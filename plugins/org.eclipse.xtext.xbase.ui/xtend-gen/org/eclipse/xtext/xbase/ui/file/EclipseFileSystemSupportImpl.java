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
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A FileSystemSupport implementation which maps to the Eclipse Resources API.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class EclipseFileSystemSupportImpl extends AbstractFileSystemSupport {
  @Accessors
  @Inject
  private IWorkspaceRoot workspaceRoot;
  
  protected IFile getEclipseFile(final Path path) {
    String _string = path.toString();
    org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(_string);
    return this.workspaceRoot.getFile(_path);
  }
  
  protected IFolder getEclipseFolder(final Path path) {
    String _string = path.toString();
    org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(_string);
    return this.workspaceRoot.getFolder(_path);
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
          _switchResult = this.workspaceRoot;
        }
      }
      if (!_matched) {
        int _size_1 = segments.size();
        boolean _equals_1 = (_size_1 == 1);
        if (_equals_1) {
          _matched=true;
          List<String> _segments_1 = path.getSegments();
          String _head = IterableExtensions.<String>head(_segments_1);
          _switchResult = this.workspaceRoot.getProject(_head);
        }
      }
      if (!_matched) {
        String _string = path.toString();
        org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(_string);
        _switchResult = this.workspaceRoot.getFolder(_path);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  protected IResource findResource(final Path path) {
    String _string = path.toString();
    org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(_string);
    return this.workspaceRoot.findMember(_path);
  }
  
  protected org.eclipse.core.runtime.Path toEclipsePath(final Path path) {
    String _string = path.toString();
    return new org.eclipse.core.runtime.Path(_string);
  }
  
  @Override
  public Iterable<? extends Path> getChildren(final Path path) {
    List<Path> _xblockexpression = null;
    {
      final IContainer container = this.getEclipseContainer(path);
      boolean _exists = container.exists();
      boolean _not = (!_exists);
      if (_not) {
        return CollectionLiterals.<Path>emptyList();
      }
      List<Path> _xtrycatchfinallyexpression = null;
      try {
        IResource[] _members = container.members();
        final Function1<IResource, Path> _function = new Function1<IResource, Path>() {
          @Override
          public Path apply(final IResource it) {
            IPath _fullPath = it.getFullPath();
            String _string = _fullPath.toString();
            return new Path(_string);
          }
        };
        _xtrycatchfinallyexpression = ListExtensions.<IResource, Path>map(((List<IResource>)Conversions.doWrapArray(_members)), _function);
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException exc = (CoreException)_t;
          String _message = exc.getMessage();
          throw new IllegalArgumentException(_message, exc);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean exists(final Path path) {
    IResource _findResource = this.findResource(path);
    return (!Objects.equal(_findResource, null));
  }
  
  @Override
  public boolean isFolder(final Path path) {
    IResource _findResource = this.findResource(path);
    return (_findResource instanceof IContainer);
  }
  
  @Override
  public boolean isFile(final Path path) {
    IResource _findResource = this.findResource(path);
    return (_findResource instanceof IFile);
  }
  
  @Override
  public long getLastModification(final Path path) {
    long _xblockexpression = (long) 0;
    {
      final IResource resource = this.findResource(path);
      boolean _equals = Objects.equal(resource, null);
      if (_equals) {
        return 0L;
      }
      _xblockexpression = resource.getModificationStamp();
    }
    return _xblockexpression;
  }
  
  @Override
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
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException exc = (CoreException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public InputStream getContentsAsStream(final Path path) {
    InputStream _xtrycatchfinallyexpression = null;
    try {
      IFile _eclipseFile = this.getEclipseFile(path);
      _xtrycatchfinallyexpression = _eclipseFile.getContents();
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException exc = (CoreException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Override
  public void delete(final Path path) {
    try {
      boolean _exists = this.exists(path);
      if (_exists) {
        IResource _findResource = this.findResource(path);
        _findResource.delete(true, null);
      }
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException exc = (CoreException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public void mkdir(final Path path) {
    boolean _exists = this.exists(path);
    if (_exists) {
      return;
    }
    Path _parent = path.getParent();
    boolean _exists_1 = this.exists(_parent);
    boolean _not = (!_exists_1);
    if (_not) {
      Path _parent_1 = path.getParent();
      this.mkdir(_parent_1);
    }
    try {
      IContainer _eclipseContainer = this.getEclipseContainer(path);
      final IContainer container = _eclipseContainer;
      boolean _matched = false;
      if (!_matched) {
        if (container instanceof IFolder) {
          _matched=true;
          ((IFolder)container).create(true, true, null);
        }
      }
      if (!_matched) {
        if (container instanceof IProject) {
          _matched=true;
          ((IProject)container).create(null);
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException exc = (CoreException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public void setContentsAsStream(final Path path, final InputStream stream) {
    try {
      try {
        final IFile eclipseFile = this.getEclipseFile(path);
        boolean _exists = eclipseFile.exists();
        if (_exists) {
          boolean _markSupported = stream.markSupported();
          if (_markSupported) {
            boolean _hasContentsChanged = this.hasContentsChanged(stream, eclipseFile);
            if (_hasContentsChanged) {
              stream.reset();
              eclipseFile.setContents(stream, true, true, null);
            }
          } else {
            eclipseFile.setContents(stream, true, true, null);
          }
        } else {
          Path _parent = path.getParent();
          this.mkdir(_parent);
          eclipseFile.create(stream, true, null);
        }
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException exc = (CoreException)_t;
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
  
  private boolean hasContentsChanged(final InputStream newContent, final IFile file) {
    boolean contentChanged = false;
    BufferedInputStream oldContent = null;
    try {
      InputStream _contents = file.getContents();
      BufferedInputStream _bufferedInputStream = new BufferedInputStream(_contents);
      oldContent = _bufferedInputStream;
      int newByte = newContent.read();
      int oldByte = oldContent.read();
      while ((((newByte != (-1)) && (oldByte != (-1))) && (newByte == oldByte))) {
        {
          int _read = newContent.read();
          newByte = _read;
          int _read_1 = oldContent.read();
          oldByte = _read_1;
        }
      }
      contentChanged = (newByte != oldByte);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        contentChanged = true;
      } else if (_t instanceof IOException) {
        final IOException e_1 = (IOException)_t;
        contentChanged = true;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      boolean _notEquals = (!Objects.equal(oldContent, null));
      if (_notEquals) {
        try {
          oldContent.close();
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof IOException) {
            final IOException e_2 = (IOException)_t_1;
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      }
    }
    return contentChanged;
  }
  
  @Override
  public URI toURI(final Path path) {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    return this.toURI(path, _newArrayList);
  }
  
  protected URI toURI(final Path path, final List<String> trailingSegments) {
    URI _xblockexpression = null;
    {
      final IResource resource = this.findResource(path);
      boolean _equals = Objects.equal(resource, null);
      if (_equals) {
        String _lastSegment = path.getLastSegment();
        trailingSegments.add(_lastSegment);
        Path _parent = path.getParent();
        return this.toURI(_parent, trailingSegments);
      }
      List<String> _reverse = ListExtensions.<String>reverse(trailingSegments);
      IPath _location = resource.getLocation();
      final Function2<IPath, String, IPath> _function = new Function2<IPath, String, IPath>() {
        @Override
        public IPath apply(final IPath location, final String segment) {
          return location.append(segment);
        }
      };
      IPath _fold = IterableExtensions.<String, IPath>fold(_reverse, _location, _function);
      _xblockexpression = URIUtil.toURI(_fold);
    }
    return _xblockexpression;
  }
  
  @Override
  public Path getPath(final Resource res) {
    org.eclipse.emf.common.util.URI _uRI = res.getURI();
    boolean _isPlatform = _uRI.isPlatform();
    boolean _not = (!_isPlatform);
    if (_not) {
      org.eclipse.emf.common.util.URI _uRI_1 = res.getURI();
      String _plus = ("Expecting platform URI but was : " + _uRI_1);
      throw new IllegalStateException(_plus);
    }
    org.eclipse.emf.common.util.URI _uRI_2 = res.getURI();
    String _platformString = _uRI_2.toPlatformString(true);
    return new Path(_platformString);
  }
  
  @Pure
  public IWorkspaceRoot getWorkspaceRoot() {
    return this.workspaceRoot;
  }
  
  public void setWorkspaceRoot(final IWorkspaceRoot workspaceRoot) {
    this.workspaceRoot = workspaceRoot;
  }
}
