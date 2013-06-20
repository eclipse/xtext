/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;


import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
@Beta
public class IndexingOrderer {
	
	@Inject(optional=true) private IResourceServiceProvider.Registry registry = IResourceServiceProvider.Registry.INSTANCE;
	
	public List<URI> getOrderedUris(final ResourceSet resourceSet, Iterable<URI> urisToIndex) {
		// create pairs of uri and priority
		List<Pair<URI, Integer>> prios = newArrayList(transform(urisToIndex, new Function<URI, Pair<URI, Integer>>() {
			public Pair<URI, Integer> apply(URI uri) {
				IResourceServiceProvider serviceProvider = registry.getResourceServiceProvider(uri);
				if (serviceProvider != null) {
					IndexingPriorityProvider priorityProvider = serviceProvider.get(IndexingPriorityProvider.class);
					if (priorityProvider != null)
						return Tuples.create(uri, priorityProvider.getIndexingPriority(resourceSet, uri));
				}
				return Tuples.create(uri, 0);
			}
		}));
		// sort by priority
		Collections.sort(prios, new Comparator<Pair<URI,Integer>>() {
			public int compare(Pair<URI,Integer> o1, Pair<URI,Integer> o2) {
				return o2.getSecond()- o1.getSecond();
			}
		});
		// return the sorted uris
		return transform(prios, new Function<Pair<URI,Integer>, URI>() {
			public URI apply(Pair<URI,Integer> uri) {
				return uri.getFirst();
			}
		});
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
