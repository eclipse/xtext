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

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class WorkspaceProjectsState extends AbstractAllContainersState {

	private final static Logger log = Logger.getLogger(WorkspaceProjectsState.class);
	
	@Override
	protected String doInitHandle(URI uri) {
		final IFile file = getWorkspaceRoot().getFile(new Path(uri.toPlatformString(true)));
		if (file == null) {
			return null;
		}
		final IProject project = file.getProject();
		return project.getName();
	}
	
	@Override
	protected Collection<URI> doInitContainedURIs(String containerHandle) {
		IProject project = getWorkspaceRoot().getProject(containerHandle);
		if (project != null && project.exists()) {
			final List<URI> uris = Lists.newArrayList();
			try {
				project.accept(new IResourceVisitor() {
					public boolean visit(IResource resource) throws CoreException {
						if (resource instanceof IStorage) {
							URI uri = getUri((IStorage) resource);
							if (uri != null) {
								uris.add(uri);	
							}
							return false;
						}
						return true;
					}
				});
				return uris;
			} catch (CoreException e) {
				log.error(e.getMessage(), e);
			}
		}
		return Collections.emptyList();
	}

	@Override
	protected List<String> doInitVisibleHandles(String handle) {
		IProject project = getWorkspaceRoot().getProject(handle);
		if (isAccessibleXtextProject(project)) {
			try {
				IProject[] referencedProjects = project.getReferencedProjects();
				List<String> result = Lists.newArrayListWithExpectedSize(referencedProjects.length);
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
		return Collections.emptyList();
	}
	
	protected boolean isAccessibleXtextProject(IProject p) {
		return p != null && p.isAccessible() && hasXtextNature(p);
	}
	
	protected boolean hasXtextNature(IProject p) {
		try {
			return p.getNature("org.eclipse.xtext.builder.xtextNature") != null;
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}

}
