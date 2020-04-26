/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.workspace;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfigProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class EclipseWorkspaceConfigurationTest {
	@Inject
	private EclipseProjectConfigProvider projectConfigProvider;

	@Before
	public void setup() {
		Injector injector = TestsActivator.getInstance()
				.getInjector(TestsActivator.ORG_ECLIPSE_XTEXT_UI_TESTS_EDITOR_CONTENTASSIST_DOMAINMODELTESTLANGUAGE);
		injector.injectMembers(this);
	}

	@After
	public void tearDown() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}

	@Test
	public void testConfig() throws Exception {
		IWorkspaceRoot wsroot = ResourcesPlugin.getWorkspace().getRoot();
		for (IProject p : wsroot.getProjects()) {
			p.delete(true, true, null);
		}
		Assert.assertEquals(0, wsroot.getProjects().length);
		IJavaProject project = JavaProjectSetupUtil.createJavaProject("projectA");
		JavaProjectSetupUtil.createJavaProject("projectB");
		EclipseProjectConfig projectConfig = projectConfigProvider.createProjectConfig(project.getProject());
		Assert.assertNotNull(projectConfig);
		Assert.assertNotNull(projectConfig.getWorkspaceConfig().findProjectByName("projectB"));
	}
}
