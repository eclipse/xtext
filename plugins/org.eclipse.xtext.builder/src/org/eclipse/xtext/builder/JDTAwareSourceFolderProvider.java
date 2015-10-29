/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import com.google.common.collect.Lists;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class JDTAwareSourceFolderProvider implements EclipseSourceFolderProvider {
	static final Logger log = Logger.getLogger(JDTAwareSourceFolderProvider.class);

	@Override
	public List<? extends IContainer> getSourceFolders(IProject project) {
		List<IContainer> sourceFolders = Lists.newArrayList();
		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] classpath;
		if (!javaProject.exists()) {
			return Collections.emptyList();
		}
		try {
			classpath = javaProject.getRawClasspath();
		} catch (JavaModelException e) {
			log.error("Error determining source folders for project " + project.getName(), e);
			return Collections.emptyList();
		}
		for (IClasspathEntry entry : classpath) {
			if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				IPath path = entry.getPath();
				// see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=436371
				if (path.segmentCount() == 1) {
					sourceFolders.add(project);
				} else {
					sourceFolders.add(project.getWorkspace().getRoot().getFolder(entry.getPath()));
				}
			}
		}
		return sourceFolders;
	}

}
