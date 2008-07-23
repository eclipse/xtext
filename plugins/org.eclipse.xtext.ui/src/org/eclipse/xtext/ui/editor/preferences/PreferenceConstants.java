/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;

import org.eclipse.xtext.service.IServiceScope;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class PreferenceConstants {

	public static final char SEPARATOR = '.';

	public static final String SYNTAX_COLORER_PREFERENCE_TAG = "syntaxColorer";
	public static final String TOKEN_STYLES_PREFERENCE_TAG = "tokenStyles";

	public static final String COLOR_SUFIX = "color";
	public static final String BACKGROUNDCOLOR_SUFIX = "bgColor";
	public static final String STYLE_SUFIX = "style";
	public static final String FONT_SUFIX = "font";

	public static String getTokenColorPreferenceKey(String tokenType) {
		return tokenType + SEPARATOR + COLOR_SUFIX;
	}

	public static String getTokenBackgroundColorPreferenceKey(String tokenType) {
		return tokenType + SEPARATOR + BACKGROUNDCOLOR_SUFIX;
	}

	public static String getTokenFontPreferenceKey(String tokenType) {
		return tokenType + SEPARATOR + FONT_SUFIX;
	}

	public static String getTokenStylePreferenceKey(String tokenType) {
		return tokenType + SEPARATOR + STYLE_SUFIX;
	}

	public static String languageTag(IServiceScope serviceScope) {
		return serviceScope.getId();
	}

	public static String syntaxColorerTag(IServiceScope serviceScope) {
		return languageTag(serviceScope) + SEPARATOR + SYNTAX_COLORER_PREFERENCE_TAG;
	}

	public static String tokenTypeTag(IServiceScope serviceScope) {
		return syntaxColorerTag(serviceScope) + SEPARATOR + TOKEN_STYLES_PREFERENCE_TAG;
	}

}
