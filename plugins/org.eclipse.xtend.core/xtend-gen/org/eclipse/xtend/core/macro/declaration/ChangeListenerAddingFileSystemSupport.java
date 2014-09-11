/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.io.InputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.IResourceChangeRegistry;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ChangeListenerAddingFileSystemSupport implements MutableFileSystemSupport {
  private final MutableFileSystemSupport delegate;
  
  private final CompilationUnitImpl compilationUnit;
  
  public void delete(final Path path) {
    this.delegate.delete(path);
  }
  
  public void mkdir(final Path path) {
    this.delegate.mkdir(path);
  }
  
  public void setContents(final Path path, final CharSequence contents) {
    this.delegate.setContents(path, contents);
  }
  
  public void setContentsAsStream(final Path path, final InputStream source) {
    this.delegate.setContentsAsStream(path, source);
  }
  
  public boolean exists(final Path path) {
    boolean _xblockexpression = false;
    {
      IResourceChangeRegistry _resourceChangeRegistry = this.compilationUnit.getResourceChangeRegistry();
      String _string = path.toString();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      Resource _eResource = _xtendFile.eResource();
      URI _uRI = _eResource.getURI();
      _resourceChangeRegistry.registerExists(_string, _uRI);
      _xblockexpression = this.delegate.exists(path);
    }
    return _xblockexpression;
  }
  
  public String getCharset(final Path path) {
    String _xblockexpression = null;
    {
      IResourceChangeRegistry _resourceChangeRegistry = this.compilationUnit.getResourceChangeRegistry();
      String _string = path.toString();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      Resource _eResource = _xtendFile.eResource();
      URI _uRI = _eResource.getURI();
      _resourceChangeRegistry.registerGetCharset(_string, _uRI);
      _xblockexpression = this.delegate.getCharset(path);
    }
    return _xblockexpression;
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    Iterable<? extends Path> _xblockexpression = null;
    {
      IResourceChangeRegistry _resourceChangeRegistry = this.compilationUnit.getResourceChangeRegistry();
      String _string = path.toString();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      Resource _eResource = _xtendFile.eResource();
      URI _uRI = _eResource.getURI();
      _resourceChangeRegistry.registerGetChildren(_string, _uRI);
      _xblockexpression = this.delegate.getChildren(path);
    }
    return _xblockexpression;
  }
  
  public CharSequence getContents(final Path path) {
    CharSequence _xblockexpression = null;
    {
      IResourceChangeRegistry _resourceChangeRegistry = this.compilationUnit.getResourceChangeRegistry();
      String _string = path.toString();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      Resource _eResource = _xtendFile.eResource();
      URI _uRI = _eResource.getURI();
      _resourceChangeRegistry.registerGetContents(_string, _uRI);
      _xblockexpression = this.delegate.getContents(path);
    }
    return _xblockexpression;
  }
  
  public InputStream getContentsAsStream(final Path path) {
    InputStream _xblockexpression = null;
    {
      IResourceChangeRegistry _resourceChangeRegistry = this.compilationUnit.getResourceChangeRegistry();
      String _string = path.toString();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      Resource _eResource = _xtendFile.eResource();
      URI _uRI = _eResource.getURI();
      _resourceChangeRegistry.registerGetContents(_string, _uRI);
      _xblockexpression = this.delegate.getContentsAsStream(path);
    }
    return _xblockexpression;
  }
  
  public long getLastModification(final Path path) {
    long _xblockexpression = (long) 0;
    {
      IResourceChangeRegistry _resourceChangeRegistry = this.compilationUnit.getResourceChangeRegistry();
      String _string = path.toString();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      Resource _eResource = _xtendFile.eResource();
      URI _uRI = _eResource.getURI();
      _resourceChangeRegistry.registerGetContents(_string, _uRI);
      _xblockexpression = this.delegate.getLastModification(path);
    }
    return _xblockexpression;
  }
  
  public boolean isFile(final Path path) {
    boolean _xblockexpression = false;
    {
      IResourceChangeRegistry _resourceChangeRegistry = this.compilationUnit.getResourceChangeRegistry();
      String _string = path.toString();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      Resource _eResource = _xtendFile.eResource();
      URI _uRI = _eResource.getURI();
      _resourceChangeRegistry.registerExists(_string, _uRI);
      _xblockexpression = this.delegate.isFile(path);
    }
    return _xblockexpression;
  }
  
  public boolean isFolder(final Path path) {
    boolean _xblockexpression = false;
    {
      IResourceChangeRegistry _resourceChangeRegistry = this.compilationUnit.getResourceChangeRegistry();
      String _string = path.toString();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      Resource _eResource = _xtendFile.eResource();
      URI _uRI = _eResource.getURI();
      _resourceChangeRegistry.registerExists(_string, _uRI);
      _xblockexpression = this.delegate.isFolder(path);
    }
    return _xblockexpression;
  }
  
  public java.net.URI toURI(final Path path) {
    return this.delegate.toURI(path);
  }
  
  public ChangeListenerAddingFileSystemSupport(final MutableFileSystemSupport delegate, final CompilationUnitImpl compilationUnit) {
    super();
    this.delegate = delegate;
    this.compilationUnit = compilationUnit;
  }
  
  @Pure
  public MutableFileSystemSupport getDelegate() {
    return this.delegate;
  }
  
  @Pure
  public CompilationUnitImpl getCompilationUnit() {
    return this.compilationUnit;
  }
}
