/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.preferences;

import org.eclipse.osgi.util.NLS;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.ui.preferences.messages"; //$NON-NLS-1$
	public static String OutputConfigurationPage_CleanDirectory;
	public static String OutputConfigurationPage_CleanupDerivedResources;
	public static String OutputConfigurationPage_CreateDirectory;
	public static String OutputConfigurationPage_CreatesDerivedResources;
	public static String OutputConfigurationPage_Directory;
	public static String OutputConfigurationPage_OverrideExistingResources;
	public static String ProjectDirectoryFieldEditor_OutputDirectory;

	public static String BuilderConfigurationBlock_BuildJob_TitleBuildAll_TaskName;
	public static String BuilderConfigurationBlock_BuildJob_TitleBuildProject_TaskName;
	
	public static String PropertyAndPreferencePage_useworkspacesettings_change;
	public static String PropertyAndPreferencePage_showprojectspecificsettings_label;
	public static String PropertyAndPreferencePage_useprojectsettings_label;

	public static String ProjectSelectionDialog_title;
	public static String ProjectSelectionDialog_desciption;
	public static String ProjectSelectionDialog_filter;
	public static String ResetPromptDialogSettingsField_0;
	public static String ResetPromptDialogSettingsField_1;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
