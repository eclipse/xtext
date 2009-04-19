/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.util.SimpleCache;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultScopeProvider extends AbstractScopeProvider {

	private static final Logger logger = Logger.getLogger(DefaultScopeProvider.class);

	private final EContentAdapter adapter = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification notification) {
			if (!notification.isTouch() && !cache.isEmpty()) {
				Object notifier = notification.getNotifier();
				if (logger.isTraceEnabled()) {
					logger.trace("received notification " + notification.getEventType());
					logger.trace("discarding cache of " + notifier.toString());
				}
				// ignore setting of cross references
				Object feature = notification.getFeature();
				if ((notification.getEventType() == Notification.SET || notification.getEventType() == Notification.ADD)
						&& feature instanceof EReference) {
					EReference ref = (EReference) feature;
					if (!ref.isContainment())
						return;
				}
				cache.clear();
			}
		}
	};

	//TODO SimpleCache uses WeakHashMap, since the pairs are never referenced from somewhere else, GC will clean them up ASAP.
	// this might result in no caching at all, depending on how often the GC is triggered
	private final SimpleCache<Triple<EObject, Resource, EClass>, IScope> cache = new SimpleCache<Triple<EObject, Resource, EClass>, IScope>(
			new Function<Triple<EObject, Resource, EClass>, IScope>() {
				public IScope apply(Triple<EObject, Resource, EClass> param) {
					EList<Adapter> adapters = param.getSecond().getResourceSet().eAdapters();
					if (!adapters.contains(adapter))
						adapters.add(adapter);
					adapters = param.getFirst().eResource().getResourceSet().eAdapters();
					if (!adapters.contains(adapter))
						adapters.add(adapter);
					return createScope(param.getFirst(), param.getSecond(), param.getThird());
				}
			});

	protected IScope createScope(EObject rootModel, Resource resource, EClass type) {
		return new DefaultScope(resource, type);
	}

	public IScope getScope(EObject rootModel, EObject context, EReference reference) {
		EClass type = (EClass) reference.getEType();
		if (type == null)
			type = context.eClass();
		return cache.get(Tuples.create(rootModel, context.eResource(), type));
	}
	
	public IScope getScope(EObject rootModel, EObject context, EClass type) {
		EClass typeToUse = type != null ? type : context.eClass();
		return cache.get(Tuples.create(rootModel, context.eResource(), typeToUse));
	}

}
