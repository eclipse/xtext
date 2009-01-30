/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.ui.common.editor.preferencepage.CommonPreferenceConstants;
import org.eclipse.xtext.ui.core.editor.preferences.AbstractPreferencePage;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class SyntaxColoringPreferencePage extends AbstractPreferencePage {

	@Inject
	private ITokenStyleProvider tokenStyleProvider;

	@Override
	protected String qualifiedName() {
		return PreferenceStoreAccessor.syntaxColorerTag(getServiceScope());
	}

	@Override
	protected void createFieldEditors() {
		final List<ITokenStyle> allTokenStyles = Arrays.asList(tokenStyleProvider.getTokenStyles());
		refreshTokenStyles(allTokenStyles);
		addField(new TokenTypeDefMasterDetailFieldEditor(CommonPreferenceConstants.TOKEN_STYLES_PREFERENCE_TAG,
				"Token Styles", getFieldEditorParent(), getPreferenceStore(), allTokenStyles));
	}

	/**
	 * @param allTokenStyles
	 */
	private void refreshTokenStyles(List<ITokenStyle> allTokenStyles) {
		PreferenceStoreAccessor preferenceStoreAccessor = new PreferenceStoreAccessor(getServiceScope());
		for (ITokenStyle tokenTypeDef : allTokenStyles) {
			preferenceStoreAccessor.populateTextStyle(tokenTypeDef.getID(), new TextStyle(), tokenTypeDef.getDefaultTextStyle());
		}
	}

}
