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
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.TerminalRulesTestLanguagePackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTest extends AbstractXtextTests {

	private EStructuralFeature idFeature;
	private EStructuralFeature intFeature;
	private EStructuralFeature stringFeature;
	private EStructuralFeature mlCommentFeature;
	private EStructuralFeature slCommentFeature;
	private EStructuralFeature wsFeature;
	private EStructuralFeature anyOtherFeature;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(TerminalRulesTestLanguageStandaloneSetup.class);
		EPackage pack = TerminalRulesTestLanguagePackage.eINSTANCE;
		EClass model = (EClass) pack.getEClassifier("Model");
		idFeature = model.getEStructuralFeature("idValue");
		intFeature = model.getEStructuralFeature("intValue");
		stringFeature = model.getEStructuralFeature("stringValue");
		mlCommentFeature = model.getEStructuralFeature("mlCommentValue");
		slCommentFeature = model.getEStructuralFeature("slCommentValue");
		wsFeature = model.getEStructuralFeature("wsValue");
		anyOtherFeature = model.getEStructuralFeature("anyValue");
	}

	private void doTest(String expected, String model, EStructuralFeature feature) throws Exception {
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		assertEquals("Model", parsedModel.eClass().getName());
		String value = (String) parsedModel.eGet(feature);
		assertNotNull(value);
		assertEquals(expected, value);
	}

	public void testId_01() throws Exception {
		doTest("abc", "abc", idFeature);
	}

	public void testId_02() throws Exception {
		doTest("abc", "^abc", idFeature);
	}

	public void testId_03() throws Exception {
		doTest("abc1", "abc1", idFeature);
	}

	public void testId_04() throws Exception {
		doTest("abc1", "^abc1", idFeature);
	}

	public void testInt_01() throws Exception {
		doTest("0", "0", intFeature);
	}

	public void testInt_02() throws Exception {
		doTest("111", "111", intFeature);
	}

	public void testString_01() throws Exception {
		doTest("abc", "'abc'", stringFeature);
	}

	public void testString_02() throws Exception {
		doTest("abc", "\"abc\"", stringFeature);
	}

	public void testString_03() throws Exception {
		doTest("ab cd", "'ab cd'", stringFeature);
	}

	public void testMlComment_01() throws Exception {
		doTest("/* abc */", "/* abc */", mlCommentFeature);
	}

	public void testMlComment_02() throws Exception {
		doTest("/* ab\nc */", "/* ab\nc */", mlCommentFeature);
	}

	public void testSlComment_01() throws Exception {
		doTest("// abc" , "// abc", slCommentFeature);
	}

	public void testSlComment_02() throws Exception {
		doTest("// abc\n" , "// abc\n", slCommentFeature);
	}

	public void testSlComment_03() throws Exception {
		doTest("// abc\r\n" , "// abc\r\n", slCommentFeature);
	}

	public void testSlComment_04() throws Exception {
		doTest("// abc" , "// abc", slCommentFeature);
	}

	public void testWs_01() throws Exception {
		doTest("  ", "  ", wsFeature);
	}

	public void testWs_02() throws Exception {
		doTest("\t", "\t", wsFeature);
	}

	public void testWs_03() throws Exception {
		doTest(" \n ", " \n ", wsFeature);
	}

	public void testAnyOther_01() throws Exception {
		doTest("'", "'", anyOtherFeature);
	}

	public void testAnyOther_02() throws Exception {
		doTest(".", ".", anyOtherFeature);
	}

	public void testAnyOther_03() throws Exception {
		doTest("\b", "\b", anyOtherFeature);
	}
}
