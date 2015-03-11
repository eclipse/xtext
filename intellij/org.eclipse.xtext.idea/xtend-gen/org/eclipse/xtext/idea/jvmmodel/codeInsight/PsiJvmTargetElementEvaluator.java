/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.jvmmodel.codeInsight;

import com.intellij.codeInsight.TargetElementEvaluator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.light.LightElement;

@SuppressWarnings("all")
public class PsiJvmTargetElementEvaluator implements TargetElementEvaluator {
  @Override
  public PsiElement getElementByReference(final PsiReference ref, final int flags) {
    PsiElement _switchResult = null;
    PsiElement _resolve = ref.resolve();
    final PsiElement element = _resolve;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof LightElement) {
        _matched=true;
        _switchResult = ((LightElement)element).getNavigationElement();
      }
    }
    if (!_matched) {
      _switchResult = element;
    }
    return _switchResult;
  }
  
  @Override
  public boolean includeSelfInGotoImplementation(final PsiElement element) {
    return true;
  }
}
