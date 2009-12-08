/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.resource;

import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Storage2UriMapperJavaImpl extends Storage2UriMapperImpl {

	private static final Logger log = Logger.getLogger(Storage2UriMapperJavaImpl.class);

	@Override
	public Iterable<IStorage> getStorages(URI uri) {
		Iterable<IStorage> storages = super.getStorages(uri);
		if (!storages.iterator().hasNext()) {
			return findStoragesInJarsOrExternalClassFolders(uri);
		}
		return storages;
	}

	@Override
	protected URI internalGetUri(IStorage storage) {
		URI uri = super.internalGetUri(storage);
		if (uri != null)
			return uri;
		return computeUriForStorageInJarOrExternalClassFolder(storage);
	}

	protected Iterable<IStorage> findStoragesInJarsOrExternalClassFolders(URI uri) {
		Set<IStorage> result = Sets.newHashSet();
		if (uri.isArchive()) {
			URI toArchive = getPathToArchive(uri);
			IProject[] projects = getWorkspaceRoot().getProjects();
			for (IProject iProject : projects) {
				if (iProject.isAccessible()) {
					IJavaProject project = JavaCore.create(iProject);
					findStoragesInJarsOrExternalFoldersOfProject(toArchive, uri, project, result);
				}
			}
		}
		return result;
	}

	protected void findStoragesInJarsOrExternalFoldersOfProject(URI toArchive, URI uri, IJavaProject project,
			Set<IStorage> storages) {
		if (project.exists()) {
			try {
				IPackageFragmentRoot[] fragmentRoots = project.getAllPackageFragmentRoots();
				for (IPackageFragmentRoot fragRoot : fragmentRoots) {
					if (!"org.eclipse.jdt.launching.JRE_CONTAINER".equals(fragRoot.getRawClasspathEntry().getPath()
							.toString())) {
						if (getUriForPackageFragmentRoot(fragRoot).equals(toArchive)) {
							IStorage storage = findStorageInJar(uri, fragRoot);
							if (storage != null)
								storages.add(storage);
						}
					}
				}
			} catch (JavaModelException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	protected IStorage findStorageInJar(URI toArchive, IPackageFragmentRoot fragRoot) throws JavaModelException {
		final String path = toArchive.devicePath().substring(toArchive.authority().length());
		return new JarWalker<IStorage>() {
			@Override
			protected IStorage handle(IJarEntryResource jarEntry) {
				if (jarEntry.getFullPath().toString().equals(path))
					return jarEntry;
				return null;
			}
		}.traverse(fragRoot, true);
	}

	protected URI computeUriForStorageInJarOrExternalClassFolder(IStorage storage) {
		if (storage instanceof IJarEntryResource) {
			URI uri = getUriForIJarEntryResource((IJarEntryResource) storage);
			if (isValidUri(uri))
				return uri;
		}
		return null;
	}

	protected URI getUriForIJarEntryResource(IJarEntryResource resource) {
		IJarEntryResource jarEntry = resource;
		IPackageFragmentRoot root = jarEntry.getPackageFragmentRoot();
		URI jarURI = getUriForPackageFragmentRoot(root);
		URI storageURI = URI.createURI(jarEntry.getFullPath().toString());
		return createJarURI(jarURI, storageURI);
	}

	protected URI getUriForPackageFragmentRoot(IPackageFragmentRoot root) {
		IResource underlyingResource = root.getResource();
		if (underlyingResource == null) {
			return URI.createFileURI(root.getPath().toString());
		} else {
			return URI.createPlatformResourceURI(underlyingResource.getFullPath().toString(), true);
		}
	}

	protected URI createJarURI(URI jarURI, URI pathToResourceInURI) {
		String fullURI = "archive:" + jarURI.toString() + "!" + pathToResourceInURI.toString();
		return URI.createURI(fullURI);
	}

	protected URI getPathToArchive(URI archiveURI) {
		if (!archiveURI.isArchive())
			throw new IllegalArgumentException("not an archive URI : " + archiveURI);
		String string = archiveURI.toString();
		return URI.createURI(string.substring(archiveURI.scheme().length() + 1, string.indexOf('!')));
	}
}
