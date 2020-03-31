/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
			addField(new ColorFieldEditor(CommonPreferenceConstants.COLOR_SUFFIX, Messages.TokenTypeDefDetailsPart_ColorField, getFieldEditorParent()));

			// Background
			addField(new ColorFieldEditor(CommonPreferenceConstants.BACKGROUNDCOLOR_SUFFIX, Messages.TokenTypeDefDetailsPart_BackgroundColorField,
					getFieldEditorParent()));
			// Style
			// TODO extract a FontStyleCheckBoxGroupFieldEditor
			addField(new CheckBoxGroupFieldEditor(CommonPreferenceConstants.STYLE_SUFFIX, Messages.TokenTypeDefDetailsPart_FontStyleGroupField, 2, new String[][] {
					{ Messages.TokenTypeDefDetailsPart_ItalicFontStyle, String.valueOf(SWT.ITALIC) }, { Messages.TokenTypeDefDetailsPart_BoldFontStyle, String.valueOf(SWT.BOLD) },
					{ Messages.TokenTypeDefDetailsPart_UnderlineFontStyle, String.valueOf(TextAttribute.UNDERLINE) },
					{ Messages.TokenTypeDefDetailsPart_StrikeTroughFontStyle, String.valueOf(TextAttribute.STRIKETHROUGH) }, }, getFieldEditorParent(), true) {
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
					if (fieldName.equals(Messages.TokenTypeDefDetailsPart_ItalicFontStyle))
						return (value & SWT.ITALIC) == SWT.ITALIC;
					else if (fieldName.equals(Messages.TokenTypeDefDetailsPart_BoldFontStyle))
						return (value & SWT.BOLD) == SWT.BOLD;
					else if (fieldName.equals(Messages.TokenTypeDefDetailsPart_UnderlineFontStyle))
						return (value & TextAttribute.UNDERLINE) == TextAttribute.UNDERLINE;
					else if (fieldName.equals(Messages.TokenTypeDefDetailsPart_StrikeTroughFontStyle))
						return (value & TextAttribute.STRIKETHROUGH) == TextAttribute.STRIKETHROUGH;
					return false;
				}
			});
			// Font
			addField(new FontFieldEditor(CommonPreferenceConstants.FONT_SUFFIX, Messages.TokenTypeDefDetailsPart_FontField, getFieldEditorParent()));
		}
	}
}