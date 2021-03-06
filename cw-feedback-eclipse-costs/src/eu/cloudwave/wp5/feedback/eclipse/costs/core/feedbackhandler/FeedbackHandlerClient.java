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
package eu.cloudwave.wp5.feedback.eclipse.costs.core.feedbackhandler;

import eu.cloudwave.wp5.common.constants.AggregationInterval;
import eu.cloudwave.wp5.common.dto.ApplicationDto;
import eu.cloudwave.wp5.common.dto.costs.AggregatedIncomingRequestsDto;
import eu.cloudwave.wp5.common.dto.costs.AggregatedMicroserviceRequestsDto;
import eu.cloudwave.wp5.common.dto.costs.InitialInvocationCheckDto;

/**
 * Provides methods to talk to the Feedback Handler Server.
 */
public interface FeedbackHandlerClient {

  /**
   * Get all microservice requests
   * 
   * @param accessToken
   *          the access token
   * @param applicationId
   *          the application ID
   * @param aggregationInterval
   *          the time interval that is used to aggregate timestamps, e.g. second, minute, hour, month (
   *          {@link AggregationInterval})
   * @param timeRangeFrom
   *          Requests with a timestamp in milliseconds >= the given timestamp
   * @param timeRangeTo
   *          Requests with a timestamp in milliseconds <= the given timestamp
   * @return An array of {@link AggregatedMicroserviceRequestsDto} containing all requests
   */
  public AggregatedMicroserviceRequestsDto[] allRequests(
      final String accessToken,
      final String applicationId,
      final AggregationInterval aggregationInterval,
      final String timeRangeFrom,
      final String timeRangeTo);

  /**
   * Get statistics about all requests to the given callee (application id) but grouped by caller
   * 
   * @param accessToken
   *          the access token
   * @param applicationId
   *          the application ID which will be used to identify the callee
   * @param aggregationInterval
   *          the time interval that is used to aggregate timestamps, e.g. second, minute, hour, month (
   *          {@link AggregationInterval})
   * @param timeRangeFrom
   *          Requests with a timestamp in milliseconds >= the given timestamp
   * @param timeRangeTo
   *          Requests with a timestamp in milliseconds <= the given timestamp
   * @return An array of {@link AggregatedMicroserviceRequestsDto}
   */
  public AggregatedMicroserviceRequestsDto[] requestsByCallee(
      final String accessToken,
      final String applicationId,
      final AggregationInterval aggregationInterval,
      final String timeRangeFrom,
      final String timeRangeTo);

  /**
   * Get overall statistics about all requests to the given callee (application id)
   * 
   * @param accessToken
   *          the access token
   * @param applicationId
   *          the application ID which will be used to identify the callee
   * @param aggregationInterval
   *          the time interval that is used to aggregate timestamps, e.g. second, minute, hour, month (
   *          {@link AggregationInterval})
   * @param timeRangeFrom
   *          Requests with a timestamp in milliseconds >= the given timestamp
   * @param timeRangeTo
   *          Requests with a timestamp in milliseconds <= the given timestamp
   * @return An {@link AggregatedMicroserviceRequestsDto} object
   */
  public AggregatedMicroserviceRequestsDto requestsByCalleeOverall(
      final String accessToken,
      final String applicationId,
      final AggregationInterval aggregationInterval,
      final String timeRangeFrom,
      final String timeRangeTo);

  /**
   * Get all microservice requests from the given caller (application id)
   * 
   * @param accessToken
   *          the access token
   * @param applicationId
   *          the application ID which will be used to identify the caller
   * @param aggregationInterval
   *          the time interval that is used to aggregate timestamps, e.g. second, minute, hour, month (
   *          {@link AggregationInterval})
   * @param timeRangeFrom
   *          Requests with a timestamp in milliseconds >= the given timestamp
   * @param timeRangeTo
   *          Requests with a timestamp in milliseconds <= the given timestamp
   * 
   * @return An array of {@link AggregatedMicroserviceRequestsDto}
   */
  public AggregatedMicroserviceRequestsDto[] requestsByCaller(
      final String accessToken,
      final String applicationId,
      final AggregationInterval aggregationInterval,
      final String timeRangeFrom,
      final String timeRangeTo);

  /**
   * All incoming microservice requests aggregated by given time interval
   * 
   * @param accessToken
   *          {@link String} used for auth
   * @param applicationId
   *          {@link String} used for auth
   * @param aggregationInterval
   *          {@link AggregationInterval}
   * @param timeRangeFrom
   *          {@link String} that specifies the start time of the time range
   * @param timeRangeTo
   *          {@link String} that specifies the end time of the time range
   * 
   * @return an array of aggregated requests
   */
  public AggregatedIncomingRequestsDto[] allIncomingRequests(
      final String accessToken,
      final String applicationId,
      final AggregationInterval aggregationInterval,
      final String timeRangeFrom,
      final String timeRangeTo);

