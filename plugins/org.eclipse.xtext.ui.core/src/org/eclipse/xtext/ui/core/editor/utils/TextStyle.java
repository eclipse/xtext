/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

/**
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
	public void setColor(RGB rgb) {
		this.color = rgb;
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
	 * @return
	 */
	public int getStyle() {
		return style;
	}

	public TextStyle copy() {
		return new TextStyle(this);
	}

	/**
	 * @param style
	 */
	public void setStyle(int style) {
		this.style = style;
	}
}
