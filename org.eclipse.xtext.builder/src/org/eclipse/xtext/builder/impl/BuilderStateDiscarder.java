/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

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

	private static final Logger logger = Logger.getLogger(BuilderStateDiscarder.class);

	/**
	 * Returns true, if the given builderArguments indicate that we should discard the built state
	 * for the given projects.
	 */
	public boolean forgetLastBuildState(Iterable<IProject> toUpdate, Map<String, String> builderArguments) {
		if (canHandleBuildFlag(builderArguments)) {
			for (IProject project : toUpdate) {
				XtextBuilder builder = BuildManagerAccess.findBuilder(project);
				if (builder != null) {
					builder.forgetLastBuiltState();
					touchProject(project);
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Touch a given project such that the auto-build knows it should be rebuild.
	 *
	 * @since 2.26
	 */
	protected void touchProject(IProject project) {
		if (!project.getWorkspace().isTreeLocked()) {
			try {
				project.touch(null);
			} catch (CoreException e) {
				logger.error("Failed to refresh project while forgetting its builder state", e);
			}
		} else {
			Job touchJob = Job.create("Touch project " + project.getName(), progressMonitor -> {
				try {
					project.touch(progressMonitor);
					return Status.OK_STATUS;
				} catch (CoreException e) {
					logger.error("Failed to refresh project while forgetting its builder state", e);
					return Status.CANCEL_STATUS;
				}
			});
			touchJob.setRule(project);
			touchJob.setUser(false);
			touchJob.setSystem(true);
			touchJob.schedule(0);
		}
	}

	protected boolean canHandleBuildFlag(Map<String, String> builderArguments) {
		return IBuildFlag.FORGET_BUILD_STATE_ONLY.isSet(builderArguments)
				|| IBuildFlag.RECOVERY_BUILD.isSet(builderArguments);
	}

}
