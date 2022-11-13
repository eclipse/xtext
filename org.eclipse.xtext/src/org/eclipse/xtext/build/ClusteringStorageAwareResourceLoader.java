/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.build;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProviderExtension;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.google.common.collect.FluentIterable;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ClusteringStorageAwareResourceLoader {
	private final BuildContext context;

	public ClusteringStorageAwareResourceLoader(BuildContext context) {
		this.context = context;
	}

	/**
	 * Execute the given operation in a clustered fashion.
	 */
	public <T> Iterable<T> executeClustered(Iterable<URI> uris, Function1<? super Resource, ? extends T> operation) {
		int loadedURIsCount = 0;
		List<Resource> resources = new ArrayList<>();
		List<T> result = new ArrayList<>();
		Iterator<URI> iter = uris.iterator();
		while (iter.hasNext()) {
			URI uri = iter.next();
			XtextResourceSet resourceSet = context.getResourceSet();
			if (!context.getClusteringPolicy().continueProcessing(resourceSet, uri, loadedURIsCount)) {
				FluentIterable.from(resources).transform(operation::apply).copyInto(result);
				clearResourceSet();
				resources.clear();
				loadedURIsCount = 0;
			}
			loadedURIsCount++;
			resources.add(resourceSet.getResource(uri, true));
		}
		FluentIterable.from(resources).transform(operation::apply).copyInto(result);
		return result;
	}

	/**
	 * Return true if the given uri must be loaded from source.
	 */
	@Deprecated(forRemoval = true)
	protected boolean isSource(URI uri) {
		IResourceServiceProvider provider = context.getResourceServiceProvider(uri);
		return provider instanceof IResourceServiceProviderExtension
				&& ((IResourceServiceProviderExtension) provider).isSource(uri);
	}
	
	/**
	 * Remove all resources from the resource set without delivering notifications.
	 */
	protected void clearResourceSet() {
		XtextResourceSet resourceSet = context.getResourceSet();
		boolean wasDeliver = resourceSet.eDeliver();
		try {
			resourceSet.eSetDeliver(false);
			resourceSet.getResources().clear();
		} finally {
			resourceSet.eSetDeliver(wasDeliver);
		}
	}

}
