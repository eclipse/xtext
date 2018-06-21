/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.validation;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.SeverityConverter;

@SuppressWarnings("restriction")
public class ArithmeticsValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {

	@Override
	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
	}

	@Override
	protected Job getBuildJob(IProject project) {
		Job buildJob = new OptionsConfigurationBlock.BuildJob("Validation Settings Changed", project);
		buildJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
		buildJob.setUser(true);
		return buildJob;
	}

	@Override
	protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
		return new String[] { "Validation Settings Changed",
				"Validation settings have changed. A full rebuild is required for changes to take effect. Do the full build now?" };
	}

	@Override
	protected void validateSettings(String changedKey, String oldValue, String newValue) {
	}

	protected Combo addComboBox(String prefKey, String label, Composite parent, int indent) {
		String[] values = new String[] { SeverityConverter.SEVERITY_ERROR, SeverityConverter.SEVERITY_WARNING,
				SeverityConverter.SEVERITY_INFO, SeverityConverter.SEVERITY_IGNORE };
		String[] valueLabels = new String[] { "Error", "Warning", "Info", "Ignore" };
		Combo comboBox = addComboBox(parent, label, prefKey, indent, values, valueLabels);
		return comboBox;
	}

	@Override
	public void dispose() {
		storeSectionExpansionStates(getDialogSettings());
		super.dispose();
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings dialogSettings = super.getDialogSettings();
		IDialogSettings section = dialogSettings.getSection("Arithmetics");
		if (section == null) {
			return dialogSettings.addNewSection("Arithmetics");
		}
		return section;
	}
}
