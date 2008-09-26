/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import java.util.List;

import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokentype.ITokenTypeDef;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokentype.ITokenTypeDefProvider;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokentype.TokenTypeDefMasterDetailFieldEditor;
import org.eclipse.xtext.ui.core.editor.preferences.AbstractPreferencePage;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class SyntaxColoringPreferencePage extends AbstractPreferencePage {

	@Inject
	private ITokenTypeDefProvider ttd;

	@Override
	protected String qualifiedName() {
		return PreferenceConstants.syntaxColorerTag(getServiceScope());
	}

	@Override
	protected void createFieldEditors() {
		List<ITokenTypeDef> allTokenTypes = ttd.allTokenTypes();
		refreshTokenStyles(allTokenTypes);
		addField(new TokenTypeDefMasterDetailFieldEditor(PreferenceConstants.TOKEN_STYLES_PREFERENCE_TAG,
				"Token Styles", getFieldEditorParent(), getPreferenceStore(), allTokenTypes));
	}

	/**
	 * @param allTokenTypes
	 */
	private void refreshTokenStyles(List<ITokenTypeDef> allTokenTypes) {
		PropertiesResolver propertiesResolver = new PropertiesResolver(getServiceScope());
		for (ITokenTypeDef tokenTypeDef : allTokenTypes) {
			propertiesResolver
					.populateTextStyle(tokenTypeDef.getId(), new TextStyle(), tokenTypeDef.defaultTextStyle());
		}
	}

}
