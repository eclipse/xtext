/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.workspace;

import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfigProvider;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class EclipseWorkspaceConfig implements IWorkspaceConfig {
  private final IWorkspaceRoot workspaceRoot;
  
  private final EclipseProjectConfigProvider projectConfigProvider;
  
  @Override
  public Set<? extends EclipseProjectConfig> getProjects() {
    final Function1<IProject, Boolean> _function = (IProject it) -> {
      return Boolean.valueOf(it.getProject().isAccessible());
    };
    final Function1<IProject, EclipseProjectConfig> _function_1 = (IProject it) -> {
      return this.projectConfigProvider.createProjectConfig(it.getProject());
    };
    return IterableExtensions.<EclipseProjectConfig>toSet(IterableExtensions.<IProject, EclipseProjectConfig>map(IterableExtensions.<IProject>filter(((Iterable<IProject>)Conversions.doWrapArray(this.workspaceRoot.getProjects())), _function), _function_1));
  }
  
  @Override
  public EclipseProjectConfig findProjectByName(final String name) {
    try {
      final IProject project = this.workspaceRoot.getProject(name);
      boolean _isAccessible = project.isAccessible();
      if (_isAccessible) {
        return this.projectConfigProvider.createProjectConfig(project);
      }
      return null;
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
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
      return this.findProjectByName(URI.decode(member.segment(1)));
    }
    return null;
  }
  
  public EclipseWorkspaceConfig(final IWorkspaceRoot workspaceRoot, final EclipseProjectConfigProvider projectConfigProvider) {
    super();
    this.workspaceRoot = workspaceRoot;
    this.projectConfigProvider = projectConfigProvider;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.workspaceRoot== null) ? 0 : this.workspaceRoot.hashCode());
    return prime * result + ((this.projectConfigProvider== null) ? 0 : this.projectConfigProvider.hashCode());
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
    if (this.projectConfigProvider == null) {
      if (other.projectConfigProvider != null)
        return false;
    } else if (!this.projectConfigProvider.equals(other.projectConfigProvider))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("workspaceRoot", this.workspaceRoot);
    b.add("projectConfigProvider", this.projectConfigProvider);
    return b.toString();
  }
  
  @Pure
  public IWorkspaceRoot getWorkspaceRoot() {
    return this.workspaceRoot;
  }
  
  @Pure
  public EclipseProjectConfigProvider getProjectConfigProvider() {
    return this.projectConfigProvider;
  }
}
