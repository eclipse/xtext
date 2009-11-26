/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.core.builder.internal.XtextNature;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContainerManager implements IContainer.Manager {

	private static final Logger log = Logger.getLogger(ContainerManager.class);
	
	public IContainer getContainer(IResourceDescription desc) {
		IProject project = getProject(desc.getURI());
		return createContainer(project);
	}

	protected NameBasedContainer createContainer(IProject project) {
		return new NameBasedContainer(project);
	}

	private IProject getProject(URI uri) {
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(uri.toPlatformString(true)));
		if (file == null) {
			throw new IllegalStateException("Could not find file for " + uri);
		}
		final IProject project = file.getProject();
		return project;
	}

	public List<IContainer> getVisibleContainers(IResourceDescription desc) {
		IProject project = getProject(desc.getURI());
		List<IContainer> result = Lists.newArrayList();
		result.add(createContainer(project));
		try {
			for (IProject p : project.getReferencedProjects()) {
				if (isAccessableXtextProject(p))
					result.add(createContainer(p));
			}
		}
		catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}

	protected boolean isAccessableXtextProject(IProject p) {
		return p.isAccessible() && hasXtextNature(p);
	}

	protected boolean hasXtextNature(IProject p) {
		try {
			return p.getNature(XtextNature.NATURE_ID)!=null;
		}
		catch (CoreException e) {
			log.error(e.getMessage(),e);
			return false;
		}
	}

}
