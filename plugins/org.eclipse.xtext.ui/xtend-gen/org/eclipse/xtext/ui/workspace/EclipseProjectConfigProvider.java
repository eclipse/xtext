/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.workspace;

import com.google.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.JdtProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;

@SuppressWarnings("all")
public class EclipseProjectConfigProvider implements IProjectConfigProvider {
  @Inject
  private IJdtHelper jdtHelper;
  
  @Override
  public IProjectConfig getProjectConfig(final ResourceSet context) {
    ProjectConfigAdapter _findInEmfObject = ProjectConfigAdapter.findInEmfObject(context);
    IProjectConfig _projectConfig = null;
    if (_findInEmfObject!=null) {
      _projectConfig=_findInEmfObject.getProjectConfig();
    }
    return _projectConfig;
  }
  
  public void installProjectConfig(final IProject eclipseProject, final ResourceSet resourceSet) {
    final EclipseProjectConfig config = this.createProjectConfig(eclipseProject);
    ProjectConfigAdapter _projectConfigAdapter = new ProjectConfigAdapter(config);
    _projectConfigAdapter.attachToEmfObject(resourceSet);
  }
  
  public EclipseProjectConfig createProjectConfig(final IProject eclipseProject) {
    EclipseProjectConfig _xifexpression = null;
    boolean _isJavaCoreAvailable = this.jdtHelper.isJavaCoreAvailable();
    if (_isJavaCoreAvailable) {
      _xifexpression = new JdtProjectConfig(eclipseProject);
    } else {
      _xifexpression = new EclipseProjectConfig(eclipseProject);
    }
    return _xifexpression;
  }
}
