/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.TextRegion

import static extension com.intellij.openapi.editor.EditorModificationUtil.*
import static extension java.lang.Character.*
import static extension org.eclipse.xtext.util.Strings.*

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
class AutoEditMultiLineBlock extends AbstractIndentableAutoEditBlock {

	new(String openingTerminal, String closingTerminal) {
		super(openingTerminal, closingTerminal)
	}

	new(String openingTerminal, String closingTerminal, boolean nested) {
		super(openingTerminal, null, closingTerminal, nested)
	}

	new(String openingTerminal, String indentationTerminal, String closingTerminal) {
		super(openingTerminal, indentationTerminal, closingTerminal, false)
	}

	new(String openingTerminal, String indentationTerminal, String closingTerminal, boolean nested) {
		super(openingTerminal, indentationTerminal, closingTerminal, nested)
	}

	override findRegion(extension AutoEditContext context) {
		caretOffset.findRegion(context)
	}

	protected def findRegion(int offset, extension AutoEditContext context) {
		val openingTerminal = findOpeningTerminal(offset, context)
		if (openingTerminal == null)
			return null

		var closingTerminal = findClosingTerminal(offset, context)
		if (closingTerminal != -1 && nested) {
			var previousOpeningTerminal = openingTerminal
			var previousClosingTerminal = closingTerminal
			while (closingTerminal != null && previousOpeningTerminal != null && previousClosingTerminal != null) {
				previousOpeningTerminal = findOpeningTerminal(previousOpeningTerminal.offset, context)
				if (previousOpeningTerminal != null) {
					previousClosingTerminal = findClosingTerminal(previousClosingTerminal.offset + 1, context)
					if (previousClosingTerminal == null)
						closingTerminal = null
				}
			}
		}
		return new AutoEditBlockRegion(this, openingTerminal, closingTerminal)
	}

	protected def TextRegion findOpeningTerminal(int offset, extension AutoEditContext context) {
		val text = editor.document.text

		var leftOffset = offset
		var rightOffset = offset
		while (true) {
			val openingTerminal = text.searchBackward(this.openingTerminal, leftOffset, context)
			if (openingTerminal == null)
				return null
			val closingTerminal = text.searchBackward(this.closingTerminal, rightOffset, context)
			if (closingTerminal == null || closingTerminal.offset < openingTerminal.offset)
				return openingTerminal

			leftOffset = openingTerminal.offset
			rightOffset = closingTerminal.offset
		}
	}

	protected def findClosingTerminal(int offset, extension AutoEditContext context) {
		val text = editor.document.text

		var leftOffset = offset
		var rightOffset = offset
		while (true) {
			val closingTerminal = text.searchForward(this.closingTerminal, rightOffset, context)
			if (closingTerminal == null)
				return null
			val openingTerminal = text.searchForward(this.openingTerminal, leftOffset, context)
			if (openingTerminal == null || openingTerminal.offset > closingTerminal.offset)
				return closingTerminal

			rightOffset = findNextOffset(rightOffset, closingTerminal.offset + closingTerminal.length, context)
			leftOffset = findNextOffset(leftOffset, openingTerminal.offset + openingTerminal.length, context)
		}
	}

	protected def int findNextOffset(
		int currentOffset,
		int nextOffset,
		extension AutoEditContext context
	) {
		val tokenSet = currentOffset.tokenSet
		val iterator = nextOffset.createTokenIterator
		var offset = nextOffset
		while (!iterator.atEnd) {
			if (tokenSet == iterator.tokenSet)
				return offset
			if (iterator.end != document.textLength) {
				iterator.advance
				offset = iterator.start
			}
		}
		return offset
	}

	protected def TextRegion searchForward(
		String text,
		String toFind,
		int startOffset,
		extension AutoEditContext context
	) {
		val length = toFind.length
		val tokenSet = startOffset.tokenSet
		var index = text.indexOf(toFind, startOffset)
		while (index >= 0 && index < text.length) {
			if (index.tokenSet == tokenSet)
				return new TextRegion(index, toFind.length)
			index = text.indexOf(toFind, index + length)
		}
		val trimmed = toFind.trim
		if (!trimmed.empty && trimmed.length != toFind.length)
			return text.searchForward(trimmed, startOffset, context)
		return null
	}

