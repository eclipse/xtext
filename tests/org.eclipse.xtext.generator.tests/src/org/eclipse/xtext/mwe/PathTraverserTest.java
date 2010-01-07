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
import org.eclipse.xtext.mwe.PathTraverser;

import com.google.common.base.Predicates;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PathTraverserTest extends TestCase {
	
	public void testEmptyFolder() throws Exception {
		String path = pathTo("emptyFolder");
		Set<URI> uris = new PathTraverser().findAllResourceUris(path, Predicates.<URI>alwaysTrue());
		assertTrue(uris.isEmpty());
	}
	
	public void testNonEmptyFolder() throws Exception {
		String path = pathTo("nonemptyFolder");
		Set<URI> uris = new PathTraverser().findAllResourceUris(path, Predicates.<URI>alwaysTrue());
		assertEquals(2,uris.size());
	}
	
	public void testArchive() throws Exception {
		String path = pathTo("nonemptyJar.jar");
		Set<URI> uris = new PathTraverser().findAllResourceUris(path, Predicates.<URI>alwaysTrue());
		assertEquals(3,uris.size());
	}

	private String pathTo(String string) throws Exception {
		java.net.URI uri = getClass().getClassLoader().getResource(getClass().getName().replace('.', '/')+".class").toURI();
		URI fileURI = URI.createURI(uri.toString());
		URI fileURI2 = URI.createURI(string);
		return fileURI2.resolve(fileURI).toFileString();
	}
}
