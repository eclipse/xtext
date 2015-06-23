/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.sdomain.idea.tests.containers

import com.google.inject.Inject
import com.intellij.openapi.roots.ModuleRootModificationUtil
import com.intellij.testFramework.PlatformTestCase
import com.intellij.testFramework.builders.EmptyModuleFixtureBuilder
import com.intellij.testFramework.fixtures.IdeaTestFixtureFactory
import com.intellij.testFramework.fixtures.JavaCodeInsightTestFixture
import com.intellij.testFramework.fixtures.JavaTestFixtureFactory
import java.io.File
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider

class ResolveScopeBasedContainerManagerTest extends PlatformTestCase {
	
	@Inject
	IContainer.Manager containerManager
	
	@Inject
	ResourceDescriptionsProvider resourceDescriptionsProvider
	
	BaseXtextFile[] files

	JavaCodeInsightTestFixture myFixture
	
	protected def String getTestDataPath() '''./testData/containers'''

	override protected setUp() throws Exception {
		super.setUp

		val projectBuilder = IdeaTestFixtureFactory.getFixtureFactory.createFixtureBuilder(name)
		
		myFixture = JavaTestFixtureFactory.fixtureFactory.createCodeInsightFixture(projectBuilder.fixture)
		myFixture.testDataPath = testDataPath
		
		val tempDirPath = myFixture.tempDirPath

		val moduleFixtureBuilder = projectBuilder.addModule(EmptyModuleFixtureBuilder)
		new File('''«tempDirPath»/module''').mkdir
		moduleFixtureBuilder.addSourceContentRoot('''«tempDirPath»/module''')
		
		val module2FixtureBuilder = projectBuilder.addModule(EmptyModuleFixtureBuilder)
		new File('''«tempDirPath»/module2''').mkdir
		module2FixtureBuilder.addSourceContentRoot('''«tempDirPath»/module2''')
		
		myFixture.setUp
		
		val module = moduleFixtureBuilder.fixture.module
		val module2 = module2FixtureBuilder.fixture.module
		ModuleRootModificationUtil.addDependency(module, module2)
		
		files = myFixture.configureByFiles(
			'/module/file1.sdomain',
			'/module/file2.sdomain',
			'/module2/file3.sdomain'
		).filter(BaseXtextFile)
		
		files.head.xtextLanguage.injectMembers(this)
	}
	
	override protected tearDown() throws Exception {
		files = null
		myFixture.tearDown
		myFixture = null
		super.tearDown
	}
	
	def void testGetContainer_01() {
		val description = new URIBasedTestResourceDescription(files.head.URI)
		val resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(files.head.resource)
		val container = containerManager.getContainer(description, resourceDescriptions)
		assertEquals(2, container.resourceDescriptions.size)
		assertNotNull(container.getResourceDescription(files.head.URI))
		assertNotNull(container.getResourceDescription(files.get(1).URI))
		assertNull(container.getResourceDescription(files.last.URI))
	}
	
	def void testGetContainer_02() {
		val description = new URIBasedTestResourceDescription(files.last.URI)
		val resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(files.last.resource)
		val container = containerManager.getContainer(description, resourceDescriptions)
		assertEquals(1, container.resourceDescriptions.size)
		assertNull(container.getResourceDescription(files.head.URI))
		assertNull(container.getResourceDescription(files.get(1).URI))
		assertNotNull(container.getResourceDescription(files.last.URI))
	}
	
	def void testGetVisibleContainers_01() {
		val description = new URIBasedTestResourceDescription(files.head.URI)
		val resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(files.head.resource)
		val visibleContainers = containerManager.getVisibleContainers(description, resourceDescriptions)
		assertEquals(2, visibleContainers.size)
		assertEquals(2, visibleContainers.head.resourceDescriptions.size)
		assertEquals(1, visibleContainers.get(1).resourceDescriptions.size)
		assertNotNull(visibleContainers.head.getResourceDescription(files.head.URI))
		assertNotNull(visibleContainers.head.getResourceDescription(files.get(1).URI))
		assertNotNull(visibleContainers.get(1).getResourceDescription(files.last.URI))
	}
	
	def void testGetVisibleContainers_02() {
		val description = new URIBasedTestResourceDescription(files.last.URI)
		val resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(files.last.resource)
		val visibleContainers = containerManager.getVisibleContainers(description, resourceDescriptions)
		assertEquals(1, visibleContainers.size)
		assertEquals(1, visibleContainers.head.resourceDescriptions.size)
		assertNotNull(visibleContainers.head.getResourceDescription(files.last.URI))
	}

}
