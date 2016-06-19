/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.linking;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Ignore;
import org.junit.Test;

import testdata.OverloadedMethods;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Refinements to linking / shadowing
 */
public abstract class AbstractXbaseLinkingTest extends AbstractXbaseTestCase {
	
	@Test public void testParameterizedInnerTypes_01() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val nested.ParameterizedInnerTypes<String>.Inner x = null }", true);
		XVariableDeclaration variableDecl = (XVariableDeclaration) block.getExpressions().get(0);
		JvmType type = variableDecl.getType().getType();
		assertEquals("nested.ParameterizedInnerTypes$Inner", type.getIdentifier());
		assertEquals("nested.ParameterizedInnerTypes<java.lang.String>$Inner", variableDecl.getType().getIdentifier());
	}
	
	@Test public void testParameterizedInnerTypes_02() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val nested.ParameterizedInnerTypes.Sub<String>.Inner x = null }", true);
		XVariableDeclaration variableDecl = (XVariableDeclaration) block.getExpressions().get(0);
		JvmType type = variableDecl.getType().getType();
		assertEquals("nested.ParameterizedInnerTypes$Inner", type.getIdentifier());
		assertEquals("nested.ParameterizedInnerTypes$Sub<java.lang.String>$Inner", variableDecl.getType().getIdentifier());
	}
	
	@Test public void testIdentifierAsTypeLiteral_01() throws Exception {
		XFeatureCall featureCall = (XFeatureCall) expression("String", true);
		assertEquals("java.lang.String", featureCall.getFeature().getIdentifier());
		assertTrue(featureCall.isTypeLiteral());
	}
	
	@Test public void testIdentifierAsTypeLiteral_02() throws Exception {
		XFeatureCall featureCall = (XFeatureCall) expression("void", true);
		assertEquals("void", featureCall.getFeature().getIdentifier());
		assertTrue(featureCall.isTypeLiteral());
	}
	
	@Test public void testIdentifierAsTypeLiteral_03() throws Exception {
		XFeatureCall featureCall = (XFeatureCall) expression("int", true);
		assertEquals("int", featureCall.getFeature().getIdentifier());
		assertTrue(featureCall.isTypeLiteral());
	}
	
	@Test public void testAssignment_1() throws Exception {
		XBinaryOperation assignment = (XBinaryOperation) expression("new java.util.ArrayList<String>() += 'foo'", true);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,E)", assignment.getFeature().getIdentifier());
	}
	
	@Test public void testAssignment_2() throws Exception {
		XBinaryOperation assignment = (XBinaryOperation) expression("new java.util.ArrayList<CharSequence>() += new java.util.ArrayList<String>()", true);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,java.lang.Iterable)",assignment.getFeature().getIdentifier());
	}
	
	@Test public void testBinaryOperation_1() throws Exception {
		XBinaryOperation operation = (XBinaryOperation) expression("'1' + 1", true);
		assertEquals("org.eclipse.xtext.xbase.lib.StringExtensions.operator_plus(java.lang.String,java.lang.Object)", operation.getFeature().getIdentifier());
	}
	
	@Test public void testBinaryOperation_2() throws Exception {
		XBinaryOperation operation = (XBinaryOperation) expression("'11' + 1", true);
		assertEquals("org.eclipse.xtext.xbase.lib.StringExtensions.operator_plus(java.lang.String,java.lang.Object)",operation.getFeature().getIdentifier());
	}
	
	@Test public void testBinaryOperation_3() throws Exception {
		XBinaryOperation operation = (XBinaryOperation) expression("(1 as char) + '1'", true);
		assertEquals("org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_plus(java.lang.Object,java.lang.String)",operation.getFeature().getIdentifier());
	}
	
	@Test public void testBinaryOperation_4() throws Exception {
		XBinaryOperation operation = (XBinaryOperation) expression("(null as Character) + '1'", true);
		assertEquals("org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_plus(java.lang.Object,java.lang.String)",operation.getFeature().getIdentifier());
	}
	
	@Test public void testBinaryOperation_5() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{\n" +
				" val java.util.List list = null" +
				" list += 'bar'" +
				"}", true);
		XBinaryOperation operation = (XBinaryOperation) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,E)", operation.getFeature().getIdentifier());
	}
	
	@Test public void testBinaryOperation_6() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{\n" +
				" val java.util.List<String> list = null" +
				" list += 'bar'" +
				"}", true);
		XBinaryOperation operation = (XBinaryOperation) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,E)", operation.getFeature().getIdentifier());
	}

	@Test public void testBinaryOperation_7() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{\n" +
				" val java.util.List<? super CharSequence> list = null" +
				" list += null as Iterable<CharSequence>" +
				"}", true);
		XBinaryOperation operation = (XBinaryOperation) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,java.lang.Iterable)", operation.getFeature().getIdentifier());
	}
	
	@Test public void testBinaryOperation_8() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{\n" +
				" val java.util.List<? super CharSequence> list = null" +
				" list += null as Iterable<? extends CharSequence>" +
				"}", true);
		XBinaryOperation operation = (XBinaryOperation) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,java.lang.Iterable)", operation.getFeature().getIdentifier());
	}
	
	@Test public void testBinaryOperation_9() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{\n" +
				" val java.util.List<CharSequence> list = null" +
				" list += null as Iterable<? extends CharSequence>" +
				"}", true);
		XBinaryOperation operation = (XBinaryOperation) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,java.lang.Iterable)", operation.getFeature().getIdentifier());
	}
	
	@Test public void testBinaryOperation_10() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{\n" +
				" val java.util.List<CharSequence> list = null" +
				" list += null as Iterable<CharSequence>" +
				"}", true);
		XBinaryOperation operation = (XBinaryOperation) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,java.lang.Iterable)", operation.getFeature().getIdentifier());
	}
	
	@Test public void testBinaryOperation_11() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{\n" +
				" val java.util.List list = null" +
				" list += null as Iterable<CharSequence>" +
				"}", true);
		XBinaryOperation operation = (XBinaryOperation) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,java.lang.Iterable)", operation.getFeature().getIdentifier());
	}
	
	@Test public void testAssignmentToInvisibleElements() throws Exception {
		XAssignment expression = (XAssignment) expression("new testdata.GenericType1<String>().t = 'foo'");
		assertEquals("testdata.GenericType1.t", expression.getFeature().getIdentifier());
		assertTrue(((JvmMember)expression.getFeature()).getVisibility()==JvmVisibility.PRIVATE);
	}
	
	@Test public void testRecursiveClosure() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val (int)=>int fun = [ fun.apply(it) ] }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XClosure closure = (XClosure) variable.getRight();
		XBlockExpression body = (XBlockExpression) closure.getExpression();
		XMemberFeatureCall member = (XMemberFeatureCall) body.getExpressions().get(0);
		XFeatureCall recursive = (XFeatureCall) member.getMemberCallTarget();
		assertSame(variable, recursive.getFeature());
	}
	
	@Test public void testRecursiveClosure_02() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val (int)=>int fun = [ self.apply(it) ] }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XClosure closure = (XClosure) variable.getRight();
		XBlockExpression body = (XBlockExpression) closure.getExpression();
		XMemberFeatureCall member = (XMemberFeatureCall) body.getExpressions().get(0);
		XFeatureCall recursive = (XFeatureCall) member.getMemberCallTarget();
		assertEquals(Functions.Function1.class.getName(), recursive.getFeature().getQualifiedName('$'));
	}
	
	@Test public void testConstructorCall_00() throws Exception {
		XConstructorCall expression = (XConstructorCall) expression("new java.util.ArrayList<String>(42)");
		assertEquals("java.util.ArrayList.ArrayList(int)", expression.getConstructor().getIdentifier());
	}
	
	@Test public void testConstructorCall_01() throws Exception {
		XConstructorCall expression = (XConstructorCall) expression("new java.util.ArrayList<String>()");
		assertEquals("java.util.ArrayList.ArrayList()", expression.getConstructor().getIdentifier());
	}
	
	@Test public void testEscapedQualifiedName() throws Exception {
		XCastedExpression expression = (XCastedExpression) expression("null as ^testdata/* foobar */.^FieldAccessSub");
		assertFalse(expression.getType().getType().eIsProxy());
	}
	
	@Test public void testFeatureCall() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{" +
				"  val this = new testdata.FieldAccessSub();" +
				"  stringField;" +
				"  finalField;" +
				"}");
		XFeatureCall call1 = (XFeatureCall) block.getExpressions().get(1);
		XFeatureCall call2 = (XFeatureCall) block.getExpressions().get(2);
		assertEquals("testdata.FieldAccessSub.stringField",call1.getFeature().getIdentifier());
		assertEquals("testdata.FieldAccess.finalField",call2.getFeature().getIdentifier());
	}
	
	@Test public void testFeatureCall_1() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{" +
				"  val this = new testdata.FieldAccessSub();" +
				"  stringField;" +
				"  stringField();" +
				"}");
		XFeatureCall call1 = (XFeatureCall) block.getExpressions().get(1);
		XFeatureCall call2 = (XFeatureCall) block.getExpressions().get(2);
		assertEquals("testdata.FieldAccessSub.stringField",call1.getFeature().getIdentifier());
		assertEquals("testdata.FieldAccessSub.stringField()",((JvmOperation)call2.getFeature()).getIdentifier());
	}
	
	@Test public void testFeatureCall_1_b() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{" +
				"  val this = new testdata.FieldAccessSub();" +
				"  stringField();" +
				"  stringField;" +
				"}");
		XFeatureCall call1 = (XFeatureCall) block.getExpressions().get(1);
		XFeatureCall call2 = (XFeatureCall) block.getExpressions().get(2);
		assertEquals("testdata.FieldAccessSub.stringField()",((JvmOperation)call1.getFeature()).getIdentifier());
		assertEquals("testdata.FieldAccessSub.stringField",call2.getFeature().getIdentifier());
	}
	
	@Test public void testFeatureCall_2() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{" +
				"  val this = new testdata.FieldAccessSub();" +
				"  privateField;" +
				"  privateField();" +
		"}");
		XFeatureCall call1 = (XFeatureCall) block.getExpressions().get(1);
		XFeatureCall call2 = (XFeatureCall) block.getExpressions().get(2);
		assertEquals("testdata.FieldAccessSub.privateField()",((JvmOperation)call1.getFeature()).getIdentifier());
		assertSame(call1.getFeature(), call2.getFeature());
	}
	
	@Test public void testFeatureCall_3() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{" +
				"  val this = new testdata.MethodOverrides1();" +
				"  m1('String');" +
				"  m1('CharSequence' as CharSequence);" +
		"}");
		XFeatureCall call1 = (XFeatureCall) block.getExpressions().get(1);
		XFeatureCall call2 = (XFeatureCall) block.getExpressions().get(2);
		assertEquals("testdata.MethodOverrides1.m1(java.lang.String)",((JvmOperation)call1.getFeature()).getIdentifier());
		assertEquals("testdata.MethodOverrides1.m1(java.lang.CharSequence)",((JvmOperation)call2.getFeature()).getIdentifier());
	}
	
	@Test public void testFeatureCall_4() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{" +
				"  val this = new testdata.MethodOverrides2();" +
				"  m1('String');" +
				"  m1('CharSequence' as CharSequence);" +
				"  m1('String' as Object);" +
		"}");
		XFeatureCall call1 = (XFeatureCall) block.getExpressions().get(1);
		XFeatureCall call2 = (XFeatureCall) block.getExpressions().get(2);
		XFeatureCall call3 = (XFeatureCall) block.getExpressions().get(3);
		assertEquals("testdata.MethodOverrides1.m1(java.lang.String)",((JvmOperation)call1.getFeature()).getIdentifier());
		assertEquals("testdata.MethodOverrides1.m1(java.lang.CharSequence)",((JvmOperation)call2.getFeature()).getIdentifier());
		assertEquals("testdata.MethodOverrides2.m1(java.lang.Object)",((JvmOperation)call3.getFeature()).getIdentifier());
	}
	
	@Test public void testFeatureCall_5() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" + 
				"	val list = newArrayList\n" + 
				"	list.addAll(null as java.util.ArrayList<String>)\n" + 
				"	list\n" + 
				"}");
		XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("java.util.ArrayList.addAll(java.util.Collection)", ((JvmOperation)memberFeatureCall.getFeature()).getIdentifier());
	}
	
	@Test public void testFeatureCall_6() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" + 
				"	val list = newArrayList\n" + 
				"	list.addAll(null as Iterable<String>)\n" + 
				"	list\n" + 
				"}");
		XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,java.lang.Iterable)", ((JvmOperation)memberFeatureCall.getFeature()).getIdentifier());
	}
	
	@Test public void testFeatureCall_7() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" + 
				"	val list = newArrayList\n" + 
				"	list.addAll(null as String[])\n" + 
				"	list\n" + 
				"}");
		XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,T[])", ((JvmOperation)memberFeatureCall.getFeature()).getIdentifier());
	}
	
	@Test public void testFeatureCall_8() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" + 
				"	val list = newArrayList\n" + 
				"	list.addAll(1, null as String[])\n" + 
				"	list\n" + 
				"}");
		XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("java.util.ArrayList.addAll(int,java.util.Collection)", ((JvmOperation)memberFeatureCall.getFeature()).getIdentifier());
	}
	
	@Test public void testFeatureCall_9() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" + 
				"	val list = newArrayList\n" + 
				"	list.addAll(null as Integer, null as String[])\n" + 
				"	list\n" + 
				"}");
		XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("java.util.ArrayList.addAll(int,java.util.Collection)", ((JvmOperation)memberFeatureCall.getFeature()).getIdentifier());
	}
	
	@Test public void testFeatureCall_10() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" + 
				"	val list = <String>newArrayList\n" + 
				"	list.addAll(1, null as String[])\n" + 
				"	list\n" + 
				"}");
		XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("java.util.ArrayList.addAll(int,java.util.Collection)", ((JvmOperation)memberFeatureCall.getFeature()).getIdentifier());
	}
	
	@Test public void testFeatureCall_11() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" + 
				"	val list = <String>newArrayList\n" + 
				"	list.addAll(null as Integer, null as String[])\n" + 
				"	list\n" + 
				"}");
		XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("java.util.ArrayList.addAll(int,java.util.Collection)", ((JvmOperation)memberFeatureCall.getFeature()).getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_01() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata::MethodOverrides4::staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_02() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata::MethodOverrides4::<java.io.Serializable>staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_03() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata::MethodOverrides4::<CharSequence>staticM5(null)");
		assertEquals("testdata.MethodOverrides3.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	// TODO here we would expect an error marker since <Object> is no valid type argument
	@Test public void testStaticFeatureCall_04() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata::MethodOverrides4::<Object>staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	// TODO here we would expect an error marker since <String> is ambiguous
	@Test public void testStaticFeatureCall_05() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata::MethodOverrides4::<String>staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_06() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val iterable = testdata::MethodOverrides4::staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_07() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val Iterable<java.io.Serializable> iterable = testdata::MethodOverrides4::staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Ignore("TODO eager binding of type arguments to expectation")
	@Test public void testStaticFeatureCall_08() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val Iterable<CharSequence> iterable = testdata::MethodOverrides4::staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides3.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_09() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val Iterable<Object> iterable = testdata::MethodOverrides4::staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_10() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata.MethodOverrides4::staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_11() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata.MethodOverrides4::<java.io.Serializable>staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_12() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata.MethodOverrides4::<CharSequence>staticM5(null)");
		assertEquals("testdata.MethodOverrides3.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	// TODO here we would expect an error marker since <Object> is no valid type argument
	@Test public void testStaticFeatureCall_13() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata.MethodOverrides4::<Object>staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	// TODO here we would expect an error marker since <String> is ambiguous
	@Test public void testStaticFeatureCall_14() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata.MethodOverrides4::<String>staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_15() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val iterable = testdata.MethodOverrides4::staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_16() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val Iterable<java.io.Serializable> iterable = testdata.MethodOverrides4::staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Ignore("TODO eager binding of type arguments to expectation")
	@Test public void testStaticFeatureCall_17() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val Iterable<CharSequence> iterable = testdata.MethodOverrides4::staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides3.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_18() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val Iterable<Object> iterable = testdata.MethodOverrides4::staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_19() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata.MethodOverrides4.staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_20() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata.MethodOverrides4.<java.io.Serializable>staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_21() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata.MethodOverrides4.<CharSequence>staticM5(null)");
		assertEquals("testdata.MethodOverrides3.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	// TODO here we would expect an error marker since <Object> is no valid type argument
	@Test public void testStaticFeatureCall_22() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata.MethodOverrides4.<Object>staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	// TODO here we would expect an error marker since <String> is ambiguous
	@Test public void testStaticFeatureCall_23() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("testdata.MethodOverrides4.<String>staticM5(null)");
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_24() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val iterable = testdata.MethodOverrides4.staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_25() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val Iterable<java.io.Serializable> iterable = testdata.MethodOverrides4.staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Ignore("TODO eager binding of type arguments to expectation")
	@Test public void testStaticFeatureCall_26() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val Iterable<CharSequence> iterable = testdata.MethodOverrides4.staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides3.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_27() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val Iterable<Object> iterable = testdata.MethodOverrides4.staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_28() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val Iterable<Object> iterable = testdata.MethodOverrides4.staticM5(null) }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("testdata.MethodOverrides4.staticM5(T)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_29() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val int x = nested.NestedTypes.array }");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("nested.NestedTypes$array", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_30() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val boolean x = nested.NestedTypes.isInterface}");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("nested.NestedTypes.isInterface()", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_31() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val boolean x = nested.NestedTypes.primitive}");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("nested.NestedTypes$primitive", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testStaticFeatureCall_32() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ val boolean x = nested.NestedTypes.annotation}");
		XVariableDeclaration variable = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) variable.getRight();
		assertEquals("nested.NestedTypes.annotation", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testGenerics() throws Exception {
		expression("new testdata.GenericType1<String>() += 'foo'", true);
	}
	
	@Test public void testGenerics_1() throws Exception {
		expression("(null as testdata.GenericType1<? extends java.lang.String>) += null", true);
	}
	
	@Test public void testGenerics_2() throws Exception {
		// linking is ok but should trigger a validation error
		XExpression expression = expression("(null as testdata.GenericType1<? extends java.lang.StringBuffer>) += new StringBuffer", false);
		EcoreUtil.resolveAll(expression);
		List<Resource.Diagnostic> errors = expression.eResource().getErrors();
		assertEquals(errors.toString(), 1, errors.size());
		assertEquals("Type mismatch: type StringBuffer is not applicable at this location", errors.get(0).getMessage());
	}
	
	@Test public void testGenerics_3() throws Exception {
		// linking is ok but should trigger a validation error
		XExpression expression = expression("(null as testdata.GenericType1<? extends java.lang.String>) += 'foo'", false);
		EcoreUtil.resolveAll(expression);
		List<Resource.Diagnostic> errors = expression.eResource().getErrors();
		assertEquals(errors.toString(), 1, errors.size());
		assertEquals("Type mismatch: type String is not applicable at this location", errors.get(0).getMessage());
	}
	
	@Test public void testGenerics_4() throws Exception {
		expression("new testdata.GenericType1() += 'foo'", true);
	}
	
	@Test public void testImplicitThis_1() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val this = new java.util.ArrayList<String>(); " +
				"	size;" +
				"}");
		final XFeatureCall xFeatureCall = (XFeatureCall)bop.getExpressions().get(1);
		assertEquals("java.util.ArrayList.size()",xFeatureCall.getFeature().getIdentifier());
		assertSame(bop.getExpressions().get(0), ((XAbstractFeatureCall)xFeatureCall.getImplicitReceiver()).getFeature());
	}
	
	@Test public void testImplicitThis_2() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val this = new java.util.ArrayList<String>(); " +
				"	size();" +
				"}");
		assertEquals("java.util.ArrayList.size()",((XFeatureCall)bop.getExpressions().get(1)).getFeature().getIdentifier());
	}
	
	@Test public void testImplicitThis_3() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val java.util.List this = new java.util.ArrayList<String>(); " +
				"	size;" +
				"}");
		assertEquals("java.util.List.size()",((XFeatureCall)bop.getExpressions().get(1)).getFeature().getIdentifier());
	}
	
	@Test public void testImplicitThis_4() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val java.util.List this = new java.util.ArrayList<String>(); " +
				"	size();" +
				"}");
		assertEquals("java.util.List.size()",((XFeatureCall)bop.getExpressions().get(1)).getFeature().getIdentifier());
	}
	
	@Test public void testLinkingToInvisibleElements() throws Exception {
		XMemberFeatureCall expression = (XMemberFeatureCall) expression("new testdata.GenericType1<String>().t.value");
		assertEquals("java.lang.String.value", expression.getFeature().getIdentifier());
		assertTrue(((JvmMember)expression.getFeature()).getVisibility()==JvmVisibility.PRIVATE);
	}
	
	@Test public void testLocalVarAssignment_1() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = ''; x = '' }");
		XAssignment assignment = (XAssignment) block.getExpressions().get(1);
		assertNull(assignment.getAssignable());
		assertTrue(String.valueOf(assignment.getFeature()), assignment.getFeature() instanceof XVariableDeclaration);
		assertSame(block.getExpressions().get(0), assignment.getFeature());
	}
	
	@Test public void testMemberCall() throws Exception {
		XMemberFeatureCall expression = (XMemberFeatureCall) expression("'x'.length()");
		assertEquals("java.lang.String.length()",expression.getFeature().getIdentifier());
	}
	
	@Test public void testPropertyAccess_1() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("new testdata.Properties1().prop1");
		assertTrue(exp.getFeature() instanceof JvmField);
		assertEquals("testdata.Properties1.prop1",exp.getFeature().getIdentifier());
	}
	
	@Test public void testPropertyAccess_2() throws Exception {
		XMemberFeatureCall exp1 = (XMemberFeatureCall) expression("new testdata.Properties1().getProp1");
		XMemberFeatureCall exp2 = (XMemberFeatureCall) expression("new testdata.Properties1().getProp1()");
		assertEquals(exp1.getFeature().getIdentifier(),exp2.getFeature().getIdentifier());
	}
	
	@Test public void testPropertyAccess_4() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("new testdata.Properties1().prop2");
		assertTrue(exp.getFeature().toString(), exp.getFeature() instanceof JvmOperation);
		assertEquals("testdata.Properties1.getProp2()",exp.getFeature().getIdentifier());
	}
	
	@Test public void testPropertyAccess_5() throws Exception {
		XMemberFeatureCall exp1 = (XMemberFeatureCall) expression("new testdata.Properties1().getProp2");
		XMemberFeatureCall exp2 = (XMemberFeatureCall) expression("new testdata.Properties1().getProp2()");
		assertEquals(exp1.getFeature().getIdentifier(),exp2.getFeature().getIdentifier());
	}
	
	@Test public void testPropertyAccess_6() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("(null as instanceVsStatic.C).OK");
		assertEquals("instanceVsStatic.C.isOK()", exp.getFeature().getIdentifier());
	}
	
	@Test public void testPropertyAccess_7() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("instanceVsStatic::C::OK");
		assertEquals("instanceVsStatic.C.OK", exp.getFeature().getIdentifier());
	}
	
	@Test public void testPropertyAccess_8() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("instanceVsStatic.C::OK");
		assertEquals("instanceVsStatic.C.OK", exp.getFeature().getIdentifier());
	}
	
	@Test public void testPropertySetter_1() throws Exception {
		XAssignment exp = (XAssignment) expression("new testdata.Properties1().prop1 = 'Text'");
		assertEquals(((XConstructorCall)exp.getAssignable()).getConstructor().getDeclaringType(), ((JvmField)exp.getFeature()).getDeclaringType());
	}
	
	@Test public void testPropertySetter_2() throws Exception {
		XAssignment exp = (XAssignment) expression("new testdata.Properties1().prop2 = 'Text'");
		assertEquals("testdata.Properties1.setProp2(java.lang.String)", exp.getFeature().getIdentifier());
	}
	
	@Test public void testStaticVsInstance_1() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("(null as instanceVsStatic.C).toString");
		assertEquals("java.lang.Object.toString()", exp.getFeature().getIdentifier());
	}
	
	@Test public void testStaticVsInstance_2() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("(null as instanceVsStatic.C).toString(null)");
		assertEquals("instanceVsStatic.C.toString(instanceVsStatic.C)", exp.getFeature().getIdentifier());
	}
	
	@Test public void testStaticVsInstance_3() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("(null as instanceVsStatic.C).m1(1)");
		assertEquals("instanceVsStatic.C.m1(int)", exp.getFeature().getIdentifier());
	}
	
	@Test public void testStaticVsInstance_4() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("(null as instanceVsStatic.C).m1(1, 2)");
		assertEquals("instanceVsStatic.C.m1(instanceVsStatic.C,int)", exp.getFeature().getIdentifier());
	}
	
	@Test public void testStaticVsInstance_5() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("(null as instanceVsStatic.C).m1(null)");
		assertEquals("instanceVsStatic.C.m1(int)", exp.getFeature().getIdentifier());
	}
	
	@Test public void testStaticVsInstance_6() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("(null as instanceVsStatic.C).m2(1)");
		assertEquals("instanceVsStatic.C.m2(int)", exp.getFeature().getIdentifier());
	}
	
	@Test public void testStaticVsInstance_7() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("(null as instanceVsStatic.C).m2(1, 2)");
		assertEquals("instanceVsStatic.C.m2(int)", exp.getFeature().getIdentifier());
	}
	
	@Test public void testStaticVsInstance_8() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("instanceVsStatic::C::m2(1, 2)");
		assertEquals("instanceVsStatic.C.m2(instanceVsStatic.C,int,int)", exp.getFeature().getIdentifier());
	}
	
	@Test public void testStaticVsInstance_9() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("instanceVsStatic.C::m2(1, 2)");
		assertEquals("instanceVsStatic.C.m2(instanceVsStatic.C,int,int)", exp.getFeature().getIdentifier());
	}
	
	@Test public void testShadowing_1() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val this = new java.util.List<String>(); " +
				"	val size = 23;" +
				"	size;" +
				"}", false);
		final JvmIdentifiableElement feature = ((XFeatureCall)bop.getExpressions().get(2)).getFeature();
		assertTrue(feature.getClass().getName(), feature instanceof XVariableDeclaration);
		
		XConstructorCall xConstructorCall = (XConstructorCall)((XVariableDeclaration)bop.getExpressions().get(0)).getRight();
		assertTrue(xConstructorCall.getConstructor().eIsProxy());
	}
	
	@Test public void testShadowing_2() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val size = 23;" +
				"	val this = new java.util.ArrayList<String>(); " +
				"	size;" +
				"}");
		JvmIdentifiableElement feature = ((XFeatureCall)bop.getExpressions().get(2)).getFeature();
		assertTrue(feature.toString(), feature instanceof XVariableDeclaration);
	}
	
	@Test public void testShadowing_3() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	{" +
				"		val this = new java.util.ArrayList<String>(); " +
				"		size;" +
				"	};" +
				"}");
		XBlockExpression innerBlock = (XBlockExpression)bop.getExpressions().get(1);
		assertSame(bop.getExpressions().get(0),((XFeatureCall)innerBlock.getExpressions().get(1)).getFeature());
	}
	
	@Test public void testShadowing_4() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	{" +
				"		val this = new java.util.ArrayList<String>(); " +
				"		size();" +
				"	};" +
				"}");
		XBlockExpression innerBlock = (XBlockExpression)bop.getExpressions().get(1);
		assertEquals("java.util.ArrayList.size()",((XFeatureCall)innerBlock.getExpressions().get(1)).getFeature().getIdentifier());
	}
	
	@Test public void testShadowing_5() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	[String size|size];" +
				"}");
		XClosure closure = (XClosure)bop.getExpressions().get(1);
		assertSame(closure.getFormalParameters().get(0), ((XFeatureCall)((XBlockExpression)closure.getExpression()).getExpressions().get(0)).getFeature());
	}
	
	@Test public void testShadowing_6() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	[String x|size];" +
				"}");
		XClosure closure = (XClosure)bop.getExpressions().get(1);
		assertSame(bop.getExpressions().get(0), ((XFeatureCall)((XBlockExpression)closure.getExpression()).getExpressions().get(0)).getFeature());
	}
	
	@Test public void testShadowing_7() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	[String size| [String x|size]];" +
				"}");
		XClosure closure = (XClosure)bop.getExpressions().get(1);
		assertSame(closure.getFormalParameters().get(0), ((XFeatureCall)((XBlockExpression)((XClosure)((XBlockExpression)closure.getExpression()).getExpressions().get(0)).getExpression()).getExpressions().get(0)).getFeature());
	}
	
	@Test public void testShadowing_8() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	{" +
				"		val this = new java.util.ArrayList<String>(); " +
				"		size;" +
				"	};" +
				"}");
		XBlockExpression innerBlock = (XBlockExpression)bop.getExpressions().get(1);
		assertEquals(bop.getExpressions().get(0), ((XFeatureCall)innerBlock.getExpressions().get(1)).getFeature());
	}
	
	@Test public void testSwitchExpression_00() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{ " +
				"  val Object x = new testdata.MethodOverrides2(); " +
				"  switch x { " +
				"    testdata.Properties1 : x" +
				"    testdata.MethodOverrides2 case x : 'bar'" +
				"    default : 'baz'" +
				"  }" +
				"}");
		XVariableDeclaration xDeclaration = (XVariableDeclaration) block.getExpressions().get(0); 
		XSwitchExpression switchExpr = (XSwitchExpression) block.getExpressions().get(1);
		XFeatureCall feature = (XFeatureCall) switchExpr.getSwitch();
		assertEquals(xDeclaration, feature.getFeature());
		feature = (XFeatureCall) switchExpr.getCases().get(1).getCase();
		assertEquals(xDeclaration, feature.getFeature());
	}
	
	@Test public void testSwitchExpression_01() throws Exception {
		XSwitchExpression switchExpr = (XSwitchExpression) expression(
				"switch x : new Object() { " +
				"   case x : x" +
		"}");
		final XCasePart xCasePart = switchExpr.getCases().get(0);
		assertEquals(switchExpr.getDeclaredParam(), ((XFeatureCall) xCasePart.getThen()).getFeature());
		assertEquals(switchExpr.getDeclaredParam(), ((XFeatureCall) xCasePart.getCase()).getFeature());
	}
	
	@Test public void testSwitchExpression_02() throws Exception {
		XSwitchExpression switchExpr = (XSwitchExpression) expression(
				"switch x : new Object() { " +
				"    case true : true "+
				"    default : x" +
				"}");
		assertEquals(switchExpr.getDeclaredParam(), ((XFeatureCall)switchExpr.getDefault()).getFeature());
	}
	
	@Test public void testSwitchExpression_03() throws Exception {
		XSwitchExpression switchExpr = (XSwitchExpression) expression(
				"switch x : 'foo' as CharSequence {" +
				"  Comparable : x.toString()" +
				"}");
		XMemberFeatureCall then = (XMemberFeatureCall) switchExpr.getCases().get(0).getThen();
		assertEquals("java.lang.CharSequence.toString()", then.getFeature().getIdentifier());
	}
	
	@Test public void testTryCatch_0() throws Exception {
		XTryCatchFinallyExpression exp = (XTryCatchFinallyExpression) expression("try 'foo' catch (Exception e) e",true);
		XCatchClause xCatchClause = exp.getCatchClauses().get(0);
		assertSame(xCatchClause.getDeclaredParam(), ((XFeatureCall)xCatchClause.getExpression()).getFeature());
	}
	
	@Test public void testTryCatch_1() throws Exception {
		expression("try { null as Boolean } catch(ClassCastException e) {e.getClass().getSimpleName()}", true);
	}
	
	@Test public void testForLoop_01() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{val s = null as Iterable<String>; for(String s: s) s}");
		XForLoopExpression forLoop = (XForLoopExpression) block.getExpressions().get(1);
		XFeatureCall forFeatureCall = (XFeatureCall) forLoop.getForExpression();
		assertEquals(block.getExpressions().get(0), forFeatureCall.getFeature());
		XFeatureCall eachFeatureCall = (XFeatureCall) forLoop.getEachExpression();
		assertFalse(eachFeatureCall.getFeature().eIsProxy());
		assertSame(forLoop.getDeclaredParam(), eachFeatureCall.getFeature());
	}
	
	@Test public void testExtensionMethodOnThis_01() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{ var Iterable<String> this = newArrayList('').map(s|1).toList() map(i|i+1) }");
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.map(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodOnThis_02() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{ var Iterable<String> this = newArrayList('').map(s|1).toList() this.map(i|i+1) }");
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.map(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodOnThis_03() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{ var this = newArrayList('').map(s|1).toList() map(i|i+1) }");
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.ListExtensions.map(java.util.List,org.eclipse.xtext.xbase.lib.Functions$Function1)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodOnThis_04() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{ var this = newArrayList('').map(s|1).toList() this.map(i|i+1) }");
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.ListExtensions.map(java.util.List,org.eclipse.xtext.xbase.lib.Functions$Function1)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodOnArray_01() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{ (null as String[]).size }");
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) block.getExpressions().get(0);
		assertEquals("java.util.List.size()", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethod_Map() throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("newArrayList().map[42]");
		assertEquals("org.eclipse.xtext.xbase.lib.ListExtensions.map(java.util.List,org.eclipse.xtext.xbase.lib.Functions$Function1)", featureCall.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnNull_01() throws Exception {
		XMemberFeatureCall toString = (XMemberFeatureCall) expression("null.toString");
		assertTrue(toString.getFeature().eIsProxy());
	}
	
	@Ignore("isNullOrEmpty is ambiguous - should be flagged as such")
	@Test public void testMemberCallOnNull_02() throws Exception {
		XMemberFeatureCall nullOrEmpty = (XMemberFeatureCall) expression("null.isNullOrEmpty");
		JvmIdentifiableElement feature = nullOrEmpty.getFeature();
		assertFalse(feature.toString(), feature.eIsProxy());
	}
	
	@Test public void testMemberCallOnNull_03() throws Exception {
		XBinaryOperation equals = (XBinaryOperation) expression("null == 'literal'");
		assertFalse(equals.getFeature().eIsProxy());
	}
	
	@Test public void testMemberCallOnNull_04() throws Exception {
		XBinaryOperation equalsNot = (XBinaryOperation) expression("null != 'literal'");
		assertFalse(equalsNot.getFeature().eIsProxy());
	}
	
	@Test public void testMemberCallOnNull_05() throws Exception {
		XBinaryOperation mappedTo = (XBinaryOperation) expression("null -> 'literal'");
		assertFalse(mappedTo.getFeature().eIsProxy());
	}
	
	@Test public void testMemberCallOnNull_06() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = null x.toString }");
		XMemberFeatureCall toString = (XMemberFeatureCall) block.getExpressions().get(1);
		assertTrue(toString.getFeature().eIsProxy());
	}
	
	@Ignore("isNullOrEmpty is ambiguous - should be flagged as such")
	@Test public void testMemberCallOnNull_07() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = null x.isNullOrEmpty }");
		XMemberFeatureCall nullOrEmpty = (XMemberFeatureCall) block.getExpressions().get(1);
		assertFalse(nullOrEmpty.getFeature().toString(), nullOrEmpty.getFeature().eIsProxy());
	}
	
	@Test public void testMemberCallOnNull_08() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = null x == 'literal' }");
		XBinaryOperation equals = (XBinaryOperation) block.getExpressions().get(1);
		assertFalse(equals.getFeature().eIsProxy());
	}
	
	@Test public void testMemberCallOnNull_09() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = null x != 'literal' }");
		XBinaryOperation equalsNot = (XBinaryOperation) block.getExpressions().get(1);
		assertFalse(equalsNot.getFeature().eIsProxy());
	}
	
	@Test public void testMemberCallOnNull_10() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = null x -> 'literal' }");
		XBinaryOperation mappedTo = (XBinaryOperation) block.getExpressions().get(1);
		assertFalse(mappedTo.getFeature().eIsProxy());
	}
	
	@Test public void testMemberCallOnNull_11() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = null toString }");
		XFeatureCall toString = (XFeatureCall) block.getExpressions().get(1);
		assertTrue(toString.getFeature().eIsProxy());
	}
	
	@Ignore("isNullOrEmpty is ambiguous - should be flagged as such")
	@Test public void testMemberCallOnNull_12() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = null isNullOrEmpty }");
		XFeatureCall nullOrEmpty = (XFeatureCall) block.getExpressions().get(1);
		assertFalse(nullOrEmpty.getFeature().toString(), nullOrEmpty.getFeature().eIsProxy());
	}
	
	@Test public void testMemberCallOnMultiType_01() throws Exception {
		XMemberFeatureCall compareTo = (XMemberFeatureCall) expression("(if (true) new Double('') else new Integer('')).compareTo(null)");
		assertEquals("java.lang.Comparable.compareTo(T)", compareTo.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnMultiType_02() throws Exception {
		XMemberFeatureCall intValue = (XMemberFeatureCall) expression("(if (true) new Double('') else new Integer('')).intValue");
		assertEquals("java.lang.Number.intValue()", intValue.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnMultiType_03() throws Exception {
		XMemberFeatureCall intValue = (XMemberFeatureCall) expression(
				"newArrayList.map(e|if (true) new Double('') else new Integer('')).head.intValue");
		assertEquals("java.lang.Number.intValue()", intValue.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnMultiType_04() throws Exception {
		XMemberFeatureCall compareTo = (XMemberFeatureCall) expression(
				"newArrayList.map(e|if (true) new Double('') else new Integer('')).head.compareTo(null)");
		assertEquals("java.lang.Comparable.compareTo(T)", compareTo.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnMultiType_05() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var number = if (true) new Double('') else new Integer('') number.compareTo(number) }");
		XMemberFeatureCall compareTo = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("java.lang.Comparable.compareTo(T)", compareTo.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnMultiType_06() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var number = if (true) new Double('') else new Integer('') number.intValue }");
		XMemberFeatureCall intValue = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("java.lang.Number.intValue()", intValue.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnMultiType_07() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = if (true) new Double('') else new Integer('') compareTo(this) }");
		XFeatureCall compareTo = (XFeatureCall) block.getExpressions().get(1);
		assertEquals("java.lang.Comparable.compareTo(T)", compareTo.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnMultiType_08() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = if (true) new Double('') else new Integer('') intValue }");
		XFeatureCall intValue = (XFeatureCall) block.getExpressions().get(1);
		assertEquals("java.lang.Number.intValue()", intValue.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnMultiType_09() throws Exception {
		XBinaryOperation greaterOrEqualThan = (XBinaryOperation) expression("(if (true) new Double('') else new Integer('')) >= 0");
		assertEquals("org.eclipse.xtext.xbase.lib.ComparableExtensions.operator_greaterEqualsThan(java.lang.Comparable,C)", greaterOrEqualThan.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnMultiType_10() throws Exception {
		XBinaryOperation lessThan = (XBinaryOperation) expression("(if (true) new Double('') else new Integer('')) < 0");
		assertEquals("org.eclipse.xtext.xbase.lib.ComparableExtensions.operator_lessThan(java.lang.Comparable,C)", lessThan.getFeature().getIdentifier());
	}
	
	@Test public void testMemberCallOnMultiTypeWithUnresolvableArgument_01() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = if (true) new Double('') else new Integer('') compareTo(number) }");
		XFeatureCall compareTo = (XFeatureCall) block.getExpressions().get(1);
		assertEquals("java.lang.Comparable.compareTo(T)", compareTo.getFeature().getIdentifier());
	}
	
	@Test public void testOverloadedMethods_01() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<CharSequence> chars = null\n" +
				"    var java.util.List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(chars, strings)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.util.Collection,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_02() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<CharSequence> chars = null\n" +
				"    var java.util.List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(strings, chars)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.lang.Iterable,java.util.Collection)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_03() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(strings, strings)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.util.List,java.util.List)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_04() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<? extends Object> objects = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(objects, objects)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.lang.Iterable,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_05() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<?> any = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(any, any)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.lang.Iterable,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethodsJava_01() throws Exception {
		List<CharSequence> chars = null;
		List<String> strings = null;
		List<? extends Object> objects = null;
		List<?> wildcards = null;
		assertEquals("overloaded(Collection,Iterable)", new OverloadedMethods<Object>().overloaded(chars, strings));
		assertEquals("overloaded(Iterable,Collection)", new OverloadedMethods<Object>().overloaded(strings, chars));
		assertEquals("overloaded(List,List)", new OverloadedMethods<Object>().overloaded(strings, strings));
		assertEquals("overloaded(List,List)", new OverloadedMethods<Object>().overloaded(chars, chars));
		assertEquals("overloaded(Iterable,Iterable)", new OverloadedMethods<Object>().overloaded(objects, objects));
		assertEquals("overloaded(Iterable,Iterable)", new OverloadedMethods<Object>().overloaded(wildcards, wildcards));
	}
	
	@Test public void testOverloadedMethods_06() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<CharSequence> chars = null\n" +
				"    var java.util.List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<CharSequence> receiver = null\n" +
				"    receiver.overloaded2(chars, strings)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.util.Collection,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_07() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<CharSequence> chars = null\n" +
				"    var java.util.List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<CharSequence> receiver = null\n" +
				"    receiver.overloaded2(strings, chars)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.lang.Iterable,java.util.Collection)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_08() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<String> receiver = null\n" +
				"    receiver.overloaded2(strings, strings)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.util.List,java.util.List)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_09() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<? extends Object> objects = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded2(objects, objects)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.lang.Iterable,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_10() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<? extends CharSequence> chars = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded2(chars, chars)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.lang.Iterable,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethodsJava_02() throws Exception {
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
	
	@Test public void testBoxingUnboxing_01() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var int i = 0\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloadedInt(i)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloadedInt(int)", overloaded.getIdentifier());
	}
	
	@Test public void testBoxingUnboxing_02() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var Integer i = 0\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloadedInt(i)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloadedInt(java.lang.Integer)", overloaded.getIdentifier());
	}
	
	@Test public void testBoxingUnboxingJava_03() throws Exception {
		int i = 0;
		Integer integer = null;
		assertEquals("overloadedInt(int)", new OverloadedMethods<Object>().overloadedInt(i));
		assertEquals("overloadedInt(Integer)", new OverloadedMethods<Object>().overloadedInt(integer));
	}
	
	@Test public void testOverloadedConstructors_01() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    new testdata.OverloadedMethods<Object>()\n" +
				"}");
		XConstructorCall constructorCall = (XConstructorCall) block.getExpressions().get(0);
		JvmConstructor constructor = constructorCall.getConstructor();
		assertNotNull(constructor);
		assertFalse(constructor.eIsProxy());
		assertEquals("testdata.OverloadedMethods.OverloadedMethods()", constructor.getIdentifier());
	}
	
	@Test public void testOverloadedConstructors_02() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<CharSequence> chars = null\n" +
				"    var java.util.List<String> strings = null\n" +
				"    new testdata.OverloadedMethods<CharSequence>(chars, strings)\n" +
				"}");
		XConstructorCall constructorCall = (XConstructorCall) block.getExpressions().get(2);
		JvmConstructor constructor = constructorCall.getConstructor();
		assertNotNull(constructor);
		assertFalse(constructor.eIsProxy());
		assertEquals("testdata.OverloadedMethods.OverloadedMethods(java.util.Collection,java.lang.Iterable)", constructor.getIdentifier());
	}
	
	@Test public void testOverloadedConstructors_03() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<CharSequence> chars = null\n" +
				"    var java.util.List<String> strings = null\n" +
				"    new testdata.OverloadedMethods<CharSequence>(strings, chars)\n" +
				"}");
		XConstructorCall constructorCall = (XConstructorCall) block.getExpressions().get(2);
		JvmConstructor constructor = constructorCall.getConstructor();
		assertNotNull(constructor);
		assertFalse(constructor.eIsProxy());
		assertEquals("testdata.OverloadedMethods.OverloadedMethods(java.lang.Iterable,java.util.Collection)", constructor.getIdentifier());
	}
	
	@Test public void testOverloadedConstructors_04() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<CharSequence> chars = null\n" +
				"    new testdata.OverloadedMethods<CharSequence>(chars, chars)\n" +
				"}");
		XConstructorCall constructorCall = (XConstructorCall) block.getExpressions().get(1);
		JvmConstructor constructor = constructorCall.getConstructor();
		assertNotNull(constructor);
		assertFalse(constructor.eIsProxy());
		assertEquals("testdata.OverloadedMethods.OverloadedMethods(java.util.List,java.util.List)", constructor.getIdentifier());
	}
	
	@Test public void testOverloadedConstructors_05() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<String> strings = null\n" +
				"    new testdata.OverloadedMethods<String>(strings, strings)\n" +
				"}");
		XConstructorCall constructorCall = (XConstructorCall) block.getExpressions().get(1);
		JvmConstructor constructor = constructorCall.getConstructor();
		assertNotNull(constructor);
		assertFalse(constructor.eIsProxy());
		assertEquals("testdata.OverloadedMethods.OverloadedMethods(java.util.List,java.util.List)", constructor.getIdentifier());
	}
	
	@Test public void testOverloadedConstructors_06() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<CharSequence> chars = null\n" +
				"    new testdata.OverloadedMethods<Object>(chars, chars)\n" +
				"}");
		XConstructorCall constructorCall = (XConstructorCall) block.getExpressions().get(1);
		JvmConstructor constructor = constructorCall.getConstructor();
		assertNotNull(constructor);
		assertFalse(constructor.eIsProxy());
		assertEquals("testdata.OverloadedMethods.OverloadedMethods(java.lang.Iterable,java.lang.Iterable)", constructor.getIdentifier());
	}
	
	@Test public void testOverloadedConstructors_07() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<? extends Object> objects = null\n" +
				"    new testdata.OverloadedMethods<Object>(objects, objects)\n" +
				"}");
		XConstructorCall constructorCall = (XConstructorCall) block.getExpressions().get(1);
		JvmConstructor constructor = constructorCall.getConstructor();
		assertNotNull(constructor);
		assertFalse(constructor.eIsProxy());
		assertEquals("testdata.OverloadedMethods.OverloadedMethods(java.lang.Iterable,java.lang.Iterable)", constructor.getIdentifier());
	}
	
	@Test public void testOverloadedConstructors_08() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<CharSequence> chars = null\n" +
				"    var java.util.List<String> strings = null\n" +
				"    new testdata.OverloadedMethods<Object>(chars, strings)\n" +
				"}");
		XConstructorCall constructorCall = (XConstructorCall) block.getExpressions().get(2);
		JvmConstructor constructor = constructorCall.getConstructor();
		assertNotNull(constructor);
		assertFalse(constructor.eIsProxy());
		assertEquals("testdata.OverloadedMethods.OverloadedMethods(java.lang.Iterable,java.lang.Iterable)", constructor.getIdentifier());
	}
	
	@Test public void testOverloadedConstructors_09() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" +
				"    var java.util.List<CharSequence> chars = null\n" +
				"    var java.util.List<String> strings = null\n" +
				"    new testdata.OverloadedMethods<Object>(strings, chars)\n" +
				"}");
		XConstructorCall constructorCall = (XConstructorCall) block.getExpressions().get(2);
		JvmConstructor constructor = constructorCall.getConstructor();
		assertNotNull(constructor);
		assertFalse(constructor.eIsProxy());
		assertEquals("testdata.OverloadedMethods.OverloadedMethods(java.lang.Iterable,java.lang.Iterable)", constructor.getIdentifier());
	}
	
	@Test public void testOverloadedConstructorsJava_01() throws Exception {
		List<CharSequence> chars = null;
		List<String> strings = null;
		List<? extends Object> objects = null;
		assertEquals(0, new OverloadedMethods<CharSequence>().usedConstructor);
		assertEquals(1, new OverloadedMethods<CharSequence>(chars, strings).usedConstructor);
		assertEquals(2, new OverloadedMethods<CharSequence>(strings, chars).usedConstructor);
		assertEquals(3, new OverloadedMethods<CharSequence>(chars, chars).usedConstructor);
		assertEquals(3, new OverloadedMethods<String>(strings, strings).usedConstructor);
		assertEquals(4, new OverloadedMethods<Object>(chars, chars).usedConstructor);
		assertEquals(4, new OverloadedMethods<Object>(strings, strings).usedConstructor);
		assertEquals(4, new OverloadedMethods<Object>(objects, objects).usedConstructor);
		assertEquals(4, new OverloadedMethods<Object>(chars, strings).usedConstructor);
		assertEquals(4, new OverloadedMethods<Object>(strings, chars).usedConstructor);
	}

	
}
