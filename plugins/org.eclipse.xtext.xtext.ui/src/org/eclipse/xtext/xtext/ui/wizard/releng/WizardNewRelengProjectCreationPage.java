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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

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
	private Text buckyField;
	private Text testsField;
	private IFile testLauncherFile;

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

	public void createControl(final Composite parent) {
		Composite pageMain = new Composite(parent, SWT.NONE);
		initializeDialogUnits(parent);
		pageMain.setLayout(new GridLayout());

		createFeatureSelectionControl(pageMain).setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		createProjectControl(pageMain).setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		createBuckyControl(pageMain).setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		createTestsControl(pageMain).setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		//setDefaults(projectsuffix);
		setErrorMessage(null);
		setMessage(null);
		setControl(pageMain);
		Dialog.applyDialogFont(getControl());
	}

	private Composite createFeatureSelectionControl(final Composite parent) {
		Triple<Composite, Text, Button> selectionControl = createSelectionControl(parent, "Feature to build:");
		// text field
		featureProjectField = selectionControl.getSecond();
		String initialValue = calculateFeatureSelection(selection);
		if (initialValue != null) {
			featureProjectField.setText(initialValue);
		}
		//select  button
		selectionControl.getThird().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DialogCatalog.openFeatureSelectionDialog(parent.getShell(), new IAcceptor<IProject>() {

					public void accept(IProject project) {
						if (project != null) {
							featureProjectField.setText(project.getName());
						}
					}
				});
			}
		});
		featureProjectField.addListener(SWT.Modify, featureChangedListener);
		return selectionControl.getFirst();
	}

	private Composite createProjectControl(final Composite parent) {
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

		String initialValue = calculateInitialProjectName(nullSafeFeatureProjectName());
		if (initialValue != null) {
			relengProjectField.setText(initialValue);
		}
		return composite;
	}

	private Composite createBuckyControl(final Composite parent) {
		Triple<Composite, Text, Button> selectionControl = createSelectionControl(parent, "Buckminster:");
		buckyField = selectionControl.getSecond();
		//select  button
		Button button = selectionControl.getThird();
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String folder = DialogCatalog.openOSFolderSelectionDialog(parent.getShell());
				if (folder != null) {
					buckyField.setText(folder);
				}
			}
		});
		return selectionControl.getFirst();
	}

	private Control createTestsControl(final Composite parent) {
		Triple<Composite, Text, Button> controlTriplet = createSelectionControl(parent, "Tests to launch:");
		testsField = controlTriplet.getSecond();
		//select  button
		Button button = controlTriplet.getThird();
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				testLauncherFile = DialogCatalog.openWorkspaceFileSelectionDialog(parent.getShell(), "*.launch");
				String fieldValue = "";
				if (testLauncherFile != null) {
					fieldValue = new Path(testLauncherFile.getProject().getName()).append(
							testLauncherFile.getProjectRelativePath()).toString();
				}
				testsField.setText(fieldValue);
			}
		});
		return controlTriplet.getFirst();
	}

	private Triple<Composite, Text, Button> createSelectionControl(final Composite parent, final String controlName) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);
		// label
		Label projectLabel = new Label(composite, SWT.NONE);
		projectLabel.setText(controlName);
		projectLabel.setFont(parent.getFont());

		// text field
		Text text = new Text(composite, SWT.BORDER);
		GridData grData = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(grData);
		text.setFont(parent.getFont());

		//select  button
		Button button = new Button(composite, SWT.PUSH);
		button.setFont(parent.getFont());
		button.setText("Select");
		return Tuples.create(composite, text, button);
	}

	protected final void featureProjectNameChanged() {
		setProjectName(calculateInitialProjectName(nullSafeFeatureProjectName()));
	}

	private String nullSafeFeatureProjectName() {
		return featureProjectField == null ? "" : featureProjectField.getText();
	}

	private void setProjectName(String projectName) {
		relengProjectField.setText(projectName);
	}

	private String calculateInitialProjectName(final String selectedFeatureProject) {
		String nameSpace = cutLastSegment(selectedFeatureProject);
		String projectsuffix = findNextValidProjectSuffix(nameSpace, "buckminster"); //$NON-NLS-1$ //$NON-NLS-2$
		return nameSpace + "." + projectsuffix;
	}

	private String cutLastSegment(final String selectedFeatureProject) {
		String nameSpace = selectedFeatureProject;
		int lastIndexOfDot = nameSpace.lastIndexOf('.');
		if (lastIndexOfDot > 0) {
			nameSpace = nameSpace.substring(0, lastIndexOfDot);
		}
		return nameSpace;
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

	/**
	 * Sets the defaults.
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

	public String getMainFeatureProjectName() {
		return nullSafeFeatureProjectName();
	}

	public String getProjectNameSpace() {
		return cutLastSegment(getProjectName());
	}

	public String getSiteFeatureProjectName() {
		return getProjectNameSpace() + ".site";
	}

	public String getBuckyLocation() {
		return buckyField.getText();
	}

	public IFile getTestLaunchFile() {
		return testLauncherFile;
	}
}