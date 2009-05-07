/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao;

import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IGenericQuery;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EReferenceDAOTest extends AbstractDAOTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		indexStore.resourceDAO().store(resourceDescriptor);
		indexStore.ePackageDAO().store(ePackageDescriptor);
		indexStore.eClassDAO().store(eClassDescriptor);
		indexStore.eObjectDAO().store(eObjectDescriptor);
	}

	public void testGenericQueries() throws Exception {
		EReferenceDescriptor.Query query = indexStore.eReferenceDAO().createQuery().referenceName(
				ECROSS_REFERENCE_NAME);
		genericQuerySingleResultTest(indexStore.eReferenceDAO(), eReferenceDescriptor, query);

		query = indexStore.eReferenceDAO().createQuery().sourceFragment(eObjectDescriptor.getFragment())
				.sourceResource(resourceDescriptor);
		genericQuerySingleResultTest(indexStore.eReferenceDAO(), eReferenceDescriptor, query);

		query.sourceFragment(eObjectDescriptor.getFragment()).sourceResource(resourceDescriptor).referenceName(
				ECROSS_REFERENCE_NAME);
		genericQuerySingleResultTest(indexStore.eReferenceDAO(), eReferenceDescriptor, query);

		query = indexStore.eReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.sourceFragment(EOBJECT_FRAGMENT);
		genericQuerySingleResultTest(indexStore.eReferenceDAO(), eReferenceDescriptor, query);

		query = indexStore.eReferenceDAO().createQuery().targetFragment(eObjectDescriptor.getFragment())
				.targetResource(resourceDescriptor);
		genericQuerySingleResultTest(indexStore.eReferenceDAO(), eReferenceDescriptor, query);

		query.targetFragment(eObjectDescriptor.getFragment()).targetResource(resourceDescriptor).referenceName(
				ECROSS_REFERENCE_NAME);
		genericQuerySingleResultTest(indexStore.eReferenceDAO(), eReferenceDescriptor, query);

		query = indexStore.eReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.targetFragment(EOBJECT_FRAGMENT);
		genericQuerySingleResultTest(indexStore.eReferenceDAO(), eReferenceDescriptor, query);

	}

	public void testNonGenericQueries() {
		IGenericQuery<EReferenceDescriptor> query = indexStore.eReferenceDAO()
				.createQueryEReferencesFrom(eObjectDescriptor.getFragmentURI());
		genericQuerySingleResultTest(indexStore.eReferenceDAO(), eReferenceDescriptor, query);

		query = indexStore.eReferenceDAO().createQueryEReferencesTo(eObjectDescriptor.getFragmentURI());
		genericQuerySingleResultTest(indexStore.eReferenceDAO(), eReferenceDescriptor, query);

		query = indexStore.eReferenceDAO().createQueryEReferencesTo(eObject);
		genericQuerySingleResultTest(indexStore.eReferenceDAO(), eReferenceDescriptor, query);
	}

}
