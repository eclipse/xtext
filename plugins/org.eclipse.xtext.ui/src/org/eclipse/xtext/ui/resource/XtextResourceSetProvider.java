/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import static com.google.common.collect.Maps.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.util.JdtClasspathUriResolver;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextResourceSetProvider implements IResourceSetProvider {

	private final static Logger LOG = Logger.getLogger(XtextResourceSetProvider.class);

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	@Inject
	private IStorage2UriMapperJdtExtensions storage2UriMapper;

	public ResourceSet get(IProject project) {
		XtextResourceSet set = resourceSetProvider.get();
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject != null && javaProject.exists()) {
			set.getURIConverter().getURIMap().putAll(computePlatformURIMap(javaProject));
			set.setClasspathURIContext(javaProject);
			set.setClasspathUriResolver(new JdtClasspathUriResolver());
		}
		return set;
	}

	protected Map<URI, URI> computePlatformURIMap(IJavaProject javaProject) {
		HashMap<URI, URI> hashMap = newHashMap();
		try {
			hashMap.putAll(EcorePlugin.computePlatformURIMap());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		if (!javaProject.exists())
			return hashMap;
		try {
			IPackageFragmentRoot[] roots = javaProject.getAllPackageFragmentRoots();
			for (IPackageFragmentRoot root : roots) {
				try {
					Pair<URI,URI> mapping = storage2UriMapper.getURIMapping(root);
					if (mapping != null) {
						hashMap.put(mapping.getFirst(), mapping.getSecond());
					}
				} catch (JavaModelException e) {
					LOG.error(e.getMessage(), e);
				}
			}
			try {
				final IProject project = javaProject.getProject();
				IPath location = project.getLocation();
				if (location != null)
					hashMap.put(URI.createPlatformResourceURI(project.getName(), true), URI.createFileURI(location.toFile().getPath()));
				else 
					System.out.println(project);
				IProject[] projects = project.getReferencedProjects();
				for (IProject iProject : projects) {
					location = iProject.getLocation();
					if (location != null)
						hashMap.put(URI.createPlatformResourceURI(iProject.getName(), true), URI.createFileURI(location.toFile().getPath()));
				}
			} catch (CoreException e) {
				LOG.error(e.getMessage(), e);
			}
		} catch (JavaModelException e) {
			LOG.error(e.getMessage(), e);
		}
		return hashMap;
	}

}
