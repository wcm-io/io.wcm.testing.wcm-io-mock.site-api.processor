/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2022 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.testing.mock.wcmio.siteapi.processor;

import static io.wcm.testing.mock.wcmio.siteapi.processor.ContextPlugins.WCMIO_SITEAPI_PROCESSOR;
import static io.wcm.testing.mock.wcmio.sling.ContextPlugins.WCMIO_SLING;
import static org.apache.sling.testing.mock.caconfig.ContextPlugins.CACONFIG;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;

import io.wcm.siteapi.processor.ProcessorManager;
import io.wcm.siteapi.processor.caconfig.ContextAwareConfigurationMapper;
import io.wcm.testing.mock.aem.junit.AemContext;
import io.wcm.testing.mock.aem.junit.AemContextBuilder;

public class ContextPluginsTest {

  @Rule
  public AemContext context = new AemContextBuilder()
      .plugin(CACONFIG)
      .plugin(WCMIO_SLING, WCMIO_SITEAPI_PROCESSOR).build();

  @Test
  public void testServices() {
    assertNotNull(context.getService(ProcessorManager.class));
    assertNotNull(context.getService(ContextAwareConfigurationMapper.class));
  }

}
