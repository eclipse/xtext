/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.annotations;

import java.util.List;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AnnotationsValidatorTest extends AbstractXbaseWithAnnotationsTest {
	
	@Inject 
	protected ValidationTestHelper validator;
	
	@Test public void testTypeConformance_01() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2('foo')", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testTypeConformance_02() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = 'foo')", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testTypeConformance_05() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(true)", false);
		validator.assertError(annotation, XbasePackage.Literals.XBOOLEAN_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, 
				"cannot convert from boolean to String | String[]");
	}
	
	@Test public void testTypeConformance_06() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = 42)", false);
		validator.assertError(annotation, XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String | String[]", "int");
	}
	
	@Test public void testTypeConformance_09() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation1(true)", false);
		validator.assertError(annotation, XAnnotationsPackage.Literals.XANNOTATION, IssueCodes.ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION, "children");
	}
	
	@Test public void testTypeConformance_10() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation1(value = true , children = @testdata.Annotation2('foo'), foo = 'bar' )", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testTypeConformance_11() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation1(value = true , children = @testdata.Annotation2(true), foo = 'bar' )", false);
		validator.assertError(annotation, XbasePackage.Literals.XBOOLEAN_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String[]", "boolean");
	}
	
	@Test public void testTypeConformance_13() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(#['foo'])", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testTypeConformance_14() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = #['foo'])", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testTypeConformance_15() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(#[typeof(String)])", false);
		validator.assertError(annotation, XbasePackage.Literals.XTYPE_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String", "Class<String>");
	}
	
	@Test public void testTypeConformance_16() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = #[true])", false);
		validator.assertError(annotation, XbasePackage.Literals.XBOOLEAN_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String", "boolean");
	}
	
	@Test public void testTypeConformance_17() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = #['', true, 1, ''])", false);
		validator.assertError(annotation, XbasePackage.Literals.XBOOLEAN_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String", "boolean");
		validator.assertError(annotation, XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String", "int");
	}
	
	@Test public void testConstantExpression_0() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = #['' + ''])", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testConstantExpression_1() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = #['foo'.replace('foo', 'bar')])", false);
		validator.assertError(annotation, XbasePackage.Literals.XLIST_LITERAL, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE, "constant");
	}
	
	@Test public void testConstantExpression_2() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = #['foo'.replace('foo', 'bar')])", false);
		validator.assertError(annotation, XbasePackage.Literals.XLIST_LITERAL, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE, "constant");
	}
	
	@Test public void testConstantExpression_3() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = #['foo' + ('foo' as Object))])", false);
		validator.assertError(annotation, XbasePackage.Literals.XLIST_LITERAL, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE, "constant");
	}
	
	@Test public void testConstantExpression_4() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = #['foo' + 'foo'.toString])", false);
		validator.assertError(annotation, XbasePackage.Literals.XLIST_LITERAL, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE, "constant");
	}
	
	@Test public void testConstantExpression_5() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = #['' + ''])", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testConstantExpression_6() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation3("
				+ "booleanValue = true,"
				+ "intValue = 1,"
				+ "longValue = 42,"
				+ "stringValue = 'foo',"
				+ "booleanArrayValue = #[true],"
				+ "intArrayValue = #[1],"
				+ "longArrayValue = #[42],"
				+ "stringArrayValue = #['foo'],"
				+ "typeValue = String,"
				+ "typeArrayValue = #[String],"
				+ "annotation2Value = @testdata.Annotation2(#['foo']),"
				+ "annotation2ArrayValue = #[@testdata.Annotation2(#['foo'])],"
				+ "enumValue = testdata.Enum1.RED,"
				+ "enumArrayValue = #[testdata.Enum1.RED]"
				+ ")", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testConstantExpression_7() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation3("
				+ "intValue = 1 + 4 + 6 * 42 - 4 / 45,"
				+ "longValue = 42 + 4 + 6 * 42 - testdata.Constants1.INT_CONSTANT / 45,"
				+ "stringValue = 'foo' + 'baz',"
				+ "booleanArrayValue = #[true, false],"
				+ "intArrayValue = #[ -1, 34 + 45, 2 - 6 ],"
				+ "longArrayValue = #[42, 5 * -3],"
				+ "stringArrayValue = #['foo', 'bla' + 'buzz'],"
				+ "typeValue = String,"
				+ "typeArrayValue = #[String, Integer],"
				+ "annotation2Value = @testdata.Annotation2(#['foo' + 'wuppa']),"
				+ "annotation2ArrayValue = #[@testdata.Annotation2(#['foo']), @testdata.Annotation2(#['foo'+'wuppa'])]"
				+ ")", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testConstantExpression_8() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation3("
				+ "intValue = 'foo'.length,"
				+ ")", false);
		validator.assertError(annotation, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE, "constant");
	}
	
	
	@Test public void testConstantExpression_9() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation3("
				+ "typeValue = 'foo'.class,"
				+ ")", false);
		validator.assertError(annotation, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE, "constant");
	}
	
	@Test public void testConstantExpression_10() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation3("
				+ "intValue = testdata.Constants1.NOT_A_INT_CONSTANT,"
				+ ")", false);
		validator.assertError(annotation, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE, "constant");
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=398086
	 */
	@Test public void testBug398086() throws Exception {
		XAnnotation annotation = annotation("@SuppressWarnings(('' + 1 + 2)) ", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testEmptyValueList_03() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = #[])", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testEmptyValueList_04() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(#[])", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testBooleanArrayInsteadOfPrimitive_01() throws Exception {
		XAnnotation annotation = annotation("@com.google.inject.Inject(optional=#[true])", false);
		validator.assertError(annotation, XbasePackage.Literals.XLIST_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from boolean[] to boolean");
	}
	
	@Test public void testIntArrayInsteadOfPrimitiveBoolean_01() throws Exception {
		XAnnotation annotation = annotation("@com.google.inject.Inject(optional=#[1])", false);
		validator.assertError(annotation, XbasePackage.Literals.XLIST_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from int[] to boolean");
	}
	
	@Test public void testNoOperationFound() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(toString = true)", false);
		validator.assertNoError(annotation, IssueCodes.INCOMPATIBLE_TYPES);
		// TODO use better error message like in Java (e.g. Annotation A does not define an attribute b)
		validator.assertError(annotation, XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR, Diagnostic.LINKING_DIAGNOSTIC);
		validator.assertError(annotation, XAnnotationsPackage.Literals.XANNOTATION, IssueCodes.ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION, "attribute 'value'");
	}
	
	@Test public void testReferencedTypeIsNoEnum() throws Exception {
		XAnnotation annotation = annotation("@java.lang.Object(unknown = #[ new String() ])", false);
		List<Issue> issues = validator.validate(annotation);
		assertEquals(issues.toString(), 1, issues.size());
		Issue singleIssue = issues.get(0);
		assertEquals(IssueCodes.INCOMPATIBLE_TYPES, singleIssue.getCode());
		assertEquals(1, singleIssue.getOffset().intValue());
		assertEquals("java.lang.Object".length(), singleIssue.getLength().intValue());
	}
	
}
