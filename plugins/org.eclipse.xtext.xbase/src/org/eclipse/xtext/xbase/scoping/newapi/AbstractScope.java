/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.newapi;

import java.util.Iterator;

import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractScope implements INewScope {
	
	private INewScope parent;
	
	public AbstractScope(INewScope parent) {
		this.parent = parent;
	}

	public INewScope getParent() {
		return parent;
	}

	public IEObjectDescription getSingleElement(ISelector selector) {
		Iterator<? extends IEObjectDescription> iter = getElements(selector).iterator();
		return iter.hasNext()?iter.next():null;
	}

	public Iterable<? extends IEObjectDescription> getElements(ISelector selector) {
		Iterable<? extends IEObjectDescription> localElements = getLocalElements(selector);
		return Iterables.concat(index(localElements),Iterables.filter(parent.getElements(selector), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return !isShadowed(input);
			}
		}));
	}
	
	protected abstract Iterable<? extends IEObjectDescription> index(Iterable<? extends IEObjectDescription> localElements);

	protected abstract Iterable<? extends IEObjectDescription> getLocalElements(ISelector selector);

	protected abstract boolean isShadowed(IEObjectDescription fromParent);
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+"["+getLocalElements(ISelector.SELECT_ALL)+"] -> "+getParent();
	}

}
