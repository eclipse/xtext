/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractScope implements IScope {
	
	private IScope parent = IScope.NULLSCOPE;
	
	public AbstractScope() {
	}
	public AbstractScope(IScope parent) {
		if (parent == null)
			throw new NullPointerException("parent");
		this.parent = parent;
	}

	public IScope getParent() {
		return parent;
	}

	public IEObjectDescription getSingleElement(ISelector selector) {
		if (selector==null)
			selector = ISelector.SELECT_ALL;
		Iterable<IEObjectDescription> elements = getLocalElements(selector);
		final Iterator<IEObjectDescription> iterator = elements.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return getParent().getSingleElement(selector);
	}

	public Iterable<IEObjectDescription> getElements(ISelector selector) {
		if (selector==null)
			selector = ISelector.SELECT_ALL;
		Iterable<IEObjectDescription> localElements = getLocalElements(selector);
		return Iterables.concat(trackKeys(localElements),Iterables.filter(parent.getElements(selector), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return !isShadowed(input);
			}
		}));
	}
	
	protected Set<Object> shadowingIndex = null;
	
	/**
	 * call back used to add indexing functionality to the local {@link IEObjectDescription}
	 * The default impl populates a set of keys, which are used to shadow {@link IEObjectDescription} from
	 * the parent scope 
	 */
	protected Iterable<IEObjectDescription> trackKeys(Iterable<IEObjectDescription> localElements) {
		HashSet<IEObjectDescription> set = Sets.newHashSet(localElements);
		shadowingIndex = Sets.newHashSet();
		for (IEObjectDescription description : set) {
			shadowingIndex.add(getKey(description));
		}
		return set;
	}
	
	/**
	 * @return whether the passed {@link IEObjectDescription} from the parent scope is shadowed by this scope.
	 */
	protected boolean isShadowed(IEObjectDescription fromParent) {
		boolean filtered = shadowingIndex.contains(getKey(fromParent));
		return filtered;
	}
	
	/**
	 * @return the key of the given description, which makes it shadowing others 
	 */
	protected Object getKey(IEObjectDescription description) {
		return description.getKey();
	}
	
	public abstract Iterable<IEObjectDescription> getLocalElements(ISelector selector);

	@Override
	public String toString() {
		return getClass().getSimpleName()+getLocalElements(ISelector.SELECT_ALL)+" -> "+getParent();
	}

}
