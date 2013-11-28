/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.file;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.io.InputStream;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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
      IFolder _eclipseFolder = this.getEclipseFolder(path);
      IResource[] _members = _eclipseFolder.members();
      final Function1<IResource,Path> _function = new Function1<IResource,Path>() {
        public Path apply(final IResource it) {
          IPath _fullPath = it.getFullPath();
          String _string = _fullPath.toString();
          Path _path = new Path(_string);
          return _path;
        }
      };
      List<Path> _map = ListExtensions.<IResource, Path>map(((List<IResource>)Conversions.doWrapArray(_members)), _function);
      return _map;
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
    return (_findResource instanceof IFolder);
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
          IFolder _eclipseFolder = this.getEclipseFolder(path);
          return _eclipseFolder.getDefaultCharset();
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
      IFolder _eclipseFolder = this.getEclipseFolder(path);
      _eclipseFolder.create(true, true, null);
      return true;
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
}
