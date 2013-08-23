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
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.xtext.ui.editor.XtextEditor;
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
		if (Display.getCurrent() != null && workbench != null) {
			if (useProgressDialog) {
				workbench.getProgressService().run(false, true, new IRunnableWithProgress() {
					public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
						SubMonitor progress = SubMonitor.convert(monitor, 6);
						reconcileAllEditors(workbench, saveAll, progress.newChild(1));
						waitForBuild(progress.newChild(4));
						yieldToQueuedDisplayJobs(progress.newChild(1));
					}
				});
			} else {
				SubMonitor progress = SubMonitor.convert(new NullProgressMonitor());
				reconcileAllEditors(workbench, saveAll, progress.newChild(1));
				waitForBuild(progress.newChild(4));
				yieldToQueuedDisplayJobs(progress.newChild(1));
			}
		}
	}

	public void totalSync(final boolean saveAll) throws InvocationTargetException, InterruptedException {
		totalSync(saveAll, true);
	}

	/**
	 * @deprecated use {@link #reconcileAllEditors(IWorkbench, boolean, IProgressMonitor)} instead
	 */
	@Deprecated
	public void syncAllEditors(IWorkbench workbench, final boolean saveAll, IProgressMonitor monitor) {
		reconcileAllEditors(workbench, saveAll, monitor);
	}

	public void reconcileAllEditors(IWorkbench workbench, final boolean saveAll, IProgressMonitor monitor) {
		SubMonitor pm0 = SubMonitor.convert(monitor, workbench.getWorkbenchWindowCount());
		for (IWorkbenchWindow window : workbench.getWorkbenchWindows()) {
			SubMonitor pm1 = pm0.newChild(1).setWorkRemaining(window.getPages().length);
			for (IWorkbenchPage page : window.getPages()) {
				SubMonitor pm2 = pm1.newChild(1).setWorkRemaining(2 * page.getEditorReferences().length);
				for (IEditorReference editorReference : page.getEditorReferences()) {
					if (pm2.isCanceled())
						return;
					IEditorPart editor = editorReference.getEditor(false);
					if (editor != null) {
						if (editor instanceof XtextEditor)
							waitForReconciler((XtextEditor) editor);
						if (editor.isDirty() && saveAll)
							editor.doSave(pm2.newChild(1));
					}
					pm2.worked(1);
				}
			}
		}
	}

	public void waitForReconciler(XtextEditor editor) {
		editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				// this doesn't execute before the reconciler has finished
			}
		});
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
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	public void yieldToQueuedDisplayJobs(IProgressMonitor monitor) {
		yieldToQueuedDisplayJobs(monitor, 5000);
	}

	public void yieldToQueuedDisplayJobs(IProgressMonitor monitor, int maxJobsToYieldTo) {
		SubMonitor pm = SubMonitor.convert(monitor, maxJobsToYieldTo);
		int count = 0;
		if (Display.getCurrent() != null) {
			while (count < maxJobsToYieldTo && Display.getCurrent().readAndDispatch()) {
				if (pm.isCanceled())
					throw new OperationCanceledException();
				++count;
				pm.worked(1);
			}
			if (count == maxJobsToYieldTo) {
				LOG.error("maxJobsToYieldTo probably exceeded. Worked: " + count);
			}
		}
	}

}
