/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.workspace;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseWorkspaceConfig;
import org.eclipse.xtext.ui.workspace.EclipseWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class EclipseWorkspaceConfigurationTest {
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
      JavaProjectSetupUtil.createJavaProject("projectA");
      EclipseWorkspaceConfigProvider _eclipseWorkspaceConfigProvider = new EclipseWorkspaceConfigProvider();
      final Procedure1<EclipseWorkspaceConfigProvider> _function = new Procedure1<EclipseWorkspaceConfigProvider>() {
        @Override
        public void apply(final EclipseWorkspaceConfigProvider it) {
          IWorkspace _workspace = ResourcesPlugin.getWorkspace();
          it.setWorkspace(_workspace);
        }
      };
      final EclipseWorkspaceConfigProvider provider = ObjectExtensions.<EclipseWorkspaceConfigProvider>operator_doubleArrow(_eclipseWorkspaceConfigProvider, _function);
      EclipseWorkspaceConfig _workspaceConfig = provider.getWorkspaceConfig(null);
      final EclipseProjectConfig project = _workspaceConfig.findProjectByName("projectA");
      Assert.assertNotNull(project);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
