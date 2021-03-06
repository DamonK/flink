/*
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

package org.apache.flink.table.plan.schema

import org.apache.calcite.rel.`type`.{RelDataType, RelDataTypeFactory}
import org.apache.calcite.schema.Statistic
import org.apache.flink.table.plan.stats.FlinkStatistic
import org.apache.flink.table.sources.TableSource

/** Abstract class which define the interfaces required to convert a [[TableSource]] to
  * a Calcite Table */
abstract class TableSourceTable[T](
    val tableSource: TableSource[T],
    val statistic: FlinkStatistic) {

  /** Returns the row type of the table with this tableSource.
    *
    * @param typeFactory Type factory with which to create the type
    * @return Row type
    */
  def getRowType(typeFactory: RelDataTypeFactory): RelDataType

  /**
    * Returns statistics of current table
    *
    * @return statistics of current table
    */
  def getStatistic: Statistic = statistic

}
