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
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Ignore
import org.junit.Test
import org.eclipse.xtext.testing.smoketest.IgnoredBySmokeTest

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractTypeResolverTest<Reference> extends AbstractXbaseTestCase {
	
	def Reference resolvesTo(String expression, String type)
	
	def void isFunctionAndEquivalentTo(Reference reference, String type)
	
	static Set<String> seenExpressions
	
	@BeforeClass
	def static void createSeenExpressionsSet() {
		seenExpressions = newHashSet
	}
	
	@AfterClass
	def static void discardSeenExpressions() {
		seenExpressions = null
	}
	
	override protected expression(CharSequence expression, boolean resolve) throws Exception {
		val string = expression.toString.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		if (!seenExpressions.add(string)) {
			handleDuplicateExpression(expression)
			return null
		}
		super.expression(string, resolve)
	}
	
	def getLinkingAndSyntaxErrors(Resource resource) {
		resource.errors.filter[ it instanceof XtextSyntaxDiagnostic || it instanceof XtextLinkingDiagnostic]
	}
	
	def protected handleDuplicateExpression(CharSequence expression) {
		fail("Duplicate expression under test: " + expression)
	}
	
	@Test def void testRawType_01() throws Exception {
		"{ val java.util.Set set = newHashSet() set }".resolvesTo("Set")
	}
	
	@Test def void testRawType_02() throws Exception {
		"{ val java.util.Set set = newHashSet set.head }".resolvesTo("Object")
	}
	
	@Test def void testRawType_03() throws Exception {
		"(null as java.util.Set<java.util.Set>).head".resolvesTo("Set")
	}
	
	@Test def void testRawType_04() throws Exception {
		"{ val java.util.Set<java.util.Set> set = newHashSet set }".resolvesTo("Set<Set>")
	}
	
	@Test def void testAssignment_01() throws Exception {
		"new testdata.FieldAccess().stringField = null".resolvesTo("String")
	}
	
	@Test def void testAssignment_02() throws Exception {
		"new testdata.FieldAccess().stringField = new Object".resolvesTo("String")
	}
	
	@Test def void testAssignment_03() throws Exception {
		"new testdata.FieldAccess().stringField = ''".resolvesTo("String")
	}
	
	@Test def void testAssignment_04() throws Exception {
		"{
			var Comparable<Object> it = null
			switch it {
	            CharSequence: { it.length it = null }
        	}
		}".resolvesTo("Comparable<Object>")
	}
	
	@Test def void testAssignment_05() throws Exception {
		"{
			val Comparable<Object> it = null
			switch it {
	            CharSequence: it = null
        	}
		}".resolvesTo("Comparable<Object> & CharSequence")
	}
	
	@Test def void testAssignment_06() throws Exception {
		"{
			var Comparable<Object> it = null
			switch it {
	            CharSequence: { it = null it }
        	}
		}".resolvesTo("Comparable<Object>")
	}
	
	@Test def void testReassignedTypeDiscarded_01() throws Exception {
		"{
			var Comparable<Object> it = null
			switch it {
	            CharSequence: it
        	}
			it
		}".resolvesTo("Comparable<Object>")
	}

	@Test def void testNullLiteral() throws Exception {
		"null".resolvesTo("null")
	}
	
	@Test def void testTypeLiteral() throws Exception {
		"typeof(String)".resolvesTo("Class<String>")
	}
	
	@Test def void testTypeLiteral_1() throws Exception {
		"typeof(String[])".resolvesTo("Class<String[]>")
	}
	
	@Test def void testTypeLiteral_2() throws Exception {
		"typeof(void)".resolvesTo("Class<Void>")
	}
	
	@Test def void testTypeLiteral_3() throws Exception {
		"typeof(int)".resolvesTo("Class<Integer>")
	}
	
	@Test def void testTypeLiteral_4() throws Exception {
		"typeof(int[])".resolvesTo("Class<int[]>")
	}
	
	@Test def void testTypeLiteral_5() throws Exception {
		"typeof(int[]).superclass".resolvesTo("Class<? super int[]>")
	}
	
	@Test def void testTypeLiteral_6() throws Exception {
		"String".resolvesTo("Class<String>")
	}
	
	@Test def void testTypeLiteral_7() throws Exception {
		"void".resolvesTo("Class<Void>")
	}
	
	@Test def void testTypeLiteral_8() throws Exception {
		"int".resolvesTo("Class<Integer>")
	}
	
	@Test def void testTypeLiteral_9() throws Exception {
		"java.lang.String".resolvesTo("Class<String>")
	}

	@Test def void testBooleanLiteral() throws Exception {
		"true".resolvesTo("boolean")
		"false".resolvesTo("boolean")
	}
	
	@Test def void testBooleanLiteral_02() throws Exception {
		"return true".resolvesTo("void")
	}

	@Test def void testStringLiteral_01() throws Exception {
		"'foo'".resolvesTo("String")
		'"foo"'.resolvesTo("String")
	}
	
	@Test def void testStringLiteral_02() throws Exception {
		"''".resolvesTo("String")
	}
	
	@Test def void testStringLiteral_03() throws Exception {
		"'1'".resolvesTo("String")
	}
	
	@Test def void testStringLiteral_04() throws Exception {
		"newArrayList('1')".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testStringLiteral_05() throws Exception {
		"newArrayList(null as Character, '1')".resolvesTo("ArrayList<Serializable & Comparable<?>>")
	}
	
	@Test def void testStringLiteral_06() throws Exception {
		"newArrayList(null as Character, '11')".resolvesTo("ArrayList<Serializable & Comparable<?>>")
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
	
	@Test def void testNumberLiteral_25() throws Exception {
		"1bi.toString".resolvesTo("String")
	}
	
	@Test def void testNumberLiteralInClosure_01() throws Exception {
		"newArrayList().map[42]".resolvesTo("List<Integer>")
	}
	
	@Test def void testListLiteral_00() {
		"#[]".resolvesTo("List<Object>")
	}
	
	@Test def void testListLiteral_01() throws Exception {
		"#['foo']".resolvesTo("List<String>")
	}

	@Test def void testListLiteral_02() throws Exception {
		"#['foo', null, 'bar']".resolvesTo("List<String>")
	}

	@Test def void testListLiteral_03() throws Exception {
		"#[null]".resolvesTo("List<Object>")
	}

	@Test def void testListLiteral_04() throws Exception {
		"#[1, 2, 3]".resolvesTo("List<Integer>")
	}

	@Test def void testListLiteral_05() throws Exception {
		if (isJava12OrLater) {
			"#[1, 2.0, 3]".resolvesTo("List<? extends Number & Comparable<?> & Constable & ConstantDesc>")
		} else {
			"#[1, 2.0, 3]".resolvesTo("List<? extends Number & Comparable<?>>")
		}
	}

	@Test def void testListLiteral_06() throws Exception {
		"{ val java.util.List<Number> foo = #[1, 2.0, 3bi] foo }".resolvesTo("List<Number>")
	}

	@Test def void testListLiteral_07() throws Exception {
		"{ val java.util.List<CharSequence> foo = #['foo', 'bar'] foo }".resolvesTo("List<CharSequence>")
	}

	@Test def void testListLiteral_08() throws Exception {
		"{ val String[] foo = #['foo', 'bar'] foo }".resolvesTo("String[]")
	}

	@Test def void testListLiteral_09() throws Exception {
		"{ val x = #[] val String[] y = x x }".resolvesTo("List<String>")
	}

	@Test def void testListLiteral_10() throws Exception {
		"{ val x = #[null] val String[] y = x x }".resolvesTo("List<String>")
	}

	@Test def void testListLiteral_11() throws Exception {
		"{ val x = #[] val Iterable<String> y = x x }".resolvesTo("List<String>")
	}

	@Test def void testListLiteral_12() throws Exception {
		"{ val x = #[null] val java.util.Set<String> y = x x }".resolvesTo("List<String>")
	}

	@Test def void testListLiteral_13() throws Exception {
		// produces immutable list thus ? extends is ok
		"#[#['foo'], #{}]".resolvesTo("List<? extends Collection<String>>")
	}
	
	@Test def void testListLiteral_14() throws Exception {
		// produces mutable list thus ? extends would be not too helpful
		"newArrayList(#['foo'], #{})".resolvesTo("ArrayList<Collection<String>>")
	}

	@Test def void testSetLiteral_00() {
		"#{}".resolvesTo("Set<Object>")
	}
	
	@Test def void testSetLiteral_01() throws Exception {
		"#{'foo'}".resolvesTo("Set<String>")
	}

	@Test def void testSetLiteral_02() throws Exception {
		"#{'foo', null, 'bar'}".resolvesTo("Set<String>")
	}

	@Test def void testSetLiteral_03() throws Exception {
		"#{null}".resolvesTo("Set<Object>")
	}

	@Test def void testSetLiteral_04() throws Exception {
		"#{1, 2 ,3}".resolvesTo("Set<Integer>")
	}

	@Test def void testSetLiteral_05() throws Exception {
		if (isJava12OrLater) {
			"#{1, 2.0 ,3}".resolvesTo("Set<? extends Number & Comparable<?> & Constable & ConstantDesc>")
		} else {
			"#{1, 2.0 ,3}".resolvesTo("Set<? extends Number & Comparable<?>>")
		}
	}
	
	@Test def void testSetLiteral_06() throws Exception {
		"{ val java.util.Set<Number> foo = #{1, 2.0, 3bi} foo }".resolvesTo("Set<Number>")
	}
	
	@Test def void testSetLiteral_07() throws Exception {
		"{ val java.util.Set<CharSequence> foo = #{'foo', 'bar'} foo }".resolvesTo("Set<CharSequence>")
	}

	@Test def void testSetLiteral_08() throws Exception {
		"#{'foo' -> 'bar'}".resolvesTo("Map<String, String>")
	}

	@Test def void testSetLiteral_09() throws Exception {
		"#{'foo' -> true, 'bar' -> false}".resolvesTo("Map<String, Boolean>")
	}

	@Test def void testSetLiteral_10() throws Exception {
		"#{'foo'-> new Exception('ohoh'),'bar'->new Error('ohohoh')}".resolvesTo("Map<String, Throwable>")
	}

	@Test def void testSetLiteral_11() throws Exception {
		"{ val java.util.Map<String,String> x = #{} x }".resolvesTo("Map<String, String>")
	} 

	@Test def void testSetLiteral_12() throws Exception {
		"{ val java.util.Set<org.eclipse.xtext.xbase.lib.Pair<String,Object>> foo = #{'foo'->'bar'} foo }".resolvesTo("Set<Pair<String, Object>>")
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
		// TODO discuss: JDT binds to overloaded(Object, Object) though the arity indicates overloaded(String...)
		"testdata::OverloadedMethods::overloadedVarArgs(new Object, new Object, new Object)".resolvesTo("int")
	}
	
	@Test def void testOverloadedTypeParameters_01() throws Exception {
		"testdata::OverloadedMethods::<String>overloadedTypeParameters(null)".resolvesTo("int")
	}
	
	@Test def void testOverloadedTypeParameters_02() throws Exception {
		"testdata::OverloadedMethods::<String, String>overloadedTypeParameters(null)".resolvesTo("long")
	}
	
	@Test def void testOverloadedMethods_01() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)
		}".resolvesTo("int")
	}
	
	@Test def void testOverloadedMethods_02() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)
		}".resolvesTo("long")
	}
	
	@Test def void testOverloadedMethods_03() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)
		}".resolvesTo("int")
	}
	
	@Test def void testOverloadedMethods_04() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)
		}".resolvesTo("int")
	}
	
	@Test def void testOverloadedMethods_05() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, null)
		}".resolvesTo("long")
	}
	
	@Test def void testOverloadedMethods_06() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, null)
		}".resolvesTo("int")
	}
	
	@Test def void testOverloadedMethods_07() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)
		}".resolvesTo("int")
	}
	
	@Test def void testOverloadedMethods_08() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)
		}".resolvesTo("long")
	}
	
	@Test def void testOverloadedMethods_09() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)
		}".resolvesTo("int")
	}
	
	@Test def void testOverloadedMethods_10() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)
		}".resolvesTo("long")
	}
	
	@Test def void testOverloadedMethods_11() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)
		}".resolvesTo("long")
	}
	
	@Test def void testOverloadedMethods_12() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)
		}".resolvesTo("long")
	}
	
	@Test def void testBoxing_01() throws Exception {
		"1.toString".resolvesTo("String")
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
	
	@Test def void testOverloadedOperators_06() throws Exception {
		"1 + ''".resolvesTo("String")
	}
	
	@Test def void testOverloadedOperators_07() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].isEmpty".resolvesTo("boolean")
	}
	
	@Test def void testOverloadedOperators_08() throws Exception {
		"(1..2).map[ toString ].reduce[ i1, i2| i1 + i2 ]".resolvesTo("String")
	}
	
	@Test def void testOverloadedOperators_09() throws Exception {
		"(1..2).map[ toString.length ].reduce[ i1, i2| i1 + i2 ]".resolvesTo("Integer")
	}
	
	@Test def void testOverloadedOperators_10() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]".resolvesTo("BigInteger")
	}
	
	@Ignore("i1 and i2 should become T -> Object thus + maps to String + Object")
	@Test def void testOverloadedOperators_11() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2 | i1.toString + i2 ]".resolvesTo("String")
	}
	
	@Test def void testOverloadedOperators_12() throws Exception {
		"{
			val i = 1bi
			val s = ''
			s + i
		}".resolvesTo("String")
	}
	
	@Ignore("i1 and i2 should become T -> Object thus + maps to Object + String")
	@Test def void testOverloadedOperators_13() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + String::valueOf(i2) ]".resolvesTo("String")
	}
	
	@Test def void testOverloadedOperators_14() throws Exception {
		"{
			val i = 1bi
			val s = ''
			i + s
		}".resolvesTo("String")
	}
	
	@Test def void testOverloadedOperators_15() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]".resolvesTo("Iterable<String>")
	}
	
	@Test def void testOverloadedOperators_16() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i + String::valueOf(i) ]".resolvesTo("Iterable<String>")
	}
	
	@Test def void testOverloadedOperators_17() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].empty".resolvesTo("boolean")
	}
	
	@Test def void testOverloadedOperators_18() throws Exception {
		"'a' + 1".resolvesTo("String")
	}
	
	@Test def void testOverloadedOperators_19() throws Exception {
		"'aa' + 1".resolvesTo("String")
	}
	
	@Test def void testOverloadedOperators_20() throws Exception {
		if (isJava11OrLater) {
			"(null as Iterable<StringBuilder>) + (null as Iterable<StringBuffer>) + (null as Iterable<String>)".resolvesTo("Iterable<Serializable & Comparable<?> & CharSequence>")
		} else {
			"(null as Iterable<StringBuilder>) + (null as Iterable<StringBuffer>) + (null as Iterable<String>)".resolvesTo("Iterable<Serializable & CharSequence>")
		}
	}

	@Test def void testCastExpression() throws Exception {
		"null as String".resolvesTo("String")
		"null as Boolean".resolvesTo("Boolean")
	}
	
	@Test def void testCastExpression_02() throws Exception {
		"(null as Iterable<String[]>)".resolvesTo("Iterable<String[]>")
	}
	
	@Test def void testThrowExpression() throws Exception {
		"throw new Exception()".resolvesTo("void")
	}

	@Test def void testTryCatchFinallyExpression_00() throws Exception {
		"try 'foo' catch (Exception e) 'bar'".resolvesTo("String") 
	}
	
	@Test def void testTryCatchFinallyExpression_01() throws Exception {
		"try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz'".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_02() throws Exception {
		"try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz' finally true".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_03() throws Exception {
		"try { 'literal' as Object as Boolean } catch(ClassCastException e) 'caught'".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test def void testTryCatchFinallyExpression_04() throws Exception {
		"try { 'literal' as Object as Boolean } catch(ClassCastException e) {'caught'}".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test def void testTryCatchFinallyExpression_05() throws Exception {
		"try 'literal' as Object as Boolean
		  catch(NullPointerException e) 'second thing is thrown'		  
		  catch(ClassCastException e) throw new NullPointerException()
		".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test def void testTryCatchFinallyExpression_06() throws Exception {
		"try 'literal' as Object as Boolean
		  catch(ClassCastException e) throw new NullPointerException()
		  catch(NullPointerException e) 'dont catch subsequent exceptions'".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test def void testTryCatchFinallyExpression_07() throws Exception {
		"try 'literal' as Object as Boolean
		  catch(ClassCastException e) null as Number
		  catch(NullPointerException e) 'dont catch subsequent exceptions'".resolvesTo("Serializable")	
	}
	
	@Test def void testTryCatchFinallyExpression_08() throws Exception {
		"try return 'foo' catch (Exception e) return 'bar'".resolvesTo("void") 
	}
	
	@Test def void testTryCatchFinallyExpression_09() throws Exception {
		"try return 'foo' catch (Exception e) return 'bar' catch(RuntimeException e) return 'baz'".resolvesTo("void")	
	}
	
	@Test def void testTryCatchFinallyExpression_10() throws Exception {
		"try return 'foo' catch (Exception e) return 'bar' catch(RuntimeException e) return 'baz' finally true".resolvesTo("void")	
	}
	
	@Test def void testTryCatchFinallyExpression_11() throws Exception {
		"try { return 'literal' as Object as Boolean } catch(ClassCastException e) return 'caught'".resolvesTo("void")	
	}
	
	@Test def void testTryCatchFinallyExpression_12() throws Exception {
		"try { return 'literal' as Object as Boolean } catch(ClassCastException e) {return 'caught'}".resolvesTo("void")	
	}
	
	@Test def void testTryCatchFinallyExpression_13() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(NullPointerException e) return 'second thing is thrown'		  
		  catch(ClassCastException e) throw new NullPointerException()
		".resolvesTo("void")	
	}
	
	@Test def void testTryCatchFinallyExpression_14() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(ClassCastException e) throw new NullPointerException()
		  catch(NullPointerException e) return 'dont catch subsequent exceptions'".resolvesTo("void")	
	}
	
	@Test def void testTryCatchFinallyExpression_15() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(ClassCastException e) return null as Number
		  catch(NullPointerException e) return 'dont catch subsequent exceptions'".resolvesTo("void")	
	}
	
	@Test def void testTryCatchFinallyExpression_16() throws Exception {
		"try return 'foo' catch (Exception e) 'bar'".resolvesTo("String") 
	}
	
	@Test def void testTryCatchFinallyExpression_17() throws Exception {
		"try return 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz'".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_18() throws Exception {
		"try return 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz' finally true".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_19() throws Exception {
		"try { return 'literal' as Object as Boolean } catch(ClassCastException e) 'caught'".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_20() throws Exception {
		"try { return 'literal' as Object as Boolean } catch(ClassCastException e) {'caught'}".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_21() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(NullPointerException e) 'second thing is thrown'		  
		  catch(ClassCastException e) throw new NullPointerException()
		".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_22() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(ClassCastException e) throw new NullPointerException()
		  catch(NullPointerException e) 'dont catch subsequent exceptions'".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_23() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(ClassCastException e) null as Number
		  catch(NullPointerException e) 'dont catch subsequent exceptions'".resolvesTo("Serializable")	
	}
	
	@Test def void testTryCatchFinallyExpression_24() throws Exception {
		"try 'foo' catch (Exception e) return 'bar'".resolvesTo("String") 
	}
	
	@Test def void testTryCatchFinallyExpression_25() throws Exception {
		"try 1 catch (Exception e) return 'bar' catch(RuntimeException e) return 'baz'".resolvesTo("int")	
	}
	
	@Test def void testTryCatchFinallyExpression_26() throws Exception {
		"try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) return 1 finally true".resolvesTo("String")	
	}
	
	@Test def void testTryCatchFinallyExpression_27() throws Exception {
		"try { 'literal' as Object as Boolean } catch(ClassCastException e) return 'caught'".resolvesTo("Boolean")	
	}
	
	@Test def void testTryCatchFinallyExpression_28() throws Exception {
		"try { 'literal' as Object as Boolean } catch(ClassCastException e) {return 'caught'}".resolvesTo("Boolean")	
	}
	
	@Test def void testTryCatchFinallyExpression_29() throws Exception {
		"try 'literal' as Object as Boolean
		  catch(NullPointerException e) return 'second thing is thrown'		  
		  catch(ClassCastException e) throw new NullPointerException()
		".resolvesTo("Boolean")	
	}
	
	@Test def void testTryCatchFinallyExpression_30() throws Exception {
		"try 'literal' as Object as Boolean
		  catch(ClassCastException e) throw new NullPointerException()
		  catch(NullPointerException e) return 'dont catch subsequent exceptions'".resolvesTo("Boolean")	
	}
	
	@Test def void testTryCatchFinallyExpression_31() throws Exception {
		"try 'literal' as Object as Boolean
		  catch(ClassCastException e) return null as Number
		  catch(NullPointerException e) return 'dont catch subsequent exceptions'".resolvesTo("Boolean")	
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
	
	@Test def void testForExpression_05() throws Exception {
		"for(String x : new java.util.ArrayList<String>()) return x.length".resolvesTo("void")
		"for(String x : newArrayList('foo')) return x.length".resolvesTo("void")
		"for(String x : <String>newArrayList()) return x.length".resolvesTo("void")
	}
	
	@Test def void testForExpression_06() throws Exception {
		"for(x : new java.util.ArrayList<String>()) return x.length".resolvesTo("void")
		"for(x : <String>newArrayList()) return x.length".resolvesTo("void")
		"for(x : newArrayList('foo')) return x.length".resolvesTo("void")
	}
	
	@Test def void testForExpression_07() throws Exception {
		"for(String x : null as String[]) return x.length".resolvesTo("void")
	}
	
	@Test def void testForExpression_08() throws Exception {
		"for(x : null as String[]) return x.length".resolvesTo("void")
	}
	
	@Test def void testForExpression_09() throws Exception {
		"for(x : null as String[]) return".resolvesTo("void")
	}
	
	@Test def void testWhileExpression_01() throws Exception {
		"while(true) ''.length".resolvesTo("void")
	}
	
	@Test def void testWhileExpression_02() throws Exception {
		"while(true) return ''.length".resolvesTo("void")
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
	
	@Test def void testElvisWithEmptyListInLamdba() throws Exception {
		"[ String s |
			val result = <Integer>newArrayList
			val (String)=>Iterable<Integer> fun = []
			result += fun.apply(s) ?: emptyList
			result
		]".resolvesTo("(String)=>ArrayList<Integer>")
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
	
	@Test def void testTypeForVoidClosure_01() throws Exception {
		"newArrayList('foo','bar').forEach []".resolvesTo("void")
	}
	
	@Test def void testTypeForVoidClosure_02() throws Exception {
		"[ return ]".resolvesTo("(Object)=>void").isFunctionAndEquivalentTo("Procedure1<Object>")
	}
	
	@Test def void testTypeForVoidClosure_03() throws Exception {
		"[| return ]".resolvesTo("()=>void").isFunctionAndEquivalentTo("Procedure0")
	}
	
	@Test def void testTypeForVoidClosure_04() throws Exception {
		"[a, b| return ]".resolvesTo("(Object, Object)=>void").isFunctionAndEquivalentTo("Procedure2<Object, Object>")
	}
	
	@Test def void testTypeForVoidClosure_05() throws Exception {
		"[ System::out.println ]".resolvesTo("(Object)=>void").isFunctionAndEquivalentTo("Procedure1<Object>")
	}
	
	@Test def void testTypeForVoidClosure_06() throws Exception {
		"[| System::out.println ]".resolvesTo("()=>void").isFunctionAndEquivalentTo("Procedure0")
	}
	
	@Test def void testTypeForVoidClosure_07() throws Exception {
		"[a, b| System::out.println ]".resolvesTo("(Object, Object)=>void").isFunctionAndEquivalentTo("Procedure2<Object, Object>")
	}
	
	@Test def void testTypeForEmptyClosure_01() throws Exception {
		"[]".resolvesTo("(Object)=>Object").isFunctionAndEquivalentTo("Function1<Object, Object>")
	}
	
	@Test def void testTypeForEmptyClosure_02() throws Exception {
		"[|]".resolvesTo("()=>Object").isFunctionAndEquivalentTo("Function0<Object>")
	}
	
	@Test def void testTypeForEmptyClosure_03() throws Exception {
		"[a, b|]".resolvesTo("(Object, Object)=>Object").isFunctionAndEquivalentTo("Function2<Object, Object, Object>")
	}

	@Test def void testFeatureCallWithArrayToIterableConversion_01() throws Exception {
		"'foo'.toCharArray.iterator".resolvesTo("Iterator<Character>")
	}
	
	@Test def void testFeatureCallWithArrayToIterableConversion_02() throws Exception {
		"(null as String[]).head".resolvesTo("String")
	}
	
	@Test def void testFeatureCallWithArrayToIterableConversion_03() throws Exception {
		"(null as String[]).map[ it ]".resolvesTo("List<String>")
	}
	
	@Test def void testFeatureCallWithArrayToIterableConversion_04() throws Exception {
        "(null as String[][]).head".resolvesTo("String[]")
    }
	
	@Test def void testFeatureCallWithArrayToIterableConversion_05() throws Exception {
        "{ var x = <String[]>newArrayList('a,b'.split(',')) x }".resolvesTo("ArrayList<String[]>")
    }
	
	@Test def void testFeatureCallWithArrayToIterableConversion_06() throws Exception {
        "{ var x = <String[]>newArrayList('a,b'.split(',')) x.head }".resolvesTo("String[]")
    }
	
	@Test def void testFeatureCallWithArrayToIterableConversion_07() throws Exception {
        "{ var x = <String[]>newArrayList('a,b'.split(',')) x.head.head }".resolvesTo("String")
    }
	
	@Test def void testFeatureCallWithArrayToIterableConversion_08() throws Exception {
        "{ var x = <Iterable<String>>newArrayList('a,b'.split(',')) x }".resolvesTo("ArrayList<Iterable<String>>")
    }
	
	@Test def void testFeatureCallWithArrayToIterableConversion_09() throws Exception {
        "{ var x = <Iterable<String>>newArrayList('a,b'.split(',')) x.head }".resolvesTo("Iterable<String>")
    }
	
	@Test def void testFeatureCallWithArrayToIterableConversion_10() throws Exception {
        "{ var x = <Iterable<String>>newArrayList('a,b'.split(',')) x.head.head }".resolvesTo("String")
    }
    
    @Test def void testReturnExpression_00() throws Exception {
		"return".resolvesTo("void")
	}
	
	@Test def void testReturnExpression_01() throws Exception {
		"return 'foo'".resolvesTo("void")
	}
	
	@Test def void testReturnExpression_02() throws Exception {
		"return try { if (true) 'foo' else 'bar' } finally { String::valueOf('zonk') }".resolvesTo("void")
	}
	
	@Test def void testReturnExpression_03() throws Exception {
		"{ val c = [ int i | return i ] c.apply(1) return null }".resolvesTo("void")
	}
	
	@Test def void testReturnExpression_04() throws Exception {
		"{ val c = [ int i | i ] c.apply(1) return null }".resolvesTo("void")
	}
	
	@Test def void testReturnExpression_05() throws Exception {
		"{ var closure = [| return 'literal'] closure.apply }".resolvesTo("String")
	}
	
	@Test def void testReturnExpression_06() throws Exception {
		"{ var closure = [| return 'literal'] return closure.apply }".resolvesTo("void")
	}
	
	@Test def void testReturnExpression_07() throws Exception {
		"[| return 'literal'].apply".resolvesTo("String")
	}
	
	@Test def void testReturnExpression_08() throws Exception {
		"return [| return 'literal'].apply".resolvesTo("void")
	}
	
	@Test def void testReturnExpression_09() throws Exception {
		"[| return 'literal']".resolvesTo("()=>String").isFunctionAndEquivalentTo("Function0<String>")
	}
	
	@Test def void testReturnExpression_10() throws Exception {
		"return if (true) while(false) ('foo'+'bar').length".resolvesTo("void")
	}
	
	@Test def void testClosure_00() throws Exception {
		"[|'literal'].apply()".resolvesTo("String")
	}
	
	@Test def void testClosure_01() throws Exception {
		"{ var closure = [|'literal']
		  new testdata.ClosureClient().invoke0(closure)	}".resolvesTo("String")
	}
	
	@Test def void testClosure_02() throws Exception {
		"[String x| true]".resolvesTo("(String)=>boolean").isFunctionAndEquivalentTo("Function1<String, Boolean>")
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
		"  list.map(e|false)\n" +
		"}").resolvesTo("List<Boolean>")
	}

	@Test def void testClosure_05() throws Exception {
		"[x| true]".resolvesTo("(Object)=>boolean").isFunctionAndEquivalentTo("Function1<Object, Boolean>")
	}
	
	@Test def void testClosure_06() throws Exception {
		"[x| null]".resolvesTo("(Object)=>Object").isFunctionAndEquivalentTo("Function1<Object, Object>")
	}
	
	@Test def void testClosure_07() throws Exception {
		"[String x, String y| x + y ]".resolvesTo("(String, String)=>String").isFunctionAndEquivalentTo("Function2<String, String, String>")
	}
	
	@Test def void testClosure_08() throws Exception {
		"[x| x]".resolvesTo("(Object)=>Object").isFunctionAndEquivalentTo("Function1<Object, Object>")
	}
	
	@Test def void testClosure_09() throws Exception {
		"[String x, String y| x.substring(y.length)]".resolvesTo("(String, String)=>String").isFunctionAndEquivalentTo("Function2<String, String, String>")
	}
	
	@Test def void testClosure_10() throws Exception {
		"[ x | x.toString x ]".resolvesTo("(Object)=>Object").isFunctionAndEquivalentTo("Function1<Object, Object>")
	}
	
	@Test def void testClosure_11() throws Exception {
		"[Object x| x]".resolvesTo("(Object)=>Object").isFunctionAndEquivalentTo("Function1<Object, Object>")
	}
	
	@Test def void testClosure_12() throws Exception {
		"[Object x| x.toString x ]".resolvesTo("(Object)=>Object").isFunctionAndEquivalentTo("Function1<Object, Object>")
	}
	
	@Test def void testClosure_13() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper)
		}".resolvesTo("List<Integer>")
	}
	
	@Test def void testClosure_13a() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper).head
		}".resolvesTo("Integer")
	}
	
	@Test def void testClosure_13b() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper).findFirst [ true ]
		}".resolvesTo("Integer")
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
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_16() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList(fun.apply(null))
			fun
		}".resolvesTo("(String[])=>String[]").isFunctionAndEquivalentTo("Function1<String[], String[]>")
	}
	
	@Test def void testClosure_16_02() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList(fun.apply(null), fun.apply(null))
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_17() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList.map(fun)
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_18() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.Set<String> list = newArrayList.map(fun)
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_19() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.ArrayList<String> list = newArrayList.map(fun)
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_20() throws Exception {
		"{ 
			val fun = [ x | x ]
			val Iterable<String> list = newArrayList.map(fun)
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_21() throws Exception {
		"{ 
			val fun = [ x | x ]
			val list = newArrayList.map(fun)
			val Iterable<String> iter = list
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_22() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_23() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.Set<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_24() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.ArrayList<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_25() throws Exception {
		"{ 
			val fun = [ x | x ]
			val Iterable<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_26() throws Exception {
		"{ 
			val fun = [ x | x ]
			val list = $$ListExtensions::map(newArrayList, fun)
			val Iterable<String> iter = list
			fun
		}".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testClosure_27() throws Exception {
		"{ 
			val mapper = [ x | x ]
			$$ListExtensions::map(newArrayList(1), mapper)
		}".resolvesTo("List<Integer>")
	}
	
	@Test def void testClosure_28() throws Exception {
		"[|].apply()".resolvesTo("Object")
	}
	
	@Test def void testClosure_29() throws Exception {
		"[].apply()".resolvesTo("Object")
		"[].apply('')".resolvesTo("Object")
		"[].apply('', '')".resolvesTo("Object")
	}
	
	@Test def void testClosure_30() throws Exception {
		"$$ListExtensions::map(null as java.util.List<? super String>) [e|e]".resolvesTo("List<Object>")
	}
	
	@Test def void testClosure_31() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  $$ListExtensions::map(list) [e|e]\n" +
		"}").resolvesTo("List<Object>")
	}
	
	@Ignore("TODO deferred closure body typing")
	@Test def void testClosure_32() throws Exception {
        "[ x, i | x.charAt(i) ].apply('', 0)".resolvesTo("Character")
    }
    
	@Test def void testClosure_33() throws Exception {
        "[ String it | val bytes = new String bytes ]".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
    }
    
	@Test def void testNewTreeSet_01() throws Exception {
        "new java.util.TreeSet(newArrayList(''))".resolvesTo("TreeSet<String>")
    }
    
    @Test def void testNewTreeSet_02() throws Exception {
        "newTreeSet[a, b|0]".resolvesTo("TreeSet<Object>")
    }
    
    @Test def void testNewTreeSet_03() throws Exception {
        "newTreeSet([a, b|0], 'a', 'b')".resolvesTo("TreeSet<String>") /* character? */
    }
    
    @Test def void testNewTreeSet_04() throws Exception {
        "newTreeSet([a, b|a.length.compareTo(b.length)], 'a', 'b')".resolvesTo("TreeSet<String>")
    }
    
    @Test def void testNewTreeSet_05() throws Exception {
        "newTreeSet([a, b|a.toString.compareTo(b.toString)], 'a', 'b')".resolvesTo("TreeSet<String>")
    }
    
	@Test def void testTypeArgs_01() throws Exception {
		"new java.util.ArrayList<String>() += 'foo'".resolvesTo("boolean")
	}
	
	@Test def void testJEP101Example_01() throws Exception {
		"foo::JEP101List::cons(42, foo::JEP101List::nil())".resolvesTo("JEP101List<Integer>")
	}
	
	@Test def void testIfExpression_01() throws Exception {
		"if (true) 'foo' else null".resolvesTo("String")
		"if (true) 'foo' else 'bar'".resolvesTo("String")
		"if (true) 'foo'".resolvesTo("String")
	}
	
	@Test def void testIfExpression_02() throws Exception {
		if (isJava11OrLater) {
			"if (true) new StringBuilder() else new StringBuffer()".resolvesTo("AbstractStringBuilder & Serializable & Comparable<?>")
		} else {
			"if (true) new StringBuilder() else new StringBuffer()".resolvesTo("AbstractStringBuilder & Serializable")
		}
	}
	
	@Test def void testIfExpression_03() throws Exception {
		"if (true) return 'foo'".resolvesTo("void")
	}
	
	@Test def void testIfExpression_04() throws Exception {
		"if (true) return '' else new StringBuilder".resolvesTo("StringBuilder")
	}
	
	@Test def void testIfExpression_05() throws Exception {
		"if (true) [|''] else [|'']".resolvesTo("()=>String").isFunctionAndEquivalentTo("Function0<String>")
	}
	
	@Test def void testIfExpression_06() throws Exception {
		"if (true) [|''] else [|null as CharSequence]".resolvesTo("()=>CharSequence").isFunctionAndEquivalentTo("Function0<CharSequence>")
	}
	
	@Test def void testIfExpression_07() throws Exception {
		"if (true) [|null as Appendable] else [|null as CharSequence]".resolvesTo("()=>Object").isFunctionAndEquivalentTo("Function0<?>")
	}
	
	@Test def void testIfExpression_08() throws Exception {
		"if (true) [ CharSequence c |''] else [ String s |'']".resolvesTo("(String)=>String").isFunctionAndEquivalentTo("Function1<String, String>")
	}
	
	@Test def void testIfExpression_09() throws Exception {
		if (isJava11OrLater) {
			"if (true) [new StringBuilder()] else [new StringBuffer()]".resolvesTo("(Object)=>AbstractStringBuilder & Serializable & Comparable<?>").isFunctionAndEquivalentTo("Function1<Object, ? extends AbstractStringBuilder & Serializable & Comparable<?>>")
		} else {
			"if (true) [new StringBuilder()] else [new StringBuffer()]".resolvesTo("(Object)=>AbstractStringBuilder & Serializable").isFunctionAndEquivalentTo("Function1<Object, ? extends AbstractStringBuilder & Serializable>")
		}
	}
	
	@Test def void testIfExpression_10() throws Exception {
		"if (true) null as java.util.List<String> else null as String[]".resolvesTo("Object")
	}
	
	@Test def void testIfExpression_11() throws Exception {
		if (isJava11OrLater) {
			"(if (true) [new StringBuilder()] else [new StringBuffer()]).apply('')".resolvesTo("AbstractStringBuilder & Serializable & Comparable<?>")
		} else {
			"(if (true) [new StringBuilder()] else [new StringBuffer()]).apply('')".resolvesTo("AbstractStringBuilder & Serializable")
		}
	}

	@Test def void testIfExpression_12() throws Exception {
		"if (true) newArrayList else <String>newHashSet".resolvesTo("AbstractCollection<String> & Serializable & Cloneable")
	}
	
	@Test def void testIfExpression_13() throws Exception {
		if (isJava11OrLater) {
			"if (true) <StringBuffer>newArrayList else <String>newHashSet".resolvesTo("AbstractCollection<? extends Serializable & Comparable<?> & CharSequence> & Serializable & Cloneable")
		} else {
			"if (true) <StringBuffer>newArrayList else <String>newHashSet".resolvesTo("AbstractCollection<? extends Serializable & CharSequence> & Serializable & Cloneable")
		}
	}
	
	@Test def void testIfExpression_14() throws Exception {
		"if (true) newArrayList else newHashSet".resolvesTo("AbstractCollection<Object> & Serializable & Cloneable")
	}
	
	@Test def void testIfExpression_15() throws Exception {
        "if (true) null else null".resolvesTo("null")
    }
    
    @Test def void testIfExpression_16() throws Exception {
		"if (true) return 1 else 0".resolvesTo("int")
	}
	
	@Test def void testIfExpression_17() throws Exception {
		"if (true) return 1".resolvesTo("void")
	}
	
	@Test def void testIfExpression_18() throws Exception {
		"if (true) return".resolvesTo("void")
	}
	
	@Test def void testIfExpression_19() throws Exception {
		"if (true) return else null".resolvesTo("null")
	}
	
	@Test def void testIfExpression_20() throws Exception {
		"if (true) return else return".resolvesTo("void")
	}
	
	@Test def void testIfExpression_21() throws Exception {
        "{ val x = if (true) null else null x }".resolvesTo("null")
    }
    
    @Test def void testIfExpression_22() throws Exception {
		"{ val x = if (true) return 1 else 0 x }".resolvesTo("int")
	}
	
	@Test def void testIfExpression_23() throws Exception {
		"{ val x = if (true) return 1 x }".resolvesTo("null")
	}
	
	@Test def void testIfExpression_24() throws Exception {
		"{ val x = if (true) return; x }".resolvesTo("null")
	}
	
	@Test def void testIfExpression_25() throws Exception {
		"{ val x = if (true) return else null x }".resolvesTo("null")
	}
	
	@Test def void testIfExpression_26() throws Exception {
		"if (true) for(i: 1..2) i.toString else ''".resolvesTo("String")
	}
	
	@Test def void testIfExpression_27() throws Exception {
		"if (true) while(false) ('foo'+'bar').length".resolvesTo("void")
	}
	
	@Test def void testIfExpression_28() throws Exception {
		"if (true) return '' else 1".resolvesTo("int")
	}
	
	@Test def void testIfExpression_29() throws Exception {
		"if (true) while(true) ''.toString else while(true) ''.toString".resolvesTo("void")
	}
	
	@Test def void testIfExpression_30() throws Exception {
		"if (true) null as int[] else null as Integer[]".resolvesTo("Serializable & Cloneable")
	}
	
	@Test def void testIfExpression_31() throws Exception {
		"if (true) null as int[] else null as Iterable<Integer>".resolvesTo("Object")
	}
	
	@Test def void testIfExpression_32() throws Exception {
		"if (true) while(false) ''.toString else 'myString'".resolvesTo("String")
	}
	
	@Test def void testIfExpression_33() throws Exception {
		"if(true) #{'f'} else emptySet".resolvesTo("Set<String>")
	}
	
	@Test def void testIfExpression_34() throws Exception {
		"if(true) true else Boolean.TRUE".resolvesTo("Boolean")
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
		}".resolvesTo("void")
	}
	
	@Test def void testSwitchExpression_3() throws Exception {
		"{
			val Object c = null
			switch c {
	            CharSequence: 1
	    	}
		}".resolvesTo("int")
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
		}".resolvesTo("char")
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
		}".resolvesTo("int")
	}
	
	@Test def void testSwitchExpression_7() throws Exception {
		"{
			val Comparable<Object> it = null
			switch it {
	            CharSequence: switch(it) {
                    Appendable: {
                        charAt(1)
                    }
                }
        	}
		}".resolvesTo("char")
	}
	
	@Test def void testSwitchExpression_8() throws Exception {
		"{
			val Comparable<Object> it = null
			switch it {
	            CharSequence: switch(it) {
                    Appendable: {
                        append(null)
                    }
                }
        	}
		}".resolvesTo("Appendable")
	}
	
	@Test def void testSwitchExpression_9() throws Exception {
		"{
			val Comparable<Object> it = null
			switch it {
	            CharSequence: switch(it) {
                    Appendable: {
                        compareTo(null)
                    }
                }
        	}
		}".resolvesTo("int")
	}
	
	@Test def void testSwitchExpression_10() throws Exception {
		"switch null {
            case null : [Object it | it]
            case null : [Integer it | it]
        }".resolvesTo("(Integer)=>Object").isFunctionAndEquivalentTo("Function1<? super Integer, ?>")
	}
	
	@Test def void testSwitchExpression_11() throws Exception {
		"switch null {
		  Object : return 
		}".resolvesTo("void")
	}
	
	@Test def void testSwitchExpression_12() throws Exception {
		"switch null {
		  Object : return
		  default: return
		}".resolvesTo("void")
	}
	
	@Test def void testTypeGuardedCase_0() throws Exception {
		if (isJava11OrLater) {
			"switch s: new Object() { String: s StringBuffer: s}".resolvesTo("Serializable & Comparable<?> & CharSequence")
		} else {
			"switch s: new Object() { String: s StringBuffer: s}".resolvesTo("Serializable & CharSequence")
		}
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
	
	@Test def void testTypeGuardedCase_2() throws Exception {
		"{
			val java.util.Iterator<CharSequence> it = null
			switch next {
	            String: next
        	}
		}".resolvesTo("CharSequence")
	}
	
	@Test def void testTypeGuardedCase_3() throws Exception {
		if (isJava11OrLater) {
			"switch s: new Object() { String, StringBuffer: s}".resolvesTo("Serializable & Comparable<?> & CharSequence")
		} else {
			"switch s: new Object() { String, StringBuffer: s}".resolvesTo("Serializable & CharSequence")
		}
	}
	
	@Test def void testTypeGuardedCase_4() throws Exception {
		"switch s: '' as CharSequence { Cloneable, String: s }".resolvesTo("CharSequence")
	}
	
	@Test def void testSwitchExpression_Bug343100() throws Exception {
		"switch 'a' {
		  case null: typeof(String) 
		  case 'a': typeof(Void)
		}".resolvesTo("Class<?>")
	}

	@Test def void testBlockExpression_01() throws Exception {
		"{}".resolvesTo("null")
		"{null}".resolvesTo("null")
		"{''.toString 4}".resolvesTo("int")
		"{''.toString true}".resolvesTo("boolean")
	}
	
	@Test def void testBlockExpression_02() throws Exception {
		"{val s = '' s}".resolvesTo("String")
	}
	
	@IgnoredBySmokeTest("Do not run smoke test with 1000s of nested expressions") 
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
	
	@Test def void testBlockExpression_05() throws Exception {
		"{val Object s = ''}".resolvesTo("void")
	}
	
	@Test def void testBlockExpression_06() throws Exception {
		"{val Object s = '' s.notify}".resolvesTo("void")
	}
	
	@Test def void testBlockExpression_07() throws Exception {
		"{
            val (Integer, Double, Boolean) => void fun1 = null
            val (byte[], Object) => double[] fun2 = null
            val test = newArrayList.map[1 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]
            val test2 = newArrayList.map[2 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]
            val test3 = com::google::common::collect::Iterables::concat(test, test2).toMap[key].entrySet.map[value].toList
            test3
        }".resolvesTo("List<Pair<Integer, Pair<(Integer, Double, Boolean)=>void, (byte[], Object)=>double[]>>>")
	}
	
	@Test def void testBlockExpression_08() throws Exception {
        "{
            val (Integer, Double, Boolean) => void fun1 = null
            val (byte[], Object) => double[] fun2 = null
            val test = newArrayList.map[1 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]
            val test2 = newArrayList.map[2 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]
            val test3 = com::google::common::collect::Iterables::concat(test, test2).toMap[key].entrySet.map[value].toList
            test3.head.value.value.apply(null, null).last
        }".resolvesTo("Double")
    }
    
    @Test def void testBlockExpression_09() throws Exception {
		"{val Object x = if (false) return; x }".resolvesTo("Object")
	}
    
    @Test def void testBlockExpression_10() throws Exception {
		"{ ( if (true) {val Object x = if (false) return; x } ) }".resolvesTo("Object")
	}
    
    @Test def void testBlockExpression_11() throws Exception {
		"{ ( if (true) {val Object x = if (false) return; x } ) {val Object x = if (false) return; x } }".resolvesTo("Object")
	}
	
	@Test def void testBlockExpression_12() throws Exception {
		"{ ( if (true) if (true) return else null ) { if (true) return else null } }".resolvesTo("null")
	}
    
    @Test def void testEntrySet_01() throws Exception {
		"(null as java.util.Map<? extends String,? extends String>).entrySet".resolvesTo("Set<? extends Entry<? extends String, ? extends String>>")
	}
	
    @Test def void testEntrySet_02() throws Exception {
		"(null as java.util.Map<String, String>).entrySet".resolvesTo("Set<Entry<String, String>>")
	}
	
    @Test def void testEntrySet_03() throws Exception {
		"(null as java.util.Map<Iterable<? extends String>, Iterable<? extends String>>).entrySet"
			.resolvesTo("Set<Entry<Iterable<? extends String>, Iterable<? extends String>>>")
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
	
	@Test def void testEMap_05() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ key ].head
         }".resolvesTo("Integer")
	}
	
	@Test def void testEMap_06() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ value ].head
         }".resolvesTo("String")
	}
	
	@Test def void testEMap_07() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ it ].head
         }".resolvesTo("Entry<? extends Integer, String>")
	}
	
	@Test def void testEMap_08() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map
         }".resolvesTo("Map<? extends Integer, String>")
	}
	
	@Test def void testEMap_09() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map[ key ].head
         }".resolvesTo("Object")
	}
	
	@Test def void testEMap_10() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map[ value ].head
         }".resolvesTo("String")
	}
	
	@Test def void testEMap_11() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map[ it ].head
         }".resolvesTo("Entry<? super Integer, String>")
	}
	
	@Test def void testEMap_12() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map
         }".resolvesTo("Map<? super Integer, String>")
	}
	
	@Test def void testConstructorCall_01() throws Exception {
		"new java.util.ArrayList<String>()".resolvesTo("ArrayList<String>")
		"new java.util.HashMap<String,Boolean>".resolvesTo("HashMap<String, Boolean>");
		"new java.util.ArrayList()".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testConstructorCall_02() throws Exception {
		"new java.util.ArrayList<? extends String>()".resolvesTo("ArrayList<String>")
		"new java.util.HashMap<? extends String, ? extends Boolean>".resolvesTo("HashMap<String, Boolean>");
	}
	
	@Test def void testConstructorCall_03() throws Exception {
		"new java.util.ArrayList<? super String>()".resolvesTo("ArrayList<String>")
		"new java.util.HashMap<? super String,Boolean>".resolvesTo("HashMap<String, Boolean>");
	}
	
	@Test def void testBrokenConstructorCall_01() throws Exception {
		"new Iterable<String>()".resolvesTo("Iterable<String>")
	}
	
	@Test def void testBrokenConstructorCall_02() throws Exception {
		"new java.util.Map<String>()".resolvesTo("Map<String, Object>")
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
		if (isJava12OrLater) {
			"new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)".resolvesTo("GenericType2<Number & Comparable<?> & Constable & ConstantDesc>")
		} else {
			"new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)".resolvesTo("GenericType2<Number & Comparable<?>>")
		}
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
	
	@Test def void testClassGetSuperclass_01() throws Exception {
		"typeof(String).superclass".resolvesTo("Class<? super String>")
	}
	
	@Test def void testClassGetSuperclass_02() throws Exception {
		"typeof(String).superclass.superclass".resolvesTo("Class<? super String>")
	}
	
	@Test def void testClassGetSuperclass_03() throws Exception {
		"{ var c = Class::forName('') c.superclass }".resolvesTo("Class<?>")
	}
	
	@Test def void testClassGetSuperclass_04() throws Exception {
		"{ var c = Class::forName('') println(c.superclass) }".resolvesTo("Class<?>")
	}
	
	@Test def void testVarArgs_01() throws Exception {
		if (isJava12OrLater) {
			"newArrayList(new Double('-20'), new Integer('20'))".resolvesTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			"newArrayList(new Double('-20'), new Integer('20'))".resolvesTo("ArrayList<Number & Comparable<?>>");
		}
	}
	
	@Test def void testVarArgs_02() throws Exception {
		if (isJava12OrLater) {
			"newArrayList(if (true) new Double('-20') else new Integer('20'))".resolvesTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			"newArrayList(if (true) new Double('-20') else new Integer('20'))".resolvesTo("ArrayList<Number & Comparable<?>>");
		}
	}
	
	@Test def void testVarArgs_03() throws Exception {
		if (isJava12OrLater) {
			"newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'))".resolvesTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			"newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'))".resolvesTo("ArrayList<Number & Comparable<?>>");
		}
	}
	
	@Test def void testVarArgs_04() throws Exception {
		if (isJava12OrLater) {
			"newArrayList(if (true) new Double('-20') else new Integer('20'), new Double('29'))".resolvesTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			"newArrayList(if (true) new Double('-20') else new Integer('20'), new Double('29'))".resolvesTo("ArrayList<Number & Comparable<?>>");
		}
	}
	
	@Test def void testVarArgs_05() throws Exception {
		if (isJava12OrLater) {
			"newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'), new Double('29'))".resolvesTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			"newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'), new Double('29'))".resolvesTo("ArrayList<Number & Comparable<?>>");
		}
	}

	@Test def void testVarArgs_06() throws Exception {
		if (isJava12OrLater) {
			"java::util::Arrays::asList(1, 3d, '4')".resolvesTo("List<Comparable<?> & Constable & ConstantDesc & Serializable>");
		} else {
			"java::util::Arrays::asList(1, 3d, '4')".resolvesTo("List<Comparable<?> & Serializable>");
		}
	}
	
	@Test def void testVarArgs_07() throws Exception {
		"newArrayList(null as Integer[], null as int[], null as Iterable<Integer>)".resolvesTo("ArrayList<Object>");
	}
	
	@Test def void testVarArgs_08() throws Exception {
		"newArrayList(null as Integer[], null as int[])".resolvesTo("ArrayList<Serializable & Cloneable>");
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
	
	@Test def void testFeatureCall_03_a() throws Exception {
		"new testdata.ClassWithVarArgs().toList(null as String[])".resolvesTo("List<String>")
	}
	
	@Test def void testFeatureCall_03_b() throws Exception {
		"new testdata.ClassWithVarArgs().toList(null as int[])".resolvesTo("List<int[]>")
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
	
	@Test def void testMemberFeatureCall_04() throws Exception {
		"''.^class".resolvesTo("Class<? extends String>")
	}
	
	@Test def void testMemberFeatureCall_05() throws Exception {
		if (isJava12OrLater) {
			
		} else {
			
		}
		"''.^class.superclass".resolvesTo("Class<?>")
	}
	
	@Test def void testFeatureCall_04() throws Exception {
		if (isJava12OrLater) {
			"new testdata.ClassWithVarArgs().toList('', 1)".resolvesTo("List<Comparable<?> & Constable & ConstantDesc & Serializable>")
		} else {
			"new testdata.ClassWithVarArgs().toList('', 1)".resolvesTo("List<Comparable<?> & Serializable>")
		}
	}
	
	@Test def void testFeatureCall_05() throws Exception {
		if (isJava12OrLater) {
			"new testdata.ClassWithVarArgs().toNumberList()".resolvesTo("List<Number>")
			"new testdata.ClassWithVarArgs().toNumberList(0)".resolvesTo("List<Integer>")
			"new testdata.ClassWithVarArgs().toNumberList(0, 1)".resolvesTo("List<Integer>")
			"new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)".resolvesTo("List<Number & Comparable<?> & Constable & ConstantDesc>")
		} else {
			"new testdata.ClassWithVarArgs().toNumberList()".resolvesTo("List<Number>")
			"new testdata.ClassWithVarArgs().toNumberList(0)".resolvesTo("List<Integer>")
			"new testdata.ClassWithVarArgs().toNumberList(0, 1)".resolvesTo("List<Integer>")
			"new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)".resolvesTo("List<Number & Comparable<?>>")
		}
	}
	
	@Test def void testFeatureCall_05_b() throws Exception {
		"new testdata.ClassWithVarArgs().toNumberList(null as Float[])".resolvesTo("List<Float>")
	}
	
	@Test def void testFeatureCall_06() throws Exception {
		"newArrayList('').map(s|s)".resolvesTo("List<String>")
	}
	
	@Test def void testFeatureCall_06a() throws Exception {
		"newArrayList('').map [it|it]".resolvesTo("List<String>")
	}
	
	@Test def void testFeatureCall_06b() throws Exception {
		"newArrayList('').map [it]".resolvesTo("List<String>")
	}
	
	@Test def void testFeatureCall_06c() throws Exception {
		"(null as Iterable<String>).map(s|s)".resolvesTo("Iterable<String>")
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
	
	@Test def void testFeatureCall_06_03() throws Exception {
		"newArrayList('').map(s|1)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_06_04() throws Exception {
		"newArrayList('').map(s|1).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_07() throws Exception {
		"newArrayList('').map(s|s.length)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_07_01() throws Exception {
		"<String>newArrayList.map(s|s.length)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_07_02() throws Exception {
		"newArrayList('').map(s|s.length).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_07_03() throws Exception {
		"<String>newArrayList.map(s|s.length).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_08() throws Exception {
		"newArrayList('').map(s|s !== null)".resolvesTo("List<Boolean>")
	}
	
	@Test def void testFeatureCall_09() throws Exception {
		"newArrayList('').map(s|s.length+1)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_10() throws Exception {
		"newArrayList('').map(s|1).map(i|i+1)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_11() throws Exception {
		"newArrayList('').map(s|1).toList()".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_12() throws Exception {
		"newArrayList('').map(s|1).toList().map(i|i)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_13() throws Exception {
		"newArrayList('').map(s|1).toList().map(i|i+1)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_13_2() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it.map(i|i+1) }".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_13_3() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() map(i|i+1) }".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_13_4() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it }".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_13_5() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i|i+1) }".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_13_6() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i|i) }".resolvesTo("List<Integer>")
	}
	
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
	
	@Test def void testFeatureCall_15_d() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}
	
	@Test def void testFeatureCall_15_d_2() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_15_e() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size())".resolvesTo("List<Integer>")
	}
	@Test def void testFeatureCall_15_e_2() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_15_f() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size())".resolvesTo("List<Integer>");
	}
	@Test def void testFeatureCall_15_f_2() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).head".resolvesTo("Integer");
	}
	
	@Test def void testFeatureCall_15_g() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())".resolvesTo("List<Integer>");
	}
	@Test def void testFeatureCall_15_g_2() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).head".resolvesTo("Integer");
	}
	
	@Test def void testFeatureCall_15_h() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())".resolvesTo("List<Integer>")
	}
	@Test def void testFeatureCall_15_h_2() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_15_i() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)).map(e|e).map(iterable|iterable.size())".resolvesTo("List<Integer>")
	}
	@Test def void testFeatureCall_15_i_2() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)).map(e|e).map(iterable|iterable.size()).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_15_i_3() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e)".resolvesTo("List<Integer>")
	}
	@Test def void testFeatureCall_15_i_4() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_15_j() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}
	@Test def void testFeatureCall_15_j_2() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_15_k() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}
	@Test def void testFeatureCall_15_k_2() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_15_l() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)".resolvesTo("List<Integer>")
	}
	@Test def void testFeatureCall_15_l_2() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e).head".resolvesTo("Integer")
	}
	
	@IgnoredBySmokeTest("Pointless since the scenario is pretty much the same as above")
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
	
	@Ignore("slightly too slow")
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
	
	@Ignore("too slow")
	@Test def void testFeatureCall_15_n_1() throws Exception {
		("newArrayList(newArrayList('').map(s|1).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		).map(iterable|iterable.size()).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)
		.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).head").resolvesTo("Integer");
	}
	
	@Ignore("way too slow")
	@Test def void testFeatureCall_15_n_2() throws Exception {
		("newArrayList(newArrayList('').map(s|1).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		).map(iterable|iterable.size()).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))
		.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).head").resolvesTo("Integer");
	}
	
	@Test def void testFeatureCall_15_o() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size())".resolvesTo("List<Integer>");
	}
	@Test def void testFeatureCall_15_o_2() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).head".resolvesTo("Integer");
	}
	
	@Test def void testFeatureCall_15_p() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e)".resolvesTo("List<Integer>");
	}
	@Test def void testFeatureCall_15_p_2() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e).head".resolvesTo("Integer");
	}
	
	@Test def void testFeatureCall_16_a() throws Exception {
		"newArrayList('').map(s|1).map(i|1)".resolvesTo("List<Integer>")
	}
	@Test def void testFeatureCall_16_b() throws Exception {
		"newArrayList('').map(s|1).map(i|1).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_17_a() throws Exception {
		"newArrayList('').map(s|s.length).map(i|i)".resolvesTo("List<Integer>")
	}
	@Test def void testFeatureCall_17_b() throws Exception {
		"newArrayList('').map(s|s.length).map(i|i).head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_18_a() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b|b)".resolvesTo("List<Boolean>")
	}
	@Test def void testFeatureCall_18_b() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b|b).head".resolvesTo("Boolean")
	}
	
	@Test def void testFeatureCall_19_a() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b })".resolvesTo("List<Boolean>")
	}
	@Test def void testFeatureCall_19_b() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b }).head".resolvesTo("Boolean")
	}
	
	@Test def void testFeatureCall_20_a() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b)".resolvesTo("List<Boolean>")
	}
	@Test def void testFeatureCall_20_b() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b).head".resolvesTo("Boolean")
	}
	
	@Test def void testFeatureCall_21_a() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| ! b )".resolvesTo("List<Boolean>")
	}
	@Test def void testFeatureCall_21_b() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| ! b ).head".resolvesTo("Boolean")
	}
	
	@Test def void testFeatureCall_22_a() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } )".resolvesTo("List<Boolean>")
	}
	@Test def void testFeatureCall_22_b() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } ).head".resolvesTo("Boolean")
	}
	
	@Test def void testFeatureCall_23_a() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } )".resolvesTo("List<Boolean>")
	}
	@Test def void testFeatureCall_23_b() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } ).head".resolvesTo("Boolean")
	}

	@Test def void testFeatureCall_24_a() throws Exception {
		("newArrayList('').map(s|" +
				"$$ObjectExtensions::operator_equals(" +
				"	$$IntegerExtensions::operator_plus(s.length,1), 5)" +
				").map(b| $$BooleanExtensions::operator_not(b) )").resolvesTo("List<Boolean>")
	}
	@Test def void testFeatureCall_24_b() throws Exception {
		("newArrayList('').map(s|" +
				"$$ObjectExtensions::operator_equals(" +
				"	$$IntegerExtensions::operator_plus(s.length,1), 5)" +
				").map(b| $$BooleanExtensions::operator_not(b) ).head").resolvesTo("Boolean")
	}
	
	@Test def void testFeatureCall_25_a() throws Exception {
		"newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 )".resolvesTo("List<Integer>")
	}
	@IgnoredBySmokeTest("Same as testFeatureCall_25_a")
	@Test def void testFeatureCall_25_b() throws Exception {
		"newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 ).head".resolvesTo("Integer")
	}
	@IgnoredBySmokeTest("Same as testFeatureCall_25_a")
	@Test def void testFeatureCall_25_c() throws Exception {
		"newArrayList('').map[ length + 1 * 5 ].map [ it / 5 ].head".resolvesTo("Integer")
	}
	@IgnoredBySmokeTest("Same as testFeatureCall_25_a")
	@Test def void testFeatureCall_25_d() throws Exception {
		"newArrayList('').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ].head".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_26() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list
        }".resolvesTo("List<Integer>");
	}
	
	@Test def void testFeatureCall_26a() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list.head
        }".resolvesTo("Integer");
	}
	
	@Test def void testFeatureCall_26b() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.compareTo(null))
           val Object o = list.head 
           list.head
        }".resolvesTo("Integer");
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
	
	@Test def void testFeatureCall_31() throws Exception {
		"{ val list = newArrayList(null as Integer).map [ v|v.intValue ]
           val Object o = list.head 
           list.findFirst [ intValue == 0 ]
        }".resolvesTo("Integer");
	}
	
	@Test def void testFeatureCall_32() throws Exception {
		"{
			val list = newArrayList
			list.forEach[String s | s]
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testFeatureCall_33() throws Exception {
		"{
			val list = newArrayList
			list.findFirst[String s | true]
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testFeatureCall_34() throws Exception {
		"newArrayList.map[String s | s.substring(1,1) ]".resolvesTo("List<String>")
	}

	@Test def void testFeatureCall_35() throws Exception {
		"newArrayList.map[ s | s.toString ]".resolvesTo("List<String>")
	}
	
	@Test def void testFeatureCall_36() throws Exception {
		"{
			val list = newArrayList
			list.forEach[ s | s.toString ]
			list
		}".resolvesTo("ArrayList<Object>")
	}
	
	@Test def void testFeatureCall_37() throws Exception {
		"java::util::Arrays::asList('', '', '').map(s | s.length()).fold(0) [ l, r | if (l > r) l else r]".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_38() throws Exception {
		"(null as Iterable<Integer>).fold(0) [ l, r | if (l > r) l else r]".resolvesTo("Integer")
	}
	
	@Test def void testFeatureCall_39() throws Exception {
		"new testdata.ArrayClient().toStringArray('a', 'b').filter(e|e!=null)".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_40() throws Exception {
		"new testdata.ArrayClient().toStringArray('a', 'b').map[ it ]".resolvesTo("List<String>")
	}
	
	@Test def void testFeatureCall_41() throws Exception {
		"new testdata.ArrayClient().toStringArray('a', 'b')".resolvesTo("String[]")
	}
	
	@Test def void testFeatureCall_42() throws Exception {
		"new testdata.ArrayClient().toStringArray('a', 'b').head".resolvesTo("String")
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
		"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }".resolvesTo("List<Object>")
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
	
	@Test def void testFeatureCall_Bug342134_00() throws Exception {
		"(null as java.util.List<String>).map(e|newArrayList(e)).flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_01() throws Exception {
		"(null as java.util.List<String>).map(e|newArrayList(e)).flatten.head".resolvesTo("String")
	}
	
	@Test def void testFeatureCall_Bug342134_02() throws Exception {
		"newArrayList('').map(e|newArrayList(e)).flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_03() throws Exception {
		"newArrayList('').map(e|newArrayList(e)).flatten.head".resolvesTo("String")
	}
	
	@Test def void testFeatureCall_Bug342134_04() throws Exception {
		"newArrayList('').map(e|newArrayList(e))".resolvesTo("List<ArrayList<String>>")
	}
	
	@Test def void testFeatureCall_Bug342134_05() throws Exception {
		"newArrayList('').map(e|newArrayList(e)).head".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_06() throws Exception {
		"<String>newArrayList.map(e|newArrayList(e)).flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_07() throws Exception {
		"newArrayList('').map(e|<String>newArrayList(e)).flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_08() throws Exception {
		"newArrayList.map(String e|<String>newArrayList(e)).flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_09() throws Exception {
		"newArrayList(newArrayList('')).flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testFeatureCall_Bug342134_10() throws Exception {
		"<java.util.List<String>>newArrayList().flatten".resolvesTo("Iterable<String>")
	}
	
	@Test def void testBug_389512() throws Exception {
		"{
			val Object it = null
			^class.declaredFields.toMap[name].mapValues[get(it)]
		}".resolvesTo("Map<String, Object>")
	}

	@Test def void testBug_391758() throws Exception {
		"{
			val iterable = newArrayList
			iterable.fold(newArrayList) [ list , elem | null as java.util.List<String> ]
		}".resolvesTo("List<String>")
	}
    
    @Test def void testBug_381466_01() throws Exception {
        "{
            val map = com::google::common::collect::HashMultimap::create
            val com.google.common.collect.HashMultimap<String, Integer> stringToInts = null
            stringToInts.putAll(map)
            map
        }".resolvesTo("HashMultimap<String, Integer>")
    }
    
    @Test def void testBug_381466_02() throws Exception {
        "{
            val map = com::google::common::collect::HashMultimap::create
            val java.util.Map<String, java.util.Collection<Integer>> stringToInts = null
            stringToInts.putAll(map.asMap)
            map
        }".resolvesTo("HashMultimap<String, Integer>")
    }
    
    @Test def void testBug_381466_03() throws Exception {
        "{
            val map = com::google::common::collect::HashMultimap::create
            val java.util.Map<String, Iterable<Integer>> stringToInts = null
            stringToInts.putAll(map.asMap)
            map
        }".resolvesTo("HashMultimap<String, Integer>")
    }
    
    @Test def void testBug_381466_04() throws Exception {
        "{
            val map = com::google::common::collect::HashMultimap::create
            val stringToInts = newHashMap
            stringToInts.keySet.addAll(map.asMap.keySet)
            stringToInts.values.add(map.values.head)
            stringToInts.put('', 1)
            map
        }".resolvesTo("HashMultimap<String, Integer>")
    }
	
	@Test def void testBounds_01() throws Exception {
		"{ var java.util.List<Integer> list = null list.get(0) }".resolvesTo("Integer")
	}
	
	@Test def void testBounds_02() throws Exception {
		"{ var java.util.List<? extends Integer> list = null list.get(0) }".resolvesTo("Integer")
	}
	
	@Test def void testBounds_03() throws Exception {
		"{ var java.util.List<? super Integer> list = null list.get(0) }".resolvesTo("Object")
	}
	
	@Test def void testBounds_04() throws Exception {
		"{ var java.util.List<Integer> list = null list.subList(0, 1) }".resolvesTo("List<Integer>")
	}
	
	@Test def void testBounds_05() throws Exception {
		"{ var java.util.List<? extends Integer> list = null list.subList(0, 1) }".resolvesTo("List<? extends Integer>")
	}
	
	@Test def void testBounds_06() throws Exception {
		"{ var java.util.List<? super Integer> list = null list.subList(0, 1) }".resolvesTo("List<? super Integer>")
	}
	
	@Test def void testBounds_07() throws Exception {
		"{ var java.util.List<Integer> list = null list.last }".resolvesTo("Integer")
	}
	
	@Test def void testBounds_08() throws Exception {
		"{ var java.util.List<? extends Integer> list = null list.last }".resolvesTo("Integer")
	}
	
	@Test def void testBounds_09() throws Exception {
		"{ var java.util.List<? super Integer> list = null list.last }".resolvesTo("Object")
	}
	
	@Test def void testBounds_10() throws Exception {
		"{ var java.util.List<Iterable<Integer>> list = null list.last }".resolvesTo("Iterable<Integer>")
	}
	
	@Test def void testBounds_11() throws Exception {
		"{ var java.util.List<Iterable<Integer>> list = null list.last.last }".resolvesTo("Integer")
	}
	
	@Test def void testBounds_12() throws Exception {
		"{ var java.util.List<? extends Iterable<Integer>> list = null list.last }".resolvesTo("Iterable<Integer>")
	}
	
	@Test def void testBounds_13() throws Exception {
		"{ var java.util.List<? extends Iterable<Integer>> list = null list.last.last }".resolvesTo("Integer")
	}
	
	@Test def void testBounds_14() throws Exception {
		"{ var java.util.List<Iterable<? extends Integer>> list = null list.last }".resolvesTo("Iterable<? extends Integer>")
	}
	
	@Test def void testBounds_15() throws Exception {
		"{ var java.util.List<Iterable<? extends Integer>> list = null list.last.last }".resolvesTo("Integer")
	}
	
	@Test def void testBounds_16() throws Exception {
		"{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last }".resolvesTo("Iterable<? extends Integer>")
	}
	
	@Test def void testBounds_17() throws Exception {
		"{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last.last }".resolvesTo("Integer")
	}
	
	@Test def void testBounds_18() throws Exception {
		"{ var java.util.List<Iterable<? super Integer>> list = null list.last }".resolvesTo("Iterable<? super Integer>")
	}
	
	@Test def void testBounds_19() throws Exception {
		"{ var java.util.List<Iterable<? super Integer>> list = null list.last.last }".resolvesTo("Object")
	}
	
	@Test def void testBounds_20() throws Exception {
		"{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last }".resolvesTo("Iterable<? super Integer>")
	}
	
	@Test def void testBounds_21() throws Exception {
		"{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last.last }".resolvesTo("Object")
	}
	
	@Test def void testBounds_22() throws Exception {
		"(null as com.google.inject.Provider<? extends String>).get".resolvesTo("String")
	}
	
	@Test def void testBounds_23() throws Exception {
		"(null as com.google.inject.Provider<? extends Iterable<String>[]>).get".resolvesTo("Iterable<String>[]")
	}
	
	@Test def void testBounds_24() throws Exception {
		"new testdata.ClosureClient().useProvider(null as com.google.inject.Provider<? extends Iterable<String>[]>)".resolvesTo("Iterable<String>[]")
	}
	
	@Test def void testBounds_25() throws Exception {
		"new testdata.ClosureClient().useProvider(null as com.google.inject.Provider<? extends String>)".resolvesTo("String")
	}
	
	@Test def void testBounds_26() throws Exception {
		"new testdata.ClosureClient().useProvider(null as =>Iterable<String>[])".resolvesTo("Iterable<String>[]")
	}
	
	@Test def void testBounds_27() throws Exception {
		"new testdata.ClosureClient().useProvider(null as =>String)".resolvesTo("String")
	}
	
	@Test def void testImplicitReceiverBounds_01() throws Exception {
		"{ var java.util.List<Integer> it = null get(0) }".resolvesTo("Integer")
	}
	
	@Test def void testImplicitReceiverBounds_02() throws Exception {
		"{ var java.util.List<? extends Integer> it = null get(0) }".resolvesTo("Integer")
	}
	
	@Test def void testImplicitReceiverBounds_03() throws Exception {
		"{ var java.util.List<? super Integer> it = null get(0) }".resolvesTo("Object")
	}
	
	@Test def void testImplicitReceiverBounds_04() throws Exception {
		"{ var java.util.List<Integer> it = null subList(0, 1) }".resolvesTo("List<Integer>")
	}
	
	@Test def void testImplicitReceiverBounds_05() throws Exception {
		"{ var java.util.List<? extends Integer> it = null subList(0, 1) }".resolvesTo("List<? extends Integer>")
	}
	
	@Test def void testImplicitReceiverBounds_06() throws Exception {
		"{ var java.util.List<? super Integer> it = null subList(0, 1) }".resolvesTo("List<? super Integer>")
	}
	
	@Test def void testImplicitReceiverBounds_07() throws Exception {
		"{ var java.util.List<Integer> it = null last }".resolvesTo("Integer")
	}
	
	@Test def void testImplicitReceiverBounds_08() throws Exception {
		"{ var java.util.List<? extends Integer> it = null last }".resolvesTo("Integer")
	}
	
	@Test def void testImplicitReceiverBounds_09() throws Exception {
		"{ var java.util.List<? super Integer> it = null last }".resolvesTo("Object")
	}
	
	@Test def void testPropertyAccess_01() throws Exception {
		"{ var java.util.List<Integer> it = null empty }".resolvesTo("boolean")
	}
	
	@Test def void testPropertyAccess_02() throws Exception {
		"{ var java.util.List<Integer> list = null list.empty }".resolvesTo("boolean")
	}
	
	@Test def void testPropertyAccess_03() throws Exception {
		"{ var Iterable<Integer> iterable = null iterable.empty }".resolvesTo("boolean")
	}
	
	@Test def void testPropertyAccess_04() throws Exception {
		"{ var Iterable<Integer> it = null empty }".resolvesTo("boolean")
	}
	
	@Test def void testPropertyAccess_05() throws Exception {
		"{ var Iterable<Integer> iterable = null iterable.class }".resolvesTo("Class<? extends Iterable>")
	}
	
	@Test def void testPropertyAccess_06() throws Exception {
		"{ var Iterable<Integer> it = null class }".resolvesTo("Class<? extends Iterable>")
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
			$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)
			list.head
		}".resolvesTo("String")
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
	
	@Test def void testDeferredTypeArgumentResolution_018() throws Exception {
		if (isJava12OrLater) {
			"{
				val list = newArrayList
				list.add(new Integer(0))
				list.add(new Integer(0).doubleValue)
				list
			}".resolvesTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>")
		} else {
			"{
				val list = newArrayList
				list.add(new Integer(0))
				list.add(new Integer(0).doubleValue)
				list
			}".resolvesTo("ArrayList<Number & Comparable<?>>")
		}
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
			list.head
		}".resolvesTo("String")
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
			list.head
		}".resolvesTo("String")
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
	
	@Test def void testDeferredTypeArgumentResolution_064() throws Exception {
		if (isJava12OrLater) {
			"{
				val list = newArrayList
				list.add(println(new Integer(0)))
				list.add(println(new Integer(0).doubleValue))
				list
			}".resolvesTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>")
		} else {
			"{
				val list = newArrayList
				list.add(println(new Integer(0)))
				list.add(println(new Integer(0).doubleValue))
				list
			}".resolvesTo("ArrayList<Number & Comparable<?>>")
		}
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
			list.head
		}".resolvesTo("String")
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
	
	@Test def void testDeferredTypeArgumentResolution_084() throws Exception {
		if (isJava12OrLater) {
			"{
				val list = new java.util.ArrayList
				list.add(new Integer(0))
				list.add(new Integer(0).doubleValue)
				list
			}".resolvesTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>")
		} else {
			"{
				val list = new java.util.ArrayList
				list.add(new Integer(0))
				list.add(new Integer(0).doubleValue)
				list
			}".resolvesTo("ArrayList<Number & Comparable<?>>")
		}
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
	
	@Test def void testDeferredTypeArgumentResolution_130() throws Exception {
		if (isJava12OrLater) {
			"{
				val list = new java.util.ArrayList
				list.add(println(new Integer(0)))
				list.add(println(new Integer(0).doubleValue))
				list
			}".resolvesTo("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>")
		} else {
			"{
				val list = new java.util.ArrayList
				list.add(println(new Integer(0)))
				list.add(println(new Integer(0).doubleValue))
				list
			}".resolvesTo("ArrayList<Number & Comparable<?>>")
		}
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
			val fun = [String s| s]
			list.map(fun)
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
	
	@Test def void testDeferredTypeArgumentResolution_137() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::<String>addAll(println(list), null, null)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_138() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::<String>addAll(list, null, null)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_139() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::<String>addAll(println(list), '', '')
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_140() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(println(list), println(''), println(''))
			println(list)
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_141() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(list, println(''), println(''))
			println(list).head
		}".resolvesTo("String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_142() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(println(list), println(''), println(''))
			println(println(println(list)).head)
		}".resolvesTo("String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_143() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = $$IterableExtensions::head(list)
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_144() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = list.head.head
			list.head
		}".resolvesTo("ArrayList<Iterable<String>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_145() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = list.head.flatten.head
			list.head
		}".resolvesTo("ArrayList<Iterable<? extends Iterable<String>>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_146() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val String s = list.head.head
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_147() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val String s = list.head.flatten.head
			list.head
		}".resolvesTo("ArrayList<Iterable<? extends String>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_148() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = $$IterableExtensions::flatten(list)
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_149() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(newHashSet)
			val String s = $$IterableExtensions::flatten(list).head
			list.head
		}".resolvesTo("HashSet<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_150() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val String s = $$IterableExtensions::flatten(list).head
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_151() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add(new java.util.ArrayList)
			val String s = $$IterableExtensions::flatten(second).head
			list.add(second.head)
			list.head
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_152() throws Exception {
		"{
			val list = newArrayList
			list.map[String s| s]
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_153() throws Exception {
		"{
			val list = newArrayList
			$$IterableExtensions::map(list, [String s| s])
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_154() throws Exception {
		"{
			val list = newArrayList
			val fun = [String s| s]
			$$IterableExtensions::map(list, fun)
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_155() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map(println([String s| println(s)]))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_156() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as java.util.ArrayList<String>)
			list.head
		}".resolvesTo("String")
	}
	
	@Test def void testDeferredTypeArgumentResolution_157() throws Exception {
		"{
			val list = newArrayList
			list.addAll(newArrayList(''))
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_158() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as String[])
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_159() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(null as String[])
			list.addAll(secondList)
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_160() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(secondList)
			list.addAll(null as String[])
			secondList
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_161() throws Exception {
		"{
			val list = newArrayList
			for(s: list) {
				val String x = s
				x.toString
			}
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_162() throws Exception {
		"{
			val list = newArrayList
			for(s: newArrayList) {
				list.add(s)
				val String x = s
				x.toString
			}
			list
		}".resolvesTo("ArrayList<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_163() throws Exception {
		"{
			val list = newArrayList
			val literal = #{}
			list.addAll(literal)
			for(s: newArrayList) {
				list.add(s)
				val String x = s
				x.toString
			}
			literal
		}".resolvesTo("Set<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_164() throws Exception {
		"{
			val list = newArrayList
			val literal = #{}
			list += literal
			for(s: newArrayList) {
				list.add(s)
				val String x = s
				x.toString
			}
			literal
		}".resolvesTo("Set<String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_165() throws Exception {
		"{
			val list = newArrayList
			val literal = #{}
			list.add(literal.flatten.head)
			for(s: newArrayList) {
				list.add(s)
				val String x = s
				x.toString
			}
			literal
		}".resolvesTo("Set<Iterable<? extends String>>")
	}
	
	@Ignore("+= resolves the type parameter since Integer is a resolved type")
	@Test def void testDeferredTypeArgumentResolution_166() throws Exception {
		"{
			val list = newArrayList
			list += 1
			list += 1.0
			list
		}".resolvesTo("ArrayList<Number & Comparable<?>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_167() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val java.util.Iterator<String> s = list.head.flatten.head
			list.head
		}".resolvesTo("ArrayList<Iterable<? extends Iterator<String>>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_168() throws Exception {
		"{
			val list = newArrayList
			list.addAll(1, null as String[])
			list
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
	
	@Test def void testFeatureCallWithOperatorOverloading_2() throws Exception {
		"new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next".resolvesTo("boolean")
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_3() throws Exception {
		"new java.util.ArrayList<Byte>() += null".resolvesTo("boolean")
	}
	
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
