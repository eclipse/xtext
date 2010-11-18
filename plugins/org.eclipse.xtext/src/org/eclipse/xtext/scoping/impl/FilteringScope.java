/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.ISelector.DelegatingSelector;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
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
					if (EcoreUtil2.isAssignableFrom(eClass, input.getEClass()))
						return true;
				}
				return false;
			}};
	}

	public IEObjectDescription getSingleElement(ISelector selector) {
		return delegate.getSingleElement(enhanceSelector(selector));
	}

	public Iterable<IEObjectDescription> getElements(ISelector selector) {
		return delegate.getElements(enhanceSelector(selector));
	}

	protected ISelector enhanceSelector(ISelector selector) {
		if (selector instanceof ISelector.DelegatingSelector) {
			final DelegatingSelector delegatingSelector = (ISelector.DelegatingSelector) selector;
			delegatingSelector.addDelegate(new ISelector(){
				public Iterable<IEObjectDescription> applySelector(Iterable<IEObjectDescription> elements) {
					return Iterables.filter(elements,Predicates.not(filter));
				}});
		}
		return selector;
	}

}
