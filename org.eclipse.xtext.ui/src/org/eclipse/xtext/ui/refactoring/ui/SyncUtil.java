/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * This class does everything I know to put the IDE into a consistent state before refactoring.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SyncUtil {
	private static final Logger LOG = Logger.getLogger(SyncUtil.class);

	@Inject(optional = true)
	private IWorkbench workbench;

	@Inject(optional = true)
	private IWorkspace workspace;
	
	public void totalSync(final boolean saveAll, boolean useProgressDialog) throws InvocationTargetException,
			InterruptedException {
		totalSync(saveAll, useProgressDialog, true);
	}
	
	public void totalSync(final boolean saveAll, boolean useProgressDialog, boolean fork) throws InvocationTargetException,
			InterruptedException {
		if (Display.getCurrent() != null && workbench != null) {
			if (useProgressDialog) {
				workbench.getProgressService().run(fork, true, new IRunnableWithProgress() {
					@Override
					public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
						doReconcileAndBuild(saveAll, monitor);
					}
				});
			} else {
				doReconcileAndBuild(saveAll, null);
			}
		}
	}
	
	private void doReconcileAndBuild(final boolean saveAll, IProgressMonitor monitor)
			throws InterruptedException {
		try {
			SubMonitor progress = SubMonitor.convert(monitor, 6);
			reconcileAllEditors(workbench, saveAll, progress.newChild(1));
			if (progress.isCanceled()) {
				throw new InterruptedException();
			}
			waitForBuild(progress.newChild(4));
			if (progress.isCanceled()) {
				throw new InterruptedException();
			}
			yieldToQueuedDisplayJobs(progress.newChild(1));
		} catch(OperationCanceledException e) {
			throw new InterruptedException(); 
		}
	}

	public void totalSync(final boolean saveAll) throws InvocationTargetException, InterruptedException {
		totalSync(saveAll, true);
	}

	public void reconcileAllEditors(IWorkbench workbench, final boolean saveAll, final IProgressMonitor monitor) {
		for (IWorkbenchWindow window : workbench.getWorkbenchWindows()) {
			for (IWorkbenchPage page : window.getPages()) {
				for (IEditorReference editorReference : page.getEditorReferences()) {
					if (monitor.isCanceled())
						return;
					final IEditorPart editor = editorReference.getEditor(false);
					if (editor != null) {
						if (editor instanceof XtextEditor) {
							waitForReconciler((XtextEditor) editor);
						}
						if (editor.isDirty() && saveAll) {
							Display display = workbench.getDisplay();
							display.syncExec(new Runnable() {
								@Override
								public void run() {
									editor.doSave(monitor);
								}
							});
						}
					}
				}
			}
		}
	}

	/**
	 * this methods blocks until the following jobs have finished,
	 * - the reconciler
	 * - the editor validation job
	 * - the dirty state editor updater job
	 */
	public void waitForReconciler(XtextEditor editor) {
		try {
			editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					// this doesn't execute before the reconciler has finished
				}
			});
			// reconciling schedules both, validation and dirty state
			Job validationJob = ((XtextDocument)editor.getDocument()).getValidationJob();
			validationJob.join();
			editor.getDirtyStateEditorSupport().waitForUpdateEditorJob();
		} catch (OperationCanceledException e) {
		} catch (OperationCanceledError e) {
		} catch (InterruptedException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	public void waitForBuild(IProgressMonitor monitor) {
		try {
			workspace.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, monitor);
		} catch (CoreException e) {
			throw new OperationCanceledException(e.getMessage());
		}
	}
	
	/**
	 * @deprecated we should not rely on auto build to be triggered. Use {@link #waitForBuild(IProgressMonitor)}
	 *             instead.
	 */
	@Deprecated
	public void waitForAutoBuild(IProgressMonitor monitor) {
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD, monitor);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				throw e;
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	public void yieldToQueuedDisplayJobs(IProgressMonitor monitor) {
		yieldToQueuedDisplayJobs(monitor, 5000);
	}

	public void yieldToQueuedDisplayJobs(IProgressMonitor monitor, int maxJobsToYieldTo) {
		int count = 0;
		if (Display.getCurrent() != null) {
			while (count < maxJobsToYieldTo && Display.getCurrent().readAndDispatch()) {
				if (monitor.isCanceled())
					throw new OperationCanceledException();
				++count;
			}
			if (count == maxJobsToYieldTo) {
				LOG.error("maxJobsToYieldTo probably exceeded. Worked: " + count);
			}
		}
	}

}
