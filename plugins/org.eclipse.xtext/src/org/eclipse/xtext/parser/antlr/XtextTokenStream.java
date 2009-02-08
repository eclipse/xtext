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
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	private Map<String, Integer> rulenameToTokenType;
	
	private BitSet hiddenTokens;

	public XtextTokenStream() {
		super();
		tokens = new TokenList(500);
	}

	public XtextTokenStream(TokenSource tokenSource, int channel) {
		super(tokenSource, channel);
		tokens = new TokenList(500);
	}

	public XtextTokenStream(TokenSource tokenSource, ITokenDefProvider tokenDefProvider) {
		super(tokenSource);
		tokens = new TokenList(500);
		rulenameToTokenType = new HashMap<String, Integer>(tokenDefProvider.getTokenDefMap().size());
		for(Map.Entry<Integer, String> entry: tokenDefProvider.getTokenDefMap().entrySet()) {
			rulenameToTokenType.put(entry.getValue(), entry.getKey());
		}
	}
	
	@SuppressWarnings({ "serial", "unchecked" })
	private final class TokenList extends ArrayList {
		private TokenList(int initialCapacity) {
			super(initialCapacity);
		}

		@Override
		public Object get(int index) {
			Token tok = (Token) super.get(index);
			// adjust only tokens in the 'future', as we wont change the channel of previously parsed
			// tokens
			if (hiddenTokens != null && tok.getType() >= Token.MIN_TOKEN_TYPE && index >= p)
				tok.setChannel(hiddenTokens.get(tok.getType()) ? Token.HIDDEN_CHANNEL : Token.DEFAULT_CHANNEL);
			return tok;
		}
	}

	public interface HiddenTokens {
		void restore();
	}
	
	public HiddenTokens setHiddenTokens(String... lexerRules) {
		HiddenTokens result = new MyHiddenTokens(hiddenTokens);
		BitSet newHiddens = new BitSet();
		for(String lexerRule: lexerRules) {
			int idx = rulenameToTokenType.get(lexerRule);
			newHiddens.set(idx);
		}
		hiddenTokens = newHiddens;
		return result;
	}
	
	public void setInitialHiddenTokens(String... lexerRules) {
		BitSet newHiddens = new BitSet();
		for(String lexerRule: lexerRules) {
			int idx = rulenameToTokenType.get(lexerRule);
			newHiddens.set(idx);
		}
		hiddenTokens = newHiddens;
	}

	private class MyHiddenTokens implements HiddenTokens {

		private final BitSet prev;
		
		private MyHiddenTokens(BitSet prev) {
			this. prev = prev;
		}
		public void restore() {
			XtextTokenStream.this.hiddenTokens = prev;
		}
		
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
		// return super.LA(i); // inlined 
		return lookaheadToken.getType();
	}

	/**
	 * Same as {@link CommonTokenStream#LT(int)} except that we skip
	 * hidden tokens even for <code>k == 1<code>.
	 */
	@Override
	public Token LT(int k) {
		Token result = super.LT(k);
        if (k == 1 && result.getChannel()!=channel) {
        	// copied from super.LT(k) except from the last assignment to p
        	int k_ = k + 1;
        	if ( (p+k_-1) >= tokens.size() ) {
    			return Token.EOF_TOKEN;
    		}
    		int i = p;
    		int n = 1;
    		// find k good tokens
    		while ( n<k_ ) {
    			// skip off-channel tokens
    			i = skipOffTokenChannels(i+1); // leave p to a valid pointer
    										   // SZ: prev. comment from superclass
    										   // is irritating because p is not set
    										   // in skipOffTokenChannels(...)
    			n++;
    		}
    		if ( i>=tokens.size() ) {
    			return Token.EOF_TOKEN;
    		}
    		p = i; // adjust p to the valid pointer
            result = (Token)tokens.get(i);
        }
        return result;
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
