/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;

/**
 * Utility to extract the project context for the given resource. By default
 * it will succeed for resource with platform:/resource URIs.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public class ProjectByResourceProvider {

	@Inject 
	private IWorkspace workspace;
	
	/**
	 * Return the project context for the given resource.
	 */
	public IProject getProjectContext(Resource resource) {
		if (resource.getURI().isPlatformResource()) {
			String projectName = URI.decode(resource.getURI().segment(1));
			IProject project = workspace.getRoot().getProject(projectName);
			if (project.exists() && project.isAccessible()) {
				return project;
			} 
		}
		return null;
	}
	
	protected IWorkspace getWorkspace() {
		return workspace;
	}

}
