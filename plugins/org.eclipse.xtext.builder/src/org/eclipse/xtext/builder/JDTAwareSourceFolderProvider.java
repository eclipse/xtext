/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
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

	public List<? extends IContainer> getSourceFolders(IProject project) {
		List<IFolder> sourceFolders = Lists.newArrayList();
		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] classpath;
		try {
			classpath = javaProject.getRawClasspath();
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
		for (IClasspathEntry entry : classpath) {
			if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				sourceFolders.add(project.getWorkspace().getRoot().getFolder(entry.getPath()));
			}
		}
		return sourceFolders;
	}

}
