/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.ide.hierarchy

import com.google.inject.Inject
import com.intellij.ide.hierarchy.type.JavaTypeHierarchyProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses
import org.jetbrains.annotations.NotNull

import static extension com.intellij.codeInsight.TargetElementUtilBase.*
import static extension org.eclipse.xtext.idea.actionSystem.DataContextExtensions.*
import static extension org.eclipse.xtext.idea.extensions.IdeaProjectExtensions.*

class JvmDeclaredTypeHierarchyProvider extends JavaTypeHierarchyProvider {

	@Inject
	extension JvmPsiClasses

	override PsiElement getTarget(@NotNull DataContext dataContext) {
		val project = dataContext.project
		if (project == null) {
			return null
		}
		val editor = dataContext.editor
		if (editor == null) {
			return dataContext.psiElement.psiClasses.head
		}
		val file = project.psiDocumentManager.getPsiFile(editor.document)
		if (file == null) {
			return null
		}
		val psiClass = editor.targetElement.psiClasses.head
		if (psiClass != null) {
			return psiClass
		}
		val offset = editor.caretModel.offset
		file.findElementAt(offset).findPsiClasses.head
	}

	protected def getTargetElement(Editor editor) {
		editor.findTargetElement(
			ELEMENT_NAME_ACCEPTED.bitwiseOr(REFERENCED_ELEMENT_ACCEPTED).bitwiseOr(LOOKUP_ITEM_ACCEPTED)
		)
	}

}