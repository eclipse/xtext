/*******************************************************************************
 * Copyright (c) 2019, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;

import com.google.common.annotations.Beta;

/**
 * Utility to discard builder state for a given set of projects.
 * 
 * It'll access the {@link XtextBuilder} assigned to the given projects and invoke
 * {@link IncrementalProjectBuilder#forgetLastBuiltState()}.
 * 
 * Clients are usually not expected to call this manually.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.17
 */
@Beta
public class BuilderStateDiscarder {

	/**
	 * Returns true, if the given builderArguments indicate that we should discard the built state
	 * for the given projects.
	 */
	public boolean forgetLastBuildState(Iterable<IProject> toUpdate, Map<String, String> builderArguments) {
		/*
		 * Implementation note:
		 * This is an unsafe operation. There no guarantee that any lock is being acquired by the current thread
		 * while performing this operation. It is very well possible that this is running concurrently with a build.
		 * 
		 * When we come here, we might, or might not
		 * - hold the AbstractBuilderState.loadLock
		 * - hold the org.eclipse.core.internal.resources.WorkManager.lock
		 * - come from a build and see a situation with org.eclipse.core.internal.resources.Workspace.treeLocked being the case
		 * - might or might not have a rule stack available on org.eclipse.core.internal.jobs.ThreadJob.ruleStack
		 * 
		 * It is desired that we only discard the build information of the XtextBuilder and not of all the builders
		 * of a project. Therefore, we try to keep the interaction with the resource model to a minimum.
		 * 
		 * The strategy is coupled to the internals of the XtextBuilder where state is maintained
		 * that allows to schedule an initial full build for a project.
		 */
		if (canHandleBuildFlag(builderArguments)) {
			for (IProject project : toUpdate) {
				if (project.isAccessible()) {
					XtextBuilder builder = BuildManagerAccess.findBuilder(project);
					if (builder != null) {
						builder.requestFullBuild(IBuildFlag.FORGET_BUILD_STATE_ONLY.isSet(builderArguments));
					}
				}
			}
			return true;
		}
		return false;
	}
	
	protected boolean canHandleBuildFlag(Map<String, String> builderArguments) {
		return IBuildFlag.FORGET_BUILD_STATE_ONLY.isSet(builderArguments)
				|| IBuildFlag.RECOVERY_BUILD.isSet(builderArguments);
	}

}
