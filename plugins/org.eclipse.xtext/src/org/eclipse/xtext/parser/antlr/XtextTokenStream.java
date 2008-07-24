/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;

/**
 * A token stream that is aware of the current lookahead.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public class XtextTokenStream extends CommonTokenStream {

	private List<Token> lookaheadTokens = new ArrayList<Token>();

//	private Map<Token, String> tokenErrorMap = new HashMap<Token, String>();

	public XtextTokenStream() {
		super();
	}

	public XtextTokenStream(TokenSource tokenSource, int channel) {
		super(tokenSource, channel);
	}

	public XtextTokenStream(TokenSource tokenSource) {
		super(tokenSource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.CommonTokenStream#LA(int)
	 */
	@Override
	public int LA(int i) {
		Token lookaheadToken = LT(i);
		if (!lookaheadTokens.contains(lookaheadToken)) {
			lookaheadTokens.add(lookaheadToken);
		}
		return super.LA(i);
	}

	/**
	 * @return the lookaheadTokens
	 */
	public List<Token> getLookaheadTokens() {
		return lookaheadTokens;
	}

	public void removeLastLookaheadToken() {
		lookaheadTokens.remove(lookaheadTokens.size() - 1);
	}

	public void resetLookahead() {
		lookaheadTokens.clear();
	}

	public String getLexerErrorMessage(Token invalidToken) {
		if (tokenSource instanceof org.eclipse.xtext.parser.antlr.Lexer) {
			return ((org.eclipse.xtext.parser.antlr.Lexer) tokenSource).getErrorMessage(invalidToken);
		}
		return (invalidToken.getType() == Token.INVALID_TOKEN_TYPE) ? "Invalid token " + invalidToken.getText() : null;
	}

}
