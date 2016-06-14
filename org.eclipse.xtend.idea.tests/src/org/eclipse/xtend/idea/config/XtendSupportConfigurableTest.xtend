/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.config

import com.intellij.facet.FacetManager
import com.intellij.facet.FacetTypeRegistry
import com.intellij.framework.detection.FacetBasedFrameworkDetector
import com.intellij.framework.detection.impl.FrameworkDetectorRegistry
import com.intellij.ide.util.frameworkSupport.FrameworkSupportConfigurable
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModelImpl
import com.intellij.ide.util.frameworkSupport.FrameworkSupportUtil
import com.intellij.ide.util.newProjectWizard.OldFrameworkSupportProviderWrapper
import com.intellij.ide.util.newProjectWizard.impl.FrameworkSupportCommunicator
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.IdeaModifiableModelsProvider
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainerFactory
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.PsiTestCase
import com.intellij.testFramework.PsiTestUtil
import java.util.ArrayList
import org.eclipse.xtend.core.idea.facet.XtendFacetType
import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtend.core.idea.lang.XtendLanguage

/**
 * @author dhuebner - Initial contribution and API
 */
class XtendSupportConfigurableTest extends PsiTestCase {

	def testPlainJavaOutputConfiguration_01() {
		val manager = ModuleRootManager.getInstance(myModule)
		assertEquals(0, manager.contentRoots.size)
		addFrameworkSupport(myModule)
		assertEquals(1, manager.contentRoots.size)
		val facet = FacetManager.getInstance(myModule).getFacetsByType(XtendFacetType.TYPEID).head
		assertNotNull(facet)

		val xtendConfig = facet.configuration.state
		assertTrue(xtendConfig.outputDirectory.endsWith("xtend-gen"))
		assertTrue(xtendConfig.testOutputDirectory.endsWith("xtend-gen"))

		assertEquals(1, manager.contentEntries.head.sourceFolders.filter [
			val urlToCheck = (it.file.path).replace("file://", '')
			(xtendConfig.outputDirectory) == urlToCheck && !it.testSource
		].size)
	}

	def testPlainJavaOutputConfiguration_02() {
		val module = WriteCommandAction.<Module>runWriteCommandAction(project) [
			val module = createModule("module1")
			val moduleRoot = VfsUtil.createDirectoryIfMissing(module.project.baseDir, module.name)
			val srcDirVf = VfsUtil.createDirectoryIfMissing(moduleRoot, "src/main/java")
			val testDirVf = VfsUtil.createDirectoryIfMissing(moduleRoot, "src/test/java")
			PsiTestUtil.addContentRoot(module, moduleRoot)
			PsiTestUtil.addSourceRoot(module, srcDirVf)
			PsiTestUtil.addSourceRoot(module, testDirVf, true)
			return module
		]

		val manager = ModuleRootManager.getInstance(module)

		val srcFolders = manager.getSourceRoots(true)
		assertEquals(2, srcFolders.size)
		addFrameworkSupport(module)
		val facet = FacetManager.getInstance(module).getFacetsByType(XtendFacetType.TYPEID).head
		assertNotNull(facet)

		val xtendConfig = facet.configuration.state
		assertFalse(xtendConfig.outputDirectory == xtendConfig.testOutputDirectory)

		assertTrue(xtendConfig.outputDirectory.endsWith("module1/src/main/xtend-gen"))
		assertTrue(xtendConfig.testOutputDirectory.endsWith("module1/src/test/xtend-gen"))
		val sourceRoots = ModuleRootManager.getInstance(module).getSourceRoots(true)
		assertEquals(1, sourceRoots.filter [
			val urlToCheck = (path).replace("file://", '')
			(xtendConfig.outputDirectory) == urlToCheck
		].size)

		assertEquals(1, sourceRoots.filter [
			val urlToCheck = (path).replace("file://", '')
			(xtendConfig.testOutputDirectory) == urlToCheck
		].size)
	}

