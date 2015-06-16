/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.file;

import com.google.inject.Inject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.ui.file.EclipseWorkspaceConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class EclipseWorkspaceConfigProvider implements IWorkspaceConfigProvider {
  @Accessors
  @Inject
  private IWorkspaceRoot workspaceRoot;
  
  @Accessors
  @Inject
  private IContextualOutputConfigurationProvider configurationProvider;
  
  @Override
  public IWorkspaceConfig getWorkspaceConfig(final Resource context) {
    return new EclipseWorkspaceConfig(this.workspaceRoot, context, this.configurationProvider);
  }
  
  @Pure
  public IWorkspaceRoot getWorkspaceRoot() {
    return this.workspaceRoot;
  }
  
  public void setWorkspaceRoot(final IWorkspaceRoot workspaceRoot) {
    this.workspaceRoot = workspaceRoot;
  }
  
  @Pure
  public IContextualOutputConfigurationProvider getConfigurationProvider() {
    return this.configurationProvider;
  }
  
  public void setConfigurationProvider(final IContextualOutputConfigurationProvider configurationProvider) {
    this.configurationProvider = configurationProvider;
  }
}
