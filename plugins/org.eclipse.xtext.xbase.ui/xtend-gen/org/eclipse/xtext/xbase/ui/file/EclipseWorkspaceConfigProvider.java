/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.file;

import com.google.inject.Inject;
import java.util.Map;
import javax.inject.Provider;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.ui.file.EclipseProjectConfig;

@SuppressWarnings("all")
public class EclipseWorkspaceConfigProvider implements Provider<WorkspaceConfig> {
  @Inject
  private IWorkspaceRoot workspaceRoot;
  
  @Inject
  private EclipseOutputConfigurationProvider configurationProvider;
  
  public WorkspaceConfig get() {
    IPath _location = this.workspaceRoot.getLocation();
    final String wsRoot = _location.toString();
    WorkspaceConfig _workspaceConfig = new WorkspaceConfig(wsRoot);
    final WorkspaceConfig result = _workspaceConfig;
    IProject[] _projects = this.workspaceRoot.getProjects();
    final Procedure1<IProject> _function = new Procedure1<IProject>() {
      public void apply(final IProject it) {
        Map<String,ProjectConfig> _projects = result.getProjects();
        String _name = it.getName();
        EclipseProjectConfig _eclipseProjectConfig = new EclipseProjectConfig(it, EclipseWorkspaceConfigProvider.this.configurationProvider);
        _projects.put(_name, _eclipseProjectConfig);
      }
    };
    IterableExtensions.<IProject>forEach(((Iterable<IProject>)Conversions.doWrapArray(_projects)), _function);
    return result;
  }
}
