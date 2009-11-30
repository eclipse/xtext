/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ToBeBuiltComputer {
	
	@Inject
	private IBuilderState builderState;

	@Inject
	private UriUtil uriUtil;
	
	@Inject 
	private StorageUtil storageUtil;
	
	public ToBeBuilt removeProject(IProject project, final IProgressMonitor monitor) {
		ToBeBuilt result = new ToBeBuilt();
		for (IResourceDescription iResourceDescription : builderState.getAllResourceDescriptions()) {
			ResourceDescriptionImpl descImpl = (ResourceDescriptionImpl) iResourceDescription;
			IStorage storage = storageUtil.getStorage(descImpl.getPathToStorage());
			if (isOnProject(storage,project))
				result.getToBeDeleted().add(descImpl.getURI());
		}
		return result;
	}

	protected boolean isOnProject(IStorage storage, IProject project) {
		if (storage instanceof IFile) {
			return project.contains((IFile)storage);
		}
		return false;
	}
	
	public ToBeBuilt updateProject(final IProject project, final IProgressMonitor monitor) throws CoreException {
		final ToBeBuilt toBeBuilt = removeProject(project, monitor);
		project.accept(new IResourceVisitor() {
			public boolean visit(IResource resource) throws CoreException {
				return updateResource(monitor, toBeBuilt, resource);
			}
		});
		return toBeBuilt;
	}
	
	public boolean updateResource(final IProgressMonitor monitor, final ToBeBuilt toBeBuilt, IResource resource) {
		if (monitor.isCanceled())
			return false;
		if (!isHandled(resource))
			return true;
		IFile file = (IFile) resource;
		URI uri = getUri(file);
		if (uri != null) {
			toBeBuilt.getToBeUpdated().put(uri,getExternalRep(file));
		}
		return true;
	}

	protected boolean isHandled(IResource resource) {
		return (resource instanceof IFile) && !resource.isDerived();
	}
	
	protected URI getUri(IStorage file) {
		return uriUtil.getUri(file);
	}
	
	protected String getExternalRep(IStorage file) {
		return storageUtil.toExternalString(file);
	}


}
