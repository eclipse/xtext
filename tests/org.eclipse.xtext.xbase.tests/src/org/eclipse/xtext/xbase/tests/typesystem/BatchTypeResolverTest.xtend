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
import org.eclipse.xtext.xbase.XExpression
import org.junit.Ignore
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer
import java.util.List
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate
import org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate
import org.junit.Before
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.IReentrantTypeResolver
import com.google.inject.Provider
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import com.google.inject.Singleton
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XSwitchExpression

import static org.junit.Assert.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class BatchTypeResolverTest extends AbstractXbaseTestCase {
	
	@Inject
	IBatchTypeResolver typeResolver;
	@Inject
	ITypeProvider typeProvider;

	def void resolvesTo(String expression, String type) throws Exception {
		val xExpression = expression(expression.replace('$$', 'org::eclipse::xtext::xbase::lib::'), false /* true */);
		val resolvedTypes = getTypeResolver.resolveTypes(xExpression)
		val resolvedType = resolvedTypes.getActualType(xExpression)
		assertEquals(type, resolvedType.simpleName);
		for(content: xExpression.eAllContents.toIterable) {
			switch(content) {
				XSwitchExpression: {
					assertExpressionTypeIsResolved(content, resolvedTypes)
					if (content.localVarName != null) {
						assertIdentifiableTypeIsResolved(content, resolvedTypes)
					}
				}
				XExpression: {
					assertExpressionTypeIsResolved(content, resolvedTypes)
				}
				XCasePart : { /* skip */}
				JvmIdentifiableElement: {
					assertIdentifiableTypeIsResolved(content, resolvedTypes)
				}
			}
		}
	}
	
	def void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		val type = types.getActualType(expression)
		assertNotNull(expression.toString, type)
		assertNotNull(expression.toString + " / " + type, type.identifier)	
	}
	
	def void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		val type = types.getActualType(identifiable)
		assertNotNull(identifiable.toString, type)
		assertNotNull(identifiable.toString + " / " + type, type.identifier)	
	}
	
	def getTypeResolver() {
		typeResolver
	}
	
	def void resolvesTo2(String expression, String type) throws Exception {
		val xExpression = expression(expression, false /* true */);
		val resolvedType = typeProvider.getType(xExpression)
		assertEquals(type, resolvedType.simpleName);
//		for(content: xExpression.eAllContents.toIterable) {
//			if (content instanceof XExpression)
//				typeProvider.getType(content as XExpression)
//		}
	}
	
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
	
	@Test def void testOverloadedVarArgs_01() throws Exception {
		"testdata::OverloadedMethods::overloadedVarArgs(null, null)".resolvesTo("long")
	}
	
	@Test def void testOverloadedVarArgs_02() throws Exception {
		"testdata::OverloadedMethods::overloadedVarArgs()".resolvesTo("int")
	}
	
	@Test def void testOverloadedVarArgs_03() throws Exception {
		"testdata::OverloadedMethods::overloadedVarArgs('', '')".resolvesTo("long")
	}
	
	@Test def void testOverloadedVarArgs_04() throws Exception {
		// TODO discuss: JDT binds to overloaded(Object, Object) thought the arity indicates overloaded(String...)
		"testdata::OverloadedMethods::overloadedVarArgs(new Object, new Object, new Object)".resolvesTo("int")
	}
	
	@Test def void testOverloadedTypeParameters_01() throws Exception {
		"testdata::OverloadedMethods::<String>overloadedTypeParameters(null)".resolvesTo("int")
	}
	
	@Test def void testOverloadedTypeParameters_02() throws Exception {
		"testdata::OverloadedMethods::<String, String>overloadedTypeParameters(null)".resolvesTo("long")
	}
	
	@Test def void testOverloadedOperators_01() throws Exception {
		"1 + 1".resolvesTo("int")
	}
	
	@Test def void testOverloadedOperators_02() throws Exception {
		"1L + 1".resolvesTo("long")
	}
	
	@Test def void testOverloadedOperators_03() throws Exception {
		"1 + 1L".resolvesTo("long")
	}
	
	@Test def void testOverloadedOperators_04() throws Exception {
		"'' + ''".resolvesTo("String")
	}
	
	@Test def void testOverloadedOperators_05() throws Exception {
		"'' + 1".resolvesTo("String")
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
	
	@Test def void testImplicitImportPrintln_01() throws Exception {
		"println(null)".resolvesTo("Object")
	}
	
	@Test def void testImplicitImportPrintln_02() throws Exception {
		"<String>println(null)".resolvesTo("String")
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
	
	@Test def void testMethodTypeParamInference_03() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]".resolvesTo("String")
	}
	
	@Test def void testMethodTypeParamInference_04() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == 'foo']".resolvesTo("String")
	}
	
	@Test def void testMethodTypeParamInference_05() throws Exception {
		"$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == 'foo']".resolvesTo("String")
	}
	
	@Test def void testInstanceof() throws Exception {
		"null instanceof String".resolvesTo("boolean")
	}
	
	@Test def void testTypeForVoidClosure() throws Exception {
		"newArrayList('foo','bar').forEach []".resolvesTo("void")
	}

	@Ignore
	@Test def void testFeatureCallWithArrayToIterableConversion() throws Exception {
		"'foo'.toCharArray.iterator".resolvesTo("Iterator<Character>")
	}
	
	@Test def void testReturnType_01() throws Exception {
		"return 'foo'".resolvesTo("void")
	}
	
	@Test def void testReturnType_02() throws Exception {
		"return try { if (true) 'foo' else 'bar' } finally { String::valueOf('zonk') }".resolvesTo("void")
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
	
	@Test
	def void testClosure_03() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e|e)\n" +
		"}").resolvesTo("List<Object>")
	}

	@Test
	def void testClosure_04() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e|e == null)\n" +
		"}").resolvesTo("List<Boolean>")
	}

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
	
	@Test def void testClosure_10() throws Exception {
		"[ x | x.toString x ]".resolvesTo("(Object)=>Object")
	}
	
	@Test def void testClosure_11() throws Exception {
		"[Object x| x]".resolvesTo("(Object)=>Object")
	}
	
	@Test def void testClosure_12() throws Exception {
		"[Object x| x.toString x ]".resolvesTo("(Object)=>Object")
	}
	
	@Test def void testClosure_13() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper)
		}".resolvesTo("List<Integer>")
	}
	
	@Ignore("TODO deferred closure body typing")
	@Test def void testClosure_14() throws Exception {
		"{ 
			val mapper = [ x | x.charAt(0) ]
			newArrayList('').map(mapper)
		}".resolvesTo("List<Character>")
	}
	
	@Test def void testClosure_15() throws Exception {
		"{ 
			val fun = [ x | x ]
			val String s = fun.apply(null)
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_16() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList(fun.apply(null))
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_17() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList.map(fun)
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_18() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.Set<String> list = newArrayList.map(fun)
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_19() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.ArrayList<String> list = newArrayList.map(fun)
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_20() throws Exception {
		"{ 
			val fun = [ x | x ]
			val Iterable<String> list = newArrayList.map(fun)
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_21() throws Exception {
		"{ 
			val fun = [ x | x ]
			val list = newArrayList.map(fun)
			val Iterable<String> iter = list
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_22() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_23() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.Set<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_24() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.ArrayList<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_25() throws Exception {
		"{ 
			val fun = [ x | x ]
			val Iterable<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_26() throws Exception {
		"{ 
			val fun = [ x | x ]
			val list = $$ListExtensions::map(newArrayList, fun)
			val Iterable<String> iter = list
			fun
		}".resolvesTo("(String)=>String")
	}
	
	@Test def void testClosure_27() throws Exception {
		"{ 
			val mapper = [ x | x ]
			$$ListExtensions::map(newArrayList(1), mapper)
		}".resolvesTo("List<Integer>")
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
	
	@Test def void testSwitchExpression_3() throws Exception {
		"{
			val Object c = null
			switch c {
	            CharSequence: 1
	    	}
		}".resolvesTo("Integer")
	}
	
	@Test def void testSwitchExpression_4() throws Exception {
		"{
			val Comparable<Object> c = null
			switch c {
	            CharSequence: switch(c) {
                    Appendable: {
                        c.charAt(1)
                    }
                }
        	}
		}".resolvesTo("Character")
	}
	
	@Test def void testSwitchExpression_5() throws Exception {
		"{
			val Comparable<Object> c = null
			switch c {
	            CharSequence: switch(c) {
                    Appendable: {
                        c.append(null)
                    }
                }
        	}
		}".resolvesTo("Appendable")
	}
	
	@Test def void testSwitchExpression_6() throws Exception {
		"{
			val Comparable<Object> c = null
			switch c {
	            CharSequence: switch(c) {
                    Appendable: {
                        c.compareTo(null)
                    }
                }
        	}
		}".resolvesTo("Integer")
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
	
	@Test def void testBlockExpression_04() throws Exception {
		"{val Object s = '' s}".resolvesTo("Object")
	}
	
	@Test def void testEMap_01() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getKey ].head
         }".resolvesTo("Integer")
	}
	
	@Test def void testEMap_02() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getValue ].head
         }".resolvesTo("String")
	}
	
	@Test def void testEMap_03() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ it ].head
         }".resolvesTo("Entry<Integer, String>")
	}
	
	@Test def void testEMap_04() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map
         }".resolvesTo("Map<Integer, String>")
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
	
	@Test def void testConstructorTypeInference_09() throws Exception {
		"<Iterable<String>>newArrayList().add(new java.util.LinkedList)".resolvesTo("boolean")
	}
	
	@Test def void testConstructorTypeInference_10() throws Exception {
		"<Iterable<String>>newArrayList().add(null)".resolvesTo("boolean")
	}
	
	@Test def void testConstructorTypeInference_11() throws Exception {
		"<java.util.Map<Iterable<String>, Iterable<Integer>>>newArrayList().head".resolvesTo("Map<Iterable<String>, Iterable<Integer>>")
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
		"'x'.length".resolvesTo("int")
	}
	
	@Test def void testMemberFeatureCall_02() throws Exception {
		"(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]".resolvesTo("Integer")
	}
	
	@Test def void testMemberFeatureCall_03() throws Exception {
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
	
	@Test def void testFeatureCall_06() throws Exception {
		"newArrayList('').map(s|s)".resolvesTo("List<String>")
	}
	
	@Test def void testFeatureCall_06_00() throws Exception {
		"$$ListExtensions::map(newArrayList('')) [s|s]".resolvesTo("List<String>")
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
	@Test def void testFeatureCall_13_4() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it.map(i|i+1) }".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_13_5() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it }".resolvesTo("List<Integer>")
	}
	
	@Ignore
	@Test def void testFeatureCall_14() throws Exception {
		"newArrayList(newArrayList('').map(s|1))".resolvesTo("ArrayList<List<Integer>>")
	}
	
	@Test def void testFeatureCall_15() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size())".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_15_a() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_15_b() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}
	
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
		"newArrayList(newArrayList('')).map(iterable|iterable.size())".resolvesTo("List<Integer>");
	}
	
	@Test def void testFeatureCall_15_p() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e)".resolvesTo("List<Integer>");
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
				"$$ObjectExtensions::operator_equals(" +
				"	$$IntegerExtensions::operator_plus(s.length,1), 5)" +
				").map(b| $$BooleanExtensions::operator_not(b) )").resolvesTo("List<Boolean>")
	}
	
	@Ignore
	@Test def void testFeatureCall_25() throws Exception {
		"newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 )".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_26() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list
        }".resolvesTo("List<Integer>");
	}
	
	@Test def void testFeatureCall_27() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v|v.intValue ]
           val Object o = list.head 
           list
        }".resolvesTo("List<Integer>");
	}
	
	@Test def void testFeatureCall_28() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ]
           val Object o = list.head 
           list
        }".resolvesTo("List<Integer>");
	}

	@Test def void testFeatureCall_30() throws Exception {
		"{ val list = newArrayList(null as Integer).map [ v|v.intValue ]
           val Object o = list.head 
           list
        }".resolvesTo("List<Integer>");
	}
	
	@Test def void testToList_01() throws Exception {
		"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }".resolvesTo("List<? extends String>")
	}
	
	@Test def void testToList_02() throws Exception {
		"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }".resolvesTo("List<? super String>")
	}
	
	@Test def void testToList_03() throws Exception {
		"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }".resolvesTo("List<String>")
	}

	@Test def void testToList_04() throws Exception {
		"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }".resolvesTo("List<String>")
	}
	
	@Test def void testToList_05() throws Exception {
		"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }".resolvesTo("List<String>")
	}
	
	@Test def void testToList_06() throws Exception {
		"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }".resolvesTo("List<String>")
	}
	
	@Test def void testToList_07() throws Exception {
		"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }".resolvesTo("List<String>")
	}
	
	@Test def void testToList_08() throws Exception {
		"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }".resolvesTo("List<String>")
	}
	
	@Test def void testToList_09() throws Exception {
		"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }".resolvesTo("List<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_01() throws Exception {
		"newArrayList('').map(e|newArrayList(e)).flatten".resolvesTo("List<String>")
	}
	
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
	
	@Test def void testTypeByTransitiveExpectation_04() throws Exception {
		"newArrayList.<java.util.Set<Number>>flatten.toList.flatten.head".resolvesTo("Number")
	}
	
	@Test def void testTypeByTransitiveExpectation_05() throws Exception {
		"newArrayList.flatten.<java.util.Set<Number>>toList.flatten.head".resolvesTo("Number")
	}
	
	@Test def void testTypeByTransitiveExpectation_06() throws Exception {
		"newArrayList.flatten.toList.flatten.<Number>head".resolvesTo("Number")
	}
	
	@Test def void testDeferredTypeArgumentResolution_001() throws Exception {
		"newArrayList".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_002() throws Exception {
		"{
			val list = newArrayList
			val String s = list.get(0)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_003() throws Exception {
		"{
			val list = newArrayList
			val String s = list.head
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_004() throws Exception {
		"{
			val list = newArrayList
			list.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_005() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_006() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(list, '', '')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_007() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_008() throws Exception {
		"{
			val list = newArrayList
			org::eclipse::xtext::xbase::lib::CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_05b() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_05c() throws Exception {
		"{
			val list = newArrayList
			list.addAll(newArrayList(''))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_009() throws Exception {
		"{
			val list = newArrayList
			list.addAll(newHashSet(''))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_010() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as java.util.Collection<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_011() throws Exception {
		"{
			val list = newArrayList
			list.addAll('', '', '')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_012() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.add('')
			list.addAll(secondList)
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_013() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(secondList)
			list.add('')
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_014() throws Exception {
		"{
			val list = newArrayList
			val Iterable<String> sublist = list.subList(1, 1)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_015() throws Exception {
		"{
			val list = newArrayList
			val java.util.Set<String> sublist = list.subList(1, 1)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_016() throws Exception {
		"{
			val list = newArrayList
			val java.util.Iterator<String> sublist = list.subList(1, 1).iterator
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_017() throws Exception {
		"{
			val list = newArrayList
			for(String s: list.subList(1, 1)) {}
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Ignore("TODO: figure out why the common super type is something like Number & Comparable<? extends Number & Comparable<?>>")
	@Test def void testDeferredTypeArgumentResolution_018() throws Exception {
		"{
			val list = newArrayList
			list.add(new Integer(0))
			list.add(new Integer(0).doubleValue)
			list
		}".resolvesTo("ArrayList<Number & Comparable<?>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_019() throws Exception {
		"{
			val list = newArrayList
			list.add(new Integer(0))
			list.get(0).toString
			list.add(new Integer(0).doubleValue)
			list
		}".resolvesTo("ArrayList<Integer>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_020() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.get(0))
			list.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_021() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.get(0))
			list.add('')
			second
		}".resolvesTo("ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_022() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.head)
			list.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_023() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.head)
			list.add('')
			second
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_024() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add('')
			list.add(second.get(0))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_025() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add('')
			list.add(second.get(0))
			second
		}".resolvesTo("ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_026() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add('')
			list.add(second.head)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_027() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add('')
			list.add(second.head)
			second
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_028() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.get(0))
			second.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_029() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.get(0))
			second.add('')
			second
		}".resolvesTo("ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_030() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.head)
			second.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_031() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.head)
			second.add('')
			second
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_032() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			second.add('')
			list.add(second.get(0))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_033() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			second.add('')
			list.add(second.get(0))
			second
		}".resolvesTo("ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_034() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			second.add('')
			list.add(second.head)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_035() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			second.add('')
			list.add(second.head)
			second
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_036() throws Exception {
		"{
			val list = newArrayList(newArrayList)
			val Iterable<String> s = list.head
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_037() throws Exception {
		"{
			val list = newArrayList(newArrayList)
			val Iterable<String> s = list.flatten
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_038() throws Exception {
		"{
			val list = newArrayList(newHashSet)
			val String s = list.flatten.head
			list.head
		}".resolvesTo("HashSet<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_039() throws Exception {
		"{
			val list = newArrayList(newArrayList)
			val String s = list.flatten.head
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_040() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList(newArrayList)
			val String s = second.flatten.head
			list.add(second.head)
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_041() throws Exception {
		"{
			val list = newArrayList
			list.addAll('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_042() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll('')
			list.addAll(secondList)
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_043() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(secondList)
			list.addAll('')
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_044() throws Exception {
		"{
			val list = newArrayList
			list.addAll('', '', '')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_045() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll('', '', '')
			list.addAll(secondList)
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_046() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(secondList)
			list.addAll('', '', '')
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_047() throws Exception {
		"println(newArrayList)".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_048() throws Exception {
		"{
			val list = newArrayList
			val String s = println(list.get(0))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_049() throws Exception {
		"{
			val list = newArrayList
			val String s = println(println(list).head)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_050() throws Exception {
		"{
			val list = newArrayList
			println(list).add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_051() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_052() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(println(list), println(''), println(''))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_053() throws Exception {
		"{
			val list = newArrayList
			println(list).addAll(null as java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_054() throws Exception {
		"{
			val list = newArrayList
			println(list).addAll(println(newArrayList('')))
			println(list)
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_055() throws Exception {
		"{
			val list = println(newArrayList)
			println(list).addAll(println(newHashSet('')))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_056() throws Exception {
		"{
			val list = println(newArrayList)
			println(list).addAll(null as java.util.Collection<String>)
			println(list)
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_057() throws Exception {
		"{
			val list = newArrayList
			println(list).addAll('', '', '')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_058() throws Exception {
		"{
			val list = println(newArrayList)
			val secondList = println(newArrayList)
			println(list).add('')
			println(list).addAll(println(secondList))
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_059() throws Exception {
		"{
			val list = println(newArrayList)
			val secondList = println(newArrayList)
			println(list).addAll(println(secondList))
			println(list).add('')
			println(secondList)
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_060() throws Exception {
		"{
			val list = newArrayList
			val Iterable<String> sublist = println(println(list).subList(1, 1))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_061() throws Exception {
		"{
			val list = newArrayList
			val java.util.Set<String> sublist = println(println(list).subList(1, 1))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_062() throws Exception {
		"{
			val list = newArrayList
			val java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_063() throws Exception {
		"{
			val list = println(newArrayList)
			for(String s: println(list.subList(1, 1))) {}
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Ignore("TODO: figure out why the common super type is something like Number & Comparable<? extends Number & Comparable<?>>")
	@Test def void testDeferredTypeArgumentResolution_064() throws Exception {
		"{
			val list = newArrayList
			list.add(println(new Integer(0)))
			list.add(println(new Integer(0).doubleValue))
			list
		}".resolvesTo("ArrayList<Number & Comparable<?>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_065() throws Exception {
		"{
			val list = newArrayList
			list.add(println(new Integer(0)))
			println(list.get(0)).toString
			list.add(println(new Integer(0).doubleValue))
			list
		}".resolvesTo("ArrayList<Integer>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_066() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			println(list).add(println(second.get(0)))
			println(list).add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_067() throws Exception {
		"new java.util.ArrayList".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_068() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = list.get(0)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_069() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = list.head
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_070() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_071() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_072() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(list, '', '')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_073() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(null as java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_074() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(new java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_075() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(newHashSet(''))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_076() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(null as java.util.Collection<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_077() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('', '', '')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_078() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.add('')
			list.addAll(secondList)
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_079() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll(secondList)
			list.add('')
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_080() throws Exception {
		"{
			val list = new java.util.ArrayList
			val Iterable<String> sublist = list.subList(1, 1)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_081() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Set<String> sublist = list.subList(1, 1)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_082() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Iterator<String> sublist = list.subList(1, 1).iterator
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_083() throws Exception {
		"{
			val list = new java.util.ArrayList
			for(String s: list.subList(1, 1)) {}
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Ignore("TODO: figure out why the common super type is something like Number & Comparable<? extends Number & Comparable<?>>")
	@Test def void testDeferredTypeArgumentResolution_084() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new Integer(0))
			list.add(new Integer(0).doubleValue)
			list
		}".resolvesTo("ArrayList<Number & Comparable<?>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_085() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new Integer(0))
			list.get(0).toString
			list.add(new Integer(0).doubleValue)
			list
		}".resolvesTo("ArrayList<Integer>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_086() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			list.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_087() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			list.add('')
			second
		}".resolvesTo("ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_088() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			list.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_089() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			list.add('')
			second
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_090() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.get(0))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_091() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.get(0))
			second
		}".resolvesTo("ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_092() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.head)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_093() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.head)
			second
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_094() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			second.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_095() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			second.add('')
			second
		}".resolvesTo("ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_096() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			second.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_097() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			second.add('')
			second
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_098() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.get(0))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_099() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.get(0))
			second
		}".resolvesTo("ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_100() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.head)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_101() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.head)
			second
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_102() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.HashSet)
			val Iterable<String> s = list.head
			list.head
		}".resolvesTo("HashSet<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_103() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = list.flatten
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_104() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(newHashSet)
			val String s = list.flatten.head
			list.head
		}".resolvesTo("HashSet<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_105() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val String s = list.flatten.head
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_106() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add(new java.util.ArrayList)
			val String s = second.flatten.head
			list.add(second.head)
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_107() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_108() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll('')
			list.addAll(secondList)
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_109() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll(secondList)
			list.addAll('')
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_110() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('', '', '')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_111() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll('', '', '')
			list.addAll(secondList)
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_112() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll(secondList)
			list.addAll('', '', '')
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_113() throws Exception {
		"println(new java.util.ArrayList)".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_114() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = println(list.get(0))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_115() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = println(println(list).head)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_116() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_117() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_118() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(println(list), println(''), println(''))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_119() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).addAll(null as java.util.ArrayList<String>)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_120() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).addAll(println(new java.util.ArrayList<String>))
			println(list)
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_121() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			println(list).addAll(println(newHashSet('')))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_122() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			println(list).addAll(null as java.util.Collection<String>)
			println(list)
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_123() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).addAll('', '', '')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_124() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			val secondList = println(new java.util.ArrayList)
			println(list).add('')
			println(list).addAll(println(secondList))
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_125() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			val secondList = println(new java.util.ArrayList)
			println(list).addAll(println(secondList))
			println(list).add('')
			println(secondList)
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_126() throws Exception {
		"{
			val list = new java.util.ArrayList
			val Iterable<String> sublist = println(println(list).subList(1, 1))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_127() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Set<String> sublist = println(println(list).subList(1, 1))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_128() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_129() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			for(String s: println(list.subList(1, 1))) {}
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Ignore("TODO: figure out why the common super type is something like Number & Comparable<? extends Number & Comparable<?>>")
	@Test def void testDeferredTypeArgumentResolution_130() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(println(new Integer(0)))
			list.add(println(new Integer(0).doubleValue))
			list
		}".resolvesTo("ArrayList<Number & Comparable<?>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_131() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(println(new Integer(0)))
			println(list.get(0)).toString
			list.add(println(new Integer(0).doubleValue))
			list
		}".resolvesTo("ArrayList<Integer>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_132() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			println(list).add(println(second.get(0)))
			println(list).add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_133() throws Exception {
		"{
			val list = newArrayList
			list.map[String s| s]
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_134() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map[String s| s]
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_135() throws Exception {
		"{
			val list = newArrayList
			list.add(newArrayList)
			val Iterable<String> s = list.head
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_136() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = list.head
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_01() throws Exception {
		"{
			val list = newArrayList
			list.addAll(list)
			list
		}".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_02() throws Exception {
		"{
			val list = newArrayList
			list.add(list.head)
			list
		}".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_03() throws Exception {
		"{
			val list = newArrayList
			list.addAll(list)
			list.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_04() throws Exception {
		"{
			val list = newArrayList
			list.add(list.head)
			list.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_05() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(list)
			list
		}".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_06() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(list.head)
			list
		}".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_07() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(list)
			list.add('')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_08() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(list.head)
			list.add('')
			list
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

/**
 * This tests ensures that the type calculation does not depend on some lazy evaluation.
 * Therefore all argument types for all overloaded variants are computed eagerly.
 * @author Sebastian Zarnekow
 */
class IsolationTest extends BatchTypeResolverTest {

	@Inject
	EagerArgumentTypeResolver eagerResolver

	@Inject
	Provider<IReentrantTypeResolver> typeResolverProvider;
	
	@Inject
	extension ReflectExtensions

	@Before
	def void setEagerResolver() {
		val castedResolver = typeResolver as DefaultBatchTypeResolver
		val Provider<IReentrantTypeResolver> provider = [|
			val reentrantResolver = typeResolverProvider.get
			reentrantResolver.set("typeComputer", eagerResolver)
			return reentrantResolver
		]
		castedResolver.set("typeResolverProvider", provider)
	}

}

/**
 * @author Sebastian Zarnekow
 */
@Singleton
class EagerArgumentTypeResolver extends XbaseTypeComputer {
	
	override protected <Candidate extends ILinkingCandidate<Candidate>> getBestCandidate(List<Candidate> candidates) {
		candidates.forEach[
			(it as AbstractLinkingCandidate).computeArgumentTypes(feature)
		]
		super.<Candidate> getBestCandidate(candidates)
	}
	
}
