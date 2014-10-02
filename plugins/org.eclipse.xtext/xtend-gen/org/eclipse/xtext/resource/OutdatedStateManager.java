/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@SuppressWarnings("all")
public class OutdatedStateManager {
  @Inject
  private OperationCanceledManager canceledManager;
  
  private final ThreadLocal<Boolean> cancelationAllowed = new ThreadLocal<Boolean>() {
    public Boolean initialValue() {
      return Boolean.valueOf(true);
    }
  };
  
  /**
   * Created a fresh CancelIndicator
   */
  public CancelIndicator newCancelIndiciator(final ResourceSet rs) {
    CancelIndicator _xifexpression = null;
    if ((rs instanceof XtextResourceSet)) {
      final int current = ((XtextResourceSet)rs).getModificationStamp();
      final CancelIndicator _function = new CancelIndicator() {
        public boolean isCanceled() {
          boolean _and = false;
          Boolean _get = OutdatedStateManager.this.cancelationAllowed.get();
          if (!(_get).booleanValue()) {
            _and = false;
          } else {
            boolean _or = false;
            boolean _isOutdated = ((XtextResourceSet)rs).isOutdated();
            if (_isOutdated) {
              _or = true;
            } else {
              int _modificationStamp = ((XtextResourceSet)rs).getModificationStamp();
              boolean _notEquals = (current != _modificationStamp);
              _or = _notEquals;
            }
            _and = _or;
          }
          return _and;
        }
      };
      return _function;
    } else {
      _xifexpression = CancelIndicator.NullImpl;
    }
    return _xifexpression;
  }
  
  /**
   * Checks whether the given ResourceSet is in an outdated state and
   * throws an {@link OperationCanceledError} if so.
   */
  public void checkCanceled(final ResourceSet rs) {
    if ((rs instanceof XtextResourceSet)) {
      boolean _and = false;
      boolean _isOutdated = ((XtextResourceSet)rs).isOutdated();
      if (!_isOutdated) {
        _and = false;
      } else {
        Boolean _get = this.cancelationAllowed.get();
        _and = (_get).booleanValue();
      }
      if (_and) {
        this.canceledManager.throwOperationCanceledException();
      }
    }
  }
  
  public <R extends Object, P extends Resource> R exec(final IUnitOfWork<R, P> work, final P param) {
    try {
      R _xtrycatchfinallyexpression = null;
      try {
        R _xblockexpression = null;
        {
          if ((work instanceof CancelableUnitOfWork<?, ?>)) {
            ResourceSet _resourceSet = param.getResourceSet();
            CancelIndicator _newCancelIndiciator = this.newCancelIndiciator(_resourceSet);
            ((CancelableUnitOfWork<?, ?>)work).setCancelIndicator(_newCancelIndiciator);
          } else {
            this.cancelationAllowed.set(Boolean.valueOf(false));
          }
          _xblockexpression = work.exec(param);
        }
        _xtrycatchfinallyexpression = _xblockexpression;
      } finally {
        this.cancelationAllowed.set(Boolean.valueOf(true));
      }
      return _xtrycatchfinallyexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
