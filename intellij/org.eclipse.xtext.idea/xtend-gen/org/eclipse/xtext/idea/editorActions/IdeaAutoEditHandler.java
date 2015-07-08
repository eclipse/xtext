/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.inject.ImplementedBy;
import com.intellij.codeInsight.editorActions.BackspaceHandlerDelegate;
import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegate;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiFile;
import org.eclipse.xtext.idea.editorActions.DefaultAutoEditHandler;

/**
 * @author kosyakov - Initial contribution and API
 * 
 * @see TypedHandlerDelegate
 * @see BackspaceHandlerDelegate
 * @see EnterHandlerDelegate
 */
@ImplementedBy(DefaultAutoEditHandler.class)
@SuppressWarnings("all")
public abstract class IdeaAutoEditHandler {
  public enum Result {
    DEFAULT,
    
    CONTINUE,
    
    STOP;
  }
  
  /**
   * @see TypedHandlerDelegate#beforeCharTyped
   */
  public IdeaAutoEditHandler.Result beforeCharTyped(final char c, final Project project, final EditorEx editor, final PsiFile file, final FileType fileType) {
    return IdeaAutoEditHandler.Result.CONTINUE;
  }
  
  /**
   * @see TypedHandlerDelegate#charTyped
   */
  public IdeaAutoEditHandler.Result charTyped(final char c, final Project project, final EditorEx editor, final PsiFile file) {
    return IdeaAutoEditHandler.Result.CONTINUE;
  }
  
  /**
   * @see BackspaceHandlerDelegate#beforeCharDeleted
   */
  public void beforeCharDeleted(final char c, final PsiFile file, final EditorEx editor) {
  }
  
  /**
   * @see BackspaceHandlerDelegate#charDeleted
   */
  public boolean charDeleted(final char c, final PsiFile file, final EditorEx editor) {
    return false;
  }
  
  /**
   * @see EnterHandlerDelegate#preprocessEnter
   */
  public IdeaAutoEditHandler.Result beforeEnterTyped(final PsiFile file, final EditorEx editor, final Ref<Integer> caretOffset, final Ref<Integer> caretAdvance, final DataContext dataContext, final EditorActionHandler originalHandler) {
    return IdeaAutoEditHandler.Result.CONTINUE;
  }
  
  /**
   * @see EnterHandlerDelegate#postProcessEnter
   */
  public IdeaAutoEditHandler.Result enterTyped(final PsiFile file, final EditorEx editor, final DataContext dataContext) {
    return IdeaAutoEditHandler.Result.CONTINUE;
  }
}
