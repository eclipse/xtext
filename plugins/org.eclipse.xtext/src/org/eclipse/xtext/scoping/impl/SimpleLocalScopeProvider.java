/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.util.OnChangeEvictingCacheAdapter;

import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SimpleLocalScopeProvider extends AbstractGlobalScopeDelegatingScopeProvider {

	public IScope getScope(EObject context, EReference reference) {
		final Map<String, IEObjectDescription> result = getDescriptionsAsMap(context, reference);
		return new SimpleScope(getGlobalScope(context, reference), result.values()) {
			@Override
			public IEObjectDescription getContentByName(String name) {
				IEObjectDescription description = result.get(name);
				if (description != null)
					return description;
				return getOuterScope().getContentByName(name);
			}
		};
	}

	protected Map<String, IEObjectDescription> getDescriptionsAsMap(EObject context, EReference reference) {
		OnChangeEvictingCacheAdapter cache = OnChangeEvictingCacheAdapter.getOrCreate(context.eResource());
		if (cache.get(getCacheKey(reference)) == null) {
			Iterable<IEObjectDescription> exportedObjects = getExportedEObjects(context.eResource());
			Iterable<IEObjectDescription> filtered = Scopes.selectCompatible(exportedObjects, reference.getEReferenceType());
			filtered = Scopes.filterDuplicates(filtered);
			final Map<String, IEObjectDescription> result = Maps.newLinkedHashMap();
			for (IEObjectDescription e : filtered)
				result.put(e.getName(), e);
			cache.set(getCacheKey(reference), result);
		}
		return cache.get(getCacheKey(reference));
	}

	protected String getCacheKey(EReference reference) {
		return getClass().getName() + EcoreUtil.getURI(reference);
	}

}
