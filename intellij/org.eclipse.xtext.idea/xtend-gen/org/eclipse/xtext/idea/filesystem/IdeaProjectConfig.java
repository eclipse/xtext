/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.filesystem;

import com.google.common.base.Objects;
import com.intellij.ide.projectView.impl.ProjectRootsUtil;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.idea.extensions.RootModelExtensions;
import org.eclipse.xtext.idea.filesystem.IdeaSourceFolder;
import org.eclipse.xtext.idea.filesystem.IdeaWorkspaceConfig;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class IdeaProjectConfig implements IProjectConfig {
  private final Module module;
  
  private final VirtualFile contentRoot;
  
  public IdeaProjectConfig(final Module module) {
    this.module = module;
    ModuleRootManager _instance = ModuleRootManager.getInstance(module);
    VirtualFile[] _contentRoots = _instance.getContentRoots();
    VirtualFile _head = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots)));
    this.contentRoot = _head;
  }
  
  @Override
  public IdeaSourceFolder findSourceFolderContaining(final URI member) {
    VirtualFileManager _instance = VirtualFileManager.getInstance();
    String _string = member.toString();
    final VirtualFile file = _instance.findFileByUrl(_string);
    boolean _equals = Objects.equal(file, null);
    if (_equals) {
      return null;
    }
    Project _project = this.module.getProject();
    ProjectRootManager _instance_1 = ProjectRootManager.getInstance(_project);
    ProjectFileIndex _fileIndex = _instance_1.getFileIndex();
    final VirtualFile sourceRoot = _fileIndex.getSourceRootForFile(file);
    boolean _equals_1 = Objects.equal(sourceRoot, null);
    if (_equals_1) {
      return null;
    }
    final SourceFolder sourceFolder = ProjectRootsUtil.findSourceFolder(this.module, sourceRoot);
    boolean _or = false;
    boolean _equals_2 = Objects.equal(sourceFolder, null);
    if (_equals_2) {
      _or = true;
    } else {
      ContentEntry _contentEntry = sourceFolder.getContentEntry();
      VirtualFile _file = _contentEntry.getFile();
      boolean _notEquals = (!Objects.equal(_file, this.contentRoot));
      _or = _notEquals;
    }
    if (_or) {
      return null;
    }
    return new IdeaSourceFolder(sourceFolder);
  }
  
  @Override
  public String getName() {
    return this.module.getName();
  }
  
  @Override
  public URI getPath() {
    String _url = this.contentRoot.getUrl();
    URI _createURI = URI.createURI(_url);
    return UriUtil.toFolderURI(_createURI);
  }
  
  @Override
  public Set<? extends IdeaSourceFolder> getSourceFolders() {
    Iterable<SourceFolder> _existingSourceFolders = RootModelExtensions.getExistingSourceFolders(this.module);
    final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        VirtualFile _file = it.getFile();
        return Boolean.valueOf(Objects.equal(_file, IdeaProjectConfig.this.contentRoot));
      }
    };
    Iterable<SourceFolder> _filter = IterableExtensions.<SourceFolder>filter(_existingSourceFolders, _function);
    final Function1<SourceFolder, IdeaSourceFolder> _function_1 = new Function1<SourceFolder, IdeaSourceFolder>() {
      @Override
      public IdeaSourceFolder apply(final SourceFolder sourceFolder) {
        return new IdeaSourceFolder(sourceFolder);
      }
    };
    Iterable<IdeaSourceFolder> _map = IterableExtensions.<SourceFolder, IdeaSourceFolder>map(_filter, _function_1);
    return IterableExtensions.<IdeaSourceFolder>toSet(_map);
  }
  
  @Override
  public IWorkspaceConfig getWorkspaceConfig() {
    Project _project = this.module.getProject();
    return new IdeaWorkspaceConfig(_project);
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.module== null) ? 0 : this.module.hashCode());
    result = prime * result + ((this.contentRoot== null) ? 0 : this.contentRoot.hashCode());
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
    IdeaProjectConfig other = (IdeaProjectConfig) obj;
    if (this.module == null) {
      if (other.module != null)
        return false;
    } else if (!this.module.equals(other.module))
      return false;
    if (this.contentRoot == null) {
      if (other.contentRoot != null)
        return false;
    } else if (!this.contentRoot.equals(other.contentRoot))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("module", this.module);
    b.add("contentRoot", this.contentRoot);
    return b.toString();
  }
  
  @Pure
  public Module getModule() {
    return this.module;
  }
  
  @Pure
  public VirtualFile getContentRoot() {
    return this.contentRoot;
  }
}
