/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

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
	public IEObjectDescription getContentByEObject(EObject object) {
		if (elementFilter.apply(object)) {
			IEObjectDescription result = delegate.getContentByEObject(object);
			if (result != null && nameFilter.apply(result.name()))
				return result;
		}
		return null;
	}

	@Override
	public IEObjectDescription getContentByName(String name) {
		if (nameFilter.apply(name)) {
			IEObjectDescription result = delegate.getContentByName(name);
			if (result != null && elementFilter.apply(result.getEObjectOrProxy()))
				return result;
		}
		return null;
	}

	public Iterable<IEObjectDescription> getContents() {
		return Iterables.filter(delegate.getContents(), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				if (input != null) {
					return nameFilter.apply(input.name()) && elementFilter.apply(input.getEObjectOrProxy());
				}
				return true;
			}
		});
	}

	public IScope getOuterScope() {
		return new FilteredScope(delegate.getOuterScope(), elementFilter, nameFilter);
	}
	
}
