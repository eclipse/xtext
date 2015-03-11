/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.filesystem;

import com.google.common.io.ByteStreams;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
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
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
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
      ProjectManager _instance = ProjectManager.getInstance();
      Project[] _openProjects = _instance.getOpenProjects();
      final Project project = IterableExtensions.<Project>head(((Iterable<Project>)Conversions.doWrapArray(_openProjects)));
      VirtualFile _baseDir = project.getBaseDir();
      String _string = path.toString();
      _xblockexpression = _baseDir.findFileByRelativePath(_string);
    }
    return _xblockexpression;
  }
  
  private Path toPath(final VirtualFile file) {
    Path _xblockexpression = null;
    {
      ProjectManager _instance = ProjectManager.getInstance();
      Project[] _openProjects = _instance.getOpenProjects();
      final Project project = IterableExtensions.<Project>head(((Iterable<Project>)Conversions.doWrapArray(_openProjects)));
      VirtualFile _baseDir = project.getBaseDir();
      String _relativePath = VfsUtil.getRelativePath(file, _baseDir, Path.SEGMENT_SEPARATOR);
      _xblockexpression = new Path(_relativePath);
    }
    return _xblockexpression;
  }
}
