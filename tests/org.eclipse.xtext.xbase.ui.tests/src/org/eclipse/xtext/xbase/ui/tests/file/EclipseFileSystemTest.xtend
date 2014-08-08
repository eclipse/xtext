/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.file

import java.io.File
import java.io.FileInputStream
import org.eclipse.core.internal.resources.ProjectDescription
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.xbase.tests.file.JavaIoFileSystemTest
import org.eclipse.xtext.xbase.ui.file.EclipseFileSystemSupportImpl
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*
import org.junit.After
import java.util.Set

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class EclipseFileSystemTest extends JavaIoFileSystemTest {

	private Set<String> knownProjects = newHashSet

	@Before override void setUp() {
		for(p: ResourcesPlugin.workspace.root.projects) {
			knownProjects.add(p.name)
		}
		
		val root = ResourcesPlugin.workspace.root
		val project = root.getProject('foo')
		if (project.exists) {
			fail("Project 'foo' should not exist yet")
		}
		project.create(null)
		project.open(null)
		fs = new EclipseFileSystemSupportImpl => [
			workspaceRoot = root
			encodingProvider = new IEncodingProvider.Runtime()
		]
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

	// overridden to make the launch config work.
	@Test override testMakeandDeleteFile() {
		super.testMakeandDeleteFile()
	}
	
	// in temp folders, there's .createdBy but not in Eclipse folders
	@Test override void testGetWorkspaceChildren() {
		// changed expectation from 2 to 1
		assertEquals(Path.ROOT.children.join('[', ', ', ']') [ it.segments.join('.') ], 1, Path.ROOT.children.size)

		val path = new Path("/bar")
		path.mkdir
		assertTrue(path.exists)
		// changed expectation from 3 to 2		
		assertEquals(Path.ROOT.children.join('[', ', ', ']') [ it.segments.join('.') ], 2, Path.ROOT.children.size)
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
