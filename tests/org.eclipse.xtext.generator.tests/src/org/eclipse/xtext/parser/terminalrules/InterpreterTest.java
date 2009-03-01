/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.generator.parser.TerminalRuleInterpreter;
import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InterpreterTest extends AbstractGeneratorTest {

	private TerminalRulesTestLanguageGrammarAccess grammarAccess;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(TerminalRulesTestLanguageStandaloneSetup.class);
		grammarAccess = get(TerminalRulesTestLanguageGrammarAccess.class);
	}

	private void doTest(boolean expected, String model, TerminalRule rule) throws Exception {
		TerminalRuleInterpreter interpreter = new TerminalRuleInterpreter(model);
		assertEquals(rule.getName(), expected, interpreter.matches(rule));
	}

	public void testId_01() throws Exception {
		doTest(true, "abc", grammarAccess.trID());
	}

	public void testId_02() throws Exception {
		doTest(true, "^abc", grammarAccess.trID());
	}

	public void testId_03() throws Exception {
		doTest(true, "abc1", grammarAccess.trID());
	}

	public void testId_04() throws Exception {
		doTest(true, "^abc1", grammarAccess.trID());
	}

	public void testId_05() throws Exception {
		doTest(false, "^1abc1", grammarAccess.trID());
	}

	public void testId_06() throws Exception {
		doTest(false, "abc ", grammarAccess.trID());
	}

	public void testInt_01() throws Exception {
		doTest(true, "0", grammarAccess.trINT());
	}

	public void testInt_02() throws Exception {
		doTest(true, "111", grammarAccess.trINT());
	}

	public void testString_01() throws Exception {
		doTest(true, "'abc'", grammarAccess.trSTRING());
	}

	public void testString_02() throws Exception {
		doTest(true, "\"abc\"", grammarAccess.trSTRING());
	}

	public void testString_03() throws Exception {
		doTest(true, "'ab cd'", grammarAccess.trSTRING());
	}

	public void testMlComment_01() throws Exception {
		doTest(true, "/* abc */", grammarAccess.trML_COMMENT());
	}

	public void testMlComment_02() throws Exception {
		doTest(true, "/* ab\nc */", grammarAccess.trML_COMMENT());
	}

	public void testSlComment_01() throws Exception {
		doTest(true , "// abc", grammarAccess.trSL_COMMENT());
	}

	public void testSlComment_02() throws Exception {
		doTest(true , "// abc\n", grammarAccess.trSL_COMMENT());
	}

	public void testSlComment_03() throws Exception {
		doTest(true , "// abc\r\n", grammarAccess.trSL_COMMENT());
	}

	public void testSlComment_04() throws Exception {
		doTest(true , "// abc", grammarAccess.trSL_COMMENT());
	}

	public void testWs_01() throws Exception {
		doTest(true, "  ", grammarAccess.trWS());
	}

	public void testWs_02() throws Exception {
		doTest(true, "\t", grammarAccess.trWS());
	}

	public void testWs_03() throws Exception {
		doTest(true, " \n ", grammarAccess.trWS());
	}

	public void testAnyOther_01() throws Exception {
		doTest(true, "'", grammarAccess.trANY_OTHER());
	}

	public void testAnyOther_02() throws Exception {
		doTest(true, ".", grammarAccess.trANY_OTHER());
	}

	public void testAnyOther_03() throws Exception {
		doTest(true, "\b", grammarAccess.trANY_OTHER());
	}
}
