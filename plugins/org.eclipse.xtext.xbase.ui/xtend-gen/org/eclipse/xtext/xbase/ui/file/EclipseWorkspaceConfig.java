/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.file;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.xbase.file.IWorkspaceConfig;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.ui.file.EclipseProjectConfig;

@Data
@SuppressWarnings("all")
public class EclipseWorkspaceConfig implements IWorkspaceConfig {
  private final IWorkspaceRoot workspaceRoot;
  
  private final EclipseOutputConfigurationProvider configurationProvider;
  
  @Override
  public String getAbsoluteFileSystemPath() {
    IPath _location = this.workspaceRoot.getLocation();
    return _location.toString();
  }
  
  @Override
  public ProjectConfig getProject(final String name) {
    try {
      final IProject project = this.workspaceRoot.getProject(name);
      boolean _exists = project.exists();
      if (_exists) {
        return new EclipseProjectConfig(project, this.configurationProvider);
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
  public Collection<? extends ProjectConfig> getProjects() {
    IProject[] _projects = this.workspaceRoot.getProjects();
    final Function1<IProject, EclipseProjectConfig> _function = new Function1<IProject, EclipseProjectConfig>() {
      @Override
      public EclipseProjectConfig apply(final IProject it) {
        return new EclipseProjectConfig(it, EclipseWorkspaceConfig.this.configurationProvider);
      }
    };
    List<EclipseProjectConfig> _map = ListExtensions.<IProject, EclipseProjectConfig>map(((List<IProject>)Conversions.doWrapArray(_projects)), _function);
    return Collections.<EclipseProjectConfig>unmodifiableList(_map);
  }
  
  public EclipseWorkspaceConfig(final IWorkspaceRoot workspaceRoot, final EclipseOutputConfigurationProvider configurationProvider) {
    super();
    this.workspaceRoot = workspaceRoot;
    this.configurationProvider = configurationProvider;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.workspaceRoot== null) ? 0 : this.workspaceRoot.hashCode());
    result = prime * result + ((this.configurationProvider== null) ? 0 : this.configurationProvider.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EclipseWorkspaceConfig other = (EclipseWorkspaceConfig) obj;
    if (this.workspaceRoot == null) {
      if (other.workspaceRoot != null)
        return false;
    } else if (!this.workspaceRoot.equals(other.workspaceRoot))
      return false;
    if (this.configurationProvider == null) {
      if (other.configurationProvider != null)
        return false;
    } else if (!this.configurationProvider.equals(other.configurationProvider))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("workspaceRoot", this.workspaceRoot);
    b.add("configurationProvider", this.configurationProvider);
    return b.toString();
  }
  
  @Pure
  public IWorkspaceRoot getWorkspaceRoot() {
    return this.workspaceRoot;
  }
  
  @Pure
  public EclipseOutputConfigurationProvider getConfigurationProvider() {
    return this.configurationProvider;
  }
}
