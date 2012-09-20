/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import static com.google.common.collect.Lists.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.annotations.Beta;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
@Beta
public class IndexingOrderer {
	
	@Inject(optional=true) private IResourceServiceProvider.Registry registry = IResourceServiceProvider.Registry.INSTANCE;
	
	public List<URI> getOrderedUris(final ResourceSet resourceSet, Iterable<URI> urisToIndex) {
		final PriorityProvider provider = new PriorityProvider();
		ArrayList<URI> result = newArrayList(urisToIndex);
		Collections.sort(result, new Comparator<URI>() {
			public int compare(URI o1, URI o2) {
				int prio1 = provider.getIndexingPrio(resourceSet, o1);
				int prio2 = provider.getIndexingPrio(resourceSet, o2);
				return prio2 - prio1;
			}
		});
		return result;
	}

	protected class PriorityProvider {
		
		private Cache<Pair<ResourceSet, URI>, Integer> cache = CacheBuilder.newBuilder().build(new CacheLoader<Pair<ResourceSet, URI>, Integer>() {
			@Override
			public Integer load(Pair<ResourceSet, URI> key) throws Exception {
				IResourceServiceProvider serviceProvider = registry.getResourceServiceProvider(key.getSecond());
				if (serviceProvider != null) {
					IndexingPriorityProvider priorityProvider = serviceProvider.get(IndexingPriorityProvider.class);
					if (priorityProvider != null)
						return priorityProvider.getIndexingPriority(key.getFirst(), key.getSecond());
				}
				return 0;
			}
			
		});
		
		protected int getIndexingPrio(final ResourceSet resourceSet, URI uri) {
			return cache.apply(Tuples.create(resourceSet, uri));
		}
	}
	
	@Beta
	public static class IndexingPriorityProvider {
	
		/**
		 * @return a number indicating the precedence for indexing this URI's resource. Higher means indexed before lower numbers. Can be anything between {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
		 */
		public int getIndexingPriority(ResourceSet resourceSet, URI uri) {
			return 0; // no priority by default
		}
	}

}
