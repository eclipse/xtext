/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.testing

import com.google.inject.Inject
import org.eclipse.jface.text.ITextSelection
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Event
import org.eclipse.ui.texteditor.AbstractTextEditor
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil
import org.eclipse.xtext.ui.editor.XtextEditorInfo

/**
 * @since 2.14
 */
abstract class AbstractEditorDoubleClickTextSelectionTest extends AbstractEditorTest {

	@Inject XtextEditorInfo xtextEditorInfo
	@Inject extension FileExtensionProvider

	/**
	 * Special symbol indicating the current cursor position.
	 */
	def String c() '''|'''

	/**
	 * @param it - The editor's input text. The text must contain the {@link #c}
	 *	special symbol indicating the current cursor position.
	 * 
	 * @param expected - The text that is expected to be selected after double
	 *	clicking in the Xtext editor on the current cursor position.
	 */
	def assertSelectedTextAfterDoubleClicking(CharSequence it, String expected) {
		
		content.createFile.openEditor.
		
		doubleClick(cursorPosition).
		
		assertSelectedText(expected)
	}

	protected def getContent(CharSequence text) {
		text.toString.replace(c, "")
	}

	protected def createFile(String content) {
		IResourcesSetupUtil.createFile(projectName, fileName, fileExtension, content)
	}

	protected def String getProjectName() '''Test'''

	protected def String getFileName() '''Foo'''

	protected def getFileExtension() {
		primaryFileExtension
	}

	protected def int getCursorPosition(CharSequence text) {
		val cursorPosition = text.toString.indexOf(c)
		if(cursorPosition == -1) {
			fail('''
				The input text
				«text»
				must contain the '«c»' special symbol indicating the current cursor position!
			''')
		}
		cursorPosition
	}

	protected def XtextEditor doubleClick(XtextEditor xtextEditor, int cursorPosition) {
		val viewer = xtextEditor.internalSourceViewer
		
		// set the cursor position
		viewer.setSelectedRange(cursorPosition, 0)
		
		// fire a mouse down event with the left mouse button
		viewer.textWidget.notifyListeners(
			SWT.MouseDown,
			new Event => [
				button = 1
			]
		)
		
		xtextEditor
	}

	protected def assertSelectedText(AbstractTextEditor textEditor, CharSequence expectedSelectedText) {
		val actualSelectedText = (textEditor.selectionProvider.selection as ITextSelection).text
		expectedSelectedText.assertEquals(actualSelectedText)
	}

	override protected getEditorId() {
		xtextEditorInfo.editorId
	}

}
