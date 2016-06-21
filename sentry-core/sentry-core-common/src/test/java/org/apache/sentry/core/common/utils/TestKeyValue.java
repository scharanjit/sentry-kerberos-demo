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
package org.apache.sentry.core.common.utils;

import static org.apache.sentry.core.common.utils.SentryConstants.KV_JOINER;
import junit.framework.Assert;
import org.junit.Test;

public class TestKeyValue {

  @Test
  public void testWithSeparators() throws Exception {
    KeyValue kv = new KeyValue("URI=/u/h/w/t/partition=value/");
    Assert.assertEquals("URI", kv.getKey());
    Assert.assertEquals("/u/h/w/t/partition=value/", kv.getValue());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyKey() throws Exception {
    new KeyValue(KV_JOINER.join("", "b"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyValue() throws Exception {
    new KeyValue(KV_JOINER.join("a", ""));
  }

  @Test
  public void testOneParameterConstructor() throws Exception {
    KeyValue kv1 = new KeyValue(KV_JOINER.join("k1", "v1"));
    KeyValue kv2 = new KeyValue(KV_JOINER.join("k1", "v1"));
    KeyValue kv3 = new KeyValue(KV_JOINER.join("k2", "v2"));
    doTest(kv1, kv2, kv3);
  }

  @Test
  public void testTwoParameterConstructor() throws Exception {
    KeyValue kv1 = new KeyValue("k1", "v1");
    KeyValue kv2 = new KeyValue("k1", "v1");
    KeyValue kv3 = new KeyValue("k2", "v2");
    doTest(kv1, kv2, kv3);
  }

  private void doTest(KeyValue kv1, KeyValue kv2, KeyValue kv3) {
    Assert.assertEquals(kv1, kv2);
    Assert.assertFalse(kv1.equals(kv3));

    Assert.assertEquals(kv1.toString(), kv2.toString());
    Assert.assertFalse(kv1.toString().equals(kv3.toString()));

    Assert.assertEquals(kv1.hashCode(), kv2.hashCode());
    Assert.assertFalse(kv1.hashCode() == kv3.hashCode());

    Assert.assertEquals(kv1.getKey(), kv2.getKey());
    Assert.assertFalse(kv1.getKey().equals(kv3.getKey()));

    Assert.assertEquals(kv1.getValue(), kv2.getValue());
    Assert.assertFalse(kv1.getValue().equals(kv3.getValue()));
  }
}
