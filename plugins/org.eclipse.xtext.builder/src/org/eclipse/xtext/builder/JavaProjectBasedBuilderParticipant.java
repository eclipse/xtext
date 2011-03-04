/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JavaProjectBasedBuilderParticipant implements IXtextBuilderParticipant {
	
	@Inject
	private IGenerator generator;
	
	@Inject
	private Provider<EclipseResourceFileSystemAccess> fileAccessProvider;
	
	@Inject
	private IResourceServiceProvider resourceServiceProvider;
	
	private Map<URI, Set<String>> sourceTargetMap = newHashMap();
	
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		IJavaProject javaProject = JavaCore.create(context.getBuiltProject());
		if (!javaProject.exists())
			return;
		final IFolder srcGenFolder = context.getBuiltProject().getFolder("src-gen");
		if (!srcGenFolder.exists())
			return;
		IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(srcGenFolder);
		if (!root.exists())
			return;
		for (IResourceDescription.Delta delta : context.getDeltas()) {
			final Set<String> oldFiles = newHashSet();
			if(sourceTargetMap.containsKey(delta.getUri())) {
				oldFiles.addAll(sourceTargetMap.get(delta.getUri()));
			}
			final Set<String> newFiles = newHashSet();
			IFileSystemAccess fileSystemAccess = getConfiguredFileSystemAccess(srcGenFolder, new IAcceptor<String>() {
				public void accept(String fileName) {
					oldFiles.remove(fileName);
					newFiles.add(fileName);
				}
			});
			if (delta.getNew() == null) {
				handleDeletion(delta, context, fileSystemAccess);
			} else {
				handleChangedContents(delta, context, fileSystemAccess);
			}
			for(String removeFile: oldFiles) {
				fileSystemAccess.deleteFile(removeFile);
			}
			if(!newFiles.isEmpty()) {
				sourceTargetMap.put(delta.getUri(), newFiles);
			}
		}
	}

	protected IFileSystemAccess getConfiguredFileSystemAccess(IFolder srcGenFolder, IAcceptor<String> newFileAcceptor) {
		EclipseResourceFileSystemAccess access = fileAccessProvider.get();
		access.setOutputPath(srcGenFolder.getFullPath().toString());
		access.setNewFileAcceptor(newFileAcceptor);
		return access;
	}

	protected void handleChangedContents(Delta delta, IBuildContext context, IFileSystemAccess fileSystemAccess) {
		if (!resourceServiceProvider.canHandle(delta.getUri()))
			return;
		Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		if (shouldGenerate(resource)) {
			generator.doGenerate(resource, fileSystemAccess);
			context.needRebuild();
		}
	}

	protected boolean shouldGenerate(Resource resource) {
		return resource.getErrors().isEmpty();
	}

	protected void handleDeletion(Delta delta, IBuildContext context, IFileSystemAccess fileSystemAccess) {
	}

}
