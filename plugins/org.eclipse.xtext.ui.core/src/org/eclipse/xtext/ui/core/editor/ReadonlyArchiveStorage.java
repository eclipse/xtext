/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReadonlyArchiveStorage extends ReadonlyStorage {

	private final ZipFile file;

	private final ZipEntry entry;

	public ReadonlyArchiveStorage(URI uri) throws IOException {
		super(URI.createURI(uri.scheme() + ":" + uri.devicePath()));
		URI archiveUri = URI.createURI(uri.authority());
		String archive = null;
		if (archiveUri.isFile()) {
			archive = archiveUri.toFileString();
		} else if (archiveUri.isPlatformResource()) {
			archive = archiveUri.toPlatformString(true);
		} else {
			archive = archiveUri.toString();
		}
		archive = archive.substring(0, archive.length() - 1);
		File file = new File(archive);
		if (!file.exists())
			throw new IOException("file does not exist: " + uri);
		this.file = new ZipFile(file);
		String path = uri.path().substring(1);
		this.entry = this.file.getEntry(path);
	}

	public InputStream getContents() throws CoreException {
		try {
			InputStream result = file.getInputStream(entry);
			return result;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public IPath getFullPath() {
		return new Path(getURI().toString());
	}

	public String getName() {
		return entry.getName();
	}

}
