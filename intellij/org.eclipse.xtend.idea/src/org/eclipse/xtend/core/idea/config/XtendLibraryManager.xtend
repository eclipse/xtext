/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.google.inject.Inject
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.libraries.Library
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.xtend.lib.annotations.Data

/**
 * @author dhuebner - Initial contribution and API
 */
class XtendLibraryManager {
	@Inject XtendLibraryDescription xtendLibDescr

	def Library createOrGetXtendJavaLibrary(ModifiableRootModel rootModel, Module module) {
		val libraryTable = LibraryTablesRegistrar.getInstance().getLibraryTable(module.project).libraries +
			LibraryTablesRegistrar.getInstance().getLibraryTable().libraries
		val xtendLibs = libraryTable.filter [
			name.startsWith(XtendLibraryDescription.XTEND_LIBRARY_NAME)
		]
		if (!xtendLibs.empty) {
			if (xtendLibs.exists[name == XtendLibraryDescription.XTEND_LIBRARY_NAME]) {
				return xtendLibs.findFirst[name == XtendLibraryDescription.XTEND_LIBRARY_NAME]
			} else {
				return xtendLibs.head
			}
		} else {
			// create new lib
			val libDescr = xtendLibDescr.createLibraryDescription
			val model = rootModel.getModuleLibraryTable().getModifiableModel()
			val createdLib = model.createLibrary(libDescr.defaultLibraryName)
			val libModel = createdLib.modifiableModel
			xtendLibDescr.libraryRoots.forEach [ type, roots |
				roots.forEach [
					libModel.addRoot(it, type)
				]
			]
			libModel.commit
			model.commit
			return createdLib
		}
	}

	def ensureXtendLibAvailable(ModifiableRootModel rootModel, Module module) {
		val psiClass = JavaPsiFacade.getInstance(module.project).findClass(Data.name,
			GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module));
		if (psiClass == null) {
			// TODO choose a strategy for maven/gradle/plain module and apply 
			val library = createOrGetXtendJavaLibrary(rootModel, module)
			if (library != null && !rootModel.moduleLibraryTable.libraries.contains(library)) {
				rootModel.addLibraryEntry(library)
			}
		}
	}

}