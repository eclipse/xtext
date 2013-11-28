/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.ISelectable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionsBasedContainerTest extends Assert implements IResourceDescriptions {

	private static final QualifiedName SOME_NAME = QualifiedName.create("SomeName");
	protected ResourceDescriptionsBasedContainer container;
	protected EClass eClass;
	protected URI uri;
	protected ResourceDescription resourceDescription;
	protected ISelectable selectableDelegate;
	
	private class ResourceDescription extends AbstractResourceDescription {

		private URI uri;

		protected ResourceDescription(URI uri) {
			this.uri = uri;
		}
		
		@Override
		protected List<IEObjectDescription> computeExportedObjects() {
			if (eClass != null)
				return Collections.singletonList(EObjectDescription.create(QualifiedName.create(eClass.getName()), eClass));
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

	@Before
	public void setUp() throws Exception {
		eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("SomeName");
		uri = URI.createURI("myURI");
		((InternalEObject)eClass).eSetProxyURI(uri.appendFragment("SomeName"));
		resourceDescription = new ResourceDescription(uri);
		container = createContainer();
		selectableDelegate = new AbstractCompoundSelectable() {
			@Override
			protected Iterable<? extends ISelectable> getSelectables() {
				return getAllResourceDescriptions();
			}
		};
	}

	protected ResourceDescriptionsBasedContainer createContainer() {
		return new ResourceDescriptionsBasedContainer(this);
	}
	
	@Test public void testGetExportedObjectsByType_01() {
		EClass classifier = EcorePackage.Literals.ECLASSIFIER;
		Iterable<IEObjectDescription> iterable = container.getExportedObjectsByType(classifier);
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
	}
	
	@Test public void testGetExportedObjectsByType_02() {
		eClass = null;
		Iterable<IEObjectDescription> iterable = container.getExportedObjectsByType(EcorePackage.Literals.ECLASSIFIER);
		assertTrue(Iterables.isEmpty(iterable));
	}
	
	@Test public void testGetExportedObjects_01() {
		Iterable<IEObjectDescription> iterable = container.getExportedObjects(EcorePackage.Literals.ECLASSIFIER, SOME_NAME, false);
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
	}
	
	@Test public void testGetExportedObjects_02() {
		eClass = null;
		Iterable<IEObjectDescription> iterable = container.getExportedObjects(EcorePackage.Literals.ECLASSIFIER, SOME_NAME, false);
		assertTrue(Iterables.isEmpty(iterable));
	}
	
	@Test public void testGetExportedObjects_03() {
		Iterable<IEObjectDescription> iterable = container.getExportedObjects(EcorePackage.Literals.ECLASSIFIER, SOME_NAME.toUpperCase(), true);
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
	}
	
	@Test public void testGetExportedObjects_04() {
		Iterable<IEObjectDescription> iterable = container.getExportedObjects(EcorePackage.Literals.ECLASSIFIER, SOME_NAME.toLowerCase(), true);
		EObject eObject = Iterables.getOnlyElement(iterable).getEObjectOrProxy();
		assertSame(eClass, eObject);
	}
	
	@Test public void testGetExportedObjects_05() {
		eClass = null;
		Iterable<IEObjectDescription> iterable = container.getExportedObjects(EcorePackage.Literals.ECLASSIFIER, SOME_NAME, true);
		assertTrue(Iterables.isEmpty(iterable));
	}
	
	@Test public void testBug352214() {
		container.getResourceDescriptions(); // initialize uri map
		ResourceDescriptionChangeEvent event = new ResourceDescriptionChangeEvent(Collections.<IResourceDescription.Delta>singletonList(
				new ChangedResourceDescriptionDelta(resourceDescription, null)));
		container.descriptionsChanged(event);
		assertEquals(0, container.getResourceDescriptionCount());
		assertTrue(Iterables.all(container.getResourceDescriptions(), Predicates.notNull()));
		assertTrue(container.hasResourceDescription(uri)); // broken invariant in implementation
		assertNull(container.getResourceDescription(uri));
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Collections.<IResourceDescription>singletonList(resourceDescription);
	}
	
	public IResourceDescription getResourceDescription(URI uri) {
		if (uri == this.uri)
			return resourceDescription;
		return null;
	}

	public boolean isEmpty() {
		return false;
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		return selectableDelegate.getExportedObjects();
	}

	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		return selectableDelegate.getExportedObjects(type, name, ignoreCase);
	}

	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return selectableDelegate.getExportedObjectsByType(type);
	}

	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return selectableDelegate.getExportedObjectsByObject(object);
	}
	
}
