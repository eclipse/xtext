/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class StringLiteralTest extends AbstractXbaseTestCase {
	
	@Inject
	IBatchTypeResolver typeResolver
	
	def void resolvesStringLiteralsTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val featureCalls = expressionWithQualifiedNames.findLiterals
		assertFalse(featureCalls.empty)
		assertEquals(types.size, featureCalls.size)
		val resolvedTypes = typeResolver.resolveTypes(featureCalls.head)
		featureCalls.forEach [ featureCall, index |
			val type = resolvedTypes.getActualType(featureCall)
			assertEquals('''failed for literal at «index»''', types.get(index), type.simpleName); 
		]
	}
	
	def protected findLiterals(CharSequence expression) {
		val xExpression = expression(expression, false)
		val featureCalls = EcoreUtil2::eAll(xExpression).filter(typeof(XStringLiteral)).toList
		return featureCalls.sortBy [ NodeModelUtils::findActualNodeFor(it).offset ]
	}
	
	@Test def void testNoExpectation_01() throws Exception {
		"''".resolvesStringLiteralsTo("String")
	}
	@Test def void testNoExpectation_02() throws Exception {
		"'1'".resolvesStringLiteralsTo("String")
	}
	@Test def void testNoExpectation_03() throws Exception {
		"'11'".resolvesStringLiteralsTo("String")
	}
	
	@Test def void testMemberCall_01() throws Exception {
		"'1'.toString".resolvesStringLiteralsTo("String")
	}
	@Test @Ignore("Improve typing according to expectation") def void testMemberCall_02() throws Exception {
		"'1'.charValue".resolvesStringLiteralsTo("char")
	}
	@Test @Ignore("Improve typing according to expectation") def void testMemberCall_03() throws Exception {
		"'1'.compareTo(null as Character)".resolvesStringLiteralsTo("char")
	}
	
	@Test @Ignore("Improve typing according to expectation") def void testBinaryOperation_01() throws Exception {
		"{ var char c = '1' '1' == c".resolvesStringLiteralsTo("char", "char")
	}
	@Test def void testBinaryOperation_02() throws Exception {
		"{ var c = '1' '1' == c".resolvesStringLiteralsTo("String", "String")
	}
	@Test def void testBinaryOperation_03() throws Exception {
		"{ var String c = '1' '1' == c".resolvesStringLiteralsTo("String", "String")
	}
	
	@Test def void testCharExpectation_01() throws Exception {
		"{ var char c = '' }".resolvesStringLiteralsTo("String")
	}
	@Test def void testCharExpectation_02() throws Exception {
		"{ var char c = '1' }".resolvesStringLiteralsTo("char")
	}
	@Test def void testCharExpectation_03() throws Exception {
		"{ var char c = '11' }".resolvesStringLiteralsTo("String")
	}
	@Test def void testCharExpectation_04() throws Exception {
		"Character::valueOf('')".resolvesStringLiteralsTo("String")
	}
	@Test def void testCharExpectation_05() throws Exception {
		"Character::valueOf('1')".resolvesStringLiteralsTo("char")
	}
	@Test def void testCharExpectation_06() throws Exception {
		"Character::valueOf('11')".resolvesStringLiteralsTo("String")
	}
	
	@Test def void testCharacterExpectation_01() throws Exception {
		"{ var Character c = '' }".resolvesStringLiteralsTo("String")
	}
	@Test def void testCharacterExpectation_02() throws Exception {
		"{ var Character c = '1' }".resolvesStringLiteralsTo("Character")
	}
	@Test def void testCharacterExpectation_03() throws Exception {
		"{ var Character c = '11' }".resolvesStringLiteralsTo("String")
	}
	
	@Test def void testAmbiguousExpectation_01() throws Exception {
		"String::valueOf('')".resolvesStringLiteralsTo("String")
	}
	@Test def void testAmbiguousExpectation_02() throws Exception {
		"String::valueOf('1')".resolvesStringLiteralsTo("String")
	}
	@Test def void testAmbiguousExpectation_03() throws Exception {
		"String::valueOf('11')".resolvesStringLiteralsTo("String")
	}
	@Test def void testCastToChar_01() throws Exception {
		// TODO should casts impose a weaker type expectation in order
		// to influence target typing?
		"'a' as Character".resolvesStringLiteralsTo("String")
	}
}