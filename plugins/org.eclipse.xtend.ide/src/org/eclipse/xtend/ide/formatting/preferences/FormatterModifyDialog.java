/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;

import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialog;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.Profile;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileStore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;
import org.eclipse.xtend.ide.formatting.FormatterPreferenceInfra;
import org.eclipse.xtend.ide.formatting.SettingsData.Category;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class FormatterModifyDialog extends ModifyDialog {
	public static class Factory {

		@Inject
		MembersInjector<FormatterModifyDialog> injector;

		public FormatterModifyDialog create(Shell parentShell, Profile profile, ProfileManager profileManager,
				ProfileStore profileStore, boolean newProfile, String dialogPreferencesKey, String lastSavePathKey) {
			FormatterModifyDialog modifyDialog = new FormatterModifyDialog(parentShell, profile, profileManager,
					profileStore, newProfile, dialogPreferencesKey, lastSavePathKey);
			injector.injectMembers(modifyDialog);
			return modifyDialog;
		}

	}

	@Inject
	private AbstractModifyDialogTab.Factory tabFactory;

	public FormatterModifyDialog(Shell parentShell, Profile profile, ProfileManager profileManager,
			ProfileStore profileStore, boolean newProfile, String dialogPreferencesKey, String lastSavePathKey) {
		super(parentShell, profile, profileManager, profileStore, newProfile, dialogPreferencesKey, lastSavePathKey);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void addPages(final Map values) {
		for (Category category : Category.values()) {
			if (FormatterPreferenceInfra.settingsByCategory(category, new XtendFormatterConfig(values)).iterator()
					.hasNext()) {
				addTabPage(category.getLabel(), tabFactory.createGenericTab(this, values, category));
			}
		}
	}

	@Override
	protected String getHelpContextId() {
		return null;
	}

}
