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

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
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
	private TabFactory tabFactory;

	public FormatterModifyDialog(Shell parentShell, Profile profile, ProfileManager profileManager,
			ProfileStore profileStore, boolean newProfile, String dialogPreferencesKey, String lastSavePathKey) {
		super(parentShell, profile, profileManager, profileStore, newProfile, dialogPreferencesKey, lastSavePathKey);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void addPages(final Map values) {
//		addTabPage("Indentation", tabFactory.createIndentationTab(this, values));
		addTabPage("Braces", tabFactory.createBracesTab(this, values));
		addTabPage("White Space", tabFactory.createWhiteSpaceTab(this, values));
		addTabPage("Blank Lines", tabFactory.createBlankLinesTab(this, values));
		addTabPage("New Lines", tabFactory.createNewLineTab(this, values));
		addTabPage("Line Wrapping", tabFactory.createLineWrapTab(this, values));
	}
	
	@Override
	protected String getHelpContextId() {
		return null;
	}

}
