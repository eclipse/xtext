/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.containers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.XtextProjectHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class WorkspaceProjectsStateHelper extends AbstractStorage2UriMapperClient {

	private final static Logger log = Logger.getLogger(WorkspaceProjectsStateHelper.class);
	
	@Inject
	private IWorkspace workspace;
	
	public String initHandle(URI uri) {
		if (!uri.isPlatform())
			return null;
		final IFile file = getWorkspaceRoot().getFile(new Path(uri.toPlatformString(true)));
		if (file == null) {
			return null;
		}
		final IProject project = file.getProject();
		return project.getName();
	}
	
	public Collection<URI> initContainedURIs(String containerHandle) {
		try {
			IPath projectPath = new Path(null, containerHandle).makeAbsolute();
			if (projectPath.segmentCount()!=1) 
				return Collections.emptySet();
			IProject project = getWorkspaceRoot().getProject(containerHandle);
			if (project != null && isAccessibleXtextProject(project)) {
				Map<URI, IStorage> entries = getMapper().getAllEntries(project);
				return entries.keySet();
			}
		} catch (IllegalArgumentException e) {
			if (log.isDebugEnabled())
				log.debug("Cannot init contained URIs for containerHandle '" + containerHandle + "'", e);
		}
		return Collections.emptyList();
	}

	public List<String> initVisibleHandles(String handle) {
		try {
			IProject project = getWorkspaceRoot().getProject(handle);
			if (isAccessibleXtextProject(project)) {
				try {
					IProject[] referencedProjects = project.getReferencedProjects();
					List<String> result = Lists.newArrayListWithExpectedSize(referencedProjects.length);
					result.add(handle);
					for(IProject referencedProject: referencedProjects) {
						if (isAccessibleXtextProject(referencedProject)) {
							result.add(referencedProject.getName());
						}
					}
					return result;
				} catch(CoreException e) {
					log.error(e.getMessage(), e);
				}
			}
		} catch (IllegalArgumentException e) {
			if (log.isDebugEnabled())
				log.debug("Cannot init visible handles for containerHandle '" + handle + "'", e);
		}
		return Collections.emptyList();
	}
	
	protected boolean isAccessibleXtextProject(IProject p) {
		return p != null && XtextProjectHelper.hasNature(p) && XtextProjectHelper.hasNature(p);
	}
	
	protected IWorkspaceRoot getWorkspaceRoot() {
		return workspace.getRoot();
	}

	public void setWorkspace(IWorkspace workspace) {
		this.workspace = workspace;
	}
}
