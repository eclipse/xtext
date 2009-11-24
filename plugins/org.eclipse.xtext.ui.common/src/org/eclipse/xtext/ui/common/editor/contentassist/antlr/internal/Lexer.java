/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class Lexer extends org.antlr.runtime.Lexer {

	private static final Logger logger = Logger.getLogger(Lexer.class);
	
	protected Lexer(CharStream input) {
		super(input);
	}

	protected Lexer() {
		super();
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
