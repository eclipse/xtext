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
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.common.editor.contentassist.ProposalConflictHelper;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrProposalConflictHelper extends ProposalConflictHelper {

	@Inject
	private Lexer proposalLexer;

	@Inject
	private Lexer lastCompleteLexer;
	
	@Inject
	private Lexer combinedLexer;

	@Override
	public boolean existsConflict(String lastCompleteText, String proposal) {
		initLexer(lastCompleteText, proposal);
		if (!equalTokenSequence(lastCompleteLexer, combinedLexer))
			return true;
		if (!equalTokenSequence(proposalLexer, combinedLexer))
			return true;
		Token lastToken = proposalLexer.nextToken();
		if (!lastToken.equals(Token.EOF_TOKEN))
			return true;
		return false;
	}

	protected boolean equalTokenSequence(Lexer first, Lexer second) {
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
	
	protected void initLexer(String lastCompleteText, String proposal) {
		String combinedText = lastCompleteText.concat(proposal);
		initLexer(combinedText, combinedLexer);
		initLexer(lastCompleteText, lastCompleteLexer);
		initLexer(proposal, proposalLexer);
	}

	protected void initLexer(String text, Lexer lexer) {
		CharStream stream = new ANTLRStringStream(text);
		lexer.setCharStream(stream);
	}

	public Lexer getProposalLexer() {
		return proposalLexer;
	}

	public void setProposalLexer(Lexer proposalLexer) {
		this.proposalLexer = proposalLexer;
	}

	public Lexer getCombinedLexer() {
		return combinedLexer;
	}

	public void setCombinedLexer(Lexer combinedLexer) {
		this.combinedLexer = combinedLexer;
	}

	public void setLastCompleteLexer(Lexer lastCompleteLexer) {
		this.lastCompleteLexer = lastCompleteLexer;
	}

	public Lexer getLastCompleteLexer() {
		return lastCompleteLexer;
	}

}
