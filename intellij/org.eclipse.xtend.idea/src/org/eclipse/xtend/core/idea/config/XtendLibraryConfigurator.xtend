/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.google.inject.Inject
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.PluginId
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
import org.eclipse.xtend.core.idea.framework.XtendLibraryDescription
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.idea.util.ProjectLifecycleUtil
import org.jetbrains.idea.maven.dom.MavenDomUtil
import org.jetbrains.idea.maven.dom.model.MavenDomProjectModel
import org.jetbrains.idea.maven.model.MavenId
import org.jetbrains.idea.maven.project.MavenProject
import org.jetbrains.idea.maven.project.MavenProjectsManager

/**
 * @author dhuebner - Initial contribution and API
 */
class XtendLibraryConfigurator {
	
	protected static final Logger LOG = Logger.getInstance(XtendLibraryConfigurator.name)
	@Inject extension GradleBuildFileUtility gradleUtils
	@Inject XtendLibraryDescription xtendLibDescr
	static MavenId XTEND_LIB_MAVEN_ID
	@Inject extension  ProjectLifecycleUtil

	def ensureXtendLibAvailable(ModifiableRootModel rootModel) {
		ensureXtendLibAvailable(rootModel, null)
	}

	def ensureXtendLibAvailable(ModifiableRootModel rootModel, PsiFile context) {
		rootModel.project.executeWhenProjectReady[doEnsureXtendLibAvailable(rootModel, context)]
	}

	protected def void doEnsureXtendLibAvailable(ModifiableRootModel rootModel, PsiFile context) {
		val module = rootModel.module
		val scope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module)
		val psiClass = JavaPsiFacade.getInstance(rootModel.project).findClass(Data.name, scope)
		if (psiClass == null) {
			if (module.isMavenizedModule) {
				module.addMavenDependency(context)
			} else if (module.isGradleedModule) {
				module.addGradleDependency(context)
			} else {
				module.addJavaRuntimeLibrary(rootModel)
			}
		}
	}

	def void addGradleDependency(Module module, PsiFile context) {
		val buildFile = module.locateBuildFile
		if (buildFile === null) {
			LOG.error("Gradle build file not found in module " + module.name)
			return
		}

		new WriteCommandAction.Simple(module.project, "Gradle: Add Xtend Runtime Library",
			newImmutableList(buildFile)) {
			override protected run() throws Throwable {
				val scope = if(context?.isTestScope) "testCompile" else "compile"
				gradleUtils.addDependency(buildFile, '''«scope» '«xtendLibMavenId.key»' ''')
			}

		}.execute

	}

	def static xtendLibMavenId() {
		if (XTEND_LIB_MAVEN_ID === null) {
			// TODO use 2.8.4 because snapshot repo is not available 
			val xtendPlugin = PluginManager.getPlugin(PluginId.getId("org.eclipse.xtend.idea"))
			val version = xtendPlugin?.version
			LOG.info("The current Xtend plugin version is " + version)
			XTEND_LIB_MAVEN_ID = new MavenId("org.eclipse.xtend", "org.eclipse.xtend.lib", "2.8.4")
		}
		return XTEND_LIB_MAVEN_ID
	}

	def void addJavaRuntimeLibrary(Module module, ModifiableRootModel rootModel) {
		val library = createOrGetXtendJavaLibrary(rootModel, module)
		if (library != null && rootModel.findLibraryOrderEntry(library) === null) {
			if (rootModel.isWritable)
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
				var dependency = MavenDomUtil.createDomDependency(model, null, xtendLibMavenId)
				if (context?.isTestScope) {
					dependency.getScope().setStringValue("test")
				}
			}

		}.execute()
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

	protected def boolean isTestScope(PsiFile context) {
		var VirtualFile virtualFile = context.getOriginalFile().getVirtualFile()
		if (virtualFile !== null) {
			return ProjectRootManager.getInstance(context.project).getFileIndex().isInTestSourceContent(virtualFile)
		}
	}

	def boolean isMavenizedModule(Module module) {
		var mavenProjectsManager = MavenProjectsManager.getInstance(module.getProject())
		return if(mavenProjectsManager !== null) mavenProjectsManager.isMavenizedModule(module) else false
	}

}