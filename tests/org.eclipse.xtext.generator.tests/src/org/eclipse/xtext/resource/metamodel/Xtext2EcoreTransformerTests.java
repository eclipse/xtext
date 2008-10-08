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

import org.easymock.EasyMock;
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
import org.eclipse.xtext.util.EmfFormater;

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
		List<EPackage> metamodels = getEPackagesFromGrammar(xtextGrammar);
		assertEquals(1, metamodels.size());

		EPackage result = metamodels.get(0);
		assertNotNull(result);
		return result;
	}

	private List<EPackage> getEPackagesFromGrammar(String xtextGrammar) throws Exception {
		Grammar grammar = (Grammar) getModel(xtextGrammar);
		replay(errorAcceptorMock);
		xtext2EcoreTransformer.setErrorAcceptor(errorAcceptorMock);
		List<EPackage> metamodels = xtext2EcoreTransformer.transform(grammar);
		verify(errorAcceptorMock);

		assertNotNull(metamodels);
		return metamodels;
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
			String featureTypeName, boolean isContainment, int lowerBound, int upperBound) {
		EReference reference = eClass.getEReferences().get(referenceIndex);
		assertEquals(featureName, reference.getName());
		assertNotNull(reference.getEType());
		assertEquals(featureTypeName, reference.getEType().getName());
		assertEquals(isContainment, reference.isContainment());
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
		assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
		assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
		assertEquals(2, ruleC.getEAttributes().size());
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
		assertAttributeConfiguration(ruleC, 1, "featureC2", "EString");
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
		String grammar = "language test generate test 'http://test'";
		grammar += " RuleA: ((RuleB|RuleC featureC1=ID)? featureBC=ID | (RuleC|RuleD featureD1=ID) featureCD=ID) featureA=ID;";
		grammar += " RuleB: featureB2=ID;";
		grammar += " RuleC: featureC2=ID;";
		grammar += " RuleD: featureD2=ID;";
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
		assertEquals(3, ruleC.getEAttributes().size());
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
		assertAttributeConfiguration(ruleC, 1, "featureCD", "EString");
		assertAttributeConfiguration(ruleC, 2, "featureC2", "EString");
		assertEquals(3, ruleD.getEAttributes().size());
		assertAttributeConfiguration(ruleD, 0, "featureD1", "EString");
		assertAttributeConfiguration(ruleD, 1, "featureCD", "EString");
		assertAttributeConfiguration(ruleD, 2, "featureD2", "EString");
	}

	public void testFeaturesAndInheritanceOfActions01() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: ({Add.a=current} '+'|{Sub.a=current} '-') featureAS=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(3, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass add = (EClass) ePackage.getEClassifier("Add");
		assertNotNull(add);
		EClass sub = (EClass) ePackage.getEClassifier("Sub");
		assertNotNull(sub);

		// test inheritance
		assertTrue(ruleA.getESuperTypes().isEmpty());
		assertEquals(1, add.getESuperTypes().size());
		assertEquals(ruleA, add.getESuperTypes().get(0));
		assertEquals(1, sub.getESuperTypes().size());
		assertEquals(ruleA, sub.getESuperTypes().get(0));

		// test features
		assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureAS", "EString");
		assertEquals(1, ruleA.getEReferences().size());
		assertReferenceConfiguration(ruleA, 0, "a", "RuleA", true, 0, 1);
		
		assertEquals(0, add.getEAttributes().size());
		assertEquals(0, add.getEReferences().size());

		assertEquals(0, sub.getEAttributes().size());
		assertEquals(0, sub.getEReferences().size());
	}

	public void testFeaturesAndInheritanceOfActions02() throws Exception {
		String grammar = "";
		grammar += "language org.eclipse.xtext.testlanguages.ActionTestLanguage ";
		grammar += "generate ActionLang";
		grammar += " 'http://www.eclipse.org/2008/tmf/xtext/ActionLang'";
		grammar += "";
		grammar += " Model:";
		grammar += " (children+=Element)*;";
		grammar += "";
		grammar += " Element returns Type:";
		grammar += " Item ( { Item.items+=current } items+=Item );";
		grammar += "";
		grammar += " Item returns Type:";
		grammar += " { Thing.content=current } name=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(4, ePackage.getEClassifiers().size());

		EClass model = (EClass) ePackage.getEClassifier("Model");
		assertNotNull(model);
		EClass type = (EClass) ePackage.getEClassifier("Type");
		assertNotNull(type);
		EClass item = (EClass) ePackage.getEClassifier("Item");
		assertNotNull(item);
		EClass thing = (EClass) ePackage.getEClassifier("Thing");
		assertNotNull(thing);

		// type hierarchy
		assertEquals(0, model.getESuperTypes().size());
		assertEquals(0, type.getESuperTypes().size());
		assertEquals(1, item.getESuperTypes().size());
		assertSame(type, item.getESuperTypes().get(0));
		assertEquals(1, thing.getESuperTypes().size());
		assertSame(type, thing.getESuperTypes().get(0));
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
		assertReferenceConfiguration(ruleA, 0, "callA1", "RuleB", true, 0, 1);
		assertReferenceConfiguration(ruleA, 1, "callA2", "RuleB", true, 0, -1);
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
		assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", false, 0, 1);
		assertReferenceConfiguration(ruleA, 1, "refA2", "TypeB", false, 0, -1);
		assertEquals(1, typeB.getEAttributes().size());
		assertAttributeConfiguration(typeB, 0, "featureB", "EString");
	}

	public void testAssignedParenthesizedElement() throws Exception {
		String grammar = " language test generate test 'http://test'";
		grammar += " RuleA: featureA1?=(RuleB) refA1=(RuleB) refA2=(RuleB|RuleC) refA3+=(RuleB|RuleC|RuleD) refA4=(RuleB|RuleD) featureA2+=('a'|'b');";
		grammar += " RuleB returns TypeB: RuleC? featureB=ID;";
		grammar += " RuleC: featureC=ID;";
		grammar += " RuleD returns TypeB: featureD=ID;";
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
		assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", true, 0, 1);
		assertReferenceConfiguration(ruleA, 1, "refA2", "TypeB", true, 0, 1);
		assertReferenceConfiguration(ruleA, 2, "refA3", "TypeB", true, 0, -1);
		assertReferenceConfiguration(ruleA, 3, "refA4", "TypeB", true, 0, 1);
	}

	public void testAssignedKeyWord() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: featureA?=('+'|'-') featureB=('*'|'/');";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(1, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");

		assertEquals(2, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertAttributeConfiguration(ruleA, 1, "featureB", "EString", 0, 1);
	}

	public void testImportWithoutAlias() throws Exception {
		final String grammar = "language test generate test 'http://test' import 'http://www.eclipse.org/emf/2002/Ecore' RuleA: feature=ID;";
		errorAcceptorMock.acceptError(same(ErrorCode.AliasForMetamodelAlreadyExists), (String) anyObject(),
				(EObject) anyObject());
		getEPackageFromGrammar(grammar);
	}

	public void testGenerateTwoModels() throws Exception {
		String grammar = "";
		grammar += " language test";
		grammar += " generate t1 'http://t1'";
		grammar += " generate t2 'http://t2' as t2";
		grammar += " RuleA: featureA=ID;";
		grammar += " RuleB returns t2::TypeB: featureB=ID;";
		List<EPackage> ePackages = getEPackagesFromGrammar(grammar);
		assertEquals(2, ePackages.size());

		EPackage t1 = ePackages.get(0);
		assertEquals("t1", t1.getName());

		assertEquals(1, t1.getEClassifiers().size());
		EClassifier ruleA = t1.getEClassifier("RuleA");
		assertNotNull(ruleA);

		EPackage t2 = ePackages.get(1);
		assertEquals(1, t2.getEClassifiers().size());
		assertEquals("t2", t2.getName());
		EClassifier typeB = t2.getEClassifier("TypeB");
		assertNotNull(typeB);
	}

	public void testUseSameModelAlias() throws Exception {
		String grammar = "";
		grammar += " language test";
		grammar += " generate t1 'http://t1' as target";
		grammar += " generate t2 'http://t2' as target";
		grammar += " RuleA: featureA=ID;"; // no alias => cannot be created
		grammar += " RuleB returns target::TypeB: featureB=ID;";

		errorAcceptorMock.acceptError(same(ErrorCode.AliasForMetamodelAlreadyExists), (String) anyObject(),
				(EObject) anyObject());
		errorAcceptorMock.acceptError(same(ErrorCode.CannotCreateTypeInSealedMetamodel), (String) anyObject(),
				(EObject) anyObject());
		errorAcceptorMock.acceptError(same(ErrorCode.NoSuchTypeAvailable), (String) anyObject(), (EObject) anyObject());

		List<EPackage> ePackages = getEPackagesFromGrammar(grammar);
		assertEquals(1, ePackages.size());
		EPackage t1 = ePackages.get(0);
		assertEquals("t1", t1.getName());
		assertEquals(1, t1.getEClassifiers().size());
		EClassifier ruleA = t1.getEClassifier("TypeB");
		assertNotNull(ruleA);
	}

	public void testModifyingSealedModel() throws Exception {
		final String grammar = "language test generate test 'http://test' import 'http://www.eclipse.org/emf/2002/Ecore' as ecore RuleA returns ecore::SomeNewTypeA: feature=ID;";
		errorAcceptorMock.acceptError(same(ErrorCode.CannotCreateTypeInSealedMetamodel), (String) anyObject(),
				(EObject) anyObject());
		errorAcceptorMock.acceptError(same(ErrorCode.NoSuchTypeAvailable), (String) anyObject(), (EObject) anyObject());
		getEPackageFromGrammar(grammar);
	}

	public void testImportingUnknownModel() throws Exception {
		final String grammar = "language test generate test 'http://test' import 'http://www.unknownModel' as unknownModel RuleA: feature=ID;";
		errorAcceptorMock.acceptError(same(ErrorCode.CannotLoadMetamodel), (String) anyObject(), (EObject) anyObject());
		getEPackageFromGrammar(grammar);
	}

	public void testMoreThanOneRuleCall() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: RuleB RuleC; RuleB: featureB=ID; RuleC: featureC=ID;";
		errorAcceptorMock.acceptError(same(ErrorCode.MoreThanOneTypeChangeInOneRule), (String) anyObject(),
				(EObject) anyObject());
		getEPackageFromGrammar(grammar);
	}

	public void testRuleCallAndAction() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: RuleB {TypeC.B = current}; RuleB: featureB=ID;";
		getEPackageFromGrammar(grammar);
	}

	public void testRuleCallActionAndRuleCall() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA: RuleB {TypeC.B = current} RuleB; RuleB: featureB=ID;";
		errorAcceptorMock.acceptError(same(ErrorCode.MoreThanOneTypeChangeInOneRule), (String) anyObject(),
				(EObject) anyObject());
		getEPackageFromGrammar(grammar);
	}

	public void testAddingFeatureTwice() throws Exception {
		final String grammar = "language test generate test 'http://test' RuleA returns TypeA: featureA=ID; RuleB returns TypeA: featureA=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(1, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) ePackage.getEClassifier("TypeA");
		assertNotNull(typeA);

		assertEquals(1, typeA.getEAttributes().size());
		assertAttributeConfiguration(typeA, 0, "featureA", "EString");
	}

	public void testAddingDifferentFeaturesWithSameName01() throws Exception {
		// simple datatypes do not have a common compatible type
		final String grammar = "" + " language test generate test 'http://test'" + " RuleA returns TypeA: featureA=ID;"
				+ " RuleB returns TypeA: featureA=INT;";

		errorAcceptorMock.acceptError(same(ErrorCode.NoCompatibleFeatureTypeAvailable), (String) anyObject(),
				(EObject) anyObject());
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(1, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) ePackage.getEClassifier("TypeA");
		assertNotNull(typeA);

		assertEquals(1, typeA.getEAttributes().size());
		assertAttributeConfiguration(typeA, 0, "featureA", "EString");
	}

	public void testAddingDifferentFeaturesWithSameName02() throws Exception {
		String grammar = "language test generate test 'http://test'";
		grammar += " RuleA returns TypeA: featureA=RuleD;";
		grammar += " RuleB returns TypeA: featureA=RuleC;";
		grammar += " RuleC: RuleD;";
		grammar += " RuleD: featureD=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);

		assertEquals(3, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) ePackage.getEClassifier("TypeA");
		assertNotNull(typeA);
		EClass ruleC = (EClass) ePackage.getEClassifier("RuleC");
		assertNotNull(ruleC);
		EClass ruleD = (EClass) ePackage.getEClassifier("RuleD");
		assertNotNull(ruleD);

		assertEquals(1, typeA.getEReferences().size());
		assertReferenceConfiguration(typeA, 0, "featureA", "RuleC", true, 0, 1);
	}

	public void testAddingDifferentFeaturesWithSameName03() throws Exception {
		// independent rules are combined as EObject
		String grammar = "language test generate test 'http://test'";
		grammar += " RuleA returns TypeA: featureA1=ID featureA2=RuleD featureA3=RuleC;";
		grammar += " RuleB returns TypeA: featureA2=RuleC featureA4=INT;";
		grammar += " RuleC: featureC=INT;";
		grammar += " RuleD: featureD=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);

		assertEquals(3, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) ePackage.getEClassifier("TypeA");
		assertNotNull(typeA);
		EClass ruleC = (EClass) ePackage.getEClassifier("RuleC");
		assertNotNull(ruleC);
		EClass ruleD = (EClass) ePackage.getEClassifier("RuleD");
		assertNotNull(ruleD);

		assertEquals(2, typeA.getEAllAttributes().size());
		assertAttributeConfiguration(typeA, 0, "featureA1", "EString");
		assertAttributeConfiguration(typeA, 1, "featureA4", "EInt");

		assertEquals(2, typeA.getEReferences().size());
		assertReferenceConfiguration(typeA, 0, "featureA2", "EObject", true, 0, 1);
		assertReferenceConfiguration(typeA, 1, "featureA3", "RuleC", true, 0, 1);
	}
	
	public void testUplift01() throws Exception {
		String grammar = "language test generate test 'http://test'";
		grammar += " RuleA: (RuleB|RuleC) featureA=ID;";
		grammar += " RuleB: featureB=INT;";
		grammar += " RuleC: (featureA=ID)?;";
		EPackage ePackage = getEPackageFromGrammar(grammar);

		assertEquals(3, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		EClass ruleB = (EClass) ePackage.getEClassifier("RuleB");
		assertNotNull(ruleB);
		EClass ruleC = (EClass) ePackage.getEClassifier("RuleC");
		assertNotNull(ruleC);

		assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
		
		assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB", "EInt");

		assertEquals(0, ruleC.getEAttributes().size());
	}
	
	public void testCallOfUndeclaredRule() throws Exception {
		String grammar = "language test generate test 'http://test'";
		grammar += " RuleA: CallOfUndeclaredRule featureA=ID;";
		
		errorAcceptorMock.acceptError(same(ErrorCode.NoSuchRuleAvailable), (String) anyObject(),
				(EObject) anyObject());

		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(1, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
	}
	
	public void testCycleInTypeHierarchy() throws Exception {
		String grammar = "language test generate test 'http://test'";
		grammar += " RuleA: RuleB;";
		grammar += " RuleB: RuleC;";
		grammar += " RuleC: RuleA;";
		grammar += " RuleD: RuleA;";
		
		errorAcceptorMock.acceptError(same(ErrorCode.TypeWithCycleInHierarchy), (String) anyObject(),
				(EObject) anyObject());
		EasyMock.expectLastCall().times(3);
		
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
		
		assertEquals(2, ruleA.getESuperTypes().size());
		assertSame(ruleC, ruleA.getESuperTypes().get(0));
		assertSame(ruleD, ruleA.getESuperTypes().get(1));
		assertEquals(1, ruleB.getESuperTypes().size());
		assertSame(ruleA, ruleB.getESuperTypes().get(0));
		assertEquals(1, ruleC.getESuperTypes().size());
		assertSame(ruleB, ruleC.getESuperTypes().get(0));
		assertEquals(0, ruleD.getESuperTypes().size());
	}
	
	public void testExpressionLikeLangauge() throws Exception {
		String grammar = "language test generate test 'http://test'";
		grammar += " Ex :	Atom  ({ChainExpression.left+=current} operator=('+'|'-'|'*'|'/') right=Atom )*;" +
				"Atom returns Ex :   Number |  '(' Ex ')';" +
				"Number : value=INT";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass classifier = (EClass) ePackage.getEClassifier("Ex");
		System.out.println(EmfFormater.objToStr(ePackage, ""));
		assertEquals(0,classifier.getEStructuralFeatures().size());
	}
}
