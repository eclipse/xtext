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
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.ui.core.service.IPreferenceStoreService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class PreferenceStore implements IPreferenceStoreService {
	/* Tokens */
	private static final String COLOR_SUFIX = "color";
	private static final String BACKGROUNDCOLOR_SUFIX = "backgroundcolor";
	private static final String STYLE_SUFIX = "style";
	private static final String FONT_SUFIX = "font";

	private ILanguageDescriptor languageDescriptor;

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

	private IPersistentPreferenceStore preferenceStore = null;

	public IPersistentPreferenceStore getPersitablePreferenceStore() {
		if (preferenceStore == null) {
			preferenceStore = new ScopedPreferenceStore(new InstanceScope(), getLanguageDescriptor().getNameSpace());
		}
		return preferenceStore;
	}

	public ILanguageDescriptor getLanguageDescriptor() {
		return languageDescriptor;
	}

	public void setLanguageDescriptor(ILanguageDescriptor languageDescriptor) {
		this.languageDescriptor = languageDescriptor;
	}

}