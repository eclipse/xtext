/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.SimpleAttributeResolver;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

/**
 * This class contains static utility functions to create and work on {@link IScope} and {@link IScopedElement}
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class Scopes {

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
		return new SimpleScope(outer, scopedElementsFor(elements, nameComputation));
	}

	/**
	 * transforms an {@link Iterable} of {@link EObject}s into an {@link Iterable} of {@link IScopedElement}s computing
	 * the {@link EAttribute} 'name' to compute the {@link IScopedElement}'s name. If not existent the object is
	 * filtered out.
	 */
	public static Iterable<IEObjectDescription> scopedElementsFor(Iterable<? extends EObject> elements) {
		return scopedElementsFor(elements, SimpleAttributeResolver.NAME_RESOLVER);
	}

	/**
	 * transforms an {@link Iterable} of {@link EObject}s into an {@link Iterable} of {@link IScopedElement}s computing
	 * the name of the elements using the passed {@link Function} If the passed function returns null the object is
	 * filtered out.
	 */
	public static <T extends EObject> Iterable<IEObjectDescription> scopedElementsFor(Iterable<? extends T> elements,
			final Function<T, String> nameComputation) {
		Iterable<IEObjectDescription> transformed = Iterables.transform(elements, new Function<T, IEObjectDescription>() {
			public IEObjectDescription apply(T from) {
				String name = nameComputation.apply(from);
				if (name != null)
					return EObjectDescription.create(name, from);
				return null;
			}
		});
		return Iterables.filter(transformed, Predicates.notNull());
	}

	/**
	 * returns an Iterable<IScopedElement> containing all scoped elements for the AllContnts of the passed resource,
	 * which are of the given type. The name is computed using the passed function
	 * 
	 * 
	 * @param resource
	 * @param typeToFilter
	 * @param nameFunc
	 * @return
	 */
	public static Iterable<IEObjectDescription> allInResource(final Resource resource, final EClass typeToFilter,
			final Function<EObject, String> nameFunc) {
		return allInResource(resource, new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return typeToFilter.isInstance(input);
			}
		}, nameFunc);
	}

	/**
	 * @param resource
	 * @param predicate
	 * @param nameFunc
	 * 
	 *            skips duplicate elements
	 * 
	 * @return
	 */
	public static Iterable<IEObjectDescription> allInResource(final Resource resource, final Predicate<EObject> predicate,
			final Function<EObject, String> nameFunc) {
		return allInResource(resource, predicate, nameFunc, true);
	}

	/**
	 * @param resource
	 * @param filter
	 * @param nameFunc
	 * @param skipDuplicates
	 * @return
	 */
	public static Iterable<IEObjectDescription> allInResource(final Resource resource, final Predicate<EObject> filter,
			final Function<EObject, String> nameFunc, boolean skipDuplicates) {
		if (resource != null) {

			Iterable<EObject> iterable = new Iterable<EObject>() {

				public Iterator<EObject> iterator() {
					return EcoreUtil.getAllContents(resource, true);
				}
			};

			Iterable<EObject> filtered = filter(iterable, filter);

			Iterable<IEObjectDescription> transformed = transform(filtered, new Function<EObject, IEObjectDescription>() {

				public IEObjectDescription apply(EObject from) {
					return EObjectDescription.create(nameFunc.apply(from), from);
				}
			});
			if (!skipDuplicates)
				return transformed;

			return skipDuplicates(transformed);
		}
		return Iterables.emptyIterable();
	}

	public static Iterable<IEObjectDescription> skipDuplicates(Iterable<IEObjectDescription> transformed) {
		final ListMultimap<String, IEObjectDescription> multiMap = Multimaps.index(transformed,
				new Function<IEObjectDescription, String>() {
					public String apply(IEObjectDescription from) {
						return from.getName();
					}
				});

		return filter(transformed, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return multiMap.get(input.getName()).size() == 1;
			}
		});
	}
}
