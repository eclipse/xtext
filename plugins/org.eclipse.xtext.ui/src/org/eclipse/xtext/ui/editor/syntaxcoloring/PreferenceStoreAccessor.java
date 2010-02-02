/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import static org.eclipse.xtext.ui.editor.syntaxcoloring.CommonPreferenceConstants.*;

import java.util.Arrays;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class PreferenceStoreAccessor {
	private final String PREFERENCE_TAG;
	private final IPreferenceStoreAccess scopedAccessor;

	@Inject
	public PreferenceStoreAccessor(@Named(Constants.LANGUAGE_NAME) String languageName, IPreferenceStoreAccess scopedAccessor) {
		this.scopedAccessor = scopedAccessor;
		PREFERENCE_TAG = tokenTypeTag(languageName) + SEPARATOR;
	}

	public void populateTextStyle(String id, TextStyle style, TextStyle defaults) {
		// prepare
		String colorKey = PREFERENCE_TAG + PreferenceStoreAccessor.getTokenColorPreferenceKey(id);
		String backgroundKey = PREFERENCE_TAG + getTokenBackgroundColorPreferenceKey(id);
		String fontKey = PREFERENCE_TAG + getTokenFontPreferenceKey(id);
		String styleKey = PREFERENCE_TAG + getTokenStylePreferenceKey(id);

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
		IPreferenceStore preferenceStore = getPreferenceStore();
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

	private IPreferenceStore getPreferenceStore() {
		return scopedAccessor.getWritablePreferenceStore();
	}

	private Device getDisplay() {
		Display display = Display.getCurrent();
		return display == null ? Display.getDefault() : display;
	}

	public static String getTokenColorPreferenceKey(String tokenType) {
		return tokenType + SEPARATOR + CommonPreferenceConstants.COLOR_SUFFIX;
	}

	public static String getTokenBackgroundColorPreferenceKey(String tokenType) {
		return tokenType + SEPARATOR + BACKGROUNDCOLOR_SUFFIX;
	}

	public static String getTokenFontPreferenceKey(String tokenType) {
		return tokenType + SEPARATOR + FONT_SUFFIX;
	}

	public static String getTokenStylePreferenceKey(String tokenType) {
		return tokenType + SEPARATOR + STYLE_SUFFIX;
	}

	public static String syntaxColorerTag(String languageName) {
		return languageName + SEPARATOR + SYNTAX_COLORER_PREFERENCE_TAG;
	}

	public static String tokenTypeTag(String languageName) {
		return syntaxColorerTag(languageName) + SEPARATOR + TOKEN_STYLES_PREFERENCE_TAG;
	}
}