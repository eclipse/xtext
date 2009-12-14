/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.containers;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ProjectBasedContainer extends ResourceDescriptionsBasedContainer {

	private final IProject project;
	
	public ProjectBasedContainer(IResourceDescriptions descriptions, IProject project) {
		super(descriptions);
		this.project = project;
	}
	
	public IProject getProject() {
		return project;
	}

	@Override
	protected boolean contains(IResourceDescription input) {
		URI uri = input.getURI();
		String platformString = uri.toPlatformString(true);
		IPath projectPath = project.getFullPath();
		IPath descriptionPath = new Path(platformString);
		boolean result = projectPath.isPrefixOf(descriptionPath);
		if (result) {
			IPath relativePath = descriptionPath.makeRelativeTo(projectPath);
			result = project.exists(relativePath);
		}
		return result;
	}

}
