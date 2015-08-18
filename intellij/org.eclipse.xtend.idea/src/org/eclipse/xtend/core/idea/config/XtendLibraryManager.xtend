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
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.libraries.Library
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import com.intellij.openapi.startup.StartupManager
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.xml.DomUtil
import org.eclipse.xtend.lib.annotations.Data
import org.jetbrains.idea.maven.dom.MavenDomUtil
import org.jetbrains.idea.maven.dom.model.MavenDomProjectModel
import org.jetbrains.idea.maven.model.MavenId
import org.jetbrains.idea.maven.project.MavenProject
import org.jetbrains.idea.maven.project.MavenProjectsManager
import org.jetbrains.plugins.gradle.util.GradleConstants
import org.jetbrains.plugins.groovy.lang.psi.GroovyPsiElementFactory
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrCall
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrMethodCall

import static org.eclipse.xtend.core.idea.config.XtendLibraryManager.*

/**
 * @author dhuebner - Initial contribution and API
 */
class XtendLibraryManager {
	protected static final Logger LOG = Logger.getInstance(XtendLibraryManager.name)

	@Inject XtendLibraryDescription xtendLibDescr
	static MavenId XTEND_LIB_MAVEN_ID

	def ensureXtendLibAvailable(ModifiableRootModel rootModel, Module module) {
		ensureXtendLibAvailable(rootModel, module, null)
	}

	def ensureXtendLibAvailable(ModifiableRootModel rootModel, Module module, PsiFile context) {
		val project = module.project
		if (project.initialized) {
			doEnsureXtendLibAvailable(rootModel, module, context)
		} else {
			StartupManager.getInstance(project).registerPostStartupActivity[
				doEnsureXtendLibAvailable(rootModel, module, context)
			]
		}
	}
	
	protected def void doEnsureXtendLibAvailable(ModifiableRootModel rootModel, Module module, PsiFile context) {
		val scope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module)
		val psiClass = JavaPsiFacade.getInstance(module.project).findClass(Data.name, scope)
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
				var factory = GroovyPsiElementFactory.getInstance(module.project)
				var closableBlocks = PsiTreeUtil.getChildrenOfTypeAsList(buildFile, GrMethodCall)
				
				var GrCall dependenciesBlock = closableBlocks.findFirst [
					var expression = getInvokedExpression()
					return expression !== null && "dependencies".equals(expression.getText())
				]

				val scope = if(context?.isTestScope) "testCompile" else "compile"

				if (dependenciesBlock === null) {
					dependenciesBlock = factory.createStatementFromText(
					'''
					dependencies {
						«scope» '«xtendLibMavenId.key»'
					}''') as GrCall
					buildFile.add(dependenciesBlock)
				} else {
					var closableBlock = dependenciesBlock.getClosureArguments().head
					if (closableBlock !== null) {
						closableBlock.addStatementBefore(
							factory.createStatementFromText('''«scope» '«xtendLibMavenId.key»' '''), null)
					}
				}
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

	def PsiFile locateBuildFile(Module module) {
		val modulePath = ExternalSystemApiUtil.getExternalProjectPath(module)
		if (modulePath !== null) {
			var buildScriptPath = FileUtil.findFileInProvidedPath(modulePath, GradleConstants.DEFAULT_SCRIPT_NAME)
			if (!buildScriptPath.isNullOrEmpty) {
				var VirtualFile virtualFile = LocalFileSystem.getInstance().refreshAndFindFileByPath(buildScriptPath)
				if (virtualFile !== null) {
					val PsiFile psiFile = PsiManager.getInstance(module.project).findFile(virtualFile)
					if (psiFile !== null && psiFile.valid) {
						return psiFile
					}
				}
			}
		}
		return null
	}

	def boolean isGradleedModule(Module module) {
		ExternalSystemApiUtil.isExternalSystemAwareModule(GradleConstants.SYSTEM_ID, module)
	}

	def void addJavaRuntimeLibrary(Module module, ModifiableRootModel rootModel) {
		val library = createOrGetXtendJavaLibrary(rootModel, module)
		if (library != null && rootModel.findLibraryOrderEntry(library) === null) {
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

}