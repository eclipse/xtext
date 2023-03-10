/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

/**
 * Simple bean which is used to share text style information between components.
 * 
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class TextStyle {
	public static final int DEFAULT_FONT_STYLE = SWT.NORMAL;
	private RGB color;
	private RGB backgroundColor;
	private FontData[] fontData;
	private int style = DEFAULT_FONT_STYLE;

	private TextStyle(TextStyle textStyle) {
		this.backgroundColor = textStyle.backgroundColor;
		this.color = textStyle.color;
		this.fontData = textStyle.fontData;
		this.style = textStyle.style;
	}

	public TextStyle() {
	}

	/**
	 * @return the color
	 */
	public RGB getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(RGB color) {
		this.color = color;
	}

	/**
	 * @return the fontData
	 */
	public FontData[] getFontData() {
		return fontData;
	}

	/**
	 * @param fontData
	 *            the fontData to set
	 */
	public void setFontData(FontData... fontData) {
		this.fontData = fontData;
	}

	/**
	 * @param backgroundColor
	 *            the backgroundColor to set
	 */
	public void setBackgroundColor(RGB backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	/**
	 * @return the backgroundColor
	 */
	public RGB getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * @return SWT style constant (default is SWT.NORMAL)
	 */
	public int getStyle() {
		return style;
	}

	/**
	 * creates a new {@link TextStyle} instance and copies all the source fields
	 */
	public TextStyle copy() {
		return new TextStyle(this);
	}

	/**
	 * @param style SWT style constant 
	 * @see SWT
	 */
	public void setStyle(int style) {
		this.style = style;
	}
}
