/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import static org.junit.Assert.*;

public class UriUtilTest {
	@Test
	public void testPrefix() {
		URI prefix = URI.createURI("file:/foo/");
		URI uri = URI.createURI("file:/foo/bar");
		assertTrue(UriUtil.isPrefixOf(prefix, uri));
	}

	@Test
	public void testPrefixRequiresSameScheme() {
		URI prefix = URI.createURI("platform:/foo/");
		URI uri = URI.createURI("file:/foo/bar");
		assertFalse(UriUtil.isPrefixOf(prefix, uri));
	}

	@Test
	public void testPrefixRequiresTrailingSeparator() {
		URI prefix = URI.createURI("file:/foo");
		URI uri = URI.createURI("file:/foo/bar");
		assertFalse(UriUtil.isPrefixOf(prefix, uri));
	}

	@Test
	public void testPrefixRequiresSegmentsToMatch() {
		URI prefix = URI.createURI("file:/foo");
		URI uri = URI.createURI("file:/buzz/bar");
		assertFalse(UriUtil.isPrefixOf(prefix, uri));
	}

	@Test
	public void testFolderUriHasTrailingSeparator() {
		File folder = new File(".");
		URI uri = UriUtil.createFolderURI(folder);
		assertTrue(uri.hasTrailingPathSeparator());
		assertEquals(".", uri.segment(uri.segmentCount() - 2));
	}
}
