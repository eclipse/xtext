/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.validation;

import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.*;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.SeverityConverter;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
public class XtextValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {

	public static final String SETTINGS_SECTION_NAME = "XtextValidatorConfigurationBlock"; //$NON-NLS-1$

	@Override
	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
		Composite grammarSection = createSection(Messages.XtextValidatorConfigurationBlock_0, composite, nColumns);
		fillGrammarSection(grammarSection, defaultIndent);
		Composite ecoreModel = createSection(Messages.XtextValidatorConfigurationBlock_1, composite, nColumns);
		fillEcoreModelSection(ecoreModel, defaultIndent);
	}

	protected void fillGrammarSection(Composite section, int defaultIndent) {
		addComboBox(INVALID_TERMINALRULE_NAME, Messages.XtextValidatorConfigurationBlock_2, section, defaultIndent);
		addComboBox(DISCOURAGED_RULE_NAME, Messages.XtextValidatorConfigurationBlock_15, section, defaultIndent);
		addComboBox(DUPLICATE_ENUM_LITERAL, Messages.XtextValidatorConfigurationBlock_3, section, defaultIndent);
	}

	protected void fillEcoreModelSection(Composite section, int defaultIndent) {
		addComboBox(INVALID_METAMODEL_NAME, Messages.XtextValidatorConfigurationBlock_4, section, defaultIndent);
		addComboBox(INVALID_PACKAGE_REFERENCE_EXTERNAL, Messages.XtextValidatorConfigurationBlock_5, section,
				defaultIndent);
		addComboBox(INVALID_PACKAGE_REFERENCE_NOT_ON_CLASSPATH, Messages.XtextValidatorConfigurationBlock_6, section,
				defaultIndent);
		addComboBox(BIDIRECTIONAL_REFERENCE, Messages.XtextValidatorConfigurationBlock_7, section, defaultIndent);
	}

	protected Combo addComboBox(String prefKey, String label, Composite parent, int indent) {
		String[] values = new String[] { SeverityConverter.SEVERITY_ERROR, SeverityConverter.SEVERITY_WARNING,
				SeverityConverter.SEVERITY_IGNORE };
		String[] valueLabels = new String[] { Messages.XtextValidatorConfigurationBlock_8,
				Messages.XtextValidatorConfigurationBlock_9, Messages.XtextValidatorConfigurationBlock_10 };
		Combo comboBox = addComboBox(parent, label, prefKey, indent, values, valueLabels);
		return comboBox;
	}

	@Override
	protected Job getBuildJob(IProject project) {
		Job buildJob = new OptionsConfigurationBlock.BuildJob(Messages.XtextValidatorConfigurationBlock_11, project);
		buildJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
		buildJob.setUser(true);
		return buildJob;

	}

	@Override
	protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
		String title = Messages.XtextValidatorConfigurationBlock_12;
		String message;
		if (workspaceSettings) {
			message = Messages.XtextValidatorConfigurationBlock_13;
		} else {
			message = Messages.XtextValidatorConfigurationBlock_14;
		}
		return new String[] { title, message };
	}

	@Override
	protected void validateSettings(String changedKey, String oldValue, String newValue) {
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
