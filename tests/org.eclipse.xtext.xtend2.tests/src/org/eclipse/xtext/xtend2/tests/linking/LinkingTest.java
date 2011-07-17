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
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendParameter;
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
				"  def create list: newArrayList('foo') getListWithFooAnd(String s) {" +
				"    list" +
				"  }" +
				"}");
		assertEquals(1, clazz.getMembers().size());
		
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals(func.getCreateExtensionInfo(), featureCall.getFeature());
	}
	
	public void testXtendField_00() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  @com.google.inject.Inject java.util.ArrayList<String> arrayList" +
				"  def foo() {arrayList}" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		JvmField field = (JvmField) associator.getJvmElements(clazz.getMembers().get(0)).iterator().next();
		assertSame(field, ((XFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0)).getFeature());
	}
	
	
	public void testInjectedExtensionMethodCall() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  @com.google.inject.Inject extension String string" +
				"  def foo() " +
				"    {(1 as int).indexOf()}" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("java.lang.String.indexOf(int)", call.getFeature().getIdentifier());
		assertEquals("Foo.string", ((XMemberFeatureCall)call.getImplicitReceiver()).getFeature().getIdentifier());
	}
	
	public void testCaseFunction_00() throws Exception {
		XtendFunction function = function("def dispatch String foo(String s) {_foo(s)}");
		final XBlockExpression block = (XBlockExpression) function.getExpression();
		final JvmOperation feature = (JvmOperation) ((XAbstractFeatureCall)block.getExpressions().get(0)).getFeature();
		XtendFunction xtendFunction = (XtendFunction) associator.getAssociatedElements(feature).iterator().next();
		assertSame(function,xtendFunction);
	}
	
	public void testTypeReference_withImport() throws Exception {
		XtendFunction func = (XtendFunction) clazz("import java.lang.* class X { def (String)=>Boolean foo() {[|true]} }").getMembers().get(0);
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		JvmTypeReference returnType = type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getIdentifier());
		JvmTypeReference paramType = type.getParamTypes().get(0);
		assertEquals("java.lang.String", paramType.getIdentifier());
	}
	
	public void testTypeReference_0() throws Exception {
		XtendFunction func = function("def =>java.lang.Boolean foo() {[|true]}");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		JvmTypeReference returnType = type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getIdentifier());
	}
	
	public void testTypeParameterReference() throws Exception {
		XtendFunction func = function("def <X> X foo(X x) {x}");
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("X", typeParamDecl.getIdentifier());
		assertEquals("X", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_0() throws Exception {
		XtendFunction func = (XtendFunction) file("import java.lang.* class X { def <String> String foo(String x) {x}}").getXtendClass().getMembers().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getIdentifier());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_1() throws Exception {
		XtendFunction func = (XtendFunction) file("import java.lang.* class X { def <String> String foo(java.lang.String x) {x}}")
				.getXtendClass().getMembers().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getIdentifier());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertNotSame(typeParamDecl,paramType.getType());
	}

	public void testFeatureScope_1() throws Exception {
		XtendFile file = file ("class X { def String foo() {'hello world'} def String bar(String foo) {foo}}");
		XtendClass xClass = file.getXtendClass();
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(1);
		final XBlockExpression expression = (XBlockExpression) func.getExpression();
		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) expression.getExpressions().get(0);
		assertEquals(func.getParameters().get(0), featureCall1.getFeature());
	}
	
	public void testFeatureScope_3() throws Exception {
		XtendFile file = file ("import java.lang.String class X { def String foo(String foo) {[String foo|foo]}}");
		XtendClass xClass = file.getXtendClass();
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(0);
		XClosure closure = (XClosure) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) closure.getExpression();
		assertEquals(closure.getFormalParameters().get(0), featureCall1.getFeature());
	}
	
	public void testMemberFeatureScope_0() throws Exception {
		XtendFile file = file ("import java.lang.String class X { def String foo(String foo) {foo.length()}}");
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
		String fileAsText= "import java.util.Collections.* class Clazz { def void method() { ''.singletonList() } }";
		XtendFile file = file(fileAsText, false);
		EcoreUtil.resolveAll(file);
		List<Diagnostic> errors = file.eResource().getErrors();
		assertEquals(1, errors.size());
		assertTrue(errors.get(0) instanceof XtextLinkingDiagnostic);
		XtextLinkingDiagnostic diagnostic = (XtextLinkingDiagnostic) errors.get(0);
		assertEquals(fileAsText.indexOf("singletonList"),  diagnostic.getOffset());
	}
	
	public void testStaticImports_02() throws Exception {
		String fileAsText= "import static java.util.Collections.* class Clazz { def void method() { ''.singletonList() } }";
		XtendFile file = file(fileAsText, false);
		EcoreUtil.resolveAll(file);
		List<Diagnostic> errors = file.eResource().getErrors();
		assertEquals(1, errors.size());
		assertTrue(errors.get(0) instanceof XtextLinkingDiagnostic);
		XtextLinkingDiagnostic diagnostic = (XtextLinkingDiagnostic) errors.get(0);
		assertEquals(fileAsText.indexOf("singletonList"),  diagnostic.getOffset());
	}
	
	public void testStaticImports_03() throws Exception {
		String fileAsText= "import static extension java.util.Collections.* class Clazz { def void method() {''.singletonList()} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.util.Collections.singletonList(T)", identifier);
	}
	
	public void testStaticImports_04() throws Exception {
		// TODO: Fix me - method invocation should not require parenthesis
//		String fileAsText= "import static extension java.util.Collections.* class Clazz { void method() {''.singletonList} }";
		String fileAsText= "import static extension java.util.Collections.* class Clazz { def void method() {''.singletonList()} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.util.Collections.singletonList(T)", identifier);
	}
	
	public void testStaticImports_05() throws Exception {
		String fileAsText= "import static java.util.Collections.* class Clazz { def void method() {singletonList('')} }";
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
				"class Clazz { def void method() {find(singletonList(''), [e|e!=null])} }";
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
				"class Clazz { def void method() {find(singletonList(''), [e|e!=null])} }";
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
				"class Clazz { def void method() {singletonList('').findFirst(e|e!=null)} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.findFirst(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", identifier);
	}
	
	public void testStaticImports_09() throws Exception {
		String fileAsText= "import static java.util.Collections.* class Clazz { def void method() {singletonList('').findFirst(String e|e!=null)} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.findFirst(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", identifier);
	}
	
	public void testStaticImports_10() throws Exception {
		String fileAsText= "import static extension java.util.Collections.* class Clazz { def void method() { singletonList('')} }";
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
				"class Clazz { def void method() {find(singletonList(''), [e|e.length!=0])} }";
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
				"class Clazz { def void method() { find(singletonList(''), [e|e.length!=0])} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("com.google.common.collect.Iterables.find(java.lang.Iterable,com.google.common.base.Predicate)", identifier);
	}
	
	public void testBug343102_01() throws Exception {
		XtendFunction function = function("def <T extends java.lang.Object> test(T t) {\n" + 
				"  t.getClass\n" + 
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.lang.Object.getClass()", identifier);
	}
	
	public void testBug343102_02() throws Exception {
		XtendFunction function = function("def <T> test(T t) {\n" + 
				"  t.getClass\n" + 
		"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.lang.Object.getClass()", identifier);
	}
	
	public void testBug345827_01() throws Exception {
		XtendFunction function = function("def String name() {\n" + 
				"  var name = ''\n" +
				"  name" + 
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(1);
		// TODO actually we should prefer the function in case 'explicitOperationCall' is true
		// for a featureCall
		assertSame(block.getExpressions().get(0), featureCall.getFeature());
	}
	
	public void testBug345827_02() throws Exception {
		XtendFunction function = function("def String name() {\n" + 
				"  var name = ''\n" +
				"  name()" + 
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(1);
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
	
	public void testBug345827_03() throws Exception {
		XtendFunction function = function("def String name(String param) {\n" + 
				"  var name = ''\n" +
				"  name()" + 
		"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(1);
		// TODO actually we should prefer the function in case 'explicitOperationCall' is true
		// for a featureCall
		assertSame(block.getExpressions().get(0), featureCall.getFeature());
	}
	
	public void testBug345827_04() throws Exception {
		XtendFunction function = function("def String name(String param) {\n" + 
				"  var name = ''\n" +
				"  name('param')" + 
		"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(1);
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
	
	public void testBug345827_05() throws Exception {
		XtendFunction function = function("def String name(String name) {\n" + 
				"  name()" + 
		"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(0);
		// TODO actually we should prefer the function in case 'explicitOperationCall' is true
		// for a featureCall
		assertSame(function.getParameters().get(0), featureCall.getFeature());
	}
	
	public void testBug345827_06() throws Exception {
		XtendFunction function = function("def String name(String param) {\n" + 
				"  name('param')" + 
		"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(0);
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
	
	public void testBug345433_01() throws Exception {
		String classAsString = 
			"import static extension org.eclipse.xtext.GrammarUtil.*\n" +
			"class Foo {" +
			"	org.eclipse.xtext.Grammar grammar\n" +
			"	def function1() {\n" + 
			"		grammar.containedRuleCalls.filter(e | " +
			"			!e.isAssigned() && !e.isEObjectRuleCall()" +
			"		).map(e | e.rule)\n" + 
			"	}\n" +
			"	def function2() {\n" +
			"		newArrayList(function1().head())\n" +
			"	}\n" +
			"}";
		XtendClass clazz = clazz(classAsString);
		IResourceValidator validator = ((XtextResource) clazz.eResource()).getResourceServiceProvider().getResourceValidator();
		List<Issue> issues = validator.validate(clazz.eResource(), CheckMode.ALL, CancelIndicator.NullImpl);
		assertTrue("Resource contained errors : " + issues.toString(), issues.isEmpty());
		XtendFunction function1 = (XtendFunction) clazz.getMembers().get(1);
		JvmOperation operation1 = associator.getDirectlyInferredOperation(function1);
		assertEquals("java.lang.Iterable<org.eclipse.xtext.AbstractRule>", operation1.getReturnType().getIdentifier());
		XtendFunction function2 = (XtendFunction) clazz.getMembers().get(2);
		JvmOperation operation2 = associator.getDirectlyInferredOperation(function2);
		assertEquals("java.util.ArrayList<org.eclipse.xtext.AbstractRule>", operation2.getReturnType().getIdentifier());
	}
	
	public void testBug345433_02() throws Exception {
		String classAsString = 
			"import static extension org.eclipse.xtext.GrammarUtil.*\n" +
			"class Foo {" +
			"	org.eclipse.xtext.Grammar grammar\n" +
			"	def function1() {\n" + 
			"		grammar.containedRuleCalls.filter(e0 | " +
			"			!e0.isAssigned() && !e0.isEObjectRuleCall()" +
			"		).map(e1 | e1.rule)\n" + 
			"	}\n" +
			"}";
		XtendClass clazz = clazz(classAsString);
		IResourceValidator validator = ((XtextResource) clazz.eResource()).getResourceServiceProvider().getResourceValidator();
		List<Issue> issues = validator.validate(clazz.eResource(), CheckMode.ALL, CancelIndicator.NullImpl);
		assertTrue("Resource contained errors : " + issues.toString(), issues.isEmpty());
		XtendFunction function = (XtendFunction) clazz.getMembers().get(1);
		XExpression body = function.getExpression();
		ITypeProvider typeProvider = get(ITypeProvider.class);
		JvmTypeReference bodyType = typeProvider.getType(body);
		assertEquals("java.lang.Iterable<org.eclipse.xtext.AbstractRule>", bodyType.getIdentifier());
		XBlockExpression block = (XBlockExpression) body;
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(0);
		XClosure closure = (XClosure) featureCall.getMemberCallArguments().get(0);
		JvmFormalParameter e1 = closure.getFormalParameters().get(0);
		assertEquals("e1", e1.getSimpleName());
		assertEquals("org.eclipse.xtext.RuleCall", typeProvider.getTypeForIdentifiable(e1).getIdentifier());
	}
	
	public void testBug342848() throws Exception {
		String fileAsText= 
				"import org.eclipse.xtext.xbase.lib.Functions\n" +
				"class Clazz { def void method(Functions$Function0<Integer> f) { f.apply } }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) file.getXtendClass().getMembers().get(0);
		XtendParameter parameter = function.getParameters().get(0);
		String identifier = parameter.getParameterType().getIdentifier();
		assertEquals(Functions.Function0.class.getName()+ "<java.lang.Integer>", identifier);
	}
}
