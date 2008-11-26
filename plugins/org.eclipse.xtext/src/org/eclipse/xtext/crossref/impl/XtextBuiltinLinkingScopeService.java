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
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.SimpleCache;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class XtextBuiltinLinkingScopeService extends AbstractLinkingScopeService implements Adapter {

	private static final Logger logger = Logger.getLogger(XtextBuiltinLinkingScopeService.class);

	private final SimpleCache<Resource, Collection<EObject>> cache;

	public XtextBuiltinLinkingScopeService() {
		super();
		cache = new SimpleCache<Resource, Collection<EObject>>(new Function<Resource, Collection<EObject>>() {
			public Collection<EObject> exec(Resource resource) {
				final Collection<EObject> result = new ArrayList<EObject>();
				collectEObjectsInto(result, resource);
				resource.eAdapters().add(XtextBuiltinLinkingScopeService.this);
				return result;
			}

			/**
			 * @param result
			 * @param resource
			 */
			private void collectEObjectsInto(Collection<EObject> result, Resource resource) {
				if (logger.isTraceEnabled()) {
					logger.trace("collecting objects of " + resource.toString());
				}
				final Iterator<Object> iter = EcoreUtil.getAllContents(resource, false);
				while (iter.hasNext()) {
					final Object candidate = iter.next();
					if (candidate instanceof EObject)
						result.add((EObject) candidate);
				}
				if (logger.isTraceEnabled()) {
					logger.trace("collected " + result.size() + " object(s) in " + resource.toString());
				}
			}
		});
		logger.debug("Created " + XtextBuiltinLinkingScopeService.class.getName());
	}

	/*
	 * Returns all EObjects of all Resources of the ResourceSet of a given context.
	 * 
	 * @see org.eclipse.xtext.crossref.ILinkingScopeService#getObjectsInScope(org.eclipse.emf.ecore.EObject)
	 */
	public List<EObject> getObjectsInScope(EObject context, EReference reference) {
		if (logger.isTraceEnabled()) {
			logger.trace("retrieving objects in scope of " + context.toString());
		}
		final ResourceSet set = context.eResource().getResourceSet();
		List<EObject> result = null;
		for (int i = 0; i < set.getResources().size(); i++) {
			final Resource r = set.getResources().get(i);
			if (result == null)
				result = new ArrayList<EObject>(cache.get(r));
			else
				result.addAll(cache.get(r));
		}
		if (logger.isTraceEnabled()) {
			logger.trace("found " + result.size() + " object(s) in scope of " + context.toString());
		}
		return result;
	}

	public Notifier getTarget() {
		// nothing to do
		return null;
	}

	public boolean isAdapterForType(Object type) {
		return type instanceof XtextResource;
	}

	public void notifyChanged(Notification notification) {
		if (!notification.isTouch()) {
			if (logger.isTraceEnabled()) {
				logger.trace("received notification " + notification.getEventType());
				logger.trace("discarding cache of " + notification.getNotifier().toString());
			}
			final Resource r = (Resource) notification.getNotifier();
			cache.discard(r);
			r.eAdapters().remove(this);
		}
	}

	public void setTarget(Notifier newTarget) {
		// nothing to do
	}

}
