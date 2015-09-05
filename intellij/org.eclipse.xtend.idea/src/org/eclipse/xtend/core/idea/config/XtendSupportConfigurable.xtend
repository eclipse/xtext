/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.google.inject.Inject
import com.intellij.facet.FacetManager
import com.intellij.facet.FacetTypeRegistry
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableModelsProvider
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.SourceFolder
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import javax.inject.Provider
import org.eclipse.xtend.core.idea.facet.XtendFacetConfiguration
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState
import org.jetbrains.jps.model.java.JavaSourceRootType
import org.jetbrains.jps.model.java.JpsJavaExtensionService

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendSupportConfigurable extends FrameworkSupportInModuleConfigurable {

	@Inject
	Provider<XtendLibraryDescription> libraryDescriptionProvider
	@Inject XtendLibraryManager xtendLibManager
	@Inject extension GradleBuildFileUtility

	override addSupport(
		Module module,
		ModifiableRootModel rootModel,
		ModifiableModelsProvider modifiableModelsProvider
	) {
		val conf = module.createOrGetXtendFacetConf
		setupOutputConfiguration(module, conf, rootModel)
		createOutputFolders(conf.state, rootModel)
		xtendLibManager.ensureXtendLibAvailable(rootModel, module)
	}

	def setupOutputConfiguration(Module module, XtendFacetConfiguration conf, ModifiableRootModel rootModel) {
		val buildFile = module.locateBuildFile()
		if (module.isGradleedModule && buildFile !== null) {
			new WriteCommandAction.Simple(module.project, "Gradle: Xtend Configuration", newImmutableList(buildFile)) {
				override protected run() throws Throwable {
					module.setupGradleBuild(buildFile)
				}
			}.execute
			conf.state.presetGradleOutputDirectories(module)
		} else {
			conf.state.presetPlainJavaOutputDirectories(module)
		}
	}

	def XtendFacetConfiguration createOrGetXtendFacetConf(Module module) {
		val facetType = FacetTypeRegistry.getInstance().findFacetType(XtendLanguage.INSTANCE.ID)
		if (facetType === null) {
			return null
		}
		val mnr = FacetManager.getInstance(module)
		var facet = mnr.findFacet(facetType.id, facetType.defaultFacetName) ?:
			FacetManager.getInstance(module).addFacet(facetType, facetType.defaultFacetName, null)
		return facet.configuration as XtendFacetConfiguration

	}

	def presetGradleOutputDirectories(XbaseGeneratorConfigurationState state, Module module) {
		val parentPath = ModuleRootManager.getInstance(module).contentRoots.head.path
		if (module.isAndroidGradleModule()) {
			state.outputDirectory = '''«parentPath»/build/generated/source/xtend/debug'''
			state.testOutputDirectory = '''«parentPath»/build/generated/source/xtend/androidTest/debug'''
		} else {
			state.outputDirectory = '''«parentPath»/build/xtend-gen/main'''
			state.testOutputDirectory = '''«parentPath»/build/xtend-gen/test'''
		}
	}

	def void presetPlainJavaOutputDirectories(XbaseGeneratorConfigurationState state, Module module) {
		val moduleManager = ModuleRootManager.getInstance(module)

		val mainSrc = moduleManager.findSourceFolder[!testSource && file?.exists]
		val testSrc = moduleManager.findSourceFolder[testSource && file?.exists]

		if (mainSrc != null) {
			state.outputDirectory = siblingPath(mainSrc, 'xtend-gen')
		} else {
			val contentRoot = moduleManager.findBestContentRoot
			state.outputDirectory = contentRoot.path + VfsUtil.VFS_SEPARATOR_CHAR + 'xtend-gen'

		}
		if (testSrc != null) {
			state.testOutputDirectory = siblingPath(testSrc, 'xtend-gen')
		} else {
			state.testOutputDirectory = state.outputDirectory
		}
	}

	def void createOutputFolders(XbaseGeneratorConfigurationState state, ModifiableRootModel rootModel) {
		var xtendGenMain = VfsUtil.createDirectoryIfMissing(state.outputDirectory)
		if (xtendGenMain != null) {
			rootModel.addAsSourceFolder(xtendGenMain, JavaSourceRootType.SOURCE)
		}
		var xtendGenTest = VfsUtil.createDirectoryIfMissing(state.testOutputDirectory)
		if (xtendGenTest != null) {
			rootModel.addAsSourceFolder(xtendGenTest, JavaSourceRootType.TEST_SOURCE)
		}
	}

	def private VirtualFile findBestContentRoot(ModuleRootManager moduleManager) {
		val module = moduleManager.module
		var contentRoot = module.project.baseDir
		if (module.moduleFile !== null) {
			val moduleFileRoot = ProjectRootManager.getInstance(module.project).fileIndex.getContentRootForFile(
				module.moduleFile)
			if (moduleFileRoot !== null) {
				return contentRoot
			}
		}
		if (!moduleManager.contentRoots.empty) {
			contentRoot = moduleManager.contentRoots.head
		}
		return contentRoot
	}

	def private VirtualFile findSourceFolder(ModuleRootManager manager, (SourceFolder)=>Boolean fun) {
		val contnentRoot = manager.contentEntries.findFirst [
			sourceFolders.findFirst[fun.apply(it)] !== null
		]
		if (contnentRoot !== null) {
			return contnentRoot.sourceFolders.findFirst(fun).file
		}
	}

	def void addAsSourceFolder(ModifiableRootModel rootModel, VirtualFile xtendGenMain, JavaSourceRootType type) {
		val projectFileIndex = ProjectRootManager.getInstance(rootModel.module.project).getFileIndex()
		val properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true);
		val contentRootFile = projectFileIndex.getContentRootForFile(xtendGenMain)
		val contentRoot = rootModel.contentEntries.findFirst[it.file == contentRootFile]
		contentRoot?.addSourceFolder(xtendGenMain, type, properties)
	}

	def private String siblingPath(VirtualFile sibling, String path) {
		return sibling.parent.path + VfsUtil.VFS_SEPARATOR_CHAR + path
	}

	override createComponent() {
		null
	}

	override createLibraryDescription() {
		libraryDescriptionProvider.get
	}

}