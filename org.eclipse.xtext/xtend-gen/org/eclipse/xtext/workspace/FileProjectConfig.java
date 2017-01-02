/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import com.google.common.base.Objects;
import java.io.File;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.FileSourceFolder;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.SingleProjectWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FileProjectConfig implements IProjectConfig {
  private final URI path;
  
  private final String name;
  
  private final Set<FileSourceFolder> sourceFolders = CollectionLiterals.<FileSourceFolder>newHashSet();
  
  public FileProjectConfig(final URI path) {
    this(path, path.lastSegment());
  }
  
  public FileProjectConfig(final URI path, final String name) {
    this.path = path;
    this.name = name;
  }
  
  public FileProjectConfig(final File root, final String name) {
    this(UriUtil.createFolderURI(root), name);
  }
  
  public FileProjectConfig(final File root) {
    this(UriUtil.createFolderURI(root), root.getName());
  }
  
  public FileSourceFolder addSourceFolder(final String relativePath) {
    FileSourceFolder _xblockexpression = null;
    {
      final FileSourceFolder sourceFolder = new FileSourceFolder(this, relativePath);
      this.sourceFolders.add(sourceFolder);
      _xblockexpression = sourceFolder;
    }
    return _xblockexpression;
  }
  
  @Override
  public FileSourceFolder findSourceFolderContaining(final URI member) {
    final Function1<FileSourceFolder, Boolean> _function = (FileSourceFolder source) -> {
      return Boolean.valueOf(UriUtil.isPrefixOf(source.getPath(), member));
    };
    return IterableExtensions.<FileSourceFolder>findFirst(this.sourceFolders, _function);
  }
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  public URI getPath() {
    return this.path;
  }
  
  @Override
  public Set<FileSourceFolder> getSourceFolders() {
    return this.sourceFolders;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if ((obj instanceof FileProjectConfig)) {
      return Objects.equal(this.path, ((FileProjectConfig)obj).path);
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    return this.path.hashCode();
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Project ");
    _builder.append(this.name);
    _builder.append(" (");
    _builder.append(this.path);
    _builder.append(")");
    return _builder.toString();
  }
  
  @Override
  public IWorkspaceConfig getWorkspaceConfig() {
    return new SingleProjectWorkspaceConfig(this);
  }
}
