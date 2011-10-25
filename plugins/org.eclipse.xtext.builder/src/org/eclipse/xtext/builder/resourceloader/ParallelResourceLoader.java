/*******************************************************************************
 * Copyright (c) 2011 Sigasi NV (http://www.sigasi.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Lieven Lemiengre - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.xtext.builder.resourceloader;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;

/**
 * Loads resources in one more separate threads.
 *
 * @author Lieven Lemiengre - Initial contribution and API
 * @author Sebastian Zarnekow - Use IProject aware IResourceSetProvider instead of Provider<XtextResourceSet>
 * @since 2.1
 */
public class ParallelResourceLoader extends AbstractResourceLoader {

	private static final long MAX_WAIT_TIME = TimeUnit.SECONDS.toMillis(60);

	private final int nThreads;
	private final int queueSize;
	private long timeout;

	public ParallelResourceLoader(IResourceSetProvider resourceSetProvider, Sorter sorter, int nThreads, int queueSize) {
		super(resourceSetProvider, sorter);
		this.nThreads = nThreads;
		this.queueSize = queueSize;
		this.timeout = MAX_WAIT_TIME;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long time, TimeUnit unit) {
		this.timeout = unit.toMillis(time);
	}

	public LoadOperation create(ResourceSet parent, IProject project) {
		return new CheckedLoadOperation(new ParallelLoadOperation(parent, project));
	}

	private class ParallelLoadOperation implements LoadOperation {

		private final BlockingQueue<Triple<URI, Resource, Throwable>> resourceQueue;
		private final ThreadLocal<ResourceSet> resourceSetProvider;
		private final ExecutorService executor;
		private final ResourceSet parent;
		private final long waitTime;
		private int toProcess;

		public ParallelLoadOperation(final ResourceSet parent, final IProject project) {
			this.parent = parent;
			if(queueSize == 0) {
				this.resourceQueue = new SynchronousQueue<Triple<URI, Resource, Throwable>>(true);
			} else {
				this.resourceQueue = new ArrayBlockingQueue<Triple<URI, Resource, Throwable>>(queueSize);
			}
			this.resourceSetProvider = new ThreadLocal<ResourceSet>() {
				@Override
				protected ResourceSet initialValue() {
					ResourceSet resourceSet = getResourceSetProvider().get(project);
					resourceSet.getLoadOptions().putAll(parent.getLoadOptions());
					resourceSet.setURIConverter(parent.getURIConverter());
					return resourceSet;
				}
			};
			this.executor = Executors.newFixedThreadPool(nThreads);
			this.waitTime = getTimeout();
		}

		private class ResourceLoadJob implements Runnable {
			private final URI uri;

			public ResourceLoadJob(URI uri) {
				this.uri = uri;
			}

			public void run() {
				Throwable exception = null;
				Resource resource = null;

				// load resource
				try {
					ResourceSet localResourceSet = resourceSetProvider.get();
					resource = loadResource(uri, localResourceSet, parent);
					localResourceSet.getResources().clear();
				} catch (Throwable t) {
					exception = t;
				}

				// push resource to the queue, wait if queue is full
				try {
					resourceQueue.put(Tuples.create(uri, resource, exception));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}

		public LoadResult next() {
			if (!hasNext())
				throw new NoSuchElementException("The resource queue is empty or the execution was cancelled.");
			Triple<URI, Resource, Throwable> result = null;
			try {
				result = resourceQueue.poll(waitTime, TimeUnit.MILLISECONDS);
				toProcess--;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			if (result == null) {
				throw new NullPointerException("Resource load job didn't return a result");
			}

			URI uri = result.getFirst();
			Resource resource = result.getSecond();
			Throwable throwable = result.getThird();

			if (throwable != null) { // rethrow errors in the main thread
				if (throwable instanceof WrappedException)
					throw new LoadOperationException(uri, throwable.getCause());
				throw new LoadOperationException(uri, throwable);
			}
			return new LoadResult(resource, uri);
		}

		public boolean hasNext() {
			return toProcess > 0;
		}

		public void load(Collection<URI> uris) {
			toProcess += uris.size();
			Collection<URI> workload = getSorter().sort(uris);
			for(URI uri : workload) {
				executor.execute(new ResourceLoadJob(uri));
			}
			executor.shutdown();
		}

		public Collection<URI> cancel() {
			toProcess = 0;
			List<Runnable> jobs = executor.shutdownNow();
			List<URI> ret = Lists.newArrayList();
			for (Runnable job : jobs) {
				if (job instanceof ResourceLoadJob) {
					ret.add(((ResourceLoadJob) job).uri);
				}
			}
			return ret;
		}

	}

}
