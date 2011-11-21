/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import org.eclipse.compare.IResourceProvider;
import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.compare.structuremergeviewer.IDiffContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class CompareInputResourceProvider implements IResourceProvider {
	private ICompareInput compareInput;
	private ITypedElement typedElement;

	public CompareInputResourceProvider(ICompareInput compareInput, ITypedElement typedElement) {
		Assert.isNotNull(compareInput, "parameter 'compareInput' must not be null");
		Assert.isNotNull(typedElement, "parameter 'typedElement' must not be null");
		this.compareInput = compareInput;
		this.typedElement = typedElement;
	}

	public IResource getResource() {
		IResource resource = getResource(typedElement);
		if (resource == null) {
			if (typedElement == compareInput.getLeft()) {
				resource = getResource(compareInput.getRight());
			} else {
				resource = getResource(compareInput.getLeft());
			}
		}
		if (resource == null && compareInput instanceof ITypedElement) {
			resource = getResource((ITypedElement) compareInput);
		}
		return resource;
	}

	@SuppressWarnings("restriction")
	protected IResource getResource(ITypedElement typedElement) {
		IResource result = null;
		if (typedElement instanceof IResourceProvider) {
			IResourceProvider resourceProvider = (IResourceProvider) typedElement;
			result = resourceProvider.getResource();
		} else if (typedElement instanceof org.eclipse.team.internal.ui.StorageTypedElement) {
			org.eclipse.team.internal.ui.StorageTypedElement storageTypedElement = (org.eclipse.team.internal.ui.StorageTypedElement) typedElement;
			IStorage bufferedStorage = storageTypedElement.getBufferedStorage();
			result = getExistingFile(bufferedStorage != null ? bufferedStorage.getFullPath() : Path.EMPTY);
		}
		if (result == null) {
			String[] path = getPath(typedElement, 0);
			for (int i = 0; i < path.length && result == null; i++) {
				IProject project = getWorkspaceRoot().getProject(path[i]);
				if (project.exists()) {
					String concatenatedPath = Strings.concat(String.valueOf(IPath.SEPARATOR), Lists.newArrayList(path)
							.subList(i, path.length));
					result = getExistingFile(new Path(concatenatedPath));
				}
			}
		}
		return result;
	}

	private IResource getExistingFile(IPath fullPath) {
		IFile file = getWorkspaceRoot().getFile(fullPath);
		if (file.exists()) {
			return file;
		}
		return null;
	}

	private IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	private String[] getPath(ITypedElement typedElement, int level) {
		String[] path = null;
		if (typedElement instanceof IDiffContainer) {
			IDiffContainer parent = ((IDiffContainer) typedElement).getParent();
			if (parent != null) {
				path = getPath(parent, level + 1);
			}
		}
		if (path == null) {
			path = new String[level + 1];
		}
		path[(path.length - 1) - level] = typedElement.getName();
		return path;
	}

}