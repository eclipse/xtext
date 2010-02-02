/*******************************************************************************
 * Copyright (c) 2009 Dakshinamurthy Karra, itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dakshinamurthy Karra (Jalian Systems)
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

/**
 * The main page of the Xtext project wizard.
 * 
 * @author KD - Initial contribution and API
 * @author Knut Wannheden
 */
public final class WizardNewXtextProjectCreationPage extends WizardNewProjectCreationPage {
	private Text languageNameField;
	private final IStructuredSelection selection;
	private Text extensionsField;
	private Button generatorProjectField;
	private Combo generatorConfigurationField;
	private Object defaultConfigurationName;
	
	/**
	 * Constructs a new WizardNewXtextProjectCreationPage.
	 * 
	 * @param pageName
	 *            the name of the page
	 * 
	 * @param selection
	 *            The current selection. If the current selection includes workingsets the workingsets field is
	 *            initialized with the selection.
	 */
	public WizardNewXtextProjectCreationPage(String pageName, IStructuredSelection selection, String defaultConfigurationName) {
		super(pageName);
		this.selection = selection;
		this.defaultConfigurationName = defaultConfigurationName;
		setTitle(Messages.WizardNewXtextProjectCreationPage_WindowTitle);
		setDescription(Messages.WizardNewXtextProjectCreationPage_Description);
	}

	@Override
	public void createControl(Composite parent) {
		final String projectsuffix = findNextValidProjectSuffix("org.xtext.example", "mydsl"); //$NON-NLS-1$ //$NON-NLS-2$
		// We need to set the initial project name before calling super.createControl()
		// This calls the validate page and since our controls are not yet created we need to check for
		// that case for avoiding an NPE
		setInitialProjectName("org.xtext.example." + projectsuffix); //$NON-NLS-1$
		super.createControl(parent);
		createLanguageSelectionGroup((Composite) getControl());
		createProjectLayoutGroup((Composite) getControl());
		createWorkingSetGroup((Composite) getControl(), selection,
				new String[] { "org.eclipse.ui.resourceWorkingSetPage" }); //$NON-NLS-1$
		setDefaults(projectsuffix);
		Dialog.applyDialogFont(getControl());
	}

	/**
	 * Sets the defaults for the languageName and extensions.
	 * 
	 * @param dslName
	 *            the name of the DSL
	 */
	private void setDefaults(String projectSuffix) {
		languageNameField.setText("org.xtext.example." + projectSuffix+".MyDsl"); //$NON-NLS-1$
		extensionsField.setText(projectSuffix);

		fillMweSnippet();
		validatePage();
	}

	private void fillMweSnippet() {
		Map<String, WizardContribution> contributions = WizardContribution.getFromRegistry();

		List<String> names = new ArrayList<String>(contributions.keySet());

		Collections.sort(names);
		if (generatorConfigurationField != null) {
			generatorConfigurationField.setItems(names.toArray(new String[names.size()]));
			generatorConfigurationField.select(indexOfDefault(names));
		}
	}

	private int indexOfDefault(List<String> contributions) {
		int indexOf = contributions.indexOf(defaultConfigurationName);
		return indexOf != -1 ? indexOf : 0;
	}

	/**
	 * Find the next available (default) DSL name
	 */
	private String findNextValidProjectSuffix(final String prefix, final String name) {
		String candidate = name;
		int suffix = 1;
		while (ResourcesPlugin.getWorkspace().getRoot().getProject((prefix + "." + candidate).toLowerCase()).exists()) { //$NON-NLS-1$
			candidate = name + suffix;
			suffix++;
		}
		return candidate;
	}

	@Override
	protected boolean validatePage() {
		if (!super.validatePage())
			return false;
		IStatus status = JavaConventions.validatePackageName(getProjectName(), JavaCore.VERSION_1_3,
				JavaCore.VERSION_1_3);
		if (!status.isOK()) {
			setErrorMessage(Messages.WizardNewXtextProjectCreationPage_ErrorMessageProjectName + status.getMessage());
			return false;
		}
		if (languageNameField == null) // See the comment in createControl
			return true;
		if (languageNameField.getText().length() == 0)
			return false;

		status = JavaConventions.validateJavaTypeName(languageNameField.getText(), JavaCore.VERSION_1_3,
				JavaCore.VERSION_1_3);
		if (!status.isOK()) {
			setErrorMessage(Messages.WizardNewXtextProjectCreationPage_ErrorMessageLanguageName + status.getMessage());
			return false;
		}
		if (extensionsField.getText().length() == 0)
			return false;
		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	protected void createLanguageSelectionGroup(Composite parent) {
		Group languageGroup = new Group(parent, SWT.NONE);
		languageGroup.setFont(parent.getFont());
		languageGroup.setText(Messages.WizardNewXtextProjectCreationPage_LabelLanguage);
		languageGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		languageGroup.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(languageGroup, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		composite.setLayout(new GridLayout(2, false));

		Label languageLabel = new Label(composite, SWT.NONE);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 1;
		languageLabel.setText(Messages.WizardNewXtextProjectCreationPage_LabelName);

		languageNameField = new Text(composite, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 1;
		languageNameField.setLayoutData(data);
		languageNameField.setFont(parent.getFont());

		Label extensionsLabel = new Label(composite, SWT.NONE);
		extensionsLabel.setText(Messages.WizardNewXtextProjectCreationPage_LabelExtensions);

		extensionsField = new Text(composite, SWT.BORDER);
		GridData textData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		textData.horizontalSpan = 1;
		textData.horizontalIndent = 0;
		extensionsField.setLayoutData(textData);

		Listener modifyListener = new Listener() {
			public void handleEvent(Event event) {
				setPageComplete(validatePage());
			}
		};
		languageNameField.addListener(SWT.Modify, modifyListener);
		extensionsField.addListener(SWT.Modify, modifyListener);
	}

	protected void createProjectLayoutGroup(Composite parent) {
		Group layoutGroup = new Group(parent, SWT.NONE);
		layoutGroup.setFont(parent.getFont());
		layoutGroup.setText(Messages.WizardNewXtextProjectCreationPage_LabelLayout);
		layoutGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		layoutGroup.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(layoutGroup, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		composite.setLayout(new GridLayout(2, false));

		if (WizardContribution.getFromRegistry().size() > 1) {
			Label generatorConfigLabel = new Label(composite, SWT.NONE);
			generatorConfigLabel.setText(Messages.WizardNewXtextProjectCreationPage_GeneratorConfiguration);

			generatorConfigurationField = new Combo(composite, SWT.READ_ONLY);
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.horizontalSpan = 1;
			generatorConfigurationField.setLayoutData(data);
			generatorConfigurationField.setFont(parent.getFont());
		}

		generatorProjectField = new Button(composite, SWT.CHECK);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		generatorProjectField.setLayoutData(data);
		generatorProjectField.setText(Messages.WizardNewXtextProjectCreationPage_CreateAGeneratorProject);
		generatorProjectField.setSelection(true);
	}

	/**
	 * Returns the (user selection of) create generator package checkbox
	 */
	public boolean getCreateGeneratorPackage() {
		return generatorProjectField.getSelection();
	}

	/**
	 * Returns the supported DSL extensions as a CSV string
	 */
	public String getFileExtensions() {
		return extensionsField.getText();
	}

	public String getLanguageName() {
		return languageNameField.getText();
	}

	public String getGeneratorConfig() {
		if (generatorConfigurationField==null)
			return WizardContribution.getFromRegistry().values().iterator().next().getName();
		return generatorConfigurationField.getItems()[generatorConfigurationField.getSelectionIndex()];
	}
}