/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.ResourceSetBasedContainer;
import org.eclipse.xtext.scoping.namespaces.DefaultDeclarativeQualifiedNameProvider;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionsBasedContainerTest extends TestCase implements IResourceDescriptions, IResourceDescription.Manager.Registry {

	private ResourceSet resourceSet;
	private DefaultResourceDescriptionManager resourceDescriptionManager;
	private IContainer container;
	private Resource resource;
	private EClass eClass;
	private ResourceSetBasedContainer delegatingContainer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		resource = new EcoreResourceFactoryImpl().createResource(URI.createURI("test://uri.ecore"));
		resourceSet.getResources().add(resource);
		eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("SomeName");
		resource.getContents().add(eClass);
		IQualifiedNameProvider qualifiedNameProvider = new DefaultDeclarativeQualifiedNameProvider();
		resourceDescriptionManager = new DefaultResourceDescriptionManager();
		resourceDescriptionManager.setNameProvider(qualifiedNameProvider);
		delegatingContainer = new ResourceSetBasedContainer(resourceSet, this);
		container = new ResourceDescriptionsBasedContainer(this);
	}
	
	public void testFindAllEObjectsByType_01() {
		Iterable<IEObjectDescription> iterable = container.findAllEObjects(EcorePackage.Literals.ECLASSIFIER);
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
	}
	
	public void testFindAllEObjectsByType_02() {
		delegatingContainer = null;
		Iterable<IEObjectDescription> iterable = container.findAllEObjects(EcorePackage.Literals.ECLASSIFIER);
		assertTrue(Iterables.isEmpty(iterable));
	}
	
	public void testFindAllEObjectsByName_01() {
		Iterable<IEObjectDescription> iterable = container.findAllEObjects(EcorePackage.Literals.ECLASSIFIER, "SomeName");
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
	}
	
	public void testFindAllEObjectsByName_02() {
		delegatingContainer = null;
		Iterable<IEObjectDescription> iterable = container.findAllEObjects(EcorePackage.Literals.ECLASSIFIER, "SomeName");
		assertTrue(Iterables.isEmpty(iterable));
	}
//	
//	public void testFindDescriptionByEObject_01() {
//		Iterable<IEObjectDescription> iterable = indexFacade.findAllDescriptionsFor(eClass);
//		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
//		assertSame(eClass, eObject);
//		assertEquals(0, invocationCount);
//	}
//	
//	public void testFindDescriptionByEObject_02() {
//		returnedDescription = new EmptyResourceDescription(); // cannot shadow the actual resource of the eobject itself
//		Iterable<IEObjectDescription> iterable = container.findAllDescriptionsFor(eClass);
//		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
//		assertSame(eClass, eObject);
//		assertEquals(0, invocationCount);
//	}

	public IResourceDescription.Manager getResourceDescriptionManager(URI uri, String contentType) {
		return resourceDescriptionManager;
	}

	public void addListener(Listener listener) {
		fail("Unexpected");
	}
	
	public void removeListener(Listener listener) {
		fail("Unexpected");
	}
	
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		if (delegatingContainer != null)
			return delegatingContainer.getResourceDescriptions();
		return Collections.emptyList();
	}
	
	public IResourceDescription getResourceDescription(URI uri) {
//		return delegatingContainer.getResourceDescription(uri);
		fail("Unexpected");
		return null;
	}
}
