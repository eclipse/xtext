/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.xbase.XExpression
import org.junit.Ignore

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class BatchTypeResolverTest extends AbstractXbaseTestCase {
	
	@Inject
	IBatchTypeResolver typeResolver;
//	@Inject
//	ITypeProvider typeProvider;

	def void resolvesTo(String expression, String type) throws Exception {
		val xExpression = expression(expression, false /* true */);
		val resolvedTypes = typeResolver.resolveTypes(xExpression)
		val resolvedType = resolvedTypes.getActualType(xExpression)
		assertEquals(type, resolvedType.simpleName);
		for(content: xExpression.eAllContents.toIterable) {
			if (content instanceof XExpression) {
				resolvedTypes.getActualType(content as XExpression)
//				val childType = resolvedTypes.getActualType(content as XExpression)
//				assertNotNull(content.toString, childType)
//				assertNotNull(childType.identifier)
			}
		}
	}
	
//	def void resolvesTo2(String expression, String type) throws Exception {
//		val xExpression = expression(expression, false /* true */);
//		val resolvedType = typeProvider.getType(xExpression)
//		assertEquals(type, resolvedType.simpleName);
//		for(content: xExpression.eAllContents.toIterable) {
//			if (content instanceof XExpression)
//				typeProvider.getType(content as XExpression)
//		}
//	}
	
	def void resolvesTo(String expression, Class<?> type) throws Exception {
		expression.resolvesTo(type.simpleName)
	}

	@Test def void testNullLiteral() throws Exception {
		"null".resolvesTo("null")
	}
	
	@Test def void testTypeLiteral() throws Exception {
		"typeof(String)".resolvesTo("Class<String>")
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
		"throw new Exception()".resolvesTo("void")
	}

	@Test def void testTryCatchFinallyExpression_0() throws Exception {
		"try 'foo' catch (Exception e) 'bar'".resolvesTo("String") 
	}
	
	@Test def void testTryCatchFinallyExpression_1() throws Exception {
		"try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz'".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_2() throws Exception {
		"try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz' finally true".resolvesTo("String")	
	}

	@Test def void testForExpression_01() throws Exception {
		"for(String x : new java.util.ArrayList<String>()) x.length".resolvesTo("void")
		"for(String x : newArrayList('foo')) x.length".resolvesTo("void")
		"for(String x : <String>newArrayList()) x.length".resolvesTo("void")
	}
	
	@Test def void testForExpression_02() throws Exception {
		"for(x : new java.util.ArrayList<String>()) x.length".resolvesTo("void")
		"for(x : <String>newArrayList()) x.length".resolvesTo("void")
		"for(x : newArrayList('foo')) x.length".resolvesTo("void")
	}
	
	@Test def void testForExpression_03() throws Exception {
		"for(String x : null as String[]) x.length".resolvesTo("void")
	}
	
	@Test def void testForExpression_04() throws Exception {
		"for(x : null as String[]) x.length".resolvesTo("void")
	}

	@Test def void testNull() throws Exception {
		val typeResolution = typeResolver.resolveTypes(null)
		assertNotNull(typeResolution);
		assertEquals(IResolvedTypes::NULL, typeResolution)
	}

	@Test def void testProxy() throws Exception {
		val proxy = XbaseFactory::eINSTANCE.createXFeatureCall();
		(proxy as InternalEObject).eSetProxyURI(URI::createURI("path#fragment"));
		val typeResolution = typeResolver.resolveTypes(proxy)
		assertNotNull(typeResolution);
		assertEquals(IResolvedTypes::NULL, typeResolution)
	}
	
	@Test def void testImplicitImportPrintln() throws Exception {
		"<String>println(null)".resolvesTo("String")
		"println(null)".resolvesTo("Object")
	}
	
	@Test def void testImplicitImportEmptyList() throws Exception {
		"<String>emptyList".resolvesTo("List<String>")
		"emptyList".resolvesTo("List<Object>")
	}
	
	@Test def void testMethodTypeParamInference_00() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e | true)".resolvesTo("String")
	}
	
	@Test def void testMethodTypeParamInference_01() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e|e == 'foo')".resolvesTo("String")
	}
	
	@Test def void testMethodTypeParamInference_02() throws Exception {
		"new java.util.ArrayList<String>().<String>findFirst(e|e == 'foo')".resolvesTo("String")
	}
	
	@Test def void testInstanceof() throws Exception {
		"null instanceof String".resolvesTo("boolean")
	}
	
