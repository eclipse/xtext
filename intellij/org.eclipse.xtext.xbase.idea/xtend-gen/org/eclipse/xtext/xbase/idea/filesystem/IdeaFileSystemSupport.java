/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.filesystem;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.io.ByteStreams;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.idea.extensions.RootModelExtensions;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class IdeaFileSystemSupport extends AbstractFileSystemSupport {
  @Override
  public Path getPath(final Resource res) {
    Path _xblockexpression = null;
    {
      VirtualFileManager _instance = VirtualFileManager.getInstance();
      URI _uRI = res.getURI();
      String _string = _uRI.toString();
      final VirtualFile file = _instance.findFileByUrl(_string);
      _xblockexpression = this.toPath(file);
    }
    return _xblockexpression;
  }
  
  @Override
  public void delete(final Path path) {
    try {
      VirtualFile _virtualFile = this.toVirtualFile(path);
      _virtualFile.delete(this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void mkdir(final Path path) {
    VirtualFile _virtualFile = this.toVirtualFile(path);
    this.mkdir(_virtualFile);
  }
  
  private void mkdir(final VirtualFile file) {
    try {
      final VirtualFile parent = file.getParent();
      boolean _exists = parent.exists();
      if (_exists) {
        String _name = file.getName();
        parent.createChildData(null, _name);
      } else {
        this.mkdir(parent);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void setContentsAsStream(final Path path, final InputStream source) {
    try {
      VirtualFile _virtualFile = this.toVirtualFile(path);
      final OutputStream out = _virtualFile.getOutputStream(this);
      try {
        ByteStreams.copy(source, out);
      } finally {
        out.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public boolean exists(final Path path) {
    VirtualFile _virtualFile = this.toVirtualFile(path);
    boolean _exists = false;
    if (_virtualFile!=null) {
      _exists=_virtualFile.exists();
    }
    return _exists;
  }
  
  @Override
  public String getCharset(final Path path) {
    VirtualFile _virtualFile = this.toVirtualFile(path);
    Charset _charset = _virtualFile.getCharset();
    return _charset.name();
  }
  
  @Override
  public Iterable<? extends Path> getChildren(final Path path) {
    VirtualFile _virtualFile = this.toVirtualFile(path);
    VirtualFile[] _children = _virtualFile.getChildren();
    final Function1<VirtualFile, Path> _function = new Function1<VirtualFile, Path>() {
      @Override
      public Path apply(final VirtualFile it) {
        return IdeaFileSystemSupport.this.toPath(it);
      }
    };
    return ListExtensions.<VirtualFile, Path>map(((List<VirtualFile>)Conversions.doWrapArray(_children)), _function);
  }
  
  @Override
  public InputStream getContentsAsStream(final Path path) {
    try {
      VirtualFile _virtualFile = this.toVirtualFile(path);
      return _virtualFile.getInputStream();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public long getLastModification(final Path path) {
    VirtualFile _virtualFile = this.toVirtualFile(path);
    return _virtualFile.getModificationStamp();
  }
  
  @Override
  public boolean isFile(final Path path) {
    boolean _isFolder = this.isFolder(path);
    return (!_isFolder);
  }
  
  @Override
  public boolean isFolder(final Path path) {
    VirtualFile _virtualFile = this.toVirtualFile(path);
    return _virtualFile.isDirectory();
  }
  
  @Override
  public java.net.URI toURI(final Path path) {
    VirtualFile _virtualFile = this.toVirtualFile(path);
    String _url = _virtualFile.getUrl();
    return java.net.URI.create(_url);
  }
  
  private VirtualFile toVirtualFile(final Path path) {
    VirtualFile _xblockexpression = null;
    {
      final Project project = this.getCurrentlyActiveProject();
      List<String> _segments = path.getSegments();
      final String moduleName = IterableExtensions.<String>head(_segments);
      ModuleManager _instance = ModuleManager.getInstance(project);
      final Module module = _instance.findModuleByName(moduleName);
      String _plus = (Character.valueOf(Path.SEGMENT_SEPARATOR) + moduleName);
      final Path moduleRelativePath = path.relativize(_plus);
      Iterable<SourceFolder> _sourceFolders = RootModelExtensions.getSourceFolders(module);
      final Function1<SourceFolder, VirtualFile> _function = new Function1<SourceFolder, VirtualFile>() {
        @Override
        public VirtualFile apply(final SourceFolder it) {
          return IdeaFileSystemSupport.this.findFileByModuleRelativePath(it, moduleRelativePath);
        }
      };
      Iterable<VirtualFile> _map = IterableExtensions.<SourceFolder, VirtualFile>map(_sourceFolders, _function);
      Iterable<VirtualFile> _filterNull = IterableExtensions.<VirtualFile>filterNull(_map);
      _xblockexpression = IterableExtensions.<VirtualFile>head(_filterNull);
    }
    return _xblockexpression;
  }
  
  private Path toPath(final VirtualFile file) {
    Path _xblockexpression = null;
    {
      final Project project = this.getCurrentlyActiveProject();
      ProjectRootManager _instance = ProjectRootManager.getInstance(project);
      ProjectFileIndex _fileIndex = _instance.getFileIndex();
      final Module module = _fileIndex.getModuleForFile(file);
      Iterable<SourceFolder> _sourceFolders = RootModelExtensions.getSourceFolders(module);
      final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
        @Override
        public Boolean apply(final SourceFolder it) {
          VirtualFile _file = it.getFile();
          return Boolean.valueOf(VfsUtilCore.isAncestor(_file, file, true));
        }
      };
      final SourceFolder sourceFolder = IterableExtensions.<SourceFolder>findFirst(_sourceFolders, _function);
      VirtualFile _file = sourceFolder.getFile();
      final String relativePath = VfsUtilCore.getRelativePath(file, _file);
      _xblockexpression = IdeaFileSystemSupport.createAbsolutePath(module, sourceFolder, relativePath);
    }
    return _xblockexpression;
  }
  
  private Project getCurrentlyActiveProject() {
    ProjectManager _instance = ProjectManager.getInstance();
    Project[] _openProjects = _instance.getOpenProjects();
    return IterableExtensions.<Project>head(((Iterable<Project>)Conversions.doWrapArray(_openProjects)));
  }
  
  private VirtualFile findFileByModuleRelativePath(final SourceFolder sourceFolder, final Path moduleRelativePath) {
    VirtualFile _xblockexpression = null;
    {
      String _relativePath = RootModelExtensions.getRelativePath(sourceFolder);
      final Path sourceRelativePath = moduleRelativePath.relativize(_relativePath);
      VirtualFile _xifexpression = null;
      boolean _equals = Objects.equal(sourceRelativePath, null);
      if (_equals) {
        _xifexpression = null;
      } else {
        VirtualFile _file = sourceFolder.getFile();
        String _string = sourceRelativePath.toString();
        _xifexpression = _file.findFileByRelativePath(_string);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static Path createAbsolutePath(final Module module, final SourceFolder sourceFolder) {
    return IdeaFileSystemSupport.createAbsolutePath(module, sourceFolder, null);
  }
  
  public static Path createAbsolutePath(final Module module, final SourceFolder sourceFolder, final String relativePath) {
    Path _xblockexpression = null;
    {
      String _name = module.getName();
      String _relativePath = RootModelExtensions.getRelativePath(sourceFolder);
      final List<String> segments = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name, _relativePath, relativePath));
      Joiner _on = Joiner.on(Path.SEGMENT_SEPARATOR);
      Joiner _skipNulls = _on.skipNulls();
      String _join = _skipNulls.join(segments);
      String _plus = (Character.valueOf(Path.SEGMENT_SEPARATOR) + _join);
      _xblockexpression = new Path(_plus);
    }
    return _xblockexpression;
  }
}
