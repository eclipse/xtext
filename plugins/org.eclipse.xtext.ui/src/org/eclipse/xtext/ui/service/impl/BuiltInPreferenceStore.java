/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service.impl;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.service.IPreferenceStore;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuiltInPreferenceStore implements IPreferenceStore {
	/* Tokens */
	private static final String COLOR_SUFIX = "color";
	private static final String BACKGROUNDCOLOR_SUFIX = "bgColor";
	private static final String STYLE_SUFIX = "style";
	private static final String FONT_SUFIX = "font";

	public static String getTokenColorPreferenceKey(ILanguageDescriptor languageDescriptor, String tokenType) {
		return languageDescriptor.getId() + tokenType + COLOR_SUFIX;
	}

	public static String getTokenBackgroundColorPreferenceKey(ILanguageDescriptor languageDescriptor, String tokenType) {
		return languageDescriptor.getId() + tokenType + BACKGROUNDCOLOR_SUFIX;
	}

	public static String getTokenFontPreferenceKey(ILanguageDescriptor languageDescriptor, String tokenType) {
		return languageDescriptor.getId() + tokenType + FONT_SUFIX;
	}

	public static String getTokenStylePreferenceKey(ILanguageDescriptor languageDescriptor, String tokenType) {
		return languageDescriptor.getId() + tokenType + STYLE_SUFIX;
	}

	private IPersistentPreferenceStore preferenceStore = null;

	public IPersistentPreferenceStore getPersitablePreferenceStore() {
		if (preferenceStore == null) {
			preferenceStore = new ScopedPreferenceStore(new InstanceScope(), qualifier());
		}
		return preferenceStore;
	}

	/**
	 * Subclasses can overwrite
	 * 
	 * @return qualifier for internal scoped preference store
	 */
	protected String qualifier() {
		return Activator.PLUGIN_ID;
	}

}