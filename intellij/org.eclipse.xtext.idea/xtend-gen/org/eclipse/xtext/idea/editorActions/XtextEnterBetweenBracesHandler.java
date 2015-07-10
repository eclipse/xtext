/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegate;
import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegateAdapter;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiFile;
import org.eclipse.xtext.idea.editorActions.LanguageSpecificBetweenBracesHandler;
import org.eclipse.xtext.idea.lang.IXtextLanguage;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextEnterBetweenBracesHandler extends EnterHandlerDelegateAdapter {
  @Override
  public EnterHandlerDelegate.Result preprocessEnter(final PsiFile file, final Editor editor, final Ref<Integer> caretOffsetRef, final Ref<Integer> caretAdvance, final DataContext dataContext, final EditorActionHandler originalHandler) {
    final Language language = file.getLanguage();
    if ((language instanceof IXtextLanguage)) {
      return this.delegateLanguage(((IXtextLanguage)language), file, editor, caretOffsetRef, caretAdvance, dataContext, originalHandler);
    }
    return this.delegateSuper(file, editor, caretOffsetRef, caretAdvance, dataContext, originalHandler);
  }
  
  protected EnterHandlerDelegate.Result delegateLanguage(final IXtextLanguage language, final PsiFile file, final Editor editor, final Ref<Integer> caretOffsetRef, final Ref<Integer> caretAdvance, final DataContext dataContext, final EditorActionHandler originalHandler) {
    LanguageSpecificBetweenBracesHandler _instance = language.<LanguageSpecificBetweenBracesHandler>getInstance(LanguageSpecificBetweenBracesHandler.class);
    return _instance.preprocessEnter(file, editor, caretOffsetRef, caretAdvance, dataContext, originalHandler);
  }
  
  protected EnterHandlerDelegate.Result delegateSuper(final PsiFile file, final Editor editor, final Ref<Integer> caretOffsetRef, final Ref<Integer> caretAdvance, final DataContext dataContext, final EditorActionHandler originalHandler) {
    return super.preprocessEnter(file, editor, caretOffsetRef, caretAdvance, dataContext, originalHandler);
  }
}
