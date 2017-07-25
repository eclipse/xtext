/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.concurrent;

import com.google.inject.Inject;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.eclipse.xtext.ide.server.concurrent.Cancellable;
import org.eclipse.xtext.ide.server.concurrent.RequestCancelIndicator;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

/**
 * <p>
 * The request manager run read/write requests.
 * </p>
 * <p>
 * <b>Execution:</b>
 * <ul>
 *  <li>requests are processed in an insertion order;</li>
 * 	<li>write requests are executed exclusive;</li>
 *  <li>read requests are executed in parallel.</li>
 * </ul>
 * </p>
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class RequestManager {
  private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
  
  private final Lock r = this.rwl.readLock();
  
  private final Lock w = this.rwl.writeLock();
  
  @Inject
  private ExecutorService parallel;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  private final CopyOnWriteArrayList<Cancellable> toCancel = new CopyOnWriteArrayList<Cancellable>();
  
  public void shutdown() {
    this.parallel.shutdown();
    this.cancel();
  }
  
  public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> request) {
    final CompletableFuture<V> result = new CompletableFuture<V>();
    final Runnable _function = () -> {
      final Callable<Boolean> _function_1 = () -> {
        boolean _xblockexpression = false;
        {
          final RequestCancelIndicator cancelIndicator = new RequestCancelIndicator(result);
          boolean _xtrycatchfinallyexpression = false;
          try {
            boolean _xblockexpression_1 = false;
            {
              this.r.lock();
              this.toCancel.add(cancelIndicator);
              cancelIndicator.checkCanceled();
              _xblockexpression_1 = result.complete(request.apply(cancelIndicator));
            }
            _xtrycatchfinallyexpression = _xblockexpression_1;
          } catch (final Throwable _t) {
            if (_t instanceof Throwable) {
              final Throwable e = (Throwable)_t;
              _xtrycatchfinallyexpression = result.completeExceptionally(e);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          } finally {
            this.toCancel.remove(cancelIndicator);
            this.r.unlock();
          }
          _xblockexpression = _xtrycatchfinallyexpression;
        }
        return Boolean.valueOf(_xblockexpression);
      };
      this.parallel.<Boolean>submit(_function_1);
    };
    this.writePending.thenRun(_function);
    return result;
  }
  
  private CompletableFuture<Void> writePending = CompletableFuture.<Void>completedFuture(null);
  
  public <U extends Object, V extends Object> CompletableFuture<V> runWrite(final Function0<? extends U> nonCancellable, final Function2<? super CancelIndicator, ? super U, ? extends V> request) {
    final CompletableFuture<V> result = new CompletableFuture<V>();
    final CompletableFuture<Void> localWritePending = new CompletableFuture<Void>();
    this.writePending = localWritePending;
    final Callable<Boolean> _function = () -> {
      boolean _xblockexpression = false;
      {
        final RequestCancelIndicator cancelIndicator = new RequestCancelIndicator(result);
        boolean _xtrycatchfinallyexpression = false;
        try {
          boolean _xblockexpression_1 = false;
          {
            this.cancel();
            this.w.lock();
            localWritePending.complete(null);
            final U intermediateResult = nonCancellable.apply();
            this.toCancel.add(cancelIndicator);
            cancelIndicator.checkCanceled();
            _xblockexpression_1 = result.complete(request.apply(cancelIndicator, intermediateResult));
          }
          _xtrycatchfinallyexpression = _xblockexpression_1;
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable e = (Throwable)_t;
            _xtrycatchfinallyexpression = result.completeExceptionally(e);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        } finally {
          this.toCancel.remove(cancelIndicator);
          this.w.unlock();
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return Boolean.valueOf(_xblockexpression);
    };
    this.parallel.<Boolean>submit(_function);
    return result;
  }
  
  protected void cancel() {
    for (final Cancellable cancellable : this.toCancel) {
      {
        cancellable.cancel();
        this.toCancel.remove(cancellable);
      }
    }
  }
  
  protected boolean isCancelException(final Throwable t) {
    if ((t == null)) {
      return false;
    }
    Throwable _xifexpression = null;
    if ((t instanceof CompletionException)) {
      _xifexpression = ((CompletionException)t).getCause();
    } else {
      _xifexpression = t;
    }
    final Throwable cause = _xifexpression;
    return this.operationCanceledManager.isOperationCanceledException(cause);
  }
}
