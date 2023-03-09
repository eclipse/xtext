/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.validation;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xbase.validation.XbaseSeverityConverter;

import com.google.inject.Inject;

/**
 * Default ConfigurationBlock for Xbase Languages.<br>
 * Clients may override {@link #fillSettingsPage(Composite, int, int)}<br>
 * If {@link #fillSettingsPage(Composite, int, int)} is reused, clients may participate<br>
 * to the section creation in {@link #fillRestrictedApiSection(ComboBoxBuilder)} and/or
 * {@link #fillUnusedCodeSection(ComboBoxBuilder)}
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @author Holger Schill
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
		
		Composite codingStyle = createSection("Coding style", composite, nColumns);
		fillCodingStyleSection(new ComboBoxBuilder(this, codingStyle, defaultIndent));
	}
	
	protected void fillCodingStyleSection(ComboBoxBuilder comboBoxBuilder) {
		comboBoxBuilder.addJavaDelegatingComboBox(IssueCodes.INSTANCE_ACCESS_TO_STATIC_MEMBER, "Non-static access to static member:");
		comboBoxBuilder.addComboBox(IssueCodes.OPERATION_WITHOUT_PARENTHESES, "Method/Constructor call without parentheses:");
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
		comboBoxBuilder.addComboBox(IssueCodes.VARIABLE_NAME_DISCOURAGED, "Discouraged usage of variable name 'self':");
		comboBoxBuilder.addComboBox(IssueCodes.UNREACHABLE_CASE, "Unreachable case:");
		comboBoxBuilder.addComboBox(IssueCodes.UNREACHABLE_IF_BLOCK, "Unreachable if block:");
		comboBoxBuilder.addComboBox(IssueCodes.CONSTANT_BOOLEAN_CONDITION, "Constant boolean condition:");
		comboBoxBuilder.addComboBox(IssueCodes.INCOMPLETE_CASES_ON_ENUM, "Incomplete 'switch' cases on enum:");
	}

	protected void fillRestrictedApiSection(ComboBoxBuilder comboBoxBuilder) {
		comboBoxBuilder
				.addJavaDelegatingComboBox(IssueCodes.DEPRECATED_MEMBER_REFERENCE,
						Messages.XbaseValidationConfigurationBlock_deprecated_ref_label)
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
				SeverityConverter.SEVERITY_INFO, SeverityConverter.SEVERITY_IGNORE, javaIssueCode };
		String javaValue = javaValue(javaIssueCode);
		String[] valueLabels = new String[] { org.eclipse.xtext.ui.validation.Messages.ValidationConfigurationBlock_error,
				org.eclipse.xtext.ui.validation.Messages.ValidationConfigurationBlock_warning, org.eclipse.xtext.ui.validation.Messages.ValidationConfigurationBlock_info,
				org.eclipse.xtext.ui.validation.Messages.ValidationConfigurationBlock_ignore,
				NLS.bind(Messages.XbaseValidationConfigurationBlock_java_label, javaValue) };
		Combo comboBox = addComboBox(parent, label, prefKey, indent, values, valueLabels);
		return comboBox;
	}

	protected String javaValue(final String javaIssueCode) {
		String delegatedValue;
		String decodedDelegateKey = XbaseSeverityConverter.decodeDelegationKey(javaIssueCode).getFirst();
		IJavaProject javaProject = JavaCore.create(getProject());
		if (javaProject != null && javaProject.exists() && javaProject.getProject().isAccessible()) {
			delegatedValue = javaProject.getOption(decodedDelegateKey, true);
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
