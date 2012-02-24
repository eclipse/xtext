/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class StorageAwareTrace extends AbstractTrace {

	private ITraceRegionProvider traceRegionProvider;
	
	private IStorage localStorage;
	
	private String projectName;

	@Override
	public IStorage getLocalStorage() {
		return localStorage;
	}
	
	@Override
	public IProject getLocalProject() {
		return findProject(projectName);
	}

	@Override
	@Nullable
	protected AbstractTraceRegion doGetRootTraceRegion() {
		try {
			return traceRegionProvider.getTraceRegion();
		} catch(TraceNotFoundException noTraceFound) {
			return null;
		}
	}
	
	protected void setTraceRegionProvider(ITraceRegionProvider traceRegionProvider) {
		this.traceRegionProvider = traceRegionProvider;
	}
	
	protected ITraceRegionProvider getTraceRegionProvider() {
		return traceRegionProvider;
	}
	
	protected void setLocalStorage(IStorage derivedResource) {
		this.localStorage = derivedResource;
		if (derivedResource instanceof IResource) {
			this.projectName = ((IResource) derivedResource).getProject().getName();
		}
	}

}
