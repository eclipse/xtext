/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;


/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class AbstractScope implements IScope {

	public Iterable<IScopedElement> getAllContents() {
		final Set<String> identifiers = new HashSet<String>();
		return Iterables.concat(Iterables.transform(getContents(), new Function<IScopedElement, IScopedElement>() {
			public IScopedElement apply(IScopedElement param) {
				identifiers.add(param.name());
				return param;
			}
		}), Iterables.filter(getOuterScope().getAllContents(), new Predicate<IScopedElement>() {
			public boolean apply(IScopedElement param) {
				return !identifiers.contains(param.name());
			}
		}));
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
