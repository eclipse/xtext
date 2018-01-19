/**
 * Copyright (c) 2016, 2017, 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.concurrent;

import java.util.concurrent.CompletableFuture;
import org.eclipse.xtext.ide.server.concurrent.Cancellable;
import org.eclipse.xtext.ide.server.concurrent.RequestCancelIndicator;

@SuppressWarnings("all")
public abstract class AbstractRequest<V extends Object> implements Runnable, Cancellable {
  protected final CompletableFuture<V> result = new CompletableFuture<V>();
  
  protected final RequestCancelIndicator cancelIndicator = new RequestCancelIndicator(this.result);
  
  @Override
  public void cancel() {
    this.cancelIndicator.cancel();
  }
  
  public CompletableFuture<V> get() {
    return this.result;
  }
}
