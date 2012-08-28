/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jdt.internal.ui.preferences.PreferencesAccess;
import org.eclipse.jdt.internal.ui.preferences.formatter.FormatterProfileManager;
import org.eclipse.jdt.internal.ui.preferences.formatter.FormatterProfileStore;
import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialog;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileConfigurationBlock;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.Profile;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileStore;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileVersioner;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * @author dhuebner - Initial contribution and API
 */
public class FormatterConfigurationBlock extends ProfileConfigurationBlock {

	public FormatterConfigurationBlock(IProject project, PreferencesAccess access, String lastSaveLoadPathKey) {
		super(project, access, lastSaveLoadPathKey);
	}

	@Override
	protected IProfileVersioner createProfileVersioner() {
		return new ProfileVersioner();
	}

	@Override
	protected ProfileStore createProfileStore(IProfileVersioner profileVersioner) {
		return new FormatterProfileStore(profileVersioner);
	}

	@Override
	protected ProfileManager createProfileManager(List profiles, IScopeContext context, PreferencesAccess access,
			IProfileVersioner profileVersioner) {
		return new XtendFormatterProfileManager(profiles, context, access, profileVersioner);
	}

	@Override
	protected ModifyDialog createModifyDialog(Shell shell, Profile profile, ProfileManager profileManager,
			ProfileStore profileStore, boolean newProfile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void configurePreview(Composite composite, int numColumns, ProfileManager profileManager) {
		// TODO Auto-generated method stub
	}

}
