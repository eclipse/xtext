/*******************************************************************************
 * Copyright (c) 2019 Sebastian Zarnekow (szarnekow) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.buildship;

import java.io.File;
import java.util.Collections;
import java.util.Optional;

import org.eclipse.buildship.core.GradleBuild;
import org.eclipse.buildship.core.GradleCore;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperContribution;
import org.eclipse.xtext.util.Pair;
import org.gradle.tooling.model.GradleProject;

/**
 * Filter Gradle output folders from the builder.
 */
public class IgnoreBuildDirContribution implements IToBeBuiltComputerContribution, IStorage2UriMapperContribution {

	@Override
	public boolean isRejected(IFolder folder) {
		IProject project = folder.getProject();
		Optional<GradleBuild> gradleBuild = GradleCore.getWorkspace().getBuild(project);
		if (gradleBuild.isPresent()) {
			try {
				GradleProject gradleProject = gradleBuild.get().withConnection(connection->connection.getModel(GradleProject.class), new NullProgressMonitor());
				File buildDirectory = gradleProject.getBuildDirectory();
				File folderAsFile = folder.getFullPath().toFile();
				if (folderAsFile.equals(buildDirectory)) {
					return true;
				}
			} catch (Exception e) {
				return false;
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
