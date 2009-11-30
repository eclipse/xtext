/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.scoping.namespaces.DefaultGlobalScopeProvider;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceDescriptionsUpdater {

	@Inject
	private IResourceServiceProvider.Registry managerRegistry;

	public void setResourceServiceRegistry(IResourceServiceProvider.Registry managerRegistry) {
		this.managerRegistry = managerRegistry;
	}

	/**
	 * This method computes the {@link IResourceDescription}s for all affected (i.e. added, updated or transitively
	 * affected) resources. It does not change any state in the underlying
	 * {@link org.eclipse.xtext.resource.IResourceDescriptions} instance.
	 * 
	 * @param rs
	 *            - The ResourceSet to use for reloading the to be updated resources
	 * @param toBeUpdated
	 *            - the URIs which have to be reloaded
	 * @param toBeDeleted
	 *            - the URIs which are about to be deleted
	 * @return returns an iterable of fresh {@link IResourceDescription} for all resources, which are affected by the
	 *         change (i.e. the to BeUpdated and toBeDeleted resources)
	 */
	public Iterable<Delta> transitiveUpdate(IResourceDescriptions resourceDescriptions, final ResourceSet rs,
			Iterable<URI> toBeUpdated, Iterable<URI> toBeDeleted) {
		if (toBeUpdated == null)
			toBeUpdated = Iterables.emptyIterable();
		HashSet<URI> toBeDeletedAsSet = Sets.newHashSet(toBeDeleted != null ? toBeDeleted : Iterables
				.<URI> emptyIterable());
		toBeDeletedAsSet.removeAll(Collections2.forIterable(toBeUpdated));

		Map<URI, Delta> result = Maps.newHashMap();
		rs.eAdapters().add(new ShadowingResourceDescriptions.Adapter(resourceDescriptions, toBeDeletedAsSet));
		rs.getLoadOptions().put(DefaultGlobalScopeProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);

		// add deleted
		for (URI toDelete : toBeDeletedAsSet) {
			IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(toDelete);
			if (resourceDescription != null)
				result.put(toDelete, new DefaultResourceDescriptionDelta(resourceDescription, null));
		}

		// add toBeUpdated
		result.putAll(update(resourceDescriptions, rs, toBeUpdated));

		// add transient
		while (true) {
			Set<IResourceDescription> descriptions = findAffectedResourceDescriptions(resourceDescriptions, result
					.values());
			Set<URI> uris = Sets.newHashSet(Iterables.transform(descriptions,
					new Function<IResourceDescription, URI>() {
						public URI apply(IResourceDescription from) {
							return from.getURI();
						}
					}));
			uris.removeAll(result.keySet());
			if (!uris.isEmpty()) {
				result.putAll(update(resourceDescriptions, rs, uris));
			} else {
				return result.values();
			}
		}
	}

	private Map<URI, Delta> update(IResourceDescriptions resourceDescriptions, final ResourceSet set,
			Iterable<URI> toBeUpdated) {
		for (URI uri : toBeUpdated) {
			set.getResource(uri, true);
		}
		Map<URI, Delta> result = Maps.newHashMap();
		for (URI uri : toBeUpdated) {
			Manager manager = getResourceDescriptionManager(uri);
			Resource resource = set.getResource(uri, false);
			IResourceDescription description = manager.getResourceDescription(resource);
			result.put(uri, new DefaultResourceDescriptionDelta(resourceDescriptions.getResourceDescription(uri),
					description));
		}
		return result;
	}

	private Manager getResourceDescriptionManager(URI uri) {
		return managerRegistry.getResourceServiceProvider(uri, null).getResourceDescriptionManager();
	}

	private Set<IResourceDescription> findAffectedResourceDescriptions(IResourceDescriptions resourceDescriptions,
			Collection<Delta> collection) throws IllegalArgumentException {
		Set<IResourceDescription> result = Sets.newHashSet();
		Iterable<IResourceDescription> descriptions = resourceDescriptions.getAllResourceDescriptions();
		for (IResourceDescription desc : descriptions) {
			Manager manager = getResourceDescriptionManager(desc.getURI());
			for (Delta delta : collection) {
				if (manager.isAffected(delta, desc))
					result.add(desc);
			}
		}
		return result;
	}

}
