/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
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
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseLinkingScopeProviderTest extends AbstractXbaseTestCase {
	
	public void testAssignment_1() throws Exception {
		XBinaryOperation assignment = (XBinaryOperation) expression("new java.util.ArrayList<String>() += 'foo'", true);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,E)", assignment.getFeature().getIdentifier());
	}
	
	public void testAssignment_2() throws Exception {
		XBinaryOperation assignment = (XBinaryOperation) expression("new java.util.ArrayList<CharSequence>() += new java.util.ArrayList<String>()", true);
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,java.lang.Iterable)",assignment.getFeature().getIdentifier());
	}
	
	public void testAssignmentToInvisibleElements() throws Exception {
		XAssignment expression = (XAssignment) expression("new testdata.GenericType1<String>().t = 'foo'");
		assertEquals("testdata.GenericType1.t", expression.getFeature().getIdentifier());
		assertTrue(((JvmMember)expression.getFeature()).getVisibility()==JvmVisibility.PRIVATE);
	}
	
	public void testConstructorCall_00() throws Exception {
		XConstructorCall expression = (XConstructorCall) expression("new java.util.ArrayList<String>(42)");
		assertEquals("java.util.ArrayList.ArrayList(int)", expression.getConstructor().getIdentifier());
	}
	
	public void testConstructorCall_01() throws Exception {
		XConstructorCall expression = (XConstructorCall) expression("new java.util.ArrayList<String>()");
		assertEquals("java.util.ArrayList.ArrayList()", expression.getConstructor().getIdentifier());
	}
	
	public void testEscapedQualifiedName() throws Exception {
		XCastedExpression expression = (XCastedExpression) expression("null as ^testdata/* foobar */.^FieldAccessSub");
		assertFalse(expression.getType().getType().eIsProxy());
	}
	
	public void testFeatureCall() throws Exception {
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
	
	public void testFeatureCall_1() throws Exception {
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
	
	public void testFeatureCall_2() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{" +
				"  val this = new testdata.FieldAccessSub();" +
				"  privateField;" +
				"  privateField();" +
		"}");
		XFeatureCall call1 = (XFeatureCall) block.getExpressions().get(1);
		XFeatureCall call2 = (XFeatureCall) block.getExpressions().get(2);
		assertEquals("testdata.FieldAccessSub.privateField()",((JvmOperation)call1.getFeature()).getIdentifier());
		assertSame(call1.getFeature(),call2.getFeature());
	}
	
	public void testFeatureCall_3() throws Exception {
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
	
	public void testFeatureCall_4() throws Exception {
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
	
	public void testGenerics() throws Exception {
		expression("new testdata.GenericType1<String>() += 'foo'", true);
	}
	
	public void testGenerics_1() throws Exception {
		expression("(null as testdata.GenericType1<? extends java.lang.String>) += null", true);
		// linking is ok but should trigger a validation error
		XExpression expression = expression("(null as testdata.GenericType1<? extends java.lang.String>) += 'foo'", false);
		EcoreUtil.resolveAll(expression);
		assertTrue(expression.eResource().getErrors().isEmpty());
	}
	
	public void testGenerics_2() throws Exception {
		expression("new testdata.GenericType1() += 'foo'", true);
	}
	
	public void testImplicitThis_1() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val this = new java.util.ArrayList<String>(); " +
				"	size;" +
				"}");
		final XFeatureCall xFeatureCall = (XFeatureCall)bop.getExpressions().get(1);
		assertEquals("java.util.ArrayList.size()",xFeatureCall.getFeature().getIdentifier());
		assertSame(bop.getExpressions().get(0), ((XAbstractFeatureCall)xFeatureCall.getImplicitReceiver()).getFeature());
	}
	
	public void testImplicitThis_2() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val this = new java.util.ArrayList<String>(); " +
				"	size();" +
				"}");
		assertEquals("java.util.ArrayList.size()",((XFeatureCall)bop.getExpressions().get(1)).getFeature().getIdentifier());
	}
	
	public void testImplicitThis_3() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val java.util.List this = new java.util.ArrayList<String>(); " +
				"	size;" +
				"}");
		assertEquals("java.util.List.size()",((XFeatureCall)bop.getExpressions().get(1)).getFeature().getIdentifier());
	}
	
	public void testImplicitThis_4() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val java.util.List this = new java.util.ArrayList<String>(); " +
				"	size();" +
				"}");
		assertEquals("java.util.List.size()",((XFeatureCall)bop.getExpressions().get(1)).getFeature().getIdentifier());
	}
	
	public void testLinkingToInvisibleElements() throws Exception {
		XMemberFeatureCall expression = (XMemberFeatureCall) expression("new testdata.GenericType1<String>().t.offset");
		assertEquals("java.lang.String.offset", expression.getFeature().getIdentifier());
		assertTrue(((JvmMember)expression.getFeature()).getVisibility()==JvmVisibility.PRIVATE);
	}
	
	public void testLocalVarAssignment_1() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = ''; x = '' }");
		XAssignment assignment = (XAssignment) block.getExpressions().get(1);
		assertNull(assignment.getAssignable());
		assertTrue(String.valueOf(assignment.getFeature()), assignment.getFeature() instanceof XVariableDeclaration);
		assertSame(block.getExpressions().get(0), assignment.getFeature());
	}
	
	public void testMemberCall() throws Exception {
		XMemberFeatureCall expression = (XMemberFeatureCall) expression("'x'.length()");
		assertEquals("java.lang.String.length()",expression.getFeature().getIdentifier());
	}
	
	public void testPropertyAccess_1() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("new testdata.Properties1().prop1");
		assertTrue(exp.getFeature() instanceof JvmField);
		assertEquals("testdata.Properties1.prop1",exp.getFeature().getIdentifier());
	}
	
	public void testPropertyAccess_2() throws Exception {
		XMemberFeatureCall exp1 = (XMemberFeatureCall) expression("new testdata.Properties1().getProp1");
		XMemberFeatureCall exp2 = (XMemberFeatureCall) expression("new testdata.Properties1().getProp1()");
		assertEquals(exp1.getFeature().getIdentifier(),exp2.getFeature().getIdentifier());
	}
	
	public void testPropertyAccess_4() throws Exception {
		XMemberFeatureCall exp = (XMemberFeatureCall) expression("new testdata.Properties1().prop2");
		assertTrue(exp.getFeature() instanceof JvmOperation);
		assertEquals("testdata.Properties1.getProp2()",exp.getFeature().getIdentifier());
	}
	
	public void testPropertyAccess_5() throws Exception {
		XMemberFeatureCall exp1 = (XMemberFeatureCall) expression("new testdata.Properties1().getProp2");
		XMemberFeatureCall exp2 = (XMemberFeatureCall) expression("new testdata.Properties1().getProp2()");
		assertEquals(exp1.getFeature().getIdentifier(),exp2.getFeature().getIdentifier());
	}
	
	public void testPropertySetter_1() throws Exception {
		XAssignment exp = (XAssignment) expression("new testdata.Properties1().prop1 = 'Text'");
		assertEquals(((XConstructorCall)exp.getAssignable()).getConstructor().getDeclaringType(), ((JvmField)exp.getFeature()).getDeclaringType());
	}
	
	public void testPropertySetter_2() throws Exception {
		XAssignment exp = (XAssignment) expression("new testdata.Properties1().prop2 = 'Text'");
		assertEquals("testdata.Properties1.setProp2(java.lang.String)", exp.getFeature().getIdentifier());
	}
	
	public void testShadowing_1() throws Exception {
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
	
	public void testShadowing_2() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val size = 23;" +
				"	val this = new java.util.ArrayList<String>(); " +
				"	size;" +
				"}");
		assertTrue(((XFeatureCall)bop.getExpressions().get(2)).getFeature() instanceof XVariableDeclaration);
	}
	
	public void testShadowing_3() throws Exception {
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
	
	public void testShadowing_4() throws Exception {
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
	
	public void testShadowing_5() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	[String size|size];" +
				"}");
		XClosure closure = (XClosure)bop.getExpressions().get(1);
		assertSame(closure.getFormalParameters().get(0), ((XFeatureCall)closure.getExpression()).getFeature());
	}
	
	public void testShadowing_6() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	[String x|size];" +
				"}");
		XClosure closure = (XClosure)bop.getExpressions().get(1);
		assertSame(bop.getExpressions().get(0), ((XFeatureCall)closure.getExpression()).getFeature());
	}
	
	public void testShadowing_7() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	[String size| [String x|size]];" +
				"}");
		XClosure closure = (XClosure)bop.getExpressions().get(1);
		assertSame(closure.getFormalParameters().get(0), ((XFeatureCall)((XClosure)closure.getExpression()).getExpression()).getFeature());
	}
	
	public void testShadowing_8() throws Exception {
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
	
	public void testSwitchExpression_00() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{ " +
				"  val Object x = new testdata.MethodOverrides2(); " +
				"  switch x { " +
				"    testdata.Properties1 : x" +
				"    testdata.MethodOverrides2 case x : 'bar'" +
				"    default : 'baz'" +
				"  }" +
				"}");
		XSwitchExpression switchExpr = (XSwitchExpression) block.getExpressions().get(1);
		XFeatureCall feature = (XFeatureCall) switchExpr.getCases().get(0).getThen();
		assertEquals(switchExpr.getCases().get(0), feature.getFeature());
		feature = (XFeatureCall) switchExpr.getCases().get(1).getCase();
		assertEquals(switchExpr.getCases().get(1), feature.getFeature());
	}
	
	public void testSwitchExpression_01() throws Exception {
		XSwitchExpression switchExpr = (XSwitchExpression) expression(
				"switch x : new Object() { " +
				"   case x : x" +
		"}");
		final XCasePart xCasePart = switchExpr.getCases().get(0);
		assertEquals(switchExpr, ((XFeatureCall) xCasePart.getThen()).getFeature());
		assertEquals(switchExpr, ((XFeatureCall)xCasePart.getCase()).getFeature());
	}
	
	public void testSwitchExpression_02() throws Exception {
		XSwitchExpression switchExpr = (XSwitchExpression) expression(
				"switch x : new Object() { " +
				"    case true : true "+
				"    default : x" +
				"}");
		assertEquals(switchExpr, ((XFeatureCall)switchExpr.getDefault()).getFeature());
	}
	
	public void testTryCatch_0() throws Exception {
		XTryCatchFinallyExpression exp = (XTryCatchFinallyExpression) expression("try 'foo' catch (Exception e) e",true);
		XCatchClause xCatchClause = exp.getCatchClauses().get(0);
		assertSame(xCatchClause.getDeclaredParam(), ((XFeatureCall)xCatchClause.getExpression()).getFeature());
	}
	
	public void testTryCatch_1() throws Exception {
		expression("try { null as Boolean } catch(ClassCastException e) {e.getClass().getSimpleName()}", true);
	}
	
	public void testForLoop_01() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{val s = null as Iterable<String>; for(String s: s) s}");
		XForLoopExpression forLoop = (XForLoopExpression) block.getExpressions().get(1);
		XFeatureCall forFeatureCall = (XFeatureCall) forLoop.getForExpression();
		assertEquals(block.getExpressions().get(0), forFeatureCall.getFeature());
		XFeatureCall eachFeatureCall = (XFeatureCall) forLoop.getEachExpression();
		assertFalse(eachFeatureCall.getFeature().eIsProxy());
		assertSame(forLoop.getDeclaredParam(), eachFeatureCall.getFeature());
	}
	
	public void testExtensionMethodOnThis_01() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{ var Iterable<String> this = newArrayList('').map(s|1).toList() map(i|i+1) }");
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.map(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", featureCall.getFeature().getIdentifier());
	}
	
	public void testExtensionMethodOnThis_02() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{ var Iterable<String> this = newArrayList('').map(s|1).toList() this.map(i|i+1) }");
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.map(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", featureCall.getFeature().getIdentifier());
	}
	
	public void testExtensionMethodOnThis_03() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{ var this = newArrayList('').map(s|1).toList() map(i|i+1) }");
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.ListExtensions.map(java.util.List,org.eclipse.xtext.xbase.lib.Functions$Function1)", featureCall.getFeature().getIdentifier());
	}
	
	public void testExtensionMethodOnThis_04() throws Exception {
		final XBlockExpression block = (XBlockExpression) expression("{ var this = newArrayList('').map(s|1).toList() this.map(i|i+1) }");
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) block.getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.ListExtensions.map(java.util.List,org.eclipse.xtext.xbase.lib.Functions$Function1)", featureCall.getFeature().getIdentifier());
	}
	
	public void testMemberCallOnNull_01() throws Exception {
		XMemberFeatureCall toString = (XMemberFeatureCall) expression("null.toString");
		assertTrue(toString.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_02() throws Exception {
		XMemberFeatureCall nullOrEmpty = (XMemberFeatureCall) expression("null.isNullOrEmpty");
		assertTrue(nullOrEmpty.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_03() throws Exception {
		XBinaryOperation equals = (XBinaryOperation) expression("null == 'literal'");
		assertFalse(equals.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_04() throws Exception {
		XBinaryOperation equalsNot = (XBinaryOperation) expression("null != 'literal'");
		assertFalse(equalsNot.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_05() throws Exception {
		XBinaryOperation mappedTo = (XBinaryOperation) expression("null -> 'literal'");
		assertFalse(mappedTo.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_06() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = null x.toString }");
		XMemberFeatureCall toString = (XMemberFeatureCall) block.getExpressions().get(1);
		assertTrue(toString.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_07() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = null x.isNullOrEmpty }");
		XMemberFeatureCall nullOrEmpty = (XMemberFeatureCall) block.getExpressions().get(1);
		assertTrue(nullOrEmpty.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_08() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = null x == 'literal' }");
		XBinaryOperation equals = (XBinaryOperation) block.getExpressions().get(1);
		assertFalse(equals.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_09() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = null x != 'literal' }");
		XBinaryOperation equalsNot = (XBinaryOperation) block.getExpressions().get(1);
		assertFalse(equalsNot.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_10() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = null x -> 'literal' }");
		XBinaryOperation mappedTo = (XBinaryOperation) block.getExpressions().get(1);
		assertFalse(mappedTo.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_11() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = null toString }");
		XFeatureCall toString = (XFeatureCall) block.getExpressions().get(1);
		assertTrue(toString.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnNull_12() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = null isNullOrEmpty }");
		XFeatureCall nullOrEmpty = (XFeatureCall) block.getExpressions().get(1);
		assertTrue(nullOrEmpty.getFeature().eIsProxy());
	}
	
	public void testMemberCallOnMultiType_01() throws Exception {
		XMemberFeatureCall compareTo = (XMemberFeatureCall) expression("(if (true) new Double('') else new Integer('')).compareTo(null)");
		assertEquals("java.lang.Comparable.compareTo(T)", compareTo.getFeature().getIdentifier());
	}
	
	public void testMemberCallOnMultiType_02() throws Exception {
		XMemberFeatureCall intValue = (XMemberFeatureCall) expression("(if (true) new Double('') else new Integer('')).intValue");
		assertEquals("java.lang.Number.intValue()", intValue.getFeature().getIdentifier());
	}
	
	public void testMemberCallOnMultiType_03() throws Exception {
		XMemberFeatureCall intValue = (XMemberFeatureCall) expression(
				"newArrayList.map(e|if (true) new Double('') else new Integer('')).head.intValue");
		assertEquals("java.lang.Number.intValue()", intValue.getFeature().getIdentifier());
	}
	
	public void testMemberCallOnMultiType_04() throws Exception {
		XMemberFeatureCall compareTo = (XMemberFeatureCall) expression(
				"newArrayList.map(e|if (true) new Double('') else new Integer('')).head.compareTo(null)");
		assertEquals("java.lang.Comparable.compareTo(T)", compareTo.getFeature().getIdentifier());
	}
	
	public void testMemberCallOnMultiType_05() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var number = if (true) new Double('') else new Integer('') number.compareTo(number) }");
		XMemberFeatureCall compareTo = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("java.lang.Comparable.compareTo(T)", compareTo.getFeature().getIdentifier());
	}
	
	public void testMemberCallOnMultiType_06() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var number = if (true) new Double('') else new Integer('') number.intValue }");
		XMemberFeatureCall intValue = (XMemberFeatureCall) block.getExpressions().get(1);
		assertEquals("java.lang.Number.intValue()", intValue.getFeature().getIdentifier());
	}
	
	public void testMemberCallOnMultiType_07() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = if (true) new Double('') else new Integer('') compareTo(number) }");
		XFeatureCall compareTo = (XFeatureCall) block.getExpressions().get(1);
		assertEquals("java.lang.Comparable.compareTo(T)", compareTo.getFeature().getIdentifier());
	}
	
	public void testMemberCallOnMultiType_08() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = if (true) new Double('') else new Integer('') intValue }");
		XFeatureCall intValue = (XFeatureCall) block.getExpressions().get(1);
		assertEquals("java.lang.Number.intValue()", intValue.getFeature().getIdentifier());
	}
	
	public void testMemberCallOnMultiType_09() throws Exception {
		XBinaryOperation greaterOrEqualThan = (XBinaryOperation) expression("(if (true) new Double('') else new Integer('')) >= 0");
		assertEquals("org.eclipse.xtext.xbase.lib.ComparableExtensions.operator_greaterEqualsThan(java.lang.Comparable,C)", greaterOrEqualThan.getFeature().getIdentifier());
	}
	
	public void testMemberCallOnMultiType_10() throws Exception {
		XBinaryOperation lessThan = (XBinaryOperation) expression("(if (true) new Double('') else new Integer('')) < 0");
		assertEquals("org.eclipse.xtext.xbase.lib.ComparableExtensions.operator_lessThan(java.lang.Comparable,C)", lessThan.getFeature().getIdentifier());
	}
}
