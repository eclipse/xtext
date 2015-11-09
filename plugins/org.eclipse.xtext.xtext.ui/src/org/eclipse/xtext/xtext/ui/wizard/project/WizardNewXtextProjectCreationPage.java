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

import java.util.Arrays;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.util.Policy;
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
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.xtext.ui.util.JREContainerProvider;
import org.eclipse.xtext.util.JavaVersion;

import com.google.common.collect.Sets;

/**
 * The main page of the Xtext project wizard.
 * 
 * @author KD - Initial contribution and API
 * @author Knut Wannheden
 * @author Sebastian Zarnekow
 */
public class WizardNewXtextProjectCreationPage extends WizardNewProjectCreationPage {
	private Text languageNameField;
	private final IStructuredSelection selection;
	private Text extensionsField;
	private Combo breeCombo;
	private Button exeEnvButton;

	/**
	 * Constructs a new WizardNewXtextProjectCreationPage.
	 * 
	 * @param pageName
	 *            the name of the page
	 * 
	 * @param selection
	 *            The current selection. If the current selection includes workingsets the workingsets field is initialized with the
	 *            selection.
	 */
	public WizardNewXtextProjectCreationPage(String pageName, IStructuredSelection selection) {
		super(pageName);
		this.selection = selection;
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
		creatBreeGroup((Composite) getControl());
		createWorkingSetGroup((Composite) getControl(), selection, getWorkingSetIdents());
		setDefaults(projectsuffix);
		Dialog.applyDialogFont(getControl());
	}

	protected void creatBreeGroup(Composite parent) {

		Group breeGroup = new Group(parent, SWT.NONE);
		breeGroup.setFont(parent.getFont());
		breeGroup.setText(Messages.WizardNewXtextProjectCreationPage_EEGrTitle);
		breeGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		breeGroup.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(breeGroup, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		composite.setLayout(new GridLayout(3, false));

		Label breeLabel = new Label(composite, SWT.NONE);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 1;
		breeLabel.setText(Messages.WizardNewXtextProjectCreationPage_EECombo);

		breeCombo = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 1;
		breeCombo.setLayoutData(data);
		breeCombo.setFont(parent.getFont());
		fillBreeCombo(breeCombo);

		Listener modifyListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				setPageComplete(validatePage());
			}
		};
		breeCombo.addListener(SWT.Modify, modifyListener);
		// Create button
		exeEnvButton = new Button(composite, SWT.PUSH);
		exeEnvButton.setLayoutData(new GridData());
		exeEnvButton.setText(Messages.WizardNewXtextProjectCreationPage_EEButton);
		exeEnvButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				PreferencesUtil.createPreferenceDialogOn(getShell(), "org.eclipse.jdt.debug.ui.jreProfiles", //$NON-NLS-1$
						new String[] { "org.eclipse.jdt.debug.ui.jreProfiles" }, null).open(); //$NON-NLS-1$ 
				fillBreeCombo(breeCombo);
			}
		});
	}

	@SuppressWarnings("unchecked")
	protected void fillBreeCombo(Combo comboToFill) {
		Set<String> brees = Sets.newHashSet(JREContainerProvider.getDefaultBREE());
		Set<String> availableBrees = Sets.newHashSet();
		for (IExecutionEnvironment ee : JavaRuntime.getExecutionEnvironmentsManager().getExecutionEnvironments()) {
			availableBrees.add(ee.getId());
		}
		for (JavaVersion supportedVersion : JavaVersion.values()) {
			if (supportedVersion.isAtLeast(JavaVersion.JAVA6)) {
				String bree = supportedVersion.getBree();
				if (availableBrees.contains(bree))
					brees.add(bree);
			}
		}
		String[] array = brees.toArray(new String[] {});
		Arrays.sort(array, Policy.getComparator());
		comboToFill.setItems(array);
		String selectionMemento = comboToFill.getText();
		int index = comboToFill.indexOf(selectionMemento);
		if (index < 0) {
			comboToFill.select(comboToFill.indexOf(JREContainerProvider.getDefaultBREE()));
		}
		comboToFill.select(index);
	}

	protected String[] getWorkingSetIdents() {
		return new String[] { "org.eclipse.jdt.ui.JavaWorkingSetPage", //$NON-NLS-1$
				"org.eclipse.pde.ui.pluginWorkingSet", //$NON-NLS-1$
				"org.eclipse.ui.resourceWorkingSetPage" //$NON-NLS-1$
		};
	}

	/**
	 * Sets the defaults for the languageName and extensions.
	 * 
	 * @param projectSuffix
	 *            the name of the DSL
	 * @see findNextValidProjectSuffix(String, String)
	 */
	protected void setDefaults(String projectSuffix) {
		languageNameField.setText("org.xtext.example." + projectSuffix + ".MyDsl"); //$NON-NLS-1$ //$NON-NLS-2$
		extensionsField.setText(projectSuffix);
		breeCombo.select(breeCombo.indexOf(JREContainerProvider.getDefaultBREE()));
		validatePage();
	}

	/**
	 * Find the next available (default) DSL name
	 */
	protected String findNextValidProjectSuffix(final String prefix, final String name) {
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
		IStatus status = JavaConventions.validatePackageName(getProjectName(), JavaCore.VERSION_1_5, JavaCore.VERSION_1_5);
		if (!status.isOK()) {
			setErrorMessage(Messages.WizardNewXtextProjectCreationPage_ErrorMessageProjectName + status.getMessage());
			return false;
		}
		if (languageNameField == null) // See the comment in createControl
			return true;
		if (languageNameField.getText().length() == 0)
			return false;

		status = JavaConventions.validateJavaTypeName(languageNameField.getText(), JavaCore.VERSION_1_5, JavaCore.VERSION_1_5);
		if (!status.isOK()) {
			setErrorMessage(Messages.WizardNewXtextProjectCreationPage_ErrorMessageLanguageName + status.getMessage());
			return false;
		}
		if (extensionsField.getText().length() == 0)
			return false;
		if (!Sets.newHashSet(JREContainerProvider.getConfiguredBREEs()).contains(breeCombo.getText())) {
			setMessage(Messages.WizardNewXtextProjectCreationPage_eeInfo_0 + breeCombo.getText()
					+ Messages.WizardNewXtextProjectCreationPage_eeInfo_1, IMessageProvider.INFORMATION);
			return true;
		}
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
			@Override
			public void handleEvent(Event event) {
				setPageComplete(validatePage());
			}
		};
		languageNameField.addListener(SWT.Modify, modifyListener);
		extensionsField.addListener(SWT.Modify, modifyListener);
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

	public JavaVersion getJavaVersion() {
		String selected = breeCombo.getText();
		JavaVersion version = JavaVersion.fromBree(selected);
		return version;
	}
}