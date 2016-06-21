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
import org.apache.sentry.core.model.db.Database;
import org.apache.sentry.core.common.validator.PrivilegeValidatorContext;
import org.apache.shiro.config.ConfigurationException;

public class DatabaseMustMatch extends AbstractDBPrivilegeValidator {

  @Override
  public void validate(PrivilegeValidatorContext context) throws ConfigurationException {
    String database = context.getDatabase();
    String privilege = context.getPrivilege();
    /*
     *  Rule only applies to rules in per database policy file
     */
    if(database != null) {
      Iterable<DBModelAuthorizable> authorizables = parsePrivilege(privilege);
      for(DBModelAuthorizable authorizable : authorizables) {
        if(authorizable instanceof Database &&
            !database.equalsIgnoreCase(authorizable.getName())) {
          String msg = "Privilege " + privilege + " references db " +
              authorizable.getName() + ", but is only allowed to reference "
              + database;
          throw new ConfigurationException(msg);
        }
      }
    }
  }
}
