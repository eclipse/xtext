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

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Strings;

//import org.eclipse.jface.internal.databinding.provisional.fieldassist.ControlDecorationSupport;

/**
 * The main page of the Releng project wizard.
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class WizardNewRelengProjectCreationPage extends WizardPage {

	private final IStructuredSelection selection;
	private final RelengProjectInfo projectInfo;
	private DataBindingContext dbc;

	/**
	 * Constructs a new WizardNewRelengXtextProjectCreationPage.
	 * 
	 * @param pageName
	 *            the name of the page
	 * 
	 * @param selection
	 *            The current selection.
	 */
	public WizardNewRelengProjectCreationPage(String pageName, IStructuredSelection selection,
			RelengProjectInfo projectInfo) {
		super(pageName);
		this.selection = selection;
		this.projectInfo = projectInfo;
		setTitle(Messages.WizardNewRelengProjectCreationPage_pageTitle);
		setDescription(Messages.WizardNewRelengProjectCreationPage_pageDescr);
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(final Composite parent) {
		Composite pageMain = new Composite(parent, SWT.NONE);
		initializeDialogUnits(parent);
		pageMain.setLayout(new GridLayout(3, false));

		Text featureProjectField = createFeatureSelectionControl(pageMain);
		Group prjGroup = createTreeRowGroup(pageMain, Messages.WizardNewRelengProjectCreationPage_prjGroupLbl, 10);
		Text prjField = createProjectControl(prjGroup);
		Text sitePrjField = createSiteFeatureControl(prjGroup);
		Group buckyGroup = createTreeRowGroup(pageMain, Messages.WizardNewRelengProjectCreationPage_buckyGroupLbl, 0);
		Text buckyField = createBuckyControl(buckyGroup);
		createInstallationText(buckyGroup, Messages.WizardNewRelengProjectCreationPage_buckminsteInstallText,
				buckyField);
		ListViewer testsList = createTestsControl(buckyGroup);

		dbc = new DataBindingContext();
		WizardPageSupport.create(this, dbc);

		ProjectInfoBinder binder = new ProjectInfoBinder(dbc, projectInfo);
		IObservableValue featPrjObserv = binder.bindFeatureProjectField(featureProjectField);
		binder.bindProjectField(prjField, featPrjObserv);
		binder.bindSiteProjectField(sitePrjField, featPrjObserv);
		binder.bindBuckyLocationField(buckyField);
		binder.bindTestLaunchers(testsList);

		setErrorMessage(null);
		setMessage(null);
		setControl(pageMain);
		Dialog.applyDialogFont(getControl());

		loadInitialValues(selection, featureProjectField, buckyField);
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
		Triple<Label, Text, Button> selectionControl = createSelectionControl(parent,
				Messages.WizardNewRelengProjectCreationPage_featFieldLbl);
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
		projectLabel.setText(Messages.WizardNewRelengProjectCreationPage_relPrjFieldLbl);
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
		projectLabel.setText(Messages.WizardNewRelengProjectCreationPage_sitePrjFieldLbl);
		projectLabel.setFont(parent.getFont());
		projectLabel.setLayoutData(new GridData());
		// text field
		Text text = new Text(parent, SWT.BORDER);
		GridData grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		text.setLayoutData(grData);
		text.setFont(parent.getFont());
		text.setEnabled(false);
		return text;
	}

	private Link createInstallationText(final Composite parent, final String text, final Text buckyField) {
		Link link = new Link(parent, SWT.NONE);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 3;
		link.setLayoutData(layoutData);
		link.setText(text);
		link.setToolTipText("Click here to install buckminster headless from " + P2DirectorLaunch.REPOSITORY);
		link.setFont(parent.getFont());
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				final ILaunchConfigurationType configurationType = DebugPlugin.getDefault().getLaunchManager()
						.getLaunchConfigurationType("org.eclipse.pde.ui.RuntimeWorkbench");

				final String destinationPath;

				if (!Strings.isNullOrEmpty(buckyField.getText())) {
					destinationPath = buckyField.getText();
				} else {
					destinationPath = P2DirectorLaunch.DESTINATION_JAVA;
					buckyField.setText(destinationPath);
				}

				try {
					IRunnableWithProgress runnable = new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor) throws InvocationTargetException,
								InterruptedException {
							SubMonitor localmonitor = SubMonitor.convert(monitor, "Installing Buckminster", 200);
							ILaunchConfigurationWorkingCopy workingCopy;
							try {
								workingCopy = configurationType.newInstance(null, "Install buckminster headless");
								P2DirectorLaunch.setupLaunchConfiguration(workingCopy, destinationPath);
								ILaunch launch = workingCopy.launch(ILaunchManager.RUN_MODE, localmonitor.newChild(20));
								while (!localmonitor.isCanceled() && !launch.isTerminated()) {
									localmonitor.worked(5);
									localmonitor.setWorkRemaining(180);
									Thread.sleep(200l);
								}
								Display.getDefault().syncExec(new Runnable() {
									public void run() {
										dbc.updateModels();
									}
								});
							} catch (CoreException e) {
								throw new InvocationTargetException(e);
							}
						}
					};
					new ProgressMonitorDialog(parent.getShell()).run(true, true, runnable);

				} catch (InvocationTargetException e2) {
					// handle exception
					e2.printStackTrace();
				} catch (InterruptedException e3) {
					// handle cancelation
					e3.printStackTrace();
				}
			}
		});
		return link;
	}

	private Text createBuckyControl(final Composite parent) {
		Triple<Label, Text, Button> selectionControl = createSelectionControl(parent,
				Messages.WizardNewRelengProjectCreationPage_buckyInstallFieldLbl);
		final Text buckyField = selectionControl.getSecond();
		buckyField.setEditable(true);

		ControlDecoration dec = new ControlDecoration(buckyField, SWT.DOWN | SWT.LEFT, parent);
		FieldDecoration infoIndication = FieldDecorationRegistry.getDefault().getFieldDecoration(
				FieldDecorationRegistry.DEC_INFORMATION);
		dec.setImage(infoIndication.getImage());
		dec.setDescriptionText(NLS.bind(Messages.WizardNewRelengProjectCreationPage_buckyControlInfo,
				RelengProjectFactory.BUILD_FILE_NAME));

		//select  button
		Button button = selectionControl.getThird();
		button.setText(Messages.WizardNewRelengProjectCreationPage_browseButton);
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
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.BEGINNING;
		projectLabel.setLayoutData(gridData);
		projectLabel.setText(Messages.WizardNewRelengProjectCreationPage_testsListLbl);
		projectLabel.setFont(parent.getFont());

		final ListViewer listViewer = new ListViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listViewer.setContentProvider(new ObservableListContentProvider());
		listViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		Composite buttons = new Composite(parent, SWT.NONE);
		buttons.setLayout(new RowLayout(SWT.VERTICAL));
		//select  button
		Button button = new Button(buttons, SWT.PUSH);
		button.setFont(parent.getFont());
		button.setText(Messages.WizardNewRelengProjectCreationPage_addTestButton);
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
		remove.setText(Messages.WizardNewRelengProjectCreationPage_removeTestButton);
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
		button.setText(Messages.WizardNewRelengProjectCreationPage_selectButton);
		return Tuples.create(projectLabel, text, button);
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

	private void loadInitialValues(final IStructuredSelection structSelection, Text featureProjectField, Text buckyField) {
		String initialValue = calculateFeatureSelection(structSelection);
		if (initialValue != null) {
			featureProjectField.setText(initialValue);
		}
		buckyField.setText(P2DirectorLaunch.DESTINATION_JAVA);

	}

}