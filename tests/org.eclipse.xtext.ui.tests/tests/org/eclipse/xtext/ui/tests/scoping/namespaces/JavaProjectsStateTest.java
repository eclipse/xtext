/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.ui.containers.JavaProjectsState;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaProjectsStateTest extends AbstractAllContainersStateTests {

	private URI uri1;
	private URI uri2;
	private URI uri3;
	
	private IJavaProject javaProject1;
	private JavaProjectsState projectsState;
	private IPackageFragmentRoot srcRoot;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		javaProject1 = makeJavaProject(project1);
		addSourceFolder(javaProject1, "src2");
		uri1 = createFileAndRegisterResource(project1, "src/file1");
		uri2 = createFileAndRegisterResource(project1, "src/file2");
		uri3 = createFileAndRegisterResource(project2, "src2/file3");
		IResource member = javaProject1.getProject().findMember("src");
		srcRoot = javaProject1.getPackageFragmentRoot(member);
		IStorage2UriMapper mapper = new Storage2UriMapperJavaImpl() {
			@Override
			public boolean isValidUri(URI uri, IStorage storage) {
				return uri != null;
			}
		};
		projectsState = new JavaProjectsState();
		projectsState.setMapper(mapper);
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
