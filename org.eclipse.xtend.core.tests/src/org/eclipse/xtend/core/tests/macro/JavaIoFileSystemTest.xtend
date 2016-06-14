/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream
import org.eclipse.xtend.core.macro.JavaIOFileSystemSupport
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.workspace.FileProjectConfig
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
			projectConfigProvider = [new FileProjectConfig(new File(tempDir,"foo")) => [
				addSourceFolder("src")
			]]
			encodingProvider = new IEncodingProvider.Runtime()
			context = new XtextResourceSet
		]
		createProject('foo')
	}

	protected def Object createProject(String name) {
		val file = new File(new Path(name).toURI)
		file.mkdirs
		return file
	}

	@Test def void testMakeAndDeleteFolder() {
		val someFolder = new Path('/foo/bar')
		val someFile = someFolder.append('Foo.txt')
		assertFalse(someFolder.exists)
		assertFalse(someFolder.isFile)
		assertFalse(someFolder.isFolder)
		someFile.contents = "Hello Foo"
		assertFalse(someFolder.isFile)
		assertTrue(someFolder.isFolder)
		assertTrue(someFolder.exists)
		someFolder.delete
		assertTrue(someFolder.exists)
		someFile.delete
		someFolder.delete
		assertFalse(someFolder.exists)
	}

	@Test def void testMakeAndDeleteFile() {
		val path = new Path('/foo/src/my/pack/Foo.txt')
		assertFalse(path.exists)
		path.contents = "Hello Foo"
		assertTrue(path.exists)
		assertEquals("Hello Foo", path.contents)

		assertTrue(path.isFile)
		assertFalse(path.isFolder)

		path.delete
		assertFalse(path.exists)
		assertFalse(path.isFile)
		assertFalse(path.isFolder)
	}

	@Test def void testModificationStamp_01() {
		val path = new Path('/foo/src/my/pack/Foo.txt')
		assertEquals(0L, path.lastModification)

		path.contents = "Hello Foo"
		val mod = path.lastModification
		assertEquals("Hello Foo", path.contents)

		assertEquals(mod, path.lastModification)
		Thread.sleep(1000)
		path.contents = "Hello Foo"
		assertEquals(mod, path.lastModification)
	}

	@Test def void testModificationStamp_02() {
		val path = new Path('/foo/src/my/pack/Foo.txt')
		assertEquals(0L, path.lastModification)

		path.contents = "Hello Foo"
		val mod = path.lastModification
		assertEquals("Hello Foo", path.contents)

		assertEquals(mod, path.lastModification)
		Thread.sleep(1000)
		path.contents = "Hello Bar"
		assertTrue(mod < path.lastModification)
	}

	@Test def void testGetWorkspaceChildren() {
		assertEquals(Path.ROOT.children.join('[', ', ', ']')[it.segments.join('.')], 1, Path.ROOT.children.size)
	}

	@Test def void testGetProjectChildren() {
		val projectFolder = new Path('/foo')
		assertTrue(projectFolder.exists)
		val expectedChildrenSize = projectFolder.children.size + 1

		new Path("/foo/Foo.text").contents = "Hello Foo"
		assertEquals(
			'' + projectFolder.children,
			expectedChildrenSize,
			projectFolder.children.size
		)
	}

	@Test def void testGetFolderChildren() {
		val folder = new Path('/foo/bar')
		assertFalse(folder.exists)

		folder.append('Bar.txt').contents = "Hello Bar"
		assertTrue(folder.exists)
		assertEquals(1, folder.children.size)

		new Path("/foo/bar/Foo.text").contents = "Hello Foo"
		assertEquals(2, folder.children.size)
	}

	@Test def void testGetFileChildren() {
		val file = new Path("/foo/bar/Foo.text")
		assertFalse(file.exists)
		assertEquals(0, file.children.size)

		file.contents = "Hello Foo"
		assertTrue(file.exists)
		assertEquals(0, file.children.size)
	}

	@Test def void testGetFileURI() {
		val file = new Path("/foo/bar/Foo.text")
		assertFalse(file.exists)
		assertNotNull(file.toURI)

		file.contents = "Hello Foo"
		assertTrue(file.exists)
		assertToURI(file, "Hello Foo")
	}

	@Test def void testGetFolderURI() {
		val path = new Path("/foo/bar")
		assertFalse(path.exists)
		assertNotNull(path.toURI)

		path.append('Foo.txt').contents = 'Hello Foo'
		assertTrue(path.exists)
		assertNotNull(path.toURI)
	}

	@Test def void testGetProjectURI() {
		val path = new Path("/foo")
		assertTrue(path.exists)
		assertNotNull(path.toURI)
	}

	@Test def void testGetWorkspaceURI() {
		val path = Path.ROOT
		assertTrue(path.exists)
		assertNull(path.toURI)
	}

	@Test def void testWorkspaceIsFolder() {
		assertTrue(Path.ROOT.folder)
	}

	@Test def void testWorkspaceIsFile() {
		assertFalse(Path.ROOT.file)
	}

	@Test def void testGetWorkspaceLastModification() {
		assertEquals(0L, Path.ROOT.lastModification)
	}

	@Test def void testGetWorkspaceCharset() {
		assertNotNull(Path.ROOT.charset)
	}

	@Test def void testGetWorkspaceContent() {
		try {
			Path.ROOT.contents
			fail
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	def void testGetWorkspaceContentAsSteam() {
		try {
			Path.ROOT.contentsAsStream
			fail
		} catch (IllegalArgumentException e) {
		}
	}

	@Test def void testSetWorkspaceContents() {
		try {
			Path.ROOT.contents = 'Hello World!'
			fail
		} catch (IllegalArgumentException e) {
		}
	}

	@Test def void testSetWorkspaceContentsAsStream() {
		try {
			Path.ROOT.contentsAsStream = new ByteArrayInputStream('Hello World!'.bytes)
			fail
		} catch (IllegalArgumentException e) {
		}
	}

	@Test def void testDeleteWorkspace() {
		assertTrue(Path.ROOT.exists)
		Path.ROOT.delete
		assertTrue(Path.ROOT.exists)
	}

	protected def void assertToURI(Path file, String expectedContent) {
		val uri = file.toURI
		assertNotNull(uri)
		try {
			val javaIoFile = new File(uri)
			assertTrue(javaIoFile.exists)

			val data = newByteArrayOfSize(javaIoFile.length as int)
			val fis = new FileInputStream(javaIoFile)
			fis.read(data)
			fis.close

			assertEquals(expectedContent, new String(data))
		} catch (Exception e) {
			fail('''URI: «uri»; «e.message»''')
		}
	}

}
