/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import com.google.common.collect.ImmutableSet
import java.util.Collection
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors

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
class SourceLevelURIsAdapter extends AdapterImpl {

	@Accessors ImmutableSet<URI> sourceLevelURIs
	
	override isAdapterForType(Object type) {
		return type == SourceLevelURIsAdapter 
	}
	
	def static void setSourceLevelUris(ResourceSet resourceSet, Collection<URI> uris) {
		val adapter = findInstalledAdapter(resourceSet) 
			?: (new SourceLevelURIsAdapter => [
				resourceSet.eAdapters += it
			])
		adapter.sourceLevelURIs = ImmutableSet.copyOf(uris) 
	}
	
	def static SourceLevelURIsAdapter findInstalledAdapter(ResourceSet resourceSet) {
		resourceSet.eAdapters.filter(SourceLevelURIsAdapter).head
	}
}