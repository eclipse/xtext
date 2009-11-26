/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ProjectBasedContainer extends AbstractMapBasedContainer {

	private IProject project;
	
	public void setProject(IProject project) {
		this.project = project;
	}
	
	public IProject getProject() {
		return project;
	}

	@Override
	public boolean apply(IResourceDescription input) {
		IPath path = new Path(input.getURI().toPlatformString(true));
		return project.exists(path);
	}

}
