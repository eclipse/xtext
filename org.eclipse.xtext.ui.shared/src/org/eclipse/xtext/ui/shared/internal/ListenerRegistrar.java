/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import java.util.Arrays;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.impl.BuildScheduler;
import org.eclipse.xtext.builder.impl.IBuildFlag;
import org.eclipse.xtext.builder.impl.ProjectOpenedOrClosedListener;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class ListenerRegistrar implements IEagerContribution {
	
	@Inject
	private ProjectOpenedOrClosedListener listener;
	@Inject
	private IWorkspace workspace;
	@Inject
	private BuildScheduler buildManager;
	@Inject
	private IBuilderState builderState;
	
	@Override
	public void initialize() {
		workspace.addResourceChangeListener(listener);
		
		// If there are no open projects in a workspace after a restart, a newly opened Xtext project will
		// trigger the infrastructure's initialization procedure. Since the listeners are than registered
		// after the fact, the project-open event is already done. Thus no build is triggered for the newly
		// opened project and the index state is corrupt.
		// thus we trigger a recovery build here
		class RecoveryBuildTrigger extends WorkspaceJob {

			public RecoveryBuildTrigger() {
				super("Schedule Xtext recovery build on start-up");
			}

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				if (builderState.isEmpty()) {
					buildManager.scheduleBuildIfNecessary(Arrays.asList(workspace.getRoot().getProjects()), IBuildFlag.RECOVERY_BUILD);
				}
				return Status.OK_STATUS;
			}
		}
		RecoveryBuildTrigger recoveryBuildTrigger = new RecoveryBuildTrigger();
		recoveryBuildTrigger.schedule();
	}

	@Override
	public void discard() {
		workspace.removeResourceChangeListener(listener);
	}
	
}
