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

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Strings;

/**
 * The main page of the Releng project wizard.
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class WizardNewRelengProjectCreationPage extends WizardPage {

	private final IStructuredSelection selection;
	private Text featureProjectField;
	private Text relengProjectField;

	private Text buckyField;
	private Text testsField;
	private IFile testLauncherFile;
	private final RelengProjectInfo projectInfo;
	private Text siteProjectField;

	/**
	 * Constructs a new WizardNewRelengXtextProjectCreationPage.
	 * 
	 * @param pageName
	 *            the name of the page
	 * 
	 * @param selection
	 *            The current selection. If the current selection includes workingsets the workingsets field is
	 *            initialized with the selection.
	 */
	public WizardNewRelengProjectCreationPage(String pageName, IStructuredSelection selection,
			RelengProjectInfo projectInfo) {
		super(pageName);
		this.selection = selection;
		this.projectInfo = projectInfo;
		setTitle(Messages.WizardNewRelengProjectCreationPage_pageTitle);
		setDescription(Messages.WizardNewRelengProjectCreationPage_pageDescr);
	}

	public void createControl(final Composite parent) {
		Composite pageMain = new Composite(parent, SWT.NONE);
		initializeDialogUnits(parent);
		pageMain.setLayout(new GridLayout(3, false));

		createFeatureSelectionControl(pageMain);
		createProjectControl(pageMain);
		createSiteFeatureControl(pageMain);
		createBuckyControl(pageMain);
		createTestsControl(pageMain);

		//Bind stuff
		DataBindingContext dbc = new DataBindingContext();
		WizardPageSupport.create(this, dbc);

		IObservableValue featureProjectName = PojoObservables.observeValue(projectInfo, "buildFeatureName");
		dbc.bindValue(SWTObservables.observeText(featureProjectField, SWT.Modify), featureProjectName,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE)
						.setBeforeSetValidator(new FeatureProjectValidator()), null);

		IObservableValue projectNameObservable = PojoObservables.observeValue(projectInfo, "projectName");
		dbc.bindValue(SWTObservables.observeText(relengProjectField, SWT.Modify), projectNameObservable);
		dbc.bindValue(featureProjectName, projectNameObservable, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_UPDATE).setConverter(new SuffixedNameComputedValue(projectInfo,
				"buckminster")), null);

		IObservableValue siteFeatureObservable = PojoObservables.observeValue(projectInfo, "siteFeatureProjectName");
		dbc.bindValue(SWTObservables.observeText(siteProjectField, SWT.Modify), siteFeatureObservable);
		dbc.bindValue(featureProjectName, siteFeatureObservable, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_UPDATE).setConverter(new SuffixedNameComputedValue(projectInfo, "site")),
				null);

		dbc.bindValue(SWTObservables.observeText(buckyField, SWT.Modify),
				PojoObservables.observeValue(projectInfo, "buckyLocation"));

		setErrorMessage(null);
		setMessage(null);
		setControl(pageMain);
		Dialog.applyDialogFont(getControl());
		initialValues(selection);
	}

	private void initialValues(final IStructuredSelection structSelection) {
		String initialValue = calculateFeatureSelection(structSelection);
		if (initialValue != null) {
			featureProjectField.setText(initialValue);
		}
	}

	private Composite createFeatureSelectionControl(final Composite parent) {
		Triple<Composite, Text, Button> selectionControl = createSelectionControl(parent, "Feature to build:");
		// text field
		featureProjectField = selectionControl.getSecond();
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
		return selectionControl.getFirst();
	}

	private Composite createProjectControl(final Composite parent) {
		// label
		Label projectLabel = new Label(parent, SWT.NONE);
		projectLabel.setText("Project name:");
		projectLabel.setFont(parent.getFont());

		// text field
		relengProjectField = new Text(parent, SWT.BORDER);
		GridData grData = new GridData(GridData.FILL_HORIZONTAL);
		relengProjectField.setLayoutData(grData);
		relengProjectField.setFont(parent.getFont());
		relengProjectField.setEnabled(false);
		new Label(parent, SWT.NONE);
		return parent;
	}

	private Composite createSiteFeatureControl(final Composite parent) {
		// label
		Label projectLabel = new Label(parent, SWT.NONE);
		projectLabel.setText("Site project name:");
		projectLabel.setFont(parent.getFont());

		// text field
		siteProjectField = new Text(parent, SWT.BORDER);
		GridData grData = new GridData(GridData.FILL_HORIZONTAL);
		siteProjectField.setLayoutData(grData);
		siteProjectField.setFont(parent.getFont());
		siteProjectField.setEnabled(false);
		new Label(parent, SWT.NONE);
		return parent;
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

	private Triple<Composite, Text, Button> createSelectionControl(final Composite composite, final String controlName) {
		// label
		Label projectLabel = new Label(composite, SWT.NONE);
		projectLabel.setText(controlName);
		projectLabel.setFont(composite.getFont());

		// text field
		Text text = new Text(composite, SWT.BORDER);
		GridData grData = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(grData);
		text.setFont(composite.getFont());

		//select  button
		Button button = new Button(composite, SWT.PUSH);
		button.setFont(composite.getFont());
		button.setText("Select");
		return Tuples.create(composite, text, button);
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

	public IFile getTestLaunchFile() {
		return testLauncherFile;
	}

	final static class SuffixedNameComputedValue extends Converter {
		private final String suffix;
		private final RelengProjectInfo projectInfo;

		public SuffixedNameComputedValue(RelengProjectInfo projectInfo, String suffix) {
			super(String.class, String.class);
			this.projectInfo = projectInfo;
			this.suffix = suffix;
		}

		public Object convert(Object fromObject) {
			return calculateProjectName();
		}

		private String calculateProjectName() {
			String nameSpace = projectInfo.getProjectNameSpace();
			if (Strings.isNullOrEmpty(nameSpace))
				return "";
			String projectsuffix = findNextValidProjectSuffix(nameSpace, suffix); //$NON-NLS-1$ //$NON-NLS-2$
			return nameSpace + "." + projectsuffix;
		}

		/**
		 * TODO extract to util Find the next available (default) DSL name
		 */
		private String findNextValidProjectSuffix(final String prefix, final String name) {
			String candidate = name;
			int suffix = 1;
			while (ResourcesPlugin.getWorkspace().getRoot()
					.getProject((prefix + "." + candidate).toLowerCase()).exists()) { //$NON-NLS-1$
				candidate = name + suffix;
				suffix++;
			}
			return candidate;
		}
	}

	class FeatureProjectValidator implements IValidator {

		public IStatus validate(Object value) {
			if (value == null) {
				return ValidationStatus.error("Please select a feature project from your workspace.");
			} else {
				String featureProjectName = value.toString();
				if (!PDEUtils.featureProjectExists(featureProjectName)) {
					return ValidationStatus.error("Feature project with name '" + featureProjectName
							+ "' does not exist in this workspace.");
				}
			}
			return ValidationStatus.ok();
		}

	}
}