package org.eclipse.xtext.builder;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;
import static org.eclipse.xtext.ui.util.ResourceUtil.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.DerivedResourceMarkers.GeneratorIdProvider;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfiguration.SourceMapping;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

import com.google.common.base.Function;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 * @since 2.7
 */
public class ParallelBuilderParticipant implements IXtextBuilderParticipant {

	private final static Logger logger = Logger.getLogger(BuilderParticipant.class);

	@Inject
	private Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider;

	@Inject
	private IGenerator generator;

	@Inject
	private IResourceServiceProvider resourceServiceProvider;

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	private IDerivedResourceMarkers derivedResourceMarkers;

	@Inject
	private GeneratorIdProvider generatorIdProvider;

	private EclipseOutputConfigurationProvider outputConfigurationProvider;
	private BuilderPreferenceAccess builderPreferenceAccess;

	/**
	 * @since 2.4
	 */
	protected IDerivedResourceMarkers getDerivedResourceMarkers() {
		return derivedResourceMarkers;
	}

	/**
	 * @since 2.4
	 */
	protected GeneratorIdProvider getGeneratorIdProvider() {
		return generatorIdProvider;
	}

	/**
	 * @nooverride This method is not intended to be re-implemented or extended by
	 *             clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public BuilderPreferenceAccess getBuilderPreferenceAccess() {
		return builderPreferenceAccess;
	}

	/**
	 * @nooverride This method is not intended to be re-implemented or extended by
	 *             clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Inject
	public void setBuilderPreferenceAccess(BuilderPreferenceAccess builderPreferenceAccess) {
		this.builderPreferenceAccess = builderPreferenceAccess;
	}

	public EclipseOutputConfigurationProvider getOutputConfigurationProvider() {
		return outputConfigurationProvider;
	}

	/**
	 * @since 2.2
	 */
	public IGenerator getGenerator() {
		return generator;
	}

	/**
	 * @since 2.2
	 */
	public IResourceServiceProvider getResourceServiceProvider() {
		return resourceServiceProvider;
	}

	@Inject
	public void setOutputConfigurationProvider(EclipseOutputConfigurationProvider outputConfigurationProvider) {
		this.outputConfigurationProvider = outputConfigurationProvider;
	}

	/**
	 * @since 2.4
	 */
	protected Map<OutputConfiguration, Iterable<IMarker>> getGeneratorMarkers(IProject builtProject, Collection<OutputConfiguration> outputConfigurations)
	    throws CoreException {
		Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers = newHashMap();
		for (OutputConfiguration config : outputConfigurations) {
			if (config.isCleanUpDerivedResources()) {
				IContainer container = getContainer(builtProject, config.getOutputDirectory());
				final Iterable<IMarker> markers = derivedResourceMarkers.findDerivedResourceMarkers(container, generatorIdProvider.getGeneratorIdentifier());
				generatorMarkers.put(config, markers);
			}
		}
		return generatorMarkers;
	}

	public void build(final IBuildContext context, IProgressMonitor monitor) throws CoreException {
		if (!isEnabled(context)) {
			return;
		}

		final List<IResourceDescription.Delta> deltas = getRelevantDeltas(context);
		if (deltas.isEmpty()) {
			return;
		}

//		Stopwatches.setEnabled(true);
//		StoppedTask buildTask = Stopwatches.forTask("com.bosch.amf.apl.builder.ParallelBuilderParticipant.build(IBuildContext, IProgressMonitor)");
//		try {
//		buildTask.start();
		// monitor handling
		if (monitor.isCanceled())
			throw new OperationCanceledException();
		SubMonitor subMonitor = SubMonitor.convert(monitor, 3);

		EclipseResourceFileSystemAccess2 access = fileSystemAccessProvider.get();
		final IProject builtProject = context.getBuiltProject();
		access.setProject(builtProject);
		final Map<String, OutputConfiguration> outputConfigurations = getOutputConfigurations(context);
		refreshOutputFolders(context, outputConfigurations, subMonitor.newChild(1));
		access.setOutputConfigurations(outputConfigurations);
		if (context.getBuildType() == BuildType.CLEAN || context.getBuildType() == BuildType.RECOVERY) {
			SubMonitor cleanMonitor = SubMonitor.convert(subMonitor.newChild(1), outputConfigurations.size());
			for (OutputConfiguration config : outputConfigurations.values()) {
				cleanOutput(context, config, cleanMonitor.newChild(1));
			}
			if (context.getBuildType() == BuildType.CLEAN)
				return;
		}

		Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers = getGeneratorMarkers(builtProject, outputConfigurations.values());

		List<Future<?>> futures = newArrayList();
		ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryBuilder().setNameFormat("ParallelGenerator-%d").build());

