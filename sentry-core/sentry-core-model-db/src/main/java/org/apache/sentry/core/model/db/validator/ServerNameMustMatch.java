/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sentry.core.model.db.validator;

import org.apache.sentry.core.model.db.DBModelAuthorizable;
import org.apache.sentry.core.model.db.Server;
import org.apache.sentry.core.common.validator.PrivilegeValidatorContext;
import org.apache.shiro.config.ConfigurationException;

public class ServerNameMustMatch extends AbstractDBPrivilegeValidator {

  private final String serverName;
  public ServerNameMustMatch(String serverName) {
    this.serverName = serverName;
  }
  @Override
  public void validate(PrivilegeValidatorContext context) throws ConfigurationException {
    String privilege = context.getPrivilege();
    Iterable<DBModelAuthorizable> authorizables = parsePrivilege(privilege);
    for(DBModelAuthorizable authorizable : authorizables) {
      if(authorizable instanceof Server && !serverName.equalsIgnoreCase(authorizable.getName())) {
        String msg = "Server name " + authorizable.getName() + " in "
            + privilege + " is invalid. Expected " + serverName;
        throw new ConfigurationException(msg);
      }
    }
  }

}
