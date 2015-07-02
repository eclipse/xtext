/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegateAdapter
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.actionSystem.EditorActionHandler
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiFile

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextAutoEditEnterHandler extends EnterHandlerDelegateAdapter {

	override preprocessEnter(
		PsiFile file,
		Editor editor,
		Ref<Integer> caretOffset,
		Ref<Integer> caretAdvance,
		DataContext dataContext,
		EditorActionHandler originalHandler
	) {
		val autoEditHandler = IdeaAutoEditHandlerExtension.INSTANCE.forLanguage(file.language)
		if (autoEditHandler == null)
			return super.preprocessEnter(
				file,
				editor,
				caretOffset,
				caretAdvance,
				dataContext,
				originalHandler
			)
		return autoEditHandler.beforeEnterTyped(
			file,
			editor as EditorEx,
			caretOffset,
			caretAdvance,
			dataContext,
			originalHandler
		).translateResult
	}

	override postProcessEnter(PsiFile file, Editor editor, DataContext dataContext) {
		val autoEditHandler = IdeaAutoEditHandlerExtension.INSTANCE.forLanguage(file.language)
		if (autoEditHandler == null)
			return super.postProcessEnter(file, editor, dataContext)
		return autoEditHandler.enterTyped(file, editor as EditorEx, dataContext).translateResult
	}

	protected def translateResult(IdeaAutoEditHandler.Result result) {
		switch result {
			case DEFAULT: Result.Default
			case CONTINUE: Result.Continue
			case STOP: Result.Stop
		}
	}

}