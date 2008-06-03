/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.utils;


/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class TextStyle {
	private String color;
	private String backgroundColor;
	private int style;
	private String fontName;

	/**
	 * @param color
	 * @param backgroundColor
	 * @param style
	 * @param fontName
	 */
	public TextStyle(String color, String backgroundColor, int style, String fontName) {
		super();
		this.color = color;
		this.backgroundColor = backgroundColor;
		this.style = style;
		this.fontName = fontName;
	}

	public TextStyle() {
		this(TextStyleConstants.KEYWORD_COLOR, TextStyleConstants.DEFAULT_BACKGROUNDCOLOR, TextStyleConstants.KEYWORD_STYLE,
				TextStyleConstants.DEFAULT_FONT);
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 * 		the color to set
	 */
	public void setColor(String rgb) {
		this.color = rgb;
	}

	/**
	 * @return the style
	 */
	public int getStyle() {
		return style;
	}

	/**
	 * @param style
	 * 		the style to set
	 */
	public void setStyle(int style) {
		this.style = style;
	}

	/**
	 * @return the fontName
	 */
	public String getFontName() {
		return fontName;
	}

	/**
	 * @param fontName
	 * 		the fontName to set
	 */
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	/**
	 * @param backgroundColor
	 * 		the backgroundColor to set
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
}
