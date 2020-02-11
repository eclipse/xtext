/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;

/**
 * A token stream that is aware of the current lookahead.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Support for dynamic hidden tokens,
 *   reworked lookahead algorithm
 */
public class XtextTokenStream extends CommonTokenStream {

	private int currentLookAhead;
	
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
	
	@Override
	public String toString(int start, int stop) {
		if ( start<0 || stop<0 ) {
			return null;
		}
		if ( p == -1 ) {
			fillBuffer();
		}
		if ( stop>=tokens.size() ) {
			stop = tokens.size()-1;
		}
		if (tokenSource instanceof Lexer) {
			Token startToken = (Token) tokens.get(start);
			Token stopToken = (Token) tokens.get(stop);
			if (startToken instanceof CommonToken && stopToken instanceof CommonToken) {
				CommonToken commonStart = (CommonToken) startToken;
				CommonToken commonStop = (CommonToken) stopToken;
				CharStream charStream = ((Lexer) tokenSource).getCharStream();
				String result = charStream.substring(commonStart.getStartIndex(), commonStop.getStopIndex());
				return result;
			}
		}
		// fall back to super implementation but use StringBuilder instead of StringBuffer
		// and use reasonable initialization size
 		StringBuilder result = new StringBuilder(Math.max(1024, tokens.size() * 6));
		for (int i = start; i <= stop; i++) {
			Token t = (Token)tokens.get(i);
			result.append(t.getText());
		}
		return result.toString();
	}
	
	@SuppressWarnings({ "serial" })
	private final class TokenList extends ArrayList<Object> {
		private TokenList(int initialCapacity) {
			super(initialCapacity);
		}

		@Override
		public Object get(int index) {
			Token tok = (Token) super.get(index);
			// adjust only tokens in the 'future', as we wont change the channel of previously parsed
			// tokens
			int current = p;
			if (firstMarker != -1)
				current = firstMarker;
			if (hiddenTokens != null && tok.getType() >= Token.MIN_TOKEN_TYPE && index >= current)
				tok.setChannel(hiddenTokens.get(tok.getType()) ? Token.HIDDEN_CHANNEL : Token.DEFAULT_CHANNEL);
			return tok;
		}
		
		@Override
		public void clear() {
			if (isEmpty())
				return;
			super.clear();
		}
	}

	public interface HiddenTokens {
		void restore();
	}
	
	public HiddenTokens setHiddenTokens(String... lexerRules) {
		skipHiddenTokens();
		HiddenTokens result = new MyHiddenTokens(hiddenTokens);
		doSetHiddenTokens(lexerRules);
		return result;
	}
	
	public void setInitialHiddenTokens(String... lexerRules) {
		doSetHiddenTokens(lexerRules);
	}

	protected void doSetHiddenTokens(String... lexerRules) {
		BitSet newHiddens = new BitSet();
		for(String lexerRule: lexerRules) {
			Integer idxObj = rulenameToTokenType.get(lexerRule);
			if (idxObj != null) {
				newHiddens.set(idxObj.intValue());
			} else {
				throw new IllegalStateException("unknown rule: " + lexerRule + 
						" - the rule seems to be hidden by a keyword.");
			}
		}
		hiddenTokens = newHiddens;
	}

	protected void skipHiddenTokens() {
		if (hiddenTokens == null || hiddenTokens.isEmpty())
			return;
		Token token = LT(1);
		while(token.getChannel() == Token.HIDDEN_CHANNEL) {
			p++;
			token = LT(1);
		}
	}
	
	private class MyHiddenTokens implements HiddenTokens {

		private final BitSet prev;
		
		private MyHiddenTokens(BitSet prev) {
			this. prev = prev;
		}
		@Override
		public void restore() {
			skipHiddenTokens();
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
		if (firstMarker != -1) {
			int currentLookAheadIsRelativeTo = Math.min(firstMarker, p);
			int totalLA = p + i - currentLookAheadIsRelativeTo;
			currentLookAhead = Math.max(totalLA, currentLookAhead);
		} else {
			currentLookAhead = Math.max(i, currentLookAhead);
		}
		// return super.LA(i); // inlined
		return lookaheadToken.getType();
	}
	
	private int firstMarker = -1;
	
	@Override
	public void consume() {
		if (firstMarker != -1) { // predicting
			int currentLookAheadIsRelativeTo = Math.min(firstMarker, p);
			currentLookAhead = Math.max(currentLookAhead, p - currentLookAheadIsRelativeTo);
			super.consume();
		} else { // producing
			super.consume();
			currentLookAhead--;
		}
	}
	
	/**
	 * @since 2.1
	 */
	protected int getFirstMarker() {
		return firstMarker;
	}
	
	@Override
	public int mark() {
		int result = super.mark();
		if (firstMarker == -1)
			firstMarker = result;
		return result;
	}
	
	@Override
	public void seek(int index) {
		if (index == firstMarker)
			firstMarker = -1;
		super.seek(index);
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

	public int getCurrentLookAhead() {
		return currentLookAhead;  
	}
	
	public void initCurrentLookAhead(int currentLookAhead) {
		this.currentLookAhead = currentLookAhead;
	}

	public String getLexerErrorMessage(Token invalidToken) {
		if (tokenSource instanceof org.eclipse.xtext.parser.antlr.Lexer) {
			return ((org.eclipse.xtext.parser.antlr.Lexer) tokenSource).getErrorMessage(invalidToken);
		}
		return (invalidToken.getType() == Token.INVALID_TOKEN_TYPE) ? "Invalid token " + invalidToken.getText() : null;
	}

}
