/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SerializationTest extends AbstractXtextTests {
	
	private EPackage pack;
	private EFactory factory;
	private EClass compositeModelClass;
	private EClass modelClass;
	private EStructuralFeature valueFeature;
	private EStructuralFeature idFeature;
	private EStructuralFeature modelFeature;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(DatatypeRulesTestLanguageStandaloneSetup.class);
		pack = DatatypeRulesTestLanguagePackage.eINSTANCE;
		factory = pack.getEFactoryInstance();
		compositeModelClass = (EClass) pack.getEClassifier("CompositeModel");
		modelClass = (EClass) pack.getEClassifier("Model");
		modelFeature = compositeModelClass.getEStructuralFeature("model");
		idFeature = modelClass.getEStructuralFeature("id");
		valueFeature = modelClass.getEStructuralFeature("value");
	}
	
	@SuppressWarnings("unchecked")
	@Test public void testSerializeSimple() {
		EObject compositeModel = factory.create(compositeModelClass);
		EObject firstModel = factory.create(modelClass);
		((List<EObject>) compositeModel.eGet(modelFeature)).add(firstModel);
		firstModel.eSet(idFeature, "a.b.c.d");
		String s = serialize(compositeModel);
		assertEquals("a.b.c.d ;", s);
	}
	
	@SuppressWarnings("unchecked")
	@Test public void testSerializeTwoModels() {
		EObject compositeModel = factory.create(compositeModelClass);
		EObject firstModel = factory.create(modelClass);
		((List<EObject>) compositeModel.eGet(modelFeature)).add(firstModel);
		firstModel.eSet(idFeature, "a.b.c.d");
		EObject secondModel = factory.create(modelClass);
		((List<EObject>) compositeModel.eGet(modelFeature)).add(secondModel);
		secondModel.eSet(idFeature, "e.f.g.h");
		String s = serialize(compositeModel);
		assertEquals("a.b.c.d ; e.f.g.h ;", s);
	}
	
	@SuppressWarnings("unchecked")
	@Test public void testSerializeFracton() {
		EObject compositeModel = factory.create(compositeModelClass);
		EObject firstModel = factory.create(modelClass);
		((List<EObject>) compositeModel.eGet(modelFeature)).add(firstModel);
		firstModel.eSet(idFeature, "a.b.c.d");
		firstModel.eSet(valueFeature, new BigDecimal("0.75"));
		String s = serialize(compositeModel);
		assertEquals("a.b.c.d : 75/100 ;", s);
	}

}
