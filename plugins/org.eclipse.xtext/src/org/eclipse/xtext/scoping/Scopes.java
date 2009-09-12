/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.impl.SimpleAttributeResolver;
import org.eclipse.xtext.scoping.impl.ScopedElement;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class Scopes {
	
	public static IScope scopeFor(Iterable<? extends EObject> elements) {
		return scopeFor(elements, IScope.NULLSCOPE);
	}
	
	public static IScope scopeFor(Iterable<? extends EObject> elements, IScope outer) {
		return scopeFor(elements, SimpleAttributeResolver.NAME_RESOLVER, outer);
	}
	
	public static IScope scopeFor(Iterable<? extends EObject> elements, final Function<EObject, String> nameComputation) {
		return scopeFor(elements, nameComputation, IScope.NULLSCOPE);
	}
	
	public static IScope scopeFor(Iterable<? extends EObject> elements, final Function<EObject, String> nameComputation, IScope outer) {
		return new SimpleScope(outer, scopedElementsFor(elements, nameComputation));
	}
	
	/**
	 * transforms an {@link Iterable} of {@link EObject}s into an {@link Iterable} of {@link IScopedElement}s 
	 * computing the {@link EAttribute} 'name' to compute the {@link IScopedElement}'s name.
	 * If not existent the object is filtered out.
	 */
	public static Iterable<IScopedElement> scopedElementsFor(Iterable<? extends EObject> elements) {
		return scopedElementsFor(elements, SimpleAttributeResolver.NAME_RESOLVER);
	}
	
	/**
	 * transforms an {@link Iterable} of {@link EObject}s into an {@link Iterable} of {@link IScopedElement}s 
	 * computing the name of the elements using the passed {@link Function}
	 * If the passed function returns null the object is filtered out.
	 */
	public static Iterable<IScopedElement> scopedElementsFor(Iterable<? extends EObject> elements, final Function<EObject, String> nameComputation) {
		Iterable<IScopedElement> transformed = Iterables.transform(elements, new Function<EObject, IScopedElement>() {
			public IScopedElement apply(EObject from) {
				return ScopedElement.create(nameComputation.apply(from), from);
			}
		});
		return Iterables.filter(transformed, new Predicate<IScopedElement>() {
			public boolean apply(IScopedElement input) {
				return input.name()!=null;
			}
		});
	}
}
