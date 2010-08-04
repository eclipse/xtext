/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * A local scope that uses the qualified names of all elements of an {@link org.eclipse.emf.ecore.resource.Resource} and
 * delegates to a global scope.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class SimpleLocalScopeProvider extends AbstractGlobalScopeDelegatingScopeProvider {

	@Inject
	private IQualifiedNameProvider nameProvider;

	@Inject
	private IResourceScopeCache cache;

	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}

	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	protected IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}

	public IScope getScope(final EObject context, final EReference reference) {
		Map<String, IEObjectDescription> map = cache.get(Tuples.pair(SimpleLocalScopeProvider.class.getName(),
				reference), context.eResource(), new Provider<Map<String, IEObjectDescription>>() {

			public Map<String, IEObjectDescription> get() {
				return toMap(context, reference);
			}

		});
		IScope globalScope = getGlobalScope(context, reference);
		return createMapBasedScope(globalScope, map);
	}

	protected IScope createMapBasedScope(IScope parent, Map<String, IEObjectDescription> map) {
		return new MapBasedScope(parent, map);
	}

	protected EObjectDescription createEObjectDescription(EObject next, String name) {
		return new EObjectDescription(name, next, null);
	}

	protected Map<String, IEObjectDescription> toMap(final EObject context, final EReference reference) {
		TreeIterator<EObject> iterator = context.eResource().getAllContents();
		Map<String, IEObjectDescription> result = Maps.newLinkedHashMap();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (reference.getEReferenceType().isInstance(next)) {
				String name = nameProvider.getQualifiedName(next);
				if (name != null && !result.containsKey(name)) {
					EObjectDescription description = createEObjectDescription(next, name);
					if (description != null)
						result.put(name, description);
				}
			}
		}
		return result;
	}
}
