/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import static org.eclipse.xtext.util.CollectionUtils.filter;
import static org.eclipse.xtext.util.CollectionUtils.join;
import static org.eclipse.xtext.util.CollectionUtils.each;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.Function;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractNestedScope extends AbstractScope {

	private IScope outer;

	private Iterable<IScopedElement> elements;

	public AbstractNestedScope(IScope outer) {
		this.outer = outer;
	}

	protected AbstractNestedScope(IScope outer, Iterable<IScopedElement> elements) {
		this(outer);
		this.elements = elements;
	}

	public final Iterable<IScopedElement> getAllContents() {
		final Set<String> identifiers = new HashSet<String>();
		return join(each(getContents(), new Function.WithoutResult<IScopedElement>() {
			public void exec(IScopedElement param) {
				identifiers.add(param.name());
			}
		}), filter(getOuterScope().getAllContents(), new Filter<IScopedElement>() {
			public boolean matches(IScopedElement param) {
				return !identifiers.contains(param.name());
			}
		}));
	}

	public IScope getOuterScope() {
		return outer;
	}

	protected void setOuterScope(IScope outer) {
		this.outer = outer;
	}

	public Iterable<IScopedElement> getContents() {
		return elements;
	}

	public IScopedElement getScopedElement(EObject element) {
		Iterable<IScopedElement> allContents = getAllContents();
		for (IScopedElement scopedElement : allContents) {
			if (scopedElement.element().equals(element))
				return scopedElement;
		}
		return null;
	}

}
