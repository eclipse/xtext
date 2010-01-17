/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

import com.ibm.icu.text.MessageFormat;

/**
 * 
 * Singleton for all message bundle classes used from within
 * <i>org.eclipse.xtext.ui.core</i>.
 * 
 * @author Dennis Hübner - Initial contribution and API
 * @author Michael Clay
 * @see org.eclipse.osgi.util.NLS
 * 
 */
public class XtextUIMessages extends NLS {

	private static final String BUNDLE_NAME = XtextUIMessages.class.getPackage().getName() + ".messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	static {
		NLS.initializeMessages(BUNDLE_NAME, XtextUIMessages.class);
	}

	private XtextUIMessages() {
	}

	/**
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		try {
			return getResourceBundle().getString(key);
		}
		catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * @return the rESOURCE_BUNDLE
	 */
	public static ResourceBundle getResourceBundle() {
		return RESOURCE_BUNDLE;
	}

	/**
	 * @param key
	 * @param args
	 * @return Formatted message
	 */
	public static String getFormattedString(String key, Object... args) {
		return MessageFormat.format(RESOURCE_BUNDLE.getString(key), args);
	}

	/**
	 * messages for hovers
	 */
	public static String AbstractHover_MultipleMarkers;

	/**
	 * messages for tasktag preferences page
	 */
	public static String TodoTaskPreferencePage_title;
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
	
	public static String ProblemMarkerManager_problem_marker_update_job_description;
}
