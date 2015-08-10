/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.workspace;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseWorkspaceConfig;
import org.eclipse.xtext.ui.workspace.JdtProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class EclipseWorkspaceConfigProvider implements IWorkspaceConfigProvider {
  @Accessors
  @Inject
  private IWorkspace workspace;
  
  @Inject
  private IJdtHelper jdtHelper;
  
  @Override
  public IWorkspaceConfig getWorkspaceConfig(final ResourceSet context) {
    IWorkspaceRoot _root = this.workspace.getRoot();
    return new EclipseWorkspaceConfig(this, _root);
  }
  
  public EclipseProjectConfig getProjectConfig(final IProject project) {
    boolean _isJavaCoreAvailable = this.jdtHelper.isJavaCoreAvailable();
    if (_isJavaCoreAvailable) {
      return new Provider<EclipseProjectConfig>() {
        @Override
        public EclipseProjectConfig get() {
          return new JdtProjectConfig(project);
        }
      }.get();
    }
    return new EclipseProjectConfig(project);
  }
  
  @Pure
  public IWorkspace getWorkspace() {
    return this.workspace;
  }
  
  public void setWorkspace(final IWorkspace workspace) {
    this.workspace = workspace;
  }
}
