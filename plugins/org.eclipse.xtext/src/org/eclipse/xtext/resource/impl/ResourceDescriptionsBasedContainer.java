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
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.base.Function;
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
public class ResourceDescriptionsBasedContainer implements IContainer {

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

	protected Map<URI, IResourceDescription> getUriToDescription() {
		if (uriToDescription == null) {
			Iterable<IResourceDescription> filtered = Iterables.filter(descriptions.getAllResourceDescriptions(), new DelegatingPredicate());
			uriToDescription = Maps.newHashMap();
			for(IResourceDescription description: filtered) {
				uriToDescription.put(description.getURI(), description);
			}
		}
		return uriToDescription;
	}
	
	private class DelegatingPredicate implements Predicate<IResourceDescription> {

		public boolean apply(IResourceDescription input) {
			return contains(input);
		}
		
	}
	
	protected boolean contains(IResourceDescription input) {
		return true;
	}

	public Iterable<IEObjectDescription> findAllEObjects(final EClass type) {
		return Iterables.concat(Iterables.transform(getResourceDescriptions(), new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				return from.getExportedObjects(type);
			}
		}));
	}

	public Iterable<IEObjectDescription> findAllEObjects(final EClass type, final String name) {
		return Iterables.concat(Iterables.transform(getResourceDescriptions(), new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				return from.getExportedObjects(type, name);
			}
		}));
	}
}
