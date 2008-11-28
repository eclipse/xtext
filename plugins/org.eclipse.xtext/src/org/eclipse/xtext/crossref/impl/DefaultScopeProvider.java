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
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.SimpleCache;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DefaultScopeProvider extends AbstractScopeProvider implements IScopeProvider {

	private static final Logger logger = Logger.getLogger(DefaultScopeProvider.class);

	private final EContentAdapter adapter = new EContentAdapter() {

		public void notifyChanged(Notification notification) {
			if (!notification.isTouch()) {
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

	private final SimpleCache<Pair<Resource, EClass>, IScope<EObject>> cache = new SimpleCache<Pair<Resource, EClass>, IScope<EObject>>(
			new Function<Pair<Resource, EClass>, IScope<EObject>>() {

				public IScope<EObject> exec(Pair<Resource, EClass> param) {
					EList<Adapter> adapters = param.getFirstElement().getResourceSet().eAdapters();
					if (!adapters.contains(adapter))
						adapters.add(adapter);
					return new DefaultScope(param.getFirstElement(), param.getSecondElement());
				}
			});

	public IScope<EObject> getScope(EObject context, EReference reference) {
		return cache.get(new Pair<Resource, EClass>(context.eResource(), reference != null ? reference
				.getEReferenceType() : null));
	}

}
