/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.SimpleCache;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.inject.Inject;

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
	
	@Inject
	private ImportUriResolver importUriResolver;

	//TODO SimpleCache uses WeakHashMap, since the pairs are never referenced from somewhere else, GC will clean them up ASAP.
	// this might result in no caching at all, depending on how often the GC is triggered
	private final SimpleCache<Pair<Resource, EClass>, IScope> cache = new SimpleCache<Pair<Resource, EClass>, IScope>(
			new Function<Pair<Resource, EClass>, IScope>() {
				public IScope apply(Pair<Resource, EClass> param) {
					EList<Adapter> adapters = param.getFirst().getResourceSet().eAdapters();
					if (!adapters.contains(adapter))
						adapters.add(adapter);
					return createScope(param.getFirst(), param.getSecond());
				}
			});

	protected IScope createScope(Resource resource, EClass type) {
		return new DefaultScope(resource, type, getImportUriResolver());
	}

	public IScope getScope(EObject context, EReference reference) {
		EClass type = (EClass) reference.getEType();
		if (type == null)
			type = context.eClass();
		return cache.get(Tuples.create(context.eResource(), type));
	}
	
	public IScope getScope(EObject context, EClass type) {
		EClass typeToUse = type != null ? type : context.eClass();
		return cache.get(Tuples.create(context.eResource(), typeToUse));
	}

	public void setImportUriResolver(ImportUriResolver importUriResolver) {
		this.importUriResolver = importUriResolver;
	}

	public ImportUriResolver getImportUriResolver() {
		return importUriResolver;
	}

}
