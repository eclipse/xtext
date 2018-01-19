/**
 * Copyright (c) 2016, 2017, 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.concurrent;

import java.util.concurrent.CompletableFuture;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.server.concurrent.AbstractRequest;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class WriteRequest<U extends Object, V extends Object> extends AbstractRequest<V> {
  private final Function0<? extends U> nonCancellable;
  
  private final Function2<? super CancelIndicator, ? super U, ? extends V> cancellable;
  
  private final CompletableFuture<Void> previous;
  
  @Override
  public void run() {
    try {
      this.previous.join();
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      final U intermediateResult = this.nonCancellable.apply();
      this.cancelIndicator.checkCanceled();
      this.result.complete(this.cancellable.apply(this.cancelIndicator, intermediateResult));
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof Throwable) {
        final Throwable e_1 = (Throwable)_t_1;
        this.result.completeExceptionally(e_1);
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
  }
  
  public WriteRequest(final Function0<? extends U> nonCancellable, final Function2<? super CancelIndicator, ? super U, ? extends V> cancellable, final CompletableFuture<Void> previous) {
    super();
    this.nonCancellable = nonCancellable;
    this.cancellable = cancellable;
    this.previous = previous;
  }
}
