/**
 * Copyright (c) 2016, 2017, 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.server.concurrent.AbstractRequest;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class ReadRequest<V extends Object> extends AbstractRequest<V> {
  private static final Logger LOG = Logger.getLogger(ReadRequest.class);
  
  private final Function1<? super CancelIndicator, ? extends V> cancellable;
  
  private final ExecutorService executor;
  
  @Override
  public void run() {
    boolean _isCancelled = this.result.isCancelled();
    if (_isCancelled) {
      return;
    }
    final Callable<Boolean> _function = () -> {
      boolean _xtrycatchfinallyexpression = false;
      try {
        boolean _xblockexpression = false;
        {
          this.cancelIndicator.checkCanceled();
          _xblockexpression = this.result.complete(this.cancellable.apply(this.cancelIndicator));
        }
        _xtrycatchfinallyexpression = _xblockexpression;
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable e = (Throwable)_t;
          boolean _xblockexpression_1 = false;
          {
            if (((e != null) && (!this.requestManager.isCancelException(e)))) {
              ReadRequest.LOG.error("Error during request: ", e);
            }
            _xblockexpression_1 = this.result.completeExceptionally(e);
          }
          _xtrycatchfinallyexpression = _xblockexpression_1;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return Boolean.valueOf(_xtrycatchfinallyexpression);
    };
    this.executor.<Boolean>submit(_function);
  }
  
  public ReadRequest(final RequestManager requestManager, final Function1<? super CancelIndicator, ? extends V> cancellable, final ExecutorService executor) {
    super(requestManager);
    this.cancellable = cancellable;
    this.executor = executor;
  }
}
