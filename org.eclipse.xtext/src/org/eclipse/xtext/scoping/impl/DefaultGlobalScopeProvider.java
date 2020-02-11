/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event.Source;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.FilterUriContainer;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.OnChangeEvictingCache;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultGlobalScopeProvider extends AbstractGlobalScopeProvider {

	@Inject
	private IContainer.Manager containerManager;

	@Inject
	private IResourceDescription.Manager descriptionManager;
	
	protected IScope getScope(IScope parent, final Resource context, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		IScope result = parent;
		if (context == null || context.getResourceSet() == null)
			return result;
		List<IContainer> containers = Lists.newArrayList(getVisibleContainers(context));
		Collections.reverse(containers);
		Iterator<IContainer> iter = containers.iterator();
		while (iter.hasNext()) {
			IContainer container = iter.next();
			result = createContainerScopeWithContext(context, result, container, filter, type, ignoreCase);
		}
		return result;
	}
	
	@Override
	protected IScope getScope(final Resource context, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		return getScope(IScope.NULLSCOPE, context, ignoreCase, type, filter);
	}

	protected List<IContainer> getVisibleContainers(Resource resource) {
		IResourceDescription description = descriptionManager.getResourceDescription(resource);
		IResourceDescriptions resourceDescriptions = getResourceDescriptions(resource);
		String cacheKey = getCacheKey("VisibleContainers", resource.getResourceSet());
		OnChangeEvictingCache.CacheAdapter cache = new OnChangeEvictingCache().getOrCreate(resource);
		List<IContainer> result = null;
		result = cache.get(cacheKey);
		if (result == null) {
			result = containerManager.getVisibleContainers(description, resourceDescriptions);
			// SZ: I'ld like this dependency to be moved to the implementation of the
			// container manager, but it is not aware of a CacheAdapter
			if (resourceDescriptions instanceof IResourceDescription.Event.Source) {
				IResourceDescription.Event.Source eventSource = (Source) resourceDescriptions;
				DelegatingEventSource delegatingEventSource = new DelegatingEventSource(eventSource);
				delegatingEventSource.addListeners(Lists.newArrayList(Iterables.filter(result, IResourceDescription.Event.Listener.class)));
				delegatingEventSource.initialize();
				cache.addCacheListener(delegatingEventSource);
			}
			cache.set(cacheKey, result);
		}
		return result;
	}
	
	protected String getCacheKey(String base, ResourceSet context) {
		Map<Object, Object> loadOptions = context.getLoadOptions();
		if (loadOptions.containsKey(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)) {
			return base + "@" + ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE;
		} 
		return base + "@DEFAULT_SCOPE"; 
	}

	protected IScope createContainerScopeWithContext(Resource eResource, IScope parent, IContainer container,
			Predicate<IEObjectDescription> filter, EClass type, boolean ignoreCase) {
		if (eResource != null) {
			URI uriToFilter = eResource.getURI();
			if (container.hasResourceDescription(uriToFilter))
				container = new FilterUriContainer(uriToFilter, container);
		}
		return createContainerScope(parent, container, filter, type, ignoreCase);
	}

	protected IScope createContainerScope(IScope parent, IContainer container, Predicate<IEObjectDescription> filter, EClass type, boolean ignoreCase) {
		return SelectableBasedScope.createScope(parent, container, filter, type, ignoreCase);
	}

}
