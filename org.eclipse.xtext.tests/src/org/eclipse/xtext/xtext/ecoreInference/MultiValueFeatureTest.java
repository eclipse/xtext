/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguagePackage;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MultiValueFeatureTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(MultiValueFeatureTestLanguageStandaloneSetup.class);
	}

	@Test public void testMetamodel() {
		EPackage generated = MultiValueFeatureTestLanguagePackage.eINSTANCE;
		assertEquals("multiValueFeatureTestLanguage", generated.getName());
		EClass clazz = (EClass) generated.getEClassifier("Start");
		assertNotNull(clazz);
		EStructuralFeature feature = clazz.getEStructuralFeature("featureA");
		assertNotNull(feature);
		assertTrue(feature.isMany());
		assertFalse(feature.isUnique());
	}

	@SuppressWarnings("unchecked")
	@Test public void testModel() throws Exception {
		String model = "idA idB idA";
		EObject parsedModel = getModel(model);
		List<String> values = (List<String>) parsedModel.eGet(parsedModel.eClass().getEStructuralFeature("featureA"));
		assertEquals(3, values.size());
		assertEquals("idA", values.get(0));
		assertEquals("idB", values.get(1));
		assertEquals("idA", values.get(2));
	}

}
