/*******************************************************************************
 * Copyright 2015 Software Evolution and Architecture Lab, University of Zurich
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 ******************************************************************************/
package eu.cloudwave.wp5.feedbackhandler.repositories;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import eu.cloudwave.wp5.common.constants.Ids;
import eu.cloudwave.wp5.feedbackhandler.model.db.DbApplication;

/*
 * Abstract repository used in concrete implementations to share helper methods and constants
 */
public abstract class AbstractRepository {

  protected static final String DOT = ".";
  protected static final String TYPE = "type";
  protected static final String VALUE = "value";
  protected static final String APPLICATION = "application";
  protected static final String PROCEDURE = "procedure";
  protected static final String ADDITIONAL_QUALIFIER = "additionalQualifier";
  protected static final String PROC__CLASS_NAME = PROCEDURE + DOT + "className";
  protected static final String PROC__NAME = PROCEDURE + DOT + "name";
  protected static final String PROC__ARGUMENTS = PROCEDURE + DOT + "arguments";
  protected static final String TIMESTAMP = "timestamp";
  protected static final String APPLICATION__ID = APPLICATION + DOT + "$id";
  protected static final String AVERAGE_VALUE = "averageValue";

  protected static final String ANNOTATIONS = PROCEDURE + DOT + "annotations";
  protected static final String ANNOTATION_NAME = ANNOTATIONS + DOT + "name";
  protected static final String ANNOTATION_FROM_ATTRIBUTE = ANNOTATIONS + DOT + "members" + DOT + Ids.MICROSERVICE_CLIENT_REQUEST_ANNOTATION_FROM_ATTRIBUTE; // caller
  protected static final String ANNOTATION_TO_ATTRIBUTE = ANNOTATIONS + DOT + "members" + DOT + Ids.MICROSERVICE_CLIENT_REQUEST_ANNOTATION_TO_ATTRIBUTE; // callee
  protected static final String ANNOTATION_TO_METHOD_ATTRIBUTE = ANNOTATIONS + DOT + "members" + DOT + Ids.MICROSERVICE_CLIENT_REQUEST_ANNOTATION_TO_METHOD_ATTRIBUTE; // calleeMethod
  protected static final String ANNOTATION_IDENTIFIER_ATTRIBUTE = ANNOTATIONS + DOT + "members" + DOT + Ids.MICROSERVICE_ENDPOINT_ANNOTATION_IDENTIFIER_ATTRIBUTE; // identifier
  protected static final String ANNOTATION_METHOD_ATTRIBUTE = ANNOTATIONS + DOT + "members" + DOT + Ids.MICROSERVICE_DECLARATION_ANNOTATION_METHOD_ATTRIBUTE; // method

  protected static final String METHOD_ATTRIBUTE = PROCEDURE + DOT + "name";
  protected static final String METHOD_PROJECTION = "methodName";

  protected static final String TIME_FIELD = "startTime";
  protected static final String TIME_PROJECTION = "timestamp";
  protected static final String TIME_AGGREGATION_ATTRIBUTE = "reqTimestamps";

  // Invocation Check
  protected static final String INVOKED_METHOD_NAME_PROJECTION = "invokedMethodName";
  protected static final String INVOKED_CLASS_NAME_PROJECTION = "invokedClassName";
  protected static final String CALLER = "caller";
  protected static final String CALLER_AGGREGATION_ATTRIBUTE = "callers";

  protected Criteria appCriteria(final DbApplication application) {
    // Hint: Fields of DBRefs cannot be accessed directly in a query:
    // http://stackoverflow.com/questions/17973321/querying-mongodb-dbref-inner-field
    return new Criteria(APPLICATION__ID).is(application.getId());
  }

  protected GroupOperation groupOperation(final String... fields) {
    return group(fields).avg(VALUE).as(AVERAGE_VALUE);
  }
}
