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

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsState;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsStateHelper;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class WorkspaceProjectsStateTest extends AbstractAllContainersStateTests {

	private URI uri1;
	private URI uri2;
	private URI uri3;
	
	private WorkspaceProjectsState projectsState;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		uri1 = createFileAndRegisterResource(project1, "file1");
		uri2 = createFileAndRegisterResource(project1, "file2");
		uri3 = createFileAndRegisterResource(project2, "file3");
		IStorage2UriMapper mapper = new Storage2UriMapperImpl() {
			@Override
			public boolean isValidUri(URI uri, IStorage storage) {
				return uri != null && !uri.toString().endsWith("/.project");
			}
		};
		projectsState = new WorkspaceProjectsState();
		projectsState.setMapper(mapper);
		WorkspaceProjectsStateHelper helper = new WorkspaceProjectsStateHelper();
		helper.setMapper(mapper);
		helper.setWorkspace(ResourcesPlugin.getWorkspace());
		projectsState.setHelper(helper);
	}

	public void testGetContainerHandle() {
		String uri1ContainerHandle = projectsState.getContainerHandle(uri1);
		String uri2ContainerHandle = projectsState.getContainerHandle(uri2);
		String uri3ContainerHandle = projectsState.getContainerHandle(uri3);
		assertEquals(project1.getName(), uri1ContainerHandle);
		assertEquals(project1.getName(), uri2ContainerHandle);
		assertEquals(project2.getName(), uri3ContainerHandle);
	}
	
	public void testGetContainedURIs_01() {
		Collection<URI> containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(containedURIs.toString(), 2, containedURIs.size());
		assertTrue(containedURIs.contains(uri1));
		assertTrue(containedURIs.contains(uri2));
	}
	
	public void testGetContainedURIs_02() throws CoreException, InvocationTargetException, InterruptedException {
		Collection<URI> containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(containedURIs.toString(), 2, containedURIs.size());
		URI uri = createFileAndRegisterResource(project1, "file3");
		containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(containedURIs.toString(), 3, containedURIs.size());
		assertTrue(containedURIs.contains(uri1));
		assertTrue(containedURIs.contains(uri2));
		assertTrue(containedURIs.contains(uri));
	}
	
	@Override
	public void testRemoveNature() throws CoreException {
		Collection<URI> containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(2, containedURIs.size());
		IResourcesSetupUtil.removeNature(project1, XtextProjectHelper.NATURE_ID);
		containedURIs = projectsState.getContainedURIs(project1.getName());
		assertTrue(containedURIs.isEmpty());
	}
	
}
