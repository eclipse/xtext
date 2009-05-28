/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Dennis Hübner - Initial contribution and API
 */
public abstract class AbstractTokenScanner implements ITokenScanner {

	private final PreferenceStoreAccessor preferenceStoreAccessor;

	protected AbstractTokenScanner(final PreferenceStoreAccessor accessor) {
		this.preferenceStoreAccessor = accessor;
	}

	protected TextAttribute createTextAttribute(ITokenStyle tokenStyle) {
		TextStyle textStyle = new TextStyle();
		// we need difference to an default TextAttribute(null,null,0,null) in
		// DefaultDamagerRepair
		if (tokenStyle == null) {
			return new TextAttribute(null, null, 0, null) {
				@Override
				public boolean equals(Object object) {
					return false;
				}
			};
		}
		preferenceStoreAccessor.populateTextStyle(tokenStyle.getID(), textStyle, tokenStyle.getDefaultTextStyle());
		int style = textStyle.getStyle();
		Font fontFromFontData = null;
		if (style == SWT.NORMAL) {
			fontFromFontData = EditorUtils.fontFromFontData(textStyle.getFontData());
		}
		return new TextAttribute(EditorUtils.colorFromRGB(textStyle.getColor()), EditorUtils.colorFromRGB(textStyle
				.getBackgroundColor()), style, fontFromFontData);
	}
}
