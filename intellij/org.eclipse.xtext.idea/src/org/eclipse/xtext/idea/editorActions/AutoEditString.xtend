/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.psi.tree.TokenSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.TextRegion

import static extension com.intellij.openapi.editor.EditorModificationUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class AutoEditString extends AbstractAutoEditBlock {

	val TokenSet stringLiteralTokens
	
	new(String quote, TokenSet stringLiteralTokens) {
		this(quote, quote, stringLiteralTokens)
	}

	new(String openingTerminal, String closingTerminal, TokenSet stringLiteralTokens) {
		super(openingTerminal, closingTerminal)
		shouldDeleteClosing = true
		this.stringLiteralTokens = stringLiteralTokens
	}

	override open(char c, extension AutoEditContext context) {
		val newCaretOffset = type(c)
		if (shouldInsertClosingQuote(newCaretOffset, context))
			document.insertString(newCaretOffset, closingTerminal)
	}

	override close(char c, extension AutoEditContext context) {
		val stringRegion = caretOffset.findRegion(context)
		if (stringRegion == null)
			return false

		if (stringRegion.closingTerminal == null)
			type(c)
		else if (stringRegion.closingTerminal.contains(caretOffset))
			editor.moveCaretRelatively(1)
		else
			type(c)

		return true
	}

	protected def AutoEditStringRegion findRegion(int offset, extension AutoEditContext context) {
		val openingTerminal = offset.findOpeningTerminal(context)
		if (openingTerminal == null)
			return null

		val closingTerminal = offset.findClosingTerminal(openingTerminal.offset, context)
		if (closingTerminal != null) {
			if (openingTerminal.offset >= offset)
				return null
			if (closingTerminal.offset + closingTerminal.length <= offset)
				return null
		}

		return new AutoEditStringRegion(openingTerminal, closingTerminal)
	}

	protected def TextRegion findOpeningTerminal(
		int offset,
		extension AutoEditContext context
	) {
		val iterator = offset.createTokenIterator
		if (!iterator.isStringLiteral(context))
			return null

		while (!iterator.atEnd) {
			val openingTerminal = iterator.getOpeningTerminal(context)
			if (openingTerminal != null)
				return openingTerminal

			iterator.retreat
		}
		null
	}

	protected def TextRegion findClosingTerminal(
		int offset,
		int openingTokenOffset,
		extension AutoEditContext context
	) {
		val iterator = offset.createTokenIterator
		if (!iterator.isStringLiteral(context))
			return null

		while (!iterator.atEnd) {
			val closingTerminal = iterator.getClosingTerminal(openingTokenOffset, context)
			if (closingTerminal != null)
				return closingTerminal

			iterator.advance
		}
		null
	}

	protected def TextRegion getOpeningTerminal(
		HighlighterIterator iterator,
		extension AutoEditContext context
	) {
		if (iterator == null)
			return null

		if (iterator.end - iterator.start < openingTerminal.length)
			return null

		if (getText(iterator.start, iterator.start + openingTerminal.length) != openingTerminal)
			return null

		return new TextRegion(iterator.start, openingTerminal.length)
	}

	protected def TextRegion getClosingTerminal(
		HighlighterIterator iterator,
		int openingTokenOffset,
		extension AutoEditContext context
	) {
		if (iterator == null)
			return null

		if (iterator.end - openingTokenOffset < openingTerminal.length + closingTerminal.length)
			return null

		if (getText(iterator.end - closingTerminal.length, iterator.end) != closingTerminal)
			return null

		return new TextRegion(iterator.end - closingTerminal.length, closingTerminal.length)
	}

	protected def boolean shouldInsertClosingQuote(int offset, extension AutoEditContext context) {
		return !offset.identifierPart
	}

	protected def isStringLiteral(HighlighterIterator iterator, extension AutoEditContext context) {
		if (iterator.atEnd)
			return false

		iterator.tokenSet.isStringLiteral(context)
	}

	protected def isStringLiteral(TokenSet tokenSet, extension AutoEditContext context) {
		tokenSet == stringLiteralTokens
	}

}

@Accessors
@FinalFieldsConstructor
class AutoEditStringRegion {
	val TextRegion openingTerminal
	val TextRegion closingTerminal
}