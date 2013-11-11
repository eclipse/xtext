/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ClasspathEntry;
import org.eclipse.jdt.internal.core.util.Util;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.DefaultResourceUIServiceProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendResourceUiServiceProvider extends DefaultResourceUIServiceProvider {

	@Inject
	public XtendResourceUiServiceProvider(IResourceServiceProvider delegate) {
		super(delegate);
	}
	
	@Override
	public boolean canHandle(URI uri) {
		return super.canHandle(uri);
	}
	
	@Override
	public boolean canBuild(URI uri, IStorage storage) {
		// we don't want to build+index .xtend files from JARs, because cross references target .class files
		if (storage instanceof IFile) {
			IFile file = (IFile) storage;
			IProject project = file.getProject();
			IJavaProject javaProject = JavaCore.create(project);
			return isInSourceFolder(javaProject, file);
		}
		return false;
	}

	public boolean isInSourceFolder(IJavaProject javaProject, IFile resource) {
		IPath path = resource.getFullPath();
		IClasspathEntry[] classpath;
		try {
			classpath = javaProject.getResolvedClasspath(true);
		} catch(JavaModelException e){
			return false; // not a Java project
		}
		for (int i = 0; i < classpath.length; i++) {
			IClasspathEntry entry = classpath[i];
			if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				IPath entryPath = entry.getPath();
				if (entryPath.isPrefixOf(path) && !isExcluded(entry, path)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isExcluded(IClasspathEntry entry, IPath path) {
		char[][] inclusionPatterns = getInclusionPatterns(entry);
		char[][] exclusionPatterns = getExclusionPatterns(entry);
		return Util.isExcluded(path, inclusionPatterns, exclusionPatterns, false);
	}

	private char[][] getInclusionPatterns(IClasspathEntry entry) {
		if (entry instanceof ClasspathEntry) {
			ClasspathEntry classpathEntry = (ClasspathEntry) entry;
			return classpathEntry.fullInclusionPatternChars();
		}
		return toFullPatternChars(entry, entry.getInclusionPatterns());
	}

	private char[][] getExclusionPatterns(IClasspathEntry entry) {
		if (entry instanceof ClasspathEntry) {
			ClasspathEntry classpathEntry = (ClasspathEntry) entry;
			return classpathEntry.fullExclusionPatternChars();
		}
		return toFullPatternChars(entry, entry.getExclusionPatterns());
	}
	
	private char[][] toFullPatternChars(IClasspathEntry entry, IPath[] patterns) {
		if (patterns == null) {
			return null;
		}
		int length = patterns.length;
		char[][] fullPatternChars = new char[length][];
		IPath prefixPath = entry.getPath().removeTrailingSeparator();
		for (int i = 0; i < length; i++) {
			fullPatternChars[i] = prefixPath.append(patterns[i]).toString().toCharArray();
		}
		return fullPatternChars;
	}
	
}
