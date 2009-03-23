/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.indexImpl;

import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Descriptor;
import org.eclipse.emf.ecore.EPackage.Registry;
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
	public IndexAwareResourceSet(IIndexStore store, final INameProvider nameProvider) {
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
		Registry reg = getPackageRegistry();
		// XXX SZ: will not return null, however reg.entrySet does not provide all visible
		// registry entries. Is there a way to enumerate them?
		if (reg==null || reg.isEmpty())
			reg = EPackage.Registry.INSTANCE;
		Set<Entry<String,Object>> set = reg.entrySet();
		for (Entry<String, Object> entry : set) {
			// TODO SZ: what about EPackage.Descriptor?
			EPackage pack = null;
			if (entry.getValue() instanceof EPackage.Descriptor) {
				pack = ((Descriptor) entry.getValue()).getEPackage();
			} else if (entry.getValue() instanceof EPackage)
				pack = (EPackage) entry.getValue();
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
