/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.lexer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.BuiltinRules;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.core.parser.ITokenTypes;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.LeafNode;
import org.eclipse.xtext.testlanguages.LexerLanguageLanguageFacade;
import org.eclipse.xtext.testlanguages.LexerLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.LexerLanguageTokenTypes;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public class LexerTokenTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		LexerLanguageStandaloneSetup.doSetup();
		with(LexerLanguageLanguageFacade.LANGUAGE_ID);
	}

	public void testLexerTokens() throws Exception {
		AbstractNode rootNode = getRootNode("xyz #A #CCC #BB #CCCCC");
		EList<LeafNode> leafNodes = rootNode.getLeafNodes();
		assertTrue(GrammarUtil.isLexerRuleCall(leafNodes.get(0).getGrammarElement()));
		assertEquals(BuiltinRules.BUILTIN_ID, GrammarUtil.calledRule((RuleCall) leafNodes.get(0).getGrammarElement()));
		assertEquals(ITokenTypes.IDENTIFIER, leafNodes.get(0).tokenType());
		checkIsWhitespace(leafNodes.get(1));
		checkIsDefinedRule(leafNodes.get(2), "EXPLICITTOKENTYPE", LexerLanguageTokenTypes.X);
		checkIsWhitespace(leafNodes.get(3));
		checkIsDefinedRule(leafNodes.get(4), "IMPLICITTOKENTYPE", LexerLanguageTokenTypes.IMPLICITTOKENTYPE);
		checkIsWhitespace(leafNodes.get(5));
		checkIsDefinedRule(leafNodes.get(6), "STRING", LexerLanguageTokenTypes.STRING);
		checkIsWhitespace(leafNodes.get(7));
		checkIsDefinedRule(leafNodes.get(8), "IMPLICITTOKENTYPE", LexerLanguageTokenTypes.IMPLICITTOKENTYPE);
	}
	
	private void checkIsDefinedRule(LeafNode leafNode, String ruleName, String tokenType) {
		assertTrue(GrammarUtil.isLexerRuleCall(leafNode.getGrammarElement()));
		AbstractRule calledRule = GrammarUtil.calledRule((RuleCall) leafNode.getGrammarElement());
		assertFalse(BuiltinRules.getBuiltinLexerRules().contains(calledRule));
		assertEquals(ruleName, calledRule.getName());
		assertEquals(tokenType, leafNode.tokenType());
	}
	
	private void checkIsWhitespace(LeafNode leafNode) {
		assertEquals(BuiltinRules.BUILTIN_WS, leafNode.getGrammarElement());
		assertEquals(ITokenTypes.WHITESPACE, leafNode.tokenType());
	}
	
}
