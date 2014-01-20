/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FolderAwareTrace extends AbstractTrace {

	private IProject project;
	private URI uri;
	private String folder;

	@Override
	public IProject getLocalProject() {
		return project;
	}

	@Override
	public URI getLocalURI() {
		return uri;
	}

	protected void setProject(IProject project) {
		this.project = project;
	}

	protected void setUri(URI uri) {
		this.uri = uri;
	}

	@Override
	protected IStorage findStorage(URI uri, IProject project) {
		// there are no storages inside a plain folder
		return null;
	}

	public void setRootFolder(String folder) {
		if (!folder.endsWith("/"))
			folder = folder + "/";
		this.folder = folder;
	}

	protected File findFile(File container, String candiadate) {
		File[] files = container.listFiles();
		if (files != null) {
			for (File child : files) {
				if (child.isFile()) {
					if (child.getAbsolutePath().endsWith(candiadate))
						return child;
				} else if (child.isDirectory()) {
					File result = findFile(child, candiadate);
					if (result != null)
						return result;
				}
			}
		}
		return null;
	}

	@Override
	protected InputStream getContents(URI uri, IProject project) throws CoreException {
		try {
			File container = new File(folder);
			if (!container.exists())
				return null;
			File file = findFile(container, uri.toString());
			if (file == null)
				return null;
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new CoreException(new Status(IStatus.ERROR, "", e.getMessage(), e));
		}
	}

}
