/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.buildpath;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.util.JavaProjectFactory;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtend2.ui.buildpath.XtendLibClasspathAdder;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendLibClasspathAdderTest extends AbstractXtend2UITestCase {

	@Inject
	private XtendLibClasspathAdder adder;

	@Inject
	private JavaProjectFactory javaProjectFactory;

	@Inject
	private PluginProjectFactory pluginProjectFactory;

	@Override
	protected void tearDown() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
		super.tearDown();
	}

	public void testAddToJavaProject() throws Exception {
		javaProjectFactory.setProjectName("test");
		javaProjectFactory.addFolders(Collections.singletonList("src"));
		javaProjectFactory.addBuilderIds(JavaCore.BUILDER_ID, XtextProjectHelper.BUILDER_ID);
		javaProjectFactory.addProjectNatures(JavaCore.NATURE_ID, XtextProjectHelper.NATURE_ID);
		IProject project = javaProjectFactory.createProject(null, null);
		IJavaProject javaProject = JavaCore.create(project);
		JavaProjectSetupUtil.makeJava5Compliant(javaProject);
		IFile file = project.getFile("src/Foo.xtend");
		file.create(new StringInputStream("class Foo {}"), true, null);
		IResourcesSetupUtil.waitForAutoBuild();
		assertErrorMarker(file);
		adder.addLibsToClasspath(javaProject, null);
		IResourcesSetupUtil.waitForAutoBuild();
		assertNoErrorMarker(file);
	}

	public void testAddToPlugin() throws Exception {
		pluginProjectFactory.setProjectName("test");
		pluginProjectFactory.addFolders(Collections.singletonList("src"));
		pluginProjectFactory.addBuilderIds(JavaCore.BUILDER_ID, "org.eclipse.pde.ManifestBuilder",
				"org.eclipse.pde.SchemaBuilder", XtextProjectHelper.BUILDER_ID);
		pluginProjectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature",
				XtextProjectHelper.NATURE_ID);
		IProject project = pluginProjectFactory.createProject(null, null);
		IJavaProject javaProject = JavaCore.create(project);
		JavaProjectSetupUtil.makeJava5Compliant(javaProject);
		IFile file = project.getFile("src/Foo.xtend");
		file.create(new StringInputStream("class Foo {}"), true, null);
		IResourcesSetupUtil.waitForAutoBuild();
		assertErrorMarker(file);
		adder.addLibsToClasspath(javaProject, null);
		IResourcesSetupUtil.waitForAutoBuild();
		assertNoErrorMarker(file);
	}

	protected void assertErrorMarker(IFile file) throws CoreException {
		int severity = file.findMaxProblemSeverity(null, true, IResource.DEPTH_INFINITE);
		assertEquals("Expected error marker", IMarker.SEVERITY_ERROR, severity);
	}

	protected void assertNoErrorMarker(IFile file) throws CoreException {
		int severity = file.findMaxProblemSeverity(null, true, IResource.DEPTH_INFINITE);
		if (severity != -1) {
			StringBuilder errors = new StringBuilder();
			for (IMarker marker : file.findMarkers(null, true, IResource.DEPTH_INFINITE)) {
				errors.append("\n").append(marker.getAttribute(IMarker.MESSAGE));
			}
			fail("Expected no error but got" + errors.toString());
		}
	}

}
