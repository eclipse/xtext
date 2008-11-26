/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.FilteringIterator;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.SimpleCache;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleAttributeResolver<T> implements Adapter {

	private final SimpleCache<EClass, EAttribute> attributeCache;

	private final SimpleCache<EObject, T> valueCache;

	private final String attributeName;

	public static <T> SimpleAttributeResolver<T> newResolver(final Class<T> type, final String attributeName) {
		return new SimpleAttributeResolver<T>(type, attributeName);
	}
	
	public SimpleAttributeResolver(final Class<T> type, final String attributeName) {
		this.attributeName = attributeName;
		attributeCache = new SimpleCache<EClass, EAttribute>(new Function<EClass, EAttribute>() {
			public EAttribute exec(EClass param) {
				EStructuralFeature structuralFeature = param.getEStructuralFeature(attributeName);
				if (structuralFeature != null && structuralFeature instanceof EAttribute
						&& structuralFeature.getEType() instanceof EDataType) {
					EDataType dt = (EDataType) structuralFeature.getEType();
					if (type.equals(dt.getInstanceClass())) {
						return (EAttribute) structuralFeature;
					}
				}
				return null;
			}
		});
		valueCache = new SimpleCache<EObject, T>(new Function<EObject, T>() {
			@SuppressWarnings("unchecked")
			public T exec(EObject param) {
				final EAttribute attr = attributeCache.get(param.eClass());
				if (attr != null) {
					param.eAdapters().add(SimpleAttributeResolver.this);
				}
				// TODO: think about String.intern()
				//				return attr != null ? ((String) param.eGet(attr)).intern() : null;
				return attr != null ? ((T) param.eGet(attr)) : null;
			}
		});
	}

	public T getValue(EObject object) {
		return valueCache.get(object);
	}

	public Iterable<EObject> getMatches(Iterable<EObject> candidates, final T value) {
		return new FilteringIterator<EObject>(candidates.iterator(), new Filter<EObject>() {
			public boolean matches(EObject param) {
				final T candidateValue = getValue(param);
				return value.equals(candidateValue);
			}
		});
	}

	public Notifier getTarget() {
		return null;
	}

	public boolean isAdapterForType(Object type) {
		return type instanceof EObject;
	}

	public void notifyChanged(Notification notification) {
		if (!notification.isTouch() && Notification.SET == notification.getEventType()) {
			final Object feature = notification.getFeature();
			if (feature != null && feature instanceof EAttribute) {
				if (attributeName.equals(((EAttribute) feature).getName())) {
					valueCache.discard((EObject) notification.getNotifier());
				}
			}

		}
	}

	public void setTarget(Notifier newTarget) {
		// nothing to do
	}

}
