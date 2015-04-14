/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.psi;

import com.google.common.base.Objects;
import java.util.Iterator;
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
  @Override
  public boolean isAdapterForType(final Object type) {
    return Objects.equal(LoadingTypeResourcePhase.class, type);
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
      Adapter _adapter = EcoreUtil.getAdapter(_eAdapters, LoadingTypeResourcePhase.class);
      _xblockexpression = (!Objects.equal(_adapter, null));
    }
    return _xblockexpression;
  }
  
  public static void setLoadingTypeResource(final Notifier ctx, final boolean loadingTypeResource) {
    final ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
    if (loadingTypeResource) {
      EList<Adapter> _eAdapters = resourceSet.eAdapters();
      LoadingTypeResourcePhase _loadingTypeResourcePhase = new LoadingTypeResourcePhase();
      _eAdapters.add(_loadingTypeResourcePhase);
    } else {
      EList<Adapter> _eAdapters_1 = resourceSet.eAdapters();
      final Iterator<Adapter> i = _eAdapters_1.iterator();
      while (i.hasNext()) {
        Adapter _next = i.next();
        boolean _isAdapterForType = _next.isAdapterForType(LoadingTypeResourcePhase.class);
        if (_isAdapterForType) {
          i.remove();
          return;
        }
      }
    }
  }
}
