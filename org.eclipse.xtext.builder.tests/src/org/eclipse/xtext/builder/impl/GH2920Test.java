/*******************************************************************************
 * Copyright (c) 2024 GK Software SE and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

import com.google.inject.Inject;

/**
 * @author sherrmann - Initial contribution and API
 */
public class GH2920Test extends AbstractParticipatingBuilderTest {
	private IJavaProject javaProject;
	
	@Inject private IResourceDescriptionsProvider descriptionsProvider;

	@Before
	public void createProjectUnderTest() throws Exception {
		javaProject = createJavaProject("NoResourceFromOutput");
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		build();
	}

	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		IResourceDescriptions resourceDescriptions = descriptionsProvider.getResourceDescriptions(context.getResourceSet());
		resourceDescriptions.getAllResourceDescriptions().forEach(rd -> assertFalse(rd.getURI().toString().contains("bin")));
		super.build(context, monitor);
	}

	@Test
	public void testIncremental() throws Exception {
		IProject project = javaProject.getProject();
		createSomeBuilderRelatedFile(project, "Foo");
		build();
		startLogging();
		createSomeBuilderRelatedFile(project, "Bar");
	}

	private IFile createSomeBuilderRelatedFile(IProject project, String name) throws CoreException {
		IFolder folder = project.getProject().getFolder("src");
		IFile file = folder.getFile(name + F_EXT);
		file.create(new StringInputStream("object "+name), true, monitor());
		build();
		return file;
	}
}

