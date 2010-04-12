/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseScopes {

	/**
	 * creates a scope using {@link SimpleAttributeResolver#NAME_RESOLVER} to compute the names and sets
	 * {@link IScope#NULLSCOPE} as parent scope
	 */
	public static IScope scopeFor(Iterable<? extends EObject> elements) {
		return scopeFor(elements, IScope.NULLSCOPE);
	}

	/**
	 * creates a scope using {@link SimpleAttributeResolver#NAME_RESOLVER} to compute the names
	 */
	public static IScope scopeFor(Iterable<? extends EObject> elements, IScope outer) {
		return scopeFor(elements, SimpleAttributeResolver.NAME_RESOLVER, outer);
	}

	/**
	 * creates a scope using the passed function to compute the names and sets the passed scope as the parent scope
	 */
	public static <T extends EObject> IScope scopeFor(Iterable<? extends T> elements,
			final Function<T, String> nameComputation, IScope outer) {
		return new IgnoreCaseSimpleScope(outer, Scopes.scopedElementsFor(elements, nameComputation));
	}

	public static Iterable<IEObjectDescription> filterDuplicatesIgnoreCase(Iterable<IEObjectDescription> filtered) {
		Map<String, IEObjectDescription> result = new LinkedHashMap<String, IEObjectDescription>();
		for (IEObjectDescription e : filtered) {
			String name = e.getName().toLowerCase();
			if (result.containsKey(name)) {
				result.put(name, null);
			} else {
				result.put(name, e);
			}
		}
		return Iterables.filter(result.values(), Predicates.notNull());
	}
}
