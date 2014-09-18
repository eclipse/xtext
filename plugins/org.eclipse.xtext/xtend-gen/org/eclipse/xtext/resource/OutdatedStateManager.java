/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @version 2.8
 */
@SuppressWarnings("all")
public class OutdatedStateManager {
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
}
