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
		val conf = rootModel.module.createOrGetXtendFacetConf
		rootModel.setupOutputConfiguration(conf)
		rootModel.createOutputFolders(conf.state)
		xtendLibManager.ensureXtendLibAvailable(rootModel)
	}

	def setupOutputConfiguration(ModifiableRootModel rootModel, XtendFacetConfiguration conf) {
		val module = rootModel.module
		val buildFile = module.locateBuildFile()
		if (module.isGradleedModule && buildFile !== null) {
			new WriteCommandAction.Simple(module.project, "Gradle: Xtend Configuration", newImmutableList(buildFile)) {
				override protected run() throws Throwable {
					module.setupGradleBuild(buildFile)
				}
			}.execute
			conf.state.presetGradleOutputDirectories(rootModel)
		} else {
			conf.state.presetPlainJavaOutputDirectories(rootModel)
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

	def presetGradleOutputDirectories(XbaseGeneratorConfigurationState state, ModifiableRootModel rootModel) {
		val parentPath = rootModel.contentRoots.head.path
		if (rootModel.module.isAndroidGradleModule()) {
			state.outputDirectory = '''«parentPath»/build/generated/source/xtend/debug'''
			state.testOutputDirectory = '''«parentPath»/build/generated/source/xtend/androidTest/debug'''
		} else {
			state.outputDirectory = '''«parentPath»/build/xtend-gen/main'''
			state.testOutputDirectory = '''«parentPath»/build/xtend-gen/test'''
		}
	}

	def void presetPlainJavaOutputDirectories(XbaseGeneratorConfigurationState state, ModifiableRootModel model) {

		val mainSrc = model.findSourceFolder[!testSource && file?.exists]
		val testSrc = model.findSourceFolder[testSource && file?.exists]

		if (mainSrc != null) {
			state.outputDirectory = siblingPath(mainSrc, 'xtend-gen')
		} else {
			val contentRoot = model.findBestContentRoot
			state.outputDirectory = contentRoot.path + VfsUtil.VFS_SEPARATOR_CHAR + 'xtend-gen'

		}
		if (testSrc != null) {
			state.testOutputDirectory = siblingPath(testSrc, 'xtend-gen')
		} else {
			state.testOutputDirectory = state.outputDirectory
		}
	}

	def void createOutputFolders(ModifiableRootModel rootModel, XbaseGeneratorConfigurationState state) {
		var xtendGenMain = VfsUtil.createDirectoryIfMissing(state.outputDirectory)
		if (xtendGenMain != null) {
			rootModel.addAsSourceFolder(xtendGenMain, JavaSourceRootType.SOURCE)
		}
		if (state.outputDirectory != state.testOutputDirectory) {
			var xtendGenTest = VfsUtil.createDirectoryIfMissing(state.testOutputDirectory)
			if (xtendGenTest != null) {
				rootModel.addAsSourceFolder(xtendGenTest, JavaSourceRootType.TEST_SOURCE)
			}
		}
	}

	/**
	 * 	For single contentRoot use it
	 * 	For multiple use first that not contains the module config file
	 * 	For any use project baseDir
	 */
	def private VirtualFile findBestContentRoot(ModifiableRootModel model) {
		val module = model.module
		val roots = model.contentRoots
		if (roots.size == 1) {
			return roots.get(0)
		} else if (roots.size > 1) {
			if (module.moduleFile !== null) {
				return roots.findFirst[!VfsUtil.isAncestor(it, module.moduleFile, true)]
			} else {
				return roots.head
			}
		}
		return model.project.baseDir
	}

	def private VirtualFile findSourceFolder(ModifiableRootModel rootModel, (SourceFolder)=>Boolean fun) {
		val contnentRoot = rootModel.contentEntries.findFirst [
			sourceFolders.findFirst[fun.apply(it)] !== null
		]
		if (contnentRoot !== null) {
			return contnentRoot.sourceFolders.findFirst(fun).file
		}
	}

	def void addAsSourceFolder(ModifiableRootModel rootModel, VirtualFile xtendGenMain, JavaSourceRootType type) {
		val contentRoot = rootModel.contentEntries.findFirst[VfsUtil.isAncestor(it.file, xtendGenMain, true)]
		if (contentRoot !== null) {
			val excludedParent = contentRoot.excludeFolders.findFirst[VfsUtil.isAncestor(it.file, xtendGenMain, true)]
			if (excludedParent !== null) {
				contentRoot.removeExcludeFolder(excludedParent)
			}
			val properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true)
			contentRoot.addSourceFolder(xtendGenMain, type, properties)
		}
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