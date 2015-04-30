/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import com.google.inject.Inject
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.indexing.FileBasedIndex
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.resource.impl.PsiFileBasedResourceDescription
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable

abstract class AbstractScopeBasedSelectable extends AbstractCompoundSelectable {

	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER)
	GlobalSearchScope scope

	@Inject
	ExportedObjectQualifiedNameIndex exportedObjectQualifiedNameIndex

	override protected getSelectables() {
		resourceDescriptions
	}

	def IResourceDescription getResourceDescription(URI uri) {
		uri.findFile.toResourceDescription
	}

	def getResourceDescriptions() {
		val extension psiManager = PsiManager.getInstance(scope.project)
		allXtextVirtualFiles.map[findFile].filter(BaseXtextFile).map[toResourceDescription]
	}

	override getExportedObjects(EClass type, QualifiedName qualifiedName, boolean ignoreCase) {
		exportedObjectQualifiedNameIndex.get(qualifiedName.toString, scope.project, scope).map [
			toResourceDescription.getExportedObjects(type, qualifiedName, ignoreCase)
		].flatten
	}

	protected def IResourceDescription toResourceDescription(BaseXtextFile xtextFile) {
		if(xtextFile != null) new PsiFileBasedResourceDescription(xtextFile)
	}

	protected def findFile(URI uri) {
		val fileName = uri.lastSegment
		FilenameIndex.getFilesByName(scope.project, fileName, scope).filter(BaseXtextFile).findFirst [
			uri.equals(URI)
		]
	}

	protected def getAllXtextVirtualFiles() {
		xtextLanguageFilesTypes.map[fileType|FileTypeIndex.getFiles(fileType, scope)].flatten
	}

	protected def getXtextLanguageFilesTypes() {
		FileBasedIndex.instance.getAllKeys(FileTypeIndex.NAME, scope.project).filter[xtextLanguage]
	}

	protected def isXtextLanguage(FileType fileType) {
		if(fileType instanceof LanguageFileType) fileType.language instanceof IXtextLanguage
	}

}
