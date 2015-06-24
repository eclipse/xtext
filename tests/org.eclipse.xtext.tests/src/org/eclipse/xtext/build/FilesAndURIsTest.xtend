/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.build

import org.eclipse.emf.common.util.URI
import org.junit.Test

import static org.junit.Assert.*

import static extension org.eclipse.xtext.build.FilesAndURIs.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class FilesAndURIsTest {
	
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
		assertEquals('/Users/Foo/bar', URI.createURI('file:/Users/./Foo/bar').asFile.path)
		assertEquals('file:/Users/Foo/bar', '/Users/./Foo/bar'.asFileURI.toString)
	}
	
	def assertRelativeURI(String expected, String absoluteURI, String... baseURIs) {
		assertEquals(expected?.asURI, absoluteURI.asURI.findRelativeURI(baseURIs.map[asURI]))
	}
	
}
