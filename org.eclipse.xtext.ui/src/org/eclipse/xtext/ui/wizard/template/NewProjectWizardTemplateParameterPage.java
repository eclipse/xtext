/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;

/**
 * Page in the new project wizard to display a list with project templates. User get some description text and can select a template. In a
 * later page he can eventually configure the project template further.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public class NewProjectWizardTemplateParameterPage extends WizardPage implements IParameterPage {

	private final AbstractProjectTemplate projectTemplate;

	private boolean inUserAction = true;

	public NewProjectWizardTemplateParameterPage(AbstractProjectTemplate projectTemplate, IExtendedProjectInfo projectInfo) {
		super("NewProjectWizardTemplateParameterPage");
		this.projectTemplate = projectTemplate;
		this.projectTemplate.setProjectInfo(projectInfo);
	}

	@Override
	public Composite getControl() {
		return (Composite) super.getControl();
	}

	@Override
	public void createControl(Composite parent) {
		Composite main = new Composite(parent, SWT.NONE);
		main.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		main.setLayout(new GridLayout(2, false));
		setControl(main);
		for (ProjectVariable variable : projectTemplate.getVariables()) {
			Label label = new Label(main, SWT.NONE);
			label.setText(variable.getLabel());
			label.setToolTipText(variable.getDescription());
			label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			variable.createWidget(this);
		}
		update();
	}

	@Override
	public void update() {
		if (inUserAction) {
			inUserAction = false;
			refreshVariables();
			validate();
			inUserAction = true;
		}
	}

	protected void validate() {
		IStatus status = projectTemplate.validate();
		if (status == null || status.getSeverity() == IStatus.OK) {
			setErrorMessage(null);
			setMessage(null);
			setPageComplete(true);
		} else if (status.getSeverity() == IStatus.ERROR) {
			setErrorMessage(status.getMessage());
			setPageComplete(false);
		} else if (status.getSeverity() == IStatus.WARNING) {
			setErrorMessage(null);
			setMessage(status.getMessage(), IMessageProvider.WARNING);
			setPageComplete(true);
		} else {
			setErrorMessage(null);
			setMessage(status.getMessage(), IMessageProvider.INFORMATION);
			setPageComplete(true);
		}
	}

	private void refreshVariables() {
		projectTemplate.updateVariables();
		for (ProjectVariable variable : projectTemplate.getVariables()) {
			variable.refresh();
		}
	}

}
