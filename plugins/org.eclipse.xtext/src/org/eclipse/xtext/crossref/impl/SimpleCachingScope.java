/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.FilteringIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleCachingScope extends AbstractNestedScope {

	protected Map<String, EObject> elements;
	protected EClass type;

	protected static Iterable<IScopedElement> convert(final Map<String, EObject> elements, final EClass type) {
		final Iterator<Entry<String, EObject>> iterator = elements.entrySet().iterator();
		return FilteringIterator.create(new Iterator<IScopedElement>() {
	
			public boolean hasNext() {
				return iterator.hasNext();
			}
	
			public IScopedElement next() {
				Entry<String, EObject> entry = iterator.next();
				if (entry != null)
					return ScopedElement.create(entry.getKey(), entry.getValue());
				return null;
			}
	
			public void remove() {
				iterator.remove();
			}
		}, new Filter<IScopedElement>() {
	
			public boolean matches(IScopedElement param) {
				return type == null ? true : EcoreUtil2.isAssignableFrom(type, param.element());
			}
		});
	}

	public Iterable<IScopedElement> getContents() {
		return convert(elements, type);
	}

	protected static Map<String, EObject> createMap(Resource resource, EClass type, SimpleAttributeResolver<String> resolver) {
		Map<String, EObject> elements = new HashMap<String, EObject>();
		Set<String> usedNames = new HashSet<String>();
		TreeIterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject object = (EObject) iterator.next();
			if (EcoreUtil2.isAssignableFrom(type, object.eClass())) {
				String value = resolver.getValue(object);
				if (value != null) {
					if (usedNames.add(value)) {
						elements.put(value, object);
					} else {
						elements.remove(value);
					}
				}
			}
		}
		return elements;
	}

	public SimpleCachingScope(IScope parent, Resource resource, EClass type) {
		super(parent);
		SimpleAttributeResolver<String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");
		this.elements = createMap(resource, type, resolver);
		this.type = type;
	}

}