		BlockingQueue<Pair<IResourceDescription.Delta, Procedure2<? super IFileSystemAccess, ? super IProgressMonitor>>> requestQueue = newLinkedBlockingQueue(50);

		for (IResourceDescription.Delta delta : deltas) {
			if (delta.getNew() != null) {
				try {
					Runnable runnable = createRunnable(delta, context, outputConfigurations, generatorMarkers, requestQueue);
					if (runnable != null) {
						Future<?> future = executorService.submit(runnable);
						futures.add(future);
					}
				} catch (Exception e) {
					logErrorDuringCompilation(delta, e);
				}
			}
		}

		subMonitor.subTask("Compiling...");
		access.setMonitor(subMonitor.newChild(1));

		boolean interrupted = false;
		try {
			while (!requestQueue.isEmpty() || !removeDone(futures).isEmpty()) {
				if (subMonitor.isCanceled() && !executorService.isShutdown()) {
					executorService.shutdownNow();
				}

				Delta delta = null;
				try {
					Pair<Delta, Procedure2<? super IFileSystemAccess, ? super IProgressMonitor>> pair = requestQueue.poll(500, TimeUnit.MILLISECONDS);
					if (pair != null) {
						delta = pair.getKey();
						pair.getValue().apply(access, subMonitor);
					}
				} catch (InterruptedException e) {
					interrupted = true;
				} catch (OperationCanceledException e) {

				} catch (Exception e) {
					logErrorDuringCompilation(delta, e);
				}
			}
		} finally {
			if (interrupted) {
				Thread.currentThread().interrupt();
			}
		}

