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
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.UriValidator;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public class ToBeBuiltComputer {

	@Inject
	private IBuilderState builderState;

	@Inject
	private IStorage2UriMapper mapper;
	
	@Inject
	private UriValidator uriValidator;

	public ToBeBuilt removeProject(IProject project, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, Iterables.size(builderState.getAllResourceDescriptions()));
		ToBeBuilt result = new ToBeBuilt();
		Iterable<IResourceDescription> allResourceDescriptions = builderState.getAllResourceDescriptions();
		for (IResourceDescription description : allResourceDescriptions) {
			Iterable<IStorage> storages = mapper.getStorages(description.getURI());
			if (!storages.iterator().hasNext()) {
				result.getToBeDeleted().add(description.getURI());
			} else {
				for (IStorage storage : storages) {
					if (isOnProject(storage, project))
						result.getToBeDeleted().add(description.getURI());
				}
			}
			progress.worked(1);
		}
		return result;
	}

	protected boolean isOnProject(IStorage storage, IProject project) {
		if (storage instanceof IFile) {
			return project.contains((IFile) storage);
		}
		return false;
	}

	public ToBeBuilt updateProjectNewResourcesOnly(IProject project, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, "Collecting resources", 1);
		progress.subTask("Collecting resources");
		ToBeBuilt toBeBuilt = updateProject(project, progress.newChild(1));
		Iterable<URI> existingURIs = Iterables.transform(
				builderState.getAllResourceDescriptions(), 
				new Function<IResourceDescription, URI>() {
					public URI apply(IResourceDescription from) {
						return from.getURI();
					}
				}
		);
		for(URI existingURI: existingURIs) {
			toBeBuilt.getToBeDeleted().remove(existingURI);
			toBeBuilt.getToBeUpdated().remove(existingURI);
		}
		return toBeBuilt;
	}
	
	public ToBeBuilt updateProject(IProject project, IProgressMonitor monitor) throws CoreException {
		final SubMonitor progress = SubMonitor.convert(monitor, "Collecting resources", 1);
		progress.subTask("Collecting resources");
		
		final ToBeBuilt toBeBuilt = removeProject(project, progress.newChild(1));
		if (!project.isAccessible() || progress.isCanceled())
			return toBeBuilt;
		
		project.accept(new IResourceVisitor() {
			public boolean visit(IResource resource) throws CoreException {
				if (progress.isCanceled())
					return false;
				if (resource instanceof IStorage) {
					return updateStorage(null, toBeBuilt, (IStorage) resource);
				}
				return true;
			}
		});
		return toBeBuilt;
	}

	public boolean updateStorage(final IProgressMonitor monitor, final ToBeBuilt toBeBuilt, IStorage storage) {
		if (!isHandled(storage))
			return true;
		URI uri = getUri(storage);
		if (uri != null) {
			toBeBuilt.getToBeUpdated().add(uri);
		}
		return true;
	}
	
	public boolean removeStorage(final IProgressMonitor monitor, final ToBeBuilt toBeBuilt, IStorage storage) {
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
		URI uri = mapper.getUri(file);
		return uri!=null && isValid(uri, file)?uri:null;
	}
	
	protected boolean isValid(URI uri, IStorage storage) {
		return uriValidator.isValid(uri, storage);
	}

}
