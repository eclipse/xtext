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
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import org.eclipse.xtend.core.idea.highlighting.XtendHighlightingLexer
import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions

import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*
import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VfsUtil

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
	
	protected def getGeneratedSources(PsiFile sourceFile, (VirtualFile)=>boolean filter) {
		sourceFile.virtualFile.getGeneratedSources(filter).map[psiManager.findFile(it)].filterNull
	}
	
	protected def getGeneratedSources(VirtualFile sourceFile, (VirtualFile)=>boolean filter) {
		sourceFile.generatedSources.filter[filter.apply(it)]
	}
	
	protected def getGeneratedSources(VirtualFile sourceFile) {
		builder.getGeneratedSources(sourceFile.URI).map[virtualFile].filterNull
	}
	
	protected def getIndex() {
		val rs = new XtextResourceSet()
		builder.installCopyOfResourceDescriptions(rs)
		val index = ChunkedResourceDescriptions.findInEmfObject(rs)
		return index
	}
	
	protected def getBuilder() {
		project.getComponent(XtextAutoBuilderComponent)
	}

}