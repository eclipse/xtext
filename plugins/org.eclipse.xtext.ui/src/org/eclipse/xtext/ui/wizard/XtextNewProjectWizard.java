/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.util.FileOpener;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 */
public abstract class XtextNewProjectWizard extends Wizard implements INewWizard {

	private static final Logger logger = Logger.getLogger(XtextNewProjectWizard.class);

	protected IStructuredSelection selection;

	@Inject
	private FileOpener fileOpener;
	
	private IProjectCreator creator;

	private IWorkbench workbench;
	
	public XtextNewProjectWizard(IProjectCreator creator) {
		this.creator = creator;
		setNeedsProgressMonitor(true);
	}

	protected abstract IProjectInfo getProjectInfo();

	@Override
	public boolean performFinish() {
		final IProjectInfo projectInfo = getProjectInfo();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(projectInfo, monitor);
				}
				catch (Exception e) {
					throw new InvocationTargetException(e);
				}
				finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		}
		catch (InterruptedException e) {
			return false;
		}
		catch (InvocationTargetException e) {
			logger.error(e.getMessage(), e);
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), Messages.XtextNewProjectWizard_ErrorDialog_Title, realException.getMessage());
			return false;
		}
		return true;
	}

	protected void doFinish(final IProjectInfo projectInfo, final IProgressMonitor monitor) {
		try {
			creator.setProjectInfo(projectInfo);
			creator.run(monitor);
			fileOpener.selectAndReveal(creator.getResult());
			fileOpener.openFileToEdit(getShell(), creator.getResult());
		}
		catch (final InvocationTargetException e) {
			logger.error(e.getMessage(), e);
		}
		catch (final InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	public IWorkbench getWorkbench() {
		return workbench;
	}
	
	protected IProjectCreator getCreator() {
		return creator;
	}

}