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
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.idea.filesystem.IdeaModuleConfig;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class IdeaWorkspaceConfig implements IWorkspaceConfig {
  private final Project project;
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    ModuleManager _instance = ModuleManager.getInstance(this.project);
    final Module module = _instance.findModuleByName(name);
    boolean _equals = Objects.equal(module, null);
    if (_equals) {
      return null;
    }
    return new IdeaModuleConfig(module);
  }
  
  @Override
  public IProjectConfig findProjectContaining(final URI member) {
    VirtualFileManager _instance = VirtualFileManager.getInstance();
    String _string = member.toString();
    final VirtualFile file = _instance.findFileByUrl(_string);
    boolean _equals = Objects.equal(file, null);
    if (_equals) {
      return null;
    }
    ProjectRootManager _instance_1 = ProjectRootManager.getInstance(this.project);
    ProjectFileIndex _fileIndex = _instance_1.getFileIndex();
    final Module module = _fileIndex.getModuleForFile(file);
    boolean _equals_1 = Objects.equal(module, null);
    if (_equals_1) {
      return null;
    }
    return new IdeaModuleConfig(module);
  }
  
  @Override
  public Set<? extends IProjectConfig> getProjects() {
    Set<IdeaModuleConfig> _xblockexpression = null;
    {
      ModuleManager _instance = ModuleManager.getInstance(this.project);
      final Module[] modules = _instance.getModules();
      final Function1<Module, Boolean> _function = new Function1<Module, Boolean>() {
        @Override
        public Boolean apply(final Module it) {
          ModuleRootManager _instance = ModuleRootManager.getInstance(it);
          ContentEntry[] _contentEntries = _instance.getContentEntries();
          boolean _isEmpty = ((List<ContentEntry>)Conversions.doWrapArray(_contentEntries)).isEmpty();
          return Boolean.valueOf((!_isEmpty));
        }
      };
      final Iterable<Module> usableModules = IterableExtensions.<Module>filter(((Iterable<Module>)Conversions.doWrapArray(modules)), _function);
      final Function1<Module, IdeaModuleConfig> _function_1 = new Function1<Module, IdeaModuleConfig>() {
        @Override
        public IdeaModuleConfig apply(final Module it) {
          return new IdeaModuleConfig(it);
        }
      };
      Iterable<IdeaModuleConfig> _map = IterableExtensions.<Module, IdeaModuleConfig>map(usableModules, _function_1);
      _xblockexpression = IterableExtensions.<IdeaModuleConfig>toSet(_map);
    }
    return _xblockexpression;
  }
  
  public IdeaWorkspaceConfig(final Project project) {
    super();
    this.project = project;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.project== null) ? 0 : this.project.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    IdeaWorkspaceConfig other = (IdeaWorkspaceConfig) obj;
    if (this.project == null) {
      if (other.project != null)
        return false;
    } else if (!this.project.equals(other.project))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("project", this.project);
    return b.toString();
  }
  
  @Pure
  public Project getProject() {
    return this.project;
  }
}
