/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.index.IDAO;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.guice.AbstractEmfIndexTest;
import org.eclipse.emf.index.mocks.MockDescriptors;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractDAOTest extends AbstractEmfIndexTest implements MockDescriptors {
	
	public static final EPackage ePackage;
	public static final EClass eClass;
	public static final Resource resource;
	public static final EObject eObject;
	public static final EReference eReference;

	static {
		ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(EPACKAGE_NAME);
		ePackage.setNsURI(EPACKAGE_NS_URI);

		eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(ECLASS_NAME);
		ePackage.getEClassifiers().add(eClass);

		eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setName(ECROSS_REFERENCE_NAME);
		eReference.setEType(eClass);
		eClass.getEStructuralFeatures().add(eReference);

		resource = new ResourceImpl();
		resource.setURI(URI.createURI(RESOURCE_URI));

		eObject = ePackage.getEFactoryInstance().create(eClass);
		eObject.eSet(eReference, eObject);
		resource.getContents().add(eObject);
	}

	@Inject
	protected IndexStore indexStore;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected <T> void assertResultIs(T descriptor, IGenericQuery<T> query) {
		Iterable<T> result = query.executeListResult();
		assertNotNull(result);
		Iterator<T> iterator = result.iterator();
		assertEquals(descriptor, iterator.next());
		assertFalse(iterator.hasNext());
	}

	protected <T> void assertContains(T descriptor, IGenericQuery<T> query) {
		Iterable<T> result = query.executeListResult();
		assertNotNull(result);
		for(Iterator<T> iterator = result.iterator(); iterator.hasNext();) {
			if(descriptor.equals(iterator.next())) {
				return;
			}
		}
		fail("Descriptor not in result");
	}

	protected <T> void assertEmptyResult(IGenericQuery<T> query) {
		Iterable<T> result = query.executeListResult();
		assertTrue(result == null || !result.iterator().hasNext());
	}

	protected <T> void genericQuerySingleResultTest(IDAO<T> dao, T descriptor, IGenericQuery<T> query) {
		dao.store(descriptor);
		assertResultIs(descriptor, query);
		dao.delete(descriptor);
		assertEmptyResult(query);
	}

}
