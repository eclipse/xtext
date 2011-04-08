/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class LinkingTest extends AbstractXtend2TestCase {
	
	@Inject
	private IXtend2JvmAssociations associator;
	
	public void testCreateExtension_00() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  create newArrayList('foo') getListWithFooAnd(String s) {" +
				"    this" +
				"  }" +
				"}");
		assertEquals(1, clazz.getMembers().size());
		
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals(func.getCreateExtensionInfo(), featureCall.getFeature());
	}
	
	public void testCreateExtension_01() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  create foo : newArrayList('foo') getListWithFooAnd(String s) {" +
				"    foo" +
				"  }" +
		"}");
		assertEquals(1, clazz.getMembers().size());
		
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals(func.getCreateExtensionInfo(), featureCall.getFeature());
	}
	
	public void testDeclaredDependency_00() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  @Inject java.util.ArrayList<String>" +
				"  foo() {arrayList}" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		JvmField field = (JvmField) associator.getJvmElements(clazz.getMembers().get(0)).iterator().next();
		assertSame(field, ((XFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0)).getFeature());
	}
	
	
	public void testInjectedExtensionMethodCall() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  @Inject extension String" +
				"  foo() " +
				"    {(1 as int).indexOf()}" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("java.lang.String.indexOf(int)", call.getFeature().getIdentifier());
		assertEquals("Foo.string", ((XMemberFeatureCall)call.getImplicitReceiver()).getFeature().getIdentifier());
	}
	
	public void testCaseFunction_00() throws Exception {
		XtendFunction function = function("dispatch String foo(String s) {_foo(s)}");
		final XBlockExpression block = (XBlockExpression) function.getExpression();
		final JvmOperation feature = (JvmOperation) ((XAbstractFeatureCall)block.getExpressions().get(0)).getFeature();
		XtendFunction xtendFunction = (XtendFunction) associator.getAssociatedElements(feature).iterator().next();
		assertSame(function,xtendFunction);
	}
	
	public void testTypeReference_withImport() throws Exception {
		XtendFunction func = (XtendFunction) clazz("import java.lang.* class X { (String)=>Boolean foo() {[|true]} }").getMembers().get(0);
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		JvmTypeReference returnType = type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getIdentifier());
		JvmTypeReference paramType = type.getParamTypes().get(0);
		assertEquals("java.lang.String", paramType.getIdentifier());
	}
	
	public void testTypeReference_0() throws Exception {
		XtendFunction func = function("=>java.lang.Boolean foo() {[|true]}");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		JvmTypeReference returnType = type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getIdentifier());
	}
	
	public void testTypeParameterReference() throws Exception {
		XtendFunction func = function("<X> X foo(X x) {x}");
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("X", typeParamDecl.getIdentifier());
		assertEquals("X", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_0() throws Exception {
		XtendFunction func = (XtendFunction) file("import java.lang.* class X { <String> String foo(String x) {x}}").getXtendClass().getMembers().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getIdentifier());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_1() throws Exception {
		XtendFunction func = (XtendFunction) file("import java.lang.* class X { <String> String foo(java.lang.String x) {x}}")
				.getXtendClass().getMembers().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getIdentifier());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertNotSame(typeParamDecl,paramType.getType());
	}

	public void testFeatureScope_1() throws Exception {
		XtendFile file = file ("class X { String foo() {'hello world'} String bar(String foo) {foo}}");
		XtendClass xClass = file.getXtendClass();
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(1);
		final XBlockExpression expression = (XBlockExpression) func.getExpression();
		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) expression.getExpressions().get(0);
		assertEquals(func.getParameters().get(0), featureCall1.getFeature());
	}
	
	public void testFeatureScope_3() throws Exception {
		XtendFile file = file ("import java.lang.String class X { String foo(String foo) {[String foo|foo]}}");
		XtendClass xClass = file.getXtendClass();
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(0);
		XClosure closure = (XClosure) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) closure.getExpression();
		assertEquals(closure.getFormalParameters().get(0), featureCall1.getFeature());
	}
	
	public void testMemberFeatureScope_0() throws Exception {
		XtendFile file = file ("import java.lang.String class X { String foo(String foo) {foo.length()}}");
		XtendClass xClass = file.getXtendClass();
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(0);
		XMemberFeatureCall call = (XMemberFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("length", ((JvmOperation)call.getFeature()).getSimpleName());
	}
	
	public void testImplicitPackageImport() throws Exception {
		XtendFile file = file("package java.io class Foo implements Serializable {}");
		List<JvmTypeReference> implementedInterfaces = file.getXtendClass().getImplements();
		assertFalse(implementedInterfaces.isEmpty());
		JvmType implementedInterface = implementedInterfaces.get(0).getType();
		assertNotNull(implementedInterface);
		assertEquals("java.io.Serializable", implementedInterface.getIdentifier());
	}
	
	public void testStaticImports_01() throws Exception {
		String fileAsText= "import java.util.Collections.* class Clazz { void method() { ''.singletonList() } }";
		XtendFile file = file(fileAsText, false);
		EcoreUtil.resolveAll(file);
		List<Diagnostic> errors = file.eResource().getErrors();
		assertEquals(1, errors.size());
		assertTrue(errors.get(0) instanceof XtextLinkingDiagnostic);
		XtextLinkingDiagnostic diagnostic = (XtextLinkingDiagnostic) errors.get(0);
		assertEquals(fileAsText.indexOf("singletonList"),  diagnostic.getOffset());
	}
	
	public void testStaticImports_02() throws Exception {
		String fileAsText= "import static java.util.Collections.* class Clazz { void method() { ''.singletonList() } }";
		XtendFile file = file(fileAsText, false);
		EcoreUtil.resolveAll(file);
		List<Diagnostic> errors = file.eResource().getErrors();
		assertEquals(1, errors.size());
		assertTrue(errors.get(0) instanceof XtextLinkingDiagnostic);
		XtextLinkingDiagnostic diagnostic = (XtextLinkingDiagnostic) errors.get(0);
		assertEquals(fileAsText.indexOf("singletonList"),  diagnostic.getOffset());
	}
	
	public void testStaticImports_03() throws Exception {
		String fileAsText= "import static extension java.util.Collections.* class Clazz { void method() {''.singletonList()} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.util.Collections.singletonList(T)", identifier);
	}
	
	public void testStaticImports_04() throws Exception {
		// TODO: Fix me - method invocation should not require parenthesis
//		String fileAsText= "import static extension java.util.Collections.* class Clazz { void method() {''.singletonList} }";
		String fileAsText= "import static extension java.util.Collections.* class Clazz { void method() {''.singletonList()} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.util.Collections.singletonList(T)", identifier);
	}
	
	public void testStaticImports_05() throws Exception {
		String fileAsText= "import static java.util.Collections.* class Clazz { void method() {singletonList('')} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.util.Collections.singletonList(T)", identifier);
	}
	
	public void testStaticImports_06() throws Exception {
		String fileAsText= 
				"import static com.google.common.collect.Iterables.*\n" +
				"import static java.util.Collections.*\n" +
				"class Clazz { void method() {find(singletonList(''), [e|e!=null])} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("com.google.common.collect.Iterables.find(java.lang.Iterable,com.google.common.base.Predicate)", identifier);
	}
	
	public void testStaticImports_07() throws Exception {
		String fileAsText= 
				"import static extension com.google.common.collect.Iterables.*\n" +
				"import static java.util.Collections.*\n" +
				"class Clazz { void method() {find(singletonList(''), [e|e!=null])} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("com.google.common.collect.Iterables.find(java.lang.Iterable,com.google.common.base.Predicate)", identifier);
	}
	
	public void testStaticImports_08() throws Exception {
		String fileAsText= 
				"import static com.google.common.collect.Iterables.*\n" +
				"import static java.util.Collections.*\n" +
				"class Clazz { void method() {singletonList('').findFirst(e|e!=null)} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.findFirst(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", identifier);
	}
	
	public void testStaticImports_09() throws Exception {
		String fileAsText= "import static java.util.Collections.* class Clazz { void method() {singletonList('').findFirst(String e|e!=null)} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.findFirst(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", identifier);
	}
	
	public void testStaticImports_10() throws Exception {
		String fileAsText= "import static extension java.util.Collections.* class Clazz { void method() { singletonList('')} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.util.Collections.singletonList(T)", identifier);
	}
	
	public void testStaticImports_11() throws Exception {
		String fileAsText= 
				"import static com.google.common.collect.Iterables.*\n" +
				"import static java.util.Collections.*\n" +
				"class Clazz { void method() {find(singletonList(''), [e|e.length!=0])} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("com.google.common.collect.Iterables.find(java.lang.Iterable,com.google.common.base.Predicate)", identifier);
	}
	
	public void testStaticImports_12() throws Exception {
		String fileAsText= 
				"import static extension com.google.common.collect.Iterables.*\n" +
				"import static java.util.Collections.*\n" +
				"class Clazz { void method() { find(singletonList(''), [e|e.length!=0])} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("com.google.common.collect.Iterables.find(java.lang.Iterable,com.google.common.base.Predicate)", identifier);
	}
}
