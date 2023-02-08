/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks.preferences;

import org.eclipse.osgi.util.NLS;


public final class PreferencesMessages extends NLS {

	private static final String BUNDLE_NAME= "org.eclipse.xtext.ui.tasks.preferences.PreferencesMessages";//$NON-NLS-1$
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, PreferencesMessages.class);
	}

	private PreferencesMessages() {
		// Do not instantiate
	}

	public static String TaskTagPreferencePage_title;
	public static String TaskTagPreferencePage_description;
	public static String TaskTagConfigurationBlock_markers_tasks_high_priority;
	public static String TaskTagConfigurationBlock_markers_tasks_normal_priority;
	public static String TaskTagConfigurationBlock_markers_tasks_low_priority;
	public static String TaskTagConfigurationBlock_markers_tasks_add_button;
	public static String TaskTagConfigurationBlock_markers_tasks_remove_button;
	public static String TaskTagConfigurationBlock_markers_tasks_edit_button;
	public static String TaskTagConfigurationBlock_markers_tasks_name_column;
	public static String TaskTagConfigurationBlock_markers_tasks_priority_column;
	public static String TaskTagConfigurationBlock_markers_tasks_setdefault_button;
	public static String TaskTagConfigurationBlock_casesensitive_label;
	public static String TaskTagConfigurationBlock_needsbuild_title;
	public static String TaskTagConfigurationBlock_tasks_default;
	public static String TaskTagConfigurationBlock_needsfullbuild_message;
	public static String TaskTagConfigurationBlock_needsprojectbuild_message;
	public static String TaskTagInputDialog_new_title;
	public static String TaskTagInputDialog_edit_title;
	public static String TaskTagInputDialog_name_label;
	public static String TaskTagInputDialog_priority_label;
	public static String TaskTagInputDialog_priority_high;
	public static String TaskTagInputDialog_priority_normal;
	public static String TaskTagInputDialog_priority_low;
	public static String TaskTagInputDialog_error_enterName;
	public static String TaskTagInputDialog_error_comma;
	public static String TaskTagInputDialog_error_entryExists;
	public static String TaskTagInputDialog_error_noSpace;
	
}
