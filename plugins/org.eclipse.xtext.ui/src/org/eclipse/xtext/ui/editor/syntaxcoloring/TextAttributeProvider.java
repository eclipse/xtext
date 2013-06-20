/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class TextAttributeProvider implements ITextAttributeProvider, IHighlightingConfigurationAcceptor, IPropertyChangeListener {

	private final PreferenceStoreAccessor preferencesAccessor;
	private final HashMap<String, TextAttribute> attributes;
	private final IHighlightingConfiguration highlightingConfig;

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
		attributes.clear();
		highlightingConfig.configure(this);
	}
	
	public TextAttribute getAttribute(String id) {
		return attributes.get(id);
	}
	
	public TextAttribute getMergedAttributes(String[] ids) {
		if (ids.length < 2)
			throw new IllegalStateException();
		String mergedIds = getMergedIds(ids);
		TextAttribute result = getAttribute(mergedIds);
		if (result == null) {
			for(String id: ids) {
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

	public void propertyChange(PropertyChangeEvent event) {
		initialize();
	}

	public void acceptDefaultHighlighting(String id, String name, TextStyle style) {
		if (this.attributes.put(id, createTextAttribute(id, style)) != null)
			throw new IllegalStateException("Id '" + id + "' has been used twice.");
	}

	protected TextAttribute createTextAttribute(String id, TextStyle defaultTextStyle) {
		TextStyle textStyle = new TextStyle();
		preferencesAccessor.populateTextStyle(id, textStyle, defaultTextStyle);
		int style = textStyle.getStyle();
		Font fontFromFontData = EditorUtils.fontFromFontData(textStyle.getFontData());
		return new TextAttribute(
				EditorUtils.colorFromRGB(textStyle.getColor()),
				EditorUtils.colorFromRGB(textStyle.getBackgroundColor()),
				style, fontFromFontData);
	}
	
}
