/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.tracking.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.tracking.EmfResourceChangeListener;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ResourceChangeDispatcher {
	
	private IndexFeeder indexFeeder;

	private EmfResourceChangeListener.Registry listenerRegistry;

	@Inject
	public ResourceChangeDispatcher(IndexFeeder indexFeeder, EmfResourceChangeListener.Registry listenerRegistry) {
		this.indexFeeder = indexFeeder;
		this.listenerRegistry = listenerRegistry;
	}

	public EmfResourceChangeListener.Registry getListenerRegistry() {
		return listenerRegistry;
	}

	public void resourceChanged(URI resourceURI) {
		String fileExtension = resourceURI.fileExtension();
		Collection<EmfResourceChangeListener> resourceChangeListeners = listenerRegistry.getListenersFor(fileExtension);
		if (resourceChangeListeners != null) {
			for (EmfResourceChangeListener resourceChangeListener : resourceChangeListeners) {
				synchronized (indexFeeder) {
					resourceChangeListener.resourceChanged(resourceURI, indexFeeder);
				}
			}
		}
	}

	public void resourceDeleted(URI resourceURI) {
		String fileExtension = resourceURI.fileExtension();
		Collection<EmfResourceChangeListener> resourceChangeListeners = listenerRegistry.getListenersFor(fileExtension);
		if (resourceChangeListeners != null) {
			for (EmfResourceChangeListener resourceChangeListener : resourceChangeListeners) {
				synchronized (indexFeeder) {
					resourceChangeListener.resourceDeleted(resourceURI, indexFeeder);
					indexFeeder.commit();
				}
			}
		}
	}

}
