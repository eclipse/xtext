/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.util;

import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ExternalPackageFragmentRoot;
import org.eclipse.jdt.internal.core.JarPackageFragmentRoot;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.IClasspathUriResolver;

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

	protected static URI findResourceInWorkspace(IJavaProject javaProject, URI classpathUri) throws JavaModelException,
			CoreException {
		Path fullPath = new Path(classpathUri.path());
		String projectRelativePath = fullPath.toString();
		if (javaProject.exists()) {
			IPackageFragmentRoot[] allPackageFragmentRoots = javaProject.getAllPackageFragmentRoots();
			for (IPackageFragmentRoot packageFragmentRoot : allPackageFragmentRoots) {
				IResource correspondingResource = packageFragmentRoot.getCorrespondingResource();
				if ((correspondingResource != null && correspondingResource instanceof IFile)
						|| packageFragmentRoot instanceof JarPackageFragmentRoot) {
					// jar file
					JarPackageFragmentRoot jarPackageFragmentRoot = (packageFragmentRoot instanceof JarPackageFragmentRoot) ? (JarPackageFragmentRoot) packageFragmentRoot
							: (JarPackageFragmentRoot) JavaCore
									.createJarPackageFragmentRootFrom((IFile) correspondingResource);
					if (jarPackageFragmentRoot != null) {
						URI resourceUri = findUriInJarFile(projectRelativePath, jarPackageFragmentRoot);
						if(resourceUri != null) {
							return resourceUri;
						}
					}
				}
				else {
					// folder
					IFolder rootFolder = null;
					// path as fallback necessary due to jdt bug #264776
					IPath path = null;
					if (correspondingResource instanceof IFolder) {
						rootFolder = (IFolder) correspondingResource;
					}
					else if (packageFragmentRoot instanceof ExternalPackageFragmentRoot) {
						IResource resource = ((ExternalPackageFragmentRoot) packageFragmentRoot).resource();
						path = ((ExternalPackageFragmentRoot) packageFragmentRoot).getPath();
						if (resource instanceof IFolder) {
							rootFolder = (IFolder) resource;
						}
					}
					if (rootFolder != null) {
						IResource modelFile = rootFolder.findMember(projectRelativePath);
						// modelFile.exists() is sometimes false, even if it exists
						if (modelFile != null && modelFile.exists() && modelFile instanceof IFile) {
							URI platformResourceUri = URI.createPlatformResourceURI(modelFile.getFullPath().toString(),
									true);
							return platformResourceUri;
						}
					}
					// fallback for jdt bug #264776
					if (path != null) {
						path = path.append(fullPath);
						File f = path.toFile();
						if (f.exists() && f.isFile()) {
							URI fileUri = URI.createFileURI(f.getAbsolutePath());
							return fileUri;
						}
					}
				}
			}
		}
		return classpathUri;
	}

	private static URI findUriInJarFile(String projectRelativePath, JarPackageFragmentRoot jarPackageFragmentRoot)
			throws CoreException {
		ZipFile zipFile = jarPackageFragmentRoot.getJar();
		if (zipFile != null) {
			ZipEntry zipEntry = zipFile.getEntry(projectRelativePath.substring(1));
			if (zipEntry != null) {
				IResource resource = jarPackageFragmentRoot.resource();
				if (resource == null) {
					resource = jarPackageFragmentRoot.getUnderlyingResource();
					if (resource == null) {
						String name = zipFile.getName();
						return getZipEntryUri(projectRelativePath, name);
					}
				}
				return URI.createURI(
						"archive:" + "platform:/resource" + resource.getFullPath() + "!" + projectRelativePath, true);
			}
		}
		return null;
	}

	/**
	 * Have a look at the JdtClasspahtUriResolverTest to get an idea about the semantics
	 * of this method. The tests are actually deactivated, because this implementation is
	 * sort of platform dependent.
	 */
	public static URI getZipEntryUri(String projectRelativePath, String osDependentName) {
		String name = osDependentName.replace('\\', '/');
		URI fileURI = URI.createFileURI(name);
		String uri = "archive:" + fileURI + "!" + projectRelativePath;
		return URI.createURI(uri);
	}

}
