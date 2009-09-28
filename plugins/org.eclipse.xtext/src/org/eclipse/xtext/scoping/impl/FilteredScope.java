/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FilteredScope extends AbstractScope {

	private final IScope delegate;
	private final Predicate<EObject> elementFilter;
	private final Predicate<String> nameFilter;

	public FilteredScope(IScope delegate, Predicate<EObject> elementFilter, Predicate<String> nameFilter) {
		this.delegate = delegate;
		this.elementFilter = elementFilter;
		this.nameFilter = nameFilter;
	}
	
	@Override
	public IScopedElement getContentByEObject(EObject object) {
		if (elementFilter.apply(object)) {
			IScopedElement result = delegate.getContentByEObject(object);
			if (result != null && nameFilter.apply(result.name()))
				return result;
		}
		return null;
	}

	@Override
	public IScopedElement getContentByName(String name) {
		if (nameFilter.apply(name)) {
			IScopedElement result = delegate.getContentByName(name);
			if (result != null && elementFilter.apply(result.element()))
				return result;
		}
		return null;
	}

	public Iterable<IScopedElement> getContents() {
		return Iterables.filter(delegate.getContents(), new Predicate<IScopedElement>() {
			public boolean apply(IScopedElement input) {
				if (input != null) {
					return nameFilter.apply(input.name()) && elementFilter.apply(input.element());
				}
				return true;
			}
		});
	}

	public IScope getOuterScope() {
		return new FilteredScope(delegate.getOuterScope(), elementFilter, nameFilter);
	}
	
}
