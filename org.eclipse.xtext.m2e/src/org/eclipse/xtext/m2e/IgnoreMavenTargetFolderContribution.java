/*******************************************************************************
 * Copyright (c) 2019 Sebastian Zarnekow (szarnekow) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.m2e;

import java.util.Collections;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.project.IMavenProjectFacade;
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperContribution;
import org.eclipse.xtext.util.Pair;

/**
 * Filter maven output folders from the builder.
 */
public class IgnoreMavenTargetFolderContribution implements IToBeBuiltComputerContribution, IStorage2UriMapperContribution {

	@Override
	public boolean isRejected(IFolder folder) {
		IMavenProjectFacade mavenProjectFacade = MavenPlugin.getMavenProjectRegistry().getProject(folder.getProject());
		if (mavenProjectFacade == null) {
			return false;
		}
		IPath outputLocation = mavenProjectFacade.getOutputLocation();
		if (outputLocation == null) {
			return false;
		} else if (folder.getFullPath().equals(outputLocation)) {
			return true;
		}
		IPath testOutputLocation = mavenProjectFacade.getTestOutputLocation();
		if (testOutputLocation == null) {
			return false;
		} else if (folder.getFullPath().equals(testOutputLocation)) {
			return true;
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
