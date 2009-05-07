/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IPersistableIndexStore;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.EReferenceDescriptor.Query;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.guice.AbstractEmfIndexTest;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.ResourceIndexer;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;
import org.eclipse.emf.index.util.CollectionUtils;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IntegrationTests extends AbstractEmfIndexTest {

	private static final String TEST_MODEL = "org/eclipse/emf/index/integration/domainmodel.ecore";

	@Inject
	protected Provider<IndexStore> indexStoreProvider;

	protected IPersistableIndexStore index;
	
	protected EcoreIndexFeeder ecoreFeeder;

	protected ResourceSet resourceSet;

	protected IndexFeeder feeder;
	
	@Inject
	private ResourceIndexer resourceIndexer;

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		index = (IPersistableIndexStore) indexStoreProvider.get();
		ecoreFeeder = new EcoreIndexFeederImpl(index);
		feeder = new IndexFeederImpl(index);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		resourceSet = new ResourceSetImpl();
	}

	public void testIntegration() throws Exception {
		ecoreFeeder.index(EcorePackage.eINSTANCE, true);
		indexExampleResource();
		checkIndexData();
	}

	public void testLoadSave() throws Exception {
		ecoreFeeder.index(EcorePackage.eINSTANCE, true);
		indexExampleResource();
		File testFile = File.createTempFile("test", "index");
		index.save(new FileOutputStream(testFile));
		index = (IPersistableIndexStore) indexStoreProvider.get();
		index.load(new FileInputStream(testFile));
		checkIndexData();		
	}
	
	private void checkIndexData() {
		Iterable<EObjectDescriptor> elementResult = index.eObjectDAO().createQuery().name("Entity").executeListResult();
		assertNotNull(elementResult);
		Iterator<EObjectDescriptor> eObjectIterator = elementResult.iterator();
		EObjectDescriptor elementDescriptor = eObjectIterator.next();
		assertFalse(eObjectIterator.hasNext());
		EObject entityClass = resourceSet.getEObject(elementDescriptor.getFragmentURI(), true);
		assertNotNull(entityClass);
		assertTrue(entityClass instanceof EClass);
		assertEquals("Entity", ((EClass) entityClass).getName());

		EClassDescriptor typeDescriptor = elementDescriptor.getEClassDescriptor();
		assertNotNull(typeDescriptor);
		Iterable<EClassDescriptor> typeResult = index.eClassDAO().createQuery().name("EClass").executeListResult();
		assertNotNull(typeResult);
		Iterator<EClassDescriptor> eClassIterator = typeResult.iterator();
		EClassDescriptor typeDescriptor0 = eClassIterator.next();
		assertFalse(eClassIterator.hasNext());
		assertEquals(typeDescriptor, typeDescriptor0);
		EClassDescriptor[] superClasses = typeDescriptor0.getSuperClasses();
		assertNotNull(superClasses);
		// four super classes: EClassifier, ENamedElement, EModelElement and
		// EObject
		assertEquals(4, superClasses.length);

		Query eReferenceQuery = index.eReferenceDAO().createQuery();
		eReferenceQuery.targetFragment("//Feature");
		Iterable<EReferenceDescriptor> eReferenceDescriptors = eReferenceQuery.executeListResult();
		assertNotNull(eReferenceDescriptors);
		assertTrue(eReferenceDescriptors.iterator().hasNext());
		for (EReferenceDescriptor eReferenceDescriptor : eReferenceDescriptors) {
			EObject source = resourceSet.getEObject(eReferenceDescriptor.getSourceURI(), false);
			assertNotNull(source);
			EObject target = resourceSet.getEObject(eReferenceDescriptor.getTargetURI(), false);
			EStructuralFeature structuralFeature = source.eClass().getEStructuralFeature(
					eReferenceDescriptor.getReferenceName());
			assertTrue(structuralFeature instanceof EReference);
			if (structuralFeature.isMany()) {
				assertTrue(((List<?>) source.eGet(structuralFeature)).contains(target));
			}
			else {
				assertEquals(target, source.eGet(structuralFeature));
			}
		}

		org.eclipse.emf.index.EObjectDescriptor.Query objectQuery = index.eObjectDAO().createQuery();
		objectQuery.eClass().name("EClassifier").ePackage().nsURI(EcorePackage.eNS_URI);
		assertEquals(15, CollectionUtils.toList(objectQuery.executeListResult()).size());

		objectQuery = index.eObjectDAO().createQuery();
		objectQuery.eClass(index.eClassDAO().createQueryEClass(EcorePackage.eINSTANCE.getEClassifier()).executeSingleResult());
		assertEquals(15, CollectionUtils.toList(objectQuery.executeListResult()).size());
	}

	private void indexExampleResource() throws IOException {
		URI uri = URI.createFileURI("src/" + TEST_MODEL);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		resourceIndexer.resourceChanged(resource, feeder);
	}
}
