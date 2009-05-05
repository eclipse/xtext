/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.index;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.resource.EmfResourceChangeListener;
import org.eclipse.emf.index.resource.impl.DefaultEmfResourceChangeListenerImpl;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class IndexAwareResourceSet extends XtextResourceSet {
	private final IIndexStore store;
	private final IndexFeederImpl feeder;
	private final EmfResourceChangeListener listener;

	public IIndexStore getStore() {
		return store;
	}

	@Inject
	public IndexAwareResourceSet(IIndexStore store, final INameProvider nameProvider, final EPackage.Registry registry) {
		this.store = store;
		this.feeder = new IndexFeederImpl(store);
		this.listener = new DefaultEmfResourceChangeListenerImpl() {
			@Override
			protected Resource loadResource(URI resourceUri) {
				return IndexAwareResourceSet.this.getResource(resourceUri, true);
			}

			@Override
			protected String getEObjectName(EObject eObject) {
				return nameProvider.getGlobalName(eObject);
			}

			@Override
			protected boolean isIndexElement(EObject element) {
				return nameProvider.getGlobalName(element) != null;
			}
		};
		
		EcoreIndexFeederImpl ecoreFeeder = new EcoreIndexFeederImpl(store);
		
		Collection<String> keys = new ArrayList<String>(registry.keySet());
		for (String nsURI : keys) {
			EPackage pack = registry.getEPackage(nsURI);
			ecoreFeeder.index(pack, false);
		}
	}
	
	@Override
	public Resource createResource(URI uri, String contentType) {
		try {
			return super.createResource(uri, contentType);
		} finally {
			indexResource(uri);
		}
	}

	/**
	 * @param uri
	 */
	private void indexResource(URI uri) {
		try {
			feeder.begin();
			listener.resourceChanged(uri, store, feeder);
		} finally {
			feeder.commit();
		}
	}
}
