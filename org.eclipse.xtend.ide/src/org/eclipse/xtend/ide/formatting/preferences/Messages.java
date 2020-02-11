/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import org.eclipse.osgi.util.NLS;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtend.ide.formatting.preferences.messages"; //$NON-NLS-1$
	public static String AbstractProfileManager_unmanaged_profile_with_name;
	public static String AbstractProfileManager_unmanaged_profile;
	public static String FormatterConfigurationBlock_DefaultProfileLabel;
	public static String FormatterConfigurationBlock_XtendCodePreview;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
