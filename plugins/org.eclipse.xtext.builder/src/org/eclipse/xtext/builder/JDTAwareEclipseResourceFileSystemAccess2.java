/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.Collection;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Multimap;

/**
 * A specialization of the EclipseResourceFileSystemAccess2 for languages that produce
 * Java code. If code is written to a folder that is not yet a source folder, it will be
 * automatically added as a source folder.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class JDTAwareEclipseResourceFileSystemAccess2 extends EclipseResourceFileSystemAccess2 {

	private static final Logger LOG = Logger.getLogger(JDTAwareEclipseResourceFileSystemAccess2.class);
	
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
			IPackageFragmentRoot currentSource = jp.findPackageFragmentRoot(jp.getPath().append(getCurrentSource()));
			if (currentSource != null) {
				IClasspathEntry currentClasspathEntry = currentSource.getRawClasspathEntry();
				if (currentClasspathEntry != null) {
					insertClasspathEntry(container, currentClasspathEntry, jp);
					return;
				}
			}
			addClasspathEntry(container, jp);
		}
	}

	/**
	 * @param prototype settings will be copied from the prototype and the new entry is inserted after that one.
	 */
	private void insertClasspathEntry(IContainer folder, IClasspathEntry prototype, IJavaProject project)
			throws JavaModelException {
		IClasspathEntry newEntry = JavaCore.newSourceEntry(
				folder.getFullPath(),
				prototype.getInclusionPatterns(),
				prototype.getExclusionPatterns(),
				prototype.getOutputLocation(),
				prototype.getExtraAttributes());
		IClasspathEntry[] classPath = project.getRawClasspath();
		IClasspathEntry[] newClassPath = new IClasspathEntry[classPath.length + 1];
		int i = 0;
		for(IClasspathEntry entry: classPath) {
			newClassPath[i++] = entry;
			if (entry.equals(prototype)) {
				newClassPath[i++] = newEntry;
			}
		}
		// should not happen, but to be sure
		if (i == newClassPath.length - 1 && newClassPath[i] == null) {
			LOG.warn("Cannot find classpath entry '" + prototype + "'");
			newClassPath[i] = newEntry;
		}
		project.setRawClasspath(newClassPath, getMonitor());
	}

	private void addClasspathEntry(IContainer folder, IJavaProject project) throws JavaModelException {
		IClasspathEntry srcFolderClasspathEntry = JavaCore.newSourceEntry(folder.getFullPath());
		IClasspathEntry[] classPath = project.getRawClasspath();
		IClasspathEntry[] newClassPath = new IClasspathEntry[classPath.length + 1];
		System.arraycopy(classPath, 0, newClassPath, 0, classPath.length);
		newClassPath[newClassPath.length - 1] = srcFolderClasspathEntry;
		project.setRawClasspath(newClassPath, getMonitor());
	}
	
	/**
	 * Since sourceTraces are relative the URI has to be computed with the currentSource as context
	 */
	@Override
	public void flushSourceTraces(String generatorName) throws CoreException {
		Multimap<SourceRelativeURI, IPath> sourceTraces = getSourceTraces();
		if (sourceTraces != null) {
			Set<SourceRelativeURI> keys = sourceTraces.keySet();
			String source = getCurrentSource();
			IContainer container = Strings.isEmpty(source) ? getProject() : getProject().getFolder(source);
			for (SourceRelativeURI uri : keys) {
				if (uri != null && source != null) {
					Collection<IPath> paths = sourceTraces.get(uri);
					IFile sourceFile = container.getFile(new Path(uri.getURI().path()));
					if (sourceFile.exists()) {
						IPath[] tracePathArray = paths.toArray(new IPath[paths.size()]);
						getTraceMarkers().installMarker(sourceFile, generatorName, tracePathArray);
					}
				}
			}
		}
		resetSourceTraces();
	}
}
