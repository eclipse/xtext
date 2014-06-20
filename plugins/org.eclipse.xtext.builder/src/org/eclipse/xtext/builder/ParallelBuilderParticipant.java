package org.eclipse.xtext.builder;

import static com.google.common.collect.Lists.*;

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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2.IFileCallback;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.7
 */
public class ParallelBuilderParticipant extends BuilderParticipant {
	
	@Override
	protected void handleChangedContents(Delta delta, IBuildContext context, IFileSystemAccess access)
			throws CoreException {
		Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		if (shouldGenerate(resource, context)) {
			getGenerator().doGenerate(resource, access);
		}
	}
	
	@Override
	protected void doBuild(List<Delta> deltas, Map<String, OutputConfiguration> outputConfigurations,
			Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers, IBuildContext context,
			EclipseResourceFileSystemAccess2 access, IProgressMonitor progressMonitor) throws CoreException {
		List<Future<?>> futures = newArrayList();
		ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryBuilder().setNameFormat("ParallelGenerator-%d").build());

		BlockingQueue<Pair<IResourceDescription.Delta, Procedure2<? super IFileSystemAccess, ? super IProgressMonitor>>> requestQueue = newBlockingQueue(50);

		for (IResourceDescription.Delta delta : deltas) {
			try {
				Runnable runnable = createRunnable(delta, context, outputConfigurations, generatorMarkers, requestQueue);
				Future<?> future = executorService.submit(runnable);
				futures.add(future);
			} catch (Exception e) {
				logErrorDuringCompilation(delta, e);
			}
		}

		SubMonitor subMonitor = SubMonitor.convert(progressMonitor, 1);
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
	}

	protected Runnable createRunnable(
			final IResourceDescription.Delta delta, 
			final IBuildContext context,
			final Map<String, OutputConfiguration> outputConfigurations, 
			final Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers,
			final BlockingQueue<Pair<IResourceDescription.Delta, Procedure2<? super IFileSystemAccess, ? super IProgressMonitor>>> requestQueue) {
		return new Runnable() {

			public void run() {
				try {
					Set<IFile> derivedResources = getDerivedResources(delta, outputConfigurations, generatorMarkers);
					
					FileSystemAccessQueue fileSystemAccessQueue = new FileSystemAccessQueue(requestQueue);

					IFileSystemAccess fsa = getParalleFileSystemAccess(delta, context, derivedResources, fileSystemAccessQueue);
					doGenerate(delta, context, fsa);
					
					fileSystemAccessQueue.put(delta, getFlushAndCleanUpCallback(delta, derivedResources, context));
				} catch (Throwable e) {
					logErrorDuringCompilation(delta, e);
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

	protected Procedure2<IFileSystemAccess, IProgressMonitor> getFlushAndCleanUpCallback(final Delta delta,
			final Set<IFile> derivedResources, final IBuildContext context) {
		return new Procedure2<IFileSystemAccess, IProgressMonitor>() {

			public void apply(IFileSystemAccess access, IProgressMonitor deleteMonitor) {
				try {
					if (access instanceof EclipseResourceFileSystemAccess2) {
						EclipseResourceFileSystemAccess2 eclipseAccess = (EclipseResourceFileSystemAccess2) access;
						eclipseAccess.flushSourceTraces();
						cleanDerivedResources(delta, derivedResources, context, eclipseAccess, deleteMonitor);
					}
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			}

		};
	}

	protected IFileSystemAccess getParalleFileSystemAccess(final IResourceDescription.Delta delta,
			final IBuildContext context, Set<IFile> derivedResources, FileSystemAccessQueue fileSystemAccessQueue) {
		String currentSourceFolder = getCurrentSourceFolder(context, delta);
		IFileCallback postProcessor = getPostProcessor(delta, context, derivedResources);
		return new ParallelFileSystemAccess(delta, fileSystemAccessQueue, currentSourceFolder, postProcessor);
	}

}
