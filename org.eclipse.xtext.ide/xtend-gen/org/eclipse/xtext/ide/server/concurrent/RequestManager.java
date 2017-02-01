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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.eclipse.lsp4j.jsonrpc.CancelChecker;
import org.eclipse.lsp4j.jsonrpc.CompletableFutures;
import org.eclipse.xtext.ide.server.concurrent.Cancellable;
import org.eclipse.xtext.ide.server.concurrent.RequestCancelIndicator;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class RequestManager {
  private final static Logger LOGGER = Logger.getLogger(RequestManager.class);
  
  private final int MAX_PERMITS = Integer.MAX_VALUE;
  
  @Inject
  private ExecutorService executorService;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  private final LinkedBlockingQueue<Cancellable> cancelIndicators = new LinkedBlockingQueue<Cancellable>();
  
  private final Semaphore semaphore = new Semaphore(this.MAX_PERMITS);
  
  public void shutdown() {
    this.executorService.shutdown();
  }
  
  /**
   * <p>
   * The given <i>write request</i> will be run first when <i>all running requests</i> completed.
   * </p>
   * <p>
   * Currently <i>running requests</i> will be cancelled.
   * </p>
   * <p>
   * A provided cancel indicator should implement {@link CancelIndicator}
   * to let the given request to be cancelled by a write request.
   * </p>
   */
  public <V extends Object> CompletableFuture<V> runWrite(final Function1<? super CancelIndicator, ? extends V> writeRequest) {
    try {
      try {
        this.semaphore.acquire(this.MAX_PERMITS);
        final CancelIndicator _function = () -> {
          return false;
        };
        final V result = writeRequest.apply(_function);
        return CompletableFuture.<V>completedFuture(result);
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
        this.semaphore.release(this.MAX_PERMITS);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * <p>
   * The given <i>read request</i> will be run:
   * <ul>
   * 	<li>concurrent with <i>running read requests</i>;</li>
   * 	<li>first when <i>running write requests</i> completed.</li>
   * </ul>
   * </p>
   * <p>
   * </p>
   */
  public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> readRequest) {
    final Function<CancelChecker, V> _function = (CancelChecker it) -> {
      try {
        final RequestCancelIndicator cancelIndicator = new RequestCancelIndicator(it);
        this.cancelIndicators.add(cancelIndicator);
        this.semaphore.acquire(1);
        try {
          cancelIndicator.checkCanceled();
          final CancelIndicator _function_1 = () -> {
            cancelIndicator.checkCanceled();
            return false;
          };
          return readRequest.apply(_function_1);
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
          this.cancelIndicators.remove(cancelIndicator);
          this.semaphore.release(1);
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    return CompletableFutures.<V>computeAsync(this.executorService, _function);
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
