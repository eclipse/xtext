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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class ValidationTests extends AbstractXbaseTestCase {

	@Inject
	protected ValidationTestHelper helper;
	
	public void testToLittleTypeInformation() throws Exception {
		XExpression expr = expression("{ val x = [e | e.toString()] }");
		helper.assertError(expr, XCLOSURE, TOO_LITTLE_TYPE_INFORMATION);
	}
	
	public void testNoWildCardsInTypeArgs() throws Exception {
		XExpression expr = expression("java::util::Collections::<? extends String>singleton()");
		helper.assertError(expr, TypesPackage.Literals.JVM_WILDCARD_TYPE_REFERENCE, INVALID_USE_OF_WILDCARD);
	}
	
	public void testNoWildCardsInTypeArgs_01() throws Exception {
		XExpression expr = expression("new java.util.ArrayList<?>()");
		helper.assertError(expr, TypesPackage.Literals.JVM_WILDCARD_TYPE_REFERENCE, INVALID_USE_OF_WILDCARD);
	}
	
	public void testSideEffectFreeExpressionInBlock_01() throws Exception {
		XExpression expr = expression("{ val x = 'foo' x 42 }");
		helper.assertError(expr, XFEATURE_CALL, SIDE_EFFECT_FREE_EXPRESSION_IN_BLOCK);
	}
	
	public void testSideEffectFreeExpressionInBlock_02() throws Exception {
		XExpression expr = expression("{ val x = 'foo' 'bar' 42 }");
		helper.assertError(expr, XSTRING_LITERAL, SIDE_EFFECT_FREE_EXPRESSION_IN_BLOCK);
	}
	
	public void testSideEffectFreeExpressionInBlock_03() throws Exception {
		XExpression expr = expression("{ val x = 'foo' 42 x }");
		helper.assertError(expr, XINT_LITERAL, SIDE_EFFECT_FREE_EXPRESSION_IN_BLOCK);
	}
	
	public void testSideEffectFreeExpressionInBlock_04() throws Exception {
		XExpression expr = expression("{ val x = 'foo' x as String 42 }");
		helper.assertError(expr, XCASTED_EXPRESSION, SIDE_EFFECT_FREE_EXPRESSION_IN_BLOCK);
	}
	
	public void testLocalVarWithArguments() throws Exception {
		XExpression expr = expression("{ val x = 'foo' x(42) }");
		helper.assertError(expr, XFEATURE_CALL, LOCAL_VAR_ACCESS_WITH_PARENTHESES, "local", "variable");
	}
	
	public void testLocalVarOfTypeVoid_01() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var illegalAssignmentOfVoid = while(true) {} }");
		helper.assertError(block, XVARIABLE_DECLARATION, INVALID_USE_OF_TYPE, "void");
	}
	
	public void testLocalVarOfTypeVoid_02() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var String s = while(true) {} }");
		helper.assertError(block, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES, "void", "String");
	}
	
	public void testLocalVarOfTypeVoid_03() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var void illegalVoid; }");
		helper.assertError(block, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "void");
	}
	
	public void testVariableShadowing_00() throws Exception {
		XExpression expression = expression("{ val x = 'foo' { val x= 'bar' return x } }");
		helper.assertError(expression, XbasePackage.Literals.XVARIABLE_DECLARATION, VARIABLE_NAME_SHADOWING, "x");
	}
	
	public void testVariableShadowing_01() throws Exception {
		XExpression expression = expression("{ val x = 'foo' for ( x : newArrayList('foo')) x.length }");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
	}
	
	public void testVariableShadowing_03() throws Exception {
		XExpression expression = expression("{ val x = 'foo' val x = 'bar' }");
		helper.assertError(expression, XbasePackage.Literals.XVARIABLE_DECLARATION, VARIABLE_NAME_SHADOWING, "x");
	}
	
	public void testVariableShadowing_04() throws Exception {
		XExpression expression = expression("{ val x = 'foo' switch x : 'foo' { case 'foo' : 'foo' } }");
		helper.assertError(expression, XbasePackage.Literals.XSWITCH_EXPRESSION, VARIABLE_NAME_SHADOWING, "x");
	}
	
	public void testVariableShadowing_05() throws Exception {
		XExpression expression = expression("{ val x = 'foo' [String x | x + x].apply('foo') }");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
	}
	
	public void testVariableShadowing_06() throws Exception {
		XExpression expression = expression("{ val x = 'foo' [String y, String x | x + y].apply('foo','bar') }");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
	}
	
	public void testVariableShadowing_07() throws Exception {
		XExpression expression = expression("{ val x = 'foo' try { 'foo'.length } catch (Exception x) { 'bar'.length } }");
		helper.assertError(expression, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING, "x");
	}
	
	public void testNoPrimitivesInTypeArgs_00() throws Exception {
		XExpression expression = expression("java::util::Collections::<boolean>singletonList");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "primitives");
	}
	
	public void testNoPrimitivesInTypeArgs_01() throws Exception {
		XExpression expression = expression("new java.util.ArrayList<boolean>()");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "primitives");
	}
	
	public void testVoidNotAllowed() throws Exception {
		XExpression expression = expression("null as void");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "void");
	}
	
	public void testVoidNotAllowed_00() throws Exception {
		XExpression expression = expression("switch ('foo') void : 'bar'");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "void");
	}
	
	public void testVoidNotAllowed_01() throws Exception {
		XExpression expression = expression("{val void y = null null}");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "void");
	}

	public void testFinalCast() throws Exception {
		XExpression expression = expression("'foo' as Cloneable");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_CAST, "sealed");
		expression = expression("'foo' as CharSequence");
		helper.assertNoError(expression, INVALID_CAST);
	}
	
	public void testClosureWithModeThanSixParams() throws Exception {
		XExpression expression = expression("[int a1,int a2,int a3,int a4,int a5,int a6,int a7|null]");
		helper.assertError(expression, XCLOSURE, TOO_MANY_PARAMS_IN_CLOSURE);
		expression = expression("[int a1,int a2,int a3,int a4,int a5,int a6|null]");
		helper.assertNoError(expression, TOO_MANY_PARAMS_IN_CLOSURE);
	}
	
	public void testVoidInReturnExpression_01() throws Exception {
		XExpression expression = expression("return while(false) 'foo'+'bar'");
		helper.assertError(expression, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES);
	}
	
	public void testVoidInReturnExpression_02() throws Exception {
		XExpression expression = expression("return if (true) while(false) 'foo'+'bar'");
		helper.assertNoErrors(expression);
	}
	
	public void testVoidInReturnExpression_03() throws Exception {
		XExpression expression = expression("return if (true) while(false) 'foo'+'bar' else 'zonk'");
		helper.assertNoErrors(expression);
	}
	
	public void testVoidInReturnExpression_04() throws Exception {
		XExpression expression = expression("return if (true) while(false) 'foo'+'bar' else while(false) 'foo'+'bar'");
		helper.assertError(expression, XIF_EXPRESSION, INCOMPATIBLE_TYPES);
	}
	
	public void testReturnExpressionInClosure_01() throws Exception {
		XExpression expression = expression("{val (String)=>String func = [x | return true] func.apply('foo')}");
		helper.assertError(expression, XBOOLEAN_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	public void testReturnExpressionInClosure_02() throws Exception {
		XExpression expression = expression("{val (Integer)=>Integer func = [Integer i| return i]}");
		helper.assertNoErrors(expression);
	}
	
	public void testReturnExpressionInClosure_03() throws Exception {
		XExpression expression = expression("{val (Integer)=>Integer func = [Integer i| i]}");
		helper.assertNoErrors(expression);
	}
	
	public void testReturnExpressionInClosure_04() throws Exception {
		XExpression expression = expression("{val (Integer)=>String func = [Integer i| return i]}");
		helper.assertError(expression, XCLOSURE, INCOMPATIBLE_TYPES);
	}
	
	public void testReturnExpressionInClosure_05() throws Exception {
		XExpression expression = expression("{val (Integer)=>String func = [Integer i| i]}");
		helper.assertError(expression, XCLOSURE, INCOMPATIBLE_TYPES);
	}
	
	public void testReturnExpressionInClosure_06() throws Exception {
		XExpression expression = expression("{val func = [Integer i| return i]}");
		helper.assertNoErrors(expression);
	}
	
	public void testReturnExpressionInClosure_07() throws Exception {
		XExpression expression = expression("{val func = [Integer i| i]}");
		helper.assertNoErrors(expression);
	}
	
	public void testInCompatibleRightOperand() throws Exception {
		XExpression expression = expression("true || 'foo'");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}

	public void testStringLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("'foo'", XSTRING_LITERAL);
	}

	public void testNullLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("null", XNULL_LITERAL);
	}

	public void testBooleanLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("true", XBOOLEAN_LITERAL);
	}

	public void testTypeLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("typeof (String)", XTYPE_LITERAL);
	}

	public void testClosureInBlock() throws Exception {
		checkInnerExpressionInBlock("[a|a]", XCLOSURE);
	}

	public void testThrowsInBlock_01() throws Exception {
		XExpression block = expression("{ throw new Exception() }");
		helper.assertNoErrors(block);
	}
	
	public void testThrowsInBlock_02() throws Exception {
		XExpression block = expression("{ throw new Exception() new Object()}");
		helper.assertError(block, XbasePackage.Literals.XCONSTRUCTOR_CALL, UNREACHABLE_CODE, "unreachable", "expression");
	}
	
	public void testThrowsInBlock_03() throws Exception {
		XExpression block = expression("{ if (true) throw new Exception() new Object()}");
		helper.assertNoErrors(block);
	}
	
	public void testThrowsInBlock_04() throws Exception {
		XExpression block = expression("{ if (true) throw new Exception() else throw new Exception() new Object()}");
		helper.assertError(block, XbasePackage.Literals.XCONSTRUCTOR_CALL, UNREACHABLE_CODE, "unreachable", "expression");
	}

	protected void checkInnerExpressionInBlock(String innerExpression, EClass innerExpressionClass) throws Exception {
		XExpression validExpression = expression("{ " + innerExpression + " }");
		helper.assertNoError(validExpression, INVALID_INNER_EXPRESSION);
		XExpression invalidExpression = expression("{ " + innerExpression + " " + innerExpression + " }");
		helper.assertError(invalidExpression, innerExpressionClass, INVALID_INNER_EXPRESSION, "block", "last",
				"element");
	}
	
	public void testInvalidEarlyExit_01() throws Exception {
		XExpression expression = expression("try {} finally throw new Exception()");
		helper.assertError(expression, XbasePackage.Literals.XTHROW_EXPRESSION, INVALID_EARLY_EXIT, "throw", "not allowed", "context");
	}
	
	public void testInvalidEarlyExit_02() throws Exception {
		XExpression expression = expression("if (throw new Exception()) {}");
		helper.assertError(expression, XbasePackage.Literals.XTHROW_EXPRESSION, INCOMPATIBLE_TYPES, "void", "boolean");
	}
	
	public void testInvalidEarlyExit_03() throws Exception {
		XExpression expression = expression("try {} finally return null");
		helper.assertError(expression, XbasePackage.Literals.XRETURN_EXPRESSION, INVALID_EARLY_EXIT, "return", "context");
	}
	
	public void testInvalidEarlyExit_04() throws Exception {
		XExpression expression = expression("if (return 1) {}");
		helper.assertError(expression, XbasePackage.Literals.XRETURN_EXPRESSION, INCOMPATIBLE_TYPES, "void", "boolean");
	}
	
	public void testInvalidEarlyExit_05() throws Exception {
		XExpression expression = expression("if (true) return 1 else throw new Exception()");
		helper.assertNoErrors(expression);
	}
	
	public void testUnreachableCode_00() throws Exception {
		XExpression expression = expression(
				"{" +
				"	for (e : new java.util.ArrayList<String>()) " +
				"      throw new Exception() " +
				"   null" +
				"}");
		helper.assertNoErrors(expression);
	}
	
	public void testUnreachableCode_01() throws Exception {
		XExpression expression = expression(
				"{" +
				"	while (false) " +
				"      throw new Exception() " +
				"   null" +
		"}");
		helper.assertNoErrors(expression);
	}
	
	public void testUnreachableCode_02() throws Exception {
		XExpression expression = expression(
				"{" +
				"	do " +
				"      throw new Exception() " +
				"   while (false)" +
				"   null" +
		"}");
		helper.assertError(((XBlockExpression)expression).getExpressions().get(1), XbasePackage.Literals.XNULL_LITERAL, UNREACHABLE_CODE);
	}

	public void testNewAbstractClass() throws Exception {
		XExpression expression = expression("new testdata.AbstractClassWithPublicConstructor()");
		helper.assertError(expression, XCONSTRUCTOR_CALL, ABSTRACT_CLASS_INSTANTIATION, "abstract", "instantiate",
				"class");
	}

