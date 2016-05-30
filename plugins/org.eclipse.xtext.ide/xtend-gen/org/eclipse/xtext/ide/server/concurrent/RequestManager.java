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
  
  public CompletableFuture<Void> runWrite(final Procedure1<? super CancelIndicator> writeRequest) {
    RequestCancelIndicator _requestCancelIndicator = new RequestCancelIndicator();
    return this.runWrite(writeRequest, _requestCancelIndicator);
  }
  
  public CompletableFuture<Void> runWrite(final Procedure1<? super CancelIndicator> writeRequest, final CancelIndicator cancelIndicator) {
    final Consumer<CancellableIndicator> _function = (CancellableIndicator it) -> {
      it.cancel();
    };
    this.cancelIndicators.forEach(_function);
    final Runnable _function_1 = () -> {
      Function1<? super CancelIndicator, ? extends Void> _withVoidAsReturnType = this.withVoidAsReturnType(writeRequest);
      this.<Void>run(_withVoidAsReturnType, this.MAX_PERMITS, cancelIndicator);
    };
    return CompletableFuture.runAsync(_function_1, this.writeExecutorService);
  }
  
  public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> readRequest) {
    RequestCancelIndicator _requestCancelIndicator = new RequestCancelIndicator();
    return this.<V>runRead(readRequest, _requestCancelIndicator);
  }
  
  public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> readRequest, final CancelIndicator cancelIndicator) {
    final Supplier<V> _function = () -> {
      return this.<V>run(readRequest, 1, cancelIndicator);
    };
    return CompletableFuture.<V>supplyAsync(_function, this.readExecutorService);
  }
  
  protected <V extends Object> V run(final Function1<? super CancelIndicator, ? extends V> request, final int permits, final CancelIndicator cancelIndicator) {
    try {
      this.semaphore.acquire(permits);
      try {
        if ((cancelIndicator instanceof CancellableIndicator)) {
          this.cancelIndicators.add(((CancellableIndicator)cancelIndicator));
        }
        return request.apply(cancelIndicator);
      } finally {
        if ((cancelIndicator instanceof CancellableIndicator)) {
          this.cancelIndicators.remove(((CancellableIndicator)cancelIndicator));
        }
        this.semaphore.release(permits);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Function1<? super CancelIndicator, ? extends Void> withVoidAsReturnType(final Procedure1<? super CancelIndicator> request) {
    final Function1<CancelIndicator, Void> _function = (CancelIndicator cancelIindicator) -> {
      request.apply(cancelIindicator);
      return null;
    };
    return _function;
  }
}
