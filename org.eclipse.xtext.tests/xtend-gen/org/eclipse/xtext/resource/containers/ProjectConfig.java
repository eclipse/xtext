/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.containers;

import java.io.File;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.resource.containers.SourceFolder;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors(AccessorType.PUBLIC_GETTER)
@SuppressWarnings("all")
public class ProjectConfig implements IProjectConfig {
  private URI path;
  
  private Set<SourceFolder> sourceFolders = CollectionLiterals.<SourceFolder>newHashSet();
  
  private String name;
  
  private IWorkspaceConfig workspaceConfig;
  
  public ProjectConfig(final String name, final WorkspaceConfig workspaceConfig) {
    this.name = name;
    this.path = URI.createURI(new File(name).getAbsoluteFile().toURI().toString()).appendSegment("");
    URI _appendSegment = this.path.trimSegments(1).appendSegment("src").appendSegment("");
    SourceFolder _sourceFolder = new SourceFolder(_appendSegment);
    this.sourceFolders.add(_sourceFolder);
    this.workspaceConfig = workspaceConfig;
    workspaceConfig.addProject(this);
  }
  
  @Override
  public ISourceFolder findSourceFolderContaining(final URI member) {
    final Function1<SourceFolder, Boolean> _function = (SourceFolder it) -> {
      return Boolean.valueOf(UriUtil.isPrefixOf(this.path, member));
    };
    return IterableExtensions.<SourceFolder>findFirst(this.sourceFolders, _function);
  }
  
  @Pure
  public URI getPath() {
    return this.path;
  }
  
  @Pure
  public Set<SourceFolder> getSourceFolders() {
    return this.sourceFolders;
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
