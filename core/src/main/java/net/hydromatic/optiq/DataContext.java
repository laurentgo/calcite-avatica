/*
// Licensed to Julian Hyde under one or more contributor license
// agreements. See the NOTICE file distributed with this work for
// additional information regarding copyright ownership.
//
// Julian Hyde licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except in
// compliance with the License. You may obtain a copy of the License at:
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
*/
package net.hydromatic.optiq;

import net.hydromatic.linq4j.Queryable;

import net.hydromatic.optiq.impl.java.JavaTypeFactory;

/**
 * Runtime context allowing access to the tables in a database.
 */
public interface DataContext {
  /**
   * Returns a table with a given name and element type, or null if not found.
   */
  <T> Queryable<T> getTable(String name, Class<T> elementType);

  /**
   * Returns a sub-schema with a given name, or null.
   */
  Schema getSubSchema(String name);

  /**
   * Returns the type factory.
   */
  JavaTypeFactory getTypeFactory();

  /**
   * Returns a context variable.
   *
   * <p>Supported variables include: "sparkContext", "currentTimestamp",
   * "localTimestamp".</p>
   *
   * @param name Name of variable
   */
  Object get(String name);
}

// End DataContext.java
