/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StorageUtilImpl implements StorageUtil {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(StorageUtilImpl.class);
	
	public String toExternalString(IStorage storage) {
		if (storage instanceof IFile) {
			IFile file = (IFile) storage;
			return file.getFullPath().toString();
		}
		throw new UnsupportedOperationException();
	}

	public IStorage getStorage(String externalString) {
		IWorkspaceRoot ws = workspaceRoot();
		IPath location = new Path(externalString);
		IFile result = ws.getFile(location);
		if (result == null)
			return ws.getFileForLocation(location);
		return result;
	}

	protected IWorkspaceRoot workspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}
}
