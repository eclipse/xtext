/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao;

import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.ResourceDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractEObjectDAOTest extends AbstractDAOTest {

	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract EPackageDescriptor.DAO createEPackageDAO();

	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract EClassDescriptor.DAO createEClassDAO();

	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract ResourceDescriptor.DAO createResourceDAO();
	
	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract EObjectDescriptor.DAO createEObjectDAO();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		indexStore.resourceDAO().store(resourceDescriptor);
		indexStore.ePackageDAO().store(ePackageDescriptor);
		indexStore.eClassDAO().store(eClassDescriptor);
	}

	public void testGenericQueries() throws Exception {
		EObjectDescriptor.Query query = indexStore.eObjectDAO().createQuery().fragment(EOBJECT_FRAGMENT);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);

		query = indexStore.eObjectDAO().createQuery().name(EOBJECT_NAME);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);

		query.fragment(EOBJECT_FRAGMENT);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
		
		query = indexStore.eObjectDAO().createQuery().eClass(eClassDescriptor);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
		
		query = indexStore.eObjectDAO().createQuery().resource(resourceDescriptor);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
		
		query = indexStore.eObjectDAO().createQuery();
		query.resource().uri(RESOURCE_URI);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
		
		query = indexStore.eObjectDAO().createQuery();
		query.eClass().name(ECLASS_NAME);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
		
		query = indexStore.eObjectDAO().createQuery();
		query.eClass().ePackage(ePackageDescriptor);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
		
		query = indexStore.eObjectDAO().createQuery();
		query.eClass().ePackage().nsURI(EPACKAGE_NS_URI);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
	}

	public void testNonGenericQueries() {
		IGenericQuery<EObjectDescriptor> query = indexStore.eObjectDAO().createQueryEObjectByURI(eObjectDescriptor.getFragmentURI());
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
		
		query = indexStore.eObjectDAO().createQueryEObjectsByType(eClass);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);

		query = indexStore.eObjectDAO().createQueryEObjectsByType(eClassDescriptor);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
		
		query = indexStore.eObjectDAO().createQueryEObjectsInResource(resourceDescriptor);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
		
		query = indexStore.eObjectDAO().createQueryEObjectInResource(eObject, resourceDescriptor);
		genericQuerySingleResultTest(indexStore.eObjectDAO(), eObjectDescriptor, query);
	}

}
