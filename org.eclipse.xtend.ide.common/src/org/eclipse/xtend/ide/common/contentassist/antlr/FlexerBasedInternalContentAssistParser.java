/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.contentassist.antlr;

import java.util.Map;

import org.antlr.runtime.Token;
import org.eclipse.xtend.ide.common.contentassist.antlr.internal.InternalXtendParser;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.ide.editor.contentassist.antlr.LookAheadTerminal;
import org.eclipse.xtext.ide.editor.contentassist.antlr.LookAheadTerminalRuleCall;
import org.eclipse.xtext.ide.editor.contentassist.antlr.LookaheadKeyword;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FlexerBasedInternalContentAssistParser extends InternalXtendParser {

	private final ITokenDefProvider tokenDefProvider;

	public FlexerBasedInternalContentAssistParser(ITokenDefProvider tokenDefProvider) {
		super(null);
		this.tokenDefProvider = tokenDefProvider;
	}
	
	@Override
	protected String getValueForTokenName(String tokenName) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public LookAheadTerminal createLookAheadTerminal(Token token) {
		Grammar grammar = getGrammar();
		String tokenName = getTokenDefMap().get(token.getType());
		if (tokenName.charAt(0) == '\'') {
			LookaheadKeyword result = new LookaheadKeyword();
			result.setKeyword(tokenName.substring(1, tokenName.length() - 1));
			result.setToken(token);
			return result;
		}
		LookAheadTerminalRuleCall result = new LookAheadTerminalRuleCall();
		result.setToken(token);
		String ruleName = tokenName.substring(5);
		if (terminalRules == null)
			terminalRules = GrammarUtil.allTerminalRules(grammar);
		for (TerminalRule rule : terminalRules) {
			if (rule.getName().equalsIgnoreCase(ruleName)) {
				result.setRule(rule);
				return result;
			}
		}
		throw new IllegalArgumentException("tokenType " + token.getType() + " seems to be invalid.");
	}
	
	@Override
	public Map<Integer, String> getTokenDefMap() {
		return tokenDefProvider.getTokenDefMap();
	}

}
