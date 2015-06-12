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
package eu.cloudwave.wp5.common.dto.costs;

/**
 * Contains the aggregated values and details about the service which receives the requests
 */
public class AggregatedIncomingRequestsDto implements AggregatedRequestsDto {

  private String identifier;
  private String method;
  private int min;
  private int max;
  private double avg;
  private long sum;

  /**
   * Constructor
   * 
   * @param identifier
   * @param method
   * @param min
   * @param max
   * @param avg
   * @param sum
   */
  public AggregatedIncomingRequestsDto(String identifier, String method, int min, int max, double avg, long sum) {
    this.identifier = identifier;
    this.method = method;
    this.min = min;
    this.max = max;
    this.avg = avg;
    this.sum = sum;
  }

  /**
   * Default constructor should not be used, but is required for deserialization
   */
  public AggregatedIncomingRequestsDto() {
    this(null, null, 0, 0, 0, 0);
  }

  public String getIdentifier() {
    return identifier;
  }

  public String getMethod() {
    return method;
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  public double getAvg() {
    return avg;
  }

  public long getSum() {
    return sum;
  }
}
