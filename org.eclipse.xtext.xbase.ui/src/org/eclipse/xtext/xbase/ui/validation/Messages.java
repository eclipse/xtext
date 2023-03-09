/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.validation;

import org.eclipse.osgi.util.NLS;

/**
 * @author dhuebner - Initial contribution and API
 * @author Holger Schill
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.xbase.ui.validation.messages"; //$NON-NLS-1$
	public static String XbaseValidationConfigurationBlock_deprecated_ref_label;
	public static String XbaseValidationConfigurationBlock_discouraged_ref_label;
	public static String XbaseValidationConfigurationBlock_forbidden_ref_label;
	public static String XbaseValidationConfigurationBlock_java_label;
	public static String XbaseValidationConfigurationBlock_not_java_message;
	public static String XbaseValidationConfigurationBlock_restricted_api_section_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
