/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IQualifiedNameProvider;

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
	}

	public void testGetExportedObject_1() throws Exception {
		delegate = new IQualifiedNameProvider.AbstractImpl() {
			public String getQualifiedName(EObject obj) {
				if (obj instanceof EPackage)
					return ((EPackage)obj).getName();
				return null;
			}
		};
				
		
		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(1, list.size());
		assertEquals(pack.getName(),list.get(0).getName());
		assertEquals(pack,list.get(0).getEObjectOrProxy());
	}
	
	public void testGetExportedObject_2() throws Exception {
		delegate = new IQualifiedNameProvider.AbstractImpl() {
			public String getQualifiedName(EObject obj) {
				if (obj instanceof EClassifier)
					return ((EClassifier)obj).getName();
				return null;
			}
		};
		
		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(2, list.size());
		assertEquals(eClass.getName(),list.get(0).getName());
		assertEquals(eClass,list.get(0).getEObjectOrProxy());
		assertEquals(dtype.getName(),list.get(1).getName());
		assertEquals(dtype,list.get(1).getEObjectOrProxy());
	}
	
	public void testGetExportedObject_3() throws Exception {
		delegate = new IQualifiedNameProvider.AbstractImpl() {
			public String getQualifiedName(EObject obj) {
				if (obj instanceof ENamedElement)
					return ((ENamedElement)obj).getName();
				return null;
			}
		};
		
		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(3, list.size());
		assertEquals(pack.getName(),list.get(0).getName());
		assertEquals(pack,list.get(0).getEObjectOrProxy());
		assertEquals(eClass.getName(),list.get(1).getName());
		assertEquals(eClass,list.get(1).getEObjectOrProxy());
		assertEquals(dtype.getName(),list.get(2).getName());
		assertEquals(dtype,list.get(2).getEObjectOrProxy());
	}

	public String getQualifiedName(EObject obj) {
		return delegate.getQualifiedName(obj);
	}

	public String apply(EObject from) {
		return delegate.apply(from);
	}

}
