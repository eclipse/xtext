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
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup
import org.eclipse.xtext.linking.impl.Linker
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.tests.AbstractXtextTests
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
	
	protected def <T extends EStructuralFeature> feature(EClassifier clazz, String name) {
		if (clazz instanceof EClass) {
			return clazz.getEStructuralFeature(name) as T
		}
		return null
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

}
