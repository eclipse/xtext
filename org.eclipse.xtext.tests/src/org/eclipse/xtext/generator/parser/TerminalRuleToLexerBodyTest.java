/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xtext.generator.parser.antlr.TerminalRuleToLexerBody;
import org.junit.Test;

//import org.eclipse.xtext.generator.parser.TerminalRuleToLexerBody;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO reactivate testcase and move to test plugin, that is not hosted at eclipse
 */
public class TerminalRuleToLexerBodyTest extends AbstractXtextTests {

	private Grammar grammar;
	private TerminalRule adaString;
	private TerminalRule workaroundString;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		String model = "grammar foo\n" +
				"generate fooModel 'uri' as foo\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"Model returns foo::Model: name=ADA_STRING\n;" +
				"terminal ADA_STRING: '\"' ((!'\"')|'\"\"')* '\"'\n;" +
				"terminal WORKAROUND_STRING: '\"' ((!'\"')|'\"''\"')* '\"'\n;";
		grammar = (Grammar) getModel(model);
		adaString = (TerminalRule) GrammarUtil.findRuleForName(grammar, "ADA_STRING");
		workaroundString = (TerminalRule) GrammarUtil.findRuleForName(grammar, "WORKAROUND_STRING");
	}
	
	@Test public void testToLexerBody_01() {
		String ada = TerminalRuleToLexerBody.toLexerBody(adaString);
		String expectation = "'\"' (~('\"')|'\"\"')* '\"'"; // '"' (~('"')|'""')* '"'
		assertEquals(expectation, ada);
	}

	@Test public void testToLexerBody_02() {
		String workaround = TerminalRuleToLexerBody.toLexerBody(workaroundString);
		String expectation = "'\"' (~('\"')|'\"' '\"')* '\"'"; // '"' (~('"')|'"' '"')* '"'
		assertEquals(expectation, workaround);
	}
}
