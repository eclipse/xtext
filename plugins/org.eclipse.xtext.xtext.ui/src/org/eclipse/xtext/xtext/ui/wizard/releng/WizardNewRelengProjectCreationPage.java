/*******************************************************************************
 * Copyright (c) 2012 Dennis Huebner, itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Denni Huebner
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * The main page of the Releng project wizard.
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class WizardNewRelengProjectCreationPage extends WizardPage {

	private final IStructuredSelection selection;
	private Text featureProjectField;
	private Text relengProjectField;

	private Listener featureChangedListener = new Listener() {
		public void handleEvent(Event e) {
			featureProjectNameChanged();
			boolean valid = validatePage();
			setPageComplete(valid);
		}
	};

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
	public WizardNewRelengProjectCreationPage(String pageName, IStructuredSelection selection) {
		super(pageName);
		this.selection = selection;
		setTitle(Messages.WizardNewRelengProjectCreationPage_pageTitle);
		setDescription(Messages.WizardNewRelengProjectCreationPage_pageDescr);
	}

	protected final void featureProjectNameChanged() {
		setProjectName(calculateInitialProjectName(nullSafeFeatureProjectName()));
	}

	private String nullSafeFeatureProjectName() {
		return featureProjectField == null ? "" : featureProjectField.getText();
	}

	public void createControl(final Composite parent) {
		Composite pageMain = new Composite(parent, SWT.NONE);
		initializeDialogUnits(parent);
		pageMain.setLayout(new GridLayout());

		Composite featureControl = createFeatureSelectionControl(pageMain, calculateFeatureSelection(selection));
		featureControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite projectControl = createProjectControl(pageMain,
				calculateInitialProjectName(nullSafeFeatureProjectName()));
		projectControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		//		setDefaults(projectsuffix);
		setErrorMessage(null);
		setMessage(null);
		setControl(pageMain);
		Dialog.applyDialogFont(getControl());
	}

	private void setProjectName(String projectName) {
		relengProjectField.setText(projectName);
	}

	private String calculateInitialProjectName(final String selectedFeatureProject) {
		String nameSpace = selectedFeatureProject;
		int lastIndexOfDot = nameSpace.lastIndexOf('.');
		if (lastIndexOfDot > 0) {
			nameSpace = nameSpace.substring(0, lastIndexOfDot);
		}
		String projectsuffix = findNextValidProjectSuffix(nameSpace, "buckminster"); //$NON-NLS-1$ //$NON-NLS-2$
		return nameSpace + "." + projectsuffix;
	}

	private String calculateFeatureSelection(IStructuredSelection structSelection) {
		String initialSelection = null;
		if (structSelection != null) {
			Object firstElement = structSelection.getFirstElement();
			if (firstElement instanceof IProject) {
				IProject project = (IProject) firstElement;
				initialSelection = project.getName();
			}
		}
		return initialSelection;
	}

	private Composite createFeatureSelectionControl(final Composite parent, final String initialValue) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);
		// label
		Label projectLabel = new Label(composite, SWT.NONE);
		projectLabel.setText("Feature to build:");
		projectLabel.setFont(parent.getFont());

		// text field
		featureProjectField = new Text(composite, SWT.BORDER);
		GridData grData = new GridData(GridData.FILL_HORIZONTAL);
		featureProjectField.setLayoutData(grData);
		featureProjectField.setFont(parent.getFont());

		if (initialValue != null) {
			featureProjectField.setText(initialValue);
		}

		//select  button
		Button selectFeatureButton = new Button(composite, SWT.PUSH);
		selectFeatureButton.setFont(parent.getFont());
		selectFeatureButton.setText("Select");
		selectFeatureButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openFeatureSelectionDialog(parent.getShell(), featureProjectField.getText());
			}

		});

		featureProjectField.addListener(SWT.Modify, featureChangedListener);
		return composite;
	}

	private Composite createProjectControl(final Composite parent, final String initialValue) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gridLayout = new GridLayout(2, false);
		composite.setLayout(gridLayout);
		// label
		Label projectLabel = new Label(composite, SWT.NONE);
		projectLabel.setText("Project name:");
		projectLabel.setFont(parent.getFont());

		// text field
		relengProjectField = new Text(composite, SWT.BORDER);
		GridData grData = new GridData(GridData.FILL_HORIZONTAL);
		relengProjectField.setLayoutData(grData);
		relengProjectField.setFont(parent.getFont());

		if (initialValue != null) {
			relengProjectField.setText(initialValue);
		}
		return composite;
	}

	protected final void openFeatureSelectionDialog(final Shell shell, final String initialSelection) {
		BusyIndicator.showWhile(shell.getDisplay(), new Runnable() {
			@SuppressWarnings("restriction")
			public void run() {
				org.eclipse.pde.internal.core.ifeature.IFeatureModel[] allModels = org.eclipse.pde.internal.core.PDECore
						.getDefault().getFeatureModelManager().getWorkspaceModels();

				SelectionDialog dialog = new org.eclipse.pde.internal.ui.dialogs.FeatureSelectionDialog(shell,
						allModels, false);
				if (dialog.open() == Window.OK) {
					Object[] models = dialog.getResult();
					if (models.length > 0) {
						Object selectedElement = models[0];
						if (selectedElement instanceof org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel) {
							IProject project = ((org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel) selectedElement)
									.getFile().getProject();
							featureProjectField.setText(project.getName());
						}
					}
				}
			}
		});
	}

	/**
	 * Sets the defaults for the languageName and extensions.
	 */
	protected void setDefaults(String projectSuffix) {
		validatePage();
	}

	/**
	 * TODO extract to util Find the next available (default) DSL name
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

	protected boolean validatePage() {
		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	public String getProjectName() {
		return relengProjectField.getText();
	}

	public String getFeatureProjectName() {
		return nullSafeFeatureProjectName();
	}
}