/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MetamodelTest extends Assert {
	
	@Before
	public void setUp() throws Exception {
		DatatypeRulesTestLanguageStandaloneSetup.doSetup();
	}
	
	@Test public void testDerivedPackage() {
		EPackage pack = DatatypeRulesTestLanguagePackage.eINSTANCE;
		assertNotNull(pack);
		assertEquals(2, pack.getEClassifiers().size());
	}

	@Test public void testDerivedModel() {
		EPackage pack = DatatypeRulesTestLanguagePackage.eINSTANCE;
		EClass model = (EClass) pack.getEClassifier("Model");
		assertNotNull(model);
		EStructuralFeature feature = model.getEStructuralFeature("id");
		assertNotNull(feature);
		assertEquals(EcorePackage.Literals.ESTRING, feature.getEType());
		feature = model.getEStructuralFeature("value");
		assertNotNull(feature);
		assertEquals(EcorePackage.Literals.EBIG_DECIMAL, feature.getEType());
		feature = model.getEStructuralFeature("vector");
		assertNotNull(feature);
		assertEquals(EcorePackage.Literals.ESTRING, feature.getEType());
		feature = model.getEStructuralFeature("dots");
		assertNotNull(feature);
		assertEquals(EcorePackage.Literals.ESTRING, feature.getEType());
	}
	
	@Test public void testDerivedCompositeModel() {
		EPackage pack = DatatypeRulesTestLanguagePackage.eINSTANCE;
		EClass model = (EClass) pack.getEClassifier("CompositeModel");
		assertNotNull(model);
		EStructuralFeature feature = model.getEStructuralFeature("model");
		assertEquals("Model", feature.getEType().getName());
		assertTrue(feature.isMany());
	}
	
}
