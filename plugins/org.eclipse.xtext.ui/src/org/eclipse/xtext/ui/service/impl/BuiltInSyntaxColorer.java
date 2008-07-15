/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.ui.service.impl;

import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.service.IPreferenceStore;
import org.eclipse.xtext.ui.service.ISyntaxColorer;
import org.eclipse.xtext.ui.service.ITokenTypeDefProvider;
import org.eclipse.xtext.ui.tokentype.ITokenTypeDef;

/**
 * @author Dennis Hübner
 * 
 */
public class BuiltInSyntaxColorer implements ISyntaxColorer {

	private ITokenTypeDefProvider tokenTypeDef;
	private IPreferenceStore preferenceStore;
	private IServiceScope languageDescriptor;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.service.ISyntaxColorer#color(org.eclipse.xtext
	 * .parsetree.LeafNode)
	 */
	public TextStyle color(LeafNode leafNode) {
		TextStyle tsToSet = new TextStyle(null, null, SWT.NONE, null);
		for (ITokenTypeDef ttd : tokenTypeDef.allTokenTypes()) {
			if (ttd.match(leafNode)) {
				String tokenTypeId = ttd.getId();
				if (ttd.getTextStyle() != null) {
					tsToSet = ttd.getTextStyle();
				}
				TextStyle ts = new TextStyle(getColorForTokenType(tokenTypeId, tsToSet.getColor()),
						getBackgroundColorForTokenType(tokenTypeId, tsToSet.getBackgroundColor()),
						getStyleForTokenType(tokenTypeId, tsToSet.getStyle()), getFontForTokenType(tokenTypeId, tsToSet
								.getFontName()));
				return ts;
			}
		}
		return tsToSet;
	}

	@Inject
	public void setTokenTypeDefProvider(ITokenTypeDefProvider service) {
		this.tokenTypeDef = service;
	}

	@Inject
	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		this.preferenceStore = preferenceStore;
	}

	@Inject
	public void setLanguageDescriptor(IServiceScope languageDescriptor) {
		this.languageDescriptor = languageDescriptor;
	}

	private IPersistentPreferenceStore getPreferenceStore() {
		return preferenceStore.getPersitablePreferenceStore();
	}

	// TODO set defaults somewhere else if possible, or check if a default
	// already set
	private int getStyleForTokenType(String tokenType, int defaultStyle) {
		String tokenStylePreferenceKey = BuiltInPreferenceStore.getTokenStylePreferenceKey(languageDescriptor,
				tokenType);
		getPreferenceStore().setDefault(tokenStylePreferenceKey, defaultStyle);
		return getPreferenceStore().getInt(tokenStylePreferenceKey);
	}

	private String getFontForTokenType(String tokenType, String defaultFont) {
		String tokenFontPreferenceKey = BuiltInPreferenceStore.getTokenFontPreferenceKey(languageDescriptor, tokenType);
		if (defaultFont != null)
			getPreferenceStore().setDefault(tokenFontPreferenceKey, defaultFont);
		return getPreferenceStore().getString(tokenFontPreferenceKey);
	}

	private String getBackgroundColorForTokenType(String tokenType, String defaultBackgroundColor) {
		String tokenBackgroundColorPreferenceKey = BuiltInPreferenceStore.getTokenBackgroundColorPreferenceKey(
				languageDescriptor, tokenType);
		if (defaultBackgroundColor != null)
			getPreferenceStore().setDefault(
					BuiltInPreferenceStore.getTokenBackgroundColorPreferenceKey(languageDescriptor, tokenType),
					defaultBackgroundColor);
		String rgbString = getPreferenceStore().getString(tokenBackgroundColorPreferenceKey);
		return rgbString;
	}

	private String getColorForTokenType(String tokenType, String defaultColor) {
		String preferenceKey = BuiltInPreferenceStore.getTokenColorPreferenceKey(languageDescriptor, tokenType);
		if (defaultColor != null)
			getPreferenceStore().setDefault(
					BuiltInPreferenceStore.getTokenColorPreferenceKey(languageDescriptor, tokenType), defaultColor);
		String rgbString = getPreferenceStore().getString(preferenceKey);
		return rgbString;
	}

}
