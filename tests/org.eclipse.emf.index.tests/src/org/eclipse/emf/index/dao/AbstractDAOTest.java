/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao;

import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IDAO;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.event.IndexChangeListener;
import org.eclipse.emf.index.mocks.MockDescriptors;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractDAOTest extends TestCase implements MockDescriptors {
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

	protected EPackageDescriptor.DAO createEPackageDAO() {
		return null;
	}

	protected EClassDescriptor.DAO createEClassDAO() {
		return null;
	}

	protected ResourceDescriptor.DAO createResourceDAO() {
		return null;
	}

	protected EObjectDescriptor.DAO createEObjectDAO() {
		return null;
	}

	protected ECrossReferenceDescriptor.DAO createECrossReferenceDAO() {
		return null;
	}

	protected IIndexStore indexStore;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		indexStore = new IIndexStore() {

			protected EPackageDescriptor.DAO ePackageDAO;

			protected EClassDescriptor.DAO eClassDAO;

			protected ResourceDescriptor.DAO resourceDAO;

			protected EObjectDescriptor.DAO eObjectDAO;

			protected ECrossReferenceDescriptor.DAO eCrossReferenceDAO;

			public EPackageDescriptor.DAO ePackageDAO() {
				if (ePackageDAO == null) {
					ePackageDAO = createEPackageDAO();
				}
				return ePackageDAO;
			}

			public EClassDescriptor.DAO eClassDAO() {
				if (eClassDAO == null) {
					eClassDAO = createEClassDAO();
				}
				return eClassDAO;
			}

			public ResourceDescriptor.DAO resourceDAO() {
				if (resourceDAO == null) {
					resourceDAO = createResourceDAO();
				}
				return resourceDAO;
			}

			public EObjectDescriptor.DAO eObjectDAO() {
				if (eObjectDAO == null) {
					eObjectDAO = createEObjectDAO();
				}
				return eObjectDAO;
			}

			public ECrossReferenceDescriptor.DAO eCrossReferenceDAO() {
				if (eCrossReferenceDAO == null) {
					eCrossReferenceDAO = createECrossReferenceDAO();
				}
				return eCrossReferenceDAO;
			}

			public void addIndexChangeListener(IndexChangeListener listener) {
			}

			public void beginTransaction() {
			}

			public void endTransaction() {
			}

			public void removeIndexChangeListener(IndexChangeListener listener) {
			}

			public void fireIndexChangedEvent(IndexChangeEvent event) {
			}

		};
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
