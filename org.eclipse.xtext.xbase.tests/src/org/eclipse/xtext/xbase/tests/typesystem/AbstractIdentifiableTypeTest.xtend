/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import java.util.Set
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Ignore
import org.junit.Test
import org.eclipse.xtext.xbase.XExpression

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractIdentifiableTypeTest extends AbstractXbaseTestCase {
	
	def void resolvesIdentifiablesTo(String expression, String... types)
	
	static Set<String> seenExpressions
	
	@BeforeClass
	def static void createSeenExpressionsSet() {
		seenExpressions = newHashSet
	}
	
	@AfterClass
	def static void discardSeenExpressions() {
		seenExpressions = null
	}
	
	def protected findIdentifiables(XExpression expression) {
		val identifiables = EcoreUtil2::eAll(expression).map[
			switch(it) {
				// derived features are not part of eContents thus we add it here explicitly
				XClosure: it.implicitFormalParameters
				default: #[it] 
			}
		].toIterable.flatten.toSet.filter [
			it !== null && switch(it) {
				XVariableDeclaration: true
				JvmFormalParameter: true
				default: false
			}
		].filter(JvmIdentifiableElement).toList
		return identifiables.sortBy [ 
			val node = NodeModelUtils::findActualNodeFor(it)
			if (node !== null) 
				node.offset
			else
				NodeModelUtils::findActualNodeFor(it.eContainer).offset
		]
	}
	
	override protected expression(CharSequence expression, boolean resolve) throws Exception {
		val string = expression.toString
		if (!seenExpressions.add(string)) {
			fail("Duplicate expression under test: " + expression)
		}
		super.expression(expression, resolve)
	}
	
	@Test def void testIfExpression_01() throws Exception {
		"{ val x = if (true) while(false) ('foo'+'bar').length }".resolvesIdentifiablesTo("null")
	}
	
	@Test def void testIfExpression_02() throws Exception {
		"{ val Object x = if (true) while(false) ('foo'+'bar').length }".resolvesIdentifiablesTo("Object")
	}

	@Test def void testOverloadedMethods_01() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)
		}".resolvesIdentifiablesTo("List<CharSequence>", "Object")
	}
	
	@Test def void testOverloadedMethods_02() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)
		}".resolvesIdentifiablesTo("List<CharSequence>", "String")
	}
	
	@Test def void testOverloadedMethods_03() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)
		}".resolvesIdentifiablesTo("List<? extends CharSequence>", "Object")
	}
	
	@Test def void testOverloadedMethods_04() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)
		}".resolvesIdentifiablesTo("List<? extends CharSequence>", "String")
	}
	
	@Test def void testOverloadedOperators_05() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ int it | 1l % it == 0 ].isEmpty".resolvesIdentifiablesTo("int")
	}
	
	@Test def void testOverloadedOperators_06() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ 1l % it == 0 ].isEmpty".resolvesIdentifiablesTo("Integer")
	}
	
	@Test def void testOverloadedOperators_07() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].isEmpty".resolvesIdentifiablesTo("Integer")
	}
	
	@Test def void testOverloadedOperators_08() throws Exception {
		"(1..2).map[ toString ].reduce[ i1, i2| i1 + i2 ]".resolvesIdentifiablesTo("Integer", "String", "String")
	}
	
	@Test def void testOverloadedOperators_09() throws Exception {
		"(1..2).map[ toString.length ].reduce[ i1, i2| i1 + i2 ]".resolvesIdentifiablesTo("Integer", "Integer", "Integer")
	}
	
	@Test def void testOverloadedOperators_10() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]".resolvesIdentifiablesTo("Integer", "BigInteger", "BigInteger")
	}
	
	@Ignore("i1 and i2 should become T -> Object thus + maps to String + Object")
	@Test def void testOverloadedOperators_11() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2 | i1.toString + i2 ]".resolvesIdentifiablesTo("Integer", "Object", "Object")
	}
	
	@Test def void testOverloadedOperators_12() throws Exception {
		"{
			val i = 1bi
			val s = ''
			s + i
		}".resolvesIdentifiablesTo("BigInteger", "String")
	}
	
	@Ignore("i1 and i2 should become T -> Object thus + maps to Object + String")
	@Test def void testOverloadedOperators_13() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + String::valueOf(i2) ]".resolvesIdentifiablesTo("Integer", "Object", "Object")
	}
	
	@Test def void testOverloadedOperators_15() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]".resolvesIdentifiablesTo("Integer", "BigInteger")
	}
	
	@Test def void testOverloadedOperators_16() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].map[ it + String::valueOf(it) ]".resolvesIdentifiablesTo("Integer", "BigInteger")
	}
	
	@Test def void testOverloadedOperators_17() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].empty".resolvesIdentifiablesTo("Integer")
	}

	@Test def void testTryCatchFinallyExpression_0() throws Exception {
		"try 'foo' catch (Exception e) 'bar'".resolvesIdentifiablesTo("Exception") 
	}
	
	@Test def void testTryCatchFinallyExpression_1() throws Exception {
		"try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz'".resolvesIdentifiablesTo("Exception", "RuntimeException")	
	}
	
	@Test def void testTryCatchFinallyExpression_2() throws Exception {
		"try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz' finally true".resolvesIdentifiablesTo("Exception", "RuntimeException")	
	}
	
	@Test def void testArrayVariable_01() throws Exception {
		"{ var a = 'a,b,c'.split(',') }".resolvesIdentifiablesTo("String[]")	
	}

	@Test def void testForExpression_01() throws Exception {
		"for(String x : new java.util.ArrayList<String>()) x.length".resolvesIdentifiablesTo("String")
		"for(String x : newArrayList('foo')) x.length".resolvesIdentifiablesTo("String")
		"for(String x : <String>newArrayList()) x.length".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testForExpression_02() throws Exception {
		"for(x : new java.util.ArrayList<String>()) x.length".resolvesIdentifiablesTo("String")
		"for(x : <String>newArrayList()) x.length".resolvesIdentifiablesTo("String")
		"for(x : newArrayList('foo')) x.length".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testForExpression_03() throws Exception {
		"for(String x : null as String[][]) x.length".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testForExpression_04() throws Exception {
		"for(x : null as String[][]) x.size".resolvesIdentifiablesTo("String[]")
	}
	
	@Test def void testForExpression_05() throws Exception {
		"for(x : null as java.util.Set) x.toString".resolvesIdentifiablesTo("Object")
	}
	
	@Test def void testForExpression_06() throws Exception {
		"for(x : null as Iterable<String>?:emptyList) x.toString".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testMethodTypeParamInference_00() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e | true)".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testMethodTypeParamInference_01() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e|e == 'foo')".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testMethodTypeParamInference_02() throws Exception {
		"new java.util.ArrayList<String>().<String>findFirst(e|e == 'foo')".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testMethodTypeParamInference_03() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testMethodTypeParamInference_04() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == 'foo']".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testMethodTypeParamInference_05() throws Exception {
		"$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == 'foo']".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testClosure_01() throws Exception {
		"{ var closure = [|'literal']
		  new testdata.ClosureClient().invoke0(closure)	}".resolvesIdentifiablesTo("()=>String")
	}
	
	@Test def void testClosure_02() throws Exception {
		"[String x| true]".resolvesIdentifiablesTo("String")
	}
	
	@Test
	def void testClosure_03() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e|e)\n" +
		"}").resolvesIdentifiablesTo("List<? super String>", "Object")
	}

	@Test
	def void testClosure_04() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e|false)\n" +
		"}").resolvesIdentifiablesTo("List<? super String>", "Object")
	}

	@Test def void testClosure_05() throws Exception {
		"[x| true]".resolvesIdentifiablesTo("Object")
	}
	
	@Test def void testClosure_07() throws Exception {
		"[String x, String y| x + y ]".resolvesIdentifiablesTo("String", "String")
	}
	
	@Test def void testClosure_08() throws Exception {
		"[x| x]".resolvesIdentifiablesTo("Object")
	}
	
	@Test def void testClosure_11() throws Exception {
		"[Object x| x]".resolvesIdentifiablesTo("Object")
	}
	
	@Test def void testClosure_13() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper)
		}".resolvesIdentifiablesTo("(Integer)=>Integer", "Integer")
	}
	
	@Test def void testClosure_13b() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper).findFirst [ true ]
		}".resolvesIdentifiablesTo("(Integer)=>Integer", "Integer", "Integer")
	}
	
	@Ignore("TODO deferred closure body typing")
	@Test def void testClosure_14() throws Exception {
		"{ 
			val mapper = [ x | x.charAt(0) ]
			newArrayList('').map(mapper)
		}".resolvesIdentifiablesTo("(String)=>char", "String")
	}
	
	@Test def void testClosure_15() throws Exception {
		"{ 
			val fun = [ x | x ]
			val String s = fun.apply(null)
			fun
		}".resolvesIdentifiablesTo("(String)=>String", "String", "String")
	}
	
	@Test def void testClosure_16() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList(fun.apply(null))
			fun
		}".resolvesIdentifiablesTo("(String[])=>String[]", "String[]", "List<String>")
	}
	
	@Test def void testClosure_17() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList.map(fun)
			fun
		}".resolvesIdentifiablesTo("(String)=>String", "String", "List<String>")
	}
	
	@Test def void testClosure_21() throws Exception {
		"{ 
			val fun = [ x | x ]
			val list = newArrayList.map(fun)
			val Iterable<String> iter = list
			fun
		}".resolvesIdentifiablesTo("(String)=>String", "String", "List<String>", "Iterable<String>")
	}
	
	@Test def void testClosure_22() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesIdentifiablesTo("(String)=>String", "String", "List<String>")
	}
	
	@Test def void testClosure_26() throws Exception {
		"{ 
			val fun = [ x | x ]
			val list = $$ListExtensions::map(newArrayList, fun)
			val Iterable<String> iter = list
			fun
		}".resolvesIdentifiablesTo("(String)=>String", "String", "List<String>", "Iterable<String>")
	}
	
	@Test def void testClosure_27() throws Exception {
		"{ 
			val mapper = [ x | x ]
			$$ListExtensions::map(newArrayList(1), mapper)
		}".resolvesIdentifiablesTo("(Integer)=>Integer", "Integer")
	}
	
	@Test def void testClosure_30() throws Exception {
		"$$ListExtensions::map(null as java.util.List<? super String>) [e|e]".resolvesIdentifiablesTo("Object")
	}
	
	@Test def void testClosure_31() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  $$ListExtensions::map(list) [e|e]\n" +
		"}").resolvesIdentifiablesTo("List<? super String>", "Object")
	}
	
	@Test def void testSwitchExpression_3() throws Exception {
		"{
			val Object c = null
			switch c {
	            CharSequence: 1
	    	}
		}".resolvesIdentifiablesTo("Object")
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
		}".resolvesIdentifiablesTo("Comparable<Object>")
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
		}".resolvesIdentifiablesTo("Comparable<Object>")
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
		}".resolvesIdentifiablesTo("Comparable<Object>")
	}
	
	@Test def void testTypeGuardedCase_0() throws Exception {
		"switch s: new Object() { String: s StringBuffer: s}".resolvesIdentifiablesTo("Object")
	}
	
	@Test def void testTypeGuardedCase_1() throws Exception {
		"switch s: '' as CharSequence { Cloneable: s String: s }".resolvesIdentifiablesTo("CharSequence")
	}
	
	@Test def void testBlockExpression_02() throws Exception {
		"{val s = '' s}".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testBlockExpression_04() throws Exception {
		"{val Object s = '' s}".resolvesIdentifiablesTo("Object")
	}
	
	@Test def void testEMap_01() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getKey ].head
         }".resolvesIdentifiablesTo("BasicEMap<Integer, String>", "Entry<Integer, String>")
	}
	
	@Test def void testEMap_05() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ key ].head
         }".resolvesIdentifiablesTo("BasicEMap<? extends Integer, String>", "Entry<? extends Integer, String>")
	}
	
	@Test def void testEMap_09() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map[ key ].head
         }".resolvesIdentifiablesTo("BasicEMap<? super Integer, String>", "Entry<? super Integer, String>")
	}
	
	@Test def void testMemberFeatureCall_02() throws Exception {
		"(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]".resolvesIdentifiablesTo("Integer", "Integer", "Integer")
	}
	
	@Test def void testFeatureCall_06() throws Exception {
		"newArrayList('').map(s|s)".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_06a() throws Exception {
		"newArrayList('').map [it|it]".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_06b() throws Exception {
		"newArrayList('').map [it]".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_06c() throws Exception {
		"(null as Iterable<String>).map(s|s)".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_06_00() throws Exception {
		"$$ListExtensions::map(newArrayList('')) [s|s]".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_06_01() throws Exception {
		"newArrayList('').map(s|s).head".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_06_02() throws Exception {
		"newArrayList('').map(s|s.toString).head".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_06_03() throws Exception {
		"newArrayList('').map(s|1)".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_07() throws Exception {
		"newArrayList('').map(s|s.length)".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_07_01() throws Exception {
		"<String>newArrayList.map[ length ]".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_10() throws Exception {
		"newArrayList('').map(s|1).map(i|i+1)".resolvesIdentifiablesTo("String", "Integer")
	}
	
	@Test def void testFeatureCall_12() throws Exception {
		"newArrayList('').map(s|1).toList().map(i|i)".resolvesIdentifiablesTo("String", "Integer")
	}
	
	@Test def void testFeatureCall_13_2() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it.map(i|i+1) }".resolvesIdentifiablesTo("List<Integer>", "String", "Integer")
	}
	
	@Test def void testFeatureCall_13_3() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() map(i|i+1) }".resolvesIdentifiablesTo("List<Integer>", "String", "Integer")
	}
	
	@Test def void testFeatureCall_13_5() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i|i+1) }".resolvesIdentifiablesTo("List<? extends Integer>", "Integer")
	}
	
	@Test def void testFeatureCall_13_6() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i|i) }".resolvesIdentifiablesTo("List<? extends Integer>", "Integer")
	}
	
	@Test def void testFeatureCall_14() throws Exception {
		"newArrayList(newArrayList('').map(s|1))".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_15() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size())".resolvesIdentifiablesTo("String", "List<Integer>")
	}
	
	@Test def void testFeatureCall_15_a() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e)".resolvesIdentifiablesTo("String", "List<Integer>", "Integer")
	}
	
	@Test def void testFeatureCall_15_b() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e)".resolvesIdentifiablesTo("String", "List<Integer>", "Integer", "Integer")
	}
	
	@Test def void testFeatureCall_15_e() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size())".resolvesIdentifiablesTo("String", "Integer", "List<Integer>")
	}
	
	@Test def void testFeatureCall_15_e_2() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size())".resolvesIdentifiablesTo("ArrayList<String>")
	}
	
	@Test def void testFeatureCall_15_f() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size())".resolvesIdentifiablesTo("String", "Integer", "Integer", "List<Integer>")
	}
	
	@Test def void testFeatureCall_15_i_3() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e)".resolvesIdentifiablesTo("String", "Integer", "List<Integer>",  "Integer")
	}
	
	@Test def void testFeatureCall_15_p() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e)".resolvesIdentifiablesTo("ArrayList<String>", "Integer");
	}
	
	@Test def void testFeatureCall_16_a() throws Exception {
		"newArrayList('').map(s|1).map(i|1)".resolvesIdentifiablesTo("String", "Integer")
	}
	
	@Test def void testFeatureCall_18_a() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b|b)".resolvesIdentifiablesTo("String", "Boolean")
	}
	
	@Test def void testFeatureCall_20_a() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(boolean b|!b)".resolvesIdentifiablesTo("String", "boolean")
	}
	
	@Test def void testFeatureCall_24_a() throws Exception {
		("newArrayList('').map(s|" +
				"$$ObjectExtensions::operator_equals(" +
				"	$$IntegerExtensions::operator_plus(s.length,1), 5)" +
				").map(b| $$BooleanExtensions::operator_not(b) )").resolvesIdentifiablesTo("String", "Boolean")
	}
	
	@Test def void testFeatureCall_25_a() throws Exception {
		"newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 )".resolvesIdentifiablesTo("String", "Integer")
	}
	
	@Test def void testFeatureCall_25_c() throws Exception {
		"newArrayList('').map[ length + 1 * 5 ].map [ it / 5 ].head".resolvesIdentifiablesTo("String", "Integer")
	}
	
	@Test def void testFeatureCall_26() throws Exception {
		if (isJava12OrLater) {
			"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
			   val Object o = list.head 
			   list
			}".resolvesIdentifiablesTo("List<Integer>", "Number & Comparable<?> & Constable & ConstantDesc", "Object")
		} else {
			"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
			   val Object o = list.head 
			   list
			}".resolvesIdentifiablesTo("List<Integer>", "Number & Comparable<?>", "Object")
		}
	}
	
	@Test def void testFeatureCall_27() throws Exception {
		if (isJava12OrLater) {
			"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v|v.intValue ]
			   val Object o = list.head 
			   list
			}".resolvesIdentifiablesTo("List<Integer>", "Number & Comparable<?> & Constable & ConstantDesc", "Object")
		} else {
			"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v|v.intValue ]
			   val Object o = list.head 
			   list
			}".resolvesIdentifiablesTo("List<Integer>", "Number & Comparable<?>", "Object")
		}
	}
	
	@Test def void testFeatureCall_28() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ] }".resolvesIdentifiablesTo("List<Integer>", "Integer")
	}

	@Test def void testFeatureCall_30() throws Exception {
		"{ val list = newArrayList(null as Integer).map [ v|v.intValue ]
           val o = list.head 
           list
        }".resolvesIdentifiablesTo("List<Integer>", "Integer", "Integer");
	}
	
	@Test def void testFeatureCall_31() throws Exception {
		"{ val list = newArrayList(null as Integer).map [ v|v.intValue ]
           list.findFirst [ intValue == 0 ]
        }".resolvesIdentifiablesTo("List<Integer>", "Integer", "Integer");
	}
	
	@Test def void testFeatureCall_32() throws Exception {
		"{
			val list = newArrayList
			list.forEach[String s | s]
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "String")
	}
	
	@Test def void testFeatureCall_34() throws Exception {
		"newArrayList.map[String s | s.substring(1,1) ]".resolvesIdentifiablesTo("String")
	}

	@Test def void testFeatureCall_35() throws Exception {
		"newArrayList.map[ s | s.toString ]".resolvesIdentifiablesTo("Object")
	}
	
	@Test def void testFeatureCall_36() throws Exception {
		"{
			val list = newArrayList
			list.forEach[ s | s.toString ]
			list
		}".resolvesIdentifiablesTo("ArrayList<Object>", "Object")
	}
	
	@Test def void testFeatureCall_Bug342134_00() throws Exception {
		"(null as java.util.List<String>).map(e|newArrayList(e)).flatten".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_Bug342134_01() throws Exception {
		"(null as java.util.List<String>).map(CharSequence e|newArrayList(e)).flatten".resolvesIdentifiablesTo("CharSequence")
	}
	
	@Test def void testFeatureCall_Bug342134_02() throws Exception {
		"newArrayList('').map(e|newArrayList(e)).flatten".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_Bug342134_04() throws Exception {
		"newArrayList('').map(e|newArrayList(e))".resolvesIdentifiablesTo("String")
	}
	
	@Test def void testFeatureCall_Bug342134_06() throws Exception {
		"<String>newArrayList.map(e|newArrayList(e)).flatten".resolvesIdentifiablesTo("String")
	}
	
	// TODO fix the following case
	@Ignore("TODO this should work")
	@Test def void testBug_391758() throws Exception {
		"{
			val iterable = newArrayList
			iterable.fold(newArrayList) [ list , elem | null as java.util.List<String> ]
		}".resolvesIdentifiablesTo("ArrayList<Object>", "List<String>", "Object")
	}
	
	@Test def void testDeferredTypeArgumentResolution_002() throws Exception {
		"{
			val list = newArrayList
			val String s = list.get(0)
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_012() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.add('')
			list.addAll(secondList)
			secondList
		}".resolvesIdentifiablesTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_016() throws Exception {
		"{
			val list = newArrayList
			val java.util.Iterator<String> sublist = list.subList(1, 1).iterator
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "Iterator<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_036() throws Exception {
		"{
			val list = newArrayList(newArrayList)
			val Iterable<String> s = list.head
			list.head
		}".resolvesIdentifiablesTo("ArrayList<ArrayList<String>>", "Iterable<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_037() throws Exception {
		"{
			val list = newArrayList(newArrayList)
			val Iterable<String> s = list.flatten
			list.head
		}".resolvesIdentifiablesTo("ArrayList<ArrayList<String>>", "Iterable<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_038() throws Exception {
		"{
			val list = newArrayList(newHashSet)
			val String s = list.flatten.head
			list.head
		}".resolvesIdentifiablesTo("ArrayList<HashSet<String>>", "String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_040() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList(newArrayList)
			val String s = second.flatten.head
			list.add(second.head)
			list.head
		}".resolvesIdentifiablesTo("ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_042() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll('')
			list.addAll(secondList)
			secondList
		}".resolvesIdentifiablesTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_061() throws Exception {
		"{
			val list = newArrayList
			val java.util.Set<String> sublist = println(println(list).subList(1, 1))
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "Set<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_062() throws Exception {
		"{
			val list = newArrayList
			val java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "Iterator<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_102() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.HashSet)
			val Iterable<String> s = list.head
			list.head
		}".resolvesIdentifiablesTo("ArrayList<HashSet<String>>", "Iterable<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_106() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add(new java.util.ArrayList)
			val String s = second.flatten.head
			list.add(second.head)
			list.head
		}".resolvesIdentifiablesTo("ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_133() throws Exception {
		"{
			val list = newArrayList
			val fun = [String s| s]
			list.map(fun)
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "(String)=>String", "String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_134() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map[String s| s]
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_135() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.<String, Object>map[s| s]
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "String")
	}

	@Test def void testDeferredTypeArgumentResolution_136() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.<String, Object>map[s| s.toString]
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "String")
	}	

	@Test def void testDeferredTypeArgumentResolution_137() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.<String, Object>map[s| s.charAt(1) ]
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_138() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.<String, CharSequence>map[s| s]
			list
		}".resolvesIdentifiablesTo("ArrayList<String>", "String")
	}
}
