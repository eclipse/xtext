/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LooseJavaProjectsStateTest extends AbstractJavaProjectsStateTest {

	private URI simpleUri1;
	private URI simpleUri2;
	private URI simpleUri3;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		simpleUri1 = createFileAndRegisterResource(project1, "file1");
		simpleUri2 = createFileAndRegisterResource(project1, "file2");
		simpleUri3 = createFileAndRegisterResource(project2, "file3");
		projectsState.setStrict(false);
	}
	
	public void testGetContainerHandle() {
		String uri1ContainerHandle = projectsState.getContainerHandle(uri1);
		String uri2ContainerHandle = projectsState.getContainerHandle(uri2);
		String uri3ContainerHandle = projectsState.getContainerHandle(uri3);
		assertEquals(srcRoot.getHandleIdentifier(), uri1ContainerHandle);
		assertEquals(srcRoot.getHandleIdentifier(), uri2ContainerHandle);
		assertEquals(project2.getName(), uri3ContainerHandle);
	}
	
	public void testGetContainedURIs_01() {
		Collection<URI> containedURIs = projectsState.getContainedURIs(srcRoot.getHandleIdentifier());
		assertEquals(2, containedURIs.size());
		assertTrue(containedURIs.contains(uri1));
		assertTrue(containedURIs.contains(uri2));
		assertFalse(containedURIs.contains(uri3));
	}
	
	public void testGetContainedURIs_02() {
		Collection<URI> containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(containedURIs.toString(), 4, containedURIs.size());
		assertTrue(containedURIs.contains(uri1));
		assertTrue(containedURIs.contains(simpleUri1));
		assertTrue(containedURIs.contains(uri2));
		assertTrue(containedURIs.contains(simpleUri2));
		assertFalse(containedURIs.contains(uri3));
		assertFalse(containedURIs.contains(simpleUri3));
	}
	
	public void testGetContainedURIs_03() throws CoreException, InvocationTargetException, InterruptedException {
		Collection<URI> containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(containedURIs.toString(), 4, containedURIs.size());
		URI uri = createFileAndRegisterResource(project1, "file3");
		containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(containedURIs.toString(), 5, containedURIs.size());
		assertTrue(containedURIs.contains(uri1));
		assertTrue(containedURIs.contains(simpleUri1));
		assertTrue(containedURIs.contains(uri2));
		assertTrue(containedURIs.contains(simpleUri2));
		assertTrue(containedURIs.contains(uri));
	}
	
	public void testRemoveNature_02() throws CoreException {
		Collection<URI> containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(4, containedURIs.size());
		IResourcesSetupUtil.removeNature(project1, XtextProjectHelper.NATURE_ID);
		containedURIs = projectsState.getContainedURIs(project1.getName());
		assertTrue(containedURIs.isEmpty());
	}
}
