/*******************************************************************************
 * Copyright (c) 2010 Ralf Ebert and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.indent;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.parser.antlr.ITokenAcceptor;
import org.eclipse.xtext.testlanguages.indent.parser.antlr.internal.InternalIndentationAwareTestLanguageLexer;

/**
 * IndentTokenSource yields additional BEGIN / END tokens for (\n+ \t*) NL
 * tokens whenever the amount of tabs (indentation) changes.
 */
public class IndentTokenSource extends AbstractSplittingTokenSource {

	private int level;

	@Override
	protected boolean shouldSplitToken(Token token) {
		return token.getType() == InternalIndentationAwareTestLanguageLexer.RULE_NL || token.getType() == Token.EOF;
	}

	@Override
	protected void doSplitToken(Token token, ITokenAcceptor result) {
		int nextLevel = (token.getType() == Token.EOF) ? 0 : countTabs(token.getText());
		while (this.level > nextLevel) {
			this.level--;
			result.accept(new CommonToken(InternalIndentationAwareTestLanguageLexer.RULE_END, ""));
		}
		result.accept(token);
		while (this.level < nextLevel) {
			this.level++;
			result.accept(new CommonToken(InternalIndentationAwareTestLanguageLexer.RULE_BEGIN, ""));
		}
	}

	private int countTabs(String text) {
		int firstTab = text.indexOf("\t");
		return (firstTab == -1) ? 0 : text.length() - firstTab;
	}
}
