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
    @Override
    public Boolean initialValue() {
      return Boolean.valueOf(true);
    }
  };
  
  /**
   * Created a fresh CancelIndicator
   */
  public CancelIndicator newCancelIndicator(final ResourceSet rs) {
    CancelIndicator _xifexpression = null;
    if ((rs instanceof XtextResourceSet)) {
      final boolean cancelationAllowed = (this.cancelationAllowed.get()).booleanValue();
      final int current = ((XtextResourceSet)rs).getModificationStamp();
      final CancelIndicator _function = () -> {
        return (cancelationAllowed && (((XtextResourceSet)rs).isOutdated() || (current != ((XtextResourceSet)rs).getModificationStamp())));
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
      if ((((XtextResourceSet)rs).isOutdated() && (this.cancelationAllowed.get()).booleanValue())) {
        this.canceledManager.throwOperationCanceledException();
      }
    }
  }
  
  public <R extends Object, P extends Resource> R exec(final IUnitOfWork<R, P> work, final P param) {
    try {
      R _xblockexpression = null;
      {
        final Boolean wasCancelationAllowed = this.cancelationAllowed.get();
        R _xtrycatchfinallyexpression = null;
        try {
          R _xblockexpression_1 = null;
          {
            if ((work instanceof CancelableUnitOfWork<?, ?>)) {
              CancelIndicator _xifexpression = null;
              if ((param == null)) {
                final CancelIndicator _function = () -> {
                  return true;
                };
                _xifexpression = _function;
              } else {
                _xifexpression = this.newCancelIndicator(param.getResourceSet());
              }
              ((CancelableUnitOfWork<?, ?>)work).setCancelIndicator(_xifexpression);
            } else {
              this.cancelationAllowed.set(Boolean.valueOf(false));
            }
            _xblockexpression_1 = work.exec(param);
          }
          _xtrycatchfinallyexpression = _xblockexpression_1;
        } finally {
          this.cancelationAllowed.set(wasCancelationAllowed);
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
