/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import java.io.File
import java.io.FileInputStream
import org.eclipse.xtend.core.macro.JavaIOFileSystemSupport
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.workspace.FileWorkspaceConfig
import org.junit.Before
import org.junit.Rule
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class JavaIoFileSystemTest {
	
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder()
	
	protected extension MutableFileSystemSupport fs
	
	@Before def void setUp() {
		val tempDir = temporaryFolder.newFolder()
		fs = new JavaIOFileSystemSupport => [
			projectInformationProvider = [context| 
				new FileWorkspaceConfig(tempDir) => [
					addProject("foo") => [
						addSourceFolder("src")
					]
					addProject("bar") => [
						addSourceFolder("src")
					]
				]
			]
			encodingProvider = new IEncodingProvider.Runtime()
		]
		new Path("/foo").mkdir
	}
	
	@Test def void testMakeandDeleteFolder() {
		val someFolder = new Path('/foo/bar')
		assertFalse(someFolder.exists)
		assertFalse(someFolder.isFile)
		assertFalse(someFolder.isFolder)
		someFolder.mkdir
		assertFalse(someFolder.isFile)
		assertTrue(someFolder.isFolder)
		assertTrue(someFolder.exists)
		someFolder.delete
		assertFalse(someFolder.exists)
	}
	
	@Test def void testMakeandDeleteFile() {
		val path = new Path('/foo/src/my/pack/Foo.txt')
		assertFalse(path.exists)
		path.contents = "Hello Foo"
		assertTrue(path.exists)
		assertEquals("Hello Foo",path.contents)
		
		assertTrue(path.isFile)
		assertFalse(path.isFolder)
		
		path.delete
		assertFalse(path.exists)
		assertFalse(path.isFile)
		assertFalse(path.isFolder)
	}
	
	@Test def void testModificationStamp() {
		val path = new Path('/foo/src/my/pack/Foo.txt')
		assertEquals(0L, path.lastModification)
		
		path.contents = "Hello Foo"
		val mod = path.lastModification
		assertEquals("Hello Foo", path.contents)
		
		assertEquals(mod, path.lastModification)
		Thread.sleep(1000)
		path.contents = "Hello Foo"
		assertTrue(mod < path.lastModification)
	}
	
	@Test def void testGetWorkspaceChildren() {
		// in a temp folders we have a '.createdBy' file.
		assertEquals(Path.ROOT.children.join('[', ', ', ']') [ it.segments.join('.') ], 2, Path.ROOT.children.size)
		
		val path = new Path("/bar")
		path.mkdir
		assertTrue(path.exists)
		
		assertEquals(Path.ROOT.children.join('[', ', ', ']') [ it.segments.join('.') ], 3, Path.ROOT.children.size)
	}
	
	@Test def void testGetProjectChildren() {
		val projectFolder = new Path('/foo')
		assertTrue(projectFolder.exists)
		val expectedChildrenSize = projectFolder.children.size + 1
		
		new Path("/foo/Foo.text").contents = "Hello Foo"
		assertEquals(expectedChildrenSize, projectFolder.children.size)
	}
	
	@Test def void testGetFolderChildren() {
		val folder = new Path('/foo/bar')
		assertFalse(folder.exists)
		
		folder.mkdir
		assertTrue(folder.exists)
		assertEquals(0, folder.children.size)
		
		new Path("/foo/bar/Foo.text").contents = "Hello Foo"
		assertEquals(1, folder.children.size)
	}
	
	@Test def void testGetFileChildren() {
		val file = new Path("/foo/bar/Foo.text")
		assertFalse(file.exists)
		assertEquals(0, file.children.size)
		 
		file.contents = "Hello Foo"
		assertTrue(file.exists)
		assertEquals(0, file.children.size)
	}
	
	@Test def void testGetURI() {
		val file = new Path("/foo/bar/Foo.text")
		assertFalse(file.exists)
		assertNotNull(file.toURI)

		file.contents = "Hello Foo"
		assertTrue(file.exists)
		assertNotNull(file.toURI)
		
		val javaIoFile = new File(file.toURI)
		assertTrue(javaIoFile.exists)
		
		val data = newByteArrayOfSize(javaIoFile.length as int)
		val fis = new FileInputStream(javaIoFile)
		fis.read(data)
		fis.close
		
		assertEquals("Hello Foo", new String(data))
	}

}
