/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.common.editor.preferencepage.CommonPreferenceConstants;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Dennis Hübner - Initial contribution and API
 */
public abstract class AbstractTokenScanner implements ITokenScanner {

	private PreferenceStoreAccessor preferenceStoreAccessor;

	@Inject
	protected void setServiceScope(final IServiceScope scope) {
		this.preferenceStoreAccessor = new PreferenceStoreAccessor(scope);
		// XXX LITTLE HACK, adding PrefPage on the fly
		String languageTag = PreferenceStoreAccessor.languageTag(scope);
		String preferencePagePathSeparator = "/";
		String parentPreferencePagePath = languageTag + preferencePagePathSeparator + languageTag
				+ CommonPreferenceConstants.SEPARATOR + CommonPreferenceConstants.EDITOR_NODE_NAME;
		String syntaxColorerPrefPageTag = PreferenceStoreAccessor.syntaxColorerTag(scope);
		String preferencePagePath = parentPreferencePagePath + preferencePagePathSeparator + syntaxColorerPrefPageTag;
		if (PlatformUI.getWorkbench().getPreferenceManager().find(preferencePagePath) == null) {
			PreferenceNode node = new PreferenceNode(syntaxColorerPrefPageTag, "Syntax Colorer", null, null) {
				@Override
				public void createPage() {
					SyntaxColoringPreferencePage page = new SyntaxColoringPreferencePage();
					page.setTitle(getLabelText());
					ServiceRegistry.getInjector(scope).injectMembers(page);
					setPage(page);
				}
			};
			PlatformUI.getWorkbench().getPreferenceManager().addTo(parentPreferencePagePath, node);
		}
		// TODO redraw/revalidate editor's StyledText control
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
		else {
			preferenceStoreAccessor.populateTextStyle(tokenStyle.getID(), textStyle, tokenStyle.getDefaultTextStyle());
		}
		int style = textStyle.getStyle();
		Font fontFromFontData = null;
		if (style == SWT.NORMAL) {
			fontFromFontData = EditorUtils.fontFromFontData(textStyle.getFontData());
		}
		return new TextAttribute(EditorUtils.colorFromRGB(textStyle.getColor()), EditorUtils.colorFromRGB(textStyle
				.getBackgroundColor()), style, fontFromFontData);
	}
}
