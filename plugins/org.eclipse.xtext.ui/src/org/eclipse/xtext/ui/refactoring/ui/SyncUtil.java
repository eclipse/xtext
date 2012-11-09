/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.ResourcesPlugin;
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
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SyncUtil {

	@Inject(optional = true)
	private IWorkbench workbench;

	public void totalSync(final boolean saveAll) throws InvocationTargetException, InterruptedException {
		if (Display.getCurrent() != null && workbench != null) {
			workbench.getProgressService().run(false, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					SubMonitor progress = SubMonitor.convert(monitor, 6);
					syncAllEditors(workbench, saveAll, progress.newChild(1));
					waitForAutoBuild(progress.newChild(4));
					yieldToQueuedDisplayJobs(progress.newChild(1));
				}
			});
		}
	}

	public void syncAllEditors(IWorkbench workbench, final boolean saveAll, IProgressMonitor monitor) {
		SubMonitor pm0 = SubMonitor.convert(monitor, workbench.getWorkbenchWindowCount());
		for (IWorkbenchWindow window : workbench.getWorkbenchWindows()) {
			SubMonitor pm1 = pm0.newChild(1).setWorkRemaining(window.getPages().length);
			for (IWorkbenchPage page : window.getPages()) {
				SubMonitor pm2 = pm1.newChild(1).setWorkRemaining(page.getEditorReferences().length);
				for (IEditorReference editorReference : page.getEditorReferences()) {
					IEditorPart editor = editorReference.getEditor(true);
					if (editor == null)
						throw new IllegalStateException("Could not restore editor " + editorReference.getName());
					if (editor instanceof XtextEditor)
						waitForReconciler((XtextEditor) editor);
					if (saveAll)
						editor.doSave(monitor);
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
		yieldToQueuedDisplayJobs(monitor, 100);
	}

	public void yieldToQueuedDisplayJobs(IProgressMonitor monitor, int maxJobsToYieldTo) {
		SubMonitor pm = SubMonitor.convert(monitor, maxJobsToYieldTo);
		int count = 0;
		if (Display.getCurrent() != null)
			while (count < maxJobsToYieldTo && Display.getCurrent().readAndDispatch()) {
				++count;
				pm.worked(1);
			}
	}

}
