/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
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
		super("wizardPage");
		setTitle("Xtext project wizard");
		setDescription("This wizard creates a pair of projects for your Xtext DSL.");
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
		label.setText("Main &project name:");

		projectText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		projectText.setLayoutData(gd);
		projectText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		label = new Label(container, SWT.NULL);
		label.setText("&Language name:");

		languageNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		languageNameText.setLayoutData(gd);
		languageNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		label = new Label(container, SWT.NULL);
		label.setText("DSL-File extension:");

		fileExtensionText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileExtensionText.setLayoutData(gd);
		fileExtensionText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		label = new Label(container, SWT.NULL);
		label.setText("Create generator project:");

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

		if (!xtextProjectInfo.getProjectName().matches("\\w+[\\w\\.]*\\w+")) {
			setErrorMessage("Project name must be specified (and must be in Java Package syntax (e.g. org.example))");
			setPageComplete(false);
			return;
		}
		// check whether project already exists
		final IProject handle = ResourcesPlugin.getWorkspace().getRoot().getProject(xtextProjectInfo.getProjectName());
		if (handle.exists()) {
			setErrorMessage("A project with this name already exists.");
			setPageComplete(false);
			return;
		}
		if (!xtextProjectInfo.getLanguageName().matches("\\w+[\\w\\.]*\\w+")) {
			setErrorMessage("Language name must be specified (example: org.xtext.example.MyDsl)");
			setPageComplete(false);
			return;
		}
		try {
			new URI(xtextProjectInfo.getNsURI());
		}
		catch (URISyntaxException e) {
			setErrorMessage("The namespace URI is no valid URI (example: 'http://example.xtext.org/MyDsl')");
			setPageComplete(false);
			return;
		}
		setErrorMessage(null);
		setPageComplete(true);
	}

	private void initializeDefaultValues() {
		String dslName = findNextValidDSLName("org.xtext.example", "MyDsl");
		projectText.setText("org.xtext.example." + dslName.toLowerCase());
		languageNameText.setText("org.xtext.example." + dslName);
		fileExtensionText.setText(dslName.toLowerCase());
		generateGenProject.setSelection(true);
	}

	private String findNextValidDSLName(String prefix, String name) {
		String candidate = name;
		int suffix = 1;
		while (ResourcesPlugin.getWorkspace().getRoot().getProject((prefix + "." + candidate).toLowerCase()).exists()) {
			candidate = name + suffix;
			suffix++;
		}
		return candidate;
	}
}