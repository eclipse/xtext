/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.intellij.codeInsight.editorActions.BackspaceHandlerDelegate
import com.intellij.codeInsight.editorActions.TypedHandlerDelegate
import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegate
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.actionSystem.EditorActionHandler
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiFile

/**
 * @author kosyakov - Initial contribution and API
 * 
 * @see TypedHandlerDelegate
 * @see BackspaceHandlerDelegate
 * @see EnterHandlerDelegate
 */
abstract class IdeaAutoEditHandler {

	enum Result {
		DEFAULT,
		CONTINUE,
		STOP
	}

	/**
	 * @see TypedHandlerDelegate#beforeCharTyped
	 */
	def Result beforeCharTyped(char c, Project project, EditorEx editor, PsiFile file, FileType fileType) {
		Result.CONTINUE
	}

	/**
	 * @see TypedHandlerDelegate#charTyped
	 */
	def Result charTyped(char c, Project project, EditorEx editor, PsiFile file) {
		Result.CONTINUE
	}

	/**
	 * @see BackspaceHandlerDelegate#beforeCharDeleted
	 */
	def void beforeCharDeleted(char c, PsiFile file, EditorEx editor) {
	}

	/**
	 * @see BackspaceHandlerDelegate#charDeleted
	 */
	def boolean charDeleted(char c, PsiFile file, EditorEx editor) {
		false
	}

	/**
	 * @see EnterHandlerDelegate#preprocessEnter
	 */
	def Result beforeEnterTyped(
		PsiFile file,
		EditorEx editor,
		Ref<Integer> caretOffset,
		Ref<Integer> caretAdvance,
		DataContext dataContext,
		EditorActionHandler originalHandler
	) {
		Result.CONTINUE
	}

	/**
	 * @see EnterHandlerDelegate#postProcessEnter
	 */
	def Result enterTyped(PsiFile file, EditorEx editor, DataContext dataContext) {
		Result.CONTINUE
	}

}