//	@Test def void testTypeForVoidClosure() throws Exception {
//		XExpression expression = expression("newArrayList('foo','bar').forEach [] ", true);
//		XExpression closure = ((XMemberFeatureCall)expression).getMemberCallArguments().get(0);
//		JvmTypeReference type = typeProvider.getType(closure);
//		assertEquals("(String)=>void", type.getSimpleName());
//	}

	@Ignore
	@Test def void testFeatureCallWithArrayToIterableConversion() throws Exception {
		"'foo'.toCharArray.iterator".resolvesTo("Iterator<Character>")
	}
	
	@Test def void testReturnType() throws Exception {
		"return 'foo'".resolvesTo("void")
	}
	
	@Test def void testClosure_00() throws Exception {
		"[|'literal'].apply()".resolvesTo("String")
	}
	
	@Test def void testClosure_01() throws Exception {
		"{ var closure = [|'literal']
		  new testdata.ClosureClient().invoke0(closure)	}".resolvesTo("String")
	}
	
	@Test def void testClosure_02() throws Exception {
		"[String x| true]".resolvesTo("(String)=>boolean")
	}
	
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
//		assertEquals("(Object)=>Object", toString(typeRef));
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
//		assertEquals("(Object)=>boolean", toString(typeRef));
//	}

	@Test def void testClosure_05() throws Exception {
		"[x| true]".resolvesTo("(Object)=>boolean")
	}
	
	@Test def void testClosure_06() throws Exception {
		"[x| null]".resolvesTo("(Object)=>Object")
	}
	
	@Ignore
	@Test def void testClosure_07() throws Exception {
		"[String x, String y| x + y ]".resolvesTo("(String, String)=>String")
	}
	
	@Test def void testClosure_08() throws Exception {
		"[x| x]".resolvesTo("(Object)=>Object")
	}
	
	@Test def void testClosure_09() throws Exception {
		"[String x, String y| x.substring(y.length)]".resolvesTo("(String, String)=>String")
	}

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
		"switch true { case true : 's' case false : new Object() default: 'bar'}".resolvesTo("Object")
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
		"switch s: new Object() { String: s StringBuffer: s}".resolvesTo("Serializable & CharSequence")
//		assertEquals("Object", toString(typeProvider.getType(expression.getSwitch())));
//		assertEquals("String", toString(typeProvider.getType(expression.getCases().get(0).getThen())));
//		assertEquals("StringBuffer", toString(typeProvider.getType(expression.getCases().get(1).getThen())));
	}
	
	@Test def void testTypeGuardedCase_1() throws Exception {
		"switch s: '' as CharSequence { Cloneable: s String: s }".resolvesTo("CharSequence")
//		assertEquals("CharSequence", toString(typeProvider.getType(expression.getSwitch())));
//		assertEquals("Cloneable & CharSequence", toString(typeProvider.getType(expression.getCases().get(0).getThen())));
//		assertEquals("String", toString(typeProvider.getType(expression.getCases().get(1).getThen())));
	}
	
	@Test def void testSwitchExpression_Bug343100() throws Exception {
		"switch 'a' {
		  case null: typeof(String) 
		  case 'a': typeof(Void)
		}".resolvesTo("Class<?>")
	}

	@Test def void testBlockExpression_01() throws Exception {
		"{null}".resolvesTo("null")
		"{''.toString 4}".resolvesTo("int")
		"{''.toString true}".resolvesTo("boolean")
	}
	
	@Test def void testBlockExpression_02() throws Exception {
		"{val s = '' s}".resolvesTo("String")
	}
	
	@Test def void testBlockExpression_03() throws Exception {
		var input = "{ val s1 = ''\n"
		val max = 1000
		for(i : 1 .. max) {
			input = input + " val s" + (i+1) + " = s" + i + "\n"
		}
		input = input + " s" + (max + 1) + "}"
		input.resolvesTo("String")
	}
	
