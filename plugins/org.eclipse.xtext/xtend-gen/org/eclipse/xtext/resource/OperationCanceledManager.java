/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import com.google.common.base.Objects;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A facade for managing and working with cancellation exceptions of different platforms.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@SuppressWarnings("all")
public class OperationCanceledManager {
  @FinalFieldsConstructor
  private static final class OperationCanceledError extends Error {
    @Accessors
    private final RuntimeException wrapped;
    
    public OperationCanceledError(final RuntimeException wrapped) {
      super();
      this.wrapped = wrapped;
    }
    
    @Pure
    public RuntimeException getWrapped() {
      return this.wrapped;
    }
  }
  
  /**
   * @since 2.8
   */
  public RuntimeException getOperationCanceledException(final Throwable t) {
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
      if (t instanceof OperationCanceledManager.OperationCanceledError) {
        _matched=true;
        _switchResult = ((OperationCanceledManager.OperationCanceledError)t).wrapped;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  /**
   * @since 2.8
   */
  public void throwIfOperationCanceledException(final Throwable t) {
    final RuntimeException opCanceledException = this.getOperationCanceledException(t);
    boolean _notEquals = (!Objects.equal(opCanceledException, null));
    if (_notEquals) {
      throw opCanceledException;
    }
  }
  
  /**
   * @since 2.8
   */
  public void throwAsErrorIfOperationCanceledException(final Throwable t) {
    try {
      final RuntimeException opCanceledException = this.getOperationCanceledException(t);
      boolean _notEquals = (!Objects.equal(opCanceledException, null));
      if (_notEquals) {
        throw this.getCheckedOperationCanceledException(opCanceledException);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public OperationCanceledManager.OperationCanceledError getCheckedOperationCanceledException(final RuntimeException opCanceledException) {
    return new OperationCanceledManager.OperationCanceledError(opCanceledException);
  }
}
