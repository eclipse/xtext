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
import com.intellij.psi.PsiFileSystemItem;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.search.PsiElementProcessor;
import com.intellij.refactoring.RefactoringActionHandler;
import com.intellij.refactoring.actions.BaseRefactoringAction;
import java.util.List;
import org.eclipse.xtend.core.idea.javaconverter.ConvertJavaCodeHandler;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
    final Function1<PsiElement, PsiFileSystemItem> _function = new Function1<PsiElement, PsiFileSystemItem>() {
      @Override
      public PsiFileSystemItem apply(final PsiElement it) {
        PsiFileSystemItem _xifexpression = null;
        if ((it instanceof PsiFileSystemItem)) {
          _xifexpression = ((PsiFileSystemItem)it);
        } else {
          _xifexpression = it.getContainingFile();
        }
        return _xifexpression;
      }
    };
    List<PsiFileSystemItem> _map = ListExtensions.<PsiElement, PsiFileSystemItem>map(((List<PsiElement>)Conversions.doWrapArray(elements)), _function);
    final Function1<PsiFileSystemItem, Boolean> _function_1 = new Function1<PsiFileSystemItem, Boolean>() {
      @Override
      public Boolean apply(final PsiFileSystemItem it) {
        boolean _or = false;
        if ((it instanceof PsiJavaFile)) {
          _or = true;
        } else {
          final PsiElementProcessor<PsiFileSystemItem> _function = new PsiElementProcessor<PsiFileSystemItem>() {
            @Override
            public boolean execute(final PsiFileSystemItem it) {
              return (!(it instanceof PsiJavaFile));
            }
          };
          boolean _processChildren = it.processChildren(_function);
          boolean _not = (!_processChildren);
          _or = _not;
        }
        return Boolean.valueOf(_or);
      }
    };
    Iterable<PsiFileSystemItem> _filter = IterableExtensions.<PsiFileSystemItem>filter(_map, _function_1);
    final Function1<PsiFileSystemItem, Boolean> _function_2 = new Function1<PsiFileSystemItem, Boolean>() {
      @Override
      public Boolean apply(final PsiFileSystemItem it) {
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
    return IterableExtensions.<PsiFileSystemItem>exists(_filter, _function_2);
  }
}
