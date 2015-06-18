/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
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
  public FileSourceFolder findSourceFolderContaing(final URI member) {
    final Function1<FileSourceFolder, Boolean> _function = new Function1<FileSourceFolder, Boolean>() {
      @Override
      public Boolean apply(final FileSourceFolder source) {
        URI _path = source.getPath();
        URI _deresolve = member.deresolve(_path);
        return Boolean.valueOf(_deresolve.isRelative());
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
    URI _path = this.parent.getPath();
    return _path.appendSegment(this.name);
  }
  
  @Override
  public Set<FileSourceFolder> getSourceFolders() {
    return this.sourceFolders;
  }
  
  public FileProjectConfig(final FileWorkspaceConfig parent, final String name) {
    super();
    this.parent = parent;
    this.name = name;
  }
}
