/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.file

import java.io.File
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.util.Files
import org.eclipse.xtext.xbase.file.JavaIOFileSystemSupport
import org.eclipse.xtext.xbase.file.ProjectConfig
import org.eclipse.xtext.xbase.file.WorkspaceConfig
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class JavaIoFileSystemTest {
	
	protected extension MutableFileSystemSupport fs
	
	@Before def void setUp() {
		val tempDir = new File(File.createTempFile('foo','bar').parent, class.simpleName)
		if (tempDir.exists)
			Files.sweepFolder(tempDir);
		fs = new JavaIOFileSystemSupport => [
			projectInformationProvider = [|new WorkspaceConfig(tempDir.absolutePath) => [
				addProjectConfig(new ProjectConfig('/foo') => [
					sourceFolderMappings.put(new Path('/foo/src'), new Path('/foo/xtend-gen'))
				])
			]]
			encodingProvider = new IEncodingProvider.Runtime()
		]
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
		path.contents = "Hello Foo"
		val mod = path.lastModification
		assertEquals("Hello Foo",path.contents)
		
		assertEquals(mod, path.lastModification)
		Thread.sleep(1000)
		path.contents = "Hello Foo"
		assertTrue(mod < path.lastModification)
	}
	
}