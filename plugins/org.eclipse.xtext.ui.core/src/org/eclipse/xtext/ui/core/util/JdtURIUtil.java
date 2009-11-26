/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.util;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JdtURIUtil {

	public URI getURI(IJarEntryResource resource) {
		IJarEntryResource jarEntry = resource;
		IPackageFragmentRoot root = jarEntry.getPackageFragmentRoot();
		URI jarURI = getURI(root);
		URI storageURI = URI.createURI(jarEntry.getFullPath().toString());
		return createJarURI(jarURI, storageURI);
	}

	public URI getURI(IPackageFragmentRoot root) {
		IResource underlyingResource = root.getResource();
		if (underlyingResource == null) {
			return URI.createFileURI(root.getPath().toString());
		} else {
			return URI.createPlatformResourceURI(underlyingResource.getFullPath().toString(), true);
		}
	}

	public URI getURI(IJavaProject project, IClasspathEntry entry) {
		try {
			IPackageFragmentRoot[] roots = project.getPackageFragmentRoots();
			for (IPackageFragmentRoot root : roots) {
				if (root.getPath().equals(entry.getPath()))
					return getURI(root);
			}
			return null;
		} catch (JavaModelException e) {
			throw new WrappedException(e);
		}
	}

	public URI createJarURI(URI jarURI, URI pathToResourceInURI) {
		String fullURI = "archive:" + jarURI.toString() + "!" + pathToResourceInURI.toString();
		return URI.createURI(fullURI);
	}

	public URI getPathToArchive(URI archiveURI) {
		if (!archiveURI.isArchive())
			throw new IllegalArgumentException("not an archive URI : " + archiveURI);
		String string = archiveURI.toString();
		return URI.createURI(string.substring(archiveURI.scheme().length() + 1, string.indexOf('!')));
	}

}
