/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.AESCipherImpl;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class Xtext2EcoreTransformerTests extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	private EPackage getEPackageFromGrammar(String xtextGrammar)
			throws Exception {
		Grammar grammar = (Grammar) getModel(xtextGrammar);
		Xtext2EcoreTransformer xtext2EcoreTransformer = new Xtext2EcoreTransformer();
		List<EPackage> metamodels = xtext2EcoreTransformer.transform(grammar);
		assertNotNull(metamodels);
		assertEquals(1, metamodels.size());

		EPackage result = metamodels.get(0);
		assertNotNull(result);
		return result;
	}

	private EAttribute assertFeatureConfiguration(EClass eClass, int attributeIndex,
			String featureName, String featureTypeName) {
		EAttribute feature = eClass.getEAttributes().get(attributeIndex);
		assertEquals(featureName, feature.getName());
		assertNotNull(feature.getEType());
		assertEquals(featureTypeName, feature.getEType().getName());
		
		return feature;
	}
	
	private EAttribute assertFeatureConfiguration(EClass eClass, int attributeIndex,
			String featureName, String featureTypeName, int lowerBound, int upperBound) {
		EAttribute feature = assertFeatureConfiguration(eClass, attributeIndex, featureName, featureTypeName);
		assertEquals(lowerBound, feature.getLowerBound());
		assertEquals(upperBound, feature.getUpperBound());
		
		return feature;
	}

	public void testTypesOfImplicitSuperGrammar() throws Exception {
		final String xtextGrammar = "language test generate test 'http://test' MyRule: myFeature=INT;";
		Grammar grammar = (Grammar) getModel(xtextGrammar);
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer();
		transformer.transform(grammar);
		// directly from grammar
		assertNotNull(transformer.getEClassifierInfos().getInfo("MyRule"));
		// ecore data types
		assertNotNull(transformer.getEClassifierInfos().getInfo("ecore::EString"));
		assertNotNull(transformer.getEClassifierInfos().getInfo("ecore::EInt"));
	}

	public void testRuleWithoutExplicitReturnType() throws Exception {
		final String grammar = "language test generate test 'http://test' MyRule: myFeature=INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		assertEquals(1, classifiers.size());
		EClassifier implicitlyDefinedMetatype = classifiers.get(0);
		assertEquals("MyRule", implicitlyDefinedMetatype.getName());
	}

	public void testRulesWithExplicitReturnType() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA returns TypeA: featureA=INT; RuleB returns TypeB: featureB= INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(2, ePackage.getEClassifiers().size());
		assertNotNull(ePackage.getEClassifier("TypeA"));
		assertNotNull(ePackage.getEClassifier("TypeB"));
	}

	public void testSimpleHierarchy() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: RuleB; RuleB: featureB= INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass ruleB = (EClass) ePackage.getEClassifier("RuleB");
		assertNotNull(ruleB);
		assertTrue(ruleA.getESuperTypes().isEmpty());
		assertEquals(1, ruleB.getESuperTypes().size());
		EClass superClass = ruleB.getESuperTypes().get(0);
		assertEquals(ruleA, superClass);
	}

	public void testSingleFeatures() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: featureA=INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);

		assertEquals(1, ruleA.getEAttributes().size());
		assertFeatureConfiguration(ruleA, 0, "featureA", "EInt");
	}

	public void testBuiltInFeatureTypes() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: featureA=ID featureB=INT featureC=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);

		assertEquals(3, ruleA.getEAttributes().size());
		assertFeatureConfiguration(ruleA, 0, "featureA", "EString");
		assertFeatureConfiguration(ruleA, 1, "featureB", "EInt");
		assertFeatureConfiguration(ruleA, 2, "featureC", "EString");
	}

	public void testCardinalityOfFeatures() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: featureA?=ID featureB=INT featureC+=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);

		assertEquals(3, ruleA.getEAttributes().size());
		assertFeatureConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertFeatureConfiguration(ruleA, 1, "featureB", "EInt", 0, 1);
		assertFeatureConfiguration(ruleA, 2, "featureC", "EString", 0, -1);
	}

	public void testOptionalAssignmentsInGroup() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: (featureA?='abstract' featureB+=INT)?;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(1, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		assertEquals(2, ruleA.getEAttributes().size());
		assertFeatureConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertFeatureConfiguration(ruleA, 1, "featureB", "EInt", 0, -1);
	}

	public void testFeatureAndInheritanceOptionalRuleCall() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: RuleB? featureA=INT; RuleB: featureB=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass ruleB = (EClass) ePackage.getEClassifier("RuleB");
		assertNotNull(ruleB);
		
		assertEquals(1, ruleA.getEAttributes().size());
		assertFeatureConfiguration(ruleA, 0, "featureA", "EInt");
		
		assertEquals(1, ruleB.getEAttributes().size());
		assertFeatureConfiguration(ruleB, 0, "featureB", "EString");
	}

	public void testFeatureAndInheritanceMandatoryRuleCall() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: RuleB featureA=INT; RuleB: featureB=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass ruleB = (EClass) ePackage.getEClassifier("RuleB");
		assertNotNull(ruleB);
		
		assertEquals(0, ruleA.getEAttributes().size());
		
		assertEquals(2, ruleB.getEAttributes().size());
		assertFeatureConfiguration(ruleB, 0, "featureA", "EInt");
		assertFeatureConfiguration(ruleB, 1, "featureB", "EString");
	}

}
