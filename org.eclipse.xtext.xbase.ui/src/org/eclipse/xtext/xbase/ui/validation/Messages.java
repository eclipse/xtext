/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.validation;

import org.eclipse.osgi.util.NLS;

/**
 * @author dhuebner - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.xbase.ui.validation.messages"; //$NON-NLS-1$
	public static String XbaseValidationConfigurationBlock_build_dailog_project_message;
	public static String XbaseValidationConfigurationBlock_build_dailog_ws_message;
	public static String XbaseValidationConfigurationBlock_build_dialog_title;
	public static String XbaseValidationConfigurationBlock_build_job_title;
	public static String XbaseValidationConfigurationBlock_deprecated_ref_label;
	public static String XbaseValidationConfigurationBlock_discouraged_ref_label;
	public static String XbaseValidationConfigurationBlock_error;
	public static String XbaseValidationConfigurationBlock_forbidden_ref_label;
	public static String XbaseValidationConfigurationBlock_ignore;
	public static String XbaseValidationConfigurationBlock_java_label;
	public static String XbaseValidationConfigurationBlock_not_java_message;
	public static String XbaseValidationConfigurationBlock_restricted_api_section_title;
	public static String XbaseValidationConfigurationBlock_warning;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
