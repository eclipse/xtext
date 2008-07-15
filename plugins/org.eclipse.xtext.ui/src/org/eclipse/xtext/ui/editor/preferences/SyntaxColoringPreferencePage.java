/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;

import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.editor.preferences.fields.TokenTypeDefMasterDetailFieldEditor;
import org.eclipse.xtext.ui.service.ITokenTypeDefProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class SyntaxColoringPreferencePage extends AbstractPreferencePage {
	@Override
	protected void createFieldEditors() {
		ITokenTypeDefProvider ttd = ServiceRegistry.getService(getLanguageDescriptor(), ITokenTypeDefProvider.class);
		addField(new TokenTypeDefMasterDetailFieldEditor(getPreferenceStore(), qualifiedName(), "Token Style", ttd
				.allTokenTypes(), getFieldEditorParent()));
	}
	@Override
	public String qualifiedName() {
		return super.qualifiedName();
	}
}
