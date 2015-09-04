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
import com.intellij.openapi.vfs.VfsUtilCore
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

	def presetGradleOutputDirectories(XbaseGeneratorConfigurationState state, Module module) {
		if (module.isAndroidGradleModule()) {
			state.outputDirectory = "build/generated/source/xtend/debug"
			state.testOutputDirectory = "build/generated/source/xtend/androidTest/debug"
		} else {
			state.outputDirectory = "build/xtend-gen/main"
			state.testOutputDirectory = "build/xtend-gen/test"
		}
	}

	def presetPlainJavaOutputDirectories(XbaseGeneratorConfigurationState state, ModifiableRootModel rootModel) {
		val entry = rootModel.contentEntries.filter[!it.url.contains('xtend-gen')].head
		val mainSrc = entry.sourceFolders.filter[!testSource && file?.exists].head
		val testSrc = entry.sourceFolders.filter[testSource && file?.exists].head
		if (mainSrc != null) {
			state.outputDirectory = siblingPath(mainSrc, 'xtend-gen')
		}
		if (testSrc != null) {
			state.testOutputDirectory = siblingPath(testSrc, 'xtend-gen')
		}
	}

	def createOutputFolders(XbaseGeneratorConfigurationState state, ModifiableRootModel rootModel) {
		val moduleRoot = rootModel.contentEntries.head
		var VirtualFile xtendGenMain = createOrGetDir(moduleRoot.file, state.outputDirectory)
		if (xtendGenMain != null) {
			val properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true);
			moduleRoot.addSourceFolder(xtendGenMain, JavaSourceRootType.SOURCE, properties)
		}
		var VirtualFile xtendGenTest = createOrGetDir(moduleRoot.file, state.testOutputDirectory)
		if (xtendGenTest != null) {
			val properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true);
			moduleRoot.addSourceFolder(xtendGenTest, JavaSourceRootType.TEST_SOURCE, properties)
		}

	}

	def private VirtualFile createOrGetDir(VirtualFile parent, String path) {
		if (VfsUtilCore.isUnder(path, #[parent.url])) {
			VfsUtil.createDirectoryIfMissing(parent, path)
		} else {
			VfsUtil.createDirectoryIfMissing(path)
		}
	}

	def private String siblingPath(SourceFolder sibling, String path) {
		val parentUrl = VfsUtil.getParentDir(sibling.url)
		return parentUrl + VfsUtil.VFS_SEPARATOR_CHAR + path
	}

	override createComponent() {
		null
	}

	override createLibraryDescription() {
		libraryDescriptionProvider.get
	}

}