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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.IXtextBuilderParticipant.BuildType;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public class XtextBuilder extends IncrementalProjectBuilder {
	
	private static final Logger log = Logger.getLogger(XtextBuilder.class);

	public static final String BUILDER_ID = XtextProjectHelper.BUILDER_ID;

	@Inject
	private ToBeBuiltComputer toBeBuiltComputer;

	@Inject
	private IBuilderState builderState;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private RegistryBuilderParticipant participant;

	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		try {
			if (monitor != null) {
				final String taskName = "Building " + getProject().getName() + ": ";
				monitor = new ProgressMonitorWrapper(monitor) {
					@Override
					public void subTask(String name) {
						super.subTask(taskName + name);
					}
				};
			}
			SubMonitor progress = SubMonitor.convert(monitor, 1);
			if (kind == FULL_BUILD) {
				fullBuild(progress.newChild(1), IBuildFlag.RECOVERY_BUILD.isSet(args));
			} else {
				IResourceDelta delta = getDelta(getProject());
				if (delta == null || isOpened(delta)) {
					fullBuild(progress.newChild(1), IBuildFlag.RECOVERY_BUILD.isSet(args));
				} else {
					incrementalBuild(delta, progress.newChild(1));
				}
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (monitor != null)
				monitor.done();
		}
		return null;
	}

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	protected void incrementalBuild(IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
		final SubMonitor progress = SubMonitor.convert(monitor, "Collecting resources", 2);
		progress.subTask("Collecting resources");
		
		final ToBeBuilt toBeBuilt = new ToBeBuilt();
		IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) throws CoreException {
				if (progress.isCanceled())
					return false;
				
				if (delta.getResource() instanceof IStorage) {
					if (delta.getKind() == IResourceDelta.REMOVED) {
						return toBeBuiltComputer.removeStorage(
								null, 
								toBeBuilt, 
								(IStorage) delta.getResource());
					} else if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED) {
						return toBeBuiltComputer.updateStorage(
								null, 
								toBeBuilt, 
								(IStorage) 
								delta.getResource());
					}
				}
				return true;
			}
		};
		delta.accept(visitor);
		if (progress.isCanceled())
			return;
		progress.worked(1);
		doBuild(toBeBuilt, progress.newChild(1), BuildType.INCREMENTAL);
		
	}

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	protected void doBuild(ToBeBuilt toBeBuilt, IProgressMonitor monitor, BuildType type) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		
		ResourceSet resourceSet = getResourceSetProvider().get(getProject());
		if (resourceSet instanceof ResourceSetImpl) {
			((ResourceSetImpl) resourceSet).setURIResourceMap(Maps.<URI, Resource> newHashMap());
		}
		ImmutableList<Delta> deltas = builderState.update(
				resourceSet, 
				toBeBuilt.toBeUpdated,
				toBeBuilt.toBeDeleted, 
				progress.newChild(1));
		if (participant != null) {
			participant.build(
					new IXtextBuilderParticipant.BuildContext(this, resourceSet, deltas, type), 
					progress.newChild(1));
		} else {
			progress.worked(1);
		}
		resourceSet.getResources().clear();
		resourceSet.eAdapters().clear();
	}

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	protected void fullBuild(final IProgressMonitor monitor, boolean isRecoveryBuild) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		
		IProject project = getProject();
		ToBeBuilt toBeBuilt = 
			isRecoveryBuild
				? toBeBuiltComputer.updateProjectNewResourcesOnly(project, progress.newChild(1)) 
				: toBeBuiltComputer.updateProject(project, progress.newChild(1));
		doBuild(toBeBuilt, progress.newChild(1), 
			isRecoveryBuild 
				? BuildType.RECOVERY 
				: BuildType.FULL);
	}

	protected boolean isOpened(IResourceDelta delta) {
		return delta.getResource() instanceof IProject 
				&& (delta.getFlags() & IResourceDelta.OPEN) != 0
				&& ((IProject) delta.getResource()).isOpen();
	}

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the <em>implementors</em> responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		try {
			ToBeBuilt toBeBuilt = toBeBuiltComputer.removeProject(getProject(), progress.newChild(1));
			doClean(toBeBuilt, progress.newChild(1));
		} finally {
			if (monitor != null)
				monitor.done();
		}
	}
	
	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	protected void doClean(ToBeBuilt toBeBuilt, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		ImmutableList<Delta> deltas = builderState.clean(toBeBuilt.toBeDeleted, progress.newChild(1));
		if (participant != null) {
			participant.build(new IXtextBuilderParticipant.BuildContext(this, 
					getResourceSetProvider().get(getProject()), 
					deltas,
					BuildType.CLEAN), 
					progress.newChild(1));
		} else {
			progress.worked(1);
		}
	}
}
