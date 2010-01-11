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
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.core.resource.IStorage2UriMapper;

import com.google.common.collect.Collections2;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ToBeBuiltComputer {

	@Inject
	private IBuilderState builderState;

	@Inject
	private IStorage2UriMapper mapper;

	public ToBeBuilt removeProject(IProject project, final IProgressMonitor monitor) {
		ToBeBuilt result = new ToBeBuilt();
		SubMonitor.convert(monitor, 0);
		Iterable<IResourceDescription> allResourceDescriptions = builderState.getAllResourceDescriptions();
		SubMonitor subMonitor = SubMonitor.convert(monitor, Collections2.forIterable(allResourceDescriptions).size());
		for (IResourceDescription iResourceDescription : allResourceDescriptions) {
			ResourceDescriptionImpl descImpl = (ResourceDescriptionImpl) iResourceDescription;
			Iterable<IStorage> storages = mapper.getStorages(descImpl.getURI());
			for (IStorage storage : storages) {
				if (isOnProject(storage, project))
					result.getToBeDeleted().add(descImpl.getURI());
			}
			subMonitor.worked(1);
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
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Collecting resources", 1);
		subMonitor.subTask("Collecting resources");
		try {
			final ToBeBuilt toBeBuilt = removeProject(project, monitor);
			if (!project.isAccessible())
				return toBeBuilt;
			project.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IStorage) {
						return updateStorage(monitor, toBeBuilt, (IStorage) resource);
					}
					return true;
				}
			});
			return toBeBuilt;
		} finally {
			subMonitor.done();
		}
	}

	public boolean updateStorage(final IProgressMonitor monitor, final ToBeBuilt toBeBuilt, IStorage storage) {
		if (monitor.isCanceled())
			return false;
		if (!isHandled(storage))
			return true;
		URI uri = getUri(storage);
		if (uri != null) {
			toBeBuilt.getToBeUpdated().add(uri);
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
		return mapper.getUri(file);
	}
	
	protected boolean isValid(URI uri) {
		return mapper.isValidUri(uri);
	}

}
