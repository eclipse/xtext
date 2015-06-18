/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.filesystem;

import com.google.common.base.Objects;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.filesystem.IdeaModuleConfig;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class IdeaWorkspaceConfig implements IWorkspaceConfig {
  private final Project project;
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    Set<? extends IProjectConfig> _projects = this.getProjects();
    final Function1<IProjectConfig, Boolean> _function = new Function1<IProjectConfig, Boolean>() {
      @Override
      public Boolean apply(final IProjectConfig it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.findFirst(_projects, _function);
  }
  
  @Override
  public IProjectConfig findProjectContaining(final URI member) {
    try {
      IdeaModuleConfig _xblockexpression = null;
      {
        String _string = member.toString();
        URL _uRL = new URL(_string);
        final VirtualFile file = VfsUtil.findFileByURL(_uRL);
        ProjectRootManager _instance = ProjectRootManager.getInstance(this.project);
        ProjectFileIndex _fileIndex = _instance.getFileIndex();
        final Module module = _fileIndex.getModuleForFile(file);
        _xblockexpression = new IdeaModuleConfig(module);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public URI getPath() {
    VirtualFile _baseDir = this.project.getBaseDir();
    String _url = _baseDir.getUrl();
    return URI.createURI(_url);
  }
  
  @Override
  public Set<? extends IProjectConfig> getProjects() {
    Set<IdeaModuleConfig> _xblockexpression = null;
    {
      ModuleManager _instance = ModuleManager.getInstance(this.project);
      final Module[] modules = _instance.getModules();
      final Function1<Module, IdeaModuleConfig> _function = new Function1<Module, IdeaModuleConfig>() {
        @Override
        public IdeaModuleConfig apply(final Module it) {
          return new IdeaModuleConfig(it);
        }
      };
      List<IdeaModuleConfig> _map = ListExtensions.<Module, IdeaModuleConfig>map(((List<Module>)Conversions.doWrapArray(modules)), _function);
      _xblockexpression = IterableExtensions.<IdeaModuleConfig>toSet(_map);
    }
    return _xblockexpression;
  }
  
  public IdeaWorkspaceConfig(final Project project) {
    super();
    this.project = project;
  }
}
