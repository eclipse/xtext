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
import java.util.Collections
import java.util.Set
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

	@Accessors Set<URI> sourceLevelURIs
	
	def Set<URI> getSourceLevelURIs() {
		return Collections.unmodifiableSet(this.sourceLevelURIs);
	}
	
	override isAdapterForType(Object type) {
		return type == SourceLevelURIsAdapter 
	}
	
	def static void setSourceLevelUris(ResourceSet resourceSet, Collection<URI> uris) {
		val adapter = findOrCreateAdapter(resourceSet)
		adapter.sourceLevelURIs = ImmutableSet.copyOf(uris) 
	}
	
	protected def static SourceLevelURIsAdapter findOrCreateAdapter(ResourceSet resourceSet) {
		return findInstalledAdapter(resourceSet) 
			?: (new SourceLevelURIsAdapter => [
				resourceSet.eAdapters += it
			])
	}
	
	/**
	 * Installs the given set of URIs as the source level URIs. Does not copy the given
	 * set but uses it directly.
	 */
	def static void setSourceLevelUrisWithoutCopy(ResourceSet resourceSet, Set<URI> uris) {
		val adapter = findOrCreateAdapter(resourceSet)
		adapter.sourceLevelURIs = uris; 
	}
	
	def static SourceLevelURIsAdapter findInstalledAdapter(ResourceSet resourceSet) {
		return resourceSet.eAdapters.filter(SourceLevelURIsAdapter).head
	}
}