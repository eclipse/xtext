/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.filesystem;

import com.google.common.base.Objects;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.idea.filesystem.IdeaModuleConfig;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class IdeaWorkspaceConfig implements IWorkspaceConfig {
  private final Project project;
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    Application _application = ApplicationManager.getApplication();
    final Computable<Module> _function = new Computable<Module>() {
      @Override
      public Module compute() {
        ModuleManager _instance = ModuleManager.getInstance(IdeaWorkspaceConfig.this.project);
        return _instance.findModuleByName(name);
      }
    };
    final Module module = _application.<Module>runReadAction(_function);
    boolean _equals = Objects.equal(module, null);
    if (_equals) {
      return null;
    }
    boolean _isUsable = this.isUsable(module);
    boolean _not = (!_isUsable);
    if (_not) {
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
    boolean _isUsable = this.isUsable(module);
    boolean _not = (!_isUsable);
    if (_not) {
      return null;
    }
    return new IdeaModuleConfig(module);
  }
  
  private boolean isUsable(final Module module) {
    ModuleRootManager _instance = ModuleRootManager.getInstance(module);
    ContentEntry[] _contentEntries = _instance.getContentEntries();
    boolean _isEmpty = ((List<ContentEntry>)Conversions.doWrapArray(_contentEntries)).isEmpty();
    return (!_isEmpty);
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
