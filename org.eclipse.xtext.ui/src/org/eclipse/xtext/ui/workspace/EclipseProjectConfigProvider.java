/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.workspace;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class EclipseProjectConfigProvider implements IProjectConfigProvider {

	@Inject
	private IJdtHelper jdtHelper;

	@Override
	public IProjectConfig getProjectConfig(ResourceSet context) {
		ProjectConfigAdapter projectConfigAdapter = ProjectConfigAdapter.findInEmfObject(context);
		return projectConfigAdapter != null ? projectConfigAdapter.getProjectConfig() : null;
	}

	public void installProjectConfig(IProject eclipseProject, ResourceSet resourceSet) {
		EclipseProjectConfig config = createProjectConfig(eclipseProject);
		ProjectConfigAdapter.install(resourceSet, config);
	}

	public EclipseProjectConfig createProjectConfig(IProject eclipseProject) {
		if (jdtHelper.isJavaCoreAvailable()) {
			return new JdtProjectConfig(eclipseProject, this);
		} else {
			return new EclipseProjectConfig(eclipseProject, this);
		}
	}
}