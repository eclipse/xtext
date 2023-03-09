/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.xtext.ecoreInference.EClassifierInfo.EClassInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EClassInfoTest extends Assert {

	@Test public void testContainsCompatibleFeature_01() throws Exception {
		EcorePackage pack = EcorePackage.eINSTANCE;
		EClass eClass = pack.getEClass();
		EClassInfo objectUnderTest = new EClassifierInfo.EClassInfo(eClass, false, Collections.<String>emptySet(), null);
		assertEquals(true,objectUnderTest.containsCompatibleFeature("name", false, true, pack.getEString(), new StringBuilder()));
		assertEquals(false,objectUnderTest.containsCompatibleFeature("name", true, true, pack.getEString(), new StringBuilder()));
		assertEquals(false,objectUnderTest.containsCompatibleFeature("name", true, true, pack.getEAnnotation(), new StringBuilder()));
		assertEquals(false,objectUnderTest.containsCompatibleFeature("name", true, true, pack.getEShort(), new StringBuilder()));
		assertEquals(false,objectUnderTest.containsCompatibleFeature("names", false, true, pack.getEString(), new StringBuilder()));
		
		assertEquals(true,objectUnderTest.containsCompatibleFeature("eStructuralFeatures", true, true, pack.getEAttribute(), new StringBuilder()));
		assertEquals(true,objectUnderTest.containsCompatibleFeature("eStructuralFeatures", true, true, pack.getEReference(), new StringBuilder()));
		assertEquals(true,objectUnderTest.containsCompatibleFeature("eStructuralFeatures", true, true, pack.getEStructuralFeature(), new StringBuilder()));
		assertEquals(false,objectUnderTest.containsCompatibleFeature("eStructuralFeatures", false, true, pack.getEStructuralFeature(), new StringBuilder()));
		assertEquals(false,objectUnderTest.containsCompatibleFeature("eStructuralFeatures", true, true, pack.getEAnnotation(), new StringBuilder()));
	}
	
	
	public void testChangeable(){
		EcorePackage pack = EcorePackage.eINSTANCE;
		EClass eClass = pack.getEClass();
		EClassInfo objectUnderTest = new EClassifierInfo.EClassInfo(eClass, false, Collections.<String>emptySet(), null);
		EcoreFactory fac = EcoreFactory.eINSTANCE;
		EReference reference = fac.createEReference();
		reference.setName("newReference");
		reference.setEType(eClass);
		reference.setChangeable(true);
		reference.setContainment(true);
		eClass.getEStructuralFeatures().add(reference);
		assertEquals(true,objectUnderTest.containsCompatibleFeature("newReference", false, true, eClass, new StringBuilder()));
		reference.setChangeable(false);
		assertEquals(false,objectUnderTest.containsCompatibleFeature("newReference", false, true, eClass, new StringBuilder()));
	}
		
	@Test public void testContainsCompatibleFeature_02() throws Exception {
		EcorePackage pack = EcorePackage.eINSTANCE;
		EClass attribute = pack.getEAttribute();
		EClassInfo objectUnderTest = new EClassifierInfo.EClassInfo(attribute, false, Collections.<String>emptySet(), null);
		assertEquals(true, objectUnderTest.containsCompatibleFeature("lowerBound", false, true, pack.getEInt(), new StringBuilder()));
		assertEquals(true, objectUnderTest.containsCompatibleFeature("lowerBound", false, true, pack.getEIntegerObject(), new StringBuilder()));
		assertEquals(false, objectUnderTest.containsCompatibleFeature("lowerBound", false, true, pack.getELong(), new StringBuilder()));
	}
}
