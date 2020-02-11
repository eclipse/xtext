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
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractFeatureCallTypeTest extends AbstractXbaseTestCase {
	
	def void resolvesFeatureCallsTo(String expression, String... types) 
	
	static Set<String> seenExpressions
	
	@BeforeClass
	def static void createSeenExpressionsSet() {
		seenExpressions = newHashSet
	}
	
	@AfterClass
	def static void discardSeenExpressions() {
		seenExpressions = null
	}
	
	def protected findFeatureCalls(CharSequence expression) {
		val xExpression = expression(expression, false)
		val featureCalls = EcoreUtil2::eAll(xExpression).filter(typeof(XAbstractFeatureCall)).toList
		return featureCalls.sortBy [ NodeModelUtils::findNodesForFeature(it, XbasePackage$Literals::XABSTRACT_FEATURE_CALL__FEATURE).head.offset ]
	}
	
	def protected filterTypeLiteralsAndPackageFragments(Iterable<XAbstractFeatureCall> featureCalls) {
		featureCalls.filter[ !packageFragment && !typeLiteral ]
	}
	
	override protected expression(CharSequence expression, boolean resolve) throws Exception {
		val string = expression.toString
		if (!seenExpressions.add(string)) {
			fail("Duplicate expression under test: " + expression)
		}
		super.expression(expression, resolve)
	}
	
	@Test def void testJEP101Example_01() throws Exception {
		"{ val foo.JEP101List<String> ls = foo::JEP101List::nil }".resolvesFeatureCallsTo("JEP101List<String>")
	}
	@Test def void testJEP101Example_02() throws Exception {
		"foo::JEP101List::cons(42, foo::JEP101List::nil)".resolvesFeatureCallsTo("JEP101List<Integer>", "JEP101List<Integer>")
	}
	@Test def void testJEP101Example_03() throws Exception {
		"{ val String s = foo::JEP101List::nil.head }".resolvesFeatureCallsTo("JEP101List<String>", "String")
	}
	
	@Test def void testElvisWithEmptyListInLambda() throws Exception {
		"[ String s |
			val result = <Integer>newArrayList
			val (String)=>Iterable<Integer> fun = []
			result += fun.apply(s) ?: emptyList
			result
		]".resolvesFeatureCallsTo(
			"ArrayList<Integer>", // <Integer>newArrayList
			"ArrayList<Integer>", // result
			"boolean", // +=
			"(String)=>Iterable<Integer>", // fun
			"Iterable<Integer>", // apply 
			"String", // s
			"Iterable<Integer>", // ?: 
			"List<Integer>", // emptyList
			"ArrayList<Integer>") // result
	}
	
	@Test def void testElvisWithEmptyList() throws Exception {
		"{ 
			val java.util.List<Integer> list = null
			val fun = [| list ]
			list += fun.apply ?: emptyList
         }".resolvesFeatureCallsTo(
			"List<Integer>", // list in lambda
			"List<Integer>", // list
			"boolean", // +=
			"()=>List<Integer>", // fun
			"List<Integer>", // apply
			"List<Integer>", // ?: 
			"List<Integer>") // emptyList
	}
	
	@Test def void testRawType_01() throws Exception {
		"{ val java.util.Set set = newHashSet() set }".resolvesFeatureCallsTo("HashSet", "Set")
	}
	
	@Test def void testRawType_02() throws Exception {
		"{ val java.util.Set set = newHashSet set.head }".resolvesFeatureCallsTo("HashSet", "Set", "Object")
	}
	
	@Test def void testRawType_03() throws Exception {
		"(null as java.util.Set<java.util.Set>).head".resolvesFeatureCallsTo("Set")
	}
	
	@Test def void testRawType_04() throws Exception {
		"{ val java.util.Set<java.util.Set> set = newHashSet set.head }".resolvesFeatureCallsTo("HashSet<Set>", "Set<Set>", "Set")
	}
	
	@Test def void testRawType_05() throws Exception {
		"{ val java.util.Set<java.util.Set> set = newHashSet(newHashSet) set.head }".resolvesFeatureCallsTo("HashSet<Set>", "HashSet", "Set<Set>", "Set")
	}

	@Test def void testNumberLiteralInClosure_01() throws Exception {
		"newArrayList().map[42]".resolvesFeatureCallsTo("ArrayList<Object>", "List<Integer>")
	}
	
	@Test def void testOverloadedMethods_01() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)
		}".resolvesFeatureCallsTo("int", "List<CharSequence>", "Object")
	}
	
	@Test def void testOverloadedMethods_02() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)
		}".resolvesFeatureCallsTo("long", "List<CharSequence>", "String")
	}
	
	@Test def void testOverloadedMethods_03() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)
		}".resolvesFeatureCallsTo("int", "List<? extends CharSequence>", "Object")
	}
	
	@Test def void testOverloadedMethods_04() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)
		}".resolvesFeatureCallsTo("int", "List<? extends CharSequence>", "String")
	}
	
	@Test def void testOverloadedMethods_05() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, null)
		}".resolvesFeatureCallsTo("long", "List<CharSequence>")
	}
	
	@Test def void testOverloadedMethods_06() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, null)
		}".resolvesFeatureCallsTo("int", "List<? extends CharSequence>")
	}
	
	@Test def void testOverloadedMethods_07() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)
		}".resolvesFeatureCallsTo("int", "List<CharSequence>", "Object")
	}
	
	@Test def void testOverloadedMethods_08() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)
		}".resolvesFeatureCallsTo("long", "List<CharSequence>", "String")
	}
	
	@Test def void testOverloadedMethods_09() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)
		}".resolvesFeatureCallsTo("int", "List<? extends CharSequence>", "Object")
	}
	
	@Test def void testOverloadedMethods_10() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)
		}".resolvesFeatureCallsTo("long", "List<? extends CharSequence>", "String")
	}
	
	@Test def void testOverloadedMethods_11() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)
		}".resolvesFeatureCallsTo("long", "List<CharSequence>")
	}
	
	@Test def void testOverloadedMethods_12() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)
		}".resolvesFeatureCallsTo("long", "List<? extends CharSequence>")
	}
	
	@Test def void testOverloadedOperators_12() throws Exception {
		"{
			val i = 1bi
			val s = ''
			s + i
		}".resolvesFeatureCallsTo("String", "String", "BigInteger")
	}
	
	@Test def void testOverloadedOperators_14() throws Exception {
		"{
			val i = 1bi
			val s = ''
			i + s
		}".resolvesFeatureCallsTo("BigInteger", "String", "String")
	}
	
	@Test def void testForExpression_01() throws Exception {
		"for(String x : new java.util.ArrayList<String>()) x.length".resolvesFeatureCallsTo("String", "int")
		"for(String x : newArrayList('foo')) x.length".resolvesFeatureCallsTo("ArrayList<String>", "String", "int")
		"for(String x : <String>newArrayList()) x.length".resolvesFeatureCallsTo("ArrayList<String>", "String", "int")
	}
	
	@Test def void testForExpression_02() throws Exception {
		"for(x : new java.util.ArrayList<String>()) x.length".resolvesFeatureCallsTo("String", "int")
		"for(x : <String>newArrayList()) x.length".resolvesFeatureCallsTo("ArrayList<String>", "String", "int")
		"for(x : newArrayList('foo')) x.length".resolvesFeatureCallsTo("ArrayList<String>", "String", "int")
	}
	
	@Test def void testForExpression_03() throws Exception {
		"for(String x : null as String[]) x.length".resolvesFeatureCallsTo("String", "int")
	}
	
	@Test def void testForExpression_04() throws Exception {
		"for(x : null as String[]) x.length".resolvesFeatureCallsTo("String", "int")
	}
	
	@Test def void testBasicForExpression_01() {
		"for(val x = new Object; x instanceof String;) { val y = x }".resolvesFeatureCallsTo("Object", "String")
	}
	
	@Test def void testBasicForExpression_02() {
		"for(val x = new Object; x instanceof String && true;) { val y = x }".resolvesFeatureCallsTo("Object", "boolean", "Object")
	}
	
	@Test def void testBasicForExpression_03() {
		'''
			{
				var Object y = null
				for(var x = new Object; x instanceof String; y = x) { 
					y = x
					x = new Object
				}
			}
		'''.toString.resolvesFeatureCallsTo("Object", "Object", "Object", "Object", "String", "Object")
	}

	@Test def void testMethodTypeParamInference_01() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e|e == 'foo')".resolvesFeatureCallsTo("String", "String", "boolean")
	}
	
	@Test def void testMethodTypeParamInference_02() throws Exception {
		"new java.util.ArrayList<String>().<String>findFirst(e|e == 'foo')".resolvesFeatureCallsTo("String", "String", "boolean")
	}
	
	@Test def void testMethodTypeParamInference_04() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == 'foo']".resolvesFeatureCallsTo("String", "String", "boolean")
	}
	
	@Test def void testMethodTypeParamInference_05() throws Exception {
		"$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == 'foo']".resolvesFeatureCallsTo("String", "String", "boolean")
	}
	
	@Test def void testTypeForVoidClosure() throws Exception {
		"newArrayList('foo','bar').forEach []".resolvesFeatureCallsTo("ArrayList<String>", "void")
	}

	@Test def void testFeatureCallWithArrayToIterableConversion() throws Exception {
		"'foo'.toCharArray.iterator".resolvesFeatureCallsTo("char[]", "Iterator<Character>")
	}
	
	@Test def void testArray_01() throws Exception {
		"'a,b,c'.split(',').tail".resolvesFeatureCallsTo("String[]", "Iterable<String>")
	}
	
	@Test def void testArray_02() throws Exception {
		"new testdata.ArrayClient().swap('a,b,c'.split(','))".resolvesFeatureCallsTo("String[]", "String[]")
	}
	
	@Test def void testArray_03() throws Exception {
		"new testdata.ArrayClient().swap('a,b,c'.split(',').tail)".resolvesFeatureCallsTo("String[]", "String[]", "Iterable<String>")
	}
	
	@Test def void testArray_04() throws Exception {
		"new testdata.ArrayClient().swap(null)".resolvesFeatureCallsTo("Object[]")
	}
	
	@Test def void testArray_05() throws Exception {
		"new testdata.ArrayClient().swap(null as Integer[])".resolvesFeatureCallsTo("Integer[]")
	}
	
	@Test def void testArray_06() throws Exception {
		"{ val Integer[] x = new testdata.ArrayClient().swap(null) }".resolvesFeatureCallsTo("Integer[]")
	}
	
	@Test def void testArray_07() throws Exception {
		"{ val x = new testdata.ArrayClient().swap(null) val Integer[] y = x }".resolvesFeatureCallsTo("Integer[]", "Integer[]")
	}
	
	@Test def void testArray_08() throws Exception {
		"{ val x = new testdata.ArrayClient().swap(null) val Integer y = x.head }".resolvesFeatureCallsTo("Integer[]", "Integer[]", "Integer")
	}
	
	@Test def void testArray_09() throws Exception {
		"{ val x = new testdata.ArrayClient().swap(null) val Integer[] y = x.head }".resolvesFeatureCallsTo("Integer[][]", "Integer[][]", "Integer[]")
	}
	
	@Test def void testReturnType_02() throws Exception {
		"return try { if (true) 'foo' else 'bar' } finally { String::valueOf('zonk') }".resolvesFeatureCallsTo("String")
	}
	
	@Test def void testClosure_01() throws Exception {
		"{ var closure = [|'literal']
		  new testdata.ClosureClient().invoke0(closure)	}".resolvesFeatureCallsTo("String", "()=>String")
	}
	
	@Test def void testClosure_02() throws Exception {
		"{ var com.google.common.collect.AbstractIterator<String> iter = [| return self.endOfData ] }"
			.resolvesFeatureCallsTo("AbstractIterator<String>", "String")
	}
	
	@Test
	def void testClosure_03() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e|e)\n" +
		"}").resolvesFeatureCallsTo("List<? super String>", "List<Object>", "Object")
	}

	@Test
	def void testClosure_04() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e|false)\n" +
		"}").resolvesFeatureCallsTo("List<? super String>", "List<Boolean>")
	}
	
	@Test def void testClosure_05() throws Exception {
		"{ 
			var com.google.common.collect.AbstractIterator<java.util.Iterator<String>> iter = [|
				if (true) {
					val com.google.common.collect.AbstractIterator<String> result = [|
						return self.endOfData
					]
					return result
				}
				return self.endOfData
			]
		}"
			.resolvesFeatureCallsTo("AbstractIterator<String>", "String", "AbstractIterator<String>", "AbstractIterator<Iterator<String>>", "Iterator<String>")
	}

	@Test def void testClosure_07() throws Exception {
		"[String x, String y| x + y ]".resolvesFeatureCallsTo("String", "String", "String")
	}
	
	@Test def void testClosure_08() throws Exception {
		"[x| x]".resolvesFeatureCallsTo("Object")
	}
	
	@Test def void testClosure_09() throws Exception {
		"[String x, String y| x.substring(y.length)]".resolvesFeatureCallsTo("String", "String", "String", "int")
	}
	
	@Test def void testClosure_10() throws Exception {
		"[ x | x.toString x ]".resolvesFeatureCallsTo("Object", "String", "Object")
	}
	
	@Test def void testClosure_11() throws Exception {
		"[Object x| x]".resolvesFeatureCallsTo("Object")
	}
	
	@Test def void testClosure_12() throws Exception {
		"[Object x| x.toString x ]".resolvesFeatureCallsTo("Object", "String", "Object")
	}
	
	@Test def void testClosure_13() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper)
		}".resolvesFeatureCallsTo("Integer", "ArrayList<Integer>", "List<Integer>", "(Integer)=>Integer")
	}
	
	@Test def void testClosure_15() throws Exception {
		"{ 
			val fun = [ x | x ]
			val String s = fun.apply(null)
			fun
		}".resolvesFeatureCallsTo("String", "(String)=>String", "String", "(String)=>String")
	}
	
	@Test def void testClosure_27() throws Exception {
		"{ 
			val mapper = [ x | x ]
			$$ListExtensions::map(newArrayList(1), mapper)
		}".resolvesFeatureCallsTo("Integer", "List<Integer>", "ArrayList<Integer>", "(Integer)=>Integer")
	}
	
	@Test def void testClosure_30() throws Exception {
		"$$ListExtensions::map(null as java.util.List<? super String>) [e|e]".resolvesFeatureCallsTo("List<Object>", "Object")
	}
	
	@Test def void testClosure_31() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  $$ListExtensions::map(list) [e|e]\n" +
		"}").resolvesFeatureCallsTo("List<Object>", "List<? super String>", "Object")
	}
	
	@Test def void testClosure_59() throws Exception {
		'{ 
			val java.util.List<CharSequence> res = null
			val Iterable<? extends Object> obj = null
			res += obj.map[""]
		}'.resolvesFeatureCallsTo("List<CharSequence>", "boolean", "Iterable<?>", "Iterable<String>")
	}
	
	@Test def void testIfExpression_01() throws Exception {
		"if(true) #{'f'} else emptySet".resolvesFeatureCallsTo("Set<String>")
	}
	
	@Test def void testIfExpression_02() throws Exception {
		"if(true) emptySet else #{'f'}".resolvesFeatureCallsTo("Set<String>")
	}
	
	@Test def void testIfExpression_03() throws Exception {
		"{ 
			val Iterable<Object> branch = 
			  if (true) 
			    [|<Object>newArrayList().iterator]
			  else
			    newArrayList('a').toArray
		}"
			.resolvesFeatureCallsTo("ArrayList<Object>", "Iterator<Object>", "ArrayList<String>", "Object[]")
	}
	
	@Test def void testSwitchExpression_3() throws Exception {
		"{
			val Object c = null
			switch c {
	            CharSequence: 1
	    	}
		}".resolvesFeatureCallsTo("Object")
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
		}".resolvesFeatureCallsTo("Comparable<Object>", "Comparable<Object> & CharSequence", "Comparable<Object> & CharSequence & Appendable", "char")
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
		}".resolvesFeatureCallsTo("Comparable<Object>", "Comparable<Object> & CharSequence", "Comparable<Object> & CharSequence & Appendable", "Appendable")
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
		}".resolvesFeatureCallsTo("Comparable<Object>", "Comparable<Object> & CharSequence", "Comparable<Object> & CharSequence & Appendable", "int")
	}
	
	@Test def void testSwitchExpression_7() throws Exception {
		"switch x : 'foo' as CharSequence {
			Comparable : x.compareTo('')
		}".resolvesFeatureCallsTo("CharSequence & Comparable", "int")
	}
	
	@Test def void testTypeGuardedCase_0() throws Exception {
		"switch s: new Object() { String: s StringBuffer: s}".resolvesFeatureCallsTo("String", "StringBuffer")
	}
	
	@Test def void testTypeGuardedCase_1() throws Exception {
		"switch s: '' as CharSequence { Cloneable: s String: s }".resolvesFeatureCallsTo("CharSequence & Cloneable", "String")
	}
	
	@Test def void testBlockExpression_02() throws Exception {
		"{val s = '' s}".resolvesFeatureCallsTo("String")
	}
	
	@Test def void testBlockExpression_04() throws Exception {
		"{val Object s = '' s}".resolvesFeatureCallsTo("Object")
	}
	
	@Test def void testEMap_01() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getKey ].head
         }".resolvesFeatureCallsTo("BasicEMap<Integer, String>", "List<Integer>", "Integer", "Integer")
	}
	
	@Test def void testEMap_02() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getValue ].head
         }".resolvesFeatureCallsTo("BasicEMap<Integer, String>", "List<String>", "String", "String")
	}
	
	@Test def void testEMap_03() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ it ].head
         }".resolvesFeatureCallsTo("BasicEMap<Integer, String>", "List<Entry<Integer, String>>", "Entry<Integer, String>", "Entry<Integer, String>")
	}
	
	@Test def void testEMap_04() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map
         }".resolvesFeatureCallsTo("BasicEMap<Integer, String>", "Map<Integer, String>")
	}
	
	@Test def void testEMap_05() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ key ].head
         }".resolvesFeatureCallsTo("BasicEMap<? extends Integer, String>", "List<Integer>", "Integer", "Integer")
	}
	
	@Test def void testEMap_06() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ value ].head
         }".resolvesFeatureCallsTo("BasicEMap<? extends Integer, String>", "List<String>", "String", "String")
	}
	
	@Test def void testEMap_07() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ it ].head
         }".resolvesFeatureCallsTo("BasicEMap<? extends Integer, String>", "List<Entry<? extends Integer, String>>", "Entry<? extends Integer, String>", "Entry<? extends Integer, String>")
	}
	
	@Test def void testEMap_08() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map
         }".resolvesFeatureCallsTo("BasicEMap<? extends Integer, String>", "Map<? extends Integer, String>")
	}
	
	@Test def void testEMap_09() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map[ key ].head
         }".resolvesFeatureCallsTo("BasicEMap<? super Integer, String>", "List<Object>", "Object", "Object")
	}
	
	@Test def void testEMap_10() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map[ value ].head
         }".resolvesFeatureCallsTo("BasicEMap<? super Integer, String>", "List<String>", "String", "String")
	}
	
	@Test def void testEMap_11() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map[ it ].head
         }".resolvesFeatureCallsTo("BasicEMap<? super Integer, String>", "List<Entry<? super Integer, String>>", "Entry<? super Integer, String>", "Entry<? super Integer, String>")
	}
	
	@Test def void testEMap_12() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map
         }".resolvesFeatureCallsTo("BasicEMap<? super Integer, String>", "Map<? super Integer, String>")
	}
	
	@Test def void testConstructorTypeInference_02() throws Exception {
		"<java.util.List<String>>newArrayList().add(new java.util.ArrayList())".resolvesFeatureCallsTo("ArrayList<List<String>>", "boolean")
	}
	
	@Test def void testConstructorTypeInference_03() throws Exception {
		"<java.util.List<String>>newArrayList().add(0, new java.util.ArrayList())".resolvesFeatureCallsTo("ArrayList<List<String>>", "void")
	}
	
	@Test def void testConstructorTypeInference_04() throws Exception {
		"newArrayList.add(new java.util.ArrayList())".resolvesFeatureCallsTo("ArrayList<ArrayList<Object>>", "boolean")
	}
	
	@Test def void testConstructorTypeInference_08() throws Exception {
		"new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)".resolvesFeatureCallsTo("double")
	}
	
	@Test def void testConstructorTypeInference_09() throws Exception {
		"<Iterable<String>>newArrayList().add(new java.util.LinkedList)".resolvesFeatureCallsTo("ArrayList<Iterable<String>>", "boolean")
	}
	
	@Test def void testConstructorTypeInference_10() throws Exception {
		"<Iterable<String>>newArrayList().add(null)".resolvesFeatureCallsTo("ArrayList<Iterable<String>>", "boolean")
	}
	
	@Test def void testConstructorTypeInference_11() throws Exception {
		"<java.util.Map<Iterable<String>, Iterable<Integer>>>newArrayList().head".resolvesFeatureCallsTo(
			"ArrayList<Map<Iterable<String>, Iterable<Integer>>>", "Map<Iterable<String>, Iterable<Integer>>")
	}
	
	@Test def void testMemberFeatureCall_03() throws Exception {
		"newArrayList('').get(0)".resolvesFeatureCallsTo("ArrayList<String>", "String")
		"<String>newArrayList().get(0)".resolvesFeatureCallsTo("ArrayList<String>", "String")
	}
	
	@Test def void testFeatureCall_06() throws Exception {
		"newArrayList('').map(s|s)".resolvesFeatureCallsTo("ArrayList<String>", "List<String>", "String")
	}
	
	@Test def void testFeatureCall_06a() throws Exception {
		"newArrayList('').map [it|it]".resolvesFeatureCallsTo("ArrayList<String>", "List<String>", "String")
	}
	
	@Test def void testFeatureCall_06b() throws Exception {
		"newArrayList('').map [it]".resolvesFeatureCallsTo("ArrayList<String>", "List<String>", "String")
	}
	
	@Test def void testFeatureCall_06c() throws Exception {
		"(null as Iterable<String>).map(s|s)".resolvesFeatureCallsTo("Iterable<String>", "String")
	}
	
	@Test def void testFeatureCall_06_00() throws Exception {
		"$$ListExtensions::map(newArrayList('')) [s|s]".resolvesFeatureCallsTo("List<String>", "ArrayList<String>", "String")
	}
	
	@Test def void testFeatureCall_06_01() throws Exception {
		"newArrayList('').map(s|s).head".resolvesFeatureCallsTo("ArrayList<String>", "List<String>", "String", "String")
	}
	
	@Test def void testFeatureCall_06_03() throws Exception {
		"newArrayList('').map(s|1)".resolvesFeatureCallsTo("ArrayList<String>", "List<Integer>")
	}
	
	@Test def void testFeatureCall_06_04() throws Exception {
		"newArrayList('').map(s|1).head".resolvesFeatureCallsTo("ArrayList<String>", "List<Integer>", "Integer")
	}
	
	@Test def void testFeatureCall_07() throws Exception {
		"newArrayList('').map(s|s.length)".resolvesFeatureCallsTo("ArrayList<String>", "List<Integer>", "String", "int")
	}
	
	@Test def void testFeatureCall_07_01() throws Exception {
		"<String>newArrayList.map(s|s.length)".resolvesFeatureCallsTo("ArrayList<String>", "List<Integer>", "String", "int")
	}
	
	@Test def void testFeatureCall_08() throws Exception {
		"newArrayList('').map(s|s !== null)".resolvesFeatureCallsTo("ArrayList<String>", "List<Boolean>", "String", "boolean")
	}
	
	@Test def void testFeatureCall_11() throws Exception {
		"newArrayList('').map(s|1).toList()".resolvesFeatureCallsTo("ArrayList<String>", "List<Integer>", "List<Integer>")
	}
	
	@Test def void testFeatureCall_13_4() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it }".resolvesFeatureCallsTo("ArrayList<String>", "List<Integer>", "List<Integer>", "List<Integer>")
	}
	
	@Test def void testFeatureCall_13_5() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i|i+1) }".resolvesFeatureCallsTo("List<Integer>", "Integer", "int")
	}
	
	@Test def void testFeatureCall_13_6() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i|i) }".resolvesFeatureCallsTo("List<Integer>", "Integer")
	}
	
	@Test def void testFeatureCall_14() throws Exception {
		"newArrayList(newArrayList('').map(s|1))".resolvesFeatureCallsTo("ArrayList<List<Integer>>", "ArrayList<String>", "List<Integer>")
	}
	
	@Test def void testFeatureCall_16_a() throws Exception {
		"newArrayList('').map(s|1).map(i|1)".resolvesFeatureCallsTo("ArrayList<String>", "List<Integer>", "List<Integer>")
	}
	@Test def void testFeatureCall_16_b() throws Exception {
		"newArrayList('').map(s|1).map(i|1).head".resolvesFeatureCallsTo("ArrayList<String>", "List<Integer>", "List<Integer>", "Integer")
	}
	
	@Test def void testFeatureCall_33() throws Exception {
		"{
			val list = newArrayList
			list.findFirst[String s | true]
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "String", "ArrayList<String>")
	}
	
	@Test def void testFeatureCall_34() throws Exception {
		"newArrayList.map[String s | s.substring(1,1) ]".resolvesFeatureCallsTo("ArrayList<String>", "List<String>", "String", "String")
	}

	@Test def void testFeatureCall_35() throws Exception {
		"newArrayList.map[ s | s.toString ]".resolvesFeatureCallsTo("ArrayList<Object>", "List<String>", "Object", "String")
	}
	
	@Test def void testFeatureCall_36() throws Exception {
		"{
			val list = newArrayList
			list.forEach[ s | s.toString ]
		}".resolvesFeatureCallsTo("ArrayList<Object>", "ArrayList<Object>", "void", "Object", "String")
	}
	
	@Test def void testToList_01() throws Exception {
		"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }"
			.resolvesFeatureCallsTo("List<? extends String>", "Iterable<? extends String>")
	}
	
	@Test def void testToList_02() throws Exception {
		"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }"
			.resolvesFeatureCallsTo("List<? super String>", "Iterable<? super String>")
	}
	
	@Test def void testToList_03() throws Exception {
		"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }"
			.resolvesFeatureCallsTo("List<String>", "Iterable<String>")
	}

	@Test def void testToList_04() throws Exception {
		"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }"
			.resolvesFeatureCallsTo("List<String>", "Iterable<? extends String>")
	}
	
	@Test def void testToList_05() throws Exception {
		"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }"
			.resolvesFeatureCallsTo("List<Object>", "Iterable<? super String>")
	}
	
	@Test def void testToList_06() throws Exception {
		"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }"
			.resolvesFeatureCallsTo("List<String>", "Iterable<String>")
	}
	
	@Test def void testToList_07() throws Exception {
		"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }"
			.resolvesFeatureCallsTo("List<String>", "Iterable<? extends String>")
	}
	
	@Test def void testToList_08() throws Exception {
		"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }"
			.resolvesFeatureCallsTo("List<String>", "Iterable<? super String>")
	}
	
	@Test def void testToList_09() throws Exception {
		"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }"
			.resolvesFeatureCallsTo("List<String>", "Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_00() throws Exception {
		"(null as java.util.List<String>).map(e|newArrayList(e)).flatten"
			.resolvesFeatureCallsTo("List<ArrayList<String>>", "ArrayList<String>", "String", "Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_04() throws Exception {
		"newArrayList('').map(e|newArrayList(e))"
			.resolvesFeatureCallsTo("ArrayList<String>", "List<ArrayList<String>>", "ArrayList<String>", "String")
	}
	
	@Test def void testFeatureCall_Bug342134_09() throws Exception {
		"newArrayList(newArrayList('')).flatten".resolvesFeatureCallsTo("ArrayList<ArrayList<String>>", "ArrayList<String>", "Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_10() throws Exception {
		"<java.util.List<String>>newArrayList().flatten".resolvesFeatureCallsTo("ArrayList<List<String>>", "Iterable<String>")
	}
	
	@Test def void testBug_389512() throws Exception {
		"{
			val CharSequence s = null
			s.^class.declaredFields.toMap[name].mapValues[get(s)]
		}".resolvesFeatureCallsTo("CharSequence", "Class<? extends CharSequence>", "Field[]", "Map<String, Field>", "String", "Map<String, Object>", "Object", "CharSequence")
	}
	
	@Test def void testBug_391758() throws Exception {
		"{
			val iterable = newArrayList
			iterable.fold(newArrayList) [ list , elem | null as java.util.List<String> ]
		}".resolvesFeatureCallsTo("ArrayList<Object>", "ArrayList<Object>", "List<String>", "ArrayList<String>")
	}
	
	@Test def void testBug_406425_01() throws Exception {
		if (isJava11OrLater) {
			"(null as StringBuilder) => [
				newArrayList(it, new Long(0))
			]".resolvesFeatureCallsTo("StringBuilder", "ArrayList<Comparable<?> & Serializable>", "StringBuilder")
		} else {
			"(null as StringBuilder) => [
				newArrayList(it, new Long(0))
			]".resolvesFeatureCallsTo("StringBuilder", "ArrayList<Serializable>", "StringBuilder")
		}
	}
	
	@Test def void testBounds_01() throws Exception {
		"{ var java.util.List<Integer> list = null list.get(0) }".resolvesFeatureCallsTo("List<Integer>", "Integer")
	}
	
	@Test def void testBounds_02() throws Exception {
		"{ var java.util.List<? extends Integer> list = null list.get(0) }".resolvesFeatureCallsTo("List<? extends Integer>", "Integer")
	}
	
	@Test def void testBounds_03() throws Exception {
		"{ var java.util.List<? super Integer> list = null list.get(0) }".resolvesFeatureCallsTo("List<? super Integer>", "Object")
	}
	
	@Test def void testBounds_04() throws Exception {
		"{ var java.util.List<Integer> list = null list.subList(0, 1) }".resolvesFeatureCallsTo("List<Integer>", "List<Integer>")
	}
	
	@Test def void testBounds_05() throws Exception {
		"{ var java.util.List<? extends Integer> list = null list.subList(0, 1) }".resolvesFeatureCallsTo("List<? extends Integer>", "List<? extends Integer>")
	}
	
	@Test def void testBounds_06() throws Exception {
		"{ var java.util.List<? super Integer> list = null list.subList(0, 1) }".resolvesFeatureCallsTo("List<? super Integer>", "List<? super Integer>")
	}
	
	@Test def void testBounds_07() throws Exception {
		"{ var java.util.List<Integer> list = null list.last }".resolvesFeatureCallsTo("List<Integer>", "Integer")
	}
	
	@Test def void testBounds_08() throws Exception {
		"{ var java.util.List<? extends Integer> list = null list.last }".resolvesFeatureCallsTo("List<? extends Integer>", "Integer")
	}
	
	@Test def void testBounds_09() throws Exception {
		"{ var java.util.List<? super Integer> list = null list.last }".resolvesFeatureCallsTo("List<? super Integer>", "Object")
	}
	
	@Test def void testBounds_10() throws Exception {
		"{ var java.util.List<Iterable<Integer>> list = null list.last }".resolvesFeatureCallsTo("List<Iterable<Integer>>", "Iterable<Integer>")
	}
	
	@Test def void testBounds_11() throws Exception {
		"{ var java.util.List<Iterable<Integer>> list = null list.last.last }".resolvesFeatureCallsTo("List<Iterable<Integer>>", "Iterable<Integer>", "Integer")
	}
	
	@Test def void testBounds_12() throws Exception {
		"{ var java.util.List<? extends Iterable<Integer>> list = null list.last }".resolvesFeatureCallsTo("List<? extends Iterable<Integer>>", "Iterable<Integer>")
	}
	
	@Test def void testBounds_13() throws Exception {
		"{ var java.util.List<? extends Iterable<Integer>> list = null list.last.last }".resolvesFeatureCallsTo("List<? extends Iterable<Integer>>", "Iterable<Integer>", "Integer")
	}
	
	@Test def void testBounds_14() throws Exception {
		"{ var java.util.List<Iterable<? extends Integer>> list = null list.last }".resolvesFeatureCallsTo("List<Iterable<? extends Integer>>", "Iterable<? extends Integer>")
	}
	
	@Test def void testBounds_15() throws Exception {
		"{ var java.util.List<Iterable<? extends Integer>> list = null list.last.last }".resolvesFeatureCallsTo("List<Iterable<? extends Integer>>", "Iterable<? extends Integer>", "Integer")
	}
	
	@Test def void testBounds_16() throws Exception {
		"{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last }"
			.resolvesFeatureCallsTo("List<? extends Iterable<? extends Integer>>", "Iterable<? extends Integer>")
	}
	
	@Test def void testBounds_17() throws Exception {
		"{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last.last }"
			.resolvesFeatureCallsTo("List<? extends Iterable<? extends Integer>>", "Iterable<? extends Integer>", "Integer")
	}
	
	@Test def void testBounds_18() throws Exception {
		"{ var java.util.List<Iterable<? super Integer>> list = null list.last }"
			.resolvesFeatureCallsTo("List<Iterable<? super Integer>>", "Iterable<? super Integer>")
	}
	
	@Test def void testBounds_19() throws Exception {
		"{ var java.util.List<Iterable<? super Integer>> list = null list.last.last }"
			.resolvesFeatureCallsTo("List<Iterable<? super Integer>>", "Iterable<? super Integer>", "Object")
	}
	
	@Test def void testBounds_20() throws Exception {
		"{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last }"
			.resolvesFeatureCallsTo("List<? extends Iterable<? super Integer>>", "Iterable<? super Integer>")
	}
	
	@Test def void testBounds_21() throws Exception {
		"{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last.last }"
			.resolvesFeatureCallsTo("List<? extends Iterable<? super Integer>>", "Iterable<? super Integer>", "Object")
	}
	
	@Test def void testPropertyAccess_01() throws Exception {
		"{ var java.util.List<Integer> it = null empty }".resolvesFeatureCallsTo("boolean")
	}
	
	@Test def void testPropertyAccess_02() throws Exception {
		"{ var java.util.List<Integer> list = null list.empty }".resolvesFeatureCallsTo("List<Integer>", "boolean")
	}
	
	@Test def void testPropertyAccess_03() throws Exception {
		"{ var Iterable<Integer> iterable = null iterable.empty }".resolvesFeatureCallsTo("Iterable<Integer>", "boolean")
	}
	
	@Test def void testPropertyAccess_04() throws Exception {
		"{ var Iterable<Integer> it = null empty }".resolvesFeatureCallsTo("boolean")
	}
	
	@Test def void testPropertyAccess_05() throws Exception {
		"{ var Iterable<Integer> iterable = null iterable.class }".resolvesFeatureCallsTo("Iterable<Integer>", "Class<? extends Iterable>")
	}
	
	@Test def void testPropertyAccess_06() throws Exception {
		"{ var Iterable<Integer> it = null class }".resolvesFeatureCallsTo("Class<? extends Iterable>")
	}
	
	@Test def void testReceiverIsPartiallyResolved_01() throws Exception {
		"newArrayList.get(0)".resolvesFeatureCallsTo("ArrayList<Object>", "Object")
	}
	
	@Test def void testReceiverIsPartiallyResolved_02() throws Exception {
		"newArrayList.toString".resolvesFeatureCallsTo("ArrayList<Object>", "String")
	}
	
	@Test def void testTypeByTransitiveExpectation_02() throws Exception {
		"newArrayList.subList(1,1).subList(1,1).head".resolvesFeatureCallsTo("ArrayList<Object>", "List<Object>", "List<Object>", "Object")
	}
	
	@Test def void testDependentTypeArgumentResolution_01() throws Exception {
		"{
			var Iterable<CharSequence> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, newArrayList)
		}".resolvesFeatureCallsTo("void", "Iterable<CharSequence>", "ArrayList<CharSequence>")
	}
	
	@Test def void testDependentTypeArgumentResolution_02() throws Exception {
		"{
			var Iterable<? extends CharSequence> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, newArrayList)
		}".resolvesFeatureCallsTo("void", "Iterable<? extends CharSequence>", "ArrayList<CharSequence>")
	}
	
	@Test def void testDependentTypeArgumentResolution_03() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(null, newArrayList)
		}".resolvesFeatureCallsTo("void", "ArrayList<Object>")
	}
	
	@Test def void testDependentTypeArgumentResolution_04() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>copyIntoList(null, newArrayList)
		}".resolvesFeatureCallsTo("void", "ArrayList<String>")
	}
	
	@Test def void testDependentTypeArgumentResolution_05() throws Exception {
		"{
			var Iterable<? super CharSequence> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, newArrayList)
		}".resolvesFeatureCallsTo("void", "Iterable<? super CharSequence>", "ArrayList<Object>")
	}
	
	@Test def void testDependentTypeArgumentResolution_06() throws Exception {
		"{
			var Iterable<StringBuffer> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, newArrayList)
		}".resolvesFeatureCallsTo("void", "Iterable<StringBuffer>", "ArrayList<StringBuffer>")
	}
	
	@Test def void testDependentTypeArgumentResolution_07() throws Exception {
		"{
			var Iterable<? extends StringBuffer> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, newArrayList)
		}".resolvesFeatureCallsTo("void", "Iterable<? extends StringBuffer>", "ArrayList<StringBuffer>")
	}
	
	@Test def void testDependentTypeArgumentResolution_08() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(null, newArrayList)
		}".resolvesFeatureCallsTo("void", "ArrayList<Serializable>")
	}
	
	@Test def void testDependentTypeArgumentResolution_09() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>constrainedCopyIntoList(null, newArrayList)
		}".resolvesFeatureCallsTo("void", "ArrayList<String>")
	}
	
	@Test def void testDependentTypeArgumentResolution_10() throws Exception {
		"{
			var Iterable<? super StringBuffer> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, newArrayList)
		}".resolvesFeatureCallsTo("void", "Iterable<? super StringBuffer>", "ArrayList<Object>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_002() throws Exception {
		"{
			val list = newArrayList
			val String s = list.get(0)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "String", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_003() throws Exception {
		"{
			val list = newArrayList
			val String s = list.head
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "String", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_004() throws Exception {
		"{
			val list = newArrayList
			list.add('')
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_005() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_006() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(list, '', '')
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_007() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as java.util.ArrayList<String>)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_010() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as java.util.Collection<String>)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_011() throws Exception {
		"{
			val list = newArrayList
			list.addAll('', '', '')
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_014() throws Exception {
		"{
			val list = newArrayList
			val Iterable<String> sublist = list.subList(1, 1)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "List<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_015() throws Exception {
		"{
			val list = newArrayList
			val java.util.Set<String> sublist = list.subList(1, 1)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "List<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_017() throws Exception {
		"{
			val list = newArrayList
			for(String s: list.subList(1, 1)) {}
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "List<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_041() throws Exception {
		"{
			val list = newArrayList
			list.addAll('')
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_047() throws Exception {
		"println(newArrayList)".resolvesFeatureCallsTo("ArrayList<Object>", "ArrayList<Object>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_068() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = list.get(0)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "String", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_069() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = list.head
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "String", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_070() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add('')
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_071() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)
			list
		}".resolvesFeatureCallsTo("boolean", "ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_072() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(list, '', '')
			list
		}".resolvesFeatureCallsTo("boolean", "ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_073() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(null as java.util.ArrayList<String>)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_074() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(new java.util.ArrayList<String>)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_075() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(newHashSet(''))
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "HashSet<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_076() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(null as java.util.Collection<String>)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_077() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('', '', '')
			list.head
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "ArrayList<String>", "String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_080() throws Exception {
		"{
			val list = new java.util.ArrayList
			val Iterable<String> sublist = list.subList(1, 1)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "List<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_081() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Set<String> sublist = list.subList(1, 1)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "List<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_082() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Iterator<String> sublist = list.subList(1, 1).iterator
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "List<String>", "Iterator<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_083() throws Exception {
		"{
			val list = new java.util.ArrayList
			for(String s: list.subList(1, 1)) {}
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "List<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_107() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('')
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_110() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('', '', '')
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_114() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = println(list.get(0))
			list
		}".resolvesFeatureCallsTo("String", "ArrayList<String>", "String", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_116() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).add('')
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_117() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)
			list
		}".resolvesFeatureCallsTo("boolean", "ArrayList<String>", "ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_119() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).addAll(null as java.util.ArrayList<String>)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_123() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).addAll('', '', '')
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_134() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map[String s| s]
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "List<String>", "String", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_138() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::<String>addAll(list, null, null)
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "boolean", "ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_158() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as String[])
			list
		}".resolvesFeatureCallsTo("ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_05() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(list)
			list
		}".resolvesFeatureCallsTo("ArrayList<Object>", "boolean", "ArrayList<Object>", "ArrayList<Object>")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_2() throws Exception {
		"new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next".resolvesFeatureCallsTo("boolean", "byte[]", "Iterator<Byte>", "Byte")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_3() throws Exception {
		"{ 
			val java.util.List<? super CharSequence> list = null
			list += null as Iterable<CharSequence>
		}".resolvesFeatureCallsTo("List<? super CharSequence>", "boolean")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_5() throws Exception {
		"new java.util.ArrayList<Byte>() += 'x'.getBytes()".resolvesFeatureCallsTo("boolean", "byte[]")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_6() throws Exception {
		if (isJava12OrLater) {
			"newHashMap( 5 -> '', '' -> 5 )".resolvesFeatureCallsTo(
				"HashMap<Comparable<?> & Constable & ConstantDesc & Serializable, Comparable<?> & Constable & ConstantDesc & Serializable>", 
				"Pair<Integer, String>", 
				"Pair<String, Integer>")
		} else {
			"newHashMap( 5 -> '', '' -> 5 )".resolvesFeatureCallsTo(
				"HashMap<Comparable<?> & Serializable, Comparable<?> & Serializable>", 
				"Pair<Integer, String>", 
				"Pair<String, Integer>")
		}
	}
	
	@Test def void testFeatureCallOnIt() throws Exception {
		"{ val it = 'foo'; length == 3;}".resolvesFeatureCallsTo("int", "boolean")
	}
	
	@Test def void testStaticMethods_03() throws Exception {
		"newArrayList(newHashSet(''))".resolvesFeatureCallsTo("ArrayList<HashSet<String>>", "HashSet<String>")
	}
	
}
