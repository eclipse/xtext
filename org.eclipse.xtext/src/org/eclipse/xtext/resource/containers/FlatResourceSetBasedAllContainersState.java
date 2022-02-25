/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.resource.impl.ResourceDescriptionsData.ResourceSetAdapter.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;

import com.google.common.collect.Lists;

/**
 * This implementation of {@link IAllContainersState} looks whether a {@link ResourceDescriptionsData} is installed on the wrapped {@link ResourceSet} 
 * and delegates to that. If no such adapter is installed it uses the contents of the {@link ResourceSet}. Resource that are loaded after this class has been created are also considered.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.3
 */
public class FlatResourceSetBasedAllContainersState extends AdapterImpl implements IAllContainersState {

	private final static String HANDLE = "all";

	public static String getHandle() {
		return HANDLE;
	}

	private ResourceSet resourceSet;

	public FlatResourceSetBasedAllContainersState(ResourceSet rs) {
		super();
		this.resourceSet = rs;
	}

	@Override
	public Collection<URI> getContainedURIs(String containerHandle) {
		if (!HANDLE.equals(containerHandle))
			return Collections.emptySet();
		if (resourceSet instanceof XtextResourceSet) {
			ResourceDescriptionsData descriptionsData = findResourceDescriptionsData(resourceSet);
			if (descriptionsData != null) {
				return descriptionsData.getAllURIs();
			}
			return newArrayList(((XtextResourceSet) resourceSet).getNormalizationMap().values());
		}
		List<URI> uris = Lists.newArrayListWithCapacity(resourceSet.getResources().size());
		URIConverter uriConverter = resourceSet.getURIConverter();
		for (Resource r : resourceSet.getResources())
			uris.add(uriConverter.normalize(r.getURI()));
		return uris;
	}
	
	@Override
	public boolean containsURI(String containerHandle, URI candidateURI) {
		if (!HANDLE.equals(containerHandle))
			return false;
		if (resourceSet instanceof XtextResourceSet) {
			ResourceDescriptionsData descriptionsData = findResourceDescriptionsData(resourceSet);
			if (descriptionsData != null) {
				return descriptionsData.getResourceDescription(candidateURI) != null;
			}
			Collection<URI> allUris = ((XtextResourceSet) resourceSet).getNormalizationMap().values();
			for (URI uri : allUris) {
				if (uri.equals(candidateURI)) {
					return true;
				}
			}
			return false;
		}
		URIConverter uriConverter = resourceSet.getURIConverter();
		for (Resource r : resourceSet.getResources()) {
			URI normalized = uriConverter.normalize(r.getURI());
			if (normalized.equals(candidateURI)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getContainerHandle(URI uri) {
		return HANDLE;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	@Override
	public List<String> getVisibleContainerHandles(String handle) {
		return Collections.singletonList(HANDLE);
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return IAllContainersState.class == type || FlatResourceSetBasedAllContainersState.class == type;
	}

	@Override
	public boolean isEmpty(String containerHandle) {
		return !HANDLE.equals(containerHandle);
	}

}