//	public void testCast_0() throws Exception {
//		XExpression expression = expression("'foo' as String");
//		helper.assertWarning(expression, XCASTED_EXPRESSION, OBSOLETE_CAST, "cast", "obsolete");
//		helper.assertNoError(expression, INVALID_CAST);
//	}

	public void testCast_1() throws Exception {
		XExpression expression = expression("'foo' as Cloneable");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_CAST, "sealed", "type");
		helper.assertNoError(expression, OBSOLETE_CAST);
	}

	public void testCast_2() throws Exception {
		XExpression expression = expression("new String() as Boolean");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_CAST, "Cannot", "cast");
		helper.assertNoError(expression, OBSOLETE_CAST);
	}

	public void testInstanceOf_0() throws Exception {
		XExpression expression = expression("'foo' instanceof String");
		helper.assertWarning(expression, XINSTANCE_OF_EXPRESSION, OBSOLETE_INSTANCEOF, "already", "java.lang.String");
		helper.assertNoError(expression, INVALID_INSTANCEOF);
	}

	public void testInstanceOf_1() throws Exception {
		XExpression expression = expression("'foo' instanceof Cloneable");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "incompatible", "type");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}

	public void testInstanceOf_2() throws Exception {
		XExpression expression = expression("new String() instanceof Boolean");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "incompatible", "type");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}
	
	public void testPrimitiveAsTypeGuard() throws Exception {
		XCasePart expression = ((XSwitchExpression) expression("switch(new Object()) { int: 1 }")).getCases().get(0);
		helper.assertError(expression, XCASE_PART, INVALID_USE_OF_TYPE, "primitive", "not", "allowed", "type", "guard");
	}
	
}
