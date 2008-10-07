/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.common.editor.preferencepage.CommonPreferenceConstants;
import org.eclipse.xtext.ui.core.editor.preferences.AbstractPreferencePage;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class SyntaxColoringPreferencePage extends AbstractPreferencePage {

	@Inject
	private AntlrTokenDefProvider tokenDefProvider;

	@Inject
	private ITokenColorer tc;

	@Override
	protected String qualifiedName() {
		return PreferenceStoreAccessor.syntaxColorerTag(getServiceScope());
	}

	@Override
	protected void createFieldEditors() {
		List<ITokenStyle> allTokenTypes = new ArrayList<ITokenStyle>();
		for (Integer id : tokenDefProvider.getTokenDefMap().keySet()) {
			ITokenStyle tokenStyle = tc.getTokenStyle(id);
			if (!allTokenTypes.contains(tokenStyle)) {
				allTokenTypes.add(tokenStyle);
			}
		}
		refreshTokenStyles(allTokenTypes);
		addField(new TokenTypeDefMasterDetailFieldEditor(CommonPreferenceConstants.TOKEN_STYLES_PREFERENCE_TAG,
				"Token Styles", getFieldEditorParent(), getPreferenceStore(), allTokenTypes));
	}

	/**
	 * @param allTokenTypes
	 */
	private void refreshTokenStyles(List<ITokenStyle> allTokenTypes) {
		PreferenceStoreAccessor preferenceStoreAccessor = new PreferenceStoreAccessor(getServiceScope());
		for (ITokenStyle tokenTypeDef : allTokenTypes) {
			preferenceStoreAccessor.populateTextStyle(tokenTypeDef.getID(), new TextStyle(), tokenTypeDef
					.getDefaultTextStyle());
		}
	}

}
