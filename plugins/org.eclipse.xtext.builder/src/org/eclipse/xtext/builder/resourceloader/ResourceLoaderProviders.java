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
		int nProcessors = Runtime.getRuntime().availableProcessors();
		int nThreads = Math.max(2, Math.min(4, nProcessors));
		return getParallelLoader(nThreads, 0);
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

	public static Provider<IResourceLoader> getSerialLoader() {
		return new AbstractResourceLoaderProvider() {
			@Override
			public IResourceLoader get() {
				return new SerialResourceLoader(getResourceSetProvider(), getResourceSorter());
			}
		};
	}

}
