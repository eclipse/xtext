package org.eclipse.xtext.idea.tests

import com.google.common.collect.Lists
import com.intellij.openapi.fileTypes.FileTypeManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.vfs.LocalFileSystem
import java.io.File
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder

import static extension com.intellij.openapi.roots.ModuleRootModificationUtil.*
import static extension com.intellij.openapi.vfs.VfsUtil.*
import static extension com.intellij.util.PathUtil.*

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
		addLibrary("org.eclipse.xtext.xbase.lib", ToStringBuilder)
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
		val libraryRoot = new File(clazz.jarPathForClass)
		LocalFileSystem.instance.refreshAndFindFileByIoFile(libraryRoot)
		libraryRoot.urlForLibraryRoot
	}

}
