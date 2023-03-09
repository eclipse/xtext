/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.workspace;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.workspace.IWorkspaceConfig;

public class EclipseWorkspaceConfig implements IWorkspaceConfig {

	private final IWorkspaceRoot workspaceRoot;

	private final EclipseProjectConfigProvider projectConfigProvider;

	public EclipseWorkspaceConfig(IWorkspaceRoot workspaceRoot, EclipseProjectConfigProvider projectConfigProvider) {
		this.workspaceRoot = workspaceRoot;
		this.projectConfigProvider = projectConfigProvider;
	}

	@Override
	public Set<? extends EclipseProjectConfig> getProjects() {
		return Arrays.asList(workspaceRoot.getProjects()) //
				.stream() //
				.filter(project -> project.isAccessible()) //
				.map(project -> projectConfigProvider.createProjectConfig(project.getProject())) //
				.collect(Collectors.toSet());
	}

	@Override
	public EclipseProjectConfig findProjectByName(String name) {
		try {
			IProject project = workspaceRoot.getProject(name);
			if (project.isAccessible()) {
				return projectConfigProvider.createProjectConfig(project);
			}
			return null;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public EclipseProjectConfig findProjectContaining(URI member) {
		if (member.isPlatformResource()) {
			return findProjectByName(URI.decode(member.segment(1)));
		}
		return null;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((workspaceRoot == null) ? 0 : workspaceRoot.hashCode());
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
		EclipseWorkspaceConfig other = (EclipseWorkspaceConfig) obj;
		if (workspaceRoot == null) {
			if (other.workspaceRoot != null)
				return false;
		} else if (!workspaceRoot.equals(other.workspaceRoot))
			return false;
		if (projectConfigProvider == null) {
			if (other.projectConfigProvider != null)
				return false;
		} else if (!projectConfigProvider.equals(other.projectConfigProvider))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "workspaceRoot " + workspaceRoot + " projectConfigProvider " + projectConfigProvider;
	}

	public IWorkspaceRoot getWorkspaceRoot() {
		return workspaceRoot;
	}

	public EclipseProjectConfigProvider getProjectConfigProvider() {
		return projectConfigProvider;
	}
}