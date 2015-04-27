/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.psi;

import com.google.common.base.Objects;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class LoadingTypeResourcePhase extends AdapterImpl {
  private final static LoadingTypeResourcePhase INSTANCE = new LoadingTypeResourcePhase();
  
  @Override
  public boolean isAdapterForType(final Object type) {
    return Objects.equal(LoadingTypeResourcePhase.INSTANCE, type);
  }
  
  public static boolean isLoadingTypeResource(final Notifier ctx) {
    boolean _xblockexpression = false;
    {
      final ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
      boolean _equals = Objects.equal(resourceSet, null);
      if (_equals) {
        return false;
      }
      EList<Adapter> _eAdapters = resourceSet.eAdapters();
      Adapter _adapter = EcoreUtil.getAdapter(_eAdapters, LoadingTypeResourcePhase.INSTANCE);
      _xblockexpression = (!Objects.equal(_adapter, null));
    }
    return _xblockexpression;
  }
  
  public static void setLoadingTypeResource(final Notifier ctx, final boolean loadingTypeResource) {
    ResourceSet _resourceSet = EcoreUtil2.getResourceSet(ctx);
    final EList<Adapter> adapters = _resourceSet.eAdapters();
    if (loadingTypeResource) {
      adapters.add(LoadingTypeResourcePhase.INSTANCE);
    } else {
      adapters.remove(LoadingTypeResourcePhase.INSTANCE);
    }
  }
}
