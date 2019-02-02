/*******************************************************************************
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.testing

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.swt.custom.StyleRange
import org.eclipse.swt.custom.StyledText
import org.eclipse.swt.graphics.Color
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.addNature

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.15
 */
abstract class AbstractHighlightingTest extends AbstractEditorTest {

	@Inject extension SyncUtil
	@Inject extension FileExtensionProvider

	/**
	 * @param it The editor's input text. The input text must contain the given <code>text</code>.
	 * @param text The text that's highlighting style is to test.
	 * @param style The expected highlighting configuration text style used when highlighting the given <code>text</code>. 
	 */
	def testHighlighting(CharSequence it, String text, TextStyle style) {
		testHighlighting(text, style.style, 
			if (style.color===null) 0 else style.color.red,
			if (style.color===null) 0 else style.color.green,
			if (style.color===null) 0 else style.color.blue,
			if (style.backgroundColor===null) 255 else style.backgroundColor.red,
			if (style.backgroundColor===null) 255 else style.backgroundColor.green,
			if (style.backgroundColor===null) 255 else style.backgroundColor.blue
		)
	}

	/**
	 * @param it The editor's input text. The input text must contain the given <code>text</code>.
	 * @param text The text that's highlighting style is to test.
	 * @param fontStyle The expected font style used when highlighting the given <code>text</code>. 
	 * @param foregroundR The red component of the expected foreground color when highlighting the given <code>text</code>.
	 * @param foregroundG The green component of the expected foreground color when highlighting the given <code>text</code>.
	 * @param foregroundB The blue component of the expected foreground color when highlighting the given <code>text</code>.
	 */
	def testHighlighting(CharSequence it, String text, int fontStyle, int foregroundR, int foregroundG, int foregroundB) {
		testHighlighting(text, fontStyle, foregroundR, foregroundG, foregroundB, 255, 255, 255)
	}

	/**
	 * @param it The editor's input text. The input text must contain the given <code>text</code>.
	 * @param text The text that's highlighting style is to test.
	 * @param fontStyle The expected font style used when highlighting the given <code>text</code>. 
	 * @param foregroundR The red component of the expected foreground color when highlighting the given <code>text</code>.
	 * @param foregroundG The green component of the expected foreground color when highlighting the given <code>text</code>.
	 * @param foregroundB The blue component of the expected foreground color when highlighting the given <code>text</code>.
	 * @param backgroundR The red component of the expected background color when highlighting the given <code>text</code>.
	 * @param backgroundG The green component of the expected background color when highlighting the given <code>text</code>.
	 * @param backgroundB The blue component of the expected background color when highlighting the given <code>text</code>.
	 */
	def testHighlighting(CharSequence it, String text, int fontStyle,
		int foregroundR, int foregroundG, int foregroundB, 
		int backgroundR, int backgroundG, int backgroundB) {
		dslFile.openInEditor.testHighlighting(
			text, fontStyle,
			foregroundR, foregroundG, foregroundB,
			backgroundR, backgroundG, backgroundB
		)
	}

	protected def dslFile(CharSequence content) {
		val file = IResourcesSetupUtil.createFile(projectName, fileName, fileExtension, content.toString)
		
		/*
		 * TODO: find a better (with good performance) solution
		 * to set the Xtext nature on the test project.
		 */
		val project = file.project
		if(!project.hasNature(XtextProjectHelper.NATURE_ID)) {
			project.addNature(XtextProjectHelper.NATURE_ID)
		}
		
		file
	}

	protected def String getProjectName() '''HighlightingTestProject'''

	protected def String getFileName() '''highlighting'''

	protected def getFileExtension() {
		primaryFileExtension
	}

	protected def openInEditor(IFile dslFile) {
		val editor = dslFile.openEditor
		
		/*
		 * wait for the Xtext framework HighlightingPresenter.updatePresentation()
		 * to apply the semantic highlighting executed asynchronously
		 */
		editor.waitForReconciler
	
		editor.internalSourceViewer.textWidget
	}

	protected def testHighlighting(StyledText styledText, String text, int fontStyle,
		int foregroundR, int foregroundG, int foregroundB, 
		int backgroundR, int backgroundG, int backgroundB) {

		val expectedForegroundColor = new Color(null, foregroundR, foregroundG, foregroundB)
		val expectedBackgroundColor = new Color(null, backgroundR, backgroundG, backgroundB)

		val content = styledText.text
		val offset = content.indexOf(text)
		assertNotEquals('''Cannot locate '«text»' in «content»''', -1, offset)
		
		for (var i = 0; i < text.length; i++) {
			val currentPosition = offset + i
			val character = styledText.getTextRange(currentPosition, 1)
			val styleRange = styledText.getStyleRangeAtOffset(currentPosition)
			if (character.isRelevant) {
				styleRange => [
					assertFontStyle(character, fontStyle)
					assertForegroundColor(character, expectedForegroundColor)
					assertBackgroundColor(character, expectedBackgroundColor)
				]
			}
		}
	}

	protected def isRelevant(String character) {
		// skipping the whitespace characters
		character == character.trim 
	}

	protected def assertFontStyle(StyleRange it, String character, int expected) {
		val actual = fontStyle
		assertEquals('''Expected font style does not correspond to the actual font style on character «character»''',
			expected, actual)
	}

	protected def assertForegroundColor(StyleRange it, String character, Color expected) {
		val actual = foreground ?: new Color(null, 0, 0, 0) // the default foreground color is black 
		assertEquals('''Expected foreground color does not correspond to the actual foreground color on character «character»''',
			expected, actual)
	}

	protected def assertBackgroundColor(StyleRange it, String character, Color expected) {
		val actual = background ?: new Color(null, 255, 255, 255) // the default background color is white 
		assertEquals('''Expected background color does not correspond to the actual background color on character «character»''',
			expected, actual)
	}

}
