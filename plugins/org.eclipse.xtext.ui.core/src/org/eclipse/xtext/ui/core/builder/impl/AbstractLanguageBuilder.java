/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.impl;

import static org.eclipse.core.resources.IncrementalProjectBuilder.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;
import org.eclipse.emf.emfindex.query.ContainerDescriptorQuery;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.emf.emfindex.query.ResourceDescriptorQuery;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.UpdateCommand;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.index.IXtextIndex;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.core.builder.IBuilderAccess;
import org.eclipse.xtext.ui.core.builder.ILanguageBuilder;
import org.eclipse.xtext.ui.core.editor.validation.IXtextResourceChecker;
import org.eclipse.xtext.validation.CheckMode;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractLanguageBuilder implements ILanguageBuilder {

	public static final String MANAGED_BY = "MANAGED_BY";
	public static final String STORAGE = "STORAGE";
	public static final String BUILDER_ID = "BUILDER_ID";
	
	private final Logger log = Logger.getLogger(getClass());

	@Inject
	protected BuildState state;

	@Inject
	protected IXtextIndex index;

	@Inject
	protected IXtextResourceChecker resourceChecker;

	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	protected String fileExtensions;

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	protected String languageName;

	@Inject
	protected EObjectDescriptorIndexer eObjectIndexer;

	@Inject
	protected EReferenceDescriptorIndexer eReferenceIndexer;

	@Inject
	protected StorageUtil storageUtil;

	protected IBuilderAccess builder;

	public void initialize(IBuilderAccess builderAccess) {
		this.builder = builderAccess;
	}

	protected String getBuilderId() {
		return languageName;
	}

	protected void validate(IStorage storage, Resource res, IProgressMonitor monitor) {
		if (storage instanceof IFile) {
			IFile file = (IFile) storage;
			List<Map<String, Object>> check = resourceChecker.check(res, getValidationContext(), monitor);
			updateMarkers(monitor, file, check);
		}
	}

	protected void updateMarkers(IProgressMonitor monitor, IFile file, List<Map<String, Object>> issues) {
		try {
			new AddMarkersOperation(file, issues, EValidator.MARKER, true).run(monitor);
		} catch (InvocationTargetException e) {
			log.error("Could not create marker.", e);
		} catch (InterruptedException e) {
			log.error("Could not create marker.", e);
		}
	}

	protected Map<?, ?> getValidationContext() {
		return Collections.singletonMap(CheckMode.KEY, CheckMode.NORMAL_AND_FAST);
	}
	
	public final void clean(IProgressMonitor monitor) throws CoreException {
		try {
			internalClean(monitor);
		} finally {
			cleanUpAfterClean();
		}
	}

	protected void cleanUpAfterClean() {
		cleanUpAfterBuild();
	}

	public void internalClean(IProgressMonitor monitor) {}

	public IProject[] build(ISharedState sharedState, int kind, IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = builder.getDelta(builder.getProject());
			if (delta == null || isOpened(delta)) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return builder.getProject().getReferencedProjects();
	}

	protected IStorage findStorageInProject(IProject project, URI uri) {
		Path path = new Path(uri.toPlatformString(true));
		IFile file = project.getWorkspace().getRoot().getFile(path);
		if (file != null && file.exists() && file.getProject() == project)
			return file;
		return null;
	}

	protected Set<URI> getAffectedResourceURIs() {
		final Set<URI> affected = new HashSet<URI>(state.getDeleted());
		Iterable<URI> iterable = Iterables.transform(state.getUpdated().values(), new Function<Resource, URI>() {
			public URI apply(Resource from) {
				return from.getURI();
			}
		});
		Set<URI> changed = Sets.newHashSet(iterable);
		affected.addAll(changed);
		return affected;
	}

	protected boolean hasDependencyChanges() throws CoreException {
		for (IProject refProj : builder.getProject().getReferencedProjects()) {
			IResourceDelta delta = builder.getDelta(refProj);
			if (isClosed(delta) || isOpened(delta) || isProjectDescriptionChange(delta))
				return true;
		}
		return false;
	}

	protected boolean isProjectDescriptionChange(IResourceDelta delta) {
		return (delta.getFlags() & IResourceDelta.DESCRIPTION) != 0;
	}

	protected boolean isOpened(IResourceDelta delta) {
		return delta.getResource() instanceof IProject && (delta.getFlags() & IResourceDelta.OPEN) != 0
				&& ((IProject) delta.getResource()).isOpen();
	}

	protected boolean isClosed(IResourceDelta delta) {
		return delta.getResource() instanceof IProject && (delta.getFlags() & IResourceDelta.OPEN) != 0
				&& !((IProject) delta.getResource()).isOpen();
	}

	protected abstract void fullBuild(final IProgressMonitor monitor) throws CoreException;

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {

			public boolean visit(IResourceDelta delta) throws CoreException {
				IResource resource = delta.getResource();
				if (!(resource instanceof IFile))
					return true;
				IFile file = (IFile) resource;
				if (delta.getKind() == IResourceDelta.ADDED | delta.getKind() == IResourceDelta.CHANGED) {
					if (isManaged(file))
						build(file);
				} else if (delta.getKind() == IResourceDelta.REMOVED) {
					if (isManaged(file))
						delete(file);
				}
				return true;
			}
		};
		delta.accept(visitor);
	}

	protected void delete(final IStorage resource) {
		final URI uri = getURI(resource);
		index.executeUpdateCommand(new UpdateCommand<Void>() {
			public Void execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
				indexUpdater.deleteResource(uri);
				return null;
			}
		});
		state.deleted(uri);
	}

	protected URI getURI(IStorage resource) {
		if (resource == null)
			throw new NullPointerException("resource");
		return URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
	}

	protected boolean isManaged(IStorage resource) {
		if ((resource instanceof IFile) && ((IFile) resource).isDerived())
			return false;
		return hasRightFileExtension(resource.getFullPath());
	}

	protected boolean hasRightFileExtension(IPath path) {
		String[] extensions = fileExtensions.split(",");
		String fileExtension = path.getFileExtension();
		for (String string : extensions) {
			if (string.equals(fileExtension))
				return true;
		}
		return false;
	}

	protected void build(final IStorage storage) {
		final Resource res = getEmfResource(storage);
		index.executeUpdateCommand(new UpdateCommand<Void>() {

			public Void execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
				URI uri = res.getURI();
				indexUpdater.deleteResource(uri);
				String containerName = getContainerName(storage);
				findOrCreateContainer(containerName, indexUpdater, queryExecutor);
				indexUpdater.createOrUpdateResource(containerName, uri, 0l, getUserDataForResource(res, storage));
				eObjectIndexer.update(res, indexUpdater, queryExecutor);
				return null;
			}

		});
		state.updated(storage, res);
	}

	protected void buildRecursivly(IResource iResource) throws CoreException, JavaModelException {
		IResourceVisitor visitor = new IResourceVisitor() {
			public boolean visit(IResource resource) throws CoreException {
				if ((resource instanceof IFile) && isManaged((IFile) resource))
					build((IFile) resource);
				return true;
			}
		};
		iResource.accept(visitor);
	}

	protected Map<String, String> getUserDataForResource(Resource res, final IStorage storage) {
		Map<String,String> map = new HashMap<String, String>();
		map.put(STORAGE, storageUtil.toExternalString(storage));
		map.put(BUILDER_ID, getBuilderId());
		return map;
	}

	protected void findOrCreateContainer(String containerName, IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
		ContainerDescriptorQuery query = new ContainerDescriptorQuery();
		query.setName(containerName);
		QueryResult<ContainerDescriptor> result = queryExecutor.execute(query);
		if (!result.isEmpty()) {
			result.iterator().next();
			return;
		}
		indexUpdater.createContainer(containerName, getUserDataForContainer(containerName));
	}

	protected Map<String, String> getUserDataForContainer(String containerName) {
		return Collections.singletonMap(MANAGED_BY, builder.getProject().getName());
	}

	protected Resource getEmfResource(final IStorage resource) {
		URI uri = getURI(resource);
		if (uri == null)
			return null;
		ResourceSet rs = getResourceSet();
		final Resource res = rs.getResource(uri, true);
		return res;
	}

	protected IStorage getIStorage(final URI uri) {
		return index.executeQueryCommand(new QueryCommand<IStorage>() {

			public IStorage execute(QueryExecutor queryExecutor) {
				ResourceDescriptorQuery query = new ResourceDescriptorQuery();
				query.setURI(uri);
				QueryResult<ResourceDescriptor> result = queryExecutor.execute(query);
				for (ResourceDescriptor resourceDescriptor : result) {
					String externalStorageString = resourceDescriptor.getUserData(STORAGE);
					if (externalStorageString != null)
						return storageUtil.getStorage(externalStorageString);
				}
				return null;
			}
		});
	}

	protected abstract String getContainerName(IStorage resource);
	
	@Inject
	protected Provider<XtextResourceSet> resourceSetProvider;
	protected XtextResourceSet resourceSet;

	protected ResourceSet getResourceSet() {
		if (resourceSet==null) {
			resourceSet = resourceSetProvider.get();
		}
		return resourceSet;
	}

	public final void postBuild(ISharedState sharedState, int kind, IProgressMonitor monitor) {
		try {
			internalPostBuild(sharedState, monitor);
		} finally {
			cleanUpAfterBuild();
		}
	}

	protected void internalPostBuild(ISharedState sharedState, IProgressMonitor monitor) {
		Iterable<URI> resources = index.getPotentiallyInterestedResources(sharedState.getChangedEObjectNames());
		for (URI uri : Sets.newHashSet(resources)) {
			IStorage iStorage = getIStorage(uri);
			if (iStorage != null && isManaged(iStorage)) {
				state.updated(iStorage, getEmfResource(iStorage));
			}
		}

		indexCrossReferences();
		
		for (Entry<IStorage, Resource> res : state.getUpdated().entrySet()) {
			validate(res.getKey(), res.getValue(), monitor);
		}
	}

	protected void cleanUpAfterBuild() {
		state.clear();
		resourceSet=null;
	}

	protected void indexCrossReferences() {
		index.executeUpdateCommand(new UpdateCommand<Void>() {

			public Void execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
				for (Resource res : state.getUpdated().values()) {
					index.clearNameSearchesFor(res.getURI());
					eReferenceIndexer.update(res, indexUpdater, queryExecutor);
				}
				return null;
			}
		});
	}

	protected void deleteResourceDescriptors(IndexUpdater indexUpdater, ContainerDescriptor containerDescriptor) {
		Set<URI> toDelete = new HashSet<URI>();
		List<ResourceDescriptor> descriptors = containerDescriptor.getResourceDescriptors();
		for (ResourceDescriptor resourceDescriptor : descriptors) {
			String userData = resourceDescriptor.getUserData(BUILDER_ID);
			if (userData!=null && userData.equals(getBuilderId()))
				toDelete.add(resourceDescriptor.getURI());
		}
		for (URI uri : toDelete) {
			indexUpdater.deleteResource(uri);
		}
	}

	@Override
	public String toString() {
		return getBuilderId();
	}
}
