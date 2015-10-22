/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.workspace;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfigProvider;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class EclipseWorkspaceConfigurationTest {
  @Inject
  private EclipseProjectConfigProvider projectConfigProvider;
  
  @Before
  public void setup() {
    Activator _instance = Activator.getInstance();
    final Injector injector = _instance.getInjector(
      Activator.ORG_ECLIPSE_XTEXT_UI_TESTS_EDITOR_CONTENTASSIST_DOMAINMODELTESTLANGUAGE);
    injector.injectMembers(this);
  }
  
  @After
  public void tearDown() {
    try {
      IResourcesSetupUtil.cleanWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConfig() {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      final IWorkspaceRoot wsroot = _workspace.getRoot();
      IProject[] _projects = wsroot.getProjects();
      for (final IProject p : _projects) {
        p.delete(true, true, null);
      }
      IProject[] _projects_1 = wsroot.getProjects();
      int _length = _projects_1.length;
      Assert.assertEquals(0, _length);
      final IJavaProject project = JavaProjectSetupUtil.createJavaProject("projectA");
      JavaProjectSetupUtil.createJavaProject("projectB");
      IProject _project = project.getProject();
      final EclipseProjectConfig projectConfig = this.projectConfigProvider.createProjectConfig(_project);
      Assert.assertNotNull(projectConfig);
      IWorkspaceConfig _workspaceConfig = projectConfig.getWorkspaceConfig();
      IProjectConfig _findProjectByName = _workspaceConfig.findProjectByName("projectB");
      Assert.assertNotNull(_findProjectByName);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
