/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.SimpleCache;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleAttributeResolver<K extends EObject, T> implements Function<K, T>{
	
	public final static SimpleAttributeResolver<EObject, String> NAME_RESOLVER = newResolver(String.class, "name");

	private final SimpleCache<EClass, EAttribute> attributeCache;

	private final SimpleCache<EObject, T> valueCache;

	private final String attributeName;

	private final Adapter discardingAdapter;

	public static <K extends EObject, T> SimpleAttributeResolver<K, T> newResolver(final Class<T> type, final String attributeName) {
		return new SimpleAttributeResolver<K, T>(type, attributeName);
	}

	public EAttribute getAttribute(final EObject object) {
		return attributeCache.get(object.eClass());
	}

	private SimpleAttributeResolver(final Class<T> type, final String attributeName) {
		this.attributeName = attributeName;
		this.discardingAdapter = new DiscardingAdapter();
		attributeCache = new SimpleCache<EClass, EAttribute>(new Function<EClass, EAttribute>() {
			public EAttribute apply(EClass param) {
				final EStructuralFeature structuralFeature = param.getEStructuralFeature(attributeName);
				if (structuralFeature != null && structuralFeature instanceof EAttribute && !structuralFeature.isMany()) {
					if (type.isAssignableFrom(structuralFeature.getEType().getInstanceClass())) {
						return (EAttribute) structuralFeature;
					}
				}
				return null;
			}
		});
		valueCache = new SimpleCache<EObject, T>(new Function<EObject, T>() {
			@SuppressWarnings("unchecked")
			public T apply(EObject param) {
				final EStructuralFeature feature = attributeCache.get(param.eClass());
				if (feature != null) {
					param.eAdapters().add(discardingAdapter);
				}
				return feature != null ? ((T) param.eGet(feature)) : null;
			}
		});
	}

	public T getValue(final K object) {
		return valueCache.get(object);
	}

	public Iterable<K> getMatches(final Iterable<K> candidates, final T value) {
		return Iterables.filter(candidates, new Predicate<K>() {
			public boolean apply(K param) {
				final T candidateValue = getValue(param);
				return value.equals(candidateValue);
			}
		});
	}

	private class DiscardingAdapter implements Adapter {

		public Notifier getTarget() {
			return null;
		}

		public boolean isAdapterForType(final Object type) {
			return type instanceof EObject;
		}

		public void notifyChanged(final Notification notification) {
			if (!notification.isTouch() && Notification.SET == notification.getEventType()) {
				final Object feature = notification.getFeature();
				if (feature != null) {
					if (attributeName.equals(((ENamedElement) feature).getName())) {
						valueCache.discard((EObject) notification.getNotifier());
						((EObject) notification.getNotifier()).eAdapters().remove(this);
					}
				}

			}
		}

		public void setTarget(final Notifier newTarget) {
			// nothing to do
		}
	}

	public T apply(final K from) {
		return getValue(from);
	}

}
