/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.IThreadListener;

/**
 * @author schill - Initial contribution and API
 * Due to visibility problems copied from org.eclipse.ltk.internal.ui.refactoring.WorkbenchRunnableAdapter
 */
public class WorkbenchRunnableAdapter implements IRunnableWithProgress, IThreadListener {

	private IWorkspaceRunnable workspaceRunnable;
	private ISchedulingRule rule;
	private boolean fTransfer;

	/**
	 * Runs a workspace runnable with the given lock or <code>null</code>
	 * to run with no lock at all.
	 *
	 * @param runnable the workspace runnable
	 * @param rule the scheduling rule
	 */
	public WorkbenchRunnableAdapter(IWorkspaceRunnable runnable, ISchedulingRule rule) {
		this(runnable, rule, true);
	}

	/**
	 * Runs a workspace runnable with the given lock or <code>null</code>
	 * to run with no lock at all.
	 *
	 * @param runnable the workspace runnable
	 * @param rule the scheduling rule
	 * @param transfer <code>true</code> if the rule is to be transfered
	 *  to the model context thread. Otherwise <code>false</code>
	 *
	 *  @since 3.1
	 */
	public WorkbenchRunnableAdapter(IWorkspaceRunnable runnable, ISchedulingRule rule, boolean transfer) {
		Assert.isNotNull(runnable);
		Assert.isNotNull(rule);
		workspaceRunnable= runnable;
		this.rule= rule;
		fTransfer= transfer;
	}

	public ISchedulingRule getSchedulingRule() {
		return rule;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void threadChange(Thread thread) {
		if (fTransfer)
			Job.getJobManager().transferRule(rule, thread);
	}

	/*
	 * @see IRunnableWithProgress#run(IProgressMonitor)
	 */
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		try {
			ResourcesPlugin.getWorkspace().run(workspaceRunnable, rule, IWorkspace.AVOID_UPDATE, monitor);
		} catch (OperationCanceledException e) {
			throw new InterruptedException(e.getMessage());
		} catch (CoreException e) {
			throw new InvocationTargetException(e);
		}
	}
}
