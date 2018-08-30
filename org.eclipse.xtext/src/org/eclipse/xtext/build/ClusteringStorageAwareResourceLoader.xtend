/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.build

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.resource.IResourceServiceProviderExtension
import org.eclipse.xtext.resource.persistence.SourceLevelURIsAdapter
import org.eclipse.xtext.resource.persistence.StorageAwareResource

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@FinalFieldsConstructor
class ClusteringStorageAwareResourceLoader {

	val extension BuildContext context

	def <T> Iterable<T> executeClustered(Iterable<URI> uris, (Resource)=>T operation) {
		var loadedURIsCount = 0
		val sourceLevelURIs = <URI>newHashSet
		val resources = newArrayList
		val result = newArrayList
		val iter = uris.iterator
		while (iter.hasNext) {
			val uri = iter.next
			if (!clusteringPolicy.continueProcessing(resourceSet, uri, loadedURIsCount)) {
				result += resources.map[operation.apply(it)]
				clearResourceSet
				loadedURIsCount = 0
			}
			loadedURIsCount++;
			if (uri.isSource) {
				sourceLevelURIs.add(uri) 
				val existingResource = resourceSet.getResource(uri, false)
				if(existingResource instanceof StorageAwareResource) {
					if(existingResource.isLoadedFromStorage)
						existingResource.unload
				}
				SourceLevelURIsAdapter.setSourceLevelUrisWithoutCopy(resourceSet, sourceLevelURIs)
			}
			resources += resourceSet.getResource(uri, true)
		}
		result += resources.map[operation.apply(it)]
		return result
	}
	
	protected def isSource(URI uri) {
		val provider = context.getResourceServiceProvider(uri)
		return provider instanceof IResourceServiceProviderExtension &&
				(provider as IResourceServiceProviderExtension).isSource(uri)
	}

	protected def void clearResourceSet() {
		val wasDeliver = resourceSet.eDeliver();
		try {
			resourceSet.eSetDeliver(false);
			resourceSet.getResources().clear();
		} finally {
			resourceSet.eSetDeliver(wasDeliver);
		}
	}
}