//	@Test def void testBlockExpression_04() throws Exception {
//		for(j : 1 .. 20) {
//			var input = "{ val s1 = ''\n"
//			val max = 1000
//			for(i : 1 .. max) {
//				input = input + " val s" + (i+1) + " = s" + i + "\n"
//			}
//			input = input + " s" + (max + 1) + "}"
//			input.resolvesTo2("String")
//		}
//	}
//	
//	@Test def void testBlockExpression_05() throws Exception {
//		for(j : 1 .. 20) {
//			var input = "{ val s1 = ''\n"
//			val max = 1000
//			for(i : 1 .. max) {
//				input = input + " val s" + (i+1) + " = s" + i + "\n"
//			}
//			input = input + " s" + (max + 1) + "}"
//			input.resolvesTo2("String")
//		}
//	}
	
	@Test def void testConstructorCall() throws Exception {
		"new java.util.ArrayList<String>()".resolvesTo("ArrayList<String>")
		"new java.util.HashMap<String,Boolean>".resolvesTo("HashMap<String, Boolean>");
		"new java.util.ArrayList()".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testConstructorTypeInference_01() throws Exception {
		"new testdata.GenericType1('')".resolvesTo("GenericType1<String>")
	}
	
	@Test def void testConstructorTypeInference_02() throws Exception {
		"<java.util.List<String>>newArrayList().add(new java.util.ArrayList())".resolvesTo("boolean")
	}
	
	@Test def void testConstructorTypeInference_03() throws Exception {
		"<java.util.List<String>>newArrayList().add(0, new java.util.ArrayList())".resolvesTo("void")
	}
	
	@Test def void testConstructorTypeInference_04() throws Exception {
		"newArrayList.add(new java.util.ArrayList())".resolvesTo("boolean")
	}
	
	@Test def void testConstructorTypeInference_05() throws Exception {
		"new testdata.GenericType2".resolvesTo("GenericType2<Number>")
	}
	
	@Test def void testConstructorTypeInference_06() throws Exception {
		"new testdata.GenericType2(0)".resolvesTo("GenericType2<Integer>")
	}
	
	@Test def void testConstructorTypeInference_07() throws Exception {
		"new testdata.GenericType2(0, 1)".resolvesTo("GenericType2<Integer>")
	}
	
	@Test def void testConstructorTypeInference_08() throws Exception {
		"new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)".resolvesTo("GenericType2<Number & Comparable<?>>")
	}
	
	@Test def void testClassNewInstance() throws Exception {
		"typeof(String).newInstance".resolvesTo("String")
	}

	@Test def void testFeatureCall_01() throws Exception {
		"'foo'.length".resolvesTo("int")
	}

	@Test def void testFeatureCall_02() throws Exception {
		"'foo'.getBytes()".resolvesTo("byte[]")
		"new java.util.ArrayList<String>().get(23)".resolvesTo("String")
	}
	
	@Test def void testFeatureCall_03() throws Exception {
		"new testdata.ClassWithVarArgs().toList()".resolvesTo("List<Object>")
		"new testdata.ClassWithVarArgs().toList('')".resolvesTo("List<String>")
		"new testdata.ClassWithVarArgs().toList('', '')".resolvesTo("List<String>")
	}
	
	@Test def void testMemberFeatureCall_01() throws Exception {
		"newArrayList('').get(0)".resolvesTo("String")
		"<String>newArrayList().get(0)".resolvesTo("String")
	}
	
	@Test def void testFeatureCall_04() throws Exception {
		"new testdata.ClassWithVarArgs().toList('', 1)".resolvesTo("List<Comparable<?> & Serializable>")
	}
	
	@Test def void testFeatureCall_05() throws Exception {
//		Lists.newArrayList(1l, 1);
		"new testdata.ClassWithVarArgs().toNumberList()".resolvesTo("List<Number>")
		"new testdata.ClassWithVarArgs().toNumberList(0)".resolvesTo("List<Integer>")
		"new testdata.ClassWithVarArgs().toNumberList(0, 1)".resolvesTo("List<Integer>")
		"new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)".resolvesTo("List<Number & Comparable<?>>")
	}
	
	@Ignore
	@Test def void testFeatureCall_06() throws Exception {
		"newArrayList('').map(s|s)".resolvesTo("List<String>")
	}
	
	@Test def void testFeatureCall_06_01() throws Exception {
		"newArrayList('').map(s|s).head".resolvesTo("String")
	}
	
	@Test def void testFeatureCall_06_02() throws Exception {
		"newArrayList('').map(s|s.toString).head".resolvesTo("String")
	}
	
	@Ignore
	@Test def void testFeatureCall_06_03() throws Exception {
		"newArrayList('').map(s|1)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_06_04() throws Exception {
		"newArrayList('').map(s|1).head".resolvesTo("Integer")
	}
	
	@Ignore
	@Test def void testFeatureCall_07() throws Exception {
		"newArrayList('').map(s|s.length)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_07_01() throws Exception {
		"<String>newArrayList.map(s|s.length)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_07_02() throws Exception {
		"newArrayList('').map(s|s.length).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_07_03() throws Exception {
		"<String>newArrayList.map(s|s.length).head".resolvesTo("Integer")
	}
	
	@Ignore
	@Test def void testFeatureCall_08() throws Exception {
		"newArrayList('').map(s|s != null)".resolvesTo("List<Boolean>")
	}
	
	@Ignore
	@Test def void testFeatureCall_09() throws Exception {
		"newArrayList('').map(s|s.length+1)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_10() throws Exception {
		"newArrayList('').map(s|1).map(i|i+1)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_11() throws Exception {
		"newArrayList('').map(s|1).toList()".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_12() throws Exception {
		"newArrayList('').map(s|1).toList().map(i|i)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_13() throws Exception {
		"newArrayList('').map(s|1).toList().map(i|i+1)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_13_2() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it.map(i|i+1) }".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_13_3() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() map(i|i+1) }".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_14() throws Exception {
		"newArrayList(newArrayList('').map(s|1))".resolvesTo("ArrayList<List<Integer>>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size())".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_a() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_b() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_c() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_d() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_e() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size())".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_f() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size())".resolvesTo("List<Integer>");
	}
	
	@Ignore
	@Test def void testFeatureCall_15_g() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())".resolvesTo("List<Integer>");
	}
	
	@Ignore
	@Test def void testFeatureCall_15_h() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_i() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)).map(e|e).map(iterable|iterable.size())".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_i_2() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_j() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_k() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_15_l() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}

	@Test def void testFeatureCall_15_m() throws Exception {
		("newArrayList(newArrayList('').map(String s|1).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		).map(iterable|iterable.size()).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)
		.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).head").resolvesTo("Integer");
	}
	
	@Test def void testFeatureCall_15_n() throws Exception {
		("newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)
		.map(e|e).map(e|e).map(e|e).map(e|e).head").resolvesTo("Integer");
	}
	
	@Test def void testFeatureCall_15_o() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size())".resolvesTo("Iterable<Integer>");
	}
	
	@Test def void testFeatureCall_15_p() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e)".resolvesTo("Iterable<Integer>");
	}
	
	@Ignore
	@Test def void testFeatureCall_16() throws Exception {
		"newArrayList('').map(s|1).map(i|1)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_17() throws Exception {
		"newArrayList('').map(s|s.length).map(i|i)".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_18() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b|b)".resolvesTo("List<Boolean>")
	}
	
	@Ignore
	@Test def void testFeatureCall_19() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b })".resolvesTo("List<Boolean>")
	}
	
	@Ignore
	@Test def void testFeatureCall_20() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b)".resolvesTo("List<Boolean>")
	}
	
	@Ignore
	@Test def void testFeatureCall_21() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| ! b )".resolvesTo("List<Boolean>")
	}
	
	@Ignore
	@Test def void testFeatureCall_22() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } )".resolvesTo("List<Boolean>")
	}
	
	@Ignore
	@Test def void testFeatureCall_23() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } )".resolvesTo("List<Boolean>")
	}

	@Ignore
	@Test def void testFeatureCall_24() throws Exception {
		("newArrayList('').map(s|" +
				"org::eclipse::xtext::xbase::lib::ObjectExtensions::operator_equals(" +
				"	org::eclipse::xtext::xbase::lib::IntegerExtensions::operator_plus(s.length,1), 5)" +
				").map(b| org::eclipse::xtext::xbase::lib::BooleanExtensions::operator_not(b) )").resolvesTo("List<Boolean>")
	}
	
	@Ignore
	@Test def void testFeatureCall_25() throws Exception {
		"newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 )".resolvesTo("List<Integer>")
	}
	
