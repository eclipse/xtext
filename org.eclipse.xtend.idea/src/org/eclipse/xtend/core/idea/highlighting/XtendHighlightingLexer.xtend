/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.highlighting

import com.google.inject.Inject
import com.intellij.lexer.LexerBase
import com.intellij.lexer.LexerPosition
import com.intellij.psi.tree.IElementType
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles
import org.eclipse.xtext.idea.parser.AntlrDelegatingIdeaLexer
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendHighlightingLexer extends LexerBase {

	protected static class RichTextToken {
		int index = 0
		int[] offsets
		int[] lengths
		boolean delimiter
		IElementType tokenType

		def getTokenLength() {
			lengths.get(index)
		}

		def getTokenOffset() {
			offsets.get(index)
		}

		def hasNext() {
			index < offsets.length - 1
		}

		def advance() {
			index++;
			delimiter = !delimiter
		}

		def getTokenType() {
			if (delimiter)
				GUILLEMET_ELEMENT_TYPE
			else
				tokenType
		}

		def getType() {
			if (delimiter)
				GUILLEMET_ELEMENT_TYPE.index
			else
				tokenType.index
		}
	}

	public static val GUILLEMET_ELEMENT_TYPE = new IElementType(XtendHighlightingStyles.RICH_TEXT_DELIMITER_ID,
		XtendLanguage.INSTANCE)

	static val TOKEN_TYPE_NAMES_CONTAINING_GUILLEMETS = #{
		'RULE_RICH_TEXT_START',
		'RULE_RICH_TEXT_END',
		'RULE_RICH_TEXT_INBETWEEN',
		'RULE_COMMENT_RICH_TEXT_INBETWEEN',
		'RULE_COMMENT_RICH_TEXT_END'
	}

	@Inject AntlrDelegatingIdeaLexer delegate

	@Inject extension AntlrTokenDefProvider

	RichTextToken _currentRichTextToken
	

	override advance() {
		if (currentRichTextToken?.hasNext) {
			currentRichTextToken.advance
		} else {
			_currentRichTextToken = null
			delegate.advance
		}
	}
	
	def getCurrentRichTextToken() {
		if(_currentRichTextToken == null) {
			if(delegate.currentToken != null) {
				val tokenID = tokenDefMap.get(delegate.currentToken.type)
				if (TOKEN_TYPE_NAMES_CONTAINING_GUILLEMETS.contains(tokenID))
					_currentRichTextToken = createRichTextToken(tokenID, delegate.tokenStart,
						delegate.tokenEnd - delegate.tokenStart, delegate.tokenType)
			}
		}
		return _currentRichTextToken
	}

	override getState() {
		return if (_currentRichTextToken === null) 0 else 1
	}

	override getTokenEnd() {
		if (currentRichTextToken != null)
			currentRichTextToken.tokenOffset + currentRichTextToken.tokenLength
		else
			delegate.tokenEnd
	}

	override getTokenStart() {
		if (currentRichTextToken != null)
			currentRichTextToken.tokenOffset
		else
			delegate.tokenStart
	}

	override getTokenType() {
		if (currentRichTextToken != null)
			currentRichTextToken.getTokenType
		else
			delegate.tokenType
	}

	override start(CharSequence buffer, int startOffset, int endOffset, int initialState) {
		delegate.start(buffer, startOffset, endOffset, initialState)
		_currentRichTextToken = null
	}

	override getBufferEnd() {
		delegate.bufferEnd
	}

	override getBufferSequence() {
		delegate.bufferSequence
	}

	override restore(LexerPosition position) {
		throw new UnsupportedOperationException()
	}

	protected def RichTextToken createRichTextToken(String id, int tokenOffset, int tokenLength, IElementType tokenType) {
		val result = new RichTextToken => [
			it.tokenType = tokenType
		]
		switch id {
			case 'RULE_RICH_TEXT_START': {
				result.delimiter = false
				result.offsets = #[tokenOffset, tokenOffset + tokenLength - 1]
				result.lengths = #[tokenLength - 1, 1]
			}
			case 'RULE_RICH_TEXT_INBETWEEN': {
				result.delimiter = true
				if (tokenLength == 2) {
					result.offsets = #[tokenOffset]
					result.lengths = #[tokenLength]
				} else {
					result.offsets = #[tokenOffset, tokenOffset + 1, tokenOffset + tokenLength - 1]
					result.lengths = #[1, tokenLength - 2, 1]
				}
			}
			case 'RULE_RICH_TEXT_END': {
				result.delimiter = true
				result.offsets = #[tokenOffset, tokenOffset + 1]
				result.lengths = #[1, tokenLength - 1]
			}
			case 'RULE_COMMENT_RICH_TEXT_END': {
				result.delimiter = true
				result.offsets = #[tokenOffset, tokenOffset + 2]
				result.lengths = #[2, tokenLength - 2]
			}
			case 'RULE_COMMENT_RICH_TEXT_INBETWEEN': {
				result.delimiter = true
				result.offsets = #[tokenOffset, tokenOffset + 2, tokenOffset + tokenLength - 1]
				result.lengths = #[2, tokenLength - 3, 1]
			}
			default:
				throw new IllegalArgumentException(id)
		}
		return result;
	}

}