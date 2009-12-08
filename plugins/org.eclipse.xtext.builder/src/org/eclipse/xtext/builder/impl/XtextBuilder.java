/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.ui.core.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextBuilder extends IncrementalProjectBuilder {
	public static Logger log = Logger.getLogger(XtextBuilder.class);

	public static final String BUILDER_ID = "org.eclipse.xtext.builder.xtextBuilder";

	@Inject
	private ToBeBuiltComputer toBeBuiltComputer;

	@Inject
	private IBuilderState builderState;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
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
		return null;
	}

	protected void incrementalBuild(IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
		final ToBeBuilt toBeBuilt = new ToBeBuilt();
		IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) throws CoreException {
				if (delta.getResource() instanceof IStorage) {
					if (delta.getKind() == IResourceDelta.REMOVED) {
						return toBeBuiltComputer.removeStorage(monitor, toBeBuilt, (IStorage) delta.getResource());
					} else if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED) {
						return toBeBuiltComputer.updateStorage(monitor, toBeBuilt, (IStorage) delta.getResource());
					}
				}
				return true;
			}
		};
		delta.accept(visitor);
		doBuild(toBeBuilt, monitor);
	}

	protected void doBuild(ToBeBuilt toBeBuilt, IProgressMonitor monitor) {
		builderState.update(getResourceSetProvider().get(getProject()), toBeBuilt.toBeUpdated, toBeBuilt.toBeDeleted,
				monitor);
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		IProject project = getProject();
		final ToBeBuilt toBeBuilt = toBeBuiltComputer.updateProject(project, monitor);
		doBuild(toBeBuilt, monitor);
	}

	protected boolean isOpened(IResourceDelta delta) {
		return delta.getResource() instanceof IProject && (delta.getFlags() & IResourceDelta.OPEN) != 0
				&& ((IProject) delta.getResource()).isOpen();
	}

	@Override
	protected void startupOnInitialize() {
		super.startupOnInitialize();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(listener);
	}

	@Inject
	private ProjectOpenedOrClosedListener listener;

}
