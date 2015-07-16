/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.codeInsight.editorActions.enter.EnterBetweenBracesHandler
import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegateAdapter
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.actionSystem.EditorActionHandler
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiFile
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider
import org.eclipse.xtext.idea.lang.IXtextLanguage

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextEnterBetweenBracesHandler extends EnterHandlerDelegateAdapter {

	override preprocessEnter(
		PsiFile file,
		Editor editor,
		Ref<Integer> caretOffsetRef,
		Ref<Integer> caretAdvance,
		DataContext dataContext,
		EditorActionHandler originalHandler
	) {
		val language = file.language
		if (language instanceof IXtextLanguage)
			return delegateLanguage(language, file, editor, caretOffsetRef, caretAdvance, dataContext, originalHandler)

		return delegateSuper(file, editor, caretOffsetRef, caretAdvance, dataContext, originalHandler)
	}

	protected def delegateLanguage(
		IXtextLanguage language,
		PsiFile file,
		Editor editor,
		Ref<Integer> caretOffsetRef,
		Ref<Integer> caretAdvance,
		DataContext dataContext,
		EditorActionHandler originalHandler
	) {
		language.getInstance(LanguageSpecificBetweenBracesHandler).preprocessEnter(
			file,
			editor,
			caretOffsetRef,
			caretAdvance,
			dataContext,
			originalHandler
		)
	}

	protected def delegateSuper(
		PsiFile file,
		Editor editor,
		Ref<Integer> caretOffsetRef,
		Ref<Integer> caretAdvance,
		DataContext dataContext,
		EditorActionHandler originalHandler
	) {
		super.preprocessEnter(
			file,
			editor,
			caretOffsetRef,
			caretAdvance,
			dataContext,
			originalHandler
		)
	}

}

@Singleton
class LanguageSpecificBetweenBracesHandler extends EnterBetweenBracesHandler {

	@Inject
	IBracePairProvider bracePairProvider

	override protected isBracePair(char c1, char c2) {
		bracePairProvider.pairs.filter [
			leftBrace.length == 1 && rightBrace.length == 1
		].exists [
			leftBrace.charAt(0) == c1 && rightBrace.charAt(0) == c2
		]
	}

}