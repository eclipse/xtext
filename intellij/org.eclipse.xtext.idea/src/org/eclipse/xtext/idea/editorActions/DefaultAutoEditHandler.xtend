/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.codeInsight.CodeInsightSettings
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.actionSystem.EditorActionHandler
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiFile
import com.intellij.util.text.CharArrayUtil

import static extension com.intellij.openapi.editor.EditorModificationUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class DefaultAutoEditHandler extends IdeaAutoEditHandler {

	@Inject
	extension TokenSetProvider tokenSetProvider

	@Inject
	extension AutoEditBlockProvider blockProvider

	protected def getBlocks(EditorEx editor) {
		editor.getTokenSet(editor.caretModel.offset).blocks
	}

	override beforeEnterTyped(
		PsiFile file,
		EditorEx editor,
		Ref<Integer> caretOffset,
		Ref<Integer> caretAdvance,
		DataContext dataContext,
		EditorActionHandler originalHandler
	) {
		val context = new AutoEditContext(editor, tokenSetProvider)
		val region = findBlockRegion(context)
		if (region == null)
			return Result.CONTINUE

		return handleIndentation(region, context)
	}

	// TODO: replace with skipping whitespace tokens
	protected static val WHITESPACE_CHARACTERS = ' \t'

	protected def handleIndentation(AutoEditBlockRegion region, extension AutoEditContext context) {
		val previousLineIndentation = context.previousLineIndentaiton
		val blockIndentaion = region.indentBlock(previousLineIndentation, context)
		val string = (previousLineIndentation + blockIndentaion).newLine
		val cursorShift = string.length

		editor.insertStringAtCaret(string, false, false)
		editor.moveCaretRelatively(cursorShift)

		return Result.STOP
	}

	protected def indentBlock(AutoEditBlockRegion region, String previousLineIndentation, AutoEditContext context) {
		if (region.shouldIndentBlock(previousLineIndentation, context))
			return region.block.indent(region, previousLineIndentation, context)

		return ''
	}

	protected def shouldIndentBlock(
		AutoEditBlockRegion region,
		String previousLineIndentation,
		AutoEditContext context
	) {
		return (CodeInsightSettings.instance.INSERT_BRACE_ON_ENTER && region.block.closingTerminal == '}') ||
			CodeInsightSettings.instance.AUTOINSERT_PAIR_BRACKET
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

	protected def findBlockRegion(extension AutoEditContext context) {
		editor.blocks.map[findRegion(context)].filterNull.reduce [
			if($0.openingTerminal.offset < $1.openingTerminal.offset) $1 else $0
		]
	}

	override beforeCharTyped(char c, Project project, EditorEx editor, PsiFile file, FileType fileType) {
		val context = new AutoEditContext(editor, tokenSetProvider)
		if (CodeInsightSettings.instance.AUTOINSERT_PAIR_BRACKET) {
			for (result : editor.blocks.map[closeBlock(c, context)]) {
				if (result == Result.DEFAULT || result == Result.STOP)
					return result
			}
		}
		if (CodeInsightSettings.instance.AUTOINSERT_PAIR_QUOTE) {
			for (result : quotes.map[closeBlock(c, context)]) {
				if (result == Result.DEFAULT || result == Result.STOP)
					return result
			}
		}
		if (CodeInsightSettings.instance.AUTOINSERT_PAIR_BRACKET) {
			for (result : editor.blocks.map[openBlock(c, context)]) {
				if (result == Result.DEFAULT || result == Result.STOP)
					return result
			}
		}
		if (CodeInsightSettings.instance.AUTOINSERT_PAIR_QUOTE) {
			for (result : quotes.map[openBlock(c, context)]) {
				if (result == Result.DEFAULT || result == Result.STOP)
					return result
			}
		}
		return super.beforeCharTyped(c, project, editor, file, fileType)
	}

	override charDeleted(char c, PsiFile file, EditorEx editor) {
		val context = new AutoEditContext(editor, tokenSetProvider)

		if (CodeInsightSettings.instance.AUTOINSERT_PAIR_BRACKET && editor.blocks.exists[delete(c, context)])
			return true

		if (CodeInsightSettings.instance.AUTOINSERT_PAIR_QUOTE && quotes.exists[delete(c, context)])
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

}