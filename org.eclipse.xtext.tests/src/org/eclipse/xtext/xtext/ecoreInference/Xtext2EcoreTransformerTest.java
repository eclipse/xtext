/**
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.ecoreInference;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.tests.TestErrorAcceptor;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.xtext.XtextLinker;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * @see https://www.eclipse.org/Xtext/documentation/301_grammarlanguage.html#metamodel-inference
 */
public class Xtext2EcoreTransformerTest extends AbstractXtextTests {
	/**
	 * @author Dennis Hübner - Initial contribution and API
	 */
	@Deprecated
	private static class MockedXtext2EcorePostProcessor implements IXtext2EcorePostProcessor {
		private int called = 0;

		private GeneratedMetamodel testMetamodel;

		@Override
		public void process(GeneratedMetamodel metamodel) {
			if (testMetamodel.equals(metamodel)) {
				called++;
			}
		}

		public int proccessMethCalled() {
			return called;
		}

		public MockedXtext2EcorePostProcessor(GeneratedMetamodel testMetamodel) {
			this.testMetamodel = testMetamodel;
		}
	}

	public static class MyErrorAcceptor implements ErrorAcceptor {
		private ErrorAcceptor first;

		private ErrorAcceptor second;

		@Override
		public void acceptError(TransformationErrorCode errorCode, String message, EObject element) {
			first.acceptError(errorCode, message, element);
			second.acceptError(errorCode, message, element);
		}

		public MyErrorAcceptor(ErrorAcceptor first, ErrorAcceptor second) {
			this.first = first;
			this.second = second;
		}
	}

