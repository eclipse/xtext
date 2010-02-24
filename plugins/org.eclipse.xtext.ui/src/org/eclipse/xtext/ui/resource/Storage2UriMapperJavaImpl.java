/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.util.SimpleCache;

import com.google.common.base.Function;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class Storage2UriMapperJavaImpl extends Storage2UriMapperImpl implements IElementChangedListener {

	private static final Logger log = Logger.getLogger(Storage2UriMapperJavaImpl.class);
	
	@Inject
	private JarEntryLocator locator;
	
	public void setLocator(JarEntryLocator locator) {
		this.locator = locator;
	}

	public Storage2UriMapperJavaImpl() {
		JavaCore.addElementChangedListener(this);
	}

	public void elementChanged(ElementChangedEvent event) {
		if (event.getType() == ElementChangedEvent.POST_CHANGE) {
			synchronized (cache) {
				cache.clear();
			}
		}
	}

	private SimpleCache<URI, Iterable<IStorage>> cache = new SimpleCache<URI, Iterable<IStorage>>(
			new Function<URI, Iterable<IStorage>>() {
				public Iterable<IStorage> apply(URI from) {
					return findStoragesInJarsOrExternalClassFolders(from);
				}
			});

	@Override
	public Iterable<IStorage> getStorages(URI uri) {
		Iterable<IStorage> storages = super.getStorages(uri);
		if (!storages.iterator().hasNext()) {
			synchronized (cache) {
				return cache.get(uri);
			}
		}
		return storages;
	}
	
	@Override
	protected boolean isValidStorageFor(URI uri, IStorage storage) {
		if (storage instanceof IFile) {
			IProject project = ((IFile) storage).getProject();
			if (!project.isAccessible() || project.isHidden())
				return false;
		}
		return true;
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
					findStoragesInJarsOfProject(toArchive, uri, project, result);
				}
			}
		} else {
			IProject[] projects = getWorkspaceRoot().getProjects();
			for (IProject project : projects) {
				if (project.isAccessible()) {
					IJavaProject javaProject = JavaCore.create(project);
					findStoragesInExternalFoldersOfProject(uri, javaProject, result);
				}
			}
		}
		return result;
	}

	protected void findStoragesInExternalFoldersOfProject(URI uri, IJavaProject project,
			Set<IStorage> storages) {
		if (project.exists()) {
			try {
				IPackageFragmentRoot[] fragmentRoots = project.getAllPackageFragmentRoots();
				for (IPackageFragmentRoot fragRoot : fragmentRoots) {
					if (fragRoot.isExternal() && !fragRoot.isArchive()) {
						IStorage storage = locator.getJarEntry(uri, fragRoot);
						if (storage != null)
							storages.add(storage);
					}
				}
			} catch (JavaModelException e) {
				if (!e.isDoesNotExist())
					log.error(e.getMessage(), e);
			}
		}
	}
	
	protected void findStoragesInJarsOfProject(URI toArchive, URI uri, IJavaProject project,
			Set<IStorage> storages) {
		if (project.exists()) {
			try {
				IPackageFragmentRoot[] fragmentRoots = project.getAllPackageFragmentRoots();
				for (IPackageFragmentRoot fragRoot : fragmentRoots) {
					if (!"org.eclipse.jdt.launching.JRE_CONTAINER".equals(fragRoot.getRawClasspathEntry().getPath()
							.toString())) {
						if (JarEntryURIHelper.getUriForPackageFragmentRoot(fragRoot).equals(toArchive)) {
							IStorage storage = locator.getJarEntry(uri, fragRoot);
							if (storage != null)
								storages.add(storage);
						}
					}
				}
			} catch (JavaModelException e) {
				if (!e.isDoesNotExist())
					log.error(e.getMessage(), e);
			}
		}
	}

	protected URI computeUriForStorageInJarOrExternalClassFolder(IStorage storage) {
		if (storage instanceof IJarEntryResource) {
			URI uri = getUriForIJarEntryResource((IJarEntryResource) storage);
			if (isValidUri(uri,storage))
				return uri;
		}
		return null;
	}

	protected URI getUriForIJarEntryResource(IJarEntryResource jarEntry) {
		return locator.getURI(jarEntry);
	}
	
	protected URI getPathToArchive(URI archiveURI) {
		if (!archiveURI.isArchive())
			throw new IllegalArgumentException("not an archive URI : " + archiveURI);
		String string = archiveURI.toString();
		return URI.createURI(string.substring(archiveURI.scheme().length() + 1, string.indexOf('!')));
	}

}
