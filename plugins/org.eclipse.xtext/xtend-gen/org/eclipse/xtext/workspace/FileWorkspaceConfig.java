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
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@FinalFieldsConstructor
@ToString
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
        String _string = member.toString();
        URI _path = FileWorkspaceConfig.this.getPath();
        String _string_1 = _path.toString();
        return Boolean.valueOf(_string.startsWith(_string_1));
      }
    };
    return IterableExtensions.<FileProjectConfig>findFirst(_values, _function);
  }
  
  public URI getPath() {
    String _path = this.root.getPath();
    return URI.createFileURI(_path);
  }
  
  @Override
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
  
  public FileWorkspaceConfig(final File root) {
    super();
    this.root = root;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("root", this.root);
    b.add("projects", this.projects);
    return b.toString();
  }
}
