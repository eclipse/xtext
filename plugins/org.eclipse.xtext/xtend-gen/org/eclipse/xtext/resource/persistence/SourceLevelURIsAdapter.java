/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import java.util.Collection;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * An adapter to be installed into a ResourceSet.
 * 
 * It's used as a protocol to tell whether a StorageAwareResource
 * should load from source or could load from serialized data.
 * 
 * @see ResourceStorageProviderAdapter
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@SuppressWarnings("all")
public class SourceLevelURIsAdapter extends AdapterImpl {
  @Accessors
  private ImmutableSet<URI> sourceLevelURIs;
  
  @Override
  public boolean isAdapterForType(final Object type) {
    return Objects.equal(type, SourceLevelURIsAdapter.class);
  }
  
  public static void setSourceLevelUris(final ResourceSet resourceSet, final Collection<URI> uris) {
    SourceLevelURIsAdapter _elvis = null;
    SourceLevelURIsAdapter _findInstalledAdapter = SourceLevelURIsAdapter.findInstalledAdapter(resourceSet);
    if (_findInstalledAdapter != null) {
      _elvis = _findInstalledAdapter;
    } else {
      SourceLevelURIsAdapter _sourceLevelURIsAdapter = new SourceLevelURIsAdapter();
      final Procedure1<SourceLevelURIsAdapter> _function = new Procedure1<SourceLevelURIsAdapter>() {
        @Override
        public void apply(final SourceLevelURIsAdapter it) {
          EList<Adapter> _eAdapters = resourceSet.eAdapters();
          _eAdapters.add(it);
        }
      };
      SourceLevelURIsAdapter _doubleArrow = ObjectExtensions.<SourceLevelURIsAdapter>operator_doubleArrow(_sourceLevelURIsAdapter, _function);
      _elvis = _doubleArrow;
    }
    final SourceLevelURIsAdapter adapter = _elvis;
    ImmutableSet<URI> _copyOf = ImmutableSet.<URI>copyOf(uris);
    adapter.sourceLevelURIs = _copyOf;
  }
  
  public static SourceLevelURIsAdapter findInstalledAdapter(final ResourceSet resourceSet) {
    EList<Adapter> _eAdapters = resourceSet.eAdapters();
    Iterable<SourceLevelURIsAdapter> _filter = Iterables.<SourceLevelURIsAdapter>filter(_eAdapters, SourceLevelURIsAdapter.class);
    return IterableExtensions.<SourceLevelURIsAdapter>head(_filter);
  }
  
  @Pure
  public ImmutableSet<URI> getSourceLevelURIs() {
    return this.sourceLevelURIs;
  }
  
  public void setSourceLevelURIs(final ImmutableSet<URI> sourceLevelURIs) {
    this.sourceLevelURIs = sourceLevelURIs;
  }
}
