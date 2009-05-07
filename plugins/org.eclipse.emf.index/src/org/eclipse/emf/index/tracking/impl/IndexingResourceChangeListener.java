/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.tracking.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.index.internal.LogFacade;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.ResourceIndexer;
import org.eclipse.emf.index.tracking.EmfResourceChangeListener;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IndexingResourceChangeListener implements EmfResourceChangeListener {

	@Inject
	private ResourceIndexer resourceIndexer; 
	
	public IndexingResourceChangeListener(ResourceIndexer resourceIndexer) {
		this.resourceIndexer = resourceIndexer;
	}

	public void resourceChanged(URI resourceURI, IndexFeeder indexFeeder) {
		Resource resource = loadResource(resourceURI);
		resourceIndexer.resourceChanged(resource, indexFeeder);
	}

	public void resourceDeleted(URI resourceURI, IndexFeeder indexFeeder) {
		resourceIndexer.resourceDeleted(resourceURI, indexFeeder);
	}	
	
	protected Resource loadResource(URI resourceURI) {
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			return resourceSet.getResource(resourceURI, true);
		}
		catch (Exception exc) {
			LogFacade.logError("Error loading resource", exc);
			return null;
		}
	}

}
