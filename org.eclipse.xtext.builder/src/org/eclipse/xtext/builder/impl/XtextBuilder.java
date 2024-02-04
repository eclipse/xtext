/*******************************************************************************
 * Copyright (c) 2009, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
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
import org.osgi.framework.Version;

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

	private static final Version VERSION_3_17_0 = new Version(3,17,0);

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
	
	/**
	 * @since 2.19
	 */
	private Set<IProject> interestingProjects = Collections.emptySet();
	
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
		@SuppressWarnings("restriction")
		ALL_XTEXT_PROJECTS_AND_JDTEXTFOLDER,
		/** the currently building project */
		PROJECT,
		/** null scheduling rule */
		NULL;
	}
	
	/**
	 * Used to reflectively set the flag that will instruct the Eclipse infrastructure to also
	 * consider this builder if the delta is empty. An XtextBuilder might need to run a build even
	 * if no resource changes have been recorded, e.g. if the index wasn't deserialized successfully
	 * but the workspace state is still consistent from Eclipse's POV.
	 * 
	 * @since 2.26
	 */
	private static final Field callOnEmptyData;
	static {
		try {
			@SuppressWarnings("restriction")
			Field fld = org.eclipse.core.internal.events.InternalBuilder.class.getDeclaredField("callOnEmptyDelta");
			fld.setAccessible(true);
			callOnEmptyData = fld;
		} catch (ReflectiveOperationException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * True if the next regular build (not a clean build) that will be executed, will be treated as a full build request.
	 * 
	 * @since 2.26
	 */
	private boolean nextBuildIsFullBuild = false;
	
	/**
	 * True if a regular request for a full build from an external service is allowed.
	 * 
	 * @since 2.26
	 */
	private boolean allowRequestFullBuild = true;
	
	/**
	 * The lock protects against concurrent access to the boolean flags {@link #nextBuildIsFullBuild} and {@link #allowRequestFullBuild}.
	 * 
	 * @since 2.26
	 */
	private final Object requestFullBuildLock = new Object();
	
	/**
	 * An external (to this builder and the Eclipse BuildManager) service may want to trigger an initial
	 * full build for this project if it was detected that the project state is not in sync with the builder
	 * state. This can be done once in the life-cycle of an XtextBuilder which is bound to an IProject or, if {@code force} 
	 * is set to true, when a configuration change to the project happened that warrants a full build.
	 * 
	 * @since 2.26
	 */
	protected void requestFullBuild(boolean force) {
		/*
		 * Synchronize here to avoid a build being triggered while a build was running and completed successfully.
		 * Maintaining the flags must be coherent.
		 */
		synchronized (requestFullBuildLock) {
			if (allowRequestFullBuild || force) {
				allowRequestFullBuild = false;
				nextBuildIsFullBuild = true;
				try {
					callOnEmptyData.set(this, true);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					log.error(e.getMessage(), e);
				}
				BuildManagerAccess.scheduleAutoBuild();
			}
		}
	}
	
	/**
	 * Answer if a full build was already requested externally and not yet done.
	 * 
	 * @since 2.26
	 */
	protected boolean wasFullBuildRequested() {
		synchronized (requestFullBuildLock) {
			return nextBuildIsFullBuild;
		}
	}
	
	/**
	 * After a full build was run, reset the externally requested full build.
	 * Don't reset, if the current build was an incremental build but a full build was requested
	 * in the meantime.
	 * 
	 * @since 2.26
	 */
	protected void unsetWasFullBuildRequested(boolean wasFullBuildRequested) {
		synchronized (requestFullBuildLock) {
			if (nextBuildIsFullBuild && !wasFullBuildRequested) {
				// an intermediate operation requested an enforced full build, e.g. due to a class-path change
				// make the next build a full build
				return;
			}
			allowRequestFullBuild = false;
			nextBuildIsFullBuild = false;
			try {
				callOnEmptyData.set(this, false);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * Attempt to access the builder state. If it wasn't loaded yet, an attempt to load it is made.
	 * This may trigger the {@link BuilderStateDiscarder#forgetLastBuildState(Iterable, Map)} if there
	 * is no build state available.
	 * Since we are currently building this project, we turn the current build into a full build if it
	 * was an auto build or an incremental build instead. 
	 * 
	 * @since 2.26
	 */
	protected void ensureBuilderStateLoaded() {
		// ensure the state was loaded or load it now or wait until it was successfully loaded
		builderState.isEmpty();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		ensureBuilderStateLoaded();
		
		boolean wasFullBuildRequested = wasFullBuildRequested();
		if (!wasFullBuildRequested && IBuildFlag.FORGET_BUILD_STATE_ONLY.isSet(args)) {
			forgetLastBuiltState();
			return getReferencedProjects();
		}
		int effectiveKind = wasFullBuildRequested ? FULL_BUILD : kind;
		
		long startTime = System.currentTimeMillis();
		StoppedTask task = Stopwatches.forTask(String.format("XtextBuilder.build[%s]", getKindAsString(effectiveKind)));
		try {
			queuedBuildData.createCheckpoint();
			if(shouldCancelBuild(effectiveKind)) {
				buildLogger.log("interrupted");
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
						boolean shouldCancelBuild = shouldCancelBuild(effectiveKind);
						if (shouldCancelBuild)
							buildLogger.log("interrupted");
						return shouldCancelBuild || super.isCanceled();
					}
				};
			}
			SubMonitor progress = SubMonitor.convert(monitor, 1);
			if (effectiveKind == FULL_BUILD) {
				fullBuild(progress.split(1), !wasFullBuildRequested && IBuildFlag.RECOVERY_BUILD.isSet(args));
			} else {
				IResourceDelta delta = getDelta(getProject());
				if (delta == null || isOpened(delta)) {
					fullBuild(progress.split(1), IBuildFlag.RECOVERY_BUILD.isSet(args));
				} else {
					incrementalBuild(delta, progress.split(1));
				}
			}
			// If no exceptions have been thrown, fix the information about the requested full builds
			unsetWasFullBuildRequested(wasFullBuildRequested);
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
			String message = "Built " + getProject().getName() + " in " + (System.currentTimeMillis() - startTime) + " ms";
			log.info(message);
			buildLogger.log(message);
			task.stop();
		}
		return getReferencedProjects();
	}

	/**
	 * @since 2.19
	 */
	protected IProject[] getReferencedProjects() throws CoreException {
		interestingProjects = toBeBuiltComputer.getInterestingProjects(getProject());
		return interestingProjects.toArray(new IProject[0]); 
	}
	
	/**
	 * @since 2.19
	 */
	protected final Set<IProject> getInternalInterestingProjects() {
		return interestingProjects;
	}

	private boolean shouldCancelBuild(int buildKind) {
		return buildKind == IncrementalProjectBuilder.AUTO_BUILD && isInterrupted();
	}

	private void handleCanceled(Throwable t) {
		// If the cancellation happens due to an external interruption, don't pass an 
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
		
		pollQueuedBuildData();

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
		// we reuse the isEmpty() implementation from BuildData assuming that it doesnT access the ResourceSet which is still null 
		// and would be expensive to create.
		boolean indexingOnly = type == BuildType.RECOVERY;
		if (new BuildData(getProject().getName(), null, toBeBuilt, queuedBuildData, indexingOnly, this::triggerRequestProjectRebuild, removedProjects).isEmpty())
			return;
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		ResourceSet resourceSet = getResourceSetProvider().get(getProject());
		resourceSet.getLoadOptions().put(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);
		BuildData buildData = new BuildData(getProject().getName(), resourceSet, toBeBuilt, queuedBuildData, indexingOnly, this::triggerRequestProjectRebuild, removedProjects);
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

		pollQueuedBuildData();
		
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
				} else if (delta.getResource() instanceof IFolder) {
					return toBeBuiltComputer.isHandled((IFolder) delta.getResource());
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
			unsetWasFullBuildRequested(true);
		} finally {
			if (monitor != null)
				monitor.done();
		}
	}

	@Deprecated
	private static Boolean mustCallDeprecatedDoClean = null;
	@Deprecated
	private static boolean wasDeprecationWarningLoggedForClean = false;

	private Method requestProjectRebuildMethod;
	private Method requestProjectsRebuildMethod;

	private static Version installedCoreResourcesVersion;
	
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
	 * @since 2.19
	 */
	protected void pollQueuedBuildData() {
		if (pollQueuedBuildData(getProject())) {
			triggerRequestProjectRebuild();
		}
		for(IProject project: interestingProjects) {
			if (!XtextProjectHelper.hasNature(project)) {
				if (pollQueuedBuildData(project)) {
					triggerRequestProjectsRebuild(project);
				}	
			}
		}
	}
	
	/**
	 * @since 2.19
	 */
	protected boolean pollQueuedBuildData(IProject project) {
		return queuedBuildData.needRebuild(project);
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
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 * @deprecated call {@link #doClean(ToBeBuilt, Set, IProgressMonitor)} instead.
	 */
	@Deprecated
	protected void doClean(ToBeBuilt toBeBuilt, IProgressMonitor monitor) throws CoreException {
		doClean(toBeBuilt, ImmutableSet.of(), monitor);
	}
	
	/**
	 * 
	 * @param toBeBuilt the collected URIs that should be handled by this clean operation.
	 * @param removedProjects additional projects that were available but do no longer have the Xtext nature or have been deleted
	 * 
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
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
	
	/**
	 * @since 2.27
	 */
	public void triggerRequestProjectRebuild() {
		if (requestProjectRebuildMethod != null || isCoreResourceGreaterOrEqual(VERSION_3_17_0)) {
			try {
				if (requestProjectRebuildMethod == null) {
					requestProjectRebuildMethod = getClass().getMethod("requestProjectRebuild", Boolean.TYPE);
				}
				requestProjectRebuildMethod.invoke(this, true);
			} catch (Exception e) {
				log.error("something went wrong in triggerRequestProjectRebuild", e);
				needRebuild();
			}
		} else {
			needRebuild();
		}
	}
	
	/**
	 * @since 2.27
	 */
	public void triggerRequestProjectsRebuild(IProject project) {
		if (requestProjectsRebuildMethod != null || isCoreResourceGreaterOrEqual(VERSION_3_17_0)) {
			try {
				if (requestProjectsRebuildMethod == null) {
					requestProjectsRebuildMethod = getClass().getMethod("requestProjectsRebuild", Collection.class);
				}
				requestProjectsRebuildMethod.invoke(this, Collections.singletonList(project));
			} catch (Exception e) {
				log.error("something went wrong in triggerRequestProjectRebuild", e);
				needRebuild();
			}
		} else {
			needRebuild();
		}
	}
	
	private static boolean isCoreResourceGreaterOrEqual(Version version) {
		if (installedCoreResourcesVersion == null) {
			installedCoreResourcesVersion = ResourcesPlugin.getPlugin().getBundle().getVersion();
		}
		return installedCoreResourcesVersion.compareTo(version) >= 0;
	}
	
	/**
	 * @since 2.32
	 */
	protected ToBeBuiltComputer getToBeBuiltComputer() {
		return toBeBuiltComputer;
	}

}
