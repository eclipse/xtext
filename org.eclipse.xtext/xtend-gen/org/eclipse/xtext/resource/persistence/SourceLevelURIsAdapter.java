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
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
  private Set<URI> sourceLevelURIs;
  
  public Set<URI> getSourceLevelURIs() {
    return Collections.<URI>unmodifiableSet(this.sourceLevelURIs);
  }
  
  @Override
  public boolean isAdapterForType(final Object type) {
    return Objects.equal(type, SourceLevelURIsAdapter.class);
  }
  
  public static void setSourceLevelUris(final ResourceSet resourceSet, final Collection<URI> uris) {
    final SourceLevelURIsAdapter adapter = SourceLevelURIsAdapter.findOrCreateAdapter(resourceSet);
    adapter.sourceLevelURIs = ImmutableSet.<URI>copyOf(uris);
  }
  
  protected static SourceLevelURIsAdapter findOrCreateAdapter(final ResourceSet resourceSet) {
    SourceLevelURIsAdapter _elvis = null;
    SourceLevelURIsAdapter _findInstalledAdapter = SourceLevelURIsAdapter.findInstalledAdapter(resourceSet);
    if (_findInstalledAdapter != null) {
      _elvis = _findInstalledAdapter;
    } else {
      SourceLevelURIsAdapter _sourceLevelURIsAdapter = new SourceLevelURIsAdapter();
      final Procedure1<SourceLevelURIsAdapter> _function = (SourceLevelURIsAdapter it) -> {
        EList<Adapter> _eAdapters = resourceSet.eAdapters();
        _eAdapters.add(it);
      };
      SourceLevelURIsAdapter _doubleArrow = ObjectExtensions.<SourceLevelURIsAdapter>operator_doubleArrow(_sourceLevelURIsAdapter, _function);
      _elvis = _doubleArrow;
    }
    return _elvis;
  }
  
  /**
   * Installs the given set of URIs as the source level URIs. Does not copy the given
   * set but uses it directly.
   */
  public static void setSourceLevelUrisWithoutCopy(final ResourceSet resourceSet, final Set<URI> uris) {
    final SourceLevelURIsAdapter adapter = SourceLevelURIsAdapter.findOrCreateAdapter(resourceSet);
    adapter.sourceLevelURIs = uris;
  }
  
  public static SourceLevelURIsAdapter findInstalledAdapter(final ResourceSet resourceSet) {
    return IterableExtensions.<SourceLevelURIsAdapter>head(Iterables.<SourceLevelURIsAdapter>filter(resourceSet.eAdapters(), SourceLevelURIsAdapter.class));
  }
  
  public void setSourceLevelURIs(final Set<URI> sourceLevelURIs) {
    this.sourceLevelURIs = sourceLevelURIs;
  }
}
