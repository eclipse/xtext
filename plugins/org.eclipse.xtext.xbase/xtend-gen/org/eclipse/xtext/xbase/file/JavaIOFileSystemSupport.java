/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.file;

import com.google.common.base.Objects;
import com.google.common.io.ByteStreams;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaIOFileSystemSupport extends AbstractFileSystemSupport {
  @Inject
  private Provider<WorkspaceConfig> _projectInformationProvider;
  
  public Provider<WorkspaceConfig> getProjectInformationProvider() {
    return this._projectInformationProvider;
  }
  
  public void setProjectInformationProvider(final Provider<WorkspaceConfig> projectInformationProvider) {
    this._projectInformationProvider = projectInformationProvider;
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    File _file = this.getFile(path);
    String[] _list = _file.list();
    final Function1<String,Path> _function = new Function1<String,Path>() {
      public Path apply(final String it) {
        Path _absolutePath = path.getAbsolutePath(it);
        return _absolutePath;
      }
    };
    List<Path> _map = ListExtensions.<String, Path>map(((List<String>)Conversions.doWrapArray(_list)), _function);
    return _map;
  }
  
  protected File getFile(final Path path) {
    Provider<WorkspaceConfig> _projectInformationProvider = this.getProjectInformationProvider();
    WorkspaceConfig _get = _projectInformationProvider.get();
    String _absoluteFileSystemPath = _get.getAbsoluteFileSystemPath();
    String _string = path.toString();
    File _file = new File(_absoluteFileSystemPath, _string);
    return _file;
  }
  
  public boolean exists(final Path path) {
    File _file = this.getFile(path);
    boolean _exists = _file.exists();
    return _exists;
  }
  
  public boolean isFolder(final Path path) {
    File _file = this.getFile(path);
    boolean _isDirectory = _file.isDirectory();
    return _isDirectory;
  }
  
  public boolean isFile(final Path path) {
    File _file = this.getFile(path);
    boolean _isFile = _file.isFile();
    return _isFile;
  }
  
  public long getLastModification(final Path path) {
    File _file = this.getFile(path);
    long _lastModified = _file.lastModified();
    return _lastModified;
  }
  
  public String getCharset(final Path path) {
    IEncodingProvider _encodingProvider = this.getEncodingProvider();
    File _file = this.getFile(path);
    String _absolutePath = _file.getAbsolutePath();
    URI _createFileURI = URI.createFileURI(_absolutePath);
    return _encodingProvider.getEncoding(_createFileURI);
  }
  
  public InputStream getContentsAsStream(final Path path) {
    try {
      File _file = this.getFile(path);
      FileInputStream _fileInputStream = new FileInputStream(_file);
      return _fileInputStream;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean mkdir(final Path path) {
    boolean _exists = this.exists(path);
    if (_exists) {
      return false;
    }
    final Path parent = path.getParent();
    boolean _notEquals = (!Objects.equal(parent, null));
    if (_notEquals) {
      this.mkdir(parent);
    }
    File _file = this.getFile(path);
    _file.mkdir();
    return true;
  }
  
  public boolean delete(final Path path) {
    try {
      boolean _exists = this.exists(path);
      boolean _not = (!_exists);
      if (_not) {
        return false;
      }
      File _file = this.getFile(path);
      boolean _isDirectory = _file.isDirectory();
      if (_isDirectory) {
        File _file_1 = this.getFile(path);
        Files.sweepFolder(_file_1);
      }
      File _file_2 = this.getFile(path);
      _file_2.delete();
      return true;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void setContentsAsStream(final Path path, final InputStream stream) {
    try {
      Path _parent = path.getParent();
      this.mkdir(_parent);
      File _file = this.getFile(path);
      FileOutputStream _fileOutputStream = new FileOutputStream(_file);
      ByteStreams.copy(stream, _fileOutputStream);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
