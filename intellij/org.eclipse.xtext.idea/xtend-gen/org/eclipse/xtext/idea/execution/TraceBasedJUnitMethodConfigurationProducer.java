/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.execution;

import com.google.inject.Inject;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.junit.JUnitConfiguration;
import com.intellij.execution.junit.TestMethodConfigurationProducer;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
import org.eclipse.xtext.idea.execution.ConfigurationProducerExtensions;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceBasedJUnitMethodConfigurationProducer extends TestMethodConfigurationProducer {
  @Inject
  @Extension
  private ConfigurationProducerExtensions _configurationProducerExtensions;
  
  public TraceBasedJUnitMethodConfigurationProducer(final IXtextLanguage xtextLanguage) {
    super();
    xtextLanguage.injectMembers(this);
  }
  
  @Override
  public boolean setupConfigurationFromContext(final JUnitConfiguration configuration, final ConfigurationContext context, final Ref<PsiElement> sourceElement) {
    final PsiElement javaElement = this._configurationProducerExtensions.tracedJavaElement(context);
    if ((javaElement != null)) {
      ConfigurationContext _prepareContextFor = this._configurationProducerExtensions.prepareContextFor(context, javaElement);
      return super.setupConfigurationFromContext(configuration, _prepareContextFor, sourceElement);
    }
    return false;
  }
  
  @Override
  public boolean isConfigurationFromContext(final JUnitConfiguration junitConf, final ConfigurationContext context) {
    final PsiElement javaElement = this._configurationProducerExtensions.tracedJavaElement(context);
    if ((javaElement != null)) {
      ConfigurationContext _prepareContextFor = this._configurationProducerExtensions.prepareContextFor(context, javaElement);
      return super.isConfigurationFromContext(junitConf, _prepareContextFor);
    }
    return false;
  }
}
