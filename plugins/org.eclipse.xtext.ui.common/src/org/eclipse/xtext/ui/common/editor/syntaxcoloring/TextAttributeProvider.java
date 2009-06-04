/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import java.util.HashMap;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.xtext.ui.common.editor.preferencepage.IScopedPreferenceStoreAccessor;
import org.eclipse.xtext.ui.common.editor.preferencepage.PreferenceStoreAccessor;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class TextAttributeProvider implements ITextAttributeProvider, IHighlightingConfigurationAcceptor, IPropertyChangeListener {

	private final PreferenceStoreAccessor preferencesAccessor;
	private final HashMap<String, TextAttribute> attributes;
	private final ILexicalHighlightingConfiguration lexical;
	private final ISemanticHighlightingConfiguration semantic;

	@Inject
	public TextAttributeProvider(ILexicalHighlightingConfiguration lexical, ISemanticHighlightingConfiguration semantic,
			IScopedPreferenceStoreAccessor preferences, PreferenceStoreAccessor preferencesAccessor) {
		this.lexical = lexical;
		this.semantic = semantic;
		this.preferencesAccessor = preferencesAccessor;
		this.attributes = new HashMap<String, TextAttribute>();
		preferences.getStore().addPropertyChangeListener(this);
		initialize();
	}

	private void initialize() {
		attributes.clear();
		lexical.configure(this);
		semantic.configure(this);
	}
	
	public TextAttribute getAttribute(String id) {
		return attributes.get(id);
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
		Font fontFromFontData = null;
		if (style == SWT.NORMAL) {
			fontFromFontData = EditorUtils.fontFromFontData(textStyle.getFontData());
		}
		return new TextAttribute(
				EditorUtils.colorFromRGB(textStyle.getColor()),
				EditorUtils.colorFromRGB(textStyle.getBackgroundColor()),
				style, fontFromFontData);
	}
	
	
}
