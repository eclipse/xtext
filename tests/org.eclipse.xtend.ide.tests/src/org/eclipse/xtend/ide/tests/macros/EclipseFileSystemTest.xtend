/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.macros

import com.google.inject.Inject
import com.google.inject.Provider
import java.io.File
import java.io.FileInputStream
import java.util.Set
import org.eclipse.core.internal.resources.ProjectDescription
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.xtend.core.tests.macro.JavaIoFileSystemTest
import org.eclipse.xtend.ide.macro.EclipseFileSystemSupportImpl
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import org.eclipse.core.resources.IProject

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class EclipseFileSystemTest extends JavaIoFileSystemTest {

	private Set<String> knownProjects = newHashSet
	
	@Inject IResourceSetProvider resourceSetProvider
	
	@Inject Provider<EclipseFileSystemSupportImpl> fileSystemSupportProvider

	@Before override void setUp() {
		for(p: ResourcesPlugin.workspace.root.projects) {
			knownProjects.add(p.name)
		}
		
		val project = createProject('foo')
		val fileSystemSupport = fileSystemSupportProvider.get
		fileSystemSupport.context = resourceSetProvider.get(project)  
		fs = fileSystemSupport
	}
	
	override IProject createProject(String name) {
		val root = ResourcesPlugin.workspace.root
		val project = root.getProject(name)
		if (project.exists) {
			fail("Project 'foo' should not exist yet")
		}
		project.create(null)
		project.open(null)
		project
	}
	
	@After def void tearDown() {
		val root = ResourcesPlugin.workspace.root
		for(p: root.projects) {
			if (!knownProjects.remove(p.name)) {
				p.delete(true, null)
			}
		}
		assertTrue(knownProjects.empty)
	}
	
	@Test
	@Ignore('PlatformResourceURIHandlerImpl does not allow to delete folders')
	override testMakeAndDeleteFolder() {
		super.testMakeAndDeleteFolder()
	}

	// overridden to make the launch config work.
	@Test override testMakeAndDeleteFile() {
		super.testMakeAndDeleteFile()
	}

	@Test def void testGetURIForImportedProject() {
		val root = ResourcesPlugin.workspace.root

		val description = new ProjectDescription()
		description.name = "bar"
		description.location = root.location.append('foo/bar')

		val project = root.getProject('bar')
		project.create(description, null)
		project.open(null)

		val file = new Path("/bar/Foo.text")
		assertFalse(file.exists)
		assertNotNull(file.toURI)

		file.contents = "Hello Foo"
		assertTrue(file.exists)
		val uri = file.toURI
		assertNotNull(uri)
		assertTrue('' + uri, uri.toString.endsWith('/foo/bar/Foo.text'))

		val javaIoFile = new File(uri)
		assertTrue(javaIoFile.exists)

		val data = newByteArrayOfSize(javaIoFile.length as int)
		val fis = new FileInputStream(javaIoFile)
		fis.read(data)
		fis.close

		assertEquals("Hello Foo", new String(data))
	}

}
