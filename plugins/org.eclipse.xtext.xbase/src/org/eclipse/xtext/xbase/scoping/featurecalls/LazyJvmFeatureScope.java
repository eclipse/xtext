/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Provider;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LazyJvmFeatureScope extends JvmFeatureScope implements Predicate<IEObjectDescription> {

	private final LazyJvmFeatureScopeStrategy strategy;
	private final boolean onlyValidDescriptions;

	public LazyJvmFeatureScope(IScope parent, String scopeDescription,
			LazyJvmFeatureScopeStrategy strategy, boolean onlyValidDescriptions) {
		super(parent, scopeDescription, Collections.<JvmFeatureDescription>emptyList());
		this.strategy = strategy;
		this.onlyValidDescriptions = onlyValidDescriptions;
	}

	private Map<QualifiedName, List<IEObjectDescription>> cachedLocalElements = Maps.newHashMap();
	
	@Override
	protected List<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		List<IEObjectDescription> result = cachedLocalElements.get(name);
		if (result == null) {
			Iterable<IEObjectDescription> candidates = strategy.getDescriptionsByName(name);
			result = Lists.newArrayList(Iterables.filter(candidates, this));
			cachedLocalElements.put(name, result);
		}
		return result;
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
		// avoid using Iterables.concat here
		List<IEObjectDescription> localElements = getLocalElementsByName(name);
		if (localElements.isEmpty())
			return getParent().getElements(name);
		Iterable<IEObjectDescription> parentElements = getParentElements(new Provider<Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> get() {
				return getParent().getElements(name);
			}
		});
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}
	
	@Override
	protected boolean isShadowedBy(IEObjectDescription fromParent, Iterable<IEObjectDescription> localElements) {
		if (localElements instanceof Collection<?>) {
			if (((Collection<?>) localElements).isEmpty())
				return false;
		}
		return super.isShadowedBy(fromParent, localElements);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		Iterable<IEObjectDescription> result = strategy.getAllDescriptions();
		return Iterables.filter(result, this);
	}

	public boolean apply(IEObjectDescription input) {
		if (input instanceof IValidatedEObjectDescription) {
			boolean result = onlyValidDescriptions == ((IValidatedEObjectDescription) input).isValid();
			return result;
		}
		return false;
	}
	
}
