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

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 * @since 2.1
 */
public class BuilderParticipant implements IXtextBuilderParticipant {
	@Inject
	private Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider;
	
	@Inject
	private IGenerator generator;
	
	@Inject
	private IResourceServiceProvider resourceServiceProvider;
	
	@Inject
	private IStorage2UriMapper storage2UriMapper;
	
	@Inject
	private DerivedResourceMarkers derivedResourceMarkers;
	
	private EclipseOutputConfigurationProvider outputConfigurationProvider;
	private BuilderPreferenceAccess builderPreferenceAccess;

	public BuilderPreferenceAccess getBuilderPreferenceAccess() {
		return builderPreferenceAccess;
	}

	@Inject
	public void setBuilderPreferenceAccess(BuilderPreferenceAccess builderPreferenceAccess) {
		this.builderPreferenceAccess = builderPreferenceAccess;
	}
	
	public EclipseOutputConfigurationProvider getOutputConfigurationProvider() {
		return outputConfigurationProvider;
	}
	
	/**
	 * @since 2.2
	 */
	public IGenerator getGenerator() {
		return generator;
	}
	
	/**
	 * @since 2.2
	 */
	public IResourceServiceProvider getResourceServiceProvider() {
		return resourceServiceProvider;
	}

	@Inject
	public void setOutputConfigurationProvider(EclipseOutputConfigurationProvider outputConfigurationProvider) {
		this.outputConfigurationProvider = outputConfigurationProvider;
	}

	public void build(final IBuildContext context, IProgressMonitor monitor) throws CoreException {
		if (!isEnabled(context)) {
			return;
		}
		final int numberOfDeltas = context.getDeltas().size();
		
		// monitor handling
		if (monitor.isCanceled())
			throw new OperationCanceledException();
		SubMonitor subMonitor = SubMonitor.convert(monitor, numberOfDeltas + 3);
		
		EclipseResourceFileSystemAccess2 access = fileSystemAccessProvider.get();
		final IProject builtProject = context.getBuiltProject();
		access.setProject(builtProject);
		final Map<String, OutputConfiguration> outputConfigurations = getOutputConfigurations(context);
		refreshOutputFolders(context, outputConfigurations, subMonitor.newChild(1));
		access.setOutputConfigurations(outputConfigurations);
		if (context.getBuildType() == BuildType.CLEAN || context.getBuildType() == BuildType.RECOVERY) {
			SubMonitor cleanMonitor = SubMonitor.convert(subMonitor.newChild(1), outputConfigurations.size());
			for (OutputConfiguration config : outputConfigurations.values()) {
				cleanOutput(context, config, cleanMonitor.newChild(1));
			}
			if (context.getBuildType() == BuildType.CLEAN)
				return;
		}
		for (int i = 0 ; i < numberOfDeltas ; i++) {
			final IResourceDescription.Delta delta = context.getDeltas().get(i);
			
			// monitor handling
			if (subMonitor.isCanceled())
				throw new OperationCanceledException();
			subMonitor.subTask("Compiling "+delta.getUri().lastSegment()+" ("+i+" of "+numberOfDeltas+")");
			access.setMonitor(subMonitor.newChild(1));
			
			final String uri = delta.getUri().toString();
			final Set<IFile> derivedResources = newLinkedHashSet();
			for (OutputConfiguration config : outputConfigurations.values()) {
				if (config.isCleanUpDerivedResources()) {
					List<IFile> resources = derivedResourceMarkers.findDerivedResources(builtProject.getFolder(config.getOutputDirectory()), uri);
					derivedResources.addAll(resources);
				}
			}
			access.setPostProcessor(new EclipseResourceFileSystemAccess2.IFileCallback() {
				
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
						derivedResourceMarkers.installMarker(file, uri);
						context.needRebuild();
					} catch (CoreException e) {
						throw new RuntimeException(e);
					}
				}
				
			});
			if (delta.getNew() != null) {
				handleChangedContents(delta, context, access);
			}
			SubMonitor deleteMonitor = SubMonitor.convert(subMonitor.newChild(1), derivedResources.size());
			for (IFile iFile : derivedResources) {
				IMarker marker = derivedResourceMarkers.findDerivedResourceMarker(iFile, uri);
				if (marker != null)
					marker.delete();
				if (derivedResourceMarkers.findDerivedResourceMarkers(iFile).length == 0) {
					iFile.delete(IResource.KEEP_HISTORY, deleteMonitor.newChild(1));
					context.needRebuild();
				}
			}
		}
	}

	protected boolean isEnabled(final IBuildContext context) {
		return builderPreferenceAccess.isAutoBuildEnabled(context.getBuiltProject());
	}
	
	protected void refreshOutputFolders(IBuildContext ctx, Map<String, OutputConfiguration> outputConfigurations, IProgressMonitor monitor) throws CoreException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, outputConfigurations.size());
		for (OutputConfiguration config : outputConfigurations.values()) {
			SubMonitor child = subMonitor.newChild(1);
			final IProject project = ctx.getBuiltProject();
			IFolder folder = project.getFolder(config.getOutputDirectory());
			folder.refreshLocal(IResource.DEPTH_INFINITE, child);
		}
	}

	protected void cleanOutput(IBuildContext ctx, OutputConfiguration config, IProgressMonitor monitor) throws CoreException {
		final IProject project = ctx.getBuiltProject();
		IFolder folder = project.getFolder(config.getOutputDirectory());
		if (!folder.exists())
			return;
		if (config.isCanClearOutputDirectory()) {
			for (IResource resource : folder.members())
				resource.delete(IResource.KEEP_HISTORY, monitor);
		} else {
			if (config.isCleanUpDerivedResources()) {
				List<IFile> resources = derivedResourceMarkers.findDerivedResources(folder, null);
				for (IFile iFile : resources) {
					iFile.delete(IResource.KEEP_HISTORY, monitor);
				}
			}
		}
	}
	
	protected void handleChangedContents(Delta delta, IBuildContext context, EclipseResourceFileSystemAccess2 fileSystemAccess) throws CoreException {
		if (!resourceServiceProvider.canHandle(delta.getUri()))
			return;
		// TODO: we will run out of memory here if the number of deltas is large enough
		Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		if (shouldGenerate(resource, context)) {
			try {
				generator.doGenerate(resource, fileSystemAccess);
			} catch (RuntimeException e) {
				if (e.getCause() instanceof CoreException) {
					throw (CoreException) e.getCause();
				}
				throw e;
			}
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

	protected Map<String,OutputConfiguration> getOutputConfigurations(IBuildContext context) {
		Set<OutputConfiguration> configurations = outputConfigurationProvider.getOutputConfigurations(context.getBuiltProject());
		return uniqueIndex(configurations, new Function<OutputConfiguration, String>() {
			public String apply(OutputConfiguration from) {
				return from.getName();
			}
		});
	}
	
}
