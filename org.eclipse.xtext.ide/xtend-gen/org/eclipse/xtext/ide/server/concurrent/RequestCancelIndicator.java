/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.concurrent;

import java.util.concurrent.CancellationException;
import org.eclipse.lsp4j.jsonrpc.CancelIndicator;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.server.concurrent.Cancellable;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class RequestCancelIndicator implements CancelIndicator, Cancellable {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private volatile boolean canceled;
  
  private CancelIndicator delegate;
  
  public RequestCancelIndicator() {
  }
  
  public RequestCancelIndicator(final CancelIndicator delegate) {
    this.delegate = delegate;
  }
  
  @Override
  public void cancel() {
    this.canceled = true;
  }
  
  @Override
  public void checkCanceled() {
    if ((this.delegate != null)) {
      this.delegate.checkCanceled();
    }
    if (this.canceled) {
      throw new CancellationException("process canceled");
    }
  }
  
  @Pure
  public boolean isCanceled() {
    return this.canceled;
  }
}
