/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.google.inject.Inject
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.libraries.Library
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.xml.DomUtil
import org.eclipse.xtend.lib.annotations.Data
import org.jetbrains.idea.maven.dom.MavenDomUtil
import org.jetbrains.idea.maven.dom.model.MavenDomDependency
import org.jetbrains.idea.maven.dom.model.MavenDomProjectModel
import org.jetbrains.idea.maven.model.MavenId
import org.jetbrains.idea.maven.project.MavenProject
import org.jetbrains.idea.maven.project.MavenProjectsManager

import static org.eclipse.xtend.core.idea.config.XtendLibraryManager.*

/**
 * @author dhuebner - Initial contribution and API
 */
class XtendLibraryManager {

	@Inject XtendLibraryDescription xtendLibDescr
	static final String VERSION = "2.8.4"

	def ensureXtendLibAvailable(ModifiableRootModel rootModel, Module module) {
		ensureXtendLibAvailable(rootModel, module, null)
	}

	def ensureXtendLibAvailable(ModifiableRootModel rootModel, Module module, PsiFile context) {
		val psiClass = JavaPsiFacade.getInstance(module.project).findClass(Data.name,
			GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module));
		if (psiClass == null) {
			// TODO choose a strategy for gradle plain module and apply
			// see org.jetbrains.plugins.gradle.integrations.maven.codeInsight.actions.AddGradleDslDependencyActionHandler
			if (module.isMavenizedModule) {
				module.addMavenDependency(context)
			} else {
				module.addJavaRuntimeLibrary(rootModel)
			}
		}
	}

	def void addJavaRuntimeLibrary(Module module, ModifiableRootModel rootModel) {
		val library = createOrGetXtendJavaLibrary(rootModel, module)
		if (library != null && !rootModel.moduleLibraryTable.libraries.contains(library)) {
			rootModel.addLibraryEntry(library)
		}
	}

	def void addMavenDependency(Module module, PsiFile context) {
		val project = module.getProject()
		val mavenProjectsManager = MavenProjectsManager.getInstance(project)
		val MavenProject mavenProject = mavenProjectsManager.findProject(module)
		if(mavenProject === null) return;

		val MavenDomProjectModel model = MavenDomUtil.getMavenDomProjectModel(project, mavenProject.getFile())
		if(model === null) return;

		new WriteCommandAction.Simple(project, "Add Xtend lib Maven Dependency",
			newImmutableList(DomUtil.getFile(model))) {

			override protected run() throws Throwable {
				var boolean isTestSource = false
				var VirtualFile virtualFile = context.getOriginalFile().getVirtualFile()
				if (virtualFile !== null) {
					isTestSource = ProjectRootManager.getInstance(project).getFileIndex().
						isInTestSourceContent(virtualFile)
				}
				val xtendLibId = new MavenId("org.eclipse.xtend", "org.eclipse.xtend.lib", VERSION)
				var MavenDomDependency dependency = MavenDomUtil.createDomDependency(model, null, xtendLibId)
				if (isTestSource) {
					dependency.getScope().setStringValue("test")
				}
			}

		}.execute()
	}

	def boolean isMavenizedModule(Module module) {
		var mavenProjectsManager = MavenProjectsManager.getInstance(module.getProject())
		return if(mavenProjectsManager !== null) mavenProjectsManager.isMavenizedModule(module) else false
	}

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

}