		if (subMonitor.isCanceled()) {
			throw new OperationCanceledException();
		}
//		} finally {
//			buildTask.stop();
//			System.out.println(Stopwatches.getPrintableStopwatchData());
//		}
	}

	protected Runnable createRunnable(final IResourceDescription.Delta delta, final IBuildContext context,
	    final Map<String, OutputConfiguration> outputConfigurations, final Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers,
	    final BlockingQueue<Pair<IResourceDescription.Delta, Procedure2<? super IFileSystemAccess, ? super IProgressMonitor>>> requestQueue) {
		final Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		if (shouldGenerate(resource, context)) {
			return new Runnable() {

				public void run() {
					try {
						final Set<IFile> derivedResources = newLinkedHashSet();

						final String uri = delta.getUri().toString();
						for (OutputConfiguration config : outputConfigurations.values()) {
							if (config.isCleanUpDerivedResources()) {
								Iterable<IMarker> markers = generatorMarkers.get(config);
								for (IMarker marker : markers) {
									String source = derivedResourceMarkers.getSource(marker);
									if (source != null && source.equals(uri))
										derivedResources.add((IFile) marker.getResource());
								}
							}
						}
						
						String currentSourceFolder = getCurrentSourceFolder(context, delta);
						FileSystemAccessQueue fileSystemAccessQueue = new FileSystemAccessQueue(requestQueue);
						generator.doGenerate(resource, new ParallelFileSystemAccess(delta, fileSystemAccessQueue, currentSourceFolder, new EclipseResourceFileSystemAccess2.IFileCallback() {

							public boolean beforeFileDeletion(IFile file) {
								derivedResources.remove(file);
								context.needRebuild();
								return true;
							}

							public void afterFileUpdate(IFile file) {
								handleFileAccess(file);
							}

							public void afterFileCreation(IFile file) {
								handleFileAccess(file);
							}

							protected void handleFileAccess(IFile file) {
								try {
									derivedResources.remove(file);
									derivedResourceMarkers.installMarker(file, uri);
									context.needRebuild();
								} catch (CoreException e) {
									throw new RuntimeException(e);
								}
							}

						}));

						fileSystemAccessQueue.put(delta, new Procedure2<IFileSystemAccess, IProgressMonitor>() {

							public void apply(IFileSystemAccess access, IProgressMonitor deleteMonitor) {
								try {
									if (access instanceof EclipseResourceFileSystemAccess2) {
										EclipseResourceFileSystemAccess2 eclipseAccess = (EclipseResourceFileSystemAccess2) access;
										eclipseAccess.flushSourceTraces();
										for (IFile iFile : newLinkedHashSet(derivedResources)) {
											IMarker marker = derivedResourceMarkers.findDerivedResourceMarker(iFile, uri);
											if (marker != null)
												marker.delete();
											if (derivedResourceMarkers.findDerivedResourceMarkers(iFile).length == 0) {
												eclipseAccess.deleteFile(iFile, deleteMonitor);
												context.needRebuild();
											}
										}
									}
								} catch (CoreException e) {
									throw new RuntimeException(e);
								}
							}

						});
					} catch (Throwable e) {
						logErrorDuringCompilation(delta, e);
					}
				}

			};
		}
		return null;
	}

	protected List<Future<?>> removeDone(List<Future<?>> futures) {
		Iterator<Future<?>> iterator = futures.iterator();
		while (iterator.hasNext()) {
			Future<?> future = iterator.next();
			if (!future.isDone()) {
				return futures;
			}
			iterator.remove();
		}
		return futures;
	}

	/**
	 * @since 2.6
	 */
	protected String getCurrentSourceFolder(IBuildContext context, Delta delta) {
		Iterable<org.eclipse.xtext.util.Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(delta.getUri());
		for (org.eclipse.xtext.util.Pair<IStorage, IProject> pair : storages) {
			final IResource resource = (IResource) pair.getFirst();
			IProject project = pair.getSecond();
			for (OutputConfiguration output : getOutputConfigurations(context).values()) {
				for (SourceMapping sourceMapping : output.getSourceMappings()) {
					IContainer folder = ResourceUtil.getContainer(project, sourceMapping.getSourceFolder());
					if (folder.contains(resource)) {
						return sourceMapping.getSourceFolder();
					}
				}
			}
		}
		return null;
	}

	protected boolean isEnabled(final IBuildContext context) {
		return builderPreferenceAccess.isAutoBuildEnabled(context.getBuiltProject());
	}

	/**
	 * @since 2.3
	 */
	protected List<IResourceDescription.Delta> getRelevantDeltas(IBuildContext context) {
		List<IResourceDescription.Delta> result = newArrayList();
		for (IResourceDescription.Delta delta : context.getDeltas()) {
			if (resourceServiceProvider.canHandle(delta.getUri()))
				result.add(delta);
		}
		return result;
	}

	protected void refreshOutputFolders(IBuildContext ctx, Map<String, OutputConfiguration> outputConfigurations, IProgressMonitor monitor) throws CoreException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, outputConfigurations.size());
		for (OutputConfiguration config : outputConfigurations.values()) {
			SubMonitor child = subMonitor.newChild(1);
			final IProject project = ctx.getBuiltProject();
			IContainer container = getContainer(project, config.getOutputDirectory());
			container.refreshLocal(IResource.DEPTH_INFINITE, child);
		}
	}

	protected void cleanOutput(IBuildContext ctx, OutputConfiguration config, IProgressMonitor monitor) throws CoreException {
		final IProject project = ctx.getBuiltProject();
		IContainer container = getContainer(project, config.getOutputDirectory());
		if (!container.exists()) {
			return;
		}
		if (config.isCanClearOutputDirectory()) {
			for (IResource resource : container.members()) {
				resource.delete(IResource.KEEP_HISTORY, monitor);
			}
		} else if (config.isCleanUpDerivedResources()) {
			List<IFile> resources = derivedResourceMarkers.findDerivedResources(container, null);
			for (IFile iFile : resources) {
				iFile.delete(IResource.KEEP_HISTORY, monitor);
			}
		}
	}

	protected boolean shouldGenerate(Resource resource, IBuildContext context) {
		try {
			Iterable<org.eclipse.xtext.util.Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(resource.getURI());
			for (org.eclipse.xtext.util.Pair<IStorage, IProject> pair : storages) {
				if (pair.getFirst() instanceof IFile && pair.getSecond().equals(context.getBuiltProject())) {
					IFile file = (IFile) pair.getFirst();
					return file.findMaxProblemSeverity(null, true, IResource.DEPTH_INFINITE) != IMarker.SEVERITY_ERROR;
				}
			}
			return false;
		} catch (CoreException exc) {
			throw new WrappedException(exc);
		}
	}

	protected Map<String, OutputConfiguration> getOutputConfigurations(IBuildContext context) {
		Set<OutputConfiguration> configurations = outputConfigurationProvider.getOutputConfigurations(context.getBuiltProject());
		return uniqueIndex(configurations, new Function<OutputConfiguration, String>() {
			public String apply(OutputConfiguration from) {
				return from.getName();
			}
		});
	}

	protected void logErrorDuringCompilation(final IResourceDescription.Delta delta, Throwable e) {
		Throwable cause = e;
		if (cause instanceof CoreException) {
			cause = cause.getCause();
		}
		if (delta == null) {
			logger.error("Error during compilation of.", e);
		} else {
			logger.error("Error during compilation of '" + delta.getUri() + "'.", e);
		}
	}

	private <E> BlockingQueue<E> newLinkedBlockingQueue(int capacity) {
		return new LinkedBlockingQueue<E>(capacity);
	}

}
