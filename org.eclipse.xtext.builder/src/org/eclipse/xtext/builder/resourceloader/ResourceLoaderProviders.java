/*******************************************************************************
 * Copyright (c) 2011, 2017 Sigasi NV (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Lieven Lemiengre - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.xtext.builder.resourceloader;

import java.util.concurrent.TimeUnit;

import org.eclipse.xtext.builder.resourceloader.IResourceLoader.Sorter;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Lieven Lemiengre - Initial contribution and API
 * @author Sebastian Zarnekow - Use IProject aware XtextResourceSetProvider instead of Provider<XtextResourceSet>
 * @since 2.1
 */
public final class ResourceLoaderProviders {

	public static abstract class AbstractResourceLoaderProvider implements Provider<IResourceLoader> {

		@Inject
		private IResourceSetProvider resourceSetProvider;

		@Inject
		private Sorter resourceSorter;

		public IResourceSetProvider getResourceSetProvider() {
			return resourceSetProvider;
		}

		public Sorter getResourceSorter() {
			return resourceSorter;
		}
	}

	/** Returns a loader with a parallelization degree of 2 to 4 (depending on how many processors are available). */
	public static Provider<IResourceLoader> getParallelLoader() {
		int nThreads = getNumberOfThreads();
		return getParallelLoader(nThreads, 0);
	}

	/**
	 * since 2.12
	 */
	public static Provider<IResourceLoader> getParallelLoader(long timeoutTime, TimeUnit timeoutUnit) {
		int nThreads = getNumberOfThreads();
		return getParallelLoader(nThreads, 0, timeoutTime, timeoutUnit);
	}

	private static int getNumberOfThreads() {
		int nProcessors = Runtime.getRuntime().availableProcessors();
		int nThreads = Math.max(2, Math.min(4, nProcessors));
		return nThreads;
	}

	public static Provider<IResourceLoader> getParallelLoader(final int nrOfThreads) {
		return getParallelLoader(nrOfThreads, 0);
	}

	public static Provider<IResourceLoader> getParallelLoader(final int nrOfThreads, final int bufferSize) {
		return new AbstractResourceLoaderProvider() {
			@Override
			public IResourceLoader get() {
				ParallelResourceLoader resourceLoader = new ParallelResourceLoader(getResourceSetProvider(), getResourceSorter(), nrOfThreads, bufferSize);
				return resourceLoader;
			}
		};
	}

	/**
	 * @since 2.12
	 */
	public static Provider<IResourceLoader> getParallelLoader(final int nrOfThreads, final int bufferSize, long timeoutTime, TimeUnit timeoutUnit) {
		return new AbstractResourceLoaderProvider() {
			@Override
			public IResourceLoader get() {
				ParallelResourceLoader resourceLoader = new ParallelResourceLoader(getResourceSetProvider(), getResourceSorter(), nrOfThreads, bufferSize);
				resourceLoader.setTimeout(timeoutTime, timeoutUnit);
				return resourceLoader;
			}
		};
	}

	public static Provider<IResourceLoader> getSerialLoader() {
		return new AbstractResourceLoaderProvider() {
			@Override
			public IResourceLoader get() {
				return new SerialResourceLoader(getResourceSetProvider(), getResourceSorter());
			}
		};
	}

}
