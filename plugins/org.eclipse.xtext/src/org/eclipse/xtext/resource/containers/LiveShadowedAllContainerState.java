/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * This class ensures that every IResourceDescription from a local IResourceDescrions that is not known to the global
 * IAllContainerState gets a proper container.
 * 
 * This is usually necessary when an IResourceDescrion has no (not yet a) file in the file system.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.6
 */
public class LiveShadowedAllContainerState implements IAllContainersState {

	public static class Provider {
		// we're not implementing IAllContainerState.Provider here because its get() expects a global instance of IResourceDescrions. 
		// Here, we expect one that only holds an IResourceDescrion for every resource from a ResourceSet.  

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

	public Collection<URI> getContainedURIs(String containerHandle) {
		List<URI> result = Lists.newArrayList();
		for (IResourceDescription descriptions : localDescriptions.getAllResourceDescriptions()) {
			String computedHandle = getContainerHandle(descriptions.getURI());
			if (computedHandle != null && computedHandle.equals(containerHandle))
				result.add(descriptions.getURI());
		}
		result.addAll(globalState.getContainedURIs(containerHandle));
		return result;
	}

	public String getContainerHandle(URI uri) {
		return globalState.getContainerHandle(uri);
	}

	public List<String> getVisibleContainerHandles(String handle) {
		return globalState.getVisibleContainerHandles(handle);
	}

	public boolean isEmpty(String containerHandle) {
		for (IResourceDescription descriptions : localDescriptions.getAllResourceDescriptions()) {
			String computedHandle = getContainerHandle(descriptions.getURI());
			if (computedHandle != null && computedHandle.equals(containerHandle))
				return false;
		}
		return globalState.isEmpty(containerHandle);
	}

}
