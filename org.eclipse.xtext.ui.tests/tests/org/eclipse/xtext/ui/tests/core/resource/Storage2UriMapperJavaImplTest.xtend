/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.core.resource

import java.lang.reflect.InvocationTargetException
import java.util.Map
import org.eclipse.core.resources.IStorage
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.eclipse.xtext.ui.resource.JarEntryLocator
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl.PackageFragmentRootData
import org.eclipse.xtext.ui.resource.UriValidator
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.TextFile
import org.eclipse.xtext.ui.util.JavaProjectClasspathChangeAnalyzer
import org.eclipse.xtext.ui.workspace.WorkspaceLockAccess
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*
import static org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.*

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
	
	private def isExpectedJRESize(int size) {
		return switch(size) {
			case 1: /* java8 */ true
			case 63: /* java9 */ true
			case 49: /* java10 + java11 */ true
			default: false
		}
	}
	
	private def isExpectedJRESize(int size, int multiplier) {
		return (size / multiplier).isExpectedJRESize && size / multiplier * multiplier == size
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
			workspaceLockAccess = new WorkspaceLockAccess
			javaProjectClasspathChangeAnalyzer = new JavaProjectClasspathChangeAnalyzer
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
			assertTrue(value.associatedRoots.size + ' / ' + key, value.associatedRoots.size.isExpectedJRESize)
			val head = value.associatedRoots.keySet.head
			assertTrue(head, head.startsWith('=testProject/'))
		]

		val project2 = createJavaProject('testProject2')
		addJarToClasspath(project2, file)
		
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore + 1, cachedPackageFragmentRootData.size)
		assertNotNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		cachedPackageFragmentRootData.entrySet.forEach [
			assertTrue(value.associatedRoots.size + ' / ' + key, value.associatedRoots.size.isExpectedJRESize(2))
			val msg = value.associatedRoots.keySet.join('\n')
			assertTrue(msg, value.associatedRoots.keySet.exists[ it.startsWith('=testProject/')])
			assertTrue(msg, value.associatedRoots.keySet.exists[ it.startsWith('=testProject2/')])
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
				assertTrue(value.associatedRoots.size + "/" + key, value.associatedRoots.size.isExpectedJRESize(2))
				val msg = value.associatedRoots.keySet.join('\n')
				assertTrue(msg, value.associatedRoots.keySet.exists[ it.startsWith('=testProject/')])
				assertTrue(msg, value.associatedRoots.keySet.exists[ it.startsWith('=testProject2/')])
			}
		]

		removeJarFromClasspath(project2, file);
		
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore, cachedPackageFragmentRootData.size)
		assertNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		cachedPackageFragmentRootData.entrySet.forEach [
			assertTrue(value.associatedRoots.size + "/" + key, value.associatedRoots.size.isExpectedJRESize(2))
			val msg = value.associatedRoots.keySet.join('\n')
			assertTrue(msg, value.associatedRoots.keySet.exists[ it.startsWith('=testProject/')])
			assertTrue(msg, value.associatedRoots.keySet.exists[ it.startsWith('=testProject2/')])
		]
	}

	@Test
	def void testOnCloseOpenRemoveProject() {
		assertEquals(0, cachedPackageFragmentRootData.size)
		
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
	
	@Test
	def void testOnRemoveTwoProjects() {
		assertEquals(0, cachedPackageFragmentRootData.size)
		
		val project = createJavaProject("testProject")
		val project2 = createJavaProject("testProject2")
		
		val sizeBefore = cachedPackageFragmentRootData.size
		val file = project.createJar
		addJarToClasspath(project, file)
		addJarToClasspath(project2, file)
		assertBothProjects(sizeBefore)

		val op = new WorkspaceModifyOperation() {
			
			override protected execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				project.project.delete(true, monitor)
				project2.project.delete(true, monitor)
			}
			
		}
		op.run(monitor);
		assertNonProjects
	}

	def assertNonProjects() {
		assertEquals("" + cachedPackageFragmentRootData, 0, cachedPackageFragmentRootData.size)
	}

	def assertFirstProject(int sizeBefore) {
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore + 1, cachedPackageFragmentRootData.size)
		assertNotNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])
		cachedPackageFragmentRootData.entrySet.forEach [
			val java9OrNewer = value.associatedRoots.values.exists[ it.class.simpleName == 'JrtPackageFragmentRoot' ]
			if (java9OrNewer) {
				assertTrue(value.associatedRoots.size + ' / ' + key, #[44 /* java11 */, 49, 63 /* java9 */].contains(value.associatedRoots.size))
			} else {
				assertEquals(key, 1, value.associatedRoots.size)
			}
			val head = value.associatedRoots.keySet.head
			assertTrue(head, head.startsWith('=testProject/'))
		]
	}

	def assertBothProjects(int sizeBefore) {
		assertEquals("" + cachedPackageFragmentRootData, sizeBefore + 1, cachedPackageFragmentRootData.size)
		assertNotNull(cachedPackageFragmentRootData.keySet.findFirst[contains("foo.jar")])

		cachedPackageFragmentRootData.entrySet.forEach [
			assertTrue(value.associatedRoots.size + "/" + key, value.associatedRoots.size.isExpectedJRESize(2))
			val msg = value.associatedRoots.keySet.join('\n')
			assertTrue(msg, value.associatedRoots.keySet.exists[ it.startsWith('=testProject/')])
			assertTrue(msg, value.associatedRoots.keySet.exists[ it.startsWith('=testProject2/')])
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
