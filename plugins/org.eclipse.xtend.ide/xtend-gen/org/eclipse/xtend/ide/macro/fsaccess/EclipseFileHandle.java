package org.eclipse.xtend.ide.macro.fsaccess;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
import org.eclipse.xtend.ide.macro.fsaccess.EclipseResouceHandle;
import org.eclipse.xtend.lib.macro.services.FileHandle;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EclipseFileHandle extends EclipseResouceHandle implements FileHandle {
  public EclipseFileHandle(final IProject project, final IPath path) {
    super(project, path);
  }
  
  public String getContents() {
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
    final Function1<InputStream,String> _function_1 = new Function1<InputStream,String>() {
        public String apply(final InputStream it) {
          String _asString = IOUtils.asString(it);
          return _asString;
        }
      };
    String _tryWith = IOUtils.<String, InputStream>tryWith(_function, _function_1);
    return _tryWith;
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
          EclipseFileHandle.this.write(_function);
        }
      };
    ObjectExtensions.<CharSequence>operator_doubleArrow(_apply, _function);
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
                ByteArrayInputStream _inputStream = IOUtils.getInputStream(_byteArray);
                BufferedInputStream _buffered = IOUtils.getBuffered(_inputStream);
                return _buffered;
              }
            };
          final Procedure1<BufferedInputStream> _function_1 = new Procedure1<BufferedInputStream>() {
              public void apply(final BufferedInputStream it) {
                try {
                  final IFile file = EclipseFileHandle.this.getFile();
                  boolean _exists = file.exists();
                  if (_exists) {
                    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
                    file.setContents(it, true, true, _nullProgressMonitor);
                  } else {
                    EclipseFileHandle.this.create(file, it);
                  }
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
  
  public void create(final IFile it, final InputStream inputStream) {
    try {
      boolean _exists = it.exists();
      boolean _not = (!_exists);
      if (_not) {
        IContainer _parent = it.getParent();
        this.create(_parent);
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        it.create(inputStream, true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _create(final IFolder it) {
    try {
      boolean _exists = it.exists();
      boolean _not = (!_exists);
      if (_not) {
        IContainer _parent = it.getParent();
        this.create(_parent);
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        it.create(true, true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _create(final IContainer it) {
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
  }
  
  public IResource getMember() {
    IFile _file = this.getFile();
    return _file;
  }
  
  public void create(final IContainer it) {
    if (it instanceof IFolder) {
      _create((IFolder)it);
      return;
    } else if (it != null) {
      _create(it);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
