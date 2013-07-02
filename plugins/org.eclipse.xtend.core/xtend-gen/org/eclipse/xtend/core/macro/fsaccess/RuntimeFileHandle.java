package org.eclipse.xtend.core.macro.fsaccess;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.eclipse.xtend.core.macro.fsaccess.IOUtils;
import org.eclipse.xtend.core.macro.fsaccess.RuntimeResourceHandle;
import org.eclipse.xtend.lib.macro.services.FileHandle;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class RuntimeFileHandle extends RuntimeResourceHandle implements FileHandle {
  public RuntimeFileHandle(final File file) {
    super(file);
  }
  
  public String getContents() {
    final Function0<BufferedInputStream> _function = new Function0<BufferedInputStream>() {
        public BufferedInputStream apply() {
          FileInputStream _inputStream = IOUtils.getInputStream(RuntimeFileHandle.this.file);
          BufferedInputStream _buffered = IOUtils.getBuffered(_inputStream);
          return _buffered;
        }
      };
    final Function1<BufferedInputStream,String> _function_1 = new Function1<BufferedInputStream,String>() {
        public String apply(final BufferedInputStream it) {
          String _asString = IOUtils.asString(it);
          return _asString;
        }
      };
    String _tryWith = IOUtils.<String, BufferedInputStream>tryWith(_function, _function_1);
    return _tryWith;
  }
  
  public void read(final Procedure1<InputStream> function) {
    final Function0<FileInputStream> _function = new Function0<FileInputStream>() {
        public FileInputStream apply() {
          FileInputStream _inputStream = IOUtils.getInputStream(RuntimeFileHandle.this.file);
          return _inputStream;
        }
      };
    IOUtils.<InputStream>tryWith(_function, function);
  }
  
  public void write(final Procedure1<OutputStream> function) {
    try {
      final File file = this.file;
      boolean _exists = file.exists();
      boolean _not = (!_exists);
      if (_not) {
        final File parentFile = file.getParentFile();
        boolean _exists_1 = parentFile.exists();
        boolean _not_1 = (!_exists_1);
        if (_not_1) {
          parentFile.mkdirs();
        }
        file.createNewFile();
      }
      final Function0<FileOutputStream> _function = new Function0<FileOutputStream>() {
          public FileOutputStream apply() {
            FileOutputStream _outputStream = IOUtils.getOutputStream(file);
            return _outputStream;
          }
        };
      IOUtils.<OutputStream>tryWith(_function, function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void writeContents(final Function1<FileHandle,CharSequence> function) {
    CharSequence _apply = function.apply(this);
    final Procedure1<CharSequence> _function = new Procedure1<CharSequence>() {
        public void apply(final CharSequence value) {
          final Procedure1<OutputStream> _function = new Procedure1<OutputStream>() {
              public void apply(final OutputStream it) {
                final Function0<BufferedWriter> _function = new Function0<BufferedWriter>() {
                    public BufferedWriter apply() {
                      OutputStreamWriter _writer = IOUtils.getWriter(it);
                      BufferedWriter _buffered = IOUtils.getBuffered(_writer);
                      return _buffered;
                    }
                  };
                final Procedure1<BufferedWriter> _function_1 = new Procedure1<BufferedWriter>() {
                    public void apply(final BufferedWriter it) {
                      try {
                        String _string = value.toString();
                        it.write(_string);
                      } catch (Throwable _e) {
                        throw Exceptions.sneakyThrow(_e);
                      }
                    }
                  };
                IOUtils.<BufferedWriter>tryWith(_function, _function_1);
              }
            };
          RuntimeFileHandle.this.write(_function);
        }
      };
    ObjectExtensions.<CharSequence>operator_doubleArrow(_apply, _function);
  }
}
