/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MetamodelTest extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		DatatypeRulesTestLanguageStandaloneSetup.doSetup();
	}
	
	public void testDerivedPackage() {
		EPackage pack = DatatypeRulesTestLanguagePackage.eINSTANCE;
		assertNotNull(pack);
		assertEquals(2, pack.getEClassifiers().size());
	}

	public void testDerivedModel() {
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
	
	public void testDerivedCompositeModel() {
		EPackage pack = DatatypeRulesTestLanguagePackage.eINSTANCE;
		EClass model = (EClass) pack.getEClassifier("CompositeModel");
		assertNotNull(model);
		EStructuralFeature feature = model.getEStructuralFeature("model");
		assertEquals("Model", feature.getEType().getName());
		assertTrue(feature.isMany());
	}
	
}
