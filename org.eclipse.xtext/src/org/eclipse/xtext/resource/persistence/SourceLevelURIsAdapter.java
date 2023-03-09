/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.common.collect.ImmutableSet;

/**
 * An adapter to be installed into a ResourceSet.
 * 
 * It's used as a protocol to tell whether a StorageAwareResource should load from source or could load from serialized
 * data.
 * 
 * @see ResourceStorageProviderAdapter
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
public class SourceLevelURIsAdapter extends AdapterImpl {
	
	public static void setSourceLevelUris(ResourceSet resourceSet, Collection<URI> uris) {
		SourceLevelURIsAdapter adapter = findOrCreateAdapter(resourceSet);
		adapter.sourceLevelURIs = ImmutableSet.copyOf(uris);
	}

	protected static SourceLevelURIsAdapter findOrCreateAdapter(ResourceSet resourceSet) {
		SourceLevelURIsAdapter adapter = findInstalledAdapter(resourceSet);
		if (adapter != null) {
			return adapter;
		}
		adapter = new SourceLevelURIsAdapter();
		resourceSet.eAdapters().add(adapter);
		return adapter;
	}

	/**
	 * Installs the given set of URIs as the source level URIs. Does not copy the given set but uses it directly.
	 */
	public static void setSourceLevelUrisWithoutCopy(ResourceSet resourceSet, Set<URI> uris) {
		SourceLevelURIsAdapter adapter = findOrCreateAdapter(resourceSet);
		adapter.sourceLevelURIs = Collections.unmodifiableSet(uris);
	}

	public static SourceLevelURIsAdapter findInstalledAdapter(ResourceSet resourceSet) {
		for (Adapter adapter : resourceSet.eAdapters()) {
			if (adapter instanceof SourceLevelURIsAdapter) {
				return (SourceLevelURIsAdapter) adapter;
			}
		}
		return null;
	}
	
	private Set<URI> sourceLevelURIs;

	public Set<URI> getSourceLevelURIs() {
		return sourceLevelURIs;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return SourceLevelURIsAdapter.class.equals(type);
	}

	public void setSourceLevelURIs(Set<URI> sourceLevelURIs) {
		this.sourceLevelURIs = Collections.unmodifiableSet(sourceLevelURIs);
	}
}
