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

import java.io.File;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

//import org.eclipse.jface.internal.databinding.provisional.fieldassist.ControlDecorationSupport;

/**
 * The main page of the Releng project wizard.
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class WizardNewRelengProjectCreationPage extends WizardPage {

	private final IStructuredSelection selection;
	private final RelengProjectInfo projectInfo;

	private Text featureProjectField;

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

		featureProjectField = createFeatureSelectionControl(pageMain);
		Group prjGroup = createTreeRowGroup(pageMain, "Projects to create", 10);
		Text prjField = createProjectControl(prjGroup);
		Text sitePrjField = createSiteFeatureControl(prjGroup);
		Group buckyGroup = createTreeRowGroup(pageMain, "Buckminster", 0);
		Text buckyField = createBuckyControl(buckyGroup);
		ListViewer testsList = createTestsControl(buckyGroup);

		//Binding stuff
		DataBindingContext dbc = new DataBindingContext();
		WizardPageSupport.create(this, dbc);

		IObservableValue featPrjObserv = PojoObservables.observeValue(projectInfo, "buildFeatureName");
		bindFeatureProjectField(dbc, featPrjObserv);
		bindProjectField(prjField, dbc, featPrjObserv);
		bindSiteProjectField(sitePrjField, dbc, featPrjObserv);
		bindBuckyLocationField(buckyField, dbc);

		IObservableList observeList = new WritableList(projectInfo.getTestLaunchers(), IFile.class);
		testsList.setInput(observeList);
		testsList.setLabelProvider(new WorkbenchLabelProvider());
		setErrorMessage(null);
		setMessage(null);
		setControl(pageMain);
		Dialog.applyDialogFont(getControl());
		initialValues(selection);
	}

	private Group createTreeRowGroup(Composite pageMain, String name, int vertIdent) {
		Group prjGroup = new Group(pageMain, SWT.NONE);
		prjGroup.setFont(pageMain.getFont());
		prjGroup.setText(name);
		GridData layoutData = new GridData(SWT.FILL, SWT.TOP, true, false);
		layoutData.verticalIndent = vertIdent;
		layoutData.horizontalSpan = 3;
		prjGroup.setLayoutData(layoutData);
		prjGroup.setLayout(new GridLayout(3, false));
		return prjGroup;
	}

	private Text createFeatureSelectionControl(final Composite parent) {
		Triple<Label, Text, Button> selectionControl = createSelectionControl(parent, "Feature to build:");
		// text field
		final Text featureProjectField = selectionControl.getSecond();
		featureProjectField.setEditable(true);
		//select  button
		selectionControl.getThird().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IAcceptor<IProject> acceptor = new IAcceptor<IProject>() {

					public void accept(IProject project) {
						if (project != null) {
							featureProjectField.setText(project.getName());
						}
					}
				};
				DialogCatalog.openFeatureSelectionDialog(parent.getShell(), acceptor);
			}
		});
		return featureProjectField;
	}

	private Text createProjectControl(final Composite parent) {
		// label
		Label projectLabel = new Label(parent, SWT.NONE);
		projectLabel.setText("Releng project:");
		projectLabel.setFont(parent.getFont());

		// text field
		Text relengProjectField = new Text(parent, SWT.BORDER);
		GridData grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		relengProjectField.setLayoutData(grData);
		relengProjectField.setFont(parent.getFont());
		relengProjectField.setEnabled(false);
		return relengProjectField;
	}

	private Text createSiteFeatureControl(final Composite parent) {
		// label
		Label projectLabel = new Label(parent, SWT.NONE);
		projectLabel.setText("Site project:");
		projectLabel.setFont(parent.getFont());

		// text field
		Text text = new Text(parent, SWT.BORDER);
		GridData grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		text.setLayoutData(grData);
		text.setFont(parent.getFont());
		text.setEnabled(false);
		return text;
	}

	private Text createBuckyControl(final Composite parent) {
		Triple<Label, Text, Button> selectionControl = createSelectionControl(parent, "Installation:");
		final Text buckyField = selectionControl.getSecond();
		ControlDecoration dec = new ControlDecoration(buckyField, SWT.DOWN | SWT.LEFT, parent);
		FieldDecoration infoIndication = FieldDecorationRegistry.getDefault().getFieldDecoration(
				FieldDecorationRegistry.DEC_INFORMATION);
		dec.setImage(infoIndication.getImage());
		dec.setDescriptionText("You can also manuelly set the buckminster.home property in "
				+ RelengProjectFactory.BUILD_FILE_NAME + " file later.");

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
		return buckyField;
	}

	private ListViewer createTestsControl(final Composite parent) {
		// label
		Label projectLabel = new Label(parent, SWT.NONE);
		GridData gridData = new GridData(SWT.NONE);
		gridData.verticalAlignment = GridData.BEGINNING;
		projectLabel.setLayoutData(gridData);
		projectLabel.setText("Tests to launch:");
		projectLabel.setFont(parent.getFont());

		final ListViewer listViewer = new ListViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listViewer.setContentProvider(new ObservableListContentProvider());
		listViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		Composite buttons = new Composite(parent, SWT.NONE);
		buttons.setLayout(new RowLayout(SWT.VERTICAL));
		//select  button
		Button button = new Button(buttons, SWT.PUSH);
		button.setFont(parent.getFont());
		button.setText("Add");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IFile testLauncherFile = DialogCatalog.openJunitLaunchSelectionDialog(parent.getShell());
				if (testLauncherFile != null) {
					listViewer.add(testLauncherFile);
					IObservableList input = (IObservableList) listViewer.getInput();
					input.add(testLauncherFile);
					listViewer.setInput(input);
				}
			}
		});
		//select  button
		Button remove = new Button(buttons, SWT.PUSH);
		remove.setFont(parent.getFont());
		remove.setText("Remove");
		remove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection iSelection = listViewer.getSelection();
				if (!iSelection.isEmpty()) {
					IObservableList input = (IObservableList) listViewer.getInput();
					List<?> list = ((IStructuredSelection) iSelection).toList();
					if (input.containsAll(list)) {
						input.removeAll(list);
					}
					listViewer.setInput(input);
				}
			}
		});
		return listViewer;
	}

	private Triple<Label, Text, Button> createSelectionControl(final Composite composite, final String controlLabel) {
		// label
		Label projectLabel = new Label(composite, SWT.NONE);
		projectLabel.setText(controlLabel);
		projectLabel.setFont(composite.getFont());

		// text field
		Text text = new Text(composite, SWT.BORDER);
		GridData grData = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(grData);
		text.setFont(composite.getFont());
		text.setEditable(false);

		//select  button
		Button button = new Button(composite, SWT.PUSH);
		button.setFont(composite.getFont());
		button.setText("Select");
		return Tuples.create(projectLabel, text, button);
	}

	@SuppressWarnings("restriction")
	private void bindBuckyLocationField(Text buckyField, DataBindingContext dbc) {
		Binding binding = dbc.bindValue(SWTObservables.observeText(buckyField, SWT.Modify), PojoObservables
				.observeValue(projectInfo, "buckyLocation"), new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE)
				.setBeforeSetValidator(new BuckminsterLocationValidator()), null);
		//		ControlDecorationSupport.create(binding, SWT.LEFT | SWT.TOP, buckyField.getParent());
	}

	private void bindSiteProjectField(Text sitePrjField, DataBindingContext dbc, IObservableValue featPrjObserv) {
		IObservableValue siteFeatureObservable = PojoObservables.observeValue(projectInfo, "siteFeatureProjectName");
		dbc.bindValue(SWTObservables.observeText(sitePrjField, SWT.Modify), siteFeatureObservable);
		dbc.bindValue(featPrjObserv, siteFeatureObservable, new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE)
				.setConverter(new SuffixedNameComputedValue(projectInfo, "site")), null);
	}

	private void bindProjectField(Text prjField, DataBindingContext dbc, IObservableValue featPrjObserv) {
		IObservableValue prjObserv = PojoObservables.observeValue(projectInfo, "projectName");
		dbc.bindValue(SWTObservables.observeText(prjField, SWT.Modify), prjObserv);
		dbc.bindValue(featPrjObserv, prjObserv, new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE)
				.setConverter(new SuffixedNameComputedValue(projectInfo, "buckminster")), null);
	}

	@SuppressWarnings("restriction")
	private void bindFeatureProjectField(DataBindingContext dbc, IObservableValue featPrjObserv) {
		Binding featBinding = dbc.bindValue(SWTObservables.observeText(featureProjectField, SWT.Modify), featPrjObserv,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE)
						.setBeforeSetValidator(new FeatureProjectValidator()), null);
		//		ControlDecorationSupport.create(featBinding, SWT.LEFT | SWT.TOP);
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

	private void initialValues(final IStructuredSelection structSelection) {
		String initialValue = calculateFeatureSelection(structSelection);
		if (initialValue != null) {
			featureProjectField.setText(initialValue);
		}
	}

	final private static class SuffixedNameComputedValue extends Converter {
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
			if (Strings.isEmpty(nameSpace))
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

	static private class FeatureProjectValidator implements IValidator {

		public IStatus validate(Object value) {
			if (value == null || Strings.isEmpty(value.toString())) {
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

	static private class BuckminsterLocationValidator implements IValidator {

		public IStatus validate(Object value) {
			if (value == null || Strings.isEmpty(value.toString())) {
				return ValidationStatus
						.warning("Buckminster headless installation directory is not selected. How to install buckminster headless http://www.eclipse.org/buckminster/downloads.html");
			} else {
				File buckyHeadless = new File(value.toString());
				File[] files = buckyHeadless.listFiles();
				boolean buckminsterExecutableFound = false;
				for (File file : files) {
					if (file.isFile() && "buckminster".equals(file.getName())) {
						buckminsterExecutableFound = true;
						break;
					}
				}
				if (!buckminsterExecutableFound) {
					return ValidationStatus.warning("Selected directory '" + buckyHeadless
							+ "' seems not to be a buckminster headless installation.");
				}
			}
			return ValidationStatus.ok();
		}

	}
}