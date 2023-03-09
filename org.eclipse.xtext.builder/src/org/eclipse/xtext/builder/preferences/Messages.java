/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import org.eclipse.osgi.util.NLS;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.builder.preferences.messages"; //$NON-NLS-1$
	public static String BuilderConfigurationBlock_BuildJob_Title0;
	public static String BuilderConfigurationBlock_BuildJob_TitleBuildAll_TaskName;
	public static String BuilderConfigurationBlock_BuildJob_TitleBuildProject_TaskName;
	public static String BuilderConfigurationBlock_GeneralSection_Label;
	public static String BuilderConfigurationBlock_hideSyntheticLocalVariables;
	public static String BuilderConfigurationBlock_InstallDslAsPrimarySource;
	public static String BuilderConfigurationBlock_SettingsChanged_ProjectBuild;
	public static String BuilderConfigurationBlock_SettingsChanged_Title;
	public static String BuilderConfigurationBlock_SettingsChanged_WorkspaceBuild;
	public static String BuilderPreferencePage_GenerateAuto;
	public static String BuilderPreferencePage_Output;
	public static String OutputConfigurationPage_CleanDirectory;
	public static String OutputConfigurationPage_CleanupDerivedResources;
	public static String OutputConfigurationPage_CreateDirectory;
	public static String OutputConfigurationPage_CreatesDerivedResources;
	public static String OutputConfigurationPage_Directory;
	public static String OutputConfigurationPage_IgnoreSourceFolder;
	public static String OutputConfigurationPage_OutputDirectory;
	public static String OutputConfigurationPage_OverrideExistingResources;
	public static String OutputConfigurationPage_KeepLocalHistory;
	public static String OutputConfigurationPage_SourceFolder;
	public static String OutputConfigurationPage_UseOutputPerSourceFolder;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
