/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * 
 * A FilteringScope filters out all {@link IEObjectDescription} for which 
 * the given predicate returns <code>false</code>. 
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class FilteringScope implements IScope {
	
	private IScope delegate;
	private Predicate<IEObjectDescription> filter;
	
	public FilteringScope(IScope delegate, Predicate<IEObjectDescription> filter) {
		this.delegate = delegate;
		this.filter = filter;
	}
	
	public FilteringScope(IScope delegate, final EClass ...allowedTypes) {
		this.delegate = delegate;
		this.filter = new Predicate<IEObjectDescription>(){

			public boolean apply(IEObjectDescription input) {
				for (EClass eClass : allowedTypes) {
					if (eClass.isSuperTypeOf(eClass))
						return true;
				}
				return false;
			}};
	}

	public IScope getOuterScope() {
		return new FilteringScope(delegate.getOuterScope(), filter);
	}

	public Iterable<IEObjectDescription> getAllContents() {
		return filtered(delegate.getAllContents());
	}
	
	public Iterable<IEObjectDescription> getContents() {
		return filtered(delegate.getContents());
	}

	public IEObjectDescription getContentByName(String name) {
		return filtered(delegate.getContentByName(name));
	}

	public IEObjectDescription getContentByEObject(EObject object) {
		return filtered(delegate.getContentByEObject(object));
	}

	public Iterable<IEObjectDescription> getAllContentsByEObject(EObject object) {
		return filtered(delegate.getAllContentsByEObject(object));
	}

	protected Iterable<IEObjectDescription> filtered(
			Iterable<IEObjectDescription> elements) {
		return Iterables.filter(elements, filter);
	}
	
	protected IEObjectDescription filtered(IEObjectDescription element) {
		if (element==null)
			return null;
		if (filter.apply(element))
			return element;
		return null;
	}
	
	
}
