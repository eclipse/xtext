/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.buildpath;

import org.eclipse.osgi.util.NLS;

/**
 * @author huebner - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtend.ide.buildpath.messages"; //$NON-NLS-1$
	public static String XtendClasspathContainer_Description;
	public static String XtendContainerWizardPage_AboutContainer;
	public static String XtendContainerWizardPage_Desc;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
