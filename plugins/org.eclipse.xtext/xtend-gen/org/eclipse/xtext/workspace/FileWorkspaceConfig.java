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
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class FileWorkspaceConfig implements IWorkspaceConfig {
  private final File root;
  
  private final Map<String, FileProjectConfig> projects = CollectionLiterals.<String, FileProjectConfig>newHashMap();
  
  public FileProjectConfig addProject(final String name) {
    FileProjectConfig _xblockexpression = null;
    {
      final FileProjectConfig project = new FileProjectConfig(this, name);
      String _name = project.getName();
      this.projects.put(_name, project);
      _xblockexpression = project;
    }
    return _xblockexpression;
  }
  
  @Override
  public FileProjectConfig findProjectContaining(final URI member) {
    Collection<FileProjectConfig> _values = this.projects.values();
    final Function1<FileProjectConfig, Boolean> _function = new Function1<FileProjectConfig, Boolean>() {
      @Override
      public Boolean apply(final FileProjectConfig project) {
        URI _path = project.getPath();
        return Boolean.valueOf(UriUtil.isPrefixOf(_path, member));
      }
    };
    return IterableExtensions.<FileProjectConfig>findFirst(_values, _function);
  }
  
  public URI getPath() {
    URI _xblockexpression = null;
    {
      String _path = this.root.getPath();
      final URI path = URI.createFileURI(_path);
      URI _xifexpression = null;
      boolean _hasTrailingPathSeparator = path.hasTrailingPathSeparator();
      if (_hasTrailingPathSeparator) {
        _xifexpression = path;
      } else {
        _xifexpression = path.appendSegment("");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public Set<FileProjectConfig> getProjects() {
    Collection<FileProjectConfig> _values = this.projects.values();
    return IterableExtensions.<FileProjectConfig>toSet(_values);
  }
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    return this.projects.get(name);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if ((obj instanceof FileWorkspaceConfig)) {
      URI _path = this.getPath();
      URI _path_1 = ((FileWorkspaceConfig)obj).getPath();
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
    _builder.append("Workspace (");
    URI _path = this.getPath();
    _builder.append(_path, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  public FileWorkspaceConfig(final File root) {
    super();
    this.root = root;
  }
}
