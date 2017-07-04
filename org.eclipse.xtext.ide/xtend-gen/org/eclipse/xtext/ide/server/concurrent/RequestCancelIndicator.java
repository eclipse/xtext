/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import org.eclipse.lsp4j.jsonrpc.CancelChecker;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.server.concurrent.Cancellable;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class RequestCancelIndicator implements CancelIndicator, CancelChecker, Cancellable {
  private final CompletableFuture<?> requestFuture;
  
  @Override
  public void cancel() {
    this.requestFuture.cancel(true);
  }
  
  @Override
  public boolean isCanceled() {
    this.checkCanceled();
    return false;
  }
  
  @Override
  public void checkCanceled() {
    boolean _isCancelled = this.requestFuture.isCancelled();
    if (_isCancelled) {
      throw new CancellationException();
    }
  }
  
  public RequestCancelIndicator(final CompletableFuture<?> requestFuture) {
    super();
    this.requestFuture = requestFuture;
  }
}
