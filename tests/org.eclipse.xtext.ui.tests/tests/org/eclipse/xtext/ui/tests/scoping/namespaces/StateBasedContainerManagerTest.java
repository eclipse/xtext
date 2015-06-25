/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.util.URIBasedTestResourceDescription;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager;
import org.eclipse.xtext.resource.containers.StateBasedContainerManager;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsState;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsStateHelper;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StateBasedContainerManagerTest extends AbstractContainerRelatedTests implements IAllContainersState.Provider {

	private URI uri1;
	private URI uri2;
	private URI uri3;
	
	private WorkspaceProjectsState projectsState;
	private StateBasedContainerManager containerManager;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		IResourcesSetupUtil.setReference(project1, project2);
		uri1 = createFileAndRegisterResource(project1, "file1");
		uri2 = createFileAndRegisterResource(project1, "file2");
		uri3 = createFileAndRegisterResource(project2, "file3");
		Storage2UriMapperImpl mapper = new Storage2UriMapperImpl() {
			@Override
			public boolean isValidUri(URI uri, IStorage storage) {
				return uri != null && !uri.toString().endsWith("/.project");
			}
		};
		mapper.setUriValidator(new UriValidator() {
			@Override
			public boolean isPossiblyManaged(IStorage storage) {
				return true;
			}
			@Override
			public boolean isValid(URI uri, IStorage storage) {
				return true;
			}
		});
		projectsState = new WorkspaceProjectsState();
		projectsState.setMapper(mapper);
		WorkspaceProjectsStateHelper helper = new WorkspaceProjectsStateHelper();
		helper.setMapper(mapper);
		helper.setWorkspace(ResourcesPlugin.getWorkspace());
		projectsState.setHelper(helper);
		containerManager = new StateBasedContainerManager();
		containerManager.setStateProvider(this);
		containerManager.setDelegate(new ProjectDescriptionBasedContainerManager());
	}

	@Override
	public IAllContainersState get(IResourceDescriptions context) {
		assertSame(this, context);
		return projectsState;
	}
	
	@Test public void testGetContainer_01() {
		IResourceDescription description = new URIBasedTestResourceDescription(uri1);
		IContainer container = containerManager.getContainer(description, this);
		assertEquals(2, Iterables.size(container.getResourceDescriptions()));
		assertNotNull(container.getResourceDescription(uri1));
		assertNotNull(container.getResourceDescription(uri2));
		assertNull(container.getResourceDescription(uri3));
	}
	
	@Test public void testGetContainer_02() {
		IFile file = getFile(project1, "doesNotExist");
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		IResourceDescription description = new URIBasedTestResourceDescription(uri);
		IContainer container = containerManager.getContainer(description, this);
		assertEquals(3, Iterables.size(container.getResourceDescriptions()));
		assertNotNull(container.getResourceDescription(uri));
		assertNotNull(container.getResourceDescription(uri1));
		assertNotNull(container.getResourceDescription(uri2));
		assertNull(container.getResourceDescription(uri3));
	}
	
	@Test public void testGetVisibleContainers_01() {
		IResourceDescription description = new URIBasedTestResourceDescription(uri1);
		List<IContainer> visibleContainers = containerManager.getVisibleContainers(description, this);
		assertEquals(2, visibleContainers.size());
		assertEquals(2, Iterables.size(visibleContainers.get(0).getResourceDescriptions()));
		assertEquals(1, Iterables.size(visibleContainers.get(1).getResourceDescriptions()));
		assertNotNull(visibleContainers.get(0).getResourceDescription(uri1));
		assertNotNull(visibleContainers.get(0).getResourceDescription(uri2));
		assertNotNull(visibleContainers.get(1).getResourceDescription(uri3));
	}
	
	@Test public void testGetVisibleContainers_02() {
		IFile file = getFile(project1, "doesNotExist");
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		IResourceDescription description = new URIBasedTestResourceDescription(uri);
		List<IContainer> visibleContainers = containerManager.getVisibleContainers(description, this);
		assertEquals(2, visibleContainers.size());
		assertEquals(3, Iterables.size(visibleContainers.get(0).getResourceDescriptions()));
		assertEquals(1, Iterables.size(visibleContainers.get(1).getResourceDescriptions()));
		assertNotNull(visibleContainers.get(0).getResourceDescription(uri));
		assertNotNull(visibleContainers.get(0).getResourceDescription(uri1));
		assertNotNull(visibleContainers.get(0).getResourceDescription(uri2));
		assertNotNull(visibleContainers.get(1).getResourceDescription(uri3));
	}
	
}
