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
class ClosureTypeTest1 extends AbstractClosureTypeTest2 {
	
	@Test def void testScenario_1_1_a_01() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1
			val Iterable<String> res = testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_a_02() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1
			val Iterable<? extends String> res = testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_a_03() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1
			val Iterable<? super String> res = testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_a_04() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1 
			testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<Object>").withEquivalents("ListFunction1<StringBuffer, Object>")
	}
	
	@Test def void testScenario_1_1_a_05() throws Exception {
		"{
			val testData = null as ClosureTypeResolutionTestData1 
			testData.<StringBuffer, String>method_1_1_a(null) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_a_06() throws Exception {
		"{
			val iter = null as Iterable<? extends StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1
			val Iterable<String> res = testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_a_07() throws Exception {
		"{
			val iter = null as Iterable<? extends StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1
			val Iterable<? extends String> res = testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_a_08() throws Exception {
		"{
			val iter = null as Iterable<? extends StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1
			val Iterable<? super String> res = testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_a_09() throws Exception {
		"{
			val iter = null as Iterable<? extends StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1 
			testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<Object>").withEquivalents("ListFunction1<StringBuffer, Object>")
	}
	
	@Test def void testScenario_1_1_a_10() throws Exception {
		"{
			val iter = null as Iterable<? super StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1
			val Iterable<String> res = testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<Object>)=>List<String>").withEquivalents("ListFunction1<Object, String>")
	}
	
	@Test def void testScenario_1_1_a_11() throws Exception {
		"{
			val iter = null as Iterable<? super StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1
			val Iterable<? extends String> res = testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<Object>)=>List<String>").withEquivalents("ListFunction1<Object, String>")
	}
	
	@Test def void testScenario_1_1_a_12() throws Exception {
		"{
			val iter = null as Iterable<? super StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1
			val Iterable<? super String> res = testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<Object>)=>List<String>").withEquivalents("ListFunction1<Object, String>")
	}
	
	@Test def void testScenario_1_1_a_13() throws Exception {
		"{
			val iter = null as Iterable<? super StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1 
			testData.method_1_1_a(iter) []
		}".resolvesClosuresTo("(List<Object>)=>List<Object>").withEquivalents("ListFunction1<Object, Object>")
	}
	
	@Test def void testScenario_1_1_b_01() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1 
			val Iterable<String> res = testData.method_1_1_b(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<? extends String>").withEquivalents("ListFunction1<StringBuffer, ? extends String>")
	}
	
	@Test def void testScenario_1_1_b_02() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1 
			val Iterable<? extends String> res = testData.method_1_1_b(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_b_03() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1 
			val Iterable<? super String> res = testData.method_1_1_b(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_b_04() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1 
			testData.method_1_1_b(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<Object>").withEquivalents("ListFunction1<StringBuffer, Object>")
	}
	
	@Test def void testScenario_1_1_b_05() throws Exception {
		"{
			val testData = null as ClosureTypeResolutionTestData1 
			testData.<StringBuffer, String>method_1_1_b(null) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_c_01() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1 
			// invalid but should infer String since Object would be invalid, too
			val Iterable<String> res = testData.method_1_1_c(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_c_02() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1 
			val Iterable<? super String> res = testData.method_1_1_c(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
	@Test def void testScenario_1_1_c_03() throws Exception {
		"{
			val iter = null as Iterable<StringBuffer>
			val testData = null as ClosureTypeResolutionTestData1 
			testData.method_1_1_c(iter) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<Object>").withEquivalents("ListFunction1<StringBuffer, Object>")
	}
	
	@Test def void testScenario_1_1_c_04() throws Exception {
		"{
			val testData = null as ClosureTypeResolutionTestData1 
			testData.<StringBuffer, String>method_1_1_c(null) []
		}".resolvesClosuresTo("(List<StringBuffer>)=>List<String>").withEquivalents("ListFunction1<StringBuffer, String>")
	}
	
}
