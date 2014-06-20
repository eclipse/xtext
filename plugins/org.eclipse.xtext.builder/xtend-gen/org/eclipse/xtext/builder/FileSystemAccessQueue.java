package org.eclipse.xtext.builder;

import java.util.concurrent.BlockingQueue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class FileSystemAccessQueue {
  private BlockingQueue<Pair<IResourceDescription.Delta, Procedure2<? super IFileSystemAccess, ? super IProgressMonitor>>> requestQueue;
  
  public FileSystemAccessQueue(final BlockingQueue<Pair<IResourceDescription.Delta, Procedure2<? super IFileSystemAccess, ? super IProgressMonitor>>> requestQueue) {
    this.requestQueue = requestQueue;
  }
  
  public void put(final IResourceDescription.Delta delta, final Procedure2<? super IFileSystemAccess, ? super IProgressMonitor> procedure) {
    boolean interrupted = false;
    try {
      boolean _while = true;
      while (_while) {
        try {
          Pair<IResourceDescription.Delta, Procedure2<? super IFileSystemAccess, ? super IProgressMonitor>> _mappedTo = Pair.<IResourceDescription.Delta, Procedure2<? super IFileSystemAccess, ? super IProgressMonitor>>of(delta, procedure);
          this.requestQueue.put(_mappedTo);
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