	protected def TextRegion searchBackward(
		String text,
		String toFind,
		int endOffset,
		extension AutoEditContext context
	) {
		val length = toFind.length
		val tokenSet = endOffset.tokenSet
		var index = text.lastIndexOf(toFind, endOffset - length)
		while (index >= 0) {
			if (index.tokenSet == tokenSet)
				return new TextRegion(index, toFind.length)
			index = text.lastIndexOf(toFind, index - length)
		}
		val trimmed = toFind.trim
		if (!trimmed.empty && trimmed.length != toFind.length)
			return text.searchBackward(trimmed, endOffset, context)
		return null
	}

	override indent(AutoEditBlockRegion region, String previousLineIndentation, extension AutoEditContext context) {
		val caretOffset = caretOffset
		if (region.openingTerminal.offset.isSameLine(caretOffset)) {
			val closingTerminal = region.getClosingTerminal(context)
			if (closingTerminal == null) {
				close(previousLineIndentation, context)
			} else if (closingTerminal.offset.isSameLine(caretOffset) && closingTerminal.offset >= caretOffset) {
				val text = getText(caretOffset, closingTerminal.offset).trim
				document.replaceString(caretOffset, closingTerminal.offset, text + previousLineIndentation.newLine)
			}
			return indentationTerminal
		}

		if (region.closingTerminal == null) {
			close(previousLineIndentation, context)
			return ''
		}

		return indentationTerminal.removeLeadingWhitespace
	}

	protected def getClosingTerminal(AutoEditBlockRegion region, extension AutoEditContext context) {
		val closingTerminal = region.closingTerminal
		if (closingTerminal == null)
			return null

		if (closingTerminal.length < this.closingTerminal.length && closingTerminal.offset.isSameLine(caretOffset))
			return null

		return closingTerminal
	}

	protected def close(String previousLineIndentation, extension AutoEditContext context) {
		if (caretOffset.endOfLine)
			document.insertString(
				caretOffset,
				(previousLineIndentation + closingTerminal.removeLeadingWhitespace).newLine
			)
	}

	override open(char c, extension AutoEditContext context) {
		val newCaretOffset = type(c)
		if (!shouldInsertClosingTerminal(newCaretOffset, context))
			return;

		val documentContent = editor.document.text
		val opening = documentContent.count(openingTerminal)
		val closing = documentContent.count(closingTerminal)
		val occurences = opening + closing - 1
		if (occurences % 2 == 0)
			document.insertString(newCaretOffset, closingTerminal)
	}

	override close(char c, extension AutoEditContext context) {
		val region = caretOffset.findRegion(context)
		if (region == null)
			return false

		val openedRegion = region.findOpenedRegion(context)
		if (openedRegion != null)
			type(c)
		else if (region.closingTerminal != null && region.closingTerminal.contains(caretOffset))
			editor.moveCaretRelatively(1)
		else
			type(c)

		return true
	}

	protected def AutoEditBlockRegion findOpenedRegion(AutoEditBlockRegion region, extension AutoEditContext context) {
		if (region == null)
			return null
		if (region.closingTerminal == null)
			return region
		val nextRegion = region.openingTerminal.offset.findRegion(context)
		return nextRegion.findOpenedRegion(context)
	}

	val static Set<Character> CHARACTERS = #{'!', '-', '(', '{', '[', "'", '"'}

	boolean shouldInsertClosingTerminalBeforeIndentifier = false
	boolean shouldInsertClosingTerminalBeforeDigit = false
	boolean shouldInsertClosingTerminalBeforeSpecialCharacters = false

	protected def shouldInsertClosingTerminal(int offset, extension AutoEditContext context) {
		if (document.textLength <= offset)
			return true

		val charAtOffset = document.charsSequence.charAt(offset)

		if (!shouldInsertClosingTerminalBeforeIndentifier && charAtOffset.javaIdentifierStart)
			return false

		if (!shouldInsertClosingTerminalBeforeDigit && charAtOffset.digit)
			return false

		if (!shouldInsertClosingTerminalBeforeSpecialCharacters && specialCharacters.contains(charAtOffset))
			return false

		return true
	}

	protected def getSpecialCharacters() {
		CHARACTERS
	}

}