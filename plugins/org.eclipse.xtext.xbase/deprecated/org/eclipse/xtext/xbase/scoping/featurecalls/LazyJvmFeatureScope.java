/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Internal scope implementation for Xbase feature scopes. Clients should not use this directly.
 * @see FilteredDelegatingScope
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class LazyJvmFeatureScope extends JvmFeatureScope {

	private final LazyJvmFeatureScopeStrategy strategy;

	protected LazyJvmFeatureScope(String scopeDescription,
			LazyJvmFeatureScopeStrategy strategy) {
		super(IScope.NULLSCOPE, scopeDescription, Collections.<JvmFeatureDescription>emptyList());
		this.strategy = strategy;
	}

	private Map<QualifiedName, List<IEObjectDescription>> cachedLocalElements = Maps.newHashMap();
	
	@Override
	protected List<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		List<IEObjectDescription> result = cachedLocalElements.get(name);
		if (result == null) {
			Iterable<IEObjectDescription> candidates = strategy.getDescriptionsByName(name);
			result = Lists.newArrayList(candidates);
			cachedLocalElements.put(name, result);
		}
		return result;
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return strategy.getAllDescriptions();
	}
	
	@Override
	public List<IEObjectDescription> getElements(final QualifiedName name) {
		// we know that we never have a parent scope
		return getLocalElementsByName(name);
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		// we know that we never have a parent scope
		URI uri = EcoreUtil2.getPlatformResourceOrNormalizedURI(object);
		Iterable<IEObjectDescription> result = getLocalElementsByEObject(object, uri);
		return result;
	}
	
}
