/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import static org.eclipse.xtext.scoping.Selectors.*;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

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

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultResourceDescriptionTest extends TestCase implements IQualifiedNameProvider {

	private DefaultResourceDescription description;
	private EPackage pack;
	private EClass eClass;
	private EDataType dtype;
	private Resource resource;
	private IQualifiedNameProvider delegate;

	@Override
	protected void setUp() throws Exception {
		resource = new XMLResourceImpl();
		resource.setURI(URI.createURI("foo:/test"));
		description = new DefaultResourceDescription(resource, this);
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

		delegate = new IQualifiedNameProvider.AbstractImpl() {
			public QualifiedName getFullyQualifiedName(EObject obj) {
				if (obj instanceof ENamedElement)
					return QualifiedName.create(((ENamedElement) obj).getName());
				return null;
			}
		};
	}

	public void testGetExportedObject_1() throws Exception {
		delegate = new IQualifiedNameProvider.AbstractImpl() {
			public QualifiedName getFullyQualifiedName(EObject obj) {
				if (obj instanceof EPackage)
					return QualifiedName.create(((EPackage) obj).getName());
				return null;
			}
		};

		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(1, list.size());
		assertEquals(pack.getName(), list.get(0).getName().toString());
		assertEquals(pack, list.get(0).getEObjectOrProxy());
	}

	public void testGetExportedObject_2() throws Exception {
		delegate = new IQualifiedNameProvider.AbstractImpl() {
			public QualifiedName getFullyQualifiedName(EObject obj) {
				if (obj instanceof EClassifier)
					return QualifiedName.create(((EClassifier) obj).getName());
				return null;
			}
		};

		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(2, list.size());
		assertEquals(eClass.getName(), list.get(0).getName().toString());
		assertEquals(eClass, list.get(0).getEObjectOrProxy());
		assertEquals(dtype.getName(), list.get(1).getName().toString());
		assertEquals(dtype, list.get(1).getEObjectOrProxy());
	}

	public void testGetExportedObject_3() throws Exception {
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

	public void testGetExportedEObjects_EClass_String() throws Exception {
		assertContains(description.getExportedObjects(selectByName(QualifiedName.create(pack.getName()),selectByType(pack.eClass()))), pack);
		assertContains(description.getExportedObjects(selectByName(QualifiedName.create("foo"),selectByType(pack.eClass()))));
		assertContains(description.getExportedObjects(selectByName(QualifiedName.create("foo"),selectByType(eClass.eClass()))));
	}
	
	public void testGetExportedEObjectsIgnoreCase() throws Exception {
		assertContains(description.getExportedObjects(selectByNameIgnoreCase(QualifiedName.create(pack.getName().toUpperCase()),selectByType(pack.eClass()))), pack);
		assertContains(description.getExportedObjects(selectByNameIgnoreCase(QualifiedName.create("foo").toUpperCase(),selectByType(pack.eClass()))));
		assertContains(description.getExportedObjects(selectByNameIgnoreCase(QualifiedName.create("foo").toUpperCase(),selectByType(eClass.eClass()))));
	}
	
	public void testGetExportedEObjects_EClass() throws Exception {
		assertContains(description.getExportedObjects(selectByType(EcorePackage.Literals.EPACKAGE)),pack);
		assertContains(description.getExportedObjects(selectByType(EcorePackage.Literals.ECLASSIFIER)),eClass,dtype);
		assertContains(description.getExportedObjects(selectByType(EcorePackage.Literals.ECLASS)),eClass);
		assertContains(description.getExportedObjects(selectByType(EcorePackage.Literals.EDATA_TYPE)),dtype);
		assertContains(description.getExportedObjects(selectByType(EcorePackage.Literals.EATTRIBUTE)));
	}
	
	public void testGetExportedEObjectsForEObject() throws Exception {
		assertContains(description.getExportedObjects(selectByEObject(pack)),pack);
		assertContains(description.getExportedObjects(selectByEObject(eClass)),eClass);
		assertContains(description.getExportedObjects(selectByEObject(dtype)),dtype);
		assertContains(description.getExportedObjects(selectByEObject(EcoreFactory.eINSTANCE.createEAttribute())));
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

	public QualifiedName getFullyQualifiedName(EObject obj) {
		return delegate.getFullyQualifiedName(obj);
	}

	public QualifiedName apply(EObject from) {
		return delegate.apply(from);
	}

}
