package org.eclipse.xtend.core.macro.fsaccess;

import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.common.io.OutputSupplier;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.eclipse.xtend.core.macro.fsaccess.IOUtils;
import org.eclipse.xtend.core.macro.fsaccess.RuntimeResourceHandle;
import org.eclipse.xtend.lib.macro.services.FileHandle;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class RuntimeFileHandle extends RuntimeResourceHandle implements FileHandle {
  public RuntimeFileHandle(final File file, final IEncodingProvider encodingProvider) {
    super(file, encodingProvider);
  }
  
  public String getContents() {
    try {
      Charset _encoding = this.getEncoding();
      String _string = Files.toString(this.file, _encoding);
      return _string;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void read(final Procedure1<InputStream> function) {
    final Function0<FileInputStream> _function = new Function0<FileInputStream>() {
        public FileInputStream apply() {
          try {
            InputSupplier<FileInputStream> _newInputStreamSupplier = Files.newInputStreamSupplier(RuntimeFileHandle.this.file);
            FileInputStream _input = _newInputStreamSupplier.getInput();
            return _input;
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    IOUtils.<InputStream>tryWith(_function, function);
  }
  
  public void write(final Procedure1<OutputStream> function) {
    final Function0<FileOutputStream> _function = new Function0<FileOutputStream>() {
        public FileOutputStream apply() {
          try {
            File _ensureFileCreated = RuntimeFileHandle.this.ensureFileCreated();
            OutputSupplier<FileOutputStream> _newOutputStreamSupplier = Files.newOutputStreamSupplier(_ensureFileCreated);
            FileOutputStream _output = _newOutputStreamSupplier.getOutput();
            return _output;
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    IOUtils.<OutputStream>tryWith(_function, function);
  }
  
  public void writeContents(final Function1<FileHandle,CharSequence> function) {
    try {
      CharSequence _apply = function.apply(this);
      File _ensureFileCreated = this.ensureFileCreated();
      Charset _encoding = this.getEncoding();
      Files.write(_apply, _ensureFileCreated, _encoding);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public File ensureFileCreated() {
    try {
      File _xblockexpression = null;
      {
        final File file = this.file;
        boolean _exists = file.exists();
        boolean _not = (!_exists);
        if (_not) {
          Files.createParentDirs(file);
          file.createNewFile();
        }
        _xblockexpression = (file);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
