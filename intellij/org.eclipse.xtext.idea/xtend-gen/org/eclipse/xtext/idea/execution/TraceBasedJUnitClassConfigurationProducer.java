/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.execution;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.execution.JavaExecutionUtil;
import com.intellij.execution.Location;
import com.intellij.execution.PsiLocation;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.configurations.JavaRunConfigurationModule;
import com.intellij.execution.junit.JUnitConfiguration;
import com.intellij.execution.junit.JUnitUtil;
import com.intellij.execution.junit.TestClassConfigurationProducer;
import com.intellij.execution.junit2.PsiMemberParameterizedLocation;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiClass;
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
      boolean _notEquals = (!Objects.equal(javaElement, null));
      if (_notEquals) {
        if ((originalLocation instanceof PsiMemberParameterizedLocation)) {
          final String paramSetName = ((PsiMemberParameterizedLocation)originalLocation).getParamSetName();
          if ((paramSetName != null)) {
            configuration.setProgramParameters(paramSetName);
          }
        }
        final Location<PsiElement> javaContextLocation = PsiLocation.<PsiElement>fromPsiElement(javaElement);
        final Location<?> javaClassLocation = JavaExecutionUtil.stepIntoSingleClass(javaContextLocation);
        if ((javaClassLocation == null)) {
          return false;
        }
        PsiClass testClass = JUnitUtil.getTestClass(javaClassLocation);
        if ((testClass == null)) {
          return false;
        }
        sourceElement.set(testClass);
        this.setupConfigurationModule(context, configuration);
        JavaRunConfigurationModule _configurationModule = configuration.getConfigurationModule();
        final Module originalModule = _configurationModule.getModule();
        configuration.beClassConfiguration(testClass);
        configuration.restoreOriginalModule(originalModule);
        final String forkMode = configuration.getForkMode();
        boolean _equals = JUnitConfiguration.FORK_KLASS.equals(forkMode);
        if (_equals) {
          configuration.setForkMode(JUnitConfiguration.FORK_NONE);
        }
        return true;
      }
    }
    return false;
  }
  
  @Override
  public boolean isConfigurationFromContext(final JUnitConfiguration junitConf, final ConfigurationContext context) {
    return super.isConfigurationFromContext(junitConf, context);
  }
}
