/*******************************************************************************
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.osgi.util.NLS;

/**
 * @author adeutsch - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.ui.wizard.template.messages"; //$NON-NLS-1$
	public static String NewProjectWizardTemplateSelectionPage_available_templates;
	public static String TemplateNewProjectWizard_create_new_prefix;
	public static String TemplateNewProjectWizard_create_new_suffix;
	public static String TemplateNewProjectWizard_title;
	public static String TemplateNewProjectWizard_title_suffix;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
