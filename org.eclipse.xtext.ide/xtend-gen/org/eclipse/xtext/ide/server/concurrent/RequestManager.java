/**
 * Copyright (c) 2016, 2017, 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.xtext.ide.server.concurrent.AbstractRequest;
import org.eclipse.xtext.ide.server.concurrent.ReadRequest;
import org.eclipse.xtext.ide.server.concurrent.WriteRequest;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class RequestManager {
  @Inject
  private ExecutorService parallel;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  private final ExecutorService queue = Executors.newSingleThreadExecutor(
    new ThreadFactoryBuilder().setDaemon(true).setNameFormat("RequestManager-Queue-%d").build());
  
  private ArrayList<AbstractRequest<?>> requests = CollectionLiterals.<AbstractRequest<?>>newArrayList();
  
  public void shutdown() {
    this.queue.shutdown();
    this.parallel.shutdown();
    this.cancel();
  }
  
  public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> cancellable) {
    ReadRequest<V> _readRequest = new ReadRequest<V>(cancellable, this.parallel);
    return this.<V>submit(_readRequest);
  }
  
  public <U extends Object, V extends Object> CompletableFuture<V> runWrite(final Function0<? extends U> nonCancellable, final Function2<? super CancelIndicator, ? super U, ? extends V> cancellable) {
    final CompletableFuture<Void> cancelFuture = this.cancel();
    WriteRequest<U, V> _writeRequest = new WriteRequest<U, V>(nonCancellable, cancellable, cancelFuture);
    return this.<V>submit(_writeRequest);
  }
  
  protected <V extends Object> CompletableFuture<V> submit(final AbstractRequest<V> request) {
    this.requests.add(request);
    this.queue.submit(request);
    return request.get();
  }
  
  protected CompletableFuture<Void> cancel() {
    final ArrayList<AbstractRequest<?>> localRequests = this.requests;
    this.requests = CollectionLiterals.<AbstractRequest<?>>newArrayList();
    final ArrayList<CompletableFuture<?>> cfs = CollectionLiterals.<CompletableFuture<?>>newArrayList();
    for (final AbstractRequest<?> request : localRequests) {
      {
        request.cancel();
        CompletableFuture<?> _get = request.get();
        cfs.add(_get);
      }
    }
    return CompletableFuture.allOf(((CompletableFuture<?>[])Conversions.unwrapArray(cfs, CompletableFuture.class)));
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
