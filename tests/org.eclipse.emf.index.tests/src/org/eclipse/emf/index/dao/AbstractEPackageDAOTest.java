/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.ecore.EPackageDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractEPackageDAOTest extends AbstractDAOTest {

	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract EPackageDescriptor.DAO createEPackageDAO();

	public void testGenericQueries() throws Exception {
		EPackageDescriptor.Query query = indexStore.ePackageDAO().createQuery().nsURI(EPACKAGE_NS_URI);
		genericQuerySingleResultTest(indexStore.ePackageDAO(), ePackageDescriptor, query);

		query = indexStore.ePackageDAO().createQuery().name(EPACKAGE_NAME);
		genericQuerySingleResultTest(indexStore.ePackageDAO(), ePackageDescriptor, query);

		query.nsURI(EPACKAGE_NS_URI);
		genericQuerySingleResultTest(indexStore.ePackageDAO(), ePackageDescriptor, query);
	}

	public void testNonGenericQueries() {

		IGenericQuery<EPackageDescriptor> query = indexStore.ePackageDAO().createQueryEPackage(ePackage);
		genericQuerySingleResultTest(indexStore.ePackageDAO(), ePackageDescriptor, query);

		indexStore.ePackageDAO().store(ePackageDescriptor);
		EPackage wrongEPackage = EcoreFactory.eINSTANCE.createEPackage();
		wrongEPackage.setNsURI("wrong");
		query = indexStore.ePackageDAO().createQueryEPackage(wrongEPackage);
		assertEmptyResult(query);
	}

}