	def testPlainJavaOutputConfiguration_03() {
		// Bug 479332 - [idea] Exception after applying framework support in Android project 
		val manager = ModuleRootManager.getInstance(myModule)
		assertEquals(0, manager.contentRoots.size)
		addFrameworkSupportUsingDetector(myModule)
		assertEquals(1, manager.contentRoots.size)

		val facet = FacetManager.getInstance(myModule).getFacetsByType(XtendFacetType.TYPEID).head
		assertNotNull(facet)

		val xtendConfig = facet.configuration.state
		assertTrue(xtendConfig.outputDirectory.endsWith("xtend-gen"))
		assertTrue(xtendConfig.testOutputDirectory.endsWith("xtend-gen"))
	
		assertEquals(1, manager.contentEntries.head.sourceFolders.filter [
			val urlToCheck = (it.file.path).replace("file://", '')
			(xtendConfig.outputDirectory) == urlToCheck && !it.testSource
		].size)
	}

	def protected void addFrameworkSupportUsingDetector(Module moduleToHandle) {
		new WriteCommandAction.Simple(getProject()) {

			override protected run() throws Throwable {
				createContentRoot(moduleToHandle)
				val modifiableModelsProvider = new IdeaModifiableModelsProvider()
				val model = modifiableModelsProvider.getFacetModifiableModel(moduleToHandle)
				try {
					val facetType = FacetTypeRegistry.instance.findFacetType(XtendFacetType.TYPEID.toString)
					val facetConfiguration = facetType.createDefaultConfiguration
					val detId = FrameworkDetectorRegistry.instance.getDetectorIds(XtendFileType.INSTANCE).head
					val detector = FrameworkDetectorRegistry.instance.
						getDetectorById(detId) as FacetBasedFrameworkDetector
					val facet = FacetManager.getInstance(moduleToHandle).createFacet(facetType,
						facetType.getDefaultFacetName(), facetConfiguration, null)
					model.addFacet(facet)
					modifiableModelsProvider.commitFacetModifiableModel(moduleToHandle, model)
					val rootModel = modifiableModelsProvider.getModuleModifiableModel(moduleToHandle)
					detector.setupFacet(facet, rootModel)
					modifiableModelsProvider.commitModuleModifiableModel(rootModel)
				} finally {
					model.commit()
				}
			}
		}.execute().throwException()
	}

	protected def createContentRoot(Module moduleToHandle) {
		val VirtualFile root = getVirtualFile(createTempDir("contentRoot"))
		PsiTestUtil.addContentRoot(moduleToHandle, root)
	}

	def protected void addFrameworkSupport(Module moduleToHandle) {
		new WriteCommandAction.Simple(getProject()) {

			override protected run() throws Throwable {
				createContentRoot(moduleToHandle)

				val model = ModuleRootManager.getInstance(moduleToHandle).getModifiableModel()
				val provider = FrameworkSupportUtil.findProvider(XtendLanguage.INSTANCE.ID,
					FrameworkSupportUtil.getAllProviders());
				val myFrameworkSupportModel = new FrameworkSupportModelImpl(project, "",
					LibrariesContainerFactory.createContainer(project))
				val configurable = provider.createConfigurable(myFrameworkSupportModel)
				try {
					var selectedConfigurables = new ArrayList<FrameworkSupportConfigurable>()
					configurable.addSupport(moduleToHandle, model,
						new IdeaModifiableModelsProvider())
					if (configurable instanceof OldFrameworkSupportProviderWrapper.FrameworkSupportConfigurableWrapper) {
						selectedConfigurables.add(configurable.getConfigurable())
					}
					for (FrameworkSupportCommunicator communicator : FrameworkSupportCommunicator.EP_NAME.
						getExtensions()) {
						communicator.onFrameworkSupportAdded(moduleToHandle, model, selectedConfigurables,
							myFrameworkSupportModel)
					}
				} finally {
					model.commit()
					if (!Disposer.isDisposed(configurable))
						Disposer.dispose(configurable)
				}
			}
		}.execute().throwException()
	}
}