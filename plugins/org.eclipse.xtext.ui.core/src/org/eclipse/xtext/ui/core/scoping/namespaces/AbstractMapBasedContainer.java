/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Think about synchronization and cache invalidation to enable reuse of ProjectBasedContainers
 *  - ConcurrentHashMap
 *  - ReentrantRWLock
 *  - Listen for description deltas
 */
public abstract class AbstractMapBasedContainer implements IContainer, Predicate<IResourceDescription> {

	@Inject
	private IResourceDescriptions descriptions;
	
	private Map<URI, IResourceDescription> uriToDescription;

	public IResourceDescription getResourceDescription(URI uri) {
		return getUriToDescription().get(uri);
	}

	public Iterable<IResourceDescription> getResourceDescriptions() {
		return getUriToDescription().values();
	}

	protected Map<URI, IResourceDescription> getUriToDescription() {
		if (uriToDescription == null) {
			Iterable<IResourceDescription> filtered = Iterables.filter(descriptions.getAllResourceDescriptions(), this);
			uriToDescription = Maps.newHashMap();
			for(IResourceDescription description: filtered) {
				uriToDescription.put(description.getURI(), description);
			}
		}
		return uriToDescription;
	}
	
	public abstract boolean apply(IResourceDescription input);

}
