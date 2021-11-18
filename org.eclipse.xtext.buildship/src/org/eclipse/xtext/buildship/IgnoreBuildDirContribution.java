/*******************************************************************************
 * Copyright (c) 2019, 2021 Sebastian Zarnekow (szarnekow) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.buildship;

import java.io.File;
import java.util.Collections;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.eclipse.buildship.core.GradleBuild;
import org.eclipse.buildship.core.GradleCore;
import org.eclipse.buildship.core.InitializationContext;
import org.eclipse.buildship.core.ProjectConfigurator;
import org.eclipse.buildship.core.ProjectContext;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperContribution;
import org.eclipse.xtext.util.Pair;
import org.gradle.tooling.model.GradleProject;

/**
 * Filter Gradle output folders from the builder.
 */
public class IgnoreBuildDirContribution
		implements IToBeBuiltComputerContribution, IStorage2UriMapperContribution, ProjectConfigurator {

	private final static QualifiedName BUILDSHIP_BUILD_DIR_KEY = new QualifiedName("org.eclipse.xtext.buildship",
			"builddir");

	private final static Logger LOGGER = Logger.getLogger(IgnoreBuildDirContribution.class);

	public IgnoreBuildDirContribution() {
	}

	@Override
	public void init(InitializationContext context, IProgressMonitor monitor) {
		// nothing to do
	}

	/**
	 * Store the build dir for the given project.
	 */
	@Override
	public void configure(ProjectContext context, IProgressMonitor monitor) {
		/*
		 * Implementation note: This is called for each project in the workspace that
		 * participates in a Gradle build. We keep track of the gradle build dir and the
		 * Eclipse project to allow efficient rejection of the build dir when the Xtext
		 * builder runs.
		 */
		IProject project = context.getProject();
		if (project.isAccessible()) {
			Optional<GradleBuild> gradleBuild = GradleCore.getWorkspace().getBuild(project);
			if (gradleBuild.isPresent()) {
				try {
					GradleProject gradleProject = gradleBuild.get().withConnection(
							connection -> connection.getModel(GradleProject.class), new NullProgressMonitor());
					File buildDirectory = gradleProject.getBuildDirectory();
					File projectDirectory = gradleProject.getProjectDirectory();
					IPath relativePath = Path
							.fromOSString(projectDirectory.toPath().relativize(buildDirectory.toPath()).toString());
					project.setPersistentProperty(BUILDSHIP_BUILD_DIR_KEY, relativePath.toString());
				} catch (Exception e) {
					LOGGER.error(e);
				}
			}
		}
	}

	/**
	 * Remove the cached build dir.
	 */
	@Override
	public void unconfigure(ProjectContext context, IProgressMonitor monitor) {
		IProject project = context.getProject();
		if (project.isAccessible()) {
			try {
				project.setPersistentProperty(BUILDSHIP_BUILD_DIR_KEY, null);
			} catch (CoreException e) {
				LOGGER.error(e);
			}
		}
	}

	@Override
	public boolean isRejected(IFolder folder) {
		IProject project = folder.getProject();
		String persistedPath;
		if (project.isAccessible()) {
			try {
				persistedPath = project.getPersistentProperty(BUILDSHIP_BUILD_DIR_KEY);
				if (persistedPath != null) {
					String path = folder.getProjectRelativePath().toString();
					boolean result = persistedPath.equals(path);
					return result;
				}
			} catch (CoreException e) {
				LOGGER.error(e);
			}
		}
		return false;
	}

	@Override
	public void removeProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) {
		// nothing to do
	}

	@Override
	public void updateProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) throws CoreException {
		// nothing to do
	}

	@Override
	public boolean removeStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		return false;
	}

	@Override
	public boolean updateStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		return false;
	}

	@Override
	public boolean isPossiblyHandled(IStorage storage) {
		return false;
	}

	@Override
	public void initializeCache() {
		// nothing to do
	}

	@Override
	public Iterable<Pair<IStorage, IProject>> getStorages(URI uri) {
		return Collections.emptyList();
	}

	@Override
	public URI getUri(IStorage storage) {
		return null;
	}

}
