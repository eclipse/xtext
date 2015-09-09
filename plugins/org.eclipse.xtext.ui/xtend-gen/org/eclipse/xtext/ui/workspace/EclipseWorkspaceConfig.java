/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.workspace;

import com.google.common.base.Objects;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseWorkspaceConfigProvider;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class EclipseWorkspaceConfig implements IWorkspaceConfig {
  private final EclipseWorkspaceConfigProvider provider;
  
  private final IWorkspaceRoot workspaceRoot;
  
  @Override
  public Set<? extends EclipseProjectConfig> getProjects() {
    IProject[] _projects = this.workspaceRoot.getProjects();
    final Function1<IProject, Boolean> _function = new Function1<IProject, Boolean>() {
      @Override
      public Boolean apply(final IProject it) {
        IProject _project = it.getProject();
        return Boolean.valueOf(_project.exists());
      }
    };
    Iterable<IProject> _filter = IterableExtensions.<IProject>filter(((Iterable<IProject>)Conversions.doWrapArray(_projects)), _function);
    final Function1<IProject, EclipseProjectConfig> _function_1 = new Function1<IProject, EclipseProjectConfig>() {
      @Override
      public EclipseProjectConfig apply(final IProject it) {
        IProject _project = it.getProject();
        return EclipseWorkspaceConfig.this.provider.getProjectConfig(_project);
      }
    };
    Iterable<EclipseProjectConfig> _map = IterableExtensions.<IProject, EclipseProjectConfig>map(_filter, _function_1);
    return IterableExtensions.<EclipseProjectConfig>toSet(_map);
  }
  
  @Override
  public EclipseProjectConfig findProjectByName(final String name) {
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
  public EclipseProjectConfig findProjectContaining(final URI member) {
    boolean _isPlatformResource = member.isPlatformResource();
    if (_isPlatformResource) {
      String _segment = member.segment(1);
      return this.findProjectByName(_segment);
    }
    return null;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if ((obj instanceof EclipseWorkspaceConfig)) {
      return Objects.equal(((EclipseWorkspaceConfig)obj).workspaceRoot, this.workspaceRoot);
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    return this.workspaceRoot.hashCode();
  }
  
  @Override
  public String toString() {
    return this.workspaceRoot.toString();
  }
  
  public EclipseWorkspaceConfig(final EclipseWorkspaceConfigProvider provider, final IWorkspaceRoot workspaceRoot) {
    super();
    this.provider = provider;
    this.workspaceRoot = workspaceRoot;
  }
}
