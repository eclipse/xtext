/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileStore;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class FormatterProfileStore extends ProfileStore {

	private static final String XTEND_PROFILES_KEY = "XtendFormatterProfile";

	public FormatterProfileStore(IProfileVersioner profileVersioner) {
		super(XTEND_PROFILES_KEY, profileVersioner);
	}

}
