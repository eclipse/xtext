/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parser.packrat.TerminalRuleInterpreter;
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

	private void doTest(boolean expected, String model, ParserRule rule) throws Exception {
		TerminalRuleInterpreter interpreter = new TerminalRuleInterpreter(model);
		assertEquals(rule.getName(), expected, interpreter.matches(rule));
	}

	public void testId_01() throws Exception {
		doTest(true, "abc", grammarAccess.prID().getRule());
	}

	public void testId_02() throws Exception {
		doTest(true, "^abc", grammarAccess.prID().getRule());
	}

	public void testId_03() throws Exception {
		doTest(true, "abc1", grammarAccess.prID().getRule());
	}

	public void testId_04() throws Exception {
		doTest(true, "^abc1", grammarAccess.prID().getRule());
	}

	public void testId_05() throws Exception {
		doTest(false, "^1abc1", grammarAccess.prID().getRule());
	}

	public void testId_06() throws Exception {
		doTest(false, "abc ", grammarAccess.prID().getRule());
	}

	public void testInt_01() throws Exception {
		doTest(true, "0", grammarAccess.prINT().getRule());
	}

	public void testInt_02() throws Exception {
		doTest(true, "111", grammarAccess.prINT().getRule());
	}

	public void testString_01() throws Exception {
		doTest(true, "'abc'", grammarAccess.prSTRING().getRule());
	}

	public void testString_02() throws Exception {
		doTest(true, "\"abc\"", grammarAccess.prSTRING().getRule());
	}

	public void testString_03() throws Exception {
		doTest(true, "'ab cd'", grammarAccess.prSTRING().getRule());
	}

	public void testMlComment_01() throws Exception {
		doTest(true, "/* abc */", grammarAccess.prML_COMMENT().getRule());
	}

	public void testMlComment_02() throws Exception {
		doTest(true, "/* ab\nc */", grammarAccess.prML_COMMENT().getRule());
	}

	public void testSlComment_01() throws Exception {
		doTest(true , "// abc", grammarAccess.prSL_COMMENT().getRule());
	}

	public void testSlComment_02() throws Exception {
		doTest(true , "// abc\n", grammarAccess.prSL_COMMENT().getRule());
	}

	public void testSlComment_03() throws Exception {
		doTest(true , "// abc\r\n", grammarAccess.prSL_COMMENT().getRule());
	}

	public void testSlComment_04() throws Exception {
		doTest(true , "// abc", grammarAccess.prSL_COMMENT().getRule());
	}

	public void testWs_01() throws Exception {
		doTest(true, "  ", grammarAccess.prWS().getRule());
	}

	public void testWs_02() throws Exception {
		doTest(true, "\t", grammarAccess.prWS().getRule());
	}

	public void testWs_03() throws Exception {
		doTest(true, " \n ", grammarAccess.prWS().getRule());
	}

	public void testAnyOther_01() throws Exception {
		doTest(true, "'", grammarAccess.prANY_OTHER().getRule());
	}

	public void testAnyOther_02() throws Exception {
		doTest(true, ".", grammarAccess.prANY_OTHER().getRule());
	}

	public void testAnyOther_03() throws Exception {
		doTest(true, "\b", grammarAccess.prANY_OTHER().getRule());
	}
}
