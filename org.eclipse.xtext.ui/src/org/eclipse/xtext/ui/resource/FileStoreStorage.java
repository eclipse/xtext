/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import java.io.InputStream;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IEncodedStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * {@link IEncodedStorage} implementation for external files. Used to support open reference for external files.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class FileStoreStorage implements IEncodedStorage {
	private final IFileStore fileStore;
	private final IFileInfo fileInfo;
	private final Path filePath;

	public FileStoreStorage(IFileStore fileStore, IFileInfo fileInfo, Path filePath) {
		this.fileStore = fileStore;
		this.fileInfo = fileInfo;
		this.filePath = filePath;
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		return null;
	}

	@Override
	public InputStream getContents() throws CoreException {
		return fileStore.openInputStream(EFS.NONE, null);
	}

	@Override
	public IPath getFullPath() {
		return filePath;
	}

	@Override
	public String getName() {
		return filePath.lastSegment();
	}

	@Override
	public boolean isReadOnly() {
		return fileInfo.getAttribute(EFS.ATTRIBUTE_READ_ONLY);
	}

	public IFileStore getFileStore() {
		return fileStore;
	}

	@Override
	public String getCharset() throws CoreException {
		 // encoding unknown, use default encoding
		return ResourcesPlugin.getWorkspace().getRoot().getDefaultCharset();
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof FileStoreStorage)) {
			return false;
		}
		return filePath.equals(((FileStoreStorage) object).filePath);
	}

	@Override
	public int hashCode() {
		return filePath.hashCode();
	}

}