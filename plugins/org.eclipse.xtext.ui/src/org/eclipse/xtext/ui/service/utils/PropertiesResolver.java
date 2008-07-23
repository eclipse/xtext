/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service.utils;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.internal.Activator;

public class PropertiesResolver {
	private final String PREFERENCE_TAG;
	private static ScopedPreferenceStore preferenceStore;

	public static final ScopedPreferenceStore getPreferenceStore() {
		if (preferenceStore == null)
			preferenceStore = new ScopedPreferenceStore(new InstanceScope(), Activator.getDefault().getBundle()
					.getSymbolicName());
		return preferenceStore;
	}

	public PropertiesResolver(IServiceScope serviceScope) {
		PREFERENCE_TAG = PreferenceConstants.tokenTypeTag(serviceScope) + PreferenceConstants.SEPARATOR;
	}

	public void populateTextStyle(String tokenTpeDefId, TextStyle style, TextStyle defaults) {
		// prepare
		String colorKey = PREFERENCE_TAG + PreferenceConstants.getTokenColorPreferenceKey(tokenTpeDefId);
		String backgroundKey = PREFERENCE_TAG + PreferenceConstants.getTokenBackgroundColorPreferenceKey(tokenTpeDefId);
		String fontKey = PREFERENCE_TAG + PreferenceConstants.getTokenFontPreferenceKey(tokenTpeDefId);
		String styleKey = PREFERENCE_TAG + PreferenceConstants.getTokenStylePreferenceKey(tokenTpeDefId);

		// Defaults
		if (defaults.getColor() != null)
			PreferenceConverter.setDefault(getPreferenceStore(), colorKey, defaults.getColor());
		if (defaults.getBackgroundColor() != null)
			PreferenceConverter.setDefault(getPreferenceStore(), backgroundKey, defaults.getBackgroundColor());
		if (defaults.getFontData() != null)
			PreferenceConverter.setDefault(getPreferenceStore(), fontKey, defaults.getFontData());
		getPreferenceStore().setDefault(styleKey, defaults.getStyle());

		// populate
		if (getPreferenceStore().contains(colorKey))
			style.setColor(PreferenceConverter.getColor(getPreferenceStore(), colorKey));
		if (getPreferenceStore().contains(backgroundKey))
			style.setBackgroundColor(PreferenceConverter.getColor(getPreferenceStore(), backgroundKey));
		if (getPreferenceStore().contains(fontKey))
			style.setFontData(PreferenceConverter.getFontDataArray(getPreferenceStore(), fontKey));
		if (getPreferenceStore().contains(styleKey))
			style.setStyle(getPreferenceStore().getInt(styleKey));
	}
}