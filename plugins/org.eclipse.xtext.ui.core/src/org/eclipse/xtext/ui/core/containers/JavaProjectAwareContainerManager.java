/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.containers;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.core.resource.IStorage2UriMapper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class JavaProjectAwareContainerManager implements IContainer.Manager {

	private final static Logger log = Logger.getLogger(JavaProjectAwareContainerManager.class);
	
	@Inject
	private IStorage2UriMapper mapper;

	public IContainer getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		IPackageFragmentRoot root = getPackageFragmentRoot(desc.getURI(), resourceDescriptions);
		if (root == null) {
			log.warn("Cannot find IPackageFragmentRoot for: " + desc.getURI());
			return IContainer.Null;
		}
		return createContainer(root, resourceDescriptions);
	}

	public List<IContainer> getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		IPackageFragmentRoot root = getPackageFragmentRoot(desc.getURI(), resourceDescriptions);
		if (root == null) {
			log.warn("Cannot find IPackageFragmentRoot for: " + desc.getURI());
			return Collections.emptyList();
		}
		IJavaProject javaProject = root.getJavaProject();
		return getVisibleContainers(javaProject, resourceDescriptions);
	}

	protected IContainer createContainer(IPackageFragmentRoot root, IResourceDescriptions resourceDescriptions) {
		JavaElementBasedContainer result = new JavaElementBasedContainer(resourceDescriptions, root,mapper);
		return result;
	}

	protected List<IContainer> getVisibleContainers(IJavaProject project, IResourceDescriptions resourceDescriptions) {
		List<IContainer> result = Lists.newArrayList();
		try {
			IPackageFragmentRoot[] roots = project.getAllPackageFragmentRoots();
			for (IPackageFragmentRoot root : roots) {
				if (root != null && !"org.eclipse.jdt.launching.JRE_CONTAINER".equals(root.getRawClasspathEntry().getPath().toString()))
					result.add(createContainer(root, resourceDescriptions));
			}
		} catch (JavaModelException e) {
			if (!e.isDoesNotExist()) {
				log.error("Cannot find visibleContainers in project " + project.getProject().getName(), e);
			}
		}
		return result;
	}

	protected IPackageFragmentRoot getPackageFragmentRoot(URI uri, IResourceDescriptions resourceDescriptions) {
		if (uri.isArchive()) {
			return getJarWithEntry(uri);
		}
		final IFile file = getWorkspaceRoot().getFile(new Path(uri.toPlatformString(true)));
		if (file == null) {
			return null;
		}
		return getJavaElement(file);
	}

	protected IPackageFragmentRoot getJavaElement(final IFile file) {
		IJavaProject jp = JavaCore.create(file.getProject());
		if (!jp.exists())
			return null;
		IPackageFragmentRoot[] roots;
		try {
			roots = jp.getPackageFragmentRoots();
			for (IPackageFragmentRoot root : roots) {
				if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
					IResource resource2 = root.getUnderlyingResource();
					if (resource2.contains(file))
						return root;
				}
			}
		} catch (JavaModelException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	protected IPackageFragmentRoot getJarWithEntry(URI uri) {
		Iterable<IStorage> storages = mapper.getStorages(uri);
		for (IStorage storage : storages) {
			if (storage instanceof IJarEntryResource) {
				IPackageFragmentRoot fragmentRoot = ((IJarEntryResource) storage).getPackageFragmentRoot();
				if (fragmentRoot != null)
					return fragmentRoot;
			}
		}
		return null;
	}

	protected IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

}
