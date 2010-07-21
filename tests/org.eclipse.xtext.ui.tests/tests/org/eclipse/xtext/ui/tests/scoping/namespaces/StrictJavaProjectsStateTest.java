/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import java.util.Collection;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.containers.JavaProjectsStateHelper;
import org.eclipse.xtext.ui.containers.StrictJavaProjectsState;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StrictJavaProjectsStateTest extends AbstractJavaProjectsStateTest {

	@Override
	protected StrictJavaProjectsState createProjectsState(IStorage2UriMapper mapper) {
		StrictJavaProjectsState result = new StrictJavaProjectsState();
		result.setMapper(mapper);
		JavaProjectsStateHelper javaProjectsStateHelper = new JavaProjectsStateHelper();
		javaProjectsStateHelper.setMapper(mapper);
		javaProjectsStateHelper.setWorkspace(ResourcesPlugin.getWorkspace());
		result.setHelper(javaProjectsStateHelper);
		return result;
	}
	
	public void testGetContainerHandle_01() {
		String uri1ContainerHandle = projectsState.getContainerHandle(uri1);
		String uri2ContainerHandle = projectsState.getContainerHandle(uri2);
		String uri3ContainerHandle = projectsState.getContainerHandle(uri3);
		assertEquals(srcRoot.getHandleIdentifier(), uri1ContainerHandle);
		assertEquals(srcRoot.getHandleIdentifier(), uri2ContainerHandle);
		assertNull(uri3ContainerHandle);
	}
	
	public void testGetContainerHandle_02() throws CoreException {
		IResourcesSetupUtil.removeNature(project1, XtextProjectHelper.NATURE_ID);
		IResourcesSetupUtil.removeNature(project2, XtextProjectHelper.NATURE_ID);
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
