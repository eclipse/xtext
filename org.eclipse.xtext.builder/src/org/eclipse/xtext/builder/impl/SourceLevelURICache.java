/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProviderExtension;

import com.google.common.collect.Sets;

/**
 * Small utility that is used by the builder in one build session to keep track of the source
 * URIs that should be considered.
 * 
 * It is used to avoid redundant queries of the file system in case of clustering or a chain
 * of affected resources.
 * 
 * @since 2.8
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SourceLevelURICache {
	private Set<URI> archives = Sets.newHashSet();
	private Set<URI> sources = Sets.newHashSet();

	/**
	 * Return all the source URIs that have been encountered.
	 */
	public Set<URI> getSources() {
		return sources;
	}
	
	public Set<URI> getSourcesFrom(Collection<URI> allURIs, IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
		for(URI uri: allURIs) {
			getOrComputeIsSource(uri, resourceServiceProviderRegistry);
		}
		return sources;
	}
	
	public void cacheAsSourceURIs(Collection<URI> uris) {
		sources.addAll(uris);
	}

	public boolean getOrComputeIsSource(URI uri, IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
		if (archives.contains(uri)) {
			return false;
		}
		if (sources.contains(uri)) {
			return true;
		}
		IResourceServiceProvider provider = resourceServiceProviderRegistry.getResourceServiceProvider(uri);
		if (provider instanceof IResourceServiceProviderExtension) {
			if (!((IResourceServiceProviderExtension) provider).isSource(uri)) {
				archives.add(uri);
				return false;
			}
		}
		sources.add(uri);
		return true;
	}

}
