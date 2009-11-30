/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.builder.builderState.IBuilderState;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextBuilder extends IncrementalProjectBuilder implements IResourceChangeListener {
	public static Logger log = Logger.getLogger(XtextBuilder.class);

	public static final String BUILDER_ID = "org.eclipse.xtext.builder.xtextBuilder";

	@Inject
	private IBuilderState builderState;

	@Inject
	private IUriUtil uriUtil;

	class ToBeBuild {
		Set<URI> toBeUpdated = Sets.newHashSet();
		Set<URI> toBeDeleted = Sets.newHashSet();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		try {
			if (kind == FULL_BUILD) {
				fullBuild(monitor);
			} else {
				IResourceDelta delta = getDelta(getProject());
				if (delta == null || isOpened(delta)) {
					fullBuild(monitor);
				} else {
					incrementalBuild(delta, monitor);
				}
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getProject().getReferencedProjects();
	}

	protected void incrementalBuild(IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
		final ToBeBuild toBeBuild = new ToBeBuild();
		IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) throws CoreException {
				if (monitor.isCanceled())
					return false;
				IResource resource = delta.getResource();
				if (!isHandled(resource))
					return true;
				IFile file = (IFile) resource;
				URI uri = getUri(file);
				if (uri != null) {
					if (delta.getKind() == IResourceDelta.ADDED | delta.getKind() == IResourceDelta.CHANGED) {
						toBeBuild.toBeUpdated.add(uri);
					} else if (delta.getKind() == IResourceDelta.REMOVED) {
						toBeBuild.toBeDeleted.add(uri);
					}
				}
				return true;
			}

		};
		delta.accept(visitor);
		doBuild(toBeBuild);
	}
	
	protected boolean isHandled(IResource resource) {
		return (resource instanceof IFile) && !resource.isDerived();
	}

	protected void doBuild(ToBeBuild toBeBuild) {
		builderState.update(toBeBuild.toBeUpdated, toBeBuild.toBeDeleted);
	}

	protected URI getUri(IStorage file) {
		return uriUtil.getUri(file);
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		IProject project = getProject();
		final ToBeBuild toBeBuild = updateProject(monitor, project);
		doBuild(toBeBuild);
	}

	protected ToBeBuild updateProject(final IProgressMonitor monitor, IProject project) throws CoreException {
		final ToBeBuild toBeBuild = new ToBeBuild();
		project.accept(new IResourceVisitor() {
			public boolean visit(IResource resource) throws CoreException {
				if (monitor.isCanceled())
					return false;
				if (!isHandled(resource))
					return true;
				IFile file = (IFile) resource;
				URI uri = getUri(file);
				if (uri != null)
					toBeBuild.toBeUpdated.add(uri);
				return true;
			}
		});
		return toBeBuild;
	}
	
	protected ToBeBuild deleteProject(final IProgressMonitor monitor, IProject project) throws CoreException {
		final ToBeBuild toBeBuild = new ToBeBuild();
		project.accept(new IResourceVisitor() {
			public boolean visit(IResource resource) throws CoreException {
				if (monitor.isCanceled())
					return false;
				if (!isHandled(resource))
					return true;
				IFile file = (IFile) resource;
				URI uri = getUri(file);
				if (uri != null)
					toBeBuild.toBeDeleted.add(uri);
				return true;
			}
		});
		return toBeBuild;
	}

	protected boolean isOpened(IResourceDelta delta) {
		return delta.getResource() instanceof IProject && (delta.getFlags() & IResourceDelta.OPEN) != 0
				&& ((IProject) delta.getResource()).isOpen();
	}

	@Override
	protected void clean(final IProgressMonitor monitor) throws CoreException {
		try {
			final ToBeBuild toBeBuild = deleteProject(monitor, getProject());
			doBuild(toBeBuild);
		} catch (WrappedException e) {
			log.error(e.getCause().getMessage(), e.getCause());
			throw e;
		} catch (RuntimeException e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	protected void startupOnInitialize() {
		super.startupOnInitialize();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
			try {
				event.getDelta().accept(new IResourceDeltaVisitor() {

					public boolean visit(IResourceDelta delta) throws CoreException {
						if (delta.getResource() instanceof IWorkspaceRoot)
							return true;
						if (delta.getResource().equals(getProject())) {
							if ((delta.getFlags() & IResourceDelta.OPEN) != 0 && getProject().isOpen()) {
								Job job = new Job("deferred") {

									@Override
									protected IStatus run(IProgressMonitor monitor) {
										try {
											build(FULL_BUILD, Collections.emptyMap(), new NullProgressMonitor());
										} catch (CoreException e) {
											log.error(e.getMessage(), e);
											return e.getStatus();
										}
										return Status.OK_STATUS;
									}
								};
								job.setRule(getProject());
								job.schedule();
							}
						}
						return false;
					}
				});
			} catch (CoreException e) {
				log.error(e);
			}
		}
		if ((event.getType() == IResourceChangeEvent.PRE_CLOSE || event.getType() == IResourceChangeEvent.PRE_DELETE)) {
			if (getProject().equals(event.getResource())) {
				try {
					clean(new NullProgressMonitor());
				} catch (CoreException e) {
					log.error("Error cleaning project " + getProject(), e);
				}
			}
		}
	}

}
