/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.internal.jobs.InternalJob;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.builder.IXtextBuilderParticipant.BuildType;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.eclipse.xtext.builder.impl.ClosedProjectsQueue.Task;
import org.eclipse.xtext.builder.internal.Activator;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 * @author Knut Wannheden
 * @author Sebastian Zarnekow - BuildData as blackboard for scheduled data
 */
public class XtextBuilder extends IncrementalProjectBuilder {

	private static final Logger log = Logger.getLogger(XtextBuilder.class);

	public static final String BUILDER_ID = XtextProjectHelper.BUILDER_ID;
	/** org.eclipse.jdt.internal.core.ExternalFoldersManager.EXTERNAL_PROJECT_NAME */
	private static final String EXTERNAL_PROJECT_NAME = ".org.eclipse.jdt.core.external.folders"; //$NON-NLS-1$

	@Inject
	private ToBeBuiltComputer toBeBuiltComputer;

	@Inject
	private IBuilderState builderState;

	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	@Inject
	private IResourceServiceProvider.Registry resourceServiceProvideRegistry;

	@Inject
	private RegistryBuilderParticipant participant;

	@Inject
	private QueuedBuildData queuedBuildData;

	@Inject
	private IBuildLogger buildLogger;
	
	@Inject 
	private OperationCanceledManager operationCanceledManager;
	
	private ClosedProjectsQueue closedProjectsQueue;
	
	@Inject
	private void injectClosedProjectsQueue(ISharedStateContributionRegistry sharedState) {
		this.closedProjectsQueue = sharedState.getSingleContributedInstance(ClosedProjectsQueue.class);
	}
	
	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

	/**
	 * 
	 * @since 2.16
	 */
	@Singleton
	@Beta
	public static class BuilderPreferences {
		/**
		 * Name of a preference defining the scheduling rule strategy for the builder.
		 */
		public static final String PREF_SCHEDULING_RULE = "schedulingrule"; //$NON-NLS-1$
		
		private SchedulingOption schedulingOption;
		
		public BuilderPreferences () {
			IPreferenceStore preferenceStore = new ScopedPreferenceStore(InstanceScope.INSTANCE,
					Activator.PLUGIN_ID);

			String schedulingRuleName = preferenceStore.getString(PREF_SCHEDULING_RULE);
			if (schedulingRuleName.isEmpty()) {
				schedulingOption = SchedulingOption.WORKSPACE;
			} else {
				schedulingOption = SchedulingOption.valueOf(schedulingRuleName);
			}
			
			preferenceStore.addPropertyChangeListener(e -> {
				if (PREF_SCHEDULING_RULE.equals(e.getProperty())) {
					schedulingOption = SchedulingOption.valueOf(e.getNewValue().toString());
				}
			});
		}
	}
	
	@Inject
	private BuilderPreferences preferences;
	
