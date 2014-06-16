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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend.lib.Property;
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
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaIOFileSystemSupport extends AbstractFileSystemSupport {
  @Inject
  @Property
  private Provider<WorkspaceConfig> _projectInformationProvider;
  
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
      final Function1<String, Path> _function = new Function1<String, Path>() {
        public Path apply(final String it) {
          return path.getAbsolutePath(it);
        }
      };
      _xblockexpression = ListExtensions.<String, Path>map(((List<String>)Conversions.doWrapArray(_list)), _function);
    }
    return _xblockexpression;
  }
  
  protected File getJavaIOFile(final Path path) {
    Provider<WorkspaceConfig> _projectInformationProvider = this.getProjectInformationProvider();
    WorkspaceConfig _get = _projectInformationProvider.get();
    String _absoluteFileSystemPath = _get.getAbsoluteFileSystemPath();
    String _string = path.toString();
    return new File(_absoluteFileSystemPath, _string);
  }
  
  public boolean exists(final Path path) {
    File _javaIOFile = this.getJavaIOFile(path);
    return _javaIOFile.exists();
  }
  
  public boolean isFolder(final Path path) {
    File _javaIOFile = this.getJavaIOFile(path);
    return _javaIOFile.isDirectory();
  }
  
  public boolean isFile(final Path path) {
    File _javaIOFile = this.getJavaIOFile(path);
    return _javaIOFile.isFile();
  }
  
  public long getLastModification(final Path path) {
    File _javaIOFile = this.getJavaIOFile(path);
    return _javaIOFile.lastModified();
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
      return new BufferedInputStream(_fileInputStream);
    } catch (final Throwable _t) {
      if (_t instanceof FileNotFoundException) {
        final FileNotFoundException exc = (FileNotFoundException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
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
    boolean _exists = this.exists(path);
    boolean _not = (!_exists);
    if (_not) {
      return false;
    }
    File _javaIOFile = this.getJavaIOFile(path);
    boolean _isDirectory = _javaIOFile.isDirectory();
    if (_isDirectory) {
      try {
        File _javaIOFile_1 = this.getJavaIOFile(path);
        Files.sweepFolder(_javaIOFile_1);
      } catch (final Throwable _t) {
        if (_t instanceof FileNotFoundException) {
          final FileNotFoundException exc = (FileNotFoundException)_t;
          String _message = exc.getMessage();
          throw new IllegalArgumentException(_message, exc);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    File _javaIOFile_2 = this.getJavaIOFile(path);
    _javaIOFile_2.delete();
    return true;
  }
  
  public void setContentsAsStream(final Path path, final InputStream stream) {
    Path _parent = path.getParent();
    this.mkdir(_parent);
    try {
      final InputSupplier<InputStream> _function = new InputSupplier<InputStream>() {
        public InputStream getInput() throws IOException {
          return stream;
        }
      };
      final OutputSupplier<BufferedOutputStream> _function_1 = new OutputSupplier<BufferedOutputStream>() {
        public BufferedOutputStream getOutput() throws IOException {
          File _javaIOFile = JavaIOFileSystemSupport.this.getJavaIOFile(path);
          FileOutputStream _fileOutputStream = new FileOutputStream(_javaIOFile);
          return new BufferedOutputStream(_fileOutputStream);
        }
      };
      ByteStreams.copy(_function, _function_1);
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
  
  public java.net.URI toURI(final Path path) {
    File _javaIOFile = this.getJavaIOFile(path);
    return _javaIOFile.toURI();
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
        throw new IllegalStateException((((("Couldn\'t determine file path. The file (\'" + absolutefilePath) + "\') doesn\'t seem to be contained in the workspace (\'") + workspacePath) + "\')"));
      }
      int _length = workspacePath.length();
      final String filePath = absolutefilePath.substring(_length);
      String _string = filePath.toString();
      String _plus = ("/" + _string);
      return new Path(_plus);
    }
    return null;
  }
  
  @Pure
  public Provider<WorkspaceConfig> getProjectInformationProvider() {
    return this._projectInformationProvider;
  }
  
  public void setProjectInformationProvider(final Provider<WorkspaceConfig> projectInformationProvider) {
    this._projectInformationProvider = projectInformationProvider;
  }
}
