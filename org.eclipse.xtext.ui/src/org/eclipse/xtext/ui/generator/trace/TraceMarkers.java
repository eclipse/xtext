/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TraceMarkers {
	public final static String MARKER_ID = "org.eclipse.xtext.builder.traceFilePath"; 
	public final static String ATTR_PATH = "path"; 
	public final static String ATTR_GENERATOR_NAME = "generatorName";
	public final static String DEFAULT_GENERATOR_NAME = "default";
	
	protected IMarker[] findTraceMarkers(IFile file) throws CoreException {
		if (!file.exists())
			return new IMarker[0];
		IMarker[] markers = file.findMarkers(MARKER_ID, false, IResource.DEPTH_ONE);
		return markers;
	}
	
	public List<IPath> findTraceFiles(IFile sourceFile) throws CoreException {
		return findTraceFiles(sourceFile, DEFAULT_GENERATOR_NAME);
	}
	
	public List<IPath> findTraceFiles(IFile sourceFile, String generatorName) throws CoreException {
		List<IPath> result = newArrayList();
		for (IMarker marker : findTraceMarkers(sourceFile)) {
			if (marker.exists()) {
				String markerGeneratorName = marker.getAttribute(ATTR_GENERATOR_NAME, DEFAULT_GENERATOR_NAME);
				if (generatorName.equals(markerGeneratorName)) {
					String portablePath = marker.getAttribute(ATTR_PATH, (String) null);
					if (portablePath != null) {
						result.add(Path.fromPortableString(portablePath));
					}
				}
			}
		}
		return result;
	}
	
	public void installMarker(IFile sourceFile, IPath... traceFileLocations) throws CoreException {
		installMarker(sourceFile, DEFAULT_GENERATOR_NAME, traceFileLocations);
	}
	
	public void installMarker(IFile sourceFile, String generatorName, IPath[] traceFileLocations) throws CoreException {
		if (!sourceFile.exists())
			return;
		IMarker[] markers = findTraceMarkers(sourceFile);
		for(IMarker marker: markers) {
			if (marker.exists()) {
				String markerGeneratorName = marker.getAttribute(ATTR_GENERATOR_NAME, DEFAULT_GENERATOR_NAME);
				if (generatorName.equals(markerGeneratorName)) {
					marker.delete();
				}
			}
		}
		for(IPath traceFileLocation: traceFileLocations) {
			IMarker marker = sourceFile.createMarker(MARKER_ID);
			marker.setAttribute(ATTR_PATH, traceFileLocation.toPortableString());
			if(!DEFAULT_GENERATOR_NAME.equals(generatorName)) {
				marker.setAttribute(ATTR_GENERATOR_NAME, generatorName);
			}
		}
	}
	
}
