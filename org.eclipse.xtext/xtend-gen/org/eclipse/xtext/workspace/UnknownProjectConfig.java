/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class UnknownProjectConfig implements IProjectConfig {
  private final String name = "__unknown_project";
  
  private final IWorkspaceConfig workspaceConfig;
  
  @Override
  public ISourceFolder findSourceFolderContaining(final URI member) {
    return null;
  }
  
  @Override
  public URI getPath() {
    return null;
  }
  
  @Override
  public Set<? extends ISourceFolder> getSourceFolders() {
    return CollectionLiterals.<ISourceFolder>emptySet();
  }
  
  public UnknownProjectConfig(final IWorkspaceConfig workspaceConfig) {
    super();
    this.workspaceConfig = workspaceConfig;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  @Pure
  public IWorkspaceConfig getWorkspaceConfig() {
    return this.workspaceConfig;
  }
}
