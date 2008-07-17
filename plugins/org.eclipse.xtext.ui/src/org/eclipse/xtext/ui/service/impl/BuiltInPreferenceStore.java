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
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.editor.preferences.PreferencesQualifiedName;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.service.IPreferenceStore;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuiltInPreferenceStore implements IPreferenceStore {
	/* Tokens */
	public static final String COLOR_SUFIX = "color";
	public static final String BACKGROUNDCOLOR_SUFIX = "bgColor";
	public static final String STYLE_SUFIX = "style";
	public static final String FONT_SUFIX = "font";
	private String syntacColorerPrefix = new String();

	public String getTokenColorPreferenceKey(String tokenType) {
		return syntacColorerPrefix + PreferencesQualifiedName.SEPARATOR + tokenType
				+ PreferencesQualifiedName.SEPARATOR + COLOR_SUFIX;
	}

	public String getTokenBackgroundColorPreferenceKey(String tokenType) {
		return syntacColorerPrefix + PreferencesQualifiedName.SEPARATOR + tokenType
				+ PreferencesQualifiedName.SEPARATOR + BACKGROUNDCOLOR_SUFIX;
	}

	public String getTokenFontPreferenceKey(String tokenType) {
		return syntacColorerPrefix + PreferencesQualifiedName.SEPARATOR + tokenType
				+ PreferencesQualifiedName.SEPARATOR + FONT_SUFIX;
	}

	private IPersistentPreferenceStore preferenceStore = null;

	public IPersistentPreferenceStore getPersitablePreferenceStore() {
		if (preferenceStore == null) {
			preferenceStore = new ScopedPreferenceStore(new InstanceScope(), Activator.PLUGIN_ID);
		}
		return preferenceStore;
	}

	@Inject
	public void setScope(IServiceScope scope) {
		this.syntacColorerPrefix = PreferencesQualifiedName.parse(scope.getId()).append(
				calculateSyntaxColorerPrefix()).toString();
	}

	public static String calculateSyntaxColorerPrefix() {
		return PreferencesQualifiedName.parse(IPreferenceStore.SYNTAX_COLORER_PREFERENCE_TAG).append(IPreferenceStore.TOKEN_STYLES_PREFERENCE_TAG)
				.toString();
	}
}