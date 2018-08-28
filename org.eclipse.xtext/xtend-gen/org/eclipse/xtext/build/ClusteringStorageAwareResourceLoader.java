/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.build;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.build.BuildContext;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProviderExtension;
import org.eclipse.xtext.resource.persistence.SourceLevelURIsAdapter;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class ClusteringStorageAwareResourceLoader {
  @Extension
  private final BuildContext context;
  
  public <T extends Object> Iterable<T> executeClustered(final Iterable<URI> uris, final Function1<? super Resource, ? extends T> operation) {
    int loadedURIsCount = 0;
    final HashSet<URI> sourceLevelURIs = CollectionLiterals.<URI>newHashSet();
    final ArrayList<Resource> resources = CollectionLiterals.<Resource>newArrayList();
    final ArrayList<T> result = CollectionLiterals.<T>newArrayList();
    final Iterator<URI> iter = uris.iterator();
    while (iter.hasNext()) {
      {
        final URI uri = iter.next();
        boolean _continueProcessing = this.context.getClusteringPolicy().continueProcessing(this.context.getResourceSet(), uri, loadedURIsCount);
        boolean _not = (!_continueProcessing);
        if (_not) {
          final Function1<Resource, T> _function = (Resource it) -> {
            return operation.apply(it);
          };
          List<T> _map = ListExtensions.<Resource, T>map(resources, _function);
          Iterables.<T>addAll(result, _map);
          this.clearResourceSet();
          loadedURIsCount = 0;
        }
        loadedURIsCount++;
        boolean _isSource = this.isSource(uri);
        if (_isSource) {
          sourceLevelURIs.add(uri);
          final Resource existingResource = this.context.getResourceSet().getResource(uri, false);
          if ((existingResource instanceof StorageAwareResource)) {
            boolean _isLoadedFromStorage = ((StorageAwareResource)existingResource).isLoadedFromStorage();
            if (_isLoadedFromStorage) {
              ((StorageAwareResource)existingResource).unload();
            }
          }
          SourceLevelURIsAdapter.setSourceLevelUrisWithoutCopy(this.context.getResourceSet(), sourceLevelURIs);
        }
        Resource _resource = this.context.getResourceSet().getResource(uri, true);
        resources.add(_resource);
      }
    }
    final Function1<Resource, T> _function = (Resource it) -> {
      return operation.apply(it);
    };
    List<T> _map = ListExtensions.<Resource, T>map(resources, _function);
    Iterables.<T>addAll(result, _map);
    return result;
  }
  
  protected boolean isSource(final URI uri) {
    final IResourceServiceProvider provider = this.context.getResourceServiceProvider(uri);
    return ((provider instanceof IResourceServiceProviderExtension) && 
      ((IResourceServiceProviderExtension) provider).isSource(uri));
  }
  
  protected void clearResourceSet() {
    final boolean wasDeliver = this.context.getResourceSet().eDeliver();
    try {
      this.context.getResourceSet().eSetDeliver(false);
      this.context.getResourceSet().getResources().clear();
    } finally {
      this.context.getResourceSet().eSetDeliver(wasDeliver);
    }
  }
  
  public ClusteringStorageAwareResourceLoader(final BuildContext context) {
    super();
    this.context = context;
  }
}
