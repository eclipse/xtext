/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;

import com.google.common.io.Closeables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FileBasedTrace extends AbstractTrace {

	private static final Logger log = Logger.getLogger(FileBasedTrace.class);
	
	@Inject
	private TraceRegionSerializer traceRegionSerializer;
	
	private IStorage derivedResource;
	
	private String projectName;

	@Override
	public IStorage getLocalStorage() {
		return derivedResource;
	}
	
	@Override
	public IProject getLocalProject() {
		return findProject(projectName);
	}

	@Override
	@Nullable
	protected AbstractTraceRegion doGetRootTraceRegion() {
		IStorage resource = getLocalStorage();
		if (resource instanceof IResource) {
			IPath tracePath = resource.getFullPath().addFileExtension(FileBasedTraceInformation.TRACE_FILE_EXTENSION);
			IResource traceStorage = ((IResource) resource).getParent().getFile(new Path(tracePath.lastSegment()));
			if (traceStorage instanceof IStorage && traceStorage.exists()) {
				InputStream contents = null;
				try {
					contents = ((IStorage) traceStorage).getContents();
					return traceRegionSerializer.readTraceRegionFrom(contents);
				} catch (CoreException e) {
					log.error(e.getMessage(), e);
					return null;
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					return null;
				} finally {
					Closeables.closeQuietly(contents);
				}
			}
		}
		return null;
	}
	
	protected void setLocalStorage(IStorage derivedResource) {
		this.derivedResource = derivedResource;
		if (derivedResource instanceof IResource) {
			this.projectName = ((IResource) derivedResource).getProject().getName();
		}
	}

}
