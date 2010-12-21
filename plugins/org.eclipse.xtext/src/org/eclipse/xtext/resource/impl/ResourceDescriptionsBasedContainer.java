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
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Think about synchronization and cache invalidation to enable reuse of ProjectBasedContainers
 *  - ConcurrentHashMap
 *  - ReentrantRWLock
 *  - Listen for description deltas
 */
public class ResourceDescriptionsBasedContainer extends AbstractContainer implements IResourceDescription.Event.Listener {

	private final IResourceDescriptions descriptions;
	
	private Map<URI, IResourceDescription> uriToDescription;

	public ResourceDescriptionsBasedContainer(IResourceDescriptions descriptions) {
		this.descriptions = descriptions;
	}
	
	public IResourceDescription getResourceDescription(URI uri) {
		return getUriToDescription().get(uri);
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
				return contains(resourceURI);
			}
		});
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
		return contains(input.getURI());
	}
	
	protected boolean contains(URI uri) {
		return true;
	}
	
	protected IResourceDescriptions getDescriptions() {
		return descriptions;
	}

	public void descriptionsChanged(IResourceDescription.Event event) {
		if (uriToDescription != null) {
			for(IResourceDescription.Delta delta: event.getDeltas()) {
				if (uriToDescription.containsKey(delta.getUri())) {
					uriToDescription.put(delta.getUri(), delta.getNew());
				}
			}
		}
	}
}
