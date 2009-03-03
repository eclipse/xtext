/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.resource.EmfResourceChangeListener;
import org.eclipse.emf.index.resource.EmfResourceChangeListenerRegistry;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IndexBuilderImpl {

	private IIndexStore indexStore;

	private IndexFeederImpl indexFeeder;

	public IndexBuilderImpl(IIndexStore indexStore) {
		this.indexStore = indexStore;
		indexFeeder = new IndexFeederImpl(indexStore);
	}

	public IndexBuilderImpl() {
		this(IIndexStore.INSTANCE);
	}

	public void resourceChanged(URI resourceURI) {
		String fileExtension = resourceURI.fileExtension();
		Collection<EmfResourceChangeListener> resourceChangeListeners = EmfResourceChangeListenerRegistry.INSTANCE
				.getListenersFor(fileExtension);
		if (resourceChangeListeners != null) {
			for (EmfResourceChangeListener resourceChangeListener : resourceChangeListeners) {
				synchronized (indexFeeder) {
					indexFeeder.begin();
					resourceChangeListener.resourceChanged(resourceURI, indexStore, indexFeeder);
					indexFeeder.commit();
				}
			}
		}
	}
	
	public void resourceDeleted(URI resource) {
		// TODO: implement
	}
	
}
