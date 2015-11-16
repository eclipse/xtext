/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;

@SuppressWarnings("all")
public class ProjectConfigProvider implements IProjectConfigProvider {
  @Override
  public IProjectConfig getProjectConfig(final ResourceSet context) {
    ProjectConfigAdapter _findInEmfObject = ProjectConfigAdapter.findInEmfObject(context);
    IProjectConfig _projectConfig = null;
    if (_findInEmfObject!=null) {
      _projectConfig=_findInEmfObject.getProjectConfig();
    }
    return _projectConfig;
  }
}
