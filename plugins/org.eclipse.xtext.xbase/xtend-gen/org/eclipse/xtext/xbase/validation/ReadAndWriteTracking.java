/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.validation;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ReadAndWriteTracking {
  public boolean markReadAccess(final EObject object) {
    boolean _xifexpression = false;
    boolean _isRead = this.isRead(object);
    boolean _not = (!_isRead);
    if (_not) {
      EList<Adapter> _eAdapters = object.eAdapters();
      _xifexpression = _eAdapters.add(ReadAndWriteTracking.READ_MARKER);
    }
    return _xifexpression;
  }
  
  public boolean isRead(final EObject object) {
    EList<Adapter> _eAdapters = object.eAdapters();
    return _eAdapters.contains(ReadAndWriteTracking.READ_MARKER);
  }
  
  public boolean markInitialized(final EObject object) {
    boolean _xifexpression = false;
    boolean _isInitialized = this.isInitialized(object);
    boolean _not = (!_isInitialized);
    if (_not) {
      EList<Adapter> _eAdapters = object.eAdapters();
      _xifexpression = _eAdapters.add(ReadAndWriteTracking.INITIALIZED_MARKER);
    }
    return _xifexpression;
  }
  
  public boolean isInitialized(final EObject object) {
    EList<Adapter> _eAdapters = object.eAdapters();
    return _eAdapters.contains(ReadAndWriteTracking.INITIALIZED_MARKER);
  }
  
  private final static AdapterImpl READ_MARKER = new AdapterImpl() {
  };
  
  private final static AdapterImpl INITIALIZED_MARKER = new AdapterImpl() {
  };
}
