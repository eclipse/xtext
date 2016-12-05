/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.google.inject.Inject
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.libraries.Library
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.xtend.core.idea.framework.XtendLibraryDescription
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.idea.util.PlatformUtil
import org.eclipse.xtext.idea.util.ProjectLifecycleUtil
import org.eclipse.xtext.util.XtextVersion
import org.jetbrains.annotations.Nullable

/**
 * @author dhuebner - Initial contribution and API
 */
class XtendLibraryConfigurator {
	
	static final Logger LOG = Logger.getInstance(XtendLibraryConfigurator.name)
	static MavenArtifact XTEND_LIB_MAVEN_ID

	@Inject extension GradleBuildFileUtility
	@Inject extension ProjectLifecycleUtil
	@Inject extension PlatformUtil
	@Inject extension MavenUtility

	@Inject XtendLibraryDescription xtendLibDescr

	def ensureXtendLibAvailable(ModifiableRootModel rootModel) {
		ensureXtendLibAvailable(rootModel, null)
	}

	def ensureXtendLibAvailable(ModifiableRootModel rootModel, @Nullable PsiFile context) {
		rootModel.project.executeWhenProjectReady[doEnsureXtendLibAvailable(rootModel, context)]
	}

	protected def void doEnsureXtendLibAvailable(ModifiableRootModel rootModel, @Nullable PsiFile context) {
		val module = rootModel.module
		val scope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module)
		val psiClass = JavaPsiFacade.getInstance(rootModel.project).findClass(Data.name, scope)
		if (psiClass === null) {
			val testScope = isTestScope(context)
			if (isMavenInstalled && module.isMavenizedModule) {
				module.addXtendLibMavenDependency(testScope)
			} else if (isGradleInstalled && module.isGradleedModule) {
				module.addXtendLibGradleDependency(testScope)
			} else {
				module.addJavaRuntimeLibrary(rootModel)
			}
		}
	}

	def static MavenArtifact xtendLibMavenId() {
		if (XTEND_LIB_MAVEN_ID === null) {
			val version = XtextVersion.current.version
			LOG.info("The current Xtend plugin version is " + version)
			XTEND_LIB_MAVEN_ID = new MavenArtifact("org.eclipse.xtend", "org.eclipse.xtend.lib", version)
		}
		return XTEND_LIB_MAVEN_ID
	}

	def void addJavaRuntimeLibrary(Module module, ModifiableRootModel rootModel) {
		val library = createOrGetXtendJavaLibrary(rootModel, module)
		if (library !== null && rootModel.findLibraryOrderEntry(library) === null) {
			if (rootModel.isWritable)
				rootModel.addLibraryEntry(library)
		}
	}

	def Library createOrGetXtendJavaLibrary(ModifiableRootModel rootModel, Module module) {
		val libraryTable = LibraryTablesRegistrar.getInstance().getLibraryTable(module.project).libraries +
			LibraryTablesRegistrar.getInstance().getLibraryTable().libraries
		val xtendLibs = libraryTable.filter [
			name?.startsWith(XtendLibraryDescription.XTEND_LIBRARY_NAME)
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

	protected def boolean isTestScope(@Nullable PsiFile context) {
		if(context === null) {
			return false
		}
		var VirtualFile virtualFile = context.getOriginalFile().getVirtualFile()
		if (virtualFile !== null) {
			return ProjectRootManager.getInstance(context.project).getFileIndex().isInTestSourceContent(virtualFile)
		}
	}

}
