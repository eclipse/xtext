/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.parser

import com.google.inject.Inject
import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import org.antlr.runtime.CommonToken
import org.antlr.runtime.Token
import org.antlr.runtime.TokenSource
import org.eclipse.xtext.parser.antlr.TokenSourceProvider

class AntlrDelegatingIdeaLexer extends LexerBase {

	TokenSource tokenSource
	CommonToken token

	CharSequence buffer
	int startOffset
	int endOffset

	@Inject
	TokenTypeProvider tokenTypeProvider

	@Inject
	TokenSourceProvider tokenSourceProvider

	override void start(CharSequence buffer, int startOffset, int endOffset, int initialState) {
		this.buffer = buffer
		this.startOffset = startOffset
		this.endOffset = endOffset

		val text = buffer.subSequence(startOffset, endOffset)
		tokenSource = tokenSourceProvider.createTokenSource(text)
		token = null
	}

	override int getState() {
		return 0
	}

	override IElementType getTokenType() {
		locateToken
		if (token == null) {
			return null
		}
		val int type = token.getType();
		return tokenTypeProvider.getIElementType(type);
	}

	override int getTokenStart() {
		locateToken
		return startOffset + token.startIndex
	}

	override int getTokenEnd() {
		locateToken
		return startOffset + token.stopIndex + 1
	}

	override void advance() {
		locateToken();
		token = null;
	}

	override CharSequence getBufferSequence() {
		buffer
	}

	override int getBufferEnd() {
		endOffset
	}
	
	def getCurrentToken() {
		locateToken()
		token
	}

	def void locateToken() {
		if (token == null) {
			try {
				token = tokenSource.nextToken as CommonToken
			} catch (Exception e) {

				// FIXME: throw an exception or log
				e.printStackTrace()
			}
			if (token == Token.EOF_TOKEN) {
				token = null
			}
		}
	}
}
