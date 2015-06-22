/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.builder.standalone.incremental.ClusteringStorageAwareResourceLoader;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class BuildContext {
  private final IResourceServiceProvider.Registry resourceServiceProviderRegistry;
  
  @Accessors
  private final XtextResourceSet resourceSet;
  
  @Accessors
  private final IResourceClusteringPolicy clusteringPolicy;
  
  private ClusteringStorageAwareResourceLoader loader;
  
  public <T extends Object> Iterable<T> executeClustered(final Iterable<URI> uri, final Function1<? super Resource, ? extends T> operation) {
    boolean _equals = Objects.equal(this.loader, null);
    if (_equals) {
      ClusteringStorageAwareResourceLoader _clusteringStorageAwareResourceLoader = new ClusteringStorageAwareResourceLoader(this);
      this.loader = _clusteringStorageAwareResourceLoader;
    }
    final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
      @Override
      public Boolean apply(final URI it) {
        IResourceServiceProvider _resourceServiceProvider = BuildContext.this.getResourceServiceProvider(it);
        return Boolean.valueOf((!Objects.equal(_resourceServiceProvider, null)));
      }
    };
    Iterable<URI> _filter = IterableExtensions.<URI>filter(uri, _function);
    return this.loader.<T>executeClustered(_filter, operation);
  }
  
  public IResourceServiceProvider getResourceServiceProvider(final URI uri) {
    final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderRegistry.getResourceServiceProvider(uri);
    return resourceServiceProvider;
  }
  
  public BuildContext(final IResourceServiceProvider.Registry resourceServiceProviderRegistry, final XtextResourceSet resourceSet, final IResourceClusteringPolicy clusteringPolicy) {
    super();
    this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
    this.resourceSet = resourceSet;
    this.clusteringPolicy = clusteringPolicy;
  }
  
  @Pure
  public XtextResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  @Pure
  public IResourceClusteringPolicy getClusteringPolicy() {
    return this.clusteringPolicy;
  }
}
