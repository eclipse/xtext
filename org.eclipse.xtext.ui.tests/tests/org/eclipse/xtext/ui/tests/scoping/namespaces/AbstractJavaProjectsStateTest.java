/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.containers.AbstractJavaProjectsState;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.JarEntryLocator;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.ui.shared.JdtHelper;
import org.junit.Test;

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
	public void setUp() throws Exception {
		super.setUp();
		javaProject1 = makeJavaProject(project1);
		addSourceFolder(javaProject1, "src2");
		uri1 = createFileAndRegisterResource(project1, "src/file1");
		uri2 = createFileAndRegisterResource(project1, "src/file2");
		uri3 = createFileAndRegisterResource(project2, "src2/file3");
		IResource member = javaProject1.getProject().findMember("src");
		srcRoot = javaProject1.getPackageFragmentRoot(member);
		Storage2UriMapperImpl mapper = new Storage2UriMapperImpl() {
			@Override
			public boolean isValidUri(URI uri, IStorage storage) {
				return uri != null 
					&& !uri.toString().endsWith("/.project")
					&& !uri.toString().endsWith("/.classpath");
			}
		};
		UriValidator uriValidator = new UriValidator() {
			@Override
			public boolean isValid(URI uri, IStorage storage) {
				return "name".equals(uri.fileExtension());
			}
			
			@Override
			public boolean isPossiblyManaged(IStorage storage) {
				return "name".equals(storage.getFullPath().getFileExtension());
			}
		};
		mapper.setUriValidator(uriValidator);
		Storage2UriMapperJavaImpl contribution = new Storage2UriMapperJavaImpl();
		contribution.setUriValidator(uriValidator);
		contribution.setJdtHelper(new JdtHelper());
		contribution.setLocator(new JarEntryLocator());
		contribution.setHost(mapper);
		mapper.setContribution(contribution);
		projectsState = createProjectsState(mapper);
	}

	protected abstract AbstractJavaProjectsState createProjectsState(IStorage2UriMapper mapper);
	
	@Override
	@Test public void testRemoveNature() throws CoreException {
		Collection<URI> containedURIs = projectsState.getContainedURIs(srcRoot.getHandleIdentifier());
		assertEquals(2, containedURIs.size());
		IResourcesSetupUtil.removeNature(javaProject1.getProject(), XtextProjectHelper.NATURE_ID);
		containedURIs = projectsState.getContainedURIs(srcRoot.getHandleIdentifier());
		assertTrue(containedURIs.isEmpty());
	}
	
	@Test public void testGetContainerHandle_Bug316519_01() {
		IFile file = getFile(project1, "src/doesNotExist");
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		String handleIdent = projectsState.getContainerHandle(uri);
		assertEquals(srcRoot.getHandleIdentifier(), handleIdent);
	}
	
	@Test public void testGetContainerHandle_Bug316519_02() throws CoreException {
		IFile file = getFile(project1, "src/doesNotExist");
		IResourcesSetupUtil.removeNature(file.getProject(), XtextProjectHelper.NATURE_ID);
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		String handleIdent = projectsState.getContainerHandle(uri);
		assertEquals(srcRoot.getHandleIdentifier(), handleIdent);
	}
	
}
