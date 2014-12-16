/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.ide.hierarchy;

import com.intellij.ide.hierarchy.CallHierarchyBrowserBase;
import com.intellij.ide.hierarchy.HierarchyTreeStructure;
import com.intellij.ide.hierarchy.call.CallHierarchyBrowser;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCalleeMethodsTreeStructure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmExecutableCallHierarchyBrowser extends CallHierarchyBrowser {
  public JvmExecutableCallHierarchyBrowser(final Project project, final PsiMethod method) {
    super(project, method);
  }
  
  protected HierarchyTreeStructure createHierarchyTreeStructure(final String typeName, final PsiElement psiElement) {
    HierarchyTreeStructure _xifexpression = null;
    boolean _equals = CallHierarchyBrowserBase.CALLEE_TYPE.equals(typeName);
    if (_equals) {
      String _currentScopeType = this.getCurrentScopeType();
      _xifexpression = new JvmExecutableCalleeMethodsTreeStructure(this.myProject, ((PsiMethod) psiElement), _currentScopeType);
    } else {
      _xifexpression = super.createHierarchyTreeStructure(typeName, psiElement);
    }
    return _xifexpression;
  }
}
