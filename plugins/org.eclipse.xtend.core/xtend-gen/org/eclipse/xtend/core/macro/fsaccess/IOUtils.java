package org.eclipse.xtend.core.macro.fsaccess;

import com.google.common.base.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class IOUtils {
  public static <T extends Object, C extends Closeable> T tryWith(final Function0<? extends C> provider, final Function1<? super C,? extends T> consumer) {
    C closeable = ((C) null);
    try {
      C _apply = provider.apply();
      closeable = _apply;
      return consumer.apply(closeable);
    } finally {
      IOUtils.<C>closeQuietly(closeable);
    }
  }
  
  public static <C extends Closeable> void tryWith(final Function0<? extends C> provider, final Procedure1<? super C> consumer) {
    C closeable = ((C) null);
    try {
      C _apply = provider.apply();
      closeable = _apply;
      consumer.apply(closeable);
    } finally {
      IOUtils.<C>closeQuietly(closeable);
    }
  }
  
  public static String asString(final InputStream inputStream) {
    String _xblockexpression = null;
    {
      StringWriter _stringWriter = new StringWriter();
      final StringWriter stringWriter = _stringWriter;
      IOUtils.copy(inputStream, stringWriter);
      String _string = stringWriter.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public static int copy(final InputStream inputStream, final Writer writer) {
    InputStreamReader _reader = IOUtils.getReader(inputStream);
    int _copy = IOUtils.copy(_reader, writer);
    return _copy;
  }
  
  public static int copy(final Reader reader, final Writer writer) {
    try {
      final char[] buffer = new char[4096];
      int count = 0;
      int n = 0;
      int _minus = (-1);
      int _read = reader.read(buffer);
      int _n = n = _read;
      boolean _notEquals = (_minus != _n);
      boolean _while = _notEquals;
      while (_while) {
        {
          writer.write(buffer, 0, n);
          int _plus = (count + n);
          count = _plus;
        }
        int _minus_1 = (-1);
        int _read_1 = reader.read(buffer);
        int _n_1 = n = _read_1;
        boolean _notEquals_1 = (_minus_1 != _n_1);
        _while = _notEquals_1;
      }
      return count;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static <C extends Closeable> Object closeQuietly(final C closeable) {
    Object _xtrycatchfinallyexpression = null;
    try {
      boolean _notEquals = (!Objects.equal(closeable, null));
      if (_notEquals) {
        closeable.close();
      }
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public static File getFile(final String path) {
    File _file = new File(path);
    return _file;
  }
  
  public static File getFile(final URI uri) {
    File _file = new File(uri);
    return _file;
  }
  
  public static FileInputStream getInputStream(final File file) {
    try {
      FileInputStream _fileInputStream = new FileInputStream(file);
      return _fileInputStream;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static FileOutputStream getOutputStream(final File file) {
    try {
      FileOutputStream _fileOutputStream = new FileOutputStream(file);
      return _fileOutputStream;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static ByteArrayInputStream getInputStream(final byte[] bytes) {
    ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(bytes);
    return _byteArrayInputStream;
  }
  
  public static BufferedInputStream getBuffered(final InputStream inputStream) {
    BufferedInputStream _bufferedInputStream = new BufferedInputStream(inputStream);
    return _bufferedInputStream;
  }
  
  public static BufferedOutputStream getBuffered(final OutputStream outputStream) {
    BufferedOutputStream _bufferedOutputStream = new BufferedOutputStream(outputStream);
    return _bufferedOutputStream;
  }
  
  public static InputStreamReader getReader(final InputStream inputStream) {
    InputStreamReader _inputStreamReader = new InputStreamReader(inputStream);
    return _inputStreamReader;
  }
  
  public static BufferedReader getBuffered(final Reader reader) {
    BufferedReader _bufferedReader = new BufferedReader(reader);
    return _bufferedReader;
  }
  
  public static OutputStreamWriter getWriter(final OutputStream outputStream) {
    OutputStreamWriter _outputStreamWriter = new OutputStreamWriter(outputStream);
    return _outputStreamWriter;
  }
  
  public static BufferedWriter getBuffered(final Writer writer) {
    BufferedWriter _bufferedWriter = new BufferedWriter(writer);
    return _bufferedWriter;
  }
}
