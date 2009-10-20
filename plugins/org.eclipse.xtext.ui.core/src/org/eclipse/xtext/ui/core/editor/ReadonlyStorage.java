/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class ReadonlyStorage extends PlatformObject implements IStorage {

	private final URI uri;

	public ReadonlyStorage(URI uri) {
		this.uri = uri;
	}
	
	public boolean isReadOnly() {
		return true;
	}

	public URI getURI() {
		return uri;
	}
	
	public IPath getFullPath() {
		return new Path(getURI().toString());
	}
	
	public String getName() {
		return uri.lastSegment();
	}
	
	public InputStream getContents() throws CoreException {
		try {
			return new ResourceSetImpl().getURIConverter().createInputStream(uri);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

}
