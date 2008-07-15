/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences.fields;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.ui.service.impl.BuiltInPreferenceStore;

public class TokenTypeDefDetailsPart extends AbstractDetailsPart {

	public TokenTypeDefDetailsPart(IPreferenceStore preferenceStore) {
		super(preferenceStore);
	}

	@Override
	protected void createFieldEditors() {
		{
			addField(new ColorFieldEditor(BuiltInPreferenceStore.COLOR_SUFIX, "Color", getFieldEditorParent()));
			addField(new ColorFieldEditor(BuiltInPreferenceStore.BACKGROUNDCOLOR_SUFIX, "Background",
					getFieldEditorParent()));
			addField(new FontFieldEditor(BuiltInPreferenceStore.FONT_SUFIX, "Font", getFieldEditorParent()));
		}
	}
}