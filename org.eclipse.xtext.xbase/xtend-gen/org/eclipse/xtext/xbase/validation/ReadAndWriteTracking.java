/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.validation;

import com.google.common.collect.Iterables;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ReadAndWriteTracking {
  protected static class InitializedMarker extends AdapterImpl {
    private Set<JvmConstructor> byConstructors = CollectionLiterals.<JvmConstructor>newHashSet();
    
    public boolean isInitialized(final JvmConstructor constructor) {
      return this.byConstructors.contains(constructor);
    }
    
    public boolean markInitialized(final JvmConstructor constructor) {
      return this.byConstructors.add(constructor);
    }
  }
  
  public boolean markReadAccess(final EObject object) {
    boolean _xifexpression = false;
    boolean _isRead = this.isRead(object);
    boolean _not = (!_isRead);
    if (_not) {
      _xifexpression = object.eAdapters().add(ReadAndWriteTracking.READMARKER);
    }
    return _xifexpression;
  }
  
  public boolean isRead(final EObject object) {
    return object.eAdapters().contains(ReadAndWriteTracking.READMARKER);
  }
  
  private static final Adapter READMARKER = new Adapter() {
    @Override
    public Notifier getTarget() {
      return null;
    }
    
    @Override
    public boolean isAdapterForType(final Object type) {
      return false;
    }
    
    @Override
    public void notifyChanged(final Notification notification) {
    }
    
    @Override
    public void setTarget(final Notifier newTarget) {
    }
  };
  
  public boolean markInitialized(final EObject it, final JvmConstructor constructor) {
    boolean _xblockexpression = false;
    {
      ReadAndWriteTracking.InitializedMarker _elvis = null;
      ReadAndWriteTracking.InitializedMarker _initializedMarker = this.getInitializedMarker(it);
      if (_initializedMarker != null) {
        _elvis = _initializedMarker;
      } else {
        ReadAndWriteTracking.InitializedMarker _newInitalizedMarker = this.newInitalizedMarker(it);
        _elvis = _newInitalizedMarker;
      }
      ReadAndWriteTracking.InitializedMarker initializedMarker = _elvis;
      _xblockexpression = initializedMarker.markInitialized(constructor);
    }
    return _xblockexpression;
  }
  
  public boolean isInitialized(final EObject it, final JvmConstructor constructor) {
    ReadAndWriteTracking.InitializedMarker _initializedMarker = this.getInitializedMarker(it);
    boolean _isInitialized = false;
    if (_initializedMarker!=null) {
      _isInitialized=_initializedMarker.isInitialized(constructor);
    }
    return _isInitialized;
  }
  
  protected ReadAndWriteTracking.InitializedMarker newInitalizedMarker(final EObject it) {
    ReadAndWriteTracking.InitializedMarker _xblockexpression = null;
    {
      final ReadAndWriteTracking.InitializedMarker initializedMarker = new ReadAndWriteTracking.InitializedMarker();
      it.eAdapters().add(initializedMarker);
      _xblockexpression = initializedMarker;
    }
    return _xblockexpression;
  }
  
  protected ReadAndWriteTracking.InitializedMarker getInitializedMarker(final EObject object) {
    return IterableExtensions.<ReadAndWriteTracking.InitializedMarker>head(Iterables.<ReadAndWriteTracking.InitializedMarker>filter(object.eAdapters(), ReadAndWriteTracking.InitializedMarker.class));
  }
}
