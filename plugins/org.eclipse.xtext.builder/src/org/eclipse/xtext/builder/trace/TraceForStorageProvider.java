/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import static com.google.common.collect.Lists.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.trace.AbstractStatefulTraceRegion;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

import com.google.common.io.Closeables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@NonNullByDefault
public class TraceForStorageProvider implements ITraceForStorageProvider {

	// use TraceFileNameProvider.TRACE_FILE_EXTENSION
	@Deprecated 
	public static final String TRACE_FILE_EXTENSION = TraceFileNameProvider.TRACE_FILE_EXTENSION;

	private static final Logger log = Logger.getLogger(TraceForStorageProvider.class);
	
	@Inject
	private TraceRegionSerializer traceRegionSerializer;
	
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
	private ITraceURIConverter traceURIConverter;

	@Nullable
	public ITrace getTraceToSource(final IStorage derivedResource) {
		StorageAwareTrace result = traceToSourceProvider.get();
		result.setLocalStorage(derivedResource);
		result.setTraceRegionProvider(new ITraceRegionProvider() {
			
			public AbstractTraceRegion getTraceRegion() {
				IStorage resource = derivedResource;
				if (resource instanceof IFile) {
					IStorage traceFile = getTraceFile(resource);
					if (traceFile instanceof IFile && ((IFile)traceFile).exists()) {
						InputStream contents = null;
						try {
							contents = traceFile.getContents();
							return traceRegionSerializer.readTraceRegionFrom(contents);
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
				}
				throw new TraceNotFoundException();
			}
		});
		return result;
	}

	@Nullable
	public ITrace getTraceToTarget(final IStorage sourceResource) {
		if (sourceResource instanceof IFile) {
			try {
				final IFile sourceFile = (IFile) sourceResource;
				final List<IPath> traceFiles = traceMarkers.findTraceFiles(sourceFile);
				if (!traceFiles.isEmpty()) {
					StorageAwareTrace result = traceToSourceProvider.get();
					result.setLocalStorage(sourceResource);
					final URI sourceFileURI = storage2UriMapper.getUri(sourceResource);
					result.setTraceRegionProvider(new ITraceRegionProvider() {
						public AbstractTraceRegion getTraceRegion() {
							List<AbstractTraceRegion> result = newArrayList();
							for (IPath tracePath : traceFiles) {
								IFile traceFile = workspace.getRoot().getFile(tracePath);
								if (traceFile.exists()) {
									InputStream contents = null;
									try {
										contents = ((IStorage) traceFile).getContents();
										AbstractTraceRegion traceRegion = traceRegionSerializer.readTraceRegionFrom(contents);
										final IStorage generatedFileForTraceFile = getGeneratedFileForTraceFile(traceFile);
										if (generatedFileForTraceFile == null)
											throw new TraceNotFoundException();
										IPath generatedFilePath = generatedFileForTraceFile.getFullPath();
										URI generatedFileURI = URI.createPlatformResourceURI(generatedFilePath.toString(), true);
										URI sourceUriForTrace = traceURIConverter.getURIForTrace(sourceFileURI);
										URI generatedUriForTrace = traceURIConverter.getURIForTrace(generatedFileURI);
										if(sourceUriForTrace != null && generatedUriForTrace != null)
											result.addAll(traceRegion.invertFor(sourceUriForTrace, generatedUriForTrace));
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
							}
							if (!result.isEmpty()) {
								if (result.size() > 1) {
									ITextRegionWithLineInformation rootLocation = ITextRegionWithLineInformation.EMPTY_REGION;
									ITextRegionWithLineInformation associated = ITextRegionWithLineInformation.EMPTY_REGION;
									for(AbstractTraceRegion child: result) {
										rootLocation = rootLocation.merge(new TextRegionWithLineInformation(child.getMyOffset(), child.getMyLength(), child.getMyLineNumber(), child.getMyEndLineNumber()));
										ILocationData childAssociation = child.getMergedAssociatedLocation();
										if (childAssociation != null)
											associated = associated.merge(childAssociation);
									}
									AbstractTraceRegion root = new AbstractStatefulTraceRegion(rootLocation, new ArrayList<ILocationData>(), null) {};
									Collections.sort(result, new Comparator<AbstractTraceRegion>() {
										
										public int compare(@Nullable AbstractTraceRegion o1, @Nullable AbstractTraceRegion o2) {
											if (o1 == null || o2 == null)
												throw new NullPointerException();
											return o1.getMyOffset() - o2.getMyOffset();
										}

									});
									for(AbstractTraceRegion child: result) {
										child.setParent(root);
									}
									return root;
								} else {
									return result.get(0);
								}
							}
							throw new TraceNotFoundException();
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
	public @Nullable IStorage getTraceFile(IStorage storage) {
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

	protected @Nullable IStorage getGeneratedFileForTraceFile(IStorage traceFile) {
		if (traceFile instanceof IFile) {
			IFile file = (IFile) traceFile;
			String lastSegment = traceFile.getFullPath().lastSegment();
			lastSegment = traceFileNameProvider.getJavaFromTrace(lastSegment);
			return file.getParent().getFile(new Path(lastSegment));
		}
		return null;
	}

}
