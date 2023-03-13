/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import static org.eclipse.xtend.core.validation.IssueCodes.*;
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*;
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;
import static org.eclipse.xtext.xtype.XtypePackage.Literals.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider.SingletonPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.validation.ReadAndWriteTracking;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendValidationTest extends AbstractXtendTestCase {

	@Inject
	protected ValidationTestHelper helper;
	
	@Inject
	private ReadAndWriteTracking readAndWriteTracking;
	
	private MapBasedPreferenceValues preferences;
	
	@Inject
	public void setPreferences(SingletonPreferenceValuesProvider prefProvider) {
		preferences = prefProvider.getPreferenceValues(null);
	}
	
	@Before
	public void setSeverity() {
		preferences.put(IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, "error");
	}
	
	@After
	public void clearPreferences() {
		preferences.clear();
	}
	
	@Test public void testTemplateCompilesToStringConcatenation_01() throws Exception {
		XtendClass clazz = clazz(
				  "import org.eclipse.xtend2.lib.StringConcatenationClient\n"
				+ "class Z {"
				+ "  def StringConcatenationClient m() {"
				+ "    var myVar = null"
				+ "    return '''«myVar»'''"
				+ "  }"
				+ "}");
		helper.assertError(clazz, XbasePackage.Literals.XFEATURE_CALL, INVALID_MUTABLE_VARIABLE_ACCESS, 
				"Cannot refer to the non-final variable myVar inside this template.",
				"This template compiles to an anonymous subclass of StringConcatenationClient because of its target type.");
	}
	
	@Test public void testTemplateCompilesToStringConcatenation_02() throws Exception {
		XtendClass clazz = clazz(
				  "import org.eclipse.xtend2.lib.StringConcatenationClient\n"
				+ "class Z {"
				+ "  def StringConcatenationClient m() {"
				+ "    val myVar = null"
				+ "    return '''«myVar»'''"
				+ "  }"
				+ "}");
		helper.assertNoErrors(clazz);
	}

	@Test public void testTemplateCompilesToStringConcatenation_03() throws Exception {
		XtendClass clazz = clazz(
				  "import org.eclipse.xtend2.lib.StringConcatenationClient\n"
				+ "class Z {"
				+ "  def m() {"
				+ "    val myVar = null"
				+ "    return '''«myVar»'''"
				+ "  }"
				+ "}");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testExtensionMayNotBePrimitive_01() throws Exception {
		XtendClass clazz = clazz("class Z { extension int x = 1 }");
		helper.assertError(clazz, XTEND_FIELD, INVALID_EXTENSION_TYPE);
	}
	
	@Test public void testExtensionMayNotBePrimitive_02() throws Exception {
		XtendClass clazz = clazz("class Z { extension int = 1 }");
		helper.assertError(clazz, XTEND_FIELD, INVALID_EXTENSION_TYPE);
	}
	
	@Test public void testExtensionMayNotBePrimitive_03() throws Exception {
		XtendClass clazz = clazz("class Z { extension x = 1.toString }");
		helper.assertNoError(clazz, INVALID_EXTENSION_TYPE);
	}
	
	@Test public void testExtensionMayNotBePrimitive_04() throws Exception {
		XtendClass clazz = clazz("class Z { def void m(extension int i) {} }");
		helper.assertError(clazz, XTEND_PARAMETER, INVALID_EXTENSION_TYPE);
	}
	
	@Test public void testExtensionMayNotBePrimitive_05() throws Exception {
		XtendClass clazz = clazz("class Z { def void m(extension Object i) {} }");
		helper.assertNoError(clazz, INVALID_EXTENSION_TYPE);
	}
	
	@Test public void testExtensionMayNotBePrimitive_06() throws Exception {
		XtendClass clazz = clazz("class Z { def void m() { try {} catch(extension int i) {} } }");
		helper.assertNoError(clazz, INVALID_EXTENSION_TYPE);
		helper.assertError(clazz, XTEND_FORMAL_PARAMETER, INCOMPATIBLE_TYPES);
	}
	
	@Test public void testExtensionMayNotBePrimitive_07() throws Exception {
		XtendClass clazz = clazz("class Z { def void m() { extension var i = 0 } }");
		helper.assertError(clazz, XTEND_VARIABLE_DECLARATION, INVALID_EXTENSION_TYPE);
	}
	
	@Test public void testNoSideEffects() throws Exception {
		XtendClass clazz = clazz("class Z { def void foo() { 'foo' } }");
		helper.assertError(clazz, XSTRING_LITERAL, INVALID_INNER_EXPRESSION);
	}
	
	@Test public void testNoSideEffects_02() throws Exception {
		XtendClass clazz = clazz("class Z { def void foo() { " +
				"		val blockElement =\n" + 
				"		  if ('foo'.length > 42) {\n" + 
				"		    'test'\n" + 
				"		  } else {\n" + 
				"		  	'bar'\n" + 
				"		  }\n" + 
				"		blockElement.toString " +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testNoSideEffects_03() throws Exception {
		XtendClass clazz = clazz("class Z { def void foo() { " +
				"		val blockElement =\n" + 
				"		  switch switchOver : if ('x'.length>1) 'foo' {\n" + 
				"		    case try { 'test' } finally { 'sideeffect'.length } : 52" +
				"           default : switch switchOver {" +
				"               case 'x' : 42" +
				"             }\n" + 
				"		  }\n" + 
				"		('f' + blockElement).toString " +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testNoSideEffects_04() throws Exception {
		XtendClass clazz = clazz("class Z { def void foo() { " +
				"		''' no side-effect '''" +
				"  }" +
				"}");
		helper.assertError(clazz, RICH_STRING, INVALID_INNER_EXPRESSION);
	}
	
	@Test public void testNoSideEffects_05() throws Exception {
		XtendClass clazz = clazz("class Z { def void foo() { " +
				"		''' no «'foo'.length» side-effect '''" +
				"  }" +
				"}");
		helper.assertError(clazz, RICH_STRING, INVALID_INNER_EXPRESSION);
	}
	
	@Test public void testFieldInitializerType_01() throws Exception {
		XtendClass clazz = clazz("class Z { String s = 1 }");
		helper.assertError(clazz, XNUMBER_LITERAL, INCOMPATIBLE_TYPES, "cannot convert from int to String");
	}
	
	@Test public void testFieldInitializerType_02() throws Exception {
		XtendClass clazz = clazz("class Z { String s = 1.toString }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testFieldInitializerType_03() throws Exception {
		XtendClass clazz = clazz("class Z { String s = return 1 }");
		helper.assertError(clazz, XNUMBER_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	@Test public void testFieldInitializerType_04() throws Exception {
		XtendClass clazz = clazz("class Z { String s = return '' }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testForwardReferenceInFieldInitializer_01() throws Exception {
		XtendClass clazz = clazz("class Z { String s = s }");
		helper.assertError(clazz, XFEATURE_CALL, ILLEGAL_FORWARD_REFERENCE);
	}
	
	@Test public void testForwardReferenceInFieldInitializer_02() throws Exception {
		XtendClass clazz = clazz("class Z { String s1 = newArrayList(s2 + '').toString String s2 = '' }");
		helper.assertError(clazz, XFEATURE_CALL, ILLEGAL_FORWARD_REFERENCE);
	}
	
	@Test public void testForwardReferenceInFieldInitializer_03() throws Exception {
		XtendClass clazz = clazz("class Z { static String s = s }");
		helper.assertError(clazz, XFEATURE_CALL, ILLEGAL_FORWARD_REFERENCE);
	}
	
	@Test public void testForwardReferenceInFieldInitializer_04() throws Exception {
		XtendClass clazz = clazz("class Z { static String s1 = s2 static String s2 = '' }");
		helper.assertError(clazz, XFEATURE_CALL, ILLEGAL_FORWARD_REFERENCE);
	}

	@Test public void testForwardReferenceInFieldInitializer_05() throws Exception {
		XtendClass clazz = clazz("class Z { String s = '' }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testForwardReferenceInFieldInitializer_06() throws Exception {
		XtendClass clazz = clazz("class Z { String s1 = '' String s2 = s1 }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testForwardReferenceInFieldInitializer_07() throws Exception {
		XtendClass clazz = clazz("class Z { static String s = '' }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testForwardReferenceInFieldInitializer_08() throws Exception {
		XtendClass clazz = clazz("class Z { static String s1 = '' static String s2 = s1 }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testForwardReferenceInFieldInitializer_09() throws Exception {
		XtendClass clazz = clazz("class Z { static val x = [| y] static val y = [|''] }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorInInterface() throws Exception {
		XtendInterface interfaze = interfaze("interface Foo { new() {} }");
		helper.assertError(interfaze, XTEND_CONSTRUCTOR, CONSTRUCTOR_NOT_PERMITTED);
	}
	
	@Test public void testCircularConstructor_01() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this() }}");
		helper.assertError(clazz, XFEATURE_CALL, CIRCULAR_CONSTRUCTOR_INVOCATION);
	}
	
	@Test public void testCircularConstructor_02() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(1) } new(int a) { this() } }");
		helper.assertError(clazz.getMembers().get(0), XFEATURE_CALL, CIRCULAR_CONSTRUCTOR_INVOCATION);
		helper.assertError(clazz.getMembers().get(1), XFEATURE_CALL, CIRCULAR_CONSTRUCTOR_INVOCATION);
	}
	
	@Test public void testCircularConstructor_03() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(1) } new(int a) { super() } }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorCallIsFirst_01() throws Exception {
		XtendClass clazz = clazz("class Z { new() { super() } new(int a) { this() } }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorCallIsFirst_02() throws Exception {
		XtendClass clazz = clazz("class Z { new() { { this() } }}");
		helper.assertError(clazz, XFEATURE_CALL, INVALID_CONSTRUCTOR_INVOCATION);
	}
	
	@Test public void testConstructorCallIsFirst_03() throws Exception {
		XtendClass clazz = clazz("class Z { new() { if (true) super() } }");
		helper.assertError(clazz, XFEATURE_CALL, INVALID_CONSTRUCTOR_INVOCATION);
	}
	
	@Test public void testConstructorArgumentIsValid_01() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(1) } new(int i) {} }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorArgumentIsValid_02() throws Exception {
		XtendClass clazz = clazz("class Z { static int j new() { this(j) } new(int i) {} }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorArgumentIsValid_03() throws Exception {
		XtendClass clazz = clazz("class Z { int j new() { this(j) } new(int i) {} }");
		helper.assertError(clazz.getMembers().get(1), XFEATURE_CALL, INVALID_CONSTRUCTOR_ARGUMENT);
	}
	
	@Test public void testConstructorArgumentIsValid_04() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z()) } new(Object o) {} def z() { null } }");
		helper.assertError(clazz.getMembers().get(0), XFEATURE_CALL, INVALID_CONSTRUCTOR_ARGUMENT);
	}
	
	@Test public void testConstructorArgumentIsValid_05() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(null as Object) } new(Object o) {} }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorArgumentIsValid_06() throws Exception {
		XtendClass clazz = clazz("class Z { new(Object o) { this(o as String) } new(String o) {} }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorArgumentIsValid_07() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z()) } new(Object o) {} def static z() { null } }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorArgumentIsValid_08() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z() as String) } new(Object o) {} def static z() { null } }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorArgumentIsValid_09() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z() as String) } new(Object o) {} def z() { null } }");
		helper.assertError(clazz.getMembers().get(0), XFEATURE_CALL, INVALID_CONSTRUCTOR_ARGUMENT);
	}
	
	@Test public void testConstructorArgumentIsValid_10() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z().toString + '') } new(Object o) {} def static z() { null } }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorArgumentIsValid_11() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z().toString + '') } new(Object o) {} def z() { null } }");
		helper.assertError(clazz.getMembers().get(0), XFEATURE_CALL, INVALID_CONSTRUCTOR_ARGUMENT);
	}
	
	@Test public void testConstructorArgumentIsValid_12() throws Exception {
		XtendClass clazz = clazz("class Foo extends Exception { new(java.util.List<Object> foo) { super(foo.map[toString].join) } }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorArgumentIsValid_13() throws Exception {
		XtendClass clazz = clazz("class Foo extends Exception { new(Object it) { super(toString) } }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testConstructorArgumentIsValid_14() throws Exception {
		XtendClass clazz = clazz("class Foo extends Exception { new(Object obj) { super(toString) } }");
		helper.assertError(clazz.getMembers().get(0), XFEATURE_CALL, INVALID_CONSTRUCTOR_ARGUMENT);
	}
	
	@Test public void testConstructorArgumentIsValid_15() throws Exception {
		XtendClass clazz = clazz("class Foo extends Exception { new(Object it) { super(this.toString) } }");
		helper.assertError(clazz.getMembers().get(0), XMEMBER_FEATURE_CALL, INVALID_CONSTRUCTOR_ARGUMENT);
	}
	
	@Test public void testConstructorDuplicate() throws Exception {
		XtendClass clazz = clazz("class K { new(Object o) {} new(Object o) {} }");
		helper.assertError(clazz, XTEND_CONSTRUCTOR, DUPLICATE_METHOD);
		helper.assertError(clazz, XTEND_CONSTRUCTOR, DUPLICATE_METHOD);
	}
	
	@Test public void testConstructorDuplicateErasure() throws Exception {
		XtendClass clazz = clazz("class K { new(java.util.List<Object> o) {} new(java.util.List<String> o) {} }");
		helper.assertError(clazz, XTEND_CONSTRUCTOR, DUPLICATE_METHOD);
		helper.assertError(clazz, XTEND_CONSTRUCTOR, DUPLICATE_METHOD);
	}
	
	@Test public void testConstructorDoesNotSupportTypeArguments() throws Exception {
		XtendClass clazz = clazz("class K { new<T>() {} }");
		helper.assertError(clazz, XTEND_CONSTRUCTOR, CONSTRUCTOR_TYPE_PARAMS_NOT_SUPPORTED);
	}

	@Test public void testMissingConstructor() throws Exception {
		XtendClass clazz = clazz("class K extends test.NoDefaultConstructor {}");
		helper.assertError(clazz, XTEND_CLASS, MISSING_CONSTRUCTOR);
	}
	
	@Test public void testMissingSuperConstructorCall() throws Exception {
		XtendClass clazz = clazz("class K extends test.NoDefaultConstructor { new() {} }");
		helper.assertError(clazz, XTEND_CONSTRUCTOR, MUST_INVOKE_SUPER_CONSTRUCTOR);
	}
	
	@Test public void testSuperConstructorCall() throws Exception {
		XtendClass clazz = clazz("class K extends test.NoDefaultConstructor { new() { super('') } }");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testReturnStatement() throws Exception {
		XtendClass clazz = clazz("class Z { def void foo() { return 'holla' }}");
		helper.assertError(clazz, XRETURN_EXPRESSION, INVALID_RETURN);
	}
	
	@Test public void testReturnStatement1() throws Exception {
		XtendClass clazz = clazz("class Z { def Object foo() { return }}");
		helper.assertError(clazz, XRETURN_EXPRESSION, INVALID_RETURN);
	}
	
	@Test public void testReturnStatement2() throws Exception {
		XtendClass clazz = clazz("class Z { def Object foo() { val Object x = if (false) return }}");
		helper.assertError(clazz, XRETURN_EXPRESSION, INVALID_RETURN);
	}
	
	@Test public void testReturnStatement3() throws Exception {
		XtendClass clazz = clazz("class Z { def Object foo() { val Object x = if (false) return '' }}");
		helper.assertNoError(clazz, INVALID_RETURN);
	}
	
	@Test public void testReturnStatement4() throws Exception {
		XtendClass clazz = clazz("class Z { def void foo() { val Object x = if (false) return; x.toString }}");
		helper.assertNoError(clazz, INVALID_RETURN);
	}
	
	@Test public void testReturnStatement5() throws Exception {
		XtendClass clazz = clazz("class Z { def foo() { val Object x = if (false) return; x }}");
		helper.assertError(clazz, XFEATURE_CALL, INVALID_INNER_EXPRESSION);
	}

	@Test public void testReturnStatement6() throws Exception {
		XtendClass clazz = clazz("class Z { def foo() { val Object x = if (false) return ''; x }}");
		helper.assertNoError(clazz, INVALID_RETURN);
	}
	
	@Test public void testBug_357230() throws Exception {
		XtendClass clazz = clazz(
				"package x class Z {" +
				"  def dispatch _foo(Object x, boolean b) {}\n" +
				"  def dispatch _foo(String x, boolean b) {}\n" +
				"}\n");
		helper.assertError(clazz, XTEND_FUNCTION, DISPATCH_FUNC_NAME_STARTS_WITH_UNDERSCORE);
	}
	
	@Test public void testAnnotationTarget_00() throws Exception {
		XtendClass clazz = clazz("@testdata.Annotation2('foo') class X { }");
		helper.assertError(clazz, XAnnotationsPackage.Literals.XANNOTATION, ANNOTATION_WRONG_TARGET, "@Annotation2");
	}
	
	@Test public void testAnnotationTarget_01() throws Exception {
		XtendClass clazz = clazz("class X { @testdata.Annotation2('foo')  String foo }");
		helper.assertNoErrors(clazz);
	}

	@Test public void testAnnotationTarget_02() throws Exception {
		XtendClass clazz = clazz("class X { @testdata.Annotation2('foo') def String foo() }");
		helper.assertError(clazz, XAnnotationsPackage.Literals.XANNOTATION, ANNOTATION_WRONG_TARGET);
	}
	
	@Test public void testAnnotationTarget_03() throws Exception {
		XtendClass clazz = clazz("class X {  def String foo(@testdata.Annotation2('foo') String bar) }");
		helper.assertError(clazz, XAnnotationsPackage.Literals.XANNOTATION, ANNOTATION_WRONG_TARGET);
	}
	
	@Test public void testAnnotationTarget_04() throws Exception {
		XtendEnum enumeration = enumeration("@testdata.Annotation2('foo') enum X { }");
		helper.assertError(enumeration, XAnnotationsPackage.Literals.XANNOTATION, ANNOTATION_WRONG_TARGET, "@Annotation2");
	}
	
	@Test public void testAnnotationTarget_05() throws Exception {
		XtendInterface interfaze = interfaze("@testdata.Annotation2('foo') interface X { }");
		helper.assertError(interfaze, XAnnotationsPackage.Literals.XANNOTATION, ANNOTATION_WRONG_TARGET, "@Annotation2");
	}
	
	@Test public void testAnnotationTarget_06() throws Exception {
		XtendAnnotationType annotationType = annotationType("@testdata.Annotation2('foo') annotation X { }");
		helper.assertError(annotationType, XAnnotationsPackage.Literals.XANNOTATION, ANNOTATION_WRONG_TARGET, "@Annotation2");
	}
	
	@Test public void testAnnotationTarget_07() throws Exception {
		XtendAnnotationType annotationType = annotationType("@testdata.Annotation4 annotation A {}");
		helper.assertNoErrors(annotationType);
	}
	
	@Test public void testAnnotationTarget_08() throws Exception {
		XtendClass clazz = clazz("@testdata.Annotation4 class C {}");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testAnnotationTarget_09() throws Exception {
		XtendAnnotationType annotationType = annotationType("@testdata.Annotation5 annotation A {}");
		helper.assertNoErrors(annotationType);
	}
	
	@Test public void testAnnotationTarget_10() throws Exception {
		XtendClass clazz = clazz("@testdata.Annotation5 class C {}");
		helper.assertError(clazz, XAnnotationsPackage.Literals.XANNOTATION, ANNOTATION_WRONG_TARGET);
	}
	
	@Test public void testAnnotationTarget_11() throws Exception {
		XtendAnnotationType annotationType = annotationType("annotation A { @testdata.Annotation6 String value = 'Issue206'}");
		helper.assertNoErrors(annotationType);
	}
	
	@Test public void testAnnotationTarget_12() throws Exception {
		XtendClass clazz = clazz("class C { @testdata.Annotation6 String value = 'Issue206'}");
		helper.assertError(clazz, XAnnotationsPackage.Literals.XANNOTATION, ANNOTATION_WRONG_TARGET);
	}
	
	@Test public void testMultipleAnnotations_00() throws Exception {
		XtendClass clazz = clazz("@testdata.Annotation4 @testdata.Annotation4  class X { }");
		helper.assertError(clazz, XAnnotationsPackage.Literals.XANNOTATION, ANNOTATION_MULTIPLE, "@Annotation4");
	}
	
	@Test public void testMultipleAnnotations_01() throws Exception {
		XtendClass clazz = clazz("@testdata.Annotation1(value = true,children=#[@testdata.Annotation2('bar'), @testdata.Annotation2('foo')])  class X { }");
		helper.assertNoErrors(clazz);
	}

	@Test public void testShadowingVariableNames_00() throws Exception {
		XtendClass clazz = clazz("class X { def foo() { val this = 'foo' } }");
		helper.assertError(clazz, XVARIABLE_DECLARATION, VARIABLE_NAME_DISALLOWED);
	}
	
	@Test public void testShadowingVariableNames_01() throws Exception {
		XtendClass clazz = clazz("class X { def foo() { val ^super = 'foo' } }");
		helper.assertError(clazz, XVARIABLE_DECLARATION, VARIABLE_NAME_DISALLOWED);
	}
	
	@Test public void testShadowingVariableNames_03() throws Exception {
		XtendClass clazz = clazz("class X { def foo(String this) { } }");
		helper.assertError(clazz, XTEND_PARAMETER, VARIABLE_NAME_DISALLOWED);
	}
	
	@Test public void testShadowingVariableNames_04() throws Exception {
		XtendClass clazz = clazz("class X { def foo(String x) ''' «val x = 'foo'» «x» ''' }");
		helper.assertError(clazz, XVARIABLE_DECLARATION, VARIABLE_NAME_SHADOWING);
	}
	
	@Test public void testShadowingVariableNames_05() throws Exception {
		XtendClass clazz = clazz("class X { def foo() ''' «val x = 'foo'» «val x = 'bar'» ''' }");
		helper.assertError(clazz, XVARIABLE_DECLARATION, VARIABLE_NAME_SHADOWING);
	}
	
	@Test public void testSelf_0() throws Exception {
		XtendClass clazz = clazz("class X { def foo() { val self = 1 } }");
		helper.assertWarning(clazz, XVARIABLE_DECLARATION, VARIABLE_NAME_DISCOURAGED);
	}
	
	@Test public void testSelf_1() throws Exception {
		XtendClass clazz = clazz("class X { def foo() { val ()=>void x = [| self.apply ]} }");
		helper.assertNoError(clazz, VARIABLE_NAME_DISCOURAGED);
	}
	
	@Test public void testSelf_2() throws Exception {
		XtendClass clazz = clazz("class X { public val self = '' }");
		helper.assertWarning(clazz, XTEND_FIELD, VARIABLE_NAME_DISCOURAGED);
	}
	
	@Test public void testSelf_3() throws Exception {
		XtendClass clazz = clazz("class X { def foo(String self) {} }");
		helper.assertWarning(clazz, XTEND_PARAMETER, VARIABLE_NAME_DISCOURAGED);
	}
	
	@Test public void testVoidInDependency() throws Exception {
		XtendClass clazz = clazz("class X { @Inject void v }");
		helper.assertError(clazz, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE);
	}
	
	@Test public void testVoidInReturn() throws Exception {
		XtendFunction function = function("def void foo() { }");
		helper.assertNoError(function, INVALID_USE_OF_TYPE);
	}
	
	@Test public void testParameterTypeMayNotBeVoid() throws Exception {
		XtendFunction function = function("def void foo(void myParam) { }");
		helper.assertError(function, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE);
	}
	
	@Test public void testVarArgIsNotExtension() throws Exception {
		XtendFunction function = function("def void foo(extension String... myParam) { }");
		helper.assertError(function, XtendPackage.Literals.XTEND_PARAMETER, INVALID_USE_OF_VAR_ARG, "A vararg may not be an extension.");
	}
	
	@Test public void testVarArgMustBeLast_0() throws Exception {
		XtendFunction function = function("def void foo(String... myParam, String x) { }");
		helper.assertError(function, XtendPackage.Literals.XTEND_PARAMETER, INVALID_USE_OF_VAR_ARG);
	}
	
	@Test public void testVarArgMustBeLast_1() throws Exception {
		XtendConstructor constr = constructor("new(String... myParam, String x) { }");
		helper.assertError(constr, XtendPackage.Literals.XTEND_PARAMETER, INVALID_USE_OF_VAR_ARG);
	}
	
	@Test public void testVarArgMustBeLast_2() throws Exception {
		XtendConstructor constr = constructor("new(String... myParam) { }");
		helper.assertNoErrors(constr);
	}
	
	@Test public void testVarArgMustBeLast_3() throws Exception {
		XtendConstructor constr = constructor("new(int x, String... myParam) { }");
		helper.assertNoErrors(constr);
	}
	
	@Test public void testCreateMayNotReturnVoid() throws Exception {
		XtendFunction function = function("def void create result: new Object() newObject() { }");
		helper.assertError(function, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "void", "create", "newObject");
	}
	
	@Test public void testCreateMayNotBeStatic() throws Exception {
		XtendFunction function = function("def static create new Object() newObject() { }");
		helper.assertError(function, XTEND_FUNCTION, INVALID_USE_OF_STATIC, "not", "static");
	}
	
	@Test public void testCreateExpressionMayNotReturnVoid_01() throws Exception {
		XtendFunction function = function("def create result: while(true){} illegal() { }");
		helper.assertError(function, XTEND_FUNCTION, INVALID_USE_OF_TYPE, "void", "create", "method", "illegal");
	}
	
	@Test public void testCreateExpressionMayNotReturnVoid_02() throws Exception {
		XtendFunction function = function("def String create result: while(true){} illegal() { }");
		helper.assertError(function, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES, "cannot convert from void to String");
	}

	@Test public void testCreateExpressionMayNotReturnVoid_03() throws Exception {
		XtendClass clazz = clazz("class C { String s = '' def create s m(int i) {} }");
		helper.assertNoError(clazz, org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}
	
	@Test public void testCreateExpressionMayAccessFields() throws Exception {
		XtendFunction function = function("override create result: while(true){} toString() { }");
		helper.assertError(function, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES, "cannot convert from void to String");
	}
	
	@Test public void testNoReturnInCreateFunctions() throws Exception {
		XtendFunction function = function("def create result: if (true) return 'foo' else 'bar' foo() { }");
		helper.assertError(function, XRETURN_EXPRESSION, INVALID_EARLY_EXIT);
	}
	
	@Test public void testNoReturnInCreateFunctions_00() throws Exception {
		XtendFunction function = function("def create result: [|if (true) return 'foo' else 'bar'] foo() { }");
		helper.assertNoErrors(function);
	}
	
	@Test public void testNoReturnInCreateFunctions_01() throws Exception {
		XtendFunction function = function("def create result:'foo' foo() { return 'bar' }");
		helper.assertError(function, XRETURN_EXPRESSION, INVALID_RETURN, "Void functions cannot return a value.");
		helper.assertNoError(function, INVALID_EARLY_EXIT);
	}
	
	@Test public void testNoReturnInCreateFunctions_02() throws Exception {
		XtendFunction function = function("def create result:'foo' foo() { return }");
		helper.assertNoErrors(function);
	}
	
	@Test public void testNoReturnInCreateFunctions_03() throws Exception {
		XtendFunction function = function("def create result:'foo' foo() { [|return 'foo'].apply() }");
		helper.assertNoErrors(function);
	}
	
	@Test public void testNoReturnInCreateFunctions_04() throws Exception {
		XtendFunction function = function("def create result:'foo' foo() { if (true) 'foo'+'bar' else return 'baz' }");
		helper.assertError(function, XRETURN_EXPRESSION, INVALID_RETURN, "Void functions cannot return a value.");
		helper.assertNoError(function, INVALID_EARLY_EXIT);
	}
	
	@Test public void testTypeCompatibility_01() throws Exception {
		XtendFile file = file(
				"class Foo { public val Class<? extends java.util.Map<?, ?>> x = typeof(java.util.Map) }");
		helper.assertError(file, XTYPE_LITERAL, INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from Class<Map> to Class<? extends Map<?, ?>>");
	}
	
	@Test public void testTypeCompatibility_02() throws Exception {
		XtendFile file = file(
				"class Foo { public val Class<java.util.Map<?, ?>> x = java.util.Map }");
		helper.assertError(file, XMEMBER_FEATURE_CALL, INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from Class<Map> to Class<Map<?, ?>>");
	}

	@Test public void testReturnTypeCompatibility_00() throws Exception {
		XtendFunction function = function("def void foo(int bar) { }");
		helper.assertNoErrors(function);
	}

	@Test public void testReturnTypeCompatibility_01() throws Exception {
		XtendFunction function = function("def String foo(int bar) { return 42 }");
		helper.assertError(function, XNUMBER_LITERAL, INCOMPATIBLE_TYPES, "String", "int");
	}

	@Test public void testReturnTypeCompatibility_02() throws Exception {
		XtendFunction function = function("def Object foo(int bar) { return 42 }");
		helper.assertNoErrors(function);
	}

	@Test public void testReturnTypeCompatibility_03() throws Exception {
		XtendFunction function = function(
				  "def String foo(int bar) { " 
				+ " if (true) {"
				+ "  return if (false) 42 else new Object()" 
				+ " }" 
				+ "}");
		helper.assertError(function, XCONSTRUCTOR_CALL, INCOMPATIBLE_TYPES, "cannot convert from Object to String");
	}

	@Test public void testReturnTypeCompatibility_04() throws Exception {
		XtendClass clazz = clazz("class Foo implements test.SomeInterface { def foo() { 1 } }");
		helper.assertError(clazz.getMembers().get(0), XTEND_FUNCTION, MISSING_OVERRIDE);
	}

	@Test public void testReturnTypeCompatibility_05() throws Exception {
		XtendClass clazz = clazz("class Foo implements test.SomeInterface { override foo() { true } }");
		helper.assertNoErrors(clazz.getMembers().get(0));
	}
	
	@Test public void testReturnTypeCompatibility_06() throws Exception {
		XtendClass clazz = clazz("class Foo { def dispatch void a(String x) {} def dispatch a(Object x) {return null} }");
		helper.assertError(clazz.getMembers().get(1), XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE);
	}
	
	@Test public void testReturnTypeCompatibility_07() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def void a() {" +
				"    val closure = [Integer i| return i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testReturnTypeCompatibility_08() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def void a() {" +
				"    val closure = [Integer i| i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testReturnTypeCompatibility_09() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def void a() {" +
				"    val (Integer)=>Integer closure = [Integer i| return i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}

	@Test public void testReturnTypeCompatibility_10() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def a() {" +
				"    val closure = [Integer i| return i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testReturnTypeCompatibility_11() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def a() {" +
				"    val closure = [Integer i| i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testReturnTypeCompatibility_12() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def a() {" +
				"    val (Integer)=>Integer closure = [Integer i| return i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	@Test public void testReturnTypeCompatibility_13() throws Exception {
		XtendClass clazz = clazz(
				"class C {\n" + 
				"	def dispatch void minus(Object operand) {\n" + 
				"	}\n" + 
				"	def dispatch minus(Integer e) { return -e }\n" + 
				"	def dispatch minus(Double e) { -e }\n" + 
				"}");
		 helper.assertError(clazz, XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE, "Incompatible return type of dispatch method. Expected double but was void");
	}
	
	@Test public void testReturnTypeCompatibility_14() throws Exception {
		XtendClass clazz = clazz(
				"class C {\n" + 
				"	def dispatch minus(Object operand) {\n" + 
				"		return\n" + 
				"	}\n" + 
				"	def dispatch minus(Integer e) { return -e }\n" + 
				"	def dispatch minus(Double e) { -e }\n" + 
				"}");
		helper.assertError(clazz, XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE, "Incompatible return type of dispatch method. Expected double but was void");
	}
	
	@Test public void testReturnTypeCompatibility_15() throws Exception {
		XtendClass clazz = clazz(
				"class C {\n" + 
				"	def dispatch void minus(Object operand) {\n" + 
				"	}\n" + 
				"	def dispatch minus(Integer e) { -e }\n" + 
				"	def dispatch minus(Double e) { -e }\n" + 
				"}");
		helper.assertError(clazz, XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE, "Incompatible return type of dispatch method. Expected double but was void");
	}
	
	@Test public void testReturnTypeCompatibility_16() throws Exception {
		XtendClass clazz = clazz(
				"class C {\n" + 
				"	def dispatch minus(Object operand) {\n" + 
				"		return\n" + 
				"	}\n" + 
				"	def dispatch minus(Integer e) { -e }\n" + 
				"	def dispatch minus(Double e) { -e }\n" + 
				"}");
		helper.assertError(clazz, XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE, "Incompatible return type of dispatch method. Expected double but was void");
	}
	
	@Test public void testThrowsClauseCompatibility_00() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  def foo() {" +
				"    throw new Exception()" +
				"  }" +
				"}");
		helper.assertNoError(clazz, UNHANDLED_EXCEPTION);
//		helper.assertError(clazz, XBLOCK_EXPRESSION, UNHANDLED_EXCEPTION, "unhandled", "exception");
	}
	
	@Test public void testThrowsClauseCompatibility_01() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  def foo() {" +
				"    throw new RuntimeException()" +
				"  }" +
				"}");
		helper.assertNoError(clazz, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testThrowsClauseCompatibility_02() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  def foo() throws RuntimeException {" +
				"    throw new Exception()" +
				"  }" +
				"}");
		helper.assertNoError(clazz, UNHANDLED_EXCEPTION);
//		helper.assertError(clazz, XBLOCK_EXPRESSION, UNHANDLED_EXCEPTION, "unhandled", "exception");
	}
	
	@Test public void testThrowsClauseCompatibility_03() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  def foo() throws Exception {" +
				"    throw new NoSuchFieldException()" +
				"  }" +
				"}");
		helper.assertNoError(clazz, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testThrowsClauseCompatibility_04() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  def foo() {" +
				"    try {" +
				"      throw new NoSuchFieldException()" +
				"    } catch(NoSuchFieldException e) {" +
				"    }" +
				"  }" +
				"}");
		helper.assertNoError(clazz, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testAssignmentToFunctionParameter() throws Exception {
		XtendFunction function = function("def void foo(int bar) { bar = 7 }");
		helper.assertError(function, XASSIGNMENT, ASSIGNMENT_TO_FINAL, "Assignment", "final",
				"parameter");
	}

	@Test public void testClassExtendsInterface() throws Exception {
		XtendClass clazz = clazz("class Foo extends Cloneable {}");
		helper.assertError(clazz, XTEND_CLASS, CLASS_EXPECTED, "Superclass");
	}

	@Test public void testClassImplementsClass() throws Exception {
		XtendClass clazz = clazz("class Foo implements Object {}");
		helper.assertError(clazz, XTEND_CLASS, INTERFACE_EXPECTED, "Implemented", "interface");
	}
	
	@Test public void testClassExtendsItself() throws Exception {
		XtendClass clazz = clazz("class Foo extends Foo {}");
		helper.assertError(clazz, XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	@Test public void testClassUniqueNames() throws Exception {
		XtendClass clazz = clazz("class Foo {} class Foo {}");
		helper.assertError(clazz, XTEND_CLASS, DUPLICATE_TYPE_NAME, "type", "already defined");
	}
	
	@Test public void testInterfaceExtendsInterface() throws Exception {
		XtendInterface interfaze = interfaze("interface Foo extends Cloneable {}");
		helper.assertNoErrors(interfaze);
	}

	@Test public void testInterfaceExtendsClass() throws Exception {
		XtendInterface interfaze = interfaze("interface Foo extends Object {}");
		helper.assertError(interfaze, XTEND_INTERFACE, INTERFACE_EXPECTED, "Extended", "interface");
	}
	
	@Test public void testInterfaceExtendsItself() throws Exception {
		XtendInterface interfaze = interfaze("interface Foo extends Foo {}");
		helper.assertError(interfaze, XTEND_INTERFACE, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	@Test public void testTypesUniqueNames() throws Exception {
		XtendFile file = file("class Foo {} interface Foo {} annotation Foo {}");
		helper.assertError(file, XTEND_INTERFACE, DUPLICATE_TYPE_NAME, "type", "already defined");
		helper.assertError(file, XTEND_ANNOTATION_TYPE, DUPLICATE_TYPE_NAME, "type", "already defined");
	}
	
	@Test public void testNestedTypesUniqueNames() throws Exception {
		XtendFile file = file("class C { static class Foo {} interface Foo {} annotation Foo {} }");
		helper.assertError(file, XTEND_INTERFACE, DUPLICATE_TYPE_NAME, "Duplicate nested type Foo");
		helper.assertError(file, XTEND_ANNOTATION_TYPE, DUPLICATE_TYPE_NAME, "Duplicate nested type Foo");
	}
	
	@Test public void testNestedTypesOuterNameShadowing() throws Exception {
		XtendFile file = file("class C { class C {} }");
		helper.assertError(file, XTEND_CLASS, INVALID_MEMBER_NAME, "The nested type C cannot hide an enclosing type");
	}
	
	@Test public void testInheritanceCycle() throws Exception {
		Iterator<XtendTypeDeclaration> types = file("package test "
				+ "class Foo extends Bar {}"
				+ "class Bar extends Baz {}"
				+ "class Baz extends Foo {}").getXtendTypes().iterator();
		helper.assertError(types.next(), XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		helper.assertError(types.next(), XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		helper.assertError(types.next(), XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	@Test public void testInheritanceCycle_1() throws Exception {
		Iterator<XtendTypeDeclaration> types = file("package test "
				+ "class Foo extends Bar {}"
				+ "class Bar extends Foo {}").getXtendTypes().iterator();
		helper.assertError(types.next(), XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		helper.assertError(types.next(), XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	@Test public void testInheritanceCycle_2() throws Exception {
		Iterator<XtendTypeDeclaration> types =  file("package test "
				+ "interface Foo extends Bar {}"
				+ "interface Bar extends Foo {}").getXtendTypes().iterator();
		helper.assertError(types.next(), XTEND_INTERFACE, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		helper.assertError(types.next(), XTEND_INTERFACE, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	@Test public void testInheritanceCycle_3() throws Exception {
		Iterator<XtendTypeDeclaration> types = file("package test "
				 + "interface Foo extends Bar {}"
				 + "interface Bar extends Baz {}"
				 + "interface Baz extends Foo {}").getXtendTypes().iterator();
		helper.assertError(types.next(), XTEND_INTERFACE, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		helper.assertError(types.next(), XTEND_INTERFACE, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		helper.assertError(types.next(), XTEND_INTERFACE, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	@Test public void testInheritanceCycle_4() throws Exception {
		Iterator<XtendTypeDeclaration> types = file("package test "
				+ "class Foo implements Bar { interface I {} }"
				+ "interface Bar extends Foo.I {}").getXtendTypes().iterator();
		helper.assertError(types.next(), XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	@Test public void testInheritanceCycle_5() throws Exception {
		Iterator<XtendTypeDeclaration> types = file("package test "
				+ "class Foo extends Bar { static class Baz {} }"
				+ "class Bar extends Foo.Baz {}").getXtendTypes().iterator();
		helper.assertError(types.next(), XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}

	@Test public void testMultipleInheritance() throws Exception {
		XtendFile file = file("package test "
				+ "class Foo extends Bar {}"
				+ "class Bar extends Baz implements java.io.Serializable {}"
				+ "class Baz implements java.io.Serializable {}");
		helper.assertNoErrors(file);
	}

	@Test public void testDiamondInheritance() throws Exception {
		XtendFile file = file("package test "
				+ "interface Bottom extends Left, Top, Right {}"
				+ "interface Left extends Top {}"
				+ "interface Right extends Top {}"
				+ "interface Top{}");
		helper.assertNoErrors(file);
	}

	@Test public void testInvalidFieldName_00() throws Exception {
		XtendClass clazz = clazz("class Foo { int this }");
		helper.assertError(clazz.getMembers().get(0), XTEND_FIELD, INVALID_MEMBER_NAME, "'this'", "'it'", "names");
	}
	
	@Test public void testInvalidFieldName_01() throws Exception {
		XtendClass clazz = clazz("class Foo { int it }");
		helper.assertError(clazz.getMembers().get(0), XTEND_FIELD, INVALID_MEMBER_NAME, "'this'", "'it'", "names");
	}
	
	@Test public void testInvalidMethodName_00() throws Exception {
		XtendClass clazz = clazz("class Foo { def void this() {} }");
		helper.assertError(clazz.getMembers().get(0), XTEND_FUNCTION, INVALID_MEMBER_NAME, "'this'", "'it'", "names");
	}
	
	@Test public void testInvalidMethodName_01() throws Exception {
		XtendClass clazz = clazz("class Foo { def void it() {} }");
		helper.assertError(clazz.getMembers().get(0), XTEND_FUNCTION, INVALID_MEMBER_NAME, "'this'", "'it'", "names");
	}
	
	@Test public void testDuplicateFieldName() throws Exception {
		XtendClass clazz = clazz("class Foo { int foo String foo double foo }");
		for(XtendMember member: clazz.getMembers())
			helper.assertError(member, XTEND_FIELD, DUPLICATE_FIELD, "foo", "duplicate");
	}
	
	@Test public void testDuplicateAnonymousExtension() throws Exception {
		XtendClass clazz = clazz("import com.google.inject.Inject class Foo { @Inject extension String @Inject extension String }");
		for(XtendMember member: clazz.getMembers())
			helper.assertError(member, XTEND_FIELD, DUPLICATE_FIELD, "duplicate", "same", "type");
	}
	
	@Test public void testCaseFunctionNoParameters() throws Exception {
		XtendFunction function = function("def dispatch foo() { null }");
		helper.assertError(function, XTEND_FUNCTION, DISPATCH_FUNC_WITHOUT_PARAMS);
	}

	@Test public void testCaseFunctionWithTypeParams() throws Exception {
		XtendFunction function = function("def dispatch <T> foo(T s) { null }");
		helper.assertError(function, XTEND_FUNCTION, DISPATCH_FUNC_WITH_TYPE_PARAMS);
	}

	@Test public void testSingleCaseFunction() throws Exception {
		XtendFunction function = function("def dispatch foo(String s) { null }");
		helper.assertWarning(function, XTEND_FUNCTION, SINGLE_DISPATCH_FUNCTION);
	}

	@Test public void testSamePrimitiveArg() throws Exception {
		XtendClass clazz = clazz("class Foo { def dispatch foo(int x) { null } def dispatch foo(float x) { null } }");
		helper.assertWarning(clazz, XTEND_FUNCTION, DISPATCH_FUNCTIONS_DIFFERENT_PRIMITIVE_ARGS);
	}

	@Test public void testDuplicateCaseFunction() throws Exception {
		XtendFunction function = function("def dispatch foo(Integer s) { null } def dispatch foo(int s) { null }");
		helper.assertError(function, XTEND_FUNCTION, DUPLICATE_METHOD, "dispatch");
	}

	@Test public void testInaccessibleMethod() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { def foo() { privateMethod() }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(0), XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "The method privateMethod",
				"not", "visible");
	}
	
	@Test public void testInaccessibleStaticMethod() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { def foo() { privateStaticMethod() }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(0), XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "The method privateStaticMethod",
				"not", "visible");
	}

	@Test
	public void testInaccessibleMethod2() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def foo() { val o = new Object() o.clone() }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(1), XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "The method clone",
				"not", "visible");
	}
	
	@Test
	public void testInaccessibleMethod3() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def foo() { val o = new Object() clone() }}");
		helper.assertNoErrors(xtendClass);
	}
	
	@Test
	public void testInaccessibleMethod4() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def foo() { val o = new Object() this.clone super.clone }}");
		helper.assertNoErrors(xtendClass);
	}
	
	@Test
	public void testInaccessibleMethod5() throws Exception {
		XtendClass xtendClass = clazz("package java.lang class Foo { def foo() { val o = new Object() o.clone }}");
		helper.assertNoErrors(xtendClass);
	}
	
	@Test
	public void testInaccessibleMethod6() throws Exception {
		XtendClass xtendClass = clazz("class C { def m() { ''.clone }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(0), XMEMBER_FEATURE_CALL, FEATURE_NOT_VISIBLE, "The method clone",
				"not", "visible");
	}
	
	@Test
	public void testInaccessibleMethod7() throws Exception {
		XtendClass xtendClass = clazz("class C { def m(String s) { s.clone }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(0), XMEMBER_FEATURE_CALL, FEATURE_NOT_VISIBLE, "The method clone",
				"not", "visible");
	}
	
	@Test
	public void testInaccessibleMethod8() throws Exception {
		XtendClass xtendClass = clazz("package java.lang class C { def m(String s) { s.clone }}");
		helper.assertNoErrors(xtendClass);
	}
	
	@Test
	public void testInaccessibleMethod9() throws Exception {
		XtendClass xtendClass = clazz("package java.lang class C { def m() { ''.clone }}");
		helper.assertNoErrors(xtendClass);
	}
	
	@Test
	public void testInaccessibleMethod10() throws Exception {
		XtendClass xtendClass = clazz("class C { def m() { String.clone }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(0), XMEMBER_FEATURE_CALL, FEATURE_NOT_VISIBLE, "The method clone",
				"not", "visible");
	}
	
	@Test
	public void testInaccessibleMethod11() throws Exception {
		XtendClass xtendClass = clazz("package java.lang class C { def m() { String.clone }}");
		helper.assertNoErrors(xtendClass);
	}
	
	@Test
	public void testInaccessibleMethod12() throws Exception {
		XtendClass xtendClass = clazz("package java.lang class C { def m() { ('' as Object).clone }}");
		helper.assertNoErrors(xtendClass);
	}
	
	@Test
	public void testInaccessibleMethod13() throws Exception {
		XtendClass xtendClass = clazz("package x class C { def m(D d) { d.clone }} class D extends C {}");
		helper.assertNoErrors(xtendClass);
	}

	@Test
	public void testInaccessibleMethod14() throws Exception {
		XtendClass xtendClass = clazz("class Foo { private var int x def foo() { val o = new Foo { } o.x = 2 }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(1)).getExpression())
				.getExpressions().get(1), XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "private", " x ");
	}

	@Test
	public void testInaccessibleMethod15() throws Exception {
		XtendClass xtendClass = clazz("class Foo { private def void bar() {} def foo() { val o = new Foo { } o.bar }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(1)).getExpression())
				.getExpressions().get(1), XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "private", "bar()");
	}

	@Test public void testDuplicateParameter() throws Exception {
		XtendFunction function = function("def foo(int x, int x) {null}");
		helper.assertError(function, XTEND_FUNCTION, DUPLICATE_PARAMETER_NAME, "duplicate", "x");
	}
	
	@Test public void testDuplicateConstructorParameter() throws Exception {
		XtendConstructor constructor = constructor("new(int x, int x) {null}");
		helper.assertError(constructor, XTEND_CONSTRUCTOR, DUPLICATE_PARAMETER_NAME, "duplicate", "x");
	}
	
	@Test public void testDuplicateParameter_CreateExtension_01() throws Exception {
		XtendFunction function = function("def create newArrayList foo(int it) {}");
		helper.assertError(function, CREATE_EXTENSION_INFO, DUPLICATE_PARAMETER_NAME, "duplicate", "implicit", "it");
		helper.assertError(function, XTEND_FUNCTION, DUPLICATE_PARAMETER_NAME, "duplicate", "it");
	}
	
	@Test public void testDuplicateParameter_CreateExtension_02() throws Exception {
		XtendFunction function = function("def create result: newArrayList foo(int result) {}");
		helper.assertError(function, CREATE_EXTENSION_INFO, DUPLICATE_PARAMETER_NAME, "duplicate", "result");
		helper.assertError(function, XTEND_FUNCTION, DUPLICATE_PARAMETER_NAME, "duplicate", "result");
	}
	
	@Test public void testRichStringIfPredicate() throws Exception {
		assertNoConformanceError("'''«IF Boolean::FALSE»«ENDIF»'''");
		assertNoConformanceError("'''«IF true»«ENDIF»'''");
		assertNoConformanceError("'''«IF 1 == 1»«ENDIF»'''");
		assertConformanceError("'''«IF 1»«ENDIF»'''", XNUMBER_LITERAL, "int", "boolean", "Boolean");
	}
	
	@Test public void testRichStringForLoop() throws Exception {
		assertNoConformanceError("'''«FOR i: 1..10»«ENDFOR»'''");
		assertNoConformanceError("'''«FOR i: #[1..10]»«ENDFOR»'''");
		assertNoConformanceError("'''«FOR i: #{1..10}»«ENDFOR»'''");
		assertNoConformanceError("'''«FOR IntegerRange i: #[1..10]»«ENDFOR»'''");
		assertNoConformanceError("'''«FOR IntegerRange  i: #{1..10}»«ENDFOR»'''");
		assertNoConformanceError("'''«FOR i: 1..10 BEFORE 'a' SEPARATOR 1 AFTER true»«ENDFOR»'''");
		assertConformanceError("'''«FOR int i: #[1..10]»«ENDFOR»'''", XbasePackage.Literals.XBINARY_OPERATION, "Type mismatch: cannot convert from IntegerRange to int");
		assertConformanceError(
				"'''«FOR i: 1..10 BEFORE while(true) null SEPARATOR 'b' AFTER 'c'»«ENDFOR»'''", 
				XWHILE_EXPRESSION, "Type mismatch: type void is not applicable at this location");
		assertConformanceError(
				"'''«FOR i: 1..10 BEFORE 'a' SEPARATOR while(true) null AFTER 'c'»«ENDFOR»'''", 
				XWHILE_EXPRESSION, "Type mismatch: type void is not applicable at this location");
		assertConformanceError(
				"'''«FOR i: 1..10 BEFORE 'a' SEPARATOR null AFTER while(true) null»«ENDFOR»'''", 
				XWHILE_EXPRESSION, "Type mismatch: type void is not applicable at this location");
	}
	
	@Test public void testBug343089_01() throws Exception {
		XtendFunction function = function(
				"def <T extends Integer> noCastRequired() {\n" + 
				 "  [T a,T b|a+b]\n" + 
				 "}");
		helper.assertNoErrors(function);
	}
	
	@Test public void testBug343088_01() throws Exception {
		XtendFunction function = function(
				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
				"    [T a,T b|a+(b as Integer)]\n" + 
				"}");
		helper.assertError(function, XCLOSURE, INCOMPATIBLE_TYPES, "cannot convert from (T, T)=>int to (T, T)=>T");
	}
	
	@Test public void testBug343088_02() throws Exception {
		XtendFunction function = function(
				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
				"    [T a,T b|a+b]\n" + 
				"}");
		helper.assertError(function, XCLOSURE, INCOMPATIBLE_TYPES, "cannot convert from (T, T)=>int to (T, T)=>T");
	}
	
	@Test public void testBug343088_03() throws Exception {
		XtendFunction function = function(
				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
				"    [T a,T b|(a+b) as T]\n" + 
				"}");
		helper.assertNoErrors(function);
	}
	
	@Test public void testDispatchFunctionVisibility() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def dispatch foo(String bar) {} def public dispatch foo(Object bar) {}}");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, DISPATCH_FUNCTIONS_WITH_DIFFERENT_VISIBILITY, 
				"local", "must", "same", "visibility");
	}
	
	@Test public void testDispatchFunctionStatic1() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def dispatch foo(String bar) {} def static dispatch foo(Object bar) {}}");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, DISPATCH_FUNCTIONS_MIXED_STATIC_AND_NON_STATIC, 
				"Static", "non-static", "not", "mixed");
	}
	
	@Test public void testDispatchFunctionStatic2() throws Exception {
		Iterator<XtendFile> iter = files(false, 
				 "package test class Bar extends XXX { def dispatch foo(Boolean bar) {} def static dispatch foo(Double bar) {} }"
				,"package test class XXX { def static dispatch foo(String bar) {} def static dispatch foo(Float bar) {}}").iterator();
		helper.assertError(iter.next(), XTEND_FUNCTION, DISPATCH_FUNCTIONS_STATIC_EXPECTED, "must", "be", "static");
	}
	
	@Test public void testDispatchFunctionStatic3() throws Exception {
		Iterator<XtendFile> iter = files(false, 
				"package test class Bar extends XXX { def dispatch foo(Boolean bar) {} def static dispatch foo(Double bar) {} }"
				,"package test class XXX { def dispatch foo(String bar) {} def dispatch foo(Float bar) {}}").iterator();
		helper.assertError(iter.next(), XTEND_FUNCTION, DISPATCH_FUNCTIONS_NON_STATIC_EXPECTED, "must", "not", "be", "static");
	}
	
	@Test 
	public void testBug343096() throws Exception {
		XtendFunction function = function(
				"def <T> test() {\n" + 
				"  [T t|switch t {\n" + 
				"    case t:test\n" + 
				"  }]\n" + 
				"}");
		helper.assertNoErrors(function);
		helper.assertWarning(function, XTEND_FUNCTION, TOO_LITTLE_TYPE_INFORMATION, "recursive", "'Object'");
	}

	protected void assertConformanceError(String body, EClass objectType, String... messageParts)
			throws Exception {
		final XtendFunction function = function("def foo() " + body);
		helper.assertError(function, objectType, INCOMPATIBLE_TYPES, messageParts);
	}

	protected void assertNoConformanceError(String body) throws Exception {
		final XtendFunction function = function("def foo() " + body);
		helper.assertNoError(function, INCOMPATIBLE_TYPES);
	}
	
	@Test public void testImportUnused() throws Exception {
		XtendClass clazz = clazz("import java.util.List class X {}");
		helper.assertWarning(clazz.eContainer(), XIMPORT_DECLARATION, IMPORT_UNUSED);
	}
	
	@Test public void testImportUnused_1() throws Exception {
		XtendClass clazz = clazz("import java.util.List class X { private java.util.List sb }");
		helper.assertWarning(clazz.eContainer(), XIMPORT_DECLARATION, IMPORT_UNUSED);
	}
	
	@Test public void testImportUnused_2() throws Exception {
		XtendClass clazz = clazz("import java.util.List class X { private List sb def foo(){sb}}");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}
	
	@Test public void testImportUnused_3() throws Exception {
		XtendClass clazz = clazz("import java.util.Map$Entry class X { private Entry sb def foo(){sb}}");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}
	
	@Test public void testImportUnused_4() throws Exception {
		XtendClass clazz = clazz("import java.util.Map class X { private Map$Entry sb def foo(){sb}}");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}
	
	@Test public void testImportUnused_5() throws Exception {
		XtendClass clazz = clazz("import java.util.Map$Entry class X { private Map$Entry sb def foo(){sb}}");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}
	
	@Test public void testImportUnused_6() throws Exception {
		XtendClass clazz = clazz("import java.awt.Label /** {@link Label} */ class X{} ");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}

	@Test public void testImportUnused_7() throws Exception {
		XtendClass clazz = clazz("import java.awt.Label /** @see Label */ class X{} ");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	@Test public void testImportUnused_8() throws Exception {
		XtendClass clazz = clazz("import java.util.Map.Entry class X { private Entry sb def foo(){sb}}");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}
	
	@Test public void testImportUnused_9() throws Exception {
		XtendClass clazz = clazz("import java.util.Map class X { private Map.Entry sb def foo(){sb}}");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}
	
	@Test public void testImportUnused_10() throws Exception {
		XtendClass clazz = clazz("import org.eclipse.xtext.xbase.XbasePackage class X { var x = XbasePackage::Literals::XEXPRESSION }");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}
	
	@Test public void testImportUnused_11() throws Exception {
		XtendClass clazz = clazz("import org.eclipse.xtext.xbase.XbasePackage class X { var x = XbasePackage$Literals::XEXPRESSION }");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}
	
	@Test public void testImportUnused_12() throws Exception {
		XtendClass clazz = clazz("import java.util.ArrayList class X { public val list = new ArrayList<String> {} }");
		helper.assertNoIssues(clazz.eContainer());
	}

	@Test public void testStaticImportUnused_0() throws Exception {
		XtendClass clazz = clazz("import static java.util.Collections.* class X {}");
		helper.assertWarning(clazz.eContainer(), XIMPORT_DECLARATION, IMPORT_UNUSED);
	}

	@Test public void testStaticImportUnused_1() throws Exception {
		XtendClass clazz = clazz("import static java.util.Collections.* class X { var x = singleton('') }");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}
	
	@Test public void testStaticExtensionImportUnused_0() throws Exception {
		XtendClass clazz = clazz("import static extension java.util.Collections.* class X {}");
		helper.assertWarning(clazz.eContainer(), XIMPORT_DECLARATION, IMPORT_UNUSED);
	}

	@Test public void testStaticExtensionImportUnused_1() throws Exception {
		XtendClass clazz = clazz("import static extension java.util.Collections.* class X { var x = ''.singleton }");
		helper.assertNoIssues(clazz.eContainer(), XIMPORT_DECLARATION);
	}

	@Test public void testStaticExtensionImportUnused_2() throws Exception {
		XtendClass clazz = clazz("import static extension java.util.Collections.* class X extends java.util.Collections { var x = ''.singleton }");
		helper.assertWarning(clazz.eContainer(), XIMPORT_DECLARATION, IMPORT_UNUSED);
	}

	@Test public void testStaticAndStaticExtensionImport_0() throws Exception {
		XtendFile file = file("import static java.util.Collections.* import static extension java.util.Collections.* class X { var x = ''.singleton var y = singleton('') }");
		helper.assertWarning(file.getImportSection().getImportDeclarations().get(0), XIMPORT_DECLARATION, IMPORT_UNUSED);
	}

	@Test public void testStaticAndStaticExtensionImport_1() throws Exception {
		XtendFile file = file("import static extension java.util.Collections.* import static java.util.Collections.* class X { var x = ''.singleton var y = singleton('') }");
		helper.assertWarning(file.getImportSection().getImportDeclarations().get(1), XIMPORT_DECLARATION, IMPORT_UNUSED);
	}

	@Test public void testImportDuplicate() throws Exception {
		XtendClass clazz = clazz("import java.util.List import java.util.List class X { private List sb def foo(){sb}}");
		helper.assertWarning(clazz.eContainer(), XIMPORT_DECLARATION, IMPORT_UNUSED);
	}
	
	@Test public void testImportCollision() throws Exception {
		XtendClass clazz = clazz("import java.util.List import java.awt.List class X { private List sb def foo(){sb}}");
		helper.assertError(clazz.eContainer(), XIMPORT_DECLARATION, IMPORT_COLLISION);
	}
	
	@Test public void testImportWildcard() throws Exception {
		XtendClass clazz = clazz("import java.util.* import java.util.List class X { private List sb def foo(){sb}}");
		helper.assertWarning(clazz.eContainer(), XIMPORT_DECLARATION, IMPORT_WILDCARD_DEPRECATED);
	}
	
	@Test public void testImportConflictWithTypeInSameFile() throws Exception {
		XtendClass clazz = clazz("import java.util.List class List {}");
		helper.assertError(clazz.eContainer(), XIMPORT_DECLARATION, IMPORT_CONFLICT);
	}
	
	@Test public void testImportNoConflictWithTypeInSameFile() throws Exception {
		XtendClass clazz = clazz("import java.util.List class List2 {}");
		helper.assertNoErrors(clazz.eContainer());
	}
	
	@Test public void testPrivateUnusedField() throws Exception {
		XtendClass clazz = clazz("import java.util.List class X { private List sb }");
		helper.assertWarning(clazz.eContainer(), XTEND_FIELD,UNUSED_PRIVATE_MEMBER , "not");
	}
	
	@Test public void testUnusedField() throws Exception {
		XtendClass clazz = clazz("import java.util.List class X { protected List foo public List bar}");
		helper.assertNoIssues(clazz.eContainer(), XTEND_FIELD);
	}
	
	@Test public void testSerialVersionUIDNotUnused() throws Exception {
		XtendClass clazz = clazz("import java.io.Serializable class X implements Serializable { static final long serialVersionUID = 1L }");
		helper.assertNoIssues(clazz.eContainer(), XTEND_FIELD);
		// in the following cases not all conditions are met, therefore it is still marked unused
		// it must be static
		clazz = clazz("import java.io.Serializable class X implements Serializable { final long serialVersionUID = 1L }");
		helper.assertWarning(clazz.eContainer(), XTEND_FIELD,UNUSED_PRIVATE_MEMBER , "serialVersionUID", "not used");
		// it must be final
		clazz = clazz("import java.io.Serializable class X implements Serializable { static long serialVersionUID = 1L }");
		helper.assertWarning(clazz.eContainer(), XTEND_FIELD,UNUSED_PRIVATE_MEMBER , "serialVersionUID", "not used");
		// it must be long
		clazz = clazz("import java.io.Serializable class X implements Serializable { static final int serialVersionUID = 1 }");
		helper.assertWarning(clazz.eContainer(), XTEND_FIELD,UNUSED_PRIVATE_MEMBER , "serialVersionUID", "not used");
		// the declaring type must implement java.io.Serializable
		clazz = clazz("class X { static final long serialVersionUID = 1L }");
		helper.assertWarning(clazz.eContainer(), XTEND_FIELD,UNUSED_PRIVATE_MEMBER , "serialVersionUID", "not used");
		// it must have an initial value
		clazz = clazz("import java.io.Serializable class X implements Serializable { static final long serialVersionUID }");
		helper.assertWarning(clazz.eContainer(), XTEND_FIELD,UNUSED_PRIVATE_MEMBER , "serialVersionUID", "not used");
		// it must be correctly spelled
		clazz = clazz("import java.io.Serializable class X implements Serializable { static final long serialVersionUid = 1L }");
		helper.assertWarning(clazz.eContainer(), XTEND_FIELD,UNUSED_PRIVATE_MEMBER , "serialVersionUid", "not used");
	}
	
	@Test public void testUnusedFieldWithPropertyAnnotation() throws Exception {
		XtendClass clazz = clazz("class X { @Property String foo }");
		helper.assertNoIssues(clazz.eContainer(), XTEND_FIELD);
	}
	
	@Test public void testUnusedExtensionField() throws Exception {
		XtendClass clazz = clazz("import com.google.inject.Inject class X { @Inject extension String }");
		helper.assertWarning(clazz.eContainer(), XTEND_FIELD, UNUSED_PRIVATE_MEMBER , "extension", "String", "not", "used", "in", "X");
	}
	
	@Test public void testUnusedExtensionField_1() throws Exception {
		XtendClass clazz = clazz("import com.google.inject.Inject class X { @Inject extension String x }");
		helper.assertWarning(clazz.eContainer(), XTEND_FIELD, UNUSED_PRIVATE_MEMBER , "extension", "X.x", "not", "used");
	}
	
	@Test public void testUnusedFunction() throws Exception {
		XtendClass clazz = clazz("class X { def private foo(String a, Integer b) }");
		helper.assertWarning(clazz, XTEND_FUNCTION, UNUSED_PRIVATE_MEMBER, "method","foo(String, Integer)","never", "used");
	}
	
	@Test public void testUnusedFunction_1() throws Exception {
		XtendClass clazz = clazz("class X { def private void foo(String a, Integer b) {foo(a,b)} }");
		helper.assertWarning(clazz, XTEND_FUNCTION, UNUSED_PRIVATE_MEMBER, "method","foo(String, Integer)","never", "used");
	}
	
	@Test public void testSyntheticallyUsedFunction() throws Exception {
		XtendClass clazz = clazz("class X { def private String foo() {} def bar(){}}");
		JvmDeclaredType jvmType = (JvmDeclaredType) clazz.eResource().getContents().get(1);
		EObject eObject = jvmType.getMembers().get(1);
		readAndWriteTracking.markReadAccess(eObject);
		helper.assertNoIssues(clazz.eContainer());
	}
	
	@Test public void testSyntheticallyUsedField() throws Exception {
		XtendClass clazz = clazz("class X { String foo }");
		JvmDeclaredType jvmType = (JvmDeclaredType) clazz.eResource().getContents().get(1);
		EObject eObject = jvmType.getMembers().get(1);
		readAndWriteTracking.markReadAccess(eObject);
		helper.assertNoIssues(clazz.eContainer());
	}
	
	@Test public void testSyntheticallyInitializedField() throws Exception {
		XtendClass clazz = clazz("class X { new() {} final String foo }");
		JvmDeclaredType jvmType = (JvmDeclaredType) clazz.eResource().getContents().get(1);
		JvmConstructor constructor = (JvmConstructor) jvmType.getMembers().get(0);
		EObject field = jvmType.getMembers().get(1);
		readAndWriteTracking.markReadAccess(field);
		readAndWriteTracking.markInitialized(field, constructor);
		helper.assertNoIssues(clazz.eContainer());
	}
	
	@Test public void testUsedFunction() throws Exception {
		XtendClass clazz = clazz("abstract class X { def protected String foo() def bar(){foo}}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	@Test public void testUnusedDispatchFunction() throws Exception {
		XtendClass clazz = clazz("class X { def private dispatch foo(String a) def private dispatch foo(NullPointerException a) }");
		helper.assertWarning(clazz, XTEND_FUNCTION, UNUSED_PRIVATE_MEMBER, "method", "foo(Serializable","never", "used");
	}
	
	@Test public void testUsedDispatchFunction() throws Exception {
		XtendClass clazz = clazz("class X { def private dispatch foo(String a) {} def private dispatch foo(Integer a) {} def bar(){foo(42)}}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	@Test public void testAbstractDispatchFunction() throws Exception {
		XtendClass clazz = clazz("class X { def dispatch String foo(String a) def dispatch String foo(Integer a) {return null} }");
		helper.assertError(clazz, XTEND_FUNCTION, DISPATCH_FUNCTIONS_MUST_NOT_BE_ABSTRACT, "abstract");
	}
	
	@Test public void testUsedMemberOfExtensionField() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection def foo(){ add('42') }}");
		helper.assertNoIssues(clazz.eContainer(), XTEND_FIELD);
	}
	
	@Test public void testUnusedMemberOfExtensionField() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection def foo(){  }}");
		helper.assertWarning(clazz, XTEND_FIELD, UNUSED_PRIVATE_MEMBER , "not");
	}
	
	@Test public void testUsedMemberOfExtensionFieldWithName() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection bar def foo(){ add('42') }}");
		helper.assertNoIssues(clazz.eContainer(), XTEND_FIELD);
	}
	
	@Test public void testUsedMemberOfExtensionFieldWithName_2() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection bar def foo(){ bar.add('42') }}");
		helper.assertNoIssues(clazz.eContainer(), XTEND_FIELD);
	}
	
	@Test public void testUsedMemberOfLocalExtensionWithName_01() throws Exception {
		XtendClass clazz = clazz("class X { def foo(){ extension val java.util.Collection bar = null add('42') }}");
		helper.assertNoIssues(clazz.eContainer(), XTEND_VARIABLE_DECLARATION);
	}
	
	@Test public void testUsedMemberOfLocalExtensionWithName_02() throws Exception {
		XtendClass clazz = clazz("class X { def foo(){ extension val java.util.Collection bar = null bar.add('42') }}");
		helper.assertNoIssues(clazz.eContainer(), XTEND_VARIABLE_DECLARATION);
	}
	
	@Test public void testUnusedMemberOfExtensionFieldWithName() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection bar def foo(){  }}");
		helper.assertWarning(clazz, XTEND_FIELD, UNUSED_PRIVATE_MEMBER , "not");
	}
	
	@Test public void testUnusedMemberOfExtensionField_No_False_Positive() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection foo def bar(){  newArrayList.add('42') }}");
		helper.assertWarning(clazz, XTEND_FIELD,UNUSED_PRIVATE_MEMBER , "not");
	}
	
	@Test public void testConstructorThrownExceptionsOfTypeThrowable() throws Exception {
		XtendClass clazz = clazz("class X { new () throws Integer { }}");
		helper.assertError(clazz, XTEND_CONSTRUCTOR, EXCEPTION_NOT_THROWABLE, "No", "can", "subclass", "Throwable");
	}
	
	@Test public void testFunctionThrownExceptionsOfTypeThrowable() throws Exception {
		XtendClass clazz = clazz("class X { def foo() throws Integer { } }");
		helper.assertError(clazz, XTEND_FUNCTION, EXCEPTION_NOT_THROWABLE, "No", "can", "subclass", "Throwable");
	}
	
	@Test public void testExceptionsDeclaredTwiceOnConstructor() throws Exception {
		XtendClass clazz = clazz("import java.io.IOException class X { new () throws IOException, IOException { }}");
		helper.assertError(clazz, XTEND_CONSTRUCTOR, EXCEPTION_DECLARED_TWICE, "Exception", "declared", "twice");
	}
	
	@Test public void testExceptionsNotDeclaredTwiceOnConstructor() throws Exception {
		XtendClass clazz = clazz("import java.io.IOException class X { new () throws IOException, NullPointerException { }}");
		helper.assertNoIssues(clazz);
	}
	
	@Test public void testExceptionsDeclaredTwiceOnFunction() throws Exception {
		XtendClass clazz = clazz("import java.io.IOException class X {def foo() throws IOException, IOException { }}");
		helper.assertError(clazz, XTEND_FUNCTION, EXCEPTION_DECLARED_TWICE, "Exception", "declared", "twice");
	}
	
	@Test public void testExceptionsNotDeclaredTwiceOnFunction() throws Exception {
		XtendClass clazz = clazz("import java.io.IOException class X {def foo() throws IOException, NullPointerException { }}");
		helper.assertNoIssues(clazz);
	}
	
	@Test public void testExceptionInMethodIgnored() throws Exception {
		XtendFile file = file("class foo { def bar() { throw new Exception() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testNoAssignmentsToThisConstructor() throws Exception {
        XtendClass clazz = clazz("class X { new (String y) { this = new X('bar') val x = 2 x = 1}}");
        helper.assertError(clazz, XASSIGNMENT, LEFT_HAND_SIDE_MUST_BE_VARIABLE, "Left-hand side", "must be", "variable");
    }
		    
    @Test public void testNoAssignmentsToThisFunction() throws Exception {
        XtendClass clazz = clazz("class X { def foo(){ this = new X() val x = 1 x = 2}}");
        helper.assertError(clazz, XASSIGNMENT, LEFT_HAND_SIDE_MUST_BE_VARIABLE, "Left-hand side", "must be", "variable");
    }
    
    @Test public void testDispatchNonDispatchClash() throws Exception {
    	XtendClass clazz = clazz("class Foo { def dispatch foo(Object x) {} def foo(int x) {} }");
    	helper.assertWarning(clazz.getMembers().get(0), XTEND_FUNCTION, DISPATCH_PLAIN_FUNCTION_NAME_CLASH, "dispatch", "same", "name", "parameters");
    	helper.assertWarning(clazz.getMembers().get(1), XTEND_FUNCTION, DISPATCH_PLAIN_FUNCTION_NAME_CLASH, "dispatch", "same", "name", "parameters");
    }
    
    @Test public void testInheritedDispatch_01() throws Exception {
    	XtendClass clazz = clazz(
    			"class D extends C {\n" + 
    			"  def dispatch m(Integer o) { 1 }\n" + 
    			"  def dispatch m(String o) { 1 }\n" + 
    			"}\n" + 
    			"class C {\n" + 
    			"  def dispatch m(Number o) { 1 }\n" + 
    			"}");
    	helper.assertError(clazz, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, DISPATCH_FUNCTIONS_INVALID_PARAMETER_TYPE, "dispatch", "widen", "Number");
    }
    
    @Test public void testInheritedDispatch_02() throws Exception {
    	XtendClass clazz = clazz(
    			"class D extends C {\n" + 
				"  def dispatch m(Integer o) { 1 }\n" + 
				"  def dispatch m(Double o) { '' }\n" + 
				"}\n" + 
				"class C {\n" + 
				"  def dispatch m(Number o) { 1 }\n" + 
    			"}");
    	helper.assertError(clazz, XSTRING_LITERAL, INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from String to int");
    }
    
    @Test public void testKeywordConflict() throws Exception {
    	XtendClass clazz = clazz("class assert { def dispatch assert(Object x) {} }");
    	helper.assertError(clazz, XTEND_CLASS, INVALID_IDENTIFIER, "assert");
    	helper.assertError(clazz.getMembers().get(0), XTEND_FUNCTION, INVALID_IDENTIFIER, "assert");
    }
    
    @Test public void testKeywordConflict_02() throws Exception {
    	XtendClass clazz = clazz("class Foo<assert> { def <assert> bar(Object x) {} }");
    	helper.assertError(clazz, TypesPackage.Literals.JVM_TYPE_PARAMETER, INVALID_IDENTIFIER, "assert");
    	helper.assertError(clazz.getMembers().get(0), TypesPackage.Literals.JVM_TYPE_PARAMETER, INVALID_IDENTIFIER, "assert");
    }
    
    @Test public void testKeywordConflict_03() throws Exception {
    	XtendClass clazz = clazz("class ^null { public int ^true public int ^false }");
    	helper.assertError(clazz, XTEND_CLASS, INVALID_IDENTIFIER, "null");
    	helper.assertError(clazz.getMembers().get(0), XTEND_FIELD, INVALID_IDENTIFIER, "true");
    	helper.assertError(clazz.getMembers().get(1), XTEND_FIELD, INVALID_IDENTIFIER, "false");
    }
    
    @Test public void testKeywordConflict_04() throws Exception {
    	XtendFile file = file("interface assert {} enum ^volatile {} annotation ^null {}");
    	helper.assertError(file, XTEND_INTERFACE, INVALID_IDENTIFIER, "assert");
    	helper.assertError(file, XTEND_ENUM, INVALID_IDENTIFIER, "volatile");
    	helper.assertError(file, XTEND_ANNOTATION_TYPE, INVALID_IDENTIFIER, "null");
    }
    
    @Test public void testAbstractMethodsInNonAbstractClass() throws Exception {
    	XtendClass clazz = clazz("class Foo { def String test() }");
    	helper.assertError(clazz.getMembers().get(0), XTEND_FUNCTION, MISSING_ABSTRACT);
    }
    
    @Test public void testAbstractMethodsInAnonymousClass() throws Exception {
    	XtendClass clazz = clazz("class Foo { val f = new Object() { def String test() } }");
    	helper.assertNoErrors(clazz.getMembers().get(0), XTEND_FUNCTION, MISSING_ABSTRACT);
    	helper.assertError(clazz.getMembers().get(0), XTEND_FUNCTION, MISSING_ABSTRACT_IN_ANONYMOUS);
    }
    
    @Test public void testAbstractMethodWithoutReturnType() throws Exception {
    	XtendClass clazz = clazz("abstract class Foo { def test() }");
    	helper.assertError(clazz.getMembers().get(0), XTEND_FUNCTION, ABSTRACT_METHOD_MISSING_RETURN_TYPE);
    }
    
    @Test public void testAbstractMethodWithoutReturnType_1() throws Exception {
    	XtendInterface clazz = interfaze("interface Foo { def test() }");
    	helper.assertError(clazz.getMembers().get(0), XTEND_FUNCTION, ABSTRACT_METHOD_MISSING_RETURN_TYPE);
    }
    
    @Test public void testNonAbstractMethodInInterface() throws Exception {
    	XtendInterface clazz = interfaze("interface Foo { def test() {} }");
    	helper.assertError(clazz.getMembers().get(0), XTEND_FUNCTION, ABSTRACT_METHOD_WITH_BODY);
    }
    
    @Test public void testAbstractMethodWithReturnType() throws Exception {
    	XtendClass clazz = clazz("abstract class Foo { def String test() }");
    	helper.assertNoErrors(clazz);
    }
    
    @Test public void testFinalFieldInit_01() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test }");
    	helper.assertError(clazz.getMembers().get(0), XTEND_FIELD, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_02() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { test = 'foo'}}");
    	helper.assertNoErrors(clazz);
    }
    
    @Test public void testFinalFieldInit_03() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test = 'foo' }");
    	helper.assertNoErrors(clazz);
    }
    
    @Test public void testFinalFieldInit_04() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test = 'bar' new() { test = 'foo' }}");
    	helper.assertError(clazz.getMembers().get(0), XASSIGNMENT, FIELD_ALREADY_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_05() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { test = 'foo' test = 'foo' }}");
    	helper.assertError(clazz.getMembers().get(0), XASSIGNMENT, FIELD_ALREADY_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_06() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { for (x : newArrayList('x')) test = 'foo' }}");
    	helper.assertError(clazz.getMembers().get(0), XASSIGNMENT, FIELD_ALREADY_INITIALIZED);
    	helper.assertError(clazz.getMembers().get(1), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_07() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { if ('foo' == 'bar') test = 'foo' }}");
    	helper.assertError(clazz.getMembers().get(1), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_08() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { switch 'foo' { case 'bar' : test = 'foo' }}}");
    	helper.assertError(clazz.getMembers().get(1), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_09() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { switch 'foo' { case 'bar' : test = 'foo' default : test = 'holla' }}}");
    	helper.assertNoErrors(clazz);
    }
    
    @Test public void testFinalFieldInit_10() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { while ('x'=='bar') test = 'foo' }}");
    	helper.assertError(clazz.getMembers().get(0), XASSIGNMENT, FIELD_ALREADY_INITIALIZED);
    	helper.assertError(clazz.getMembers().get(1), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_11() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { for (x : {test = 'foo' test.toCharArray}) println(x) }}");
    	helper.assertNoErrors(clazz);
    }
    
    @Test public void testFinalFieldInit_12() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { while ({test = 'foo' test.length > 3}) println(x) }}");
    	helper.assertError(clazz.getMembers().get(0), XASSIGNMENT, FIELD_ALREADY_INITIALIZED);
    	helper.assertNoError(clazz.getMembers().get(0), FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_13() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { this('foo') } new(String x) { test = x } }");
    	helper.assertNoError(clazz, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_14() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { this('foo') } new(String x) {  } }");
    	helper.assertError(clazz.getMembers().get(2), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_15() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { println('lalala') this('foo') } new(String x) {  } }");
    	helper.assertError(clazz.getMembers().get(2), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_16() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { } new(String x) {  } }");
    	helper.assertError(clazz.getMembers().get(1), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    	helper.assertError(clazz.getMembers().get(2), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_17() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { x = 'lalala' } new(String x) {  } }");
    	helper.assertError(clazz.getMembers().get(2), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_18() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { } new(String x) { test = x } }");
    	helper.assertError(clazz.getMembers().get(1), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFinalFieldInit_19() throws Exception {
    	XtendClass clazz = clazz("class Foo { val String test new() { test = 'lalala' } new(String x) { test = x } }");
    	helper.assertNoErrors(clazz);
    }
    
    @Test public void testFinalFieldInit_20() throws Exception {
    	XtendClass clazz = clazz("class C { val String test new() { try {} catch(Throwable t) {} } }");
    	helper.assertError(clazz.getMembers().get(1), XTEND_CONSTRUCTOR, FIELD_NOT_INITIALIZED);
    }
    
    @Test public void testFieldTypeInference_01() throws Exception {
    	XtendClass clazz = clazz("class Foo { var test }");
    	helper.assertError(clazz.getMembers().get(0), XTEND_FIELD, TOO_LITTLE_TYPE_INFORMATION);
    }
    
    @Test public void testFieldTypeInference_02() throws Exception {
    	XtendClass clazz = clazz("class Foo { var String test }");
    	helper.assertNoErrors(clazz);
    }
    
    @Test public void testFieldTypeInference_03() throws Exception {
    	XtendClass clazz = clazz("class Foo { var test = 'foo'}");
    	helper.assertNoErrors(clazz);
    }

    @Test public void testBug378226_NoError() throws Exception {
		XtendClass clazz = clazz("@Data class Foo { int id }");
		helper.assertNoErrors(clazz);
    }

    @Test public void testBug378226_Error() throws Exception {
		XtendClass clazz = clazz("@Data class Foo { int id  new(int a){} }");
		helper.assertError(clazz.getMembers().get(1), XTEND_CONSTRUCTOR , FIELD_NOT_INITIALIZED);
    }

    @Test public void testBug378226_NoError_2() throws Exception {
		XtendClass clazz = clazz("@Data class Foo { int id  new(int a){ _id = a } }");
		helper.assertNoErrors(clazz);
    }
    
    @Test public void testBug378211_NoException() throws Exception{
    	String model = "@Data class Foo { int id  def }";
    	XtextResourceSet set = getResourceSet();
		String fileName = getFileName(model);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(model), null);
    	helper.validate(resource.getContents().get(0));
    }
    
    @Test public void testBug362458() throws Exception {
    	XtendFile file  = file("import java.util.Collections class foo { \n" +
    			"def foo() { \n" +
    			"// somecomment\n" +
    			"Collections::<String>emptyList\n" +
    			"}}");
    	helper.assertNoIssues(file);
    }
    
    @Test public void testBug386659() throws Exception {
    	XtendFile file  = file(
    			"class foo {\n" +
    			"  def <T> T genericMethod(T t) {\n" +
    			"    return t\n" +
    			"  }\n" +
    			"  def test() {\n" +
    			"    genericMethod(return null)" +
    			"  }\n" +
    			"}");
    	helper.assertError(file, XFEATURE_CALL, UNREACHABLE_CODE);
    }
    
    @Test public void testBug386659_02() throws Exception {
    	XtendFile file  = file(
    			"class foo {\n" +
    			"  def <T> T genericMethod(T t, int i) {\n" +
    			"    return t\n" +
    			"  }\n" +
    			"  def Object test() {\n" +
    			"    genericMethod(return null, 1)" +
    			"  }\n" +
    			"}");
    	helper.assertError(file, XNUMBER_LITERAL, UNREACHABLE_CODE);
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=394813
     */
    @Test public void testBug394813() throws Exception {
    	XtendFile file  = file(
    			"class foo {\n" +
    			"  val (String)=>void myFunction = []\n" +
    			"}");
    	helper.assertNoErrors(file);
    }
    
    @Test public void testBug394813_01() throws Exception {
    	XtendFile file  = file(
    			"class foo {\n" +
    					"  val (String)=>void myFunction = [null]\n" +
    			"}");
    	helper.assertError(file, XNULL_LITERAL, INVALID_INNER_EXPRESSION);
    }

    @Test
    public void testJavaDocRefs() throws Exception {
	XtendFile file = file(
			"/**\n" +
			" * {@link List}\n" +
			" */\n" +
			"class Foo {\n" +
			"}");
	XtendTypeDeclaration clazz = file.getXtendTypes().get(0);
	helper.assertError(clazz, XTEND_CLASS, IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, "javaDoc","List","cannot be resolved to a type");
    }

    @Test
    public void testJavaDocRefs_1() throws Exception {
	XtendFile file = file(
			"import java.util.List\n" +
			"/**\n" +
			" * {@link List}\n" +
			" */\n" +
			"class Foo {\n" +
			"}");
	XtendTypeDeclaration clazz = file.getXtendTypes().get(0);
	helper.assertNoIssues(clazz);
    }

    @Test
    public void testJavaDocRefs_2() throws Exception {
	XtendFile file = file(
			"/**\n" +
			" * {@link Bar\n" +
			" */\n" +
			"class Foo {\n" +
			"}");
	XtendTypeDeclaration clazz = file.getXtendTypes().get(0);
	helper.assertNoIssues(clazz);
    }

    @Test
    public void testJavaDocRefs_3() throws Exception {
	XtendFile file = file(
			"class Foo {\n" +
					"/**" +
				" * {@link List}\n" +
				" */" +
				"def doStuff(){}"+
			"}");
	XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
	XtendMember function = clazz.getMembers().get(0);
	helper.assertError(function, XTEND_FUNCTION, IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, "javaDoc","List","cannot be resolved to a type");
    }

	@Test
	public void testJavaDocRefs_4() throws Exception {
		XtendFile file = file(
				"class Foo {\n" +
					"/**" +
					" * {@link List}\n" +
					" */" +
					"String field = '42'\n" +
					"def doStuff(){}"+
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendMember field = clazz.getMembers().get(0);
		helper.assertError(field, XTEND_FIELD, IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, "javaDoc","List","cannot be resolved to a type");
	}

	@Test
	public void testJavaDocRefs_5() throws Exception {
		XtendFile file = file(
				"class Foo {\n" +
					"/**" +
					" * {@link List}\n" +
					" */" +
					"String field = '42'\n" +
					"def doStuff(){}"+
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendMember field = clazz.getMembers().get(0);
		helper.assertError(field, XTEND_FIELD, IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, "javaDoc","List","cannot be resolved to a type");
	}

	@Test
	public void testJavaDocRefs_6() throws Exception {
		XtendFile file = file(
				"class Foo {\n" +
					"/**" +
					" * {@link    List}\n" +
					" */" +
					"String field = '42'\n" +
					"def doStuff(){}"+
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendMember field = clazz.getMembers().get(0);
		helper.assertError(field, XTEND_FIELD, IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, "javaDoc","List","cannot be resolved to a type");
	}

	@Test
	public void testJavaDocRefs_7() throws Exception {
		XtendFile file = file(
				"class Foo {\n" +
					"/**" +
					" * @see    List\n" +
					" */" +
					"String field = '42'\n" +
					"def doStuff(){}"+
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendMember field = clazz.getMembers().get(0);
		helper.assertError(field, XTEND_FIELD, IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, "javaDoc","List","cannot be resolved to a type");
	}
	
	@Test
	public void testInvalidNumOfTypeParameters_0() throws Exception {
		XtendFile file = file(
				"class Foo extends Bar<T> {" 
				+ "}"
				+ ""
				+ "class Bar<T,U> {"
				+ "}");
		helper.assertNoErrors(file.getXtendTypes().get(0), INVALID_NUMBER_OF_TYPE_ARGUMENTS);
	}

	@Test
	public void testInvalidNumOfTypeParameters_1() throws Exception {
		XtendFile file = file(
				"class Foo extends Bar<T,U> {" 
				+ "}"
				+ ""
				+ "class Bar<T> {"
				+ "}");
		helper.assertNoErrors(file.getXtendTypes().get(0), INVALID_NUMBER_OF_TYPE_ARGUMENTS);
	}

	@Test
	public void testInvalidNumOfTypeParameters_2() throws Exception {
		XtendFile file = file(
				"class Foo extends Bar<T> {" 
				+ "}"
				+ ""
				+ "class Bar {"
				+ "}");
		helper.assertNoErrors(file.getXtendTypes().get(0), INVALID_NUMBER_OF_TYPE_ARGUMENTS);
	}
	
	@Test
	public void testInvalidNumOfTypeParameters_3() throws Exception {
		XtendFile file = file(
				"class Foo<T> extends Bar<T> {" 
				+ "}"
				+ ""
				+ "class Bar<T,U> {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, INVALID_NUMBER_OF_TYPE_ARGUMENTS);
	}

	@Test
	public void testInvalidNumOfTypeParameters_4() throws Exception {
		XtendFile file = file(
				"class Foo<T,U> extends Bar<T,U> {" 
				+ "}"
				+ ""
				+ "class Bar<T> {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, INVALID_NUMBER_OF_TYPE_ARGUMENTS);
	}

	@Test
	public void testInvalidNumOfTypeParameters_5() throws Exception {
		XtendFile file = file(
				"class Foo<T> extends Bar<T> {" 
				+ "}"
				+ ""
				+ "class Bar {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, TYPE_ARGUMENT_ON_NON_GENERIC_TYPE);
	}

	@Test
	public void testRawType() throws Exception {
		XtendFile file = file(
				"class Foo extends Bar {" 
				+ "}"
				+ ""
				+ "class Bar<T> {"
				+ "}");
		helper.assertWarning(file.getXtendTypes().get(0), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, RAW_TYPE);
	}
	
	@Test
	public void testRawTypeOnField_01() throws Exception {
		XtendFile file = file(
				"class Foo { public val Object x = typeof(java.util.Map) }");
		helper.assertNoIssues(file.getXtendTypes().get(0));
	}
	
	@Test
	public void testRawTypeOnField_02() throws Exception {
		String fileAsText = "class Foo { public val x = typeof(java.util.Map) }";
		XtendFile file = file(fileAsText);
		helper.assertWarning(file, XTEND_FIELD, RAW_TYPE, 
				"The inferred field type Class<Map> uses the raw type Map. References to generic type Map<K, V> should be parameterized");
		List<Issue> issues = helper.validate(file);
		assertEquals(1, issues.size());
		assertEquals(fileAsText.indexOf('x'), issues.get(0).getOffset().intValue());
		assertEquals(1, issues.get(0).getLength().intValue());
	}
	
	@Test
	public void testRawTypeOnFieldFromTypeLiteral_01() throws Exception {
		XtendFile file = file(
				"class Foo { public val Object x = java.util.Map }");
		helper.assertNoIssues(file.getXtendTypes().get(0));
	}
	
	@Test
	public void testRawTypeOnFieldFromTypeLiteral_02() throws Exception {
		String fileAsText = "class Foo { public val x = java.util.Map }";
		XtendFile file = file(fileAsText);
		helper.assertWarning(file, XTEND_FIELD, RAW_TYPE, 
				"The inferred field type Class<Map> uses the raw type Map. References to generic type Map<K, V> should be parameterized");
		List<Issue> issues = helper.validate(file);
		assertEquals(1, issues.size());
		assertEquals(fileAsText.indexOf('x'), issues.get(0).getOffset().intValue());
		assertEquals(1, issues.get(0).getLength().intValue());
	}

	@Test
	public void testReturnTypeInvalidNumOfTypeParameters_0() throws Exception {
		XtendFile file = file(
				"class Foo {"
				+ " def <T> Bar<T> foo() {}"
				+ "}"
				+ ""
				+ "class Bar<T,U> {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, INVALID_NUMBER_OF_TYPE_ARGUMENTS);
	}

	@Test
	public void testReturnTypeInvalidNumOfTypeParameters_1() throws Exception {
		XtendFile file = file(
				"class Foo {" 
				+ " def <T,U> Bar<T,U> foo() {}"
				+ "}"
				+ ""
				+ "class Bar<T> {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, INVALID_NUMBER_OF_TYPE_ARGUMENTS);
	}

	@Test
	public void testReturnTypeInvalidNumOfTypeParameters_2() throws Exception {
		XtendFile file = file(
				"class Foo {" 
				+ " def <T> Bar<T> foo() {}"
				+ "}"
				+ ""
				+ "class Bar {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, TYPE_ARGUMENT_ON_NON_GENERIC_TYPE);
	}

	@Test
	public void testReturnTypeRawType_01() throws Exception {
		XtendFile file = file(
				"class Foo {" 
				+ " def Bar foo() {}"
				+ "}"
				+ ""
				+ "class Bar<T> {"
				+ "}");
		helper.assertWarning(file.getXtendTypes().get(0), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, RAW_TYPE);
	}
	
	@Test
	public void testReturnTypeRawType_02() throws Exception {
		XtendFile file = file(
				"class Foo {" 
				+ " def foo() { typeof(Bar) }"
				+ "}"
				+ ""
				+ "class Bar<T> {"
				+ "}");
		helper.assertWarning(file.getXtendTypes().get(0), XTEND_FUNCTION, RAW_TYPE,
				"The inferred return type Class<Bar> uses the raw type Bar. References to generic type Bar<T> should be parameterized");
	}
	
	@Test
	public void testReturnTypeRawType_03() throws Exception {
		XtendFile file = file(
				"class Foo {" 
				+ " def foo() { Bar }"
				+ "}"
				+ ""
				+ "class Bar<T> {"
				+ "}");
		helper.assertWarning(file.getXtendTypes().get(0), XTEND_FUNCTION, RAW_TYPE,
				"The inferred return type Class<Bar> uses the raw type Bar. References to generic type Bar<T> should be parameterized");
	}

	@Test
	public void testWildcardSuperType_0() throws Exception {
		XtendFile file = file(
				"class Foo extends Bar<?>{" 
				+ "}"
				+ ""
				+ "class Bar<T> {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), XTEND_CLASS, WILDCARD_IN_SUPERTYPE);
	}

	@Test
	public void testWildcardSuperType_1() throws Exception {
		XtendFile file = file(
				"class Foo implements Bar<? extends String>{" 
				+ "}"
				+ ""
				+ "interface Bar<T> {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), XTEND_CLASS, WILDCARD_IN_SUPERTYPE);
	}

	@Test
	public void testWildcardSuperType_2() throws Exception {
		XtendFile file = file(
				"interface Foo extends Bar<? super String>{" 
				+ "}"
				+ ""
				+ "interface Bar<T> {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), XTEND_INTERFACE, WILDCARD_IN_SUPERTYPE);
	}

	@Test
	public void testWildcardSuperType_3() throws Exception {
		XtendFile file = file(
				"interface Foo extends Bar<Class<?>>{" 
				+ "}"
				+ ""
				+ "interface Bar<T> {"
				+ "}");
		helper.assertNoError(file.getXtendTypes().get(0), WILDCARD_IN_SUPERTYPE);
	}
	
	@Test
	public void testWildcardSuperType_4() throws Exception {
		XtendFile file = file(
				"class Foo {"
				+ " val bar = new Bar<?>() {" 
				+ " }"
				+ "}"
				+ "class Bar<T> {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), TypesPackage.Literals.JVM_WILDCARD_TYPE_REFERENCE, INVALID_USE_OF_WILDCARD);
	}
	
	@Test
	public void testWildcardSuperType_5() throws Exception {
		XtendFile file = file(
				"class Foo {"
				+ " val bar = new Bar<Bar<?>>() {" 
				+ " }"
				+ "}"
				+ "class Bar<T> {"
				+ "}");
		helper.assertNoErrors(file.getXtendTypes().get(0));
	}

	@Test
	public void testAnonymousClassExtendsFinal() throws Exception {
		XtendFile file = file(
				"class Foo {"
				+ " val bar = new Bar() {" 
				+ " }"
				+ "}"
				+ "final class Bar {"
				+ "}");
		helper.assertError(file.getXtendTypes().get(0), XCONSTRUCTOR_CALL, OVERRIDDEN_FINAL);
	}
	
	@Test 
	public void testVoidInFunctionParams() throws Exception {
		XtendFile file = file(
				"class Foo {"
						+ " public (String, void) => void  x"
						+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE);
	}
	
	@Test 
	public void testVoidInFunctionParams_1() throws Exception {
		XtendFile file = file(
				"class Foo {"
						+ " public (String) => void  x"
						+ "}");
		helper.assertNoErrors(file);
	}
	
	@Test 
	public void testVoidInFunctionParams_2() throws Exception {
		XtendFile file = file(
				"class Foo {"
						+ " def void foo((String, void) => void myParam) {}"
						+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE);
	}
	
	@Test 
	public void testVoidInFunctionParams_3() throws Exception {
		XtendFile file = file(
				"class Foo {"
						+ " def void foo((String, TotallyUnknown) => void myParam) {}"
						+ "}");
		helper.assertNoErrors(file, INVALID_TYPE);
	}

	@Test 
	public void testTypeParameterAccessedFromStaticMember_0() throws Exception {
		XtendFile file = file(
				"class Foo<T> {"
				+ " public T x"
				+ "}");
		helper.assertNoError(file, STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	@Test 
	public void testTypeParameterAccessedFromStaticMember_1() throws Exception {
		XtendFile file = file(
				"class Foo<T> {"
				+ " def T x(T y) { val T z=y z }"
				+ "}");
		helper.assertNoError(file, STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	@Test 
	public void testTypeParameterAccessedFromStaticMember_2() throws Exception {
		XtendFile file = file(
				"class Foo<T> {"
				+ " def static T x() { null }"
				+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	@Test 
	public void testTypeParameterAccessedFromStaticMember_3() throws Exception {
		XtendFile file = file(
				"class Foo<T> {"
				+ " def static void x(T t) { null }"
				+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	@Test 
	public void testTypeParameterAccessedFromStaticMember_4() throws Exception {
		XtendFile file = file(
				"class Foo<T> {"
				+ " def static Foo<T> x() { null }"
				+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	@Test 
	public void testTypeParameterAccessedFromStaticMember_5() throws Exception {
		XtendFile file = file(
				"class Foo<T> {"
				+ " def static void x() { new Foo<T>() }"
				+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	@Test 
	public void testTypeParameterAccessedFromStaticMember_6() throws Exception {
		XtendFile file = file(
				"class Foo<T> {"
				+ " def static <T> void x(T x) {}"
				+ "}");
		helper.assertNoError(file, STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	@Test 
	public void testInvalidTypeParameterConstraint_0() throws Exception {
		XtendFunction function = function("def <T extends String[]> foo(T x) {}");
		helper.assertError(function, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE, INVALID_TYPE_PARAMETER_BOUNDS, " String[]");
	}
	
	@Test 
	public void testInvalidTypeParameterConstraint_2() throws Exception {
		XtendFunction function = function("def <T extends Comparable<String[]>> foo(T x) {}");
		helper.assertNoError(function, INVALID_TYPE_PARAMETER_BOUNDS);
	}
	
	@Test 
	public void testInvalidTypeParameterConstraint_3() throws Exception {
		XtendFile file = file("class Foo<T, U extends T & Appendable> {}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_TYPE_PARAMETER_BOUNDS);
	}
	
	@Test 
	public void testInvalidTypeParameterConstraint_4() throws Exception {
		XtendFile file = file("class Foo<T, U extends Appendable & T> {}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_TYPE_PARAMETER_BOUNDS);
	}
	
	@Test 
	public void testTypeParameterForwardReference_0() throws Exception {
		XtendFile file = file(
				"class Foo<T extends T> {"
				+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, TYPE_PARAMETER_FORWARD_REFERENCE);
	}
	
	@Test 
	public void testTypeParameterForwardReference_1() throws Exception {
		XtendFile file = file(
				"class Foo<T extends U, U> {"
				+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, TYPE_PARAMETER_FORWARD_REFERENCE);
	}
	
	@Test 
	public void testTypeParameterForwardReference_2() throws Exception {
		XtendFile file = file(
				"class Foo<T, U extends List<? extends V>, V> {"
				+ "}");
		helper.assertNoError(file, TYPE_PARAMETER_FORWARD_REFERENCE);
	}
	
	@Test 
	public void testTypeParameterForwardReference_3() throws Exception {
		XtendFile file = file(
				"interface Foo<T extends T> {"
				+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, TYPE_PARAMETER_FORWARD_REFERENCE);
	}
	
	@Test 
	public void testTypeParameterForwardReference_4() throws Exception {
		XtendFile file = file(
				"interface Foo<T extends U, U> {"
				+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, TYPE_PARAMETER_FORWARD_REFERENCE);
	}
	
	@Test 
	public void testTypeParameterForwardReference_5() throws Exception {
		XtendFile file = file(
				"interface Foo<T, U extends List<? extends V>, V> {"
				+ "}");
		helper.assertNoError(file, TYPE_PARAMETER_FORWARD_REFERENCE);
	}

	@Test 
	public void testTypeParameterForwardReference_6() throws Exception {
		XtendFile file = file(
				"class Foo {"
				+ "  def <T extends T> foo() {}"
				+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, TYPE_PARAMETER_FORWARD_REFERENCE);
	}
	
	@Test 
	public void testTypeParameterForwardReference_7() throws Exception {
		XtendFile file = file(
				"class Foo {"
				+ "  def <T extends U, U> foo() {}"
				+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, TYPE_PARAMETER_FORWARD_REFERENCE);
	}
	
	@Test 
	public void testTypeParameterForwardReference_8() throws Exception {
		XtendFile file = file(
				"class Foo {"
				+ "  def <T, U extends List<? extends V>, V> foo() {}"
				+ "}");
		helper.assertNoError(file, TYPE_PARAMETER_FORWARD_REFERENCE);
	}
	
	@Test 
	public void testTypeParameterForwardReference_9() throws Exception {
		XtendFile file = file(
				"class Foo {"
				+ "  def <T extends Enum<T>> foo() {}"
				+ "}");
		helper.assertNoError(file, TYPE_PARAMETER_FORWARD_REFERENCE);
	}
	
	@Test 
	public void testTypeParameterReferencedInTypeLiteral_02() throws Exception {
		XtendFile file = file(
				"class Foo {"
						+ "  def <T> Class<? extends T> foo() {"
						+ "    return typeof(T)"
						+ "  }"
						+ "}");
		helper.assertError(file, XbasePackage.Literals.XTYPE_LITERAL, INVALID_USE_OF_TYPE_PARAMETER);
	}
	
	@Test 
	public void testTypeParameterReferencedInTypeLiteral_01() throws Exception {
		XtendFile file = file(
				"class Foo {"
						+ "  def <T> Class<? extends T> foo() {"
						+ "    return T"
						+ "  }"
						+ "}");
		helper.assertError(file, XbasePackage.Literals.XABSTRACT_FEATURE_CALL, INVALID_USE_OF_TYPE_PARAMETER);
	}
	
	@Test 
	public void testTypeParameterReferencedInInstanceof_01() throws Exception {
		XtendFile file = file(
				"class Foo {"
						+ "  def <T> boolean foo() {"
						+ "    return '' instanceof T"
						+ "  }"
						+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE_PARAMETER);
	}
	
	@Test 
	public void testTypeParameterReferencedInInstanceof_02() throws Exception {
		XtendFile file = file(
				"class Foo {"
						+ "  def <T extends CharSequence> boolean foo() {"
						+ "    return '' instanceof T"
						+ "  }"
						+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE_PARAMETER, "CharSequence");
	}
	
	@Test 
	public void testTypeParameterReferencedInInstanceof_03() throws Exception {
		XtendFile file = file(
				"class Foo {"
						+ "  def <T extends CharSequence & Iterable<? extends Character>> boolean foo() {"
						+ "    return '' instanceof T"
						+ "  }"
						+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE_PARAMETER, "CharSequence & Iterable");
	}
	
	@Test 
	public void testTypeParameterReferencedInSwitch() throws Exception {
		XtendFile file = file(
				"class Foo {"
						+ "  def <T> boolean foo() {"
						+ "    return switch '' { T : 'foo'  default : 'bla'}"
						+ "  }"
						+ "}");
		helper.assertError(file, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE_PARAMETER);
	}
	
	
	
	@Test
	public void testFieldInitializerNonVoid_0() throws Exception {
		XtendFile file = file(
				"class Foo {"
				+ "public val x = voidFunction()"
				+ "def void voidFunction() {}"
				+ "}");
		helper.assertError(file, XFEATURE_CALL, INCOMPATIBLE_TYPES);
	}

	@Test
	public void testFieldInitializerNonVoid_1() throws Exception {
		XtendFile file = file(
				"class Foo {"
				+ "public val int x = voidFunction()"
				+ "def void voidFunction() {}"
				+ "}");
		helper.assertError(file, XFEATURE_CALL, INCOMPATIBLE_TYPES);
	}
	
	@Test
	public void testBug413680_0() throws Exception {
		XtendFile file = file(
			"class B extends A {" +
			"	def static hello() {}" +
			"}" +
			"class A {" +
				"def static hello() {}" +
			"}");
		helper.assertNoErrors(file);
	}
	
	@Test
	public void testBug413680_1() throws Exception {
		XtendFile file = file(
			"class B extends A {" +
			"	override static hello() {}" +
			"}" +
			"class A {" +
				"def static hello() {}" +
			"}");
		helper.assertError(file, XTEND_FUNCTION, OBSOLETE_OVERRIDE, "shadows the method");
	}
	
	@Test
	public void testBug413680_2() throws Exception {
		XtendFile file = file(
			"class B extends A {" +
			"	override static hello() {}" +
			"}" +
			"class A {}");
		helper.assertError(file, XTEND_FUNCTION, OBSOLETE_OVERRIDE, "must override a superclass method");
	}

	@Test public void testPrimitiveDefaultValueSynthesized_01() throws Exception {
		XtendFile file = file(
				"class C {" +
				"	def int m() { if (true) 1 }" +
				"}");
		helper.assertWarning(file, XIF_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
	@Test public void testPrimitiveDefaultValueSynthesized_02() throws Exception {
		XtendFile file = file(
				"class C {" +
				"	def void m() { if (true) 1 }" +
				"}");
		helper.assertNoWarnings(file, XIF_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
	@Test public void testPrimitiveDefaultValueSynthesized_03() throws Exception {
		XtendFile file = file(
				"class C {" +
				"	def int m() { if (true) return 1 }" +
				"}");
		helper.assertWarning(file, XIF_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
	@Test public void testPrimitiveDefaultValueSynthesized_04() throws Exception {
		XtendFile file = file(
				"class C {" +
				"	def int m(Object o) { switch o { String: 1 CharSequence: 2 } }" +
				"}");
		helper.assertWarning(file, XSWITCH_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
	@Test public void testPrimitiveDefaultValueSynthesized_05() throws Exception {
		XtendFile file = file(
				"class C {" +
				"	def void m(Object o) { switch o { String: 1 CharSequence: 2 } }" +
				"}");
		helper.assertNoWarnings(file, XSWITCH_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
	@Test public void testPrimitiveDefaultValueSynthesized_06() throws Exception {
		XtendFile file = file(
				"class C {" +
				"	def int m(Object o) { switch o { String: return 1 CharSequence: return 2 } }" +
				"}");
		helper.assertWarning(file, XSWITCH_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}

	@Test public void testPrimitiveDefaultValueSynthesized_07() throws Exception {
		XtendFile file = file(
				"class C {" +
				"	def int m(Object o) { switch o { String: 1 CharSequence: return 2 } }" +
				"}");
		helper.assertWarning(file, XSWITCH_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
	@Test public void testBug436483_01() throws Exception {
		XtendFile file = file(
				"import static java.lang.Enum.*\n" + 
				"class C {\n" + 
				" def void m() {\n" + 
				"  valueOf(null, null)\n" + 
				" }\n" + 
				"}");
		helper.assertError(file, XFEATURE_CALL, TYPE_BOUNDS_MISMATCH, 
				"Bounds mismatch: The type argument <Enum<?>> is not a valid substitute for the bounded type parameter <T extends Enum<T>> of the method valueOf(Class<T>, String)");
	}
	
	// Probably to be improved such that this is not an error because C#valueOf could be a better match
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=436483
	// 
	@Test public void testBug436483_02() throws Exception {
		XtendFile file = file(
				"import static java.lang.Enum.*\n" + 
				"class C {\n" + 
				" def static void valueOf(Object o, Object context) {\n" + 
				" }\n" + 
				" def void m() {\n" + 
				"  valueOf(null, null)\n" + 
				" }\n" + 
				"}");
		helper.assertError(file, XFEATURE_CALL, TYPE_BOUNDS_MISMATCH, 
				"Bounds mismatch: The type argument <Enum<?>> is not a valid substitute for the bounded type parameter <T extends Enum<T>> of the method valueOf(Class<T>, String)");
	}
	
	@Test public void testConstantConditions_01() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	val x = \"a\"\n" + 
				"	val y = x \n" + 
				"	val z = y\n" + 
				"	def m() {\n" + 
				"		val a = z\n" + 
				"		val b = a\n" + 
				"		switch f: b {\n" + 
				"			case (f == 'a'): {\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always true");
	}
	
	@Test public void testConstantConditions_02() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	val x = \"a\"\n" + 
				"	val y = x \n" + 
				"	val z = y\n" + 
				"	def m() {\n" + 
				"		val a = z\n" + 
				"		val b = a\n" + 
				"		switch f: b {\n" + 
				"			case (f == 'b'): {\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always false");
	}

	@Test public void testConstantConditions_03() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	val x = \"a\"\n" + 
				"	var y = x \n" + 
				"	val z = y\n" + 
				"	def m() {\n" + 
				"		val a = z\n" + 
				"		val b = a\n" + 
				"		switch f: b {\n" + 
				"			case (f == 'b'): {\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"}");
		helper.assertNoWarnings(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION);
	}
	
	@Test public void testConstantConditions_04() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	val x = y\n" + 
				"	val y = x \n" + 
				"	val z = y\n" + 
				"	def m() {\n" + 
				"		val a = z\n" + 
				"		val b = a\n" + 
				"		switch f: b {\n" + 
				"			case (f == 'b'): {\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"}");
		helper.assertNoWarnings(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION);
	}

	@Test public void testConstantConditions_05() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m(String p) {\n" + 
				"		if (p == null) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertNoWarnings(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION);
	}
	
	@Test public void testConstantConditions_06() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m(String p) {\n" + 
				"		val a = p\n" + 
				"		val b = p\n" + 
				"		if (a == b) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always true");
	}
	
	@Test public void testConstantConditions_07() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m(String p) {\n" + 
				"		val a = p\n" + 
				"		val b = p\n" + 
				"		if (a == b && p != b) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always false");
	}
	
	@Test public void testConstantConditions_08() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m(String p) {\n" + 
				"		if (p == '') {}\n" + 
				"	}\n" + 
				"}");
		helper.assertNoWarnings(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION);
	}
	
	@Test public void testConstantConditions_09() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	val String state\n" + 
				"	new() { this.state = null }\n" + 
				"	def m() {\n" + 
				"		if (state == null) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertNoWarnings(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION);
	}
	
	@Test public void testConstantConditions_10() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	val String state\n" + 
				"	new() { this.state = null }\n" + 
				"	def m() {\n" + 
				"		if (state == '') {}\n" + 
				"	}\n" + 
				"}");
		helper.assertNoWarnings(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION);
	}
	
	@Test public void testConstantConditions_11() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	val String state = 'a'\n" + 
				"	def m() {\n" + 
				"		if (state == 'b') {}\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always false");
	}
	
	@Test public void testConstantConditions_12() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	val String state = 'a'\n" + 
				"	def m(String p) {\n" + 
				"		if (state == p) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertNoWarnings(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION);
	}
	
	@Test public void testConstantConditions_13() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m() {\n" + 
				"		while (true) { /* some code with exception control flow */ }\n" + 
				"	}\n" + 
				"}");
		helper.assertNoWarnings(file, XBOOLEAN_LITERAL, CONSTANT_BOOLEAN_CONDITION);
	}
	
	@Test public void testConstantConditions_14() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m() {\n" + 
				"		do {} while (true)\n" + 
				"	}\n" + 
				"}");
		helper.assertNoWarnings(file, XBOOLEAN_LITERAL, CONSTANT_BOOLEAN_CONDITION);
	}

	@Test public void testConstantConditions_15() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m() {\n" + 
				"		for (;true;) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBOOLEAN_LITERAL, CONSTANT_BOOLEAN_CONDITION, "always true");
	}
	
	@Test public void testConstantConditions_16() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m() {\n" + 
				"		if (true) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBOOLEAN_LITERAL, CONSTANT_BOOLEAN_CONDITION, "always true");
	}
	
	@Test public void testConstantConditions_17() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	enum E { VAL }\n" + 
				"	def m(E e) {\n" + 
				"		if (E.VAL == e) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertNoWarnings(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION);
	}

	@Test public void testConstantConditions_18() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	enum E { VAL }\n" + 
				"	def m() {\n" + 
				"		val E e = E.VAL\n" + 
				"		if (E.VAL == e) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always true");
	}
	
	@Test public void testConstantConditions_19() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m(String a) {\n" + 
				"		if (a == a) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always true");
	}
	
	@Test public void testConstantConditions_20() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m(String a) {\n" + 
				"		val b = a\n" + 
				"		if (a != b) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always false");
	}
	
	@Test public void testConstantConditions_21() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m(String a, String b) {\n" + 
				"		if (a == b) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertNoIssues(file);
	}
	
	@Test public void testConstantConditions_22() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m(String a, String b) {\n" + 
				"		val c = b\n" + 
				"		if (a == c) {}\n" + 
				"	}\n" + 
				"}");
		helper.assertNoIssues(file);
	}
	
	@Test public void testConstantConditions_23() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m(String a) {\n" + 
				"		if (this == a) return\n" + 
				"	}\n" + 
				"}");
		helper.assertNoIssues(file);
	}
	
	@Test public void testConstantConditions_24() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m() {\n" + 
				"		if (this == String) return\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always false");
	}
	
	@Test public void testConstantConditions_25() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	val t = this" + 
				"	def m() {\n" + 
				"		if (this == t) return\n" + 
				"	}\n" + 
				"}");
		// TODO could actually be smth like this, but it would require more thorough instance / flow tracking
//		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always true");
		helper.assertNoIssues(file);
	}

	@Test public void testConstantConditions_26() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	val t = this" + 
				"	def m(Test other) {\n" + 
				"		if (this == other.t) return\n" + 
				"	}\n" + 
				"}");
		helper.assertNoIssues(file);
	}

	@Test public void testConstantConditions_27() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m() {\n" + 
				"		if (this == null) return\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always false");
	}

	@Test public void testConstantConditions_28() throws Exception {
		XtendFile file = file(
				"class Test {\n" + 
				"	def m() {\n" + 
				"		val t = this" + 
				"		if (this == t) return\n" + 
				"	}\n" + 
				"}");
		helper.assertWarning(file, XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "always true");
	}
	
	@Test public void testConstantConditions_29() throws Exception {
		XtendFile file = file(
				"import java.util.Date\n" + 
				"class Test {\n" + 
				"	def <T> m(Class<T> c) {\n" + 
				"		if (c == Date) return\n" + 
				"	}\n" + 
				"}");
		helper.assertNoIssues(file);
	}
	
	@Test public void testAnonymousClassNotOverridingEquals() throws Exception {
		XtendFile file = file(
			"interface Foo {"+
			"	override equals(Object obj);"+
			"}"+
			"class Bar{"+
			"	def bar() {"+
			"		new Foo {}"+
			"	}"+
			"}");
		helper.assertNoIssues(file);
	}
	
	@Test public void testOverridingBug515801() throws Exception {
		XtendClass clazz = clazz(
				"class Foo implements int {"+
					"override void doSth(Object obj){ "+
					"}"+
				"}");
		List<Issue> issues = helper.validate(clazz);
		for (Issue issue : issues) {
			if (issue.getMessage() != null && issue.getMessage().contains("Error executing EValidator")) {
				fail(issue.getMessage());
			}
		}
	}
	
	@Test public void testDeprecation_01() throws Exception {
		XtendFile file = file(
			"package demo\n" +
			"import testdata.DeprecatedClass\n" +
			"class Demo extends DeprecatedClass {}"
		);
		helper.assertWarning(file, XIMPORT_DECLARATION, DEPRECATED_MEMBER_REFERENCE);
	}
	
	@Test public void testDeprecation_02() throws Exception {
		XtendFile file = file(
				"package demo\n" +
						"import testdata.DeprecatedClass\n" +
						"class Demo extends DeprecatedClass {}\n" + 
						"class Other {}"
				);
		helper.assertWarning(file, XIMPORT_DECLARATION, DEPRECATED_MEMBER_REFERENCE);
	}
	
	@Test public void testDeprecation_03() throws Exception {
		XtendFile file = file(
				"package demo\n" +
						"import testdata.DeprecatedClass\n" +
						"@Deprecated\n" +
						"class Demo extends DeprecatedClass {}"
				);
		helper.assertNoWarnings(file, XIMPORT_DECLARATION, DEPRECATED_MEMBER_REFERENCE);
	}
	
	@Test public void testDeprecation_04() throws Exception {
		XtendFile file = file(
				"package demo\n" +
						"import testdata.DeprecatedClass\n" +
						"@Deprecated\n" +
						"class Demo extends DeprecatedClass {}\n" + 
						"class Other {}"
				);
		helper.assertNoWarnings(file, XIMPORT_DECLARATION, DEPRECATED_MEMBER_REFERENCE);
	}
	
	@Test public void testDeprecation_05() throws Exception {
		XtendFile file = file(
				"package demo\n" +
						"import testdata.DeprecatedClass\n" +
						"class Demo extends DeprecatedClass {}\n" + 
						"@Deprecated\n" +
						"class Other {}"
				);
		helper.assertNoWarnings(file, XIMPORT_DECLARATION, DEPRECATED_MEMBER_REFERENCE);
	}
	
	@Test public void testValidInstanceof_01() throws Exception {
		XtendFile file = file("class C { def <T> boolean m(T x) { x instanceof String } }");
		helper.assertNoIssues(file);
	}
	
	@Test public void testValidInstanceof_02() throws Exception {
		XtendFile file = file("class C<T> { def boolean m(T x) { x instanceof String } }");
		helper.assertNoIssues(file);
	}
	
	@Test public void testValidInstanceof_03() throws Exception {
		XtendFile file = file("class C { def <S, T extends S> boolean m(T x) { x instanceof String } }");
		helper.assertNoIssues(file);
	}
	
	@Test public void testValidInstanceof_04() throws Exception {
		XtendFile file = file("class C { def <S extends CharSequence, T extends S> boolean m(T x) { x instanceof String } }");
		helper.assertNoIssues(file);
	}
	
	@Test public void testValidInstanceof_05() throws Exception {
		XtendFile file = file("class C { def <T> boolean m(T[] x) { x instanceof String[] } }");
		helper.assertNoIssues(file);
	}
	
	@Test public void testInvalidInstanceof_01() throws Exception {
		XtendFile file = file("class C { def <T> boolean m(T x) { x instanceof T } }");
		helper.assertError(file, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_USE_OF_TYPE_PARAMETER);
	}
	
	@Test public void testInvalidInstanceof_02() throws Exception {
		XtendFile file = file("class C { def <T extends Number> boolean m(T x) { x instanceof String } }");
		helper.assertError(file, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_INSTANCEOF);
	}
	
	@Test public void testInvalidInstanceof_03() throws Exception {
		XtendFile file = file("class C { def <T extends String> boolean m(T x) { x instanceof CharSequence } }");
		helper.assertWarning(file, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInvalidInstanceof_04() throws Exception {
		XtendFile file = file("class C { def <T extends String> boolean m(T x) { x instanceof String } }");
		helper.assertWarning(file, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInvalidInstanceof_05() throws Exception {
		XtendFile file = file("class C { def <T extends CharSequence & java.util.List<T>> boolean m(T x) { x instanceof String } }");
		helper.assertError(file, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_INSTANCEOF);
	}
	
	@Test public void testInvalidInstanceof_06() throws Exception {
		XtendFile file = file("class C { def <T extends Object & CharSequence & java.util.List<T>> boolean m(T x) { x instanceof String } }");
		helper.assertError(file, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_INSTANCEOF);
	}
	
	@Test public void testInvalidInstanceof_07() throws Exception {
		XtendFile file = file("class C { def <S extends Number, T extends S> boolean m(T x) { x instanceof String } }");
		helper.assertError(file, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_INSTANCEOF);
	}
	
	@Test public void testInvalidInstanceof_08() throws Exception {
		XtendFile file = file("class C { def <S extends String, T extends S> boolean m(T x) { x instanceof String } }");
		helper.assertWarning(file, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInvalidInstanceof_09() throws Exception {
		XtendFile file = file("class C { def <T> boolean m(T[] x) { x instanceof T[] } }");
		helper.assertError(file, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_USE_OF_TYPE_PARAMETER);
	}
	
	@Test public void testInvalidInstanceof_10() throws Exception {
		XtendFile file = file("class C { def <T extends Number> boolean m(T[] x) { x instanceof String[] } }");
		helper.assertError(file, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_INSTANCEOF);
	}
	
	@Test public void testInvalidInstanceof_11() throws Exception {
		XtendFile file = file("class C { def <S extends String, T extends S> boolean m(java.util.List<? extends T> x) { x.get(0) instanceof String } }");
		helper.assertWarning(file, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInvalidInstanceof_12() throws Exception {
		XtendFile file = file("class C { def <T extends Number> boolean m(java.util.List<? extends T> x) { x.head instanceof String } }");
		helper.assertError(file, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_INSTANCEOF);
	}
	
}
