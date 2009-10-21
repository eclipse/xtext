/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.ui.common.editor.contentassist.ProposalConflictHelper;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrProposalConflictHelper extends ProposalConflictHelper {

	@Inject
	@Named(LexerBindings.RUNTIME)
	private Lexer proposalLexer;

	@Inject
	@Named(LexerBindings.RUNTIME)
	private Lexer lastCompleteLexer;
	
	@Inject
	@Named(LexerBindings.RUNTIME)
	private Lexer combinedLexer;

	@Override
	public boolean existsConflict(String lastCompleteText, String proposal) {
		initTokenSources(lastCompleteText, proposal);
		if (!equalTokenSequence(getLastCompleteLexer(), getCombinedLexer()))
			return true;
		if (!equalTokenSequence(getProposalLexer(), getCombinedLexer()))
			return true;
		Token lastToken = getProposalLexer().nextToken();
		if (!lastToken.equals(Token.EOF_TOKEN))
			return true;
		return false;
	}

	protected boolean equalTokenSequence(TokenSource first, TokenSource second) {
		Token token = null;
		while(!(token = first.nextToken()).equals(Token.EOF_TOKEN)) {
			Token otherToken = second.nextToken();
			if (otherToken.equals(Token.EOF_TOKEN)) {
				return false;
			}
			if (!token.getText().equals(otherToken.getText())) {
				return false;
			}
		}
		return true;
	}
	
	protected void initTokenSources(String lastCompleteText, String proposal) {
		String combinedText = lastCompleteText.concat(proposal);
		initTokenSource(combinedText, getCombinedLexer());
		initTokenSource(lastCompleteText, getLastCompleteLexer());
		initTokenSource(proposal, getProposalLexer());
	}

	protected void initTokenSource(String text, TokenSource tokenSource) {
		Lexer lexer = (Lexer) tokenSource;
		CharStream stream = new ANTLRStringStream(text);
		lexer.setCharStream(stream);
	}

	public TokenSource getProposalLexer() {
		return proposalLexer;
	}

	public void setProposalLexer(Lexer proposalLexer) {
		this.proposalLexer = proposalLexer;
	}

	public TokenSource getCombinedLexer() {
		return combinedLexer;
	}

	public void setCombinedLexer(Lexer combinedLexer) {
		this.combinedLexer = combinedLexer;
	}

	public void setLastCompleteLexer(Lexer lastCompleteLexer) {
		this.lastCompleteLexer = lastCompleteLexer;
	}

	public TokenSource getLastCompleteLexer() {
		return lastCompleteLexer;
	}

}
