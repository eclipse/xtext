/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.index;

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
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.ResourceSetBasedContainer;
import org.eclipse.xtext.scoping.namespaces.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.ui.core.editor.IDirtyResource;
import org.eclipse.xtext.ui.core.editor.IDirtyStateManager;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DirtyStateAwareIndexFacadeTest extends TestCase implements IDirtyStateManager, IResourceDescription.Manager.Registry {

	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected class EmptyResourceDescription implements IResourceDescription {
		public Iterable<IEObjectDescription> getExportedObjects() {
			return Collections.emptyList();
		}

		public Iterable<IEObjectDescription> getExportedObjects(EClass clazz, String name) {
			return Collections.emptyList();
		}

		public Iterable<IEObjectDescription> getExportedObjects(EClass clazz) {
			return Collections.emptyList();
		}

		public Iterable<IEObjectDescription> getExportedObjectsForEObject(EObject object) {
			return Collections.emptyList();
		}

		public Iterable<String> getImportedNames() {
			return Collections.emptyList();
		}

		public URI getURI() {
			return resource.getURI();
		}
	}

	private ResourceSet resourceSet;
	private DefaultResourceDescriptionManager resourceDescriptionManager;
	private IContainer container;
	private DirtyStateAwareIndexFacade indexFacade;
	private Resource resource;
	private int invocationCount;
	private EClass eClass;
	private IResourceDescription returnedDescription;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		invocationCount = 0;
		resourceSet = new ResourceSetImpl();
		resource = new EcoreResourceFactoryImpl().createResource(URI.createURI("test://uri.ecore"));
		resourceSet.getResources().add(resource);
		eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("SomeName");
		resource.getContents().add(eClass);
		IQualifiedNameProvider qualifiedNameProvider = new DefaultDeclarativeQualifiedNameProvider();
		resourceDescriptionManager = new DefaultResourceDescriptionManager();
		resourceDescriptionManager.setNameProvider(qualifiedNameProvider);
		container = new ResourceSetBasedContainer(resourceSet, this);
		indexFacade = new DirtyStateAwareIndexFacade();
		indexFacade.setResourceDescriptionsManager(this);
		indexFacade.setDirtyStateManager(this);
	}
	
	public void testFindAllEObjectsByType_01() {
		Iterable<IEObjectDescription> iterable = indexFacade.findAllEObjects(container, EcorePackage.Literals.ECLASSIFIER);
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
		assertEquals(1, invocationCount);
	}
	
	public void testFindAllEObjectsByType_02() {
		returnedDescription = new EmptyResourceDescription();
		Iterable<IEObjectDescription> iterable = indexFacade.findAllEObjects(container, EcorePackage.Literals.ECLASSIFIER);
		assertTrue(Iterables.isEmpty(iterable));
		assertEquals(1, invocationCount);
	}
	
	public void testFindAllEObjectsByName_01() {
		Iterable<IEObjectDescription> iterable = indexFacade.findAllEObjects(container, EcorePackage.Literals.ECLASSIFIER, "SomeName");
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
		assertEquals(1, invocationCount);
	}
	
	public void testFindAllEObjectsByName_02() {
		returnedDescription = new EmptyResourceDescription();
		Iterable<IEObjectDescription> iterable = indexFacade.findAllEObjects(container, EcorePackage.Literals.ECLASSIFIER, "SomeName");
		assertTrue(Iterables.isEmpty(iterable));
		assertEquals(1, invocationCount);
	}
	
	public void testFindDescriptionByEObject_01() {
		Iterable<IEObjectDescription> iterable = indexFacade.findAllDescriptionsFor(eClass);
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
		assertEquals(0, invocationCount);
	}
	
	public void testFindDescriptionByEObject_02() {
		returnedDescription = new EmptyResourceDescription(); // cannot shadow the actual resource of the eobject itself
		Iterable<IEObjectDescription> iterable = indexFacade.findAllDescriptionsFor(eClass);
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
		assertEquals(0, invocationCount);
	}

	public void addListener(IDirtyStateListener listener) {
		fail("Unexpected");
	}

	public void announceDirtyStateChanged(IDirtyResource dirtyResource) {
		fail("Unexpected");
	}

	public void discardDirtyState(IDirtyResource dirtyResource) {
		fail("Unexpected");
	}

	public IResourceDescription getDirtyResourceDescription(URI uri) {
		assertEquals(resource.getURI(), uri);
		invocationCount++;
		return returnedDescription;
	}

	public boolean manageDirtyState(IDirtyResource dirtyResource) {
		fail("Unexpected");
		return false;
	}

	public void removeListener(IDirtyStateListener listener) {
		fail("Unexpected");
	}

	public String getContent(URI uri) {
		fail("Unexpected");
		return null;
	}

	public boolean hasContent(URI uri) {
		fail("Unexpected");
		return false;
	}

	public IResourceDescription.Manager getResourceDescriptionManager(URI uri, String contentType) {
		return resourceDescriptionManager;
	}

}
