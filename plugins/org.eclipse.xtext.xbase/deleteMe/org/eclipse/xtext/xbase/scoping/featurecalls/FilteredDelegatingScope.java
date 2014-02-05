/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.scoping.DelegatingScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Provider;

/**
 * A scope implementation that allows to decorate a {@link LazyJvmFeatureScope} to
 * apply filtering on the content.
 *  
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class FilteredDelegatingScope extends DelegatingScope implements Predicate<IEObjectDescription>{
	
	private final boolean onlyVisibleAndValidStaticState;

	protected FilteredDelegatingScope(IScope parent, LazyJvmFeatureScope unfiltered, boolean onlyVisibleAndValidStaticState) {
		super(parent, "FilteredDelegatingScope");
		this.onlyVisibleAndValidStaticState = onlyVisibleAndValidStaticState;
		super.setDelegate(unfiltered);
	}
	
	@Override
	public void setDelegate(IScope delegate) {
		throw new UnsupportedOperationException("Cannot reset the delegate");
	}
	
	@Override
	protected LazyJvmFeatureScope getDelegate() {
		return (LazyJvmFeatureScope) super.getDelegate();
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByEObject(EObject object, URI uri) {
		Iterable<IEObjectDescription> result = getDelegate().getElements(object);
		return Iterables.filter(result, this);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		List<IEObjectDescription> result = getDelegate().getLocalElementsByName(name);
		if (result.isEmpty())
			return result;
		if (result.size() == 1) {
			IEObjectDescription onlyOne = result.get(0);
			if (apply(onlyOne))
				return Collections.singletonList(result.get(0));
			return Collections.emptyList();
		}
		return Iterables.filter(result, this);
	}
	
	@Override
	protected IEObjectDescription getSingleLocalElementByName(QualifiedName name) {
		throw new UnsupportedOperationException("getSingleLocalElementByName");
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		@SuppressWarnings("rawtypes")
		Iterable unfiltered = getDelegate().getJvmFeatureDescriptions();
		@SuppressWarnings("unchecked")
		Iterable<IEObjectDescription> result = Iterables.filter(unfiltered, this);
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Iterable<IValidatedEObjectDescription> getJvmFeatureDescriptions() {
		@SuppressWarnings("rawtypes")
		Iterable result = getAllLocalElements();
		return result;
	}

	public boolean apply(IEObjectDescription input) {
		if (input instanceof IValidatedEObjectDescription) {
			IValidatedEObjectDescription casted = (IValidatedEObjectDescription) input;
			boolean result = onlyVisibleAndValidStaticState == (casted.isVisible() && casted.isValidStaticState());
			return result;
		}
		return false;
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
		// avoid using Iterables.concat here
		Iterable<IEObjectDescription> localElements = getLocalElementsByName(name);
		if (localElements instanceof Collection<?> && ((Collection<?>) localElements).isEmpty()) {
			return getParent().getElements(name);
		}
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
}
