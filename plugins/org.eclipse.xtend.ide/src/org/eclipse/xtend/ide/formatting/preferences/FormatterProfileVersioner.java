/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.CustomProfile;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class FormatterProfileVersioner implements IProfileVersioner {

	private static final String XTEND_FORMATTER_PROFILE = "XtendForamtterProfile";

	public int getFirstVersion() {
		return 0;
	}

	public int getCurrentVersion() {
		return 0;
	}

	public String getProfileKind() {
		return XTEND_FORMATTER_PROFILE;
	}

	public void update(CustomProfile profile) {
		//Nothing to do
	}

}
