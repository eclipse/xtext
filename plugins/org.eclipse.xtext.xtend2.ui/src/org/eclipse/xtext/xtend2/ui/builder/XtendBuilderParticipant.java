/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.builder;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendBuilderParticipant extends BuilderParticipant {
	
	private static Logger LOGGER = Logger.getLogger(XtendBuilderParticipant.class);

	@Inject
	private IStorage2UriMapper mapper;
	
	@Override
	protected void handleChangedContents(Delta delta, IBuildContext context, EclipseResourceFileSystemAccess2 fileSystemAccess) throws CoreException {
		if (!getResourceServiceProvider().canHandle(delta.getUri()))
			return;
		Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		if (shouldGenerate(resource, context)) {
			try {
				registerCurrentSourceFolder(delta, fileSystemAccess);
				getGenerator().doGenerate(resource, fileSystemAccess);
			} catch (RuntimeException e) {
				if (e.getCause() instanceof CoreException) {
					throw (CoreException) e.getCause();
				}
				throw e;
			}
		}
	}

	protected void registerCurrentSourceFolder(Delta delta, EclipseResourceFileSystemAccess2 fileSystemAccess) {
		if (fileSystemAccess instanceof SourceRelativeFileSystemAccess) {
			try {
				Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(delta.getUri());
				for (Pair<IStorage, IProject> pair : storages) {
					IJavaProject javaProject = JavaCore.create(pair.getSecond());
					final IResource first = (IResource)pair.getFirst();
					IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
					for (IPackageFragmentRoot root : roots) {
						if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
							final IResource underlyingResource = root.getUnderlyingResource();
							if (underlyingResource instanceof IFolder && underlyingResource.contains(first)) {
								((SourceRelativeFileSystemAccess) fileSystemAccess).setCurrentSource((IFolder)underlyingResource);
								return;
							}
						}
					}
				}
			} catch (CoreException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}
}
