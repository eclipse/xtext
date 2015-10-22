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

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 * @deprecated use {@link BuilderParticipant} instead
 */
@Deprecated
public class JavaProjectBasedBuilderParticipant implements IXtextBuilderParticipant {

	private final static Logger logger = Logger.getLogger(JavaProjectBasedBuilderParticipant.class);
	
	@Inject
	private GeneratorDelegate generator;

	@Inject
	private Provider<EclipseResourceFileSystemAccess> fileAccessProvider;

	@Inject
	private IResourceServiceProvider resourceServiceProvider;

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	private Map<URI, Set<String>> sourceTargetMap = newHashMap();

	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		final IProject builtProject = context.getBuiltProject();
		IJavaProject javaProject = JavaCore.create(builtProject);
		if (!javaProject.exists())
			return;
		final IFolder srcGenFolder = getSrcGenFolder(builtProject);
		if (!srcGenFolder.exists())
			return;
		if (!isValidOutputFolder(javaProject, srcGenFolder))
			return;
		for (IResourceDescription.Delta delta : context.getDeltas()) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			final Set<String> oldFiles = newHashSet();
			if (sourceTargetMap.containsKey(delta.getUri())) {
				oldFiles.addAll(sourceTargetMap.get(delta.getUri()));
			}
			final Set<String> newFiles = newHashSet();
			IFileSystemAccess fileSystemAccess = getConfiguredFileSystemAccess(srcGenFolder, new IAcceptor<String>() {
				@Override
				public void accept(String fileName) {
					oldFiles.remove(fileName);
					newFiles.add(fileName);
				}
			});
			if (delta.getNew() == null) {
				handleDeletion(delta, context, fileSystemAccess);
			} else {
				try {
					handleChangedContents(delta, context, fileSystemAccess);
				} catch (Exception e) {
					logger.error("Error during compilation of '"+delta.getUri()+"'.", e);
				}
			}
			for (String removeFile : oldFiles) {
				fileSystemAccess.deleteFile(removeFile);
			}
			if (!newFiles.isEmpty()) {
				sourceTargetMap.put(delta.getUri(), newFiles);
			}
		}
	}

	/**
	 * @since 2.0
	 */
	protected boolean isValidOutputFolder(IJavaProject javaProject, final IFolder srcGenFolder) {
		return srcGenFolder != null && srcGenFolder.exists();
	}

	/**
	 * @since 2.0
	 */
	protected IFolder getSrcGenFolder(final IProject builtProject) {
		return builtProject.getFolder("src-gen");
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
		if (shouldGenerate(resource, context)) {
			generator.generate(resource, (IFileSystemAccess2) fileSystemAccess, CancelIndicator.NullImpl);
			context.needRebuild();
		}
	}

	protected boolean shouldGenerate(Resource resource, IBuildContext context) {
		try {
			Iterable<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(resource.getURI());
			for (Pair<IStorage, IProject> pair : storages) {
				if (pair.getFirst() instanceof IFile && pair.getSecond().equals(context.getBuiltProject())) {
					return((IFile) pair.getFirst()).findMaxProblemSeverity(null, true, IResource.DEPTH_INFINITE) != IMarker.SEVERITY_ERROR;
				}
			}
			return false;
		} catch (CoreException exc) {
			throw new WrappedException(exc);
		}
	}

	protected void handleDeletion(Delta delta, IBuildContext context, IFileSystemAccess fileSystemAccess) {
	}

}
