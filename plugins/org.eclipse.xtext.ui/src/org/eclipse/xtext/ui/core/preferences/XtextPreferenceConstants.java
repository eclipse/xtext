/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.preferences;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;

/**
 * Constant definitions for plug-in preferences
 * 
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextPreferenceConstants {
	/* Tokens */
	public static RGB KEYWORD_COLOR = new RGB(127, 0, 85);
	public static RGB DEFAULT_COLOR = new RGB(0, 0, 0);
	public static RGB COMMENT_COLOR = new RGB(63, 127, 95);
	public static RGB STRING_COLOR = new RGB(42, 0, 255);
	public static int DEFAULT_STYLE = SWT.NONE;
	public static int KEYWORD_STYLE = SWT.BOLD;
	public static int COMMENT_STYLE = SWT.NONE;
	public static int STRING_STYLE = SWT.NONE;

	public static final String COLOR_SUFIX = "color";
	public static final String BACKGROUNDCOLOR_SUFIX = "backgroundcolor";
	public static final String STYLE_SUFIX = "style";
	public static final String FONT_SUFIX = "font";

	public static String getTokenColorPreferenceKey(String tokenType) {
		return tokenType + COLOR_SUFIX;
	}

	public static String getTokenBackgroundColorPreferenceKey(String tokenType) {
		return tokenType + BACKGROUNDCOLOR_SUFIX;
	}

	public static String getTokenFontPreferenceKey(String tokenType) {
		return tokenType + FONT_SUFIX;
	}

	public static String getTokenStylePreferenceKey(String tokenType) {
		return tokenType + STYLE_SUFIX;
	}

}
