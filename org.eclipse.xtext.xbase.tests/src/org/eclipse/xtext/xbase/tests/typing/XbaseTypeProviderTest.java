/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class XbaseTypeProviderTest extends AbstractXbaseTestCase {
	
	@Test public void testTypeForVoidClosure() throws Exception {
		XExpression expression = expression("newArrayList('foo','bar').forEach [] ", true);
		XExpression closure = ((XMemberFeatureCall)expression).getMemberCallArguments().get(0);
		LightweightTypeReference type = getType(closure);
		assertEquals("(String)=>void", type.getSimpleName());
	}
	
	@Test public void testFeatureCallWithArrayToIterableConversion() throws Exception {
		assertResolvedType("java.util.Iterator<java.lang.Character>", "'foo'.toCharArray.iterator");
	}
	
	@Test public void testReturnType() throws Exception {
		assertResolvedType("void", "return 'foo'");
	}
	
	@Test public void testClosure_00() throws Exception {
		assertResolvedType("java.lang.String", "[|'literal'].apply()");
	}
	
	@Test public void testClosure_01() throws Exception {
		assertResolvedType(
				"java.lang.String", 
				"{" +
				"  var closure = [|'literal']" +
				"  new testdata.ClosureClient().invoke0(closure)" +
				"}");
	}
	
	@Test public void testClosure_02() throws Exception {
		assertResolvedType("(java.lang.String)=>boolean", "[java.lang.String x| true]");
	}
	
	@Test
	public void testClosure_03() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" + 
				"  var java.util.List<? super String> list = null;\n" + 
				"  list.map(e|e)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(1);
		XClosure closure = (XClosure) featureCall.getMemberCallArguments().get(0);
		LightweightTypeReference typeRef = getType(closure);
		assertEquals("(java.lang.Object)=>java.lang.Object", toString(typeRef));
	}
	
	@Test
	public void testClosure_04() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" + 
				"  var java.util.List<? super String> list = null;\n" + 
				"  list.map(e|e == null)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(1);
		XClosure closure = (XClosure) featureCall.getMemberCallArguments().get(0);
		LightweightTypeReference typeRef = getType(closure);
		assertEquals("(java.lang.Object)=>boolean", toString(typeRef));
	}
	
	@Test public void testTypeArgs() throws Exception {
		assertResolvedType("boolean", "new java.util.ArrayList<String>() += 'foo'");
	}

	@Test public void testIfExpression() throws Exception {
		assertResolvedType("java.lang.String", "if (true) 'foo' else null");
		assertResolvedType("java.lang.String", "if (true) 'foo' else 'bar'");
		assertResolvedType("java.lang.String", "if (true) 'foo'");
	}
	
	@Test public void testIfExpression_02() throws Exception {
		if (isJava11OrLater()) {
			assertResolvedType("java.lang.AbstractStringBuilder & java.io.Serializable & java.lang.Comparable<? extends java.lang.Object>", "if (true) new StringBuilder() else new StringBuffer()");
		} else {
			assertResolvedType("java.lang.AbstractStringBuilder & java.io.Serializable", "if (true) new StringBuilder() else new StringBuffer()");
		}
	}

	@Test public void testSwitchExpression() throws Exception {
		assertResolvedType(String.class.getName(),
				"switch true { case true : 's' case false : 'foo' default: 'bar'}");
		assertResolvedType(Object.class.getName(),
				"switch true { case true : 's' case false : new java.lang.Object() default: 'bar'}");
	}
	
	@Test public void testSwitchExpression_1() throws Exception {
		XExpression expression = expression("switch true { case true : return 's' default: null}");
		LightweightTypeReference type = getType(expression);
		assertTrue(type.isAny());
	}
	@Test public void testSwitchExpression_2() throws Exception {
		XExpression expression = expression(
							"switch e {\n" + 
							"  Object : return null\n" + 
							"}");
		LightweightTypeReference type = getType(expression);
		assertEquals("void", type.getIdentifier());
	}
	
	@Test public void testTypeGuardedCase_0() throws Exception {
		XSwitchExpression expression = (XSwitchExpression) expression("switch  s: new Object() { String: s StringBuffer: s}", true);
//		assertEquals("java.lang.Object", toString(typeProvider.getType(expression.getSwitch())));
//		assertEquals("java.lang.String", toString(typeProvider.getType(expression.getCases().get(0).getThen())));
//		assertEquals("java.lang.StringBuffer", toString(typeProvider.getType(expression.getCases().get(1).getThen())));
		if (isJava11OrLater()) {
			assertEquals("java.io.Serializable & java.lang.Comparable<? extends java.lang.Object> & java.lang.CharSequence", toString(getType(expression)));
		} else{
			assertEquals("java.io.Serializable & java.lang.CharSequence", toString(getType(expression)));
		}
	}
	
	@Test public void testTypeGuardedCase_1() throws Exception {
		XSwitchExpression expression = (XSwitchExpression) expression("switch s: '' as CharSequence { Cloneable: s String: s }", true);
		assertEquals("java.lang.CharSequence", toString(getType(expression.getSwitch())));
		assertEquals("java.lang.CharSequence & java.lang.Cloneable", toString(getType(expression.getCases().get(0).getThen())));
		assertEquals("java.lang.String", toString(getType(expression.getCases().get(1).getThen())));
		assertEquals("java.lang.CharSequence", toString(getType(expression)));
	}
	
	@Test public void testSwitchExpression_Bug343100() throws Exception {
		assertResolvedType("java.lang.Class<? extends java.lang.Object>",
			"switch 'a' {\n" + 
			"  case null: typeof(java.lang.String)\n" + 
			"  case 'a': typeof(java.lang.Void)\n" + 
			"}");
	}

	@Test public void testBlockExpression() throws Exception {
		assertResolvedType(Integer.TYPE.getName(), "{''.toString;4;}");
		assertResolvedType(Boolean.TYPE.getName(), "{''.toString;true;}");
		assertResolvedType("null", "{null;}");
	}

	@Test public void testNullLiteral() throws Exception {
		assertResolvedType("null", "null");
	}

	@Test public void testBooleanLiteral() throws Exception {
		assertResolvedType(Boolean.TYPE.getName(), "true");
		assertResolvedType(Boolean.TYPE.getName(), "false");
	}

	@Test public void testStringLiteral() throws Exception {
		assertResolvedType(String.class.getName(), "'foo'");
		assertResolvedType(String.class.getName(), "\"foo\"");
	}

	@Test public void testNumberLiteral_0() throws Exception {
		assertResolvedType(Integer.TYPE.getName(), "3");
	}

	@Test public void testNumberLiteral_1() throws Exception {
		assertResolvedType(Integer.TYPE.getName(), "0x42");
	}

	@Test public void testNumberLiteral_2() throws Exception {
		assertResolvedType(Long.TYPE.getName(), "1L");
	}

	@Test public void testNumberLiteral_3() throws Exception {
		assertResolvedType(Long.TYPE.getName(), "0x42#l");
	}

	@Test public void testNumberLiteral_4() throws Exception {
		assertResolvedType(Float.TYPE.getName(), "1f");
	}

	@Test public void testNumberLiteral_5() throws Exception {
		assertResolvedType(Float.TYPE.getName(), "1.0f");
	}

	@Test public void testNumberLiteral_6() throws Exception {
		assertResolvedType(Float.TYPE.getName(), "1.0E10f");
	}

	@Test public void testNumberLiteral_7() throws Exception {
		assertResolvedType(Float.TYPE.getName(), "1.0e-10f");
	}

	@Test public void testNumberLiteral_8() throws Exception {
		assertResolvedType(Float.TYPE.getName(), "1.0E+10f");
	}

	@Test public void testNumberLiteral_9() throws Exception {
		assertResolvedType(Double.TYPE.getName(), "1.0");
	}

	@Test public void testNumberLiteral_10() throws Exception {
		assertResolvedType(Double.TYPE.getName(), "1.0E10");
	}

	@Test public void testNumberLiteral_11() throws Exception {
		assertResolvedType(Double.TYPE.getName(), "1.0e-10");
	}

	@Test public void testNumberLiteral_12() throws Exception {
		assertResolvedType(Double.TYPE.getName(), "1.0E+10");
	}

	@Test public void testNumberLiteral_13() throws Exception {
		assertResolvedType(Double.TYPE.getName(), "1.0d");
	}

	@Test public void testNumberLiteral_14() throws Exception {
		assertResolvedType(Double.TYPE.getName(), "1.0E10d");
	}

	@Test public void testNumberLiteral_15() throws Exception {
		assertResolvedType(Double.TYPE.getName(), "1.0e-10d");
	}

	@Test public void testNumberLiteral_16() throws Exception {
		assertResolvedType(Double.TYPE.getName(), "1.0E+10d");
	}

	@Test public void testNumberLiteral_17() throws Exception {
		assertResolvedType(BigInteger.class.getName(), "1234567890123456789012345678901234567890bi");
	}

	@Test public void testNumberLiteral_17a() throws Exception {
		assertResolvedType(BigInteger.class.getName(), "0x1234567890123456789012345678901234567890#bi");
	}

	@Test public void testNumberLiteral_18() throws Exception {
		assertResolvedType(BigDecimal.class.getName(), "1.0bD");
	}

	@Test public void testNumberLiteral_19() throws Exception {
		assertResolvedType(BigDecimal.class.getName(), "1.0E10Bd");
	}

	@Test public void testNumberLiteral_20() throws Exception {
		assertResolvedType(BigDecimal.class.getName(), "1.0e-10bd");
	}

	@Test public void testNumberLiteral_21() throws Exception {
		assertResolvedType(BigDecimal.class.getName(), "1.0E+10BD");
	}

	@Test public void testNumberLiteral_22() throws Exception {
		assertResolvedType(BigDecimal.class.getName(), "1E+10BD");
	}
	
	@Test public void testNumberLiteral_23() throws Exception {
		assertResolvedType(Double.TYPE.getName(), "1E-10");
	}

	@Test public void testNumberLiteral_24() throws Exception {
		assertResolvedType(Float.TYPE.getName(), "1E10f");
	}
	
	@Test public void testListLiteral_0() throws Exception {
		assertResolvedType("java.util.List<java.lang.Object>", "#[]");
	}

	@Test public void testListLiteral_1() throws Exception {
		assertResolvedType("java.util.List<java.lang.String>", "#['foo']");
	}

	@Test public void testListLiteral_2() throws Exception {
		assertResolvedType("java.util.List<java.lang.String>", "#['foo', 'bar', null]");
	}

	@Test public void testListLiteral_3() throws Exception {
		assertResolvedType("java.util.List<java.lang.Object>", "#[null]");
	}

	@Test public void testListLiteral_4() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "#[1,2,3]");
	}

	@Test public void testListLiteral_5() throws Exception {
		if (isJava12OrLater()) {
			assertResolvedType("java.util.List<? extends java.lang.Number & java.lang.Comparable<? extends java.lang.Object> & java.lang.constant.Constable & java.lang.constant.ConstantDesc>", "#[1,2.0,3]");
		} else {
			assertResolvedType("java.util.List<? extends java.lang.Number & java.lang.Comparable<? extends java.lang.Object>>", "#[1,2.0,3]");
		}
	}
	
	@Test public void testSetLiteral_0() throws Exception {
		assertResolvedType("java.util.Set<java.lang.Object>", "#{}");
	}

	@Test public void testSetLiteral_1() throws Exception {
		assertResolvedType("java.util.Set<java.lang.String>", "#{'foo'}");
	}

	@Test public void testSetLiteral_2() throws Exception {
		assertResolvedType("java.util.Set<java.lang.String>", "#{'foo', 'bar', null}");
	}

	@Test public void testSetLiteral_3() throws Exception {
		assertResolvedType("java.util.Set<java.lang.Object>", "#{null}");
	}

	@Test public void testSetLiteral_4() throws Exception {
		assertResolvedType("java.util.Set<java.lang.Integer>", "#{1,2,3}");
	}

	@Test public void testSetLiteral_5() throws Exception {
		if (isJava12OrLater()) {
			assertResolvedType("java.util.Set<? extends java.lang.Number & java.lang.Comparable<? extends java.lang.Object> & java.lang.constant.Constable & java.lang.constant.ConstantDesc>", "#{1,2.0,3}");
		} else {
			assertResolvedType("java.util.Set<? extends java.lang.Number & java.lang.Comparable<? extends java.lang.Object>>", "#{1,2.0,3}");
		}
	}

	@Test public void testCastExpression() throws Exception {
		assertResolvedType(String.class.getName(), "null as String");
		assertResolvedType(Boolean.class.getName(), "null as Boolean");
	}

	@Test
	public void testConstructorCall() throws Exception {
		assertResolvedType("java.util.ArrayList<java.lang.Object>", "new java.util.ArrayList()");
		assertResolvedType("java.util.ArrayList<java.lang.String>", "new java.util.ArrayList<java.lang.String>()");
		assertResolvedType("java.util.HashMap<java.lang.String, java.lang.Boolean>",
				"new java.util.HashMap<java.lang.String, java.lang.Boolean>()");
	}
	
	@Test public void testConstructorTypeInference_01() throws Exception {
		assertResolvedType("testdata.GenericType1<java.lang.String>", "new testdata.GenericType1('')");
	}
	
	@Test public void testConstructorTypeInference_02() throws Exception {
		assertResolvedType("boolean", "<java.util.List<String>>newArrayList().add(new java.util.ArrayList())");
	}

	@Test public void testFeatureCall_01() throws Exception {
		assertResolvedType("int", "'foo'.length");
	}

	@Test public void testFeatureCall_02() throws Exception {
		assertResolvedType("byte[]", "'foo'.getBytes()");
		assertResolvedType("java.lang.String", "new java.util.ArrayList<java.lang.String>().get(23)");
	}
	
	@Test public void testFeatureCall_03() throws Exception {
		assertResolvedType("java.util.List<java.lang.Object>", "new testdata.ClassWithVarArgs().toList()");
		assertResolvedType("java.util.List<java.lang.String>", "new testdata.ClassWithVarArgs().toList('')");
		assertResolvedType("java.util.List<java.lang.String>", "new testdata.ClassWithVarArgs().toList('', '')");
	}
	
	@Test public void testFeatureCall_04() throws Exception {
		if (isJava12OrLater()) {
			assertResolvedType("java.util.List<java.lang.Comparable<? extends java.lang.Object> & java.lang.constant.Constable & java.lang.constant.ConstantDesc & java.io.Serializable>", "new testdata.ClassWithVarArgs().toList('', 1)");
		} else {
			assertResolvedType("java.util.List<java.lang.Comparable<? extends java.lang.Object> & java.io.Serializable>", "new testdata.ClassWithVarArgs().toList('', 1)");
		}
	}
	
	@Test public void testFeatureCall_05() throws Exception {
//		Lists.newArrayList(1l, 1);
		assertResolvedType("java.util.List<java.lang.Number>", "new testdata.ClassWithVarArgs().toNumberList()");
		assertResolvedType("java.util.List<java.lang.Integer>", "new testdata.ClassWithVarArgs().toNumberList(0)");
		assertResolvedType("java.util.List<java.lang.Integer>", "new testdata.ClassWithVarArgs().toNumberList(0, 1)");
		if (isJava12OrLater()) {
			assertResolvedType("java.util.List<java.lang.Number & java.lang.Comparable<? extends java.lang.Object> & java.lang.constant.Constable & java.lang.constant.ConstantDesc>", "new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)");
		} else {
			assertResolvedType("java.util.List<java.lang.Number & java.lang.Comparable<? extends java.lang.Object>>", "new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)");
		}
	}
	
	@Test public void testFeatureCall_06() throws Exception {
//		List<String> list = null;
//		Functions.Function1<String, String> fun = null;
//		ListExtensions.map(list, fun);
		assertResolvedType("java.util.List<java.lang.String>", "newArrayList('').map(s|s)");
	}
	
	@Test public void testFeatureCall_06_1() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|1)");
	}
	
	@Test public void testFeatureCall_07() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|s.length)");
	}
	
	@Test public void testFeatureCall_08() throws Exception {
		assertResolvedType("java.util.List<java.lang.Boolean>", "newArrayList('').map(s|s != null)");
	}
	
	@Test public void testFeatureCall_09() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|s.length+1)");
	}
	
	@Test public void testFeatureCall_10() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|1).map(i| i+1)");
	}
	
	@Test public void testFeatureCall_11() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|1).toList()");
	}
	
	@Test public void testFeatureCall_12() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|1).toList().map(i|i)");
	}
	
	@Test public void testFeatureCall_13() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|1).toList().map(i|i+1)");
	}
	
	@Test public void testFeatureCall_13_2() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "{ var it = newArrayList('').map(s|1).toList() it.map(i|i+1) }");
	}
	
	@Test public void testFeatureCall_13_3() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "{ var it = newArrayList('').map(s|1).toList() map(i|i+1) }");
	}
	
	@Test public void testFeatureCall_14() throws Exception {
		assertResolvedType("java.util.ArrayList<java.util.List<java.lang.Integer>>", "newArrayList(newArrayList('').map(s|1))");
	}
	
	@Test public void testFeatureCall_15() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size())");
	}
	
	@Test public void testFeatureCall_15_a() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e)");
	}
	@Test public void testFeatureCall_15_b() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e)");
	}
	@Test
	public void testFeatureCall_15_c() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)");
	}
	@Test
	public void testFeatureCall_15_d() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)");
	}
	
	@Test public void testFeatureCall_15_e() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size())");
	}
	@Test public void testFeatureCall_15_f() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size())");
	}
	@Test
	public void testFeatureCall_15_g() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())");
	}
	@Test
	public void testFeatureCall_15_h() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())");
	}
	@Test public void testFeatureCall_15_i() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e)");
	}
	@Test
	public void testFeatureCall_15_j() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e)");
	}
	@Test
	public void testFeatureCall_15_k() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)");
	}
	@Test
	public void testFeatureCall_15_l() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)");
	}
	@Test public void testFeatureCall_15_m() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", 
				"newArrayList(newArrayList('').map(String s|1).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)" +
				").map(iterable|iterable.size()).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)" +
				"");
	}
	
	@Test public void testFeatureCall_16() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|1).map(i|1)");
	}
	
	@Test public void testFeatureCall_17() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|s.length).map(i|i)");
	}
	
	@Test public void testFeatureCall_18() throws Exception {
		assertResolvedType("java.util.List<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(b|b)");
	}
	
	@Test public void testFeatureCall_19() throws Exception {
		assertResolvedType("java.util.List<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b })");
	}
	
	@Test public void testFeatureCall_20() throws Exception {
		assertResolvedType("java.util.List<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b)");
	}
	
	@Test public void testFeatureCall_21() throws Exception {
		assertResolvedType("java.util.List<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(b| ! b )");
	}
	
	@Test public void testFeatureCall_22() throws Exception {
		assertResolvedType("java.util.List<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } )");
	}
	
	@Test public void testFeatureCall_23() throws Exception {
		assertResolvedType("java.util.List<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } )");
	}
	
	@Test public void testFeatureCall_24() throws Exception {
		assertResolvedType("java.util.List<java.lang.Boolean>", "newArrayList('').map(s|" +
				"org::eclipse::xtext::xbase::lib::ObjectExtensions::operator_equals(" +
				"	org::eclipse::xtext::xbase::lib::IntegerExtensions::operator_plus(s.length,1), 5)" +
				").map(b| org::eclipse::xtext::xbase::lib::BooleanExtensions::operator_not(b) )");
	}
	
	@Test public void testFeatureCall_25() throws Exception {
		assertResolvedType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 )");
	}
	
	@Test public void testFeatureCall_26() throws Exception {
		XBlockExpression block = (XBlockExpression) expression(
				"{ val Object o = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue).head }", true);
		XVariableDeclaration variableDeclaration = (XVariableDeclaration) block.getExpressions().get(0);
		XExpression memberCallTarget = ((XMemberFeatureCall) variableDeclaration.getRight()).getMemberCallTarget();
		LightweightTypeReference typeRef = getType(memberCallTarget);
		assertNotNull("type ref was null for " + memberCallTarget, typeRef);
		assertEquals("java.util.List<java.lang.Integer>", toString(typeRef));
	}
	
	@Test public void testFeatureCall_27() throws Exception {
		assertResolvedType("java.util.List<java.lang.Boolean>", "newArrayList('').map(s|" +
				"org.eclipse.xtext.xbase.lib.ObjectExtensions::operator_equals(" +
				"	org.eclipse.xtext.xbase.lib.IntegerExtensions::operator_plus(s.length,1), 5)" +
				").map(b| org.eclipse.xtext.xbase.lib.BooleanExtensions::operator_not(b) )");
	}
	
	@Test public void testFeatureCall_28() throws Exception {
		assertResolvedType("boolean", "org::eclipse::xtext::xbase::lib::ObjectExtensions::operator_equals('', '')");
	}
	
	@Test public void testFeatureCall_29() throws Exception {
		assertResolvedType("boolean", "org.eclipse.xtext.xbase.lib.ObjectExtensions::operator_equals('', '')");
	}
	
	@Test public void testFeatureCall_30() throws Exception {
		assertResolvedType("boolean", "org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals('', '')");
	}
	
	@Test public void testFeatureCall_31() throws Exception {
		assertResolvedType("org.eclipse.xtext.xbase.lib.ObjectExtensions", "org.eclipse.xtext.xbase.lib.ObjectExtensions.newInstance");
	}
	
	@Test public void testFeatureCall_32() throws Exception {
		assertResolvedType("java.lang.String", "org.eclipse.xtext.xbase.lib.ObjectExtensions.getName");
	}
	
	@Test public void testFeatureCall_33() throws Exception {
		assertResolvedType("java.lang.Class<org.eclipse.xtext.xbase.lib.ObjectExtensions>", "org.eclipse.xtext.xbase.lib.ObjectExtensions");
	}
	
	@Test public void testFeatureCall_34() throws Exception {
		assertResolvedType("boolean", "org.eclipse.xtext.xbase.lib.StringExtensions.identityEquals(null)");
	}
	
	@Test public void testFeatureCall_Bug342134_01() throws Exception {
		assertResolvedType("java.lang.Iterable<java.lang.String>", "newArrayList('').map(e|newArrayList(e)).flatten");
	}
	
	@Test public void testFeatureCall_Bug342134_02() throws Exception {
		assertResolvedType("java.util.List<java.util.ArrayList<java.lang.String>>", "newArrayList('').map(e|newArrayList(e))");
	}
	
	@Test public void testFeatureCall_Bug342134_03() throws Exception {
		assertResolvedType("java.lang.Iterable<java.lang.String>", "<String>newArrayList.map(e|newArrayList(e)).flatten");
	}
	
	@Test public void testFeatureCall_Bug342134_04() throws Exception {
		assertResolvedType("java.lang.Iterable<java.lang.String>", "newArrayList('').map(e|<String>newArrayList(e)).flatten");
	}
	
	@Test public void testFeatureCall_Bug342134_05() throws Exception {
		assertResolvedType("java.lang.Iterable<java.lang.String>", "newArrayList.map(String e|<String>newArrayList(e)).flatten");
	}
	
	@Test public void testFeatureCall_Bug342134_06() throws Exception {
		assertResolvedType("java.lang.Iterable<java.lang.String>", "newArrayList(newArrayList('')).flatten");
	}
	
	@Test public void testFeatureCall_Bug342134_07() throws Exception {
		assertResolvedType("java.lang.Iterable<java.lang.String>", "<java.util.List<java.lang.String>>newArrayList().flatten");
	}

	@Test public void testFeatureCallWithOperatorOverloading_2() throws Exception {
		assertResolvedType("boolean", "new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next");
	}
	
	@Test public void testFeatureCallWithOperatorOverloading_3() throws Exception {
		assertResolvedType("boolean", "new java.util.ArrayList<Byte>() += null");
	}
	
	@Test public void testFeatureCallWithOperatorOverloading_4() throws Exception {
		assertResolvedType("boolean", "new java.util.ArrayList<Byte>() += newArrayList('x'.getBytes().iterator.next)");
	}
	
	@Test public void testFeatureCallWithOperatorOverloading_5() throws Exception {
		assertResolvedType("boolean", "new java.util.ArrayList<Byte>() += 'x'.getBytes()");
	}
	
	@Test public void testFeatureCallOnIt() throws Exception {
		assertResolvedType("boolean", "{ val it = 'foo'; length == 3;}");
	}
	
	@Test public void testStaticMethods_01() throws Exception {
		assertResolvedType("java.util.ArrayList<java.lang.String>", "newArrayList('')");
	}
	
	@Test public void testStaticMethods_02() throws Exception {
		assertResolvedType("java.util.ArrayList<java.lang.String>", "newArrayList('', '')");
	}
	
	@Test public void testStaticMethods_03() throws Exception {
		assertResolvedType("java.util.ArrayList<java.util.HashSet<java.lang.String>>", "newArrayList(newHashSet(''))");
	}
	
	@Test public void testStaticMethods_04() throws Exception {
		assertResolvedType("java.util.ArrayList<java.lang.Object>", "newArrayList()");
	}
	
	@Test public void testStaticMethods_05() throws Exception {
		assertResolvedType("java.util.HashMap<java.lang.Object, java.lang.Object>", "newHashMap()");
	}

	@Test public void testThrowExpression() throws Exception {
		assertResolvedType("void", "throw new java.lang.Exception()");
	}

	@Test public void testTryCatchFinallyExpression_0() throws Exception {
		assertResolvedType("java.lang.String", "try 'foo' catch (java.lang.Exception e) 'bar'"); 
	}
	
	@Test public void testTryCatchFinallyExpression_1() throws Exception {
		assertResolvedType("java.lang.String", "try 'foo' catch (java.lang.RuntimeException e) 'bar' catch(java.lang.Exception e) 'baz'");	
	}
	
	@Test public void testTryCatchFinallyExpression_2() throws Exception {
		assertResolvedType("java.lang.String", "try 'foo' catch (java.lang.RuntimeException e) 'bar' catch(java.lang.Exception e) 'baz' finally println(true)");	
	}

	@Test public void testForExpression() throws Exception {
		assertResolvedType("void", "for(java.lang.String x : new java.util.ArrayList<String>()) x.length");
		assertResolvedType("void", "for(java.lang.String x : newArrayList('foo')) x.length");
		assertResolvedType("void", "for(java.lang.String x : <String>newArrayList()) x.length");
	}

	@Test public void testNull() throws Exception {
		assertNull(getType(null));
	}

	@Test public void testProxy() throws Exception {
		XFeatureCall proxy = XbaseFactory.eINSTANCE.createXFeatureCall();
		((InternalEObject) proxy).eSetProxyURI(URI.createURI("path#fragment"));
		assertNull(getType(proxy));
	}
	
	@Test public void testMethodTypeParamInference_00() throws Exception {
		assertResolvedType("java.lang.String", "new java.util.ArrayList<String>().findFirst(e | true)");
	}
	
	@Test public void testMethodTypeParamInference_01() throws Exception {
		assertResolvedType("java.lang.String", "new java.util.ArrayList<String>().findFirst(e|e == 'foo')");
	}
	
	@Test public void testInstanceof() throws Exception {
		assertResolvedType("boolean", "null instanceof java.lang.String");
	}
	
	@Test
	public void testToList_01() throws Exception {
		assertResolvedType("java.util.List<? extends java.lang.String>", "{ val Iterable<? extends String> iter = null iter.toList }");
	}

	@Test public void testToList_02() throws Exception {
		assertResolvedType("java.util.List<java.lang.String>", "{ val Iterable<String> iter = null iter.toList }");
	}
	
	@Inject
	protected IBatchTypeResolver typeResolver;

	public void assertResolvedType(String typeName, String expression) throws Exception {
		final XExpression expression2 = expression(expression, true);
		LightweightTypeReference typeRef = getType(expression2);
		assertNotNull("type ref was null for " + expression, typeRef);
		assertEquals(typeName, toString(typeRef));
	}

	protected LightweightTypeReference getType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getActualType(expression);
	}

	protected String toString(LightweightTypeReference typeref) {
		return typeref.getIdentifier();
	}

}
