/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import static com.google.common.collect.Lists.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseWorkspaceConfigProvider;
import org.eclipse.xtext.workspace.IProjectConfig;

import com.google.common.io.Closeables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class TraceForStorageProvider implements ITraceForStorageProvider {

	// use TraceFileNameProvider.TRACE_FILE_EXTENSION
	@Deprecated 
	public static final String TRACE_FILE_EXTENSION = TraceFileNameProvider.TRACE_FILE_EXTENSION;

	private static final Logger log = Logger.getLogger(TraceForStorageProvider.class);
	
	@Inject
	private Provider<StorageAwareTrace> traceToSourceProvider;
	
	@Inject
	private TraceMarkers traceMarkers;
	
	@Inject
	private IWorkspace workspace;
	
	@Inject 
	private IStorage2UriMapper storage2UriMapper;
	
	@Inject 
	private TraceFileNameProvider traceFileNameProvider;
	
	@Inject
	private IResourceServiceProvider.Registry serviceRegistry;
	
	@Inject
	private CachedTraces cachedTraces;
	
	@Singleton
	protected static class CachedTraces {
		
		private static class PathWithTimestamp {

			private final IPath path;
			private final long timestamp;

			public PathWithTimestamp(IFile file) {
				this.path = file.getFullPath();
				this.timestamp = file.getModificationStamp();
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((path == null) ? 0 : path.hashCode());
				result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				PathWithTimestamp other = (PathWithTimestamp) obj;
				if (path == null) {
					if (other.path != null)
						return false;
				} else if (!path.equals(other.path))
					return false;
				if (timestamp != other.timestamp)
					return false;
				return true;
			}
			
		}
		
		@Inject
		private TraceRegionSerializer traceRegionSerializer;
		
		private Map<PathWithTimestamp, AbstractTraceRegion> cache = new LinkedHashMap<PathWithTimestamp, AbstractTraceRegion>(32, 0.75f, true) {
			private static final long serialVersionUID = 1L;
			final int MAX_SIZE = 20;
			@Override
			protected boolean removeEldestEntry(Map.Entry<PathWithTimestamp, AbstractTraceRegion> eldest) {
		        return size() > MAX_SIZE;
		    }
		};
		
		protected synchronized AbstractTraceRegion getTraceRegion(IFile file) throws TraceNotFoundException {
			if (file.exists()) {
				PathWithTimestamp key = new PathWithTimestamp(file);
				AbstractTraceRegion result = cache.get(key);
				if (result != null)
					return result;
				InputStream contents = null;
				try {
					contents = file.getContents();
					result = traceRegionSerializer.readTraceRegionFrom(contents);
					cache.put(key, result);
					return result;
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				} finally {
					try {
						Closeables.close(contents, true);
					} catch (IOException e) {
						//never thrown, swallowed by Closeables.close
					}
				}
			}
			throw new TraceNotFoundException();
		}
	}
	
	

	@Override
	public IEclipseTrace getTraceToSource(AbsoluteURI absoluteDerivedResource) {
		return null;
	}

	@Override
	public IEclipseTrace getTraceToSource(SourceRelativeURI srcRelativeDerivedResource, IProjectConfig project) {
		return null;
	}

	@Override
	public IEclipseTrace getTraceToTarget(AbsoluteURI absoluteSourceResource) {
		return null;
	}

	@Override
	public IEclipseTrace getTraceToTarget(SourceRelativeURI srcRelativeSourceResource, IProjectConfig project) {
		return null;
	}

	/* @Nullable */
	@Override
	public IEclipseTrace getTraceToSource(final IStorage derivedResource) {
		StorageAwareTrace result = traceToSourceProvider.get();
		result.setLocalStorage(derivedResource);
		result.setTraceToSource(true);
		result.setTraceRegionProvider(new ITraceRegionProvider() {
			
			@Override
			public AbstractTraceRegion getTraceRegion() {
				IStorage resource = derivedResource;
				if (resource instanceof IFile) {
					IStorage traceFile = getTraceFile(resource);
					if (traceFile instanceof IFile) {
						return cachedTraces.getTraceRegion((IFile) traceFile);
					}
				}
				throw new TraceNotFoundException();
			}
		});
		return result;
	}

	/* @Nullable */
	@Override
	public IEclipseTrace getTraceToTarget(final IStorage sourceResource) {
		if (sourceResource instanceof IFile) {
			try {
				final IFile sourceFile = (IFile) sourceResource;
				final List<IPath> traceFiles = traceMarkers.findTraceFiles(sourceFile);
				if (!traceFiles.isEmpty()) {
					StorageAwareTrace result = traceToSourceProvider.get();
					result.setTraceToSource(false);
					result.setLocalStorage(sourceResource);
					final AbsoluteURI sourceFileURI = new AbsoluteURI(storage2UriMapper.getUri(sourceResource));
					IProject containingProject = sourceFile.getProject();
					IResourceServiceProvider serviceProvider = serviceRegistry.getResourceServiceProvider(sourceFileURI.getURI());
					EclipseWorkspaceConfigProvider configProvider = serviceProvider.get(EclipseWorkspaceConfigProvider.class);
					final EclipseProjectConfig projectConfig = configProvider == null ? null : configProvider.getProjectConfig(containingProject);
					final ITraceURIConverter traceURIConverter = serviceProvider.get(ITraceURIConverter.class);
					result.setTraceRegionProvider(new ITraceRegionProvider() {
						@Override
						public AbstractTraceRegion getTraceRegion() {
							List<AbstractTraceRegion> result = newArrayList();
							for (IPath tracePath : traceFiles) {
								IFile traceFile = workspace.getRoot().getFile(tracePath);
								if (traceFile.exists()) {
									final IStorage generatedFileForTraceFile = getGeneratedFileForTraceFile(traceFile);
									if (generatedFileForTraceFile == null)
										throw new TraceNotFoundException();
									AbstractTraceRegion traceRegion = cachedTraces.getTraceRegion(traceFile);
									IPath generatedFilePath = generatedFileForTraceFile.getFullPath();
									AbsoluteURI generatedFileURI = new AbsoluteURI(URI.createPlatformResourceURI(generatedFilePath.toString(), true));
									if (projectConfig != null) {
										SourceRelativeURI sourceUriForTrace = traceURIConverter.getURIForTrace(projectConfig, sourceFileURI);
										SourceRelativeURI generatedUriForTrace = traceURIConverter.getURIForTrace(projectConfig, generatedFileURI);
										if(sourceUriForTrace != null && generatedUriForTrace != null)
											result.addAll(traceRegion.invertFor(sourceUriForTrace, generatedUriForTrace));
									}
								}
							}
							if (result.isEmpty()) 
								throw new TraceNotFoundException();
							return AbstractTraceRegion.mergedFrom(result);	
						}
					});
					return result;
				}
			} catch (CoreException coreException) {
				log.info(coreException.getMessage(), coreException);
			}
		}
		return null;
	}
	
	/**
	 * @since 2.3
	 */
	public /* @Nullable */ IStorage getTraceFile(IStorage storage) {
		if (storage instanceof IFile) {
			IFile file = (IFile) storage;
			String originLastSegment = file.getFullPath().lastSegment();
			IFile traceFile = file.getParent().getFile(new Path(traceFileNameProvider.getTraceFromJava(originLastSegment)));
			return traceFile;
		}
		return null;
	}
	
	public boolean isTraceFile(IStorage storage) {
		if (!(storage instanceof IFile)) {
			return false;
		}
		IFile file = (IFile) storage;
		String originLastSegment = file.getFullPath().lastSegment();
		return traceFileNameProvider.isTraceFileName(originLastSegment);
	}

	protected /* @Nullable */ IStorage getGeneratedFileForTraceFile(IStorage traceFile) {
		if (traceFile instanceof IFile) {
			IFile file = (IFile) traceFile;
			String lastSegment = traceFile.getFullPath().lastSegment();
			lastSegment = traceFileNameProvider.getJavaFromTrace(lastSegment);
			return file.getParent().getFile(new Path(lastSegment));
		}
		return null;
	}

}
