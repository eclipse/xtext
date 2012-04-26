/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.xbase.tests.typesystem

import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import com.google.inject.Inject
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.xbase.typesystem.ITypeResolution
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class BatchTypeResolverTest extends AbstractXbaseTestCase {
	
	@Inject
	IBatchTypeResolver typeResolver;

	def void resolvesTo(String expression, String type) throws Exception {
		val xExpression = expression(expression, false /* true */);
		val typeResolution = typeResolver.resolveTypes(xExpression)
		val resolvedType = typeResolution.getActualType(xExpression)
		assertEquals(type, resolvedType.simpleName);
	}
	
	def void resolvesTo(String expression, Class<?> type) throws Exception {
		expression.resolvesTo(type.simpleName)
	}

	@Test def void testNullLiteral() throws Exception {
		"null".resolvesTo("null")
	}

	@Test def void testBooleanLiteral() throws Exception {
		"true".resolvesTo("boolean")
		"false".resolvesTo("boolean")
	}

	@Test def void testStringLiteral() throws Exception {
		"'foo'".resolvesTo("String")
		'"foo"'.resolvesTo("String")
	}

	@Test def void testNumberLiteral_0() throws Exception {
		"3".resolvesTo("int")
	}

	@Test def void testNumberLiteral_1() throws Exception {
		"0x42".resolvesTo("int")
	}

	@Test def void testNumberLiteral_2() throws Exception {
		"1L".resolvesTo("long")
	}

	@Test def void testNumberLiteral_3() throws Exception {
		"0x42#l".resolvesTo("long")
	}

	@Test def void testNumberLiteral_4() throws Exception {
		"1f".resolvesTo("float")
	}

	@Test def void testNumberLiteral_5() throws Exception {
		"1.0f".resolvesTo("float")
	}

	@Test def void testNumberLiteral_6() throws Exception {
		"1.0E10f".resolvesTo("float")
	}

	@Test def void testNumberLiteral_7() throws Exception {
		"1.0e-10f".resolvesTo("float")
	}

	@Test def void testNumberLiteral_8() throws Exception {
		"1.0E+10f".resolvesTo("float")
	}

	@Test def void testNumberLiteral_9() throws Exception {
		"1.0".resolvesTo("double")
	}

	@Test def void testNumberLiteral_10() throws Exception {
		"1.0E10".resolvesTo("double")
	}

	@Test def void testNumberLiteral_11() throws Exception {
		"1.0e-10".resolvesTo("double")
	}

	@Test def void testNumberLiteral_12() throws Exception {
		"1.0E+10".resolvesTo("double")
	}

	@Test def void testNumberLiteral_13() throws Exception {
		"1.0d".resolvesTo("double")
	}

	@Test def void testNumberLiteral_14() throws Exception {
		"1.0E10d".resolvesTo("double")
	}

	@Test def void testNumberLiteral_15() throws Exception {
		"1.0e-10d".resolvesTo("double")
	}

	@Test def void testNumberLiteral_16() throws Exception {
		"1.0E+10d".resolvesTo("double")
	}

	@Test def void testNumberLiteral_17() throws Exception {
		"1234567890123456789012345678901234567890bi".resolvesTo("BigInteger")
	}

	@Test def void testNumberLiteral_17a() throws Exception {
		"0x1234567890123456789012345678901234567890#bi".resolvesTo("BigInteger")
	}

	@Test def void testNumberLiteral_18() throws Exception {
		"1.0bD".resolvesTo("BigDecimal")
	}

	@Test def void testNumberLiteral_19() throws Exception {
		"1.0E10Bd".resolvesTo("BigDecimal")
	}

	@Test def void testNumberLiteral_20() throws Exception {
		"1.0e-10bd".resolvesTo("BigDecimal")
	}

	@Test def void testNumberLiteral_21() throws Exception {
		"1.0E+10BD".resolvesTo("BigDecimal")
	}

	@Test def void testNumberLiteral_22() throws Exception {
		"1E+10BD".resolvesTo("BigDecimal")
	}
	
	@Test def void testNumberLiteral_23() throws Exception {
		"1E-10".resolvesTo("double")
	}

	@Test def void testNumberLiteral_24() throws Exception {
		"1E10f".resolvesTo("float")
	}

	@Test def void testCastExpression() throws Exception {
		"null as String".resolvesTo("String")
		"null as Boolean".resolvesTo("Boolean")
	}
	
	@Test def void testThrowExpression() throws Exception {
		"throw new java.lang.Exception()".resolvesTo("void")
	}

	@Test def void testTryCatchFinallyExpression_0() throws Exception {
		"try 'foo' catch (java.lang.Exception e) 'bar'".resolvesTo("String") 
	}
	
	@Test def void testTryCatchFinallyExpression_1() throws Exception {
		"try 'foo' catch (java.lang.Exception e) 'bar' catch(java.lang.RuntimeException e) 'baz'".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_2() throws Exception {
		"try 'foo' catch (java.lang.Exception e) 'bar' catch(java.lang.RuntimeException e) 'baz' finally true".resolvesTo("String")	
	}

	@Test def void testForExpression_01() throws Exception {
		"for(java.lang.String x : new java.util.ArrayList<String>()) x.length".resolvesTo("void")
		"for(java.lang.String x : newArrayList('foo')) x.length".resolvesTo("void")
		"for(java.lang.String x : <String>newArrayList()) x.length".resolvesTo("void")
	}
	
	@Test def void testForExpression_02() throws Exception {
		"for(x : new java.util.ArrayList<String>()) x.length".resolvesTo("void")
		"for(x : newArrayList('foo')) x.length".resolvesTo("void")
		"for(x : <String>newArrayList()) x.length".resolvesTo("void")
	}

	@Test def void testNull() throws Exception {
		val typeResolution = typeResolver.resolveTypes(null)
		assertNotNull(typeResolution);
		assertEquals(ITypeResolution::NULL, typeResolution)
	}

	@Test def void testProxy() throws Exception {
		val proxy = XbaseFactory::eINSTANCE.createXFeatureCall();
		(proxy as InternalEObject).eSetProxyURI(URI::createURI("path#fragment"));
		val typeResolution = typeResolver.resolveTypes(proxy)
		assertNotNull(typeResolution);
		assertEquals(ITypeResolution::NULL, typeResolution)
	}
	
//	
//	@Test def void testMethodTypeParamInference_00() throws Exception {
//		"new java.util.ArrayList<String>().findFirst(e | true)".resolvesTo("java.lang.String")
//	}
//	
//	@Test def void testMethodTypeParamInference_01() throws Exception {
//		"new java.util.ArrayList<String>().findFirst(e|e == 'foo')".resolvesTo("java.lang.String")
//	}
	
	@Test def void testInstanceof() throws Exception {
		"null instanceof java.lang.String".resolvesTo("boolean")
	}
	
//	@Test def void testTypeForVoidClosure() throws Exception {
//		XExpression expression = expression("newArrayList('foo','bar').forEach [] ", true);
//		XExpression closure = ((XMemberFeatureCall)expression).getMemberCallArguments().get(0);
//		JvmTypeReference type = typeProvider.getType(closure);
//		assertEquals("(String)=>void", type.getSimpleName());
//	}
//	
//	@Test def void testFeatureCallWithArrayToIterableConversion() throws Exception {
//		"'foo'.toCharArray.iterator".resolvesTo("java.util.Iterator<java.lang.Character>")
//	}
	
	@Test def void testReturnType() throws Exception {
		"return 'foo'".resolvesTo("void")
	}
	
//	@Test def void testClosure_00() throws Exception {
//		"[|'literal'].apply()".resolvesTo("java.lang.String")
//	}
//	
//	@Test def void testClosure_01() throws Exception {
//		assertResolvedType(
//				"java.lang.String", 
//				"{" +
//				"  var closure = [|'literal']" +
//				"  new testdata.ClosureClient().invoke0(closure)" +
//				"}");
//	}
//	
//	@Test def void testClosure_02() throws Exception {
//		"[java.lang.String x| true]".resolvesTo("(java.lang.String)=>boolean")
//	}
//	
//	@Test
//	@Ignore("TODO Fix these cases")
//	public void testClosure_03() throws Exception {
//		XBlockExpression block = (XBlockExpression) expression(
//				"{\n" + 
//				"  var java.util.List<? super String> list = null;\n" + 
//				"  list.map(e|e)\n" +
//				"}");
//		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(1);
//		XClosure closure = (XClosure) featureCall.getMemberCallArguments().get(0);
//		JvmTypeReference typeRef = typeProvider.getType(closure);
//		assertEquals("(java.lang.Object)=>java.lang.Object", toString(typeRef));
//	}
//	
//	@Test
//	@Ignore("TODO Fix these cases")
//	public void testClosure_04() throws Exception {
//		XBlockExpression block = (XBlockExpression) expression(
//				"{\n" + 
//				"  var java.util.List<? super String> list = null;\n" + 
//				"  list.map(e|e == null)\n" +
//				"}");
//		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(1);
//		XClosure closure = (XClosure) featureCall.getMemberCallArguments().get(0);
//		JvmTypeReference typeRef = typeProvider.getType(closure);
//		assertEquals("(java.lang.Object)=>boolean", toString(typeRef));
//	}

	@Test def void testTypeArgs() throws Exception {
		"new java.util.ArrayList<String>() += 'foo'".resolvesTo("boolean")
	}

	@Test def void testIfExpression() throws Exception {
		"if (true) 'foo' else null".resolvesTo("String")
		"if (true) 'foo' else 'bar'".resolvesTo("String")
		"if (true) 'foo'".resolvesTo("String")
	}
	
	@Test def void testIfExpression_02() throws Exception {
		"if (true) new StringBuilder() else new StringBuffer()".resolvesTo("AbstractStringBuilder & Serializable")
	}
	
	@Test def void testIfExpression_03() throws Exception {
		"if (true) return 'foo'".resolvesTo("null")
	}

	@Test def void testSwitchExpression() throws Exception {
		"switch true { case true : 's' case false : 'foo' default: 'bar'}".resolvesTo("String")
		"switch true { case true : 's' case false : new java.lang.Object() default: 'bar'}".resolvesTo("Object")
	}
	
	@Test def void testSwitchExpression_1() throws Exception {
		"switch true { case true : return 's' default: null}".resolvesTo("null")
	}
	
	@Test def void testSwitchExpression_2() throws Exception {
		"switch null {
		  Object : return null 
		}".resolvesTo("null")
	}
	
	@Test def void testTypeGuardedCase_0() throws Exception {
		"switch  s: new Object() { String: s StringBuffer: s}".resolvesTo("Serializable & CharSequence")
//		assertEquals("java.lang.Object", toString(typeProvider.getType(expression.getSwitch())));
//		assertEquals("java.lang.String", toString(typeProvider.getType(expression.getCases().get(0).getThen())));
//		assertEquals("java.lang.StringBuffer", toString(typeProvider.getType(expression.getCases().get(1).getThen())));
	}
	
	@Test def void testTypeGuardedCase_1() throws Exception {
		"switch s: '' as CharSequence { Cloneable: s String: s }".resolvesTo("CharSequence")
//		assertEquals("java.lang.CharSequence", toString(typeProvider.getType(expression.getSwitch())));
//		assertEquals("java.lang.Cloneable & java.lang.CharSequence", toString(typeProvider.getType(expression.getCases().get(0).getThen())));
//		assertEquals("java.lang.String", toString(typeProvider.getType(expression.getCases().get(1).getThen())));
	}
	
	@Test def void testSwitchExpression_Bug343100() throws Exception {
		"switch 'a' {
		  case null: typeof(java.lang.String) 
		  case 'a': typeof(java.lang.Void)
		}".resolvesTo("Class<?>")
	}

	@Test def void testBlockExpression() throws Exception {
		"{null}".resolvesTo("null")
		"{''.toString 4}".resolvesTo("int")
		"{''.toString true}".resolvesTo("boolean")
	}
	
