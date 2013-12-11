/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import java.io.InputStream;
import java.net.URI;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class CodeGenerationContextImpl implements CodeGenerationContext {
  private MutableFileSystemSupport _fileSystemSupport;
  
  public MutableFileSystemSupport getFileSystemSupport() {
    return this._fileSystemSupport;
  }
  
  public void setFileSystemSupport(final MutableFileSystemSupport fileSystemSupport) {
    this._fileSystemSupport = fileSystemSupport;
  }
  
  private FileLocations _fileLocations;
  
  public FileLocations getFileLocations() {
    return this._fileLocations;
  }
  
  public void setFileLocations(final FileLocations fileLocations) {
    this._fileLocations = fileLocations;
  }
  
  public boolean delete(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    boolean _delete = _fileSystemSupport.delete(path);
    return _delete;
  }
  
  public boolean mkdir(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    boolean _mkdir = _fileSystemSupport.mkdir(path);
    return _mkdir;
  }
  
  public void setContents(final Path path, final CharSequence contents) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    _fileSystemSupport.setContents(path, contents);
  }
  
  public void setContentsAsStream(final Path path, final InputStream stream) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    _fileSystemSupport.setContentsAsStream(path, stream);
  }
  
  public boolean exists(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    boolean _exists = _fileSystemSupport.exists(path);
    return _exists;
  }
  
  public String getCharset(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    String _charset = _fileSystemSupport.getCharset(path);
    return _charset;
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    Iterable<? extends Path> _children = _fileSystemSupport.getChildren(path);
    return _children;
  }
  
  public CharSequence getContents(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    CharSequence _contents = _fileSystemSupport.getContents(path);
    return _contents;
  }
  
  public InputStream getContentsAsStream(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    InputStream _contentsAsStream = _fileSystemSupport.getContentsAsStream(path);
    return _contentsAsStream;
  }
  
  public long getLastModification(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    long _lastModification = _fileSystemSupport.getLastModification(path);
    return _lastModification;
  }
  
  public Path getProjectFolder(final Path path) {
    FileLocations _fileLocations = this.getFileLocations();
    Path _projectFolder = _fileLocations.getProjectFolder(path);
    return _projectFolder;
  }
  
  public Path getSourceFolder(final Path path) {
    FileLocations _fileLocations = this.getFileLocations();
    Path _sourceFolder = _fileLocations.getSourceFolder(path);
    return _sourceFolder;
  }
  
  public Path getTargetFolder(final Path sourceFolder) {
    FileLocations _fileLocations = this.getFileLocations();
    Path _targetFolder = _fileLocations.getTargetFolder(sourceFolder);
    return _targetFolder;
  }
  
  public boolean isFile(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    boolean _isFile = _fileSystemSupport.isFile(path);
    return _isFile;
  }
  
  public boolean isFolder(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    boolean _isFolder = _fileSystemSupport.isFolder(path);
    return _isFolder;
  }
  
  public URI toURI(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    URI _uRI = _fileSystemSupport.toURI(path);
    return _uRI;
  }
}
