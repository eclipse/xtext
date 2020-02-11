/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ClosureTypeTest3 extends AbstractClosureTypeTest2 {
	
	@Test def void testScenario_1_1_a_01() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>
			val Iterable<String> res = testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_a_02() throws Exception {
		"{
			val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>
			testData.method_1_1_a(null) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_b_01() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>
			val Iterable<String> res = testData.method_1_1_b(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_b_02() throws Exception {
		"{
			val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>
			testData.method_1_1_b(null) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_c_01() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>
			val Iterable<String> res = testData.method_1_1_c(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_c_02() throws Exception {
		"{
			val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>
			testData.method_1_1_c(null) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
}
