/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import static com.google.common.collect.Maps.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.util.JdtClasspathUriResolver;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextResourceSetProvider implements IResourceSetProvider {

	private final static Logger LOG = Logger.getLogger(XtextResourceSetProvider.class);

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

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
		HashMap<URI, URI> hashMap = newHashMap(EcorePlugin.computePlatformURIMap());
		try {
			if (!javaProject.exists())
				return hashMap;
			IClasspathEntry[] classpath = javaProject.getResolvedClasspath(true);
			for (IClasspathEntry classPathEntry : classpath) {
				IPath path = classPathEntry.getPath();
				if (path != null && "jar".equals(path.getFileExtension())) {
					try {
						final File file = path.toFile();
						if (file != null && file.exists()) {
							JarFile jarFile = new JarFile(file);
							Manifest manifest = jarFile.getManifest();
							if (manifest != null) {
								String name = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
								if (name != null) {
									final int indexOf = name.indexOf(';');
									if (indexOf > 0)
										name = name.substring(0, indexOf);
									if (!EcorePlugin.getPlatformResourceMap().containsKey(name)) {
										String p = "archive:" + file.toURI() + "!/";
										URI uri = URI.createURI(p);
										final URI platformResourceKey = URI.createPlatformResourceURI(name + "/", false);
										final URI platformPluginKey = URI.createPlatformPluginURI(name + "/", false);
										hashMap.put(platformResourceKey, uri);
										hashMap.put(platformPluginKey, uri);
									}
								}
							}
						}
					} catch (IOException e) {
						LOG.error(e.getMessage(), e);
					}
				}
			}
		} catch (JavaModelException e) {
			LOG.error(e.getMessage(), e);
		}
		return hashMap;
	}

}
