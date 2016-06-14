/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import com.google.inject.Inject
import com.intellij.openapi.editor.Editor
import org.eclipse.xtext.psi.PsiEObject
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendFileJvmTreeModel extends XtendFileTreeModel {

	@Inject
	extension IJvmModelAssociations

	new(BaseXtextFile xtextFile, Editor editor) {
		super(xtextFile, editor)
	}

	override getCurrentEditorElement() {
		val element = superCurrentEditorElement
		if (element instanceof PsiEObject) {
			element.EObject.getPrimaryJvmElement?.URI
		} else {
			super.currentEditorElement
		}
	}

}