/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.intellij.psi.tree.TokenSet

import static extension com.intellij.openapi.editor.EditorModificationUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class AutoEditString extends AbstractAutoEditBlock {

	new(String quote) {
		this(quote, quote)
	}

	new(String openingTerminal, String closingTerminal) {
		super(openingTerminal, closingTerminal)
		shouldDeleteClosing = true
	}

	override open(char c, extension AutoEditContext context) {
		type(c)
	}

	override close(char c, extension AutoEditContext context) {
		if (isStringLiteral(caretOffset, context)) {
			if (isAtTerminal(closingTerminal, context)) {
				editor.moveCaretRelatively(1)
				return true
			}
			return false
		}
		if (shouldInsertClosingQuote(context)) {
			val offset = type(c)
			document.insertString(offset, closingTerminal)
			return true
		}
		return false
	}

	protected def boolean shouldInsertClosingQuote(extension AutoEditContext context) {
		if (caretOffset.identifierPart)
			return false

		if (openingTerminal == closingTerminal && document.text.count(openingTerminal) % 2 != 0)
			return false

		return true
	}

	protected def isStringLiteral(int offset, extension AutoEditContext context) {
		if (offset == 0 || document.textLength == offset)
			return false
		offset.tokenSet.isStringLiteral(context)
	}

	protected def isStringLiteral(TokenSet tokenSet, extension AutoEditContext context) {
		tokenSet == stringLiteralTokens
	}

	protected def isAtTerminal(String terminal, extension AutoEditContext context) {
		val terminalLength = terminal.length

		val caretOffset = caretOffset
		val iterator = caretOffset.createTokenIterator
		if (iterator.atEnd)
			return false

		val start = iterator.start
		val end = iterator.end
		if (end - start < terminalLength)
			return false

		if (end == caretOffset)
			return false

		val caretShift = terminalLength - (end - caretOffset)
		val beginOffset = if (caretShift > 0) {
				caretOffset - caretShift
			} else
				caretOffset

		return getText(beginOffset, beginOffset + terminalLength) == terminal
	}

}