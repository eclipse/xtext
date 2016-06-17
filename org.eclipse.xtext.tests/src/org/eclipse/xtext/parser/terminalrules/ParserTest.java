/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.TerminalRulesTestLanguagePackage;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTest extends AbstractXtextTests {

	private EStructuralFeature idFeature;
	private EStructuralFeature intFeature;
	private EStructuralFeature stringFeature;
	private EStructuralFeature richStringFeature;
	private EStructuralFeature mlCommentFeature;
	private EStructuralFeature slCommentFeature;
	private EStructuralFeature wsFeature;
	private EStructuralFeature anyOtherFeature;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(TerminalRulesTestLanguageStandaloneSetup.class);
		EPackage pack = TerminalRulesTestLanguagePackage.eINSTANCE;
		EClass model = (EClass) pack.getEClassifier("Model");
		idFeature = model.getEStructuralFeature("idValue");
		intFeature = model.getEStructuralFeature("intValue");
		stringFeature = model.getEStructuralFeature("stringValue");
		richStringFeature = model.getEStructuralFeature("richStringValue");
		mlCommentFeature = model.getEStructuralFeature("mlCommentValue");
		slCommentFeature = model.getEStructuralFeature("slCommentValue");
		wsFeature = model.getEStructuralFeature("wsValue");
		anyOtherFeature = model.getEStructuralFeature("anyValue");
	}

	@Test public void testSetup() {
		EPackage pack = TerminalRulesTestLanguagePackage.eINSTANCE;
		EClass model = (EClass) pack.getEClassifier("Model");
		assertEquals(model.getEStructuralFeatures().size(), ParserTest.class.getDeclaredFields().length);
	}
	
	private void doTest(String expected, String model, EStructuralFeature feature) throws Exception {
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		assertEquals("Model", parsedModel.eClass().getName());
		String value = (String) parsedModel.eGet(feature);
		assertNotNull(value);
		assertEquals(expected, value);
	}

	@Test public void testId_01() throws Exception {
		doTest("abc", "abc", idFeature);
	}

	@Test public void testId_02() throws Exception {
		doTest("abc", "^abc", idFeature);
	}

	@Test public void testId_03() throws Exception {
		doTest("abc1", "abc1", idFeature);
	}

	@Test public void testId_04() throws Exception {
		doTest("abc1", "^abc1", idFeature);
	}

	@Test public void testInt_01() throws Exception {
		doTest("0", "0", intFeature);
	}

	@Test public void testInt_02() throws Exception {
		doTest("111", "111", intFeature);
	}

	@Test public void testString_01() throws Exception {
		doTest("abc", "'abc'", stringFeature);
	}

	@Test public void testString_02() throws Exception {
		doTest("abc", "\"abc\"", stringFeature);
	}

	@Test public void testString_03() throws Exception {
		doTest("ab cd", "'ab cd'", stringFeature);
	}
	
	@Test public void testString_04() throws Exception {
		doTest("ab\\cd", "'ab\\\\cd'", stringFeature);
	}
	
	@Test public void testString_05() throws Exception {
		doTest("ab\ncd", "'ab\\ncd'", stringFeature);
	}
	
	@Test public void testString_06() throws Exception {
		doTest("", "''", stringFeature);
	}
	
	@Test public void testRichString_01() throws Exception {
		doTest("'''abc'''", "'''abc'''", richStringFeature);
	}

	@Test public void testRichString_02() throws Exception {
		doTest("'''\n\\'''", "'''\n\\'''", richStringFeature);
	}

	@Test public void testRichString_03() throws Exception {
		doTest("'''ab cd'''", "'''ab cd'''", richStringFeature);
	}
	
	@Test public void testRichString_04() throws Exception {
		doTest("'''test''", "'''test''", richStringFeature);
	}
	
	@Test public void testRichString_05() throws Exception {
		doTest("'''test'", "'''test'", richStringFeature);
	}
	
	@Test public void testRichString_06() throws Exception {
		doTest("'''test", "'''test", richStringFeature);
	}
	
	@Test public void testRichString_07() throws Exception {
		doTest("'''", "'''", richStringFeature);
	}

	@Test public void testMlComment_01() throws Exception {
		doTest("/* abc */", "/* abc */", mlCommentFeature);
	}

	@Test public void testMlComment_02() throws Exception {
		doTest("/* ab\nc */", "/* ab\nc */", mlCommentFeature);
	}

	@Test public void testSlComment_01() throws Exception {
		doTest("// abc" , "// abc", slCommentFeature);
	}

	@Test public void testSlComment_02() throws Exception {
		doTest("// abc\n" , "// abc\n", slCommentFeature);
	}

	@Test public void testSlComment_03() throws Exception {
		doTest("// abc\r\n" , "// abc\r\n", slCommentFeature);
	}

	@Test public void testSlComment_04() throws Exception {
		doTest("// abc" , "// abc", slCommentFeature);
	}

	@Test public void testWs_01() throws Exception {
		doTest("  ", "  ", wsFeature);
	}

	@Test public void testWs_02() throws Exception {
		doTest("\t", "\t", wsFeature);
	}

	@Test public void testWs_03() throws Exception {
		doTest(" \n ", " \n ", wsFeature);
	}

	@Test public void testAnyOther_01() throws Exception {
		doTest("'", "'", anyOtherFeature);
	}

	@Test public void testAnyOther_02() throws Exception {
		doTest(".", ".", anyOtherFeature);
	}

	@Test public void testAnyOther_03() throws Exception {
		doTest("\b", "\b", anyOtherFeature);
	}
}
