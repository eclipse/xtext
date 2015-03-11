/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.file;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.ui.file.EclipseWorkspaceConfig;

@SuppressWarnings("all")
public class EclipseWorkspaceConfigProvider implements Provider<WorkspaceConfig> {
  @Accessors
  @Inject
  private IWorkspaceRoot workspaceRoot;
  
  @Accessors
  @Inject
  private EclipseOutputConfigurationProvider configurationProvider;
  
  @Override
  public WorkspaceConfig get() {
    final EclipseWorkspaceConfig result = new EclipseWorkspaceConfig(this.workspaceRoot, this.configurationProvider);
    return result;
  }
  
  @Pure
  public IWorkspaceRoot getWorkspaceRoot() {
    return this.workspaceRoot;
  }
  
  public void setWorkspaceRoot(final IWorkspaceRoot workspaceRoot) {
    this.workspaceRoot = workspaceRoot;
  }
  
  @Pure
  public EclipseOutputConfigurationProvider getConfigurationProvider() {
    return this.configurationProvider;
  }
  
  public void setConfigurationProvider(final EclipseOutputConfigurationProvider configurationProvider) {
    this.configurationProvider = configurationProvider;
  }
}
