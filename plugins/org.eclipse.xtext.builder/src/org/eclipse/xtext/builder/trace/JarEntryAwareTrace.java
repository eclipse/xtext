/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperJdtExtensions;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JarEntryAwareTrace implements StorageAwareTraceContribution {

	private static final Logger log = Logger.getLogger(JarEntryAwareTrace.class);
	
	@Inject
	private IStorage2UriMapperJdtExtensions uriMapperExtensions;
	
	public URI getResolvedPathOrNull(IStorage localStorage, URI path) {
		if (localStorage instanceof IFile) {
			IProject project = ((IFile) localStorage).getProject();
			if (project != null) {
				IJavaProject javaProject = JavaCore.create(project);
				if (javaProject != null && javaProject.exists())
					return resolvePath(javaProject, path);
				return null;
			}
		} else if (localStorage instanceof IJarEntryResource) {
			return resolvePath((IJarEntryResource) localStorage, path);
		}
		return null;
	}
	
	protected URI resolvePath(IJarEntryResource jarEntry, URI path) {
		IPackageFragmentRoot packageFragmentRoot = jarEntry.getPackageFragmentRoot();
		try {
			Pair<URI, URI> pair = uriMapperExtensions.getURIMapping(packageFragmentRoot);
			if (pair != null) {
				URI first = pair.getFirst();
				if (first != null)
					return URI.createURI(first + "/" + path);
			}
		} catch (JavaModelException e) {
			log.error(e);
		}
		return path;
	}

	protected URI resolvePath(IJavaProject javaProject, URI path) {
		try {
			for (IPackageFragmentRoot root : javaProject.getPackageFragmentRoots())
				if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
					IResource resource = root.getResource();
					if (resource instanceof IFolder) {
						IFolder folder = (IFolder) resource;
						IResource candidate = folder.findMember(path.toString());
						if (candidate != null && candidate.exists())
							return URI.createPlatformResourceURI(resource.getFullPath() + "/" + path, true);
					}
				}
		} catch (JavaModelException e) {
			log.error(e);
		}
		return null;
	}
	
}
