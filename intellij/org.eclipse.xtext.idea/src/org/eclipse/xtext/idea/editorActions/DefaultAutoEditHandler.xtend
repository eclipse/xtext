/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.google.inject.Inject
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.actionSystem.EditorActionHandler
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Ref
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.TokenSet
import com.intellij.util.text.CharArrayUtil
import java.util.Set
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider
import org.eclipse.xtext.idea.parser.TokenTypeProvider
import org.eclipse.xtext.util.TextRegion

import static extension com.intellij.openapi.editor.EditorModificationUtil.*
import static extension java.lang.Character.*
import static extension org.eclipse.xtext.util.Strings.*

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultAutoEditHandler extends IdeaAutoEditHandler {

	@Inject
	TokenTypeProvider tokenTypeProvider

	@Inject
	IBracePairProvider bracePairProvider

	// TODO: should be configurable
	protected def getQuotePairs() {
		#['"' -> '"', "'" -> "'"]
	}

	// TODO: should be configurable
	protected def Iterable<AutoEditBlock> getBlocks(EditorEx editor) {
		val multiLineCommentBlock = new AutoEditBlock('/*', ' * ', ' */')
		val tokenSet = editor.getTokenSet(editor.caretModel.offset)
		switch tokenSet {
			case singleLineCommentTokens:
				emptyList
			case commentTokens:
				#[
					multiLineCommentBlock
				]
			default:
				bracePairProvider.pairs.map [
					new AutoEditBlock(leftBrace, null, rightBrace, structural)
				] + #[multiLineCommentBlock]
		}
	}

	override beforeEnterTyped(
		PsiFile file,
		EditorEx editor,
		Ref<Integer> caretOffset,
		Ref<Integer> caretAdvance,
		DataContext dataContext,
		EditorActionHandler originalHandler
	) {
		editor.handleIndentation
	}

	// TODO: replace with skipping whitespace tokens
	protected static val WHITESPACE_CHARACTERS = ' \t'

	protected def handleIndentation(EditorEx editor) {
		val previousLineIndentation = editor.previousLineIndentaiton
		val blockIndentaion = editor.indentBlock(previousLineIndentation)
		val string = (previousLineIndentation + blockIndentaion).newLine
		val cursorShift = string.length

		editor.insertStringAtCaret(string, false, false)
		editor.moveCaretRelatively(cursorShift)

		return Result.STOP
	}

	protected def getPreviousLineIndentaiton(EditorEx editor) {
		val document = editor.document
		val caretOffset = editor.caretModel.offset
		val lineNumber = document.getLineNumber(caretOffset)
		val lineStartOffset = document.getLineStartOffset(lineNumber)
		val textStartOffset = CharArrayUtil.shiftForward(
			document.text,
			lineStartOffset,
			caretOffset,
			WHITESPACE_CHARACTERS
		)

		if (textStartOffset > lineStartOffset)
			document.getText(new TextRange(lineStartOffset, textStartOffset))
		else
			''
	}

	protected def indentBlock(EditorEx editor, String previousLineIndentation) {
		val region = editor.findBlockRegion
		if (region == null)
			return ''

		val document = editor.document
		val caretOffset = editor.caretModel.offset

		val indentationTerminal = region.block.indentationTerminal ?: indentationTerminal
		if (editor.document.isSameLine(region.openingTerminal.offset, caretOffset)) {
			val closingTerminal = region.getClosingTerminal(editor)
			if (closingTerminal == null) {
				region.closeBlock(editor, previousLineIndentation)
			} else if (document.isSameLine(closingTerminal.offset, caretOffset) &&
				closingTerminal.offset >= caretOffset) {
				val text = document.getText(new TextRange(caretOffset, closingTerminal.offset)).trim
				document.replaceString(caretOffset, closingTerminal.offset, text + previousLineIndentation.newLine)
			}
			return indentationTerminal
		}

		if (region.closingTerminal == null) {
			region.closeBlock(editor, previousLineIndentation)
			return ''
		}

		return indentationTerminal.removeLeadingWhitespace
	}

	def getClosingTerminal(AutoEditBlockRegion region, EditorEx editor) {
		val block = region.block
		val closingTerminal = region.closingTerminal
		if (closingTerminal == null)
			return null

		val document = editor.document
		val caretOffset = editor.caretModel.offset
		if (closingTerminal.length < block.closingTerminal.length &&
			document.isSameLine(closingTerminal.offset, caretOffset))
			return null

		return closingTerminal
	}

	protected def void closeBlock(AutoEditBlockRegion region, EditorEx editor, String previousLineIndentation) {
		val document = editor.document
		val caretOffset = editor.caretModel.offset
		if (document.isEndOfLine(caretOffset))
			editor.document.insertString(
				caretOffset,
				(previousLineIndentation + region.block.closingTerminal.removeLeadingWhitespace).newLine
			)
	}

	protected def newLine(String content) { '\n' + content }

	protected def findBlockRegion(EditorEx editor) {
		editor.blocks.map[findBlockRegion(editor, editor.caretModel.offset)].filterNull.reduce [
			if($0.openingTerminal.offset < $1.openingTerminal.offset) $1 else $0
		]
	}

	// TODO: should be configurable
	protected def getIndentationTerminal() {
		'\t'
	}

	override beforeCharTyped(char c, Project project, EditorEx editor, PsiFile file, FileType fileType) {
		for (result : editor.blocks.map[handleBlock(editor, c)]) {
			if (result == Result.DEFAULT || result == Result.STOP)
				return result
		}

		for (result : quotePairs.map[handleQuote(editor, c, key, value)]) {
			if (result == Result.DEFAULT || result == Result.STOP)
				return result
		}

		return super.beforeCharTyped(c, project, editor, file, fileType)
	}

	override charDeleted(char c, PsiFile file, EditorEx editor) {
		if (quotePairs.map[handleDeleteQuote(editor, c, key, value)].exists[it])
			return true

		return super.charDeleted(c, file, editor)
	}

	protected def handleQuote(
		EditorEx editor,
		char c,
		String openingQuote,
		String closingQuote
	) {
		if (!editor.endsWith(c, openingQuote))
			return Result.CONTINUE

		if (editor.isStringLiteral(editor.caretModel.offset))
			return editor.handleQuoteInStringLiteral(c, openingQuote, closingQuote)

		if (editor.shouldInsertClosingQuote(openingQuote, closingQuote))
			editor.document.insertString(editor.type(c), closingQuote)
		else
			editor.type(c)

		return Result.STOP
	}

	protected def isStringLiteral(EditorEx editor, int offset) {
		if (offset == 0 || editor.document.textLength == offset)
			return false
		editor.getTokenSet(offset) == stringLiteralTokens
	}

	protected def handleQuoteInStringLiteral(
		EditorEx editor,
		char c,
		String openingQuote,
		String closingQuote
	) {
		if (editor.isClosingQuote(closingQuote))
			editor.moveCaretRelatively(closingQuote.length)
		else
			editor.type(c)

		return Result.STOP
	}

	protected def boolean shouldInsertClosingQuote(
		EditorEx editor,
		String openingQuote,
		String closingQuote
	) {
		if (editor.document.isIdentifierPart(editor.caretModel.offset))
			return false

		if (openingQuote == closingQuote) {
			if (editor.document.text.count(openingQuote) % 2 != 0)
				return false
		}

		return true
	}

	protected def isClosingQuote(EditorEx editor, String closingQuote) {
		val beginOffset = editor.caretModel.offset
		val closingQuoteLength = closingQuote.length
		val endOffset = beginOffset + closingQuoteLength
		if (endOffset > editor.document.textLength)
			return false

		val iterator = editor.highlighter.createIterator(beginOffset)
		if (iterator.atEnd)
			return false

		val start = iterator.start
		val end = iterator.end
		return end - start >= closingQuoteLength && beginOffset == end - closingQuoteLength
	}

	protected def handleDeleteQuote(EditorEx editor, char c, String openingQuote, String closingQuote) {
		if (c != openingQuote.charAt(0))
			return false

		val beginOffset = editor.caretModel.offset
		if (beginOffset < 0)
			return false

		val endOffset = beginOffset + closingQuote.length
		if (endOffset > editor.document.textLength)
			return false

		val s = editor.document.getText(new TextRange(beginOffset, endOffset))
		if (s != closingQuote)
			return false

		editor.document.deleteString(beginOffset, endOffset)
		return true
	}

	protected def handleBlock(AutoEditBlock block, EditorEx editor, char c) {
		if (!editor.endsWith(c, block.openingTerminal))
			return Result.CONTINUE

		val newCaretOffset = editor.type(c)
		if (!editor.shouldInsertClosingTerminal(newCaretOffset))
			return Result.STOP

		val documentContent = editor.document.text
		val opening = documentContent.count(block.openingTerminal)
		val closing = documentContent.count(block.closingTerminal)
		val occurences = opening + closing - 1
		if (occurences % 2 == 0)
			editor.document.insertString(newCaretOffset, block.closingTerminal)

		return Result.STOP
	}

	val static Set<Character> CHARACTERS = #{'!', '-', '(', '{', '[', "'", '"'}

	protected def shouldInsertClosingTerminal(EditorEx editor, int offset) {
		val document = editor.document
		if(document.textLength <= offset) return true
		val charAtOffset = document.charsSequence.charAt(offset)
		return !charAtOffset.javaIdentifierStart && !charAtOffset.digit && !CHARACTERS.contains(charAtOffset)
	}

	protected def isIdentifierPart(Document document, int offset) {
		if (document.textLength > offset)
			document.charsSequence.charAt(offset).javaIdentifierPart
	}

	protected def endsWith(EditorEx editor, char c, String terminal) {
		val text = editor.document.getText(new TextRange(0, editor.caretModel.offset)) + c
		text.endsWith(terminal)
	}

	protected def type(EditorEx editor, char c) {
		editor.insertStringAtCaret(String.valueOf(c), true, true)
	}

	protected def count(String searchMe, String toFind) {
		val length = toFind.length
		var count = 0
		var index = searchMe.indexOf(toFind)
		while (index > -1) {
			count++
			index = searchMe.indexOf(toFind, index + length)
		}
		return count
	}

	protected def TokenSet getTokenSet(EditorEx editor, int offset) {
		val tokenType = editor.getTokenType(offset)
		if (stringLiteralTokens.contains(tokenType))
			return stringLiteralTokens
		if (singleLineCommentTokens.contains(tokenType))
			return singleLineCommentTokens
		if (commentTokens.contains(tokenType))
			return commentTokens
		return null
	}

	protected def getTokenType(EditorEx editor, int offset) {
		val iterator = editor.highlighter.createIterator(offset)
		if (iterator.atEnd)
			return null

		if (iterator.start == offset && offset != 0)
			iterator.retreat

		if (iterator.end == offset && editor.document.textLength != offset)
			iterator.advance

		iterator.tokenType
	}

	protected def getCommentTokens() {
		tokenTypeProvider.commentTokens
	}

	protected def getSingleLineCommentTokens() {
		TokenSet.EMPTY
	}

	protected def getStringLiteralTokens() {
		tokenTypeProvider.stringLiteralTokens
	}

	protected def isSameLine(Document document, int offset, int offset2) {
		document.getLineNumber(offset) == document.getLineNumber(offset2)
	}

	protected def isStartOfLine(Document document, int offset) {
		val lineNumber = document.getLineNumber(offset)
		val lineStartOffset = document.getLineStartOffset(lineNumber)
		document.getText(new TextRange(lineStartOffset, offset)).trim.empty
	}

	protected def isEndOfLine(Document document, int offset) {
		val lineNumber = document.getLineNumber(offset)
		val lineEndOffset = document.getLineEndOffset(lineNumber)
		document.getText(new TextRange(offset, lineEndOffset)).trim.empty
	}

	protected def findBlockRegion(AutoEditBlock block, EditorEx editor, int offset) {
		val openingTerminal = block.findOpeningTerminal(editor, offset)
		if (openingTerminal == null)
			return null

		var closingTerminal = block.findClosingTerminal(editor, offset)
		if (closingTerminal != -1 && block.nested) {
			var previousOpeningTerminal = openingTerminal
			var previousClosingTerminal = closingTerminal
			while (closingTerminal != null && previousOpeningTerminal != null && previousClosingTerminal != null) {
				previousOpeningTerminal = block.findOpeningTerminal(editor, previousOpeningTerminal.offset)
				if (previousOpeningTerminal != null) {
					previousClosingTerminal = block.findClosingTerminal(editor, previousClosingTerminal.offset + 1)
					if (previousClosingTerminal == null)
						closingTerminal = null
				}
			}
		}
		return new AutoEditBlockRegion(block, openingTerminal, closingTerminal)
	}

	protected def findOpeningTerminal(AutoEditBlock block, EditorEx editor, int offset) {
		findOpeningTerminal(editor, block.openingTerminal, block.closingTerminal, offset)
	}

	protected def findClosingTerminal(AutoEditBlock block, EditorEx editor, int offset) {
		findClosingTerminal(editor, block.openingTerminal, block.closingTerminal, offset)
	}

	protected def TextRegion findOpeningTerminal(EditorEx editor, String left, String right, int offset) {
		val text = editor.document.text

		var leftOffset = offset
		var rightOffset = offset
		while (true) {
			val openingTerminal = text.searchBackward(left, editor, leftOffset)
			if (openingTerminal == null)
				return null
			val closingTerminal = text.searchBackward(right, editor, rightOffset)
			if (closingTerminal == null || closingTerminal.offset < openingTerminal.offset)
				return openingTerminal

			leftOffset = openingTerminal.offset
			rightOffset = closingTerminal.offset
		}
	}

	protected def findClosingTerminal(EditorEx editor, String left, String right, int offset) {
		val text = editor.document.text

		var leftOffset = offset
		var rightOffset = offset
		while (true) {
			val closingTerminal = text.searchForward(right, editor, rightOffset)
			if (closingTerminal == null)
				return null
			val openingTerminal = text.searchForward(left, editor, leftOffset)
			if (openingTerminal == null || openingTerminal.offset > closingTerminal.offset)
				return closingTerminal

			rightOffset = closingTerminal.offset + closingTerminal.length
			leftOffset = openingTerminal.offset + openingTerminal.length
		}
	}

	protected def TextRegion searchForward(String text, String toFind, EditorEx editor, int offset) {
		val length = toFind.length
		val tokenSet = editor.getTokenSet(offset)
		var index = text.indexOf(toFind, offset)
		while (index >= 0 && index < text.length) {
			if (editor.getTokenSet(index) == tokenSet)
				return new TextRegion(index, toFind.length)
			index = text.indexOf(toFind, index + length)
		}
		val trimmed = toFind.trim
		if (!trimmed.empty && trimmed.length != toFind.length)
			return text.searchForward(trimmed, editor, offset)
		return null
	}

	protected def TextRegion searchBackward(String text, String toFind, EditorEx editor, int offset) {
		val length = toFind.length
		val tokenSet = editor.getTokenSet(offset)
		var index = text.lastIndexOf(toFind, offset - length)
		while (index >= 0) {
			if (editor.getTokenSet(index) == tokenSet)
				return new TextRegion(index, toFind.length)
			index = text.lastIndexOf(toFind, index - length)
		}
		val trimmed = toFind.trim
		if (!trimmed.empty && trimmed.length != toFind.length)
			return text.searchBackward(trimmed, editor, offset)
		return null
	}

}