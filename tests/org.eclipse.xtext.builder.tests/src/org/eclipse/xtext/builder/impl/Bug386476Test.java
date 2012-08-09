/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class Bug386476Test extends AbstractParticipatingBuilderTest {
	private IJavaProject javaProject;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		javaProject = createJavaProject("BuilderDisabled");
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		waitForAutoBuild();
	}

	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		super.build(context, monitor);
	}

	@Test
	public void testBuildIsNotInvokedWhenBuilderIsDisabled() throws Exception {
		IProject project = javaProject.getProject();
		IFile file = createSomeBuilderRelatedFile(project);
		waitForAutoBuild();
		startLogging();

		// With Xtext Builder activated builder is invoked
		stimulateBuildSchedulerTrigger(project);
		assertEquals("Xtext builder is triggered.", 1, getInvocationCount());

		// Disable/remove Xtext builder
		removeBuilder(project, XtextProjectHelper.BUILDER_ID);
		reset();

		// With Xtext Builder activated builder is not invoked
		stimulateBuildSchedulerTrigger(project);
		assertEquals("Xtext builder is triggered but should not, cause was disabled", 0, getInvocationCount());
		stopLogging();
		file.delete(true, false, monitor());
	}

	private void stimulateBuildSchedulerTrigger(IProject project) throws CoreException {
		project.close(monitor());
		waitForAutoBuild();
		project.open(monitor());
		waitForAutoBuild();
	}

	private IFile createSomeBuilderRelatedFile(IProject project) throws CoreException {
		IFolder folder = project.getProject().getFolder("src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		return file;
	}

	@Override
	public void tearDown() throws Exception {
		javaProject.getProject().delete(true, true, null);
		super.tearDown();
	}
}
