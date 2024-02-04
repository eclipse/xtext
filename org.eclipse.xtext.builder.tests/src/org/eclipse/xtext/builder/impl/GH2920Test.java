/*******************************************************************************
 * Copyright (c) 2024 GK Software SE and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import com.google.inject.Inject;

/**
 * @author sherrmann - Initial contribution and API
 * @author Lorenzo Bettini - make it appropriate for reproducing https://github.com/eclipse/xtext/issues/2920
 */
public class GH2920Test extends AbstractParticipatingBuilderTest {
	private IJavaProject javaProject;

	@Inject private IResourceDescriptionsProvider descriptionsProvider;

	private List<String> descriptionsInOutputFolder = new ArrayList<>();

	@Before
	public void createProjectUnderTest() throws Exception {
		javaProject = createJavaProject("NoResourceFromOutput");
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		build();
	}

	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		IResourceDescriptions resourceDescriptions = descriptionsProvider.getResourceDescriptions(context.getResourceSet());
		resourceDescriptions.getAllResourceDescriptions().forEach(
			rd -> {
				String uriString = rd.getURI().toString();
				if (uriString.contains("bin"))
					descriptionsInOutputFolder.add(uriString);
			});
		super.build(context, monitor);
	}

	@Test
	public void testIncremental() throws Exception {
		IProject project = javaProject.getProject();
		createSomeBuilderRelatedFile(project, "Foo");
		build();
		startLogging();
		createSomeBuilderRelatedFile(project, "Bar");
		checkNoUrisInOutputFolder();
	}

	private IFile createSomeBuilderRelatedFile(IProject project, String name) throws CoreException {
		IFolder folder = project.getProject().getFolder("src");
		IFile file = folder.getFile(name + F_EXT + "GH2920");
		file.create(new StringInputStream("object "+name), true, monitor());
		build();
		return file;
	}

	private void checkNoUrisInOutputFolder() {
		if (!descriptionsInOutputFolder.isEmpty())
			fail("unexpected resources in output folder:\n" +
				descriptionsInOutputFolder.stream()
					.collect(Collectors.joining("\n", "  ", "")));
	}
}
