/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.workspace;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;

public class EclipseProjectConfig implements IProjectConfig {

	private final IProject project;

	private final EclipseProjectConfigProvider projectConfigProvider;

	public EclipseProjectConfig(IProject project, EclipseProjectConfigProvider projectConfigProvider) {
		this.project = project;
		this.projectConfigProvider = projectConfigProvider;
	}

	@Override
	public String getName() {
		return project.getName();
	}

	@Override
	public URI getPath() {
		return URI.createPlatformResourceURI("/" + getName() + "/", true);
	}

	@Override
	public Set<? extends ISourceFolder> getSourceFolders() {
		return Collections.emptySet();
	}

	@Override
	public ISourceFolder findSourceFolderContaining(URI member) {
		Optional<? extends ISourceFolder> srcFolder = getSourceFolders().stream().filter(folder -> folder.contains(member)).findFirst();
		return srcFolder.isPresent() ? srcFolder.get() : null;

	}

	@Override
	public IWorkspaceConfig getWorkspaceConfig() {
		return new EclipseWorkspaceConfig(project.getWorkspace().getRoot(), projectConfigProvider);
	}

	@Override
	public String toString() {
		return project.toString();
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return prime * result + ((projectConfigProvider == null) ? 0 : projectConfigProvider.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EclipseProjectConfig other = (EclipseProjectConfig) obj;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (projectConfigProvider == null) {
			if (other.projectConfigProvider != null)
				return false;
		} else if (!projectConfigProvider.equals(other.projectConfigProvider))
			return false;
		return true;
	}

	public IProject getProject() {
		return project;
	}

	public EclipseProjectConfigProvider getProjectConfigProvider() {
		return projectConfigProvider;
	}

}
