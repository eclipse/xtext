/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference.ui.preferences;

import org.eclipse.xtext.reference.ui.services.ReferenceTokenTypeDef;
import org.eclipse.xtext.ui.editor.preferences.AbstractRootPreferencePage;
import org.eclipse.xtext.ui.editor.preferences.TokenTypeDefMasterDetailFieldEditor;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class SyntaxColoringPreferencePage extends AbstractRootPreferencePage {

	@Override
	protected void createFieldEditors() {
		ReferenceTokenTypeDef rttd = new ReferenceTokenTypeDef();
		addField(new TokenTypeDefMasterDetailFieldEditor(getPreferenceStore(), qualifiedName(), "Token Style", rttd
				.allTokenTypes(), getFieldEditorParent()));
	}
}
