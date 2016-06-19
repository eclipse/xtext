/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups;

import java.util.List;

import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParserTest extends AbstractXtextTests {
	
	@Test public void testParse_1_A_B() throws Exception {
		Model model = (Model) getModel("1 a b");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_1_B_A() throws Exception {
		Model model = (Model) getModel("1 b a");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_2_A_B_C_D() throws Exception {
		internalTest_2("a b c d");
	}
	
	@Test public void testParse_2_A_B_D_C() throws Exception {
		internalTest_2("a b d c");
	}
	
	@Test public void testParse_2_A_C_B_D() throws Exception {
		internalTest_2("a c b d");
	}
	
	@Test public void testParse_2_A_C_D_B() throws Exception {
		internalTest_2("a c d b");
	}
	
	@Test public void testParse_2_A_D_B_C() throws Exception {
		internalTest_2("a d b c");
	}
	
	@Test public void testParse_2_A_D_C_B() throws Exception {
		internalTest_2("a d c b");
	}
	
	@Test public void testParse_2_A_A_C_B_D() throws Exception {
		internalTest_2("a a c b d", 1);
	}
	
	@Test public void testParse_2_A_C_A_B_D() throws Exception {
		internalTest_2("a c a b d", 1);
	}
	
	@Test public void testParse_2_A_C_B_A_D() throws Exception {
		internalTest_2("a c b a d", 1);
	}
	
	@Test public void testParse_2_A_C_B_D_A() throws Exception {
		internalTest_2("a c b d a", 1);
	}
	
	public void internalTest_2(String input) throws Exception {
		internalTest_2(input, 0);
	}
	
	public void internalTest_2(String input, int expectedErrors) throws Exception {
		Model model = (Model) getModelAndExpect("2 " + input, expectedErrors);
		if (expectedErrors == 0) {
			assertTrue(model.isFirst());
			assertTrue(model.isSecond());
			assertTrue(model.isThird());
			assertTrue(model.isForth());
		}
	}
	
	@Test public void testParse_3_A_B() throws Exception {
		Model model = (Model) getModel("3 a b");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_3_B_A() throws Exception {
		Model model = (Model) getModel("3 b a");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_3_A() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("3 a");
		assertTrue(model.isFirst());
		assertFalse(model.isSecond());
	}
	
	@Test public void testParse_3_B() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("3 b");
		assertFalse(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_3() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("3");
		assertFalse(model.isFirst());
		assertFalse(model.isSecond());
	}
	
	@Test public void testParse_4_A_B() throws Exception {
		Model model = (Model) getModel("4 a b");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_4_B_A() throws Exception {
		Model model = (Model) getModel("4 b a");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_4_A() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("4 a");
		assertTrue(model.isFirst());
		assertFalse(model.isSecond());
	}
	
	@Test public void testParse_4_B() throws Exception {
		getModelAndExpect("4 b", 1);
	}
	
	@Test public void testParse_4() throws Exception {
		getModelAndExpect("4", 1);
	}
	
	@Test public void testParse_5_A_B() throws Exception {
		Model model = (Model) getModel("5 a b");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_5_B_A() throws Exception {
		Model model = (Model) getModel("5 b a");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_5_A() throws Exception {
		getModelAndExpect("5 a", 1);
	}
	
	@Test public void testParse_5_B() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("5 b");
		assertFalse(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_5() throws Exception {
		getModelAndExpect("5", 1);
	}
	
	@Test public void testParse_6_A_B() throws Exception {
		Model model = (Model) getModel("6 a b");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
	}
	
	@Test public void testParse_6_B_A() throws Exception {
		Model model = (Model) getModel("6 b a");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
	}
	
	@Test public void testParse_6_A_A_B_B() throws Exception {
		Model model = (Model) getModel("6 a a b b");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_6_B_B_A_A() throws Exception {
		Model model = (Model) getModel("6 b b a a");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_6_A() throws Exception {
		Model model = (Model) getModel("6 a");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(0, model.getSecondAsList().size());
	}
	
	@Test public void testParse_6_A_A() throws Exception {
		Model model = (Model) getModel("6 a a");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(0, model.getSecondAsList().size());
	}
	
	@Test public void testParse_6_B() throws Exception {
		getModelAndExpect("6 b", 1);
	}
	
	@Test public void testParse_6_B_B() throws Exception {
		getModelAndExpect("6 b b", 1);
	}
	
	@Test public void testParse_6() throws Exception {
		getModelAndExpect("6", 1);
	}
	
	@Test public void testParse_7_A_B() throws Exception {
		Model model = (Model) getModel("7 a b");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
	}
	
	@Test public void testParse_7_B_A() throws Exception {
		Model model = (Model) getModel("7 b a");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
	}
	
	@Test public void testParse_7_A_A_B_B() throws Exception {
		Model model = (Model) getModel("7 a a b b");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_7_B_B_A_A() throws Exception {
		Model model = (Model) getModel("7 b b a a");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_7_A() throws Exception {
		getModelAndExpect("7 a", 1);
	}
	
	@Test public void testParse_7_A_A() throws Exception {
		getModelAndExpect("7 a a", 1);
	}
	
	@Test public void testParse_7_B() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("7 b");
		assertEquals(0, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
	}
	
	@Test public void testParse_7_B_B() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("7 b b");
		assertEquals(0, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_7() throws Exception {
		getModelAndExpect("7", 1);
	}
	
	@Test public void testParse_8_A_B_C_A_B_D() throws Exception {
		Model model = (Model) getModel("8 a b c a b d");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_8_A_B_D_A_B_C() throws Exception {
		Model model = (Model) getModel("8 a b d a b c");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_9_A_B() throws Exception {
		Model model = (Model) getModel("9 a b");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
	}
	
	@Test public void testParse_9_B_A() throws Exception {
		Model model = (Model) getModel("9 b a");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
	}
	
	@Test public void testParse_9_A_B_A_B() throws Exception {
		Model model = (Model) getModel("9 a b a b");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_9_A_B_B_A() throws Exception {
		Model model = (Model) getModel("9 a b b a");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_9_B_A_A_B() throws Exception {
		Model model = (Model) getModel("9 b a a b");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_9_B_A_B_A() throws Exception {
		Model model = (Model) getModel("9 b a b a");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_9() throws Exception {
		getModelAndExpect("9", 1);
	}
	
	@Test public void testParse_9_A() throws Exception {
		getModelAndExpect("9 a", 1);
	}
	
	@Test public void testParse_9_B() throws Exception {
		getModelAndExpect("9 b", 1);
	}
	
	@Test public void testParse_9_A_B_A() throws Exception {
		getModelAndExpect("9 a b a", 1);
	}
	
	@Test public void testParse_9_A_B_B() throws Exception {
		getModelAndExpect("9 a b b", 1);
	}
	
	@Test public void testParse_9_B_A_A() throws Exception {
		getModelAndExpect("9 b a a", 1);
	}
	
	@Test public void testParse_9_B_A_B() throws Exception {
		getModelAndExpect("9 b a b", 1);
	}
	
	@Test public void testParse_10_A_B() throws Exception {
		Model model = (Model) getModel("10 a b");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
	}
	
	@Test public void testParse_10_B_A() throws Exception {
		Model model = (Model) getModel("10 b a");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
	}
	
	@Test public void testParse_10_A_B_A_B() throws Exception {
		Model model = (Model) getModel("10 a b a b");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_10_A_B_B_A() throws Exception {
		Model model = (Model) getModel("10 a b b a");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_10_B_A_A_B() throws Exception {
		Model model = (Model) getModel("10 b a a b");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_10_B_A_B_A() throws Exception {
		Model model = (Model) getModel("10 b a b a");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_10() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("10");
		assertEquals(0, model.getFirstAsList().size());
		assertEquals(0, model.getSecondAsList().size());
	}
	
	@Test public void testParse_10_A() throws Exception {
		getModelAndExpect("10 a", 1);
	}
	
	@Test public void testParse_10_B() throws Exception {
		getModelAndExpect("10 b", 1);
	}
	
	@Test public void testParse_10_A_B_A() throws Exception {
		getModelAndExpect("10 a b a", 1);
	}
	
	@Test public void testParse_10_A_B_B() throws Exception {
		getModelAndExpect("10 a b b", 1);
	}
	
	@Test public void testParse_10_B_A_A() throws Exception {
		getModelAndExpect("10 b a a", 1);
	}
	
	@Test public void testParse_10_B_A_B() throws Exception {
		getModelAndExpect("10 b a b", 1);
	}
	
	@Test public void testParse_11_A_B() throws Exception {
		Model model = (Model) getModel("11 a b");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_11_B_A() throws Exception {
		Model model = (Model) getModel("11 b a");
		assertTrue(model.isFirst());
		assertTrue(model.isSecond());
	}
	
	@Test public void testParse_11() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("11");
		assertFalse(model.isFirst());
		assertFalse(model.isSecond());
	}
	
	@Test public void testParse_11_A() throws Exception {
		getModelAndExpect("11 a", 1);
	}
	
	@Test public void testParse_11_B() throws Exception {
		getModelAndExpect("11 b", 1);
	}
	
	@Test public void testParse_11_A_B_A() throws Exception {
		getModelAndExpect("11 a b a", 1);
	}
	
	@Test public void testParse_11_A_B_B() throws Exception {
		getModelAndExpect("11 a b b", 1);
	}
	
	@Test public void testParse_11_B_A_A() throws Exception {
		getModelAndExpect("11 b a a", 1);
	}
	
	@Test public void testParse_11_B_A_B() throws Exception {
		getModelAndExpect("11 b a b", 1);
	}
	
	@Test public void testParse_12_A_B_A_B() throws Exception {
		Model model = (Model) getModel("12 a b a b");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_12_A_B_B_A() throws Exception {
		Model model = (Model) getModel("12 a b b a");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_12_B_A_A_B() throws Exception {
		Model model = (Model) getModel("12 b a a b");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_12_B_A_B_A() throws Exception {
		Model model = (Model) getModel("12 b a b a");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_12() throws Exception {
		getModelAndExpect("12", 1);
	}
	
	@Test public void testParse_12_A() throws Exception {
		getModelAndExpect("12 a", 1);
	}
	
	@Test public void testParse_12_B() throws Exception {
		getModelAndExpect("12 b", 1);
	}
	
	@Test public void testParse_12_A_B() throws Exception {
		getModelAndExpect("12 a b", 1);
	}
	
	@Test public void testParse_12_B_A() throws Exception {
		getModelAndExpect("12 b a", 1);
	}
	
	@Test public void testParse_12_A_A() throws Exception {
		getModelAndExpect("12 a a", 1);
	}
	
	@Test public void testParse_12_B_B() throws Exception {
		getModelAndExpect("12 b b", 1);
	}
	
	@Test public void testParse_12_A_B_A() throws Exception {
		getModelAndExpect("12 a b a", 1);
	}
	
	@Test public void testParse_12_A_B_B() throws Exception {
		getModelAndExpect("12 a b b", 1);
	}
	
	@Test public void testParse_12_B_A_A() throws Exception {
		getModelAndExpect("12 b a a", 1);
	}
	
	@Test public void testParse_12_B_A_B() throws Exception {
		getModelAndExpect("12 b a b", 1);
	}
	
	@Test public void testParse_13_A_B_A_B() throws Exception {
		Model model = (Model) getModel("13 a b a b");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_13_B_A_A_B() throws Exception {
		Model model = (Model) getModel("13 b a a b");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
	}
	
	@Test public void testParse_13_A_B() throws Exception {
		Model model = (Model) getModel("13 a b");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
	}
	
	@Test public void testParse_13_B_A_B_A() throws Exception {
		getModelAndExpect("13 b a b a", 2);
	}
	
	@Test public void testParse_13_A_B_B_A() throws Exception {
		getModelAndExpect("13 a b b a", 2);
	}
	
	@Test public void testParse_13() throws Exception {
		getModelAndExpect("13", 1);
	}
	
	@Test public void testParse_13_A() throws Exception {
		getModelAndExpect("13 a", 1);
	}
	
	@Test public void testParse_13_B() throws Exception {
		getModelAndExpect("13 b", 1);
	}
	
	@Test public void testParse_13_B_A() throws Exception {
		getModelAndExpect("13 b a", 1);
	}
	
	@Test public void testParse_13_A_A() throws Exception {
		getModelAndExpect("13 a a", 1);
	}
	
	@Test public void testParse_13_B_B() throws Exception {
		getModelAndExpect("13 b b", 1);
	}
	
	@Test public void testParse_13_A_B_A() throws Exception {
		getModelAndExpect("13 a b a", 1);
	}
	
	@Test public void testParse_13_A_B_B() throws Exception {
		getModelAndExpect("13 a b b", 1);
	}
	
	@Test public void testParse_13_B_A_A() throws Exception {
		getModelAndExpect("13 b a a", 1);
	}
	
	@Test public void testParse_13_B_A_B() throws Exception {
		getModelAndExpect("13 b a b", 1);
	}
	
	@Test public void testParse_14_A_B_C_D() throws Exception {
		Model model = (Model) getModel("14 a b c d");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
		assertEquals(1, model.getThirdAsList().size());
		assertEquals(1, model.getForthAsList().size());
	}
	
	@Test public void testParse_14_A_B_D_C() throws Exception {
		Model model = (Model) getModel("14 a b d c");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
		assertEquals(1, model.getThirdAsList().size());
		assertEquals(1, model.getForthAsList().size());
	}
	
	@Test public void testParse_14_B_A_C_D() throws Exception {
		Model model = (Model) getModel("14 b a c d");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
		assertEquals(1, model.getThirdAsList().size());
		assertEquals(1, model.getForthAsList().size());
	}
	
	@Test public void testParse_14_B_A_D_C() throws Exception {
		Model model = (Model) getModel("14 b a d c");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
		assertEquals(1, model.getThirdAsList().size());
		assertEquals(1, model.getForthAsList().size());
	}
	
	@Test public void testParse_14_C_D_A_B() throws Exception {
		Model model = (Model) getModel("14 c d a b");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
		assertEquals(1, model.getThirdAsList().size());
		assertEquals(1, model.getForthAsList().size());
	}
	
	@Test public void testParse_14_D_C_A_B() throws Exception {
		Model model = (Model) getModel("14 d c a b");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
		assertEquals(1, model.getThirdAsList().size());
		assertEquals(1, model.getForthAsList().size());
	}
	
	@Test public void testParse_14_C_D_B_A() throws Exception {
		Model model = (Model) getModel("14 c d b a");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
		assertEquals(1, model.getThirdAsList().size());
		assertEquals(1, model.getForthAsList().size());
	}
	
	@Test public void testParse_14_D_C_B_A() throws Exception {
		Model model = (Model) getModel("14 d c b a");
		assertEquals(1, model.getFirstAsList().size());
		assertEquals(1, model.getSecondAsList().size());
		assertEquals(1, model.getThirdAsList().size());
		assertEquals(1, model.getForthAsList().size());
	}
	
	@Test public void testParse_14_A_B_C_D_D_C_B_A() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("14 a b c d d c b a");
		assertEquals(2, model.getFirstAsList().size());
		assertEquals(2, model.getSecondAsList().size());
		assertEquals(2, model.getThirdAsList().size());
		assertEquals(2, model.getForthAsList().size());
	}
	
	@Test public void testParse_14_A_B_C_D_D_C_B_A_B_A_C_D() throws Exception {
		disableSerializerTest();
		Model model = (Model) getModel("14 a b c d d c b a b a c d");
		assertEquals(3, model.getFirstAsList().size());
		assertEquals(3, model.getSecondAsList().size());
		assertEquals(3, model.getThirdAsList().size());
		assertEquals(3, model.getForthAsList().size());
	}
	
	public void internalTestDatatypes(String input) throws Exception {
		Model model = (Model) getModel("datatypes " + input);
		assertEquals(input, model.getValue());
	}
	
	public void internalTestDatatypes_2(String input) throws Exception {
		Model model = (Model) getModel("datatypes 2 " + input);
		assertEquals("2 " + input, model.getValue());
	}
	
	public void internalTestDatatypes_2(String input, int expectedErrors) throws Exception {
		getModelAndExpect("datatypes 2 " + input, expectedErrors);
	}
	
	@Test public void testDatatype_1_A_B() throws Exception {
		internalTestDatatypes("1 a b");
	}
	
	@Test public void testDatatype_1_B_A() throws Exception {
		internalTestDatatypes("1 b a");
	}
	
	@Test public void testDatatype_2_A_B_C_D() throws Exception {
		internalTestDatatypes_2("a b c d");
	}
	
	@Test public void testDatatype_2_A_B_D_C() throws Exception {
		internalTestDatatypes_2("a b d c");
	}
	
	@Test public void testDatatype_2_A_C_B_D() throws Exception {
		internalTestDatatypes_2("a c b d");
	}
	
	@Test public void testDatatype_2_A_C_D_B() throws Exception {
		internalTestDatatypes_2("a c d b");
	}
	
	@Test public void testDatatype_2_A_D_B_C() throws Exception {
		internalTestDatatypes_2("a d b c");
	}
	
	@Test public void testDatatype_2_A_D_C_B() throws Exception {
		internalTestDatatypes_2("a d c b");
	}
	
	@Test public void testDatatype_2_A_A_C_B_D() throws Exception {
		internalTestDatatypes_2("a a c b d", 1);
	}
	
	@Test public void testDatatype_2_A_C_A_B_D() throws Exception {
		internalTestDatatypes_2("a c a b d", 1);
	}
	
	@Test public void testDatatype_2_A_C_B_A_D() throws Exception {
		internalTestDatatypes_2("a c b a d", 1);
	}
	
	@Test public void testDatatype_2_A_C_B_D_A() throws Exception {
		internalTestDatatypes_2("a c b d a", 1);
	}
	
	@Test public void testDatatype_3_A_B() throws Exception {
		internalTestDatatypes("3 a b");
	}
	
	@Test public void testDatatype_3_B_A() throws Exception {
		internalTestDatatypes("3 b a");
	}
	
	@Test public void testDatatype_3_A() throws Exception {
		internalTestDatatypes("3 a");
	}
	
	@Test public void testDatatype_3_B() throws Exception {
		internalTestDatatypes("3 b");
	}
	
	@Test public void testDatatype_3() throws Exception {
		internalTestDatatypes("3");
	}
	
	@Test public void testDatatype_4_A_B() throws Exception {
		internalTestDatatypes("4 a b");
	}
	
	@Test public void testDatatype_4_B_A() throws Exception {
		internalTestDatatypes("4 b a");
	}
	
	@Test public void testDatatype_4_A() throws Exception {
		internalTestDatatypes("4 a");
	}
	
	@Test public void testDatatype_4_B() throws Exception {
		getModelAndExpect("datatypes 4 b", 1);
	}
	
	@Test public void testDatatype_4() throws Exception {
		getModelAndExpect("datatypes 4", 1);
	}
	
	@Test public void testDatatype_5_A_B() throws Exception {
		internalTestDatatypes("5 a b");
	}
	
	@Test public void testDatatype_5_B_A() throws Exception {
		internalTestDatatypes("5 b a");
	}
	
	@Test public void testDatatype_5_A() throws Exception {
		getModelAndExpect("datatypes 5 a", 1);
	}
	
	@Test public void testDatatype_5_B() throws Exception {
		internalTestDatatypes("5 b");
	}
	
	@Test public void testDatatype_5() throws Exception {
		getModelAndExpect("datatypes 5", 1);
	}
	
	@Test public void testDatatype_6_A_B() throws Exception {
		internalTestDatatypes("6 a b");
	}
	
	@Test public void testDatatype_6_B_A() throws Exception {
		internalTestDatatypes("6 b a");
	}
	
	@Test public void testDatatype_6_A_A_B_B() throws Exception {
		internalTestDatatypes("6 a a b b");
	}
	
	@Test public void testDatatype_6_B_B_A_A() throws Exception {
		internalTestDatatypes("6 b b a a");
	}
	
	@Test public void testDatatype_6_A() throws Exception {
		internalTestDatatypes("6 a");
	}
	
	@Test public void testDatatype_6_A_A() throws Exception {
		internalTestDatatypes("6 a a");
	}
	
	@Test public void testDatatype_6_B() throws Exception {
		getModelAndExpect("datatypes 6 b", 1);
	}
	
	@Test public void testDatatype_6_B_B() throws Exception {
		getModelAndExpect("datatypes 6 b b", 1);
	}
	
	@Test public void testDatatype_6() throws Exception {
		getModelAndExpect("datatypes 6", 1);
	}
	
	@Test public void testDatatype_7_A_B() throws Exception {
		internalTestDatatypes("7 a b");
	}
	
	@Test public void testDatatype_7_B_A() throws Exception {
		internalTestDatatypes("7 b a");
	}
	
	@Test public void testDatatype_7_A_A_B_B() throws Exception {
		internalTestDatatypes("7 a a b b");
	}
	
	@Test public void testDatatype_7_B_B_A_A() throws Exception {
		internalTestDatatypes("7 b b a a");
	}
	
	@Test public void testDatatype_7_A() throws Exception {
		getModelAndExpect("datatypes 7 a", 1);
	}
	
	@Test public void testDatatype_7_A_A() throws Exception {
		getModelAndExpect("datatypes 7 a a", 1);
	}
	
	@Test public void testDatatype_7_B() throws Exception {
		internalTestDatatypes("7 b");
	}
	
	@Test public void testDatatype_7_B_B() throws Exception {
		internalTestDatatypes("7 b b");
	}
	
	@Test public void testDatatype_7() throws Exception {
		getModelAndExpect("datatypes 7", 1);
	}
	
	@Test public void testDatatype_8_A_B_C_A_B_D() throws Exception {
		internalTestDatatypes("8 a b c a b d");
	}
	
	@Test public void testDatatype_8_A_B_D_A_B_C() throws Exception {
		internalTestDatatypes("8 a b d a b c");
	}
	
	@Test public void testDatatype_9_A_B() throws Exception {
		internalTestDatatypes("9 a b");
	}
	
	@Test public void testDatatype_9_B_A() throws Exception {
		internalTestDatatypes("9 b a");
	}
	
	@Test public void testDatatype_9_A_B_A_B() throws Exception {
		internalTestDatatypes("9 a b a b");
	}
	
	@Test public void testDatatype_9_A_B_B_A() throws Exception {
		internalTestDatatypes("9 a b b a");
	}
	
	@Test public void testDatatype_9_B_A_A_B() throws Exception {
		internalTestDatatypes("9 b a a b");
	}
	
	@Test public void testDatatype_9_B_A_B_A() throws Exception {
		internalTestDatatypes("9 b a b a");
	}
	
	@Test public void testDatatype_9() throws Exception {
		getModelAndExpect("datatypes 9", 1);
	}
	
	@Test public void testDatatype_9_A() throws Exception {
		getModelAndExpect("datatypes 9 a", 1);
	}
	
	@Test public void testDatatype_9_B() throws Exception {
		getModelAndExpect("datatypes 9 b", 1);
	}
	
	@Test public void testDatatype_9_A_B_A() throws Exception {
		getModelAndExpect("datatypes 9 a b a", 1);
	}
	
	@Test public void testDatatype_9_A_B_B() throws Exception {
		getModelAndExpect("datatypes 9 a b b", 1);
	}
	
	@Test public void testDatatype_9_B_A_A() throws Exception {
		getModelAndExpect("datatypes 9 b a a", 1);
	}
	
	@Test public void testDatatype_9_B_A_B() throws Exception {
		getModelAndExpect("datatypes 9 b a b", 1);
	}
	
	@Test public void testDatatype_10_A_B() throws Exception {
		internalTestDatatypes("10 a b");
	}
	
	@Test public void testDatatype_10_B_A() throws Exception {
		internalTestDatatypes("10 b a");
	}
	
	@Test public void testDatatype_10_A_B_A_B() throws Exception {
		internalTestDatatypes("10 a b a b");
	}
	
	@Test public void testDatatype_10_A_B_B_A() throws Exception {
		internalTestDatatypes("10 a b b a");
	}
	
	@Test public void testDatatype_10_B_A_A_B() throws Exception {
		internalTestDatatypes("10 b a a b");
	}
	
	@Test public void testDatatype_10_B_A_B_A() throws Exception {
		internalTestDatatypes("10 b a b a");
	}
	
	@Test public void testDatatype_10() throws Exception {
		internalTestDatatypes("10");
	}
	
	@Test public void testDatatype_10_A() throws Exception {
		getModelAndExpect("datatypes 10 a", 1);
	}
	
	@Test public void testDatatype_10_B() throws Exception {
		getModelAndExpect("datatypes 10 b", 1);
	}
	
	@Test public void testDatatype_10_A_B_A() throws Exception {
		getModelAndExpect("datatypes 10 a b a", 1);
	}
	
	@Test public void testDatatype_10_A_B_B() throws Exception {
		getModelAndExpect("datatypes 10 a b b", 1);
	}
	
	@Test public void testDatatype_10_B_A_A() throws Exception {
		getModelAndExpect("datatypes 10 b a a", 1);
	}
	
	@Test public void testDatatype_10_B_A_B() throws Exception {
		getModelAndExpect("datatypes 10 b a b", 1);
	}
	
	@Test public void testDatatype_11_A_B() throws Exception {
		internalTestDatatypes("11 a b");
	}
	
	@Test public void testDatatype_11_B_A() throws Exception {
		internalTestDatatypes("11 b a");
	}
	
	@Test public void testDatatype_11() throws Exception {
		internalTestDatatypes("11");
	}
	
	@Test public void testDatatype_11_A() throws Exception {
		getModelAndExpect("datatypes 11 a", 1);
	}
	
	@Test public void testDatatype_11_B() throws Exception {
		getModelAndExpect("datatypes 11 b", 1);
	}
	
	@Test public void testDatatype_11_A_B_A() throws Exception {
		getModelAndExpect("datatypes 11 a b a", 1);
	}
	
	@Test public void testDatatype_11_A_B_B() throws Exception {
		getModelAndExpect("datatypes 11 a b b", 1);
	}
	
	@Test public void testDatatype_11_B_A_A() throws Exception {
		getModelAndExpect("datatypes 11 b a a", 1);
	}
	
	@Test public void testDatatype_11_B_A_B() throws Exception {
		getModelAndExpect("datatypes 11 b a b", 1);
	}
	
	@Test public void testDatatype_12_A_B_A_B() throws Exception {
		internalTestDatatypes("12 a b a b");
	}
	
	@Test public void testDatatype_12_A_B_B_A() throws Exception {
		internalTestDatatypes("12 a b b a");
	}
	
	@Test public void testDatatype_12_B_A_A_B() throws Exception {
		internalTestDatatypes("12 b a a b");
	}
	
	@Test public void testDatatype_12_B_A_B_A() throws Exception {
		internalTestDatatypes("12 b a b a");
	}
	
	@Test public void testDatatype_12() throws Exception {
		getModelAndExpect("datatypes 12", 1);
	}
	
	@Test public void testDatatype_12_A() throws Exception {
		getModelAndExpect("datatypes 12 a", 1);
	}
	
	@Test public void testDatatype_12_B() throws Exception {
		getModelAndExpect("datatypes 12 b", 1);
	}
	
	@Test public void testDatatype_12_A_B() throws Exception {
		getModelAndExpect("datatypes 12 a b", 1);
	}
	
	@Test public void testDatatype_12_B_A() throws Exception {
		getModelAndExpect("datatypes 12 b a", 1);
	}
	
	@Test public void testDatatype_12_A_A() throws Exception {
		getModelAndExpect("datatypes 12 a a", 1);
	}
	
	@Test public void testDatatype_12_B_B() throws Exception {
		getModelAndExpect("datatypes 12 b b", 1);
	}
	
	@Test public void testDatatype_12_A_B_A() throws Exception {
		getModelAndExpect("datatypes 12 a b a", 1);
	}
	
	@Test public void testDatatype_12_A_B_B() throws Exception {
		getModelAndExpect("datatypes 12 a b b", 1);
	}
	
	@Test public void testDatatype_12_B_A_A() throws Exception {
		getModelAndExpect("datatypes 12 b a a", 1);
	}
	
	@Test public void testDatatype_12_B_A_B() throws Exception {
		getModelAndExpect("datatypes 12 b a b", 1);
	}
	
	@Test public void testDatatype_13_A_B_A_B() throws Exception {
		internalTestDatatypes("13 a b a b");
	}
	
	@Test public void testDatatype_13_B_A_A_B() throws Exception {
		internalTestDatatypes("13 b a a b");
	}
	
	@Test public void testDatatype_13_A_B() throws Exception {
		internalTestDatatypes("13 a b");
	}
	
	@Test public void testDatatype_13_B_A_B_A() throws Exception {
		getModelAndExpect("datatypes 13 b a b a", 2);
	}
	
	@Test public void testDatatype_13_A_B_B_A() throws Exception {
		getModelAndExpect("datatypes 13 a b b a", 2);
	}
	
	@Test public void testDatatype_13() throws Exception {
		getModelAndExpect("datatypes 13", 1);
	}
	
	@Test public void testDatatype_13_A() throws Exception {
		getModelAndExpect("datatypes 13 a", 1);
	}
	
	@Test public void testDatatype_13_B() throws Exception {
		getModelAndExpect("datatypes 13 b", 1);
	}
	
	@Test public void testDatatype_13_B_A() throws Exception {
		getModelAndExpect("datatypes 13 b a", 1);
	}
	
	@Test public void testDatatype_13_A_A() throws Exception {
		getModelAndExpect("datatypes 13 a a", 1);
	}
	
	@Test public void testDatatype_13_B_B() throws Exception {
		getModelAndExpect("datatypes 13 b b", 1);
	}
	
	@Test public void testDatatype_13_A_B_A() throws Exception {
		getModelAndExpect("datatypes 13 a b a", 1);
	}
	
	@Test public void testDatatype_13_A_B_B() throws Exception {
		getModelAndExpect("datatypes 13 a b b", 1);
	}
	
	@Test public void testDatatype_13_B_A_A() throws Exception {
		getModelAndExpect("datatypes 13 b a a", 1);
	}
	
	@Test public void testDatatype_13_B_A_B() throws Exception {
		getModelAndExpect("datatypes 13 b a b", 1);
	}
	
	@Test public void testDatatype_14_A_B_C_D() throws Exception {
		internalTestDatatypes("14 a b c d");
	}
	
	@Test public void testDatatype_14_A_B_D_C() throws Exception {
		internalTestDatatypes("14 a b d c");
	}
	
	@Test public void testDatatype_14_B_A_C_D() throws Exception {
		internalTestDatatypes("14 b a c d");
	}
	
	@Test public void testDatatype_14_B_A_D_C() throws Exception {
		internalTestDatatypes("14 b a d c");
	}
	
	@Test public void testDatatype_14_C_D_A_B() throws Exception {
		internalTestDatatypes("14 c d a b");
	}
	
	@Test public void testDatatype_14_D_C_A_B() throws Exception {
		internalTestDatatypes("14 d c a b");
	}
	
	@Test public void testDatatype_14_C_D_B_A() throws Exception {
		internalTestDatatypes("14 c d b a");
	}
	
	@Test public void testDatatype_14_D_C_B_A() throws Exception {
		internalTestDatatypes("14 d c b a");
	}
	
	@Test public void testDatatype_14_A_B_C_D_D_C_B_A() throws Exception {
		internalTestDatatypes("14 a b c d d c b a");
	}
	
	@Test public void testDatatype_14_A_B_C_D_D_C_B_A_B_A_C_D() throws Exception {
		internalTestDatatypes("14 a b c d d c b a b a c d");
	}
	
	@Test public void testNested_A_B() throws Exception {
		internalTestNested("a b nested", 1);
	}
	
	@Test public void testNested_B_A() throws Exception {
		internalTestNested("b a nested", 1);
	}
	
	@Test public void testNested_A_B_A_B() throws Exception {
		internalTestNested("a b nested a b nested", 2);
	}
	
	@Test public void testNested_B_A_A_B() throws Exception {
		internalTestNested("b a nested a b nested", 2);
	}
	
	@Test public void testNested_A_B_B_A() throws Exception {
		internalTestNested("a b nested b a nested", 2);
	}
	
	@Test public void testNested_B_A_B_A() throws Exception {
		internalTestNested("b a nested b a nested", 2);
	}

	public void internalTestNested(String input, int expected) throws Exception {
		Model model = (Model) getModel("bug302585 " + input);
		assertNotNull(model);
		List<NestedModel> nestedModels = model.getNestedModel();
		assertEquals(expected, nestedModels.size());
		for(NestedModel nested: nestedModels) {
			assertTrue(nested.isFirst());
			assertTrue(nested.isSecond());
		}
	}
}
