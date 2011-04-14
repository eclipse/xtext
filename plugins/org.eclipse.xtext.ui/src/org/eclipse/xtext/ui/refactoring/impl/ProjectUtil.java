/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ProjectUtil {

	@Inject
	private IWorkspace workspace;
	
	public IProject getProject(URI targetElementURI) {
		if (!targetElementURI.isPlatformResource())
			throw new IllegalArgumentException("Refactored element URI must be a platform resource URI: "
					+ Strings.notNull(targetElementURI));
		String projectName = targetElementURI.segment(1);
		IProject project = workspace.getRoot().getProject(projectName);
		if (project == null)
			throw new IllegalArgumentException("Cannot find containing project for "
					+ Strings.notNull(targetElementURI));
		return project;
	}

}
