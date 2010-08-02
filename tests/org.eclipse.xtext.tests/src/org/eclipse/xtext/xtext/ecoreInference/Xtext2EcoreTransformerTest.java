/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import static org.easymock.EasyMock.*;

import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xtext.XtextLinker;
import org.eclipse.xtext.xtext.XtextLinker.PackageRemover;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * @see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#metamodelInference
 */
public class Xtext2EcoreTransformerTest extends AbstractXtextTests {

	private ErrorAcceptor errorAcceptorMock;

	public static class MyErrorAcceptor implements ErrorAcceptor {

		private final ErrorAcceptor first;
		private final ErrorAcceptor second;

		public MyErrorAcceptor(ErrorAcceptor first, ErrorAcceptor second) {
			this.first = first;
			this.second = second;
		}

		public void acceptError(TransformationErrorCode errorCode, String message, EObject element) {
			first.acceptError(errorCode, message, element);
			second.acceptError(errorCode, message, element);
		}

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		errorAcceptorMock = createMock(ErrorAcceptor.class);
		with(XtextStandaloneSetup.class);
	}

	@Override
	protected void tearDown() throws Exception {
		errorAcceptorMock = null;
		super.tearDown();
	}

	private EPackage getEPackageFromGrammar(String xtextGrammar, int expectedErrors) throws Exception {
		List<EPackage> metamodels = getEPackagesFromGrammar(xtextGrammar, expectedErrors);
		assertEquals(1, metamodels.size());

		EPackage result = metamodels.get(0);
		assertNotNull(result);
		return result;
	}
	
	private EPackage getEPackageFromGrammar(String xtextGrammar) throws Exception {
		return getEPackageFromGrammar(xtextGrammar, 0);
	}

