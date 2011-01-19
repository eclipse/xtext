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
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

public class CompilationFileProvider {
	
	public static final String TARGET_FILE_EXTENSION = "java";

	@Inject
	private IStorage2UriMapper storage2UriMapper;
	
	@Inject
	private JDTUtil jdtUtils;

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
		IPath sourceClasspathRelativePath = jdtUtils.getClasspathRelativePath(sourceFile, jdtUtils.getJavaProject(project));
		IPath targetClasspathRelativePath = sourceClasspathRelativePath.removeFileExtension().addFileExtension(TARGET_FILE_EXTENSION);
		IFile targetFile = getTargetFolder(project, monitor).getFile(targetClasspathRelativePath);
		return targetFile;
	}
	
	public IFolder getTargetFolder(IProject project, SubMonitor monitor) throws CoreException {
		IJavaProject javaProject = jdtUtils.getJavaProject(project);
		IFolder targetFolder = javaProject.getProject().getFolder(getTargetFolderName());
		if(!targetFolder.exists()) {
			targetFolder.create(true, true, monitor);
			jdtUtils.makeSrcFolder(targetFolder, javaProject); 
		}
		return targetFolder;
	}
	
	protected String getTargetFolderName() {
		return "xtend2-gen";
	}
	
}