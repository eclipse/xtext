/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import static org.eclipse.xtext.scoping.Selectors.*;

import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionsBasedContainerTest extends TestCase implements IResourceDescriptions {

	private static final QualifiedName SOME_NAME = QualifiedName.create("SomeName");
	private ResourceDescriptionsBasedContainer container;
	private EClass eClass;
	private URI uri;
	private ResourceDescription resourceDescription;
	
	private class ResourceDescription implements IResourceDescription {

		public Iterable<IEObjectDescription> getExportedObjects() {
			if (eClass != null)
				return Collections.singleton(EObjectDescription.create(QualifiedName.create(eClass.getName()), eClass));
			return Collections.emptyList();
		}
		public Iterable<IEObjectDescription> getExportedObjects(ISelector selector) {
			if (eClass != null)
				return selector.applySelector(getExportedObjects());
			return Collections.emptyList();
		}

		public Iterable<QualifiedName> getImportedNames() {
			fail("unexpected");
			return null;
		}

		public URI getURI() {
			return uri;
		}

		public Iterable<IReferenceDescription> getReferenceDescriptions() {
			return Collections.emptyList();
		}
		
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("SomeName");
		resourceDescription = new ResourceDescription();
		container = new ResourceDescriptionsBasedContainer(this);
	}
	
	public void testFindAllEObjectsByType_01() {
		Iterable<IEObjectDescription> iterable = container.getElements(selectByType(EcorePackage.Literals.ECLASSIFIER));
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
	}
	
	public void testFindAllEObjectsByType_02() {
		eClass = null;
		Iterable<IEObjectDescription> iterable = container.getElements(selectByType(EcorePackage.Literals.ECLASSIFIER));
		assertTrue(Iterables.isEmpty(iterable));
	}
	
	public void testFindAllEObjectsByName_01() {
		Iterable<IEObjectDescription> iterable = container.getElements(selectByTypeAndName(EcorePackage.Literals.ECLASSIFIER, SOME_NAME));
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
	}
	
	public void testFindAllEObjectsByName_02() {
		eClass = null;
		Iterable<IEObjectDescription> iterable = container.getElements(selectByTypeAndName(EcorePackage.Literals.ECLASSIFIER, SOME_NAME));
		assertTrue(Iterables.isEmpty(iterable));
	}
	
	public void testFindAllEObjectsByNameIgnoreCase_01() {
		Iterable<IEObjectDescription> iterable = container.getElements(selectByTypeAndNameIgnoreCase(EcorePackage.Literals.ECLASSIFIER, SOME_NAME.toUpperCase()));
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
	}
	
	public void testFindAllEObjectsByNameIgnoreCase_02() {
		Iterable<IEObjectDescription> iterable = container.getElements(selectByTypeAndNameIgnoreCase(EcorePackage.Literals.ECLASSIFIER, SOME_NAME.toLowerCase()));
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
	}
	
	public void testFindAllEObjectsByNameIgnoreCase_03() {
		eClass = null;
		Iterable<IEObjectDescription> iterable = container.getElements(selectByTypeAndNameIgnoreCase(EcorePackage.Literals.ECLASSIFIER, SOME_NAME));
		assertTrue(Iterables.isEmpty(iterable));
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Collections.<IResourceDescription>singletonList(resourceDescription);
	}
	
	public IResourceDescription getResourceDescription(URI uri) {
		if (uri == this.uri)
			return resourceDescription;
		return null;
	}
	
}
