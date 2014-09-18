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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * A facade for managing the outdated state of an XtextResourceSet.
 * 
 * A XtextResourceSet is considered outdated if new external changes are pending and processed
 * working on the current state should be canceled.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@SuppressWarnings("all")
public class ProcessCanceledManager {
  /**
   * Marks the given XtextResourceSet as outdated.
   * As a result any previously created CancelIndicators will be set to canceled.
   */
  public void markOutdated(final ResourceSet rs) {
    if ((rs instanceof XtextResourceSet)) {
      ((XtextResourceSet)rs).incrementOutdatedStamp();
    }
  }
  
  /**
   * Created a fresh CancelIndicator
   */
  public CancelIndicator newCancelIndiciator(final ResourceSet rs) {
    if ((rs instanceof XtextResourceSet)) {
      final int current = ((XtextResourceSet)rs).getOutdatedStamp();
      final CancelIndicator _function = new CancelIndicator() {
        public boolean isCanceled() {
          int _outdatedStamp = ((XtextResourceSet)rs).getOutdatedStamp();
          return (current != _outdatedStamp);
        }
      };
      return _function;
    } else {
      final CancelIndicator _function_1 = new CancelIndicator() {
        public boolean isCanceled() {
          return false;
        }
      };
      return _function_1;
    }
  }
  
  public RuntimeException newOperationCanceledException() {
    return new OperationCanceledException();
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
}
