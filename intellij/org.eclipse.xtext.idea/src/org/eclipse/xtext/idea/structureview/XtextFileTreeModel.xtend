/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.structureView.TextEditorBasedStructureViewModel
import com.intellij.openapi.editor.Editor
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.impl.BaseXtextFile

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextFileTreeModel extends TextEditorBasedStructureViewModel implements StructureViewModel.ElementInfoProvider {

	@Accessors
	IStructureViewTreeElementProvider structureViewTreeElementProvider

	new(BaseXtextFile xtextFile, Editor editor) {
		super(editor, xtextFile)
	}

	override protected BaseXtextFile getPsiFile() {
		super.getPsiFile() as BaseXtextFile
	}

	override getRoot() {
		val rootTreeElement = new XtextFileTreeElement(psiFile)
		rootTreeElement.structureViewTreeElementProvider = structureViewTreeElementProvider
		rootTreeElement
	}

	override isAlwaysLeaf(StructureViewTreeElement element) {
		if (element instanceof AbstractStructureViewTreeElement) {
			element.leaf
		} else {
			false
		}
	}

	override isAlwaysShowsPlus(StructureViewTreeElement element) {
		false
	}

}