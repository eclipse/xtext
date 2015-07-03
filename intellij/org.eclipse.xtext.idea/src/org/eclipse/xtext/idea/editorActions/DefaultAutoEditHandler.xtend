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
import com.intellij.openapi.editor.actionSystem.EditorActionHandler
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Ref
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.util.text.CharArrayUtil
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider
import org.eclipse.xtext.idea.parser.TokenTypeProvider

import static extension com.intellij.openapi.editor.EditorModificationUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultAutoEditHandler extends IdeaAutoEditHandler implements TokenSetProvider {

	@Inject
	TokenTypeProvider tokenTypeProvider

	@Inject
	IBracePairProvider bracePairProvider

	// TODO: should be configurable
	protected def Iterable<AbstractAutoEditBlock> getQuotes() {
		#[
			new AutoEditString('"'),
			new AutoEditString("'")
		]
	}

	protected def getBlocks(EditorEx editor) {
		editor.getTokenSet(editor.caretModel.offset).blocks
	}

	// TODO: should be configurable
	protected def Iterable<AbstractIndentableAutoEditBlock> getBlocks(TokenSet tokenSet) {
		val multiLineCommentBlock = new AutoEditMultiLineBlock('/*', ' * ', ' */')
		switch tokenSet {
			case singleLineCommentTokens:
				emptyList
			case commentTokens:
				#[
					multiLineCommentBlock
				]
			default:
				bracePairProvider.pairs.map [
					new AutoEditMultiLineBlock(leftBrace, null, rightBrace, structural)
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
		handleIndentation(new AutoEditContext(editor, this))
	}

	// TODO: replace with skipping whitespace tokens
	protected static val WHITESPACE_CHARACTERS = ' \t'

	protected def handleIndentation(extension AutoEditContext context) {
		val previousLineIndentation = context.previousLineIndentaiton
		val blockIndentaion = indentBlock(previousLineIndentation, context)
		val string = (previousLineIndentation + blockIndentaion).newLine
		val cursorShift = string.length

		editor.insertStringAtCaret(string, false, false)
		editor.moveCaretRelatively(cursorShift)

		return Result.STOP
	}

	protected def getPreviousLineIndentaiton(extension AutoEditContext context) {
		if (!shouldIndent(context))
			return ''

		val lineNumber = document.getLineNumber(caretOffset)
		val lineStartOffset = document.getLineStartOffset(lineNumber)
		val textStartOffset = CharArrayUtil.shiftForward(
			document.text,
			lineStartOffset,
			caretOffset,
			WHITESPACE_CHARACTERS
		)

		if (textStartOffset > lineStartOffset)
			getText(lineStartOffset, textStartOffset)
		else
			''
	}

	protected def shouldIndent(extension AutoEditContext context) {
		caretOffset.tokenSet != stringLiteralTokens
	}

	protected def indentBlock(String previousLineIndentation, extension AutoEditContext context) {
		val region = findBlockRegion(context)
		if (region != null)
			return region.block.indent(region, previousLineIndentation, context)
		return ''
	}

	protected def findBlockRegion(extension AutoEditContext context) {
		editor.blocks.map[findRegion(context)].filterNull.reduce [
			if($0.openingTerminal.offset < $1.openingTerminal.offset) $1 else $0
		]
	}

	override beforeCharTyped(char c, Project project, EditorEx editor, PsiFile file, FileType fileType) {
		val context = new AutoEditContext(editor, this)
		for (result : editor.blocks.map[closeBlock(c, context)]) {
			if (result == Result.DEFAULT || result == Result.STOP)
				return result
		}
		for (result : quotes.map[closeBlock(c, context)]) {
			if (result == Result.DEFAULT || result == Result.STOP)
				return result
		}
		for (result : editor.blocks.map[openBlock(c, context)]) {
			if (result == Result.DEFAULT || result == Result.STOP)
				return result
		}
		for (result : quotes.map[openBlock(c, context)]) {
			if (result == Result.DEFAULT || result == Result.STOP)
				return result
		}
		return super.beforeCharTyped(c, project, editor, file, fileType)
	}

	override charDeleted(char c, PsiFile file, EditorEx editor) {
		val context = new AutoEditContext(editor, this)

		if (editor.blocks.exists[delete(c, context)])
			return true

		if (quotes.exists[delete(c, context)])
			return true

		return super.charDeleted(c, file, editor)
	}

	protected def closeBlock(AbstractAutoEditBlock block, char c, AutoEditContext context) {
		if (block.closingTerminal.isAtTerminal(c, context)) {
			if (block.close(c, context))
				return Result.STOP
		}
		return Result.CONTINUE
	}

	protected def openBlock(AbstractAutoEditBlock block, char c, AutoEditContext context) {
		if (block.openingTerminal.isAtTerminal(c, context)) {
			block.open(c, context)
			return Result.STOP
		}
		return Result.CONTINUE
	}

	protected def isAtTerminal(String terminal, char c, extension AutoEditContext context) {
		val startOffset = caretOffset - terminal.length + 1
		val startText = if (startOffset == caretOffset)
				''
			else
				getText(Math.max(0, startOffset), caretOffset)

		val endOffset = caretOffset + terminal.length - 1
		val endText = if (endOffset == caretOffset)
				''
			else
				getText(caretOffset, Math.min(endOffset, document.textLength))

		val text = startText + c + endText
		text.lastIndexOf(terminal) != -1
	}

	override def TokenSet getTokenSet(EditorEx editor, int offset) {
		editor.getTokenType(offset).tokenSet
	}

	override def getTokenSet(IElementType tokenType) {
		if (stringLiteralTokens.contains(tokenType))
			return stringLiteralTokens
		if (singleLineCommentTokens.contains(tokenType))
			return singleLineCommentTokens
		if (commentTokens.contains(tokenType))
			return commentTokens
		return null
	}

	override isStartOfLine(EditorEx editor, int offset) {
		editor.getTokenSet(offset).isStartOfLine(editor, offset)
	}

	override isStartOfLine(TokenSet tokenSet, EditorEx editor, int offset) {
		editor.getBeginningOfLine(offset).trim.empty
	}

	override isEndOfLine(EditorEx editor, int offset) {
		editor.getTokenSet(offset).isEndOfLine(editor, offset)
	}

	override isEndOfLine(TokenSet tokenSet, EditorEx editor, int offset) {
		editor.getEndOfLine(offset).trim.empty
	}

	def getBeginningOfLine(EditorEx editor, int offset) {
		val document = editor.document
		val lineNumber = editor.document.getLineNumber(offset)
		val lineStartOffset = editor.document.getLineStartOffset(lineNumber)
		document.getText(new TextRange(lineStartOffset, offset))
	}

	def getEndOfLine(EditorEx editor, int offset) {
		val document = editor.document
		val lineNumber = editor.document.getLineNumber(offset)
		val lineEndOffset = editor.document.getLineEndOffset(lineNumber)
		document.getText(new TextRange(offset, lineEndOffset))
	}

	protected def getTokenType(EditorEx editor, int offset) {
		if(offset < 0 || offset > editor.document.textLength) return null

		val iterator = editor.highlighter.createIterator(offset)
		if(iterator.atEnd) return null

		iterator.tokenType
	}

	protected def getCommentTokens() {
		tokenTypeProvider.commentTokens
	}

	protected def getSingleLineCommentTokens() {
		TokenSet.EMPTY
	}

	override getStringLiteralTokens() {
		tokenTypeProvider.stringLiteralTokens
	}

}