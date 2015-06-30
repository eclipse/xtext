/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextAutoEditTypedHandler extends TypedHandlerDelegate {

	override beforeCharTyped(char c, Project project, Editor editor, PsiFile file, FileType fileType) {
		val autoEditHandler = IdeaAutoEditHandlerExtension.INSTANCE.forLanguage(file.language)
		if (autoEditHandler == null)
			return super.beforeCharTyped(c, project, editor, file, fileType)
		return autoEditHandler.beforeCharTyped(c, project, editor as EditorEx, file, fileType).translateResult
	}

	override charTyped(char c, Project project, Editor editor, PsiFile file) {
		val autoEditHandler = IdeaAutoEditHandlerExtension.INSTANCE.forLanguage(file.language)
		if (autoEditHandler == null)
			return super.charTyped(c, project, editor, file)
		return autoEditHandler.charTyped(c, project, editor as EditorEx, file).translateResult
	}

	protected def translateResult(IdeaAutoEditHandler.Result result) {
		switch result {
			case DEFAULT: Result.DEFAULT
			case CONTINUE: Result.CONTINUE
			case STOP: Result.STOP
		}
	}

}