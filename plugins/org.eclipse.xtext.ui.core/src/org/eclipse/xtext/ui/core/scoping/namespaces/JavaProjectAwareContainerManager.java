/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaProjectAwareContainerManager implements IContainer.Manager {

	public IContainer getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		IPackageFragmentRoot root = getContainerJavaElement(desc.getURI(),resourceDescriptions);
		return createContainer(root,resourceDescriptions);
	}
	
	public IContainer createContainer(IPackageFragmentRoot root, IResourceDescriptions resourceDescriptions) {
		JavaElementBasedContainer result = new JavaElementBasedContainer(resourceDescriptions, root);
		return result;
	}

	public List<IContainer> getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		IJavaElement element = getContainerJavaElement(desc.getURI(),resourceDescriptions);
		IJavaProject javaProject = element.getJavaProject();
		return getVisibleContainers(javaProject,resourceDescriptions);
	}
	
	public List<IContainer> getVisibleContainers(IJavaProject project, IResourceDescriptions resourceDescriptions) {
		try {
			IPackageFragmentRoot[] roots = project.getAllPackageFragmentRoots();
			List<IContainer> result = Lists.newArrayListWithExpectedSize(roots.length);
			for(IPackageFragmentRoot root: roots) {
				result.add(createContainer(root, resourceDescriptions));
			}
			return result;
		} catch (JavaModelException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public IPackageFragmentRoot getContainerJavaElement(URI uri, IResourceDescriptions resourceDescriptions) {
		if (uri.isArchive()) {
			return getJarWithEntry(uri, resourceDescriptions);
		}
		final IFile file = getWorkspaceRoot().getFile(new Path(uri.toPlatformString(true)));
		if (file == null) {
			throw new IllegalArgumentException("could not find IFile for " + uri);
		}
		return getJavaElement(file);
	}
	
	private IPackageFragmentRoot getJavaElement(final IFile file) {
		IJavaElement result = JavaCore.create(file);
		IJavaElement fragmentRoot = result.getAncestor(IJavaElement.PACKAGE_FRAGMENT_ROOT);
		if (fragmentRoot == null)
			throw new IllegalArgumentException("uri does not represent a valid javaElement");
		return (IPackageFragmentRoot) fragmentRoot;
	}
	
	public IPackageFragmentRoot getJarWithEntry(URI uri, IResourceDescriptions resourceDescriptions) {
		IResourceDescription persistentDescription = resourceDescriptions.getResourceDescription(uri);
		if (persistentDescription instanceof IPersistentResourceDescription) {
			IStorage storage = ((IPersistentResourceDescription) persistentDescription).getStorage();
			if (storage instanceof IJarEntryResource) {
				IPackageFragmentRoot fragmentRoot = ((IJarEntryResource) storage).getPackageFragmentRoot();
				if (fragmentRoot != null)
					return fragmentRoot;
			}
		}
		throw new IllegalArgumentException("uri does not represent a valid javaElement");
	}

	private IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}
	
}
