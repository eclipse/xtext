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
import java.io.Reader;
import java.nio.charset.Charset;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.ui.generator.trace.AbstractEclipseTrace;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTraceWithoutStorage extends AbstractEclipseTrace {

	private IProject project;
	private SourceRelativeURI localURI;
	private Charset encoding;

	@Override
	public IProject getLocalProject() {
		return project;
	}

	protected SourceRelativeURI getLocalSourceRelativeURI() {
		return localURI;
	}
	
	protected void setEncoding(Charset encoding) {
		this.encoding = encoding;
	}

	protected Charset getEncoding() {
		return encoding;
	}

	@Override
	public IStorage getLocalStorage() {
		return null;
	}

	protected void setProject(IProject project) {
		this.project = project;
	}

	protected void setLocalURI(SourceRelativeURI uri) {
		this.localURI = uri;
	}

	@Override
	protected IStorage findStorage(SourceRelativeURI uri, IProject project) {
		// there are no storages inside a plain folder
		return null;
	}

	@Override
	protected Reader getLocalContentsAsText(IProject project) throws IOException {
		return getContentsAsText(localURI, project);
	}

	/*
	 * Overridden to allow access from same package
	 */
	@Override
	protected abstract InputStream getContents(SourceRelativeURI uri, IProject project) throws IOException;

	@Override
	public AbsoluteURI getLocalURI() {
		return resolvePath(getLocalSourceRelativeURI());
	}

}
