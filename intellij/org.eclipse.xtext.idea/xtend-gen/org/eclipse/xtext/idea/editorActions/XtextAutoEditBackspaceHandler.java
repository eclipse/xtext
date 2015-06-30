/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.common.base.Objects;
import com.intellij.codeInsight.editorActions.BackspaceHandlerDelegate;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.psi.PsiFile;
import org.eclipse.xtext.idea.editorActions.IdeaAutoEditHandler;
import org.eclipse.xtext.idea.editorActions.IdeaAutoEditHandlerExtension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextAutoEditBackspaceHandler extends BackspaceHandlerDelegate {
  @Override
  public void beforeCharDeleted(final char c, final PsiFile file, final Editor editor) {
    Language _language = file.getLanguage();
    final IdeaAutoEditHandler autoEditHandler = IdeaAutoEditHandlerExtension.INSTANCE.forLanguage(_language);
    boolean _notEquals = (!Objects.equal(autoEditHandler, null));
    if (_notEquals) {
      autoEditHandler.beforeCharDeleted(c, file, ((EditorEx) editor));
    }
  }
  
  @Override
  public boolean charDeleted(final char c, final PsiFile file, final Editor editor) {
    boolean _xblockexpression = false;
    {
      Language _language = file.getLanguage();
      final IdeaAutoEditHandler autoEditHandler = IdeaAutoEditHandlerExtension.INSTANCE.forLanguage(_language);
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(autoEditHandler, null));
      if (_notEquals) {
        _xifexpression = autoEditHandler.charDeleted(c, file, ((EditorEx) editor));
      } else {
        _xifexpression = false;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
