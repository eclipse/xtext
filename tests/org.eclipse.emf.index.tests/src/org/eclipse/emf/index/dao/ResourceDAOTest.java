/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.ResourceDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ResourceDAOTest extends AbstractDAOTest {

	public void testGenericQueries() throws Exception {
		ResourceDescriptor.Query query = indexStore.resourceDAO().createQuery().uri(RESOURCE_URI);
		genericQuerySingleResultTest(indexStore.resourceDAO(), resourceDescriptor, query);
	}

	public void testNonGenericQueries() {
		IGenericQuery<ResourceDescriptor> query = indexStore.resourceDAO().createQueryResource(resource);
		genericQuerySingleResultTest(indexStore.resourceDAO(), resourceDescriptor, query);

		indexStore.resourceDAO().store(resourceDescriptor);
		
		Resource resource = new ResourceImpl(URI.createURI("wrong"));
		query = indexStore.resourceDAO().createQueryResource(resource);
		assertEmptyResult(query);
	}

}
