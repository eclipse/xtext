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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import org.eclipse.xtext.ide.server.concurrent.CancellableIndicator;
import org.eclipse.xtext.ide.server.concurrent.RequestCancelIndicator;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  
  public Future<Void> runWrite(final Procedure1<? super CancelIndicator> writeRequest) {
    RequestCancelIndicator _requestCancelIndicator = new RequestCancelIndicator();
    return this.runWrite(writeRequest, _requestCancelIndicator);
  }
  
  public Future<Void> runWrite(final Procedure1<? super CancelIndicator> writeRequest, final CancelIndicator cancelIndicator) {
    Future<Void> _xblockexpression = null;
    {
      final Procedure1<CancellableIndicator> _function = new Procedure1<CancellableIndicator>() {
        @Override
        public void apply(final CancellableIndicator it) {
          it.cancel();
        }
      };
      IterableExtensions.<CancellableIndicator>forEach(this.cancelIndicators, _function);
      final Function1<CancelIndicator, Void> _function_1 = new Function1<CancelIndicator, Void>() {
        @Override
        public Void apply(final CancelIndicator it) {
          writeRequest.apply(it);
          return null;
        }
      };
      _xblockexpression = this.<Void>run(this.writeExecutorService, _function_1, this.MAX_PERMITS, cancelIndicator);
    }
    return _xblockexpression;
  }
  
  public <V extends Object> Future<V> runRead(final Function1<? super CancelIndicator, ? extends V> readRequest) {
    RequestCancelIndicator _requestCancelIndicator = new RequestCancelIndicator();
    return this.<V>runRead(readRequest, _requestCancelIndicator);
  }
  
  public <V extends Object> Future<V> runRead(final Function1<? super CancelIndicator, ? extends V> readRequest, final CancelIndicator cancelIndicator) {
    return this.<V>run(this.readExecutorService, readRequest, 1, cancelIndicator);
  }
  
  protected <V extends Object> Future<V> run(final ExecutorService executorService, final Function1<? super CancelIndicator, ? extends V> request, final int permits, final CancelIndicator cancelIndicator) {
    final Callable<V> _function = new Callable<V>() {
      @Override
      public V call() throws Exception {
        RequestManager.this.semaphore.acquire(permits);
        try {
          if ((cancelIndicator instanceof CancellableIndicator)) {
            RequestManager.this.cancelIndicators.add(((CancellableIndicator)cancelIndicator));
          }
          return request.apply(cancelIndicator);
        } finally {
          if ((cancelIndicator instanceof CancellableIndicator)) {
            RequestManager.this.cancelIndicators.remove(((CancellableIndicator)cancelIndicator));
          }
          RequestManager.this.semaphore.release(permits);
        }
      }
    };
    return executorService.<V>submit(_function);
  }
}
