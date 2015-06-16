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
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
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
  
  private final Set<FileProjectConfig> projects = CollectionLiterals.<FileProjectConfig>newHashSet();
  
  public FileProjectConfig addProject(final String name) {
    FileProjectConfig _xblockexpression = null;
    {
      final FileProjectConfig project = new FileProjectConfig(this, name);
      this.projects.add(project);
      _xblockexpression = project;
    }
    return _xblockexpression;
  }
  
  @Override
  public FileProjectConfig findProjectContaining(final URI member) {
    final Function1<FileProjectConfig, Boolean> _function = new Function1<FileProjectConfig, Boolean>() {
      @Override
      public Boolean apply(final FileProjectConfig project) {
        URI _path = project.getPath();
        URI _deresolve = member.deresolve(_path);
        return Boolean.valueOf(_deresolve.isRelative());
      }
    };
    return IterableExtensions.<FileProjectConfig>findFirst(this.projects, _function);
  }
  
  @Override
  public URI getPath() {
    String _path = this.root.getPath();
    return URI.createFileURI(_path);
  }
  
  @Override
  public Set<FileProjectConfig> getProjects() {
    return this.projects;
  }
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    final Function1<FileProjectConfig, Boolean> _function = new Function1<FileProjectConfig, Boolean>() {
      @Override
      public Boolean apply(final FileProjectConfig project) {
        String _name = project.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<FileProjectConfig>findFirst(this.projects, _function);
  }
  
  public FileWorkspaceConfig(final File root) {
    super();
    this.root = root;
  }
}
