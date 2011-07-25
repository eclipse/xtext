/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * A default {@link ResourceDescriptionsBasedContainer} will expose the complete
 * set of resource descriptions of a backing {@link IResourceDescriptions}. Clients may
 * override and filter the uris based on arbitrary criteria by means of {@link #contains(IResourceDescription)}
 * and {@link #hasResourceDescription(URI)}. The implementation has to be symmetric. The default
 * implementation of {@link #contains(IResourceDescription) contains} delegates to 
 * {@link #hasResourceDescription(URI) hasResourceDescription}.
 * 
 * The default implementation is not synchronized as clients will usually create
 * short living containers.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionsBasedContainer extends AbstractContainer implements IResourceDescription.Event.Listener {

	private final IResourceDescriptions descriptions;
	
	/**
	 * A cache for the contained descriptions.
	 */
	private Map<URI, IResourceDescription> uriToDescription;

	public ResourceDescriptionsBasedContainer(IResourceDescriptions descriptions) {
		this.descriptions = descriptions;
	}
	
	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		if (hasResourceDescription(uri))
			return getUriToDescription().get(uri);
		return null;
	}

	public Iterable<IResourceDescription> getResourceDescriptions() {
		return getUriToDescription().values();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName qualifiedName, boolean ignoreCase) {
		Iterable<IEObjectDescription> unfiltered = getDescriptions().getExportedObjects(type, qualifiedName, ignoreCase);
		return filterByURI(unfiltered);
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		Iterable<IEObjectDescription> unfiltered = getDescriptions().getExportedObjectsByType(type);
		return filterByURI(unfiltered);
	}

	protected Iterable<IEObjectDescription> filterByURI(Iterable<IEObjectDescription> unfiltered) {
		return Iterables.filter(unfiltered, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				URI resourceURI = input.getEObjectURI().trimFragment();
				return hasResourceDescription(resourceURI);
			}
		});
	}
	
	@Override
	public int getResourceDescriptionCount() {
		return getUriToDescription().size();
	}
	
	protected Map<URI, IResourceDescription> getUriToDescription() {
		Map<URI, IResourceDescription> result = uriToDescription;
		if (result == null) {
			result = doGetUriToDescription();
			uriToDescription = result;
		}
		return result;
	}

	protected Map<URI, IResourceDescription> doGetUriToDescription() {
		Iterable<? extends IResourceDescription> filtered = Iterables.filter(descriptions.getAllResourceDescriptions(), new DelegatingPredicate());
		Map<URI, IResourceDescription> result = Maps.newLinkedHashMap();
		for(IResourceDescription description: filtered) {
			result.put(description.getURI(), description);
		}
		return result;
	}
	
	private class DelegatingPredicate implements Predicate<IResourceDescription> {

		public boolean apply(IResourceDescription input) {
			return contains(input);
		}
		
	}
	
	protected boolean contains(IResourceDescription input) {
		return hasResourceDescription(input.getURI());
	}
	
	@Override
	public boolean hasResourceDescription(URI uri) {
		return true;
	}
	
	protected IResourceDescriptions getDescriptions() {
		return descriptions;
	}

	public void descriptionsChanged(IResourceDescription.Event event) {
		if (uriToDescription != null) {
			for(IResourceDescription.Delta delta: event.getDeltas()) {
				URI uri = delta.getUri();
				if (hasResourceDescription(uri) || uriToDescription.get(uri) != null) {
					if (delta.getNew() != null)
						uriToDescription.put(uri, delta.getNew());
					else
						uriToDescription.remove(uri);
				}
			}
		}
	}
}
