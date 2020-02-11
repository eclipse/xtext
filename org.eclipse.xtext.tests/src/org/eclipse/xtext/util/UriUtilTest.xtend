/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util

import java.io.File
import org.eclipse.emf.common.util.URI
import org.junit.Test

import static org.junit.Assert.*

import static extension org.eclipse.xtext.util.UriUtil.*

class UriUtilTest {
	@Test
	def void testPrefix() {
		val prefix = URI.createURI("file:/foo/")
		val uri = URI.createURI("file:/foo/bar")
		assertTrue(prefix.isPrefixOf(uri))
	}

	@Test
	def void testPrefixRequiresSameScheme() {
		val prefix = URI.createURI("platform:/foo/")
		val uri = URI.createURI("file:/foo/bar")
		assertFalse(prefix.isPrefixOf(uri))
	}

	@Test
	def void testPrefixRequiresTrailingSeparator() {
		val prefix = URI.createURI("file:/foo")
		val uri = URI.createURI("file:/foo/bar")
		assertFalse(prefix.isPrefixOf(uri))
	}

	@Test
	def void testPrefixRequiresSegmentsToMatch() {
		val prefix = URI.createURI("file:/foo")
		val uri = URI.createURI("file:/buzz/bar")
		assertFalse(prefix.isPrefixOf(uri))
	}

	@Test
	def void testFolderUriHasTrailingSeparator() {
		val folder = new File(".")
		val uri = folder.createFolderURI
		assertTrue(uri.hasTrailingPathSeparator)
		assertEquals(".", uri.segment(uri.segmentCount - 2))
	}
}