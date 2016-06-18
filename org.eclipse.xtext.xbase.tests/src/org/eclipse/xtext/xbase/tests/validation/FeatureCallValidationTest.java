/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FeatureCallValidationTest extends AbstractXbaseTestCase {

	@Inject
	protected ValidationTestHelper helper;

	@Test public void testNonFinalVariableAccess() throws Exception {
		XExpression expression = expression("{ var x = '' [ x ].apply('') }");
		helper.assertError(expression, XFEATURE_CALL, INVALID_MUTABLE_VARIABLE_ACCESS, "Cannot refer to the non-final variable x inside");
	}
	
	@Test public void testFinalVariableAccess() throws Exception {
		XExpression expression = expression("{ val x = '' [ x ].apply('') }");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testConstructorCall_0() throws Exception {
		XExpression expression = expression("new testdata.Constructors()");
		helper.assertError(expression, XCONSTRUCTOR_CALL, INVALID_NUMBER_OF_ARGUMENTS);
	}

	@Test public void testConstructorCall_1() throws Exception {
		XExpression expression = expression("new testdata.Constructors(1)");
		helper.assertError(expression, XNUMBER_LITERAL, INCOMPATIBLE_TYPES);
	}

	@Test public void testConstructorCall_2() throws Exception {
		XExpression expression = expression("new testdata.Constructors('foo', 'bar')");
		helper.assertError(expression, XCONSTRUCTOR_CALL, INVALID_NUMBER_OF_ARGUMENTS);
	}

	@Test public void testConstructorCall_3() throws Exception {
		XExpression expression = expression("new testdata.Constructors2(42)");
		helper.assertError(expression, XCONSTRUCTOR_CALL, FEATURE_NOT_VISIBLE);
	}
	
	@Test public void testConstructorCall_4() throws Exception {
		XExpression expression = expression("new int");
		helper.assertError(expression, XCONSTRUCTOR_CALL, ILLEGAL_CLASS_INSTANTIATION, "Cannot instantiate the primitive type int");
	}
	
	@Test public void testConstructorCall_5() throws Exception {
		XExpression expression = expression("new Override");
		helper.assertError(expression, XCONSTRUCTOR_CALL, ILLEGAL_CLASS_INSTANTIATION, "Cannot instantiate the annotation type Override");
	}
	
	@Test public void testConstructorCall_6() throws Exception {
		XExpression expression = expression("new java.lang.annotation.RetentionPolicy");
		helper.assertError(expression, XCONSTRUCTOR_CALL, ILLEGAL_CLASS_INSTANTIATION, "Cannot instantiate the enum type RetentionPolicy");
	}
	
	@Test public void testConstructorCall_7() throws Exception {
		XExpression expression = expression("new Iterable<String>");
		helper.assertError(expression, XCONSTRUCTOR_CALL, ILLEGAL_CLASS_INSTANTIATION, "Cannot instantiate the interface type Iterable");
	}
	
	@Test public void testConstructorCall_8() throws Exception {
		XExpression expression = expression("new java.util.AbstractList<String>");
		helper.assertError(expression, XCONSTRUCTOR_CALL, ABSTRACT_CLASS_INSTANTIATION, "Cannot instantiate the abstract type AbstractList");
	}
	
	@Test public void testConstructorCall_9() throws Exception {
		XExpression expression = expression("new void");
		helper.assertError(expression, XCONSTRUCTOR_CALL, ILLEGAL_CLASS_INSTANTIATION, "Cannot instantiate the primitive type void");
	}
	
	@Test public void testConstructorCall_10() throws Exception {
		XExpression expression = expression("new DoesNotExist");
		helper.assertError(expression, XCONSTRUCTOR_CALL, Diagnostic.LINKING_DIAGNOSTIC);
	}

	// TODO: constructor type arguments

	@Test public void testBinaryOperation_0() throws Exception {
		XExpression expression = expression("1 + true");
		helper.assertError(expression, XBOOLEAN_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	@Test public void testBinaryOperation_1() throws Exception {
		XExpression expression = expression("new Integer(1) + 2");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testBinaryOperation_2() throws Exception {
		XExpression expression = expression("1 + '2'");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testBinaryOperation_3() throws Exception {
		XExpression expression = expression("{ val x = true (x && x).booleanValue }");
		helper.assertNoErrors(expression);
	}

	@Test public void testAssignment_0() throws Exception {
		XExpression expression = expression("new testdata.Properties1().prop3 = 'foo'");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}

	@Test public void testAssignmentToFinalField() throws Exception {
		XExpression expression = expression("new testdata.FieldAccess().finalField = 'foo'");
		helper.assertError(expression, XASSIGNMENT, ASSIGNMENT_TO_FINAL);
	}

	@Test public void testAssignmentToStaticField() throws Exception {
		XExpression expression = expression("new testdata.FieldAccess().staticField = 'foo'");
		helper.assertError(expression, XASSIGNMENT, INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	@Test public void testField_0() throws Exception {
		XExpression expression = expression("new testdata.FieldAccess().finalField()");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, FIELD_ACCESS_WITH_PARENTHESES);
	}

	@Test public void testField_1() throws Exception {
		XExpression expression = expression("new testdata.FieldAccess().finalField('foo')");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INVALID_NUMBER_OF_ARGUMENTS);
	}

	@Test public void testField_2() throws Exception {
		XExpression expression = expression("new testdata.FieldAccess().staticField");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	@Test public void testField_3() throws Exception {
		XExpression expression = expression("{ var this = new testdata.FieldAccess() staticField }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL,
				INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	@Test public void testField_4() throws Exception {
		XExpression expression = expression("{ var this = new testdata.FieldAccess() finalField() }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL,
				FIELD_ACCESS_WITH_PARENTHESES);
	}
	
	@Test public void testField_5() throws Exception {
		XExpression expression = expression("{ var it = new testdata.FieldAccess() staticField }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL,
				INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	@Test public void testOperationMemberFeatureCall_0() throws Exception {
		XExpression expression = expression("new testdata.Methods().staticMethod()");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	@Test public void testOperationMemberFeatureCall_1() throws Exception {
		XExpression expression = expression("new testdata.Methods().method()");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INVALID_NUMBER_OF_ARGUMENTS);
	}

	@Test public void testOperationMemberFeatureCall_2() throws Exception {
		XExpression expression = expression("new testdata.Methods().method('foo', 'bar')");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INVALID_NUMBER_OF_ARGUMENTS);
	}

	@Test public void testOperationMemberFeatureCall_3() throws Exception {
		XExpression expression = expression("new testdata.Methods().method('foo')");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}

	@Test public void testOperationMemberFeatureCall_4() throws Exception {
		XExpression expression = expression("new testdata.Methods().sugarMethod");
		helper.assertNoError(expression, METHOD_ACCESS_WITHOUT_PARENTHESES);
	}

	@Test public void testOperationMemberFeatureCall_5() throws Exception {
		XExpression expression = expression("new testdata.Methods().sugarMethod()");
		helper.assertNoError(expression, METHOD_ACCESS_WITHOUT_PARENTHESES);
	}

	@Test public void testOperationFeatureCall_0() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() staticMethod() }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL, INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	@Test public void testOperationFeatureCall_1() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() method() }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL,
				INVALID_NUMBER_OF_ARGUMENTS);
	}

	@Test public void testOperationFeatureCall_2() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() method('foo', 'bar') }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL,
				INVALID_NUMBER_OF_ARGUMENTS);
	}

	@Test public void testOperationFeatureCall_3() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() method('foo') }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XSTRING_LITERAL,
				INCOMPATIBLE_TYPES);
	}

	@Test public void testOperationFeatureCall_4() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() sugarMethod }");
		helper.assertNoError(((XBlockExpression) expression).getExpressions().get(1), METHOD_ACCESS_WITHOUT_PARENTHESES);
	}
	
	@Test public void testOperationFeatureCall_5() throws Exception {
		XExpression expression = expression("{ var o = new Object() o.clone() }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE);
	}
	
	@Test public void testOperationFeatureCall_6() throws Exception {
		XExpression expression = expression("(null as Comparable<? extends Object>).compareTo(1)");
		helper.assertError(expression, XNUMBER_LITERAL, INCOMPATIBLE_TYPES, 
				"Type mismatch: type int is not applicable at this location");
	}
	
	@Test public void testOperationFeatureCall_7() throws Exception {
		XExpression expression = expression("(null as Comparable<? extends Object>).compareTo(null)");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testOperationFeatureCall_8() throws Exception {
		XExpression expression = expression("(if (true) null as Comparable<Double> else null as Comparable<Integer>).compareTo(null)");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testOperationFeatureCall_9() throws Exception {
		XExpression expression = expression("'a,b'.split(',').flatten");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INCOMPATIBLE_TYPES, 
				"Type mismatch: cannot convert from String[] to Iterable<? extends Iterable<?>>");
	}
	
	@Test public void testOperationFeatureCall_10() throws Exception {
//		Iterable<String> x = IterableExtensions.flatten(CollectionLiterals.newArrayList(CollectionLiterals.newArrayList("a,b".split(","))));
		XExpression expression = expression("{ var Iterable<String> x = newArrayList(newArrayList('a,b'.split(','))).flatten }");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testOperationFeatureCall_11() throws Exception {
//		Iterable<String> x = IterableExtensions.flatten(CollectionLiterals.newArrayList(CollectionLiterals.newArrayList("a", "b")));
		XExpression expression = expression("{ var Iterable<String> x = newArrayList(newArrayList('a', 'b')).flatten }");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testOperationFeatureCall_12() throws Exception {
//		Iterable<String> x = IterableExtensions.flatten(CollectionLiterals.newArrayList(CollectionLiterals.newArrayList("a")));
		XExpression expression = expression("{ var Iterable<String> x = newArrayList(newArrayList('a')).flatten }");
		helper.assertNoErrors(expression);
	}
	
	@Test
	public void testOperationFeatureCall_13() throws Exception {
		XExpression expression = expression("{ var Iterable<String> x = <String[]>newArrayList('a,b'.split(',')).flatten }");
		helper.assertError(expression, XFEATURE_CALL, INCOMPATIBLE_TYPES,  
				"cannot convert from ArrayList<String[]> to Iterable<? extends Iterable<? extends String>>");
	}
	
	@Test
	public void testOperationFeatureCall_14() throws Exception {
		XExpression expression = expression("{ var Iterable<String> x = newArrayList('a,b'.split(','), 'a,b'.split(',')).flatten }");
		helper.assertError(expression, XFEATURE_CALL, INCOMPATIBLE_TYPES, 
				"cannot convert from ArrayList<String[]> to Iterable<? extends Iterable<? extends String>>");
	}
	
	@Test public void testStaticFeatureAccess_0() throws Exception {
		XExpression expression = expression("String::valueOf('')");
		helper.assertNoErrors(expression);
	}
	
	@Ignore("Currently the reference cannot be resolved at all. See bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=409849") 
	@Test public void testStaticFeatureAccess_1() throws Exception {
		XExpression expression = expression("String::hashCode()");
		helper.assertError(expression, XABSTRACT_FEATURE_CALL, STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}
	
	@Test public void testStaticFeatureAccess_2() throws Exception {
		XExpression expression = expression("''.valueOf('')");
		helper.assertError(expression, XABSTRACT_FEATURE_CALL, INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}
	
	@Test public void testNullSafeOnPrimitiveReveiver() throws Exception {
		XExpression expression = expression("1?.toString()");
		helper.assertError(expression, XABSTRACT_FEATURE_CALL, NULL_SAFE_FEATURE_CALL_ON_PRIMITIVE);
	}
	
	@Test public void testNullSafeOnPrimitiveFeature() throws Exception {
		XExpression expression = expression("#[]?.empty");
		helper.assertWarning(expression, XABSTRACT_FEATURE_CALL, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
	@Test public void testElvisOnPrimitiveReveiver() throws Exception {
		XExpression expression = expression("{ val int x=42 x?:''");
		helper.assertError(expression, XBINARY_OPERATION, PRIMITIVE_COMPARED_TO_NULL);
	}
	
	@Test public void testPrimitiveEqualsNull_0() throws Exception {
		XExpression expression = expression("{ val int x=42 x==null");
		helper.assertError(expression, XBINARY_OPERATION, PRIMITIVE_COMPARED_TO_NULL);
	}
	
	@Test public void testPrimitiveEqualsNull_1() throws Exception {
		XExpression expression = expression("{ val int x=42 null==x");
		helper.assertError(expression, XBINARY_OPERATION, PRIMITIVE_COMPARED_TO_NULL);
	}
	
	@Test public void testPrimitiveEqualsNull_2() throws Exception {
		XExpression expression = expression("{ val int x=42 x===null");
		helper.assertError(expression, XBINARY_OPERATION, PRIMITIVE_COMPARED_TO_NULL);
	}
	
	@Test public void testPrimitiveEqualsNull_3() throws Exception {
		XExpression expression = expression("{ val int x=42 null===x");
		helper.assertError(expression, XBINARY_OPERATION, PRIMITIVE_COMPARED_TO_NULL);
	}
	
	@Test public void testObjectEqualsNull_01() throws Exception {
		XExpression expression = expression("{ val Object x = null x==null");
		helper.assertNoIssue(expression, XBINARY_OPERATION, EQUALS_WITH_NULL);
	}
	
	@Test public void testObjectEqualsNull_02() throws Exception {
		XExpression expression = expression("{ val Object x = null x!=null");
		helper.assertNoIssue(expression, XBINARY_OPERATION, EQUALS_WITH_NULL);
	}
	
	@Test public void testObjectEqualsNull_03() throws Exception {
		XExpression expression = expression("{ val Object x = null x==null");
		helper.assertNoIssue(expression, XBINARY_OPERATION, EQUALS_WITH_NULL);
	}
	
	@Test public void testObjectEqualsNull_04() throws Exception {
		XExpression expression = expression("{ val Object x = null x!=null");
		helper.assertNoIssue(expression, XBINARY_OPERATION, EQUALS_WITH_NULL);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350934
	 */
	@Test
	public void testBug_350934_01() throws Exception {
		XExpression expression = expression("'3'>3");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350934
	 */
	@Test
	public void testBug_350934_02() throws Exception {
		XExpression expression = expression("'true'<false");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350934
	 */
	@Test
	public void testBug_350934_03() throws Exception {
		XExpression expression = expression("true>=0"); 
		helper.assertError(expression, XNUMBER_LITERAL, INCOMPATIBLE_TYPES, "cannot convert from int to boolean");
	}

	@Test
	public void testBug_350934_04() throws Exception {
		XExpression expression = expression("{ val z = 1bd val y = 2bi val abc = z * y }"); 
		helper.assertError(expression, XFEATURE_CALL, INCOMPATIBLE_TYPES, "BigInteger", "BigDecimal");
	}
	
	@Test public void testListExtensionsMap_01() throws Exception {
		XExpression expression = expression("" +
				"{\n" + 
				"    var java.util.List<String> list = null;\n" + 
				"    list.map(e|e.toUpperCase)\n" +
				"}");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testListExtensionsMap_02() throws Exception {
//		java.util.List<? extends String> list = null;
//		org.eclipse.xtext.xbase.lib.Functions.Function1<String, String> fun = new org.eclipse.xtext.xbase.lib.Functions.Function1<String, String>() {
//			public String apply(String p) {
//				return null;
//			}
//		};
//		org.eclipse.xtext.xbase.lib.ListExtensions.map(list, fun);
		XExpression expression = expression("" +
				"{\n" + 
				"    var java.util.List<? extends String> list = null;\n" + 
				"    list.map(e|e.toUpperCase)\n" +
				"}");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testListExtensionsMap_03() throws Exception {
//		java.util.List<? super String> list = null;
//		org.eclipse.xtext.xbase.lib.Functions.Function1<Object, Boolean> fun = new org.eclipse.xtext.xbase.lib.Functions.Function1<Object, Boolean>() {
//			public Boolean apply(Object p) {
//				return true;
//			}
//		};
//		org.eclipse.xtext.xbase.lib.ListExtensions.map(list, fun);
		XExpression expression = expression("" +
				"{\n" + 
				"    var java.util.List<? super CharSequence> list = null;\n" + 
				"    list.map(e|e == null)\n" +
				"}");
		helper.assertNoErrors(expression);
	}
	
	@Test
	@Ignore("TODO improve error message - shouldn't be Could not resolve reference")
	public void testInvalidReceiverForExtension_01() throws Exception {
		XExpression expression = expression("''.toList");
		helper.assertError(expression, XbasePackage.Literals.XMEMBER_FEATURE_CALL, INCOMPATIBLE_TYPES, "Iterable<Object>", "Object[]", "String", "receiver");
	}
	
	@Test
	@Ignore("TODO improve error message - shouldn't be Could not resolve reference")
	public void testInvalidReceiverForExtension_02() throws Exception {
		XExpression expression = expression("{ var it = '' toList }");
		helper.assertError(expression, XbasePackage.Literals.XFEATURE_CALL, INCOMPATIBLE_TYPES, "Iterable<Object>", "Object[]", "String", "first", "argument");
	}
	
	@Test
	public void testJavaStyleTypeCast() throws Exception {
		XExpression expression = expression("{ val y = \"blabla\" val x = (String) y }");
		helper.assertError(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST, -1, "(String)".length());
	}
	
	@Test
	public void testJavaStyleTypeCast_2() throws Exception {
		XExpression expression = expression("{ val y = \"blabla\" val x = ((String)) y }");
		helper.assertError(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST,  -1, "((String))".length());
	}
	
	@Test
	public void testJavaStyleTypeCast_3() throws Exception {
		XExpression expression = expression("{ val y = \"blabla\" val x = ((java.lang.String)) y }");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, JAVA_STYLE_TYPE_CAST,  -1, "((java.lang.String))".length());
	}
	
	@Test
	public void testJavaStyleTypeCast_4() throws Exception {
		XExpression expression = expression("{ val y = \"blabla\" val x = (String); y }");
		helper.assertNoErrors(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST);
	}
	
	@Test
	public void testJavaStyleTypeCast_5() throws Exception {
		XExpression expression = expression("{ val y = \"blabla\" val x = (\"blabla\" + String) y }");
		helper.assertNoErrors(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST);
	}
	
	@Test
	public void testJavaStyleTypeCast_6() throws Exception {
		XExpression expression = expression("{ val y = \"blabla\" val x = ((String) y) }");
		helper.assertNoErrors(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST);
	}
	
	@Test
	public void testJavaStyleTypeCast_7() throws Exception {
		XExpression expression = expression("{ val x = (String) }");
		helper.assertNoErrors(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST);
	}
	
	@Test
	public void testJavaStyleTypeCast_8() throws Exception {
		XExpression expression = expression("[ val y = \"blabla\" val x = (String) y ]");
		helper.assertError(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST, -1, "(String)".length());
	}
	
	@Test
	public void testJavaStyleTypeCast_9() throws Exception {
		XExpression expression = expression("[ val y = \"blabla\" val x = ((String)) y ]");
		helper.assertError(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST,  -1, "((String))".length());
	}
	
	@Test
	public void testJavaStyleTypeCast_10() throws Exception {
		XExpression expression = expression("[ val y = \"blabla\" val x = ((java.lang.String)) y ]");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, JAVA_STYLE_TYPE_CAST,  -1, "((java.lang.String))".length());
	}
	
	@Test
	public void testJavaStyleTypeCast_11() throws Exception {
		XExpression expression = expression("[ val y = \"blabla\" val x = (String); y ]");
		helper.assertNoErrors(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST);
	}
	
	@Test
	public void testJavaStyleTypeCast_12() throws Exception {
		XExpression expression = expression("[ val y = \"blabla\" val x = (\"blabla\" + String) y ]");
		helper.assertNoErrors(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST);
	}
	
	@Test
	public void testJavaStyleTypeCast_13() throws Exception {
		XExpression expression = expression("[ val y = \"blabla\" val x = ((String) y) ]");
		helper.assertNoErrors(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST);
	}
	
	@Test
	public void testJavaStyleTypeCast_14() throws Exception {
		XExpression expression = expression("[ val x = (String) ]");
		helper.assertNoErrors(expression, XFEATURE_CALL, JAVA_STYLE_TYPE_CAST);
	}
	
}
