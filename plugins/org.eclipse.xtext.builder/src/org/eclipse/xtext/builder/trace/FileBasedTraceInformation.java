/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;
import org.eclipse.xtext.generator.trace.TraceRegion;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
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
public class FileBasedTraceInformation implements ITraceInformation {

	public static final String TRACE_FILE_EXTENSION = "_trace";

	private static final Logger log = Logger.getLogger(StorageAwareTrace.class);
	
	@Inject
	private TraceRegionSerializer traceRegionSerializer;
	
	@Inject
	private Provider<StorageAwareTrace> traceToSourceProvider;
	
	@Inject
	private TraceMarkers traceMarkers;
	
	@Inject
	private IWorkspace workspace;
	
	@Nullable
	public ITrace getTraceToSource(final IStorage derivedResource) {
		StorageAwareTrace result = traceToSourceProvider.get();
		result.setLocalStorage(derivedResource);
		result.setTraceRegionProvider(new ITraceRegionProvider() {
			
			public AbstractTraceRegion getTraceRegion() {
				IStorage resource = derivedResource;
				if (resource instanceof IResource) {
					IPath tracePath = resource.getFullPath().addFileExtension(FileBasedTraceInformation.TRACE_FILE_EXTENSION);
					IResource traceStorage = ((IResource) resource).getParent().getFile(new Path(tracePath.lastSegment()));
					if (traceStorage instanceof IStorage && traceStorage.exists()) {
						InputStream contents = null;
						try {
							contents = ((IStorage) traceStorage).getContents();
							return traceRegionSerializer.readTraceRegionFrom(contents);
						} catch (Exception e) {
							log.error(e.getMessage(), e);
						} finally {
							Closeables.closeQuietly(contents);
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
				final List<IPath> traceFiles = traceMarkers.findTraceFiles((IFile) sourceResource);
				if (!traceFiles.isEmpty()) {
					StorageAwareTrace result = traceToSourceProvider.get();
					result.setLocalStorage(sourceResource);
					result.setTraceRegionProvider(new ITraceRegionProvider() {
						public AbstractTraceRegion getTraceRegion() {
							IPath tracePath = traceFiles.get(0);
							IFile traceFile = workspace.getRoot().getFile(tracePath);
							if (traceFile.exists()) {
								InputStream contents = null;
								try {
									contents = ((IStorage) traceFile).getContents();
									AbstractTraceRegion traceRegion = traceRegionSerializer.readTraceRegionFrom(contents);
									IPath generatedFilePath = traceFile.getFullPath().removeFileExtension();
									URI generatedFileURI = URI.createPlatformResourceURI(generatedFilePath.toString(), true);
									URI sourceFileURI = URI.createPlatformResourceURI(sourceResource.getFullPath().toString(), true);
									String projectName = traceFile.getProject().getName();
									List<AbstractTraceRegion> result = traceRegion.invertFor(sourceFileURI, generatedFileURI, projectName);
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
											AbstractTraceRegion root = new AbstractStatefulTraceRegion(rootLocation, new LocationData(associated, generatedFileURI, projectName), null) {
											};
											for(AbstractTraceRegion child: result) {
												child.setParent(root);
											}
											return root;
										} else {
											return result.get(0);
										}
									}
								} catch (Exception e) {
									log.error(e.getMessage(), e);
								} finally {
									Closeables.closeQuietly(contents);
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

}
