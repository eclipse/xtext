/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.xtext.ecoreInference.EClassifierInfo.EClassInfo;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EClassInfoTest extends TestCase {

	public void testContainsCompatibleFeature_01() throws Exception {
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
	
	public void testContainsCompatibleFeature_02() throws Exception {
		EcorePackage pack = EcorePackage.eINSTANCE;
		EClass attribute = pack.getEAttribute();
		EClassInfo objectUnderTest = new EClassifierInfo.EClassInfo(attribute, false, Collections.<String>emptySet(), null);
		assertEquals(true, objectUnderTest.containsCompatibleFeature("lowerBound", false, true, pack.getEInt(), new StringBuilder()));
		assertEquals(true, objectUnderTest.containsCompatibleFeature("lowerBound", false, true, pack.getEIntegerObject(), new StringBuilder()));
		assertEquals(false, objectUnderTest.containsCompatibleFeature("lowerBound", false, true, pack.getELong(), new StringBuilder()));
	}
}
