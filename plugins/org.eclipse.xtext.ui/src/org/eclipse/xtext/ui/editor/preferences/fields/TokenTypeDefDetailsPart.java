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
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;

public class TokenTypeDefDetailsPart extends AbstractDetailsPart {

	public TokenTypeDefDetailsPart(IPreferenceStore preferenceStore) {
		super(preferenceStore);
	}

	@Override
	protected void createFieldEditors() {
		{
			addField(new ColorFieldEditor(PreferenceConstants.COLOR_SUFIX, "Color", getFieldEditorParent()));
			addField(new ColorFieldEditor(PreferenceConstants.BACKGROUNDCOLOR_SUFIX, "Background",
					getFieldEditorParent()));
			// TODO change this group to checkboxgroup to allow combined styles
			// Italic&Bold a.s.o
			addField(new RadioGroupFieldEditor(PreferenceConstants.STYLE_SUFIX, "Style", 2, new String[][] {
					{ "Italic", String.valueOf(SWT.ITALIC) }, { "Bold", String.valueOf(SWT.BOLD) },
					{ "Underline", String.valueOf(TextAttribute.UNDERLINE) },
					{ "Strike through", String.valueOf(TextAttribute.STRIKETHROUGH) },
					{ "Use Font Style", String.valueOf(SWT.NORMAL) } }, getFieldEditorParent(), true));
			addField(new FontFieldEditor(PreferenceConstants.FONT_SUFIX, "Font", getFieldEditorParent()));
		}
	}
}