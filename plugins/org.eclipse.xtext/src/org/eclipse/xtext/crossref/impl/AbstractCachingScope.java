/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.util.CollectionUtils;
import org.eclipse.xtext.util.Filter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractCachingScope extends AbstractNestedScope {

	private Iterable<IScopedElement> elements;

	private boolean refuseDuplicates;

	private final EClass type;

	protected AbstractCachingScope(IScope parent, Iterable<IScopedElement> elements, EClass type) {
		super(parent, elements);
		this.refuseDuplicates = true;
		this.type = type;
	}

	protected AbstractCachingScope(IScope parent, EClass type, boolean refuseDuplicates) {
		this(parent, null, type);
		this.refuseDuplicates = refuseDuplicates;
	}

	@Override
	public Iterable<IScopedElement> getContents() {
		if (elements == null) {
			ScopedElementProducer producer = new ScopedElementProducer(refuseDuplicates);
			initElements(SimpleAttributeResolver.newResolver(String.class, getNameFeature(type)), producer);
			this.elements = producer.getProducedElements();
		}
		return filter(elements, type);
	}

	protected void initElements(Resource resource) {
		ScopedElementProducer producer = new ScopedElementProducer(refuseDuplicates);
		initElements(SimpleAttributeResolver.newResolver(String.class, getNameFeature(type)), resource, producer);
		this.elements = producer.getProducedElements();
	}

	protected abstract void initElements(SimpleAttributeResolver<String> resolver, ScopedElementProducer producer);

	protected void initElements(SimpleAttributeResolver<String> resolver, Resource resource,
			ScopedElementProducer producer) {
		final Iterator<? extends EObject> iterator = getRelevantContent(resource);
		while (iterator.hasNext()) {
			final EObject object = iterator.next();
			if (EcoreUtil2.isAssignableFrom(type, object.eClass())) {
				String value = resolver.getValue(object);
				value = convertValue(value, object);
				producer.produce(value, object);
			}
		}
	}

	protected String convertValue(String value, EObject object) {
		return value;
	}

	protected Iterator<? extends EObject> getRelevantContent(Resource resource) {
		return resource.getAllContents();
	}

	protected String getNameFeature(EClass type) {
		return "name";
	}

	public void setRefuseDuplicates(boolean refuseDuplicates) {
		this.refuseDuplicates = refuseDuplicates;
	}

	public boolean isRefuseDuplicates() {
		return refuseDuplicates;
	}

	protected Iterable<IScopedElement> filter(final Iterable<IScopedElement> elements, final EClass type) {
		return CollectionUtils.filter(elements.iterator(), new Filter<IScopedElement>() {
			public boolean matches(IScopedElement param) {
				return type == null || EcoreUtil2.isAssignableFrom(type, param.element());
			}
		});
	}

	protected static class ScopedElementProducer {
		private final Map<String, Collection<IScopedElement>> elements;
		private final boolean refuseDuplicates;

		protected ScopedElementProducer(boolean refuseDuplicateNames) {
			this.elements = new HashMap<String, Collection<IScopedElement>>();
			this.refuseDuplicates = refuseDuplicateNames;
		}

		public void produce(String name, EObject object) {
			produce(name, object, null);
		}

		public void produce(String name, EObject object, Object additionalInfo) {
			Collection<IScopedElement> current = elements.get(name);
			if (current==null) {
				if (refuseDuplicates)
					current = Collections.singleton(ScopedElement.create(name, object, additionalInfo));
				else {
					current = new ArrayList<IScopedElement>();
					current.add(ScopedElement.create(name, object, additionalInfo));
				}
				elements.put(name, current);
			} else {
				if (refuseDuplicates)
					elements.put(name, Collections.<IScopedElement>emptySet());
				else
					current.add(ScopedElement.create(name, object, additionalInfo));
			}

		}

		public Iterable<IScopedElement> getProducedElements() {
			return CollectionUtils.flatten(elements.values());
		}
	}

}