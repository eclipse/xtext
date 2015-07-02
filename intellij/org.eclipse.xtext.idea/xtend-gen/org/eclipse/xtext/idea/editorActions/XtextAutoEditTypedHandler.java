/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.common.base.Objects;
import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.eclipse.xtext.idea.editorActions.IdeaAutoEditHandler;
import org.eclipse.xtext.idea.editorActions.IdeaAutoEditHandlerExtension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextAutoEditTypedHandler extends TypedHandlerDelegate {
  @Override
  public TypedHandlerDelegate.Result beforeCharTyped(final char c, final Project project, final Editor editor, final PsiFile file, final FileType fileType) {
    Language _language = file.getLanguage();
    final IdeaAutoEditHandler autoEditHandler = IdeaAutoEditHandlerExtension.INSTANCE.forLanguage(_language);
    boolean _equals = Objects.equal(autoEditHandler, null);
    if (_equals) {
      return super.beforeCharTyped(c, project, editor, file, fileType);
    }
    IdeaAutoEditHandler.Result _beforeCharTyped = autoEditHandler.beforeCharTyped(c, project, ((EditorEx) editor), file, fileType);
    return this.translateResult(_beforeCharTyped);
  }
  
  @Override
  public TypedHandlerDelegate.Result charTyped(final char c, final Project project, final Editor editor, final PsiFile file) {
    Language _language = file.getLanguage();
    final IdeaAutoEditHandler autoEditHandler = IdeaAutoEditHandlerExtension.INSTANCE.forLanguage(_language);
    boolean _equals = Objects.equal(autoEditHandler, null);
    if (_equals) {
      return super.charTyped(c, project, editor, file);
    }
    IdeaAutoEditHandler.Result _charTyped = autoEditHandler.charTyped(c, project, ((EditorEx) editor), file);
    return this.translateResult(_charTyped);
  }
  
  protected TypedHandlerDelegate.Result translateResult(final IdeaAutoEditHandler.Result result) {
    TypedHandlerDelegate.Result _switchResult = null;
    if (result != null) {
      switch (result) {
        case DEFAULT:
          _switchResult = TypedHandlerDelegate.Result.DEFAULT;
          break;
        case CONTINUE:
          _switchResult = TypedHandlerDelegate.Result.CONTINUE;
          break;
        case STOP:
          _switchResult = TypedHandlerDelegate.Result.STOP;
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
}
