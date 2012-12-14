/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.validation;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XbaseValidationConfigurationBlock extends AbstractValidatorConfigurationBlock {

	protected XbaseValidationConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			IWorkbenchPreferenceContainer container) {
		super(project, preferenceStore, container);
	}

	@Override
	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
		Composite inner = createSection("Deprecated and restricted API", composite, nColumns);

		addJavaDelegatingComboBox(XbaseConfigurableIssueCodes.FORBIDDEN_REFERENCE, "Forbidden reference:", inner,
				defaultIndent);
		addJavaDelegatingComboBox(XbaseConfigurableIssueCodes.DISCOURAGED_REFERENCE, "Discouraged reference:", inner,
				defaultIndent);
	}

	protected Combo addJavaDelegatingComboBox(PreferenceKey issueCode, String label, Composite parent, int indent) {
		String javaIssueCode = issueCode.getDefaultValue();
		if (!javaIssueCode.startsWith(JavaCore.PLUGIN_ID)) {
			throw new IllegalArgumentException(issueCode.toString() + " is not a java delegate.");
		}
		String[] values = new String[] { SeverityConverter.SEVERITY_ERROR, SeverityConverter.SEVERITY_WARNING,
				SeverityConverter.SEVERITY_IGNORE, javaIssueCode };
		String javaValue = javaValue(javaIssueCode);
		String[] valueLabels = new String[] { "Error", "Warning", "Ignore", "Java (" + javaValue + ")" };
		Combo comboBox = addComboBox(parent, label, issueCode.getId(), indent, values, valueLabels);
		return comboBox;
	}

	@Override
	protected Job getBuildJob(IProject project) {
		return null;
	}

	@Override
	protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
		//		return new String[] { XbaseConfigurableIssueCodes.FORBIDDEN_REFERENCE.getId(),
		//				XbaseConfigurableIssueCodes.DISCOURAGED_REFERENCE.getId() };
		//		
		return null;
	}

	@Override
	protected void validateSettings(String changedKey, String oldValue, String newValue) {
		// TODO Auto-generated method stub
	}

	protected String javaValue(String javaIssueCode) {
		String delegatedValue;
		if (getProject() != null && getProject().isOpen() && JavaProject.hasJavaNature(project)) {
			delegatedValue = JavaCore.create(getProject()).getOption(javaIssueCode, true);
		} else {
			delegatedValue = JavaCore.getOption(javaIssueCode);
		}
		return delegatedValue;
	}

}