	private TestErrorAcceptor errorAcceptorMock;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		errorAcceptorMock = new TestErrorAcceptor();
		with(XtextStandaloneSetup.class);
	}

	@Override
	public void tearDown() throws Exception {
		errorAcceptorMock = null;
		super.tearDown();
	}

	private EPackage getEPackageFromGrammar(String xtextGrammar, int expectedErrors) throws Exception {
		List<EPackage> metamodels = getEPackagesFromGrammar(xtextGrammar, expectedErrors);
		Assert.assertEquals(1, metamodels.size());
		EPackage result = Iterables.getFirst(metamodels, null);
		Assert.assertNotNull(result);
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
		linker.setLinkingHelper(((Linker) resource.getLinker()).getLinkingHelper());
		linker.setPackageRemover(new XtextLinker.PackageRemover());
		linker.setDiagnosticMessageProvider(new LinkingDiagnosticMessageProvider());
		linker.setCache(new OnChangeEvictingCache());
		resource.setLinker(linker);
		resource.load(in, null);
		return resource;
	}

	private List<EPackage> getEPackagesFromGrammar(String xtextGrammar, int expectedErrors) throws Exception {
		errorAcceptorMock.replay();
		Grammar grammar = (Grammar) getModelAndExpect(xtextGrammar, expectedErrors);
		errorAcceptorMock.verify();
		List<EPackage> metamodels = Xtext2EcoreTransformer.doGetGeneratedPackages(grammar);
		Assert.assertNotNull(metamodels);
		return metamodels;
	}

	private EAttribute assertAttributeConfiguration(EClass eClass, int attributeIndex, String featureName,
			String featureTypeName) {
		EAttribute feature = eClass.getEAttributes().get(attributeIndex);
		Assert.assertEquals(featureName, feature.getName());
		Assert.assertNotNull(feature.getEType());
		Assert.assertEquals(featureTypeName, feature.getEType().getName());
		return feature;
	}

	private EAttribute assertAttributeConfiguration(EClass eClass, int attributeIndex, String featureName,
			String featureTypeName, int lowerBound, int upperBound) {
		EAttribute feature = assertAttributeConfiguration(eClass, attributeIndex, featureName, featureTypeName);
		Assert.assertEquals(lowerBound, feature.getLowerBound());
		Assert.assertEquals(upperBound, feature.getUpperBound());
		return feature;
	}

	private EReference assertReferenceConfiguration(EClass eClass, int referenceIndex, String featureName,
			String featureTypeName, boolean isContainment, int lowerBound, int upperBound) {
		EReference reference = eClass.getEReferences().get(referenceIndex);
		Assert.assertEquals(featureName, reference.getName());
		Assert.assertNotNull(reference.getEType());
		Assert.assertEquals(featureTypeName, reference.getEType().getName());
		Assert.assertEquals(Boolean.valueOf(isContainment), Boolean.valueOf(reference.isContainment()));
		Assert.assertEquals(lowerBound, reference.getLowerBound());
		Assert.assertEquals(upperBound, reference.getUpperBound());
		return reference;
	}

	@Test
	public void testEscapeChar_01() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"^MyRule: name=^ID;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		Assert.assertEquals(1, classifiers.size());
		EClassifier myRuleType = Iterables.getFirst(classifiers, null);
		Assert.assertEquals("MyRule", myRuleType.getName());
	}

	@Test
	public void testEscapeChar_02() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"^RootRule: ^Sub1 | ^Sub2;\n" +
				"^Sub1: {^Sub1} 'sub1';\n" +
				"^Sub2: {^Sub2} 'sub2';\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		Assert.assertEquals(3, classifiers.size());
		Assert.assertEquals("RootRule", classifiers.get(0).getName());
		Assert.assertEquals("Sub1", classifiers.get(1).getName());
		Assert.assertEquals("Sub2", classifiers.get(2).getName());
	}

	@Test
	public void testParserRuleFragment_01() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"MyRule: IntFeature;\n" +
				"fragment IntFeature*: myFeature=INT;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		Assert.assertEquals(1, classifiers.size());
		EClassifier myRuleType = Iterables.getFirst(classifiers, null);
		Assert.assertEquals("MyRule", myRuleType.getName());
		Assert.assertEquals("EInt", feature(myRuleType, "myFeature").getEType().getName());
	}

	@Test
	public void testParserRuleFragment_02() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"MyRule: IntFeatureHolder;\n" +
				"fragment IntFeatureHolder: myFeature=INT;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		Assert.assertEquals(2, classifiers.size());
		EClassifier myRuleType = Iterables.getFirst(classifiers, null);
		Assert.assertEquals("MyRule", myRuleType.getName());
		Assert.assertTrue(features(myRuleType).isEmpty());
		EClassifier intFeatureHolder = Iterables.getLast(classifiers);
		Assert.assertEquals("EInt", feature(intFeatureHolder, "myFeature").getEType().getName());
		Assert.assertTrue(superTypes(myRuleType).contains(intFeatureHolder));
	}

	@Test
	public void testParserRuleFragment_03() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"MyRule: IntFeatureHolder;\n" +
				"fragment IntFeatureHolder: myFeature=INT NameFeatureHolder;\n" +
				"fragment NameFeatureHolder: name=STRING;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		Assert.assertEquals(3, classifiers.size());
		EClassifier myRuleType = Iterables.getFirst(classifiers, null);
		Assert.assertEquals("MyRule", myRuleType.getName());
		Assert.assertTrue(features(myRuleType).isEmpty());
		EClassifier intFeatureHolder = classifiers.get(1);
		Assert.assertEquals("EInt", feature(intFeatureHolder, "myFeature").getEType().getName());
		Assert.assertTrue(superTypes(myRuleType).contains(intFeatureHolder));
		EClassifier nameFeatureHolder = Iterables.getLast(classifiers);
		Assert.assertEquals("EString", feature(nameFeatureHolder, "name").getEType().getName());
		Assert.assertTrue(superTypes(intFeatureHolder).contains(nameFeatureHolder));
	}

	@Test
	public void testParserRuleFragment_04() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"MyRule: Documentable IntFeatureHolder;\n" +
				"fragment IntFeatureHolder: Documentable myFeature=INT NameFeatureHolder;\n" +
				"fragment NameFeatureHolder: Documentable name=STRING;\n" +
				"fragment Documentable*: doc=STRING;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		Assert.assertEquals(3, classifiers.size());
		EClassifier myRuleType = Iterables.getFirst(classifiers, null);
		Assert.assertEquals("MyRule", myRuleType.getName());
		Assert.assertTrue(features(myRuleType).isEmpty());
		EClassifier intFeatureHolder = classifiers.get(1);
		Assert.assertEquals("EInt", feature(intFeatureHolder, "myFeature").getEType().getName());
		Assert.assertEquals(1, features(intFeatureHolder).size());
		EClassifier nameFeatureHolder = Iterables.getLast(classifiers);
		Assert.assertEquals("EString", feature(nameFeatureHolder, "name").getEType().getName());
		Assert.assertEquals(2, features(nameFeatureHolder).size());
	}

	@Test
	public void testParserRuleFragment_05() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Middle: Top;\n" +
				"fragment Top: name=ID ({Bottom.prev=current} Top)?;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		Assert.assertEquals(3, classifiers.size());
		EClassifier middleType = Iterables.getFirst(classifiers, null);
		Assert.assertEquals("Middle", middleType.getName());
		Assert.assertTrue(features(middleType).isEmpty());
		EClassifier topType = classifiers.get(1);
		Assert.assertEquals("EString", feature(topType, "name").getEType().getName());
		Assert.assertTrue(superTypes(middleType).contains(topType));
		EClassifier bottomType = Iterables.getLast(classifiers);
		Assert.assertEquals("Top", feature(bottomType, "prev").getEType().getName());
		Assert.assertTrue(superTypes(bottomType).contains(middleType));
	}

	@Test
	public void testParserRuleFragment_06() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Middle1: Top;\n" +
				"Middle2: Top;\n" +
				"fragment Top: name=ID ({Bottom.prev=current} Top)?;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		Assert.assertEquals(4, classifiers.size());
		EClassifier middleType1 = Iterables.getFirst(classifiers, null);
		Assert.assertEquals("Middle1", middleType1.getName());
		Assert.assertTrue(features(middleType1).isEmpty());
		EClassifier middleType2 = classifiers.get(1);
		Assert.assertEquals("Middle2", middleType2.getName());
		Assert.assertTrue(features(middleType2).isEmpty());
		EClassifier topType = classifiers.get(2);
		Assert.assertEquals("EString", feature(topType, "name").getEType().getName());
		Assert.assertTrue(superTypes(middleType1).contains(topType));
		Assert.assertTrue(superTypes(middleType2).contains(topType));
		EClassifier bottomType = Iterables.getLast(classifiers);
		Assert.assertEquals("Top", feature(bottomType, "prev").getEType().getName());
		Assert.assertTrue(superTypes(bottomType).contains(middleType1));
		Assert.assertTrue(superTypes(bottomType).contains(middleType2));
	}

	@Test
	public void testParserRuleFragment_07() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Middle1: Top;\n" +
				"Middle2: Top;\n" +
				"fragment Top: name=ID ({Bottom.prev=current} name=ID)*;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		Assert.assertEquals(4, classifiers.size());
		EClassifier middleType1 = Iterables.getFirst(classifiers, null);
		Assert.assertEquals("Middle1", middleType1.getName());
		Assert.assertTrue(features(middleType1).isEmpty());
		EClassifier middleType2 = classifiers.get(1);
		Assert.assertEquals("Middle2", middleType2.getName());
		Assert.assertTrue(features(middleType2).isEmpty());
		EClassifier topType = classifiers.get(2);
		Assert.assertEquals("EString", feature(topType, "name").getEType().getName());
		Assert.assertTrue(superTypes(middleType1).contains(topType));
		Assert.assertTrue(superTypes(middleType2).contains(topType));
		EClassifier bottomType = Iterables.getLast(classifiers);
		Assert.assertEquals("Top", feature(bottomType, "prev").getEType().getName());
		Assert.assertTrue(superTypes(bottomType).contains(middleType1));
		Assert.assertTrue(superTypes(bottomType).contains(middleType2));
	}

	@Test
	public void testParserRuleFragment_08() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RuleA: feature=Fragment;\n" +
				"fragment Fragment * Fragment: name=ID;\n";
		errorAcceptorMock.acceptError(TransformationErrorCode.InvalidFragmentCall, TestErrorAcceptor.ANY_STRING,
				TestErrorAcceptor.ANY_EOBJECT);
		EPackage result = getEPackageFromGrammar(grammar, 2);
		Assert.assertEquals(1, result.getEClassifiers().size());
	}

	@Test
	public void testParserRuleFragment_09() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RuleA: feature=(Fragment|Fragment);\n" +
				"fragment Fragment returns Fragment: name=ID;\n";
		errorAcceptorMock.acceptError(TransformationErrorCode.InvalidFragmentCall, TestErrorAcceptor.ANY_STRING,
				TestErrorAcceptor.ANY_EOBJECT);
		EPackage result = getEPackageFromGrammar(grammar, 1);
		Assert.assertEquals(2, result.getEClassifiers().size());
	}

	@Test
	public void testParserRuleFragment_10() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RuleA: feature+=Fragment;\n" +
				"fragment Fragment returns Fragment: name=ID;\n";
		errorAcceptorMock.acceptError(TransformationErrorCode.InvalidFragmentCall, TestErrorAcceptor.ANY_STRING,
				TestErrorAcceptor.ANY_EOBJECT);
		EPackage result = getEPackageFromGrammar(grammar, 1);
		Assert.assertEquals(2, result.getEClassifiers().size());
	}

	@Test
	public void testParserRuleFragment_11() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RuleA: feature?=Fragment;\n" +
				"fragment Fragment returns Fragment: name=ID;\n";
		errorAcceptorMock.acceptError(TransformationErrorCode.InvalidFragmentCall, TestErrorAcceptor.ANY_STRING,
				TestErrorAcceptor.ANY_EOBJECT);
		EPackage result = getEPackageFromGrammar(grammar, 1);
		Assert.assertEquals(2, result.getEClassifiers().size());
	}

	@Test
	public void testTypesOfImplicitSuperGrammar() throws Exception {
		String xtextGrammar = "grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"MyRule: myFeature=INT;\n";
		Grammar grammar = (Grammar) getModel(xtextGrammar);
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
		transformer.removeGeneratedPackages();
		transformer.transform();
		AbstractRule rule = Iterables.getFirst(grammar.getRules(), null);
		TypeRef type = rule.getType();
		Assert.assertNotNull(type);
		Assert.assertNotNull(transformer.getEClassifierInfos().getInfo(type));
		ReferencedMetamodel referenced = (ReferencedMetamodel) GrammarUtil.allMetamodelDeclarations(grammar).get(1);
		Assert.assertNotNull(referenced);
		Assert.assertEquals("ecore", referenced.getAlias());
		Assert.assertNull(transformer.getEClassifierInfos().getInfo(referenced, "EString"));
		Assert.assertNull(transformer.getEClassifierInfos().getInfo(referenced, "EInt"));
		EClassifierInfos parentInfos = Iterables.getFirst(transformer.getEClassifierInfos().getParents(), null);
		Assert.assertNotNull(parentInfos.getInfo(referenced, "EString"));
		Assert.assertNotNull(parentInfos.getInfo(referenced, "EInt"));
	}

	@SuppressWarnings("unchecked")
	protected <T extends EClassifier> T type(EPackage pack, String name) {
		return (T) pack.getEClassifier(name);
	}

	@SuppressWarnings("unchecked")
	protected <T extends EStructuralFeature> T feature(EClassifier clazz, String name) {
		if (clazz instanceof EClass) {
			return (T) ((EClass) clazz).getEStructuralFeature(name);
		}
		return null;
	}

	protected List<EClass> superTypes(EClassifier clazz) {
		if (clazz instanceof EClass) {
			return ((EClass) clazz).getESuperTypes();
		}
		return Collections.emptyList();
	}

	protected List<? extends EStructuralFeature> features(EClassifier clazz) {
		if (clazz instanceof EClass) {
			return ((EClass) clazz).getEStructuralFeatures();
		}
		return Collections.emptyList();
	}

	@Test
	public void testRuleWithoutExplicitReturnType() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"MyRule: myFeature=INT;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		Assert.assertEquals(1, classifiers.size());
		EClassifier myRuleType = Iterables.getFirst(classifiers, null);
		Assert.assertEquals("MyRule", myRuleType.getName());
		Assert.assertEquals("myFeature", Iterables.getFirst(features(myRuleType), null).getName());
	}

	@Test
	public void testRulesWithExplicitReturnType() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RuleA returns TypeA: featureA=INT;\n" +
				"RuleB returns TypeB: featureB= INT;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(2, ePackage.getEClassifiers().size());
		Assert.assertNotNull(type(ePackage, "TypeA"));
		Assert.assertNotNull(type(ePackage, "TypeB"));
	}

	@Test
	public void testSimpleHierarchy() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB; RuleB: featureB= INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass ruleB = (EClass) type(ePackage, "RuleB");
		Assert.assertNotNull(ruleB);
		Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
		Assert.assertEquals(1, ruleB.getESuperTypes().size());
		EClass superClass = Iterables.getFirst(ruleB.getESuperTypes(), null);
		Assert.assertEquals(ruleA, superClass);
	}

	@Test
	public void testDiamondHierarchy() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' Model: name=ID value=SubNamed1 otherValue=SubNamed2 thirdValue=SubNamed3;Named: SubNamed1 | SubNamed2 | SubNamed3;SubNamed1: ConcreteNamed1 | ConcreteNamed2;SubNamed2: ConcreteNamed2 | ConcreteNamed3;SubNamed3: ConcreteNamed1 | ConcreteNamed3;ConcreteNamed1: name=ID bar=ID foo=ID a=ID;ConcreteNamed2: name=ID bar=ID zonk=ID b=ID;ConcreteNamed3: name=ID foo=ID zonk=ID c=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(8, ePackage.getEClassifiers().size());
		EClassifier classifier = type(ePackage, "Named");
		Assert.assertNotNull(classifier);
		EClass named = (EClass) classifier;
		EStructuralFeature feature = feature(named, "name");
		Assert.assertNotNull("name", feature);
		Assert.assertEquals("named", 1, features(named).size());
		EClass subNamed1 = (EClass) type(ePackage, "SubNamed1");
		Assert.assertNotNull("subNamed1", subNamed1);
		Assert.assertEquals(1, subNamed1.getESuperTypes().size());
		Assert.assertNotNull("bar", feature(subNamed1, "bar"));
		Assert.assertEquals("subNamed1", 1, features(subNamed1).size());
		EClass subNamed2 = (EClass) type(ePackage, "SubNamed2");
		Assert.assertNotNull("subNamed2", subNamed2);
		Assert.assertEquals(1, subNamed2.getESuperTypes().size());
		Assert.assertNotNull("bar", feature(subNamed2, "zonk"));
		Assert.assertEquals("subNamed2", 1, features(subNamed2).size());
		EClass subNamed3 = (EClass) type(ePackage, "SubNamed3");
		Assert.assertNotNull("subNamed3", subNamed3);
		Assert.assertEquals(1, subNamed3.getESuperTypes().size());
		Assert.assertNotNull("bar", feature(subNamed3, "foo"));
		Assert.assertEquals("subNamed3", 1, features(subNamed3).size());
		EClass concreteNamed1 = (EClass) type(ePackage, "ConcreteNamed1");
		Assert.assertNotNull("concreteNamed1", concreteNamed1);
		Assert.assertEquals("concreteNamed1", 2, concreteNamed1.getESuperTypes().size());
		Assert.assertTrue(concreteNamed1.getESuperTypes().contains(subNamed1));
		Assert.assertTrue(concreteNamed1.getESuperTypes().contains(subNamed3));
		Assert.assertNotNull("a", feature(concreteNamed1, "a"));
		Assert.assertEquals("concreteNamed1", 1, features(concreteNamed1).size());
		EClass concreteNamed2 = (EClass) type(ePackage, "ConcreteNamed2");
		Assert.assertNotNull("concreteNamed2", concreteNamed2);
		Assert.assertEquals("concreteNamed2", 2, concreteNamed2.getESuperTypes().size());
		Assert.assertTrue(concreteNamed2.getESuperTypes().contains(subNamed1));
		Assert.assertTrue(concreteNamed2.getESuperTypes().contains(subNamed2));
		Assert.assertNotNull("b", feature(concreteNamed2, "b"));
		Assert.assertEquals("concreteNamed2", 1, features(concreteNamed2).size());
		EClass concreteNamed3 = (EClass) type(ePackage, "ConcreteNamed3");
		Assert.assertNotNull("concreteNamed3", concreteNamed3);
		Assert.assertEquals("concreteNamed3", 2, concreteNamed3.getESuperTypes().size());
		Assert.assertTrue(concreteNamed3.getESuperTypes().contains(subNamed2));
		Assert.assertTrue(concreteNamed3.getESuperTypes().contains(subNamed3));
		Assert.assertNotNull("c", feature(concreteNamed3, "c"));
		Assert.assertEquals("concreteNamed3", 1, features(concreteNamed3).size());
	}

	@Test
	public void testSingleFeatures() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: featureA=INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		Assert.assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EInt");
	}

	@Test
	public void testCommonTerminalsFeatureTypes() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: featureA=ID featureB=INT featureC=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		Assert.assertEquals(3, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt");
		assertAttributeConfiguration(ruleA, 2, "featureC", "EString");
	}

	@Test
	public void testCardinalityOfFeatures() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: featureA?=ID featureB=INT featureC+=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		Assert.assertEquals(3, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt", 0, 1);
		assertAttributeConfiguration(ruleA, 2, "featureC", "EString", 0, -1);
	}

	@Test
	public void testOptionalAssignmentsInGroup() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: (featureA?='abstract' featureB+=INT)?;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(1, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		Assert.assertEquals(2, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt", 0, -1);
	}

	@Test
	public void testFeaturesAndInheritanceOptionalRuleCall() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB? featureA=INT; RuleB: featureB=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass ruleB = (EClass) type(ePackage, "RuleB");
		Assert.assertNotNull(ruleB);
		Assert.assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EInt");
		Assert.assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
	}

	@Test
	public void testFeaturesAndInheritanceMandatoryRuleCall() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB featureA=INT; RuleB: featureB=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass ruleB = (EClass) type(ePackage, "RuleB");
		Assert.assertNotNull(ruleB);
		Assert.assertEquals(0, ruleA.getEAttributes().size());
		Assert.assertEquals(2, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureA", "EInt");
		assertAttributeConfiguration(ruleB, 1, "featureB", "EString");
	}

	@Test
	public void testFeaturesAndInheritanceOfMandatoryAlternativeRuleCalls() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: (RuleB|RuleC featureC1=ID) featureA=ID; RuleB: featureB=ID; RuleC: featureC2=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(3, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass ruleB = (EClass) type(ePackage, "RuleB");
		Assert.assertNotNull(ruleB);
		EClass ruleC = (EClass) type(ePackage, "RuleC");
		Assert.assertNotNull(ruleC);
		Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
		Assert.assertEquals(1, ruleB.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(ruleB.getESuperTypes(), null));
		Assert.assertEquals(1, ruleC.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(ruleC.getESuperTypes(), null));
		Assert.assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
		Assert.assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
		Assert.assertEquals(2, ruleC.getEAttributes().size());
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
		assertAttributeConfiguration(ruleC, 1, "featureC2", "EString");
	}

	@Test
	public void testFeaturesAndInheritanceOfOptionalOptionalRuleCalls() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: (RuleB|RuleC featureC1=ID)? featureA=ID; RuleB: featureB=ID; RuleC: featureC2=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(3, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass ruleB = (EClass) type(ePackage, "RuleB");
		Assert.assertNotNull(ruleB);
		EClass ruleC = (EClass) type(ePackage, "RuleC");
		Assert.assertNotNull(ruleC);
		Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
		Assert.assertEquals(1, ruleB.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(ruleB.getESuperTypes(), null));
		Assert.assertEquals(1, ruleC.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(ruleC.getESuperTypes(), null));
		Assert.assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
		Assert.assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
		Assert.assertEquals(2, ruleC.getEAttributes().size());
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
		assertAttributeConfiguration(ruleC, 1, "featureC2", "EString");
	}

	@Test
	public void testFeaturesAndInheritanceOfNestedRuleCalls() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA: ((RuleB|RuleC featureC1=ID) featureBC=ID | (RuleC|RuleD featureD1=ID) featureCD=ID) featureA=ID;";
		grammar = grammar + " RuleB: featureB2=ID;";
		grammar = grammar + " RuleC: featureC2=ID;";
		grammar = grammar + " RuleD: featureD2=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass ruleB = (EClass) type(ePackage, "RuleB");
		Assert.assertNotNull(ruleB);
		EClass ruleC = (EClass) type(ePackage, "RuleC");
		Assert.assertNotNull(ruleC);
		EClass ruleD = (EClass) type(ePackage, "RuleD");
		Assert.assertNotNull(ruleD);
		Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
		Assert.assertEquals(1, ruleB.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(ruleB.getESuperTypes(), null));
		Assert.assertEquals(1, ruleC.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(ruleC.getESuperTypes(), null));
		Assert.assertEquals(1, ruleD.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(ruleD.getESuperTypes(), null));
		Assert.assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
		Assert.assertEquals(2, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureBC", "EString");
		assertAttributeConfiguration(ruleB, 1, "featureB2", "EString");
		Assert.assertEquals(4, ruleC.getEAttributes().size());
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
		assertAttributeConfiguration(ruleC, 1, "featureBC", "EString");
		assertAttributeConfiguration(ruleC, 2, "featureCD", "EString");
		assertAttributeConfiguration(ruleC, 3, "featureC2", "EString");
		Assert.assertEquals(3, ruleD.getEAttributes().size());
		assertAttributeConfiguration(ruleD, 0, "featureD1", "EString");
		assertAttributeConfiguration(ruleD, 1, "featureCD", "EString");
		assertAttributeConfiguration(ruleD, 2, "featureD2", "EString");
	}

	@Test
	public void testFeaturesAndInheritanceOfNestedRuleCalls_02() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA: ((RuleB|RuleC featureC1=ID)? featureABC=ID | (RuleC|RuleD featureD1=ID) featureCD=ID) featureA=ID;";
		grammar = grammar + " RuleB: featureB2=ID;";
		grammar = grammar + " RuleC: featureC2=ID;";
		grammar = grammar + " RuleD: featureD2=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass ruleB = (EClass) type(ePackage, "RuleB");
		Assert.assertNotNull(ruleB);
		EClass ruleC = (EClass) type(ePackage, "RuleC");
		Assert.assertNotNull(ruleC);
		EClass ruleD = (EClass) type(ePackage, "RuleD");
		Assert.assertNotNull(ruleD);
		Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
		Assert.assertEquals(1, ruleB.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(ruleB.getESuperTypes(), null));
		Assert.assertEquals(1, ruleC.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(ruleC.getESuperTypes(), null));
		Assert.assertEquals(1, ruleD.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(ruleD.getESuperTypes(), null));
		Assert.assertEquals(2, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureABC", "EString");
		assertAttributeConfiguration(ruleA, 1, "featureA", "EString");
		Assert.assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB2", "EString");
		Assert.assertEquals(3, ruleC.getEAttributes().size());
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString");
		assertAttributeConfiguration(ruleC, 1, "featureCD", "EString");
		assertAttributeConfiguration(ruleC, 2, "featureC2", "EString");
		Assert.assertEquals(3, ruleD.getEAttributes().size());
		assertAttributeConfiguration(ruleD, 0, "featureD1", "EString");
		assertAttributeConfiguration(ruleD, 1, "featureCD", "EString");
		assertAttributeConfiguration(ruleD, 2, "featureD2", "EString");
	}

	@Test
	public void testFeaturesAndInheritanceOfActions01() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: ({Add.a=current} '+'|{Sub.a=current} '-') featureAS=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(3, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass add = (EClass) type(ePackage, "Add");
		Assert.assertNotNull(add);
		EClass sub = (EClass) type(ePackage, "Sub");
		Assert.assertNotNull(sub);
		Assert.assertTrue(ruleA.getESuperTypes().isEmpty());
		Assert.assertEquals(1, add.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(add.getESuperTypes(), null));
		Assert.assertEquals(1, sub.getESuperTypes().size());
		Assert.assertEquals(ruleA, Iterables.getFirst(sub.getESuperTypes(), null));
		Assert.assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureAS", "EString");
		Assert.assertEquals(1, ruleA.getEReferences().size());
		assertReferenceConfiguration(ruleA, 0, "a", "RuleA", true, 0, 1);
		Assert.assertEquals(0, add.getEAttributes().size());
		Assert.assertEquals(0, add.getEReferences().size());
		Assert.assertEquals(0, sub.getEAttributes().size());
		Assert.assertEquals(0, sub.getEReferences().size());
	}

	@Test
	public void testFeaturesAndInheritanceOfActions02() throws Exception {
		String grammar = "";
		grammar = grammar
				+ "grammar org.eclipse.xtext.testlanguages.ActionTestLanguage with org.eclipse.xtext.common.Terminals ";
		grammar = grammar + "generate ActionLang";
		grammar = grammar + " 'http://www.eclipse.org/2008/tmf/xtext/ActionLang'";
		grammar = grammar + "";
		grammar = grammar + " Model:";
		grammar = grammar + " (children+=Element)*;";
		grammar = grammar + "";
		grammar = grammar + " Element returns Type:";
		grammar = grammar + " Item ( { Item.items+=current } items+=Item );";
		grammar = grammar + "";
		grammar = grammar + " Item returns Type:";
		grammar = grammar + " { Thing.content=current } name=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass model = (EClass) type(ePackage, "Model");
		Assert.assertNotNull(model);
		EClass type = (EClass) type(ePackage, "Type");
		Assert.assertNotNull(type);
		EClass item = (EClass) type(ePackage, "Item");
		Assert.assertNotNull(item);
		EClass thing = (EClass) type(ePackage, "Thing");
		Assert.assertNotNull(thing);
		Assert.assertEquals(0, model.getESuperTypes().size());
		Assert.assertEquals(0, type.getESuperTypes().size());
		Assert.assertEquals(1, item.getESuperTypes().size());
		Assert.assertSame(type, Iterables.getFirst(item.getESuperTypes(), null));
		Assert.assertEquals(1, thing.getESuperTypes().size());
		Assert.assertSame(type, thing.getESuperTypes().get(0));
	}

	@Test
	public void testAssignedRuleCall() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RuleA: callA1=RuleB callA2+=RuleB simpleFeature=ID;\n" +
				"RuleB: featureB=ID;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass ruleB = (EClass) type(ePackage, "RuleB");
		Assert.assertNotNull(ruleB);
		Assert.assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "simpleFeature", "EString");
		Assert.assertEquals(2, ruleA.getEReferences().size());
		assertReferenceConfiguration(ruleA, 0, "callA1", "RuleB", true, 0, 1);
		assertReferenceConfiguration(ruleA, 1, "callA2", "RuleB", true, 0, -1);
		Assert.assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString");
	}

	@Test
	public void testAssignedCrossReference() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: refA1=[TypeB] refA2+=[TypeB|RuleB] simpleFeature=ID; RuleB returns TypeB: featureB=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(2, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "simpleFeature", "EString");
		Assert.assertEquals(2, ruleA.getEReferences().size());
		assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", false, 0, 1);
		assertReferenceConfiguration(ruleA, 1, "refA2", "TypeB", false, 0, -1);
		Assert.assertEquals(1, typeB.getEAttributes().size());
		assertAttributeConfiguration(typeB, 0, "featureB", "EString");
	}

	@Test
	public void testAssignedParenthesizedElement() throws Exception {
		String grammar = " grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA: featureA1?=(RuleB) refA1=(RuleB) refA2=(RuleB|RuleC) refA3+=(RuleB|RuleC|RuleD) refA4=(RuleB|RuleD) featureA2+=('a'|'b');";
		grammar = grammar + " RuleB returns TypeB: RuleC? featureB=ID;";
		grammar = grammar + " RuleC: featureC=ID;";
		grammar = grammar + " RuleD returns TypeB: featureD=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(3, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		Assert.assertEquals(0, ruleA.getESuperTypes().size());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertEquals(0, typeB.getESuperTypes().size());
		EClass ruleC = (EClass) type(ePackage, "RuleC");
		Assert.assertNotNull(ruleC);
		Assert.assertEquals(1, ruleC.getESuperTypes().size());
		Assert.assertEquals(typeB, Iterables.getFirst(ruleC.getESuperTypes(), null));
		Assert.assertEquals(2, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA1", "EBoolean");
		assertAttributeConfiguration(ruleA, 1, "featureA2", "EString", 0, -1);
		Assert.assertEquals(4, ruleA.getEReferences().size());
		assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", true, 0, 1);
		assertReferenceConfiguration(ruleA, 1, "refA2", "TypeB", true, 0, 1);
		assertReferenceConfiguration(ruleA, 2, "refA3", "TypeB", true, 0, -1);
		assertReferenceConfiguration(ruleA, 3, "refA4", "TypeB", true, 0, 1);
	}

	@Test
	public void testAssignedKeyword() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: featureA?=('+'|'-') featureB=('*'|'/');";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(1, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertEquals(2, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1);
		assertAttributeConfiguration(ruleA, 1, "featureB", "EString", 0, 1);
	}

	@Test
	public void testImportWithoutAlias() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' import 'http://www.eclipse.org/emf/2002/Ecore' RuleA: feature=ID;";
		getEPackageFromGrammar(grammar);
	}

	@Test
	public void testGenerateTwoModels() throws Exception {
		String grammar = "";
		grammar = grammar + " grammar test with org.eclipse.xtext.common.Terminals";
		grammar = grammar + " generate t1 'http://t1'";
		grammar = grammar + " generate t2 'http://t2' as t2";
		grammar = grammar + " RuleA: featureA=ID;";
		grammar = grammar + " RuleB returns t2::TypeB: featureB=ID;";
		List<EPackage> ePackages = getEPackagesFromGrammar(grammar, 0);
		Assert.assertEquals(2, ePackages.size());
		EPackage t1 = Iterables.getFirst(ePackages, null);
		Assert.assertEquals("t1", t1.getName());
		Assert.assertEquals(1, t1.getEClassifiers().size());
		EClassifier ruleA = type(t1, "RuleA");
		Assert.assertNotNull(ruleA);
		EPackage t2 = ePackages.get(1);
		Assert.assertEquals(1, t2.getEClassifiers().size());
		Assert.assertEquals("t2", t2.getName());
		EClassifier typeB = type(t2, "TypeB");
		Assert.assertNotNull(typeB);
	}

	@Test
	public void testUseSameModelAlias() throws Exception {
		String grammar = "";
		grammar = grammar + " grammar test with org.eclipse.xtext.common.Terminals";
		grammar = grammar + " generate t1 'http://t1' as target";
		grammar = grammar + " generate t2 'http://t2' as target";
		grammar = grammar + " RuleA: featureA=ID;";
		grammar = grammar + " RuleB returns target::TypeB: featureB=ID;";
		errorAcceptorMock.acceptError(TransformationErrorCode.AliasForMetamodelAlreadyExists,
				TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
		errorAcceptorMock.acceptError(TransformationErrorCode.UnknownMetaModelAlias, TestErrorAcceptor.ANY_STRING,
				TestErrorAcceptor.ANY_EOBJECT);
		errorAcceptorMock.acceptError(TransformationErrorCode.UnknownMetaModelAlias, TestErrorAcceptor.ANY_STRING,
				TestErrorAcceptor.ANY_EOBJECT);
		List<EPackage> ePackages = getEPackagesFromGrammar(grammar, 5);
		Assert.assertEquals(0, ePackages.size());
	}

	@Test
	public void testModifyingSealedModel() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' import 'http://www.eclipse.org/emf/2002/Ecore' as ecore RuleA returns ecore::SomeNewTypeA: feature=ID;";
		errorAcceptorMock.acceptError(TransformationErrorCode.CannotCreateTypeInSealedMetamodel,
				TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
		EPackage result = getEPackageFromGrammar(grammar, 2);
		Assert.assertTrue(result.getEClassifiers().isEmpty());
	}

	@Test
	public void testImportingUnknownModel() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' import 'unknown-scheme://www.unknownModel' as unknownModel RuleA: feature=ID;";
		getEPackageFromGrammar(grammar, 1);
	}

	@Test
	public void testMoreThanOneRuleCall() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB RuleC; RuleB: featureB=ID; RuleC: featureC=ID;";
		errorAcceptorMock.acceptError(TransformationErrorCode.MoreThanOneTypeChangeInOneRule,
				TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
		getEPackageFromGrammar(grammar, 1);
	}

	@Test
	public void testRuleCallAndAction() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB {TypeC.B = current}; RuleB: featureB=ID;";
		getEPackageFromGrammar(grammar);
	}

	@Test
	public void testRuleCallActionAndRuleCall() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB {TypeC.B = current} RuleB; RuleB: featureB=ID;";
		errorAcceptorMock.acceptError(TransformationErrorCode.MoreThanOneTypeChangeInOneRule,
				TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
		getEPackageFromGrammar(grammar, 1);
	}

	@Test
	public void testAddingFeatureTwice() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA returns TypeA: featureA=ID; RuleB returns TypeA: featureA=STRING;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(1, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) ePackage.getEClassifier("TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertEquals(1, typeA.getEAttributes().size());
		assertAttributeConfiguration(typeA, 0, "featureA", "EString");
	}

	@Test
	public void testAddingDifferentFeaturesWithSameName01() throws Exception {
		String grammar = " grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA returns TypeA: featureA=ID; RuleB returns TypeA: featureA=INT;";
		errorAcceptorMock.acceptError(TransformationErrorCode.NoCompatibleFeatureTypeAvailable,
				TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT);
		EPackage ePackage = getEPackageFromGrammar(grammar, 1);
		Assert.assertEquals(1, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertEquals(1, typeA.getEAttributes().size());
		assertAttributeConfiguration(typeA, 0, "featureA", "EString");
	}

	@Test
	public void testAddingDifferentFeaturesWithSameName02() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar + " RuleA returns TypeA: featureA=RuleD;";
		grammar = grammar + " RuleB returns TypeA: featureA=RuleC;";
		grammar = grammar + " RuleC: RuleD;";
		grammar = grammar + " RuleD: featureD=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(3, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		EClass ruleC = (EClass) type(ePackage, "RuleC");
		Assert.assertNotNull(ruleC);
		EClass ruleD = (EClass) type(ePackage, "RuleD");
		Assert.assertNotNull(ruleD);
		Assert.assertEquals(1, typeA.getEReferences().size());
		assertReferenceConfiguration(typeA, 0, "featureA", "RuleC", true, 0, 1);
	}

	@Test
	public void testAddingDifferentFeaturesWithSameName03() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar + " RuleA returns TypeA: featureA1=ID featureA2=RuleD featureA3=RuleC;";
		grammar = grammar + " RuleB returns TypeA: featureA2=RuleC featureA4=INT;";
		grammar = grammar + " RuleC: featureC=INT;";
		grammar = grammar + " RuleD: featureD=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(3, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		EClass ruleC = (EClass) type(ePackage, "RuleC");
		Assert.assertNotNull(ruleC);
		EClass ruleD = (EClass) type(ePackage, "RuleD");
		Assert.assertNotNull(ruleD);
		Assert.assertEquals(2, typeA.getEAllAttributes().size());
		assertAttributeConfiguration(typeA, 0, "featureA1", "EString");
		assertAttributeConfiguration(typeA, 1, "featureA4", "EInt");
		Assert.assertEquals(2, typeA.getEReferences().size());
		assertReferenceConfiguration(typeA, 0, "featureA2", "EObject", true, 0, 1);
		assertReferenceConfiguration(typeA, 1, "featureA3", "RuleC", true, 0, 1);
	}

	@Test
	public void testUplift01() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar + " RuleA: (RuleB|RuleC) featureA=ID;";
		grammar = grammar + " RuleB: featureB=INT;";
		grammar = grammar + " RuleC: (featureA=ID)?;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(3, ePackage.getEClassifiers().size());
		EClass ruleA = (EClass) type(ePackage, "RuleA");
		Assert.assertNotNull(ruleA);
		EClass ruleB = (EClass) type(ePackage, "RuleB");
		Assert.assertNotNull(ruleB);
		EClass ruleC = (EClass) type(ePackage, "RuleC");
		Assert.assertNotNull(ruleC);
		Assert.assertEquals(1, ruleA.getEAttributes().size());
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString");
		Assert.assertEquals(1, ruleB.getEAttributes().size());
		assertAttributeConfiguration(ruleB, 0, "featureB", "EInt");
		Assert.assertEquals(0, ruleC.getEAttributes().size());
	}

	@Test
	public void testCallOfUndeclaredRule() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar + " RuleA: CallOfUndeclaredRule featureA=ID;";
		errorAcceptorMock.acceptError(TransformationErrorCode.NoSuchRuleAvailable, TestErrorAcceptor.ANY_STRING,
				TestErrorAcceptor.ANY_EOBJECT);
		EPackage ePackage = getEPackageFromGrammar(grammar, 1);
		Assert.assertEquals(1, ePackage.getEClassifiers().size());
		Assert.assertEquals("RuleA", Iterables.getFirst(ePackage.getEClassifiers(), null).getName());
	}

	@Test
	public void testExpressionLikeLangauge() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " Ex :\tAtom  ({ChainExpression.left+=current} operator=('+'|'-'|'*'|'/') right=Atom )*;Atom returns Ex :   Number |  '(' Ex ')';Number : value=INT;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass classifier = (EClass) type(ePackage, "Ex");
		Assert.assertEquals(0, features(classifier).size());
	}

	@Test
	public void testClassNameEString() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar + "Start returns EString: id=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass classifier = (EClass) type(ePackage, "EString");
		Assert.assertEquals("EString", classifier.getName());
		EStructuralFeature feature = feature(classifier, "id");
		Assert.assertNotNull(feature);
		Assert.assertEquals("EString", feature.getEType().getName());
		Assert.assertFalse(feature.getEType().equals(classifier));
		Assert.assertEquals(EcorePackage.Literals.ESTRING, feature.getEType());
	}

	@Test
	public void testNoException_01() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore generate test 'http://test'\n" +
				"CompositeModel: (model+=Model)+;\n" +
				"Model: id=NestedModelId (':' value=Fraction)? ('#' vector=Vector)? ('+' dots=Dots)? ';'\n" +
				"ModelId returns ecore::EString: ID '.' ID;\n" +
				"NestedModelId : ModelId '.' ModelId;\n" +
				"Fraction returns EBigDecimal: INT ('/' INT)?;\n" +
				"Vector : '(' INT I";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 10);
		for (Resource.Diagnostic d : resource.getErrors()) {
			Assert.assertFalse(d instanceof ExceptionDiagnostic);
		}
	}

	@Test
	public void testNoException_02() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'\n" +
				"Model: (children+=Element)*;\n" +
				"Element returns Type: Item ( { Item.items+=current } items+=Item );\n" +
				"Item returns Type:\t{ T";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		for (Resource.Diagnostic d : resource.getErrors()) {
			Assert.assertFalse(d instanceof ExceptionDiagnostic);
		}
	}

	@Test
	public void testNoException_03() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore generate test 'http://test'\n" +
				"CompositeModel: (type+=EClassifier)+;\n" +
				"EClassifier returns ecore::EClassifier: EDataType | EClass;\n" +
				"EClass returns ecore::EClass: 'class' name=ID;\n" +
				"EDataType returns ecore::EDataType: 'dt' name=ID;";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testNoException_04() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'\n" +
				"Model: WildcardFragment;\n" +
				"fragment WildcardFragment*:;\n";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals("no viable alternative at input ';'",
				Iterables.getFirst(resource.getErrors(), null).getMessage());
	}

	@Test
	public void testNoException_05() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'\n" +
				"Model: WildcardFragment;\n" +
				"fragment WildcardFragment:;\n";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals("no viable alternative at input ';'",
				Iterables.getFirst(resource.getErrors(), null).getMessage());
	}

	@Test
	public void testBug_266440() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore  generate bugreport 'http://bugreport/266440'\n" +
				"CompositeModel: (type+=EClassifier)+;\n" +
				"EClassifier: EDataType | EClass;\n" +
				"EClass: 'class' name=ID;\n" +
				"EDataType: 'dt' name=ID;";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
		Grammar parsedGrammar = (Grammar) Iterables.getFirst(resource.getContents(), null);
		for (AbstractRule rule : parsedGrammar.getRules()) {
			EClassifier classifier = rule.getType().getClassifier();
			EPackage pack = classifier.getEPackage();
			Assert.assertEquals("bugreport", pack.getName());
		}
	}

	@Test
	public void testBug_266807() throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		XtextResource resource = (XtextResource) rs.createResource(URI.createURI("classpath:/" + getClass().getPackage().getName().replace('.',
				'/') + "/Test.xtext"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		resource.load(null);
		for (Resource.Diagnostic d : resource.getErrors()) {
			Assert.fail(d.getMessage());
		}
	}

	@Test
	public void testBug_272566_1() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Model:\n" +
				"   test=Test\n" +
				";\n" +
				"\n" +
				"Test:\n" +
				"   'keyword' WS name=ID\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}

	@Test
	public void testBug_272566_2() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Model:\n" +
				"   test=Test\n" +
				";\n" +
				"\n" +
				"Test:\n" +
				"   'keyword' FooBar name=ID\n" +
				";\n" +
				"FooBar:\n" +
				"\t'zonk' WS WS INT WS;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}

	@Test
	public void testBug_272566_3() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Model:\n" +
				"   test=Test\n" +
				";\n" +
				"\n" +
				"Test:\n" +
				"   'keyword' MyEnum name=ID\n" +
				";\n" +
				"enum MyEnum:\n" +
				"\tA | B;\n";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertFalse(resource.getErrors().toString(), resource.getErrors().isEmpty());
		for (Resource.Diagnostic d : resource.getErrors()) {
			Assert.assertFalse(d instanceof ExceptionDiagnostic);
		}
	}

	@Test
	public void testInheritFromEObject_01() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore  import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/test.ecore' as test  A returns ecore::EObject: B | C;  B returns test::Optional: 'b' optionalString=STRING;  C returns test::Mandatory: 'c' mandatoryString=STRING; ";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testInheritFromEObject_02() throws Exception {
		String grammar = " grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore  Object returns ecore::EObject: {ecore::EInt}; ";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}

	@Test
	public void testInheritFromEObject_03() throws Exception {
		String grammar = " grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore  Object returns ecore::EObject: {ecore::EAnnotation}; ";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Deprecated
	@Test
	public void testPostProcessorHook() throws Exception {
		String xtextGrammar = "grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore  generate test 'http://test' MyRule: myFeature=INT;";
		Grammar grammar = (Grammar) getModel(xtextGrammar);
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
		GeneratedMetamodel testMetamodel = (GeneratedMetamodel) grammar.getMetamodelDeclarations().get(1);
		MockedXtext2EcorePostProcessor postProcessor = new MockedXtext2EcorePostProcessor(testMetamodel);
		transformer.setPostProcessor(postProcessor);
		transformer.transform();
		Assert.assertEquals("process mthde called once", 1, postProcessor.proccessMethCalled());
	}

	@Test
	public void testBug_280413_01() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"EClass returns ecore::EClass: name=ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}

	@Test
	public void testBug_280413_02() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"EClass returns ecore::EClass: name=ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}

	@Test
	public void testBug_280413_03() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.Xtext\n" +
				"generate test 'http://test'\n" +
				"import 'http://www.eclipse.org/2008/Xtext' as xtext\n" +
				"ParserRule returns xtext::ParserRule: name=ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}

	@Test
	public void testBug_280413_04() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage\n" +
				"generate test 'http://test'\n" +
				"import 'classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.ecore' as mm\n" +
				"Atom returns mm::Atom: name=ID;\n";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		TransformationDiagnostic diagnostic = (TransformationDiagnostic) resource.getErrors().get(0);
		Assert.assertEquals(grammar.indexOf("mm::Atom"), diagnostic.getOffset());
		Assert.assertEquals("mm::Atom".length(), diagnostic.getLength());
	}

	@Test
	public void testBug_280393() throws Exception {
		String grammar =
				"grammar foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"generate bar 'http://www.Bar.foo'\n" +
				"\n" +
				"Foo returns ecore::EClass : \n" +
				"\tBar | eSuperTypes+=[ecore::EClass];\n" +
				"\n" +
				"Bar :\n" +
				" \t'bar' eSuperTypes+=[ecore::EAttribute];\n";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}

	@Test
	public void testBug_285140_01() throws Exception {
		String grammar =
				"grammar org.sublang with org.eclipse.xtext.testlanguages.ActionTestLanguage\n" +
				"\n" +
				"import 'http://www.eclipse.org/2008/tmf/xtext/ActionLang' as actionLang\n" +
				"generate sub 'http://www.sublang.org'\n" +
				"\n" +
				"Model returns actionLang::Model:\n" +
				"\tChild ({actionLang::Parent.left=current} right=Child)?;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}

	@Test
	public void testBug_285140_02() throws Exception {
		String grammar =
				"grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage\n" +
				"\n" +
				"import 'http://www.eclipse.org/2008/tmf/xtext/ActionLang' as actionLang\n" +
				"\n" +
				"Model returns actionLang::Model:\n" +
				"\tChild ({actionLang::Parent.left=current} right=Child)?;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}

	@Test
	public void testBug_285140_03() throws Exception {
		String grammar =
				"grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage\n" +
				"\n" +
				"import 'http://www.eclipse.org/2008/tmf/xtext/ActionLang' as actionLang\n" +
				"\n" +
				"Model returns actionLang::Child:\n" +
				"\tChild name=ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}

	@Test
	public void testBug_285140_04() throws Exception {
		String grammar =
				"grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage\n" +
				"\n" +
				"import 'http://www.eclipse.org/2008/tmf/xtext/ActionLang' as actionLang\n" +
				"\n" +
				"Child returns actionLang::Child:\n" +
				"\tChild unknown=ID;\n";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}

	@Test
	public void testBug_286285_01() throws Exception {
		String grammar =
				"grammar language with org.eclipse.xtext.common.Terminals\n" +
				"generate lang 'http://www.language.org'\n" +
				"Model:\n" +
				"\tClass | ID;\n" +
				"Class: name = ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}

	@Test
	public void testBug_287550_01() throws Exception {
		String grammar =
				"grammar language with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://example.xtext.org/MyDsl'\n" +
				"Model: Left | Right;\n" +
				"Left: Delegate;\n" +
				"Right returns Model: Delegate '=';\n" +
				"Delegate returns Left: value=ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}

	@Test
	public void testBug_287698_01() throws Exception {
		String grammar =
				"grammar language with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://example.xtext.org/MyDsl'\n" +
				"Model returns Namespace: {Model} elements+=NamespaceElement;\n" +
				"NamespaceElement: Type | Namespace ;\n" +
				"Type: 'type' name=ID ';';\n" +
				"Namespace: 'namespace' name=ID '{' elements+=Type '}';\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}

	@Test
	public void testBug_287698_02() throws Exception {
		String grammar =
				"grammar language with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://example.xtext.org/MyDsl'\n" +
				"Model returns Namespace: {Model} elements+=(Namespace | Something); \n" +
				"Root: Type | NamespaceElement;\n" +
				"Type: 'type' name=ID ';';\n" +
				"NamespaceElement: Namespace | Something;\n" +
				"Namespace: 'namespace' name=ID '{' elements+=SubSomething '}';\n" +
				"Something: ReturnModel | SubSomething;\n" +
				"SubSomething: 'something' name=ID ';';\n" +
				"ReturnModel returns Model: name=ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}

	@Test
	public void testContainmentVsReference_01() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' EClass: name=ID eSuperTypes+=EClass;";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}

	@Test
	public void testContainmentVsReference_02() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' EClass: name=ID eSuperTypes+=[EClass];";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}

	@Test
	public void testContainmentVsReference_03() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' EReference: name=ID eType=[EClass];";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
	}

	@Test
	public void testContainmentVsReference_04() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore'\n" +
				"EReference: name=ID eType=EClass;\n" +
				"EClass: name=ID;\n";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}

	@Test
	public void testContainmentVsReference_05() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' EReference: name=ID eContainingClass=[EClass];";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}

	@Test
	public void testContainmentVsReference_06() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore'\n" +
				"EReference: name=ID eContainingClass=EClass;\n" +
				"EClass: name=ID;\n";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}

	@Test
	public void testBug296496_01() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
				"ExistingType:\n" +
				"  enumFeature=ExistingEnum stringFeature=ExistingEnum;\n" +
				"enum ExistingEnum:\n" +
				"  SameName | OverriddenLiteral = 'overridden' | DifferentName;\n";
		XtextResource resource = getResourceFromStringAndExpect(grammar, 1);
		Assert.assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
	}

	@Test
	public void testBug296496_02() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
				"generate myDsl 'http://example.xtext.org/MyDsl'\n" +
				"CreatedType:\n" +
				"  enumFeature=ExistingEnum otherEnumFeature=ExistingEnum;\n" +
				"enum ExistingEnum:\n" +
				"  SameName | OverriddenLiteral = 'overridden' | DifferentName;\n";
		XtextResource resource = getResourceFromStringAndExpect(grammarAsString, 0);
		Assert.assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		Grammar grammar = (Grammar) Iterables.getFirst(resource.getContents(), null);
		GeneratedMetamodel generatedMetamodel = (GeneratedMetamodel) grammar.getMetamodelDeclarations().get(1);
		Assert.assertEquals("myDsl", generatedMetamodel.getName());
		EClass createdType = (EClass) type(generatedMetamodel.getEPackage(), "CreatedType");
		Assert.assertEquals(feature(createdType, "enumFeature").getEType(),
				feature(createdType, "otherEnumFeature").getEType());
	}

	@Test
	public void testEclipseIssue1547() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'uri'\n" +
				"Model: element=Element;\n" +
				"enum Element : //das ist ein test\n^false='false' | true='true';\n";
		XtextResource resource = getResourceFromString(grammarAsString);
		Grammar g = (Grammar) resource.getContents().get(0);
		EnumRule enumRule = (EnumRule) g.getRules().get(1);
		EnumLiteralDeclaration eld1 = (EnumLiteralDeclaration) ((Alternatives) enumRule.getAlternatives()).getElements().get(0);
		EnumLiteralDeclaration eld2 = (EnumLiteralDeclaration) ((Alternatives) enumRule.getAlternatives()).getElements().get(1);
		Assert.assertEquals("false", eld1.getEnumLiteral().getName());
		Assert.assertEquals("true", eld2.getEnumLiteral().getName());
	}

	@Test
	public void testBug310122() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://example.xtext.org/MyDsl'\n" +
				"Model: Sub1 | name=ID 'somekeyword';\n" +
				"Sub1 returns Model: '(' Model ')';\n";
		XtextResource resource = getResourceFromString(grammarAsString);
		Grammar grammar = (Grammar) Iterables.getFirst(resource.getContents(), null);
		GeneratedMetamodel generatedMetamodel = (GeneratedMetamodel) Iterables.getFirst(grammar.getMetamodelDeclarations(), null);
		Assert.assertEquals("myDsl", generatedMetamodel.getName());
		Assert.assertEquals(1, generatedMetamodel.getEPackage().getEClassifiers().size());
		EClass createdModel = (EClass) type(generatedMetamodel.getEPackage(), "Model");
		Assert.assertEquals(EcorePackage.Literals.ESTRING, feature(createdModel, "name").getEType());
		for (AbstractRule rule : grammar.getRules()) {
			Assert.assertEquals(createdModel, rule.getType().getClassifier());
		}
	}

	@Test
	public void testOverrideTerminalFragment_01() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage\n" +
				"terminal fragment ESCAPED_CHAR: '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\\');\n";
		getResourceFromString(grammarAsString);
	}

	@Test
	public void testOverrideTerminalFragment_02() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage\n" +
				"terminal ESCAPED_CHAR: '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\\');\n";
		getResourceFromString(grammarAsString);
	}

	@Test
	public void testOverrideTerminalFragment_03() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage\n" +
				"ESCAPED_CHAR: '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\\');\n";
		getResourceFromStringAndExpect(grammarAsString, 1);
	}

	@Test
	public void testOverrideTerminalFragment_04() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage\n" +
				"enum ESCAPED_CHAR: A | B;\n";
		getResourceFromStringAndExpect(grammarAsString, 1);
	}

	@Test
	public void testOverrideTerminalRule_01() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage\n" +
				"terminal fragment ID: 'a'..'z'+;\n";
		getResourceFromStringAndExpect(grammarAsString, 1);
	}

	@Test
	public void testOverrideTerminalRule_02() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage\n" +
				"terminal ID: 'a'..'z'+;\n";
		getResourceFromString(grammarAsString);
	}

	@Test
	public void testOverrideTerminalRule_03() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage\n" +
				"ID: 'a' | 'z';\n";
		getResourceFromStringAndExpect(grammarAsString, 1);
	}

	@Test
	public void testOverrideTerminalRule_04() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage\n" +
				"enum ID: A | B;\n";
		getResourceFromStringAndExpect(grammarAsString, 1);
	}

	@Test
	public void testOverrideDatatypeRule_01() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage\n" +
				"terminal fragment ModelId: 'a'..'z'+;\n";
		getResourceFromStringAndExpect(grammarAsString, 1);
	}

	@Test
	public void testOverrideDatatypeRule_02() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage\n" +
				"terminal ModelId: 'a'..'z'+;\n";
		getResourceFromString(grammarAsString);
	}

	@Test
	public void testOverrideDatatypeRule_03() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage\n" +
				"ModelId: 'a' | 'z';\n";
		getResourceFromString(grammarAsString);
	}

	@Test
	public void testOverrideDatatypeRule_04() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.xtext.ecoreInference.DataTypeRuleWithEnumResultTestLanguage\n" +
				"import 'http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest'\n" +
				"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
				"enum ExistingEnumAsDT returns ExistingEnum: SameName;\n";
		getResourceFromString(grammarAsString);
	}

	@Test
	public void testOverrideEnumRule_01() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
				"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
				"terminal fragment ExistingEnum: 'a'..'z'+;\n";
		getResourceFromStringAndExpect(grammarAsString, 1);
	}

	@Test
	public void testOverrideEnumRule_02() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
				"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
				"terminal ExistingEnum returns ExistingEnum: 'a'..'z'+;\n";
		getResourceFromString(grammarAsString);
	}

	@Test
	public void testOverrideEnumRule_03() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
				"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
				"ExistingEnum returns ExistingEnum: 'a' | 'z';\n";
		getResourceFromString(grammarAsString);
	}

	@Test
	public void testOverrideEnumRule_04() throws Exception {
		String grammarAsString = "grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
				"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
				"enum ExistingEnum: SameName;\n";
		getResourceFromString(grammarAsString);
	}

	@Test
	public void testBug346685_a01() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y')? name+=STRING;";
		grammar = grammar + " RuleB returns TypeB: {TypeB} 'ignore';";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertNotNull(feature(typeA, "name"));
		Assert.assertEquals(1, features(typeA).size());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "TypeC");
		Assert.assertNotNull(typeC);
		Assert.assertNotNull(feature(typeC, "x"));
		Assert.assertEquals(1, features(typeC).size());
		EClass typeD = (EClass) type(ePackage, "TypeD");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "x"));
		Assert.assertEquals(1, features(typeD).size());
	}

	@Test
	public void testBug346685_a02() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y') name+=STRING;";
		grammar = grammar + " RuleB returns TypeB: {TypeB} 'ignore';";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertTrue(features(typeA).isEmpty());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "TypeC");
		Assert.assertNotNull(typeC);
		Assert.assertNotNull(feature(typeC, "x"));
		Assert.assertNotNull(feature(typeC, "name"));
		Assert.assertEquals(2, features(typeC).size());
		EClass typeD = (EClass) type(ePackage, "TypeD");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "x"));
		Assert.assertNotNull(feature(typeD, "name"));
		Assert.assertEquals(2, features(typeD).size());
	}

	@Test
	public void testBug346685_a03() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y')? name+=STRING;";
		grammar = grammar + " RuleB returns TypeB: {TypeB} name+=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertNotNull(feature(typeA, "name"));
		Assert.assertEquals(1, features(typeA).size());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "TypeC");
		Assert.assertNotNull(typeC);
		Assert.assertNotNull(feature(typeC, "x"));
		Assert.assertEquals(1, features(typeC).size());
		EClass typeD = (EClass) type(ePackage, "TypeD");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "x"));
		Assert.assertEquals(1, features(typeD).size());
	}

	@Test
	public void testBug346685_a04() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y') name+=STRING;";
		grammar = grammar + " RuleB returns TypeB: {TypeB} name+=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertNotNull(feature(typeA, "name"));
		Assert.assertEquals(1, features(typeA).size());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "TypeC");
		Assert.assertNotNull(typeC);
		Assert.assertNotNull(feature(typeC, "x"));
		Assert.assertEquals(1, features(typeC).size());
		EClass typeD = (EClass) type(ePackage, "TypeD");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "x"));
		Assert.assertEquals(1, features(typeD).size());
	}

	@Test
	public void testBug346685_a05() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA returns TypeA: RuleB? ({TypeC.x=current} 'x' | {TypeD.x=current} 'y')? name+=STRING;";
		grammar = grammar + " RuleB returns TypeB: {TypeB} 'ignore';";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertNotNull(feature(typeA, "name"));
		Assert.assertEquals(1, features(typeA).size());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "TypeC");
		Assert.assertNotNull(typeC);
		Assert.assertNotNull(feature(typeC, "x"));
		Assert.assertEquals(1, features(typeC).size());
		EClass typeD = (EClass) type(ePackage, "TypeD");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "x"));
		Assert.assertEquals(1, features(typeD).size());
	}

	@Test
	public void testBug346685_a06() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA returns TypeA: RuleB? ({TypeC.x=current} 'x' | {TypeD.x=current} 'y') name+=STRING;";
		grammar = grammar + " RuleB returns TypeB: {TypeB} 'ignore';";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertTrue(features(typeA).isEmpty());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "TypeC");
		Assert.assertNotNull(typeC);
		Assert.assertNotNull(feature(typeC, "x"));
		Assert.assertNotNull(feature(typeC, "name"));
		Assert.assertEquals(2, features(typeC).size());
		EClass typeD = (EClass) type(ePackage, "TypeD");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "x"));
		Assert.assertNotNull(feature(typeD, "name"));
		Assert.assertEquals(2, features(typeD).size());
	}

	@Test
	public void testBug346685_a07() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA returns TypeA: RuleB? ({TypeC.x=current} 'x' | {TypeD.x=current} 'y')? name+=STRING;";
		grammar = grammar + " RuleB returns TypeB: {TypeB} name+=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertNotNull(feature(typeA, "name"));
		Assert.assertEquals(1, features(typeA).size());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "TypeC");
		Assert.assertNotNull(typeC);
		Assert.assertNotNull(feature(typeC, "x"));
		Assert.assertEquals(1, features(typeC).size());
		EClass typeD = (EClass) type(ePackage, "TypeD");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "x"));
		Assert.assertEquals(1, features(typeD).size());
	}

	@Test
	public void testBug346685_a08() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA returns TypeA: RuleB? ({TypeC.x=current} 'x' | {TypeD.x=current} 'y') name+=STRING;";
		grammar = grammar + " RuleB returns TypeB: {TypeB} name+=ID;";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertNotNull(feature(typeA, "name"));
		Assert.assertEquals(1, features(typeA).size());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "TypeC");
		Assert.assertNotNull(typeC);
		Assert.assertNotNull(feature(typeC, "x"));
		Assert.assertEquals(1, features(typeC).size());
		EClass typeD = (EClass) type(ePackage, "TypeD");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "x"));
		Assert.assertEquals(1, features(typeD).size());
	}

	@Test
	public void testBug346685_a09() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y' | 'z')? name+=STRING;";
		grammar = grammar + " RuleB returns TypeB: {TypeB} 'ignore';";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertNotNull(feature(typeA, "name"));
		Assert.assertEquals(1, features(typeA).size());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "TypeC");
		Assert.assertNotNull(typeC);
		Assert.assertNotNull(feature(typeC, "x"));
		Assert.assertEquals(1, features(typeC).size());
		EClass typeD = (EClass) type(ePackage, "TypeD");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "x"));
		Assert.assertEquals(1, features(typeD).size());
	}

	@Test
	public void testBug346685_a10() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar
				+ " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y' | 'z') name+=STRING;";
		grammar = grammar + " RuleB returns TypeB: {TypeB} 'ignore';";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(4, ePackage.getEClassifiers().size());
		EClass typeA = (EClass) type(ePackage, "TypeA");
		Assert.assertNotNull(typeA);
		Assert.assertNotNull(feature(typeA, "name"));
		Assert.assertEquals(1, features(typeA).size());
		EClass typeB = (EClass) type(ePackage, "TypeB");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "TypeC");
		Assert.assertNotNull(typeC);
		Assert.assertNotNull(feature(typeC, "x"));
		Assert.assertEquals(1, features(typeC).size());
		EClass typeD = (EClass) type(ePackage, "TypeD");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "x"));
		Assert.assertEquals(1, features(typeD).size());
	}

	@Test
	public void testBug346685_b01() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar + " Model: A ({D.a = current} b = B)? c=C? ;\n";
		grammar = grammar + " A: {A} 'a';\n";
		grammar = grammar + " B: {B} 'c';\n";
		grammar = grammar + " C: {C} 'b';\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(5, ePackage.getEClassifiers().size());
		EClass typeModel = (EClass) type(ePackage, "Model");
		Assert.assertNotNull(typeModel);
		Assert.assertNotNull(feature(typeModel, "c"));
		Assert.assertEquals(1, features(typeModel).size());
		EClass typeA = (EClass) type(ePackage, "A");
		Assert.assertNotNull(typeA);
		Assert.assertTrue(features(typeA).isEmpty());
		Assert.assertEquals(1, typeA.getESuperTypes().size());
		Assert.assertSame(typeModel, Iterables.getFirst(typeA.getESuperTypes(), null));
		EClass typeB = (EClass) type(ePackage, "B");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "C");
		Assert.assertNotNull(typeC);
		Assert.assertTrue(features(typeC).isEmpty());
		EClass typeD = (EClass) type(ePackage, "D");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "a"));
		Assert.assertNotNull(feature(typeD, "b"));
		Assert.assertEquals(2, features(typeD).size());
	}

	@Test
	public void testBug346685_b02() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar + " Model: A ({D.a = current} b = B) c=C? ;\n";
		grammar = grammar + " A: {A} 'a';\n";
		grammar = grammar + " B: {B} 'c';\n";
		grammar = grammar + " C: {C} 'b';\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(5, ePackage.getEClassifiers().size());
		EClass typeModel = (EClass) type(ePackage, "Model");
		Assert.assertNotNull(typeModel);
		Assert.assertTrue(features(typeModel).isEmpty());
		EClass typeA = (EClass) type(ePackage, "A");
		Assert.assertNotNull(typeA);
		Assert.assertTrue(features(typeA).isEmpty());
		Assert.assertEquals(1, typeA.getESuperTypes().size());
		Assert.assertSame(typeModel, Iterables.getFirst(typeA.getESuperTypes(), null));
		EClass typeB = (EClass) type(ePackage, "B");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "C");
		Assert.assertNotNull(typeC);
		Assert.assertTrue(features(typeC).isEmpty());
		EClass typeD = (EClass) type(ePackage, "D");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "a"));
		Assert.assertNotNull(feature(typeD, "b"));
		Assert.assertNotNull(feature(typeD, "c"));
		Assert.assertEquals(3, features(typeD).size());
	}

	@Test
	public void testBug346685_b03() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar + " Model: A? ({D.a = current} b = B)? c=C? ;\n";
		grammar = grammar + " A: {A} 'a';\n";
		grammar = grammar + " B: {B} 'c';\n";
		grammar = grammar + " C: {C} 'b';\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(5, ePackage.getEClassifiers().size());
		EClass typeModel = (EClass) type(ePackage, "Model");
		Assert.assertNotNull(typeModel);
		Assert.assertNotNull(feature(typeModel, "c"));
		Assert.assertEquals(1, features(typeModel).size());
		EClass typeA = (EClass) type(ePackage, "A");
		Assert.assertNotNull(typeA);
		Assert.assertTrue(features(typeA).isEmpty());
		Assert.assertEquals(1, typeA.getESuperTypes().size());
		Assert.assertSame(typeModel, Iterables.getFirst(typeA.getESuperTypes(), null));
		EClass typeB = (EClass) type(ePackage, "B");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "C");
		Assert.assertNotNull(typeC);
		Assert.assertTrue(features(typeC).isEmpty());
		EClass typeD = (EClass) type(ePackage, "D");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "a"));
		Assert.assertNotNull(feature(typeD, "b"));
		Assert.assertEquals(2, features(typeD).size());
	}

	@Test
	public void testBug346685_b04() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'";
		grammar = grammar + " Model: A? ({D.a = current} b = B) c=C? ;\n";
		grammar = grammar + " A: {A} 'a';\n";
		grammar = grammar + " B: {B} 'c';\n";
		grammar = grammar + " C: {C} 'b';\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		Assert.assertEquals(5, ePackage.getEClassifiers().size());
		EClass typeModel = (EClass) type(ePackage, "Model");
		Assert.assertNotNull(typeModel);
		Assert.assertTrue(features(typeModel).isEmpty());
		EClass typeA = (EClass) type(ePackage, "A");
		Assert.assertNotNull(typeA);
		Assert.assertTrue(features(typeA).isEmpty());
		Assert.assertEquals(1, typeA.getESuperTypes().size());
		Assert.assertSame(typeModel, Iterables.getFirst(typeA.getESuperTypes(), null));
		EClass typeB = (EClass) type(ePackage, "B");
		Assert.assertNotNull(typeB);
		Assert.assertTrue(features(typeB).isEmpty());
		EClass typeC = (EClass) type(ePackage, "C");
		Assert.assertNotNull(typeC);
		Assert.assertTrue(features(typeC).isEmpty());
		EClass typeD = (EClass) type(ePackage, "D");
		Assert.assertNotNull(typeD);
		Assert.assertNotNull(feature(typeD, "a"));
		Assert.assertNotNull(feature(typeD, "b"));
		Assert.assertNotNull(feature(typeD, "c"));
		Assert.assertEquals(3, features(typeD).size());
	}

	@Test
	public void testBug413171_01() throws Exception {
		Grammar grammar = (Grammar) getModel(readFileIntoString("org/eclipse/xtext/xtext/ecoreInference/Bug413171_01.xtext.txt"));
		AbstractRule parserRule = grammar.getRules().get(2);
		EClassifier classifier = parserRule.getType().getClassifier();
		Assert.assertTrue(parserRule.getName(), classifier instanceof EDataType);
	}

	@Test
	public void testBug413171_02() throws Exception {
		Grammar grammar = (Grammar) getModel(readFileIntoString("org/eclipse/xtext/xtext/ecoreInference/Bug413171_02.xtext.txt"));
		AbstractRule parserRule = grammar.getRules().get(2);
		EClassifier classifier = parserRule.getType().getClassifier();
		Assert.assertTrue(parserRule.getName(), classifier instanceof EDataType);
	}

	@Test
	public void testBug390326() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals";
		grammar = grammar + " generate test 'http://test'";
		grammar = grammar + " Model: A ({B.a = current} b = A)*;\n";
		grammar = grammar + " A: value=ID;\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass clazz = (EClass) type(ePackage, "B");
		EStructuralFeature feature = feature(clazz, "a");
		Assert.assertEquals("Model", feature.getEType().getName());
	}

	@Test
	public void testBug390326_02() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals";
		grammar = grammar + " generate test 'http://test'";
		grammar = grammar + " Model: A ({B.a = current} b = A {C.a=current} c = A)*;\n";
		grammar = grammar + " C returns A: value='c';\n";
		grammar = grammar + " A: value='a';\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass clazzB = (EClass) type(ePackage, "B");
		EStructuralFeature feature = feature(clazzB, "a");
		Assert.assertEquals("Model", feature.getEType().getName());
		EClass clazzC = (EClass) type(ePackage, "C");
		EStructuralFeature featureC_A = feature(clazzC, "a");
		Assert.assertEquals("B", featureC_A.getEType().getName());
	}

	@Test
	public void testBug390326_03() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.common.Terminals";
		grammar = grammar + " generate test 'http://test'";
		grammar = grammar + " Model: Value (({A.a = current} 'a' )|\n";
		grammar = grammar + "               ({B.a = current} 'b' ))*;\n";
		grammar = grammar + " Value: value='a';\n";
		EPackage ePackage = getEPackageFromGrammar(grammar);
		EClass clazzA = (EClass) type(ePackage, "A");
		EStructuralFeature featureA_a = feature(clazzA, "a");
		Assert.assertEquals("Model", featureA_a.getEType().getName());
		EClass clazzB = (EClass) type(ePackage, "B");
		EStructuralFeature featureB_a = feature(clazzB, "a");
		Assert.assertEquals("Model", featureB_a.getEType().getName());
	}

	@Test
	public void testIssue91() throws Exception {
		String grammar =
				"grammar test.Test\n" +
				"generate test 'http://test'\n" +
				"Foo:\n" +
				"bar = BAR\n" +
				";\n" +
				"terminal BAR:\n" +
				"'bar'\n" +
				";\n";
		errorAcceptorMock.acceptError(TransformationErrorCode.NoSuchTypeAvailable,
				"Cannot create datatype BAR. If this is supposed to return EString, make sure you have imported 'http://www.eclipse.org/emf/2002/Ecore'",
				TestErrorAcceptor.ANY_EOBJECT);
		getEPackageFromGrammar(grammar, 1);
	}

	@Test
	public void testTypeAfterAction_01() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: ({ChildA} 'ChildA' | {ChildB} 'ChildB') aString=ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_02() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: ({ChildA} 'ChildA' | {ChildB} 'ChildB' | {ChildC} 'ChildC') aString=ID;\n";
		errorAcceptorMock.acceptError(TransformationErrorCode.CannotCreateTypeInSealedMetamodel,
				"Cannot find compatible feature aString in sealed EClass ChildC from imported package http://multiinheritancetest: The type 'ChildC' does not have a feature 'aString'.",
				TestErrorAcceptor.ANY_EOBJECT);
		getEPackagesFromGrammar(grammar, 1);
	}

	@Test
	public void testTypeAfterAction_03() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: ({ChildA} 'ChildA' | {ChildB} 'ChildB')? aString=ID;\n";
		errorAcceptorMock.acceptError(TransformationErrorCode.CannotCreateTypeInSealedMetamodel,
				"Cannot find compatible feature aString in sealed EClass ParentA from imported package http://multiinheritancetest: The type 'ParentA' does not have a feature 'aString'.",
				TestErrorAcceptor.ANY_EOBJECT);
		getEPackagesFromGrammar(grammar, 1);
	}

	@Test
	public void testTypeAfterAction_04() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"    {ChildA} 'ChildA' {ChildC.someContainment=current}\n" +
				"  | {ChildB} 'ChildB' {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_05() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  ( {ChildA} 'ChildA' {ChildC.someContainment=current}\n" +
				"  | {ChildB} 'ChildB' {ChildC.someContainment=current}\n" +
				"  ) {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_06() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  ( {ChildA} 'ChildA' | {ChildB} 'ChildB' ) {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_07() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  {ChildA} 'ChildA' {ChildC.someContainment=current} 'ChildC' {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_08() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  {ChildA} 'ChildA' ({ChildC.someContainment=current} 'ChildC')+ {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_09() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  {ChildA} 'ChildA' ({ChildC.someContainment=current} 'ChildC')? {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_10() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  {ChildA} 'ChildA' {ChildB.someContainment=current} 'ChildB' aString=ID\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_11() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  {ChildA} 'ChildA' ({ChildB.someContainment=current} 'ChildB')? aString=ID\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_12() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA:\n" +
				"\t( {ChildA} 'ChildA' \n" +
				"\t| {ChildB} 'ChildB'\n" +
				"\t| {ChildC} 'ChildC') parent=ChildA\n" +
				";\n" +
				"ChildA: {ChildA} 'ChildA';\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_13() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA:\n" +
				"\t{ChildC} 'ChildC'\n" +
				"\t( {ChildA.someContainment=current} 'ChildA' \n" +
				"\t| {ChildB.someContainment=current} 'ChildB'\n" +
				"\t) parent=ChildA\n" +
				";\n" +
				"ChildA: {ChildA} 'ChildA';\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_14() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"SomeChild returns ParentA:\n" +
				"\t{ChildC} 'ChildC'\n" +
				"\t( {ChildA.someContainment=current} 'ChildA' \n" +
				"\t| {ChildB.someContainment=current} 'ChildB'\n" +
				"\t)* parent=ChildA\n" +
				";\n" +
				"ChildA: {ChildA} 'ChildA';\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_15() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: ({ChildA} 'ChildA' | {ChildB} 'ChildB') aString=ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_16() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: ({ChildA} 'ChildA' | {ChildB} 'ChildB' | {ChildC} 'ChildC') aString=ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_17() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: ({ChildA} 'ChildA' | {ChildB} 'ChildB')? aString=ID;\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_18() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"    {ChildA} 'ChildA' {ChildC.someContainment=current}\n" +
				"  | {ChildB} 'ChildB' {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_19() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  ( {ChildA} 'ChildA' {ChildC.someContainment=current}\n" +
				"  | {ChildB} 'ChildB' {ChildC.someContainment=current}\n" +
				"  ) {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_20() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  ( {ChildA} 'ChildA' | {ChildB} 'ChildB' ) {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_21() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  {ChildA} 'ChildA' {ChildC.someContainment=current} 'ChildC' {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_22() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  {ChildA} 'ChildA' ({ChildC.someContainment=current} 'ChildC')+ {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_23() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  {ChildA} 'ChildA' ({ChildC.someContainment=current} 'ChildC')? {ChildC.someContainment=current}\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_24() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  {ChildA} 'ChildA' {ChildB.someContainment=current} 'ChildB' aString=ID\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_25() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA: \n" +
				"  {ChildA} 'ChildA' ({ChildB.someContainment=current} 'ChildB')? aString=ID\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_26() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA:\n" +
				"\t( {ChildA} 'ChildA' \n" +
				"\t| {ChildB} 'ChildB'\n" +
				"\t| {ChildC} 'ChildC') parent=ChildA\n" +
				";\n" +
				"ChildA: {ChildA} 'ChildA';\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_27() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA:\n" +
				"\t{ChildC} 'ChildC'\n" +
				"\t( {ChildA.someContainment=current} 'ChildA' \n" +
				"\t| {ChildB.someContainment=current} 'ChildB'\n" +
				"\t) parent=ChildA\n" +
				";\n" +
				"ChildA: {ChildA} 'ChildA';\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testTypeAfterAction_28() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"SomeChild returns ParentA:\n" +
				"\t{ChildC} 'ChildC'\n" +
				"\t( {ChildA.someContainment=current} 'ChildA' \n" +
				"\t| {ChildB.someContainment=current} 'ChildB'\n" +
				"\t)* parent=ChildA\n" +
				";\n" +
				"ChildA: {ChildA} 'ChildA';\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testAssignObjectAlternative_01() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/multiinheritancetest.ecore'\n" +
				"\n" +
				"ChildA_ returns ChildA:\n" +
				"\tsomeContainment=(ChildA|ChildB)\n" +
				";\n" +
				"ChildA: {ChildA} 'ChildA';\n" +
				"ChildB: {ChildB} 'ChildB';\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}

	@Test
	public void testAssignObjectAlternative_02() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate multiinheritancetest 'multiinheritancetest'\n" +
				"\n" +
				"DeclParentA returns ParentA:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentA} attributeInParentA=ID;\n" +
				"DeclParentB returns ParentB:\n" +
				"  DeclChildA | DeclChildB | DeclChildC | {ParentB} someContainment=DeclParentA;\n" +
				"DeclChildA returns ChildA:\n" +
				"  aString=ID parent=DeclParentA;\n" +
				"DeclChildB returns ChildB:\n" +
				"  aString=ID parent=DeclParentB;\n" +
				"DeclChildC returns ChildC:\n" +
				"  parent=DeclChildA;\n" +
				"\n" +
				"\n" +
				"ChildA:\n" +
				"\tsomeContainment=(DeclChildA|DeclChildB)\n" +
				";\n";
		XtextResource resource = getResourceFromString(grammar);
		Assert.assertTrue(resource.getErrors().isEmpty());
	}
}
