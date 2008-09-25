/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.same;
import static org.easymock.EasyMock.verify;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.metamodel.ErrorAcceptor.ErrorCode;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * @see http://wiki.eclipse.org/Xtext/Documentation#Meta-Model_Inference
 */
public class Xtext2EcoreTransformerTests extends AbstractGeneratorTest {
	private Xtext2EcoreTransformer xtext2EcoreTransformer;
	private ErrorAcceptor errorAcceptorMock;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		xtext2EcoreTransformer = new Xtext2EcoreTransformer();
		errorAcceptorMock = createMock(ErrorAcceptor.class);
		with(XtextStandaloneSetup.class);
	}
	
	private EPackage getEPackageFromGrammar(String xtextGrammar) throws Exception {
		Grammar grammar = (Grammar) getModel(xtextGrammar);
		replay(errorAcceptorMock);
		xtext2EcoreTransformer.setErrorAcceptor(errorAcceptorMock);
		List<EPackage> metamodels = xtext2EcoreTransformer.transform(grammar);
		verify(errorAcceptorMock);
		
		assertNotNull(metamodels);
		assertEquals(1, metamodels.size());

		EPackage result = metamodels.get(0);
		assertNotNull(result);
		return result;
	}
	
	private EAttribute assertAttributeConfiguration(EClass eClass, int attributeIndex, String featureName,
			String featureTypeName) {
		EAttribute feature = eClass.getEAttributes().get(attributeIndex);
		assertEquals(featureName, feature.getName());
		assertNotNull(feature.getEType());
		assertEquals(featureTypeName, feature.getEType().getName());

		return feature;
	}

	private EAttribute assertAttributeConfiguration(EClass eClass, int attributeIndex, String featureName,
			String featureTypeName, int lowerBound, int upperBound) {
		EAttribute feature = assertAttributeConfiguration(eClass, attributeIndex, featureName, featureTypeName);
		assertEquals(lowerBound, feature.getLowerBound());
		assertEquals(upperBound, feature.getUpperBound());

		return feature;
	}
	
	private EReference assertReferenceConfiguration(EClass eClass, int referenceIndex, String featureName,
			String featureTypeName, int lowerBound, int upperBound) {
		EReference reference = eClass.getEReferences().get(referenceIndex);
		assertEquals(featureName, reference.getName());
		assertNotNull(reference.getEType());
		assertEquals(featureTypeName, reference.getEType().getName());
		assertEquals(lowerBound, reference.getLowerBound());
		assertEquals(upperBound, reference.getUpperBound());
		return reference;
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
		assertAttributeConfiguration(ruleA, 0, "featureA", "EInt");
	}

	public void testBuiltInFeatureTypes() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: featureA=ID featureB=INT featureC=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);

		assertEquals(3, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt");
		assertAttributeConfiguration(ruleA, 2, "featureC", "EString");
	}

	public void testCardinalityOfFeatures() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: featureA?=ID featureB=INT featureC+=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);

		assertEquals(3, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt", 0, 1);
		assertAttributeConfiguration(ruleA, 2, "featureC", "EString", 0, -1);
	}

	public void testOptionalAssignmentsInGroup() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: (featureA?='abstract' featureB+=INT)?;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(1, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		assertEquals(2, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt", 0, -1);
	}

	public void testFeaturesAndInheritanceOptionalRuleCall() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: RuleB? featureA=INT; RuleB: featureB=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass ruleB = (EClass) ePackage.getEClassifier("RuleB");
		assertNotNull(ruleB);

		assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EInt");

		assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
	}

	public void testFeaturesAndInheritanceMandatoryRuleCall() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: RuleB featureA=INT; RuleB: featureB=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass ruleB = (EClass) ePackage.getEClassifier("RuleB");
		assertNotNull(ruleB);

		assertEquals(0, ruleA.getEAttributes().size());

		assertEquals(2, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureA", "EInt");
		assertAttributeConfiguration(ruleB, 1, "featureB", "EString");
	}

	public void testFeaturesAndInheritanceOfMandatoryAlternativeRuleCalls() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: (RuleB|RuleC featureC1=ID) featureA=ID; RuleB: featureB=ID; RuleC: featureC2=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(3, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass ruleB = (EClass) ePackage.getEClassifier("RuleB");
		assertNotNull(ruleB);
		EClass ruleC = (EClass) ePackage.getEClassifier("RuleC");
		assertNotNull(ruleC);

		// test inheritance
		assertTrue(ruleA.getESuperTypes().isEmpty());
		assertEquals(1, ruleB.getESuperTypes().size());
		assertEquals(ruleA, ruleB.getESuperTypes().get(0));
		assertEquals(1, ruleC.getESuperTypes().size());
		assertEquals(ruleA, ruleC.getESuperTypes().get(0));

		// test all features are separated
		assertEquals(0, ruleA.getEAttributes().size());
		assertEquals(2, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureA", "EString");
		assertAttributeConfiguration(ruleB, 1, "featureB", "EString");
		assertEquals(3, ruleC.getEAttributes().size());
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
		assertAttributeConfiguration(ruleC, 1, "featureA", "EString");
		assertAttributeConfiguration(ruleC, 2, "featureC2", "EString");
	}

	public void testFeaturesAndInheritanceOfOptionalOptionalRuleCalls() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: (RuleB|RuleC featureC1=ID)? featureA=ID; RuleB: featureB=ID; RuleC: featureC2=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(3, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass ruleB = (EClass) ePackage.getEClassifier("RuleB");
		assertNotNull(ruleB);
		EClass ruleC = (EClass) ePackage.getEClassifier("RuleC");
		assertNotNull(ruleC);

		// test inheritance
		assertTrue(ruleA.getESuperTypes().isEmpty());
		assertEquals(1, ruleB.getESuperTypes().size());
		assertEquals(ruleA, ruleB.getESuperTypes().get(0));
		assertEquals(1, ruleC.getESuperTypes().size());
		assertEquals(ruleA, ruleC.getESuperTypes().get(0));

		// test all features are separated
		assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
		assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
		assertEquals(2, ruleC.getEAttributes().size());
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
		assertAttributeConfiguration(ruleC, 1, "featureC2", "EString");
	}

	public void testFeaturesAndInheritanceOfNestedRuleCalls() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: ((RuleB|RuleC featureC1=ID)? featureBC=ID | (RuleC|RuleD featureD1=ID) featureCD=ID) featureA=ID; RuleB: featureB2=ID; RuleC: featureC2=ID; RuleD: featureD2=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(4, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass ruleB = (EClass) ePackage.getEClassifier("RuleB");
		assertNotNull(ruleB);
		EClass ruleC = (EClass) ePackage.getEClassifier("RuleC");
		assertNotNull(ruleC);
		EClass ruleD = (EClass) ePackage.getEClassifier("RuleD");
		assertNotNull(ruleD);

		// test inheritance
		assertTrue(ruleA.getESuperTypes().isEmpty());
		assertEquals(1, ruleB.getESuperTypes().size());
		assertEquals(ruleA, ruleB.getESuperTypes().get(0));
		assertEquals(1, ruleC.getESuperTypes().size());
		assertEquals(ruleA, ruleC.getESuperTypes().get(0));
		assertEquals(1, ruleD.getESuperTypes().size());
		assertEquals(ruleA, ruleD.getESuperTypes().get(0));

		// test all features are separated
		assertEquals(2, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureBC", "EString");
		assertAttributeConfiguration(ruleA, 1, "featureA", "EString");
		assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB2", "EString");
		assertEquals(4, ruleC.getEAttributes().size());
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
		assertAttributeConfiguration(ruleC, 1, "featureCD", "EString");
		assertAttributeConfiguration(ruleC, 2, "featureA", "EString");
		assertAttributeConfiguration(ruleC, 3, "featureC2", "EString");
		assertEquals(4, ruleD.getEAttributes().size());
		assertAttributeConfiguration(ruleD, 0, "featureD1", "EString");
		assertAttributeConfiguration(ruleD, 1, "featureCD", "EString");
		assertAttributeConfiguration(ruleD, 2, "featureA", "EString");
		assertAttributeConfiguration(ruleD, 3, "featureD2", "EString");
	}

	public void testAssignedRuleCall() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: callA1=RuleB callA2+=RuleB simpleFeature=ID; RuleB: featureB=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass ruleB = (EClass) ePackage.getEClassifier("RuleB");
		assertNotNull(ruleB);
		
		assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "simpleFeature", "EString");
		assertEquals(2, ruleA.getEReferences().size());
		assertReferenceConfiguration(ruleA, 0, "callA1", "RuleB", 0, 1);
		assertReferenceConfiguration(ruleA, 1, "callA2", "RuleB", 0, -1);
		assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
	}

	public void testAssignedCrossReference() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: refA1=[TypeB] refA2+=[TypeB|RuleB] simpleFeature=ID; RuleB returns TypeB: featureB=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass typeB = (EClass) ePackage.getEClassifier("TypeB");
		assertNotNull(typeB);
		
		assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "simpleFeature", "EString");
		assertEquals(2, ruleA.getEReferences().size());
		assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", 0, 1);
		assertReferenceConfiguration(ruleA, 1, "refA2", "TypeB", 0, -1);
		assertEquals(1, typeB.getEAttributes().size());
		assertAttributeConfiguration(typeB, 0, "featureB", "EString");
	}

	public void testAssignedParenthesizedElement() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: featureA1?=(RuleB) refA1=(RuleB) refA2=(RuleB|RuleC) refA3+=(RuleB|RuleC|RuleD) refA4=(RuleB|RuleD) featureA2+=('a'|'b'); RuleB returns TypeB: RuleC? featureB=ID; RuleC: featureC=ID; RuleD returns TypeB: featureD=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(3, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		assertEquals(0, ruleA.getESuperTypes().size());
		EClass typeB = (EClass) ePackage.getEClassifier("TypeB");
		assertNotNull(typeB);
		assertEquals(0, typeB.getESuperTypes().size());
		EClass ruleC = (EClass) ePackage.getEClassifier("RuleC");
		assertNotNull(ruleC);
		assertEquals(1, ruleC.getESuperTypes().size());
		assertEquals(typeB, ruleC.getESuperTypes().get(0));
		
		assertEquals(2, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA1", "EBoolean");
		assertAttributeConfiguration(ruleA, 1, "featureA2", "EString", 0, -1);
		
		assertEquals(4, ruleA.getEReferences().size());
		assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", 0, 1);
		// TODO should be common compatible type according to #248430
		assertReferenceConfiguration(ruleA, 1, "refA2", "EObject", 0, 1);
		assertReferenceConfiguration(ruleA, 2, "refA3", "EObject", 0, -1);
		assertReferenceConfiguration(ruleA, 3, "refA4", "TypeB", 0, 1);
	}
	
	public void testImportWithoutAlias() throws Exception {
		final String grammar = "language test generate test 'http://test' import 'http://www.eclipse.org/emf/2002/Ecore' RuleA: feature=ID;";
		errorAcceptorMock.acceptError(same(ErrorCode.MissingAliasForReferencedMetamodel), (String)anyObject(), (EObject)anyObject());
		getEPackageFromGrammar(grammar);
	}
	
	public void testModifyingSealedModel() throws Exception {
		final String grammar = "language test generate test 'http://test' import 'http://www.eclipse.org/emf/2002/Ecore' as ecore RuleA returns ecore::SomeNewTypeA: feature=ID;";
		errorAcceptorMock.acceptError(same(ErrorCode.CannotCreateTypeInSealedMetamodel), (String)anyObject(), (EObject)anyObject());
		errorAcceptorMock.acceptError(same(ErrorCode.NoSuchTypeAvailable), (String)anyObject(), (EObject)anyObject());
		getEPackageFromGrammar(grammar);
	}
	
	public void testImportingUnknownModel() throws Exception {
		final String grammar = "language test generate test 'http://test' import 'http://www.unknownModel' as unknownModel RuleA: feature=ID;";
		errorAcceptorMock.acceptError(same(ErrorCode.CannotLoadMetamodel), (String)anyObject(), (EObject)anyObject());
		getEPackageFromGrammar(grammar);
	}
	
	public void testMoreThanOneRuleCall() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: RuleB RuleC; RuleB: featureB=ID; RuleC: featureC=ID;";
		errorAcceptorMock.acceptError(same(ErrorCode.MoreThanOneTypeChangeInOneRule), (String)anyObject(), (EObject)anyObject());
		getEPackageFromGrammar(grammar);
	}
}
