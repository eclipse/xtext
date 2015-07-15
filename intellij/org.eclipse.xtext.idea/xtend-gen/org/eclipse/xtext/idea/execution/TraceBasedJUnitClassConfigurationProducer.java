/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.execution;

import com.google.inject.Inject;
import com.intellij.execution.Location;
import com.intellij.execution.PsiLocation;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.junit.JUnitConfiguration;
import com.intellij.execution.junit.TestClassConfigurationProducer;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.DataContextWrapper;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.trace.TraceUtils;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceBasedJUnitClassConfigurationProducer extends TestClassConfigurationProducer {
  @Inject
  private TraceUtils traceUtils;
  
  private IXtextLanguage xtextLanguage;
  
  public TraceBasedJUnitClassConfigurationProducer(final IXtextLanguage xtextLanguage) {
    super();
    xtextLanguage.injectMembers(this);
    this.xtextLanguage = xtextLanguage;
  }
  
  @Override
  public boolean setupConfigurationFromContext(final JUnitConfiguration configuration, final ConfigurationContext context, final Ref<PsiElement> sourceElement) {
    Location _location = context.getLocation();
    boolean _tripleNotEquals = (_location != null);
    if (_tripleNotEquals) {
      final Location originalLocation = context.getLocation();
      PsiElement _psiElement = originalLocation.getPsiElement();
      Iterable<PsiElement> _bestJavaElementMatch = this.traceUtils.getBestJavaElementMatch(_psiElement);
      final PsiElement javaElement = IterableExtensions.<PsiElement>head(_bestJavaElementMatch);
      if ((javaElement != null)) {
        ConfigurationContext _prepareContext = this.prepareContext(context, javaElement);
        return super.setupConfigurationFromContext(configuration, _prepareContext, sourceElement);
      }
    }
    return false;
  }
  
  @Override
  public boolean isConfigurationFromContext(final JUnitConfiguration junitConf, final ConfigurationContext context) {
    Location _location = context.getLocation();
    PsiElement _psiElement = _location.getPsiElement();
    Iterable<PsiElement> _bestJavaElementMatch = this.traceUtils.getBestJavaElementMatch(_psiElement);
    final PsiElement javaElement = IterableExtensions.<PsiElement>head(_bestJavaElementMatch);
    if ((javaElement == null)) {
      return false;
    }
    ConfigurationContext _prepareContext = this.prepareContext(context, javaElement);
    return super.isConfigurationFromContext(junitConf, _prepareContext);
  }
  
  public ConfigurationContext prepareContext(final ConfigurationContext context, final PsiElement psiElement) {
    DataContext _dataContext = context.getDataContext();
    final ConfigurationContext ctx = ConfigurationContext.getFromContext(new DataContextWrapper(_dataContext) {
      @Override
      public Object getData(final String dataId) {
        boolean _is = RunConfiguration.DATA_KEY.is(dataId);
        if (_is) {
          return context.getOriginalConfiguration(null);
        } else {
          boolean _is_1 = LangDataKeys.MODULE.is(dataId);
          if (_is_1) {
            return context.getModule();
          } else {
            boolean _is_2 = Location.DATA_KEY.is(dataId);
            if (_is_2) {
              return PsiLocation.<PsiElement>fromPsiElement(psiElement);
            }
          }
        }
        return super.getData(dataId);
      }
    });
    return ctx;
  }
}
