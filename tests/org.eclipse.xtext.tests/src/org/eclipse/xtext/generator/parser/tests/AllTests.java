/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.tests;

import org.eclipse.xtext.generator.parser.AntlrGrammarGenUtilTest;
import org.eclipse.xtext.generator.parser.TerminalRuleToLexerBodyTest;
import org.eclipse.xtext.generator.parser.ex.common.KeywordHelperTest;
import org.eclipse.xtext.generator.parser.splitting.AntlrLexerSplitterTest;
import org.eclipse.xtext.generator.parser.splitting.AntlrParserSplitterTest;
import org.eclipse.xtext.generator.parser.splitting.CondititionSimplifierTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author huebner - Initial contribution and API
 */
public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.xtext.generator.parser.tests");
		suite.addTestSuite(AntlrGrammarGenUtilTest.class);
		suite.addTestSuite(TerminalRuleToLexerBodyTest.class);
		suite.addTestSuite(KeywordHelperTest.class);
		suite.addTestSuite(AntlrLexerSplitterTest.class);
		suite.addTestSuite(AntlrParserSplitterTest.class);
		suite.addTestSuite(CondititionSimplifierTest.class);
		return suite;
	}
}
