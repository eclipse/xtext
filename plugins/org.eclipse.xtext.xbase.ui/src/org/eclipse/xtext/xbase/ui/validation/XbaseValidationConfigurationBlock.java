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
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
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

	@Override
	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {

		Composite inner = createSection(Messages.XbaseValidationConfigurationBlock_restricted_api_section_title,
				composite, nColumns);

		addJavaDelegatingComboBox(XbaseConfigurableIssueCodes.FORBIDDEN_REFERENCE,
				Messages.XbaseValidationConfigurationBlock_forbidden_ref_label, inner, defaultIndent);
		addJavaDelegatingComboBox(XbaseConfigurableIssueCodes.DISCOURAGED_REFERENCE,
				Messages.XbaseValidationConfigurationBlock_discouraged_ref_label, inner, defaultIndent);
		addComboBox(XbaseConfigurableIssueCodes.IMPORT_WILDCARD_DEPRECATED, "Use of wildcard imports:", inner,
				defaultIndent);

		Composite unusedCode = createSection("Unnecessary code", composite, nColumns);
		addJavaDelegatingComboBox(XbaseConfigurableIssueCodes.UNUSED_LOCAL_VARIABLE,
				"Value of local variable is not used:", unusedCode, defaultIndent);
		addJavaDelegatingComboBox(XbaseConfigurableIssueCodes.IMPORT_UNUSED, "Unused import:", unusedCode,
				defaultIndent);
		addJavaDelegatingComboBox(XbaseConfigurableIssueCodes.OBSOLETE_INSTANCEOF,
				"Unnecessary 'instanceof' operation:", unusedCode, defaultIndent);

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
		String[] valueLabels = new String[] { Messages.XbaseValidationConfigurationBlock_error,
				Messages.XbaseValidationConfigurationBlock_warning, Messages.XbaseValidationConfigurationBlock_ignore,
				NLS.bind(Messages.XbaseValidationConfigurationBlock_java_label, javaValue) };
		Combo comboBox = addComboBox(parent, label, prefKey.getId(), indent, values, valueLabels);
		return comboBox;
	}

	protected Combo addComboBox(PreferenceKey prefKey, String label, Composite parent, int indent) {
		String[] values = new String[] { SeverityConverter.SEVERITY_ERROR, SeverityConverter.SEVERITY_WARNING,
				SeverityConverter.SEVERITY_IGNORE };
		String[] valueLabels = new String[] { Messages.XbaseValidationConfigurationBlock_error,
				Messages.XbaseValidationConfigurationBlock_warning, Messages.XbaseValidationConfigurationBlock_ignore };
		Combo comboBox = addComboBox(parent, label, prefKey.getId(), indent, values, valueLabels);
//		comboBox.select(java.util.Arrays.asList(comboBox.getItems()).indexOf(prefKey.getDefaultValue()));
//		updateCombo(comboBox);
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

	@Override
	public void performDefaults() {
		// TODO Auto-generated method stub
		super.performDefaults();
	}
}
