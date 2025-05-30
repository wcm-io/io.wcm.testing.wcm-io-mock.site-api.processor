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

import org.jetbrains.annotations.NotNull;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

import io.wcm.siteapi.processor.url.SiteApiConfiguration;

/**
 * Mock Site API configuration.
 */
@Component(service = SiteApiConfiguration.class)
@ServiceRanking(-500)
@ProviderType
public final class MockSiteApiConfiguration implements SiteApiConfiguration {

  /**
   * Default selector.
   */
  public static final String API_SELECTOR = "site";

  /**
   * Default extension.
   */
  public static final String API_EXTENSION = "api";

  private String selector = API_SELECTOR;
  private String extension = API_EXTENSION;
  private String contextPath = "";

  @Override
  public @NotNull String getSelector() {
    return selector;
  }

  public void setSelector(String selector) {
    this.selector = selector;
  }

  @Override
  public @NotNull String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  @Override
  public @NotNull String getContextPath() {
    return contextPath;
  }

  public void setContextPath(String contextPath) {
    this.contextPath = contextPath;
  }

}
