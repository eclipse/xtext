/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * Encapsulates the decision about the resources that should be built.
 * 
 * The resource processing can be extended by means of {@link IToBeBuiltComputerContribution contributions}. 
 * 
 * @see IToBeBuiltComputerContribution
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

	private ImmutableList<? extends IToBeBuiltComputerContribution> contributions;

	@Inject
	private void initializeContributions(ISharedStateContributionRegistry registry) {
		contributions = registry.getContributedInstances(IToBeBuiltComputerContribution.class);
	}

	/**
	 * Announce that the given project was removed / closed or a clean build was triggered. 
	 * All contained resources are considered to be no longer available.
	 * 
	 * @see IToBeBuiltComputerContribution#removeProject(ToBeBuilt, IProject, IProgressMonitor)
	 */
	public ToBeBuilt removeProject(IProject project, IProgressMonitor monitor) {
		ToBeBuilt toBeBuilt = doRemoveProject(project, monitor);
		for (int i = 0, size = contributions.size(); i < size; i++) {
			contributions.get(i).removeProject(toBeBuilt, project, monitor);
		}
		return toBeBuilt;
	}

	protected ToBeBuilt doRemoveProject(IProject project, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, Iterables.size(builderState.getAllResourceDescriptions()));
		ToBeBuilt result = new ToBeBuilt();
		Iterable<IResourceDescription> allResourceDescriptions = builderState.getAllResourceDescriptions();
		for (IResourceDescription description : allResourceDescriptions) {
			Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(description.getURI());
			boolean onlyOnThisProject = true;
			Iterator<Pair<IStorage, IProject>> iterator = storages.iterator();
			while (iterator.hasNext() && onlyOnThisProject) {
				Pair<IStorage, IProject> storage2Project = iterator.next();
				final boolean isSameProject = project.equals(storage2Project.getSecond());
				onlyOnThisProject = isSameProject || !storage2Project.getSecond().isAccessible();
			}
			if (onlyOnThisProject)
				result.getToBeDeleted().add(description.getURI());
			progress.worked(1);
		}
		return result;
	}

	/**
	 * Recovery build was triggered, remove all cached information for resources that are no
	 * longer contained in the project.
	 */
	public ToBeBuilt updateProjectNewResourcesOnly(IProject project, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, Messages.ToBeBuiltComputer_CollectingReosurces, 1);
		progress.subTask(Messages.ToBeBuiltComputer_CollectingReosurces);
		ToBeBuilt toBeBuilt = updateProject(project, progress.newChild(1));
		Iterable<URI> existingURIs = Iterables.transform(builderState.getAllResourceDescriptions(),
				new Function<IResourceDescription, URI>() {
					public URI apply(IResourceDescription from) {
						return from.getURI();
					}
				});
		for (URI existingURI : existingURIs) {
			toBeBuilt.getToBeDeleted().remove(existingURI);
			toBeBuilt.getToBeUpdated().remove(existingURI);
		}
		return toBeBuilt;
	}

	/**
	 * Full build was triggered. Update all information that is available for the given project.
	 * All contained resources are processed by {@link #updateStorage(IProgressMonitor, ToBeBuilt, IStorage)}.
	 * 
	 * @see #updateStorage(IProgressMonitor, ToBeBuilt, IStorage)
	 * @see #isHandled(IFolder)
	 * @see IToBeBuiltComputerContribution#updateProject(ToBeBuilt, IProject, IProgressMonitor)
	 */
	public ToBeBuilt updateProject(IProject project, IProgressMonitor monitor) throws CoreException {
		final SubMonitor progress = SubMonitor.convert(monitor, Messages.ToBeBuiltComputer_CollectingReosurces, 1);
		progress.subTask(Messages.ToBeBuiltComputer_CollectingReosurces);

		final ToBeBuilt toBeBuilt = doRemoveProject(project, progress.newChild(1));
		if (!project.isAccessible())
			return toBeBuilt;
		if (progress.isCanceled())
			throw new OperationCanceledException();
		project.accept(new IResourceVisitor() {
			public boolean visit(IResource resource) throws CoreException {
				if (progress.isCanceled())
					throw new OperationCanceledException();
				if (resource instanceof IStorage) {
					return updateStorage(null, toBeBuilt, (IStorage) resource);
				}
				if (resource instanceof IFolder) {
					return isHandled((IFolder) resource);
				}
				return true;
			}
		});
		for (int i = 0; i < contributions.size(); i++) {
			contributions.get(i).updateProject(toBeBuilt, project, monitor);
		}
		return toBeBuilt;
	}

	/**
	 * Update the information that is available for the given storage. This is used by a full build
	 * and the incremental build.
	 * 
	 * @see #isHandled(IStorage)
	 * @see #getUri(IStorage)
	 */
	public boolean updateStorage(final IProgressMonitor monitor, final ToBeBuilt toBeBuilt, IStorage storage) {
		if (!isHandled(storage))
			return true;
		URI uri = getUri(storage);
		if (uri != null) {
			toBeBuilt.getToBeUpdated().add(uri);
		}
		return true;
	}

	/**
	 * Removes the information that is associated with the given storage. Used by the incremental build.
	 * 
	 * @see #isHandled(IStorage)
	 * @see IToBeBuiltComputerContribution#removeStorage(ToBeBuilt, IStorage, IProgressMonitor)
	 */
	public boolean removeStorage(final IProgressMonitor monitor, final ToBeBuilt toBeBuilt, IStorage storage) {
		for (int i = 0; i < contributions.size(); i++) {
			if (contributions.get(i).removeStorage(toBeBuilt, storage, monitor)) {
				return true;
			}
		}
		if (!isHandled(storage))
			return true;
		URI uri = getUri(storage);
		if (uri != null) {
			toBeBuilt.getToBeDeleted().add(uri);
		}
		return true;
	}

	/**
	 * Returns <code>true</code> if the storage should be processed by the builder.
	 * That is, it is known to the {@link UriValidator} and a {@link IToBeBuiltComputerContribution contribution}
	 * can possibly manage it or it is a file.
	 * 
	 * @see UriValidator#isPossiblyManaged(IStorage)
	 * @see IToBeBuiltComputerContribution#isPossiblyHandled(IStorage)
	 */
	protected boolean isHandled(IStorage storage) {
		boolean possiblyManaged = false;
		for (int i = 0; i < contributions.size() && !possiblyManaged; i++) {
			possiblyManaged = contributions.get(i).isPossiblyHandled(storage);
		}
		if ((possiblyManaged || storage instanceof IFile) && uriValidator.isPossiblyManaged(storage)) {
			return true;
		}
		return false;
	}

	/**
	 * Return <code>true</code> if the folder should be traversed. <code>False</code> otherwise. Defaults to
	 * <code>true</code> for all folders. If a contribution rejects the folder, <code>false</code> is returned.
	 * 
	 * @see org.eclipse.xtext.builder.impl.javasupport.JdtToBeBuiltComputer#isRejected(IFolder)
	 * @return <code>true</code> if the folder should be traversed. <code>false</code> otherwise.
	 * @since 2.1
	 */
	protected boolean isHandled(IFolder folder) {
		for (int i = 0; i < contributions.size(); i++) {
			if (contributions.get(i).isRejected(folder)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the URI of the given storage if it is buildable.
	 */
	protected URI getUri(IStorage file) {
		URI uri = mapper.getUri(file);
		return uri != null && isValid(uri, file) ? uri : null;
	}

	/**
	 * Ask the {@link UriValidator} whether the storage is buildable.
	 * 
	 * @see UriValidator#canBuild(URI, IStorage)
	 */
	protected boolean isValid(URI uri, IStorage storage) {
		return uriValidator.canBuild(uri, storage);
	}

}