	/**
	 * Options for scheduling rules.
	 * 
	 * @since 2.16
	 */
	public static enum SchedulingOption {
		/** workspace root */ 
		WORKSPACE,
		/** all projects with Xtext nature in the workspace */
		ALL_XTEXT_PROJECTS,
		/**
		 * all projects with Xtext nature in the workspace, extended by JDTs External Folder Project
		 * @see org.eclipse.jdt.internal.core.ExternalFoldersManager
		 * */
		ALL_XTEXT_PROJECTS_AND_JDTEXTFOLDER,
		/** the currently building project */
		PROJECT,
		/** null scheduling rule */
		NULL;
	}
	
	
	/**
	 * This is a fix for https://bugs.eclipse.org/bugs/show_bug.cgi?id=459525
	 * 
	 * It turns a specific job from egit into a system job, so it won't interrupt the autobuild.
	 * 
	 */
	private final static JobChangeAdapter MAKE_EGIT_JOB_SYSTEM = new JobChangeAdapter() {
		private boolean fixedTheJob = false;
		@Override
		public void scheduled(IJobChangeEvent event) {
			if (fixedTheJob)
				return;
			Job job = event.getJob();
			if (job == null)
				return;
			Class<? extends Job> jobClazz = job.getClass();
			if (!job.isSystem() && jobClazz.getName().equals("org.eclipse.egit.core.internal.indexdiff.IndexDiffCacheEntry$5")) {
				try {
					Field field = InternalJob.class.getDeclaredField("flags");
					field.setAccessible(true);
					field.set(job, ((Integer)field.get(job)).intValue() | 0x0100 /*InternalJob.M_SYSTEM*/);
					if (log.isInfoEnabled()) {
						log.info("Made job '"+job+"' a system job.");
					}
					fixedTheJob = true;
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	};

	@SuppressWarnings("rawtypes")
	@Override
	protected IProject[] build(final int kind, Map args, IProgressMonitor monitor) throws CoreException {
		if (IBuildFlag.FORGET_BUILD_STATE_ONLY.isSet(args)) {
			forgetLastBuiltState();
			return getProject().getReferencedProjects();
		}
		Job.getJobManager().addJobChangeListener(MAKE_EGIT_JOB_SYSTEM);
		long startTime = System.currentTimeMillis();
		StoppedTask task = Stopwatches.forTask(String.format("XtextBuilder.build[%s]", getKindAsString(kind)));
		try {
			queuedBuildData.createCheckpoint();
			if(shouldCancelBuild(kind)) {
				throw new OperationCanceledException("Build has been interrupted");
			}
			task.start();
			if (monitor != null) {
				final String taskName = Messages.XtextBuilder_Building + getProject().getName() + ": "; //$NON-NLS-1$
				monitor = new ProgressMonitorWrapper(monitor) {
					@Override
					public void subTask(String name) {
						super.subTask(taskName + name);
					}
					
					@Override
					public boolean isCanceled() {
						boolean shouldCancelBuild = shouldCancelBuild(kind);
						if (shouldCancelBuild)
							buildLogger.log("interrupted");
						return shouldCancelBuild || super.isCanceled();
					}
				};
			}
			SubMonitor progress = SubMonitor.convert(monitor, 1);
			if (kind == FULL_BUILD) {
				fullBuild(progress.split(1), IBuildFlag.RECOVERY_BUILD.isSet(args));
			} else {
				IResourceDelta delta = getDelta(getProject());
				if (delta == null || isOpened(delta)) {
					fullBuild(progress.split(1), IBuildFlag.RECOVERY_BUILD.isSet(args));
				} else {
					incrementalBuild(delta, progress.split(1));
				}
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
			throw e;
		} catch (OperationCanceledException e) {
			handleCanceled(e);
		} catch (OperationCanceledError err) {
			handleCanceled(err);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			buildLogger.log(e.getClass().getSimpleName() + " while building " + getProject().getName() + ": " + e.getMessage() + " (see logs for details)");
			forgetLastBuiltState();
		} finally {
			queuedBuildData.discardCheckpoint();
			if (monitor != null)
				monitor.done();
			String message = "Build " + getProject().getName() + " in " + (System.currentTimeMillis() - startTime) + " ms";
			log.info(message);
			buildLogger.log(message);
			task.stop();
			Job.getJobManager().removeJobChangeListener(MAKE_EGIT_JOB_SYSTEM);
		}
		return getProject().getReferencedProjects();
	}

	private boolean shouldCancelBuild(int buildKind) {
		return buildKind == IncrementalProjectBuilder.AUTO_BUILD && isInterrupted();
	}

	private void handleCanceled(Throwable t) {
		// If the cancelation happens due to an external interruption, don't pass an 
		// OperationCanceledException on to the BuildManager as it would force a full 
		// build in the next round. Instead, save the resource deltas to be reprocessed 
		// next time.
		// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=454716
		if(!isInterrupted())
			operationCanceledManager.propagateIfCancelException(t);
		buildLogger.log("Build interrupted.");
		queuedBuildData.rollback();
		rememberLastBuiltState();
	}
	
	private String getKindAsString(int kind) {
		if (kind == FULL_BUILD) {
			return "FULL";
		}
		if (kind == CLEAN_BUILD) {
			return "CLEAN";
		}
		if (kind == INCREMENTAL_BUILD) {
			return "INCREMENTAL";
		}
		if (kind == AUTO_BUILD) {
			return "AUTO";
		}
		return "UNKOWN:" + kind;
	}

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	protected void incrementalBuild(IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
		final SubMonitor progress = SubMonitor.convert(monitor, Messages.XtextBuilder_CollectingResources, 10);
		progress.subTask(Messages.XtextBuilder_CollectingResources);
		
		if (queuedBuildData.needRebuild(getProject())) {
			needRebuild();
		}

		final ToBeBuilt toBeBuilt = new ToBeBuilt();
		IResourceDeltaVisitor visitor = createDeltaVisitor(toBeBuiltComputer, toBeBuilt, progress);
		delta.accept(visitor);

		if (progress.isCanceled()) {
			throw new OperationCanceledException();
		}
		progress.worked(2);
		Task task = closedProjectsQueue.exhaust();
		try {
			addInfosFromTaskAndBuild(task, toBeBuilt, BuildType.INCREMENTAL, progress.split(8));
		} catch(Exception e) {
			task.reschedule();
			throw e;
		}
	}

	@Deprecated
	private static Boolean mustCallDeprecatedDoBuild = null;
	@Deprecated
	private static boolean wasDeprecationWarningLoggedForBuild = false;
	
	/**
	 * @since 2.18
	 */
	protected void addInfosFromTaskAndBuild(Task task, ToBeBuilt toBeBuilt, BuildType buildType, IProgressMonitor monitor)
			throws CoreException {
		addInfosFromTask(task, toBeBuilt);
		if (XtextBuilder.class.equals(getClass())) {
			doBuild(toBeBuilt, task.getProjectNames(), monitor, buildType);	
		} else {
			if (mustCallDeprecatedDoBuild == null) {
				mustCallDeprecatedDoBuild = isDoBuildSpecialized(getClass());
				if (mustCallDeprecatedDoBuild.booleanValue() && !wasDeprecationWarningLoggedForBuild) {
					log.warn("XtextBuilder is specialized and overrides the deprecated method doBuild(..). The implementation should be adjusted.");
					wasDeprecationWarningLoggedForBuild = true;
				}
			}
			if (mustCallDeprecatedDoBuild.booleanValue()) {
				doBuild(toBeBuilt, monitor, buildType);
			} else {
				doBuild(toBeBuilt, task.getProjectNames(), monitor, buildType);
			}
		}
	}

	/**
	 * @since 2.18
	 * @deprecated This method is present for backwards compatibility reasons and will be removed in a future release.
	 */
	@Deprecated
	protected boolean isDoBuildSpecialized(Class<?> c) {
		return isMethodSpecialized(c, "doBuild", ToBeBuilt.class, IProgressMonitor.class, BuildType.class);
	}

	/**
	 * @since 2.18
	 */
	protected void addInfosFromTask(Task task, final ToBeBuilt toBeBuilt) {
		toBeBuilt.getToBeDeleted().addAll(task.getToBeBuilt().getToBeDeleted());
		toBeBuilt.getToBeUpdated().addAll(task.getToBeBuilt().getToBeUpdated());
	}
	
	/**
	 * @deprecated call {@link #doBuild(ToBeBuilt, Set, IProgressMonitor, BuildType)} instead.
	 */
	@Deprecated
	protected void doBuild(ToBeBuilt toBeBuilt, IProgressMonitor monitor, BuildType type) throws CoreException {
		doBuild(toBeBuilt, ImmutableSet.of(), monitor, type);
	}
	
	/**
	 * @param toBeBuilt
	 *            the URIs that will be processed in this build run.
	 * @param removedProjects
	 *            the projects that are no longer considered by XtextBuilders but are yet to be removed from the index.
	 * @param monitor
	 *            the progress monitor for the build.
	 * @param type
	 *            indicates the kind of build that is running.
	 * 
	 * @since 2.18
	 */
	protected void doBuild(ToBeBuilt toBeBuilt, Set<String> removedProjects, IProgressMonitor monitor, BuildType type) throws CoreException {
		buildLogger.log("Building " + getProject().getName());
		// return early if there's nothing to do.
		// we reuse the isEmpty() impl from BuildData assuming that it doesnT access the ResourceSet which is still null 
		// and would be expensive to create.
		boolean indexingOnly = type == BuildType.RECOVERY;
		if (new BuildData(getProject().getName(), null, toBeBuilt, queuedBuildData, indexingOnly, this::needRebuild, removedProjects).isEmpty())
			return;
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		ResourceSet resourceSet = getResourceSetProvider().get(getProject());
		resourceSet.getLoadOptions().put(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);
		BuildData buildData = new BuildData(getProject().getName(), resourceSet, toBeBuilt, queuedBuildData, indexingOnly, this::needRebuild, removedProjects);
		ImmutableList<Delta> deltas = builderState.update(buildData, progress.split(1));
		if (participant != null && !indexingOnly) {
			SourceLevelURICache sourceLevelURIs = buildData.getSourceLevelURICache();
			Set<URI> sources = sourceLevelURIs.getSources();
			participant.build(new BuildContext(this, resourceSet, deltas, sources, type),
					progress.split(1));
			try {
				getProject().getWorkspace().checkpoint(false);
			} catch(NoClassDefFoundError e) { // guard against broken Eclipse installations / bogus project configuration
				log.error(e.getMessage(), e);
			}
		} else {
			progress.worked(1);
		}
		resourceSet.eSetDeliver(false);
		for (Resource resource : resourceSet.getResources()) {
			resource.eSetDeliver(false);
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
		SubMonitor progress = SubMonitor.convert(monitor, 10);

		IProject project = getProject();
		ToBeBuilt toBeBuilt = 
			isRecoveryBuild
				? toBeBuiltComputer.updateProjectNewResourcesOnly(project, progress.split(2)) 
				: toBeBuiltComputer.updateProject(project, progress.split(2));
				

		Task task = closedProjectsQueue.exhaust();
		try {
			addInfosFromTaskAndBuild(task, toBeBuilt, isRecoveryBuild
					? BuildType.RECOVERY 
					: BuildType.FULL, progress.split(8));
		} catch(Exception e) {
			task.reschedule();
			throw e;
		}
	}
	
	/**
	 * Creates a visitor that is used to traverse the information that is obtained from {@link #getDelta(IProject)}. It
	 * accumulates its findings in the given <code>toBeBuilt</code>.
	 */
	protected IResourceDeltaVisitor createDeltaVisitor(ToBeBuiltComputer toBeBuiltComputer, ToBeBuilt toBeBuilt,
			final SubMonitor progress) {
		IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
			@Override
			public boolean visit(IResourceDelta delta) throws CoreException {
				if (progress.isCanceled())
					throw new OperationCanceledException();
				if (delta.getResource() instanceof IProject) {
					return true;
				}
				if (delta.getResource() instanceof IStorage) {
					if (delta.getKind() == IResourceDelta.REMOVED) {
						return toBeBuiltComputer.removeStorage(null, toBeBuilt, (IStorage) delta.getResource());
					} else if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED) {
						return toBeBuiltComputer.updateStorage(null, toBeBuilt, (IStorage) delta.getResource());
					}
				}
				return true;
			}
		};
		return visitor;
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
		SubMonitor progress = SubMonitor.convert(monitor, 10);
		try {
			ToBeBuilt toBeBuilt = toBeBuiltComputer.removeProject(getProject(), progress.split(2));
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			Task task = closedProjectsQueue.exhaust();
			try {
				addInfosFromTaskAndClean(toBeBuilt, task, progress.split(8));
			} catch(Exception e) {
				task.reschedule();
				throw e;
			}
		} finally {
			if (monitor != null)
				monitor.done();
		}
	}

	@Deprecated
	private static Boolean mustCallDeprecatedDoClean = null;
	@Deprecated
	private static boolean wasDeprecationWarningLoggedForClean = false;
	
	protected void addInfosFromTaskAndClean(ToBeBuilt toBeBuilt, Task task, IProgressMonitor monitor) throws CoreException {
		addInfosFromTask(task, toBeBuilt);
		if (XtextBuilder.class.equals(getClass())) {
			doClean(toBeBuilt, task.getProjectNames(), monitor);
		} else {
			if (mustCallDeprecatedDoClean == null) {
				mustCallDeprecatedDoClean = isDoCleanSpecialized(getClass());
				if (mustCallDeprecatedDoClean.booleanValue() && !wasDeprecationWarningLoggedForClean) {
					log.warn("XtextBuilder is specialized and overrides the deprecated method doClean(..). The implementation should be adjusted.");
					wasDeprecationWarningLoggedForClean = true;
				}
			}
			if (mustCallDeprecatedDoClean.booleanValue()) {
				doClean(toBeBuilt, monitor);
			} else {
				doClean(toBeBuilt, task.getProjectNames(), monitor);
			}
		}
	}
	
	/**
	 * @since 2.18
	 * @deprecated This method is present for backwards compatibility reasons and will be removed in a future release.
	 */
	@Deprecated
	protected boolean isDoCleanSpecialized(Class<?> c) {
		return isMethodSpecialized(c, "doClean", ToBeBuilt.class, IProgressMonitor.class);
	}

	private boolean isMethodSpecialized(Class<?> subclassOfBuilder, String name, Class<?>... parameterTypes) {
		try {
			// if the method is not present, we'll go into the catch clause
			subclassOfBuilder.getDeclaredMethod(name, parameterTypes);
			return !XtextBuilder.class.equals(subclassOfBuilder);
		} catch (Exception e) {
			Class<?> superclass = subclassOfBuilder.getSuperclass();
			if (superclass == null) {
				return false;
			}
			return isDoCleanSpecialized(superclass);
		}
	}

	/**
	 * @deprecated call {@link #doClean(ToBeBuilt, Set, IProgressMonitor)} instead.
	 */
	@Deprecated
	protected void doClean(ToBeBuilt toBeBuilt, IProgressMonitor monitor) throws CoreException {
		doClean(toBeBuilt, ImmutableSet.of(), monitor);
	}
	
	protected void doClean(ToBeBuilt toBeBuilt, Set<String> removedProjects, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		SetWithProjectNames toBeDeletedAndProjects = new SetWithProjectNames(toBeBuilt.getToBeDeleted(), getProject().getName(), removedProjects);
		ImmutableList<Delta> deltas = builderState.clean(toBeDeletedAndProjects, progress.split(1));
		if (participant != null) {
			Set<URI> sourceURIs = new SourceLevelURICache().getSourcesFrom(toBeBuilt.getToBeDeleted(), resourceServiceProvideRegistry);
			
			participant.build(new BuildContext(this, 
					getResourceSetProvider().get(getProject()), 
					deltas,
					sourceURIs,
					BuildType.CLEAN), 
					progress.split(1));
		} else {
			progress.worked(1);
		}
	}

	@Override
	public ISchedulingRule getRule(int kind, Map<String, String> args) {
		switch (preferences.schedulingOption) {
			case NULL: return null;
			case WORKSPACE: return getProject().getWorkspace().getRoot();
			case PROJECT: return getProject();
			case ALL_XTEXT_PROJECTS: return new MultiRule(Arrays.stream(
					getProject().getWorkspace().getRoot().getProjects())
					.filter(XtextProjectHelper::hasNature)
					.toArray(ISchedulingRule[]::new));
			case ALL_XTEXT_PROJECTS_AND_JDTEXTFOLDER: return new MultiRule(Arrays.stream(
					getProject().getWorkspace().getRoot().getProjects())
					.filter(p->
						XtextProjectHelper.hasNature(p)
						|| EXTERNAL_PROJECT_NAME.equals(p.getName())
					)
					.toArray(ISchedulingRule[]::new));
			default: throw new IllegalArgumentException();
		}
	}

}
