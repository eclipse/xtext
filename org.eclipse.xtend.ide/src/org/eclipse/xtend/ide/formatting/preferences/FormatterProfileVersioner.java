/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.CustomProfile;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class FormatterProfileVersioner implements IProfileVersioner {
	public static String PREFIX = "org.eclipse.xtend.formatter";

	public static String VERSION_KEY = ".version";

	@Override
	public int getFirstVersion() {
		return 1;
	}

	@Override
	public int getCurrentVersion() {
		return 1;
	}

	@Override
	public String getProfileKind() {
		return FormatterProfileStore.XTEND_PROFILES_KEY;
	}

	@Override
	public void update(CustomProfile profile) {
		//Nothing to do
	}

}
