/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.util.ChainedIterator;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.FilteringIterator;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public abstract class AbstractNestedScope implements IScope {

	private IScope parent;

	public AbstractNestedScope(IScope parent) {
		this.parent = parent;
	}

	public final Iterable<IScopedElement> getAllContents() {
		final Set<String> identifiers = new HashSet<String>();
		return new ChainedIterator<IScopedElement>(FilteringIterator.create(getContents().iterator(),
				new Filter<IScopedElement>() {
					public boolean matches(IScopedElement param) {
						identifiers.add(param.name());
						return true;
					}
				}), FilteringIterator.create(getParent().getAllContents().iterator(), new Filter<IScopedElement>() {
			public boolean matches(IScopedElement param) {
				return !identifiers.contains(param.name());
			}
		}));
	}

	public IScope getParent() {
		return parent;
	}

	private Iterable<IScopedElement> elements;

	public AbstractNestedScope(IScope parent, Iterable<IScopedElement> elements) {
		this(parent);
		this.elements = elements;
	}

	public Iterable<IScopedElement> getContents() {
		return elements;
	}

}
