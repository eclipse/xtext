/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ExternalPackageFragmentRoot;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.util.Wrapper;

@SuppressWarnings("restriction")
public class JdtClasspathUriResolver implements IClasspathUriResolver {

	private IJavaElement javaElement;

	public URI resolve(Object context, URI classpathUri) {
		if (!(context instanceof IJavaElement)) {
			throw new IllegalArgumentException("Context must implement IResource");
		}
		javaElement = (IJavaElement) context;
		try {
			if (ClasspathUriUtil.isClasspathUri(classpathUri)) {
				IJavaProject javaProject = javaElement.getJavaProject();
				URI result = findResourceInWorkspace(javaProject, classpathUri);
				if (classpathUri.fragment() != null)
					result = result.appendFragment(classpathUri.fragment());
				return result;
			}
		}
		catch (Exception exc) {
			throw new ClasspathUriResolutionException(exc);
		}
		return classpathUri;
	}

	protected URI findResourceInWorkspace(IJavaProject javaProject, URI classpathUri) throws JavaModelException,
			CoreException {
		if (javaProject.exists()) {
			String path = classpathUri.trimSegments(1).path();
			String fullPath = classpathUri.path();
			final String name = classpathUri.lastSegment();
			String packageName = path.substring(1).replace('/', '.');	
			for(IPackageFragmentRoot packageFragmentRoot: javaProject.getAllPackageFragmentRoots()) {
				IJavaElement foundElement = packageFragmentRoot.getPackageFragment(packageName);
				if (foundElement instanceof IPackageFragment && foundElement.exists()) {
					IPackageFragment packageFragment = (IPackageFragment) foundElement;
					IResource packageFragmentResource = packageFragment.getResource();
					if (packageFragmentResource == null || packageFragmentResource instanceof IFile) {
						Object[] nonJavaResources = packageFragment.getNonJavaResources();
						for(Object nonJavaResource: nonJavaResources) {
							// we have to check for concrete class because getFullPath
							// behaves differently
							IJarEntryResource jarEntryResource = (IJarEntryResource) nonJavaResource;
							if (packageFragmentRoot.isArchive()) {
								if (fullPath.equals(jarEntryResource.getFullPath().toString())) {
									IResource packageFragmentRootResource = packageFragmentRoot.getResource();
									if (packageFragmentRootResource != null) { // we have a resource - use nested platform/resource
										URI packageFragmentRootURI = createPlatformResourceURI(packageFragmentRootResource);
										URI result = createArchiveURI(packageFragmentRootURI, fullPath);
										return result;
									} else {
										// no resource - use file uri
										IPath packageFragmentRootPath = packageFragmentRoot.getPath();
										URI packageFragmentRootURI = URI.createFileURI(packageFragmentRootPath.toString());
										URI result = createArchiveURI(packageFragmentRootURI, fullPath);
										return result;
									}
								}
							} else {
								String nonJavaResourceName = jarEntryResource.getName();
								if (name.equals(nonJavaResourceName)) {
									if (packageFragmentRoot.isExternal()) {
										// the following code will return null
//										IResource resource = packageFragmentRoot.getUnderlyingResource();
										if (!(packageFragmentRoot instanceof ExternalPackageFragmentRoot))
											throw new IllegalStateException();
										IResource resource = ((ExternalPackageFragmentRoot)packageFragmentRoot).resource();
										IPath absolutePath = resource.getFullPath();
										absolutePath = absolutePath.append(fullPath);
										return createPlatformResourceURI(absolutePath);
									}
								}
							}
						}
					} else {
						final Wrapper<IResource> result = Wrapper.<IResource>wrap(null);
						packageFragmentResource.accept(new IResourceVisitor() {
							public boolean visit(IResource resource) throws CoreException {
								if (name.equals(resource.getName()))
									result.set(resource);
								return result.get() == null;
							}
						}, IResource.DEPTH_ONE, IResource.NONE);
						if (result.get() != null)
							return createPlatformResourceURI(result.get());
					}
				}
			}
		}
		return classpathUri;
	}

	protected URI createArchiveURI(URI baseURI, String entryPath) {
		URI result = URI.createURI("archive:" + baseURI.toString() + "!" + entryPath);
		return result;
	}

	protected URI createPlatformResourceURI(IResource resource) {
		IPath resourcePath = resource.getFullPath();
		return createPlatformResourceURI(resourcePath);
	}

	private URI createPlatformResourceURI(IPath resourcePath) {
		URI result = URI.createPlatformResourceURI(resourcePath.toString(), true);
		return result;
	}

}
