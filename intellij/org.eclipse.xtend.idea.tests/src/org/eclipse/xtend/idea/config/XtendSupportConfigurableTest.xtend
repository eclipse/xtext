/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.config

import com.intellij.facet.FacetManager
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider
import com.intellij.ide.util.frameworkSupport.FrameworkSupportConfigurable
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModelImpl
import com.intellij.ide.util.frameworkSupport.FrameworkSupportUtil
import com.intellij.ide.util.newProjectWizard.OldFrameworkSupportProviderWrapper
import com.intellij.ide.util.newProjectWizard.impl.FrameworkSupportCommunicator
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.IdeaModifiableModelsProvider
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainerFactory
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.PsiTestCase
import com.intellij.testFramework.PsiTestUtil
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.core.idea.facet.XtendFacetType
import org.eclipse.xtend.core.idea.lang.XtendLanguage

/**
 * @author dhuebner - Initial contribution and API
 */
class XtendSupportConfigurableTest extends PsiTestCase {

	override protected setUp() throws Exception {
		super.setUp()
	}

	def testPlainJavaOutputConfiguration_01() {
		addSupport(myModule)
		val facet = FacetManager.getInstance(myModule).getFacetsByType(XtendFacetType.TYPEID).head
		assertNotNull(facet)

		val manager = ModuleRootManager.getInstance(myModule)
		val xtendConfig = facet.configuration.state
		assertTrue(xtendConfig.outputDirectory.endsWith("xtend-gen"))
		assertTrue(xtendConfig.testOutputDirectory.endsWith("xtend-gen"))

		assertEquals(1, manager.contentEntries.head.sourceFolders.filter [
			val urlToCheck = (it.file.path).replace("file://", '')
			(xtendConfig.outputDirectory) == urlToCheck && !it.testSource
		].size)
	}

	def testPlainJavaOutputConfiguration_02() {
		val module = createModule("module1")
		val moduleRoot = VfsUtil.createDirectoryIfMissing(module.project.baseDir, module.name)
		val srcDirVf = VfsUtil.createDirectoryIfMissing(moduleRoot, "src/main/java")
		val testDirVf = VfsUtil.createDirectoryIfMissing(moduleRoot, "src/test/java")
		PsiTestUtil.addContentRoot(module, moduleRoot)
		PsiTestUtil.addSourceRoot(module, srcDirVf)
		PsiTestUtil.addSourceRoot(module, testDirVf, true)

		val manager = ModuleRootManager.getInstance(module)

		val srcFolders = manager.getSourceRoots(true)
		assertEquals(2, srcFolders.size)
		addSupport(module)
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

	def protected void addSupport(Module module) {
		new WriteCommandAction.Simple(getProject()) {

			override protected run() throws Throwable {
				val VirtualFile root = getVirtualFile(createTempDir("contentRoot"))
				PsiTestUtil.addContentRoot(module, root)
				val ModifiableRootModel model = ModuleRootManager.getInstance(module).getModifiableModel()
				val FrameworkSupportInModuleProvider provider = FrameworkSupportUtil.findProvider(
					XtendLanguage.INSTANCE.ID, FrameworkSupportUtil.getAllProviders());
				val myFrameworkSupportModel = new FrameworkSupportModelImpl(project, "",
					LibrariesContainerFactory.createContainer(project))
				val FrameworkSupportInModuleConfigurable configurable = provider.createConfigurable(
					myFrameworkSupportModel)
				try {
					var List<FrameworkSupportConfigurable> selectedConfigurables = new ArrayList<FrameworkSupportConfigurable>()
					val IdeaModifiableModelsProvider modelsProvider = new IdeaModifiableModelsProvider()

					configurable.addSupport(module, model,
						modelsProvider)
					if (configurable instanceof OldFrameworkSupportProviderWrapper.FrameworkSupportConfigurableWrapper) {
						selectedConfigurables.add(configurable.getConfigurable())
					}
					for (FrameworkSupportCommunicator communicator : FrameworkSupportCommunicator.EP_NAME.
						getExtensions()) {
						communicator.onFrameworkSupportAdded(module, model, selectedConfigurables,
							myFrameworkSupportModel)
					}
				} finally {
					model.commit()
					Disposer.dispose(configurable)
				}
			}
		}.execute().throwException()
	}
}