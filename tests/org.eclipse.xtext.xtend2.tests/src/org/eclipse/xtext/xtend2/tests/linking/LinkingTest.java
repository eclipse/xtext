/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import static com.google.common.collect.Iterables.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
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
import org.eclipse.xtext.xbase.XAssignment;
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
import org.eclipse.xtext.xtend2.xtend2.XtendConstructor;
import org.eclipse.xtext.xtend2.xtend2.XtendField;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendParameter;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import testdata.OverloadedMethods;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class LinkingTest extends AbstractXtend2TestCase {
	
	@Inject
	private IXtend2JvmAssociations associator;
	
	public void testDeclaredConstructor_01() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  int i" +
				"  new(int i) { this.i = i }" +
				"}");
		assertEquals(2, clazz.getMembers().size());
		
		XtendConstructor constructor = (XtendConstructor) clazz.getMembers().get(1);
		XAssignment assignment = (XAssignment) ((XBlockExpression)constructor.getExpression()).getExpressions().get(0);
		JvmField field = (JvmField) assignment.getFeature();
		assertEquals("i", field.getSimpleName());
		XFeatureCall target = (XFeatureCall) assignment.getAssignable();
		JvmDeclaredType identifiableElement = (JvmDeclaredType) target.getFeature();
		assertEquals("Foo", identifiableElement.getSimpleName());
		XFeatureCall value = (XFeatureCall) assignment.getValue();
		JvmFormalParameter parameter = (JvmFormalParameter) value.getFeature();
		assertEquals("i", parameter.getSimpleName());
	}
	
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
		Set<EObject> elements = associator.getJvmElements(func);
		Iterable<JvmOperation> filter = filter(elements, JvmOperation.class);
		JvmOperation initializer = filter(filter, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().startsWith("_init_");
			}
		}).iterator().next();
		assertEquals(initializer.getParameters().get(0), featureCall.getFeature());
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
	
	public void testExtensionMethodCall_Bug351827_01() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  extension testdata.Properties1 p\n" +
				"  def foo(String s) {\n" +
				"    s.setProp1()\n" +
				"  }\n" +
				"  def setProp1(String s) { s }" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("Foo.setProp1(java.lang.String)", call.getFeature().getIdentifier());
	}
	
	public void testExtensionMethodCall_Bug351827_02() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  extension testdata.Properties1 p\n" +
				"  def foo(String s) {\n" +
				"    s.setProp1\n" +
				"  }\n" +
				"  def setProp1(String s) { s }" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("Foo.setProp1(java.lang.String)", call.getFeature().getIdentifier());
	}
	
	public void testExtensionMethodCall_Bug351827_03() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  extension testdata.Properties1 p\n" +
				"  def foo(String s) {\n" +
				"    s.setProp1\n" +
				"  }\n" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("testdata.Properties1.setProp1(java.lang.String)", call.getFeature().getIdentifier());
	}
	
	public void testExtensionMethodCall_01() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  def foo() {\n" + 
				"    var java.util.List<? extends String> list = null;\n" + 
				"    list.map(e|e.toUpperCase)\n" +
				"  }\n" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.ListExtensions.map(java.util.List,org.eclipse.xtext.xbase.lib.Functions$Function1)", call.getFeature().getIdentifier());
	}
	
	public void testExtensionMethodCall_02() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  def doSomething() {\n" + 
				"    new Object().doSomething\n" +
				"  }\n" +
				"  def doSomething(Object o) {}" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("Foo.doSomething(java.lang.Object)", call.getFeature().getIdentifier());
		assertNull(call.getInvalidFeatureIssueCode(), call.getInvalidFeatureIssueCode());
	}
	
	public void testCaseFunction_00() throws Exception {
		XtendFunction function = function("def dispatch String foo(String s) {_foo(s)}");
		final XBlockExpression block = (XBlockExpression) function.getExpression();
		final JvmOperation feature = (JvmOperation) ((XAbstractFeatureCall)block.getExpressions().get(0)).getFeature();
		XtendFunction xtendFunction = (XtendFunction) associator.getSourceElements(feature).iterator().next();
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
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		assertEquals(operation.getParameters().get(0), featureCall1.getFeature());
	}
	
	public void testFeatureScope_3() throws Exception {
		XtendFile file = file ("import java.lang.String class X { def String foo(String foo) {[String foo|foo]}}");
		XtendClass xClass = file.getXtendClass();
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(0);
		XClosure closure = (XClosure) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) (((XBlockExpression)closure.getExpression()).getExpressions().get(0));
		assertEquals(closure.getFormalParameters().get(0), featureCall1.getFeature());
	}
	
	public void testOverloadedMethods_01() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<CharSequence> chars = null\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(chars, strings)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.util.Collection,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethods_02() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<CharSequence> chars = null\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(strings, chars)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.lang.Iterable,java.util.Collection)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethods_03() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(strings, strings)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.util.List,java.util.List)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethods_04() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<? extends Object> objects = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(objects, objects)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.lang.Iterable,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethodsJava_01() throws Exception {
		List<CharSequence> chars = null;
		List<String> strings = null;
		List<? extends Object> objects = null;
		assertEquals("overloaded(Collection,Iterable)", new OverloadedMethods<Object>().overloaded(chars, strings));
		assertEquals("overloaded(Iterable,Collection)", new OverloadedMethods<Object>().overloaded(strings, chars));
		assertEquals("overloaded(List,List)", new OverloadedMethods<Object>().overloaded(strings, strings));
		assertEquals("overloaded(List,List)", new OverloadedMethods<Object>().overloaded(chars, chars));
		assertEquals("overloaded(Iterable,Iterable)", new OverloadedMethods<Object>().overloaded(objects, objects));
	}
	
	public void testOverloadedMethods_05() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<CharSequence> chars = null\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<CharSequence> receiver = null\n" +
				"    receiver.overloaded2(chars, strings)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.util.Collection,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethods_06() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<CharSequence> chars = null\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<CharSequence> receiver = null\n" +
				"    receiver.overloaded2(strings, chars)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.lang.Iterable,java.util.Collection)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethods_07() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<String> receiver = null\n" +
				"    receiver.overloaded2(strings, strings)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.util.List,java.util.List)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethods_08() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<? extends Object> objects = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded2(objects, objects)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.lang.Iterable,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethods_09() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<? extends CharSequence> chars = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded2(chars, chars)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.lang.Iterable,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethodsJava_02() throws Exception {
		List<CharSequence> chars = null;
		List<String> strings = null;
		List<? extends Object> objects = null;
		List<? extends CharSequence> chars2 = null;
		assertEquals("overloaded2(Collection,Iterable)", new OverloadedMethods<CharSequence>().overloaded2(chars, strings));
		assertEquals("overloaded2(Iterable,Collection)", new OverloadedMethods<CharSequence>().overloaded2(strings, chars));
		assertEquals("overloaded2(List,List)", new OverloadedMethods<String>().overloaded2(strings, strings));
		assertEquals("overloaded2(List,List)", new OverloadedMethods<CharSequence>().overloaded2(chars, chars));
		assertEquals("overloaded2(Iterable,Iterable)", new OverloadedMethods<Object>().overloaded2(objects, objects));
		assertEquals("overloaded2(Iterable,Iterable)", new OverloadedMethods<Object>().overloaded2(chars2, chars2));
	}
	
	public void testOverloadedMethods_10() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var int i = 0\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloadedInt(i)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloadedInt(int)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethods_11() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
						"class X {\n" +
						"  def foo() {\n" +
						"    var Integer i = 0\n" +
						"    var testdata.OverloadedMethods<Object> receiver = null\n" +
						"    receiver.overloadedInt(i)\n" +
						"  }\n" +
				"}");
		XtendClass clazz = file.getXtendClass();
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloadedInt(java.lang.Integer)", overloaded.getIdentifier());
	}
	
	public void testOverloadedMethodsJava_03() throws Exception {
		int i = 0;
		Integer integer = null;
		assertEquals("overloadedInt(int)", new OverloadedMethods<Object>().overloadedInt(i));
		assertEquals("overloadedInt(Integer)", new OverloadedMethods<Object>().overloadedInt(integer));
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
		String fileAsText= "import static extension java.util.Collections.* class Clazz { def void method() {''.singletonList} }";
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
		XtendFunction function = function(
				"def <T extends java.lang.Object> test(T t) {\n" + 
				"  t.getClass\n" + 
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.lang.Object.getClass()", identifier);
	}
	
	public void testBug343102_02() throws Exception {
		XtendFunction function = function(
				"def <T> test(T t) {\n" + 
				"  t.getClass\n" + 
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.lang.Object.getClass()", identifier);
	}
	
	public void testBug345827_01() throws Exception {
		XtendFunction function = function(
				"def String name() {\n" + 
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
		XtendFunction function = function(
				"def String name() {\n" + 
				"  var name = ''\n" +
				"  name()" + 
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(1);
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
	
	public void testBug345827_03() throws Exception {
		XtendFunction function = function(
				"def String name(String param) {\n" + 
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
		XtendFunction function = function(
				"def String name(String param) {\n" + 
				"  var name = ''\n" +
				"  name('param')" + 
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(1);
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
	
	public void testBug345827_05() throws Exception {
		XtendFunction function = function(
				"def String name(String name) {\n" + 
				"  name()" + 
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(0);
		// TODO actually we should prefer the function in case 'explicitOperationCall' is true
		// for a featureCall
		JvmOperation operation = associator.getDirectlyInferredOperation(function);
		assertSame(operation.getParameters().get(0), featureCall.getFeature());
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
	
	public void testRelativeImports() throws Exception {
		XtendFile file = file (
				"package annotation class X {\n" +
				"  Annotation failed\n" +
				"  java.lang.annotation.Annotation success\n" +
				"  reflect.AccessibleObject failedToo\n" +
				"}");
		XtendClass xClass = file.getXtendClass();
		XtendField failed  = (XtendField) xClass.getMembers().get(0);
		assertTrue("Annotation", failed.getType().getType().eIsProxy());
		XtendField success  = (XtendField) xClass.getMembers().get(1);
		assertFalse("java.lang.annotation", success.getType().getType().eIsProxy());
		XtendField failedToo  = (XtendField) xClass.getMembers().get(2);
		assertTrue("reflect.AccessibleObject", failedToo.getType().getType().eIsProxy());
	}
	
	public void testImplicitFirstArgument_00() throws Exception {
		XtendClass clazz = clazz(
				"class MyXtendClass {\n" + 
				"  def prependHello(String myString) {\n" + 
				"    'Hello '+myString\n" + 
				"  }\n" + 
				"  def testExtensionMethods(String it) {\n" + 
				"    it.prependHello\n" + 
				"    prependHello\n" + 
				"  }\n" + 
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(1);
		XMemberFeatureCall first = (XMemberFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation firstFeature = (JvmOperation) first.getFeature();
		assertEquals("prependHello", firstFeature.getSimpleName());
		assertNull(first.getInvalidFeatureIssueCode(), first.getInvalidFeatureIssueCode());
		XFeatureCall firstReceiver = (XFeatureCall) first.getImplicitReceiver();
		assertEquals("MyXtendClass", firstReceiver.getFeature().getSimpleName());
		XFeatureCall second = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(1);
		JvmOperation secondFeature = (JvmOperation) second.getFeature();
		assertEquals("prependHello", secondFeature.getSimpleName());
		assertNull(second.getInvalidFeatureIssueCode(), second.getInvalidFeatureIssueCode());
		assertFalse(secondFeature.eIsProxy());
		XFeatureCall secondReceiver = (XFeatureCall) second.getImplicitReceiver();
		assertEquals("MyXtendClass", secondReceiver.getFeature().getSimpleName());
		XFeatureCall implicitArgument = (XFeatureCall) second.getImplicitFirstArgument();
		assertNotNull(implicitArgument);
		assertEquals("it", implicitArgument.getFeature().getSimpleName());
	}
	
	public void testImplicitFirstArgument_00_a() throws Exception {
		XtendClass clazz = clazz(
				"class MyXtendClass {\n" + 
				"  def prependHello(String myString) {\n" + 
				"    'Hello '+myString\n" + 
				"  }\n" + 
				"  def testExtensionMethods(String it) {\n" + 
				"    it.prependHello\n" + 
				"  }\n" + 
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(1);
		XMemberFeatureCall first = (XMemberFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation firstFeature = (JvmOperation) first.getFeature();
		assertEquals("prependHello", firstFeature.getSimpleName());
		assertNull(first.getInvalidFeatureIssueCode(), first.getInvalidFeatureIssueCode());
		XFeatureCall firstReceiver = (XFeatureCall) first.getImplicitReceiver();
		assertEquals("MyXtendClass", firstReceiver.getFeature().getSimpleName());
	}
	
	public void testImplicitFirstArgument_00_b() throws Exception {
		XtendClass clazz = clazz(
				"class MyXtendClass {\n" + 
						"  def prependHello(String myString) {\n" + 
						"  }\n" + 
						"  def testExtensionMethods(String it) {\n" + 
						"    prependHello\n" + 
						"  }\n" + 
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(1);
		XFeatureCall first = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation firstFeature = (JvmOperation) first.getFeature();
		assertEquals("prependHello", firstFeature.getSimpleName());
		assertNull(first.getInvalidFeatureIssueCode(), first.getInvalidFeatureIssueCode());
	}
	
	public void testImplicitFirstArgument_01() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    length\n" +
				"  }\n" +
				"  extension String" +
				"  def length() { null }\n" +
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall first = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation firstFeature = (JvmOperation) first.getFeature();
		assertEquals("java.lang.CharSequence.length()", firstFeature.getIdentifier());
		assertEquals("java.lang.CharSequence", firstFeature.getDeclaringType().getQualifiedName());
		assertNull(first.getImplicitFirstArgument());
		XFeatureCall firstReceiver = (XFeatureCall) first.getImplicitReceiver();
		assertTrue(firstReceiver.getFeature() instanceof JvmFormalParameter);
		assertNull(first.getInvalidFeatureIssueCode());
	}
	
	public void testImplicitFirstArgument_02() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    toUpperCase\n" +
				"  }\n" +
				"  extension String" +
				"  def toUpperCase() { null }\n" + 
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall second = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation secondFeature = (JvmOperation) second.getFeature();
		assertEquals("MyXtendClass.toUpperCase()", secondFeature.getIdentifier());
		assertEquals(0, secondFeature.getParameters().size());
		assertNull(second.getImplicitFirstArgument());
		XFeatureCall secondReceiver = (XFeatureCall) second.getImplicitReceiver();
		assertTrue(secondReceiver.getFeature() instanceof JvmGenericType);
		assertNull(second.getInvalidFeatureIssueCode());
	}
	
	public void testImplicitFirstArgument_03() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    toLowerCase\n" + 
				"  }\n" +
				"  extension String" +
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall third = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation thirdFeature = (JvmOperation) third.getFeature();
		assertEquals("java.lang.String.toLowerCase()", thirdFeature.getIdentifier());
		assertNull(third.getImplicitFirstArgument());
		XMemberFeatureCall thirdReceiver = (XMemberFeatureCall) third.getImplicitReceiver();
		assertTrue(thirdReceiver.getFeature() instanceof JvmField);
		assertNull(third.getInvalidFeatureIssueCode(), third.getInvalidFeatureIssueCode());
	}
	
	public void testImplicitFirstArgument_04() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    unique" +
				"  }\n" +
				"  extension String" +
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall forth = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation forthFeature = (JvmOperation) forth.getFeature();
		assertEquals("test.ImplicitFirstArgumentStatics.unique()", forthFeature.getIdentifier());
		assertNull(forth.getImplicitFirstArgument());
		assertNull(forth.getImplicitReceiver());
		assertNull(forth.getInvalidFeatureIssueCode());
	}
	
	public void testImplicitFirstArgument_05() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    withObject\n" + 
				"  }\n" +
				"  extension String" +
				"  def withObject(Object obj) { null }" + 
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall fifth = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation fifthFeature = (JvmOperation) fifth.getFeature();
		assertEquals("MyXtendClass.withObject(java.lang.Object)", fifthFeature.getIdentifier());
		assertEquals(1, fifthFeature.getParameters().size());
		assertNotNull(fifth.getImplicitFirstArgument());
		assertEquals("it", ((XAbstractFeatureCall) fifth.getImplicitFirstArgument()).getFeature().getSimpleName());
		XFeatureCall fifthReceiver = (XFeatureCall) fifth.getImplicitReceiver();
		assertTrue(fifthReceiver.getFeature() instanceof JvmGenericType);
		assertNull(fifth.getInvalidFeatureIssueCode(), fifth.getInvalidFeatureIssueCode());
	}
	
	public void testImplicitFirstArgument_06() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    contains\n" + 
				"  }\n" +
				"  extension String" +
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall sixth = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation sixthFeature = (JvmOperation) sixth.getFeature();
		assertEquals("java.lang.String.contains(java.lang.CharSequence)", sixthFeature.getIdentifier());
		assertEquals("java.lang.String", sixthFeature.getDeclaringType().getQualifiedName());
		assertNotNull(sixth.getImplicitFirstArgument());
		assertEquals("it", ((XAbstractFeatureCall) sixth.getImplicitFirstArgument()).getFeature().getSimpleName());
		XMemberFeatureCall sixthReceiver = (XMemberFeatureCall) sixth.getImplicitReceiver();
		assertTrue(sixthReceiver.getFeature() instanceof JvmField);
		assertNull(sixth.getInvalidFeatureIssueCode(), sixth.getInvalidFeatureIssueCode());
	}
	
	public void testImplicitFirstArgument_07() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    withCharSequence\n" + 
				"  }\n" +
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall seventh = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation seventhFeature = (JvmOperation) seventh.getFeature();
		assertEquals("test.ImplicitFirstArgumentStatics.withCharSequence(java.lang.CharSequence)", 
				seventhFeature.getIdentifier());
		assertNotNull(seventh.getImplicitReceiver());
		assertNull(seventh.getImplicitFirstArgument());
		assertNull(seventh.getInvalidFeatureIssueCode(), seventh.getInvalidFeatureIssueCode());
		assertEquals("it", ((XAbstractFeatureCall) seventh.getImplicitReceiver()).getFeature().getSimpleName());
	}
	
}
