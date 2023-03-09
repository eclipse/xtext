/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClosureType2Test extends AbstractClosureTypeTest2 {
	@Test
	public void testScenario_1_1_a_01() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val iter = null as Iterable<StringBuffer>\n" +
				"	val testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n" +
				"	val Iterable<String> res = testData.method_1_1_a(iter) []\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<String>"),
				"ListFunction1<StringBuffer, String>");
	}

	@Test
	public void testScenario_1_1_a_02() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val iter = null as Iterable<StringBuffer>\n" +
				"	val testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n" +
				"	testData.method_1_1_a(iter) []\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<Object>"),
				"ListFunction1<StringBuffer, Object>");
	}

	@Test
	public void testScenario_1_1_a_03() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n" +
				"	testData.<String>method_1_1_a(iter) []\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<String>"),
				"ListFunction1<StringBuffer, String>");
	}

	@Test
	public void testScenario_1_1_b_01() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val iter = null as Iterable<StringBuffer>\n" +
				"	val testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n" +
				"	val Iterable<String> res = testData.method_1_1_b(iter) [] // actually invalid since List<? extends OUT> is returned\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<? extends String>"),
				"ListFunction1<StringBuffer, ? extends String>");
	}

	@Test
	public void testScenario_1_1_b_02() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val iter = null as Iterable<StringBuffer>\n" +
				"	val testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n" +
				"	testData.method_1_1_b(iter) []\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<Object>"),
				"ListFunction1<StringBuffer, Object>");
	}

	@Test
	public void testScenario_1_1_b_03() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n" +
				"	testData.<String>method_1_1_b(null) []\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<String>"),
				"ListFunction1<StringBuffer, String>");
	}

	@Test
	public void testScenario_1_1_c_01() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val iter = null as Iterable<StringBuffer>\n" +
				"	val testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n" +
				"	// invalid but should infer String since Object would be invalid, too\n" +
				"	val Iterable<String> res = testData.method_1_1_c(iter) []\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<String>"),
				"ListFunction1<StringBuffer, String>");
	}

	@Test
	public void testScenario_1_1_c_02() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val iter = null as Iterable<StringBuffer>\n" +
				"	val testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n" +
				"	val Iterable<? super String> res = testData.method_1_1_c(iter) []\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<String>"),
				"ListFunction1<StringBuffer, String>");
	}

	@Test
	public void testScenario_1_1_c_03() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val iter = null as Iterable<StringBuffer>\n" +
				"	val testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n" +
				"	testData.method_1_1_c(iter) []\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<Object>"),
				"ListFunction1<StringBuffer, Object>");
	}

	@Test
	public void testScenario_1_1_c_04() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n" +
				"	testData.<String>method_1_1_c(null) []\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<String>"),
				"ListFunction1<StringBuffer, String>");
	}
}
