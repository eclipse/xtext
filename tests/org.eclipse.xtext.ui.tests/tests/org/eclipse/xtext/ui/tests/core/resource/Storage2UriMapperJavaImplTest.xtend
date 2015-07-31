/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.core.resource

import java.util.Map
import org.eclipse.core.resources.IStorage
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.TextFile
import org.eclipse.xtext.ui.resource.JarEntryLocator
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl.PackageFragmentRootData
import org.eclipse.xtext.ui.resource.UriValidator
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class Storage2UriMapperJavaImplTest extends Assert {

	Storage2UriMapperJavaImpl storage2UriMapperJava

	@Before
	def void setUp() {
		this.storage2UriMapperJava = createFreshStorage2UriMapper
		JavaCore.addElementChangedListener(storage2UriMapperJava)
	}

	@After
	def void tearDown() {
		JavaCore.removeElementChangedListener(storage2UriMapperJava)
		cleanWorkspace
	}
	
	def protected Storage2UriMapperJavaImpl createFreshStorage2UriMapper() {
		new Storage2UriMapperJavaImpl => [
			uriValidator = new UriValidator() {
				override boolean isPossiblyManaged(IStorage storage) {
					return "indexed".equals(storage.getFullPath().getFileExtension()) 
				}
				override boolean isValid(URI uri, IStorage storage) {
					return "indexed".equals(storage.getFullPath().getFileExtension()) 
				}
			}
			locator = new JarEntryLocator()
			workspace = ResourcesPlugin.workspace
		]
	}


	@Test
	def void testOnClasspathChange() {
		assertEquals("" + cachedPackageFragmentRootData, 0, cachedPackageFragmentRootData.size)

		val project = createJavaProject("testProject")
		
		val sizeBefore = cachedPackageFragmentRootData.size
		// it should contain all the jars from JDK now
		assertTrue(sizeBefore > 0)
		assertNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		val file = project.createJar
		addJarToClasspath(project, file)
		
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore + 1, cachedPackageFragmentRootData.size)
		assertNotNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		cachedPackageFragmentRootData.entrySet.forEach [
			assertEquals(key, 1, value.associatedRoots.size)
			val head = value.associatedRoots.keySet.head
			assertTrue(head, head.startsWith('=testProject/'))
		]

		val project2 = createJavaProject('testProject2')
		addJarToClasspath(project2, file)
		
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore + 1, cachedPackageFragmentRootData.size)
		assertNotNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		cachedPackageFragmentRootData.entrySet.forEach [
			assertEquals(key, 2, value.associatedRoots.size)
			val head = value.associatedRoots.keySet.head
			assertTrue(head, head.startsWith('=testProject/') || head.startsWith('=testProject2/'))
			val head2 = value.associatedRoots.keySet.tail.head
			assertTrue(head2, head.startsWith('=testProject/') || head.startsWith('=testProject2/'))
		]

		removeJarFromClasspath(project, file);
		
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore + 1, cachedPackageFragmentRootData.size)
		assertNotNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		cachedPackageFragmentRootData.entrySet.forEach [
			if (key.contains("foo.jar")) {
				assertEquals(key, 1, value.associatedRoots.size)
				val head = value.associatedRoots.keySet.head
				assertTrue(head, head.startsWith('=testProject2/'))
			} else {
				assertEquals(key, 2, value.associatedRoots.size)
				val head = value.associatedRoots.keySet.head
				assertTrue(head, head.startsWith('=testProject/') || head.startsWith('=testProject2/'))
				val head2 = value.associatedRoots.keySet.tail.head
				assertTrue(head2, head.startsWith('=testProject/') || head.startsWith('=testProject2/'))
			}
		]

		removeJarFromClasspath(project2, file);
		
		
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore, cachedPackageFragmentRootData.size)
		assertNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		cachedPackageFragmentRootData.entrySet.forEach [
			assertEquals(key, 2, value.associatedRoots.size)
			val head = value.associatedRoots.keySet.head
			assertTrue(head, head.startsWith('=testProject/') || head.startsWith('=testProject2/'))
			val head2 = value.associatedRoots.keySet.tail.head
			assertTrue(head2, head.startsWith('=testProject/') || head.startsWith('=testProject2/'))
		]
	}

	@Test
	def void testOnCloseOpenRemoveProject() {
		val project = createJavaProject("testProject")
		val project2 = createJavaProject("testProject2")
		
		val sizeBefore = cachedPackageFragmentRootData.size

		val file = project.createJar
		addJarToClasspath(project, file)
		addJarToClasspath(project2, file)
		assertBothProjects(sizeBefore)

		project2.project.close(monitor)
		assertFirstProject(sizeBefore)

		project.project.close(monitor)
		assertNonProjects

		project.project.open(monitor)
		assertFirstProject(sizeBefore)

		project2.project.open(monitor)
		assertBothProjects(sizeBefore)

		project.project.delete(true, monitor)
		project2.project.delete(true, monitor)
		assertNonProjects
	}

	def assertNonProjects() {
		assertEquals("" + cachedPackageFragmentRootData, 0, cachedPackageFragmentRootData.size)
	}

	def assertFirstProject(int sizeBefore) {
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore + 1, cachedPackageFragmentRootData.size)
		assertNotNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])
		cachedPackageFragmentRootData.entrySet.forEach [
			assertEquals(key, 1, value.associatedRoots.size)
			val head = value.associatedRoots.keySet.head
			assertTrue(head, head.startsWith('=testProject/'))
		]
	}

	def assertBothProjects(int sizeBefore) {
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore + 1, cachedPackageFragmentRootData.size)
		assertNotNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		cachedPackageFragmentRootData.entrySet.forEach [
			assertEquals(key, 2, value.associatedRoots.size)
			val head = value.associatedRoots.keySet.head
			assertTrue(head, head.startsWith('=testProject/') || head.startsWith('=testProject2/'))
			val head2 = value.associatedRoots.keySet.last
			assertTrue(head2, head.startsWith('=testProject/') || head.startsWith('=testProject2/'))
		]
	}

	def createJar(IJavaProject project) {
		project.project.getFile("foo.jar") => [
			create(
				jarInputStream(
					new TextFile("foo/bar.indexed", "//empty"),
					new TextFile("META-INF/MANIFEST.MF", "Manifest-Version: 1.0\nBundle-SymbolicName: hubba.bubba\n")
				), true, monitor)
		]
	}

	def getCachedPackageFragmentRootData() {
		(storage2UriMapperJava.class.declaredFields.findFirst[name == "cachedPackageFragmentRootData"] => [
			accessible = true
		]).get(storage2UriMapperJava) as Map<String, PackageFragmentRootData>
	}

}
