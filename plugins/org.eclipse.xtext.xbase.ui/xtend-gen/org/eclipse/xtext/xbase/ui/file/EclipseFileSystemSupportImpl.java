/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.file;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * A FileSystemSupport implementation which maps to the Eclipse Resources API.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class EclipseFileSystemSupportImpl extends AbstractFileSystemSupport {
  @Inject
  private IWorkspaceRoot _workspaceRoot;
  
  public IWorkspaceRoot getWorkspaceRoot() {
    return this._workspaceRoot;
  }
  
  public void setWorkspaceRoot(final IWorkspaceRoot workspaceRoot) {
    this._workspaceRoot = workspaceRoot;
  }
  
  protected IFile getEclipseFile(final Path path) {
    IWorkspaceRoot _workspaceRoot = this.getWorkspaceRoot();
    String _string = path.toString();
    org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(_string);
    IFile _file = _workspaceRoot.getFile(_path);
    return _file;
  }
  
  protected IFolder getEclipseFolder(final Path path) {
    IWorkspaceRoot _workspaceRoot = this.getWorkspaceRoot();
    String _string = path.toString();
    org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(_string);
    IFolder _folder = _workspaceRoot.getFolder(_path);
    return _folder;
  }
  
  protected IContainer getEclipseContainer(final Path path) {
    IContainer _xblockexpression = null;
    {
      boolean _isAbsolute = path.isAbsolute();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The given path has to be absolute: \'");
      _builder.append(path, "");
      _builder.append("\'.");
      Preconditions.checkState(_isAbsolute, _builder);
      IContainer _switchResult = null;
      List<String> _segments = path.getSegments();
      final List<String> segments = _segments;
      boolean _matched = false;
      if (!_matched) {
        int _size = segments.size();
        boolean _equals = (_size == 0);
        if (_equals) {
          _matched=true;
          IWorkspaceRoot _workspaceRoot = this.getWorkspaceRoot();
          _switchResult = _workspaceRoot;
        }
      }
      if (!_matched) {
        int _size_1 = segments.size();
        boolean _equals_1 = (_size_1 == 1);
        if (_equals_1) {
          _matched=true;
          IWorkspaceRoot _workspaceRoot_1 = this.getWorkspaceRoot();
          List<String> _segments_1 = path.getSegments();
          String _head = IterableExtensions.<String>head(_segments_1);
          IProject _project = _workspaceRoot_1.getProject(_head);
          _switchResult = _project;
        }
      }
      if (!_matched) {
        IWorkspaceRoot _workspaceRoot_2 = this.getWorkspaceRoot();
        String _string = path.toString();
        org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(_string);
        IFolder _folder = _workspaceRoot_2.getFolder(_path);
        _switchResult = _folder;
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  protected IResource findResource(final Path path) {
    IWorkspaceRoot _workspaceRoot = this.getWorkspaceRoot();
    String _string = path.toString();
    org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(_string);
    IResource _findMember = _workspaceRoot.findMember(_path);
    return _findMember;
  }
  
  protected org.eclipse.core.runtime.Path toEclipsePath(final Path path) {
    String _string = path.toString();
    org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(_string);
    return _path;
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    try {
      List<Path> _xblockexpression = null;
      {
        final IContainer container = this.getEclipseContainer(path);
        boolean _exists = container.exists();
        boolean _not = (!_exists);
        if (_not) {
          return CollectionLiterals.<Path>emptyList();
        }
        IResource[] _members = container.members();
        final Function1<IResource,Path> _function = new Function1<IResource,Path>() {
          public Path apply(final IResource it) {
            IPath _fullPath = it.getFullPath();
            String _string = _fullPath.toString();
            Path _path = new Path(_string);
            return _path;
          }
        };
        List<Path> _map = ListExtensions.<IResource, Path>map(((List<IResource>)Conversions.doWrapArray(_members)), _function);
        _xblockexpression = (_map);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean exists(final Path path) {
    IResource _findResource = this.findResource(path);
    boolean _notEquals = (!Objects.equal(_findResource, null));
    return _notEquals;
  }
  
  public boolean isFolder(final Path path) {
    IResource _findResource = this.findResource(path);
    return (_findResource instanceof IContainer);
  }
  
  public boolean isFile(final Path path) {
    IResource _findResource = this.findResource(path);
    return (_findResource instanceof IFile);
  }
  
  public long getLastModification(final Path path) {
    IResource _findResource = this.findResource(path);
    long _modificationStamp = _findResource.getModificationStamp();
    return _modificationStamp;
  }
  
  public String getCharset(final Path path) {
    try {
      boolean _isFile = this.isFile(path);
      if (_isFile) {
        IFile _eclipseFile = this.getEclipseFile(path);
        return _eclipseFile.getCharset();
      } else {
        boolean _isFolder = this.isFolder(path);
        if (_isFolder) {
          IContainer _eclipseContainer = this.getEclipseContainer(path);
          return _eclipseContainer.getDefaultCharset();
        } else {
          Path _parent = path.getParent();
          return this.getCharset(_parent);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public InputStream getContentsAsStream(final Path path) {
    try {
      IFile _eclipseFile = this.getEclipseFile(path);
      InputStream _contents = _eclipseFile.getContents();
      return _contents;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean delete(final Path path) {
    try {
      boolean _exists = this.exists(path);
      if (_exists) {
        IResource _findResource = this.findResource(path);
        _findResource.delete(true, null);
        return true;
      }
      return false;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean mkdir(final Path path) {
    try {
      boolean _xblockexpression = false;
      {
        boolean _exists = this.exists(path);
        if (_exists) {
          return false;
        }
        Path _parent = path.getParent();
        boolean _exists_1 = this.exists(_parent);
        boolean _not = (!_exists_1);
        if (_not) {
          Path _parent_1 = path.getParent();
          this.mkdir(_parent_1);
        }
        boolean _switchResult = false;
        IContainer _eclipseContainer = this.getEclipseContainer(path);
        final IContainer container = _eclipseContainer;
        boolean _matched = false;
        if (!_matched) {
          if (container instanceof IFolder) {
            _matched=true;
            boolean _xblockexpression_1 = false;
            {
              ((IFolder)container).create(true, true, null);
              _xblockexpression_1 = (true);
            }
            _switchResult = _xblockexpression_1;
          }
        }
        if (!_matched) {
          if (container instanceof IProject) {
            _matched=true;
            boolean _xblockexpression_1 = false;
            {
              ((IProject)container).create(null);
              _xblockexpression_1 = (true);
            }
            _switchResult = _xblockexpression_1;
          }
        }
        if (!_matched) {
          _switchResult = false;
        }
        _xblockexpression = (_switchResult);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void setContentsAsStream(final Path path, final InputStream stream) {
    try {
      boolean _exists = this.exists(path);
      if (_exists) {
        IFile _eclipseFile = this.getEclipseFile(path);
        _eclipseFile.setContents(stream, true, true, null);
      } else {
        Path _parent = path.getParent();
        this.mkdir(_parent);
        IFile _eclipseFile_1 = this.getEclipseFile(path);
        _eclipseFile_1.create(stream, true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public URI toURI(final Path path) {
    IWorkspaceRoot _workspaceRoot = this.getWorkspaceRoot();
    IPath _location = _workspaceRoot.getLocation();
    String _string = path.toString();
    IPath _append = _location.append(_string);
    URI _uRI = URIUtil.toURI(_append);
    return _uRI;
  }
}
