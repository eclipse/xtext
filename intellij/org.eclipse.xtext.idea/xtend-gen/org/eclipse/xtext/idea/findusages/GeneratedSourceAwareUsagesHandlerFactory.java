/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.findusages;

import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesHandlerFactory;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.project.IndexNotReadyException;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class GeneratedSourceAwareUsagesHandlerFactory extends FindUsagesHandlerFactory {
  private final static Logger LOG = Logger.getInstance("#com.intellij.find.findParameterUsages.FindUsagesManager");
  
  @Override
  public boolean canFindUsages(final PsiElement element) {
    if ((element instanceof PsiMethod)) {
      FindUsagesHandlerFactory _delegateFindFactory = this.delegateFindFactory(element);
      boolean _tripleNotEquals = (_delegateFindFactory != null);
      if (_tripleNotEquals) {
        return true;
      }
      PsiClass _containingClass = ((PsiMethod)element).getContainingClass();
      String _name = ((PsiMethod)element).getName();
      String _plus = (_name + "gen");
      PsiMethod[] _findMethodsByName = _containingClass.findMethodsByName(_plus, false);
      for (final PsiMethod gen : _findMethodsByName) {
        FindUsagesHandlerFactory _delegateFindFactory_1 = this.delegateFindFactory(gen);
        boolean _tripleNotEquals_1 = (_delegateFindFactory_1 != null);
        if (_tripleNotEquals_1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public FindUsagesHandlerFactory delegateFindFactory(final PsiElement element) {
    Project _project = element.getProject();
    FindUsagesHandlerFactory[] delegates = Extensions.<FindUsagesHandlerFactory>getExtensions(FindUsagesHandlerFactory.EP_NAME, _project);
    for (final FindUsagesHandlerFactory delegate : delegates) {
      if ((delegate != this)) {
        try {
          boolean _canFindUsages = delegate.canFindUsages(element);
          if (_canFindUsages) {
            return delegate;
          }
        } catch (final Throwable _t) {
          if (_t instanceof IndexNotReadyException) {
            final IndexNotReadyException e = (IndexNotReadyException)_t;
            throw e;
          } else if (_t instanceof Exception) {
            final Exception e_1 = (Exception)_t;
            GeneratedSourceAwareUsagesHandlerFactory.LOG.error(e_1);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    return null;
  }
  
  @Override
  public FindUsagesHandler createFindUsagesHandler(final PsiElement element, final boolean forHighlightUsages) {
    FindUsagesHandlerFactory _delegateFindFactory = this.delegateFindFactory(element);
    return _delegateFindFactory.createFindUsagesHandler(element, forHighlightUsages);
  }
}
