/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.validation;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.CellEditor.LayoutData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;
import org.eclipse.xtext.ui.preferences.ScrolledPageContent;
import org.eclipse.xtext.ui.util.PixelConverter;
import org.eclipse.xtext.validation.SeverityConverter;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @author Holger Schill
 * @since 2.4
 */
public abstract class AbstractValidatorConfigurationBlock extends OptionsConfigurationBlock {
	@Inject
	private IDialogSettings dialogSettings;
	private PixelConverter fPixelConverter;
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;
	private static final String PROPERTY_PREFIX = "ValidatorConfiguration"; //$NON-NLS-1$

	protected AbstractValidatorConfigurationBlock() {
		super();
	}

	@Override
	public Control doCreateContents(Composite parent) {
		fPixelConverter = new PixelConverter(parent);
		setShell(parent.getShell());

		Composite mainComp = new Composite(parent, SWT.NONE);
		mainComp.setFont(parent.getFont());
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		mainComp.setLayout(layout);

		Composite commonComposite = createStyleTabContent(mainComp);
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.heightHint = fPixelConverter.convertHeightInCharsToPixels(20);
		commonComposite.setLayoutData(gridData);
		validateSettings(null, null, null);
		return mainComp;

	}

	private Composite createStyleTabContent(Composite folder) {
		int nColumns = 3;
		final ScrolledPageContent sc1 = new ScrolledPageContent(folder);

		Composite composite = sc1.getBody();
		GridLayout layout = new GridLayout(nColumns, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);

		Label description = new Label(composite, SWT.LEFT | SWT.WRAP);
		description.setFont(description.getFont());
		description.setText("Select the severity level for the following optional " + lastSegment(languageName)
				+ " compiler problems:");
		description.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, true, false, nColumns - 1, 1));

		fillSettingsPage(composite, nColumns, 0);
		addAdditionalComponentsToSettingsPage(composite, nColumns, 0);

		new Label(composite, SWT.NONE); // TODO what's this?
		restoreSectionExpansionStates(getDialogSettings());
		return sc1;

	}

	/**
	 * This implementation returns Dialog settings which were bind in {@link org.eclipse.xtext.ui.DefaultUiModule}
	 * normally {@code org.eclipse.ui.plugin.AbstractUIPlugin.getDialogSettings()}<br>
	 * Subclasses should override to get special section settings. Here is an example:<br>
	 * 
	 * <pre>
	 *  <code>
	 *  
	 * protected IDialogSettings getDialogSettings() {
	 * 	IDialogSettings dialogSettings = super.getDialogSettings();
	 * 	IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);
	 * 	if(section==null) {
	 * 		return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);
	 * 	}
	 * 	return section;
	 * }
	 *  </code>
	 * </pre>
	 * 
	 * @return Dialog settings which were bind in {@link org.eclipse.xtext.ui.DefaultUiModule}
	 * @since 2.7
	 */
	protected IDialogSettings getDialogSettings() {
		return this.dialogSettings;
	}

	/**
	 * @since 2.7
	 */
	protected void addAdditionalComponentsToSettingsPage(Composite settingsPage, int nColumns, int defaultIndent) {
	}

	/**
	 * Computes the common width hint (the largest width) and set it as {@link GridData#widthHint} for all combos, if
	 * the combo has a {@link GridData} as {@link LayoutData}.
	 */
	protected void adjustComboWidth(List<Combo> combos) {
		int withHint = SWT.DEFAULT;
		for (Combo comboBox : combos) {
			comboBox.pack(true);
			Point computeSize = comboBox.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			int pixels = computeSize.x;
			if (pixels > withHint) {
				withHint = pixels;
			}
		}
		for (Combo comboBox : combos) {
			Object ld = comboBox.getLayoutData();
			if (ld instanceof GridData) {
				GridData layoutData = (GridData) ld;
				layoutData.widthHint = withHint;
			}
		}
	}

	private String lastSegment(String languageFQN) {
		String simplename = languageFQN;
		int lastDot = languageFQN.lastIndexOf('.');
		if (lastDot >= 0 && lastDot < languageFQN.length() - 1) {
			simplename = languageFQN.substring(lastDot + 1, languageFQN.length());
		}
		return simplename;
	}

	protected abstract void fillSettingsPage(Composite composite, int nColumns, int defaultIndent);

	protected Composite createSection(String label, Composite composite, int nColumns) {
		ExpandableComposite excomposite = createStyleSection(composite, label, nColumns);

		Composite inner = new Composite(excomposite, SWT.NONE);
		inner.setFont(composite.getFont());
		inner.setLayout(new GridLayout(nColumns, false));
		excomposite.setClient(inner);
		return inner;
	}

	/**
	 * @since 2.8
	 */
	@Override
	public String getPropertyPrefix() {
		return PROPERTY_PREFIX;
	}
	
	/**
	 * @since 2.15
	 */
	protected Combo addComboBox(String prefKey, String label, Composite parent, int indent) {
		String[] values = new String[] { SeverityConverter.SEVERITY_ERROR, SeverityConverter.SEVERITY_WARNING,
				SeverityConverter.SEVERITY_INFO, SeverityConverter.SEVERITY_IGNORE };
		String[] valueLabels = new String[] { Messages.ValidationConfigurationBlock_error,
				Messages.ValidationConfigurationBlock_warning, Messages.ValidationConfigurationBlock_info, Messages.ValidationConfigurationBlock_ignore };
		Combo comboBox = addComboBox(parent, label, prefKey, indent, values, valueLabels);
		return comboBox;
	}
	
	/**
	 * @since 2.15
	 */
	@Override
	protected Job getBuildJob(IProject project) {
		Job buildJob = new OptionsConfigurationBlock.BuildJob(
				Messages.ValidationConfigurationBlock_build_job_title, project);
		buildJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
		buildJob.setUser(true);
		return buildJob;

	}
	
	/**
	 * @since 2.15
	 */
	@Override
	protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
		String title = Messages.ValidationConfigurationBlock_build_dialog_title;
		String message;
		if (workspaceSettings) {
			message = Messages.ValidationConfigurationBlock_build_dailog_ws_message;
		} else {
			message = Messages.ValidationConfigurationBlock_build_dailog_project_message;
		}
		return new String[] { title, message };
	}
	
	/**
	 * @since 2.15
	 */
	@Override
	protected void validateSettings(String changedKey, String oldValue, String newValue) {
		// Clients may override
	}
}
