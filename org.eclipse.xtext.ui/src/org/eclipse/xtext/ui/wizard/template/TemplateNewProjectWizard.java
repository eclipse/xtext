/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.xtext.ui.util.FileOpener;
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import org.eclipse.xtext.ui.wizard.IProjectInfo;

import com.google.inject.Inject;

/**
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public abstract class TemplateNewProjectWizard extends Wizard implements INewWizard {

	private static final Logger logger = Logger.getLogger(TemplateNewProjectWizard.class);

	protected IStructuredSelection selection;

	private WizardNewProjectCreationPage mainPage;
	private NewProjectWizardTemplateSelectionPage templatePage;
	private NewProjectWizardTemplateParameterPage templateParameterPage;

	@Inject
	private ProjectTemplateLabelProvider labelProvider;
	@Inject
	private FileOpener fileOpener;
	@Inject
	private IProjectCreator projectCreator;

	private IWorkbench workbench;

	public TemplateNewProjectWizard() {
		setNeedsProgressMonitor(true);
		setWindowTitle("New Template Project");
	}

	/**
	 * Use this method to add pages to the wizard. The one-time generated version of this class will add a default new project page to the
	 * wizard.
	 */
	@Override
	public void addPages() {
		mainPage = createMainPage("basicNewProjectPage");
		mainPage.setTitle(getGrammarName() + " Project");
		mainPage.setDescription("Create a new " + getGrammarName() + " project.");
		addPage(mainPage);
		templatePage = createTemplatePage("templateNewProjectPage");
		templatePage.setTitle(getGrammarName() + " Project");
		templatePage.setDescription("Create a new " + getGrammarName() + " project.");
		addPage(templatePage);
	}

	protected WizardNewProjectCreationPage createMainPage(String pageName) {
		return new WizardNewProjectCreationPage(pageName);
	}

	protected NewProjectWizardTemplateSelectionPage createTemplatePage(String pageName) {
		return new NewProjectWizardTemplateSelectionPage(pageName, getGrammarName(), labelProvider);
	}

	protected abstract String getGrammarName();

	protected IExtendedProjectInfo getProjectInfo() {
		TemplateProjectInfo projectInfo = new TemplateProjectInfo(templatePage == null ? null : templatePage.getSelectedTemplate());
		projectInfo.setProjectName(mainPage.getProjectName());
		if (!mainPage.useDefaults()) {
			projectInfo.setLocationPath(mainPage.getLocationPath());
		}
		return projectInfo;
	}

	@Override
	public boolean performFinish() {
		final IProjectInfo projectInfo = getProjectInfo();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(projectInfo, monitor);
				} catch (Exception e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			logger.error(e.getMessage(), e);
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}

	protected void doFinish(final IProjectInfo projectInfo, final IProgressMonitor monitor) {
		try {
			TemplateProjectInfo templateProjectInfo = (TemplateProjectInfo) projectInfo;
			AbstractProjectTemplate projectTemplate = templateProjectInfo.getProjectTemplate();
			projectTemplate.setProjectInfo(templateProjectInfo);
			projectTemplate.generateProjects((IProjectGenerator) projectCreator);
			projectCreator.setProjectInfo(projectInfo);
			projectCreator.run(monitor);
			fileOpener.selectAndReveal(projectCreator.getResult());
			fileOpener.openFileToEdit(getShell(), projectCreator.getResult());
		} catch (final InvocationTargetException e) {
			logger.error(e.getMessage(), e);
		} catch (final InterruptedException e) {
			// cancelled by user, ok
			return;
		}
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	public IWorkbench getWorkbench() {
		return workbench;
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page instanceof NewProjectWizardTemplateSelectionPage) {
			AbstractProjectTemplate selectedTemplate = templatePage.getSelectedTemplate();
			if (selectedTemplate == null)
				return null;
			List<ProjectVariable> variables = selectedTemplate.getVariables();
			if (variables.isEmpty())
				return null;
			NewProjectWizardTemplateParameterPage parameterPage = new NewProjectWizardTemplateParameterPage(selectedTemplate,
					getProjectInfo());
			parameterPage.setWizard(this);
			templateParameterPage = parameterPage;
			parameterPage.setTitle(getGrammarName() + " Project");
			parameterPage.setDescription("Create a new " + getGrammarName() + " project.");
			return parameterPage;
		}
		return super.getNextPage(page);
	}

	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		if (page instanceof NewProjectWizardTemplateParameterPage) {
			templateParameterPage = null;
			return templatePage;
		}
		return super.getPreviousPage(page);
	}

	@Override
	public boolean canFinish() {
		return super.canFinish() && (templateParameterPage == null ? true : templateParameterPage.isPageComplete());
	}
}