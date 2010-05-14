/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceDescriptionsUpdater {

	private static final Logger log = Logger.getLogger(ResourceDescriptionsUpdater.class);

	@Inject
	private IResourceServiceProvider.Registry managerRegistry;
	
	@Inject
	private Provider<ShadowingResourceDescriptions> shadowingResourceDescriptionsProvider;

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
	public Collection<IResourceDescription.Delta> transitiveUpdate(IResourceDescriptions oldState, final ResourceSet rs,
			Set<URI> toBeUpdated, Set<URI> toBeDeleted, IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Find affected resources", 2);
		subMonitor.subTask("Find affected resources");
		try {
			Set<URI> toBeDeletedAsSet = Sets.newHashSet(toBeDeleted);
			toBeDeletedAsSet.removeAll(Collections2.forIterable(toBeUpdated));
			Map<URI, IResourceDescription.Delta> result = Maps.newHashMap();
			// add deleted
			for (URI toDelete : toBeDeletedAsSet) {
				IResourceDescription resourceDescription = oldState.getResourceDescription(toDelete);
				if (resourceDescription != null)
					result.put(toDelete, new DefaultResourceDescriptionDelta(resourceDescription, null));
			}
	
			// add toBeUpdated
			result.putAll(update(oldState, rs, toBeUpdated, subMonitor.newChild(1)));
	
			// add dependent
			while (true) {
				if (subMonitor.isCanceled())
					return Collections.emptySet();
				subMonitor.setWorkRemaining(1);
				ShadowingResourceDescriptions newState = shadowingResourceDescriptionsProvider.get();
				newState.setContext(rs);
				Set<IResourceDescription> descriptions = findAffectedResourceDescriptions(
						oldState, newState, result.values(), subMonitor);
				Set<URI> uris = Sets.newHashSet(Iterables.transform(descriptions,
						new Function<IResourceDescription, URI>() {
							public URI apply(IResourceDescription from) {
								return from.getURI();
							}
						}));
				uris.removeAll(result.keySet());
				if (!uris.isEmpty()) {
					result.putAll(update(oldState, rs, uris, subMonitor.newChild(1)));
				} else {
					return result.values();
				}
			}
		} finally {
			subMonitor.done();
		}
	}
	
	public Collection<IResourceDescription.Delta> clean(IResourceDescriptions oldState, Set<URI> toBeDeleted, IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Clean resources", 2);
		subMonitor.subTask("Clean resources");
		try {
			Set<URI> toBeDeletedAsSet = Sets.newHashSet(toBeDeleted);
			Map<URI, IResourceDescription.Delta> result = Maps.newHashMap();
			// add deleted
			for (URI toDelete : toBeDeletedAsSet) {
				IResourceDescription resourceDescription = oldState.getResourceDescription(toDelete);
				if (resourceDescription != null)
					result.put(toDelete, new DefaultResourceDescriptionDelta(resourceDescription, null));
			}
	
			return result.values();
		} finally {
			subMonitor.done();
		}
	}

	protected Map<URI, IResourceDescription.Delta> update(IResourceDescriptions oldState, final ResourceSet set,
			Set<URI> toBeUpdated, IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, toBeUpdated.size() * 2);
		int total = toBeUpdated.size();
		int current = 1;
		try {
			Map<URI, IResourceDescription.Delta> result = Maps.newHashMap();
			for (URI uri : toBeUpdated) {
				if (subMonitor.isCanceled())
					return Collections.emptyMap();
				Resource res = null;
				try {
					subMonitor.subTask("Loading affected resource " + current + " of " + total);
					res = set.getResource(uri, true);
					current++;
				} catch (WrappedException ex) {
					if (set.getURIConverter().exists(uri, Collections.emptyMap()))
						log.error("Error loading resource from: " + uri.toString(), ex);
					if (res != null) {
						set.getResources().remove(res);
					}
					IResourceDescription oldDescription = oldState.getResourceDescription(uri);
					if (oldDescription != null)
						result.put(uri, new DefaultResourceDescriptionDelta(oldDescription, null));
				}
				subMonitor.worked(1);
			}
			for (URI uri : toBeUpdated) {
				if (subMonitor.isCanceled())
					return Collections.emptyMap();
				if (!result.containsKey(uri)) {
					IResourceDescription.Manager manager = getResourceDescriptionManager(uri);
					if (manager != null) {
						Resource resource = set.getResource(uri, false);
						IResourceDescription description = manager.getResourceDescription(resource);
						result.put(uri, new DefaultResourceDescriptionDelta(oldState.getResourceDescription(uri),
								description));
					}
				}
				subMonitor.worked(1);
			}
			return result;
		} finally {
			subMonitor.done();
		}
	}

	protected IResourceDescription.Manager getResourceDescriptionManager(URI uri) {
		IResourceServiceProvider resourceServiceProvider = managerRegistry.getResourceServiceProvider(uri);
		if (resourceServiceProvider == null)
			return null;
		return resourceServiceProvider.getResourceDescriptionManager();
	}

	protected Set<IResourceDescription> findAffectedResourceDescriptions(IResourceDescriptions oldState,
			IResourceDescriptions newState, Collection<IResourceDescription.Delta> deltas, IProgressMonitor monitor) throws IllegalArgumentException {
		Set<IResourceDescription> result = Sets.newHashSet();
		Iterable<? extends IResourceDescription> descriptions = oldState.getAllResourceDescriptions();
		for (IResourceDescription desc : descriptions) {
			if (monitor.isCanceled())
				return Collections.emptySet();
			IResourceDescription.Manager manager = getResourceDescriptionManager(desc.getURI());
			if (manager != null) {
				if (manager.isAffected(deltas, desc, newState)) {
					result.add(desc);
				}
			}
		}
		return result;
	}
	
}
