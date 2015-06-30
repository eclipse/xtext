/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.intellij.codeInsight.editorActions.BackspaceHandlerDelegate
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.psi.PsiFile

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextAutoEditBackspaceHandler extends BackspaceHandlerDelegate {

	override beforeCharDeleted(char c, PsiFile file, Editor editor) {
		val autoEditHandler = IdeaAutoEditHandlerExtension.INSTANCE.forLanguage(file.language)
		if (autoEditHandler != null)
			autoEditHandler.beforeCharDeleted(c, file, editor as EditorEx)
	}

	override charDeleted(char c, PsiFile file, Editor editor) {
		val autoEditHandler = IdeaAutoEditHandlerExtension.INSTANCE.forLanguage(file.language)
		if (autoEditHandler != null)
			autoEditHandler.charDeleted(c, file, editor as EditorEx)
		else
			false
	}

}