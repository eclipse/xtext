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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
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
			hashMap.putAll(EcorePlugin.computePlatformURIMap(false));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		if (!javaProject.exists())
			return hashMap;
		try {
			IPackageFragmentRoot[] roots = javaProject.getAllPackageFragmentRoots();
			for (IPackageFragmentRoot root : roots) {
				Pair<URI, URI> uriMapping = storage2UriMapper.getURIMapping(root);
				if (uriMapping != null) {
					
					// we could just install the prefix mapping, i.e. platform:resource/my.project/ -> file:/my/path/to/my.project/
					// but then we wouldn't be able to load resources when using hosted bundles, because the target path points to the bin folder.
					// so instead we install qualified file mappings, which also makes normalization faster (i.e. just a lookup in a map instead of testing prefix URIs)
					//
					Map<URI, IStorage> mapping = storage2UriMapper.getAllEntries(root);
					for (URI key : mapping.keySet()) {
						IStorage storage = mapping.get(key);
						URI physicalURI = null;
						if (storage instanceof IFile) {
							physicalURI = URI.createPlatformResourceURI(storage.getFullPath().toString(), true);
						} else {
							physicalURI = key.replacePrefix(uriMapping.getFirst(), uriMapping.getSecond());
						}
						hashMap.put(key, physicalURI);
						if (key.isPlatformResource()) {
							URI pluginURI = URI.createPlatformPluginURI(key.toPlatformString(false), false);
							hashMap.put(pluginURI, physicalURI);
						}
					}
				}
			}
			final IProject project = javaProject.getProject();
			for (IProject iProject : project.getWorkspace().getRoot().getProjects()) {
				if (iProject.isAccessible()) {
					IPath location = iProject.getLocation();
					if (location != null) {
						// append a trailing slash so that URI.isPrefix is true.
						hashMap.put(URI.createPlatformResourceURI(iProject.getName()+"/", true), URI.createFileURI(location.toFile().getPath()+"/"));
					}
				}
			}
		} catch (JavaModelException e) {
			LOG.error(e.getMessage(), e);
		}
		return hashMap;
	}

}
