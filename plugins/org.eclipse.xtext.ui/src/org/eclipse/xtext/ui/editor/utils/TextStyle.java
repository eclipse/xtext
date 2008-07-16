/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.utils;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class TextStyle implements Cloneable {
	private String color;
	private String backgroundColor;
	private String fontData;

	/**
	 * @param color
	 * @param backgroundColor
	 * @param style
	 * @param fontData
	 */
	public TextStyle(String color, String backgroundColor, String fontData) {
		super();
		this.color = color;
		this.backgroundColor = backgroundColor;
		this.fontData = fontData;
		if (color == null)
			this.color = TextStyleConstants.DEFAULT_COLOR;
		if (backgroundColor == null)
			this.backgroundColor = TextStyleConstants.DEFAULT_BACKGROUNDCOLOR;
		if (this.fontData == null) {
			this.fontData = TextStyleConstants.DEFAULT_FONT;
		}
	}

	public TextStyle(TextStyle textStyle) {
		this.backgroundColor = textStyle.backgroundColor;
		this.color = textStyle.color;
		this.fontData = textStyle.fontData;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String rgb) {
		this.color = rgb;
	}

	/**
	 * @return the fontData
	 */
	public String getFontData() {
		return fontData;
	}

	/**
	 * @param fontData
	 *            the fontData to set
	 */
	public void setFontData(String fontName) {
		this.fontData = fontName;
	}

	/**
	 * @param backgroundColor
	 *            the backgroundColor to set
	 */
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	/**
	 * @return the backgroundColor
	 */
	public String getBackgroundColor() {
		return backgroundColor;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new TextStyle(this);
	}

	public TextStyle copy() {
		try {
			return (TextStyle) clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
