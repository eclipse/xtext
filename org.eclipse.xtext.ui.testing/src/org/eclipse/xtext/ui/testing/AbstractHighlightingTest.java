/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.testing;

import org.eclipse.core.resources.IFile;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.15
 */
public abstract class AbstractHighlightingTest extends AbstractEditorTest {

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	/**
	 * @param content
	 *            The editor's input text. The input text must contain the given <code>text</code>.
	 * @param text
	 *            The text that's highlighting style is to test.
	 * @param style
	 *            The expected highlighting configuration text style used when highlighting the given <code>text</code>.
	 */
	public void testHighlighting(CharSequence content, String text, TextStyle style) {
		testHighlighting(content, text, style.getStyle(), //
				style.getColor() == null ? 0 : style.getColor().red, //
				style.getColor() == null ? 0 : style.getColor().green, // 
				style.getColor() == null ? 0 : style.getColor().blue, //
				style.getBackgroundColor() == null ? 255 : style.getBackgroundColor().red, //
				style.getBackgroundColor() == null ? 255 : style.getBackgroundColor().green, //
				style.getBackgroundColor() == null ? 255 : style.getBackgroundColor().blue);
	}

	/**
	 * @param content
	 *            The editor's input text. The input text must contain the given <code>text</code>.
	 * @param text
	 *            The text that's highlighting style is to test.
	 * @param fontStyle
	 *            The expected font style used when highlighting the given <code>text</code>.
	 * @param foregroundR
	 *            The red component of the expected foreground color when highlighting the given <code>text</code>.
	 * @param foregroundG
	 *            The green component of the expected foreground color when highlighting the given <code>text</code>.
	 * @param foregroundB
	 *            The blue component of the expected foreground color when highlighting the given <code>text</code>.
	 */
	public void testHighlighting(CharSequence content, String text, int fontStyle, int foregroundR, int foregroundG, int foregroundB) {
		testHighlighting(content, text, fontStyle, foregroundR, foregroundG, foregroundB, 255, 255, 255);
	}

	/**
	 * @param content
	 *            The editor's input text. The input text must contain the given <code>text</code>.
	 * @param text
	 *            The text that's highlighting style is to test.
	 * @param fontStyle
	 *            The expected font style used when highlighting the given <code>text</code>.
	 * @param foregroundR
	 *            The red component of the expected foreground color when highlighting the given <code>text</code>.
	 * @param foregroundG
	 *            The green component of the expected foreground color when highlighting the given <code>text</code>.
	 * @param foregroundB
	 *            The blue component of the expected foreground color when highlighting the given <code>text</code>.
	 * @param backgroundR
	 *            The red component of the expected background color when highlighting the given <code>text</code>.
	 * @param backgroundG
	 *            The green component of the expected background color when highlighting the given <code>text</code>.
	 * @param backgroundB
	 *            The blue component of the expected background color when highlighting the given <code>text</code>.
	 */
	public void testHighlighting(CharSequence content, String text, int fontStyle, int foregroundR, int foregroundG, int foregroundB,
			int backgroundR, int backgroundG, int backgroundB) {
		testHighlighting(openInEditor(dslFile(getProjectName(), getFileName(), getFileExtension(), content)), text, fontStyle, foregroundR,
				foregroundG, foregroundB, backgroundR, backgroundG, backgroundB);
	}

	protected String getProjectName() {
		return "HighlightingTestProject";
	}

	protected String getFileName() {
		return "highlighting";
	}

	protected String getFileExtension() {
		return fileExtensionProvider.getPrimaryFileExtension();
	}

	protected StyledText openInEditor(IFile dslFile) {
		try {
			XtextEditor editor = openEditor(dslFile);
			waitForEventProcessing();
			return editor.getInternalSourceViewer().getTextWidget();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void testHighlighting(StyledText styledText, String text, int fontStyle, int foregroundR, int foregroundG, int foregroundB,
			int backgroundR, int backgroundG, int backgroundB) {
		Color expectedForegroundColor = new Color(null, foregroundR, foregroundG, foregroundB);
		Color expectedBackgroundColor = new Color(null, backgroundR, backgroundG, backgroundB);

		String content = styledText.getText();
		int offset = getStartPosition(content, text);
		assertNotEquals("Cannot locate '" + text + "' in " + content, -1, offset);

		for (int i = 0; i < text.length(); i++) {
			int currentPosition = offset + i;
			String character = styledText.getTextRange(currentPosition, 1);
			StyleRange styleRange = styledText.getStyleRangeAtOffset(currentPosition);
			if (isRelevant(character)) {
				assertFontStyle(styleRange, character, fontStyle);
				assertForegroundColor(styleRange, character, expectedForegroundColor);
				assertBackgroundColor(styleRange, character, expectedBackgroundColor);
			}
		}
	}

	/**
	 * @since 2.18
	 */
	protected int getStartPosition(String content, String text) {
		return content.indexOf(text);
	}

	protected boolean isRelevant(String character) {
		// skipping the whitespace characters
		return character.equals(character.trim());
	}

	protected void assertFontStyle(StyleRange styleRange, String character, int expected) {
		int actual = styleRange.fontStyle;
		assertEquals("Expected font style does not correspond to the actual font style on character " + character, //
				expected, //
				actual);
	}

	protected void assertForegroundColor(StyleRange styleRange, String character, Color expected) {
		Color actual = styleRange.foreground != null ? styleRange.foreground : new Color(null, 0, 0, 0); // the default foreground color is black
		assertEquals("Expected foreground color does not correspond to the actual foreground color on character " + character, //
				expected, //
				actual);
	}

	protected void assertBackgroundColor(StyleRange styleRange, String character, Color expected) {
		Color actual = styleRange.background != null ? styleRange.background : new Color(null, 255, 255, 255); // the default background color is white
		assertEquals("Expected background color does not correspond to the actual background color on character " + character, //
				expected, //
				actual);
	}
}
