/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.resources.ResourceLoader;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.resource.ClasspathUriUtil;

import com.google.common.collect.Lists;

/**
 * <code>XtendXtext2EcorePostProcessor</code> specialization which enables the xtend post processing file to refer to
 * classes and resources which are available from the classpath of the containing {@link IJavaProject}.
 * 
 * @author Michael Clay
 * @author Knut Wannheden
 */
public class ProjectAwareXtendXtext2EcorePostProcessor extends XtendXtext2EcorePostProcessor implements
		IResourceChangeListener {

	private static final Logger logger = Logger.getLogger(ProjectAwareXtendXtext2EcorePostProcessor.class);
	
	private Resource xtendFile;
	private ResourceLoader resourceLoader;

	@Override
	protected synchronized Resource loadXtendFile(GeneratedMetamodel metamodel) {
		if (xtendFile == null) {
			xtendFile = super.loadXtendFile(metamodel);
			if (xtendFile != null) {
				ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
			}
		}
		return xtendFile;
	}

	@Override
	protected synchronized ResourceLoader getResourceLoader(GeneratedMetamodel metamodel) {
		if (resourceLoader != null)
			return resourceLoader;

		URI uri = metamodel.eResource().getURI();
		if (ClasspathUriUtil.isClasspathUri(uri)) {
			ResourceSet resourceSet = metamodel.eResource().getResourceSet();
			uri = resourceSet.getURIConverter().normalize(uri);
		}
		IFile grammarFile = getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		IJavaProject javaProject = JavaCore.create(grammarFile.getProject());
		try {
			if (javaProject.exists()) {
				ClassLoader classLoader = createClassLoader(javaProject);
				resourceLoader = new ResourceLoaderImpl(classLoader);
				return resourceLoader;
			}
		}
		catch (CoreException e) {
			logger.error("Error creating execution context for java project '" + grammarFile.getProject().getName()
					+ "'", e);
		}
		return super.getResourceLoader(metamodel);
	}

	protected ClassLoader createClassLoader(IJavaProject javaProject) throws CoreException {
		List<URL> urls = Lists.newArrayListWithExpectedSize(javaProject.getResolvedClasspath(true).length);
		try {
			IWorkspaceRoot workspaceRoot = getWorkspace().getRoot();
			urls.addAll(getOutputFolders(javaProject));
			for (IClasspathEntry entry : javaProject.getResolvedClasspath(true)) {
				IPath path = null;
				URL url = null;
				switch (entry.getEntryKind()) {
					case IClasspathEntry.CPE_SOURCE:
						break;
					case IClasspathEntry.CPE_PROJECT:
						IResource project = workspaceRoot.findMember(entry.getPath());
						urls.addAll(getOutputFolders(JavaCore.create(project.getProject())));
						break;
					default:
						path = entry.getPath();
						url = path.toFile().toURL();
						break;
				}
				if (url != null) {
					urls.add(url);
				}
			}
		}
		catch (MalformedURLException e) {
			logger.error(
					"Error creating class loader for java project '" + javaProject.getProject().getName() + "'", e);
		}
		return new URLClassLoader(urls.toArray(new URL[urls.size()]), getClass().getClassLoader());
	}

	private List<URL> getOutputFolders(IJavaProject javaProject) throws CoreException, MalformedURLException {
		List<URL> result = Lists.newArrayListWithExpectedSize(1);
		IPath path = javaProject.getOutputLocation().addTrailingSeparator();
		URL url = new URL(URI.createPlatformResourceURI(path.toString(), true).toString());
		result.add(url);
		for (IClasspathEntry entry : javaProject.getRawClasspath()) {
			switch (entry.getEntryKind()) {
				case IClasspathEntry.CPE_SOURCE:
					path = entry.getOutputLocation();
					if (path != null) {
						url = new URL(URI.createPlatformResourceURI(
								path.addTrailingSeparator().toString(), true).toString());
						result.add(url);
					}
					break;
				default:
					break;
			}
		}
		return result;
	}

	public synchronized void resourceChanged(IResourceChangeEvent event) {
		xtendFile = null;
		resourceLoader = null;
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
	}
}