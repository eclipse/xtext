/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.core.resource

import com.google.inject.Inject
import java.util.Map
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.TextFile
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl.PackageFragmentRootData
import org.eclipse.xtext.ui.tests.Activator
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

	val static INJECTOR = Activator.instance.getInjector(Activator.ORG_ECLIPSE_XTEXT_UI_TESTS_TESTLANGUAGE)

	@Inject
	Storage2UriMapperJavaImpl storage2UriMapperJava

	@Before
	def void setUp() {
		INJECTOR.injectMembers(this)
		storage2UriMapperJava.initializeCache
	}

	@After
	def void tearDown() {
		cleanWorkspace
	}

	@Test
	def void testOnClasspathChange() {
		val cachedPackageFragmentRootData = cachedPackageFragmentRootData
		assertEquals("" + cachedPackageFragmentRootData, 0, cachedPackageFragmentRootData.size)

		val project = createJavaProject("testProject")

		Thread.sleep(200);
		val sizeBefore = cachedPackageFragmentRootData.size
		assertFalse(sizeBefore == 0)
		assertNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		val file = project.createJar
		addJarToClasspath(project, file)

		Thread.sleep(200);
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore + 1, cachedPackageFragmentRootData.size)
		assertNotNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		cachedPackageFragmentRootData.entrySet.forEach [
			assertEquals(key, 1, value.associatedRoots.size)
			val head = value.associatedRoots.keySet.head
			assertTrue(head, head.startsWith('=testProject/'))
		]

		val project2 = createJavaProject('testProject2')
		addJarToClasspath(project2, file)

		Thread.sleep(200);
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

		Thread.sleep(200);
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
		
		Thread.sleep(200);
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

		Thread.sleep(200);
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
		Thread.sleep(200);
		assertEquals("" + cachedPackageFragmentRootData, 0, cachedPackageFragmentRootData.size)
	}

	def assertFirstProject(int sizeBefore) {
		Thread.sleep(200);
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore + 1, cachedPackageFragmentRootData.size)
		assertNotNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])
		cachedPackageFragmentRootData.entrySet.forEach [
			assertEquals(key, 1, value.associatedRoots.size)
			val head = value.associatedRoots.keySet.head
			assertTrue(head, head.startsWith('=testProject/'))
		]
	}

	def assertBothProjects(int sizeBefore) {
		Thread.sleep(200);
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
