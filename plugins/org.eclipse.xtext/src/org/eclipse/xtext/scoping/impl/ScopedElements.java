/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.scoping.IScopedElement;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @deprecated Use functionality in {@link org.eclipse.xtext.scoping.Scopes} instead
 */
@Deprecated
public abstract class ScopedElements {
	private ScopedElements() {
	}

	/**
	 * returns an Iterable<IScopedElement> containing all scoped elements for the AllContnts of the passed resource,
	 * which are of the given type.
	 * The name is computed using the passed function
	 * 
	 * 
	 * @param resource
	 * @param typeToFilter
	 * @param nameFunc
	 * @return
	 */
	public static Iterable<IScopedElement> allInResource(final Resource resource, final EClass typeToFilter,
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
	 * skips duplicate elements
	 * 
	 * @return
	 */
	public static Iterable<IScopedElement> allInResource(final Resource resource, final Predicate<EObject> predicate,
			final Function<EObject, String> nameFunc) {
		return allInResource(resource,predicate,nameFunc, true);
	}
	
	/**
	 * @param resource
	 * @param filter
	 * @param nameFunc
	 * @param skipDuplicates
	 * @return
	 */
	public static Iterable<IScopedElement> allInResource(final Resource resource, final Predicate<EObject> filter,final Function<EObject, String> nameFunc, boolean skipDuplicates) {
		if (resource != null) {
			
			Iterable<EObject> iterable = new Iterable<EObject>(){
			
				public Iterator<EObject> iterator() {
					return EcoreUtil.getAllContents(resource, true);
				}
			};
			
			Iterable<EObject> filtered = filter(iterable, filter);
			
			Iterable<IScopedElement> transformed = transform(filtered, new Function<EObject, IScopedElement>(){

				public IScopedElement apply(EObject from) {
					return ScopedElement.create(nameFunc.apply(from), from);
				}
			});
			if (!skipDuplicates) 
				return transformed;
			
			final ListMultimap<String,IScopedElement> multiMap = Multimaps.index(transformed, new Function<IScopedElement, String>(){
				public String apply(IScopedElement from) {
					return from.name();
				}
			});
			
			return filter(transformed, new Predicate<IScopedElement>(){
				public boolean apply(IScopedElement input) {
					return multiMap.get(input.name()).size()==1;
				}
			});
		}
		return Iterables.emptyIterable();
	}

}
