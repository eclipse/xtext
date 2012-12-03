/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.ConfigurableIssueCode;
import org.eclipse.xtext.validation.IssueCode;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {

	protected XtendValidatorConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			IWorkbenchPreferenceContainer container) {
		super(project, preferenceStore, container);
	}

	public static class Factory {
		@Inject
		private MembersInjector<XtendValidatorConfigurationBlock> injector;

		public XtendValidatorConfigurationBlock createValidatorConfigurationBlock(IProject project,
				IPreferenceStore preferenceStore, IWorkbenchPreferenceContainer container) {
			XtendValidatorConfigurationBlock configurationBlock = new XtendValidatorConfigurationBlock(project,
					preferenceStore, container);
			injector.injectMembers(configurationBlock);
			return configurationBlock;
		}
	}

	@Override
	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
		Composite inner = createSection("Deprecated and restricted API", composite, nColumns);
		String[] values = new String[] { IssueCode.SEVERITY_ERROR, ConfigurableIssueCode.SEVERITY_WARNING,
				ConfigurableIssueCode.SEVERITY_IGNORE };
		String[] valueLabels = new String[] { "Error", "Warning", "Ignore" };
		if (IssueCodes.IC_FORBIDDEN_REFERENCE.isDerived()) {
			values = new String[] { IssueCode.SEVERITY_ERROR, ConfigurableIssueCode.SEVERITY_WARNING,
					ConfigurableIssueCode.SEVERITY_IGNORE, ConfigurableIssueCode.SEVERITY_DERIVED };
			valueLabels = new String[] { "Error", "Warning", "Ignore", "reuse Java" };
		}

		addComboBox(IssueCodes.IC_FORBIDDEN_REFERENCE, "Forbidden reference:", inner, defaultIndent, values,
				valueLabels);

	}

}
