/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.concurrent;

import com.google.inject.Inject;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.eclipse.xtext.ide.server.concurrent.Cancellable;
import org.eclipse.xtext.ide.server.concurrent.RequestCancelIndicator;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

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
  private final static Logger LOGGER = Logger.getLogger(RequestManager.class);
  
  private final int MAX_PERMITS = Integer.MAX_VALUE;
  
  private final int WRITE_PERMITS = this.MAX_PERMITS;
  
  private final int READ_PERMITS = 1;
  
  private final ExecutorService sequential = Executors.newSingleThreadExecutor();
  
  @Inject
  private ExecutorService parallel;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  private final CopyOnWriteArrayList<Cancellable> toCancel = new CopyOnWriteArrayList<Cancellable>();
  
  private final Semaphore semaphore = new Semaphore(this.MAX_PERMITS);
  
  public void shutdown() {
    this.sequential.shutdown();
    this.parallel.shutdown();
  }
  
  public <V extends Object> V lockRead(final Function0<? extends V> request) {
    return this.<V>lock(this.READ_PERMITS, request);
  }
  
  public <V extends Object> V lockWrite(final Function0<? extends V> request) {
    return this.<V>lock(this.WRITE_PERMITS, request);
  }
  
  public void cancel() {
    for (final Cancellable cancellable : this.toCancel) {
      {
        cancellable.cancel();
        this.toCancel.remove(cancellable);
      }
    }
  }
  
  public <V extends Object> CompletableFuture<V> runWrite(final Function1<? super CancelIndicator, ? extends V> request) {
    final Function1<CompletableFuture<Function0<? extends V>>, CompletableFuture<V>> _function = (CompletableFuture<Function0<? extends V>> it) -> {
      final Function<Function0<? extends V>, V> _function_1 = (Function0<? extends V> it_1) -> {
        return this.<V>lockWrite(it_1);
      };
      return it.<V>thenApply(_function_1);
    };
    return this.<V>queue(request, _function);
  }
  
  public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> request) {
    final Function1<CompletableFuture<Function0<? extends V>>, CompletableFuture<V>> _function = (CompletableFuture<Function0<? extends V>> it) -> {
      final Function<Function0<? extends V>, V> _function_1 = (Function0<? extends V> it_1) -> {
        return this.<V>lockRead(it_1);
      };
      return it.<V>thenApplyAsync(_function_1, this.parallel);
    };
    return this.<V>queue(request, _function);
  }
  
  protected <V extends Object> CompletableFuture<V> queue(final Function1<? super CancelIndicator, ? extends V> request, final Function1<? super CompletableFuture<Function0<? extends V>>, ? extends CompletableFuture<V>> requestExecutor) {
    final CompletableFuture<RequestCancelIndicator> origin = new CompletableFuture<RequestCancelIndicator>();
    final Function<RequestCancelIndicator, Function0<? extends V>> _function = (RequestCancelIndicator it) -> {
      return this.<V>bind(it, request);
    };
    final CompletableFuture<V> requestFuture = requestExecutor.apply(
      origin.<Function0<? extends V>>thenApplyAsync(_function, this.sequential));
    final RequestCancelIndicator cancelIndicator = new RequestCancelIndicator(requestFuture);
    this.toCancel.add(cancelIndicator);
    final BiConsumer<V, Throwable> _function_1 = (V $0, Throwable $1) -> {
      this.toCancel.remove(cancelIndicator);
    };
    final CompletableFuture<V> result = requestFuture.whenComplete(_function_1);
    origin.complete(cancelIndicator);
    return result;
  }
  
  protected <V extends Object> Function0<? extends V> bind(final RequestCancelIndicator cancelIndicator, final Function1<? super CancelIndicator, ? extends V> request) {
    cancelIndicator.checkCanceled();
    final Function0<V> _function = () -> {
      V _xblockexpression = null;
      {
        cancelIndicator.checkCanceled();
        _xblockexpression = request.apply(cancelIndicator);
      }
      return _xblockexpression;
    };
    return _function;
  }
  
  protected <V extends Object> V lock(final int permits, final Function0<? extends V> request) {
    try {
      this.semaphore.acquire(permits);
      try {
        return request.apply();
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          boolean _isCancelException = this.isCancelException(t);
          if (_isCancelException) {
            RequestManager.LOGGER.info("request cancelled.");
            throw new CancellationException();
          }
          throw t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        this.semaphore.release(permits);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
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