	@Override
	public XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		XtextResource resource = (XtextResource) getResourceFactory().createResource(uri);
		rs.getResources().add(resource);
		XtextLinker linker = new XtextLinker() {
			@Override
			protected Xtext2EcoreTransformer createTransformer(Grammar grammar, IDiagnosticConsumer consumer) {
				Xtext2EcoreTransformer result = super.createTransformer(grammar, consumer);
				result.setErrorAcceptor(new MyErrorAcceptor(result.getErrorAcceptor(), errorAcceptorMock));
				return result;
			}
		};
		linker.setScopeProvider(((XtextLinker) resource.getLinker()).getScopeProvider());
		linker.setLinkingService(((Linker) resource.getLinker()).getLinkingService());
		linker.setPackageRemover(new PackageRemover());
		linker.setDiagnosticMessageProvider(new LinkingDiagnosticMessageProvider());
		resource.setLinker(linker);
		resource.load(in, null);
		return resource;
	}

	private List<EPackage> getEPackagesFromGrammar(String xtextGrammar, int expectedErrors) throws Exception {
		replay(errorAcceptorMock);
		Grammar grammar = (Grammar) getModelAndExpect(xtextGrammar, expectedErrors);
		verify(errorAcceptorMock);
		List<EPackage> metamodels = Xtext2EcoreTransformer.doGetGeneratedPackages(grammar);
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
		final String xtextGrammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' MyRule: myFeature=INT;";
		Grammar grammar = (Grammar) getModel(xtextGrammar);
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
		transformer.removeGeneratedPackages();
		transformer.transform();
		// directly from grammar
		AbstractRule rule = grammar.getRules().get(0);
		TypeRef type = rule.getType();
		assertNotNull(type);
		assertNotNull(transformer.getEClassifierInfos().getInfo(type));
		// ecore data types
		ReferencedMetamodel referenced = (ReferencedMetamodel) GrammarUtil.allMetamodelDeclarations(grammar).get(1);
		assertNotNull(referenced);
		assertEquals("ecore", referenced.getAlias());
		assertNull(transformer.getEClassifierInfos().getInfo(referenced, "EString"));
		assertNull(transformer.getEClassifierInfos().getInfo(referenced, "EInt"));
		EClassifierInfos parentInfos = transformer.getEClassifierInfos().getParents().get(0);
		assertNotNull(parentInfos.getInfo(referenced, "EString"));
		assertNotNull(parentInfos.getInfo(referenced, "EInt"));
	}

	public void testRuleWithoutExplicitReturnType() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' MyRule: myFeature=INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		assertEquals(1, classifiers.size());
		EClassifier implicitlyDefinedMetatype = classifiers.get(0);
		assertEquals("MyRule", implicitlyDefinedMetatype.getName());
	}

	public void testRulesWithExplicitReturnType() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA returns TypeA: featureA=INT; RuleB returns TypeB: featureB= INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(2, ePackage.getEClassifiers().size());
		assertNotNull(ePackage.getEClassifier("TypeA"));
		assertNotNull(ePackage.getEClassifier("TypeB"));
	}

	public void testSimpleHierarchy() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: RuleB; RuleB: featureB= INT;";
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

	public void testDiamondHierarchy() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' " +
				"Model: name=ID value=SubNamed1 otherValue=SubNamed2 thirdValue=SubNamed3;" +
				"Named: SubNamed1 | SubNamed2 | SubNamed3;" +
				"SubNamed1: ConcreteNamed1 | ConcreteNamed2;" +
				"SubNamed2: ConcreteNamed2 | ConcreteNamed3;" +
				"SubNamed3: ConcreteNamed1 | ConcreteNamed3;" +
				"ConcreteNamed1: name=ID bar=ID foo=ID a=ID;" +
				"ConcreteNamed2: name=ID bar=ID zonk=ID b=ID;" +
				"ConcreteNamed3: name=ID foo=ID zonk=ID c=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(8, ePackage.getEClassifiers().size());
		EClassifier classifier = ePackage.getEClassifier("Named");
		assertNotNull(classifier);
		EClass named = (EClass) classifier;
		EStructuralFeature feature = named.getEStructuralFeature("name");
		assertNotNull("name", feature);
		assertEquals("named", 1, named.getEStructuralFeatures().size());

		EClass subNamed1 = (EClass) ePackage.getEClassifier("SubNamed1");
		assertNotNull("subNamed1", subNamed1);
		assertEquals(1, subNamed1.getESuperTypes().size());
		assertNotNull("bar", subNamed1.getEStructuralFeature("bar"));
		assertEquals("subNamed1", 1, subNamed1.getEStructuralFeatures().size());

		EClass subNamed2 = (EClass) ePackage.getEClassifier("SubNamed2");
		assertNotNull("subNamed2", subNamed2);
		assertEquals(1, subNamed2.getESuperTypes().size());
		assertNotNull("bar", subNamed2.getEStructuralFeature("zonk"));
		assertEquals("subNamed2", 1, subNamed2.getEStructuralFeatures().size());

		EClass subNamed3 = (EClass) ePackage.getEClassifier("SubNamed3");
		assertNotNull("subNamed3", subNamed3);
		assertEquals(1, subNamed3.getESuperTypes().size());
		assertNotNull("bar", subNamed3.getEStructuralFeature("foo"));
		assertEquals("subNamed3", 1, subNamed3.getEStructuralFeatures().size());

		EClass concreteNamed1 = (EClass) ePackage.getEClassifier("ConcreteNamed1");
		assertNotNull("concreteNamed1", concreteNamed1);
		assertEquals("concreteNamed1", 2, concreteNamed1.getESuperTypes().size());
		assertTrue(concreteNamed1.getESuperTypes().contains(subNamed1));
		assertTrue(concreteNamed1.getESuperTypes().contains(subNamed3));
		assertNotNull("a", concreteNamed1.getEStructuralFeature("a"));
		assertEquals("concreteNamed1", 1, concreteNamed1.getEStructuralFeatures().size());

		EClass concreteNamed2 = (EClass) ePackage.getEClassifier("ConcreteNamed2");
		assertNotNull("concreteNamed2", concreteNamed2);
		assertEquals("concreteNamed2", 2, concreteNamed2.getESuperTypes().size());
		assertTrue(concreteNamed2.getESuperTypes().contains(subNamed1));
		assertTrue(concreteNamed2.getESuperTypes().contains(subNamed2));
		assertNotNull("b", concreteNamed2.getEStructuralFeature("b"));
		assertEquals("concreteNamed2", 1, concreteNamed2.getEStructuralFeatures().size());

		EClass concreteNamed3 = (EClass) ePackage.getEClassifier("ConcreteNamed3");
		assertNotNull("concreteNamed3", concreteNamed3);
		assertEquals("concreteNamed3", 2, concreteNamed3.getESuperTypes().size());
		assertTrue(concreteNamed3.getESuperTypes().contains(subNamed2));
		assertTrue(concreteNamed3.getESuperTypes().contains(subNamed3));
		assertNotNull("c", concreteNamed3.getEStructuralFeature("c"));
		assertEquals("concreteNamed3", 1, concreteNamed3.getEStructuralFeatures().size());
	}

	public void testSingleFeatures() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: featureA=INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);

		assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EInt");
	}

	public void testCommonTerminalsFeatureTypes() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: featureA=ID featureB=INT featureC=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);

		assertEquals(3, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt");
		assertAttributeConfiguration(ruleA, 2, "featureC", "EString");
	}

	public void testCardinalityOfFeatures() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: featureA?=ID featureB=INT featureC+=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);

		assertEquals(3, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt", 0, 1);
		assertAttributeConfiguration(ruleA, 2, "featureC", "EString", 0, -1);
	}

	public void testOptionalAssignmentsInGroup() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: (featureA?='abstract' featureB+=INT)?;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(1, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");
		assertNotNull(ruleA);
		assertEquals(2, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt", 0, -1);
	}

	public void testFeaturesAndInheritanceOptionalRuleCall() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: RuleB? featureA=INT; RuleB: featureB=STRING;";
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
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: RuleB featureA=INT; RuleB: featureB=STRING;";
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
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: (RuleB|RuleC featureC1=ID) featureA=ID; RuleB: featureB=ID; RuleC: featureC2=ID;";
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
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: (RuleB|RuleC featureC1=ID)? featureA=ID; RuleB: featureB=ID; RuleC: featureC2=ID;";
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
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'";
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
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: ({Add.a=current} '+'|{Sub.a=current} '-') featureAS=ID;";
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
		grammar += "grammar org.eclipse.xtext.testlanguages.ActionTestLanguage with org.eclipse.xtext.common.Terminals ";
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
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: callA1=RuleB callA2+=RuleB simpleFeature=ID; RuleB: featureB=ID;";
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
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' " +
				"RuleA: refA1=[TypeB] refA2+=[TypeB|RuleB] simpleFeature=ID; " +
				"RuleB returns TypeB: featureB=ID;";
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
		String grammar = " grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'";
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

	public void testAssignedKeyword() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: featureA?=('+'|'-') featureB=('*'|'/');";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(1, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) ePackage.getEClassifier("RuleA");

		assertEquals(2, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertAttributeConfiguration(ruleA, 1, "featureB", "EString", 0, 1);
	}

	public void testImportWithoutAlias() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' import 'http://www.eclipse.org/emf/2002/Ecore' RuleA: feature=ID;";
		getEPackageFromGrammar(grammar);
	}

	public void testGenerateTwoModels() throws Exception {
		String grammar = "";
		grammar += " grammar test with org.eclipse.xtext.common.Terminals";
		grammar += " generate t1 'http://t1'";
		grammar += " generate t2 'http://t2' as t2";
		grammar += " RuleA: featureA=ID;";
		grammar += " RuleB returns t2::TypeB: featureB=ID;";
		List<EPackage> ePackages = getEPackagesFromGrammar(grammar, 0);
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
		grammar += " grammar test with org.eclipse.xtext.common.Terminals";
		grammar += " generate t1 'http://t1' as target";
		grammar += " generate t2 'http://t2' as target";
		grammar += " RuleA: featureA=ID;"; // no alias => cannot be created
		grammar += " RuleB returns target::TypeB: featureB=ID;";

		errorAcceptorMock.acceptError(same(TransformationErrorCode.AliasForMetamodelAlreadyExists), (String) anyObject(),	(EObject) anyObject());
		errorAcceptorMock.acceptError(same(TransformationErrorCode.UnknownMetaModelAlias), (String) anyObject(), (EObject) anyObject());
		errorAcceptorMock.acceptError(same(TransformationErrorCode.UnknownMetaModelAlias), (String) anyObject(), (EObject) anyObject());

		List<EPackage> ePackages = getEPackagesFromGrammar(grammar, 5);
		assertEquals(0, ePackages.size());
	}

	public void testModifyingSealedModel() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals " +
				"generate test 'http://test' " +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore " +
				"RuleA returns ecore::SomeNewTypeA: feature=ID;";
		errorAcceptorMock.acceptError(same(TransformationErrorCode.CannotCreateTypeInSealedMetamodel), (String) anyObject(), (EObject) anyObject());
		EPackage result = getEPackageFromGrammar(grammar, 2);
		assertTrue(result.getEClassifiers().isEmpty());
	}

	public void testImportingUnknownModel() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals " +
				"generate test 'http://test' " +
				"import 'unknown-scheme://www.unknownModel' as unknownModel " +
				"RuleA: feature=ID;";
		getEPackageFromGrammar(grammar, 1);
	}

	public void testMoreThanOneRuleCall() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: RuleB RuleC; RuleB: featureB=ID; RuleC: featureC=ID;";
		errorAcceptorMock.acceptError(same(TransformationErrorCode.MoreThanOneTypeChangeInOneRule), (String) anyObject(),
				(EObject) anyObject());
		getEPackageFromGrammar(grammar, 1);
	}

	public void testRuleCallAndAction() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: RuleB {TypeC.B = current}; RuleB: featureB=ID;";
		getEPackageFromGrammar(grammar);
	}

	public void testRuleCallActionAndRuleCall() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA: RuleB {TypeC.B = current} RuleB; RuleB: featureB=ID;";
		errorAcceptorMock.acceptError(same(TransformationErrorCode.MoreThanOneTypeChangeInOneRule), (String) anyObject(),
				(EObject) anyObject());
		getEPackageFromGrammar(grammar, 1);
	}

	public void testAddingFeatureTwice() throws Exception {
		final String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test' RuleA returns TypeA: featureA=ID; RuleB returns TypeA: featureA=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		assertEquals(1, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) ePackage.getEClassifier("TypeA");
		assertNotNull(typeA);

		assertEquals(1, typeA.getEAttributes().size());
		assertAttributeConfiguration(typeA, 0, "featureA", "EString");
	}

	public void testAddingDifferentFeaturesWithSameName01() throws Exception {
		// simple datatypes do not have a common compatible type
		final String grammar = "" + " grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'" + " RuleA returns TypeA: featureA=ID;"
				+ " RuleB returns TypeA: featureA=INT;";

		errorAcceptorMock.acceptError(same(TransformationErrorCode.NoCompatibleFeatureTypeAvailable), (String) anyObject(),
				(EObject) anyObject());
		EPackage ePackage = getEPackageFromGrammar(grammar, 1);
		assertEquals(1, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) ePackage.getEClassifier("TypeA");
		assertNotNull(typeA);

		assertEquals(1, typeA.getEAttributes().size());
		assertAttributeConfiguration(typeA, 0, "featureA", "EString");
	}

	public void testAddingDifferentFeaturesWithSameName02() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'";
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
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'";
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
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'";
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
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'";
		grammar += " RuleA: CallOfUndeclaredRule featureA=ID;";
		errorAcceptorMock.acceptError(same(TransformationErrorCode.NoSuchRuleAvailable), (String) anyObject(),
				(EObject) anyObject());
		EPackage ePackage = getEPackageFromGrammar(grammar, 1);
		assertEquals(1, ePackage.getEClassifiers().size());
		assertEquals("RuleA", ePackage.getEClassifiers().get(0).getName());
	}

	public void testExpressionLikeLangauge() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'";
		grammar += " Ex :	Atom  ({ChainExpression.left+=current} operator=('+'|'-'|'*'|'/') right=Atom )*;" +
				"Atom returns Ex :   Number |  '(' Ex ')';" +
				"Number : value=INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass classifier = (EClass) ePackage.getEClassifier("Ex");
