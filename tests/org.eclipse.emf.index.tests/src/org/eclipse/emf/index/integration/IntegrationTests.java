/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.integration;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

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
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ECrossReferenceDescriptor.Query;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.impl.memory.InMemoryIndex;
import org.eclipse.emf.index.resource.EmfResourceChangeListenerRegistry;
import org.eclipse.emf.index.resource.impl.DefaultEmfResourceChangeListenerImpl;
import org.eclipse.emf.index.resource.impl.IndexBuilderImpl;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IntegrationTests extends TestCase {

	private static final String TEST_MODEL = "org/eclipse/emf/index/integration/domainmodel.ecore";

	protected IIndexStore index;

	protected EcoreIndexFeeder ecoreFeeder;

	protected ResourceSet resourceSet;

	private IndexBuilderImpl indexBuilder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		index = new InMemoryIndex();
		ecoreFeeder = new EcoreIndexFeederImpl(index);
		indexBuilder = new IndexBuilderImpl(index);
		resourceSet = new ResourceSetImpl();
		EmfResourceChangeListenerRegistry.INSTANCE
				.registerListener("ecore", new DefaultEmfResourceChangeListenerImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
	}

	public void testIntegration() throws Exception {
		ecoreFeeder.index(EcorePackage.eINSTANCE, true);
		indexExampleResource();
		Iterable<EObjectDescriptor> elementResult = index.eObjectDAO().createQuery().name("Entity")
				.executeListResult();
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
		Iterable<EClassDescriptor> typeResult = index.eClassDAO().createQuery().name(
				"EClass").executeListResult();
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

		Query crossRefQuery = index.eCrossReferenceDAO().createQuery();
		crossRefQuery.target().name("Feature");
		Iterable<ECrossReferenceDescriptor> crossRefDescriptors = crossRefQuery
				.executeListResult();
		assertNotNull(crossRefDescriptors);
		assertTrue(crossRefDescriptors.iterator().hasNext());
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
		URI uri = URI.createFileURI("src/" + TEST_MODEL);
		indexBuilder.resourceChanged(uri);
	}
}
