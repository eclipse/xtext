/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.google.inject.Inject
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableModelsProvider
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import com.intellij.openapi.vfs.LocalFileSystem
import java.io.File
import javax.inject.Provider

import static extension com.intellij.openapi.util.io.FileUtil.*
import static extension com.intellij.openapi.vfs.VfsUtilCore.*

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendSupportConfigurable extends FrameworkSupportInModuleConfigurable {

	@Inject
	Provider<XtendLibraryDescription> libraryDescriptionProvider

	override addSupport(
		Module module,
		ModifiableRootModel rootModel,
		ModifiableModelsProvider modifiableModelsProvider
	) {
		val output = new File(new File(module.moduleFilePath).parentFile, 'xtend-gen')
		val url = output.path.toSystemIndependentName.pathToUrl
		rootModel.contentEntries.findFirst[!sourceFolders.empty].addSourceFolder(url, false)
		if (!output.exists && output.mkdirs) {
			LocalFileSystem.instance.refreshAndFindFileByIoFile(output)
		}
		val libraryTable = LibraryTablesRegistrar.getInstance().getLibraryTable()
		var library = libraryTable.getLibraryByName(XtendLibraryDescription.XTEND_LIBRARY_NAME)
		if (library != null && !rootModel.moduleLibraryTable.libraries.contains(library)) {
			rootModel.addLibraryEntry(library)
		}
	}

	override createComponent() {
		null
	}

	override createLibraryDescription() {
		libraryDescriptionProvider.get
	}

}