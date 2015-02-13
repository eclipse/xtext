package org.eclipse.xtext.generator;

import java.util.concurrent.BlockingQueue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.generator.FileSystemAccessRequest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class FileSystemAccessQueue extends AdapterImpl {
  private final BlockingQueue<FileSystemAccessRequest> requestQueue;
  
  private final IProgressMonitor monitor;
  
  public void sendAsync(final URI uri, final Procedure0 procedure) {
    FileSystemAccessRequest _fileSystemAccessRequest = new FileSystemAccessRequest(uri, procedure);
    this.send(_fileSystemAccessRequest);
  }
  
  protected FileSystemAccessRequest send(final FileSystemAccessRequest request) {
    try {
      boolean _isCanceled = this.monitor.isCanceled();
      if (_isCanceled) {
        throw new OperationCanceledException();
      }
      this.requestQueue.put(request);
      return request;
    } catch (final Throwable _t) {
      if (_t instanceof InterruptedException) {
        final InterruptedException e = (InterruptedException)_t;
        throw new OperationCanceledException();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public FileSystemAccessQueue(final BlockingQueue<FileSystemAccessRequest> requestQueue, final IProgressMonitor monitor) {
    super();
    this.requestQueue = requestQueue;
    this.monitor = monitor;
  }
}
