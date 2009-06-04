/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.resource;

import org.eclipse.emf.common.util.URI;

/**
 * Interface to index a specific resource. Implementing classes should traverse
 * the resource and call the {@link IndexFeeder} to store the desired
 * descriptors in the index.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface ResourceIndexer {

	void resourceChanged(URI resource, IndexFeeder feeder);

	void resourceDeleted(URI resourceURI, IndexFeeder feeder);

	public interface Registry {
		void registerIndexer(String fileExtension, ResourceIndexer indexer);

		void deregisterIndexer(String fileExtension, ResourceIndexer indexer);

		ResourceIndexer getIndexerFor(String fileExtension);
	}
}
