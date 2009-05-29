/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.Messages;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (xtxt).
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class NewXtextProjectWizardPage extends WizardPage {

	private Text projectText;

	private Text languageNameText;

	private Text fileExtensionText;

	private Button generateGenProject;

	private XtextProjectInfo xtextProjectInfo = new XtextProjectInfo();

//	private ISelection selection;

	/**
	 * Constructor for NewXtextProjectWizardPage.
	 * 
	 * @param pageName
	 */
	public NewXtextProjectWizardPage(ISelection selection) {
		super("wizardPage"); //$NON-NLS-1$
		setTitle(Messages.NewXtextProjectWizardPage_Title);
		setDescription(Messages.NewXtextProjectWizardPage_Description);
//		this.selection = selection;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		Label label = new Label(container, SWT.NULL);
		label.setText(Messages.NewXtextProjectWizardPage_MainProjectName);

		projectText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		projectText.setLayoutData(gd);
		projectText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		label = new Label(container, SWT.NULL);
		label.setText(Messages.NewXtextProjectWizardPage_LanguageName);

		languageNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		languageNameText.setLayoutData(gd);
		languageNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		label = new Label(container, SWT.NULL);
		label.setText(Messages.NewXtextProjectWizardPage_FileExtension);

		fileExtensionText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileExtensionText.setLayoutData(gd);
		fileExtensionText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		label = new Label(container, SWT.NULL);
		label.setText(Messages.NewXtextProjectWizardPage_GeneratorProject);

		generateGenProject = new Button(container, SWT.CHECK);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		generateGenProject.setLayoutData(gd);
		generateGenProject.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				dialogChanged();
			}

			public void widgetSelected(SelectionEvent e) {
				dialogChanged();
			}
		});
		
		initializeDefaultValues();
		dialogChanged();
		setControl(container);
	}

	/**
	 * 
	 * @return the accumulated xtext projectInfo
	 */
	public XtextProjectInfo getXtextProjectInfo() {
		return this.xtextProjectInfo;
	}

	/**
	 * Ensures that both text fields are set.
	 */
	void dialogChanged() {
		xtextProjectInfo.setProjectName(projectText.getText());
		xtextProjectInfo.setLanguageName(languageNameText.getText());
		xtextProjectInfo.setFileExtension(fileExtensionText.getText());
		xtextProjectInfo.setCreateGeneratorProject(generateGenProject.getSelection());

		if (!xtextProjectInfo.getProjectName().matches("\\w+[\\w\\.]*\\w+")) { //$NON-NLS-1$
			setErrorMessage(Messages.NewXtextProjectWizardPage_ProjectNameValidationError);
			setPageComplete(false);
			return;
		}
		// check whether project already exists
		final IProject handle = ResourcesPlugin.getWorkspace().getRoot().getProject(xtextProjectInfo.getProjectName());
		if (handle.exists()) {
			setErrorMessage(Messages.NewXtextProjectWizardPage_DuplicateProjectName);
			setPageComplete(false);
			return;
		}
		if (!xtextProjectInfo.getLanguageName().matches("\\w+[\\w\\.]*\\w+")) { //$NON-NLS-1$
			setErrorMessage(Messages.NewXtextProjectWizardPage_LanguageNameMandatory);
			setPageComplete(false);
			return;
		}
		try {
			new URI(xtextProjectInfo.getNsURI());
		}
		catch (URISyntaxException e) {
			setErrorMessage(Messages.NewXtextProjectWizardPage_InvalidURI);
			setPageComplete(false);
			return;
		}
		setErrorMessage(null);
		setPageComplete(true);
	}

	private void initializeDefaultValues() {
		String dslName = findNextValidDSLName("org.xtext.example", "MyDsl"); //$NON-NLS-1$ //$NON-NLS-2$
		projectText.setText("org.xtext.example." + dslName.toLowerCase()); //$NON-NLS-1$
		languageNameText.setText("org.xtext.example." + dslName); //$NON-NLS-1$
		fileExtensionText.setText(dslName.toLowerCase());
		generateGenProject.setSelection(true);
	}

	private String findNextValidDSLName(String prefix, String name) {
		String candidate = name;
		int suffix = 1;
		while (ResourcesPlugin.getWorkspace().getRoot().getProject((prefix + "." + candidate).toLowerCase()).exists()) { //$NON-NLS-1$
			candidate = name + suffix;
			suffix++;
		}
		return candidate;
	}
}