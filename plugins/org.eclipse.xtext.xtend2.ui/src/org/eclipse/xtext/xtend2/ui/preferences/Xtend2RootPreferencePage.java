/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2RootPreferencePage extends LanguageRootPreferencePage {

	@Override
	protected void addField(FieldEditor editor) {
		super.addField(editor);
		super.addField(new BooleanFieldEditor(Xtend2Preferences.ENABLE_RENAME_REFACTORING, "Enable rename refactoring", getFieldEditorParent()));
	}
}
