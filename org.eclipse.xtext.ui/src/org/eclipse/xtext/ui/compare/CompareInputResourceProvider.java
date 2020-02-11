/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import java.util.Collections;
import java.util.List;

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

import com.google.common.base.Joiner;
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

	@Override
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

	protected IResource getResource(ITypedElement typedElement) {
		if (typedElement == null) {
			return null;
		}
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
			IProject projectFromInput = getProjectFromInput();
			List<String> path = getPath(typedElement);
			for (int i = 0; i < path.size() && result == null; i++) {
				IProject project = getWorkspaceRoot().getProject(path.get(i));
				String subPath = IPath.SEPARATOR + Joiner.on(IPath.SEPARATOR).join(path.subList(i, path.size()));
				if (project.exists()) {
					result = getExistingFile(new Path(subPath));
				} else if (projectFromInput != null) {
					String pathInProject = IPath.SEPARATOR + projectFromInput.getName() + subPath;
					result = getExistingFile(new Path(pathInProject));
				}
			}
		}
		return result;
	}
	
	private IProject getProjectFromInput() {
		if(this.compareInput instanceof IResourceProvider) {
			IResource res = ((IResourceProvider)this.compareInput).getResource();
			if(res != null)
				return res.getProject();
		}
		return null;
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
	
	private List<String> getPath(ITypedElement typedElement) {
		List<String> names = Lists.newArrayList(typedElement.getName());
		ITypedElement current = typedElement;
		while (current instanceof IDiffContainer) {
			names.add(current.getName());
			current = ((IDiffContainer) current).getParent();
		}
		Collections.reverse(names);
		List<String> segments = Lists.newArrayList();
		for (String name : names)
			if (!Strings.isEmpty(name))
				for (String seg : name.split("/"))
					segments.add(seg);
		return segments;
	}

}