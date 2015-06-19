/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.tests.incremental

import com.google.common.io.Files
import org.junit.Test

import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*
import static org.junit.Assert.*
import java.io.File
import org.eclipse.emf.common.util.URI

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class FilesAndURIsTest {
	
	@Test
	def testDirsVsFiles() {
		val tmpDir = Files.createTempDir()
		val tmpFile = new File(tmpDir, 'tmp.tmp');
		try {
			val dirURI = tmpDir.asURI
			assertTrue(dirURI.hasTrailingPathSeparator)
			assertEquals('', dirURI.lastSegment)
			val fileURI = tmpFile.asURI
			assertFalse(fileURI.hasTrailingPathSeparator)
			assertNotSame('', fileURI.lastSegment)
		} finally {
			tmpDir.delete
		}
	}
	
	@Test 
	def testRelativeURI() {
		assertRelativeURI('bar/Foo.txt', 'file:/foo/bar/Foo.txt', 'file:/foo/')
		assertRelativeURI(null, 'file:/foo/bar/Foo.txt', 'file:/foo/baz/Foo.txt')
		assertRelativeURI(null, 'file:/foo/bar/Foo.txt', 'file:/foo')
		assertRelativeURI(null, 'file:/foo/bar/Foo.txt', 'file:/foo/bar/Foo.txt/')
		assertRelativeURI(null, 'http:/foo/bar/Foo.txt', 'file:/foo/bar/Foo.txt/')
		assertRelativeURI('Foo.txt', 'file:/foo/bar/Foo.txt', 'file:/foo/', 'file:/foo/bar/')
		assertRelativeURI('Foo.txt', 'file:/foo/bar/Foo.txt', 'file:/foo/bar/', 'file:/foo/')
	}
	
	@Test
	def testDotInURI() {
		assertEquals('/Users/Foo/bar', URI.createURI('file:/Users/./Foo/bar').asPath)
		assertEquals('/Users/Foo/bar', URI.createURI('file:/Users/./Foo/bar').asFile.path)
		assertEquals('file:/Users/Foo/bar', '/Users/./Foo/bar'.asFileURI.toString)
		assertEquals('file:/Users/Foo/bar', new File('/Users/./Foo/bar').asURI.toString)
	}
	
	def assertRelativeURI(String expected, String absoluteURI, String... baseURIs) {
		assertEquals(expected?.asURI, absoluteURI.asURI.findRelativeURI(baseURIs.map[asURI]))
	}
	
}