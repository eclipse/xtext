/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class JDTAwareEclipseResourceFileSystemAccess2 extends EclipseResourceFileSystemAccess2 {

	/*
	 * Overridden to convince the API tooling that this method still exists.
	 */
	@Override
	@Deprecated
	protected void createFolder(IFolder folder) throws CoreException {
		super.createFolder(folder);
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	protected void createContainer(IContainer container) throws CoreException {
		super.createContainer(container);
		addToSourceFolders(container);
	}
	
	/**
	 * @since 2.6
	 */
	protected void addToSourceFolders(IContainer container) throws JavaModelException {
		IJavaProject jp = JavaCore.create(container.getProject());
		if (jp.exists() && !jp.isOnClasspath(container)) {
			IClasspathEntry srcFolderClasspathEntry = JavaCore.newSourceEntry(container.getFullPath());
			IClasspathEntry[] classPath = jp.getRawClasspath();
			IClasspathEntry[] newClassPath = new IClasspathEntry[classPath.length + 1];
			System.arraycopy(classPath, 0, newClassPath, 1, classPath.length);
			newClassPath[0] = srcFolderClasspathEntry;
			jp.setRawClasspath(newClassPath, getMonitor());
		}
	}
}
