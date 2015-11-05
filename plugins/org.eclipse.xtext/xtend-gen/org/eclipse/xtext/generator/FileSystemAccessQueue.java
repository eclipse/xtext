package org.eclipse.xtext.generator;

import java.util.concurrent.BlockingQueue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.generator.FileSystemAccessRequest;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class FileSystemAccessQueue extends AdapterImpl {
  private final BlockingQueue<FileSystemAccessRequest> requestQueue;
  
  private final IProgressMonitor monitor;
  
  /**
   * @since 2.8
   */
  @FinalFieldsConstructor
  public FileSystemAccessQueue(final BlockingQueue<FileSystemAccessRequest> requestQueue, final IProgressMonitor monitor) {
    super();
    this.requestQueue = requestQueue;
    this.monitor = monitor;
  }
  
  /**
   * @since 2.9
   */
  public void sendAsync(final URI uri, final Runnable runMe) {
    FileSystemAccessRequest _fileSystemAccessRequest = new FileSystemAccessRequest(uri, runMe);
    this.send(_fileSystemAccessRequest);
  }
  
  protected FileSystemAccessRequest send(final FileSystemAccessRequest request) {
    try {
      boolean _isCanceled = this.monitor.isCanceled();
      if (_isCanceled) {
        throw new OperationCanceledError();
      }
      this.requestQueue.put(request);
      return request;
    } catch (final Throwable _t) {
      if (_t instanceof InterruptedException) {
        final InterruptedException e = (InterruptedException)_t;
        throw new OperationCanceledError();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
