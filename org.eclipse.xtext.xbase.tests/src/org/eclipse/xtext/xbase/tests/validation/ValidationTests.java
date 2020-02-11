/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class ValidationTests extends AbstractXbaseTestCase {

	@Inject
	protected ValidationTestHelper helper;
	
	@Test public void testLambdaIssuesEmittedOnce() throws Exception {
		XExpression expr = expression("{ val list = #[] list.filter[it == null] }");
		List<Issue> issues = helper.validate(expr);
		Assert.assertEquals(1, issues.size());
	}
	
	@Test public void testIncompatibleTypes() throws Exception {
		XExpression expr = expression("{ val com.google.inject.Provider<String> x = [| 'foo'] as com.google.common.base.Supplier<String> }");
		helper.assertError(expr, XCASTED_EXPRESSION, INCOMPATIBLE_TYPES);
	}
	
	@Test public void testToLittleTypeInformation_01() throws Exception {
		XExpression expr = expression("{ val x = [e | e.toString()] }");
		helper.assertError(expr, XCLOSURE, TOO_LITTLE_TYPE_INFORMATION);
	}
	
	@Test public void testToLittleTypeInformation_02() throws Exception {
		XExpression expr = expression("{ <Object>newArrayList().add(e | e.toString()) }");
		helper.assertError(expr, XCLOSURE, TOO_LITTLE_TYPE_INFORMATION);
	}
	
	@Test public void testToLittleTypeInformation_03() throws Exception {
		XExpression expr = expression("{ newArrayList().add(e | e.toString()) }");
		helper.assertNoErrors(expr);
	}
	
	@Test public void testToLittleTypeInformation_04() throws Exception {
		XExpression expr = expression("{ <(String)=>int>newArrayList().add(s | s.length) }");
		helper.assertNoErrors(expr);
	}
	
	@Test public void testToLittleTypeInformation_05() throws Exception {
		XExpression expr = expression("{ <(String)=>int>newArrayList().add [ length ] }");
		helper.assertNoErrors(expr);
	}
	
	@Test public void testNoWildcardsInTypeArgs() throws Exception {
		XExpression expr = expression("java::util::Collections::<? extends String>singleton()");
		helper.assertError(expr, TypesPackage.Literals.JVM_WILDCARD_TYPE_REFERENCE, INVALID_USE_OF_WILDCARD);
	}
	
	@Test public void testNoWildcardsInTypeArgs_01() throws Exception {
		XExpression expr = expression("new java.util.ArrayList<?>()");
		helper.assertError(expr, TypesPackage.Literals.JVM_WILDCARD_TYPE_REFERENCE, INVALID_USE_OF_WILDCARD);
	}
	
	@Test public void testNonStatementExpressionInBlock_01() throws Exception {
		XExpression expr = expression("{ val x = 'foo' x 42 }");
		helper.assertError(expr, XFEATURE_CALL, INVALID_INNER_EXPRESSION);
	}
	
	@Test public void testNonStatementExpressionInBlock_02() throws Exception {
		XExpression expr = expression("{ val x = 'foo' 'bar' 42 }");
		helper.assertError(expr, XSTRING_LITERAL, INVALID_INNER_EXPRESSION);
	}
	
	@Test public void testNonStatementExpressionInBlock_03() throws Exception {
		XExpression expr = expression("{ val x = 'foo' 42 x }");
		helper.assertError(expr, XNUMBER_LITERAL, INVALID_INNER_EXPRESSION);
	}
	
	@Test public void testNonStatementExpressionInBlock_04() throws Exception {
		XExpression expr = expression("{ val x = 'foo' x as String 42 }");
		helper.assertError(expr, XFEATURE_CALL, INVALID_INNER_EXPRESSION);
	}
	@Test public void testNonStatementExpression_01() throws Exception {
		XExpression expr = expression("for (x : newArrayList('x','y')) { 42 }");
		helper.assertError(expr, XNUMBER_LITERAL, INVALID_INNER_EXPRESSION);
	}
	@Test public void testNonStatementExpression_02() throws Exception {
		XExpression expr = expression("while (23 > 45) 42");
		helper.assertError(expr, XNUMBER_LITERAL, INVALID_INNER_EXPRESSION);
	}
	
	@Test public void testNonStatementExpression_03() throws Exception {
		XExpression expr = expression("newArrayList('foo').forEach[ it ]");
		helper.assertError(expr, XFEATURE_CALL, INVALID_INNER_EXPRESSION);
	}
	
	@Test public void testNonStatementExpression_04() throws Exception {
		XExpression expr = expression("newArrayList('foo').forEach[ it != 'foo' ]");
		helper.assertError(expr, XBINARY_OPERATION, INVALID_INNER_EXPRESSION);
	}
	
	@Test public void testNonStatementExpression_05() throws Exception {
		XExpression expr = expression("{ val blockElement =\n" + 
				"		  if ('foo'.length > 42) {\n" + 
				"		    'test'\n" + 
				"		  } else {\n" + 
				"		  	'bar'\n" + 
				"		  }\n" + 
				"		blockElement.toString }");
		helper.assertNoErrors(expr);
	}
	
	@Test public void testNonStatementExpression_06() throws Exception {
		XExpression expr = expression("'foo' => [42]");
		helper.assertError(expr, XNUMBER_LITERAL, INVALID_INNER_EXPRESSION);
	}
	@Test public void testNonStatementExpression_07() throws Exception {
		XExpression expr = expression("'foo' => [typeof(String)]");
		helper.assertError(expr, XTYPE_LITERAL, INVALID_INNER_EXPRESSION);
	}
	@Test public void testNonStatementExpression_08() throws Exception {
		XExpression expr = expression("42 => ['x']");
		helper.assertError(expr, XSTRING_LITERAL, INVALID_INNER_EXPRESSION);
	}
	@Test public void testNonStatementExpression_09() throws Exception {
		XExpression expr = expression("'foo' => [true]");
		helper.assertError(expr, XBOOLEAN_LITERAL, INVALID_INNER_EXPRESSION);
	}
	@Test public void testNonStatementExpression_10() throws Exception {
		XExpression expr = expression("'foo' => [null]");
		helper.assertError(expr, XNULL_LITERAL, INVALID_INNER_EXPRESSION);
	}
	@Test public void testNonStatementExpression_11() throws Exception {
		XExpression expr = expression("'foo' => []");
		helper.assertNoErrors(expr);
	}
	
	@Test public void testNonStatementExpression_12() throws Exception {
		XExpression expr = expression("while (true) if (42 == 23) 'test'");
		helper.assertError(expr, XSTRING_LITERAL, INVALID_INNER_EXPRESSION);
	}
	@Test public void testNonStatementExpression_13() throws Exception {
		XExpression expr = expression("while (true) switch 42 { case 23 : 'test'}");
		helper.assertError(expr, XSTRING_LITERAL, INVALID_INNER_EXPRESSION);
	}
	@Test public void testNonStatementExpression_14() throws Exception {
		XExpression expr = expression("while (true) try { throw new Exception } catch (Exception e) 'test'");
		helper.assertError(expr, XSTRING_LITERAL, INVALID_INNER_EXPRESSION);
	}
	@Test public void testNonStatementExpression_15() throws Exception {
		XExpression expr = expression("while (true) try { 'foo' } finally { typeof(String).name }");
		helper.assertError(expr, XSTRING_LITERAL, INVALID_INNER_EXPRESSION);
	}
	
	@Test public void testNonStatementExpression_16() throws Exception {
		XExpression expr = expression("{val x = if (42 == 23) 'test' x}");
		helper.assertNoErrors(expr);
	}
	@Test public void testNonStatementExpression_17() throws Exception {
		XExpression expr = expression("{val x = switch 42 { case 23 : 'test'} x}");
		helper.assertNoErrors(expr);
	}
	@Test public void testNonStatementExpression_18() throws Exception {
		XExpression expr = expression("{val x = try { throw new Exception } catch (Exception e) 'test' x}");
		helper.assertNoErrors(expr);
	}
	@Test public void testNonStatementExpression_19() throws Exception {
		XExpression expr = expression("{val x = try { 'foo' } finally { typeof(String).name } x}");
		helper.assertNoErrors(expr);
	}
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=391451
	 */
	@Test public void testNonStatementExpression_20() throws Exception {
		XExpression expr = expression(
				"{" +
				"  val x = newArrayList(1,2) " +
				"  x.add(3) && x.add(4) " +
				"  x" +
				"}");
		helper.assertNoErrors(expr);
	}
	
	@Test
	public void testLocalVarWithArguments_01() throws Exception {
		XExpression expr = expression("{ val x = 'foo' x(42, 17bd) }");
		helper.assertError(expr, XFEATURE_CALL, Diagnostic.LINKING_DIAGNOSTIC, "method", "x(int, BigDecimal)");
	}
	
	@Test 
	public void testLocalVarWithArguments_02() throws Exception {
		XExpression expr = expression("{ val x = 'foo' x() }");
		helper.assertError(expr, XFEATURE_CALL, Diagnostic.LINKING_DIAGNOSTIC, "method", "x()");
	}
	
	@Test public void testLocalVarOfTypeVoid_01() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var illegalAssignmentOfVoid = while(true) {} illegalAssignmentOfVoid.doesNotExist }");
		helper.assertError(block, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES, "void");
		helper.assertNoError(block, INVALID_USE_OF_TYPE);
		helper.assertNoError(block, Diagnostic.LINKING_DIAGNOSTIC);
	}
	
	@Test public void testLocalVarOfTypeVoid_02() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var String s = while(true) {} }");
		helper.assertError(block, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES, "void", "String");
	}
	
	@Test public void testLocalVarOfTypeVoid_03() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var void illegalVoid; illegalVoid.doesNotExist }");
		helper.assertError(block, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "void");
		helper.assertNoError(block, Diagnostic.LINKING_DIAGNOSTIC);
	}
	
	@Test public void testVariableShadowing_00() throws Exception {
		XExpression expression = expression("{ val x = 'foo' { val x= 'bar' return x } }");
		helper.assertError(expression, XbasePackage.Literals.XVARIABLE_DECLARATION, VARIABLE_NAME_SHADOWING, "x");
	}
	
	@Test public void testVariableShadowing_01() throws Exception {
		XExpression expression = expression("{ val x = 'foo' for ( x : newArrayList('foo')) x.length }");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
	}
	
	@Test public void testVariableShadowing_03() throws Exception {
		XExpression expression = expression("{ val x = 'foo' val x = 'bar' }");
		helper.assertError(expression, XbasePackage.Literals.XVARIABLE_DECLARATION, VARIABLE_NAME_SHADOWING, "x");
	}
	
	@Test public void testVariableShadowing_04() throws Exception {
		XExpression expression = expression("{ val x = 'foo' switch x : 'foo' { case 'foo' : 'foo' } }");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
	}
	
	@Test public void testVariableShadowing_05() throws Exception {
		XExpression expression = expression("{ val x = 'foo' [String x | x + x].apply('foo') }");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
	}
	
	@Test public void testVariableShadowing_06() throws Exception {
		XExpression expression = expression("{ val x = 'foo' [String y, String x | x + y].apply('foo','bar') }");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
	}
	
	@Test public void testVariableShadowing_07() throws Exception {
		XExpression expression = expression("{ val x = 'foo' try { 'foo'.length } catch (Exception x) { 'bar'.length } }");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
	}
	
	@Test
	public void testVariableShadowing_08() throws Exception {
		XExpression expression = expression("[ int x, String x | x.substring(1) ]");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
		helper.assertNoError(expression, Diagnostic.LINKING_DIAGNOSTIC);
	}
	
	@Test 
	public void testVariableShadowing_09() throws Exception {
		XExpression expression = expression("[ String x, int x | x.substring(1) ]");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, Diagnostic.LINKING_DIAGNOSTIC, "substring(int)");
	}
	
	@Test public void testNoPrimitivesInTypeArgs_00() throws Exception {
		XExpression expression = expression("java::util::Collections::<boolean>singletonList");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "primitives");
	}
	
	@Test public void testNoPrimitivesInTypeArgs_01() throws Exception {
		XExpression expression = expression("new java.util.ArrayList<boolean>()");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "primitives");
	}
	
	@Test public void testVoidNotAllowed() throws Exception {
		XExpression expression = expression("null as void");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "void");
	}
	
	@Test public void testVoidNotAllowed_00() throws Exception {
		XExpression expression = expression("switch ('foo') void : 'bar'");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "void");
	}
	
	@Test public void testVoidNotAllowed_01() throws Exception {
		XExpression expression = expression("{val void y = null null}");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "void");
	}

	@Test public void testFinalCast() throws Exception {
		XExpression expression = expression("'foo' as Cloneable");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_CAST, "cast");
		expression = expression("'foo' as CharSequence");
		helper.assertNoError(expression, INVALID_CAST);
	}
	
	@Test public void testClosureWithModeThanSixParams() throws Exception {
		XExpression expression = expression("[int a1,int a2,int a3,int a4,int a5,int a6,int a7|null]");
		helper.assertError(expression, XCLOSURE, TOO_MANY_PARAMS_IN_CLOSURE);
		expression = expression("[int a1,int a2,int a3,int a4,int a5,int a6|null]");
		helper.assertNoError(expression, TOO_MANY_PARAMS_IN_CLOSURE);
	}
	
	@Test public void testVoidInReturnExpression_01() throws Exception {
		XExpression expression = expression("return while(false) 'foo'+'bar'");
		helper.assertError(expression, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES);
	}
	
	@Test
	public void testVoidInReturnExpression_02() throws Exception {
		XExpression expression = expression("return if (true) while(false) ('foo'+'bar').length");
		helper.assertError(expression, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES);
		helper.assertNoIssues(expression, XIF_EXPRESSION);
	}
	
	@Test public void testVoidInReturnExpression_03() throws Exception {
		XExpression expression = expression("return if (true) while(false) ('foo'+'bar').length else 'zonk'");
		helper.assertError(expression, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES);
		helper.assertNoIssues(expression, XIF_EXPRESSION);
		helper.assertNoIssues(expression, XSTRING_LITERAL);
	}
	
	@Test public void testVoidInReturnExpression_04() throws Exception {
		XExpression expression = expression("return if (true) while(false) 'foo'+'bar' else while(false) 'foo'+'bar'");
		helper.assertError(expression, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES);
	}
	
	@Test public void testVoidInReturnExpression_05() throws Exception {
		XExpression expression = expression("return if (true) while(false) ('foo'+'bar').length else null");
		helper.assertError(expression, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES);
		helper.assertNoIssues(expression, XIF_EXPRESSION);
		helper.assertNoIssues(expression, XNULL_LITERAL);
	}
	
	@Test
	public void testReturnExpressionInClosure_01() throws Exception {
		XExpression expression = expression("{val (String)=>String func = [x | return true] func.apply('foo')}");
		helper.assertError(expression, XCLOSURE, INCOMPATIBLE_TYPES, "(String)=>String", "(String)=>boolean");
	}
	
	@Test public void testReturnExpressionInClosure_02() throws Exception {
		XExpression expression = expression("{val (Integer)=>Integer func = [Integer i| return i]}");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testReturnExpressionInClosure_03() throws Exception {
		XExpression expression = expression("{val (Integer)=>Integer func = [Integer i| i]}");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testReturnExpressionInClosure_04() throws Exception {
		XExpression expression = expression("{val (Integer)=>String func = [Integer i| return i]}");
		helper.assertError(expression, XCLOSURE, INCOMPATIBLE_TYPES);
	}
	
	@Test public void testReturnExpressionInClosure_05() throws Exception {
		XExpression expression = expression("{val (Integer)=>String func = [Integer i| i]}");
		helper.assertError(expression, XCLOSURE, INCOMPATIBLE_TYPES);
	}
	
	@Test public void testReturnExpressionInClosure_06() throws Exception {
		XExpression expression = expression("{val func = [Integer i| return i]}");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testReturnExpressionInClosure_07() throws Exception {
		XExpression expression = expression("{val func = [Integer i| i]}");
		helper.assertNoErrors(expression);
	}
	
	@Test
	public void testReturnExpressionInClosure_08() throws Exception {
		XExpression expression = expression("{val (String)=>String func = [x | if (x == null) return x true] func.apply('foo')}");
		helper.assertError(expression, XCLOSURE, INCOMPATIBLE_TYPES, "(String)=>String", "(String)=>Serializable & Comparable<?>");
	}
	
	@Test public void testExceptionInClosure_00() throws Exception {
		XExpression expression = expression("{val func = [Integer i| throw new RuntimeException()]}");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testInCompatibleRightOperand() throws Exception {
		XExpression expression = expression("true || 'foo'");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}

	@Test public void testStringLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("'foo'", XSTRING_LITERAL);
	}

	@Test public void testNullLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("null", XNULL_LITERAL);
	}

	@Test public void testBooleanLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("true", XBOOLEAN_LITERAL);
	}

	@Test public void testTypeLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("typeof (String)", XTYPE_LITERAL);
	}

	@Test public void testClosureInBlock() throws Exception {
		checkInnerExpressionInBlock("[a|a]", XCLOSURE);
	}
	
	@Test public void testBinaryOpInBlock() throws Exception {
		checkInnerExpressionInBlock("1 + 3", XBINARY_OPERATION);
	}
	
	@Test public void testLiteralInBlockInBlock() throws Exception {
		checkInnerExpressionInBlock("{ {1} }", XNUMBER_LITERAL);
	}
	
	@Test public void testPureCallInBlock() throws Exception {
		checkInnerExpressionInBlock("newArrayList('foo')", XFEATURE_CALL);
	}

	@Test public void testThrowsInBlock_01() throws Exception {
		XExpression block = expression("{ throw new Exception() }");
		helper.assertNoErrors(block);
	}
	
	@Test public void testThrowsInBlock_02() throws Exception {
		XExpression block = expression("{ throw new Exception() new Object()}");
		helper.assertError(block, XbasePackage.Literals.XCONSTRUCTOR_CALL, UNREACHABLE_CODE, "unreachable", "expression");
	}
	
	@Test public void testThrowsInBlock_03() throws Exception {
		XExpression block = expression("{ if (true) throw new Exception() new Object()}");
		helper.assertNoErrors(block);
	}
	
	@Test public void testThrowsInBlock_04() throws Exception {
		XExpression block = expression("{ if (true) throw new Exception() else throw new Exception() new Object()}");
		helper.assertError(block, XbasePackage.Literals.XCONSTRUCTOR_CALL, UNREACHABLE_CODE, "unreachable", "expression");
	}
	
	protected void checkInnerExpressionInBlock(String innerExpression, EClass innerExpressionClass) throws Exception {
		XExpression validExpression = expression("{ " + innerExpression + " }");
		helper.assertNoError(validExpression, INVALID_INNER_EXPRESSION);
		XExpression invalidExpression = expression("{ " + innerExpression + " " + innerExpression + " }");
		helper.assertError(invalidExpression, innerExpressionClass, INVALID_INNER_EXPRESSION, "allowed", "context");
	}
	
	@Test public void testInvalidEarlyExit_01() throws Exception {
		XExpression expression = expression("try {} finally throw new Exception()");
		helper.assertError(expression, XbasePackage.Literals.XTHROW_EXPRESSION, INVALID_EARLY_EXIT, "throw", "not allowed", "context");
	}
	
	@Test public void testInvalidEarlyExit_02() throws Exception {
		XExpression expression = expression("if (throw new Exception()) {}");
		helper.assertError(expression, XbasePackage.Literals.XBLOCK_EXPRESSION, UNREACHABLE_CODE);
	}
	
	@Test public void testInvalidEarlyExit_03() throws Exception {
		XExpression expression = expression("try {} finally return null");
		helper.assertError(expression, XbasePackage.Literals.XRETURN_EXPRESSION, INVALID_EARLY_EXIT, "return", "context");
	}
	
	@Test public void testInvalidEarlyExit_04() throws Exception {
		XExpression expression = expression("if (return 1) {}");
		helper.assertError(expression, XbasePackage.Literals.XBLOCK_EXPRESSION, UNREACHABLE_CODE);
	}
	
	@Test public void testInvalidEarlyExit_05() throws Exception {
		XExpression expression = expression("if (true) return 1 else throw new Exception()");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testUnreachableCode_00() throws Exception {
		XExpression expression = expression(
				"{" +
				"	for (e : new java.util.ArrayList<String>()) " +
				"      throw new Exception() " +
				"   null" +
				"}");
		helper.assertNoErrors(expression, UNREACHABLE_CODE);
	}
	
	@Test public void testUnreachableCode_01() throws Exception {
		XBlockExpression expression = (XBlockExpression) expression(
				"{" +
				"	while (false) {" +
				"      throw new Exception() " +
				"   }" +
				"   null" +
				"}");
		XWhileExpression whileLoop = (XWhileExpression) expression.getExpressions().get(0);
		XThrowExpression throwExpression = (XThrowExpression) ((XBlockExpression) whileLoop.getBody()).getExpressions().get(0);
		helper.assertError(throwExpression, XbasePackage.Literals.XTHROW_EXPRESSION, UNREACHABLE_CODE);
	}
	
	@Test public void testUnreachableCode_02() throws Exception {
		XExpression expression = expression(
				"{" +
				"	do " +
				"      throw new Exception() " +
				"   while (false)" +
				"   null" +
				"}");
		helper.assertError(((XBlockExpression)expression).getExpressions().get(1), XbasePackage.Literals.XNULL_LITERAL, UNREACHABLE_CODE);
	}
	
	@Test public void testUnreachableCode_03() throws Exception {
		XExpression expression = expression(
				"{\n" + 
				"	switch i : 0 {\n" +
				"		case 1: return 1\n" +
				"		default: return 2\n" +
				"	}\n" +
				"	return 3" +
				"}");
		helper.assertError(expression, XbasePackage.Literals.XRETURN_EXPRESSION, UNREACHABLE_CODE);
	}
	
	@Test public void testUnreachableCode_04() throws Exception {
		XExpression expression = expression(
				"{\n" + 
				"	switch i : 0 {\n" +
				"		case 1,\n" +
				"		default: return 2\n" +
				"	}\n" +
				"	return 3" +
				"}");
		helper.assertError(expression, XbasePackage.Literals.XRETURN_EXPRESSION, UNREACHABLE_CODE);
	}
	
	@Test public void testUnreachableCode_05() throws Exception {
		XExpression expression = expression(
				"for(; false; ) {}");
		helper.assertError(expression, XbasePackage.Literals.XBLOCK_EXPRESSION, UNREACHABLE_CODE);
	}
	
	@Test public void testUnreachableCode_06() throws Exception {
		XExpression expression = expression(
				"for(val x = false; x; ) {}");
		helper.assertError(expression, XbasePackage.Literals.XBLOCK_EXPRESSION, UNREACHABLE_CODE);
	}
	
	@Test public void testUnreachableCode_07() throws Exception {
		XExpression expression = expression(
				"for(; true; {}) return");
		helper.assertError(expression, XbasePackage.Literals.XBLOCK_EXPRESSION, UNREACHABLE_CODE);
	}

	@Test public void testUnreachableCode_08() throws Exception {
		XExpression expression = expression(
				"{ while(true) return; 1 }");
		helper.assertError(expression, XbasePackage.Literals.XNUMBER_LITERAL, UNREACHABLE_CODE);
	}
	
	@Test public void testUnreachableCode_09() throws Exception {
		XExpression expression = expression(
				"while(false) return");
		helper.assertError(expression, XbasePackage.Literals.XRETURN_EXPRESSION, UNREACHABLE_CODE);
		helper.assertNoWarnings(expression, XbasePackage.Literals.XBOOLEAN_LITERAL, CONSTANT_BOOLEAN_CONDITION);
	}

	@Test public void testConstantCondition_01() throws Exception {
		XExpression expression = expression(
				"while(true && false) return");
		helper.assertWarning(expression, XbasePackage.Literals.XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always false");
	}
	
	@Test public void testConstantCondition_02() throws Exception {
		XExpression expression = expression(
				"while(1 == 0 + 1) return");
		helper.assertWarning(expression, XbasePackage.Literals.XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always true");
	}
	
	@Test public void testConstantCondition_03() throws Exception {
		XExpression expression = expression(
				"if('' == null) return");
		helper.assertWarning(expression, XbasePackage.Literals.XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always false");
	}
	
	@Test public void testConstantCondition_04() throws Exception {
		XExpression expression = expression(
				"{ val x = false if(!x) return");
		helper.assertWarning(expression, XbasePackage.Literals.XUNARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always true");
	}
	
	@Test public void testConstantCondition_05() throws Exception {
		XExpression expression = expression(
				"for(val i = 1; i << 2 == 4;) return");
		helper.assertWarning(expression, XbasePackage.Literals.XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always true");
	}
	
	@Test public void testConstantCondition_06() throws Exception {
		XExpression expression = expression(
				"do ''.toString while (String != null)");
		helper.assertWarning(expression, XbasePackage.Literals.XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always true");
	}
	
	@Test public void testConstantCondition_07() throws Exception {
		XExpression expression = expression(
				"if (newArrayList.empty && false) {}");
		helper.assertWarning(expression, XbasePackage.Literals.XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always false");
	}
	
	@Test public void testConstantCondition_08() throws Exception {
		XExpression expression = expression(
				"if (newArrayList('').empty || 2 == (1 << 1)) {}");
		helper.assertWarning(expression, XbasePackage.Literals.XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always true");
	}
	
	@Test public void testConstantCondition_09() throws Exception {
		XExpression expression = expression(
				"while (newArrayList('').empty || 2 == (1 << 1)) {}");
		helper.assertWarning(expression, XbasePackage.Literals.XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always true");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testConstantCondition_10() throws Exception {
		XExpression expression = expression(
				"if (String == typeof(String)) {}");
		helper.assertWarning(expression, XbasePackage.Literals.XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always true");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testConstantCondition_11() throws Exception {
		XExpression expression = expression(
				"for(x: newArrayList('')) { val y = x if (x == y) {}}");
		helper.assertWarning(expression, XbasePackage.Literals.XBINARY_OPERATION, CONSTANT_BOOLEAN_CONDITION, "Constant condition is always true");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testUnreachableCode421508_01() throws Exception {
		XExpression expression = expression(
				"{  val a = true val b = true" +
				"	a.equals(b) && {\n" + 
				"		if (a == b) {\n" + 
				"			return true\n" + 
				"		}\n" + 
				"		return false\n" + 
				"	}" +
				"}");
		helper.assertError(((XBlockExpression)expression).getExpressions().get(1), XbasePackage.Literals.XBINARY_OPERATION, UNREACHABLE_CODE);
	}

	@Test public void testUnreachableCode421508_02() throws Exception {
		XExpression expression = expression(
				"{  val a = true val b = true" +
				"	a.equals(b) && {\n" + 
				"		if (a == b) {\n" + 
				"			return true\n" + 
				"		}\n" + 
				"		false\n" + 
				"	}" +
				"}");
		helper.assertNoErrors(expression);
	}

	@Test public void testNewAbstractClass() throws Exception {
		XExpression expression = expression("new testdata.AbstractClassWithPublicConstructor()");
		helper.assertError(expression, XCONSTRUCTOR_CALL, ABSTRACT_CLASS_INSTANTIATION, "abstract", "instantiate", "class");
	}

	@Test public void testCast_0() throws Exception {
		XExpression expression = expression("'foo' as String");
		helper.assertWarning(expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, OBSOLETE_CAST, "Unnecessary cast from String to String");
		helper.assertNoError(expression, INVALID_CAST);
	}

	@Test public void testCast_1() throws Exception {
		XExpression expression = expression("'foo' as Cloneable");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_CAST, "cast");
		helper.assertNoError(expression, OBSOLETE_CAST);
	}

	@Test public void testCast_2() throws Exception {
		XExpression expression = expression("new String() as Boolean");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_CAST, "Cannot", "cast");
		helper.assertNoError(expression, OBSOLETE_CAST);
	}
	
	@Ignore("FIXME see https://bugs.eclipse.org/bugs/show_bug.cgi?id=364931")
	@Test public void testCast_3() throws Exception {
		XExpression expression = expression("new java.util.ArrayList<String>() as java.util.List<Object>");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_CAST, "Cannot", "cast");
		helper.assertNoError(expression, OBSOLETE_CAST);
	}
	
	@Test public void testCast_4() throws Exception {
		XExpression expression = expression("new Object() as String");
		helper.assertNoError(expression, INVALID_CAST);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=418578
	 */
	@Test public void testCast_5() throws Exception {
		XExpression expression = expression("if ('f'=='l') { 'bla' } else { throw new Exception() } as String");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_CAST);
	}
	
	@Test
	public void testCastInSwitch() throws Exception {
		XExpression expression = expression("switch('foo') { String: it }");
		helper.assertWarning(expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, OBSOLETE_CAST, "Unnecessary cast from String to String");
		helper.assertNoError(expression, INVALID_CAST);
	}

	@Test
	public void testInstanceOf_0() throws Exception {
		XExpression expression = expression("'foo' instanceof String");
		helper.assertWarning(expression, XINSTANCE_OF_EXPRESSION, OBSOLETE_INSTANCEOF, "already", "String");
		helper.assertNoError(expression, INVALID_INSTANCEOF);
	}

	@Test public void testInstanceOf_1() throws Exception {
		XExpression expression = expression("'foo' instanceof Cloneable");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "incompatible", "type");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}

	@Test public void testInstanceOf_2() throws Exception {
		XExpression expression = expression("new String() instanceof Boolean");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "incompatible", "type");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInstanceof_3() throws Exception {
		XExpression expression = expression("new Object() instanceof java.util.List<Boolean>");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "parameter");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInstanceof_4() throws Exception {
		XExpression expression = expression("new Object() instanceof java.util.List<Boolean>[]");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "parameter");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInstanceof_5() throws Exception {
		XExpression expression = expression("new Object() instanceof java.util.List<Boolean>[][]");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "parameter");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInstanceof_6() throws Exception {
		XExpression expression = expression("new Object() instanceof Boolean[]");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testInstanceof_7() throws Exception {
		XExpression expression = expression("new Object() instanceof Boolean[][]");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testInstanceof_8() throws Exception {
		XExpression expression = expression("new Object() instanceof boolean");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "primitive");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInstanceof_9() throws Exception {
		XExpression expression = expression("[|'foo'] instanceof ()=>String");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "parameterized");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInstanceof_10() throws Exception {
		XExpression expression = expression("true instanceof Boolean");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "Incompatible");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInstanceof_11() throws Exception {
		XExpression expression = expression("newArrayList('foo','bar') instanceof String[]");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "Incompatible");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testInstanceof_12() throws Exception {
		XExpression expression = expression("null instanceof String[]");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testInstanceof_13() throws Exception {
		XExpression expression = expression("null instanceof java.util.List<?>");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testInstanceof_14() throws Exception {
		XExpression expression = expression("'foo' instanceof java.util.List<? extends Object>");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "parameterized");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}
	
	@Test public void testPrimitiveAsTypeGuard() throws Exception {
		XCasePart expression = ((XSwitchExpression) expression("switch(new Object()) { int: 1 }")).getCases().get(0);
		helper.assertError(expression, XCASE_PART, INVALID_USE_OF_TYPE, "primitive", "not", "allowed", "type", "guard");
	}
	
	@Test public void testLocallyUnusedVariableDefintion() throws Exception {
		XBlockExpression xblockExpression = (XBlockExpression) expression("{val a = 42 }");
		XVariableDeclaration expressionA = (XVariableDeclaration) xblockExpression.getExpressions().get(0);
		helper.assertWarning(expressionA, XVARIABLE_DECLARATION, UNUSED_LOCAL_VARIABLE, "used");
	}
	
	@Test public void testLocallyUsedVariableDefintion() throws Exception {
		XBlockExpression xblockExpression = (XBlockExpression) expression("{val a = 42  a+1}");
		XVariableDeclaration expressionA = (XVariableDeclaration) xblockExpression.getExpressions().get(0);
		helper.assertNoIssues(expressionA);
	}
	
	@Test public void testLocallyWriteableUnusedVariableDefintion() throws Exception {
		XBlockExpression xblockExpression = (XBlockExpression) expression("{var a = 42 }");
		XVariableDeclaration expressionA = (XVariableDeclaration) xblockExpression.getExpressions().get(0);
		helper.assertWarning(expressionA, XVARIABLE_DECLARATION, UNUSED_LOCAL_VARIABLE, "used");
	}
	
	@Test public void testLocallyWriteableUsedVariableDefintion() throws Exception {
		XBlockExpression xblockExpression = (XBlockExpression) expression("{var a = 42  a+1}");
		XVariableDeclaration expressionA = (XVariableDeclaration) xblockExpression.getExpressions().get(0);
		helper.assertNoIssues(expressionA);
	}
	
	@Test public void testNumberLiteral_0() throws Exception {
		XExpression expression = expression("1e10.2e10");
		helper.assertError(expression, XNUMBER_LITERAL, INVALID_NUMBER_FORMAT);
	}

	@Test public void testNumberLiteral_1() throws Exception {
		XExpression expression = expression("1l.2bd");
		helper.assertError(expression, XNUMBER_LITERAL, INVALID_NUMBER_FORMAT);
	}

	@Test public void testNumberLiteral_3() throws Exception {
		XExpression expression = expression("1e20d.2bd");
		helper.assertError(expression, XNUMBER_LITERAL, INVALID_NUMBER_FORMAT);
	}

	@Test public void testNumberLiteral_4() throws Exception {
		XExpression expression = expression("1.0e20bd");
		helper.assertNoIssues(expression);
	}

	@Test public void testNumberLiteral_5() throws Exception {
		XExpression expression = expression("1234567890_1234567890_1234567890_1234567890_1234567890BI");
		helper.assertNoIssues(expression);
	}

	@Test public void testNumberLiteral_6() throws Exception {
		XExpression expression = expression("12345678901234567890123456789012345678901234567890L");
		helper.assertError(expression, XNUMBER_LITERAL, INVALID_NUMBER_FORMAT);
	}
	
	@Test public void testNumberLiteral_7() throws Exception {
		XExpression expression = expression("1e-20");
		helper.assertNoIssues(expression);
	}
	
	@Test public void testNumberLiteral_8() throws Exception {
		XExpression expression = expression("1e+20f");
		helper.assertNoIssues(expression);
	}

	@Test public void testNumberLiteral_9() throws Exception {
		XExpression expression = expression("0xffffffff");
		helper.assertNoIssues(expression);
	}

	@Test public void testNumberLiteral_10() throws Exception {
		XExpression expression = expression(Integer.toString(Integer.MAX_VALUE));
		helper.assertNoIssues(expression);
	}

	@Test public void testNumberLiteral_11() throws Exception {
		XExpression expression = expression(Long.toString(((long) Integer.MAX_VALUE) + 1));
		helper.assertError(expression, XNUMBER_LITERAL, INVALID_NUMBER_FORMAT);
	}

	@Test public void testNumberLiteral_12() throws Exception {
		XExpression expression = expression("0xffffffffffffffff#l");
		helper.assertNoIssues(expression);
	}

	@Test public void testNumberLiteral_13() throws Exception {
		XExpression expression = expression(Long.toString(Long.MAX_VALUE) + "L");
		helper.assertNoIssues(expression);
	}

	@Test public void testNumberLiteral_14() throws Exception {
		XExpression expression = expression(new BigInteger(Long.toString(Long.MAX_VALUE))
			.add(new BigInteger("1")).toString(10) + "L");
		helper.assertError(expression, XNUMBER_LITERAL, INVALID_NUMBER_FORMAT);
	}
	
	@Test public void testNumberLiteral_15() throws Exception {
		XExpression expression = expression("1.0e12345678901bd");
		helper.assertError(expression, XNUMBER_LITERAL, INVALID_NUMBER_FORMAT, "Too many nonzero exponent digits");
	}
	
	@Test public void testNumberLiteral_16() throws Exception {
		XExpression expression = expression("1.0e-12345678901bd");
		helper.assertError(expression, XNUMBER_LITERAL, INVALID_NUMBER_FORMAT, "Too many nonzero exponent digits");
	}
	
	@Test public void testNumberLiteral_17() throws Exception {
		XExpression expression = expression("1.0e1234567890bd");
		helper.assertNoIssues(expression);
	}
	
	@Test public void testNumberLiteral_18() throws Exception {
		XExpression expression = expression("1.0e-1234567890bd");
		helper.assertNoIssues(expression);
	}
	
	@Test public void testNumberLiteral_19() throws Exception {
		XExpression expression = expression("10e12345678901bi");
		helper.assertError(expression, XNUMBER_LITERAL, INVALID_NUMBER_FORMAT, "Too many nonzero exponent digits");
	}
	
	@Test
	public void testNumberLiteral_20() throws Exception {
		XExpression expression = expression("10e12345bi");
		helper.assertNoIssues(expression);
	}
	
	@Test
	@Ignore("OOM")
	public void testNumberLiteral_21() throws Exception {
		XExpression expression = expression("10e1234567890bi");
		helper.assertNoIssues(expression);
	}
	
	@Test public void testBug_362271 () throws Exception {
		XExpression expression = expression("switch null {\n" + 
				"  case null : [Object it|it]\n" + 
				"  case null : [Integer it|it]\n" + 
				"}");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testTypeLiteralVoidArray() throws Exception {
		XExpression expression = expression("typeof(void[])");
		helper.assertError(expression, XTYPE_LITERAL, INVALID_TYPE);
	}
	
	@Test public void testPrimitiveDefaultValueSynthesized_01() throws Exception {
		XExpression expression = expression("{ val int i = if (true) 1 }");
		helper.assertWarning(expression, XIF_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
	@Test public void testPrimitiveDefaultValueSynthesized_02() throws Exception {
		XExpression expression = expression("{ val int i = switch null as Object { String: 1 } }");
		helper.assertWarning(expression, XSWITCH_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
	@Test public void testPrimitiveDefaultValueSynthesized_03() throws Exception {
		XExpression expression = expression("{ val x = if (true) return 1 x }");
		helper.assertNoWarnings(expression, XIF_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
	@Test public void testPrimitiveDefaultValueSynthesized_04() throws Exception {
		XExpression expression = expression("{\n" + 
				"			val Comparable<Object> it = null\n" + 
				"			switch it {\n" + 
				"	            CharSequence: switch(it) {\n" + 
				"                    Appendable: {\n" + 
				"                        charAt(1)\n" + 
				"                    }\n" + 
				"                }\n" + 
				"        	}\n" + 
				"		}");
		helper.assertNoWarnings(expression, XSWITCH_EXPRESSION, NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
	}
	
}
