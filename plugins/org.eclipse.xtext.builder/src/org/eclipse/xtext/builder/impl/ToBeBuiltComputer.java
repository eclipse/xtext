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
	private IUriUtil iUriUtil;

	public ToBeBuilt removeProject(IProject project, final IProgressMonitor monitor) {
		ToBeBuilt result = new ToBeBuilt();
		for (IResourceDescription iResourceDescription : builderState.getAllResourceDescriptions()) {
			ResourceDescriptionImpl descImpl = (ResourceDescriptionImpl) iResourceDescription;
			IStorage storage = descImpl.getStorage();
			if (isOnProject(storage, project))
				result.getToBeDeleted().add(descImpl.getURI());
		}
		return result;
	}

	protected boolean isOnProject(IStorage storage, IProject project) {
		if (storage instanceof IFile) {
			return project.contains((IFile) storage);
		}
		return false;
	}

	public ToBeBuilt updateProject(final IProject project, final IProgressMonitor monitor) throws CoreException {
		final ToBeBuilt toBeBuilt = removeProject(project, monitor);
		project.accept(new IResourceVisitor() {
			public boolean visit(IResource resource) throws CoreException {
				if (resource instanceof IStorage) {
					return updateStorage(monitor, toBeBuilt, (IStorage) resource);
				}
				return true;
			}
		});
		return toBeBuilt;
	}

	public boolean updateStorage(final IProgressMonitor monitor, final ToBeBuilt toBeBuilt, IStorage storage) {
		if (monitor.isCanceled())
			return false;
		if (!isHandled(storage))
			return true;
		URI uri = getUri(storage);
		if (uri != null) {
			toBeBuilt.getToBeUpdated().put(uri, storage);
		}
		return true;
	}
	
	public boolean removeStorage(final IProgressMonitor monitor, final ToBeBuilt toBeBuilt, IStorage storage) {
		if (monitor.isCanceled())
			return false;
		if (!isHandled(storage))
			return true;
		URI uri = getUri(storage);
		if (uri != null) {
			toBeBuilt.getToBeDeleted().add(uri);
		}
		return true;
	}

	protected boolean isHandled(IStorage resource) {
		return (resource instanceof IFile) && !((IFile) resource).isDerived();
	}

	protected URI getUri(IStorage file) {
		return iUriUtil.getUri(file);
	}

}
