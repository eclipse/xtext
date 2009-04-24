/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao;

import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractECrossReferenceDAOTest extends AbstractDAOTest {

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

	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract ECrossReferenceDescriptor.DAO createECrossReferenceDAO();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		indexStore.resourceDAO().store(resourceDescriptor);
		indexStore.ePackageDAO().store(ePackageDescriptor);
		indexStore.eClassDAO().store(eClassDescriptor);
		indexStore.eObjectDAO().store(eObjectDescriptor);
	}

	public void testGenericQueries() throws Exception {
		ECrossReferenceDescriptor.Query query = indexStore.eCrossReferenceDAO().createQuery().referenceName(
				ECROSS_REFERENCE_NAME);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().sourceFragment(eObjectDescriptor.getFragment())
				.sourceResource(resourceDescriptor);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query.sourceFragment(eObjectDescriptor.getFragment()).sourceResource(resourceDescriptor).referenceName(
				ECROSS_REFERENCE_NAME);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.sourceFragment(EOBJECT_FRAGMENT);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().targetFragment(eObjectDescriptor.getFragment())
				.targetResource(resourceDescriptor);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query.targetFragment(eObjectDescriptor.getFragment()).targetResource(resourceDescriptor).referenceName(
				ECROSS_REFERENCE_NAME);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.targetFragment(EOBJECT_FRAGMENT);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

	}

	public void testNonGenericQueries() {
		IGenericQuery<ECrossReferenceDescriptor> query = indexStore.eCrossReferenceDAO()
				.createQueryCrossReferencesFrom(eObjectDescriptor.getFragmentURI());
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQueryCrossReferencesTo(eObjectDescriptor.getFragmentURI());
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQueryCrossReferencesTo(eObject);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
	}

}
