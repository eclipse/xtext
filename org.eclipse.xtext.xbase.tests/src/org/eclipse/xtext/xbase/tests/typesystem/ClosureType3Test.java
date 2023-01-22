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
public class ClosureType3Test extends AbstractClosureTypeTest2 {
	@Test
	public void testScenario_1_1_a_01() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val iter = null as Iterable<StringBuffer>\n" +
				"	val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n" +
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
				"	val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n" +
				"	testData.method_1_1_a(null) []\n" +
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
				"	val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n" +
				"	val Iterable<String> res = testData.method_1_1_b(iter) []\n" +
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<String>"),
				"ListFunction1<StringBuffer, String>");
	}

	@Test
	public void testScenario_1_1_b_02() throws Exception {
		// @formatter:off
		String model = 
				"{\n" + 
				"	val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n" +
				"	testData.method_1_1_b(null) []\n" +
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
				"	val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n" +
				"	val Iterable<String> res = testData.method_1_1_c(iter) []" +
				"\n}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<String>"),
				"ListFunction1<StringBuffer, String>");
	}

	@Test
	public void testScenario_1_1_c_02() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n" +
				"	testData.method_1_1_c(null) []\n" + 
				"}";
		// @formatter:on
		withEquivalents(resolvesClosuresTo(model, "(List<StringBuffer>)=>List<String>"),
				"ListFunction1<StringBuffer, String>");
	}
}
