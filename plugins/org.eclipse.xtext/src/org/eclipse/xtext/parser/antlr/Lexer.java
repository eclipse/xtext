/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.apache.log4j.Logger;

/**
 * Hack: As AntLR does not allow to define the superclass of the generated
 * lexer, we call this class Lexer and import it to be used instead of the
 * original lexer class.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public abstract class Lexer extends org.antlr.runtime.Lexer {

	private static final Logger logger = Logger.getLogger(Lexer.class);
	
	public Lexer() {
		super();
	}

	public Lexer(CharStream input) {
		super(input);
	}

	private final Map<Token, String> tokenErrorMap = new HashMap<Token, String>();

	@Override
	public Token nextToken() {
		while (true) {
			this.token = null;
			this.channel = Token.DEFAULT_CHANNEL;
			this.tokenStartCharIndex = input.index();
			this.tokenStartCharPositionInLine = input.getCharPositionInLine();
			this.tokenStartLine = input.getLine();
			this.text = null;
			if (input.LA(1) == CharStream.EOF) {
				return Token.EOF_TOKEN;
			}
			try {
				mTokens();
				if (this.token == null) {
					emit();
				}
				else if (this.token == Token.SKIP_TOKEN) {
					continue;
				}
				return this.token;
			}
			catch (RecognitionException re) {
				reportError(re);
				if (re instanceof NoViableAltException) {
					recover(re);
				}
				// create token that holds mismatched char
				Token t = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.HIDDEN_CHANNEL,
						this.tokenStartCharIndex, getCharIndex() - 1);
				t.setLine(this.tokenStartLine);
				t.setCharPositionInLine(this.tokenStartCharPositionInLine);
				tokenErrorMap.put(t, getErrorMessage(re, this.getTokenNames()));
				emit(t);
				return this.token;
			}
		}
	}

	public String getErrorMessage(Token t) {
		return tokenErrorMap.get(t);
	}
	
	@Override
	public void emitErrorMessage(String msg) {
		// don't call super, since it would do a plain vanilla
		// System.err.println(msg);
		if (logger.isTraceEnabled())
			logger.trace(msg);
	}
	
	@Override
	public void recoverFromMismatchedToken(IntStream in, RecognitionException re, int ttype, BitSet follow)
			throws RecognitionException {
		// inlined super call because we want to get rid of the System.err.println(..)
		// System.err.println("BR.recoverFromMismatchedToken");
		// if next token is what we are looking for then "delete" this token
		if ( input.LA(2)==ttype ) {
			reportError(re);
			/*
			System.err.println("recoverFromMismatchedToken deleting "+input.LT(1)+
							   " since "+input.LT(2)+" is what we want");
			*/
			beginResync();
			input.consume(); // simply delete extra token
			endResync();
			input.consume(); // move past ttype token as if all were ok
			return;
		}
		if ( !recoverFromMismatchedElement(input, re,follow) ) {
			throw re;
		}
	}
}
