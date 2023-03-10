/*******************************************************************************
 * Copyright (c) 2008, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.preferences.ResetPromptDialogSettingsField;

import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class LanguageRootPreferencePage extends AbstractPreferencePage {
	private @Inject ResetPromptDialogSettingsField resetPromptDialogSettings;
	
	public LanguageRootPreferencePage () {
		noDefaultAndApplyButton();
	}

	@Override
	protected void createFieldEditors() {
		if (!isPropertyPage()) {
			Composite parent = getFieldEditorParent();
			addField(resetPromptDialogSettings.getFieldEditor(parent));
		}
	}

	/**
	 * @since 2.1
	 */
	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return super.doGetPreferenceStore();
	}
}
