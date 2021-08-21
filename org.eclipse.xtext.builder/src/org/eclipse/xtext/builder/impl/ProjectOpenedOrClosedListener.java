/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 * @author Sebastian Zarnekow - Rewrote approach to scheduled closed projects
 */
@Singleton
public class ProjectOpenedOrClosedListener implements IResourceChangeListener {

	private final static Logger log = Logger.getLogger(ProjectOpenedOrClosedListener.class);

	private static boolean reflectErrorLogged = false;

	@Inject
	private ToBeBuiltComputer toBeBuiltComputer;

	@Inject
	private IBuilderState builderState;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	@Deprecated
	private BuildScheduler buildScheduler;

	@Inject
	private QueuedBuildData queuedBuildData;

	@Inject
	private ClosedProjectsQueue closedProjectsQueue;

	@Inject
	private IWorkspace workspace;

	/**
	 * @since 2.17
	 */
	private final RemoveProjectsJob removeProjectsJob = createRemoveProjectsJob();

	/**
	 * @since 2.17
	 */
	protected class RemoveProjectsJob extends WorkspaceJob {

		public RemoveProjectsJob() {
			super(Messages.ProjectOpenedOrClosedListener_RemovingProject.trim() + Messages.ProjectOpenedOrClosedListener_FromIndex);
			setRule(ResourcesPlugin.getWorkspace().getRoot());
		}

