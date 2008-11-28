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
import org.eclipse.xtext.util.ChainedIterator;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.FilteringIterator;
import org.eclipse.xtext.util.Pair;

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
	
	public final Iterable<Pair<String,EObject>> getAllContents() {
		final Set<String> identifiers = new HashSet<String>();
		return new ChainedIterator<Pair<String,EObject>>(
				FilteringIterator.create(getContents().iterator(),new Filter<Pair<String,EObject>>(){
					public boolean matches(Pair<String,EObject> param) {
						identifiers.add(param.getFirstElement());
						return true;
					}
				}),
				FilteringIterator.create(getParent().getAllContents().iterator(),new Filter<Pair<String,EObject>>(){
					public boolean matches(Pair<String,EObject> param) {
						return !identifiers.contains(param.getFirstElement());
					}}));
	}

	public IScope<EObject> getParent() {
		return parent;
	}
	
	private Iterable<Pair<String, EObject>> elements;
	
	public AbstractNestedScope(IScope<EObject> parent, Iterable<Pair<String,EObject>> elements) {
		this(parent);
		this.elements = elements;
	}

	public Iterable<Pair<String, EObject>> getContents() {
		return elements;
	}
	
}
