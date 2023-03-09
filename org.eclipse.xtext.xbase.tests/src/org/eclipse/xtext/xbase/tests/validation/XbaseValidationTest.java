/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.validation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class XbaseValidationTest extends AbstractXbaseTestCase {
	@Inject
	private ValidationTestHelper validationTestHelper;

	@Test
	public void testForwardReferenceToLocalVar() throws Exception {
		validationTestHelper.assertError(expression("{ val (int)=>int fun = [ fun.apply(it) ] }\n"),
				XbasePackage.Literals.XFEATURE_CALL, IssueCodes.ILLEGAL_FORWARD_REFERENCE,
				"The local variable fun may not have been initialized");
	}

	@Test
	public void testDuplicateCases_typeLiteral() throws Exception {
		validationTestHelper.assertError(expression(
				"switch x : String {\n" +
				"	case String: 1\n" +
				"	case String: 1\n" +
				"}\n"),
				XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_typeLiteral_2() throws Exception {
		XExpression expression = expression(
				"switch x : String {\n" +
				"	case String: 1\n" +
				"	case typeof(String): 1\n" +
				"}\n");
		validationTestHelper.assertError(expression, XbasePackage.Literals.XTYPE_LITERAL, IssueCodes.DUPLICATE_CASE);
		validationTestHelper.assertError(expression, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_typeLiteral_3() throws Exception {
		validationTestHelper.assertError(
				expression(
				"switch x : String {\n" +
				"	case typeof(String): 1\n" +
				"	case typeof(String): 1\n" +
				"}\n"),
				XbasePackage.Literals.XTYPE_LITERAL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_typeLiteral_4() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"switch x : String {\n" +
				"	case typeof(Integer): 1\n" +
				"	case typeof(String): 1\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_typeLiteral_5() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"switch x : String {\n" +
				"	case Integer: 1\n" +
				"	case typeof(String): 1\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_typeLiteral_6() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"switch x : String {\n" +
				"	case Integer: 1\n" +
				"	case String: 1\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_typeLiteral_7() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"switch x : String {\n" +
				"	case 'java.lang.String': 1\n" +
				"	case String: 1\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_boolean() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"switch x : true {\n" +
				"	case false: 1\n" +
				"	case false: 1\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_int() throws Exception {
		validationTestHelper.assertError(expression(
				"switch x : 1 {\n" +
				"	case 1: 1\n" +
				"	case 1: 1\n" +
				"}\n"),
				XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_int_2() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"switch x : 1 {\n" +
				"	case 1: 1\n" +
				"	case 2: 2\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_int_3() throws Exception {
		validationTestHelper.assertError(expression(
				"{\n" +
				"	val int a = 1\n" +
				"	val char b = 1 as char\n" +
				"	val byte c = 1 as byte\n" +
				"	val short d = 1 as short\n" +
				"	switch x : 1 {\n" +
				"		case a: 1\n" +
				"		case b: 1\n" +
				"		case c: 1\n" +
				"		case d: 1\n" +
				"	}\n" +
				"}\n"),
				XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_int_4() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"{\n" +
				"	val int a = 1\n" +
				"	val char b = 2 as char\n" +
				"	val byte c = 3 as byte\n" +
				"	val short d = 4 as short\n" +
				"	switch x : 1 {\n" +
				"		case a: 1\n" +
				"		case b: 2\n" +
				"		case c: 3\n" +
				"		case d: 4\n" +
				"	}\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_int_5() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"{\n" +
				"	switch x : 1 {\n" +
				"		case 1: 1\n" +
				"		case [|1].apply: 1\n" +
				"	}\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_int_6() throws Exception {
		validationTestHelper.assertError(
				expression(
				"{\n" +
				"	val Integer x = 1\n" +
				"	switch x {\n" +
				"		Integer case 1: 1\n" +
				"		Integer case 1: 1\n" +
				"	}\n" +
				"}\n"),
				XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_int_7() throws Exception {
		validationTestHelper.assertError(
				expression(
				"{\n" +
				"	val Integer x = 1\n" +
				"	switch x {\n" +
				"		Integer case 1: 1\n" +
				"		case 1: 1\n" +
				"	}\n" +
				"}\n"),
				XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_int_8() throws Exception {
		validationTestHelper.assertError(expression(
				"{\n" +
				"	switch x : 1 {\n" +
				"		case x: ''\n" +
				"		case x: '1'\n" +
				"	}\n" +
				"}\n"),
				XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_enum() throws Exception {
		validationTestHelper.assertError(
				expression(
				"{\n" +
				"	switch x : Thread.State.NEW {\n" +
				"		case NEW: 1\n" +
				"		case NEW: 1\n" +
				"	}\n" +
				"}\n"),
				XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_enum_2() throws Exception {
		validationTestHelper.assertError(
				expression(
				"{\n" +
				"	switch x : Thread.State.NEW {\n" +
				"		case NEW: 1\n" +
				"		case Thread.State.NEW: 1\n" +
				"	}\n" +
				"}\n"),
				XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_enum_3() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"{\n" +
				"	val state = Thread.State.NEW\n" +
				"	switch x : Thread.State.NEW {\n" +
				"		case NEW: 1\n" +
				"		case state: 1\n" +
				"	}\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_enum_4() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"{\n" +
				"	switch x : Thread.State.NEW {\n" +
				"		case NEW: 1\n" +
				"		case RUNNABLE: 2\n" +
				"	}\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_double() throws Exception {
		validationTestHelper.assertError(expression(
				"switch x : 1d {\n" +
				"	case 1: 1\n" +
				"	case 1: 1\n" +
				"}\n"),
				XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_double_2() throws Exception {
		validationTestHelper.assertError(expression(
				"switch x : 1.5d {\n" +
				"	case 1.5d: 1\n" +
				"	case 1.5d: 1\n" +
				"}\n"),
				XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_double_3() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"switch x : 1.5d {\n" +
				"	case 1.5d: 1\n" +
				"	case 1.6d: 1\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_number() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"switch x : 1 {\n" +
				"	case 1: 1\n" +
				"	case 1l: 1\n" +
				"	case 1f: 1\n" +
				"	case 1d: 1\n" +
				"}\n"));
	}

	@Test
	public void testDuplicateCases_string() throws Exception {
		validationTestHelper.assertError(expression(
				"switch x : 'lalala' {\n" +
				"	case 'A': 1\n" +
				"	case 'A': 1\n" +
				"}\n"),
				XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testDuplicateCases_object() throws Exception {
		validationTestHelper.assertError(expression(
				"switch x : new Object {\n" +
				"	case 'A': 1\n" +
				"	case 'A': 1\n" +
				"}\n"),
				XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.DUPLICATE_CASE);
	}

	@Test
	public void testUnreachableCase() throws Exception {
		validationTestHelper.assertError(
				expression(
						"switch x : new Exception {\n" +
				"	Exception: 1\n" +
				"	java.io.IOException: 2\n" +
				"	java.io.FileNotFoundException: 3\n" +
				"}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
	}

	@Test
	public void testUnreachableCase_2() throws Exception {
		validationTestHelper.assertError(
				expression(
						"switch x : new Exception {\n" +
				"	java.io.IOException: 2\n" +
				"	Exception: 1\n" +
				"	java.io.FileNotFoundException: 3\n" +
				"}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
	}

	@Test
	public void testUnreachableCase_3() throws Exception {
		validationTestHelper.assertError(
				expression(
						"switch x : new Exception {\n" +
				"	java.io.IOException: 2\n" +
				"	java.io.FileNotFoundException: 3\n" +
				"	Exception: 1\n" +
				"}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
	}

	@Test
	public void testUnreachableCase_4() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"switch x : new Exception {\n" +
				"	java.io.FileNotFoundException: 3\n" +
				"	java.io.IOException: 2\n" +
				"	Exception: 1\n" +
				"}\n"));
	}

	@Test
	public void testUnreachableCase_5() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"switch x : new Exception {\n" +
				"	Exception case true: 1\n" +
				"	java.io.IOException case false: 2\n" +
				"	java.io.FileNotFoundException: 3\n" +
				"}\n"));
	}

	@Test
	public void testUnreachableCase_6() throws Exception {
		validationTestHelper.assertError(expression(
				"switch new java.util.ArrayList<String> {\n" +
				"	java.util.List<Integer>: 'list of integers'\n" +
				"	java.util.List<String>: 'list of strings'\n" +
				"	default: 'something else'\n" +
				"}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
	}

	@Test
	public void testUnreachableCase_7() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"switch new java.util.ArrayList<String> {\n" +
				"	java.util.List<Integer>: 'list of integers'\n" +
				"	java.util.Set<String>: 'set of strings'\n" +
				"	default: 'something else'\n" +
				"}\n"));
	}

	@Test
	public void testUnreachableCase_8() throws Exception {
		validationTestHelper.assertError(expression(
				"switch new java.util.ArrayList<String> {\n" +
				"	java.util.List: 'list of integers'\n" +
				"	java.util.List<String>: 'list of strings'\n" +
				"	default: 'something else'\n" +
				"}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
	}

	@Test
	public void testUnreachableCatchClause() throws Exception {
		validationTestHelper.assertError(expression(
				"try {\n" +
				"	\n" +
				"} catch (Exception e) {\n" +
				"	\n" +
				"} catch (java.io.IOException e) {\n" +
				"	\n" +
				"} catch (java.io.FileNotFoundException e) {\n" +
				"	\n" +
				"}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK);
	}

	@Test
	public void testUnreachableCatchClause_2() throws Exception {
		validationTestHelper.assertError(expression(
				"try {\n" +
				"	\n" +
				"} catch (java.io.IOException e) {\n" +
				"	\n" +
				"} catch (Exception e) {\n" +
				"	\n" +
				"} catch (java.io.FileNotFoundException e) {\n" +
				"	\n" +
				"}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK);
	}

	@Test
	public void testUnreachableCatchClause_3() throws Exception {
		validationTestHelper.assertError(expression(
				"try {\n" +
				"	\n" +
				"} catch (java.io.IOException e) {\n" +
				"\n} catch (java.io.FileNotFoundException e) {\n" +
				"	\n" +
				"} catch (Exception e) {\n" +
				"	\n" +
				"}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK);
	}

	@Test
	public void testUnreachableCatchClause_4() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"try {\n" +
				"	\n" +
				"} catch (java.io.FileNotFoundException e) {\n" +
				"	\n" +
				"} catch (java.io.IOException e) {\n" +
				"\n} catch (Exception e) {\n" +
				"	\n" +
				"}\n"));
	}

	@Test
	public void testUnreachableInstanceOf() throws Exception {
		validationTestHelper.assertError(expression(
				"		{\n" +
				"val x = new Object\n" +
				"if (x instanceof Exception) {\n" +
				"	1\n" +
				"} else if (x instanceof java.io.IOException) {\n" +
				"	2\n" +
				"} else if (x instanceof java.io.FileNotFoundException) {\n" +
				"	3\n" +
				"}\n" +
				"		}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
	}

	@Test
	public void testUnreachableInstanceOf_2() throws Exception {
		validationTestHelper.assertError(expression(
				"		{\n" +
				"val x = new Object\n" +
				"if (x instanceof java.io.IOException) {\n" +
				"	2\n" +
				"} else if (x instanceof Exception) {\n" +
				"	1\n" +
				"} else if (x instanceof java.io.FileNotFoundException) {\n" +
				"	3\n" +
				"}\n" +
				"		}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
	}

	@Test
	public void testUnreachableInstanceOf_3() throws Exception {
		validationTestHelper.assertError(expression(
				"		{\n" +
				"val x = new Object\n" +
				"if (x instanceof java.io.IOException) {\n" +
				"	2\n" +
				"} else if (x instanceof java.io.FileNotFoundException) {\n" +
				"	3\n" +
				"} else if (x instanceof Exception) {\n" +
				"	1\n" +
				"}\n" +
				"		}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
	}

	@Test
	public void testUnreachableInstanceOf_4() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"		{\n" +
				"val x = new Object\n" +
				"if (x instanceof java.io.FileNotFoundException) {\n" +
				"	3\n" +
				"} else if (x instanceof java.io.IOException) {\n" +
				"	2\n" +
				"} else if (x instanceof Exception) {\n" +
				"	1\n" +
				"}\n" +
				"		}\n"));
	}

	@Test
	public void testUnreachableInstanceOf_5() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"		{\n" +
				"val x = new Object\n" +
				"if (x instanceof Exception && true) {\n" +
				"	1\n" +
				"} else if (x instanceof java.io.IOException && false) {\n" +
				"	2\n" +
				"} else if (x instanceof java.io.FileNotFoundException) {\n" +
				"	3\n" +
				"}\n" +
				"		}\n"));
	}

	@Test
	public void testUnreachableInstanceOf_6() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"		{\n" +
				"val x = new Object\n" +
				"if (x instanceof java.util.List) {\n" +
				"	1\n" +
				"} else if (x instanceof int[]) {\n" +
				"	2\n" +
				"}\n" +
				"		}\n"));
	}

	@Test
	public void testUnreachableInstanceOf_7() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"		{\n" +
				"val x = new Object\n" +
				"val y = new Object\n" +
				"if (x instanceof java.io.IOException) {\n" +
				"	1\n" +
				"} else if (y instanceof java.io.FileNotFoundException) {\n" +
				"	2\n" +
				"}\n" +
				"		}\n"));
	}

	@Test
	public void testUnreachableInstanceOf_8() throws Exception {
		validationTestHelper.assertError(expression(
				"		{\n" +
				"val x = new Object\n" +
				"val y = new Object\n" +
				"if (x instanceof java.io.IOException) {\n" +
				"	1\n" +
				"} else if (y instanceof java.io.IOException) {\n" +
				"	2\n" +
				"} else if (x instanceof java.io.FileNotFoundException) {\n" +
				"	3\n" +
				"} else if (y instanceof java.io.FileNotFoundException) {\n" +
				"	4\n" +
				"}\n" +
				"		}\n"),
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
	}

	@Test
	public void testIncompleteCasesOnEnum() throws Exception {
		validationTestHelper.assertWarning(
				expression(
						"		{\n" +
				"switch org.eclipse.xtext.xbase.tests.validation.Color.RED {\n" +
				"	case RED: {\n" +
				"		1\n" +
				"	}\n" +
				"}\n" +
				"		}\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
	}

	@Test
	public void testIncompleteCasesOnEnum_2() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"		{\n" +
				"switch org.eclipse.xtext.xbase.tests.validation.Color.RED {\n" +
				"	case RED: {\n" +
				"		1\n" +
				"	}\n" +
				"	case GREEN: {\n" +
				"		1\n" +
				"	}\n" +
				"	case BLUE: {\n" +
				"		1\n" +
				"	}\n" +
				"}\n" +
				"		}\n"));
	}

	@Test
	public void testIncompleteCasesOnEnum_3() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"		{\n" +
				"val y = Integer.valueOf('1')\n" +
				"switch org.eclipse.xtext.xbase.tests.validation.Color.RED {\n" +
				"	case RED: {\n" +
				"		1\n" +
				"	}\n" +
				"	case y == 2: {\n" +
				"		2\n" +
				"	}\n" +
				"}\n" +
				"		}\n"));
	}

	@Test
	public void testIncompleteCasesOnEnum_4() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"		{\n" +
				"switch org.eclipse.xtext.xbase.tests.validation.Color.RED {\n" +
				"	case RED: {\n" +
				"		1\n" +
				"	}\n" +
				"	default: {\n" +
				"		2\n" +
				"	}\n" +
				"}\n" +
				"		}\n"));
	}

	@Test
	public void testIncompleteCasesOnEnum_5() throws Exception {
		validationTestHelper.assertWarning(
				expression(
				"		{\n" +
				"switch org.eclipse.xtext.xbase.tests.validation.Color.RED {\n" +
				"}\n" +
				"		}\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
	}

	@Test
	public void testIncompleteCasesOnEnum_6() throws Exception {
		validationTestHelper.assertNoIssues(this
				.expression(
				"		{\n" +
				"switch org.eclipse.xtext.xbase.tests.validation.Color.RED {\n" +
				"	default: {\n" +
				"		1\n" +
				"	}\n" +
				"}\n" +
				"		}\n"));
	}

	@Test
	public void testIncompleteCasesOnEnum_7() throws Exception {
		validationTestHelper.assertWarning(expression(
				"		{\n" +
				"switch org.eclipse.xtext.xbase.tests.validation.Color x : org.eclipse.xtext.xbase.tests.validation.Color.RED {\n" +
				"}\n" +
				"		}\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
	}

	@Test
	public void testIncompleteCasesOnEnum_8() throws Exception {
		validationTestHelper.assertWarning(expression(
				"		{\n" +
				"switch (org.eclipse.xtext.xbase.tests.validation.Color x : org.eclipse.xtext.xbase.tests.validation.Color.RED) {\n" +
				"}\n" +
				"		}\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
	}

	@Test
	public void testIncompleteCasesOnEnum_9() throws Exception {
		validationTestHelper.assertNoIssue(
				expression(
				"		{\n" +
				"switch Object x : org.eclipse.xtext.xbase.tests.validation.Color.RED {\n" +
				"}\n" +
				"		}\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
	}

	@Test
	public void testIncompleteCasesOnEnum_10() throws Exception {
		validationTestHelper.assertNoIssue(
				expression(
				"		{\n" +
				"switch (Object x : org.eclipse.xtext.xbase.tests.validation.Color.RED) {\n" +
				"}\n" +
				"		}\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
	}

	@Test
	public void testIncompleteCasesOnEnum_11() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"		{\n" +
				"val Enum<?> e = null\n" +
				"switch(e) {\n" +
				"	java.lang.annotation.RetentionPolicy: e.toString\n" +
				"	java.lang.annotation.ElementType: e.toString\n" +
				"}\n" +
				"		}\n"));
	}

	@Test
	public void testSwitchNoParameter() throws Exception {
		XExpression block = expression(
				"{\n" +
				"	switch 'lalala' {\n" +
				"	}\n" +
				"}\n");
		validationTestHelper.assertNoIssues(block);
	}

	@Test
	public void testSwitchDeclaredParameter() throws Exception {
		XExpression block = expression(
				"{\n" +
				"	switch Object x : 'lalala' {\n" +
				"	}\n" +
				"}\n");
		validationTestHelper.assertNoErrors(block);
		validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
	}

	@Test
	public void testSwitchDeclaredParameter_1() throws Exception {
		XExpression block = expression(
				"{\n" +
				"	switch String x : 'lalala' {\n" +
				"	}\n" +
				"}\n");
		validationTestHelper.assertNoErrors(block);
		validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
	}

	@Test
	public void testSwitchDeclaredParameter_2() throws Exception {
		XExpression block = expression(
				"{\n" +
				"	switch Integer x : 'lalala' {\n" +
				"	}\n" +
				"}\n");
		validationTestHelper.assertError(block, XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
		validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
	}

	@Test
	public void testSwitchDeclaredParameter_3() throws Exception {
		XExpression block = expression(
				"{\n" +
				"	switch (Object x : 'lalala') {\n" +
				"	}\n" +
				"}\n");
		validationTestHelper.assertNoErrors(block);
		validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
	}

	@Test
	public void testSwitchDeclaredParameter_4() throws Exception {
		XExpression block = expression(
				"{\n" +
				"	switch (String x : 'lalala') {\n" +
				"	}\n" +
				"}\n");
		validationTestHelper.assertNoErrors(block);
		validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
	}

	@Test
	public void testSwitchDeclaredParameter_5() throws Exception {
		XExpression block = expression(
				"{\n" +
				"	switch (Integer x : 'lalala') {\n" +
				"	}\n" +
				"}\n");
		validationTestHelper.assertError(block, XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
		validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
	}

	@Test
	public void testBasicForLoop_InvalidInnerExpression() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"		{\n" +
				"for(var condition = true; condition;) {\n" +
				"}\n" +
				"		}\n"));
	}

	@Test
	public void testBasicForLoop_UnusedVariable() throws Exception {
		validationTestHelper.assertWarning(expression(
				"		{\n" +
				"for(var condition = true;;) {\n" +
				"}\n" +
				"		}\n"),
				XbasePackage.Literals.XVARIABLE_DECLARATION, IssueCodes.UNUSED_LOCAL_VARIABLE);
	}

	@Test
	public void testSynchronizedExpression_1() throws Exception {
		validationTestHelper.assertError(expression(
				"{\n" +
				"	synchronized (1 + 2) {\n" +
				"	}\n" +
				"}\n"),
				XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testSynchronizedExpression_2() throws Exception {
		validationTestHelper.assertError(expression(
				"{\n" +
				"	synchronized (null) {\n" +
				"	}\n" +
				"}\n"), XbasePackage.Literals.XNULL_LITERAL,
				IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testSynchronizedExpression_3() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"{\n" +
				"	val x = Integer.valueOf(1)\n" +
				"	synchronized (x) {\n" +
				"	}\n" +
				"}\n"));
	}

	@Test
	public void testSynchronizedExpression_4() throws Exception {
		validationTestHelper.assertError(expression(
				"{\n" +
				"	val ()=>void x = [|]\n" +
				"	synchronized (x.apply) {\n" +
				"	}\n" +
				"}\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testSynchronizedExpression_5() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"{\n" +
				"	val ()=>int x = [|1]\n" +
				"	synchronized (x.apply) {\n" +
				"	}\n" +
				"}\n"));
	}

	@Test
	public void testSynchronizedExpression_6() throws Exception {
		validationTestHelper
				.assertNoIssues(expression(
				"{\n" +
				"	val ()=>Object x = [|new Object]\n" +
				"	synchronized (x.apply) {\n" +
				"	}\n" +
				"}\n"));
	}

	@Test
	public void testSynchronizedExpression_7() throws Exception {
		validationTestHelper.assertError(expression(
				"{\n" +
				"	val x = 1\n" +
				"	synchronized (x) {\n" +
				"	}\n" +
				"}\n"),
				XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testSynchronizedExpression_8() throws Exception {
		validationTestHelper.assertError(expression(
				"{\n" +
				"	val int x = synchronized (new Object) new Object\n" +
				"	x\n" +
				"}\n"),
				XbasePackage.Literals.XCONSTRUCTOR_CALL, IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testSynchronizedExpression_9() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"{\n" +
				"	val int x = synchronized (new Object) 1\n" +
				"	x\n" +
				"}\n"));
	}

	@Test
	public void testSynchronizedExpression_10() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"{\n" +
				"	val x = synchronized (new Object) new Object\n" +
				"	x\n" +
				"}\n"));
	}

	@Test
	public void testSynchronizedExpression_11() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"{\n" +
				"	val foo = 'lalala'\n" +
				"	synchronized (foo) {\n" +
				"	}\n" +
				"	foo\n" +
				"}\n"));
	}

	@Test
	public void testBug415770_01() throws Exception {
		validationTestHelper.assertError(
				expression(
				"		{\n" +
				"val String str = ''\n" +
				"val String[] array = null\n" +
				"str === array\n" +
				"		}\n"),
				XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INVALID_OPERAND_TYPES);
	}

	@Test
	public void testBug415770_02() throws Exception {
		validationTestHelper.assertError(
				expression(
				"		{\n" +
				"val String str = ''\n" +
				"val String[] array = null\n" +
				"str !== array\n" +
				"		}\n"),
				XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INVALID_OPERAND_TYPES);
	}

	@Test
	public void testBug415770_03() throws Exception {
		validationTestHelper.assertError(
				expression(
				"		{\n" +
				"val String str = ''\n" +
				"val String[] array = null\n" +
				"array === str\n" +
				"		}\n"),
				XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INVALID_OPERAND_TYPES);
	}

	@Test
	public void testBug415770_04() throws Exception {
		validationTestHelper.assertError(
				expression(
				"		{\n" +
				"val String str = ''\n" +
				"val String[] array = null\n" +
				"array !== str\n" +
				"		}\n"),
				XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INVALID_OPERAND_TYPES);
	}

	@Test
	public void testBug415770_05() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"		{\n" +
				"val String str = ''\n" +
				"str === 'SomeString'\n" +
				"		}\n"));
	}

	@Test
	public void testBug415770_06() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"		{\n" +
				"val String str = ''\n" +
				"str !== 'SomeString'\n" +
				"		}\n"));
	}

	@Test
	public void testBug415770_07() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"		{\n" +
				"val String[] array = null\n" +
				"val String[] array2 = null\n" +
				"array === array2\n" +
				"		}\n"));
	}

	@Test
	public void testBug415770_08() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"		{\n" +
				"val String[] array = null\n" +
				"val String[] array2 = null\n" +
				"array !== array2\n" +
				"		}\n"));
	}

	@Test
	public void testBug415770_09() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"		{\n" +
				"val String[] array = null\n" +
				"array !== null || array === null\n" +
				"		}\n"));
	}

	@Test
	public void testBug415770_10() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"		{\n" +
				"val Cloneable c = null\n" +
				"val String[] array = null\n" +
				"array !== c || array === c || c === array || c !== array\n" +
				"		}\n"));
	}

	@Test
	public void testBug415770_11() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"		{\n" +
				"val java.io.Serializable s = null\n" +
				"val String[] array = null\n" +
				"array !== s || array === s || s === array || s !== array\n" +
				"		}\n"));
	}

	@Test
	public void testBug415770_12() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"		{\n" +
				"val Object o = null\n" +
				"val String[] array = null\n" +
				"array !== o || array === o || o === array || o !== array\n" +
				"		}\n"));
	}

	@Test
	public void testNullSafePrimitiveNumber() throws Exception {
		validationTestHelper.assertWarning(expression(
				"		{\n" +
				"val x = ''?.hashCode\n" +
				"		}\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, "hashCode", "0");
	}

	@Test
	public void testNullSafePrimitiveBoolean() throws Exception {
		validationTestHelper.assertWarning(expression(
				"		{\n" +
				"val x = ''?.equals(null)\n" +
				"		}\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, "equals",
				"false");
	}

	@Test
	public void testBug444972_01() throws Exception {
		validationTestHelper.assertWarning(expression(
				"		{\n" +
				"val java.lang.annotation.RetentionPolicy x = null\n" +
				"val boolean b = switch x {\n" +
				"	case x.name == '': false\n" +
				"	case SOURCE: true\n" +
				"}\n" +
				"println(b)\n" +
				"		}\n"),
				XbasePackage.Literals.XSWITCH_EXPRESSION, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}

	@Test
	public void testBug444972_02() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"		{\n" +
				"val java.lang.annotation.RetentionPolicy x = null\n" +
				"val boolean b = switch x {\n" +
				"	case SOURCE,\n" +
				"	case CLASS,\n" +
				"	case RUNTIME: true\n" +
				"}\n" +
				"println(b)\n" +
				"		}\n"));
	}

	@Test
	public void testBug458742_01() throws Exception {
		validationTestHelper.assertNoIssues(expression(
				"{\n" +
				"	val list = #['foo']\n" +
				"	list?.add('bar')\n" +
				"	return false\n" +
				"}\n"));
	}

	@Test
	public void testBug458742_02() throws Exception {
		validationTestHelper.assertWarning(expression(
				"{\n" +
				"	val list = #['foo']\n" +
				"	list?.add('bar')\n" +
				"}\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE,
				"Null-safe call of primitive-valued feature");
	}

	@Test
	public void testBug458742_03() throws Exception {
		validationTestHelper.assertWarning(expression(
				"		    {\n" +
				"		    	val list = #['foo']\n" +
				"		        val b = list?.add('bar')\n" +
				"		        return b\n" +
				"		    }\n"),
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE,
				"Null-safe call of primitive-valued feature");
	}

	@Test
	public void testRedundantCases_01() throws Exception {
		validationTestHelper.assertError(expression(
				"switch i : 1 {\n" +
				"	case 1,\n" +
				"}\n"), XbasePackage.Literals.XCASE_PART,
				IssueCodes.REDUNDANT_CASE);
	}

	@Test
	public void testRedundantCases_02() throws Exception {
		validationTestHelper.assertError(expression(
				"switch i : 1 {\n" +
				"	case 1,\n" +
				"	case 2,\n" +
				"}\n"),
				XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE);
	}

	@Test
	public void testRedundantCases_03() throws Exception {
		validationTestHelper.assertWarning(expression(
				"switch i : 1 {\n" +
				"	case 1,\n" +
				"	default: 1\n" +
				"}\n"),
				XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE);
	}

	@Test
	public void testRedundantCases_04() throws Exception {
		validationTestHelper.assertWarning(expression(
				"switch i : 1 {\n" +
				"	case 1,\n" +
				"	case 2,\n" +
				"	default: 1\n" +
				"}\n"),
				XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE);
	}

	@Test
	public void testRedundantCases_05() throws Exception {
		validationTestHelper.assertNoIssue(expression(
				"switch i : 1 {\n" +
				"	case 1,\n" +
				"	case 2: 1\n" +
				"}\n"),
				XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE);
	}

	@Test
	public void testSetLiteralTypeMismatchBug498779() throws Exception {
		validationTestHelper.assertError(expression(
				"{\n" +
				"	val java.util.Set<String> set = #['']\n" +
				"}\n"),
				XbasePackage.Literals.XLIST_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testListLiteralTypeMismatchBug498779() throws Exception {
		validationTestHelper.assertError(expression(
				"{\n" +
				"	val java.util.List<String> list = #{''}\n" +
				"}\n"),
				XbasePackage.Literals.XSET_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testSetLiteralAssignedToCollectionBug498779() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"{\n" +
				"	val java.util.Collection<String> set = #{''}\n" +
				"}\n"));
	}

	@Test
	public void testListLiteralAssignedToCollectionBug498779() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"{\n" +
				"	val java.util.Collection<String> list = #['']\n" +
				"}\n"));
	}

	@Test
	public void testInvalidNestedReturnBug406762() throws Exception {
		this.assertNestedReturn("{\n" +
				"	return return 0\n" +
				"}\n", XbasePackage.Literals.XRETURN_EXPRESSION);
	}

	@Test
	public void testInvalidNestedReturnBug406762_1() throws Exception {
		this.assertInvalidReturnExpression(
				"{\n" +
				"	return {\n" +
				"		return 0\n" +
				"	}\n" +
				"}\n", XbasePackage.Literals.XBLOCK_EXPRESSION);
	}

	@Test
	public void testInvalidNestedReturnBug406762_2() throws Exception {
		this.assertInvalidReturnExpression(
				"{\n" +
				"	return {\n" +
				"		if (true) return 0 else return 1\n" +
				"	}\n" +
				"}\n",
				XbasePackage.Literals.XBLOCK_EXPRESSION);
	}

	@Test
	public void testInvalidNestedReturnBug406762_3() throws Exception {
		this.assertInvalidReturnExpression(
				"{\n" +
				"	return \n" +
				"		if (true) return 0 else return 1\n" +
				"}\n", XbasePackage.Literals.XIF_EXPRESSION);
	}

	@Test
	public void testInvalidNestedReturnBug406762_4() throws Exception {
		this.assertInvalidReturnExpression(
				"{\n" +
				"	return \n" +
				"		throw return new RuntimeException()\n" +
				"}\n",
				XbasePackage.Literals.XTHROW_EXPRESSION);
	}

	@Test
	public void testInvalidReturnInThrowBug406762() throws Exception {
		this.assertInvalidReturnInsideThrow("{\n" +
				"	throw return new RuntimeException()\n" +
				"}\n");
	}

	@Test
	public void testInvalidReturnInThrowBug406762_1() throws Exception {
		this.assertInvalidReturnInsideThrow("{\n" +
				"	throw {\n" +
				"		return new RuntimeException()\n" +
				"	}\n" +
				"}\n");
	}

	@Test
	public void testInvalidReturnInThrowBug406762_2() throws Exception {
		this.assertInvalidReturnInsideThrow("{\n" +
				"	throw return\n" +
				"}\n");
	}

	@Test
	public void testInvalidReturnInThrowBug406762_3() throws Exception {
		this.assertInvalidReturnInsideThrow("{\n" +
				"	throw {\n" +
				"		return\n" +
				"	}\n" +
				"}\n");
	}

	@Test
	public void testInvalidReturnThrowBug406762() throws Exception {
		this.assertInvalidReturnExpression(
				"{\n" +
				"	return throw new RuntimeException()\n" +
				"}\n", XbasePackage.Literals.XTHROW_EXPRESSION);
	}

	@Test
	public void testInvalidReturnThrowBug406762_1() throws Exception {
		this.assertInvalidReturnExpression(
				"{\n" +
				"	val b = true\n" +
				"	return if (b) throw new RuntimeException() else throw new RuntimeException()\n" +
				"}\n",
				XbasePackage.Literals.XIF_EXPRESSION);
	}

	@Test
	public void testValidReturnThrowBug406762() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"{\n" +
				"	val b = true\n" +
				"	return if (b) throw new RuntimeException() else 42\n" +
				"}\n"));
	}

	@Test
	public void testValidReturnThrowBug406762_1() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"{\n" +
				"	val b = true\n" +
				"	return if (b) 42 else throw new RuntimeException()\n" +
				"}\n"));
	}

	@Test
	public void test406762_ValidReturnInLambdaContainedInThrow() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"throw {\n" +
				"	val foo = [|return 'foo']\n" +
				"	new Exception(foo.apply)\n" +
				"}\n"));
	}

	@Test
	public void test406762_ValidReturnInLambdaContainedInThrow_1() throws Exception {
		validationTestHelper
				.assertNoErrors(expression(
				"throw {\n" +
				"	val ()=>Exception foo = [|return new Exception]\n" +
				"	foo.apply\n" +
				"}\n"));
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_01() throws Exception {
		validationTestHelper.assertError(expression(
				"for (int i : #[1..2]) {\n" +
				"}\n"), XbasePackage.Literals.XBINARY_OPERATION,
				IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_02() throws Exception {
		validationTestHelper.assertError(expression(
				"for (Integer i : #[1..2]) {\n" +
				"}\n"), XbasePackage.Literals.XBINARY_OPERATION,
				IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_03() throws Exception {
		validationTestHelper.assertError(expression(
				"for (Number i : #[1..2]) {\n" +
				"}\n"), XbasePackage.Literals.XBINARY_OPERATION,
				IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_04() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"for (i : #[1..2]) {\n" +
				"}\n"));
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_05() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"for (IntegerRange i : #[1..2]) {\n" +
				"}\n"));
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_06() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"for (Iterable<Integer> i : #[1..2]) {\n" +
				"}\n"));
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_07() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"for (int i : #[1..2].flatten) {\n" +
				"}\n"));
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_01b() throws Exception {
		validationTestHelper.assertError(expression(
				"for (int i : #{1..2}) {\n" +
				"}\n"), XbasePackage.Literals.XSET_LITERAL,
				IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_02b() throws Exception {
		validationTestHelper.assertError(expression(
				"for (Integer i : #{1..2}) {\n" +
				"}\n"), XbasePackage.Literals.XSET_LITERAL,
				IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_03b() throws Exception {
		validationTestHelper.assertError(expression(
				"for (Number i : #{1..2}) {\n" +
				"}\n"), XbasePackage.Literals.XSET_LITERAL,
				IssueCodes.INCOMPATIBLE_TYPES);
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_04b() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"for (i : #{1..2}) {\n" +
				"}\n"));
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_05b() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"for (IntegerRange i : #{1..2}) {\n" +
				"}\n"));
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_06b() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"for (Iterable<Integer> i : #{1..2}) {\n" +
				"}\n"));
	}

	@Test
	public void testRangeLiteralInForLoopBug440006_07b() throws Exception {
		validationTestHelper.assertNoErrors(expression(
				"for (int i : #{1..2}.flatten) {\n" +
				"}\n"));
	}

	private void assertNestedReturn(CharSequence input, EClass objectType) throws Exception {
		validationTestHelper.assertError(expression(input), objectType, IssueCodes.INVALID_RETURN, "Return cannot be nested.");
	}

	private void assertInvalidReturnInsideThrow(CharSequence input) throws Exception {
		validationTestHelper.assertError(expression(input), XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN,
				"Invalid return inside throw.");
	}

	private void assertInvalidReturnExpression(CharSequence input, EClass objectType) throws Exception {
		validationTestHelper.assertError(expression(input), objectType, IssueCodes.INVALID_RETURN,
				"Invalid return's expression.");
	}
}
