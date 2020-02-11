/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultResourceDescriptionTest extends Assert {

	private DefaultResourceDescription description;
	private EPackage pack;
	private EClass eClass;
	private EDataType dtype;
	private Resource resource;
	private IQualifiedNameProvider nameProvider;
	private DefaultResourceDescriptionStrategy strategy;

	@Before
	public void setUp() throws Exception {
		resource = new XMLResourceImpl();
		resource.setURI(URI.createURI("foo:/test"));
		nameProvider = new IQualifiedNameProvider.AbstractImpl() {
			@Override
			public QualifiedName getFullyQualifiedName(EObject obj) {
				if (obj instanceof ENamedElement)
					return QualifiedName.create(((ENamedElement) obj).getName());
				return null;
			}
		};
		strategy = new DefaultResourceDescriptionStrategy();
		strategy.setQualifiedNameProvider(nameProvider);
		description = new DefaultResourceDescription(resource, strategy);
		EcoreFactory f = EcoreFactory.eINSTANCE;
		pack = f.createEPackage();
		pack.setName("MyPackage");
		eClass = f.createEClass();
		eClass.setName("MyEClass");
		dtype = f.createEDataType();
		dtype.setName("MyDatatype");
		pack.getEClassifiers().add(eClass);
		pack.getEClassifiers().add(dtype);
		resource.getContents().add(pack);

	}

	@Test public void testGetExportedObject_1() throws Exception {
		strategy.setQualifiedNameProvider(new IQualifiedNameProvider.AbstractImpl() {
			@Override
			public QualifiedName getFullyQualifiedName(EObject obj) {
				if (obj instanceof EPackage)
					return QualifiedName.create(((EPackage) obj).getName());
				return null;
			}
		});

		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(1, list.size());
		assertEquals(pack.getName(), list.get(0).getName().toString());
		assertEquals(pack, list.get(0).getEObjectOrProxy());
	}

	@Test public void testGetExportedObject_2() throws Exception {
		strategy.setQualifiedNameProvider(new IQualifiedNameProvider.AbstractImpl() {
			@Override
			public QualifiedName getFullyQualifiedName(EObject obj) {
				if (obj instanceof EClassifier)
					return QualifiedName.create(((EClassifier) obj).getName());
				return null;
			}
		});

		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(2, list.size());
		assertEquals(eClass.getName(), list.get(0).getName().toString());
		assertEquals(eClass, list.get(0).getEObjectOrProxy());
		assertEquals(dtype.getName(), list.get(1).getName().toString());
		assertEquals(dtype, list.get(1).getEObjectOrProxy());
	}

	@Test public void testGetExportedObject_3() throws Exception {
		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(3, list.size());
		assertEquals(pack.getName(), list.get(0).getName().toString());
		assertEquals(pack, list.get(0).getEObjectOrProxy());
		assertEquals(eClass.getName(), list.get(1).getName().toString());
		assertEquals(eClass, list.get(1).getEObjectOrProxy());
		assertEquals(dtype.getName(), list.get(2).getName().toString());
		assertEquals(dtype, list.get(2).getEObjectOrProxy());
	}

	@Test public void testGetExportedEObjects_EClass_String() throws Exception {
		assertContains(description.getExportedObjects(pack.eClass(), QualifiedName.create(pack.getName()), false), pack);
		assertContains(description.getExportedObjects(pack.eClass(), QualifiedName.create("foo"), false));
		assertContains(description.getExportedObjects(eClass.eClass(), QualifiedName.create("foo"), false));
	}
	
	@Test public void testGetExportedEObjectsIgnoreCase() throws Exception {
		assertContains(description.getExportedObjects(pack.eClass(), QualifiedName.create(pack.getName().toUpperCase()), true), pack);
		assertContains(description.getExportedObjects(pack.eClass(), QualifiedName.create("foo").toUpperCase(),true));
		assertContains(description.getExportedObjects(eClass.eClass(), QualifiedName.create("foo").toUpperCase(),true));
	}
	
	@Test public void testGetExportedEObjects_EClass() throws Exception {
		assertContains(description.getExportedObjectsByType(EcorePackage.Literals.EPACKAGE),pack);
		assertContains(description.getExportedObjectsByType(EcorePackage.Literals.ECLASSIFIER),eClass,dtype);
		assertContains(description.getExportedObjectsByType(EcorePackage.Literals.ECLASS),eClass);
		assertContains(description.getExportedObjectsByType(EcorePackage.Literals.EDATA_TYPE),dtype);
		assertContains(description.getExportedObjectsByType(EcorePackage.Literals.EATTRIBUTE));
	}
	
	@Test public void testGetExportedEObjectsForEObject() throws Exception {
		assertContains(description.getExportedObjectsByObject(pack), pack);
		assertContains(description.getExportedObjectsByObject(eClass),eClass);
		assertContains(description.getExportedObjectsByObject(dtype),dtype);
		assertContains(description.getExportedObjectsByObject(EcoreFactory.eINSTANCE.createEAttribute()));
	}

	private void assertContains(Iterable<IEObjectDescription> exportedObjects, EObject ...expectedContents) {
		Collection<IEObjectDescription> collection = Lists.newArrayList(exportedObjects);
		for (EObject obj : expectedContents) {
			boolean found = false;
			for (IEObjectDescription ieObjectDescription : collection) {
				found = found || ieObjectDescription.getEObjectOrProxy()==obj;
			}
			assertTrue(obj+" wasn't contained",found);
		}
		assertEquals(collection.size(),expectedContents.length);
	}

}
