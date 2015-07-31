/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.trace;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.ui.generator.trace.AbstractEclipseTrace;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTraceWithoutStorage extends AbstractEclipseTrace {
	
	private IProject project;
	private AbsoluteURI uri;

	@Override
	public IProject getLocalProject() {
		return project;
	}

	@Override
	public AbsoluteURI getLocalURI() {
		return uri;
	}
	
	@Override
	public IStorage getLocalStorage() {
		return null;
	}

	protected void setProject(IProject project) {
		this.project = project;
	}

	protected void setLocalURI(AbsoluteURI uri) {
		this.uri = uri;
	}

	@Override
	protected IStorage findStorage(SourceRelativeURI uri, IProject project) {
		// there are no storages inside a plain folder
		return null;
	}
	
	@Override
	protected abstract InputStream getContents(SourceRelativeURI uri, IProject project) throws IOException;

	/*
	 * Overridden to allow access from same package
	 */
	@Override
	protected void setTraceRegionProvider(ITraceRegionProvider traceRegionProvider) {
		super.setTraceRegionProvider(traceRegionProvider);
	}

}
