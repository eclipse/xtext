/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.osgi.util.NLS;

/**
 * @author Arne Deutsch - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.ui.wizard.template.messages"; //$NON-NLS-1$
	public static String NewProjectWizardTemplateSelectionPage_available_templates;
	public static String TemplateNewProjectWizard_create_new_prefix;
	public static String TemplateNewProjectWizard_create_new_suffix;
	public static String TemplateNewProjectWizard_title;
	public static String TemplateNewProjectWizard_title_suffix;
	public static String NewFileWizardPrimaryPage_browse_button;
	public static String NewFileWizardPrimaryPage_empty_name;
	public static String NewFileWizardPrimaryPage_file_already_exist_post;
	public static String NewFileWizardPrimaryPage_file_already_exist_pre;
	public static String NewFileWizardPrimaryPage_folder_label;
	public static String NewFileWizardPrimaryPage_name_label;
	public static String NewFileWizardPrimaryPage_selection_description;
	public static String NewFileWizardPrimaryPage_unexistent_folder_post;
	public static String NewFileWizardPrimaryPage_unexistint_folder_pre;
	public static String NewFileWizardTemplateSelectionPage_location_label;
	public static String NewFileWizardTemplateSelectionPage_browse_location_button;
	public static String NewFileWizardPrimaryPage_template_label;
	public static String NewFileWizardTemplateSelectionPage_name_label;
	public static String NewFileWizardTemplateSelectionPage_available_templates;
	public static String TemplateNewFileWizard_title;
	public static String TemplateNewFileWizard_create_new;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
