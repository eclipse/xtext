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
import com.intellij.codeInsight.TargetElementUtilBase;
import com.intellij.ide.hierarchy.type.JavaTypeHierarchyProvider;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.eclipse.xtext.idea.actionSystem.DataContextExtensions;
import org.eclipse.xtext.idea.extensions.IdeaProjectExtensions;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class JvmDeclaredTypeHierarchyProvider extends JavaTypeHierarchyProvider {
  @Inject
  @Extension
  private JvmPsiClasses _jvmPsiClasses;
  
  @Override
  public PsiElement getTarget(@NotNull final DataContext dataContext) {
    PsiClass _xblockexpression = null;
    {
      final Project project = DataContextExtensions.getProject(dataContext);
      boolean _equals = Objects.equal(project, null);
      if (_equals) {
        return null;
      }
      final Editor editor = DataContextExtensions.getEditor(dataContext);
      boolean _equals_1 = Objects.equal(editor, null);
      if (_equals_1) {
        PsiElement _psiElement = DataContextExtensions.getPsiElement(dataContext);
        Iterable<PsiClass> _psiClasses = this._jvmPsiClasses.getPsiClasses(_psiElement);
        return IterableExtensions.<PsiClass>head(_psiClasses);
      }
      PsiDocumentManager _psiDocumentManager = IdeaProjectExtensions.getPsiDocumentManager(project);
      Document _document = editor.getDocument();
      final PsiFile file = _psiDocumentManager.getPsiFile(_document);
      boolean _equals_2 = Objects.equal(file, null);
      if (_equals_2) {
        return null;
      }
      PsiElement _targetElement = this.getTargetElement(editor);
      Iterable<PsiClass> _psiClasses_1 = this._jvmPsiClasses.getPsiClasses(_targetElement);
      final PsiClass psiClass = IterableExtensions.<PsiClass>head(_psiClasses_1);
      boolean _notEquals = (!Objects.equal(psiClass, null));
      if (_notEquals) {
        return psiClass;
      }
      CaretModel _caretModel = editor.getCaretModel();
      final int offset = _caretModel.getOffset();
      PsiElement _findElementAt = file.findElementAt(offset);
      Iterable<PsiClass> _findPsiClasses = this._jvmPsiClasses.findPsiClasses(_findElementAt);
      _xblockexpression = IterableExtensions.<PsiClass>head(_findPsiClasses);
    }
    return _xblockexpression;
  }
  
  protected PsiElement getTargetElement(final Editor editor) {
    return TargetElementUtilBase.findTargetElement(editor, 
      ((TargetElementUtilBase.ELEMENT_NAME_ACCEPTED | TargetElementUtilBase.REFERENCED_ELEMENT_ACCEPTED) | TargetElementUtilBase.LOOKUP_ITEM_ACCEPTED));
  }
}
