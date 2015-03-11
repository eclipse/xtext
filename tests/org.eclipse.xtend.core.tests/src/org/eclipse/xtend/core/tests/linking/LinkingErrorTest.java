/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking;

import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkingErrorTest extends AbstractXtendTestCase {

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private Provider<ResourceValidatorImpl> resourceValidatorProvider;
	
	@Test public void testFieldsAreNotSugared() throws Exception {
		XtendClass clazz = clazz("class A {\n"
				+ " String getFoo\n"
				+ " def String doStuff() {\n" + 
				"	    foo\n" + 
				"	}");
		XFeatureCall call = (XFeatureCall) ((XBlockExpression)((XtendFunction)clazz.getMembers().get(1)).getExpression()).getExpressions().get(0);
		JvmIdentifiableElement feature = call.getFeature();
		assertTrue(feature.eIsProxy());
	}
	
	@Test public void testFieldsAreNotSugared_01() throws Exception {
		XtendClass clazz = clazz("class A {\n"
				+ " String getFoo\n"
				+ " def String doStuff() {\n" + 
				"	    this.foo\n" + 
				"	}");
		XMemberFeatureCall call = (XMemberFeatureCall) ((XBlockExpression)((XtendFunction)clazz.getMembers().get(1)).getExpression()).getExpressions().get(0);
		JvmIdentifiableElement feature = call.getFeature();
		assertTrue(feature.eIsProxy());
	}
	
	@Test public void testNoException_01() throws Exception {
		XtendFunction function = function("def noException() {\n" + 
				// exception case is Integeri
				"	    val closure = [Integeri| return i]\n" + 
				"	    for (x : 1..100) closure.apply(x)\n" + 
				"	}");
		JvmTypeReference type = associations.getDirectlyInferredOperation(function).getReturnType();
		assertTrue(type.getType() instanceof JvmVoid);
		assertFalse(type.getType().eIsProxy());
		assertNoExceptions(function);
	}
	
	@Test public void testNoException_02() throws Exception {
		XtendFunction function = function("def noException() {\n" + 
				// exception case is i
				"	    val closure = [ i| return i]\n" + 
				"	    for (x : 1..100) closure.apply(x)\n" + 
				"	}");
		JvmTypeReference type = associations.getDirectlyInferredOperation(function).getReturnType();
		assertTrue(type.getType() instanceof JvmVoid);
		assertFalse(type.getType().eIsProxy());
		assertNoExceptions(function);
	}
	
	@Test public void testNoException_03() throws Exception {
		XtendFile file = file("package org.eclipse.xtend.core.tests.linking\n" + 
				// error condition is empty class name
				"class  {\n" + 
				"\n" + 
				"	def aOrB(String a, String b) {\n" + 
				"		if (a.isNullOrEmpty()) \n" + 
				"			b\n" + 
				"		else\n" + 
				"			a \n" + 
				"	}\n" + 
				"	\n" + 
				"	def returnInIf() {\n" + 
				"		if ('x'!='x') return 'xx' else return 'yy'\n" + 
				"	}\n" + 
				"\n" + 
				"}");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_04() throws Exception {
		XtendFile file = file("package org.eclipse.xtend.core.tests.linking\n" + 
				"import java.util.ArrayList\n" + 
				"import static java.util.Arrays.*\n" + 
				"import static extension java.util.Collections.*\n" + 
				"class NoException {\n" + 
				// error condition is tring
				"	@Inject extension tring\n" + 
				"	def boolean something(int i) {\n" + 
				"	  i.indexOf() == 0" +
				"	}\n" + 
				"}");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_05() throws Exception {
		XtendFile file = file("package org.eclipse.xtend.core.tests.linking\n" + 
				"import java.util.ArrayList\n" + 
				"import static java.util.Arrays.*\n" + 
				"import static extension java.util.Collections.*\n" + 
				// error condition is empty class name
				"class  {\n" + 
				"	@Inject\n" + 
				"	ArrayList as myList\n" + 
				"	@Inject extension\n" + 
				"	String\n" + 
				"	def boolean something(int i) {\n" + 
				"	  if (i.indexOf() == 0) {\n" + 
				"	    return myList.contains(i)\n" + 
				"	  } \n" + 
				"	  asList(i)\n" + 
				"	  i.singletonList()\n" + 
				"	  false\n" + 
				"	}\n" + 
				"}");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_06() throws Exception {
		XtendFile file = file("package org.eclipse.xtend.core.tests.linking\n" + 
				"class NoException {\n" + 
				"	def String foo(String a,) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')\n" + 
				"		}\n" + 
				"	}\n" + 
				"}");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_07() throws Exception {
		XtendFile file = file("package org.eclipse.xtend.core.tests.linking\n" + 
				"import\n" +
				"import static java.util.Arrays.*\n" + 
				"import static extension java.util.Collections.*\n" + 
				"class NoException {\n" + 
				"	@Inject\n" + 
				"	ArrayList as myList\n" + 
				"	@Inject extension String\n" + 
				"	def boolean something(int i) {\n" + 
				"	  if (i.indexOf() == 0) {\n" + 
				"	    return myList.contains(i)\n" + 
				"	  } \n" + 
				"	  asList(i)\n" + 
				"	  i.singletonList()\n" + 
				"	  false\n" + 
				"	}\n" + 
				"}");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_08() throws Exception {
		XtendFile file = file("package org.eclipse.xtend.core.tests.linking\n" + 
				"import java.util.ArrayList\n" + 
				"import static.*\n" + 
				"import static extension java.util.Collections.*\n" + 
				"class NoException {\n" + 
				"	@Inject\n" + 
				"	ArrayList as myList\n" + 
				"	@Inject extension String\n" + 
				"	def boolean something(int i) {\n" + 
				"	  if (i.indexOf() == 0) {\n" + 
				"	    return myList.contains(i)\n" + 
				"	  } \n" + 
				"	  asList(i)\n" + 
				"	  i.singletonList()\n" + 
				"	  false\n" + 
				"	}\n" + 
				"}");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_09() throws Exception {
		XtendFile file = file("package org.eclipse.xtend.core.tests.linking\n" + 
				"class NoException {\n" + 
				"	def String foo(String a, String b) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')\n" + 
				"		} else {\n" + 
				"			v");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_10() throws Exception {
		// error condition is empty package name
		XtendFile file = file("package \n" + 
				"class MyClass {\n" + 
				"	aOrB(String a, Unknown b) {\n" + 
				"	}\n" + 
				"\n" + 
				"}");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_11() throws Exception {
		XtendFile file = file("package foo\n" +
				"import java.util.*\n" + 
				"class MyClass {\n" + 
				"  def <T> Collection<T> addAll2(Collection<T> collection, Iterable<? extends T> elements){\n" + 
				"    collection.addAll(elements)\n" + 
				"    collection\n" + 
				"  }\n" + 
				"}");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_12() throws Exception {
		// error scenario is 'Iterable<haracter>' in line 4
		XtendFile file = file(
				"package foo\n" + 
				"class MyClass {\n" +  
				"	def method() {\n" + 
				"		var java.util.List<Character> x = ('abc'.toCharArray as Iterable<haracter>).toList() \n" + 
				"		x \n" + 
				"	}\n" + 
				"}");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_13() throws Exception {
		XtendFile file = file(
				"package com.acme\n" + 
				"\n" + 
				"import static org.junit.Assert.*\n" + 
				"import org.junit.runner.RunWith\n" + 
				"import org.eclipse.xtext.junit4.XtextRunner\n" + 
				"import org.eclipse.xtext.junit4.InjectWith\n" + 
				"import com.google.inject.Inject\n" + 
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" + 
				"import org.eclipse.emf.ecore.EObject\n" + 
				"import org.eclipse.xtext.naming.IQualifiedNameProvider\n" + 
				"\n" + 
				"@RunWith(typeof(XtextRunner))\n" + 
				"class QualifiedNameProviderTest {\n" + 
				"    @Inject\n" + 
				"    extension ParseHelper<EObject> helper\n" + 
				"    @Inject\n" + 
				"    extension IQualifiedNameProvider qualifiedNameProvider\n" + 
				"    def getErrors(EObject obj) {\n" + 
				"        obj.eResource.errors\n" + 
				"    }\n" + 
				"    def resolve(EObject obj) {\n" + 
				"        EcoreUtil::resolveAll(obj.eResource)\n" + 
				"    }\n" + 
				"    def parseAcme(CharSequence seq) {\n" + 
				"        seq.parse.elements.head\n" + 
				"    }\n" + 
				"    @Test\n" + 
				"    def explicitName() {\n" + 
				"        val element = '''\n" + 
				"        '''.parseAcme\n" + 
				"        assertEquals(\"FooBar\", element.fullyQualifiedName.toString)\n" + 
				"    }\n" + 
				"}");
		assertNoExceptions(file);
	}
	
	@Test public void testNoException_14() throws Exception {
		XtendFile file = file(
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"import org.eclipse.emf.ecore.EClass\n" + 
				"import org.eclipse.emf.ecore.EPackage\n" + 
				"import org.eclipse.emf.ecore.EStructuralFeature\n" + 
				"import org.eclipse.emf.ecore.EObject\n" + 
				"class Case_6 {\n" + 
				"	def dispatch transform(EClass model) {\n" + 
				"		model.ETypeParameters.map(e|transform(e))\n" + 
				"	}\n" + 
				"	def dispatch transform(EPackage packageDecl) {\n" + 
				"		packageDecl.eContents.map(e | transform(e as EStructuralFeature))\n" + 
				"	}\n" + 
				"	def dispatch transform(EStructuralFeature entity) {\n" + 
				"		val inferredType = null\n" + 
				"		newArrayList(inferredType as E");
		assertNoExceptions(file);
	}
	
	@Test public void testBug343585() throws Exception {
		XtendFile file = file("class Test extends Test {}");
		assertNoExceptions(file);
	}
	
	@Test public void testBug_350167_01() throws Exception {
		XtendFunction fun = function("def fun(Object o) {\n" + 
				"	switch(o) {\n" + 
				"		String : concatPath(o, o)\n" + 
				"		Number : .\n" + 
				"		default: null\n" + 
				"	}\n" + 
				"}");
		assertNoExceptions(fun);
	}
	
	@Test public void testBug_350167_02() throws Exception {
		XtendFunction fun = function("def fun(Object o) {\n" + 
				"	try { ''.toString } catch(NullPointerException e) { . }\n" + 
				"}");
		assertNoExceptions(fun);
	}
	
	@Test public void testBug_350167_03() throws Exception {
		XtendFunction fun = function("def fun(Object o) {\n" + 
				"	if (true) ''.toString != null else { . }\n" + 
				"}");
		assertNoExceptions(fun);
	}
	
	@Test public void testBug_350167_04() throws Exception {
		XtendFunction fun = function("def fun(@Something({ ., String::Foo }) Object o) {\n" + 
				"	null\n" + 
				"}");
		assertNoExceptions(fun);
	}
	
	@Test public void testBug343096() throws Exception {
		XtendFile file = file(
				"class Bug343096 {\n" +
				"    <T> test() {\n" + 
				"        [T t|switch t {\n" + 
				"            case t:test\n" + 
				"        }]\n" + 
				"    }" +
				"}");
		assertNoExceptions(file);
	}
	
	protected void assertNoExceptions(EObject object) {
		Resource resource = object.eResource();
		if (resource instanceof LazyLinkingResource)
			((LazyLinkingResource) resource).resolveLazyCrossReferences(CancelIndicator.NullImpl);
		List<Diagnostic> errors = object.eResource().getErrors();
		for(Diagnostic error: errors) {
			if (error instanceof ExceptionDiagnostic) {
				((ExceptionDiagnostic) error).getException().printStackTrace();
			}
			assertFalse(error.toString(), error instanceof ExceptionDiagnostic);
		}
		validateWithoutException((XtextResource) resource);
	}
	
	@Test public void testNoExceptionInValidator_01() throws Exception {
		XtendClass clazz = clazz("package pack class Case_2 {\n" + 
				"\n" + 
				"	aOrB(String a, String b) {\n" + 
				"		if (a.isNullOrEmpty()) \n" + 
				"			b\n" + 
				"		else\n" + 
				"			a \n" + 
				"	}\n" + 
				"	\n" + 
				"	() {\n" + 
				"		if ('x'!='x') return 'xx' else return 'yy'\n" + 
				"	}\n" + 
				"\n" + 
				"}");
		assertNoExceptions(clazz);
		XtextResource resource = (XtextResource) clazz.eResource();
		validateWithoutException(resource);
	}
	
	@Test public void testNoExceptionInValidator_02() throws Exception {
		XtendClass clazz = clazz("package pack class Case_4 {\n" + 
				"	richStrings_01() {\n" + 
				"		'''foobar'''\n" + 
				"	}\n" + 
				"	richStrings_02() {\n" + 
				"		'''«'start'»\n" + 
				"		  first line\n" + 
				"");
		assertNoExceptions(clazz);
		XtextResource resource = (XtextResource) clazz.eResource();
		validateWithoutException(resource);
	}
	
	@Test public void testNoExceptionInValidator_03() throws Exception {
		XtendClass clazz = clazz("package pack class Case_4 {\n" + 
				"	richStrings_01() {\n" + 
				"		'''foobar'''\n" + 
				"	}\n" + 
				"	richStrings_02() {\n" + 
				"		'''«'start'»\n" + 
				"		  first line\n'''" + 
				"");
		assertNoExceptions(clazz);
		XtextResource resource = (XtextResource) clazz.eResource();
		validateWithoutException(resource);
	}
	
	@Test public void testEmptyProxy_01() throws Exception {
		XtendFile file = file(
				"class Name {\n" + 
				"	def foo() {\n" + 
				"		''.\n" + 
				"	}\n" + 
				"}");
		assertNoExceptions(file);
		assertEquals(1, file.eResource().getErrors().size());
		assertEquals(-1, file.eResource().getErrors().get(0).getMessage().indexOf("''"));
	}

	protected void validateWithoutException(XtextResource resource) {
		ResourceValidatorImpl validator = resourceValidatorProvider.get();
		assertNotSame(validator, resource.getResourceServiceProvider().getResourceValidator());
		validator.setDiagnosticConverter(new IDiagnosticConverter() {
			@Override
			public void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic, IAcceptor<Issue> acceptor) {
				if (diagnostic instanceof BasicDiagnostic) {
					List<?> data = diagnostic.getData();
					if (!data.isEmpty() && data.get(0) instanceof Throwable) {
						Throwable t = (Throwable) data.get(0);
						// the framework catches runtime exception
						// and AssertionError does not take a throwable as argument
						throw new Error(t);
					}
				}
			}
			
			@Override
			public void convertResourceDiagnostic(Diagnostic diagnostic, Severity severity, IAcceptor<Issue> acceptor) {
				if (diagnostic instanceof ExceptionDiagnostic) {
					Exception e = ((ExceptionDiagnostic) diagnostic).getException();
					// the framework catches runtime exception
					// and AssertionError does not take a throwable as argument
					throw new Error(new RuntimeException(e));
				}
			}
		});
		validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
	}
	
	@Override
	protected XtendFile file(String string, boolean validate) throws Exception {
		if (validate)
			return super.file(string, validate);
		XtextResourceSet set = getResourceSet();
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(string), null);
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}
	
}
