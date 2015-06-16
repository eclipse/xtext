/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.workspace;

import java.util.List;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseWorkspaceConfigProvider;
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
  private final EclipseWorkspaceConfigProvider provider;
  
  private final IWorkspaceRoot workspaceRoot;
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    try {
      final IProject project = this.workspaceRoot.getProject(name);
      boolean _exists = project.exists();
      if (_exists) {
        return this.provider.getProjectConfig(project);
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
    boolean _isPlatformResource = member.isPlatformResource();
    if (_isPlatformResource) {
      String _segment = member.segment(1);
      return this.findProjectByName(_segment);
    }
    return null;
  }
  
  @Override
  public Set<? extends IProjectConfig> getProjects() {
    IProject[] _projects = this.workspaceRoot.getProjects();
    final Function1<IProject, EclipseProjectConfig> _function = new Function1<IProject, EclipseProjectConfig>() {
      @Override
      public EclipseProjectConfig apply(final IProject it) {
        return EclipseWorkspaceConfig.this.provider.getProjectConfig(it);
      }
    };
    List<EclipseProjectConfig> _map = ListExtensions.<IProject, EclipseProjectConfig>map(((List<IProject>)Conversions.doWrapArray(_projects)), _function);
    return IterableExtensions.<EclipseProjectConfig>toSet(_map);
  }
  
  public EclipseWorkspaceConfig(final EclipseWorkspaceConfigProvider provider, final IWorkspaceRoot workspaceRoot) {
    super();
    this.provider = provider;
    this.workspaceRoot = workspaceRoot;
  }
}
