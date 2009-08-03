/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import static org.eclipse.xtext.EcoreUtil2.*;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class EcoreUtil2Test extends TestCase {
	static private final EClass EOBJECT = EcorePackage.Literals.EOBJECT; 
	
	private EClass createEClass(String name) {
		EClass result = EcoreFactory.eINSTANCE.createEClass();
		result.setName(name);
		return result;
	}
	
	public void testClone() throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
		
		ResourceSetImpl rs = new ResourceSetImpl();
		Resource r1 = rs.createResource(URI.createURI("foo.xmi"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		Resource r2 = rs.createResource(URI.createURI("bar.xmi"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("a");
		EClass b = EcoreFactory.eINSTANCE.createEClass();
		r1.getContents().add(a);
		b.setName("b");
		b.getESuperTypes().add(a);
		r2.getContents().add(b);
		
		ResourceSetImpl clone = EcoreUtil2.clone(new ResourceSetImpl(), rs);
		EList<Resource> list = clone.getResources();
		
		Resource resA = list.get(0);
		assertEquals(URI.createURI("foo.xmi"),resA.getURI());
		assertNotSame(resA, r1);
		
		Resource resB = list.get(1);
		assertEquals(URI.createURI("bar.xmi"),resB.getURI());
		assertNotSame(resB, r2);
		
		EClass a1 = (EClass)resA.getContents().get(0);
		EClass b1 = (EClass)resB.getContents().get(0);
		assertEquals("a", a1.getName());
		assertNotSame(a, a1);
		assertEquals("b", b1.getName());
		assertNotSame(b, b1);
		assertSame(b1.getESuperTypes().get(0),a1);
		assertSame(b.getESuperTypes().get(0),a);
	}

	public void testCommonCompatibleType01() {
		EClass a = createEClass("a");
		EClass b = createEClass("b");
		EClass c = createEClass("c");
		EClass d = createEClass("d");
		EClass e = createEClass("e");
		EClass f = createEClass("f");

		c.getESuperTypes().add(a);
		d.getESuperTypes().add(c);
		d.getESuperTypes().add(b);
		e.getESuperTypes().add(c);
		f.getESuperTypes().add(a);
		f.getESuperTypes().add(b);
		f.getESuperTypes().add(e);

		assertSame(a, EcoreUtil2.getCompatibleType(a, a));
		assertSame(EOBJECT, EcoreUtil2.getCompatibleType(d, f));
		assertSame(c, EcoreUtil2.getCompatibleType(d, e));
		assertSame(b, EcoreUtil2.getCompatibleType(b, f));
		assertSame(EOBJECT, EcoreUtil2.getCompatibleType(b, c));
	}

	public void testCommonCompatibleType02() {
		EClass a = createEClass("a");
		EClass b = createEClass("b");
		EClass c = createEClass("c");
		EClass d = createEClass("d");
		EClass e = createEClass("e");

		b.getESuperTypes().add(a);
		c.getESuperTypes().add(a);
		d.getESuperTypes().add(b);
		d.getESuperTypes().add(c);
		e.getESuperTypes().add(b);
		e.getESuperTypes().add(c);

		assertSame(a, EcoreUtil2.getCompatibleType(a, a));

		assertSame(a, EcoreUtil2.getCompatibleType(b, c));
		assertSame(b, EcoreUtil2.getCompatibleType(b, d));
		assertSame(a, EcoreUtil2.getCompatibleType(d, e));
	}
	
	public void testGetAllSuperTypesWithCycle() {
		EClass a = createEClass("a");
		EClass b = createEClass("b");
		b.getESuperTypes().add(a);
		a.getESuperTypes().add(b);
		
		// inconsistent and quasi-unpredictable in complex scenarios due to caching
		assertTrue(a.getEAllSuperTypes().contains(a));
		assertFalse(b.getEAllSuperTypes().contains(b));
		
		// always stable
		assertTrue(EcoreUtil2.getAllSuperTypes(a).contains(a));
		assertTrue(EcoreUtil2.getAllSuperTypes(b).contains(b));
	}
	
	public void testGetAllReferencedObjects() {
		EClass a = createEClass("a");
		EClass b = createEClass("b");
		
		EPackage pack = EcoreFactory.eINSTANCE.createEPackage();
		pack.setName("empty");
		pack.setNsPrefix("empty");
		pack.setNsURI("empty");
		pack.getEClassifiers().add(a);
		pack.getEClassifiers().add(b);
		
		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		a.getEStructuralFeatures().add(ref);
		ref.setUpperBound(1);
		ref.setEType(b);
		EObject objA = pack.getEFactoryInstance().create(a);
		EObject objB = pack.getEFactoryInstance().create(b);
		List<EObject> res = EcoreUtil2.getAllReferencedObjects(objA, ref);
		assertNotNull(res);
		assertTrue(res.isEmpty());
		res = EcoreUtil2.getAllReferencedObjects(objA, ref);
		assertNotNull(res);
		objA.eSet(ref, objB);
	}
	
	public void testContainsCompatibleFeature() throws Exception {
		EcorePackage pack = EcorePackage.eINSTANCE;
		EClass eClass = pack.getEClass();
		assertEquals(true,containsCompatibleFeature(eClass, "name", false, pack.getEString()));
		assertEquals(false,containsCompatibleFeature(eClass, "name", true, pack.getEString()));
		assertEquals(false,containsCompatibleFeature(eClass, "name", true, pack.getEAnnotation()));
		assertEquals(false,containsCompatibleFeature(eClass, "name", true, pack.getEShort()));
		assertEquals(false,containsCompatibleFeature(eClass, "names", false, pack.getEString()));
		
		assertEquals(true,containsCompatibleFeature(eClass, "eStructuralFeatures", true, pack.getEAttribute()));
		assertEquals(true,containsCompatibleFeature(eClass, "eStructuralFeatures", true, pack.getEReference()));
		assertEquals(true,containsCompatibleFeature(eClass, "eStructuralFeatures", true, pack.getEStructuralFeature()));
		assertEquals(false,containsCompatibleFeature(eClass, "eStructuralFeatures", false, pack.getEStructuralFeature()));
		assertEquals(false,containsCompatibleFeature(eClass, "eStructuralFeatures", true, pack.getEAnnotation()));
		
		eClass = pack.getEAttribute();
		assertEquals(true, containsCompatibleFeature(eClass, "lowerBound", false, pack.getEInt()));
		assertEquals(true, containsCompatibleFeature(eClass, "lowerBound", false, pack.getEIntegerObject()));
		assertEquals(false, containsCompatibleFeature(eClass, "lowerBound", false, pack.getELong()));
	}
}
