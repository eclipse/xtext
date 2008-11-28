/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.FilteringIterator;
import org.eclipse.xtext.util.Pair;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DefaultScope extends AbstractNestedScope<EObject> {

	private Map<String, EObject> elements;
	private EClass type;

	public DefaultScope(Resource res, EClass type) {
		super(getParent(res.getAllContents(), type));
		SimpleAttributeResolver<String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");
		this.elements = createMap(res, resolver);
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	private static IScope<EObject> getParent(Iterator<EObject> iter, EClass type) {
		while (iter.hasNext()) {
			EObject object = (EObject) iter.next();
			String uri = getImportURI(object);
			if (uri != null) {
				return new LazyReferencedResourceScope(object, type, uri, getParent(iter, type));
			}
		}
		return (IScope<EObject>) IScope.NULLSCOPE;
	}

	private static String getImportURI(EObject object) {
		EStructuralFeature structuralFeature = object.eClass().getEStructuralFeature("importURI");
		if (structuralFeature == null)
			return null;
		return (String) object.eGet(structuralFeature);
	}

	public Iterable<Pair<String, EObject>> getContents() {
		return convert(elements, type);
	}

	private static Iterable<Pair<String, EObject>> convert(final Map<String, EObject> elements, final EClass type) {
		final Iterator<Entry<String, EObject>> iterator = elements.entrySet().iterator();
		return FilteringIterator.create(new Iterator<Pair<String, EObject>>() {

			public boolean hasNext() {
				return iterator.hasNext();
			}

			public Pair<String, EObject> next() {
				Entry<String, EObject> entry = iterator.next();
				if (entry != null)
					return new Pair<String, EObject>(entry.getKey(), entry.getValue());
				return null;
			}

			public void remove() {
				iterator.remove();
			}
		}, new Filter<Pair<String, EObject>>() {

			public boolean matches(Pair<String, EObject> param) {
				return type == null ? true : EcoreUtil2.isAssignableFrom(type, param.getSecondElement());
			}
		});
	}

	static class LazyReferencedResourceScope extends AbstractNestedScope<EObject> {

		private EObject context;
		private String uri;
		private Map<String, EObject> elements;
		private SimpleAttributeResolver<String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");
		private EClass type;

		public LazyReferencedResourceScope(EObject context, EClass type, String uri, IScope<EObject> parent) {
			super(parent);
			this.context = context;
			this.uri = uri;
			this.type = type;
		}

		@Override
		public synchronized Iterable<Pair<String, EObject>> getContents() {
			if (elements == null) {
				try {
					Resource resource = context.eResource().getResourceSet().getResource(URI.createURI(uri), true);
					elements = createMap(resource, resolver);
				} catch (RuntimeException e) {
					elements = Collections.emptyMap();
				}
			}
			return convert(elements, type);
		}

	}

	private static Map<String, EObject> createMap(Resource resource, SimpleAttributeResolver<String> resolver) {
		Map<String, EObject> elements = new HashMap<String, EObject>();
		Set<String> usedNames = new HashSet<String>();
		TreeIterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject object = (EObject) iterator.next();
			String value = resolver.getValue(object);
			if (value != null) {
				if (usedNames.add(value)) {
					elements.put(value, object);
				} else {
					elements.remove(value);
				}
			}
		}
		return elements;
	}
}
