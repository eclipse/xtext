/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.scoping.Selectors.*;

import java.util.Iterator;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

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
		if (selector == null)
			selector = ISelector.SELECT_ALL;
		Iterable<IEObjectDescription> elements = getElements(selector);
		final Iterator<IEObjectDescription> iterator = elements.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	public Iterable<IEObjectDescription> getElements(ISelector selector) {
		if (selector == null)
			selector = ISelector.SELECT_ALL;
		Iterable<IEObjectDescription> localElements = getLocalElements(selector);
		return Iterables.concat(localElements,
				Iterables.filter(parent.getElements(selector), new Predicate<IEObjectDescription>() {
					public boolean apply(IEObjectDescription input) {
						return !isShadowed(input);
					}
				}));
	}

	protected boolean isShadowed(IEObjectDescription input) {
		final Iterable<IEObjectDescription> localElements = getLocalElements(selectByName(input.getName()));
		final boolean isEmpty = isEmpty(localElements);
		return !isEmpty;
	}

	public abstract Iterable<IEObjectDescription> getLocalElements(ISelector selector);

	@Override
	public String toString() {
		String parentString = null;
		try {
			final IScope parent2 = getParent();
			parentString = parent2.toString();
		} catch (Throwable t) {
			parentString = t.getClass().getSimpleName() + " : " + t.getMessage();
		}
		return getClass().getSimpleName() + getLocalElements(ISelector.SELECT_ALL) + " -> " + parentString;
	}

}
