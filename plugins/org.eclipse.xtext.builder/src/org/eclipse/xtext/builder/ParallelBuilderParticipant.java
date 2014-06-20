package org.eclipse.xtext.builder;

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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2.IFileCallback;
import org.eclipse.xtext.generator.FileSystemAccessQueue;
import org.eclipse.xtext.generator.FileSystemAccessRequest;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.7
 */
public class ParallelBuilderParticipant extends BuilderParticipant {
	
	private static final int QUEUE_CAPACITY = 50;
	
	private static final int QUEUE_POLL_TIMEOUT = 50;

	@Override
	protected void handleChangedContents(Delta delta, IBuildContext context, IFileSystemAccess access)
			throws CoreException {
		Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		if (shouldGenerate(resource, context)) {
			getGenerator().doGenerate(resource, access);
		}
	}
	
	@Override
	protected void doBuild(
			List<Delta> deltas, 
			Map<String, OutputConfiguration> outputConfigurations,
			Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers, 
			IBuildContext context,
			EclipseResourceFileSystemAccess2 access, 
			IProgressMonitor progressMonitor) throws CoreException {
		BlockingQueue<FileSystemAccessRequest> requestQueue = newBlockingQueue(QUEUE_CAPACITY);
		FileSystemAccessQueue fileSystemAccessQueue = new FileSystemAccessQueue(requestQueue);
		context.getResourceSet().eAdapters().add(fileSystemAccessQueue);
		try {
			SubMonitor subMonitor = SubMonitor.convert(progressMonitor, 1);
			subMonitor.subTask("Compiling...");
			access.setMonitor(subMonitor.newChild(1));
			
			int nProcessors = Runtime.getRuntime().availableProcessors();
			int nThreads = Math.max(2, Math.min(4, nProcessors));
			ExecutorService executorService = Executors.newFixedThreadPool(nThreads, new ThreadFactoryBuilder().setNameFormat("ParallelGenerator-%d").build());
	
			for (IResourceDescription.Delta delta : deltas) {
				try {
					Runnable runnable = createRunnable(delta, context, outputConfigurations, generatorMarkers, fileSystemAccessQueue, access, subMonitor);
					executorService.execute(runnable);
				} catch (Exception e) {
					logErrorDuringCompilation(delta.getUri(), e);
				}
			}
			executorService.shutdown();
			
			List<org.eclipse.xtext.xbase.lib.Pair<URI, Throwable>> exceptions = Lists.newArrayList();
			boolean interrupted = false;
			try {
				while (!requestQueue.isEmpty() || !executorService.isTerminated()) {
					if (subMonitor.isCanceled()) {
						executorService.shutdownNow();
						throw new OperationCanceledException();
					}
	
					FileSystemAccessRequest request = null;
					try {
						request = requestQueue.poll(QUEUE_POLL_TIMEOUT, TimeUnit.MILLISECONDS);
					} catch (InterruptedException e) {
						interrupted = true;
					}
					if (request != null) {
						try {
							request.procedure.apply();
						} catch (OperationCanceledException e) {
							
						} catch (Exception e) {
							Throwable cause = e;
							if (cause instanceof CoreException) {
								cause = cause.getCause();
							}
							exceptions.add(org.eclipse.xtext.xbase.lib.Pair.of(request.uri, cause));
						}
					}
				}
			} finally {
				if (interrupted) {
					Thread.currentThread().interrupt();
				}
				for (org.eclipse.xtext.xbase.lib.Pair<URI, Throwable> exception : exceptions) {
					if (!addMarkers(exception)) {
						logErrorDuringCompilation(exception.getKey(), exception.getValue());
					}
				}
			}
		} finally {
			context.getResourceSet().eAdapters().remove(fileSystemAccessQueue);
		}
	}

	protected boolean addMarkers(org.eclipse.xtext.xbase.lib.Pair<URI, Throwable> exception) {
		boolean result = false;
		
		URI uri = exception.getKey();
		for (Pair<IStorage, IProject> storage : getStorage2UriMapper().getStorages(uri)) {
			IResource resource = null;
			if (storage.getFirst() instanceof IResource) {
				resource = (IResource) storage.getFirst();
			} else {
				resource = storage.getSecond();
			}
			if (resource != null) { 
				try {
					IMarker marker = resource.createMarker(MarkerTypes.NORMAL_VALIDATION);
					marker.setAttribute(IMarker.MESSAGE, exception.getValue().getMessage());
					marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
					result = true;
				} catch (CoreException e2) {
					logErrorDuringCompilation(uri, e2);			
				}
			}
		}
		return result;
	}

	protected Runnable createRunnable(
			final IResourceDescription.Delta delta, 
			final IBuildContext context,
			final Map<String, OutputConfiguration> outputConfigurations, 
			final Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers,
			final FileSystemAccessQueue fileSystemAccessQueue, 
			final IFileSystemAccess delegate, 
			final IProgressMonitor progressMonitor) {
		return new Runnable() {

			public void run() {
				try {
					Set<IFile> derivedResources = getDerivedResources(delta, outputConfigurations, generatorMarkers);

					IFileSystemAccess fsa = getParalleFileSystemAccess(delta, context, derivedResources, fileSystemAccessQueue, delegate, progressMonitor);
					boolean generated = doGenerate(delta, context, fsa);
					
					fileSystemAccessQueue.sendAsync(delta.getUri(), getFlushAndCleanDerivedResourcesCallback(delta, derivedResources, context, generated, delegate, progressMonitor));
				} catch (Throwable e) {
					logErrorDuringCompilation(delta.getUri(), e);
				}
			}

		};
	}

	protected List<Future<?>> removeDone(List<Future<?>> futures) {
		Iterator<Future<?>> iterator = futures.iterator();
		while (iterator.hasNext() && iterator.next().isDone()) {
			iterator.remove();
		}
		return futures;
	}

	protected <E> BlockingQueue<E> newBlockingQueue(int capacity) {
		return new LinkedBlockingQueue<E>(capacity);
	}

	protected Procedure0 getFlushAndCleanDerivedResourcesCallback(
			final Delta delta,
			final Set<IFile> derivedResources, 
			final IBuildContext context, 
			final boolean generated, 
			final IFileSystemAccess delegate, 
			final IProgressMonitor progressMonitor) {
		return new Procedure0() {

			public void apply() {
				try {
					if (delegate instanceof EclipseResourceFileSystemAccess2) {
						EclipseResourceFileSystemAccess2 eclipseAccess = (EclipseResourceFileSystemAccess2) delegate;
						if (generated) {
							eclipseAccess.flushSourceTraces();
						}
						cleanDerivedResources(delta, derivedResources, context, eclipseAccess, progressMonitor);
					}
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			}

		};
	}

	protected IFileSystemAccess getParalleFileSystemAccess(final IResourceDescription.Delta delta,
			final IBuildContext context, Set<IFile> derivedResources, FileSystemAccessQueue fileSystemAccessQueue, IFileSystemAccess delegate, IProgressMonitor progressMonitor) {
		String currentSourceFolder = getCurrentSourceFolder(context, delta);
		IFileCallback postProcessor = getPostProcessor(delta, context, derivedResources);
		return new ParallelFileSystemAccess(delegate, delta, fileSystemAccessQueue, currentSourceFolder, postProcessor, progressMonitor);
	}

}
