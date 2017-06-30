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
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.InMemoryWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class InMemoryProjectConfig implements IProjectConfig {
  private final URI path;
  
  private final IWorkspaceConfig workspaceConfig;
  
  private String name = "inmemory";
  
  public InMemoryProjectConfig() {
    this(URI.createURI("inmemory:/"));
  }
  
  public InMemoryProjectConfig(final URI path) {
    this.path = path;
    InMemoryWorkspaceConfig _inMemoryWorkspaceConfig = new InMemoryWorkspaceConfig(this);
    this.workspaceConfig = _inMemoryWorkspaceConfig;
  }
  
  @Override
  public Set<? extends ISourceFolder> getSourceFolders() {
    return CollectionLiterals.<ISourceFolder>emptySet();
  }
  
  @Override
  public ISourceFolder findSourceFolderContaining(final URI member) {
    return null;
  }
  
  @Pure
  public URI getPath() {
    return this.path;
  }
  
  @Pure
  public IWorkspaceConfig getWorkspaceConfig() {
    return this.workspaceConfig;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
}
