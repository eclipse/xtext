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
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.parser.ITokenTypes;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.internal.Activator;
import org.eclipse.xtext.ui.core.internal.CoreLog;
import org.eclipse.xtext.ui.core.language.AbstractLanguageService;
import org.eclipse.xtext.ui.core.language.LanguageServiceFactory;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Dennis Hübner
 * 
 */
public class SyntaxColorer extends AbstractLanguageService implements ISyntaxColorer {

	public TextAttribute color(LeafNode leafNode) {
		return colorInternal(leafNode);
	}

	private TextAttribute colorInternal(LeafNode node) {
		if (!(ITokenTypes.KEYWORD.equals(node.tokenType()) && node.length() == 1)) {
			return new TextAttribute(getColorForTokenType(node), getBackgroundColorForTokenType(node),
					getStyleForTokenType(node), getFontForTokenType(node));
		}
		return new TextAttribute(null);
	}

	private IPreferenceStore getPreferenceStore() {
		return LanguageServiceFactory.getInstance().getPreferenceStore(getLanguageDescriptor())
				.getPersitablePreferenceStore();
	}

	private int getStyleForTokenType(LeafNode node) {
		return getPreferenceStore().getInt(PreferenceStore.getTokenStylePreferenceKey(node.tokenType()));
	}

	private Font getFontForTokenType(LeafNode node) {
		return null;
	}

	private Color getBackgroundColorForTokenType(LeafNode node) {
		String rgbString = getPreferenceStore().getString(
				PreferenceStore.getTokenBackgroundColorPreferenceKey(node.tokenType()));
		if (rgbString.trim().length() > 0) {
			try {
				RGB rgb = StringConverter.asRGB(rgbString);
				return Activator.getDefault().getResourceLibrary().getColor(rgb);
			}
			catch (DataFormatException e) {
				CoreLog.logError("Corrupt preference value for background color. TokenType:" + node.tokenType(), e);
			}
		}
		return null;
	}

	private Color getColorForTokenType(LeafNode node) {
		String rgbString = getPreferenceStore().getString(PreferenceStore.getTokenColorPreferenceKey(node.tokenType()));
		if (rgbString.trim().length() > 0) {
			try {
				RGB rgb = StringConverter.asRGB(rgbString);
				return Activator.getDefault().getResourceLibrary().getColor(rgb);
			}
			catch (DataFormatException e) {
				CoreLog.logError("Corrupt preference value for color. TokenType:" + node.tokenType(), e);
			}
		}
		return null;
	}

}
