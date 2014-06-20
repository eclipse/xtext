/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.builder;

import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;

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
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.FileSystemAccessQueue;
import org.eclipse.xtext.builder.ParallelBuilderParticipant;
import org.eclipse.xtext.builder.ParallelFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendParallelBuilderParticipant extends ParallelBuilderParticipant {

	private static Logger LOGGER = Logger.getLogger(XtendParallelBuilderParticipant.class);

	@Inject
	private IStorage2UriMapper mapper;

	@Inject
	private ElementIssueProvider.Factory elementIssueProviderFactory;

	@Override
	protected Runnable createRunnable(
			final Delta delta,
			final org.eclipse.xtext.builder.IXtextBuilderParticipant.IBuildContext context,
			final java.util.Map<String, OutputConfiguration> outputConfigurations,
			final java.util.Map<OutputConfiguration, java.lang.Iterable<IMarker>> generatorMarkers,
			final java.util.concurrent.BlockingQueue<org.eclipse.xtext.xbase.lib.Pair<Delta, org.eclipse.xtext.xbase.lib.Procedures.Procedure2<? super org.eclipse.xtext.generator.IFileSystemAccess, ? super org.eclipse.core.runtime.IProgressMonitor>>> requestQueue) {
		if (!getResourceServiceProvider().canHandle(delta.getUri()))
			return null;
		final Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		final IFile file = getFile(resource, context);
		if (file != null) {
			elementIssueProviderFactory.attachData(resource);
			return new Runnable() {

				public void run() {
					try {

						FileSystemAccessQueue fileSystemAccessQueue = new FileSystemAccessQueue(requestQueue);
						try {
							final Set<IFile> derivedResources = newLinkedHashSet();

							final String uri = delta.getUri().toString();
							for (OutputConfiguration config : outputConfigurations.values()) {
								if (config.isCleanUpDerivedResources()) {
									Iterable<IMarker> markers = generatorMarkers.get(config);
									for (IMarker marker : markers) {
										String source = getDerivedResourceMarkers().getSource(marker);
										if (source != null && source.equals(uri))
											derivedResources.add((IFile) marker.getResource());
									}
								}
							}

							String currentSourceFolder = getCurrentSourceFolder(context, delta);
							getGenerator().doGenerate(
									resource,
									new ParallelFileSystemAccess(delta, fileSystemAccessQueue, currentSourceFolder,
											new EclipseResourceFileSystemAccess2.IFileCallback() {

												public boolean beforeFileDeletion(IFile file) {
													derivedResources.remove(file);
													context.needRebuild();
													return true;
												}

												public void afterFileUpdate(IFile file) {
													handleFileAccess(file);
												}

												public void afterFileCreation(IFile file) {
													handleFileAccess(file);
												}

												protected void handleFileAccess(IFile file) {
													try {
														derivedResources.remove(file);
														getDerivedResourceMarkers().installMarker(file, uri);
														context.needRebuild();
													} catch (CoreException e) {
														throw new RuntimeException(e);
													}
												}

											}));

							fileSystemAccessQueue.put(delta, new Procedure2<IFileSystemAccess, IProgressMonitor>() {

								public void apply(IFileSystemAccess access, IProgressMonitor deleteMonitor) {
									try {
										if (access instanceof EclipseResourceFileSystemAccess2) {
											EclipseResourceFileSystemAccess2 eclipseAccess = (EclipseResourceFileSystemAccess2) access;
											eclipseAccess.flushSourceTraces();
											for (IFile iFile : newLinkedHashSet(derivedResources)) {
												IMarker marker = getDerivedResourceMarkers().findDerivedResourceMarker(
														iFile, uri);
												if (marker != null)
													marker.delete();
												if (getDerivedResourceMarkers().findDerivedResourceMarkers(iFile).length == 0) {
													eclipseAccess.deleteFile(iFile, deleteMonitor);
													context.needRebuild();
												}
											}
										}
									} catch (CoreException e) {
										throw new RuntimeException(e);
									}
								}

							});
						} finally {
							fileSystemAccessQueue.put(delta, new Procedure2<IFileSystemAccess, IProgressMonitor>() {

								public void apply(IFileSystemAccess access, IProgressMonitor deleteMonitor) {
									elementIssueProviderFactory.detachData(resource);
								}

							});
						}
					} catch (Throwable e) {
						logErrorDuringCompilation(delta, e);
					}
				}

			};
		}
		return null;
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
