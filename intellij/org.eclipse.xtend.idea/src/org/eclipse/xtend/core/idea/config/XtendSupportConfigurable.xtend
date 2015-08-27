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
		val conf = module.createOrGetXtendFacetConf
		setupOutputConfiguration(module, conf, rootModel)
		setupOutputFolder(conf.state, rootModel)
		xtendLibManager.ensureXtendLibAvailable(rootModel, module)
	}

	def setupOutputConfiguration(Module module, XtendFacetConfiguration conf, ModifiableRootModel rootModel) {
		val buildFile =  module.locateBuildFile()
		if (module.isGradleedModule && buildFile !==null) {
			new WriteCommandAction.Simple(module.project, "Gradle: Xtend Configuration",
				newImmutableList(buildFile)) {
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

	def setupOutputFolder(XbaseGeneratorConfigurationState state, ModifiableRootModel rootModel) {
		val moduleFile = rootModel.module.moduleFile
		var VirtualFile xtendGenMain = createOrGetInParentDir(moduleFile, state.outputDirectory)
		val entry = rootModel.contentEntries.head
		if (xtendGenMain != null) {
			val properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true);
			entry.addSourceFolder(xtendGenMain, JavaSourceRootType.SOURCE, properties)
		}
		var VirtualFile xtendGenTest = createOrGetInParentDir(moduleFile, state.testOutputDirectory)
		if (xtendGenTest != null) {
			val properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true);
			entry.addSourceFolder(xtendGenTest, JavaSourceRootType.TEST_SOURCE, properties)
		}

	}

	def presetPlainJavaOutputDirectories(XbaseGeneratorConfigurationState state, ModifiableRootModel rootModel) {
		val entry = rootModel.contentEntries.filter[!it.url.contains('xtend-gen')].head
		val mainSrc = entry.sourceFolders.filter[!testSource && file?.exists].head
		var VirtualFile xtendGenMain = mainSrc.createOrGetInParentDir('xtend-gen')
		val testSrc = entry.sourceFolders.filter[testSource && file?.exists].head
		var VirtualFile xtendGenTest = testSrc.createOrGetInParentDir('xtend-gen')
		if (xtendGenMain != null)
			state.outputDirectory = VfsUtil.getRelativePath(xtendGenMain, rootModel.module.moduleFile.parent)
		if (xtendGenTest != null)
			state.testOutputDirectory = VfsUtil.getRelativePath(xtendGenTest, rootModel.module.moduleFile.parent)
	}

	def private VirtualFile createOrGetInParentDir(VirtualFile sibling, String relativePath) {
		// TODO unmark parent ExcludedFolders e.g. 'build'
		val parent = sibling?.parent
		if (parent === null)
			return null
		VfsUtil.createDirectoryIfMissing(parent, relativePath)
	}

	def private VirtualFile createOrGetInParentDir(SourceFolder sibling, String relativePath) {
		val file = sibling?.file
		if (file === null)
			return null
		createOrGetInParentDir(file, relativePath)
	}

	override createComponent() {
		null
	}

	override createLibraryDescription() {
		libraryDescriptionProvider.get
	}

}