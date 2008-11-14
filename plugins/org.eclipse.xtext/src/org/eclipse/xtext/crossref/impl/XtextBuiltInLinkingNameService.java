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
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.crossref.ILinkingNameService;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.FilteringIterator;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.SimpleCache;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextBuiltInLinkingNameService implements ILinkingNameService, Adapter {

	private final SimpleCache<EClass, EAttribute> attributeCache;

	private final SimpleCache<EObject, String> nameCache;

	public XtextBuiltInLinkingNameService() {
		attributeCache = new SimpleCache<EClass, EAttribute>(new Function<EClass, EAttribute>() {
			public EAttribute exec(EClass param) {
				EStructuralFeature structuralFeature = param.getEStructuralFeature("name");
				if (structuralFeature != null && structuralFeature instanceof EAttribute
						&& structuralFeature.getEType() instanceof EDataType) {
					EDataType dt = (EDataType) structuralFeature.getEType();
					if (String.class.equals(dt.getInstanceClass())) {
						return (EAttribute) structuralFeature;
					}
				}
				return null;
			}
		});
		nameCache = new SimpleCache<EObject, String>(new Function<EObject, String>() {
			public String exec(EObject param) {
				final EAttribute attr = attributeCache.get(param.eClass());
				if (attr != null) {
					param.eAdapters().add(XtextBuiltInLinkingNameService.this);
				}
				// TODO: think about String.intern()
//				return attr != null ? ((String) param.eGet(attr)).intern() : null;
				return attr != null ? ((String) param.eGet(attr)) : null;
			}
		});
	}

	public String getText(EObject object, CrossReference reference) {
		if (object instanceof ENamedElement)
			return ((ENamedElement) object).getName();
		return nameCache.get(object);
	}

	public Iterable<EObject> getMatches(Iterable<EObject> candidates, final CrossReference reference,
			final String text, final boolean exactMatch) {
		return new FilteringIterator<EObject>(candidates.iterator(), new Filter<EObject>() {
			public boolean matches(EObject param) {
				final String candidateAsText = getText(param, reference);
				// TODO: think about camel humps
				return text.equals(candidateAsText) || !exactMatch && candidateAsText != null
						&& candidateAsText.length() > text.length()
						&& text.regionMatches(!exactMatch, 0, candidateAsText, 0, text.length());
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
				if ("name".equals(((EAttribute) feature).getName())) {
					nameCache.discard((EObject) notification.getNotifier());
				}
			}

		}
	}

	public void setTarget(Notifier newTarget) {
		// nothing to do
	}

}
