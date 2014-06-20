/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.builder;

import static com.google.common.collect.Maps.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.xtext.builder.ParallelBuilderParticipant;
import org.eclipse.xtext.generator.FileSystemAccessQueue;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Anton Kosyakov - parallel support
 */
public class XtendParallelBuilderParticipant extends ParallelBuilderParticipant {

	private static Logger LOGGER = Logger.getLogger(XtendParallelBuilderParticipant.class);

	@Inject
	private IStorage2UriMapper mapper;

	@Inject
	private ElementIssueProvider.Factory elementIssueProviderFactory;
	
	@Override
	protected void handleChangedContents(Delta delta, IBuildContext context, IFileSystemAccess access)
			throws CoreException {
		if (!getResourceServiceProvider().canHandle(delta.getUri()))
			return;
		Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		IFile file = getFile(resource, context);
		if (file != null) {
			getGenerator().doGenerate(resource, access);
		}
	}
	
	@Override
	protected Runnable createRunnable(
			final Delta delta,
			final IBuildContext context,
			final Map<String, OutputConfiguration> outputConfigurations,
			final Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers,
			final FileSystemAccessQueue fileSystemAccessQueue,
			final IFileSystemAccess delegate,
			final IProgressMonitor progressMonitor) {
		IFile file = null;
		Resource resource = null;
		if (delta.getNew() != null) {
			resource = context.getResourceSet().getResource(delta.getUri(), true);
			file = getFile(resource, context);
		}
		return createRunnable(delta, file, resource, context, outputConfigurations, generatorMarkers, fileSystemAccessQueue, delegate, progressMonitor);
	}

	protected Runnable createRunnable(
			final Delta delta,
			final IFile file,
			final Resource resource,
			final IBuildContext context,
			final Map<String, OutputConfiguration> outputConfigurations,
			final Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers,
			final FileSystemAccessQueue fileSystemAccessQueue,
			final IFileSystemAccess delegate, 
			final IProgressMonitor progressMonitor) {
		if (file != null) {
			elementIssueProviderFactory.attachData(resource);
		}
		return new Runnable() {

			public void run() {
				try {
					try {
						Set<IFile> derivedResources = getDerivedResources(delta, outputConfigurations, generatorMarkers);
					
						IFileSystemAccess fsa = getParalleFileSystemAccess(delta, context, derivedResources, fileSystemAccessQueue, delegate, progressMonitor);
						boolean generated = doGenerate(delta, context, fsa);
					
						fileSystemAccessQueue.sendAsync(delta.getUri(), getFlushAndCleanDerivedResourcesCallback(delta, derivedResources, context, generated, delegate, progressMonitor));
					} finally {
						if (file != null) {
							fileSystemAccessQueue.sendAsync(delta.getUri(), new Procedure0() {
		
								public void apply() {
									elementIssueProviderFactory.detachData(resource);
								}
		
							});
						}
					}
				} catch (Throwable e) {
					logErrorDuringCompilation(delta.getUri(), e);
				}
			}

		};
	}

	protected IFile getFile(Resource resource, IBuildContext context) {
		Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(resource.getURI());
		for (Pair<IStorage, IProject> pair : storages) {
			if (pair.getFirst() instanceof IFile && pair.getSecond().equals(context.getBuiltProject())) {
				return (IFile) pair.getFirst();
			}
		}
		return null;
	}

	/**
	 * @since 2.4
	 */
	protected List<IPath> getSourceFolderPathes(IProject project) {
		List<IPath> sourceFolder = Lists.newArrayList();
		try {
			if (project.isOpen() && JavaProject.hasJavaNature(project)) {
				IJavaProject javaProject = JavaCore.create(project);
				List<IPackageFragmentRoot> packageFragmentRoots = Arrays.asList(javaProject.getPackageFragmentRoots());
				for (IPackageFragmentRoot packageFragmentRoot : packageFragmentRoots) {
					if (packageFragmentRoot.getKind() == IPackageFragmentRoot.K_SOURCE) {
						IPath path = packageFragmentRoot.getPath();
						sourceFolder.add(path);
					}
				}
			}
		} catch (JavaModelException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return sourceFolder;
	}

	@Override
	protected Map<OutputConfiguration, Iterable<IMarker>> getGeneratorMarkers(IProject builtProject,
			Collection<OutputConfiguration> outputConfigurations) throws CoreException {
		Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers = newHashMap();
		List<IPath> sourcePath = getSourceFolderPathes(builtProject);
		for (OutputConfiguration config : outputConfigurations) {
			if (config.isCleanUpDerivedResources()) {
				List<IContainer> containerToSearchIn = Lists.newArrayList();
				for (IPath sourceFolder : sourcePath) {
					if (sourceFolder.segmentCount() == 1) {
						containerToSearchIn.add(builtProject);
					} else {
						IContainer sourcePathBasedContainer = builtProject.getWorkspace().getRoot()
								.getFolder(sourceFolder);
						containerToSearchIn.add(sourcePathBasedContainer);
					}
				}
				Collection<IMarker> markers = Lists.newArrayList();
				for (IContainer container : containerToSearchIn) {
					Iterables.addAll(
							markers,
							getDerivedResourceMarkers().findDerivedResourceMarkers(container,
									getGeneratorIdProvider().getGeneratorIdentifier()));
				}
				generatorMarkers.put(config, markers);
			}
		}
		return generatorMarkers;
	}

}