//	@Test def void testFeatureCall_26() throws Exception {
//		XBlockExpression block = (XBlockExpression) expression(
//				"{ val Object o = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue).head }", true);
//		XVariableDeclaration variableDeclaration = (XVariableDeclaration) block.getExpressions().get(0);
//		XExpression memberCallTarget = ((XMemberFeatureCall) variableDeclaration.getRight()).getMemberCallTarget();
//		JvmTypeReference typeRef = typeProvider.getType(memberCallTarget);
//		assertNotNull("type ref was null for " + memberCallTarget, typeRef);
//		assertEquals("java.util.List<Integer>", toString(typeRef));
//	}
//	

	@Ignore
	@Test def void testFeatureCall_Bug342134_01() throws Exception {
		"newArrayList('').map(e|newArrayList(e)).flatten".resolvesTo("List<String>")
	}
	
	@Ignore
	@Test def void testFeatureCall_Bug342134_02() throws Exception {
		"newArrayList('').map(e|newArrayList(e))".resolvesTo("List<ArrayList<String>>")
	}
	
	@Test def void testFeatureCall_Bug342134_03() throws Exception {
		"<String>newArrayList.map(e|newArrayList(e)).flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_04() throws Exception {
		"newArrayList('').map(e|<String>newArrayList(e)).flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_05() throws Exception {
		"newArrayList.map(String e|<String>newArrayList(e)).flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_06() throws Exception {
		"newArrayList(newArrayList('')).flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_07() throws Exception {
		"<java.util.List<String>>newArrayList().flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testReceiverIsPartiallyResolved_01() throws Exception {
		"newArrayList.get(0)".resolvesTo("Object")
	}
	
	@Test def void testReceiverIsPartiallyResolved_02() throws Exception {
		"newArrayList.toString".resolvesTo("String")
	}
	
	@Test def void testTypeByTransitiveExpectation_01() throws Exception {
		"newArrayList.flatten.toList.flatten.head".resolvesTo("Object")
	}
	
	@Test def void testTypeByTransitiveExpectation_02() throws Exception {
		"newArrayList.subList(1,1).subList(1,1).head".resolvesTo("Object")
	}
	
	@Test def void testTypeByTransitiveExpectation_03() throws Exception {
		"newArrayList.flatten.toList.<Number>flatten.head".resolvesTo("Number")
	}
	
	@Ignore
	@Test def void testTypeByTransitiveExpectation_04() throws Exception {
		"newArrayList.<Set<Number>>flatten.toList.flatten.head".resolvesTo("Number")
	}
	
	@Ignore
	@Test def void testTypeByTransitiveExpectation_05() throws Exception {
		"newArrayList.flatten.<Set<Number>>toList.flatten.head".resolvesTo("Number")
	}
	
	@Test def void testTypeByTransitiveExpectation_06() throws Exception {
		"newArrayList.flatten.toList.flatten.<Number>head".resolvesTo("Number")
	}
	
	@Test def void testDeferredTypeArgumentResolution_01() throws Exception {
		"newArrayList".resolvesTo("ArrayList<Object>")
	}
	
	@Ignore
	@Test def void testDeferredTypeArgumentResolution_02() throws Exception {
		"{
			val list = newArrayList
			val String s = list.get(0)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Ignore
	@Test def void testDeferredTypeArgumentResolution_03() throws Exception {
		"{
			val list = newArrayList
			val String s = list.head
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Ignore
	@Test def void testDeferredTypeArgumentResolution_04() throws Exception {
		"{
			val list = newArrayList
			list.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Ignore
	@Test def void testDeferredTypeArgumentResolution_05() throws Exception {
		"{
			val list = newArrayList
			list.addAll(newArrayList(''))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Ignore
	@Test def void testDeferredTypeArgumentResolution_06() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll('')
			list.addAll(secondList)
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Ignore
	@Test def void testDeferredTypeArgumentResolution_07() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(secondList)
			list.addAll('')
			secondList
		}".resolvesTo("ArrayList<String>")
	}

	@Ignore
	@Test def void testFeatureCallWithOperatorOverloading_2() throws Exception {
		"new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next".resolvesTo("boolean")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_3() throws Exception {
		"new java.util.ArrayList<Byte>() += null".resolvesTo("boolean")
	}
	
	@Ignore
	@Test def void testFeatureCallWithOperatorOverloading_4() throws Exception {
		"new java.util.ArrayList<Byte>() += newArrayList('x'.getBytes().iterator.next)".resolvesTo("boolean")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_5() throws Exception {
		"new java.util.ArrayList<Byte>() += 'x'.getBytes()".resolvesTo("boolean")
	}
	
	@Test def void testFeatureCallOnIt() throws Exception {
		"{ val it = 'foo'; length == 3;}".resolvesTo("boolean")
	}
	
	@Test def void testStaticMethods_01() throws Exception {
		"newArrayList('')".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testStaticMethods_02() throws Exception {
		"newArrayList('', '')".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testStaticMethods_03() throws Exception {
		"newArrayList(newHashSet(''))".resolvesTo("ArrayList<HashSet<String>>")
	}
	
	@Test def void testStaticMethods_04() throws Exception {
		"newArrayList()".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testStaticMethods_05() throws Exception {
		"newHashMap()".resolvesTo("HashMap<Object, Object>")
	}
	
	@Test def void testStaticMethods_06() throws Exception {
		"String::CASE_INSENSITIVE_ORDER".resolvesTo("Comparator<String>")
	}
	
}