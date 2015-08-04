/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.service;

import com.google.common.base.Objects;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * A facade for managing and working with cancellation exceptions of different platforms.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@SuppressWarnings("all")
public class OperationCanceledManager {
  protected RuntimeException getPlatformOperationCanceledException(final Throwable t) {
    RuntimeException _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (t instanceof OperationCanceledException) {
        _matched=true;
        _switchResult = ((RuntimeException)t);
      }
    }
    if (!_matched) {
      if (t instanceof RuntimeException) {
        Class<? extends RuntimeException> _class = ((RuntimeException)t).getClass();
        String _name = _class.getName();
        boolean _equals = Objects.equal(_name, "com.intellij.openapi.progress.ProcessCanceledException");
        if (_equals) {
          _matched=true;
          _switchResult = ((RuntimeException)t);
        }
      }
    }
    if (!_matched) {
      if (t instanceof OperationCanceledError) {
        _matched=true;
        _switchResult = ((OperationCanceledError)t).getWrapped();
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  public boolean isOperationCanceledException(final Throwable t) {
    RuntimeException _platformOperationCanceledException = this.getPlatformOperationCanceledException(t);
    return (!Objects.equal(_platformOperationCanceledException, null));
  }
  
  /**
   * Rethrows OperationCanceledErrors and wraps platform specific OperationCanceledExceptions. Does nothing for any other type of Throwable.
   */
  public void propagateAsErrorIfCancelException(final Throwable t) {
    if ((t instanceof OperationCanceledError)) {
      throw ((OperationCanceledError)t);
    }
    final RuntimeException opCanceledException = this.getPlatformOperationCanceledException(t);
    if ((opCanceledException != null)) {
      throw new OperationCanceledError(opCanceledException);
    }
  }
  
  /**
   * Rethrows platform specific OperationCanceledExceptions and unwraps OperationCanceledErrors. Does nothing for any other type of Throwable.
   */
  public void propagateIfCancelException(final Throwable t) {
    final RuntimeException cancelException = this.getPlatformOperationCanceledException(t);
    if ((cancelException != null)) {
      throw cancelException;
    }
  }
  
  protected Error asWrappingOperationCanceledException(final Throwable throwable) {
    if ((throwable instanceof OperationCanceledError)) {
      return ((Error)throwable);
    }
    final RuntimeException platform = this.getPlatformOperationCanceledException(throwable);
    boolean _notEquals = (!Objects.equal(platform, null));
    if (_notEquals) {
      return new OperationCanceledError(platform);
    }
    return null;
  }
  
  public void throwOperationCanceledException() {
    RuntimeException _platformSpecificOperationCanceledException = this.getPlatformSpecificOperationCanceledException();
    throw this.asWrappingOperationCanceledException(_platformSpecificOperationCanceledException);
  }
  
  protected RuntimeException getPlatformSpecificOperationCanceledException() {
    return new OperationCanceledException();
  }
  
  public void checkCanceled(final CancelIndicator indicator) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(indicator, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _isCanceled = indicator.isCanceled();
      _and = _isCanceled;
    }
    if (_and) {
      this.throwOperationCanceledException();
    }
  }
  
  public void checkCanceled(final IProgressMonitor indicator) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(indicator, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _isCanceled = indicator.isCanceled();
      _and = _isCanceled;
    }
    if (_and) {
      this.throwOperationCanceledException();
    }
  }
}
