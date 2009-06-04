/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.resource.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.index.resource.ResourceIndexer;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class SimpleResourceIndexerRegistryImpl implements ResourceIndexer.Registry {

	private Map<String, ResourceIndexer> registry = new HashMap<String, ResourceIndexer>();

	public void registerIndexer(String fileExtension, ResourceIndexer indexer) {
		registry.put(fileExtension, indexer);
	}

	public void deregisterIndexer(String fileExtension, ResourceIndexer indexer) {
		if (registry.get(fileExtension) == indexer)
			registry.remove(fileExtension);
	}

	public ResourceIndexer getIndexerFor(String fileExtension) {
		return registry.get(fileExtension);
	}

}
