/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.validation;

import org.eclipse.osgi.util.NLS;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.ui.validation.messages"; //$NON-NLS-1$
	public static String ValidationConfigurationBlock_build_dailog_project_message;
	public static String ValidationConfigurationBlock_build_dailog_ws_message;
	public static String ValidationConfigurationBlock_build_dialog_title;
	public static String ValidationConfigurationBlock_build_job_title;
	public static String ValidationConfigurationBlock_error;
	public static String ValidationConfigurationBlock_ignore;
	public static String ValidationConfigurationBlock_warning;
	public static String ValidationConfigurationBlock_info;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
