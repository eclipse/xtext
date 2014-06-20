package org.eclipse.xtext.builder;

import java.util.concurrent.BlockingQueue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.FileSystemAccessRequest;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class FileSystemAccessQueue {
  private BlockingQueue<FileSystemAccessRequest> requestQueue;
  
  public FileSystemAccessQueue(final BlockingQueue<FileSystemAccessRequest> requestQueue) {
    this.requestQueue = requestQueue;
  }
  
  public void put(final IResourceDescription.Delta delta, final Procedure2<? super IFileSystemAccess, ? super IProgressMonitor> procedure) {
    boolean interrupted = false;
    try {
      boolean _while = true;
      while (_while) {
        try {
          FileSystemAccessRequest _fileSystemAccessRequest = new FileSystemAccessRequest();
          final Procedure1<FileSystemAccessRequest> _function = new Procedure1<FileSystemAccessRequest>() {
            public void apply(final FileSystemAccessRequest request) {
              request.delta = delta;
              request.procedure = procedure;
            }
          };
          FileSystemAccessRequest _doubleArrow = ObjectExtensions.<FileSystemAccessRequest>operator_doubleArrow(_fileSystemAccessRequest, _function);
          this.requestQueue.put(_doubleArrow);
          return;
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
  }
}
