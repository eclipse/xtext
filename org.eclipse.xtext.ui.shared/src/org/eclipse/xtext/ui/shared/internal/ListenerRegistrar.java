/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import java.util.Arrays;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.impl.BuildScheduler;
import org.eclipse.xtext.builder.impl.IBuildFlag;
import org.eclipse.xtext.builder.impl.ProjectOpenedOrClosedListener;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
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
		if (builderState.isEmpty()) {
			buildManager.scheduleBuildIfNecessary(Arrays.asList(workspace.getRoot().getProjects()), IBuildFlag.RECOVERY_BUILD);
		}
	}

	@Override
	public void discard() {
		workspace.removeResourceChangeListener(listener);
	}
	
}
