/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class FilteringScope implements IScope {

	private IScope delegate;
	private Predicate<IEObjectDescription> filter;

	public FilteringScope(IScope delegate, Predicate<IEObjectDescription> filter) {
		this.delegate = delegate;
		this.filter = filter;
	}

	public IScope getOuterScope() {
		return new FilteringScope(delegate.getOuterScope(), filter);
	}

	public Iterable<IEObjectDescription> getContents() {
		return filter(delegate.getContents());
	}

	public Iterable<IEObjectDescription> getAllContents() {
		return filter(delegate.getAllContents());
	}

	public IEObjectDescription getContentByName(String name) {
		return filter(delegate.getContentByName(name));
	}

	public IEObjectDescription getContentByEObject(EObject object) {
		return filter(delegate.getContentByEObject(object));
	}
	
	public Iterable<IEObjectDescription> getAllContentsByEObject(EObject object) {
		return filter(delegate.getAllContentsByEObject(object));
	}

	protected Iterable<IEObjectDescription> filter(
			Iterable<IEObjectDescription> unfiltered) {
		return Iterables.filter(unfiltered, filter);
	}

	protected IEObjectDescription filter(IEObjectDescription contentByEObject) {
		if (!filter.apply(contentByEObject))
			return null;
		return contentByEObject;
	}
}
