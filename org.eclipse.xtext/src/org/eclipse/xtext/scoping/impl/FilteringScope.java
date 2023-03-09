/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
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
	
	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		return Iterables.filter(delegate.getAllElements(), filter);
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		return Iterables.filter(delegate.getElements(object), filter);
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		return Iterables.filter(delegate.getElements(name), filter);
	}
	
	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		Iterable<IEObjectDescription> elements = getElements(object);
		return getFirst(elements);
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		Iterable<IEObjectDescription> elements = getElements(name);
		return getFirst(elements);
	}
	
	protected IEObjectDescription getFirst(Iterable<IEObjectDescription> elements) {
		Iterator<IEObjectDescription> iterator = elements.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

}
