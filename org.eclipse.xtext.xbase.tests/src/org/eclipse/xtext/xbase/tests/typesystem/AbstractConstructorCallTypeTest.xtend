/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractConstructorCallTypeTest extends AbstractXbaseTestCase {
	
	def void resolvesConstructorCallsTo(String expression, String... types) 

	static Set<String> seenExpressions
	
	@BeforeClass
	def static void createSeenExpressionsSet() {
		seenExpressions = newHashSet
	}
	
	@AfterClass
	def static void discardSeenExpressions() {
		seenExpressions = null
	}
	
	def protected findConstructorCalls(CharSequence expression) {
		val xExpression = expression(expression, false)
		assertTrue(xExpression.eResource.errors.empty)
		val closures = EcoreUtil2::eAll(xExpression).filter(typeof(XConstructorCall)).toList
		return closures.sortBy [ NodeModelUtils::findNodesForFeature(it, XbasePackage$Literals::XCONSTRUCTOR_CALL__CONSTRUCTOR).head.offset ]
	}
	
	override protected expression(CharSequence expression, boolean resolve) throws Exception {
		val string = expression.toString
		if (!seenExpressions.add(string)) {
			fail("Duplicate expression under test: " + expression)
		}
		super.expression(expression, resolve)
	}

	@Test def void testAssignment_01() throws Exception {
		"new testdata.FieldAccess().stringField = null".resolvesConstructorCallsTo("FieldAccess")
	}
	
	@Test def void testAssignment_02() throws Exception {
		"new testdata.FieldAccess().stringField = new Object".resolvesConstructorCallsTo("FieldAccess", "Object")
	}
	
	@Test def void testAssignment_03() throws Exception {
		"new testdata.FieldAccess().stringField = ''".resolvesConstructorCallsTo("FieldAccess")
	}

	@Test def void testOverloadedOperators_10() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]".resolvesConstructorCallsTo("BigInteger")
	}
	
	@Test def void testOverloadedOperators_15() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]".resolvesConstructorCallsTo("BigInteger")
	}
	
	@Test def void testOverloadedOperators_16() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i + String::valueOf(i) ]".resolvesConstructorCallsTo("BigInteger")
	}
	
	@Test def void testThrowExpression() throws Exception {
		"throw new Exception()".resolvesConstructorCallsTo("Exception")
	}

	@Test def void testMethodTypeParamInference_00() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e | true)".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testMethodTypeParamInference_01() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e|e == 'foo')".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testMethodTypeParamInference_02() throws Exception {
		"new java.util.ArrayList<String>().<String>findFirst(e|e == 'foo')".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testMethodTypeParamInference_03() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testMethodTypeParamInference_04() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == 'foo']".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testMethodTypeParamInference_05() throws Exception {
		"$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == 'foo']".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testClosure_01() throws Exception {
		"{ var closure = [|'literal']
		  new testdata.ClosureClient().invoke0(closure)	}".resolvesConstructorCallsTo("ClosureClient")
	}
	
	@Test def void testTypeArgs() throws Exception {
		"new java.util.ArrayList<String>() += 'foo'".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testIfExpression_02() throws Exception {
		"if (true) new StringBuilder() else new StringBuffer()".resolvesConstructorCallsTo("StringBuilder", "StringBuffer")
	}
	
	@Test def void testTypeGuardedCase_0() throws Exception {
		"switch s: new Object() { String: s StringBuffer: s}".resolvesConstructorCallsTo("Object")
	}
	
	@Test def void testEMap_01() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getKey ].head
         }".resolvesConstructorCallsTo("BasicEMap<Integer, String>")
	}
	
	@Test def void testEMap_02() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getValue ].head
         }".resolvesConstructorCallsTo("BasicEMap<Integer, String>")
	}
	
	@Test def void testEMap_03() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ it ].head
         }".resolvesConstructorCallsTo("BasicEMap<Integer, String>")
	}
	
	@Test def void testEMap_04() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map
         }".resolvesConstructorCallsTo("BasicEMap<Integer, String>")
	}
	
	@Test def void testConstructorTypeParameters_01() throws Exception {
		"new java.util.ArrayList<? extends String>()".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testConstructorTypeParameters_02() throws Exception {
		"new java.util.ArrayList<? super String>()".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testConstructorTypeParameters_03() throws Exception {
		"new java.util.ArrayList<? super Iterable<? super String>>()".resolvesConstructorCallsTo("ArrayList<Iterable<? super String>>")
	}
	
	@Test def void testConstructorTypeParameters_04() throws Exception {
		"new java.util.ArrayList<? extends Iterable<? extends String>>()".resolvesConstructorCallsTo("ArrayList<Iterable<? extends String>>")
	}
	
	@Test def void testConstructorTypeParameters_05() throws Exception {
		"new constructorTypeParameters.KeyValue(null, '')".resolvesConstructorCallsTo("KeyValue")
	}
	
	@Test def void testConstructorTypeParameters_06() throws Exception {
		"new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableValue, '')".resolvesConstructorCallsTo("KeyValue", "WritableValue<String>")
	}
	
	@Test def void testConstructorTypeParameters_07() throws Exception {
		"new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableDoubleValue, 1.0)".resolvesConstructorCallsTo("KeyValue", "WritableDoubleValue")
	}
	
	@Test def void testConstructorTypeParameters_08() throws Exception {
		"new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableValue, 1.0)".resolvesConstructorCallsTo("KeyValue", "WritableValue<Double>")
	}
	
	@Test def void testConstructorTypeInference_01() throws Exception {
		"{ var Iterable<? extends String> it = new java.util.ArrayList() }".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testConstructorTypeInference_02() throws Exception {
		"<java.util.List<String>>newArrayList().add(new java.util.ArrayList())".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testConstructorTypeInference_03() throws Exception {
		"<java.util.List<String>>newArrayList().add(0, new java.util.ArrayList())".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testConstructorTypeInference_04() throws Exception {
		"newArrayList.add(new java.util.ArrayList())".resolvesConstructorCallsTo("ArrayList<Object>")
	}
	
	@Test def void testConstructorTypeInference_05() throws Exception {
		"{ var Iterable<? super String> it = new java.util.ArrayList() }".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testConstructorTypeInference_06() throws Exception {
		"{ var Iterable<? extends String> it = { var x = new java.util.ArrayList() x } }".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testConstructorTypeInference_07() throws Exception {
		"{ var Iterable<? extends String> it = { var x = new java.util.ArrayList() var y = x y } }".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testConstructorTypeInference_08() throws Exception {
		if (isJava12OrLater) {
			"new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)".resolvesConstructorCallsTo("GenericType2<Number & Comparable<?> & Constable & ConstantDesc>", "Integer", "Integer")
		} else {
			"new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)".resolvesConstructorCallsTo("GenericType2<Number & Comparable<?>>", "Integer", "Integer")
		}
	}
	
	@Test def void testConstructorTypeInference_09() throws Exception {
		"<Iterable<String>>newArrayList().add(new java.util.LinkedList)".resolvesConstructorCallsTo("LinkedList<String>")
	}
	
	@Test def void testConstructorTypeInference_10() throws Exception {
		"{ var Iterable<? extends Iterable<? super String>> it = new java.util.ArrayList() }".resolvesConstructorCallsTo("ArrayList<Iterable<? super String>>")
	}
	
	@Test def void testConstructorTypeInference_11() throws Exception {
		"{ var Iterable<? super Iterable<? super String>> it = new java.util.ArrayList() }".resolvesConstructorCallsTo("ArrayList<Iterable<? super String>>")
	}
	
	@Test def void testConstructorTypeInference_12() throws Exception {
		"{ var java.util.Map<? super String, ? super String> it = new java.util.HashMap }".resolvesConstructorCallsTo("HashMap<String, String>")
	}
	
	@Test def void testVarArgs_01() throws Exception {
		"newArrayList(new Double('-20'), new Integer('20'))".resolvesConstructorCallsTo("Double", "Integer");
	}
	
	@Test def void testVarArgs_02() throws Exception {
		"newArrayList(if (true) new Double('-20') else new Integer('20'))".resolvesConstructorCallsTo("Double", "Integer");
	}
	
	@Test def void testVarArgs_03() throws Exception {
		"newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'))".resolvesConstructorCallsTo("Double", "Integer", "Integer");
	}
	
	@Test def void testVarArgs_04() throws Exception {
		"newArrayList(if (true) new Double('-20') else new Integer('20'), new Double('29'))".resolvesConstructorCallsTo("Double", "Integer", "Double");
	}
	
	@Test def void testVarArgs_05() throws Exception {
		"newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'), new Double('29'))".resolvesConstructorCallsTo("Double", "Integer", "Integer", "Double");
	}

	@Test def void testFeatureCall_03() throws Exception {
		"new testdata.ClassWithVarArgs().toList()".resolvesConstructorCallsTo("ClassWithVarArgs")
		"new testdata.ClassWithVarArgs().toList('')".resolvesConstructorCallsTo("ClassWithVarArgs")
		"new testdata.ClassWithVarArgs().toList('', '')".resolvesConstructorCallsTo("ClassWithVarArgs")
	}
	
	@Test def void testFeatureCall_03_a() throws Exception {
		"new testdata.ClassWithVarArgs().toList(null as String[])".resolvesConstructorCallsTo("ClassWithVarArgs")
	}
	
	@Test def void testFeatureCall_03_b() throws Exception {
		"new testdata.ClassWithVarArgs().toList(null as int[])".resolvesConstructorCallsTo("ClassWithVarArgs")
	}
	
	@Test def void testFeatureCall_04() throws Exception {
		"new testdata.ClassWithVarArgs().toList('', 1)".resolvesConstructorCallsTo("ClassWithVarArgs")
	}
	
	@Test def void testFeatureCall_05() throws Exception {
		"new testdata.ClassWithVarArgs().toNumberList()".resolvesConstructorCallsTo("ClassWithVarArgs")
		"new testdata.ClassWithVarArgs().toNumberList(0)".resolvesConstructorCallsTo("ClassWithVarArgs")
		"new testdata.ClassWithVarArgs().toNumberList(0, 1)".resolvesConstructorCallsTo("ClassWithVarArgs")
		"new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)".resolvesConstructorCallsTo("ClassWithVarArgs", "Integer", "Integer")
	}
	
	@Test def void testFeatureCall_05_b() throws Exception {
		"new testdata.ClassWithVarArgs().toNumberList(null as Float[])".resolvesConstructorCallsTo("ClassWithVarArgs")
	}
	
	@Test def void testFeatureCall_26() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list
        }".resolvesConstructorCallsTo("Double", "Integer");
	}
	
	@Test def void testFeatureCall_26a() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list.head
        }".resolvesConstructorCallsTo("Double", "Integer");
	}
	
	@Test def void testFeatureCall_27() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v|v.intValue ]
           val Object o = list.head 
           list
        }".resolvesConstructorCallsTo("Double", "Integer");
	}
	
	@Test def void testDependentTypeArgumentResolution_01() throws Exception {
		"{
			var Iterable<CharSequence> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, new java.util.ArrayList)
		}".resolvesConstructorCallsTo("ArrayList<CharSequence>")
	}
	
	@Test def void testDependentTypeArgumentResolution_02() throws Exception {
		"{
			var Iterable<? extends CharSequence> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, new java.util.ArrayList)
		}".resolvesConstructorCallsTo("ArrayList<CharSequence>")
	}
	
	@Test def void testDependentTypeArgumentResolution_03() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(null, new java.util.ArrayList)
		}".resolvesConstructorCallsTo("ArrayList<Object>")
	}
	
	@Test def void testDependentTypeArgumentResolution_04() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>copyIntoList(null, new java.util.ArrayList)
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDependentTypeArgumentResolution_05() throws Exception {
		"{
			var Iterable<? super CharSequence> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, new java.util.ArrayList)
		}".resolvesConstructorCallsTo("ArrayList<Object>")
	}
	
	@Test def void testDependentTypeArgumentResolution_06() throws Exception {
		"{
			var Iterable<StringBuilder> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, new java.util.ArrayList)
		}".resolvesConstructorCallsTo("ArrayList<StringBuilder>")
	}
	
	@Test def void testDependentTypeArgumentResolution_07() throws Exception {
		"{
			var Iterable<? extends StringBuilder> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, new java.util.ArrayList)
		}".resolvesConstructorCallsTo("ArrayList<StringBuilder>")
	}
	
	@Test def void testDependentTypeArgumentResolution_08() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(null, new java.util.ArrayList)
		}".resolvesConstructorCallsTo("ArrayList<Serializable>")
	}
	
	@Test def void testDependentTypeArgumentResolution_09() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>constrainedCopyIntoList(null, new java.util.ArrayList)
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDependentTypeArgumentResolution_10() throws Exception {
		"{
			var Iterable<? super StringBuilder> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, new java.util.ArrayList)
		}".resolvesConstructorCallsTo("ArrayList<Object>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_064() throws Exception {
		"{
			val list = newArrayList
			list.add(println(new Integer(0)))
			list.add(println(new Integer(0).doubleValue))
			list
		}".resolvesConstructorCallsTo("Integer", "Integer")
	}
	
	@Test def void testDeferredTypeArgumentResolution_065() throws Exception {
		"{
			val list = newArrayList
			list.add(println(new Integer(0)))
			println(list.get(0)).toString
			list.add(println(new Integer(0).doubleValue))
			list
		}".resolvesConstructorCallsTo("Integer", "Integer")
	}
	
	@Test def void testDeferredTypeArgumentResolution_068() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = list.get(0)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_069() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = list.head
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_070() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add('')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_071() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_072() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(list, '', '')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_073() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(null as java.util.ArrayList<String>)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_074() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(new java.util.ArrayList<String>)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_075() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(newHashSet(''))
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_076() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(null as java.util.Collection<String>)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_077() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('', '', '')
			list.head
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_078() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.add('')
			list.addAll(secondList)
			secondList
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_079() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll(secondList)
			list.add('')
			secondList
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_080() throws Exception {
		"{
			val list = new java.util.ArrayList
			val Iterable<String> sublist = list.subList(1, 1)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_081() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Set<String> sublist = list.subList(1, 1)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_082() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Iterator<String> sublist = list.subList(1, 1).iterator
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_083() throws Exception {
		"{
			val list = new java.util.ArrayList
			for(String s: list.subList(1, 1)) {}
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_084() throws Exception {
		if (isJava12OrLater) {
			"{
				val list = new java.util.ArrayList
				list.add(new Integer(0))
				list.add(new Integer(0).doubleValue)
				list
			}".resolvesConstructorCallsTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>", "Integer", "Integer")
		} else {
			"{
				val list = new java.util.ArrayList
				list.add(new Integer(0))
				list.add(new Integer(0).doubleValue)
				list
			}".resolvesConstructorCallsTo("ArrayList<Number & Comparable<?>>", "Integer", "Integer")
		}
	}
	
	@Test def void testDeferredTypeArgumentResolution_085() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new Integer(0))
			list.get(0).toString
			list.add(new Integer(0).doubleValue)
			list
		}".resolvesConstructorCallsTo("ArrayList<Integer>", "Integer", "Integer")
	}
	
	@Test def void testDeferredTypeArgumentResolution_086() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			list.add('')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_087() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			list.add('')
			second
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_088() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			list.add('')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_089() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			list.add('')
			second
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_090() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.get(0))
			list
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_091() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.get(0))
			second
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_092() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.head)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_093() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.head)
			second
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_094() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			second.add('')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_095() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			second.add('')
			second
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_096() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			second.add('')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_097() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			second.add('')
			second
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_098() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.get(0))
			list
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_099() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.get(0))
			second
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}

	@Test def void testDeferredTypeArgumentResolution_100() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.head)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_101() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.head)
			second
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_102() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.HashSet)
			val Iterable<String> s = list.head
			list.head
		}".resolvesConstructorCallsTo("ArrayList<HashSet<String>>", "HashSet<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_103() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = list.flatten
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<String>>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_104() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(newHashSet)
			val String s = list.flatten.head
			list.head
		}".resolvesConstructorCallsTo("ArrayList<HashSet<String>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_105() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val String s = list.flatten.head
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<String>>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_106() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add(new java.util.ArrayList)
			val String s = second.flatten.head
			list.add(second.head)
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_107() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_108() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll('')
			list.addAll(secondList)
			secondList
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_109() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll(secondList)
			list.addAll('')
			secondList
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_110() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('', '', '')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_111() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll('', '', '')
			list.addAll(secondList)
			secondList
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_112() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll(secondList)
			list.addAll('', '', '')
			secondList
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_113() throws Exception {
		"println(new java.util.ArrayList)".resolvesConstructorCallsTo("ArrayList<Object>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_114() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = println(list.get(0))
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_115() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = println(println(list).head)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_116() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).add('')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_117() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_118() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(println(list), println(''), println(''))
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_119() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).addAll(null as java.util.ArrayList<String>)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_120() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).addAll(println(new java.util.ArrayList<String>))
			println(list)
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_121() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			println(list).addAll(println(newHashSet('')))
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_122() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			println(list).addAll(null as java.util.Collection<String>)
			println(list)
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_123() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).addAll('', '', '')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_124() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			val secondList = println(new java.util.ArrayList)
			println(list).add('')
			println(list).addAll(println(secondList))
			secondList
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_125() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			val secondList = println(new java.util.ArrayList)
			println(list).addAll(println(secondList))
			println(list).add('')
			println(secondList)
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_126() throws Exception {
		"{
			val list = new java.util.ArrayList
			val Iterable<String> sublist = println(println(list).subList(1, 1))
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_127() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Set<String> sublist = println(println(list).subList(1, 1))
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_128() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_129() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			for(String s: println(list.subList(1, 1))) {}
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_130() throws Exception {
		if (isJava12OrLater) {
			"{
				val list = new java.util.ArrayList
				list.add(println(new Integer(0)))
				list.add(println(new Integer(0).doubleValue))
				list
			}".resolvesConstructorCallsTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>", "Integer", "Integer")
		} else {
			"{
				val list = new java.util.ArrayList
				list.add(println(new Integer(0)))
				list.add(println(new Integer(0).doubleValue))
				list
			}".resolvesConstructorCallsTo("ArrayList<Number & Comparable<?>>", "Integer", "Integer")
		}
	}
	
	@Test def void testDeferredTypeArgumentResolution_131() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(println(new Integer(0)))
			println(list.get(0)).toString
			list.add(println(new Integer(0).doubleValue))
			list
		}".resolvesConstructorCallsTo("ArrayList<Integer>", "Integer", "Integer")
	}
	
	@Test def void testDeferredTypeArgumentResolution_132() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			println(list).add(println(second.get(0)))
			println(list).add('')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_134() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map[String s| s]
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_136() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = list.head
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<String>>", "ArrayList<String>")
	}
	
	
	@Test def void testDeferredTypeArgumentResolution_143() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = $$IterableExtensions::head(list)
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<String>>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_144() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = list.head.head
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<Iterable<String>>>", "ArrayList<Iterable<String>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_145() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = list.head.flatten.head
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<Iterable<? extends Iterable<String>>>>", "ArrayList<Iterable<? extends Iterable<String>>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_146() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val String s = list.head.head
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<String>>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_147() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val String s = list.head.flatten.head
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<Iterable<? extends String>>>", "ArrayList<Iterable<? extends String>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_148() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = $$IterableExtensions::flatten(list)
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<String>>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_149() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(newHashSet)
			val String s = $$IterableExtensions::flatten(list).head
			list.head
		}".resolvesConstructorCallsTo("ArrayList<HashSet<String>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_150() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val String s = $$IterableExtensions::flatten(list).head
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<String>>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_151() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add(new java.util.ArrayList)
			val String s = $$IterableExtensions::flatten(second).head
			list.add(second.head)
			list.head
		}".resolvesConstructorCallsTo("ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_155() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map(println([String s| println(s)]))
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_05() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(list)
			list
		}".resolvesConstructorCallsTo("ArrayList<Object>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_06() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(list.head)
			list
		}".resolvesConstructorCallsTo("ArrayList<Object>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_07() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(list)
			list.add('')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testRecursiveTypeArgumentResolution_08() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(list.head)
			list.add('')
			list
		}".resolvesConstructorCallsTo("ArrayList<String>")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_2() throws Exception {
		"new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next".resolvesConstructorCallsTo("ArrayList<Byte>")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_3() throws Exception {
		"new java.util.ArrayList<Byte>() += null".resolvesConstructorCallsTo("ArrayList<Byte>")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_4() throws Exception {
		"new java.util.ArrayList<Byte>() += newArrayList('x'.getBytes().iterator.next)".resolvesConstructorCallsTo("ArrayList<Byte>")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_5() throws Exception {
		"new java.util.ArrayList<Byte>() += 'x'.getBytes()".resolvesConstructorCallsTo("ArrayList<Byte>")
	}
	
}
