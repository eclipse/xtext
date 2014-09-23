/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@SuppressWarnings("all")
public class OutdatedStateManager {
  @Inject
  private OperationCanceledManager canceledManager;
  
  /**
   * Created a fresh CancelIndicator
   */
  public CancelIndicator newCancelIndiciator(final ResourceSet rs) {
    CancelIndicator _xifexpression = null;
    if ((rs instanceof XtextResourceSet)) {
      final int current = ((XtextResourceSet)rs).getModificationStamp();
      final CancelIndicator _function = new CancelIndicator() {
        public boolean isCanceled() {
          boolean _or = false;
          boolean _isOutdated = ((XtextResourceSet)rs).isOutdated();
          if (_isOutdated) {
            _or = true;
          } else {
            int _modificationStamp = ((XtextResourceSet)rs).getModificationStamp();
            boolean _notEquals = (current != _modificationStamp);
            _or = _notEquals;
          }
          return _or;
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
      boolean _isOutdated = ((XtextResourceSet)rs).isOutdated();
      if (_isOutdated) {
        this.canceledManager.throwOperationCanceledException();
      }
    }
  }
}
