/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.impl;

import static org.eclipse.core.resources.IncrementalProjectBuilder.FULL_BUILD;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.query.EReferenceDescriptorQuery;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.UpdateCommand;
import org.eclipse.emf.emfindex.store.UpdateableIndex;
import org.eclipse.xtext.ui.core.builder.IBuilderAccess;
import org.eclipse.xtext.ui.core.builder.ILanguageBuilder;
import org.eclipse.xtext.ui.core.editor.validation.IXtextResourceChecker;
import org.eclipse.xtext.validation.CheckMode;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultLanguageBuilder implements ILanguageBuilder {

	@Inject
	protected BuildState state;

	@Inject
	protected UpdateableIndex index;

	@Inject
	protected IXtextResourceChecker resourceChecker;

	@Inject
	@Named("file.extensions")
	protected String fileExtensions;

	@Inject
	protected EObjectDescriptorIndexer eObjectIndexer;

	@Inject
	protected EReferenceDescriptorIndexer eReferenceIndexer;

	protected void validate(IResource iResource, Resource res, IProgressMonitor monitor) {
		List<Map<String, Object>> check = resourceChecker.check(res, getValidationContext(), monitor);
		AddMarkersOperation.run(iResource, check, true, monitor);
	}

	protected Map<?, ?> getValidationContext() {
		return Collections.singletonMap(CheckMode.KEY, CheckMode.NORMAL_AND_FAST);
	}

	public void clean(final IBuilderAccess builder, IProgressMonitor monitor) {
		index.executeUpdateCommand(new UpdateCommand<Void>() {
			public Void execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
				indexUpdater.deleteContainer(builder.getProject().getName());
				return null;
			}
		});
	}

	public IProject[] build(IBuilderAccess builder, int kind, IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(builder, monitor);
		} else {
			IResourceDelta delta = builder.getDelta(builder.getProject());
			if (delta == null || isProjectDescriptionChange(delta) || isOpened(delta) || hasDependencyChanges(builder)) {
				fullBuild(builder, monitor);
			} else {
				incrementalBuild(delta, monitor);
				updateReferencingResources(builder, delta, monitor);
			}
		}
		return builder.getProject().getReferencedProjects();
	}

	protected void updateReferencingResources(final IBuilderAccess builder, IResourceDelta delta,
			IProgressMonitor monitor) {

		index.executeQueryCommand(new QueryCommand<Void>() {

			public Void execute(QueryExecutor queryExecutor) {
				final Set<URI> affected = getAffectedResourceURIs();

				EReferenceDescriptorQuery q = new EReferenceDescriptorQuery();
				QueryResult<EReferenceDescriptor> result = queryExecutor.execute(q);
				Iterable<EReferenceDescriptor> filtered = Iterables.filter(result,
						new Predicate<EReferenceDescriptor>() {
							public boolean apply(EReferenceDescriptor refDesc) {
								return affected.contains(refDesc.getTargetResourceURI());
							}
						});
				Set<IResource> resources = new HashSet<IResource>();
				for (EReferenceDescriptor refDesc : filtered) {
					URI uri = refDesc.getSourceResourceDescriptor().getURI();
					IResource resource = findResourceInProject(builder.getProject(), uri);
					if (resource != null && resources.add(resource)) {
						Resource resource2 = getEmfResource(resource);
						state.updated(resource, resource2);
					}
				}
				return null;
			}
		});
	}

	protected IResource findResourceInProject(IProject project, URI uri) {
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

	protected boolean hasDependencyChanges(IBuilderAccess builder) throws CoreException {
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

	protected void fullBuild(final IBuilderAccess builder, final IProgressMonitor monitor) throws CoreException {
		IResourceVisitor visitor = new IResourceVisitor() {
			public boolean visit(IResource resource) throws CoreException {
				if (isLanguageResource(resource))
					build(resource);
				return true;
			}
		};
		builder.getProject().accept(visitor);
	}

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {

			public boolean visit(IResourceDelta delta) throws CoreException {
				if (delta.getKind() == IResourceDelta.ADDED | delta.getKind() == IResourceDelta.CHANGED) {
					if (isLanguageResource(delta.getResource()))
						build(delta.getResource());
				} else if (delta.getKind() == IResourceDelta.REMOVED) {
					if (isLanguageResource(delta.getResource()))
						delete(delta.getResource());
				}
				return true;
			}
		};
		delta.accept(visitor);
	}

	protected void delete(final IResource resource) {
		index.executeUpdateCommand(new UpdateCommand<Void>() {

			public Void execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
				indexUpdater.deleteResource(getURI(resource));
				return null;
			}
		});
		state.deleted(getURI(resource));
	}

	protected URI getURI(IResource resource) {
		if (resource == null)
			throw new NullPointerException("resource");
		return URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
	}

	protected boolean isLanguageResource(IResource resource) {
		if (resource.getType() != IResource.FILE)
			return false;
		if (resource.isDerived())
			return false;
		String[] extensions = fileExtensions.split(",");
		String fileExtension = resource.getFullPath().getFileExtension();
		for (String string : extensions) {
			if (string.equals(fileExtension))
				return true;
		}
		return false;
	}

	protected void build(final IResource resource) {
		final Resource res = getEmfResource(resource);
		index.executeUpdateCommand(new UpdateCommand<Void>() {

			public Void execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
				URI uri = res.getURI();
				indexUpdater.deleteResource(uri);
				indexUpdater.createOrUpdateResource(getContainerName(resource), uri, 0l, null);
				eObjectIndexer.update(res, indexUpdater, queryExecutor);
				return null;
			}
		});
		state.updated(resource, res);
	}

	protected Resource getEmfResource(final IResource resource) {
		URI uri = getURI(resource);
		if (uri == null)
			return null;
		ResourceSet rs = getResourceSet();
		final Resource res = rs.getResource(uri, true);
		return res;
	}

	protected String getContainerName(IResource resource) {
		return resource.getProject().getName();
	}

	protected ResourceSet getResourceSet() {
		return new ResourceSetImpl();
	}

	public void postBuild(IBuilderAccess builder, int kind, IProgressMonitor monitor) {
		try {
			index.executeUpdateCommand(new UpdateCommand<Void>() {

				public Void execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
					for (Resource res : state.getUpdated().values()) {
						eReferenceIndexer.update(res, indexUpdater, queryExecutor);
					}
					return null;
				}
			});
			for (Entry<IResource, Resource> res : state.getUpdated().entrySet()) {
				validate(res.getKey(), res.getValue(), monitor);
			}
		} finally {
			state.clear();
		}
	}

}
