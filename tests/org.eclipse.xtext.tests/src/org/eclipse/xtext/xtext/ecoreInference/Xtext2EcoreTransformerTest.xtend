/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference

import com.google.common.base.Joiner
import java.io.InputStream
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.ContentHandler
import org.eclipse.emf.ecore.resource.Resource.Diagnostic
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.ReferencedMetamodel
import org.eclipse.xtext.TypeRef
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.linking.impl.Linker
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.tests.TestErrorAcceptor
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.xtext.XtextLinker
import org.eclipse.xtext.xtext.ecoreInference.Xtext2EcoreTransformerTest.MyErrorAcceptor
import org.junit.Test
import org.eclipse.xtext.xtext.XtextLinker.PackageRemover

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * @see https://www.eclipse.org/Xtext/documentation/301_grammarlanguage.html#metamodel-inference
 */
class Xtext2EcoreTransformerTest extends AbstractXtextTests {
	/**
	 * @author Dennis Hübner - Initial contribution and API
	 */
	@FinalFieldsConstructor
	private static final class MockedXtext2EcorePostProcessor implements IXtext2EcorePostProcessor {
		int called = 0
		val GeneratedMetamodel testMetamodel

		override void process(GeneratedMetamodel metamodel) {
			if (testMetamodel.equals(metamodel)) {
				called++
			}
		}

		def int proccessMethCalled() {
			return called
		}
	}

	TestErrorAcceptor errorAcceptorMock

	@FinalFieldsConstructor
	static class MyErrorAcceptor implements ErrorAcceptor {
		final ErrorAcceptor first
		final ErrorAcceptor second

		override void acceptError(TransformationErrorCode errorCode, String message, EObject element) {
			first.acceptError(errorCode, message, element)
			second.acceptError(errorCode, message, element)
		}
	}

	override void setUp() throws Exception {
		super.setUp()
		errorAcceptorMock = new TestErrorAcceptor()
		EcoreSupportStandaloneSetup.setup()
		with(XtextStandaloneSetup)
	}

	override void tearDown() throws Exception {
		errorAcceptorMock = null
		super.tearDown()
	}

	def private EPackage getEPackageFromGrammar(String xtextGrammar, int expectedErrors) throws Exception {
		val metamodels = getEPackagesFromGrammar(xtextGrammar, expectedErrors)
		assertEquals(1, metamodels.size)
		val result = metamodels.head
		assertNotNull(result)
		return result
	}

	def private EPackage getEPackageFromGrammar(String xtextGrammar) throws Exception {
		return getEPackageFromGrammar(xtextGrammar, 0)
	}

