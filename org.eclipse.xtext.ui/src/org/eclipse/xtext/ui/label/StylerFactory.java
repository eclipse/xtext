/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.label;

import static org.eclipse.xtext.ui.editor.utils.EditorUtils.*;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;

/**
 * Helper class for styled strings.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class StylerFactory {
	/**
	 * @return {@link DefaultFontStyler}
	 */
	public Styler createStyler(String foregroundColorName, String backgroundColorName) {
		return new DefaultFontStyler(null, foregroundColorName, backgroundColorName);
	}

	/**
	 * Creates a styler that takes the given descriptor of a font, foreground and background colors from the JFace color
	 * registry.
	 * 
	 * @param fontDescriptor
	 *            the descriptor of a font to apply
	 * @param foregroundColorName
	 *            the color name for the foreground color
	 * @param backgroundColorName
	 *            the color name for the background color
	 * 
	 * @return the created style
	 */
	public Styler createStyler(FontDescriptor fontDescriptor, String foregroundColorName,
			String backgroundColorName) {
		return new DefaultFontStyler(fontDescriptor, foregroundColorName, backgroundColorName);
	}

	/**
	 * Creates an adapter styler for {@link org.eclipse.xtext.ui.editor.utils.TextStyle XtextStyles}.
	 * 
	 * @param xtextStyle
	 *            the xtextStyle to apply
	 * @return the created style
	 */
	public Styler createXtextStyleAdapterStyler(org.eclipse.xtext.ui.editor.utils.TextStyle xtextStyle) {
		return new XtextStyleAdapterStyler(xtextStyle);
	}

	/**
	 * Convenience method to create a new <code>StyledString</code> from a given label text and
	 * {@link org.eclipse.xtext.ui.editor.utils.TextStyle XtextTextStyle}
	 * 
	 * @param text
	 *            the label to display
	 * @param xtextStyle
	 *            the style to apply to the given text
	 * @return the created style
	 */
	public StyledString createFromXtextStyle(String text,
			org.eclipse.xtext.ui.editor.utils.TextStyle xtextStyle) {
		return new StyledString(text, new XtextStyleAdapterStyler(xtextStyle));
	}

	protected static class XtextStyleAdapterStyler extends Styler {
		private org.eclipse.xtext.ui.editor.utils.TextStyle xtextTextStyle;

		public XtextStyleAdapterStyler(org.eclipse.xtext.ui.editor.utils.TextStyle textStyle) {
			this.xtextTextStyle = textStyle;
		}

		@Override
		public void applyStyles(TextStyle textStyle) {
			textStyle.strikeout = (xtextTextStyle.getStyle() & TextAttribute.STRIKETHROUGH) != 0;
			textStyle.underline = (xtextTextStyle.getStyle() & TextAttribute.UNDERLINE) != 0;
			if (xtextTextStyle.getFontData() == null
					&& xtextTextStyle.getStyle() != org.eclipse.xtext.ui.editor.utils.TextStyle.DEFAULT_FONT_STYLE) {
				FontData fontData = new FontData();
				fontData.setStyle(xtextTextStyle.getStyle());
				xtextTextStyle.setFontData(fontData);
			}
			textStyle.font = fontFromFontData(xtextTextStyle.getFontData());
			if (xtextTextStyle.getBackgroundColor() != null) 
				textStyle.background = colorFromRGB(xtextTextStyle.getBackgroundColor());
			textStyle.foreground = colorFromRGB(xtextTextStyle.getColor());
		}
	}

	protected static class DefaultFontStyler extends Styler {
		private final FontDescriptor fontDescriptor;
		private final String foregroundColorName;
		private final String backgroundColorName;

		public DefaultFontStyler(FontDescriptor fontDescriptor, String foregroundColorName, String backgroundColorName) {
			this.fontDescriptor = fontDescriptor;
			this.foregroundColorName = foregroundColorName;
			this.backgroundColorName = backgroundColorName;
		}

		@Override
		public void applyStyles(TextStyle textStyle) {
			ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
			if (fontDescriptor != null) {
				textStyle.font = fontDescriptor.createFont(Display.getCurrent());
			}
			if (foregroundColorName != null) {
				textStyle.foreground = colorRegistry.get(foregroundColorName);
			}
			if (backgroundColorName != null) {
				textStyle.background = colorRegistry.get(backgroundColorName);
			}
		}
	}
}
