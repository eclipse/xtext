/*******************************************************************************
 * Copyright (c) 2017, 2023 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.encoding;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.nature.XtextNature;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testlanguages.ui.internal.TestlanguagesActivator;
import org.eclipse.xtext.ui.editor.WorkspaceEncodingProvider;
import org.eclipse.xtext.ui.testing.AbstractWorkbenchTest;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Karsten Thoms - Initial contribution and API
 */
public class WorkspaceEncodingProviderTest extends AbstractWorkbenchTest {
	@Inject
	private IEncodingProvider encodingProvider;
	@Inject
	private IWorkspace workspace;
	@Inject Provider<XtextResourceSet> resourceSetProvider;
	
	private Injector injector;
	private String defaultEncoding;
	private IProject project;
	private IProgressMonitor monitor = new NullProgressMonitor();
	
	
	@Before
	public void init () throws Exception {
		injector = TestlanguagesActivator.getInstance().getInjector(TestlanguagesActivator.ORG_ECLIPSE_XTEXT_TESTLANGUAGES_XTEXTGRAMMAR_XTEXTGRAMMARTESTLANGUAGE);
		injector.injectMembers(this);
		assertNotNull(encodingProvider);
		assertTrue(encodingProvider instanceof WorkspaceEncodingProvider);
		
		defaultEncoding = workspace.getRoot().getDefaultCharset();
		project = createProject("WorkspaceEncodingProviderTest");
		XtextNature xtextNature = new XtextNature();
		xtextNature.setProject(project);
		xtextNature.configure();
	}
	
	@Test
	public void testWorkspaceDefaultEncoding () {
		XtextResourceSet resourceSet = resourceSetProvider.get();
		XtextResource resource = (XtextResource) resourceSet.createResource(URI.createURI("platform:/resource/WorkspaceEncodingProviderTest/test1.xtextgrammar"));
		assertEquals(defaultEncoding, resource.getEncoding());
	}

	@Test
	public void testProjectSpecificEncoding () throws CoreException {
		project.setDefaultCharset("UTF-16", new NullProgressMonitor());
		XtextResourceSet resourceSet = resourceSetProvider.get();
		XtextResource resource = (XtextResource) resourceSet.createResource(URI.createURI("platform:/resource/WorkspaceEncodingProviderTest/test1.xtextgrammar"));
		assertEquals("UTF-16", resource.getEncoding());
	}

	@Test
	public void testContainerSpecificEncoding () throws CoreException {
		project.setDefaultCharset("UTF-16", new NullProgressMonitor());
		IFolder folder = project.getFolder("foo");
		folder.create(true, true, monitor);
		folder.setDefaultCharset("ASCII", monitor);
		XtextResourceSet resourceSet = resourceSetProvider.get();
		XtextResource resource = (XtextResource) resourceSet.createResource(URI.createURI("platform:/resource/WorkspaceEncodingProviderTest/foo/test1.xtextgrammar"));
		assertEquals("ASCII", resource.getEncoding());
	}
}
