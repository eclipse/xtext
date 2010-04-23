/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StrictJavaProjectsStateTest extends AbstractJavaProjectsStateTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		projectsState.setStrict(true);
	}
	
	public void testGetContainerHandle() {
		String uri1ContainerHandle = projectsState.getContainerHandle(uri1);
		String uri2ContainerHandle = projectsState.getContainerHandle(uri2);
		String uri3ContainerHandle = projectsState.getContainerHandle(uri3);
		assertEquals(srcRoot.getHandleIdentifier(), uri1ContainerHandle);
		assertEquals(srcRoot.getHandleIdentifier(), uri2ContainerHandle);
		assertNull(uri3ContainerHandle);
	}
	
	public void testGetContainedURIs() {
		Collection<URI> containedURIs = projectsState.getContainedURIs(srcRoot.getHandleIdentifier());
		assertEquals(2, containedURIs.size());
		assertTrue(containedURIs.contains(uri1));
		assertTrue(containedURIs.contains(uri2));
	}
	
}
