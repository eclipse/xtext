/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;

import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.editor.preferences.fields.TokenTypeDefMasterDetailFieldEditor;
import org.eclipse.xtext.ui.service.IPreferenceStore;
import org.eclipse.xtext.ui.service.ITokenTypeDefProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class SyntaxColoringPreferencePage extends AbstractPreferencePage {
	
	@Inject
	private ITokenTypeDefProvider ttd;
	
	@Override
	protected void createFieldEditors() {
		addField(new TokenTypeDefMasterDetailFieldEditor(IPreferenceStore.TOKEN_STYLES_PREFERENCE_TAG,
				"Token Styles", getFieldEditorParent(), getPreferenceStore(), ttd.allTokenTypes()));
		addField(new StringFieldEditor("testFeld", "Test Field", getFieldEditorParent()));
	}

	@Override
	protected PreferencesQualifiedName qualifiedName() {
		return super.qualifiedName().append(IPreferenceStore.SYNTAX_COLORER_PREFERENCE_TAG);
	}
}
