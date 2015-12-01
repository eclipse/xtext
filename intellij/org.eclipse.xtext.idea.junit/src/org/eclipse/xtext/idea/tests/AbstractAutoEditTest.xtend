package org.eclipse.xtext.idea.tests

import com.intellij.ide.ClipboardSynchronizer
import com.intellij.openapi.actionSystem.IdeActions
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.TextRange
import java.awt.datatransfer.StringSelection
import org.eclipse.xtext.junit4.internal.LineDelimiters

abstract class AbstractAutoEditTest extends LightToolingTest {

	new(LanguageFileType fileType) {
		super(fileType)
	}

	protected def void assertAutoIndentOnNewLine(
		CharSequence model,
		CharSequence expectedModel
	) {
		configureByText(model.toString)
		newLine
		assertState(expectedModel.toString)
	}

	protected def selectText(int relativeToCurrentOffset, int length) {
		val offset = myFixture.editor.caretModel.offset
		val startOffset = offset + relativeToCurrentOffset
		val endOffset = startOffset + length
		myFixture.editor.selectionModel.setSelection(startOffset, endOffset)
	}

	protected def void pasteText(String text) {
		val content = new StringSelection(text)
		ClipboardSynchronizer.instance.setContent(content, content)
		myFixture.performEditorAction(IdeActions.ACTION_EDITOR_PASTE)
	}

	override protected configureByText(String code) {
		super.configureByText(code.replace('|', '<caret>'))
	}

	protected def assertState(String editorState) {
		val expectedState = LineDelimiters.toUnix(editorState)

		val actualState = {
			val caretOffset = myFixture.editor.caretModel.primaryCaret.offset
			val document = myFixture.editor.document
			val beforeCaret = myFixture.editor.document.getText(new TextRange(0, caretOffset))
			val afterCaret = myFixture.editor.document.getText(new TextRange(caretOffset, document.textLength))
			beforeCaret + '|' + afterCaret
		}

		assertEquals(dumpFormattingModel, expectedState, actualState)
	}

	protected def newLine() {
		myFixture.type('\n')
	}

	protected def backspace() {
		myFixture.type('\b')
	}

}