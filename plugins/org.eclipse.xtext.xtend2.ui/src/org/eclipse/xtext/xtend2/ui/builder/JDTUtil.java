/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JDTUtil {

	public void makeSrcFolder(IFolder folder, IJavaProject javaProject) throws JavaModelException {
		IClasspathEntry newSourceEntry = JavaCore.newSourceEntry(folder.getFullPath());
		IClasspathEntry[] newClassPath;
		IClasspathEntry[] classPath = javaProject.getRawClasspath();
		for (IClasspathEntry classPathEntry : classPath) {
			if (classPathEntry.equals(newSourceEntry)) {
				return;
			}
		}
		newClassPath = new IClasspathEntry[classPath.length + 1];
		System.arraycopy(classPath, 0, newClassPath, 1, classPath.length);
		newClassPath[0] = newSourceEntry;
		javaProject.setRawClasspath(newClassPath, null);
	}
	
	public IPath getClasspathRelativePath(IFile file, IJavaProject javaProject) throws JavaModelException {
		IPath filePath = file.getFullPath();
		for(IClasspathEntry classpathEntry : javaProject.getResolvedClasspath(true)) {
			if(IClasspathEntry.CPE_SOURCE == classpathEntry.getEntryKind()) {
				IPath path = classpathEntry.getPath();
				if(path.isPrefixOf(filePath)) {
					return filePath.makeRelativeTo(path);
				}
			}
		}
		return null;
	}
	
	public IJavaProject getJavaProject(IProject project) throws CoreException {
		if(!project.hasNature(JavaCore.NATURE_ID)) {
			throw new IllegalStateException("Xtend2 files must reside in a Java project");
		}
		IJavaProject javaProject = JavaCore.create(project);
		return javaProject;
	}

}
