package org.eclipse.xtend.core.macro.fsaccess;

import java.io.File;
import java.net.URI;
import org.eclipse.xtend.core.macro.fsaccess.RuntimeFileHandle;
import org.eclipse.xtend.core.macro.fsaccess.RuntimeResourceHandle;
import org.eclipse.xtend.lib.macro.services.FileHandle;
import org.eclipse.xtend.lib.macro.services.FolderHandle;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class RuntimeFolderHandle extends RuntimeResourceHandle implements FolderHandle {
  public RuntimeFolderHandle(final File file, final IEncodingProvider encodingProvider) {
    super(file, encodingProvider);
  }
  
  public FileHandle getFile(final String path) {
    try {
      RuntimeFileHandle _xblockexpression = null;
      {
        String _fullPath = this.getFullPath(path);
        File _file = new File(_fullPath);
        final File file = _file;
        boolean _isDirectory = file.isDirectory();
        if (_isDirectory) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Given path is an existed folder (not a file): \'");
          String _canonicalPath = file.getCanonicalPath();
          _builder.append(_canonicalPath, "");
          _builder.append("\'.");
          final String message = _builder.toString();
          IllegalStateException _illegalStateException = new IllegalStateException(message);
          throw _illegalStateException;
        }
        RuntimeFileHandle _runtimeFileHandle = new RuntimeFileHandle(file, this.encodingProvider);
        _xblockexpression = (_runtimeFileHandle);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public FolderHandle getFolder(final String path) {
    try {
      RuntimeFolderHandle _xblockexpression = null;
      {
        String _fullPath = this.getFullPath(path);
        File _file = new File(_fullPath);
        final File folder = _file;
        boolean _isFile = folder.isFile();
        if (_isFile) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Given path is an existed file (not a folder): \'");
          String _canonicalPath = folder.getCanonicalPath();
          _builder.append(_canonicalPath, "");
          _builder.append("\'.");
          final String message = _builder.toString();
          IllegalStateException _illegalStateException = new IllegalStateException(message);
          throw _illegalStateException;
        }
        RuntimeFolderHandle _runtimeFolderHandle = new RuntimeFolderHandle(folder, this.encodingProvider);
        _xblockexpression = (_runtimeFolderHandle);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getFullPath(final String path) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      String _path = this.getPath();
      _builder.append(_path, "");
      _builder.append("/");
      _builder.append(path, "");
      URI _uRI = new URI(_builder.toString());
      URI _normalize = _uRI.normalize();
      String _path_1 = _normalize.getPath();
      return _path_1;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
