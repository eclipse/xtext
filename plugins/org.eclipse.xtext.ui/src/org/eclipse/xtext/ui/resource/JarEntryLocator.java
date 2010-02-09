/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ExternalPackageFragmentRoot;
import org.eclipse.xtext.ui.resource.PackageFragmentRootWalker.TraversalState;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JarEntryLocator {

	private static final Logger log = Logger.getLogger(JarEntryLocator.class);
	
	public URI getURI(final IJarEntryResource jarEntry) {
		final IPackageFragmentRoot root = jarEntry.getPackageFragmentRoot();
		if (root.isArchive()) {
			URI jarURI = JarEntryURIHelper.getUriForPackageFragmentRoot(root);
			URI storageURI = URI.createURI(jarEntry.getFullPath().toString());
			return createJarURI(root.isArchive(), jarURI, storageURI);
		} else if (root.isExternal()) {
			if (root instanceof ExternalPackageFragmentRoot) {
				try {
					return new PackageFragmentRootWalker<URI>() {
						@Override
						protected URI handle(IJarEntryResource current, TraversalState state) {
							if (current.equals(jarEntry)) {
								return getURI(root, current, state);	
							}
							return null;
						}
					}.traverse(root, true);
				} catch(JavaModelException ex) {
					if (!ex.isDoesNotExist())
						log.error(ex.getMessage(), ex);
				}
			} else {
				throw new IllegalStateException("Unexpeced root type: " + root.getClass().getName());
			}
		}
		return null;
	}
	
	public IJarEntryResource getJarEntry(final URI uri, final IPackageFragmentRoot root) {
		try {
			try {
				if (root.isArchive()) {
					final String path = uri.devicePath().substring(uri.authority().length());
					return new PackageFragmentRootWalker<IJarEntryResource>() {
						@Override
						protected IJarEntryResource handle(IJarEntryResource jarEntry, TraversalState state) {
							if (jarEntry.getFullPath().toString().equals(path))
								return jarEntry;
							return null;
						}
					}.traverse(root, true);
				} else if (root instanceof ExternalPackageFragmentRoot) {
					IResource resource = ((ExternalPackageFragmentRoot) root).resource();
					IPath uriAsPath = new Path(uri.toPlatformString(true));
					IPath absolutePath = resource.getFullPath(); // external folder link
					if (absolutePath.isPrefixOf(uriAsPath)) {
						return new PackageFragmentRootWalker<IJarEntryResource>() {
							@Override
							protected IJarEntryResource handle(IJarEntryResource jarEntry, TraversalState state) {
								URI entryURI = getURI(root, jarEntry, state);
								if (entryURI.equals(uri))
									return jarEntry;
								return null;
							}
						}.traverse(root, true);
					}
				} else {
					throw new IllegalStateException("Unexpeced root type: " + root.getClass().getName());
				}
			} catch(JavaModelException ex) {
				if (!ex.isDoesNotExist())
					log.error(ex.getMessage(), ex);
			}
		} catch(NullPointerException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public URI getURI(IPackageFragmentRoot root, IJarEntryResource jarEntry, TraversalState state) {
		if (root.isArchive()) {
			URI jarURI = JarEntryURIHelper.getUriForPackageFragmentRoot(root);
			URI storageURI = URI.createURI(jarEntry.getFullPath().toString());
			return createJarURI(root.isArchive(), jarURI, storageURI);
		} else if (root instanceof ExternalPackageFragmentRoot) {
			IResource resource = ((ExternalPackageFragmentRoot) root).resource();
			IPath result = resource.getFullPath();
			for(int i = 1; i < state.getParents().size(); i++) {
				Object obj = state.getParents().get(i);
				if (obj instanceof IPackageFragment) {
					result = result.append(new Path(((IPackageFragment) obj).getElementName().replace('.', '/')));
				} else if (obj instanceof IJarEntryResource) {
					result = result.append(((IJarEntryResource) obj).getName());
				}
			}
			result = result.append(jarEntry.getName());
			return URI.createPlatformResourceURI(result.toString(), true);			
		} else {
			throw new IllegalStateException("Unexpeced root type: " + root.getClass().getName());
		}
	}
	
	protected URI createJarURI(boolean isArchive, URI uriToRoot, URI pathToResourceInRoot) {
		if (isArchive) {
			String fullURI = "archive:" + uriToRoot.toString() + "!" + pathToResourceInRoot.toString();
			return URI.createURI(fullURI);
		} else {
			return null;
		}
	}
}
