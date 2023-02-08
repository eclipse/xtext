/*******************************************************************************
 * Copyright (c) 2008, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import static org.eclipse.xtext.ui.editor.preferences.PreferenceConstants.*;
import static org.eclipse.xtext.ui.editor.syntaxcoloring.CommonPreferenceConstants.*;

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
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.editor.preferences.FixedScopedPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class PreferenceStoreAccessor {
	private final String PREFERENCE_TAG;
	private final IPreferenceStoreAccess scopedAccessor;
	private final String CSS_PREFIX = SYNTAX_COLORER_PREFERENCE_TAG + SEPARATOR;

	@Inject
	private AbstractUIPlugin plugin;
	
	@Inject
	public PreferenceStoreAccessor(@Named(Constants.LANGUAGE_NAME) String languageName, IPreferenceStoreAccess scopedAccessor) {
		PREFERENCE_TAG = tokenTypeTag(languageName) + SEPARATOR;
		this.scopedAccessor = scopedAccessor;
	}

	public void populateTextStyle(String id, TextStyle style, TextStyle defaults) {
		IPreferenceStore editorsStore = EditorsUI.getPreferenceStore();
		RGB fontColorSystemDefault = editorsStore.getBoolean(AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND_SYSTEM_DEFAULT) 
				? getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND).getRGB()
				: PreferenceConverter.getColor(editorsStore, AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND);
		RGB backgroundColorSystemDefault = editorsStore.getBoolean(AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT) 
				? getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND).getRGB() 
				: PreferenceConverter.getColor(editorsStore, AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND);
		FontData[] fontDataDefaultDefault = JFaceResources.getTextFont().getFontData();

		IPreferenceStore preferenceStore = getPreferenceStore();
		String cssID = CSS_PREFIX + id;
		IPreferenceStore cssPrefStore = getPluginCssPreferenceStore();
		
		String colorKey = PREFERENCE_TAG + getTokenColorPreferenceKey(id);
		String cssFontColor = cssPrefStore.getString(getTokenColorPreferenceKey(cssID));
		if(!Strings.isEmpty(cssFontColor)) {
			preferenceStore.setDefault(colorKey, cssFontColor);
		} else if (defaults.getColor() != null) {
			PreferenceConverter.setDefault(preferenceStore, colorKey, defaults.getColor());
		} else {
			PreferenceConverter.setDefault(preferenceStore, colorKey, fontColorSystemDefault);
		}
		
		String backgroundKey = PREFERENCE_TAG + getTokenBackgroundColorPreferenceKey(id);
		String cssBgColor = cssPrefStore.getString(getTokenBackgroundColorPreferenceKey(cssID));
		if(!Strings.isEmpty(cssBgColor)) {
			preferenceStore.setDefault(backgroundKey, cssBgColor);
		} else if (defaults.getBackgroundColor() != null) {
			PreferenceConverter.setDefault(preferenceStore, backgroundKey, defaults.getBackgroundColor());
		} else {
			PreferenceConverter.setDefault(preferenceStore, backgroundKey, backgroundColorSystemDefault);
		}
		
		String fontKey = PREFERENCE_TAG + getTokenFontPreferenceKey(id);
		String cssFont = cssPrefStore.getString(getTokenFontPreferenceKey(cssID));
		if(!Strings.isEmpty(cssFont)) {
			preferenceStore.setDefault(fontKey, cssFont);
		} else if (defaults.getFontData() != null)
			PreferenceConverter.setDefault(preferenceStore, fontKey, defaults.getFontData());
		else {
			PreferenceConverter.setDefault(preferenceStore, fontKey, fontDataDefaultDefault);
		}
		
		String styleKey = PREFERENCE_TAG + getTokenStylePreferenceKey(id);
		int cssStyle = cssPrefStore.getInt(getTokenStylePreferenceKey(cssID));
		if(cssStyle != 0) {
			preferenceStore.setDefault(styleKey, cssStyle);
		} else {
			preferenceStore.setDefault(styleKey, defaults.getStyle());
		}
		
		// populate
		RGB color = PreferenceConverter.getColor(preferenceStore, colorKey);
		if (!color.equals(fontColorSystemDefault))
			style.setColor(color);
		RGB background = PreferenceConverter.getColor(preferenceStore, backgroundKey);
		if (!background.equals(backgroundColorSystemDefault))
			style.setBackgroundColor(background);
		FontData[] fontDataArray = PreferenceConverter.getFontDataArray(preferenceStore, fontKey);
		if (!Arrays.equals(fontDataArray, fontDataDefaultDefault)) {
			style.setFontData(fontDataArray);
		}
		style.setStyle(preferenceStore.getInt(styleKey));
	}

	private ChainedPreferenceStore getPluginCssPreferenceStore() {
		return new ChainedPreferenceStore(new IPreferenceStore[] {
				new FixedScopedPreferenceStore(InstanceScope.INSTANCE, plugin.getBundle().getSymbolicName()),
				new FixedScopedPreferenceStore(InstanceScope.INSTANCE, Activator.getDefault().getBundle().getSymbolicName())
		});
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