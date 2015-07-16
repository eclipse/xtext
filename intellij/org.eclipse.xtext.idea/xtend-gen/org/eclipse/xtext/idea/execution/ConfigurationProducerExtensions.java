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
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.DataContextWrapper;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.psi.PsiElement;
import org.eclipse.xtext.idea.trace.TraceUtils;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class ConfigurationProducerExtensions {
  @Inject
  private TraceUtils traceUtils;
  
  public ConfigurationContext prepareContextFor(final ConfigurationContext context, final PsiElement psiElement) {
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
  
  @Nullable
  public PsiElement tracedJavaElement(@NotNull final ConfigurationContext context) {
    Location _location = context.getLocation();
    PsiElement _psiElement = null;
    if (_location!=null) {
      _psiElement=_location.getPsiElement();
    }
    boolean _tripleNotEquals = (_psiElement != null);
    if (_tripleNotEquals) {
      Location _location_1 = context.getLocation();
      PsiElement _psiElement_1 = _location_1.getPsiElement();
      Iterable<PsiElement> _bestJavaElementMatch = this.traceUtils.getBestJavaElementMatch(_psiElement_1);
      final PsiElement javaElement = IterableExtensions.<PsiElement>head(_bestJavaElementMatch);
      if ((javaElement != null)) {
        return javaElement;
      }
    }
    return null;
  }
}
