/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.workspace;

import com.google.common.base.Objects;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ui.workspace.EclipseWorkspaceConfigProvider;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Exceptions;

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
