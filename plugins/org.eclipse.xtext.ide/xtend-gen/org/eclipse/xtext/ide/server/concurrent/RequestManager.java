/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.concurrent;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.eclipse.xtext.ide.server.concurrent.CancellableIndicator;
import org.eclipse.xtext.ide.server.concurrent.RequestCancelIndicator;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class RequestManager {
  public final static String READ_EXECUTOR_SERVICE = "org.eclipse.xtext.ide.server.concurrent.RequestManager.readExecutorService";
  
  public final static String WRITE_EXECUTOR_SERVICE = "org.eclipse.xtext.ide.server.concurrent.RequestManager.writeExecutorService";
  
  private final int MAX_PERMITS = Integer.MAX_VALUE;
  
  @Inject
  @Named(RequestManager.READ_EXECUTOR_SERVICE)
  private ExecutorService readExecutorService;
  
  @Inject
  @Named(RequestManager.WRITE_EXECUTOR_SERVICE)
  private ExecutorService writeExecutorService;
  
  private final LinkedBlockingQueue<CancellableIndicator> cancelIndicators = new LinkedBlockingQueue<CancellableIndicator>();
  
  private final Semaphore semaphore = new Semaphore(this.MAX_PERMITS);
  
  public void shutdown() {
    this.readExecutorService.shutdown();
    this.writeExecutorService.shutdown();
  }
  
  public CompletableFuture<Void> runWrite(final Procedure1<? super CancelIndicator> writeRequest) {
    RequestCancelIndicator _requestCancelIndicator = new RequestCancelIndicator();
    return this.runWrite(writeRequest, _requestCancelIndicator);
  }
  
  /**
   * <p>
   * The given <i>write request</i> will be run first when <i>all running requests</i> completed.
   * </p>
   * <p>
   * Currently <i>running requests</i> will be cancelled.
   * </p>
   * <p>
   * A provided cancel indicator should implement {@link org.eclipse.xtext.ide.server.concurrent.CancellableIndicator CancellableIndicator}
   * to let the given request to be cancelled by a write request.
   * </p>
   */
  public CompletableFuture<Void> runWrite(final Procedure1<? super CancelIndicator> writeRequest, final CancelIndicator cancelIndicator) {
    try {
      final Consumer<CancellableIndicator> _function = new Consumer<CancellableIndicator>() {
        @Override
        public void accept(final CancellableIndicator it) {
          it.cancel();
        }
      };
      this.cancelIndicators.forEach(_function);
      if ((cancelIndicator instanceof CancellableIndicator)) {
        this.cancelIndicators.add(((CancellableIndicator)cancelIndicator));
      }
      this.semaphore.acquire(this.MAX_PERMITS);
      final Runnable _function_1 = new Runnable() {
        @Override
        public void run() {
          try {
            writeRequest.apply(cancelIndicator);
          } finally {
            RequestManager.this.semaphore.release(RequestManager.this.MAX_PERMITS);
          }
        }
      };
      CompletableFuture<Void> _runAsync = CompletableFuture.runAsync(_function_1, this.writeExecutorService);
      final BiConsumer<Void, Throwable> _function_2 = new BiConsumer<Void, Throwable>() {
        @Override
        public void accept(final Void $0, final Throwable $1) {
          if ((cancelIndicator instanceof CancellableIndicator)) {
            RequestManager.this.cancelIndicators.remove(((CancellableIndicator)cancelIndicator));
          }
        }
      };
      return _runAsync.whenComplete(_function_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> readRequest) {
    RequestCancelIndicator _requestCancelIndicator = new RequestCancelIndicator();
    return this.<V>runRead(readRequest, _requestCancelIndicator);
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
   * A provided cancel indicator should implement {@link org.eclipse.xtext.ide.server.concurrent.CancellableIndicator CancellableIndicator}
   * to let the given request to be cancelled by a write request.
   * </p>
   */
  public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> readRequest, final CancelIndicator cancelIndicator) {
    try {
      if ((cancelIndicator instanceof CancellableIndicator)) {
        this.cancelIndicators.add(((CancellableIndicator)cancelIndicator));
      }
      this.semaphore.acquire(1);
      final Supplier<V> _function = new Supplier<V>() {
        @Override
        public V get() {
          try {
            return readRequest.apply(cancelIndicator);
          } finally {
            RequestManager.this.semaphore.release(1);
          }
        }
      };
      CompletableFuture<V> _supplyAsync = CompletableFuture.<V>supplyAsync(_function, this.readExecutorService);
      final BiConsumer<V, Throwable> _function_1 = new BiConsumer<V, Throwable>() {
        @Override
        public void accept(final V $0, final Throwable $1) {
          if ((cancelIndicator instanceof CancellableIndicator)) {
            RequestManager.this.cancelIndicators.remove(((CancellableIndicator)cancelIndicator));
          }
        }
      };
      return _supplyAsync.whenComplete(_function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
