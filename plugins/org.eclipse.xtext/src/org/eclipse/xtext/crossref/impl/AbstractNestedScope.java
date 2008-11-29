/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.util.ChainedIterator;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.FilteringIterator;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * @param <EObject>
 */
public abstract class AbstractNestedScope<EObject> implements IScope<EObject> {
	
	private IScope<EObject> parent;
	
	public AbstractNestedScope(IScope<EObject> parent) {
		this.parent = parent;
	}
	
	public final Iterable<IScopedElement<EObject>> getAllContents() {
		final Set<String> identifiers = new HashSet<String>();
		return new ChainedIterator<IScopedElement<EObject>>(
				FilteringIterator.create(getContents().iterator(),new Filter<IScopedElement<EObject>>(){
					public boolean matches(IScopedElement<EObject> param) {
						identifiers.add(param.name());
						return true;
					}
				}),
				FilteringIterator.create(getParent().getAllContents().iterator(),new Filter<IScopedElement<EObject>>(){
					public boolean matches(IScopedElement<EObject> param) {
						return !identifiers.contains(param.name());
					}}));
	}

	public IScope<EObject> getParent() {
		return parent;
	}
	
	private Iterable<IScopedElement<EObject>> elements;
	
	public AbstractNestedScope(IScope<EObject> parent, Iterable<IScopedElement<EObject>> elements) {
		this(parent);
		this.elements = elements;
	}

	public Iterable<IScopedElement<EObject>> getContents() {
		return elements;
	}
	
}
