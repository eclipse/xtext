package org.eclipse.xtext.generator;

import java.util.concurrent.BlockingQueue;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.FileSystemAccessRequest;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
  
  public void sendAsync(final URI uri, final Procedure0 procedure) {
    FileSystemAccessRequest _fileSystemAccessRequest = new FileSystemAccessRequest();
    final Procedure1<FileSystemAccessRequest> _function = new Procedure1<FileSystemAccessRequest>() {
      public void apply(final FileSystemAccessRequest request) {
        request.uri = uri;
        request.procedure = procedure;
      }
    };
    FileSystemAccessRequest _doubleArrow = ObjectExtensions.<FileSystemAccessRequest>operator_doubleArrow(_fileSystemAccessRequest, _function);
    this.send(_doubleArrow);
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