	override XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		var rs = get(XtextResourceSet)
		rs.setClasspathURIContext(getClass())
		val resource = getResourceFactory().createResource(uri) as XtextResource
		rs.getResources().add(resource)
		var XtextLinker linker = new XtextLinker() {
			override protected Xtext2EcoreTransformer createTransformer(Grammar grammar, IDiagnosticConsumer consumer) {
				var result = super.createTransformer(grammar, consumer)
				result.setErrorAcceptor(new MyErrorAcceptor(result.getErrorAcceptor(), errorAcceptorMock))
				return result
			}
		}
		linker.setScopeProvider((resource.getLinker() as XtextLinker).getScopeProvider())
		linker.setLinkingService((resource.getLinker() as Linker).getLinkingService())
		linker.setLinkingHelper((resource.getLinker() as Linker).getLinkingHelper())
		linker.setPackageRemover(new PackageRemover())
		linker.setDiagnosticMessageProvider(new LinkingDiagnosticMessageProvider())
		linker.setCache(new OnChangeEvictingCache())
		resource.setLinker(linker)
		resource.load(in, null)
		return resource
	}

	def private List<EPackage> getEPackagesFromGrammar(String xtextGrammar, int expectedErrors) throws Exception {
		errorAcceptorMock.replay()
		val grammar = getModelAndExpect(xtextGrammar, expectedErrors) as Grammar
		errorAcceptorMock.verify()
		val metamodels = Xtext2EcoreTransformer.doGetGeneratedPackages(grammar)
		assertNotNull(metamodels)
		return metamodels
	}

	def private EAttribute assertAttributeConfiguration(EClass eClass, int attributeIndex, String featureName,
		String featureTypeName) {
		val feature = eClass.getEAttributes().get(attributeIndex)
		assertEquals(featureName, feature.name)
		assertNotNull(feature.EType)
		assertEquals(featureTypeName, feature.EType.name)
		return feature
	}

	def private EAttribute assertAttributeConfiguration(EClass eClass, int attributeIndex, String featureName,
		String featureTypeName, int lowerBound, int upperBound) {
		val feature = assertAttributeConfiguration(eClass, attributeIndex, featureName, featureTypeName)
		assertEquals(lowerBound, feature.getLowerBound())
		assertEquals(upperBound, feature.getUpperBound())
		return feature
	}

	def private EReference assertReferenceConfiguration(EClass eClass, int referenceIndex, String featureName,
		String featureTypeName, boolean isContainment, int lowerBound, int upperBound) {
		val reference = eClass.getEReferences().get(referenceIndex)
		assertEquals(featureName, reference.name)
		assertNotNull(reference.EType)
		assertEquals(featureTypeName, reference.EType.name)
		assertEquals(isContainment, reference.isContainment())
		assertEquals(lowerBound, reference.getLowerBound())
		assertEquals(upperBound, reference.getUpperBound())
		return reference
	}
	
	@Test def void testEscapeChar_01() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			^MyRule: name=^ID;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		val classifiers = ePackage.EClassifiers
		assertEquals(1, classifiers.size)
		val myRuleType = classifiers.head
		assertEquals("MyRule", myRuleType.name)
	}
	
	
	@Test def void testEscapeChar_02() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			^RootRule: ^Sub1 | ^Sub2;
			^Sub1: {^Sub1} 'sub1';
			^Sub2: {^Sub2} 'sub2';
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		val classifiers = ePackage.EClassifiers
		assertEquals(3, classifiers.size)
		assertEquals("RootRule", classifiers.get(0).name)
		assertEquals("Sub1", classifiers.get(1).name)
		assertEquals("Sub2", classifiers.get(2).name)
		
	}
	
	@Test def void testParserRuleFragment_01() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			MyRule: IntFeature;
			fragment IntFeature*: myFeature=INT;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		val classifiers = ePackage.EClassifiers
		assertEquals(1, classifiers.size)
		val myRuleType = classifiers.head
		assertEquals("MyRule", myRuleType.name)
		assertEquals("EInt", myRuleType.feature('myFeature').EType.name)
	}

	@Test def void testParserRuleFragment_02() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			MyRule: IntFeatureHolder;
			fragment IntFeatureHolder: myFeature=INT;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		val classifiers = ePackage.EClassifiers
		assertEquals(2, classifiers.size)
		val myRuleType = classifiers.head
		assertEquals("MyRule", myRuleType.name)
		assertTrue(myRuleType.features.empty)
		val intFeatureHolder = classifiers.last
		assertEquals("EInt", intFeatureHolder.feature('myFeature').EType.name)
		assertTrue(myRuleType.superTypes.contains(intFeatureHolder))
	}
	
	@Test def void testParserRuleFragment_03() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			MyRule: IntFeatureHolder;
			fragment IntFeatureHolder: myFeature=INT NameFeatureHolder;
			fragment NameFeatureHolder: name=STRING;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		val classifiers = ePackage.EClassifiers
		assertEquals(3, classifiers.size)
		val myRuleType = classifiers.head
		assertEquals("MyRule", myRuleType.name)
		assertTrue(myRuleType.features.empty)
		val intFeatureHolder = classifiers.get(1)
		assertEquals("EInt", intFeatureHolder.feature('myFeature').EType.name)
		assertTrue(myRuleType.superTypes.contains(intFeatureHolder))
		val nameFeatureHolder = classifiers.last
		assertEquals("EString", nameFeatureHolder.feature('name').EType.name)
		assertTrue(intFeatureHolder.superTypes.contains(nameFeatureHolder))
	}
	
	@Test def void testParserRuleFragment_04() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			MyRule: Documentable IntFeatureHolder;
			fragment IntFeatureHolder: Documentable myFeature=INT NameFeatureHolder;
			fragment NameFeatureHolder: Documentable name=STRING;
			fragment Documentable*: doc=STRING;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		val classifiers = ePackage.EClassifiers
		assertEquals(3, classifiers.size)
		val myRuleType = classifiers.head
		assertEquals("MyRule", myRuleType.name)
		assertTrue(myRuleType.features.empty)
		val intFeatureHolder = classifiers.get(1)
		assertEquals("EInt", intFeatureHolder.feature('myFeature').EType.name)
		assertEquals(1, intFeatureHolder.features.size)
		val nameFeatureHolder = classifiers.last
		assertEquals("EString", nameFeatureHolder.feature('name').EType.name)
		assertEquals(2, nameFeatureHolder.features.size)
	}
	
	@Test def void testParserRuleFragment_05() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Middle: Top;
			fragment Top: name=ID ({Bottom.prev=current} Top)?;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		val classifiers = ePackage.EClassifiers
		assertEquals(3, classifiers.size)
		val middleType = classifiers.head
		assertEquals("Middle", middleType.name)
		assertTrue(middleType.features.empty)
		val topType = classifiers.get(1)
		assertEquals("EString", topType.feature('name').EType.name)
		assertTrue(middleType.superTypes.contains(topType))
		val bottomType = classifiers.last
		assertEquals("Top", bottomType.feature('prev').EType.name)
		assertTrue(bottomType.superTypes.contains(middleType))
	}
	
	@Test def void testParserRuleFragment_06() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Middle1: Top;
			Middle2: Top;
			fragment Top: name=ID ({Bottom.prev=current} Top)?;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		val classifiers = ePackage.EClassifiers
		assertEquals(4, classifiers.size)
		val middleType1 = classifiers.head
		assertEquals("Middle1", middleType1.name)
		assertTrue(middleType1.features.empty)
		val middleType2 = classifiers.get(1)
		assertEquals("Middle2", middleType2.name)
		assertTrue(middleType2.features.empty)
		val topType = classifiers.get(2)
		assertEquals("EString", topType.feature('name').EType.name)
		assertTrue(middleType1.superTypes.contains(topType))
		assertTrue(middleType2.superTypes.contains(topType))
		val bottomType = classifiers.last
		assertEquals("Top", bottomType.feature('prev').EType.name)
		assertTrue(bottomType.superTypes.contains(middleType1))
		assertTrue(bottomType.superTypes.contains(middleType2))
	}
	
	@Test def void testParserRuleFragment_07() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Middle1: Top;
			Middle2: Top;
			fragment Top: name=ID ({Bottom.prev=current} name=ID)*;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		val classifiers = ePackage.EClassifiers
		assertEquals(4, classifiers.size)
		val middleType1 = classifiers.head
		assertEquals("Middle1", middleType1.name)
		assertTrue(middleType1.features.empty)
		val middleType2 = classifiers.get(1)
		assertEquals("Middle2", middleType2.name)
		assertTrue(middleType2.features.empty)
		val topType = classifiers.get(2)
		assertEquals("EString", topType.feature('name').EType.name)
		assertTrue(middleType1.superTypes.contains(topType))
		assertTrue(middleType2.superTypes.contains(topType))
		val bottomType = classifiers.last
		assertEquals("Top", bottomType.feature('prev').EType.name)
		assertTrue(bottomType.superTypes.contains(middleType1))
		assertTrue(bottomType.superTypes.contains(middleType2))
	}

	@Test def void testTypesOfImplicitSuperGrammar() throws Exception {
		val xtextGrammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			MyRule: myFeature=INT;
		'''
		val grammar = getModel(xtextGrammar) as Grammar
		val transformer = new Xtext2EcoreTransformer(grammar)
		transformer.removeGeneratedPackages()
		transformer.transform()
		// directly from grammar
		val rule = grammar.rules.head
		var TypeRef type = rule.type
		assertNotNull(type)
		assertNotNull(transformer.EClassifierInfos.getInfo(type))
		// ecore data types
		val referenced = GrammarUtil.allMetamodelDeclarations(grammar).get(1) as ReferencedMetamodel
		assertNotNull(referenced)
		assertEquals("ecore", referenced.getAlias())
		assertNull(transformer.EClassifierInfos.getInfo(referenced, "EString"))
		assertNull(transformer.EClassifierInfos.getInfo(referenced, "EInt"))
		var EClassifierInfos parentInfos = transformer.EClassifierInfos.parents.head
		assertNotNull(parentInfos.getInfo(referenced, "EString"))
		assertNotNull(parentInfos.getInfo(referenced, "EInt"))
	}
	
	protected def <T extends EClassifier> type(EPackage pack, String name) {
		return pack.getEClassifier(name) as T
	}
	
	protected def <T extends EStructuralFeature> feature(EClassifier clazz, String name) {
		if (clazz instanceof EClass) {
			return clazz.getEStructuralFeature(name) as T
		}
		return null
	}
	
	protected def superTypes(EClassifier clazz) {
		if (clazz instanceof EClass) {
			return clazz.ESuperTypes
		}
		return emptyList
	}
	
	protected def List<? extends EStructuralFeature> features(EClassifier clazz) {
		if (clazz instanceof EClass) {
			return clazz.EStructuralFeatures
		}
		return emptyList
	}

	@Test def void testRuleWithoutExplicitReturnType() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			MyRule: myFeature=INT;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		val classifiers = ePackage.EClassifiers
		assertEquals(1, classifiers.size)
		val myRuleType = classifiers.head
		assertEquals("MyRule", myRuleType.name)
		assertEquals("myFeature", myRuleType.features.head.name)
	}

	@Test def void testRulesWithExplicitReturnType() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			RuleA returns TypeA: featureA=INT;
			RuleB returns TypeB: featureB= INT;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(2, ePackage.EClassifiers.size)
		assertNotNull(ePackage.type("TypeA"))
		assertNotNull(ePackage.type("TypeB"))
	}

	@Test def void testSimpleHierarchy() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB; RuleB: featureB= INT;'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(2, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var ruleB = ePackage.type("RuleB") as EClass
		assertNotNull(ruleB)
		assertTrue(ruleA.ESuperTypes.isEmpty)
		assertEquals(1, ruleB.ESuperTypes.size)
		var superClass = ruleB.ESuperTypes.head
		assertEquals(ruleA,
			superClass)
	}

	@Test def void testDiamondHierarchy() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' Model: name=ID value=SubNamed1 otherValue=SubNamed2 thirdValue=SubNamed3;Named: SubNamed1 | SubNamed2 | SubNamed3;SubNamed1: ConcreteNamed1 | ConcreteNamed2;SubNamed2: ConcreteNamed2 | ConcreteNamed3;SubNamed3: ConcreteNamed1 | ConcreteNamed3;ConcreteNamed1: name=ID bar=ID foo=ID a=ID;ConcreteNamed2: name=ID bar=ID zonk=ID b=ID;ConcreteNamed3: name=ID foo=ID zonk=ID c=ID;'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(8, ePackage.EClassifiers.size)
		val classifier = ePackage.type("Named")
		assertNotNull(classifier)
		var named = classifier as EClass
		var feature = named.feature("name")
		assertNotNull("name", feature)
		assertEquals("named", 1, named.features.size)
		var subNamed1 = ePackage.type("SubNamed1") as EClass
		assertNotNull("subNamed1", subNamed1)
		assertEquals(1, subNamed1.ESuperTypes.size)
		assertNotNull("bar", subNamed1.feature("bar"))
		assertEquals("subNamed1", 1, subNamed1.features.size)
		var subNamed2 = ePackage.type("SubNamed2") as EClass
		assertNotNull("subNamed2", subNamed2)
		assertEquals(1, subNamed2.ESuperTypes.size)
		assertNotNull("bar", subNamed2.feature("zonk"))
		assertEquals("subNamed2", 1, subNamed2.features.size)
		var subNamed3 = ePackage.type("SubNamed3") as EClass
		assertNotNull("subNamed3", subNamed3)
		assertEquals(1, subNamed3.ESuperTypes.size)
		assertNotNull("bar", subNamed3.feature("foo"))
		assertEquals("subNamed3", 1, subNamed3.features.size)
		var concreteNamed1 = ePackage.type("ConcreteNamed1") as EClass
		assertNotNull("concreteNamed1", concreteNamed1)
		assertEquals("concreteNamed1", 2, concreteNamed1.ESuperTypes.size)
		assertTrue(concreteNamed1.ESuperTypes.contains(subNamed1))
		assertTrue(concreteNamed1.ESuperTypes.contains(subNamed3))
		assertNotNull("a", concreteNamed1.feature("a"))
		assertEquals("concreteNamed1", 1, concreteNamed1.features.size)
		var concreteNamed2 = ePackage.type("ConcreteNamed2") as EClass
		assertNotNull("concreteNamed2", concreteNamed2)
		assertEquals("concreteNamed2", 2, concreteNamed2.ESuperTypes.size)
		assertTrue(concreteNamed2.ESuperTypes.contains(subNamed1))
		assertTrue(concreteNamed2.ESuperTypes.contains(subNamed2))
		assertNotNull("b", concreteNamed2.feature("b"))
		assertEquals("concreteNamed2", 1, concreteNamed2.features.size)
		var concreteNamed3 = ePackage.type("ConcreteNamed3") as EClass
		assertNotNull("concreteNamed3", concreteNamed3)
		assertEquals("concreteNamed3", 2, concreteNamed3.ESuperTypes.size)
		assertTrue(concreteNamed3.ESuperTypes.contains(subNamed2))
		assertTrue(concreteNamed3.ESuperTypes.contains(subNamed3))
		assertNotNull("c", concreteNamed3.feature("c"))
		assertEquals("concreteNamed3", 1, concreteNamed3.features.size)
	}

	@Test def void testSingleFeatures() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: featureA=INT;'''
		var ePackage = getEPackageFromGrammar(grammar)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		assertEquals(1, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA",
			"EInt")
	}

	@Test def void testCommonTerminalsFeatureTypes() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: featureA=ID featureB=INT featureC=STRING;'''
		var ePackage = getEPackageFromGrammar(grammar)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		assertEquals(3, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString")
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt")
		assertAttributeConfiguration(ruleA, 2, "featureC",
			"EString")
	}

	@Test def void testCardinalityOfFeatures() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: featureA?=ID featureB=INT featureC+=STRING;'''
		var ePackage = getEPackageFromGrammar(grammar)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		assertEquals(3, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1)
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt", 0, 1)
		assertAttributeConfiguration(ruleA, 2, "featureC", "EString", 0,
			-1)
	}

	@Test def void testOptionalAssignmentsInGroup() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: (featureA?='abstract' featureB+=INT)?;'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(1, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		assertEquals(2, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1)
		assertAttributeConfiguration(ruleA, 1, "featureB", "EInt", 0,
			-1)
	}

	@Test def void testFeaturesAndInheritanceOptionalRuleCall() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB? featureA=INT; RuleB: featureB=STRING;'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(2, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var ruleB = ePackage.type("RuleB") as EClass
		assertNotNull(ruleB)
		assertEquals(1, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA", "EInt")
		assertEquals(1, ruleB.getEAttributes().size)
		assertAttributeConfiguration(ruleB, 0, "featureB",
			"EString")
	}

	@Test def void testFeaturesAndInheritanceMandatoryRuleCall() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB featureA=INT; RuleB: featureB=STRING;'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(2, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var ruleB = ePackage.type("RuleB") as EClass
		assertNotNull(ruleB)
		assertEquals(0, ruleA.getEAttributes().size)
		assertEquals(2, ruleB.getEAttributes().size)
		assertAttributeConfiguration(ruleB, 0, "featureA", "EInt")
		assertAttributeConfiguration(ruleB, 1, "featureB",
			"EString")
	}

	@Test def void testFeaturesAndInheritanceOfMandatoryAlternativeRuleCalls() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: (RuleB|RuleC featureC1=ID) featureA=ID; RuleB: featureB=ID; RuleC: featureC2=ID;'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(3, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var ruleB = ePackage.type("RuleB") as EClass
		assertNotNull(ruleB)
		var ruleC = ePackage.type("RuleC") as EClass
		assertNotNull(ruleC)
		
		// test inheritance
		assertTrue(ruleA.ESuperTypes.isEmpty)
		assertEquals(1, ruleB.ESuperTypes.size)
		assertEquals(ruleA, ruleB.ESuperTypes.head)
		assertEquals(1, ruleC.ESuperTypes.size)
		assertEquals(ruleA, ruleC.ESuperTypes.head)
		
		// test all features are separated
		assertEquals(1, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString")
		assertEquals(1, ruleB.getEAttributes().size)
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString")
		assertEquals(2, ruleC.getEAttributes().size)
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString")
		assertAttributeConfiguration(ruleC, 1, "featureC2",
			"EString")
	}

	@Test def void testFeaturesAndInheritanceOfOptionalOptionalRuleCalls() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: (RuleB|RuleC featureC1=ID)? featureA=ID; RuleB: featureB=ID; RuleC: featureC2=ID;'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(3, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var ruleB = ePackage.type("RuleB") as EClass
		assertNotNull(ruleB)
		var ruleC = ePackage.type("RuleC") as EClass
		assertNotNull(ruleC)
		
		// test inheritance
		assertTrue(ruleA.ESuperTypes.isEmpty)
		assertEquals(1, ruleB.ESuperTypes.size)
		assertEquals(ruleA, ruleB.ESuperTypes.head)
		assertEquals(1, ruleC.ESuperTypes.size)
		assertEquals(ruleA, ruleC.ESuperTypes.head)
		
		// test all features are separated
		assertEquals(1, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString")
		assertEquals(1, ruleB.getEAttributes().size)
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString")
		assertEquals(2, ruleC.getEAttributes().size)
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString")
		assertAttributeConfiguration(ruleC, 1, "featureC2",
			"EString")
	}

	@Test def void testFeaturesAndInheritanceOfNestedRuleCalls() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar +=
			" RuleA: ((RuleB|RuleC featureC1=ID) featureBC=ID | (RuleC|RuleD featureD1=ID) featureCD=ID) featureA=ID;"
		grammar += " RuleB: featureB2=ID;"
		grammar += " RuleC: featureC2=ID;"
		grammar += " RuleD: featureD2=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var ruleB = ePackage.type("RuleB") as EClass
		assertNotNull(ruleB)
		var ruleC = ePackage.type("RuleC") as EClass
		assertNotNull(ruleC)
		var ruleD = ePackage.type("RuleD") as EClass
		assertNotNull(ruleD)
		
		// test inheritance
		assertTrue(ruleA.ESuperTypes.isEmpty)
		assertEquals(1, ruleB.ESuperTypes.size)
		assertEquals(ruleA, ruleB.ESuperTypes.head)
		assertEquals(1, ruleC.ESuperTypes.size)
		assertEquals(ruleA, ruleC.ESuperTypes.head)
		assertEquals(1, ruleD.ESuperTypes.size)
		assertEquals(ruleA, ruleD.ESuperTypes.head)
		
		// test all features are separated
		assertEquals(1, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString")
		assertEquals(2, ruleB.getEAttributes().size)
		assertAttributeConfiguration(ruleB, 0, "featureBC", "EString")
		assertAttributeConfiguration(ruleB, 1, "featureB2", "EString")
		assertEquals(4, ruleC.getEAttributes().size)
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString")
		assertAttributeConfiguration(ruleC, 1, "featureBC", "EString")
		assertAttributeConfiguration(ruleC, 2, "featureCD", "EString")
		assertAttributeConfiguration(ruleC, 3, "featureC2", "EString")
		assertEquals(3, ruleD.getEAttributes().size)
		assertAttributeConfiguration(ruleD, 0, "featureD1", "EString")
		assertAttributeConfiguration(ruleD, 1, "featureCD", "EString")
		assertAttributeConfiguration(ruleD, 2, "featureD2",
			"EString")
	}

	@Test def void testFeaturesAndInheritanceOfNestedRuleCalls_02() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar +=
			" RuleA: ((RuleB|RuleC featureC1=ID)? featureABC=ID | (RuleC|RuleD featureD1=ID) featureCD=ID) featureA=ID;"
		grammar += " RuleB: featureB2=ID;"
		grammar += " RuleC: featureC2=ID;"
		grammar += " RuleD: featureD2=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var ruleB = ePackage.type("RuleB") as EClass
		assertNotNull(ruleB)
		var ruleC = ePackage.type("RuleC") as EClass
		assertNotNull(ruleC)
		var ruleD = ePackage.type("RuleD") as EClass
		assertNotNull(ruleD)
		
		// test inheritance
		assertTrue(ruleA.ESuperTypes.isEmpty)
		assertEquals(1, ruleB.ESuperTypes.size)
		assertEquals(ruleA, ruleB.ESuperTypes.head)
		assertEquals(1, ruleC.ESuperTypes.size)
		assertEquals(ruleA, ruleC.ESuperTypes.head)
		assertEquals(1, ruleD.ESuperTypes.size)
		assertEquals(ruleA, ruleD.ESuperTypes.head)
		assertEquals(2, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureABC", "EString")
		assertAttributeConfiguration(ruleA, 1, "featureA", "EString")
		assertEquals(1, ruleB.getEAttributes().size)
		assertAttributeConfiguration(ruleB, 0, "featureB2", "EString")
		assertEquals(3, ruleC.getEAttributes().size)
		assertAttributeConfiguration(ruleC, 0, "featureC1", "EString")
		assertAttributeConfiguration(ruleC, 1, "featureCD", "EString")
		assertAttributeConfiguration(ruleC, 2, "featureC2", "EString")
		assertEquals(3, ruleD.getEAttributes().size)
		assertAttributeConfiguration(ruleD, 0, "featureD1", "EString")
		assertAttributeConfiguration(ruleD, 1, "featureCD", "EString")
		assertAttributeConfiguration(ruleD, 2, "featureD2",
			"EString")
	}

	@Test def void testFeaturesAndInheritanceOfActions01() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: ({Add.a=current} '+'|{Sub.a=current} '-') featureAS=ID;'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(3, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var add = ePackage.type("Add") as EClass
		assertNotNull(add)
		var sub = ePackage.type("Sub") as EClass
		assertNotNull(sub)
		
		// test inheritance
		assertTrue(ruleA.ESuperTypes.isEmpty)
		assertEquals(1, add.ESuperTypes.size)
		assertEquals(ruleA, add.ESuperTypes.head)
		assertEquals(1, sub.ESuperTypes.size)
		assertEquals(ruleA, sub.ESuperTypes.head)
		
		// test features
		assertEquals(1, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureAS", "EString")
		assertEquals(1, ruleA.getEReferences().size)
		assertReferenceConfiguration(ruleA, 0, "a", "RuleA", true, 0, 1)
		assertEquals(0, add.getEAttributes().size)
		assertEquals(0, add.getEReferences().size)
		assertEquals(0, sub.getEAttributes().size)
		assertEquals(0, sub.getEReferences().size)
	}

	@Test def void testFeaturesAndInheritanceOfActions02() throws Exception {
		var String grammar = ""
		grammar += "grammar org.eclipse.xtext.testlanguages.ActionTestLanguage with org.eclipse.xtext.common.Terminals "
		grammar += "generate ActionLang"
		grammar += " 'http://www.eclipse.org/2008/tmf/xtext/ActionLang'"
		grammar += ""
		grammar += " Model:"
		grammar += " (children+=Element)*;"
		grammar += ""
		grammar += " Element returns Type:"
		grammar += " Item ( { Item.items+=current } items+=Item );"
		grammar += ""
		grammar += " Item returns Type:"
		grammar += " { Thing.content=current } name=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var model = ePackage.type("Model") as EClass
		assertNotNull(model)
		var type = ePackage.type("Type") as EClass
		assertNotNull(type)
		var item = ePackage.type("Item") as EClass
		assertNotNull(item)
		var thing = ePackage.type("Thing") as EClass
		assertNotNull(thing)
		
		// type hierarchy
		assertEquals(0, model.ESuperTypes.size)
		assertEquals(0, type.ESuperTypes.size)
		assertEquals(1, item.ESuperTypes.size)
		assertSame(type, item.ESuperTypes.head)
		assertEquals(1, thing.ESuperTypes.size)
		assertSame(type, thing.ESuperTypes.get(
			0))
	}

	@Test def void testAssignedRuleCall() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			RuleA: callA1=RuleB callA2+=RuleB simpleFeature=ID;
			RuleB: featureB=ID;
		'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(2, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var ruleB = ePackage.type("RuleB") as EClass
		assertNotNull(ruleB)
		assertEquals(1, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "simpleFeature", "EString")
		assertEquals(2, ruleA.getEReferences().size)
		assertReferenceConfiguration(ruleA, 0, "callA1", "RuleB", true, 0, 1)
		assertReferenceConfiguration(ruleA, 1, "callA2", "RuleB", true, 0,-1)
		assertEquals(1, ruleB.getEAttributes().size)
		assertAttributeConfiguration(ruleB, 0, "featureB", "EString")
	}

	@Test def void testAssignedCrossReference() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: refA1=[TypeB] refA2+=[TypeB|RuleB] simpleFeature=ID; RuleB returns TypeB: featureB=ID;'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(2, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertEquals(1, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "simpleFeature", "EString")
		assertEquals(2, ruleA.getEReferences().size)
		assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", false, 0,
			1)
		assertReferenceConfiguration(ruleA, 1, "refA2", "TypeB", false, 0,
			-1)
		assertEquals(1, typeB.getEAttributes().size)
		assertAttributeConfiguration(typeB, 0, "featureB",
			"EString")
	}

	@Test def void testAssignedParenthesizedElement() throws Exception {
		var String grammar = ''' grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar +=
			" RuleA: featureA1?=(RuleB) refA1=(RuleB) refA2=(RuleB|RuleC) refA3+=(RuleB|RuleC|RuleD) refA4=(RuleB|RuleD) featureA2+=('a'|'b');"
		grammar += " RuleB returns TypeB: RuleC? featureB=ID;"
		grammar += " RuleC: featureC=ID;"
		grammar += " RuleD returns TypeB: featureD=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(3, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		assertEquals(0, ruleA.ESuperTypes.size)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertEquals(0, typeB.ESuperTypes.size)
		var ruleC = ePackage.type("RuleC") as EClass
		assertNotNull(ruleC)
		assertEquals(1, ruleC.ESuperTypes.size)
		assertEquals(typeB, ruleC.ESuperTypes.head)
		assertEquals(2, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA1", "EBoolean")
		assertAttributeConfiguration(ruleA, 1, "featureA2", "EString", 0,
			-1)
		assertEquals(4, ruleA.getEReferences().size)
		assertReferenceConfiguration(ruleA, 0, "refA1", "TypeB", true, 0, 1)
		assertReferenceConfiguration(ruleA, 1, "refA2", "TypeB", true, 0, 1)
		assertReferenceConfiguration(ruleA, 2, "refA3", "TypeB", true, 0,
			-1)
		assertReferenceConfiguration(ruleA, 3, "refA4", "TypeB", true, 0,
			1)
	}

	@Test def void testAssignedKeyword() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: featureA?=('+'|'-') featureB=('*'|'/');'''
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(1, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertEquals(2, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA", "EBoolean", 0, 1)
		assertAttributeConfiguration(ruleA, 1, "featureB", "EString", 0,
			1)
	}

	@Test def void testImportWithoutAlias() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' import 'http://www.eclipse.org/emf/2002/Ecore' RuleA: feature=ID;'''
		getEPackageFromGrammar(grammar)
	}

	@Test def void testGenerateTwoModels() throws Exception {
		var String grammar = ""
		grammar += " grammar test with org.eclipse.xtext.common.Terminals"
		grammar += " generate t1 'http://t1'"
		grammar += " generate t2 'http://t2' as t2"
		grammar += " RuleA: featureA=ID;"
		grammar += " RuleB returns t2::TypeB: featureB=ID;"
		var List<EPackage> ePackages = getEPackagesFromGrammar(grammar, 0)
		assertEquals(2, ePackages.size)
		var EPackage t1 = ePackages.head
		assertEquals("t1", t1.name)
		assertEquals(1, t1.EClassifiers.size)
		val ruleA = t1.type("RuleA")
		assertNotNull(ruleA)
		var EPackage t2 = ePackages.get(1)
		assertEquals(1, t2.EClassifiers.size)
		assertEquals("t2", t2.name)
		val typeB = t2.type("TypeB")
		assertNotNull(typeB)
	}

	@Test def void testUseSameModelAlias() throws Exception {
		var String grammar = ""
		grammar += " grammar test with org.eclipse.xtext.common.Terminals"
		grammar += " generate t1 'http://t1' as target"
		grammar += " generate t2 'http://t2' as target"
		grammar += " RuleA: featureA=ID;" // no alias => cannot be created
		grammar += " RuleB returns target::TypeB: featureB=ID;"
		errorAcceptorMock.acceptError(TransformationErrorCode.AliasForMetamodelAlreadyExists,
			TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT)
		errorAcceptorMock.acceptError(TransformationErrorCode.UnknownMetaModelAlias, TestErrorAcceptor.ANY_STRING,
			TestErrorAcceptor.ANY_EOBJECT)
		errorAcceptorMock.acceptError(TransformationErrorCode.UnknownMetaModelAlias, TestErrorAcceptor.ANY_STRING,
			TestErrorAcceptor.ANY_EOBJECT)
		var List<EPackage> ePackages = getEPackagesFromGrammar(grammar, 5)
		assertEquals(0,		ePackages.		size)
	}

	@Test def void testModifyingSealedModel() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' import 'http://www.eclipse.org/emf/2002/Ecore' as ecore RuleA returns ecore::SomeNewTypeA: feature=ID;'''
		errorAcceptorMock.acceptError(TransformationErrorCode.CannotCreateTypeInSealedMetamodel,
			TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT)
		var EPackage result = getEPackageFromGrammar(grammar, 2)
		assertTrue(result.EClassifiers.isEmpty)
	}

	@Test def void testImportingUnknownModel() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' import 'unknown-scheme://www.unknownModel' as unknownModel RuleA: feature=ID;'''
		getEPackageFromGrammar(grammar,
			1)
	}

	@Test def void testMoreThanOneRuleCall() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB RuleC; RuleB: featureB=ID; RuleC: featureC=ID;'''
		errorAcceptorMock.acceptError(
			TransformationErrorCode.
				MoreThanOneTypeChangeInOneRule,
			TestErrorAcceptor.ANY_STRING,
			TestErrorAcceptor.ANY_EOBJECT)
		getEPackageFromGrammar(grammar,
			1)
	}

	@Test def void testRuleCallAndAction() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB {TypeC.B = current}; RuleB: featureB=ID;'''
		getEPackageFromGrammar(
			grammar)
	}

	@Test def void testRuleCallActionAndRuleCall() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA: RuleB {TypeC.B = current} RuleB; RuleB: featureB=ID;'''
		errorAcceptorMock.acceptError(
			TransformationErrorCode.
				MoreThanOneTypeChangeInOneRule,
			TestErrorAcceptor.ANY_STRING,
			TestErrorAcceptor.ANY_EOBJECT)
		getEPackageFromGrammar(grammar,
			1)
	}

	@Test def void testAddingFeatureTwice() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test' RuleA returns TypeA: featureA=ID; RuleB returns TypeA: featureA=STRING;'''
		var ePackage = getEPackageFromGrammar(
			grammar)
		assertEquals(1,
			ePackage.EClassifiers.size)
		var typeA = ePackage.
			getEClassifier("TypeA") as EClass
		assertNotNull(typeA)
		assertEquals(1, typeA.getEAttributes().size)
		assertAttributeConfiguration(typeA, 0,
			"featureA",
			"EString")
		}

	@Test def void testAddingDifferentFeaturesWithSameName01() throws Exception {
		val grammar = ''' grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«» RuleA returns TypeA: featureA=ID; RuleB returns TypeA: featureA=INT;'''
		errorAcceptorMock.acceptError(TransformationErrorCode.NoCompatibleFeatureTypeAvailable,
			TestErrorAcceptor.ANY_STRING, TestErrorAcceptor.ANY_EOBJECT)
		var ePackage = getEPackageFromGrammar(grammar, 1)
		assertEquals(1, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertEquals(1, typeA.getEAttributes().size)
		assertAttributeConfiguration(typeA, 0, "featureA",
			"EString")
	}

	@Test def void testAddingDifferentFeaturesWithSameName02() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: featureA=RuleD;"
		grammar += " RuleB returns TypeA: featureA=RuleC;"
		grammar += " RuleC: RuleD;"
		grammar += " RuleD: featureD=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(3, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		var ruleC = ePackage.type("RuleC") as EClass
		assertNotNull(ruleC)
		var ruleD = ePackage.type("RuleD") as EClass
		assertNotNull(ruleD)
		assertEquals(1, typeA.getEReferences().size)
		assertReferenceConfiguration(typeA, 0, "featureA", "RuleC", true, 0,
			1)
	}

	@Test def void testAddingDifferentFeaturesWithSameName03() throws Exception {
		// independent rules are combined as EObject
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: featureA1=ID featureA2=RuleD featureA3=RuleC;"
		grammar += " RuleB returns TypeA: featureA2=RuleC featureA4=INT;"
		grammar += " RuleC: featureC=INT;"
		grammar += " RuleD: featureD=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(3, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		var ruleC = ePackage.type("RuleC") as EClass
		assertNotNull(ruleC)
		var ruleD = ePackage.type("RuleD") as EClass
		assertNotNull(ruleD)
		assertEquals(2, typeA.getEAllAttributes().size)
		assertAttributeConfiguration(typeA, 0, "featureA1", "EString")
		assertAttributeConfiguration(typeA, 1, "featureA4", "EInt")
		assertEquals(2, typeA.getEReferences().size)
		assertReferenceConfiguration(typeA, 0, "featureA2", "EObject", true, 0, 1)
		assertReferenceConfiguration(typeA, 1, "featureA3", "RuleC", true, 0, 1)
	}

	@Test def void testUplift01() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA: (RuleB|RuleC) featureA=ID;"
		grammar += " RuleB: featureB=INT;"
		grammar += " RuleC: (featureA=ID)?;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(3, ePackage.EClassifiers.size)
		var ruleA = ePackage.type("RuleA") as EClass
		assertNotNull(ruleA)
		var ruleB = ePackage.type("RuleB") as EClass
		assertNotNull(ruleB)
		var ruleC = ePackage.type("RuleC") as EClass
		assertNotNull(ruleC)
		assertEquals(1, ruleA.getEAttributes().size)
		assertAttributeConfiguration(ruleA, 0, "featureA", "EString")
		assertEquals(1, ruleB.getEAttributes().size)
		assertAttributeConfiguration(ruleB, 0, "featureB", "EInt")
		assertEquals(0, ruleC.getEAttributes().size)
	}

	@Test def void testCallOfUndeclaredRule() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA: CallOfUndeclaredRule featureA=ID;"
		errorAcceptorMock.acceptError(TransformationErrorCode.NoSuchRuleAvailable, TestErrorAcceptor.ANY_STRING,
			TestErrorAcceptor.ANY_EOBJECT)
		var ePackage = getEPackageFromGrammar(grammar, 1)
		assertEquals(1, ePackage.EClassifiers.size)
		assertEquals("RuleA", ePackage.EClassifiers.head.name)
	}

	@Test def void testExpressionLikeLangauge() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar +=
			''' Ex :	Atom  ({ChainExpression.left+=current} operator=('+'|'-'|'*'|'/') right=Atom )*;Atom returns Ex :   Number |  '(' Ex ')';Number : value=INT;'''
		var ePackage = getEPackageFromGrammar(grammar)
		var classifier = ePackage.type("Ex") as EClass
		assertEquals(0, classifier.features.size)
	}

	@Test def void testClassNameEString() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += "Start returns EString: id=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		var classifier = ePackage.type("EString") as EClass
		assertEquals("EString", classifier.name)
		var feature = classifier.feature("id")
		assertNotNull(feature)
		assertEquals("EString", feature.EType.name)
		assertFalse(feature.EType.equals(classifier))
		assertEquals(EcorePackage.Literals.ESTRING, feature.EType)
	}

	@Test def void testNoException_01() throws Exception {
		var String grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore generate test 'http://test'
			CompositeModel: (model+=Model)+;
			Model: id=NestedModelId (':' value=Fraction)? ('#' vector=Vector)? ('+' dots=Dots)? ';'
			ModelId returns ecore::EString: ID '.' ID;
			NestedModelId : ModelId '.' ModelId;
			Fraction returns EBigDecimal: INT ('/' INT)?;
			Vector : '(' INT I'''
		val resource = getResourceFromStringAndExpect(grammar, 10)
		for (Diagnostic d : resource.errors) {
			assertFalse(d instanceof ExceptionDiagnostic)
		}

	}

	@Test def void testNoException_02() throws Exception {
		var String grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'
			Model: (children+=Element)*;
			Element returns Type: Item ( { Item.items+=current } items+=Item );
			Item returns Type:	{ T'''
		val resource = getResourceFromStringAndExpect(grammar, 1)
		for (Diagnostic d : resource.errors) {
			assertFalse(d instanceof ExceptionDiagnostic)
		}

	}

	@Test def void testNoException_03() throws Exception {
		var String grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore generate test 'http://test'
			CompositeModel: (type+=EClassifier)+;
			EClassifier returns ecore::EClassifier: EDataType | EClass;
			EClass returns ecore::EClass: 'class' name=ID;
			EDataType returns ecore::EDataType: 'dt' name=ID;'''
		val resource = getResourceFromString(grammar)
		assertTrue(resource.errors.isEmpty)
	}

	@Test def void testBug_266440() throws Exception {
		var String grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore  generate bugreport 'http://bugreport/266440'
			CompositeModel: (type+=EClassifier)+;
			EClassifier: EDataType | EClass;
			EClass: 'class' name=ID;
			EDataType: 'dt' name=ID;'''
		val resource = getResourceFromString(grammar)
		assertTrue(resource.errors.isEmpty)
		val parsedGrammar = resource.contents.head as Grammar
		for (AbstractRule rule : parsedGrammar.rules) {
			val classifier = rule.type.classifier
			var EPackage pack = classifier.getEPackage()
			assertEquals("bugreport", pack.name)
		}
	}

	@Test def void testBug_266807() throws Exception {
		val rs = get(XtextResourceSet)
		rs.setClasspathURIContext(getClass())
		val resource = rs.createResource(
			URI.
				createURI('''classpath:/«getClass().getPackage().name.replace(Character.valueOf('.').charValue, Character.valueOf('/').charValue)»/Test.xtext'''),
			ContentHandler.UNSPECIFIED_CONTENT_TYPE) as XtextResource
		resource.load(null)
		for (Diagnostic d : resource.errors) {
			fail(d.getMessage())
		}
	}

	@Test def void testBug_272566_1() throws Exception {
		var String grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Model:
			   test=Test
			;
			
			Test:
			   "keyword" WS name=ID
			;
		'''
		val resource = getResourceFromString(grammar)
		assertTrue(resource.errors.toString(), resource.errors.isEmpty)
	}

	@Test def void testBug_272566_2() throws Exception {
		var String grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Model:
			   test=Test
			;
			
			Test:
			   "keyword" FooBar name=ID
			;
			FooBar:
				'zonk' WS WS INT WS;
		'''
		val resource = getResourceFromString(grammar)
		assertTrue(resource.errors.toString(), resource.errors.isEmpty)
	}

	@Test def void testBug_272566_3() throws Exception {
		var String grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Model:
			   test=Test
			;
			
			Test:
			   "keyword" MyEnum name=ID
			;
			enum MyEnum:
				A | B;
		'''
		val resource = getResourceFromStringAndExpect(grammar, 1)
		assertFalse(resource.errors.toString(), resource.errors.isEmpty)
		for (Diagnostic d : resource.errors) {
			assertFalse(d instanceof ExceptionDiagnostic)
		}
	}

	@Test def void testInheritFromEObject_01() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore  import 'classpath:/org/eclipse/xtext/xtext/ecoreInference/test.ecore' as test  A returns ecore::EObject: B | C;  B returns test::Optional: 'b' optionalString=STRING;  C returns test::Mandatory: 'c' mandatoryString=STRING; '''
		val resource = getResourceFromString(grammar)
		assertTrue(resource.errors.isEmpty)
	}

	@Test def void testInheritFromEObject_02() throws Exception {
		var String grammar = ''' grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore  Object returns ecore::EObject: {ecore::EInt}; '''
		val resource = getResourceFromStringAndExpect(grammar, 1)
		assertEquals(resource.errors.toString(), 1, resource.errors.size)
	}

	@Test def void testInheritFromEObject_03() throws Exception {
		var String grammar = ''' grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore  Object returns ecore::EObject: {ecore::EAnnotation}; '''
		val resource = getResourceFromString(grammar)
		assertTrue(resource.errors.isEmpty)
	}

	@Test def void testPostProcessorHook() throws Exception {
		val xtextGrammar = '''grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' as ecore  generate test 'http://test' MyRule: myFeature=INT;'''
		val grammar = getModel(xtextGrammar) as Grammar
		val transformer = new Xtext2EcoreTransformer(grammar)
		var GeneratedMetamodel testMetamodel = grammar.getMetamodelDeclarations().get(1) as GeneratedMetamodel
		val postProcessor = new MockedXtext2EcorePostProcessor(testMetamodel)
		transformer.setPostProcessor(postProcessor)
		transformer.transform()
		assertEquals("process mthde called once", 1, postProcessor.proccessMethCalled())
	}

	@Test def void testBug_280413_01() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			import 'http://www.eclipse.org/emf/2002/Ecore' as ecore
			EClass returns ecore::EClass: name=ID;
		'''
		val resource = getResourceFromString(grammar)
		assertTrue(resource.errors.toString(), resource.errors.isEmpty)
	}
	
	@Test def void testBug_280413_02() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			import 'http://www.eclipse.org/emf/2002/Ecore' as ecore
			EClass returns ecore::EClass: name=ID;
		'''
		val resource = getResourceFromString(grammar)
		assertTrue(resource.errors.toString(), resource.errors.isEmpty)
	}
	
	@Test def void testBug_280413_03() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.Xtext
			generate test 'http://test'
			import 'http://www.eclipse.org/2008/Xtext' as xtext
			ParserRule returns xtext::ParserRule: name=ID;
		'''
		val resource = getResourceFromString(grammar)
		assertTrue(resource.errors.toString(), resource.errors.isEmpty)
	}
	
	@Test def void testBug_280413_04() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage
			generate test 'http://test'
			import 'classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.ecore' as mm
			Atom returns mm::Atom: name=ID;
		'''
		val resource = getResourceFromStringAndExpect(grammar, 1)
		assertEquals(resource.errors.toString(), 1, resource.errors.size)
		var TransformationDiagnostic diagnostic = resource.errors.get(
			0) as TransformationDiagnostic
		assertEquals(grammar.indexOf("mm::Atom"), diagnostic.getOffset())
		assertEquals("mm::Atom".length(), diagnostic.getLength())
	}
	
	@Test def void testBug_280393() throws Exception {
		val grammar = '''
			grammar foo.Bar with org.eclipse.xtext.common.Terminals
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate bar "http://www.Bar.foo"
			
			Foo returns ecore::EClass : 
				Bar | eSuperTypes+=[ecore::EClass];
			
			Bar :
			 	'bar' eSuperTypes+=[ecore::EAttribute];
		'''
		val resource = getResourceFromStringAndExpect(grammar, 1)
		assertEquals(resource.errors.toString(), 1, resource.errors.size)
	}
	
	@Test def void testBug_285140_01() throws Exception {
		val grammar = '''
			grammar org.sublang with org.eclipse.xtext.testlanguages.ActionTestLanguage
			
			import "http://www.eclipse.org/2008/tmf/xtext/ActionLang" as actionLang
			generate sub "http://www.sublang.org"
			
			Model returns actionLang::Model:
				Child ({actionLang::Parent.left=current} right=Child)?;
		'''
		val resource = getResourceFromString(grammar)
		assertEquals(resource.errors.toString(), 0, resource.errors.size)
	}
	
	@Test def void testBug_285140_02() throws Exception {
		val grammar = '''
			grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage
			
			import "http://www.eclipse.org/2008/tmf/xtext/ActionLang" as actionLang
			
			Model returns actionLang::Model:
				Child ({actionLang::Parent.left=current} right=Child)?;
		'''
		val resource = getResourceFromString(grammar)
		assertEquals(resource.errors.toString(), 0, resource.errors.size)
	}
	
	@Test def void testBug_285140_03() throws Exception {
		val grammar = '''
			grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage
			
			import "http://www.eclipse.org/2008/tmf/xtext/ActionLang" as actionLang
			
			Model returns actionLang::Child:
				Child name=ID;
		'''
		val resource = getResourceFromString(grammar)
		assertEquals(resource.errors.toString(), 0, resource.errors.size)
	}
	
	@Test def void testBug_285140_04() throws Exception {
		val grammar = '''
			grammar org.sublang with org.eclipse.xtext.xtext.ecoreInference.Bug285140TestLanguage
			
			import "http://www.eclipse.org/2008/tmf/xtext/ActionLang" as actionLang
			
			Child returns actionLang::Child:
				Child unknown=ID;
		'''
		val resource = getResourceFromStringAndExpect(grammar, 1)
		assertEquals(resource.errors.toString(), 1, resource.errors.size)
	}
	
	@Test def void testBug_286285_01() throws Exception {
		val grammar = '''
			grammar language with org.eclipse.xtext.common.Terminals
			generate lang "http://www.language.org"
			Model:
				Class | ID;
			Class: name = ID;
		'''
		val resource = getResourceFromString(grammar)
		assertEquals(resource.errors.toString(), 0, resource.errors.size)
	}
	
	@Test def void testBug_287550_01() throws Exception {
		var String grammar = '''
			grammar language with org.eclipse.xtext.common.Terminals
			generate myDsl "http://example.xtext.org/MyDsl"
			Model: Left | Right;
			Left: Delegate;
			Right returns Model: Delegate '=';
			Delegate returns Left: value=ID;
		'''
		val resource = getResourceFromString(grammar)
		assertEquals(resource.errors.toString(), 0, resource.errors.size)
	}
	
	@Test def void testBug_287698_01() throws Exception {
		var String grammar = '''
			grammar language with org.eclipse.xtext.common.Terminals
			generate myDsl "http://example.xtext.org/MyDsl"
			Model returns Namespace: {Model} elements+=NamespaceElement;
			NamespaceElement: Type | Namespace ;
			Type: 'type' name=ID ';';
			Namespace: 'namespace' name=ID '{' elements+=Type '}';
		'''
		val resource = getResourceFromString(grammar)
		assertEquals(resource.errors.toString(), 0, resource.errors.size)
	}
	
	@Test def void testBug_287698_02() throws Exception {
		var String grammar = '''
			grammar language with org.eclipse.xtext.common.Terminals
			generate myDsl "http://example.xtext.org/MyDsl"
			Model returns Namespace: {Model} elements+=(Namespace | Something); 
			Root: Type | NamespaceElement;
			Type: 'type' name=ID ';';
			NamespaceElement: Namespace | Something;
			Namespace: 'namespace' name=ID '{' elements+=SubSomething '}';
			Something: ReturnModel | SubSomething;
			SubSomething: 'something' name=ID ';';
			ReturnModel returns Model: name=ID;
		'''
		val resource = getResourceFromString(grammar)
		assertEquals(resource.errors.toString(), 0,
			resource.errors.
				size)
	}

	@Test def void testContainmentVsReference_01() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' EClass: name=ID eSuperTypes+=EClass;'''
		val resource = getResourceFromStringAndExpect(grammar, 1)
		assertEquals(resource.errors.toString(), 1,
			resource.errors.
				size)
	}

	@Test def void testContainmentVsReference_02() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' EClass: name=ID eSuperTypes+=[EClass];'''
		val resource = getResourceFromString(grammar)
		assertEquals(resource.errors.toString(), 0,
			resource.errors.
				size)
	}

	@Test def void testContainmentVsReference_03() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' EReference: name=ID eType=[EClass];'''
		val resource = getResourceFromString(grammar)
		assertEquals(resource.errors.toString(), 0,
			resource.errors.
				size)
	}

	@Test def void testContainmentVsReference_04() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			import 'http://www.eclipse.org/emf/2002/Ecore'
			EReference: name=ID eType=EClass;
			EClass: name=ID;
		'''
		val resource = getResourceFromStringAndExpect(grammar, 1)
		assertEquals(resource.errors.toString(), 1,
			resource.errors.
				size)
	}

	@Test def void testContainmentVsReference_05() throws Exception {
		val grammar = '''grammar test with org.eclipse.xtext.common.Terminals import 'http://www.eclipse.org/emf/2002/Ecore' EReference: name=ID eContainingClass=[EClass];'''
		val resource = getResourceFromStringAndExpect(
			grammar, 1)
		assertEquals(resource.errors.toString(), 1,
			resource.errors.
				size)
	}

	@Test def void testContainmentVsReference_06() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			import 'http://www.eclipse.org/emf/2002/Ecore'
			EReference: name=ID eContainingClass=EClass;
			EClass: name=ID;
		'''
		val resource = getResourceFromStringAndExpect(grammar, 1)
		assertEquals(resource.errors.toString(), 1,
			resource.errors.
				size)
	}

	@Test def void testBug296496_01() throws Exception {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			import "classpath:/org/eclipse/xtext/enumrules/enums.ecore"
			ExistingType:
			  enumFeature=ExistingEnum stringFeature=ExistingEnum;
			enum ExistingEnum:
			  SameName | OverriddenLiteral = "overridden" | DifferentName;
		'''
		val resource = getResourceFromStringAndExpect(grammar, 1)
		assertEquals(resource.errors.toString(), 1,
			resource.errors.
				size)
	}

	@Test def void testBug296496_02() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.common.Terminals
			import "classpath:/org/eclipse/xtext/enumrules/enums.ecore"
			generate myDsl "http://example.xtext.org/MyDsl"
			CreatedType:
			  enumFeature=ExistingEnum otherEnumFeature=ExistingEnum;
			enum ExistingEnum:
			  SameName | OverriddenLiteral = "overridden" | DifferentName;
		'''
		val resource = getResourceFromStringAndExpect(grammarAsString, 0)
		assertTrue(resource.errors.toString(), resource.errors.isEmpty)
		val grammar = resource.contents.head as Grammar
		var GeneratedMetamodel generatedMetamodel = grammar.getMetamodelDeclarations().get(1) as GeneratedMetamodel
		assertEquals("myDsl", generatedMetamodel.name)
		var createdType = generatedMetamodel.getEPackage().type("CreatedType") as EClass
		assertEquals(createdType.feature("enumFeature").EType,
			createdType.feature("otherEnumFeature").
				EType)
	}

	@Test def void testBug310122() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate myDsl "http://example.xtext.org/MyDsl"
			Model: Sub1 | name=ID 'somekeyword';
			Sub1 returns Model: '(' Model ')';
		'''
		val resource = getResourceFromString(grammarAsString)
		val grammar = resource.contents.head as Grammar
		var GeneratedMetamodel generatedMetamodel = grammar.getMetamodelDeclarations().head as GeneratedMetamodel
		assertEquals("myDsl", generatedMetamodel.name)
		assertEquals(1, generatedMetamodel.getEPackage().EClassifiers.size)
		var createdModel = generatedMetamodel.getEPackage().type("Model") as EClass
		assertEquals(EcorePackage.Literals.ESTRING, createdModel.feature("name").EType)
		for (AbstractRule rule : grammar.rules) {
			assertEquals(createdModel, rule.type.classifier)
		}
	}

	@Test def void testOverrideTerminalFragment_01() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage
			terminal fragment ESCAPED_CHAR: '\\' ('b'|'t'|'n'|'f'|'r'|'\\');
		'''
		getResourceFromString(grammarAsString)
	}

	@Test def void testOverrideTerminalFragment_02() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage
			terminal ESCAPED_CHAR: '\\' ('b'|'t'|'n'|'f'|'r'|'\\');
		'''
		getResourceFromString(grammarAsString)
	}

	@Test def void testOverrideTerminalFragment_03() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage
			ESCAPED_CHAR: '\\' ('b'|'t'|'n'|'f'|'r'|'\\');
		'''
		getResourceFromStringAndExpect(grammarAsString,	1)
	}

	@Test def void testOverrideTerminalFragment_04() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage
			enum ESCAPED_CHAR: A | B;
		'''
		getResourceFromStringAndExpect(grammarAsString, 1)
	}

	@Test def void testOverrideTerminalRule_01() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage
			terminal fragment ID: 'a'..'z'+;
		'''
		getResourceFromStringAndExpect(grammarAsString, 1)
	}

	@Test def void testOverrideTerminalRule_02() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage
			terminal ID: 'a'..'z'+;
		'''
		getResourceFromString(grammarAsString)
	}

	@Test def void testOverrideTerminalRule_03() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage
			ID: 'a' | 'z';
		'''
		getResourceFromStringAndExpect(grammarAsString, 1)
	}

	@Test def void testOverrideTerminalRule_04() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage
			enum ID: A | B;
		'''
		getResourceFromStringAndExpect(grammarAsString, 1)
	}

	@Test def void testOverrideDatatypeRule_01() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage
			terminal fragment ModelId: 'a'..'z'+;
		'''
		getResourceFromStringAndExpect(grammarAsString, 1)
	}

	@Test def void testOverrideDatatypeRule_02() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage
			terminal ModelId: 'a'..'z'+;
		'''
		getResourceFromString(grammarAsString)
	}

	@Test def void testOverrideDatatypeRule_03() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage
			ModelId: 'a' | 'z';
		'''
		getResourceFromString(grammarAsString)
	}

	@Test def void testOverrideDatatypeRule_04() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.xtext.ecoreInference.DataTypeRuleWithEnumResultTestLanguage
			import 'http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest'
			import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'
			enum ExistingEnumAsDT returns ExistingEnum: SameName;
		'''
		getResourceFromString(grammarAsString)
	}

	@Test def void testOverrideEnumRule_01() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage
			import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'
			terminal fragment ExistingEnum: 'a'..'z'+;
		'''
		getResourceFromStringAndExpect(grammarAsString, 1)
	}

	@Test def void testOverrideEnumRule_02() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage
			import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'
			terminal ExistingEnum returns ExistingEnum: 'a'..'z'+;
		'''
		getResourceFromString(grammarAsString)
	}

	@Test def void testOverrideEnumRule_03() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage
			import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'
			ExistingEnum returns ExistingEnum: 'a' | 'z';
		'''
		getResourceFromString(grammarAsString)
	}

	@Test def void testOverrideEnumRule_04() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage
			import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'
			enum ExistingEnum: SameName;
		'''
		getResourceFromString(grammarAsString)
	}

	@Test def void testMultiInheritance_01() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage
			import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types
			generate myDsl "http://example.xtext.org/MyDsl" as mydsl
			Array returns mydsl::Array: componentType=ComponentType componentType=DeclaredType;
			DeclaredType returns types::JvmDeclaredType: members+=DeclaredType;
			ComponentType returns types::JvmComponentType: 'ignore';
		'''
		val resource = getResourceFromString(grammarAsString)
		val grammar = resource.contents.head as Grammar
		var array = grammar.rules.head.type.classifier as EClass
		assertEquals("JvmComponentType", array.feature("componentType").EType.name)
	}

	@Test def void testMultiInheritance_02() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage
			import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types
			generate myDsl "http://example.xtext.org/MyDsl" as mydsl
			Array returns mydsl::Array: componentType=DeclaredType componentType=ComponentType;
			DeclaredType returns types::JvmDeclaredType: members+=DeclaredType;
			ComponentType returns types::JvmComponentType: 'ignore';
		'''
		val resource = getResourceFromString(grammarAsString)
		val grammar = resource.contents.head as Grammar
		var array = grammar.rules.head.type.classifier as EClass
		assertEquals("JvmComponentType", array.feature("componentType").EType.name)
	}

	@Test def void testBug316610_01() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage
			import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types
			DeclaredType returns types::JvmDeclaredType: superTypes+=DeclaredType;'''
		val resource = getResourceFromStringAndExpect(grammarAsString, 1)
		assertTrue(resource.errors.head.getMessage().contains("JvmTypeReference"))
	}

	@Test def void testBug316610_02() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage
			import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types
			Array returns types::JvmGenericArrayTypeReference: componentType=STRING;'''
		val resource = getResourceFromStringAndExpect(grammarAsString, 1)
		assertTrue(resource.errors.head.getMessage().contains("JvmTypeReference"))
	}

	@Test def void testBug316610_03() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage
			import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types
			DeclaredType returns types::JvmDeclaredType: superTypes=[types::JvmTypeReference];'''
		val resource = getResourceFromStringAndExpect(grammarAsString, 1)
		assertTrue(resource.errors.head.getMessage().contains(
			"cardinality"))
	}

	@Test def void testBug316610_04() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage
			import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types
			DeclaredType returns types::JvmDeclaredType: superTypes+=[types::JvmTypeReference];
		'''
		val resource = getResourceFromStringAndExpect(grammarAsString, 1)
		assertTrue(resource.errors.head.getMessage().contains("containment"))
	}

	@Test def void testBug346035_01() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.common.Terminals
			import 'platform:/resource/org.eclipse.xtext.xbase/model/Xbase.ecore' as xbase
			generate myDsl 'uri'
			Model: elements+=Element*;
			Element returns xbase::XExpression : {Element} 'Hello';
			terminal ID : '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
		'''
		getResourceFromString(grammarAsString)
	}

	@Test def void testBug346685_a01() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y')? name+=STRING;"
		grammar += " RuleB returns TypeB: {TypeB} 'ignore';"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertNotNull(typeA.feature("name"))
		assertEquals(1, typeA.features.size)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("TypeC") as EClass
		assertNotNull(typeC)
		assertNotNull(typeC.feature("x"))
		assertEquals(1, typeC.features.size)
		var typeD = ePackage.type("TypeD") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("x"))
		assertEquals(1,
			typeD.features.
				size)
			}

	@Test def void testBug346685_a02() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y') name+=STRING;"
		grammar += " RuleB returns TypeB: {TypeB} 'ignore';"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertTrue(typeA.features.isEmpty)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("TypeC") as EClass
		assertNotNull(typeC)
		assertNotNull(typeC.feature("x"))
		assertNotNull(typeC.feature("name"))
		assertEquals(2, typeC.features.size)
		var typeD = ePackage.type("TypeD") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("x"))
		assertNotNull(typeD.feature("name"))
		assertEquals(2, typeD.features.size)
	}

	@Test def void testBug346685_a03() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y')? name+=STRING;"
		grammar += " RuleB returns TypeB: {TypeB} name+=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertNotNull(typeA.feature("name"))
		assertEquals(1, typeA.features.size)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("TypeC") as EClass
		assertNotNull(typeC)
		assertNotNull(typeC.feature("x"))
		assertEquals(1, typeC.features.size)
		var typeD = ePackage.type("TypeD") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("x"))
		assertEquals(1, typeD.features.size)
	}

	@Test def void testBug346685_a04() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y') name+=STRING;"
		grammar += " RuleB returns TypeB: {TypeB} name+=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertNotNull(typeA.feature("name"))
		assertEquals(1, typeA.features.size)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("TypeC") as EClass
		assertNotNull(typeC)
		assertNotNull(typeC.feature("x"))
		assertEquals(1, typeC.features.size)
		var typeD = ePackage.type("TypeD") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("x"))
		assertEquals(1,
			typeD.features.
				size)
			}

																																					@Test def void testBug346685_a05() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: RuleB? ({TypeC.x=current} 'x' | {TypeD.x=current} 'y')? name+=STRING;"
		grammar += " RuleB returns TypeB: {TypeB} 'ignore';"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertNotNull(typeA.feature("name"))
		assertEquals(1, typeA.features.size)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("TypeC") as EClass
		assertNotNull(typeC)
		assertNotNull(typeC.feature("x"))
		assertEquals(1, typeC.features.size)
		var typeD = ePackage.type("TypeD") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("x"))
		assertEquals(1, typeD.features.size)
	}

	@Test def void testBug346685_a06() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: RuleB? ({TypeC.x=current} 'x' | {TypeD.x=current} 'y') name+=STRING;"
		grammar += " RuleB returns TypeB: {TypeB} 'ignore';"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertTrue(typeA.features.isEmpty)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("TypeC") as EClass
		assertNotNull(typeC)
		assertNotNull(typeC.feature("x"))
		assertNotNull(typeC.feature("name"))
		assertEquals(2, typeC.features.size)
		var typeD = ePackage.type("TypeD") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("x"))
		assertNotNull(typeD.feature("name"))
		assertEquals(2, typeD.features.size)
	}

	@Test def void testBug346685_a07() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: RuleB? ({TypeC.x=current} 'x' | {TypeD.x=current} 'y')? name+=STRING;"
		grammar += " RuleB returns TypeB: {TypeB} name+=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertNotNull(typeA.feature("name"))
		assertEquals(1, typeA.features.size)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("TypeC") as EClass
		assertNotNull(typeC)
		assertNotNull(typeC.feature("x"))
		assertEquals(1, typeC.features.size)
		var typeD = ePackage.type("TypeD") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("x"))
		assertEquals(1, typeD.features.size)
	}

	@Test def void testBug346685_a08() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: RuleB? ({TypeC.x=current} 'x' | {TypeD.x=current} 'y') name+=STRING;"
		grammar += " RuleB returns TypeB: {TypeB} name+=ID;"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertNotNull(typeA.feature("name"))
		assertEquals(1, typeA.features.size)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("TypeC") as EClass
		assertNotNull(typeC)
		assertNotNull(typeC.feature("x"))
		assertEquals(1, typeC.features.size)
		var typeD = ePackage.type("TypeD") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("x"))
		assertEquals(1, typeD.features.size)
	}

	@Test def void testBug346685_a09() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y' | 'z')? name+=STRING;"
		grammar += " RuleB returns TypeB: {TypeB} 'ignore';"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertNotNull(typeA.feature("name"))
		assertEquals(1, typeA.features.size)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("TypeC") as EClass
		assertNotNull(typeC)
		assertNotNull(typeC.feature("x"))
		assertEquals(1, typeC.features.size)
		var typeD = ePackage.type("TypeD") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("x"))
		assertEquals(1, typeD.features.size)
	}

	@Test def void testBug346685_a10() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " RuleA returns TypeA: RuleB ({TypeC.x=current} 'x' | {TypeD.x=current} 'y' | 'z') name+=STRING;"
		grammar += " RuleB returns TypeB: {TypeB} 'ignore';"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(4, ePackage.EClassifiers.size)
		var typeA = ePackage.type("TypeA") as EClass
		assertNotNull(typeA)
		assertNotNull(typeA.feature("name"))
		assertEquals(1, typeA.features.size)
		var typeB = ePackage.type("TypeB") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("TypeC") as EClass
		assertNotNull(typeC)
		assertNotNull(typeC.feature("x"))
		assertEquals(1, typeC.features.size)
		var typeD = ePackage.type("TypeD") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("x"))
		assertEquals(1, typeD.features.size)
	}

	@Test def void testBug346685_b01() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " Model: A ({D.a = current} b = B)? c=C? ;\n"
		grammar += " A: {A} 'a';\n"
		grammar += " B: {B} 'c';\n"
		grammar += " C: {C} 'b';\n"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(5, ePackage.EClassifiers.size)
		var typeModel = ePackage.type("Model") as EClass
		assertNotNull(typeModel)
		assertNotNull(typeModel.feature("c"))
		assertEquals(1, typeModel.features.size)
		var typeA = ePackage.type("A") as EClass
		assertNotNull(typeA)
		assertTrue(typeA.features.isEmpty)
		assertEquals(1, typeA.ESuperTypes.size)
		assertSame(typeModel, typeA.ESuperTypes.head)
		var typeB = ePackage.type("B") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("C") as EClass
		assertNotNull(typeC)
		assertTrue(typeC.features.isEmpty)
		var typeD = ePackage.type("D") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("a"))
		assertNotNull(typeD.feature("b"))
		assertEquals(2, typeD.features.size)
	}

	@Test def void testBug346685_b02() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " Model: A ({D.a = current} b = B) c=C? ;\n"
		grammar += " A: {A} 'a';\n"
		grammar += " B: {B} 'c';\n"
		grammar += " C: {C} 'b';\n"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(5, ePackage.EClassifiers.size)
		var typeModel = ePackage.type("Model") as EClass
		assertNotNull(typeModel)
		assertTrue(typeModel.features.isEmpty)
		var typeA = ePackage.type("A") as EClass
		assertNotNull(typeA)
		assertTrue(typeA.features.isEmpty)
		assertEquals(1, typeA.ESuperTypes.size)
		assertSame(typeModel, typeA.ESuperTypes.head)
		var typeB = ePackage.type("B") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("C") as EClass
		assertNotNull(typeC)
		assertTrue(typeC.features.isEmpty)
		var typeD = ePackage.type("D") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("a"))
		assertNotNull(typeD.feature("b"))
		assertNotNull(typeD.feature("c"))
		assertEquals(3, typeD.features.size)
	}

	@Test def void testBug346685_b03() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " Model: A? ({D.a = current} b = B)? c=C? ;\n"
		grammar += " A: {A} 'a';\n"
		grammar += " B: {B} 'c';\n"
		grammar += " C: {C} 'b';\n"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(5, ePackage.EClassifiers.size)
		var typeModel = ePackage.type("Model") as EClass
		assertNotNull(typeModel)
		assertNotNull(typeModel.feature("c"))
		assertEquals(1, typeModel.features.size)
		var typeA = ePackage.type("A") as EClass
		assertNotNull(typeA)
		assertTrue(typeA.features.isEmpty)
		assertEquals(1, typeA.ESuperTypes.size)
		assertSame(typeModel, typeA.ESuperTypes.head)
		var typeB = ePackage.type("B") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("C") as EClass
		assertNotNull(typeC)
		assertTrue(typeC.features.isEmpty)
		var typeD = ePackage.type("D") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("a"))
		assertNotNull(typeD.feature("b"))
		assertEquals(2, typeD.features.size)
	}

	@Test def void testBug346685_b04() throws Exception {
		var String grammar = '''grammar test with org.eclipse.xtext.common.Terminals generate test 'http://test'«»'''
		grammar += " Model: A? ({D.a = current} b = B) c=C? ;\n"
		grammar += " A: {A} 'a';\n"
		grammar += " B: {B} 'c';\n"
		grammar += " C: {C} 'b';\n"
		var ePackage = getEPackageFromGrammar(grammar)
		assertEquals(5, ePackage.EClassifiers.size)
		var typeModel = ePackage.type("Model") as EClass
		assertNotNull(typeModel)
		assertTrue(typeModel.features.isEmpty)
		var typeA = ePackage.type("A") as EClass
		assertNotNull(typeA)
		assertTrue(typeA.features.isEmpty)
		assertEquals(1, typeA.ESuperTypes.size)
		assertSame(typeModel, typeA.ESuperTypes.head)
		var typeB = ePackage.type("B") as EClass
		assertNotNull(typeB)
		assertTrue(typeB.features.isEmpty)
		var typeC = ePackage.type("C") as EClass
		assertNotNull(typeC)
		assertTrue(typeC.features.isEmpty)
		var typeD = ePackage.type("D") as EClass
		assertNotNull(typeD)
		assertNotNull(typeD.feature("a"))
		assertNotNull(typeD.feature("b"))
		assertNotNull(typeD.feature("c"))
		assertEquals(3, typeD.features.size)
	}

	@Test def void testEcoreReference_01() throws Exception {
		val resourceSet = new XtextResourceSet()
		resourceSet.setClasspathURIContext(getClass())
		resourceSet.getURIConverter().getURIMap().put(URI.createURI(
			"platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore"), URI.createURI(
			"platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore"))
		assertFalse(
			resourceSet.getResource(URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore"), true).
				contents.isEmpty)
		assertFalse(
			resourceSet.getResource(URI.createURI(
				"platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerNsURI.ecore"),
				true).contents.isEmpty)
		assertFalse(
			resourceSet.getResource(URI.createURI(
				"platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerPlatformResource.ecore"),
				true).contents.isEmpty)
		assertFalse(
			resourceSet.getResource(URI.createURI(
				"platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerPlatformPlugin.ecore"),
				true).contents.isEmpty)
		val resource = resourceSet.getResource(URI.createURI(
			"classpath:/org/eclipse/xtext/metamodelreferencing/tests/EcoreReferenceTestLanguage.xtext"),
			true) as XtextResource
		assertTrue(Joiner.on("\n").join(resource.errors), resource.errors.isEmpty)
	}

	@Test def void testBug413171_01() throws Exception {
		val grammar = getModel(readFileIntoString("org/eclipse/xtext/xtext/ecoreInference/Bug413171_01.xtext.txt")) as Grammar
		val parserRule = grammar.rules.get(2)
		val classifier = parserRule.type.classifier
		assertTrue(parserRule.name, classifier instanceof EDataType)
	}

	@Test def void testBug413171_02() throws Exception {
		val grammar = getModel(readFileIntoString("org/eclipse/xtext/xtext/ecoreInference/Bug413171_02.xtext.txt")) as Grammar
		val parserRule = grammar.rules.get(2)
		val classifier = parserRule.type.classifier
		assertTrue(parserRule.name, classifier instanceof EDataType)
	}

	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=413171
	@Test def void testBug390326() throws Exception {
		var String grammar = "grammar test with org.eclipse.xtext.common.Terminals"
		grammar += " generate test 'http://test'"
		grammar += " Model: A ({B.a = current} b = A)*;\n"
		grammar += " A: value=ID;\n"
		var ePackage = getEPackageFromGrammar(grammar)
		var clazz = ePackage.type("B") as EClass
		var feature = clazz.feature("a")
		assertEquals("Model", feature.EType.name)
	}

	@Test def void testBug390326_02() throws Exception {
		var String grammar = "grammar test with org.eclipse.xtext.common.Terminals"
		grammar += " generate test 'http://test'"
		grammar += " Model: A ({B.a = current} b = A {C.a=current} c = A)*;\n"
		grammar += " C returns A: value='c';\n"
		grammar += " A: value='a';\n"
		var ePackage = getEPackageFromGrammar(grammar)
		var clazzB = ePackage.type("B") as EClass
		var feature = clazzB.feature("a")
		assertEquals("Model", feature.EType.name)
		var clazzC = ePackage.type("C") as EClass
		var featureC_A = clazzC.feature("a")
		assertEquals("B", featureC_A.EType.name)
	}

	@Test def void testBug390326_03() throws Exception {
		var String grammar = "grammar test with org.eclipse.xtext.common.Terminals"
		grammar += " generate test 'http://test'"
		grammar += " Model: Value (({A.a = current} 'a' )|\n"
		grammar += "               ({B.a = current} 'b' ))*;\n"
		grammar += " Value: value='a';\n"
		var ePackage = getEPackageFromGrammar(grammar)
		var clazzA = ePackage.type("A") as EClass
		var featureA_a = clazzA.feature("a")
		assertEquals("Model", featureA_a.EType.name)
		var clazzB = ePackage.type("B") as EClass
		var featureB_a = clazzB.feature("a")
		assertEquals("Model", featureB_a.EType.name)
	}

}
