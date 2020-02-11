/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.util.SWTUtil;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class TextAttributeProvider implements ITextAttributeProvider, IHighlightingConfigurationAcceptor,
		IPropertyChangeListener {

	private final PreferenceStoreAccessor preferencesAccessor;
	private final HashMap<String, TextAttribute> attributes;
	private final IHighlightingConfiguration highlightingConfig;
	private @Inject @Named(Constants.LANGUAGE_NAME) String languageName;

	@Inject
	public TextAttributeProvider(IHighlightingConfiguration highlightingConfig,
			IPreferenceStoreAccess preferenceStoreAccess, PreferenceStoreAccessor prefStoreAccessor) {
		this.highlightingConfig = highlightingConfig;
		this.preferencesAccessor = prefStoreAccessor;
		this.attributes = new HashMap<String, TextAttribute>();
		preferenceStoreAccess.getPreferenceStore().addPropertyChangeListener(this);
		initialize();
	}

	private void initialize() {
		if (Display.getCurrent() == null) {
			Display display = SWTUtil.getStandardDisplay();
			if (display != null) {
				display.asyncExec(new Runnable() {
					@Override
					public void run() {
						attributes.clear();
						highlightingConfig.configure(TextAttributeProvider.this);
					}
				});
			}
		} else {
			attributes.clear();
			highlightingConfig.configure(this);
		}
	}

	@Override
	public TextAttribute getAttribute(String id) {
		return attributes.get(id);
	}

	@Override
	public TextAttribute getMergedAttributes(String[] ids) {
		if (ids.length < 2)
			throw new IllegalStateException();
		String mergedIds = getMergedIds(ids);
		TextAttribute result = getAttribute(mergedIds);
		if (result == null) {
			for (String id : ids) {
				result = merge(result, getAttribute(id));
			}
			if (result != null)
				attributes.put(mergedIds, result);
			else
				attributes.remove(mergedIds);
		}
		return result;
	}

	private TextAttribute merge(TextAttribute first, TextAttribute second) {
		if (first == null)
			return second;
		if (second == null)
			return first;
		int style = first.getStyle() | second.getStyle();
		Color fgColor = second.getForeground();
		if (fgColor == null)
			fgColor = first.getForeground();
		Color bgColor = second.getBackground();
		if (bgColor == null)
			bgColor = first.getBackground();
		Font font = second.getFont();
		if (font == null)
			font = first.getFont();
		return new TextAttribute(fgColor, bgColor, style, font);
	}

	public String getMergedIds(String[] ids) {
		return "$$$Merged:" + Strings.concat("/", Arrays.asList(ids)) + "$$$";
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().startsWith(PreferenceStoreAccessor.tokenTypeTag(languageName))) {
			initialize();
		}
	}

	@Override
	public void acceptDefaultHighlighting(String id, String name, TextStyle style) {
		if (this.attributes.put(id, createTextAttribute(id, style)) != null)
			throw new IllegalStateException("Id '" + id + "' has been used twice.");
	}

	protected TextAttribute createTextAttribute(String id, TextStyle defaultTextStyle) {
		TextStyle textStyle = new TextStyle();
		preferencesAccessor.populateTextStyle(id, textStyle, defaultTextStyle);
		int style = textStyle.getStyle();
		Font fontFromFontData = EditorUtils.fontFromFontData(textStyle.getFontData());
		return new TextAttribute(EditorUtils.colorFromRGB(textStyle.getColor()), EditorUtils.colorFromRGB(textStyle
				.getBackgroundColor()), style, fontFromFontData);
	}

}
