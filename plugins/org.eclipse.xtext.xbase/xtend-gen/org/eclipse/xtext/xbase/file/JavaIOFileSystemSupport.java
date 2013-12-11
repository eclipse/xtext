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
import com.google.common.io.InputSupplier;
import com.google.common.io.OutputSupplier;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
    List<Path> _xblockexpression = null;
    {
      boolean _exists = this.exists(path);
      boolean _not = (!_exists);
      if (_not) {
        return CollectionLiterals.<Path>emptyList();
      }
      boolean _isFile = this.isFile(path);
      if (_isFile) {
        return CollectionLiterals.<Path>emptyList();
      }
      File _javaIOFile = this.getJavaIOFile(path);
      String[] _list = _javaIOFile.list();
      final Function1<String,Path> _function = new Function1<String,Path>() {
        public Path apply(final String it) {
          Path _absolutePath = path.getAbsolutePath(it);
          return _absolutePath;
        }
      };
      List<Path> _map = ListExtensions.<String, Path>map(((List<String>)Conversions.doWrapArray(_list)), _function);
      _xblockexpression = (_map);
    }
    return _xblockexpression;
  }
  
  protected File getJavaIOFile(final Path path) {
    Provider<WorkspaceConfig> _projectInformationProvider = this.getProjectInformationProvider();
    WorkspaceConfig _get = _projectInformationProvider.get();
    String _absoluteFileSystemPath = _get.getAbsoluteFileSystemPath();
    String _string = path.toString();
    File _file = new File(_absoluteFileSystemPath, _string);
    return _file;
  }
  
  public boolean exists(final Path path) {
    File _javaIOFile = this.getJavaIOFile(path);
    boolean _exists = _javaIOFile.exists();
    return _exists;
  }
  
  public boolean isFolder(final Path path) {
    File _javaIOFile = this.getJavaIOFile(path);
    boolean _isDirectory = _javaIOFile.isDirectory();
    return _isDirectory;
  }
  
  public boolean isFile(final Path path) {
    File _javaIOFile = this.getJavaIOFile(path);
    boolean _isFile = _javaIOFile.isFile();
    return _isFile;
  }
  
  public long getLastModification(final Path path) {
    File _javaIOFile = this.getJavaIOFile(path);
    long _lastModified = _javaIOFile.lastModified();
    return _lastModified;
  }
  
  public String getCharset(final Path path) {
    IEncodingProvider _encodingProvider = this.getEncodingProvider();
    File _javaIOFile = this.getJavaIOFile(path);
    String _absolutePath = _javaIOFile.getAbsolutePath();
    URI _createFileURI = URI.createFileURI(_absolutePath);
    return _encodingProvider.getEncoding(_createFileURI);
  }
  
  public InputStream getContentsAsStream(final Path path) {
    try {
      File _javaIOFile = this.getJavaIOFile(path);
      FileInputStream _fileInputStream = new FileInputStream(_javaIOFile);
      BufferedInputStream _bufferedInputStream = new BufferedInputStream(_fileInputStream);
      return _bufferedInputStream;
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
    File _javaIOFile = this.getJavaIOFile(path);
    _javaIOFile.mkdir();
    return true;
  }
  
  public boolean delete(final Path path) {
    try {
      boolean _exists = this.exists(path);
      boolean _not = (!_exists);
      if (_not) {
        return false;
      }
      File _javaIOFile = this.getJavaIOFile(path);
      boolean _isDirectory = _javaIOFile.isDirectory();
      if (_isDirectory) {
        File _javaIOFile_1 = this.getJavaIOFile(path);
        Files.sweepFolder(_javaIOFile_1);
      }
      File _javaIOFile_2 = this.getJavaIOFile(path);
      _javaIOFile_2.delete();
      return true;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void setContentsAsStream(final Path path, final InputStream stream) {
    try {
      Path _parent = path.getParent();
      this.mkdir(_parent);
      final InputSupplier<InputStream> _function = new InputSupplier<InputStream>() {
        public InputStream getInput() throws IOException {
          return stream;
        }
      };
      final OutputSupplier<BufferedOutputStream> _function_1 = new OutputSupplier<BufferedOutputStream>() {
        public BufferedOutputStream getOutput() throws IOException {
          File _javaIOFile = JavaIOFileSystemSupport.this.getJavaIOFile(path);
          FileOutputStream _fileOutputStream = new FileOutputStream(_javaIOFile);
          BufferedOutputStream _bufferedOutputStream = new BufferedOutputStream(_fileOutputStream);
          return _bufferedOutputStream;
        }
      };
      ByteStreams.copy(_function, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public java.net.URI toURI(final Path path) {
    File _javaIOFile = this.getJavaIOFile(path);
    java.net.URI _uRI = _javaIOFile.toURI();
    return _uRI;
  }
  
  public Path getPath(final Resource res) {
    ResourceSet _resourceSet = res.getResourceSet();
    URIConverter _uRIConverter = _resourceSet.getURIConverter();
    URI _uRI = res.getURI();
    final URI uri = _uRIConverter.normalize(_uRI);
    boolean _isFile = uri.isFile();
    if (_isFile) {
      Provider<WorkspaceConfig> _projectInformationProvider = this.getProjectInformationProvider();
      WorkspaceConfig _get = _projectInformationProvider.get();
      String _absoluteFileSystemPath = _get.getAbsoluteFileSystemPath();
      File _file = new File(_absoluteFileSystemPath);
      java.net.URI _uRI_1 = _file.toURI();
      final String workspacePath = _uRI_1.getPath();
      String _fileString = uri.toFileString();
      File _file_1 = new File(_fileString);
      java.net.URI _uRI_2 = _file_1.toURI();
      final String absolutefilePath = _uRI_2.getPath();
      boolean _startsWith = absolutefilePath.startsWith(workspacePath);
      boolean _not = (!_startsWith);
      if (_not) {
        IllegalStateException _illegalStateException = new IllegalStateException((((("Couldn\'t determine file path. The file (\'" + absolutefilePath) + "\') doesn\'t seem to be contained in the workspace (\'") + workspacePath) + "\')"));
        throw _illegalStateException;
      }
      int _length = workspacePath.length();
      final String filePath = absolutefilePath.substring(_length);
      String _string = filePath.toString();
      String _plus = ("/" + _string);
      Path _path = new Path(_plus);
      return _path;
    }
    return null;
  }
}
