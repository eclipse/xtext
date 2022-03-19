/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsState;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsStateHelper;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.junit.Test;
import org.osgi.framework.Version;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class WorkspaceProjectsStateTest extends AbstractAllContainersStateTests {

	private URI uri1;
	private URI uri2;
	private URI uri3;
	
	private WorkspaceProjectsState projectsState;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
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
			public boolean isValid(URI uri, IStorage storage) {
				return true;
			}
			
			@Override
			public boolean isPossiblyManaged(IStorage storage) {
				return true;
			}
		});
		projectsState = new WorkspaceProjectsState();
		projectsState.setMapper(mapper);
		WorkspaceProjectsStateHelper helper = new WorkspaceProjectsStateHelper();
		helper.setMapper(mapper);
		helper.setWorkspace(ResourcesPlugin.getWorkspace());
		projectsState.setHelper(helper);
	}

	@Test public void testGetContainerHandle_01() {
		String uri1ContainerHandle = projectsState.getContainerHandle(uri1);
		String uri2ContainerHandle = projectsState.getContainerHandle(uri2);
		String uri3ContainerHandle = projectsState.getContainerHandle(uri3);
		assertEquals(project1.getName(), uri1ContainerHandle);
		assertEquals(project1.getName(), uri2ContainerHandle);
		assertEquals(project2.getName(), uri3ContainerHandle);
	}
	
	@Test public void testGetContainerHandle_02() throws CoreException {
		IResourcesSetupUtil.removeNature(project1, XtextProjectHelper.NATURE_ID);
		IResourcesSetupUtil.removeNature(project2, XtextProjectHelper.NATURE_ID);
		String uri1ContainerHandle = projectsState.getContainerHandle(uri1);
		String uri2ContainerHandle = projectsState.getContainerHandle(uri2);
		String uri3ContainerHandle = projectsState.getContainerHandle(uri3);
		assertEquals(project1.getName(), uri1ContainerHandle);
		assertEquals(project1.getName(), uri2ContainerHandle);
		assertEquals(project2.getName(), uri3ContainerHandle);
	}
	
	@Test public void testGetContainerHandle_Bug316519_03() {
		IFile file = getFile(project1, "doesNotExist");
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		String handleIdent = projectsState.getContainerHandle(uri);
		assertEquals(project1.getName(), handleIdent);
	}
	
	@Test public void testGetContainerHandle_Bug316519_04() throws CoreException {
		IFile file = getFile(project1, "doesNotExist");
		IResourcesSetupUtil.removeNature(file.getProject(), XtextProjectHelper.NATURE_ID);
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		String handleIdent = projectsState.getContainerHandle(uri);
		assertEquals(project1.getName(), handleIdent);
	}
	
	@Test public void testGetContainedURIs_01() {
		Collection<URI> containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(containedURIs.toString(), isCoreResourceGreaterOrEqual_3_17_0() ? 3 : 2, containedURIs.size());
		assertTrue(containedURIs.contains(uri1));
		assertTrue(containedURIs.contains(uri2));
	}
	
	@Test public void testGetContainedURIs_02() throws CoreException, InvocationTargetException, InterruptedException {
		Collection<URI> containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(containedURIs.toString(), isCoreResourceGreaterOrEqual_3_17_0() ? 3 : 2, containedURIs.size());
		URI uri = createFileAndRegisterResource(project1, "file3");
		containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(containedURIs.toString(), isCoreResourceGreaterOrEqual_3_17_0() ? 4 : 3, containedURIs.size());
		assertTrue(containedURIs.contains(uri1));
		assertTrue(containedURIs.contains(uri2));
		assertTrue(containedURIs.contains(uri));
	}
	
	@Override
	@Test public void testRemoveNature() throws CoreException {
		Collection<URI> containedURIs = projectsState.getContainedURIs(project1.getName());
		assertEquals(isCoreResourceGreaterOrEqual_3_17_0() ? 3 : 2, containedURIs.size());
		IResourcesSetupUtil.removeNature(project1, XtextProjectHelper.NATURE_ID);
		containedURIs = projectsState.getContainedURIs(project1.getName());
		assertTrue(containedURIs.isEmpty());
	}
	
	private static boolean isCoreResourceGreaterOrEqual_3_17_0() {
		Version	installedCoreResourcesVersion = ResourcesPlugin.getPlugin().getBundle().getVersion();
		return installedCoreResourcesVersion.compareTo(new Version(3,17,0)) >= 0;
	}
	
}
