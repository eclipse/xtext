/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.validator.preferences;

import static org.eclipse.xtend.core.validation.IssueCodes.*;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.validation.IssueCodes;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.xbase.ui.validation.XbaseValidationConfigurationBlock;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendValidatorConfigurationBlock extends XbaseValidationConfigurationBlock {
	private static final String SETTINGS_SECTION_NAME = "XtendValidatorConfigurationBlock"; //$NON-NLS-1$

	@Override
	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
		super.fillSettingsPage(composite, nColumns, defaultIndent);
		fillDispatchSection(
				new ComboBoxBuilder(this, createSection("Dispatch methods", composite, nColumns), defaultIndent));
		fillJavaDocSection(new ComboBoxBuilder(this, createSection("Javadoc", composite, nColumns), defaultIndent));
		fillActiveAnnotationSection(
				new ComboBoxBuilder(this, createSection("Active Annotations", composite, nColumns), defaultIndent));
	}

	protected void fillDispatchSection(ComboBoxBuilder builder) {
		builder.addComboBox(DISPATCH_PLAIN_FUNCTION_NAME_CLASH, "Dispatch and non-dispatch method name clash:")
				.addComboBox(SINGLE_DISPATCH_FUNCTION, "Single dispatch method:")
				.addComboBox(DISPATCH_FUNCTIONS_DIFFERENT_PRIMITIVE_ARGS,
						"Dispatch method arguments with different primitive types:");
	}

	/**
	 * @see org.eclipse.xtend.core.validation.XtendConfigurableIssueCodes
	 */
	protected void fillJavaDocSection(ComboBoxBuilder builder) {
		builder.addJavaDelegatingComboBox(JAVA_DOC_LINKING_DIAGNOSTIC, "Unresolved references");
	}

	protected void fillActiveAnnotationSection(ComboBoxBuilder builder) {
		builder.addComboBox(ORPHAN_ELEMENT, "JVM element without source element:");
	}

	@Override
	protected void fillUnusedCodeSection(ComboBoxBuilder builder) {
		super.fillUnusedCodeSection(builder);
		builder.addJavaDelegatingComboBox(UNUSED_PRIVATE_MEMBER, "Unused private member:")
			.addComboBox(UNNECESSARY_MODIFIER, "Unnecessary modifier:");
	}

	@Override
	protected void fillPotentialProgrammingProblemsSection(ComboBoxBuilder builder) {
		super.fillPotentialProgrammingProblemsSection(builder);
		builder.addComboBox(INVALID_OPERATOR_SIGNATURE, "Unexpected operator declaration:");
	}

	@Override
	protected void fillCodingStyleSection(ComboBoxBuilder builder) {
		super.fillCodingStyleSection(builder);
		builder.addComboBox(API_TYPE_INFERENCE, "Type inference for API methods/fields:")
				.addComboBox(IMPLICIT_RETURN, "Implicit return:")
				.addComboBox(WRONG_FILE, "File name doesn't match type name:")
				.addComboBox(MODIFIER_DOES_NOT_MATCH_TYPENAME, "Modifier does not match type name:")
				.addComboBox(TERNARY_EXPRESSION_NOT_ALLOWED, "Ternary expression (cond ? a : b) is used:");
	}

	@Override
	protected void addAdditionalComponentsToSettingsPage(Composite settingsPage, int nColumns, int defaultIndent) {
		super.addAdditionalComponentsToSettingsPage(settingsPage, nColumns, defaultIndent);
		createHorizontalLine(settingsPage, nColumns);
		String[] values = new String[] { SeverityConverter.SEVERITY_ERROR, SeverityConverter.SEVERITY_WARNING,
				SeverityConverter.SEVERITY_IGNORE };
		String[] valueLabels = new String[] { "Errors only", "All", "None" };
		Composite composite = new Composite(settingsPage, SWT.NONE);
		GridLayout layout = new GridLayout(nColumns, false);
		layout.marginHeight = 0;
		composite.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false, nColumns, 1));
		composite.setLayout(layout);
		addComboBox(composite, "Display Java Problems in Xtend", IssueCodes.COPY_JAVA_PROBLEMS, defaultIndent, values,
				valueLabels);
	}

	private void createHorizontalLine(Composite settingsPage, int nColumns) {
		Label horizontalLine = new Label(settingsPage, SWT.SEPARATOR | SWT.HORIZONTAL);
		horizontalLine.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false, nColumns, 1));
		horizontalLine.setFont(settingsPage.getFont());
	}

	@Override
	public void dispose() {
		storeSectionExpansionStates(getDialogSettings());
		super.dispose();
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings dialogSettings = super.getDialogSettings();
		IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);
		if (section == null) {
			return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);
		}
		return section;
	}

}
