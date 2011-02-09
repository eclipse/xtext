/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.ltk.core.refactoring.RefactoringCore;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringUI;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * 
 * @author Holger Schill - Initial contribution and API
 */
public class RenameRefactoringExecuter {
	private RenameRefactoring refactoring;
	private RefactoringStatus preCheckStatus;
	private Logger log = Logger.getLogger(RenameRefactoringExecuter.class);

	public IStatus preCheck() throws CoreException {
		ensureChecked();
		if (preCheckStatus.hasFatalError())
			return preCheckStatus.getEntryMatchingSeverity(RefactoringStatus.FATAL).toStatus();
		else
			return Status.OK_STATUS;
	}

	private void ensureChecked() throws CoreException {
		if (preCheckStatus == null) {
			if (!refactoring.isApplicable()) {
				preCheckStatus = RefactoringStatus.createFatalErrorStatus("Refactoring ist not applicable"); //$NON-NLS-1$
			} else {
				preCheckStatus = new RefactoringStatus();
			}
		}
	}

	public void configure(RenameRefactoring renameRefactoring) throws CoreException {
		refactoring = renameRefactoring;
		RefactoringStatus refactoringStatus = new RefactoringStatus();
		if (refactoringStatus.hasFatalError()) {
			preCheckStatus = refactoringStatus;
		} else {
			preCheck();
			refactoringStatus.merge(preCheckStatus);
			preCheckStatus = refactoringStatus;
		}
	}

	public void perform(IWorkbenchPartSite iWorkbenchPartSite) throws InterruptedException {
		IRunnableContext context = iWorkbenchPartSite.getWorkbenchWindow();
		Shell parent = iWorkbenchPartSite.getShell();
		try {
			ensureChecked();
		} catch (CoreException e) {
			// Not executable
			return;
		}
		if (preCheckStatus.hasFatalError()) {
			showInformation(parent, preCheckStatus);
			return;
		}
		Assert.isTrue(Display.getCurrent() != null);
		final IJobManager manager = Job.getJobManager();
		final ISchedulingRule rule = ResourcesPlugin.getWorkspace().getRoot();
		try {
			try {
				Runnable r = new Runnable() {
					public void run() {
						manager.beginRule(rule, null);
					}
				};
				BusyIndicator.showWhile(parent.getDisplay(), r);
			} catch (OperationCanceledException e) {
				// User cancelled operation
				// Do nothing
				return;
			}

			final WrappingPerformChangeOperation op = new WrappingPerformChangeOperation(parent);
			refactoring.setValidationContext(parent);
			context.run(false, true, new WorkbenchRunnableAdapter(op, rule, true));
			if (op.performChangeOperation != null)
				context.run(false, false, new WorkbenchRunnableAdapter(op.performChangeOperation, rule, true));

			if (op.performChangeOperation != null) {
				RefactoringStatus validationStatus = op.performChangeOperation.getValidationStatus();
				if (validationStatus != null && validationStatus.hasFatalError()) {
					MessageDialog.openError(
							parent,
							refactoring.getName(),
							Messages.format("Cannot execute refactoring",
									validationStatus.getMessageMatchingSeverity(RefactoringStatus.FATAL))); //$NON-NLS-1$
					return;
				}
			}
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
		} finally {
			manager.endRule(rule);
			refactoring.setValidationContext(null);
		}

	}

	private void showInformation(Shell parent, RefactoringStatus status) {
		String message = status.getMessageMatchingSeverity(RefactoringStatus.FATAL);
		MessageDialog.openInformation(parent, "Rename refactoring", message); //$NON-NLS-1$
	}

	private class WrappingPerformChangeOperation implements IWorkspaceRunnable {
		public Change change;
		public PerformChangeOperation performChangeOperation;
		private Shell parent;

		public WrappingPerformChangeOperation(Shell parent) {
			this.parent = parent;
		}

		public void run(IProgressMonitor pm) throws CoreException {
			try {
				pm.beginTask("", 11); //$NON-NLS-1$
				pm.subTask(""); //$NON-NLS-1$

				final RefactoringStatus status = refactoring.checkAllConditions(new SubProgressMonitor(pm, 4,
						SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
				if (status.getSeverity() >= RefactoringStatus.WARNING) {
					final boolean[] canceled = { false };

					parent.getDisplay().syncExec(new Runnable() {
						public void run() {
							canceled[0] = showStatusDialog(status);
						}
					});
					if (canceled[0]) {
						throw new OperationCanceledException();
					}
				}

				change = refactoring.createChange(new SubProgressMonitor(pm, 2,
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

		private boolean showStatusDialog(RefactoringStatus status) {
			Dialog dialog = RefactoringUI.createRefactoringStatusDialog(status, parent, refactoring.getName(), false);
			return dialog.open() == IDialogConstants.CANCEL_ID;
		}
	}

}
