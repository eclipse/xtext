/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import org.eclipse.osgi.util.NLS;

/**
 * @author skomp - Initial contribution and API
 * @author Holger Schill
 * @author Karsten Thoms - bug#378821
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtend.ide.wizards.messages"; //$NON-NLS-1$
	public static String ERROR_CREATING_PACKAGE;
	public static String ERROR_CREATING_CLASS;
	public static String ERROR_CREATING_INTERFACE;
	public static String ERROR_CREATING_ENUM;
	public static String ERROR_CREATING_ANNOTATION;
	public static String XTEND_CLASS_WIZARD_DESCRIPTION;
	public static String XTEND_INTERFACE_WIZARD_DESCRIPTION;
	public static String XTEND_ENUM_WIZARD_DESCRIPTION;
	public static String XTEND_ANNOTATION_WIZARD_DESCRIPTION;
	public static String TYPE_EXISTS_0;
	public static String TYPE_EXISTS_1;
	public static String METHODS_MAIN;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
