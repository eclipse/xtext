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

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class FormatterModifyDialog extends ModifyDialog {

	public FormatterModifyDialog(Shell parentShell, Profile profile, ProfileManager profileManager,
			ProfileStore profileStore, boolean newProfile, String dialogPreferencesKey, String lastSavePathKey) {
		super(parentShell, profile, profileManager, profileStore, newProfile, dialogPreferencesKey, lastSavePathKey);
	}

	@Override
	protected void addPages(@SuppressWarnings("rawtypes") final Map values) {
		addTabPage("Prototype", new IndentationTab(this, values));
	}

	@Override
	protected String getHelpContextId() {
		return null;
	}

}
