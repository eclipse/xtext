/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.build;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.build.ClusteringStorageAwareResourceLoader;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.util.CancelIndicator;
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
  private final Function1<? super URI, ? extends IResourceServiceProvider> resourceServiceProviderProvider;
  
  @Accessors
  private final XtextResourceSet resourceSet;
  
  @Accessors
  private final IndexState oldState;
  
  @Accessors
  private final IResourceClusteringPolicy clusteringPolicy;
  
  @Accessors
  private final CancelIndicator cancelIndicator;
  
  private ClusteringStorageAwareResourceLoader loader;
  
  public <T extends Object> Iterable<T> executeClustered(final Iterable<URI> uri, final Function1<? super Resource, ? extends T> operation) {
    if ((this.loader == null)) {
      ClusteringStorageAwareResourceLoader _clusteringStorageAwareResourceLoader = new ClusteringStorageAwareResourceLoader(this);
      this.loader = _clusteringStorageAwareResourceLoader;
    }
    final Function1<URI, Boolean> _function = (URI it) -> {
      return Boolean.valueOf(this.canHandle(it));
    };
    return this.loader.<T>executeClustered(IterableExtensions.<URI>filter(uri, _function), operation);
  }
  
  protected boolean canHandle(final URI uri) {
    final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderProvider.apply(uri);
    if ((resourceServiceProvider == null)) {
      return false;
    }
    return resourceServiceProvider.canHandle(uri);
  }
  
  public IResourceServiceProvider getResourceServiceProvider(final URI uri) {
    final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderProvider.apply(uri);
    return resourceServiceProvider;
  }
  
  public BuildContext(final Function1<? super URI, ? extends IResourceServiceProvider> resourceServiceProviderProvider, final XtextResourceSet resourceSet, final IndexState oldState, final IResourceClusteringPolicy clusteringPolicy, final CancelIndicator cancelIndicator) {
    super();
    this.resourceServiceProviderProvider = resourceServiceProviderProvider;
    this.resourceSet = resourceSet;
    this.oldState = oldState;
    this.clusteringPolicy = clusteringPolicy;
    this.cancelIndicator = cancelIndicator;
  }
  
  @Pure
  public XtextResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  @Pure
  public IndexState getOldState() {
    return this.oldState;
  }
  
  @Pure
  public IResourceClusteringPolicy getClusteringPolicy() {
    return this.clusteringPolicy;
  }
  
  @Pure
  public CancelIndicator getCancelIndicator() {
    return this.cancelIndicator;
  }
}
