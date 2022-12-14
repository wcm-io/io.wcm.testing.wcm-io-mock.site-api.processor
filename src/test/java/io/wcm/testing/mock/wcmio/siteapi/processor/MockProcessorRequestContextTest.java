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
import static io.wcm.testing.mock.wcmio.siteapi.processor.MockProcessorRequestContext.processorRequestContext;
import static io.wcm.testing.mock.wcmio.sling.ContextPlugins.WCMIO_SLING;
import static org.apache.sling.testing.mock.caconfig.ContextPlugins.CACONFIG;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.wcm.siteapi.processor.ProcessorRequestContext;
import io.wcm.testing.mock.aem.junit.AemContext;
import io.wcm.testing.mock.aem.junit.AemContextBuilder;


public class MockProcessorRequestContextTest {

  @Rule
  public AemContext context = new AemContextBuilder()
      .plugin(CACONFIG)
      .plugin(WCMIO_SLING, WCMIO_SITEAPI_PROCESSOR).build();

  @Before
  public void setUp() {
    context.currentPage(context.create().page("/content/test"));
  }

  @Test
  public void testProcessorRequestContextSuffix() {
    ProcessorRequestContext underTest = processorRequestContext(context.request(), "suffix1");
    assertEquals("/content/test", underTest.getPage().getPath());
    assertEquals("suffix1", underTest.getSuffix());
    assertNull(underTest.getSuffixExtension());
  }

  @Test
  public void testProcessorRequestContextSuffixExtension() {
    ProcessorRequestContext underTest = processorRequestContext(context.request(), "suffix1", "extsuffix1");
    assertEquals("/content/test", underTest.getPage().getPath());
    assertEquals("suffix1", underTest.getSuffix());
    assertEquals("extsuffix1", underTest.getSuffixExtension());
  }

}
