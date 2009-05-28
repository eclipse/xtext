/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.emf.index.runtime.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.resource.ResourceIndexer;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;
import org.eclipse.emf.index.resource.impl.SimpleResourceIndexerRegistryImpl;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexAwareResourceSet extends ResourceSetImpl {
	private IndexStore store;
	
	@Inject(optional=true)
	private final ResourceIndexer.Registry registry = new SimpleResourceIndexerRegistryImpl();
	
	public static class IndexEntry {
		private String fileExtension;
		private ResourceIndexer indexer;
		
		public IndexEntry(String fileExtension, ResourceIndexer indexer) {
			super();
			this.fileExtension = fileExtension;
			this.indexer = indexer;
		}
		public String getFileExtension() {
			return fileExtension;
		}
		public void setFileExtension(String fileExtension) {
			this.fileExtension = fileExtension;
		}
		public ResourceIndexer getIndexer() {
			return indexer;
		}
		public void setIndexer(ResourceIndexer indexer) {
			this.indexer = indexer;
		}
	}
	
	public void addIndexer(IndexEntry entry) {
		this.registry.registerIndexer(entry.getFileExtension(), entry.getIndexer());
	}
	
	@Inject
	public void setIndexStore(IndexStore indexStore) {
		this.store = indexStore;
	}

	@Override
	public Resource createResource(URI uri, String contentType) {
		try {
			return super.createResource(uri, contentType);
		}
		finally {
			ResourceIndexer indexer = registry.getIndexerFor(uri.fileExtension());
			IndexFeederImpl feeder = new IndexFeederImpl(store);
			indexer.resourceChanged(uri, feeder);
			feeder.commit();
		}
	}

	public IndexStore getStore() {
		return store;
	}
	
}
