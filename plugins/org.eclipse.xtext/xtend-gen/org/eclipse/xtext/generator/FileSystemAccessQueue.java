package org.eclipse.xtext.generator;

import com.google.common.base.Objects;
import java.util.concurrent.BlockingQueue;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.generator.FileSystemAccessRequest;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class FileSystemAccessQueue extends AdapterImpl {
  private BlockingQueue<FileSystemAccessRequest> requestQueue;
  
  public FileSystemAccessQueue(final BlockingQueue<FileSystemAccessRequest> requestQueue) {
    this.requestQueue = requestQueue;
  }
  
  public void sendAsync(final Procedure0 procedure) {
    this.sendAsync(null, procedure);
  }
  
  public void sendAsync(final IResourceDescription.Delta delta, final Procedure0 procedure) {
    FileSystemAccessRequest _fileSystemAccessRequest = new FileSystemAccessRequest();
    final Procedure1<FileSystemAccessRequest> _function = new Procedure1<FileSystemAccessRequest>() {
      public void apply(final FileSystemAccessRequest request) {
        request.delta = delta;
        request.procedure = procedure;
      }
    };
    FileSystemAccessRequest _doubleArrow = ObjectExtensions.<FileSystemAccessRequest>operator_doubleArrow(_fileSystemAccessRequest, _function);
    this.send(_doubleArrow);
  }
  
  public <T extends Object> T send(final Function0<? extends T> function) {
    try {
      T _xblockexpression = null;
      {
        FileSystemAccessRequest _fileSystemAccessRequest = new FileSystemAccessRequest();
        final Procedure1<FileSystemAccessRequest> _function = new Procedure1<FileSystemAccessRequest>() {
          public void apply(final FileSystemAccessRequest request) {
            request.function = function;
          }
        };
        FileSystemAccessRequest _doubleArrow = ObjectExtensions.<FileSystemAccessRequest>operator_doubleArrow(_fileSystemAccessRequest, _function);
        final FileSystemAccessRequest request = this.send(_doubleArrow);
        boolean _while = (!request.completed);
        while (_while) {
          Thread.sleep(50);
          _while = (!request.completed);
        }
        boolean _notEquals = (!Objects.equal(request.throwable, null));
        if (_notEquals) {
          throw request.throwable;
        }
        _xblockexpression = ((T) request.result);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected FileSystemAccessRequest send(final FileSystemAccessRequest request) {
    boolean interrupted = false;
    try {
      boolean _while = true;
      while (_while) {
        try {
          this.requestQueue.put(request);
          return request;
        } catch (final Throwable _t) {
          if (_t instanceof InterruptedException) {
            final InterruptedException e = (InterruptedException)_t;
            interrupted = true;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _while = true;
      }
    } finally {
      if (interrupted) {
        Thread _currentThread = Thread.currentThread();
        _currentThread.interrupt();
      }
    }
    return null;
  }
}
