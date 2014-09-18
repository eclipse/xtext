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
      final CancelIndicator _function = new CancelIndicator() {
        public boolean isCanceled() {
          return ((XtextResourceSet)rs).isOutdated();
        }
      };
      _xifexpression = _function;
    } else {
      _xifexpression = CancelIndicator.NullImpl;
    }
    return _xifexpression;
  }
  
  public void checkCanceled(final ResourceSet rs) {
    if ((rs instanceof XtextResourceSet)) {
      boolean _isOutdated = ((XtextResourceSet)rs).isOutdated();
      if (_isOutdated) {
        this.canceledManager.throwOperationCanceledException();
      }
    }
  }
}
