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
	}

	override int getState() {
		return if(token != null) token.type else 0
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
