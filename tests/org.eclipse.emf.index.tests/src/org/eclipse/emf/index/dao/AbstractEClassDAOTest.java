/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao;

import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.EPackageDescriptor.DAO;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractEClassDAOTest extends AbstractDAOTest {
	
	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract DAO createEPackageDAO();
	
	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract EClassDescriptor.DAO createEClassDAO();
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		indexStore.ePackageDAO().store(ePackageDescriptor);
	}
	
	public void testGenericQueries() throws Exception {
		EClassDescriptor.Query query = indexStore.eClassDAO().createQuery().name(ECLASS_NAME);
		genericQuerySingleResultTest(indexStore.eClassDAO(), eClassDescriptor, query);

		query = indexStore.eClassDAO().createQuery().ePackage(ePackageDescriptor);
		genericQuerySingleResultTest(indexStore.eClassDAO(), eClassDescriptor, query);
		
		query.name(ECLASS_NAME);
		genericQuerySingleResultTest(indexStore.eClassDAO(), eClassDescriptor, query);
		
		query = indexStore.eClassDAO().createQuery();
		query.ePackage().nsURI(EPACKAGE_NS_URI);
		genericQuerySingleResultTest(indexStore.eClassDAO(), eClassDescriptor, query);
		
		query.name(ECLASS_NAME);
		genericQuerySingleResultTest(indexStore.eClassDAO(), eClassDescriptor, query);
	}
	
	public void testNonGenericQueries() {
		IGenericQuery<EClassDescriptor> query = indexStore.eClassDAO().createQueryEClassesInPackage(ePackageDescriptor);
		genericQuerySingleResultTest(indexStore.eClassDAO(), eClassDescriptor, query);

		query = indexStore.eClassDAO().createQueryEClass(eClass);
		genericQuerySingleResultTest(indexStore.eClassDAO(), eClassDescriptor, query);
	}
}
