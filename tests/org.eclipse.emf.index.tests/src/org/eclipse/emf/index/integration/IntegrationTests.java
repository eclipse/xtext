/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.integration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IIndexFeeder;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ECrossReferenceDescriptor.Query;
import org.eclipse.emf.index.impl.IndexFeederImpl;
import org.eclipse.emf.index.impl.memory.InMemoryIndex;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IntegrationTests extends TestCase {

	private static final String TEST_MODEL = "org/eclipse/emf/index/integration/domainmodel.ecore";

	protected IIndexStore index;

	protected IIndexFeeder feeder;

	protected ResourceSet resourceSet;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		index = new InMemoryIndex();
		feeder = new IndexFeederImpl(index);
		resourceSet = new ResourceSetImpl();
	}

	public void testIntegration() throws Exception {
		feeder.index(EcorePackage.eINSTANCE, true);
		indexExampleResource();
		Collection<EObjectDescriptor> elementResult = index.eObjectDAO().createQuery().name("Entity")
				.executeListResult();
		assertNotNull(elementResult);
		assertEquals(1, elementResult.size());
		EObjectDescriptor elementDescriptor = elementResult.iterator().next();
		EObject entityClass = resourceSet.getEObject(elementDescriptor.getFragmentURI(), false);
		assertNotNull(entityClass);
		assertTrue(entityClass instanceof EClass);
		assertEquals("Entity", ((EClass) entityClass).getName());

		EClassDescriptor typeDescriptor = elementDescriptor.getEClassDescriptor();
		assertNotNull(typeDescriptor);
		Collection<org.eclipse.emf.index.EClassDescriptor> typeResult = index.eClassDAO().createQuery().name("EClass")
				.executeListResult();
		assertNotNull(typeResult);
		assertEquals(1, typeResult.size());
		EClassDescriptor typeDescriptor0 = typeResult.iterator().next();
		assertEquals(typeDescriptor, typeDescriptor0);
		EClassDescriptor[] superClasses = typeDescriptor0.getSuperClasses();
		assertNotNull(superClasses);
		// four super classes: EClassifier, ENamedElement, EModelElement and EObject
		assertEquals(4, superClasses.length);
		

		Query crossRefQuery = index.eCrossReferenceDAO().createQuery();
		crossRefQuery.target().name("Feature");
		Collection<org.eclipse.emf.index.ECrossReferenceDescriptor> crossRefDescriptors = crossRefQuery
				.executeListResult();
		assertNotNull(crossRefDescriptors);
		assertTrue(crossRefDescriptors.size() > 0);
		for (ECrossReferenceDescriptor crossRefDescriptor : crossRefDescriptors) {
			EObject source = resourceSet.getEObject(crossRefDescriptor.getSource().getFragmentURI(), false);
			assertNotNull(source);
			EObject target = resourceSet.getEObject(crossRefDescriptor.getTarget().getFragmentURI(), false);
			EStructuralFeature structuralFeature = source.eClass().getEStructuralFeature(
					crossRefDescriptor.getReferenceName());
			assertTrue(structuralFeature instanceof EReference);
			if (structuralFeature.isMany()) {
				assertTrue(((List<?>) source.eGet(structuralFeature)).contains(target));
			}
			else {
				assertEquals(target, source.eGet(structuralFeature));
			}
		}
	}

	private void indexExampleResource() throws IOException {
		URI uri = URI.createFileURI("/" + TEST_MODEL);
		XMIResourceImpl resource = new XMIResourceImpl();
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(
				TEST_MODEL);
		resource.load(resourceAsStream, null);
		resource.setURI(uri);
		resourceSet.getResources().add(resource);
		feeder.index(resource, true);
	}
}
