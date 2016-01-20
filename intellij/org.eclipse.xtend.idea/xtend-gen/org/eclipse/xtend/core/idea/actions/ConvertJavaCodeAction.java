/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.actions;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiJavaFile;
import com.intellij.refactoring.RefactoringActionHandler;
import com.intellij.refactoring.actions.BaseRefactoringAction;
import org.eclipse.xtend.core.idea.javaconverter.ConvertJavaCodeHandler;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class ConvertJavaCodeAction extends BaseRefactoringAction {
  @Override
  protected RefactoringActionHandler getHandler(final DataContext dataContext) {
    return new ConvertJavaCodeHandler();
  }
  
  @Override
  protected boolean isAvailableInEditorOnly() {
    return false;
  }
  
  @Override
  protected boolean isEnabledOnElements(final PsiElement[] elements) {
    Iterable<PsiJavaFile> _collectJavaFiles = ConvertJavaCodeHandler.collectJavaFiles(elements);
    final Function1<PsiJavaFile, Boolean> _function = new Function1<PsiJavaFile, Boolean>() {
      @Override
      public Boolean apply(final PsiJavaFile it) {
        final Module module = ModuleUtil.findModuleForPsiElement(it);
        boolean _and = false;
        if (!(module != null)) {
          _and = false;
        } else {
          ModuleRootManager _instance = ModuleRootManager.getInstance(module);
          Sdk _sdk = _instance.getSdk();
          boolean _tripleNotEquals = (_sdk != null);
          _and = _tripleNotEquals;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.<PsiJavaFile>exists(_collectJavaFiles, _function);
  }
}
