/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.scoping.namespaces.IContainerDependencyProvider;
import org.eclipse.xtext.ui.core.builder.internal.XtextNature;

import com.google.common.collect.Iterables;

public class ContainerDependencyProviderIProjectImpl implements
		IContainerDependencyProvider {

	public static Logger log = Logger.getLogger(ContainerDependencyProviderIProjectImpl.class);

	public List<String> getReferencedContainers(EObject context) {
		IProject project = getProject(context);
		if (project == null || !project.exists()) {
			return Collections.emptyList();
		}
		List<String> projectNames = new ArrayList<String>();
		try {
			for (IProject p : Iterables.reverse(Arrays.asList(project.getReferencedProjects()))) {
				if (isAccessableXtextProject(p))
					projectNames.add(p.getName());
			}
		}
		catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
		return projectNames;
	}

	private boolean isAccessableXtextProject(IProject p) {
		return p.isAccessible() && hasXtextNature(p);
	}

	private boolean hasXtextNature(IProject p) {
		try {
			return p.getNature(XtextNature.NATURE_ID)!=null;
		}
		catch (CoreException e) {
			log.error(e.getMessage(),e);
			return false;
		}
	}

	public String getContainer(EObject context) {
		final IProject project = getProject(context);
		return project.getName();
	}

	private IProject getProject(EObject context) {
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(context.eResource().getURI().toPlatformString(true)));
		if (file == null) {
			log.error("Couldn't find IFile for " + context.eResource().getURI());
			return null;
		}
		final IProject project = file.getProject();
		return project;
	}

}