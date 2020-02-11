/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.build;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.google.common.collect.Iterables;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
public class BuildContext {
	private final Function1<? super URI, ? extends IResourceServiceProvider> resourceServiceProviderProvider;

	private final XtextResourceSet resourceSet;

	private final IndexState oldState;

	private final IResourceClusteringPolicy clusteringPolicy;

	private final CancelIndicator cancelIndicator;

	private ClusteringStorageAwareResourceLoader loader;

	public BuildContext(Function1<? super URI, ? extends IResourceServiceProvider> resourceServiceProviderProvider,
			XtextResourceSet resourceSet, IndexState oldState, IResourceClusteringPolicy clusteringPolicy,
			CancelIndicator cancelIndicator) {
		this.resourceServiceProviderProvider = resourceServiceProviderProvider;
		this.resourceSet = resourceSet;
		this.oldState = oldState;
		this.clusteringPolicy = clusteringPolicy;
		this.cancelIndicator = cancelIndicator;
	}

	/**
	 * Run the given logic on all uris with clustering enabled.
	 */
	public <T> Iterable<T> executeClustered(Iterable<URI> uris, Function1<? super Resource, ? extends T> operation) {
		if (loader == null) {
			loader = new ClusteringStorageAwareResourceLoader(this);
		}
		return loader.executeClustered(Iterables.filter(uris, this::canHandle), operation);
	}

	/**
	 * Return true, if the given URI can be handled by an available language.
	 */
	protected boolean canHandle(URI uri) {
		IResourceServiceProvider resourceServiceProvider = getResourceServiceProvider(uri);
		if (resourceServiceProvider == null) {
			return false;
		}
		return resourceServiceProvider.canHandle(uri);
	}

	/**
	 * Get the resource service provider for this URI.
	 */
	public IResourceServiceProvider getResourceServiceProvider(URI uri) {
		return resourceServiceProviderProvider.apply(uri);
	}

	public XtextResourceSet getResourceSet() {
		return resourceSet;
	}

	public IndexState getOldState() {
		return oldState;
	}

	public IResourceClusteringPolicy getClusteringPolicy() {
		return clusteringPolicy;
	}

	public CancelIndicator getCancelIndicator() {
		return cancelIndicator;
	}
}
