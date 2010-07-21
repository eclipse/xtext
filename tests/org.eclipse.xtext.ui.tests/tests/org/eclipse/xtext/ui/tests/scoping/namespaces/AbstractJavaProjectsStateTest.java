/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.containers.AbstractJavaProjectsState;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractJavaProjectsStateTest extends AbstractAllContainersStateTests {

	protected URI uri1;
	protected URI uri2;
	protected URI uri3;
	
	protected IJavaProject javaProject1;
	protected AbstractJavaProjectsState projectsState;
	protected IPackageFragmentRoot srcRoot;

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
		IStorage2UriMapper mapper = new Storage2UriMapperImpl() {
			@Override
			public boolean isValidUri(URI uri, IStorage storage) {
				return uri != null 
					&& !uri.toString().endsWith("/.project")
					&& !uri.toString().endsWith("/.classpath");
			}
		};
		projectsState = createProjectsState(mapper);
	}

	protected abstract AbstractJavaProjectsState createProjectsState(IStorage2UriMapper mapper);
	
	@Override
	public void testRemoveNature() throws CoreException {
		Collection<URI> containedURIs = projectsState.getContainedURIs(srcRoot.getHandleIdentifier());
		assertEquals(2, containedURIs.size());
		IResourcesSetupUtil.removeNature(javaProject1.getProject(), XtextProjectHelper.NATURE_ID);
		containedURIs = projectsState.getContainedURIs(srcRoot.getHandleIdentifier());
		assertTrue(containedURIs.isEmpty());
	}
	
	public void testGetContainerHandle_Bug316519_01() {
		IFile file = getFile(project1, "src/doesNotExist");
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		String handleIdent = projectsState.getContainerHandle(uri);
		assertEquals(srcRoot.getHandleIdentifier(), handleIdent);
	}
	
	public void testGetContainerHandle_Bug316519_02() throws CoreException {
		IFile file = getFile(project1, "src/doesNotExist");
		IResourcesSetupUtil.removeNature(file.getProject(), XtextProjectHelper.NATURE_ID);
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		String handleIdent = projectsState.getContainerHandle(uri);
		assertEquals(srcRoot.getHandleIdentifier(), handleIdent);
	}
	
}
