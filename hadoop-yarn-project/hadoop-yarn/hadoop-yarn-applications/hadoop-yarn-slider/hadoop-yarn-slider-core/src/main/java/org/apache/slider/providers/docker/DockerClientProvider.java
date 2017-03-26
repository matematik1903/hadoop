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
package org.apache.slider.providers.docker;

import org.apache.hadoop.conf.Configuration;
import org.apache.slider.common.SliderKeys;
import org.apache.slider.common.tools.SliderFileSystem;
import org.apache.slider.core.conf.AggregateConf;
import org.apache.slider.core.conf.ConfTreeOperations;
import org.apache.slider.core.exceptions.SliderException;
import org.apache.slider.providers.AbstractClientProvider;
import org.apache.slider.providers.ProviderRole;
import org.apache.slider.providers.ProviderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DockerClientProvider extends AbstractClientProvider
    implements SliderKeys {

  protected static final Logger log =
      LoggerFactory.getLogger(DockerClientProvider.class);
  private static final ProviderUtils providerUtils = new ProviderUtils(log);
  protected static final String NAME = "docker";

  public DockerClientProvider(Configuration conf) {
    super(conf);
  }

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public List<ProviderRole> getRoles() {
    return Collections.emptyList();
  }

  @Override
  public void validateInstanceDefinition(AggregateConf instanceDefinition,
      SliderFileSystem fs) throws SliderException {
    super.validateInstanceDefinition(instanceDefinition, fs);
    //TODO validate Application payload, part of that is already done in ApplicationApiService, need to do more
  }

  @Override
  public Set<String> getApplicationTags(SliderFileSystem fileSystem,
      ConfTreeOperations appConf, String appName) throws SliderException {
    return createApplicationTags(appName, null, null);
  }

}
