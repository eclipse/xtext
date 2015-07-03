/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.util.TextRange
import com.intellij.psi.tree.IElementType
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

import static extension com.intellij.openapi.editor.EditorModificationUtil.*
import static extension java.lang.Character.*

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@FinalFieldsConstructor
class AutoEditContext {
	val EditorEx editor
	val TokenSetProvider tokenSetProivder

	def getCaretOffset() {
		editor.caretModel.offset
	}

	def getDocument() {
		editor.document
	}

	def getTokenSet(int offset) {
		tokenSetProivder.getTokenSet(editor, offset)
	}

	def getTokenSet(HighlighterIterator iterator) {
		iterator.tokenType.tokenSet
	}

	def getTokenSet(IElementType tokenType) {
		tokenSetProivder.getTokenSet(tokenType)
	}

	def createTokenIterator(int offset) {
		editor.highlighter.createIterator(offset)
	}

	def isSameLine(int offset, int offset2) {
		offset.lineNumber == offset2.lineNumber
	}

	def getLineNumber(int offset) {
		document.getLineNumber(offset)
	}

	def getText(int startOffset, int endOffset) {
		document.getText(new TextRange(startOffset, endOffset))
	}

	def isStartOfLine(int offset) {
		tokenSetProivder.isStartOfLine(editor, offset)
	}

	def isEndOfLine(int offset) {
		tokenSetProivder.isEndOfLine(editor, offset)
	}

	def getStringLiteralTokens() {
		tokenSetProivder.stringLiteralTokens
	}

	def type(char c) {
		editor.insertStringAtCaret(String.valueOf(c), true, true)
	}

	def count(String searchMe, String toFind) {
		val length = toFind.length
		var count = 0
		var index = searchMe.indexOf(toFind)
		while (index > -1) {
			count++
			index = searchMe.indexOf(toFind, index + length)
		}
		return count
	}

	def isIdentifierPart(int offset) {
		if (document.textLength > offset)
			document.charsSequence.charAt(offset).javaIdentifierPart
	}

	def newLine(String content) { '\n' + content }

}