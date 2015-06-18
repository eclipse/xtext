/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.file;

import java.util.List;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.ui.file.EclipseProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class EclipseWorkspaceConfig implements IWorkspaceConfig {
  private final IWorkspaceRoot workspaceRoot;
  
  private final Resource context;
  
  private final IContextualOutputConfigurationProvider configurationProvider;
  
  @Override
  public URI getPath() {
    return URI.createPlatformResourceURI("/", true);
  }
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    try {
      final IProject project = this.workspaceRoot.getProject(name);
      boolean _exists = project.exists();
      if (_exists) {
        return new EclipseProjectConfig(project, this.context, this.configurationProvider);
      }
      return null;
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public IProjectConfig findProjectContaining(final URI member) {
    Set<? extends IProjectConfig> _projects = this.getProjects();
    final Function1<IProjectConfig, Boolean> _function = new Function1<IProjectConfig, Boolean>() {
      @Override
      public Boolean apply(final IProjectConfig project) {
        URI _path = project.getPath();
        URI _deresolve = member.deresolve(_path);
        return Boolean.valueOf(_deresolve.isRelative());
      }
    };
    return IterableExtensions.findFirst(_projects, _function);
  }
  
  @Override
  public Set<? extends IProjectConfig> getProjects() {
    IProject[] _projects = this.workspaceRoot.getProjects();
    final Function1<IProject, EclipseProjectConfig> _function = new Function1<IProject, EclipseProjectConfig>() {
      @Override
      public EclipseProjectConfig apply(final IProject it) {
        return new EclipseProjectConfig(it, EclipseWorkspaceConfig.this.context, EclipseWorkspaceConfig.this.configurationProvider);
      }
    };
    List<EclipseProjectConfig> _map = ListExtensions.<IProject, EclipseProjectConfig>map(((List<IProject>)Conversions.doWrapArray(_projects)), _function);
    return IterableExtensions.<EclipseProjectConfig>toSet(_map);
  }
  
  public EclipseWorkspaceConfig(final IWorkspaceRoot workspaceRoot, final Resource context, final IContextualOutputConfigurationProvider configurationProvider) {
    super();
    this.workspaceRoot = workspaceRoot;
    this.context = context;
    this.configurationProvider = configurationProvider;
  }
}
