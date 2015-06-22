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
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class IdeaModuleConfig implements IProjectConfig {
  private final Module module;
  
  @Override
  public ISourceFolder findSourceFolderContaing(final URI member) {
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
    Iterable<SourceFolder> _existingSourceFolders = RootModelExtensions.getExistingSourceFolders(this.module);
    final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        return Boolean.valueOf(Objects.equal(file, sourceRoot));
      }
    };
    final SourceFolder sourceFolder = IterableExtensions.<SourceFolder>findFirst(_existingSourceFolders, _function);
    boolean _equals_2 = Objects.equal(sourceFolder, null);
    if (_equals_2) {
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
    URI _xblockexpression = null;
    {
      ModuleRootManager _instance = ModuleRootManager.getInstance(this.module);
      ContentEntry[] _contentEntries = _instance.getContentEntries();
      final ContentEntry contentRoot = IterableExtensions.<ContentEntry>head(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)));
      VirtualFile _file = contentRoot.getFile();
      String _url = _file.getUrl();
      final URI path = URI.createURI(_url);
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
  
  @Override
  public Set<? extends ISourceFolder> getSourceFolders() {
    Iterable<SourceFolder> _existingSourceFolders = RootModelExtensions.getExistingSourceFolders(this.module);
    final Function1<SourceFolder, IdeaSourceFolder> _function = new Function1<SourceFolder, IdeaSourceFolder>() {
      @Override
      public IdeaSourceFolder apply(final SourceFolder it) {
        return new IdeaSourceFolder(it);
      }
    };
    Iterable<IdeaSourceFolder> _map = IterableExtensions.<SourceFolder, IdeaSourceFolder>map(_existingSourceFolders, _function);
    return IterableExtensions.<IdeaSourceFolder>toSet(_map);
  }
  
  public IdeaModuleConfig(final Module module) {
    super();
    this.module = module;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.module== null) ? 0 : this.module.hashCode());
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
    IdeaModuleConfig other = (IdeaModuleConfig) obj;
    if (this.module == null) {
      if (other.module != null)
        return false;
    } else if (!this.module.equals(other.module))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("module", this.module);
    return b.toString();
  }
  
  @Pure
  public Module getModule() {
    return this.module;
  }
}
