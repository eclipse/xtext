/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Event.Listener;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.OnChangeEvictingCacheAdapter;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultGlobalScopeProvider extends AbstractGlobalScopeProvider {

	@Inject
	private IContainer.Manager containerManager;

	@Inject
	private IResourceDescription.Manager descriptionManager;
	
	public IScope getScope(final EObject context, EReference reference) {
		IScope result = IScope.NULLSCOPE;
		List<IContainer> containers = getVisibleContainers(context);
		Collections.reverse(containers);
		Iterator<IContainer> iter = containers.iterator();
		while (iter.hasNext()) {
			IContainer container = iter.next();
			result = createIndexScope(result, container, reference);
		}
		return result;
	}

	protected List<IContainer> getVisibleContainers(EObject context) {
		IResourceDescription description = descriptionManager.getResourceDescription(context.eResource());
		IResourceDescriptions resourceDescriptions = getResourceDescriptions(context);
		String cacheKey = getCacheKey("VisibleContainers", context.eResource().getResourceSet());
		OnChangeEvictingCacheAdapter cache = OnChangeEvictingCacheAdapter.getOrCreate(context);
		List<IContainer> result = null;
		result = cache.get(cacheKey);
		if (result == null) {
			result = containerManager.getVisibleContainers(description,	resourceDescriptions);
			final List<IContainer> finalResult = result;
			final IResourceDescriptions finalDescriptions = resourceDescriptions;
			cache.addCacheListener(new OnChangeEvictingCacheAdapter.Listener() {
				public void onEvict(OnChangeEvictingCacheAdapter cache) {
					for(IContainer container: finalResult) {
						if (container instanceof IResourceDescription.Event.Listener) {
							finalDescriptions.removeListener((Listener) container);
						}
					}
				}
			});
			for(IContainer container: finalResult) {
				if (container instanceof IResourceDescription.Event.Listener) {
					finalDescriptions.addListener((Listener) container);
				}
			}
			cache.set(cacheKey, result);
		}
		return result;
	}
	
	protected String getCacheKey(String base, ResourceSet context) {
		Map<Object, Object> loadOptions = context.getLoadOptions();
		if (loadOptions.containsKey(NAMED_BUILDER_SCOPE)) {
			return base + "@" + NAMED_BUILDER_SCOPE;
		} 
		return base + "@DEFAULT_SCOPE"; 
	}

	protected SimpleScope createIndexScope(IScope parent, final IContainer container, final EReference reference) {
		return new SimpleScope(parent, null) {

			@Override
			public Iterable<IEObjectDescription> internalGetContents() {
				return container.findAllEObjects(reference.getEReferenceType());
			}

			@Override
			public IEObjectDescription getContentByName(String name) {
				Iterable<IEObjectDescription> allDescriptions = container.findAllEObjects(
						reference.getEReferenceType(), name);
				Iterator<IEObjectDescription> iter = allDescriptions.iterator();
				IEObjectDescription result = null;
				while (iter.hasNext()) {
					if (result != null)
						return getOuterScope().getContentByName(name);
					result = iter.next();
				}
				if (result != null)
					return result;
				return getOuterScope().getContentByName(name);
			}

			@Override
			public IEObjectDescription getContentByEObject(EObject object) {
				Iterable<IEObjectDescription> allDescriptions = findAllDescriptionsFor(object);
				Iterator<IEObjectDescription> iter = allDescriptions.iterator();
				boolean hadNext = false;
				while (iter.hasNext()) {
					hadNext = true;
					IEObjectDescription result = iter.next();
					if (isValidForEObject(result))
						return result;
				}
				if (hadNext)
					return null;
				return getOuterScope().getContentByEObject(object);
			}

			private boolean isValidForEObject(IEObjectDescription result) {
				Iterable<IEObjectDescription> allDescriptionsByName = container.findAllEObjects(reference
						.getEReferenceType(), result.getName());
				Iterator<IEObjectDescription> iter = allDescriptionsByName.iterator();
				IEObjectDescription inverted = null;
				while (iter.hasNext()) {
					if (inverted != null)
						return false;
					inverted = iter.next();
				}
				return inverted != null && inverted.getEObjectURI().equals(result.getEObjectURI());
			}
		};
	}

	public Iterable<IEObjectDescription> findAllDescriptionsFor(EObject object) {
		if (object.eIsProxy())
			throw new IllegalArgumentException("object may not be a proxy: " + object);
		IResourceDescription.Manager descriptionManager = getResourceServiceProviderRegistry().getResourceServiceProvider(
				object.eResource().getURI(), null).getResourceDescriptionManager();
		if (descriptionManager == null)
			throw new IllegalStateException("Cannot find description manager for " + object);
		IResourceDescription description = descriptionManager.getResourceDescription(object.eResource());
		return description.getExportedObjectsForEObject(object);
	}

}
