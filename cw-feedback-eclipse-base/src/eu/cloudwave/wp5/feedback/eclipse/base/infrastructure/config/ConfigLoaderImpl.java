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
package eu.cloudwave.wp5.feedback.eclipse.base.infrastructure.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.common.base.Optional;

/**
 * Implementation of {@link ConfigLoader}.
 */
public class ConfigLoaderImpl implements ConfigLoader {

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<String> get(final String path, final String key) {
    final Properties properties = new Properties();
    final InputStream fileInputStream = getClass().getClassLoader().getResourceAsStream(path);
    try {
      properties.load(fileInputStream);
    }
    catch (final IOException e) {
      return Optional.absent();
    }
    return Optional.fromNullable(properties.getProperty(key));
  }

}
