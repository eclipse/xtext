/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.crossref.ILinkingNameService;
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
				return attr != null ? (String) param.eGet(attr) : null;
			}
		});
	}

	public String getText(EObject object, CrossReference reference) {
		return nameCache.get(object);
	}

	public Iterator<EObject> getMatches(Collection<EObject> candidates, final CrossReference reference,
			final String text, final boolean exactMatch) {
		final Iterator<EObject> result = candidates.iterator();
		return new Iterator<EObject>() {

			private EObject next;

			public boolean hasNext() {
				if (next != null)
					return true;
				while (next == null && result.hasNext()) {
					final EObject nextCandidate = result.next();
					final String candidateAsText = getText(nextCandidate, reference);
					if (text.equals(candidateAsText) || !exactMatch && candidateAsText != null
							&& candidateAsText.toUpperCase().startsWith(text.toUpperCase()))
						next = nextCandidate;
				}
				return next != null;
			}

			public EObject next() {
				if (next == null && !hasNext())
					throw new IllegalStateException("call hasNext first");
				final EObject res = next;
				next = null;
				return res;
			}

			public void remove() {
				throw new UnsupportedOperationException("remove is not supported by this implementation");
			}

		};
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
		// TODO Auto-generated method stub
	}

}
