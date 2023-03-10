/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.core.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.testing.util.PluginUtil;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.ui.util.WorkspaceClasspathUriResolver;
import org.junit.Before;
import org.junit.Test;

public class WorkspaceClasspathUriResolverTest extends AbstractClasspathUriResolverTest {

	private IJavaProject _javaProject;
	private IClasspathUriResolver _resolver;

	@Before
	public void setUp() throws Exception {
		_resolver = new WorkspaceClasspathUriResolver();
	}

	@Test public void testClasspathUriForFileInWorkspace() throws Exception {
		_javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		_project = _javaProject.getProject();
		PluginUtil.copyFileToWorkspace(TestsActivator.getInstance(), "/testfiles/" + MODEL_FILE, _project, "src/"
				+ MODEL_FILE);
		URI classpathUri = URI.createURI("classpath:/" + MODEL_FILE);
		String expectedUri = "platform:/resource/" + TEST_PROJECT_NAME + "/src/" + MODEL_FILE;
		URI normalizedUri = _resolver.resolve(_project, classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, expectedUri);
	}

	@Test public void testClasspathUriForFileInWorkspaceWithFragment() throws Exception {
		_javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		_project = _javaProject.getProject();
		PluginUtil.copyFileToWorkspace(TestsActivator.getInstance(), "/testfiles/" + MODEL_FILE, _project, "src/"
				+ MODEL_FILE);
		URI classpathUri = URI.createURI("classpath:/" + MODEL_FILE + "#/");
		String expectedUri = "platform:/resource/" + TEST_PROJECT_NAME + "/src/" + MODEL_FILE + "#/";
		URI normalizedUri = _resolver.resolve(_project, classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, expectedUri);
	}

	@Test public void testClasspathUriForFileInJarInWorkspace() throws Exception {
		_javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		_project = _javaProject.getProject();
		IFile jarFile = PluginUtil.copyFileToWorkspace(TestsActivator.getInstance(), "/testfiles/" + JAR_FILE, _project, "/"
				+ JAR_FILE);
		JavaProjectSetupUtil.addJarToClasspath(_javaProject, jarFile);
		URI classpathUri = URI.createURI("classpath:/model/" + MODEL_FILE);
		String expectedUri = "archive:platform:/resource/" + TEST_PROJECT_NAME + "/" + JAR_FILE + "!/model/" + MODEL_FILE;
		URI normalizedUri = _resolver.resolve(_project, classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, expectedUri);
	}

	@Test public void testClasspathUriForFileInJarInWorkspaceWithFragment() throws Exception {
		_javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		_project = _javaProject.getProject();
		IFile jarFile = PluginUtil.copyFileToWorkspace(TestsActivator.getInstance(), "/testfiles/" + JAR_FILE, _project, "/"
				+ JAR_FILE);
		JavaProjectSetupUtil.addJarToClasspath(_javaProject, jarFile);
		URI classpathUri = URI.createURI("classpath:/model/" + MODEL_FILE + "#/");
		String expectedUri = "archive:platform:/resource/" + TEST_PROJECT_NAME + "/" + JAR_FILE + "!/model/" + MODEL_FILE + "#/";
		URI normalizedUri = _resolver.resolve(_project, classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, expectedUri);
	}

}
