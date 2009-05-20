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
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.ResourceIndexer;
import org.eclipse.emf.index.resource.impl.ResourceIndexerImpl;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class IndexAwareResourceSet extends XtextResourceSet {
	private final IndexStore store;
	private final IndexFeeder feeder;
	private final ResourceIndexer listener;

	@Inject
	public IndexAwareResourceSet(final IndexStore store, final IGlobalNameProvider nameProvider,
			final EPackage.Registry registry, final IndexFeeder indexFeeder, final EcoreIndexFeeder ecoreIndexFeeder) {
		this.store = store;
		this.feeder = indexFeeder;

		this.listener = new ResourceIndexerImpl() {
			@Override
			protected String getEObjectName(EObject eObject) {
				return nameProvider.getGlobalName(eObject);
			}

			@Override
			protected boolean isIndexElement(EObject element) {
				return nameProvider.getGlobalName(element) != null;
			}
		};

		Collection<String> keys = new ArrayList<String>(registry.keySet());
		for (String nsURI : keys) {
			EPackage pack = registry.getEPackage(nsURI);
			ecoreIndexFeeder.index(pack, false);
		}
	}

	@Override
	public Resource createResource(URI uri, String contentType) {
		try {
			return super.createResource(uri, contentType);
		}
		finally {
			listener.resourceChanged(uri, feeder);
		}
	}

	public IndexStore getStore() {
		return store;
	}
	
}
