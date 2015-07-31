/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.internal.AbstractTraceForURIProvider;
import org.eclipse.xtext.ui.workspace.EclipseWorkspaceConfigProvider;
import org.eclipse.xtext.workspace.IProjectConfig;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class TraceForStorageProvider extends AbstractTraceForURIProvider<IFile, StorageAwareTrace> implements ITraceForStorageProvider {

	// use TraceFileNameProvider.TRACE_FILE_EXTENSION
	@Deprecated 
	public static final String TRACE_FILE_EXTENSION = TraceFileNameProvider.TRACE_FILE_EXTENSION;

	@Inject
	private Provider<StorageAwareTrace> traceToSourceProvider;
	
	@Inject
	private TraceMarkers traceMarkers;
	
	@Inject
	private IWorkspace workspace;
	
	protected class FileBasedTrace implements PersistedTrace {

		private final IFile file;

		protected FileBasedTrace(IFile file) {
			this.file = file;
		}
		
		@Override
		public AbsoluteURI getPath() {
			return getAbsoluteLocation(file);
		}

		@Override
		public long getTimestamp() {
			return file.getLocalTimeStamp();
		}

		@Override
		public InputStream openStream() throws IOException {
			try {
				return file.getContents();
			} catch (CoreException e) {
				throw new WrappedCoreException(e);
			}
		}

		@Override
		public boolean exists() {
			return file.exists();
		}
		
	}
	
	@Override
	protected IFile asFile(AbsoluteURI absoluteURI, IProjectConfig project) {
		URI uri = absoluteURI.getURI();
		if (uri.isPlatformResource()) {
			IFile result = workspace.getRoot().getFile(new Path(uri.toPlatformString(true)));
			if (result.exists()) {
				return result;
			}
		}
		return null;
	}
	
	@Override
	protected List<PersistedTrace> findInverseTraceFiles(IFile sourceFile) {
		final List<IPath> traceFiles = findTraceMarkers(sourceFile);
		if (!traceFiles.isEmpty()) {
			final List<PersistedTrace> result = Lists.newArrayListWithCapacity(traceFiles.size());
			for(IPath path: traceFiles) {
				IFile file = workspace.getRoot().getFile(path);
				if (!file.exists()) {
					return Collections.emptyList();
				}
				FileBasedTrace trace = new FileBasedTrace(file);
				result.add(trace);
			}
			return result;
		}
		return Collections.emptyList();
	}

	private List<IPath> findTraceMarkers(IFile sourceFile) {
		try {
			return traceMarkers.findTraceFiles(sourceFile);
		} catch (CoreException e) {
			return Collections.emptyList();
		}
	}
	
	@Override
	protected PersistedTrace findPersistedTrace(IFile generatedFile) {
		IFile traceFile = getTraceFile(generatedFile);
		if (traceFile.exists()) {
			return new FileBasedTrace(traceFile);
		}
		return null;
	}
	
	@Override
	protected AbsoluteURI getAbsoluteLocation(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		return new AbsoluteURI(uri);
	}
	
	@Override
	protected IProjectConfig getProjectConfig(IFile sourceFile) {
		AbsoluteURI location = getAbsoluteLocation(sourceFile);
		EclipseWorkspaceConfigProvider workspaceConfig = getServiceProvider(location).get(EclipseWorkspaceConfigProvider.class);
		return workspaceConfig.getProjectConfig(sourceFile.getProject());
	}
	
	@Override
	protected StorageAwareTrace newAbstractTrace(IFile file) {
		StorageAwareTrace result = traceToSourceProvider.get();
		result.setLocalStorage(file);
		return result;
	}
	
	@Override
	public IEclipseTrace getTraceToTarget(IStorage sourceResource) {
		if (sourceResource instanceof IFile) {
			IFile file = (IFile) sourceResource;
			return getTraceToTarget(file, getAbsoluteLocation(file), getProjectConfig(file));
		}
		return null;
	}
	
	@Override
	public IEclipseTrace getTraceToSource(IStorage derivedResource) {
		if (derivedResource instanceof IFile) {
			return getTraceToSource((IFile) derivedResource);
		}
		return null;
	}

	//	/* @Nullable */
//	@Override
//	public IEclipseTrace getTraceToSource(final IStorage derivedResource) {
//		StorageAwareTrace result = traceToSourceProvider.get();
//		result.setLocalStorage(derivedResource);
//		result.setTraceToSource(true);
//		result.setTraceRegionProvider(new ITraceRegionProvider() {
//			
//			@Override
//			public AbstractTraceRegion getTraceRegion() {
//				IStorage resource = derivedResource;
//				if (resource instanceof IFile) {
//					IStorage traceFile = getTraceFile(resource);
//					if (traceFile instanceof IFile) {
//						return cachedTraces.getTraceRegion((IFile) traceFile);
//					}
//				}
//				throw new TraceNotFoundException();
//			}
//		});
//		return result;
//	}
//
//	/* @Nullable */
//	@Override
//	public IEclipseTrace getTraceToTarget(final IStorage sourceResource) {
//		if (sourceResource instanceof IFile) {
//			try {
//				final IFile sourceFile = (IFile) sourceResource;
//				final List<IPath> traceFiles = traceMarkers.findTraceFiles(sourceFile);
//				if (!traceFiles.isEmpty()) {
//					StorageAwareTrace result = traceToSourceProvider.get();
//					result.setTraceToSource(false);
//					result.setLocalStorage(sourceResource);
//					final AbsoluteURI sourceFileURI = new AbsoluteURI(storage2UriMapper.getUri(sourceResource));
//					IProject containingProject = sourceFile.getProject();
//					IResourceServiceProvider serviceProvider = serviceRegistry.getResourceServiceProvider(sourceFileURI.getURI());
//					EclipseWorkspaceConfigProvider configProvider = serviceProvider.get(EclipseWorkspaceConfigProvider.class);
//					final EclipseProjectConfig projectConfig = configProvider == null ? null : configProvider.getProjectConfig(containingProject);
//					final ITraceURIConverter traceURIConverter = serviceProvider.get(ITraceURIConverter.class);
//					result.setTraceRegionProvider(new ITraceRegionProvider() {
//						@Override
//						public AbstractTraceRegion getTraceRegion() {
//							List<AbstractTraceRegion> result = newArrayList();
//							for (IPath tracePath : traceFiles) {
//								IFile traceFile = workspace.getRoot().getFile(tracePath);
//								if (traceFile.exists()) {
//									final IStorage generatedFileForTraceFile = getGeneratedFileForTraceFile(traceFile);
//									if (generatedFileForTraceFile == null)
//										throw new TraceNotFoundException();
//									AbstractTraceRegion traceRegion = cachedTraces.getTraceRegion(traceFile);
//									IPath generatedFilePath = generatedFileForTraceFile.getFullPath();
//									AbsoluteURI generatedFileURI = new AbsoluteURI(URI.createPlatformResourceURI(generatedFilePath.toString(), true));
//									if (projectConfig != null) {
//										SourceRelativeURI sourceUriForTrace = traceURIConverter.getURIForTrace(projectConfig, sourceFileURI);
//										SourceRelativeURI generatedUriForTrace = traceURIConverter.getURIForTrace(projectConfig, generatedFileURI);
//										if(sourceUriForTrace != null && generatedUriForTrace != null)
//											result.addAll(traceRegion.invertFor(sourceUriForTrace, generatedUriForTrace));
//									}
//								}
//							}
//							if (result.isEmpty()) 
//								throw new TraceNotFoundException();
//							return AbstractTraceRegion.mergedFrom(result);	
//						}
//					});
//					return result;
//				}
//			} catch (CoreException coreException) {
//				log.info(coreException.getMessage(), coreException);
//			}
//		}
//		return null;
//	}
//	
	/**
	 * @since 2.3
	 */
	public IFile getTraceFile(IFile generatedFile) {
		String originLastSegment = generatedFile.getFullPath().lastSegment();
		IFile traceFile = generatedFile.getParent().getFile(new Path(getTraceFileNameProvider().getTraceFromJava(originLastSegment)));
		return traceFile;
	}

	public boolean isTraceFile(IStorage storage) {
		if (!(storage instanceof IFile)) {
			return false;
		}
		IFile file = (IFile) storage;
		String originLastSegment = file.getFullPath().lastSegment();
		return getTraceFileNameProvider().isTraceFileName(originLastSegment);
	}

}
