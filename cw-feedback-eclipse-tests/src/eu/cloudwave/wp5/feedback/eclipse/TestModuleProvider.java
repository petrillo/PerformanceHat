/*******************************************************************************
 * Copyright 2015 Software Evolution and Architecture Lab, University of Zurich
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package eu.cloudwave.wp5.feedback.eclipse;

import com.google.inject.AbstractModule;

import eu.cloudwave.wp5.feedback.eclipse.performance.ModuleProvider;

/**
 * Implementation of {@link ModuleProvider} for testing.
 */
public class TestModuleProvider implements ModuleProvider {

  /**
   * {@inheritDoc}
   */
  @Override
  public AbstractModule module() {
    return new TestModule();
  }

}