		@Override
		public boolean belongsTo(Object family) {
			return family == ResourcesPlugin.FAMILY_AUTO_BUILD || family == ResourcesPlugin.FAMILY_MANUAL_BUILD;
		}

		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
			processClosedProjects(monitor);
			return Status.OK_STATUS;
		}
	}
	
	/**
	 * @since 2.17
	 */
	protected RemoveProjectsJob createRemoveProjectsJob() {
		return new RemoveProjectsJob();
	}
	
	/**
	 * @since 2.17
	 */
	public ClosedProjectsQueue getClosedProjectsQueue() {
		return closedProjectsQueue;
	}
	
	/**
	 * @since 2.17
	 */
	public IWorkspace getWorkspace() {
		return workspace;
	}
	
	/**
	 * @since 2.17
	 */
	public QueuedBuildData getQueuedBuildData() {
		return queuedBuildData;
	}
	
	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

	public ToBeBuiltComputer getToBeBuiltComputer() {
		return toBeBuiltComputer;
	}

	public IBuilderState getBuilderState() {
		return builderState;
	}

	@Override
	public void resourceChanged(final IResourceChangeEvent event) {
		if (workspace != null && workspace.isAutoBuilding()) {
			if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
				try {
					final Set<IProject> toUpdate = findNewProjectsToBuild(event);
					scheduleBuildIfNecessary(toUpdate);
				} catch (CoreException e) {
					log.error(e.getMessage(), e);
				}
			} else if ((event.getType() == IResourceChangeEvent.PRE_CLOSE || event.getType() == IResourceChangeEvent.PRE_DELETE)) {
				if (event.getResource() instanceof IProject && (XtextProjectHelper.hasNature((IProject) event.getResource())
						|| event.getResource().isAccessible() && event.getResource().isHidden())) {
					scheduleRemoveProjectJob((IProject) event.getResource());
				}
			}
		}
	}

	private Set<IProject> findNewProjectsToBuild(final IResourceChangeEvent event) throws CoreException {
		final Set<IProject> toUpdate = Sets.newLinkedHashSet();
		event.getDelta().accept(createVisitor(toUpdate));
		return toUpdate;
	}

	@Deprecated
	private void scheduleBuildIfNecessary(final Set<IProject> toUpdate) {
		if (!toUpdate.isEmpty()) {
			buildScheduler.scheduleBuildIfNecessary(toUpdate, IBuildFlag.FORGET_BUILD_STATE_ONLY);
		}
	}

	private IResourceDeltaVisitor createVisitor(final Set<IProject> accumutor) {
		return new IResourceDeltaVisitor() {
			@Override
			public boolean visit(IResourceDelta delta) throws CoreException {
				return visitResourceDelta(delta, accumutor);
			}
		};
	}

	/**
	 * @since 2.17
	 */
	protected boolean visitResourceDelta(IResourceDelta delta, final Set<IProject> accumulator) {
		if (delta.getResource() instanceof IWorkspaceRoot)
			return true;
		if (delta.getResource() instanceof IProject) {
			IProject project = (IProject) delta.getResource();
			if ((delta.getKind() & IResourceDelta.CHANGED) != 0 && project.isOpen()) {
				if ((delta.getFlags() & IResourceDelta.OPEN) != 0) {
					accumulator.add(project);
				}
				if ((delta.getFlags() & IResourceDelta.DESCRIPTION) != 0) {
					if ((delta.findMember(new Path(".project")) != null) && XtextProjectHelper.hasNature(project)
							&& XtextProjectHelper.hasBuilder(project))
						accumulator.add(project);
					else if (!XtextProjectHelper.hasNature(project)) {
						scheduleRemoveProjectJobIfNecessary(project, delta);
					}
				}
			}
		}
		return false;
	}

	protected void scheduleRemoveProjectJob(final IProject project) {
		try {
			final ToBeBuilt toBeBuilt = getToBeBuiltComputer().removeProject(project, new NullProgressMonitor());
			if (toBeBuilt.getToBeDeleted().isEmpty() && toBeBuilt.getToBeUpdated().isEmpty()) {
				return;
			}
			scheduleJob(project.getName(), toBeBuilt);
		} finally {
			XtextBuilder builder = BuildManagerAccess.findBuilder(project);
			if (builder != null) {
				builder.forgetLastBuiltState();
			}
		}
	}

	/**
	 * @since 2.8
	 */
	protected void scheduleRemoveProjectJobIfNecessary(IProject project, IResourceDelta delta) {
		try {
			ReflectExtensions reflector = new ReflectExtensions();
			Object oldInfo = reflector.get(delta, "oldInfo");
			Map<?, ?> natures = reflector.get(oldInfo, "natures");
			if (natures != null && natures.containsKey(XtextProjectHelper.NATURE_ID)) {
				scheduleRemoveProjectJob(project);
			}
		} catch (Exception e) {
			if (!reflectErrorLogged) {
				log.error("Scheduled unnecessary build due to reflective code failure", e);
				reflectErrorLogged = true;
			}
			scheduleRemoveProjectJob(project);
		}
	}

	/**
	 * @since 2.17
	 */
	protected void scheduleJob(String name, ToBeBuilt toBeBuilt) {
		closedProjectsQueue.enqueue(ImmutableSet.of(name), toBeBuilt);
		removeProjectsJob
				.setName(Messages.ProjectOpenedOrClosedListener_RemovingProject + name + Messages.ProjectOpenedOrClosedListener_FromIndex);
		removeProjectsJob.schedule();
	}

	/**
	 * Process the closed projects now. Must be called when holding the workspace lock.
	 *
	 * @param monitor
	 *            the monitor.
	 *            
	 * @since 2.17
	 */
	protected void processClosedProjects(IProgressMonitor monitor) {
		ClosedProjectsQueue.Task task = closedProjectsQueue.exhaust();
		if (task.isEmpty()) {
			return;
		}
		ImmutableSet<String> removedProjects = task.getProjectNames();
		String projectNames = Joiner.on(", ").join(removedProjects);
		String taskName = Messages.ProjectOpenedOrClosedListener_RemovingProject + projectNames
				+ Messages.ProjectOpenedOrClosedListener_FromIndex;
		monitor.setTaskName(taskName);
		SubMonitor progress = SubMonitor.convert(monitor, 1);
		try {
			ResourceSet resourceSet = createResourceSet();
			BuildData buildData = new BuildData(
					"",
					resourceSet,
					task.getToBeBuilt(),
					queuedBuildData,
					false,
					BuildManagerAccess::requestBuild,
					removedProjects);
			getBuilderState().update(buildData, progress.newChild(1));
		} catch (Error | RuntimeException e) {
			task.reschedule();
			throw e;
		} finally {
			monitor.done();
		}
	}

	private ResourceSet createResourceSet() {
		ResourceSet resourceSet = getResourceSetProvider().get(null);
		resourceSet.getLoadOptions().put(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);
		if (resourceSet instanceof ResourceSetImpl) {
			((ResourceSetImpl) resourceSet).setURIResourceMap(Maps.<URI, Resource> newHashMap());
		}
		return resourceSet;
	}

	/**
	 * Wait for the removeProjectJob to finish.
	 *
	 * Public for testing purpose.
	 * 
	 * @since 2.17
	 */
	@VisibleForTesting
	public void joinRemoveProjectJob() {
		/*
		 * szarnekow: Tests in tight loops revealed that join does not always wait for the job to really finish.
		 * Including the wait serves as a poor attempt to ensure that the current thread really sees the correct
		 * internal state of the job instance when it tries to join.
		 *
		 * To be honest, I do not understand why the synchronized block in the job manager is not sufficient for this,
		 * but after the synchronized block was introduced here, I do no longer see spurious races between the join and
		 * the job execution. I suspect it is related to the Java memory model, but that is only a vague feeling.
		 */
		try {
			// Pseudo fence to make sure that we see what we want to see.
			synchronized (this) {
				wait(1);
			}
			removeProjectsJob.join();
		} catch (InterruptedException e) {
			// ignore
			e.printStackTrace();
		}
	}

}
