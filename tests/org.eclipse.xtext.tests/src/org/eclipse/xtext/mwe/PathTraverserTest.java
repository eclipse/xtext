/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PathTraverserTest extends TestCase {
	public static Predicate<URI> everythingButDummy = new Predicate<URI>() {

		public boolean apply(URI input) {
			return !input.fileExtension().equals("dummy");
		}
	};
	
	public void testEmptyFolder() throws Exception {
		String path = pathTo("emptyFolder");
		Set<URI> uris = new PathTraverser().findAllResourceUris(path, everythingButDummy);
		assertTrue(uris.isEmpty());
	}
	
	public void testNonEmptyFolder() throws Exception {
		String path = pathTo("nonemptyFolder");
		Set<URI> uris = new PathTraverser().findAllResourceUris(path, everythingButDummy);
		assertEquals(2,uris.size());
	}
	
	public void testArchive() throws Exception {
		String path = pathTo("nonemptyJar.jar");
		Set<URI> uris = new PathTraverser().findAllResourceUris(path, everythingButDummy);
		assertEquals(3,uris.size());
	}

	private String pathTo(String string) throws Exception {
		return new ReaderTest().pathTo(string);
	}
}
