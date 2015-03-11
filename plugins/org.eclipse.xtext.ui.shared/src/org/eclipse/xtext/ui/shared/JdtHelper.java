/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.ui.shared.internal.Activator;
import org.eclipse.xtext.ui.util.IJdtHelper;

import com.google.inject.Singleton;

/*
 * Important note:
 * ===============
 * Neither the interface nor the implementation class(es) may
 * expose any types from jdt.core in its signatures or use
 * any exceptions from jdt.core in catch clauses.
 */
/**
 * Default implementation of the {@link IJdtHelper}.
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.1
 */
@Singleton
public class JdtHelper implements IJdtHelper {

	private static final Logger log = Logger.getLogger(JdtHelper.class);
	
	private final boolean javaCoreAvailable;
	
	public JdtHelper() {
		javaCoreAvailable = computeJavaCoreAvailable();
	}
	
	protected boolean computeJavaCoreAvailable() {
		return Activator.isJavaEnabled();
	}

	@Override
	public boolean isJavaCoreAvailable() {
		return javaCoreAvailable;
	}
	
	// TODO consider caching the output path's per project
	// TODO have a more detailed look at other clients of #getOutputLocation to get the corner cases right
	@Override
	public boolean isFromOutputPath(IResource resource) {
		IProject project = resource.getProject();
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject != null && javaProject.exists()) {
			try {
				IPath defaultOutputLocation = javaProject.getOutputLocation();
				IPath resourcePath = resource.getFullPath();
				if (defaultOutputLocation != null && !defaultOutputLocation.isEmpty() && defaultOutputLocation.isPrefixOf(resourcePath)) {
					return true;
				}
				IClasspathEntry[] classpathEntries = javaProject.getRawClasspath();
				for(IClasspathEntry classpathEntry: classpathEntries) {
					if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
						IPath specializedOutputLocation = classpathEntry.getOutputLocation();
						if (specializedOutputLocation != null) {
							if (!specializedOutputLocation.equals(classpathEntry.getPath()) && 
									specializedOutputLocation.isPrefixOf(resourcePath)) {
								return true;
							}
						}
					}
				}
			} catch(CoreException e) {
				if (log.isDebugEnabled())
					log.debug("Error in isJavaTargetFolder():" + e.getMessage(), e);
			}
		}
		return false;
	}
}
