/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.macro;

import com.google.common.base.Objects;
import com.google.common.io.ByteStreams;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.idea.resource.ModuleProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
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
      boolean _exists = this.exists(path);
      if (_exists) {
        VirtualFile _virtualFile = this.toVirtualFile(path);
        _virtualFile.delete(this);
      }
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException exc = (IOException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public void mkdir(final Path path) {
    try {
      boolean _exists = this.exists(path);
      if (_exists) {
        return;
      }
      boolean _equals = Objects.equal(path, null);
      if (_equals) {
        throw new IllegalAccessException(("The path cannot be null: " + path));
      }
      Path _parent = path.getParent();
      this.mkdir(_parent);
      Path _parent_1 = path.getParent();
      final VirtualFile parentDir = this.toVirtualFile(_parent_1);
      try {
        String _lastSegment = path.getLastSegment();
        parentDir.createChildDirectory(this, _lastSegment);
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException exc = (IOException)_t;
          String _message = exc.getMessage();
          throw new IllegalArgumentException(_message, exc);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void setContentsAsStream(final Path path, final InputStream source) {
    boolean _exists = this.exists(path);
    boolean _not = (!_exists);
    if (_not) {
      Path _parent = path.getParent();
      this.mkdir(_parent);
      try {
        Path _parent_1 = path.getParent();
        VirtualFile _virtualFile = this.toVirtualFile(_parent_1);
        String _lastSegment = path.getLastSegment();
        _virtualFile.createChildData(this, _lastSegment);
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException exc = (IOException)_t;
          String _message = exc.getMessage();
          throw new IllegalArgumentException(_message, exc);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    final VirtualFile file = this.toVirtualFile(path);
    boolean _isDirectory = file.isDirectory();
    boolean _not_1 = (!_isDirectory);
    if (_not_1) {
      this.setContents(file, source);
    }
  }
  
  protected void setContents(final VirtualFile file, final InputStream source) {
    try {
      final OutputStream out = file.getOutputStream(this);
      try {
        ByteStreams.copy(source, out);
      } finally {
        out.close();
      }
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException exc = (IOException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
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
    try {
      String _xblockexpression = null;
      {
        boolean _equals = Objects.equal(path, null);
        if (_equals) {
          throw new IllegalAccessException(("The path cannot be null: " + path));
        }
        final VirtualFile file = this.toVirtualFile(path);
        String _xifexpression = null;
        boolean _notEquals = (!Objects.equal(file, null));
        if (_notEquals) {
          Charset _charset = file.getCharset();
          _xifexpression = _charset.name();
        } else {
          Path _parent = path.getParent();
          _xifexpression = this.getCharset(_parent);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public Iterable<? extends Path> getChildren(final Path path) {
    boolean _isFolder = this.isFolder(path);
    boolean _not = (!_isFolder);
    if (_not) {
      return CollectionLiterals.<Path>emptyList();
    }
    VirtualFile _virtualFile = this.toVirtualFile(path);
    VirtualFile[] _children = _virtualFile.getChildren();
    final Function1<VirtualFile, Path> _function = new Function1<VirtualFile, Path>() {
      @Override
      public Path apply(final VirtualFile it) {
        return IdeaFileSystemSupport.this.toPath(it);
      }
    };
    List<Path> _map = ListExtensions.<VirtualFile, Path>map(((List<VirtualFile>)Conversions.doWrapArray(_children)), _function);
    return IterableExtensions.<Path>filterNull(_map);
  }
  
  @Override
  public InputStream getContentsAsStream(final Path path) {
    try {
      InputStream _xblockexpression = null;
      {
        boolean _isFile = this.isFile(path);
        boolean _not = (!_isFile);
        if (_not) {
          throw new IllegalAccessException(("The file cannot be found: " + path));
        }
        InputStream _xtrycatchfinallyexpression = null;
        try {
          VirtualFile _virtualFile = this.toVirtualFile(path);
          _xtrycatchfinallyexpression = _virtualFile.getInputStream();
        } catch (final Throwable _t) {
          if (_t instanceof IOException) {
            final IOException exc = (IOException)_t;
            String _message = exc.getMessage();
            throw new IllegalArgumentException(_message, exc);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public long getLastModification(final Path path) {
    boolean _isFile = this.isFile(path);
    boolean _not = (!_isFile);
    if (_not) {
      return 0L;
    }
    VirtualFile _virtualFile = this.toVirtualFile(path);
    return _virtualFile.getModificationStamp();
  }
  
  @Override
  public boolean isFile(final Path path) {
    boolean _xblockexpression = false;
    {
      final VirtualFile file = this.toVirtualFile(path);
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(file, null));
      if (_notEquals) {
        boolean _isDirectory = file.isDirectory();
        _xifexpression = (!_isDirectory);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean isFolder(final Path path) {
    boolean _xblockexpression = false;
    {
      final VirtualFile file = this.toVirtualFile(path);
      boolean _isDirectory = false;
      if (file!=null) {
        _isDirectory=file.isDirectory();
      }
      _xblockexpression = _isDirectory;
    }
    return _xblockexpression;
  }
  
  @Override
  public java.net.URI toURI(final Path path) {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    return this.toURI(path, _newArrayList);
  }
  
  protected java.net.URI toURI(final Path path, final List<String> trailingSegments) {
    try {
      java.net.URI _xblockexpression = null;
      {
        final VirtualFile file = this.toVirtualFile(path);
        boolean _equals = Objects.equal(file, null);
        if (_equals) {
          String _lastSegment = path.getLastSegment();
          trailingSegments.add(_lastSegment);
          Path _parent = path.getParent();
          return this.toURI(_parent, trailingSegments);
        }
        List<String> _reverse = ListExtensions.<String>reverse(trailingSegments);
        String _url = file.getUrl();
        final Function2<String, String, String> _function = new Function2<String, String, String>() {
          @Override
          public String apply(final String url, final String segment) {
            return ((url + Character.valueOf(VfsUtilCore.VFS_SEPARATOR_CHAR)) + segment);
          }
        };
        final String url = IterableExtensions.<String, String>fold(_reverse, _url, _function);
        URL _convertToURL = VfsUtilCore.convertToURL(url);
        _xblockexpression = _convertToURL.toURI();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected VirtualFile toVirtualFile(final Path path) {
    VirtualFile _xblockexpression = null;
    {
      boolean _equals = Objects.equal(path, null);
      if (_equals) {
        return null;
      }
      List<String> _segments = path.getSegments();
      int _size = _segments.size();
      boolean _equals_1 = (_size == 0);
      if (_equals_1) {
        Project _project = this.getProject();
        return _project.getBaseDir();
      }
      List<String> _segments_1 = path.getSegments();
      final String moduleName = IterableExtensions.<String>head(_segments_1);
      Project _project_1 = this.getProject();
      ModuleManager _instance = ModuleManager.getInstance(_project_1);
      final Module module = _instance.findModuleByName(moduleName);
      boolean _equals_2 = Objects.equal(module, null);
      if (_equals_2) {
        return null;
      }
      List<String> _segments_2 = path.getSegments();
      int _size_1 = _segments_2.size();
      boolean _equals_3 = (_size_1 == 1);
      if (_equals_3) {
        ModuleRootManager _instance_1 = ModuleRootManager.getInstance(module);
        VirtualFile[] _contentRoots = _instance_1.getContentRoots();
        return IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots)));
      }
      Path _append = Path.ROOT.append(moduleName);
      Path _relativize = path.relativize(_append);
      String _string = null;
      if (_relativize!=null) {
        _string=_relativize.toString();
      }
      final String moduleRelativePath = _string;
      boolean _equals_4 = Objects.equal(moduleRelativePath, null);
      if (_equals_4) {
        return null;
      }
      ModuleRootManager _instance_2 = ModuleRootManager.getInstance(module);
      final VirtualFile[] contentRoots = _instance_2.getContentRoots();
      final Function1<VirtualFile, VirtualFile> _function = new Function1<VirtualFile, VirtualFile>() {
        @Override
        public VirtualFile apply(final VirtualFile it) {
          return it.findFileByRelativePath(moduleRelativePath);
        }
      };
      List<VirtualFile> _map = ListExtensions.<VirtualFile, VirtualFile>map(((List<VirtualFile>)Conversions.doWrapArray(contentRoots)), _function);
      Iterable<VirtualFile> _filterNull = IterableExtensions.<VirtualFile>filterNull(_map);
      final Function1<VirtualFile, Boolean> _function_1 = new Function1<VirtualFile, Boolean>() {
        @Override
        public Boolean apply(final VirtualFile it) {
          return Boolean.valueOf(it.isValid());
        }
      };
      Iterable<VirtualFile> _filter = IterableExtensions.<VirtualFile>filter(_filterNull, _function_1);
      _xblockexpression = IterableExtensions.<VirtualFile>head(_filter);
    }
    return _xblockexpression;
  }
  
  protected Path toPath(final VirtualFile file) {
    Path _xblockexpression = null;
    {
      boolean _equals = Objects.equal(file, null);
      if (_equals) {
        return null;
      }
      Project _project = this.getProject();
      ProjectRootManager _instance = ProjectRootManager.getInstance(_project);
      final ProjectFileIndex fileIndex = _instance.getFileIndex();
      final Module module = fileIndex.getModuleForFile(file);
      boolean _equals_1 = Objects.equal(module, null);
      if (_equals_1) {
        return null;
      }
      final VirtualFile contentRoot = fileIndex.getContentRootForFile(file);
      boolean _equals_2 = Objects.equal(contentRoot, null);
      if (_equals_2) {
        return null;
      }
      final String relativePath = VfsUtilCore.getRelativePath(file, contentRoot);
      boolean _equals_3 = Objects.equal(relativePath, null);
      if (_equals_3) {
        return null;
      }
      String _name = module.getName();
      Path _append = Path.ROOT.append(_name);
      _xblockexpression = _append.append(relativePath);
    }
    return _xblockexpression;
  }
  
  protected Project getProject() {
    ResourceSet _context = this.getContext();
    Module _findModule = ModuleProvider.findModule(_context);
    return _findModule.getProject();
  }
}
