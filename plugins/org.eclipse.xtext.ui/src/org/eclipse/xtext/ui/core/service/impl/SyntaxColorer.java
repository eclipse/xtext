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
import org.eclipse.jface.resource.DataFormatException;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.parser.ITokenTypes;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.InjectedService;
import org.eclipse.xtext.ui.core.TokenTypeResolver;
import org.eclipse.xtext.ui.core.internal.CoreLog;
import org.eclipse.xtext.ui.core.service.IPreferenceStoreService;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Dennis Hübner
 * 
 */
public class SyntaxColorer implements ISyntaxColorer {

	private IPreferenceStoreService preferenceStoreService;

	public TextAttribute color(LeafNode leafNode) {
		return colorInternal(leafNode);
	}

	private TextAttribute colorInternal(LeafNode node) {
		String tokenType = TokenTypeResolver.getTokenType(node);
		if (!(ITokenTypes.KEYWORD.equals(tokenType) && node.length() == 1)) {
			return new TextAttribute(getColorForTokenType(tokenType), getBackgroundColorForTokenType(tokenType),
					getStyleForTokenType(tokenType), getFontForTokenType(tokenType));
		}
		return new TextAttribute(null);
	}

	@InjectedService
	public void setPreferenceStoreService(IPreferenceStoreService preferenceStoreService) {
		this.preferenceStoreService = preferenceStoreService;
	}

	private IPreferenceStore getPreferenceStore() {
		return preferenceStoreService.getPersitablePreferenceStore();
	}

	private int getStyleForTokenType(String tokenType) {
		return getPreferenceStore().getInt(PreferenceStore.getTokenStylePreferenceKey(tokenType));
	}

	private Font getFontForTokenType(String tokenType) {
		return null;
	}

	private Color getBackgroundColorForTokenType(String tokenType) {
		String tokenBackgroundColorPreferenceKey = PreferenceStore.getTokenBackgroundColorPreferenceKey(tokenType);
		String rgbString = getPreferenceStore().getString(tokenBackgroundColorPreferenceKey);
		return colorFromString(rgbString, tokenBackgroundColorPreferenceKey);
	}

	private Color colorFromString(String rgbString, String preferenceKey) {
		if (rgbString.trim().length() > 0) {
			Color col = JFaceResources.getColorRegistry().get(rgbString);
			try {
				if (col == null) {
					RGB rgb = StringConverter.asRGB(rgbString);
					JFaceResources.getColorRegistry().put(rgbString, rgb);
					col = JFaceResources.getColorRegistry().get(rgbString);
				}
			}
			catch (DataFormatException e) {
				CoreLog.logError("Corrupt preference value for '" + preferenceKey + "' color.", e);
			}
			return col;
		}
		return null;
	}

	private Color getColorForTokenType(String tokenType) {
		String preferenceKey = PreferenceStore.getTokenColorPreferenceKey(tokenType);
		return colorFromString(getPreferenceStore().getString(preferenceKey), preferenceKey);
	}

}
