/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.tests

import com.google.common.collect.Lists
import com.intellij.openapi.fileTypes.FileTypeManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.vfs.LocalFileSystem
import java.io.File
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder

import static extension com.intellij.openapi.roots.ModuleRootModificationUtil.*
import static extension com.intellij.openapi.vfs.VfsUtil.*
import static extension com.intellij.util.PathUtil.*
import com.intellij.openapi.vfs.newvfs.impl.VfsRootAccess

class LibraryUtil {

	static def addGuavaLibrary(Module it) {
		updateModel[addGuavaLibrary]
	}

	static def addGuavaLibrary(ModifiableRootModel it) {
		addLibrary("com.google.guava", Lists)
	}

	static def addXbaseLibrary(Module it) {
		updateModel[addXbaseLibrary]
	}

	static def addXbaseLibrary(ModifiableRootModel it) {
		removeLibFromIgnoredFilesList
		addGuavaLibrary
		addLibrary("org.eclipse.xtext.xbase.lib", ToStringBuilder)
	}
	
	static def addXtendLibrary(Module it) {
		updateModel[addXtendLibrary]
	}

	static def addXtendLibrary(ModifiableRootModel it) {
		removeLibFromIgnoredFilesList
		addXbaseLibrary
		addLibrary("org.eclipse.xtend.lib.macro", Active)
		addLibrary("org.eclipse.xtend.lib", Data)
	}

	static def removeLibFromIgnoredFilesList() {
		val fileTypeManager = FileTypeManager.instance
		val ignoredFilesList = fileTypeManager.ignoredFilesList.split('\\*\\.lib;')
		if (ignoredFilesList.length > 1) {
			fileTypeManager.ignoredFilesList = ignoredFilesList.reduce[p1, p2|p1 + p2]
		}
	}

	static def void addLibrary(Module it, String libName, Class<?> clazz) {
		updateModel[addLibrary(libName, clazz)]
	}

	static def void addLibrary(ModifiableRootModel it, String libName, Class<?> clazz) {
		val libraryModel = moduleLibraryTable.createLibrary(libName).modifiableModel
		libraryModel.addRoot(clazz.urlForLibraryRoot, OrderRootType.CLASSES)
		libraryModel.commit
	}

	static def getUrlForLibraryRoot(Class<?> clazz) {
		val path = clazz.jarPathForClass
		VfsRootAccess.allowRootAccess(path)
		val libraryRoot = new File(path)
		LocalFileSystem.instance.refreshAndFindFileByIoFile(libraryRoot)
		libraryRoot.urlForLibraryRoot
	}

}
