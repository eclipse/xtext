/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.internal.events.BuildManager;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IBuildConfiguration;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.xtext.builder.internal.Activator;

import com.google.common.annotations.Beta;

/**
 * Utility that allows to access the build managers internals.
 */
@SuppressWarnings("restriction")
@Beta
public class BuildManagerAccess {

	private static final Method requestRebuild;
	private static final Field autoBuildJob;
	private static final Method forceBuild;
	private static final Method getBuilder;

	static {
		try {
			requestRebuild = BuildManager.class.getDeclaredMethod("requestRebuild");
			requestRebuild.setAccessible(true);
			autoBuildJob = BuildManager.class.getDeclaredField("autoBuildJob");
			autoBuildJob.setAccessible(true);
			Class<?> autoBuildJobClass = autoBuildJob.getType();
			forceBuild = autoBuildJobClass.getDeclaredMethod("forceBuild");
			forceBuild.setAccessible(true);
			getBuilder = BuildManager.class.getDeclaredMethod("getBuilder", IBuildConfiguration.class, ICommand.class, int.class,
					MultiStatus.class);
			getBuilder.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException | NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Obtain the configured Xtext builder for the given project, if any.
	 */
	public static XtextBuilder findBuilder(IProject project) {
		try {
			if (project.isAccessible()) {
				Project casted = (Project) project;
				IBuildConfiguration activeBuildConfig = casted.getActiveBuildConfig();
				for (ICommand command : casted.internalGetDescription().getBuildSpec(false)) {
					if (XtextBuilder.BUILDER_ID.equals(command.getBuilderName())) {
						IWorkspace workspace = ResourcesPlugin.getWorkspace();
						if (workspace instanceof Workspace) {
							BuildManager buildManager = ((Workspace) workspace).getBuildManager();
							XtextBuilder result = (XtextBuilder) getBuilder.invoke(buildManager, activeBuildConfig, command, -1,
									new MultiStatus(Activator.PLUGIN_ID, 0, null, null));
							return result;
						}
					}
				}
			}
			return null;
		} catch (IllegalAccessException | InvocationTargetException | CoreException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Enforce a build.
	 */
	public static void requestBuild() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		if (workspace instanceof Workspace) {
			BuildManager buildManager = ((Workspace) workspace).getBuildManager();
			try {
				requestRebuild.invoke(buildManager);
				Object job = autoBuildJob.get(buildManager);
				forceBuild.invoke(job);
			} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new RuntimeException("Unexpected workspace implementation");
		}
	}
	
	/**
	 * Schedule an auto build to be run.
	 * 
	 * @since 2.26
	 */
	public static void scheduleAutoBuild() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		if (workspace instanceof Workspace) {
			BuildManager buildManager = ((Workspace) workspace).getBuildManager();
			buildManager.endTopLevel(true);
		} else {
			throw new RuntimeException("Unexpected workspace implementation");
		}
	}

}