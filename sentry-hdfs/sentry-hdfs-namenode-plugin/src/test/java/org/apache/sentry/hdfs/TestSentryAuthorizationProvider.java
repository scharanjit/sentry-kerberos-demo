/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sentry.hdfs;

import java.io.IOException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.AclEntry;
import org.apache.hadoop.fs.permission.AclEntryScope;
import org.apache.hadoop.fs.permission.AclEntryType;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.hdfs.DFSConfigKeys;
import org.apache.hadoop.hdfs.HdfsConfiguration;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.apache.hadoop.hdfs.server.namenode.EditLogFileOutputStream;
import org.apache.hadoop.security.UserGroupInformation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestSentryAuthorizationProvider {
  private static final String DFS_NAMENODE_AUTHORIZATION_PROVIDER_KEY =
      "dfs.namenode.authorization.provider.class";

  private MiniDFSCluster miniDFS;
  private UserGroupInformation admin;
  
  @Before
  public void setUp() throws Exception {
    admin = UserGroupInformation.createUserForTesting(
        System.getProperty("user.name"), new String[] { "supergroup" });
    admin.doAs(new PrivilegedExceptionAction<Void>() {
      @Override
      public Void run() throws Exception {
        System.setProperty(MiniDFSCluster.PROP_TEST_BUILD_DATA, "target/test/data");
        Configuration conf = new HdfsConfiguration();
        conf.setBoolean("sentry.authorization-provider.include-hdfs-authz-as-acl", true);
        conf.set(DFS_NAMENODE_AUTHORIZATION_PROVIDER_KEY,
            MockSentryAuthorizationProvider.class.getName());
        conf.setBoolean(DFSConfigKeys.DFS_NAMENODE_ACLS_ENABLED_KEY, true);
        EditLogFileOutputStream.setShouldSkipFsyncForTesting(true);
        miniDFS = new MiniDFSCluster.Builder(conf).build();
        return null;
      }
    });
  }

  @After
  public void cleanUp() throws IOException {
    if (miniDFS != null) {
      miniDFS.shutdown();
    }
  }

  @Test
  public void testProvider() throws Exception {
    admin.doAs(new PrivilegedExceptionAction<Void>() {
      @Override
      public Void run() throws Exception {
        String sysUser = UserGroupInformation.getCurrentUser().getShortUserName();
        FileSystem fs = FileSystem.get(miniDFS.getConfiguration(0));

        List<AclEntry> baseAclList = new ArrayList<AclEntry>();
        AclEntry.Builder builder = new AclEntry.Builder();
        baseAclList.add(builder.setType(AclEntryType.USER)
            .setScope(AclEntryScope.ACCESS).build());
        baseAclList.add(builder.setType(AclEntryType.GROUP)
            .setScope(AclEntryScope.ACCESS).build());
        baseAclList.add(builder.setType(AclEntryType.OTHER)
            .setScope(AclEntryScope.ACCESS).build());
        Path path1 = new Path("/user/authz/obj/xxx");
        fs.mkdirs(path1);
        fs.setAcl(path1, baseAclList);

        fs.mkdirs(new Path("/user/authz/xxx"));
        fs.mkdirs(new Path("/user/xxx"));

        // root
        Path path = new Path("/");
        Assert.assertEquals(sysUser, fs.getFileStatus(path).getOwner());
        Assert.assertEquals("supergroup", fs.getFileStatus(path).getGroup());
        Assert.assertEquals(new FsPermission((short) 0755), fs.getFileStatus(path).getPermission());
        Assert.assertTrue(fs.getAclStatus(path).getEntries().isEmpty());

        // dir before prefixes
        path = new Path("/user");
        Assert.assertEquals(sysUser, fs.getFileStatus(path).getOwner());
        Assert.assertEquals("supergroup", fs.getFileStatus(path).getGroup());
        Assert.assertEquals(new FsPermission((short) 0755), fs.getFileStatus(path).getPermission());
        Assert.assertTrue(fs.getAclStatus(path).getEntries().isEmpty());

        // prefix dir
        path = new Path("/user/authz");
        Assert.assertEquals(sysUser, fs.getFileStatus(path).getOwner());
        Assert.assertEquals("supergroup", fs.getFileStatus(path).getGroup());
        Assert.assertEquals(new FsPermission((short) 0755), fs.getFileStatus(path).getPermission());
        Assert.assertTrue(fs.getAclStatus(path).getEntries().isEmpty());

        // dir inside of prefix, no obj
        path = new Path("/user/authz/xxx");
        FileStatus status = fs.getFileStatus(path);
        Assert.assertEquals(sysUser, status.getOwner());
        Assert.assertEquals("supergroup", status.getGroup());
        Assert.assertEquals(new FsPermission((short) 0755), status.getPermission());
        Assert.assertTrue(fs.getAclStatus(path).getEntries().isEmpty());

        // dir inside of prefix, obj
        path = new Path("/user/authz/obj");
        Assert.assertEquals("hive", fs.getFileStatus(path).getOwner());
        Assert.assertEquals("hive", fs.getFileStatus(path).getGroup());
        Assert.assertEquals(new FsPermission((short) 0771), fs.getFileStatus(path).getPermission());
        Assert.assertFalse(fs.getAclStatus(path).getEntries().isEmpty());

        List<AclEntry> acls = new ArrayList<AclEntry>();
        acls.add(new AclEntry.Builder().setName(sysUser).setType(AclEntryType.USER).setScope(AclEntryScope.ACCESS).setPermission(FsAction.ALL).build());
        acls.add(new AclEntry.Builder().setName("supergroup").setType(AclEntryType.GROUP).setScope(AclEntryScope.ACCESS).setPermission(FsAction.READ_EXECUTE).build());
        acls.add(new AclEntry.Builder().setName("user-authz").setType(AclEntryType.USER).setScope(AclEntryScope.ACCESS).setPermission(FsAction.ALL).build());
        Assert.assertEquals(new LinkedHashSet<AclEntry>(acls), new LinkedHashSet<AclEntry>(fs.getAclStatus(path).getEntries()));

        // dir inside of prefix, inside of obj
        path = new Path("/user/authz/obj/xxx");
        Assert.assertEquals("hive", fs.getFileStatus(path).getOwner());
        Assert.assertEquals("hive", fs.getFileStatus(path).getGroup());
        Assert.assertEquals(new FsPermission((short) 0771), fs.getFileStatus(path).getPermission());
        Assert.assertFalse(fs.getAclStatus(path).getEntries().isEmpty());
        
        Path path2 = new Path("/user/authz/obj/path2");
        fs.mkdirs(path2);
        fs.setAcl(path2, baseAclList);

        // dir outside of prefix
        path = new Path("/user/xxx");
        Assert.assertEquals(sysUser, fs.getFileStatus(path).getOwner());
        Assert.assertEquals("supergroup", fs.getFileStatus(path).getGroup());
        Assert.assertEquals(new FsPermission((short) 0755), fs.getFileStatus(path).getPermission());
        Assert.assertTrue(fs.getAclStatus(path).getEntries().isEmpty());

        //stale and dir inside of prefix, obj
        System.setProperty("test.stale", "true");
        path = new Path("/user/authz/xxx");
        status = fs.getFileStatus(path);
        Assert.assertEquals(sysUser, status.getOwner());
        Assert.assertEquals("supergroup", status.getGroup());
        Assert.assertEquals(new FsPermission((short) 0755), status.getPermission());
        Assert.assertTrue(fs.getAclStatus(path).getEntries().isEmpty());

        // setPermission sets the permission for dir outside of prefix.
        // setUser/setGroup sets the user/group for dir outside of prefix.
        Path pathOutside = new Path("/user/xxx");

        fs.setPermission(pathOutside, new FsPermission((short) 0000));
        Assert.assertEquals(new FsPermission((short) 0000), fs.getFileStatus(pathOutside).getPermission());
        fs.setOwner(pathOutside, sysUser, "supergroup");
        Assert.assertEquals(sysUser, fs.getFileStatus(pathOutside).getOwner());
        Assert.assertEquals("supergroup", fs.getFileStatus(pathOutside).getGroup());

        // removeAcl removes the ACL entries for dir outside of prefix.
        List<AclEntry> aclsOutside = new ArrayList<AclEntry>(baseAclList);
        List<AclEntry> acl = new ArrayList<AclEntry>();
        acl.add(new AclEntry.Builder().setName("supergroup").setType(AclEntryType.GROUP).setScope(AclEntryScope.ACCESS).
                setPermission(FsAction.READ_EXECUTE).build());
        aclsOutside.addAll(acl);
        fs.setAcl(pathOutside, aclsOutside);
        fs.removeAclEntries(pathOutside, acl);
        Assert.assertFalse(fs.getAclStatus(pathOutside).getEntries().containsAll(acl));

        // setPermission sets the permission for dir inside of prefix but not a hive obj.
        // setUser/setGroup sets the user/group for dir inside of prefix but not a hive obj.
        Path pathInside = new Path("/user/authz/xxx");

        fs.setPermission(pathInside, new FsPermission((short) 0000));
        Assert.assertEquals(new FsPermission((short) 0000), fs.getFileStatus(pathInside).getPermission());
        fs.setOwner(pathInside, sysUser, "supergroup");
        Assert.assertEquals(sysUser, fs.getFileStatus(pathInside).getOwner());
        Assert.assertEquals("supergroup", fs.getFileStatus(pathInside).getGroup());

        // removeAcl is a no op for dir inside of prefix.
        Assert.assertTrue(fs.getAclStatus(pathInside).getEntries().isEmpty());
        fs.removeAclEntries(pathInside, acl);
        Assert.assertTrue(fs.getAclStatus(pathInside).getEntries().isEmpty());

        // setPermission/setUser/setGroup is a no op for dir inside of prefix, and is a hive obj.
        Path pathInsideAndHive = new Path("/user/authz/obj");

        fs.setPermission(pathInsideAndHive, new FsPermission((short) 0000));
        Assert.assertEquals(new FsPermission((short) 0771), fs.getFileStatus(pathInsideAndHive).getPermission());
        fs.setOwner(pathInsideAndHive, sysUser, "supergroup");
        Assert.assertEquals("hive", fs.getFileStatus(pathInsideAndHive).getOwner());
        Assert.assertEquals("hive", fs.getFileStatus(pathInsideAndHive).getGroup());

        return null;
      }
    });
  }
}
