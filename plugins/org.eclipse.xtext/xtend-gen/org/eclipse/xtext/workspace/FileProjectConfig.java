/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import com.google.common.base.Objects;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.FileSourceFolder;
import org.eclipse.xtext.workspace.FileWorkspaceConfig;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class FileProjectConfig implements IProjectConfig {
  private final FileWorkspaceConfig parent;
  
  private final String name;
  
  private final Set<FileSourceFolder> sourceFolders = CollectionLiterals.<FileSourceFolder>newHashSet();
  
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
    final Function1<FileSourceFolder, Boolean> _function = new Function1<FileSourceFolder, Boolean>() {
      @Override
      public Boolean apply(final FileSourceFolder source) {
        URI _path = source.getPath();
        return Boolean.valueOf(UriUtil.isPrefixOf(_path, member));
      }
    };
    return IterableExtensions.<FileSourceFolder>findFirst(this.sourceFolders, _function);
  }
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  public URI getPath() {
    URI _createFileURI = URI.createFileURI(this.name);
    URI _path = this.parent.getPath();
    URI _resolve = _createFileURI.resolve(_path);
    return _resolve.appendSegment("");
  }
  
  @Override
  public Set<FileSourceFolder> getSourceFolders() {
    return this.sourceFolders;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if ((obj instanceof FileProjectConfig)) {
      URI _path = this.getPath();
      URI _path_1 = ((FileProjectConfig)obj).getPath();
      return Objects.equal(_path, _path_1);
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    URI _path = this.getPath();
    return _path.hashCode();
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Project ");
    _builder.append(this.name, "");
    _builder.append(" (");
    URI _path = this.getPath();
    _builder.append(_path, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  public FileProjectConfig(final FileWorkspaceConfig parent, final String name) {
    super();
    this.parent = parent;
    this.name = name;
  }
}
