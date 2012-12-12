/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.ConfigurableIssueCode;
import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {

	private static final String DELEGATE = "delegate";

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

		addJavaAwareComboBox(XbaseConfigurableIssueCodes.FORBIDDEN_REFERENCE, "Forbidden reference:", inner,
				defaultIndent);
		addJavaAwareComboBox(XbaseConfigurableIssueCodes.DISCOURAGED_REFERENCE, "Discouraged reference:", inner,
				defaultIndent);
	}

	protected Combo addJavaAwareComboBox(ConfigurableIssueCode issueCode, String label, Composite parent, int indent) {
		GridData gd = new GridData(GridData.FILL, GridData.CENTER, true, false, 2, 1);
		gd.horizontalIndent = indent;

		Label labelControl = new Label(parent, SWT.LEFT);
		labelControl.setFont(JFaceResources.getDialogFont());
		labelControl.setText(label);
		labelControl.setLayoutData(gd);

		Combo comboBox = createComboControl(issueCode, parent, indent, "delegate to Java");

		labels.put(comboBox, labelControl);

		return comboBox;
	}

	private Combo createComboControl(final ConfigurableIssueCode issueCode, final Composite parent, int indent,
			String delegateLabel) {
		String[] values = new String[] { ConfigurableIssueCode.SEVERITY_ERROR, ConfigurableIssueCode.SEVERITY_WARNING,
				ConfigurableIssueCode.SEVERITY_IGNORE };
		String[] valueLabels = new String[] { "Error", "Warning", "Ignore" };

		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = 1;
		gd.horizontalIndent = indent;
		container.setLayout(layout);
		container.setLayoutData(gd);
		final Button checkBox = addCheckBox(container, delegateLabel, issueCode.getId(), new String[] { DELEGATE, "" },
				indent);
		checkBox.setData(new ControlData(issueCode.getId(), new String[] { DELEGATE, "" }) {
			@Override
			public String getValue(boolean selection) {
				return selection ? super.getValue(selection) : ConfigurableIssueCode.severityToString(issueCode
						.getDefaultValue());
			}

			@Override
			public int getSelection(String value) {
				return DELEGATE.equals(value) ? 0 : 1;
			}

			@Override
			public String getValue(int index) {
				return super.getValue(index);
			}
		});

		final Combo comboBox = addComboControlWithData(container, valueLabels, new ControlData(issueCode.getId(),
				values));

		comboBox.setData(new ControlData(issueCode.getId(), values) {
			@Override
			public int getSelection(String value) {
				if (DELEGATE.equals(value)) {
					String delegationKey = issueCode.getDelegationKey().getId();
					if (delegationKey.startsWith(JavaCore.PLUGIN_ID)) {
						if (project != null && project.isOpen() && JavaProject.hasJavaNature(project)) {
							String delegatedValue = JavaCore.create(getProject()).getOption(delegationKey, true);
							return super.getSelection(delegatedValue);
						} else {
							return super.getSelection(JavaCore.getOption(delegationKey));
						}
					}
				}
				return super.getSelection(value);
			}

			@Override
			public String getValue(int index) {
				return super.getValue(index);
			}
		});

		checkBox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comboBox.setEnabled(!checkBox.getSelection());
				updateCombo(comboBox);
			}
		});
		updateCheckBox(checkBox);
		comboBox.setEnabled(!checkBox.getSelection());
		
		updateCombo(comboBox);
		checkBox.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		comboBox.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		return comboBox;
	}
}
