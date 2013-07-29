package org.eclipse.xtend.ide.macro.fsaccess;

import com.google.common.io.CharStreams;
import com.google.common.io.OutputSupplier;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtend.core.macro.fsaccess.IOUtils;
import org.eclipse.xtend.ide.macro.fsaccess.EclipseResourceHandle;
import org.eclipse.xtend.lib.macro.services.FileHandle;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EclipseFileHandle extends EclipseResourceHandle implements FileHandle {
  public EclipseFileHandle(final IProject project, final IPath path, final IEncodingProvider encodingProvider) {
    super(project, path, encodingProvider);
  }
  
  public IResource getMember() {
    IFile _file = this.getFile();
    return _file;
  }
  
  public String getContents() {
    try {
      IFile _file = this.getFile();
      InputStream _contents = _file.getContents();
      String _encoding = this.getEncoding();
      InputStreamReader _inputStreamReader = new InputStreamReader(_contents, _encoding);
      String _string = CharStreams.toString(_inputStreamReader);
      return _string;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void read(final Procedure1<InputStream> function) {
    final Function0<InputStream> _function = new Function0<InputStream>() {
      public InputStream apply() {
        try {
          IFile _file = EclipseFileHandle.this.getFile();
          InputStream _contents = _file.getContents();
          return _contents;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IOUtils.<InputStream>tryWith(_function, function);
  }
  
  public void writeContents(final Function1<FileHandle,CharSequence> function) {
    final Procedure1<OutputStream> _function = new Procedure1<OutputStream>() {
      public void apply(final OutputStream outputStream) {
        try {
          CharSequence _apply = function.apply(EclipseFileHandle.this);
          final OutputSupplier<BufferedWriter> _function = new OutputSupplier<BufferedWriter>() {
            public BufferedWriter getOutput() throws IOException {
              OutputStreamWriter _outputStreamWriter = new OutputStreamWriter(outputStream);
              BufferedWriter _bufferedWriter = new BufferedWriter(_outputStreamWriter);
              return _bufferedWriter;
            }
          };
          CharStreams.<BufferedWriter>write(_apply, _function);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    this.write(_function);
  }
  
  public void write(final Procedure1<OutputStream> function) {
    final Function0<ByteArrayOutputStream> _function = new Function0<ByteArrayOutputStream>() {
      public ByteArrayOutputStream apply() {
        ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
        return _byteArrayOutputStream;
      }
    };
    final Procedure1<ByteArrayOutputStream> _function_1 = new Procedure1<ByteArrayOutputStream>() {
      public void apply(final ByteArrayOutputStream it) {
        function.apply(it);
        final Function0<BufferedInputStream> _function = new Function0<BufferedInputStream>() {
          public BufferedInputStream apply() {
            byte[] _byteArray = it.toByteArray();
            ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
            BufferedInputStream _bufferedInputStream = new BufferedInputStream(_byteArrayInputStream);
            return _bufferedInputStream;
          }
        };
        final Procedure1<BufferedInputStream> _function_1 = new Procedure1<BufferedInputStream>() {
          public void apply(final BufferedInputStream it) {
            try {
              IFile _file = EclipseFileHandle.this.getFile();
              IFile _ensureCreated = EclipseFileHandle.this.ensureCreated(_file);
              NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
              _ensureCreated.setContents(it, true, true, _nullProgressMonitor);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        IOUtils.<BufferedInputStream>tryWith(_function, _function_1);
      }
    };
    IOUtils.<ByteArrayOutputStream>tryWith(_function, _function_1);
  }
  
  protected IFile _ensureCreated(final IFile it) {
    try {
      IFile _xblockexpression = null;
      {
        boolean _exists = it.exists();
        boolean _not = (!_exists);
        if (_not) {
          IContainer _parent = it.getParent();
          this.ensureCreated(_parent);
          byte[] _newByteArrayOfSize = new byte[0];
          ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_newByteArrayOfSize);
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          it.create(_byteArrayInputStream, true, _nullProgressMonitor);
        }
        IFile _file = this.getFile();
        _xblockexpression = (_file);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IFile _ensureCreated(final IFolder it) {
    try {
      IFile _xblockexpression = null;
      {
        boolean _exists = it.exists();
        boolean _not = (!_exists);
        if (_not) {
          IContainer _parent = it.getParent();
          this.ensureCreated(_parent);
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          it.create(true, true, _nullProgressMonitor);
        }
        _xblockexpression = (null);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IFile _ensureCreated(final IContainer it) {
    IFile _xblockexpression = null;
    {
      boolean _exists = it.exists();
      boolean _not = (!_exists);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Container does not exist: \'");
        _builder.append(this.path, "");
        _builder.append("\'.");
        IllegalStateException _illegalStateException = new IllegalStateException(_builder.toString());
        throw _illegalStateException;
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  public IFile ensureCreated(final IResource it) {
    if (it instanceof IFile) {
      return _ensureCreated((IFile)it);
    } else if (it instanceof IFolder) {
      return _ensureCreated((IFolder)it);
    } else if (it instanceof IContainer) {
      return _ensureCreated((IContainer)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
