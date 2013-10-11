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
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xbase.validation.XbaseSeverityConverter;

import com.google.inject.Inject;

/**
 * Default ConfigurationBlock for Xbase Langauges.<br>
 * Clients may override {@link #fillSettingsPage(Composite, int, int)}<br>
 * If {@link #fillSettingsPage(Composite, int, int)} is reused, clients may participate<br>
 * to the section creation in {@link #fillRestrictedApiSection(ComboBoxBuilder)} and/or
 * {@link #fillUnusedCodeSection(ComboBoxBuilder)}
 * 
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class XbaseValidationConfigurationBlock extends AbstractValidatorConfigurationBlock {
	@Inject
	private ConfigurableIssueCodesProvider issueCodeProvider;

	@Override
	public Control doCreateContents(Composite parent) {
		Control createContents = super.doCreateContents(parent);
		adjustComboWidth(comboBoxes);
		return createContents;
	}

	@Override
	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
		Composite programmingProblems = createSection("Potential programming problems", composite, nColumns);
		fillPotentialProgrammingProblemsSection(new ComboBoxBuilder(this, programmingProblems, defaultIndent));

		Composite restrictedApi = createSection(
				Messages.XbaseValidationConfigurationBlock_restricted_api_section_title, composite, nColumns);
		fillRestrictedApiSection(new ComboBoxBuilder(this, restrictedApi, defaultIndent));

		Composite unusedCode = createSection("Unnecessary code", composite, nColumns);
		fillUnusedCodeSection(new ComboBoxBuilder(this, unusedCode, defaultIndent));
	}

	protected void fillUnusedCodeSection(ComboBoxBuilder comboBoxBuilder) {
		comboBoxBuilder
				.addJavaDelegatingComboBox(IssueCodes.UNUSED_LOCAL_VARIABLE, "Value of local variable is not used:")
				.addJavaDelegatingComboBox(IssueCodes.IMPORT_UNUSED, "Unused import:")
				.addJavaDelegatingComboBox(IssueCodes.OBSOLETE_INSTANCEOF, "Unnecessary 'instanceof' operation:")
				.addJavaDelegatingComboBox(IssueCodes.OBSOLETE_CAST, "Unnecessary 'cast' operation:");
	}

	protected void fillPotentialProgrammingProblemsSection(ComboBoxBuilder comboBoxBuilder) {
		comboBoxBuilder.addComboBox(IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, "Null safe call of primitive valued feature:");
		comboBoxBuilder.addComboBox(IssueCodes.EQUALS_WITH_NULL, "Equals comparison with 'null':");
		comboBoxBuilder.addComboBox(IssueCodes.UNHANDLED_EXCEPTION, "Unhandled checked exceptions:");
		comboBoxBuilder.addComboBox(IssueCodes.JAVA_STYLE_TYPE_CAST, "Type cast with Java syntax:");
		comboBoxBuilder.addComboBox(IssueCodes.SUSPICIOUSLY_OVERLOADED_FEATURE, "Method overloading with multiple implicit receivers:");
	}

	protected void fillRestrictedApiSection(ComboBoxBuilder comboBoxBuilder) {
		comboBoxBuilder
				.addJavaDelegatingComboBox(IssueCodes.FORBIDDEN_REFERENCE,
						Messages.XbaseValidationConfigurationBlock_forbidden_ref_label)
				.addJavaDelegatingComboBox(IssueCodes.DISCOURAGED_REFERENCE,
						Messages.XbaseValidationConfigurationBlock_discouraged_ref_label)
				.addComboBox(IssueCodes.IMPORT_WILDCARD_DEPRECATED, "Use of wildcard imports:");
	}

	protected Combo addJavaDelegatingComboBox(String prefKey, String label, Composite parent, int indent) {
		PreferenceKey preferenceKey = issueCodeProvider.getConfigurableIssueCodes().get(prefKey);
		if (preferenceKey == null) {
			throw new IllegalArgumentException(prefKey
					+ " not registered in the corresponding ConfigurableIssueCodesProvider");
		}
		String javaIssueCode = preferenceKey.getDefaultValue();
		if (!javaIssueCode.startsWith(JavaCore.PLUGIN_ID)) {
			throw new IllegalArgumentException(prefKey + Messages.XbaseValidationConfigurationBlock_not_java_message);
		}
		String[] values = new String[] { SeverityConverter.SEVERITY_ERROR, SeverityConverter.SEVERITY_WARNING,
				SeverityConverter.SEVERITY_IGNORE, javaIssueCode };
		String javaValue = javaValue(javaIssueCode);
		String[] valueLabels = new String[] { Messages.XbaseValidationConfigurationBlock_error,
				Messages.XbaseValidationConfigurationBlock_warning, Messages.XbaseValidationConfigurationBlock_ignore,
				NLS.bind(Messages.XbaseValidationConfigurationBlock_java_label, javaValue) };
		Combo comboBox = addComboBox(parent, label, prefKey, indent, values, valueLabels);
		return comboBox;
	}

	protected Combo addComboBox(String prefKey, String label, Composite parent, int indent) {
		String[] values = new String[] { SeverityConverter.SEVERITY_ERROR, SeverityConverter.SEVERITY_WARNING,
				SeverityConverter.SEVERITY_IGNORE };
		String[] valueLabels = new String[] { Messages.XbaseValidationConfigurationBlock_error,
				Messages.XbaseValidationConfigurationBlock_warning, Messages.XbaseValidationConfigurationBlock_ignore };
		Combo comboBox = addComboBox(parent, label, prefKey, indent, values, valueLabels);
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
		// Clients may override
	}

	protected String javaValue(final String javaIssueCode) {
		String delegatedValue;
		String decodedDelegateKey = XbaseSeverityConverter.decodeDelegationKey(javaIssueCode).getFirst();
		if (getProject() != null && getProject().isOpen() && JavaProject.hasJavaNature(getProject())) {
			delegatedValue = JavaCore.create(getProject()).getOption(decodedDelegateKey, true);
		} else {
			delegatedValue = JavaCore.getOption(decodedDelegateKey);
		}
		return delegatedValue;
	}

	protected static final class ComboBoxBuilder {
		private int defaultIndent;
		private Composite section;
		private final XbaseValidationConfigurationBlock xbaseConfBlock;

		public ComboBoxBuilder(XbaseValidationConfigurationBlock xbaseConfBlock, Composite section, int defaultIndent) {
			this.section = section;
			this.xbaseConfBlock = xbaseConfBlock;
			this.defaultIndent = defaultIndent;
		}

		public ComboBoxBuilder addJavaDelegatingComboBox(String key, String label) {
			xbaseConfBlock.addJavaDelegatingComboBox(key, label, section, defaultIndent);
			return this;
		}

		public ComboBoxBuilder addComboBox(String key, String label) {
			xbaseConfBlock.addComboBox(key, label, section, defaultIndent);
			return this;
		}

	}
}
