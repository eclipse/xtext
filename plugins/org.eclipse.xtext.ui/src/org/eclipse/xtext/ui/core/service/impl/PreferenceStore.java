/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.service.impl;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.parser.ITokenTypes;
import org.eclipse.xtext.ui.core.language.AbstractLanguageService;
import org.eclipse.xtext.ui.core.service.IPreferenceStoreService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class PreferenceStore extends AbstractLanguageService implements IPreferenceStoreService {
	/* Tokens */
	public final static RGB KEYWORD_COLOR = new RGB(127, 0, 85);
	public final static RGB DEFAULT_COLOR = new RGB(0, 0, 0);
	public final static RGB COMMENT_COLOR = new RGB(63, 127, 95);
	public final static RGB STRING_COLOR = new RGB(42, 0, 255);
	public final static int DEFAULT_STYLE = SWT.NONE;
	public final static int KEYWORD_STYLE = SWT.BOLD;
	public final static int COMMENT_STYLE = SWT.NONE;
	public final static int STRING_STYLE = SWT.NONE;

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

	IPersistentPreferenceStore preferenceStore = null;

	public IPersistentPreferenceStore getPersitablePreferenceStore() {
		if (preferenceStore == null)
			preferenceStore = new ScopedPreferenceStore(new InstanceScope(), getLanguageDescriptor().getNameSpace());
		return preferenceStore;
	}

	public void initializeDefaults() {
		getPersitablePreferenceStore().setDefault(getTokenColorPreferenceKey(ITokenTypes.ANYOTHER),
				StringConverter.asString(DEFAULT_COLOR));
		getPersitablePreferenceStore().setDefault(getTokenColorPreferenceKey(ITokenTypes.COMMENT),
				StringConverter.asString(COMMENT_COLOR));
		getPersitablePreferenceStore().setDefault(getTokenColorPreferenceKey(ITokenTypes.KEYWORD),
				StringConverter.asString(KEYWORD_COLOR));
		getPersitablePreferenceStore().setDefault(getTokenColorPreferenceKey(ITokenTypes.STRINGLITERAL),
				StringConverter.asString(STRING_COLOR));
		// Style
		getPersitablePreferenceStore().setDefault(getTokenStylePreferenceKey(ITokenTypes.KEYWORD),
				StringConverter.asString(KEYWORD_STYLE));
	}

}