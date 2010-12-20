/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Iterator;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

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
	
	public IEObjectDescription getSingleElement(ISelector selector) {
		Iterable<IEObjectDescription> elements = getElements(selector);
		Iterator<IEObjectDescription> iterator = elements.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	public Iterable<IEObjectDescription> getElements(ISelector selector) {
		return Iterables.filter(delegate.getElements(selector), filter);
	}
	
	

}
