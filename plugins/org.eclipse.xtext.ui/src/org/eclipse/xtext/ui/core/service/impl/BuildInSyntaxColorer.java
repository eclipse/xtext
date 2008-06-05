/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.ui.core.service.impl;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.InjectedService;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;
import org.eclipse.xtext.ui.core.service.IPreferenceStoreService;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;
import org.eclipse.xtext.ui.core.service.ITokenTypeDefService;
import org.eclipse.xtext.ui.core.tokentype.ITokenTypeDef;

/**
 * @author Dennis Hübner
 * 
 */
public class BuildInSyntaxColorer implements ISyntaxColorer {

	private ITokenTypeDefService tokenTypeDef;
	private IPreferenceStoreService preferenceStoreService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.core.service.ISyntaxColorer#color(org.eclipse.xtext
	 * .parsetree.LeafNode)
	 */
	public TextStyle color(LeafNode leafNode) {
		TextStyle defaultTs = new TextStyle(null, null, SWT.NONE, null);
		if (tokenTypeDef != null) {
			for (ITokenTypeDef ttd : tokenTypeDef.allTokenTypes()) {
				if (ttd.match(leafNode)) {
					String tokenTypeId = ttd.getId();
					if (ttd.getTextStyle() != null) {
						defaultTs = ttd.getTextStyle();
					}
					TextStyle ts = new TextStyle(getColorForTokenType(tokenTypeId, defaultTs.getColor()),
							getBackgroundColorForTokenType(tokenTypeId, defaultTs.getBackgroundColor()),
							getStyleForTokenType(tokenTypeId, defaultTs.getStyle()), getFontForTokenType(tokenTypeId,
									defaultTs.getFontName()));
					return ts;
				}
			}
		}
		return defaultTs;
	}

	@InjectedService
	public void setTokenTypeDefService(ITokenTypeDefService service) {
		this.tokenTypeDef = service;
	}

	@InjectedService
	public void setPreferenceStoreService(IPreferenceStoreService preferenceStoreService) {
		this.preferenceStoreService = preferenceStoreService;
	}

	private IPreferenceStore getPreferenceStore() {
		return preferenceStoreService.getPersitablePreferenceStore();
	}

	// TODO set defaults somewhere else if possible, or check if a default
	// already set
	private int getStyleForTokenType(String tokenType, int defaultStyle) {
		String tokenStylePreferenceKey = BuildInPreferenceStore.getTokenStylePreferenceKey(tokenType);
		getPreferenceStore().setDefault(tokenStylePreferenceKey, defaultStyle);
		return getPreferenceStore().getInt(tokenStylePreferenceKey);
	}

	private String getFontForTokenType(String tokenType, String defaultFont) {
		String tokenFontPreferenceKey = BuildInPreferenceStore.getTokenFontPreferenceKey(tokenType);
		if (defaultFont != null)
			getPreferenceStore().setDefault(tokenFontPreferenceKey, defaultFont);
		return getPreferenceStore().getString(tokenFontPreferenceKey);
	}

	private String getBackgroundColorForTokenType(String tokenType, String defaultBackgroundColor) {
		String tokenBackgroundColorPreferenceKey = BuildInPreferenceStore
				.getTokenBackgroundColorPreferenceKey(tokenType);
		if (defaultBackgroundColor != null)
			getPreferenceStore().setDefault(BuildInPreferenceStore.getTokenBackgroundColorPreferenceKey(tokenType),
					defaultBackgroundColor);
		String rgbString = getPreferenceStore().getString(tokenBackgroundColorPreferenceKey);
		return rgbString;
	}

	private String getColorForTokenType(String tokenType, String defaultColor) {
		String preferenceKey = BuildInPreferenceStore.getTokenColorPreferenceKey(tokenType);
		if (defaultColor != null)
			getPreferenceStore().setDefault(BuildInPreferenceStore.getTokenColorPreferenceKey(tokenType), defaultColor);
		String rgbString = getPreferenceStore().getString(preferenceKey);
		return rgbString;
	}

}
