/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * This class ensures that every IResourceDescription from a local IResourceDescriptions that is not known to the global
 * IAllContainerState gets a proper container.
 * 
 * This is usually necessary when an IResourceDescription has no (not yet a) file in the file system.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.6
 */
public class LiveShadowedAllContainerState implements IAllContainersState {

	public static class Provider {
		// we're not implementing IAllContainerState.Provider here because its get() expects a global instance of IResourceDescriptions. 
		// Here, we expect one that only holds an IResourceDescription for every resource from a ResourceSet.  

		@Inject
		private com.google.inject.Provider<LiveShadowedAllContainerState> provider;

		public IAllContainersState get(IResourceDescriptions localDescriptions, IAllContainersState globalState) {
			LiveShadowedAllContainerState result = provider.get();
			result.globalState = globalState;
			result.localDescriptions = localDescriptions;
			return result;
		}
	}

	private IAllContainersState globalState;

	private IResourceDescriptions localDescriptions;

	@Override
	public Collection<URI> getContainedURIs(String containerHandle) {
		Set<URI> localContainedURIs = Sets.newLinkedHashSet();
		for (IResourceDescription descriptions : localDescriptions.getAllResourceDescriptions()) {
			String computedHandle = getContainerHandle(descriptions.getURI());
			if (computedHandle != null && computedHandle.equals(containerHandle)) {
				localContainedURIs.add(descriptions.getURI());
			}
		}
		Collection<URI> globalContainedURIs = globalState.getContainedURIs(containerHandle);
		return new Collection<URI>() {

			@Override
			public int size() {
				return localContainedURIs.size() + globalContainedURIs.size();
			}

			@Override
			public boolean isEmpty() {
				throw new UnsupportedOperationException("not expected");
			}

			@Override
			public boolean contains(Object o) {
				return localContainedURIs.contains(o) || globalContainedURIs.contains(o);
			}

			@Override
			public Iterator<URI> iterator() {
				return Iterators.concat(localContainedURIs.iterator(), globalContainedURIs.iterator());
			}

			@Override
			public Object[] toArray() {
				Set<URI> result = new LinkedHashSet<>();
				result.addAll(localContainedURIs);
				result.addAll(globalContainedURIs);
				return result.toArray();
			}

			@Override
			public <T> T[] toArray(T[] a) {
				throw new UnsupportedOperationException("not expected");
			}

			@Override
			public boolean add(URI e) {
				throw new UnsupportedOperationException("not expected");
			}

			@Override
			public boolean remove(Object o) {
				throw new UnsupportedOperationException("not expected");
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				throw new UnsupportedOperationException("not expected");
			}

			@Override
			public boolean addAll(Collection<? extends URI> c) {
				throw new UnsupportedOperationException("not expected");
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				throw new UnsupportedOperationException("not expected");
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				throw new UnsupportedOperationException("not expected");
			}

			@Override
			public void clear() {
				throw new UnsupportedOperationException("not expected");
			}
		};
	}
	
	@Override
	public boolean containsURI(String containerHandle, URI candidateURI) {
		if(localDescriptions.getResourceDescription(candidateURI) != null) {
			String computedHandle = getContainerHandle(candidateURI);
			if (computedHandle != null && computedHandle.equals(containerHandle)) {
				return true;
			}
		}
		return globalState.containsURI(containerHandle, candidateURI);
	}

	@Override
	public String getContainerHandle(URI uri) {
		return globalState.getContainerHandle(uri);
	}

	@Override
	public List<String> getVisibleContainerHandles(String handle) {
		return globalState.getVisibleContainerHandles(handle);
	}

	@Override
	public boolean isEmpty(String containerHandle) {
		for (IResourceDescription descriptions : localDescriptions.getAllResourceDescriptions()) {
			String computedHandle = getContainerHandle(descriptions.getURI());
			if (computedHandle != null && computedHandle.equals(containerHandle))
				return false;
		}
		return globalState.isEmpty(containerHandle);
	}

}
