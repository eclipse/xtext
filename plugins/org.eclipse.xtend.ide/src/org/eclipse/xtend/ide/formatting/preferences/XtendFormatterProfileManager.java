/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jdt.internal.ui.preferences.PreferencesAccess;
import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendFormatterProfileManager extends ProfileManager {

	private static final String DEFAULT_PROFILE_LABEL = "Default [built-in]";
	private static final KeySet[] KEY_SETS = new KeySet[] { new KeySet("Node name", new ArrayList(getXtendSettings()
			.keySet())) };
	private static final String DEFUALT_PROFILE_KEY = "org.eclipse.xtend.ide.default.eclipse_profile";
	private static final String PROFILE_KEY = DEFUALT_PROFILE_KEY;
	private static final String FORMATTER_SETTINGS_VERSION = "1";

	public XtendFormatterProfileManager(List profiles, IScopeContext context, PreferencesAccess preferencesAccess,
			IProfileVersioner profileVersioner) {
		super(addBuiltinProfiles(profiles, profileVersioner), context, preferencesAccess, profileVersioner, KEY_SETS,
				PROFILE_KEY, FORMATTER_SETTINGS_VERSION);
	}

	private static List addBuiltinProfiles(List profiles, IProfileVersioner profileVersioner) {
		final Profile javaProfile = new BuiltInProfile(DEFUALT_PROFILE_KEY, DEFAULT_PROFILE_LABEL, getXtendSettings(),
				1, profileVersioner.getCurrentVersion(), profileVersioner.getProfileKind());
		profiles.add(javaProfile);
		return profiles;
	}

	private static Map<Object, Object> getXtendSettings() {
		final Map<Object, Object> options = new HashMap<Object, Object>();
		return options;
	}

	@Override
	public Profile getDefaultProfile() {
		return getProfile(DEFUALT_PROFILE_KEY);
	}

}
