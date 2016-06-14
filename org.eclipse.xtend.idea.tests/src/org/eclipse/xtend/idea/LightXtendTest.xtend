/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.psi.tree.IElementType
import org.eclipse.xtend.core.idea.highlighting.XtendHighlightingLexer
import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles
import org.eclipse.xtext.idea.tests.LightToolingTest

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

abstract class LightXtendTest extends LightToolingTest {

	new() {
		super(XtendFileType.INSTANCE)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXtendLibrary
		
		val xtendGenFolder = VfsUtil.createDirectoryIfMissing(contentEntry.file, "xtend-gen") 
		contentEntry.addSourceFolder(xtendGenFolder, false)
	}

	override protected getXtextStyle(IElementType tokenType) {
		if(tokenType == XtendHighlightingLexer.GUILLEMET_ELEMENT_TYPE)
			XtendHighlightingStyles.RICH_TEXT_DELIMITER_ID
		else 
			super.getXtextStyle(tokenType)
	}

}