  /**
   * List of incoming microservice requests to the given application aggregated by given time interval. Separate
   * statistics for each service identifier and each service method.
   * 
   * @param accessToken
   *          {@link String} used for auth
   * @param applicationId
   *          {@link String} used for auth (and if requestedApplicationId is null, the applicationId is also used as
   *          identifier of the microservice which are interested in)
   * @param requestedApplicationId
   *          {@link String} with the application id of the microservice which we are interested in
   * @param aggregationInterval
   *          {@link AggregationInterval}
   * @param timeRangeFrom
   *          {@link String} that specifies the start time of the time range
   * @param timeRangeTo
   *          {@link String} that specifies the end time of the time range
   * 
   * @return an array of aggregated requests
   */
  public AggregatedIncomingRequestsDto[] incomingRequestsByIdentifier(
      final String accessToken,
      final String applicationId,
      final String requestedApplicationId,
      final AggregationInterval aggregationInterval,
      final String timeRangeFrom,
      final String timeRangeTo);

  /**
   * List of incoming microservice requests to the given application aggregated by given time interval. Separate
   * statistics for each service identifier and each service method.<br />
   * <br />
   * This method uses the given access token and application id for auth and also as identifier of the microservice we
   * are interested in (incoming requests).
   * 
   * @param accessToken
   *          {@link String} used for auth
   * @param applicationId
   *          {@link String} used for auth (and if requestedApplicationId is null, the applicationId is also used as
   *          identifier of the microservice which are interested in)
   * @param aggregationInterval
   *          {@link AggregationInterval}
   * @param timeRangeFrom
   *          {@link String} that specifies the start time of the time range
   * @param timeRangeTo
   *          {@link String} that specifies the end time of the time range
   * 
   * @return an array of aggregated requests
   */
  public AggregatedIncomingRequestsDto[] incomingRequestsByIdentifier(
      final String accessToken,
      final String applicationId,
      final AggregationInterval aggregationInterval,
      final String timeRangeFrom,
      final String timeRangeTo);

  /**
   * Incoming microservice requests to the given application aggregated by given time interval without grouping by
   * service method. No separate statistics for each service method, statistics are only grouped by service identifier.
   * 
   * @param accessToken
   *          {@link String} used for auth
   * @param applicationId
   *          {@link String} used for auth (and if requestedApplicationId is null, the applicationId is also used as
   *          identifier of the microservice which are interested in)
   * @param requestedApplicationId
   *          {@link String} with the application id of the microservice which we are interested in
   * @param aggregationInterval
   *          {@link AggregationInterval}
   * @param timeRangeFrom
   *          {@link String} that specifies the start time of the time range
   * @param timeRangeTo
   *          {@link String} that specifies the end time of the time range
   * 
   * @return an aggregated request
   */
  public AggregatedIncomingRequestsDto overallIncomingRequestsByIdentifier(
      final String accessToken,
      final String applicationId,
      final String requestedApplicationId,
      final AggregationInterval aggregationInterval,
      final String timeRangeFrom,
      final String timeRangeTo);

  /**
   * Incoming microservice requests to the given application aggregated by given time interval without grouping by
   * service method. No separate statistics for each service method, statistics are only grouped by service identifier.<br />
   * <br />
   * This method uses the given access token and application id for auth and also as identifier of the microservice we
   * are interested in (incoming requests).
   * 
   * @param accessToken
   *          {@link String} used for auth
   * @param applicationId
   *          {@link String} used for auth (and if requestedApplicationId is null, the applicationId is also used as
   *          identifier of the microservice which are interested in)
   * @param aggregationInterval
   *          {@link AggregationInterval}
   * @param timeRangeFrom
   *          {@link String} that specifies the start time of the time range
   * @param timeRangeTo
   *          {@link String} that specifies the end time of the time range
   * 
   * @return an aggregated request
   */
  public AggregatedIncomingRequestsDto overallIncomingRequestsByIdentifier(
      final String accessToken,
      final String applicationId,
      final AggregationInterval aggregationInterval,
      final String timeRangeFrom,
      final String timeRangeTo);

  /**
   * Check if the given method has ever been called within the given caller method/class
   * 
   * @param accessToken
   *          the access token
   * @param applicationId
   *          the application ID which will only be used for auth
   * @param invocation
   *          names of invoked method/class and caller method/class
   * 
   * @return boolean true means that the invoked method has never been called by the given caller
   */
  public Boolean isNewlyInvoked(final String accessToken, final String applicationId, final InitialInvocationCheckDto invocation);

  /**
   * Get data about the current application like the number of instances, price per instance and so on
   * 
   * @param accessToken
   * @param applicationId
   * 
   * @return {@link ApplicationDto}
   */
  public ApplicationDto currentApplication(final String accessToken, final String applicationId);

  /**
   * Get data about another application like the number of instances, price per instance and so on
   * 
   * @param accessToken
   * @param applicationId
   * @param requestedApplicationId
   *          applicationId of the reuqested app
   * 
   * @return {@link ApplicationDto}
   */
  public ApplicationDto application(final String accessToken, final String applicationId, final String requestedApplicationId);
}