//		logger.debug(EmfFormater.objToStr(ePackage));
		assertEquals(0,classifier.getEStructuralFeatures().size());
	}

	public void testClassNameEString() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'";
		grammar += "Start returns EString: id=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass classifier = (EClass) ePackage.getEClassifier("EString");
		assertEquals("EString", classifier.getName());
		EStructuralFeature feature = classifier.getEStructuralFeature("id");
		assertNotNull(feature);
		assertEquals("EString", feature.getEType().getName());
		assertFalse(feature.getEType().equals(classifier));
		assertEquals(EcorePackage.Literals.ESTRING, feature.getEType());
	}

	public void testNoException_01() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" import 'http://www.eclipse.org/emf/2002/Ecore' as ecore " +
				"generate test 'http://test'\n" +
				"CompositeModel: (model+=Model)+;\n" +
				"Model: id=NestedModelId (':' value=Fraction)? ('#' vector=Vector)? ('+' dots=Dots)? ';'\n" +
				"ModelId returns ecore::EString: ID '.' ID;\n" +
				"NestedModelId : ModelId '.' ModelId;\n" +
				"Fraction returns EBigDecimal: INT ('/' INT)?;\n" +
				"Vector : '(' INT I";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 8);
		for(Diagnostic d: resource.getErrors()) {
			assertFalse(d instanceof ExceptionDiagnostic);
		}
	}

	public void testNoException_02() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'\n" +
				"Model: (children+=Element)*;\n" +
				"Element returns Type: Item ( { Item.items+=current } items+=Item );\n" +
				"Item returns Type:	{ T";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		for(Diagnostic d: resource.getErrors()) {
			assertFalse(d instanceof ExceptionDiagnostic);
		}
	}

	public void testNoException_03() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" import 'http://www.eclipse.org/emf/2002/Ecore' as ecore " +
				"generate test 'http://test'\n" +
				"CompositeModel: (type+=EClassifier)+;\n" +
				"EClassifier returns ecore::EClassifier: EDataType | EClass;\n" +
				"EClass returns ecore::EClass: 'class' name=ID;\n" +
				"EDataType returns ecore::EDataType: 'dt' name=ID;";
		XtextResource resource = getResourceFromString(grammar);
		assertTrue(resource.getErrors().isEmpty());
	}

	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=266440
	 */
	public void testBug_266440() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" import 'http://www.eclipse.org/emf/2002/Ecore' as ecore " +
				" generate bugreport 'http://bugreport/266440'\n" +
				"CompositeModel: (type+=EClassifier)+;\n" +
				"EClassifier: EDataType | EClass;\n" +
				"EClass: 'class' name=ID;\n" +
				"EDataType: 'dt' name=ID;";
		XtextResource resource = getResourceFromString(grammar);
		assertTrue(resource.getErrors().isEmpty());
		Grammar parsedGrammar = (Grammar) resource.getContents().get(0);
		for(AbstractRule rule: parsedGrammar.getRules()) {
			EClassifier classifier = rule.getType().getClassifier();
			EPackage pack = classifier.getEPackage();
			assertEquals("bugreport", pack.getName());
		}
	}

	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=266807
	 */
	public void testBug_266807() throws Exception {
		with(new XtextStandaloneSetup());
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		XtextResource resource = (XtextResource) rs.createResource(
				URI.createURI("classpath:/"+getClass().getPackage().getName().replace('.', '/')+"/Test.xtext"), 
				ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		resource.load(null);
		for(Diagnostic d: resource.getErrors()) {
			fail(d.getMessage());
		}
	}
	
	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=272566
	 */
	public void testBug_272566_1() throws Exception {
		with(new XtextStandaloneSetup());
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Model:\n" +
				"   test=Test\n" +
				";\n" +
				"\n" +
				"Test:\n" +
				"   \"keyword\" WS name=ID\n" +
				";";
		XtextResource resource = getResourceFromString(grammar);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=272566
	 */
	public void testBug_272566_2() throws Exception {
		with(new XtextStandaloneSetup());
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Model:\n" +
				"   test=Test\n" +
				";\n" +
				"\n" +
				"Test:\n" +
				"   \"keyword\" FooBar name=ID\n" +
				";\n" +
				"FooBar:\n" +
				"	'zonk' WS WS INT WS" +
				";";
		XtextResource resource = getResourceFromString(grammar);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=272566
	 */
	public void testBug_272566_3() throws Exception {
		with(new XtextStandaloneSetup());
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Model:\n" +
				"   test=Test\n" +
				";\n" +
				"\n" +
				"Test:\n" +
				"   \"keyword\" MyEnum name=ID\n" +
				";\n" +
				"enum MyEnum:\n" +
				"	A | B" +
				";";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		assertFalse(resource.getErrors().toString(), resource.getErrors().isEmpty());
		for(Diagnostic d: resource.getErrors()) {
			assertFalse(d instanceof ExceptionDiagnostic);
		}
	}
	
	public void testInheritFromEObject_01() throws Exception {
		String grammar =
				" grammar test with org.eclipse.xtext.common.Terminals" +
				" import 'http://www.eclipse.org/emf/2002/Ecore' as ecore " +
				" import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/test.ecore' as test " +
				" A returns ecore::EObject: B | C; " +
				" B returns test::Optional: 'b' optionalString=STRING; " +
				" C returns test::Mandatory: 'c' mandatoryString=STRING; ";
		XtextResource resource = getResourceFromString(grammar);
		assertTrue(resource.getErrors().isEmpty());
	}
	
	public void testInheritFromEObject_02() throws Exception {
		String grammar =
				" grammar test with org.eclipse.xtext.common.Terminals" +
				" import 'http://www.eclipse.org/emf/2002/Ecore' as ecore " +
				" Object returns ecore::EObject: {ecore::EInt}; ";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}

	public void testInheritFromEObject_03() throws Exception {
		String grammar =
				" grammar test with org.eclipse.xtext.common.Terminals" +
				" import 'http://www.eclipse.org/emf/2002/Ecore' as ecore " +
				" Object returns ecore::EObject: {ecore::EAnnotation}; ";
		XtextResource resource = getResourceFromString(grammar);
		assertTrue(resource.getErrors().isEmpty());
	}

	public void testPostProcessorHook() throws Exception {
		final String xtextGrammar = "grammar test with org.eclipse.xtext.common.Terminals" +
				" import 'http://www.eclipse.org/emf/2002/Ecore' as ecore " +
				" generate test 'http://test' MyRule: myFeature=INT;";
		Grammar grammar = (Grammar) getModel(xtextGrammar);
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
		IXtext2EcorePostProcessor postProcessor = createMock(IXtext2EcorePostProcessor.class);
		transformer.setPostProcessor(postProcessor);
		GeneratedMetamodel testMetamodel = (GeneratedMetamodel) grammar.getMetamodelDeclarations().get(1);

		postProcessor.process(testMetamodel);
		replay(postProcessor);
		transformer.transform();

		verify(postProcessor);
	}
	
	public void testBug_280413_01() throws Exception {
		final String grammar =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
			"EClass returns ecore::EClass: name=ID;";
		XtextResource resource = getResourceFromString(grammar);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	public void testBug_280413_02() throws Exception {
		final String grammar =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
			"EClass returns ecore::EClass: name=ID;";
		XtextResource resource = getResourceFromString(grammar);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	public void testBug_280413_03() throws Exception {
		final String grammar =
			"grammar test with org.eclipse.xtext.Xtext\n" +
			"generate test 'http://test'\n" +
			"import 'http://www.eclipse.org/2008/Xtext' as xtext\n" +
			"ParserRule returns xtext::ParserRule: name=ID;";
		XtextResource resource = getResourceFromString(grammar);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	public void testBug_280413_04() throws Exception {
		final String grammar =
			"grammar test with org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage\n" +
			"generate test 'http://test'\n" +
			"import 'classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.ecore' as mm\n" +
			"Atom returns mm::Atom: name=ID;";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		TransformationDiagnostic diagnostic = (TransformationDiagnostic) resource.getErrors().get(0);
		assertEquals(grammar.indexOf("mm::Atom"), diagnostic.getOffset());
		assertEquals("mm::Atom".length(), diagnostic.getLength());
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=280393
	 */
	public void testBug_280393() throws Exception {
		final String grammar = "grammar foo.Bar with org.eclipse.xtext.common.Terminals\n" + 
				"\n" + 
				"import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore\n" + 
				"generate bar \"http://www.Bar.foo\"\n" + 
				"\n" + 
				"Foo returns ecore::EClass : \n" + 
				"	Bar | eSuperTypes+=[ecore::EClass];\n" + 
				"\n" + 
				"Bar :\n" + 
				" 	'bar' eSuperTypes+=[ecore::EAttribute];";
		
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}
	
	public void testBug_285140_01() throws Exception {
		final String grammar = "grammar org.sublang with org.eclipse.xtext.testlanguages.ActionTestLanguage\n" + 
		"\n" + 
		"import \"http://www.eclipse.org/2008/tmf/xtext/ActionLang\" as actionLang\n" + 
		"generate sub \"http://www.sublang.org\"\n" + 
		"\n" + 
		"Model returns actionLang::Model:\n" + 
		"	Child ({actionLang::Parent.left=current} right=Child)?;";

		XtextResource resource = getResourceFromString(grammar);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}
	
	public void testBug_285140_02() throws Exception {
		final String grammar = "grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage\n" + 
		"\n" + 
		"import \"http://www.eclipse.org/2008/tmf/xtext/ActionLang\" as actionLang\n" + 
		"\n" + 
		"Model returns actionLang::Model:\n" + 
		"	Child ({actionLang::Parent.left=current} right=Child)?;";

		XtextResource resource = getResourceFromString(grammar);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}
	
	public void testBug_285140_03() throws Exception {
		final String grammar = "grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage\n" + 
		"\n" + 
		"import \"http://www.eclipse.org/2008/tmf/xtext/ActionLang\" as actionLang\n" + 
		"\n" + 
		"Model returns actionLang::Child:\n" + 
		"	Child name=ID;";

		XtextResource resource = getResourceFromString(grammar);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}
	
	public void testBug_285140_04() throws Exception {
		final String grammar = "grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage\n" + 
		"\n" + 
		"import \"http://www.eclipse.org/2008/tmf/xtext/ActionLang\" as actionLang\n" + 
		"\n" + 
		"Child returns actionLang::Child:\n" + 
		"	Child unknown=ID;";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}
	
	public void testBug_286285_01() throws Exception {
		final String grammar = "grammar language with org.eclipse.xtext.common.Terminals\n" + 
			"generate lang \"http://www.language.org\"\n" + 
			"Model:\n" + 
			"	Class | ID;\n" +
			"Class: name = ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}
	
	public void testBug_287550_01() throws Exception {
		String grammar = "grammar language with org.eclipse.xtext.common.Terminals\n" +
			"generate myDsl \"http://example.xtext.org/MyDsl\"\n" +
			"Model: Left | Right;\n" + 
			"Left: Delegate;\n" + 
			"Right returns Model: Delegate '=';\n" + 
			"Delegate returns Left: value=ID;";
		XtextResource resource = getResourceFromString(grammar);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}
	
	public void testBug_287698_01() throws Exception {
		String grammar = "grammar language with org.eclipse.xtext.common.Terminals\n" +
		"generate myDsl \"http://example.xtext.org/MyDsl\"\n" +
		"Model returns Namespace: {Model} elements+=NamespaceElement;\n" + 
		"NamespaceElement: Type | Namespace ;\n" + 
		"Type: 'type' name=ID ';';\n" + 
		"Namespace: 'namespace' name=ID '{' elements+=Type '}';\n";
		XtextResource resource = getResourceFromString(grammar);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}
	
	public void testBug_287698_02() throws Exception {
		String grammar = "grammar language with org.eclipse.xtext.common.Terminals\n" +
		"generate myDsl \"http://example.xtext.org/MyDsl\"\n" +
		"Model returns Namespace: {Model} elements+=(Namespace | Something); \n" + 
		"Root: Type | NamespaceElement;\n" + 
		"Type: 'type' name=ID ';';\n" + 
		"NamespaceElement: Namespace | Something;\n" + 
		"Namespace: 'namespace' name=ID '{' elements+=SubSomething '}';\n" + 
		"Something: ReturnModel | SubSomething;\n" + 
		"SubSomething: 'something' name=ID ';';\n" + 
		"ReturnModel returns Model: name=ID;";
		XtextResource resource = getResourceFromString(grammar);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}
	
	public void testContainmentVsReference_01() throws Exception {
		final String grammar = 
			"grammar test with org.eclipse.xtext.common.Terminals " +
			"import 'http://www.eclipse.org/emf/2002/Ecore' " +
			"EClass: name=ID eSuperTypes+=EClass;";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}
	
	public void testContainmentVsReference_02() throws Exception {
		final String grammar = 
			"grammar test with org.eclipse.xtext.common.Terminals " +
			"import 'http://www.eclipse.org/emf/2002/Ecore' " +
			"EClass: name=ID eSuperTypes+=[EClass];";
		XtextResource resource = getResourceFromString(grammar);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}
	
	public void testContainmentVsReference_03() throws Exception {
		final String grammar = 
			"grammar test with org.eclipse.xtext.common.Terminals " +
			"import 'http://www.eclipse.org/emf/2002/Ecore' " +
			"EReference: name=ID eType=[EClass];";
		XtextResource resource = getResourceFromString(grammar);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}
	
	public void testContainmentVsReference_04() throws Exception {
		final String grammar = 
			"grammar test with org.eclipse.xtext.common.Terminals " +
			"import 'http://www.eclipse.org/emf/2002/Ecore' " +
			"EReference: name=ID eType=EClass;\n" +
			"EClass: name=ID;";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}
	
	public void testContainmentVsReference_05() throws Exception {
		final String grammar = 
			"grammar test with org.eclipse.xtext.common.Terminals " +
			"import 'http://www.eclipse.org/emf/2002/Ecore' " +
			"EReference: name=ID eContainingClass=[EClass];";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}
	
	public void testContainmentVsReference_06() throws Exception {
		final String grammar = 
			"grammar test with org.eclipse.xtext.common.Terminals " +
			"import 'http://www.eclipse.org/emf/2002/Ecore' " +
			"EReference: name=ID eContainingClass=EClass;\n" +
			"EClass: name=ID;";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}
	
	public void testBug296496_01() throws Exception {
		final String grammar = 
			"grammar test with org.eclipse.xtext.common.Terminals\n" + 
			"import \"classpath:/org/eclipse/xtext/enumrules/enums.ecore\"\n" + 
			"ExistingType:\n" + 
			"  enumFeature=ExistingEnum stringFeature=ExistingEnum;\n" + 
			"enum ExistingEnum:\n" + 
			"  SameName | OverriddenLiteral = \"overridden\" | DifferentName;";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}
	
	public void testBug296496_02() throws Exception {
		final String grammarAsString = 
			"grammar test with org.eclipse.xtext.common.Terminals\n" + 
			"import \"classpath:/org/eclipse/xtext/enumrules/enums.ecore\"\n" + 
			"generate myDsl \"http://example.xtext.org/MyDsl\"\n" + 
			"CreatedType:\n" + 
			"  enumFeature=ExistingEnum otherEnumFeature=ExistingEnum;\n" + 
			"enum ExistingEnum:\n" + 
			"  SameName | OverriddenLiteral = \"overridden\" | DifferentName;";
		XtextResource resource = getResourceFromStringAndExpect(grammarAsString, 0);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		Grammar grammar = (Grammar) resource.getContents().get(0);
		GeneratedMetamodel generatedMetamodel = (GeneratedMetamodel) grammar.getMetamodelDeclarations().get(1);
		assertEquals("myDsl", generatedMetamodel.getName());
		EClass createdType = (EClass) generatedMetamodel.getEPackage().getEClassifier("CreatedType");
		assertEquals(createdType.getEStructuralFeature("enumFeature").getEType(), createdType.getEStructuralFeature("otherEnumFeature").getEType());
	}
	
	public void testBug310122() throws Exception {
		final String grammarAsString = 
			"grammar test with org.eclipse.xtext.common.Terminals\n" + 
			"generate myDsl \"http://example.xtext.org/MyDsl\"\n" +
			"Model: Sub1 | name=ID 'somekeyword';\n" + 
			"Sub1 returns Model: '(' Model ')';"; 
		XtextResource resource = getResourceFromString(grammarAsString);
		Grammar grammar = (Grammar) resource.getContents().get(0);
		GeneratedMetamodel generatedMetamodel = (GeneratedMetamodel) grammar.getMetamodelDeclarations().get(0);
		assertEquals("myDsl", generatedMetamodel.getName());
		assertEquals(1, generatedMetamodel.getEPackage().getEClassifiers().size());
		EClass createdModel = (EClass) generatedMetamodel.getEPackage().getEClassifier("Model");
		assertEquals(EcorePackage.Literals.ESTRING, createdModel.getEStructuralFeature("name").getEType());
		for(AbstractRule rule: grammar.getRules()) {
			assertEquals(createdModel, rule.getType().getClassifier());
		}
	}
	
}
