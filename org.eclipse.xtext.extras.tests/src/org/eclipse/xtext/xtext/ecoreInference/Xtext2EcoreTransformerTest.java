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
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup;
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

import com.google.common.base.Joiner;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * @see https://www.eclipse.org/Xtext/documentation/301_grammarlanguage.html#metamodel-inference
 */
public class Xtext2EcoreTransformerTest extends AbstractXtextTests {

	public static class MyErrorAcceptor implements ErrorAcceptor {
		private final ErrorAcceptor first;

		private final ErrorAcceptor second;

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

	@SuppressWarnings("unchecked")
	protected <T extends EStructuralFeature> T feature(EClassifier clazz, String name) {
		if (clazz instanceof EClass) {
			return (T) ((EClass) clazz).getEStructuralFeature(name);
		}
		return null;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, TypesPackage.eINSTANCE);
		errorAcceptorMock = new TestErrorAcceptor();
		EcoreSupportStandaloneSetup.setup();
		with(XtextStandaloneSetup.class);
	}

	@Override
	public void tearDown() throws Exception {
		errorAcceptorMock = null;
		super.tearDown();
	}

	@Override
	public XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		XtextResource resource = ((XtextResource) getResourceFactory().createResource(uri));
		rs.getResources().add(resource);
		XtextLinker linker = new XtextLinker() {
			@Override
			protected Xtext2EcoreTransformer createTransformer(Grammar grammar, IDiagnosticConsumer consumer) {
				Xtext2EcoreTransformer result = super.createTransformer(grammar, consumer);
				result.setErrorAcceptor(new Xtext2EcoreTransformerTest.MyErrorAcceptor(result.getErrorAcceptor(),
						Xtext2EcoreTransformerTest.this.errorAcceptorMock));
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

	@Test
	public void testMultiInheritance_01() throws Exception {
		// @formatter:off
		String grammarAsString =
			"grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
			"import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types\n" +
			"generate myDsl 'http://example.xtext.org/MyDsl' as mydsl\n" +
			"Array returns mydsl::Array: componentType=ComponentType componentType=DeclaredType;\n" +
			"DeclaredType returns types::JvmDeclaredType: members+=DeclaredType;\n" +
			"ComponentType returns types::JvmComponentType: 'ignore';\n";
		// @formatter:on
		XtextResource resource = getResourceFromString(grammarAsString);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		EClass array = ((EClass) grammar.getRules().get(0).getType().getClassifier());
		Assert.assertEquals("JvmComponentType", feature(array, "componentType").getEType().getName());
	}

	@Test
	public void testMultiInheritance_02() throws Exception {
		// @formatter:off
		String grammarAsString = 
			"grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
			"import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types\n" +
			"generate myDsl 'http://example.xtext.org/MyDsl' as mydsl\n" +
			"Array returns mydsl::Array: componentType=DeclaredType componentType=ComponentType;\n" +
			"DeclaredType returns types::JvmDeclaredType: members+=DeclaredType;\n" +
			"ComponentType returns types::JvmComponentType: 'ignore';\n";
		// @formatter:on
		XtextResource resource = getResourceFromString(grammarAsString);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		EClass array = ((EClass) grammar.getRules().get(0).getType().getClassifier());
		Assert.assertEquals("JvmComponentType", feature(array, "componentType").getEType().getName());
	}

	@Test
	public void testBug316610_01() throws Exception {
		// @formatter:off
		String grammarAsString = 
			"grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
			"import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types\n" +
			"DeclaredType returns types::JvmDeclaredType: superTypes+=DeclaredType;\n";
		// @formatter:on
		XtextResource resource = getResourceFromStringAndExpect(grammarAsString, 1);
		Assert.assertTrue(resource.getErrors().get(0).getMessage().contains("JvmTypeReference"));
	}

	@Test
	public void testBug316610_02() throws Exception {
		// @formatter:off
		String grammarAsString = 
			"grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
			"import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types\n" +
			"Array returns types::JvmGenericArrayTypeReference: componentType=STRING;";
		// @formatter:on
		XtextResource resource = getResourceFromStringAndExpect(grammarAsString, 1);
		Assert.assertTrue(resource.getErrors().get(0).getMessage().contains("JvmTypeReference"));
	}

	@Test
	public void testBug316610_03() throws Exception {
		// @formatter:off
		String grammarAsString = 
			"grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
			"import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types\n" +
			"DeclaredType returns types::JvmDeclaredType: superTypes=[types::JvmTypeReference];";
		// @formatter:on
		XtextResource resource = getResourceFromStringAndExpect(grammarAsString, 1);
		Assert.assertTrue(resource.getErrors().get(0).getMessage().contains("cardinality"));
	}

	@Test
	public void testBug316610_04() throws Exception {
		// @formatter:off
		String grammarAsString = 
			"grammar test with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
			"import 'http://www.eclipse.org/xtext/common/JavaVMTypes' as types\n" +
			"DeclaredType returns types::JvmDeclaredType: superTypes+=[types::JvmTypeReference];\n";
		// @formatter:on
		XtextResource resource = getResourceFromStringAndExpect(grammarAsString, 1);
		Assert.assertTrue(resource.getErrors().get(0).getMessage().contains("containment"));
	}

	@Test
	public void testBug346035_01() throws Exception {
		// @formatter:off
		String grammarAsString = 
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"import 'platform:/resource/org.eclipse.xtext.xbase/model/Xbase.ecore' as xbase\n" +
			"generate myDsl 'uri'\n" + "Model: elements+=Element*;\n" +
			"Element returns xbase::XExpression : {Element} 'Hello';\n" +
			"terminal ID : '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;\n";
		// @formatter:on
		getResourceFromString(grammarAsString);
	}

	@Test
	public void testEcoreReference_01() throws Exception {
		XtextResourceSet resourceSet = new XtextResourceSet();
		Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
		uriMap.put(URI.createPlatformPluginURI("org.eclipse.xtext.tests/src/", false), URI.createURI("classpath:/"));
		resourceSet.setClasspathURIContext(this.getClass());
		uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore"),
				URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore"));
		Assert.assertFalse(
				resourceSet.getResource(URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore"), true)
						.getContents().isEmpty());
		Assert.assertFalse(resourceSet.getResource(URI.createURI(
				"platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerNsURI.ecore"),
				true).getContents().isEmpty());
		Assert.assertFalse(resourceSet.getResource(URI.createURI(
				"platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerPlatformResource.ecore"),
				true).getContents().isEmpty());
		Assert.assertFalse(resourceSet.getResource(URI.createURI(
				"platform:/plugin/org.eclipse.xtext.tests/src/org/eclipse/xtext/metamodelreferencing/tests/EcorePerPlatformPlugin.ecore"),
				true).getContents().isEmpty());
		Resource resource = resourceSet.getResource(
				URI.createURI(
						"classpath:/org/eclipse/xtext/metamodelreferencing/tests/EcoreReferenceTestLanguage.xtext"),
				true);
		XtextResource xtextResource = (XtextResource) resource;
		Assert.assertTrue(Joiner.on("\n").join(xtextResource.getErrors()), xtextResource.getErrors().isEmpty());
	}
}
