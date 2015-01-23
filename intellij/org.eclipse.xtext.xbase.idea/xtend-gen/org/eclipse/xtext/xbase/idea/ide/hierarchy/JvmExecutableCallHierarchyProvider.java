/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.ide.hierarchy;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.ide.hierarchy.HierarchyBrowser;
import com.intellij.ide.hierarchy.call.JavaCallHierarchyProvider;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import org.eclipse.xtext.idea.actionSystem.DataContextExtensions;
import org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallHierarchyBrowser;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JvmExecutableCallHierarchyProvider extends JavaCallHierarchyProvider {
  @Inject
  @Extension
  private IPsiJvmModelAssociations _iPsiJvmModelAssociations;
  
  @Override
  public PsiElement getTarget(final DataContext dataContext) {
    final DataContext _function = new DataContext() {
      @Override
      public Object getData(final String dataId) {
        Object _xifexpression = null;
        String _name = CommonDataKeys.PSI_ELEMENT.getName();
        boolean _equals = Objects.equal(dataId, _name);
        if (_equals) {
          PsiElement _psiElement = DataContextExtensions.getPsiElement(dataContext);
          _xifexpression = JvmExecutableCallHierarchyProvider.this._iPsiJvmModelAssociations.getPrimaryJvmElement(_psiElement);
        } else {
          _xifexpression = dataContext.getData(dataId);
        }
        return _xifexpression;
      }
    };
    return super.getTarget(_function);
  }
  
  @Override
  public HierarchyBrowser createHierarchyBrowser(final PsiElement target) {
    Project _project = target.getProject();
    return new JvmExecutableCallHierarchyBrowser(_project, ((PsiMethod) target));
  }
}
