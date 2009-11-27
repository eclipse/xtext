/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.internal;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.ui.core.builder.impl.ISharedState;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextBuilder extends IncrementalProjectBuilder implements IResourceChangeListener {
	public static Logger log = Logger.getLogger(XtextBuilder.class);

	public static final String BUILDER_ID = "org.eclipse.xtext.ui.core.xtextBuilder";

	@Inject
	private CompositeLanguageBuilder compositeLanguageBuilder;

	@Inject
	private ISharedState sharedState;

	@SuppressWarnings("unchecked")
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		IProject[] projects = null;
		try {
			projects = compositeLanguageBuilder.build(sharedState, kind, monitor);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		try {
			compositeLanguageBuilder.postBuild(sharedState, kind, monitor);
		} catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
		return projects;
	}

	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		try {
			super.clean(monitor);
			compositeLanguageBuilder.clean(monitor);
		} catch (WrappedException e) {
			log.error(e.getCause().getMessage(), e.getCause());
			throw e;
		} catch (RuntimeException e) {
			log.error(e.getMessage(), e);
			throw e;
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	private BuilderAccess getBuilderAccess() {
		return new BuilderAccess(this);
	}

	@Override
	protected void startupOnInitialize() {
		super.startupOnInitialize();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
		compositeLanguageBuilder.initialize(getBuilderAccess());
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
