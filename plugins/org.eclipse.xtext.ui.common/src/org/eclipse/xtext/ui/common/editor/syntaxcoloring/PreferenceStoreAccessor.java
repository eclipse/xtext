/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import static org.eclipse.xtext.ui.common.editor.preferencepage.CommonPreferenceConstants.*;

import java.util.Arrays;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.common.editor.preferencepage.CommonPreferenceConstants;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;
import org.eclipse.xtext.ui.core.internal.Activator;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class PreferenceStoreAccessor {
	private final String PREFERENCE_TAG;
	private static ScopedPreferenceStore preferenceStore;

	@Inject
	public PreferenceStoreAccessor(@Named(Constants.LANGUAGE_NAME) String languageName) {
		PREFERENCE_TAG = tokenTypeTag(languageName) + SEPARATOR;
	}

	private static final ScopedPreferenceStore getPreferenceStore() {
		if (preferenceStore == null)
			preferenceStore = new ScopedPreferenceStore(new InstanceScope(), Activator.getDefault().getBundle()
					.getSymbolicName());
		return preferenceStore;
	}

	public void populateTextStyle(String tokenTpeDefId, TextStyle style, TextStyle defaults) {
		// prepare
		String colorKey = PREFERENCE_TAG + PreferenceStoreAccessor.getTokenColorPreferenceKey(tokenTpeDefId);
		String backgroundKey = PREFERENCE_TAG + getTokenBackgroundColorPreferenceKey(tokenTpeDefId);
		String fontKey = PREFERENCE_TAG + getTokenFontPreferenceKey(tokenTpeDefId);
		String styleKey = PREFERENCE_TAG + getTokenStylePreferenceKey(tokenTpeDefId);

		// DefaultDefault
		IPreferenceStore editorsStore = EditorsUI.getPreferenceStore();
		RGB fontColorDefaultDefault = editorsStore.getBoolean(AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND_SYSTEM_DEFAULT) ? getDisplay()
				.getSystemColor(SWT.COLOR_LIST_FOREGROUND).getRGB()
				: PreferenceConverter.getColor(editorsStore, AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND);
		RGB backgrounColorDefaultDefault = editorsStore
				.getBoolean(AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT) ? getDisplay().getSystemColor(
				SWT.COLOR_LIST_BACKGROUND).getRGB() : PreferenceConverter.getColor(editorsStore,
				AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND);
		FontData[] fontDataDefaultDefault = JFaceResources.getTextFont().getFontData();

		// set defaults
		ScopedPreferenceStore preferenceStore = getPreferenceStore();
		if (defaults.getColor() != null)
			PreferenceConverter.setDefault(preferenceStore, colorKey, defaults.getColor());
		else {
			PreferenceConverter.setDefault(preferenceStore, colorKey, fontColorDefaultDefault);
		}
		if (defaults.getBackgroundColor() != null)
			PreferenceConverter.setDefault(preferenceStore, backgroundKey, defaults.getBackgroundColor());
		else {
			PreferenceConverter.setDefault(preferenceStore, backgroundKey, backgrounColorDefaultDefault);
		}
		if (defaults.getFontData() != null)
			PreferenceConverter.setDefault(preferenceStore, fontKey, defaults.getFontData());
		else {
			PreferenceConverter.setDefault(preferenceStore, fontKey, fontDataDefaultDefault);
		}
		preferenceStore.setDefault(styleKey, defaults.getStyle());

		// populate
		RGB color = PreferenceConverter.getColor(preferenceStore, colorKey);
		if (!color.equals(fontColorDefaultDefault))
			style.setColor(color);
		RGB background = PreferenceConverter.getColor(preferenceStore, backgroundKey);
		if (!background.equals(backgrounColorDefaultDefault))
			style.setBackgroundColor(background);
		FontData[] fontDataArray = PreferenceConverter.getFontDataArray(preferenceStore, fontKey);
		if (!Arrays.equals(fontDataArray, fontDataDefaultDefault)) {
			style.setFontData(fontDataArray);
		}
		style.setStyle(preferenceStore.getInt(styleKey));
	}

	private Device getDisplay() {
		Display display = Display.getCurrent();
		return display == null ? Display.getDefault() : display;
	}

	public static String getTokenColorPreferenceKey(String tokenType) {
		return tokenType + SEPARATOR + CommonPreferenceConstants.COLOR_SUFIX;
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

	public static String syntaxColorerTag(String languageName) {
		return languageName + SEPARATOR + SYNTAX_COLORER_PREFERENCE_TAG;
	}

	public static String tokenTypeTag(String languageName) {
		return syntaxColorerTag(languageName) + SEPARATOR + TOKEN_STYLES_PREFERENCE_TAG;
	}
}