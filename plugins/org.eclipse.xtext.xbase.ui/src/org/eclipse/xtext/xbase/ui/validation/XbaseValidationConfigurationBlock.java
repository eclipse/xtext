/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.validation;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;

/**
 * Default ConfigurationBlock for Xbase Langauges
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class XbaseValidationConfigurationBlock extends AbstractValidatorConfigurationBlock {

	protected XbaseValidationConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			IWorkbenchPreferenceContainer container) {
		super(project, preferenceStore, container);
	}

	@Override
	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
		Composite inner = createSection(Messages.XbaseValidationConfigurationBlock_restricted_api_section_title,
				composite, nColumns);

		addJavaDelegatingComboBox(XbaseConfigurableIssueCodes.FORBIDDEN_REFERENCE,
				Messages.XbaseValidationConfigurationBlock_forbidden_ref_label, inner, defaultIndent);
		addJavaDelegatingComboBox(XbaseConfigurableIssueCodes.DISCOURAGED_REFERENCE,
				Messages.XbaseValidationConfigurationBlock_discouraged_ref_label, inner, defaultIndent);
	}

	protected Combo addJavaDelegatingComboBox(PreferenceKey prefKey, String label, Composite parent, int indent) {
		String javaIssueCode = prefKey.getDefaultValue();
		if (!javaIssueCode.startsWith(JavaCore.PLUGIN_ID)) {
			throw new IllegalArgumentException(prefKey.toString()
					+ Messages.XbaseValidationConfigurationBlock_not_java_message);
		}
		String[] values = new String[] { SeverityConverter.SEVERITY_ERROR, SeverityConverter.SEVERITY_WARNING,
				SeverityConverter.SEVERITY_IGNORE, javaIssueCode };
		String javaValue = javaValue(javaIssueCode);
		String[] valueLabels = new String[] {
				Messages.XbaseValidationConfigurationBlock_error,
				Messages.XbaseValidationConfigurationBlock_warning,
				Messages.XbaseValidationConfigurationBlock_ignore,
				NLS.bind(Messages.XbaseValidationConfigurationBlock_java_label, javaValue)};
		Combo comboBox = addComboBox(parent, label, prefKey.getId(), indent, values, valueLabels);
		return comboBox;
	}

	@Override
	protected Job getBuildJob(IProject project) {
		Job buildJob = new OptionsConfigurationBlock.BuildJob(
				Messages.XbaseValidationConfigurationBlock_build_job_title, project);
		buildJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
		buildJob.setUser(true);
		return buildJob;

	}

	@Override
	protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
		String title = Messages.XbaseValidationConfigurationBlock_build_dialog_title;
		String message;
		if (workspaceSettings) {
			message = Messages.XbaseValidationConfigurationBlock_build_dailog_ws_message;
		} else {
			message = Messages.XbaseValidationConfigurationBlock_build_dailog_project_message;
		}
		return new String[] { title, message };
	}

	@Override
	protected void validateSettings(String changedKey, String oldValue, String newValue) {
		// TODO Auto-generated method stub
	}

	protected String javaValue(String javaIssueCode) {
		String delegatedValue;
		if (getProject() != null && getProject().isOpen() && JavaProject.hasJavaNature(getProject())) {
			delegatedValue = JavaCore.create(getProject()).getOption(javaIssueCode, true);
		} else {
			delegatedValue = JavaCore.getOption(javaIssueCode);
		}
		return delegatedValue;
	}

}
