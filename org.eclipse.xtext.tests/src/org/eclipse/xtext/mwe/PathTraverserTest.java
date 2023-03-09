/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PathTraverserTest extends Assert {
	public static Predicate<URI> everythingButDummy = new Predicate<URI>() {

		@Override
		public boolean apply(URI input) {
			return !input.fileExtension().equals("dummy");
		}
	};

	/**
	 * PathTraverser should not throw an exception but log a warning if a path doesn't exist.
	 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=376944">Bug 376944</a>
	 */
	@Test
	public void testNoneExistingFile() throws Exception {
		String path = "fileNotExists";
		Set<URI> uris = new PathTraverser().findAllResourceUris(path, everythingButDummy);
		assertTrue(uris.isEmpty());
	}

	@Test
	public void testEmptyFolder() throws Exception {
		String path = pathTo("emptyFolder");
		Set<URI> uris = new PathTraverser().findAllResourceUris(path, everythingButDummy);
		assertTrue(uris.isEmpty());
	}

	@Test
	public void testNonEmptyFolder() throws Exception {
		String path = pathTo("nonemptyFolder");
		Set<URI> uris = new PathTraverser().findAllResourceUris(path, everythingButDummy);
		assertEquals(2, uris.size());
	}

	@Test
	public void testArchive() throws Exception {
		String path = pathTo("nonemptyJar.jar");
		Set<URI> uris = new PathTraverser().findAllResourceUris(path, everythingButDummy);
		assertEquals(3, uris.size());
	}

	private String pathTo(String string) throws Exception {
		return new ReaderTest().pathTo(string);
	}
}
