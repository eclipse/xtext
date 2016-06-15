/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.editor.preferences.fields.AbstractDetailsPart;
import org.eclipse.xtext.ui.editor.preferences.fields.CheckBoxGroupFieldEditor;

/**
 * @author Dennis Hübner - Initial contribution and API
 *
 */
public class TokenTypeDefDetailsPart extends AbstractDetailsPart {

	public TokenTypeDefDetailsPart(IPreferenceStore preferenceStore) {
		super(preferenceStore);
	}

	@Override
	protected void createFieldEditors() {
		{
			// Foreground
			addField(new ColorFieldEditor(CommonPreferenceConstants.COLOR_SUFFIX, "Color", getFieldEditorParent()));

			// Background
			addField(new ColorFieldEditor(CommonPreferenceConstants.BACKGROUNDCOLOR_SUFFIX, "Background",
					getFieldEditorParent()));
			// Style
			// TODO extract a FontStyleCheckBoxGroupFieldEditor
			addField(new CheckBoxGroupFieldEditor(CommonPreferenceConstants.STYLE_SUFFIX, "Style", 2, new String[][] {
					{ "Italic", String.valueOf(SWT.ITALIC) }, { "Bold", String.valueOf(SWT.BOLD) },
					{ "Underline", String.valueOf(TextAttribute.UNDERLINE) },
					{ "Strike through", String.valueOf(TextAttribute.STRIKETHROUGH) }, }, getFieldEditorParent(), true) {
				@Override
				protected String calculateResult(String[][] settings) {
					int result = SWT.NORMAL;
					for (int i = 0; i < settings.length; i++) {
						String[] row = settings[i];
						String value = row[1];
						String checked = row[2];
						if (Boolean.valueOf(checked)) {
							result += Integer.valueOf(value);
						}
					}
					return String.valueOf(result);
				}

				@Override
				protected boolean isSelected(String fieldName, String valueToSet) {
					int value = SWT.NORMAL;
					try {
						value = Integer.valueOf(valueToSet);
					}
					catch (NumberFormatException nfe) {
						// ignore preference value
						return false;
					}
					if (value == SWT.NORMAL)
						return false;
					if (fieldName.equals("Italic"))
						return (value & SWT.ITALIC) == SWT.ITALIC;
					else if (fieldName.equals("Bold"))
						return (value & SWT.BOLD) == SWT.BOLD;
					else if (fieldName.equals("Underline"))
						return (value & TextAttribute.UNDERLINE) == TextAttribute.UNDERLINE;
					else if (fieldName.equals("Strike through"))
						return (value & TextAttribute.STRIKETHROUGH) == TextAttribute.STRIKETHROUGH;
					return false;
				}
			});
			// Font
			addField(new FontFieldEditor(CommonPreferenceConstants.FONT_SUFFIX, "Font", getFieldEditorParent()));
		}
	}
}