//	@Test def void testConstructorCall() throws Exception {
//		"new java.util.ArrayList()".resolvesTo("ArrayList<E>")
//		"new java.util.ArrayList<java.lang.String>()".resolvesTo("ArrayList<String>")
//		"java.util.HashMap<java.lang.String,java.lang.Boolean>".resolvesTo(
//				"new HashMap<String, Boolean>()");
//	}
//	
//	@Test def void testConstructorTypeInference_01() throws Exception {
//		"new testdata.GenericType1('')".resolvesTo("testdata.GenericType1<java.lang.String>")
//	}
//	
//	@Test def void testConstructorTypeInference_02() throws Exception {
//		"<java.util.List<String>>newArrayList().add(new java.util.ArrayList())".resolvesTo("boolean")
//	}

	@Test def void testFeatureCall_01() throws Exception {
		"'foo'.length".resolvesTo("int")
	}

//	@Test def void testFeatureCall_02() throws Exception {
//		"'foo'.getBytes()".resolvesTo("byte[]")
//		"new java.util.ArrayList<java.lang.String>().get(23)".resolvesTo("java.lang.String")
//	}
//	
//	@Test def void testFeatureCall_03() throws Exception {
//		"new testdata.ClassWithVarArgs().toList()".resolvesTo("java.util.List<java.lang.Object>")
//		"new testdata.ClassWithVarArgs().toList('')".resolvesTo("java.util.List<java.lang.String>")
//		'')".resolvesTo("java.util.List<java.lang.String>", "new testdata.ClassWithVarArgs().toList('')
//	}
//	
//	@Test def void testFeatureCall_04() throws Exception {
//		1)".resolvesTo("java.util.List<java.lang.Comparable<? extends java.lang.Object> & java.io.Serializable>", "new testdata.ClassWithVarArgs().toList('')
//	}
//	
//	@Test def void testFeatureCall_05() throws Exception {
////		Lists.newArrayList(1l, 1);
//		"new testdata.ClassWithVarArgs().toNumberList()".resolvesTo("java.util.List<java.lang.Number>")
//		"new testdata.ClassWithVarArgs().toNumberList(0)".resolvesTo("java.util.List<java.lang.Integer>")
//		1)".resolvesTo("java.util.List<java.lang.Integer>", "new testdata.ClassWithVarArgs().toNumberList(0)
//		new Integer(0).doubleValue)".resolvesTo("java.util.List<java.lang.Number & java.lang.Comparable<? extends java.lang.Object>>", "new testdata.ClassWithVarArgs().toNumberList(new Integer(0))
//	}
//	
//	@Test def void testFeatureCall_06() throws Exception {
////		List<String> list = null;
////		Functions.Function1<String, String> fun = null;
////		ListExtensions.map(list, fun);
//		"newArrayList('').map(s|s)".resolvesTo("java.util.List<java.lang.String>")
//	}
//	
//	@Test def void testFeatureCall_06_1() throws Exception {
//		"newArrayList('').map(s|1)".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_07() throws Exception {
//		"newArrayList('').map(s|s.length)".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_08() throws Exception {
//		"newArrayList('').map(s|s != null)".resolvesTo("java.util.List<java.lang.Boolean>")
//	}
//	
//	@Test def void testFeatureCall_09() throws Exception {
//		"newArrayList('').map(s|s.length+1)".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_10() throws Exception {
//		"newArrayList('').map(s|1).map(i|i+1)".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_11() throws Exception {
//		"newArrayList('').map(s|1).toList()".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_12() throws Exception {
//		"newArrayList('').map(s|1).toList().map(i|i)".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_13() throws Exception {
//		"newArrayList('').map(s|1).toList().map(i|i+1)".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_13_2() throws Exception {
//		"{ var it = newArrayList('').map(s|1).toList() it.map(i|i+1) }".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_13_3() throws Exception {
//		"{ var it = newArrayList('').map(s|1).toList() map(i|i+1) }".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_14() throws Exception {
//		"newArrayList(newArrayList('').map(s|1))".resolvesTo("java.util.ArrayList<java.util.List<java.lang.Integer>>")
//	}
//	
//	@Test def void testFeatureCall_15() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size())");
//	}
//	
//	@Test def void testFeatureCall_15_a() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e)");
//	}
//	@Test def void testFeatureCall_15_b() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e)");
//	}
//	@Test
//	@Ignore("Performance")
//	public void testFeatureCall_15_c() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)");
//	}
//	@Test
//	@Ignore("Performance")
//	public void testFeatureCall_15_d() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)");
//	}
//	
//	@Test def void testFeatureCall_15_e() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size())");
//	}
//	@Test def void testFeatureCall_15_f() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size())");
//	}
//	@Test
//	@Ignore("Performance")
//	public void testFeatureCall_15_g() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())");
//	}
//	@Test
//	@Ignore("Performance")
//	public void testFeatureCall_15_h() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())");
//	}
//	@Test def void testFeatureCall_15_i() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e)");
//	}
//	@Test
//	@Ignore("Performance")
//	public void testFeatureCall_15_j() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e)");
//	}
//	@Test
//	@Ignore("Performance")
//	public void testFeatureCall_15_k() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)");
//	}
//	@Test
//	@Ignore("Performance")
//	public void testFeatureCall_15_l() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)");
//	}
//	@Test def void testFeatureCall_15_m() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Integer>", 
//				"newArrayList(newArrayList('').map(String s|1).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)" +
//				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)" +
//				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)" +
//				").map(iterable|iterable.size()).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)" +
//				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)" +
//				"");
//	}
//	
//	@Test def void testFeatureCall_16() throws Exception {
//		"newArrayList('').map(s|1).map(i|1)".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_17() throws Exception {
//		"newArrayList('').map(s|s.length).map(i|i)".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_18() throws Exception {
//		"newArrayList('').map(s|s.length + 1 == 5).map(b|b)".resolvesTo("java.util.List<java.lang.Boolean>")
//	}
//	
//	@Test def void testFeatureCall_19() throws Exception {
//		"newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b })".resolvesTo("java.util.List<java.lang.Boolean>")
//	}
//	
//	@Test def void testFeatureCall_20() throws Exception {
//		"newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b)".resolvesTo("java.util.List<java.lang.Boolean>")
//	}
//	
//	@Test def void testFeatureCall_21() throws Exception {
//		"newArrayList('').map(s|s.length + 1 == 5).map(b| ! b )".resolvesTo("java.util.List<java.lang.Boolean>")
//	}
//	
//	@Test def void testFeatureCall_22() throws Exception {
//		"newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } )".resolvesTo("java.util.List<java.lang.Boolean>")
//	}
//	
//	@Test def void testFeatureCall_23() throws Exception {
//		"newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } )".resolvesTo("java.util.List<java.lang.Boolean>")
//	}
//	
//	@Test def void testFeatureCall_24() throws Exception {
//		assertResolvedType("java.util.List<java.lang.Boolean>", "newArrayList('').map(s|" +
//				"org::eclipse::xtext::xbase::lib::ObjectExtensions::operator_equals(" +
//				"	org::eclipse::xtext::xbase::lib::IntegerExtensions::operator_plus(s.length,1), 5)" +
//				").map(b| org::eclipse::xtext::xbase::lib::BooleanExtensions::operator_not(b) )");
//	}
//	
//	@Test def void testFeatureCall_25() throws Exception {
//		"newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 )".resolvesTo("java.util.List<java.lang.Integer>")
//	}
//	
//	@Test def void testFeatureCall_26() throws Exception {
//		XBlockExpression block = (XBlockExpression) expression(
//				"{ val Object o = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue).head }", true);
//		XVariableDeclaration variableDeclaration = (XVariableDeclaration) block.getExpressions().get(0);
//		XExpression memberCallTarget = ((XMemberFeatureCall) variableDeclaration.getRight()).getMemberCallTarget();
//		JvmTypeReference typeRef = typeProvider.getType(memberCallTarget);
//		assertNotNull("type ref was null for " + memberCallTarget, typeRef);
//		assertEquals("java.util.List<java.lang.Integer>", toString(typeRef));
//	}
//	
//	@Test def void testFeatureCall_Bug342134_01() throws Exception {
//		"newArrayList('').map(e|newArrayList(e)).flatten".resolvesTo("java.lang.Iterable<java.lang.String>")
//	}
//	
//	@Test def void testFeatureCall_Bug342134_02() throws Exception {
//		"newArrayList('').map(e|newArrayList(e))".resolvesTo("java.util.List<java.util.ArrayList<java.lang.String>>")
//	}
//	
//	@Test def void testFeatureCall_Bug342134_03() throws Exception {
//		"<String>newArrayList.map(e|newArrayList(e)).flatten".resolvesTo("java.lang.Iterable<java.lang.String>")
//	}
//	
//	@Test def void testFeatureCall_Bug342134_04() throws Exception {
//		"newArrayList('').map(e|<String>newArrayList(e)).flatten".resolvesTo("java.lang.Iterable<java.lang.String>")
//	}
//	
//	@Test def void testFeatureCall_Bug342134_05() throws Exception {
//		"newArrayList.map(String e|<String>newArrayList(e)).flatten".resolvesTo("java.lang.Iterable<java.lang.String>")
//	}
//	
//	@Test def void testFeatureCall_Bug342134_06() throws Exception {
//		"newArrayList(newArrayList('')).flatten".resolvesTo("java.lang.Iterable<java.lang.String>")
//	}
//	
//	@Test def void testFeatureCall_Bug342134_07() throws Exception {
//		"<java.util.List<java.lang.String>>newArrayList().flatten".resolvesTo("java.lang.Iterable<java.lang.String>")
//	}
//
//	@Test def void testFeatureCallWithOperatorOverloading_2() throws Exception {
//		"new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next".resolvesTo("boolean")
//	}
//	
//	@Test def void testFeatureCallWithOperatorOverloading_3() throws Exception {
//		"new java.util.ArrayList<Byte>() += null".resolvesTo("boolean")
//	}
//	
//	@Test def void testFeatureCallWithOperatorOverloading_4() throws Exception {
//		"new java.util.ArrayList<Byte>() += newArrayList('x'.getBytes().iterator.next)".resolvesTo("boolean")
//	}
//	
//	@Test def void testFeatureCallWithOperatorOverloading_5() throws Exception {
//		"new java.util.ArrayList<Byte>() += 'x'.getBytes()".resolvesTo("boolean")
//	}
	
	@Test def void testFeatureCallOnIt() throws Exception {
		"{ val it = 'foo'; length == 3;}".resolvesTo("boolean")
	}
	
//	@Test def void testStaticMethods_01() throws Exception {
//		"newArrayList('')".resolvesTo("java.util.ArrayList<java.lang.String>")
//	}
//	
//	@Test def void testStaticMethods_02() throws Exception {
//		'')".resolvesTo("java.util.ArrayList<java.lang.String>", "newArrayList('')
//	}
//	
//	@Test def void testStaticMethods_03() throws Exception {
//		"newArrayList(newHashSet(''))".resolvesTo("java.util.ArrayList<java.util.HashSet<java.lang.String>>")
//	}
//	
//	@Test def void testStaticMethods_04() throws Exception {
//		"newArrayList()".resolvesTo("java.util.ArrayList<java.lang.Object>")
//	}
//	
//	@Test def void testStaticMethods_05() throws Exception {
//		"newHashMap()".resolvesTo("java.util.HashMap<java.lang.Object,java.lang.Object>")
//	}
	
}