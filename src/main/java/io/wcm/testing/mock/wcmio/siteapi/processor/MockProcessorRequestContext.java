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

import org.apache.sling.api.SlingHttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.osgi.annotation.versioning.ProviderType;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import io.wcm.siteapi.processor.ProcessorRequestContext;
import io.wcm.siteapi.processor.impl.ProcessorRequestContextImpl;

/**
 * Helper methods for creating {@link MockProcessorRequestContext} instances in unit tests.
 */
@ProviderType
public final class MockProcessorRequestContext {

  private MockProcessorRequestContext() {
    // static methods only
  }

  /**
   * Create {@link ProcessorRequestContext} instance, assuming current page is set.
   * @param request Request
   * @param suffix Suffix
   * @return Processor request context
   */
  public static @NotNull ProcessorRequestContext processorRequestContext(@NotNull SlingHttpServletRequest request,
      @NotNull String suffix) {
    return processorRequestContext(request, suffix, null);
  }

  /**
   * Create {@link ProcessorRequestContext} instance, assuming current page is set.
   * @param request Request
   * @param suffix Suffix
   * @param suffixExtension Suffix extension.
   * @return Processor request context
   */
  public static @NotNull ProcessorRequestContext processorRequestContext(@NotNull SlingHttpServletRequest request,
      @NotNull String suffix, @Nullable String suffixExtension) {
    PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
    if (pageManager == null) {
      throw new IllegalArgumentException("PageManager missing.");
    }
    Page page = pageManager.getContainingPage(request.getResource());
    if (page == null) {
      throw new IllegalArgumentException("Current page missing.");
    }
    return new ProcessorRequestContextImpl(suffix, suffixExtension, request, pageManager, page);
  }

}
