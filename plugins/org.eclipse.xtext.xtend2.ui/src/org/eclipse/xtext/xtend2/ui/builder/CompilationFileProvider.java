/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.builder;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

public class CompilationFileProvider {
	
	public static final String TARGET_FILE_EXTENSION = "java";

	@Inject
	private IStorage2UriMapper storage2UriMapper;
	
	public IFile getFile(URI fileURI, IProject project) {
		Iterable<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(fileURI);
		if(isEmpty(storages)) {
			throw new IllegalArgumentException("Cannot detect IStorage for " + notNull(fileURI));
		}
		for(Pair<IStorage, IProject> pair: storages) {
			if(project.equals(pair.getSecond())) {
				IStorage storage = pair.getFirst();
				if(!(storage instanceof IFile)) {
					throw new IllegalArgumentException("Source file must reside in the workspace");
				}
				return (IFile) storage;
			}
		}
		throw new IllegalArgumentException("Cannot detect IFile for " + notNull(fileURI));
	}
	
	public IFile getTargetFile(URI sourceFileURI, IProject project, SubMonitor monitor) throws CoreException {
		IFile sourceFile = getFile(sourceFileURI, project);
		IPath sourceClasspathRelativePath = getClasspathRelativePath(sourceFile, getJavaProject(project));
		if(sourceClasspathRelativePath == null) 
			sourceClasspathRelativePath = sourceFile.getProjectRelativePath();
		IPath targetClasspathRelativePath = sourceClasspathRelativePath.removeFileExtension().addFileExtension(TARGET_FILE_EXTENSION);
		IFile targetFile = getTargetFolder(project, monitor).getFile(targetClasspathRelativePath);
		return targetFile;
	}
	
	public IFolder getTargetFolder(IProject project, SubMonitor monitor) throws CoreException {
		IJavaProject javaProject = getJavaProject(project);
		IFolder targetFolder = javaProject.getProject().getFolder(getTargetFolderName());
		if(!targetFolder.exists()) {
			targetFolder.create(true, true, monitor);
			makeSrcFolder(targetFolder, javaProject); 
		}
		return targetFolder;
	}
	
	public String getTargetFolderName() {
		return "xtend-gen";
	}

	protected void makeSrcFolder(IFolder folder, IJavaProject javaProject) throws JavaModelException {
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
	
	protected IPath getClasspathRelativePath(IFile file, IJavaProject javaProject) throws JavaModelException {
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
	
	protected IJavaProject getJavaProject(IProject project) throws CoreException {
		if(!project.hasNature(JavaCore.NATURE_ID)) {
			throw new IllegalStateException("Xtend files must reside in a Java project");
		}
		IJavaProject javaProject = JavaCore.create(project);
		return javaProject;
	}
	
}