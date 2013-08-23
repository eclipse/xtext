/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.ltk.core.refactoring.RefactoringCore;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringUI;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtext.ui.refactoring.impl.Messages;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 */
public class RenameRefactoringExecuter {

	@Inject
	private IWorkspace workspace;
	
	@Inject
	private SyncUtil syncUtil;

	private static final Logger LOG = Logger.getLogger(RenameRefactoringExecuter.class);

	protected boolean isApplicable(Shell parent, ProcessorBasedRefactoring refactoring) {
		try {
			if (refactoring.isApplicable()) {
				return true;
			}
			showFatalErrorMessage(parent, "Refactoring is not applicable");
		} catch (CoreException e) {
			LOG.error("Error detecting applicability of refactoring", e);
			showFatalErrorMessage(parent, "Cannot apply refactoring. See log for details.");
		}
		return false;
	}

	public void execute(IEditorPart editor, ProcessorBasedRefactoring refactoring) throws InterruptedException {
		Assert.isTrue(Display.getCurrent() != null);
		IWorkbenchWindow window = editor.getSite().getWorkbenchWindow();
		IWorkbench workbench = window.getWorkbench();
		Shell shell = editor.getSite().getShell();
		if (!isApplicable(shell, refactoring))
			return;
		final IJobManager manager = Job.getJobManager();
		final ISchedulingRule rule = workspace.getRoot();
		try {
			try {
				Runnable r = new Runnable() {
					public void run() {
						manager.beginRule(rule, null);
					}
				};
				BusyIndicator.showWhile(shell.getDisplay(), r);
			} catch (OperationCanceledException e) {
				// User cancelled operation
				// Do nothing
				return;
			}
			CheckConditionsAndCreateChangeRunnable checkConditionsRunnable = new CheckConditionsAndCreateChangeRunnable(
					shell, refactoring);
			refactoring.setValidationContext(shell);
			window.run(false, true, new WorkbenchRunnableAdapter(checkConditionsRunnable, rule, true));
			PerformChangeOperation performChangeOperation = checkConditionsRunnable.getPerformChangeOperation();
			if (performChangeOperation != null) {
				window.run(false, false, new WorkbenchRunnableAdapter(performChangeOperation, rule, true));
				RefactoringStatus validationStatus = performChangeOperation.getValidationStatus();
				if (validationStatus != null && validationStatus.hasFatalError()) {
					MessageDialog.openError(
							shell,
							refactoring.getName(),
							Messages.format("Cannot execute refactoring",
									validationStatus.getMessageMatchingSeverity(RefactoringStatus.FATAL))); 
					return;
				}
			}
		} catch (InvocationTargetException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			manager.endRule(rule);
			refactoring.setValidationContext(null);
		}
		syncUtil.yieldToQueuedDisplayJobs(new NullProgressMonitor());
		syncUtil.reconcileAllEditors(workbench, false, new NullProgressMonitor());
	}

	private void showFatalErrorMessage(Shell parent, String message) {
		MessageDialog.openInformation(parent, "Rename refactoring", message);
	}

	protected static class CheckConditionsAndCreateChangeRunnable implements IWorkspaceRunnable {

		private final Shell shell;
		private final ProcessorBasedRefactoring refactoring;

		private PerformChangeOperation performChangeOperation;

		public CheckConditionsAndCreateChangeRunnable(Shell shell, ProcessorBasedRefactoring refactoring) {
			this.shell = shell;
			this.refactoring = refactoring;
		}

		public void run(IProgressMonitor pm) throws CoreException {
			try {
				pm.beginTask("", 11);
				pm.subTask("");
				final RefactoringStatus status = refactoring.checkAllConditions(new SubProgressMonitor(pm, 4,
						SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
				if (status.getSeverity() >= RefactoringStatus.WARNING) {
					final boolean[] canceled = { false };
					shell.getDisplay().syncExec(new Runnable() {
						public void run() {
							canceled[0] = showStatusDialog(status);
						}
					});
					if (canceled[0]) {
						throw new OperationCanceledException();
					}
				}
				Change change = refactoring.createChange(new SubProgressMonitor(pm, 2,
						SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
				change.initializeValidationData(new SubProgressMonitor(pm, 1,
						SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
				performChangeOperation = new PerformChangeOperation(change);
				performChangeOperation.setUndoManager(RefactoringCore.getUndoManager(), refactoring.getName());
				performChangeOperation.setSchedulingRule(ResourcesPlugin.getWorkspace().getRoot());
			} finally {
				pm.done();
			}
		}

		protected boolean showStatusDialog(RefactoringStatus status) {
			Dialog dialog = RefactoringUI.createRefactoringStatusDialog(status, shell, refactoring.getName(), false);
			return dialog.open() == IDialogConstants.CANCEL_ID;
		}

		public PerformChangeOperation getPerformChangeOperation() {
			return performChangeOperation;
		}

	}
}
