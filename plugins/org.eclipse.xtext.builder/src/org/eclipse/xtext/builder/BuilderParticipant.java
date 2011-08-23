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
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
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
	
	@Inject
	private OutputConfigurationProvider outputConfigurationProvider;
	
	public void setOutputConfigurationProvider(OutputConfigurationProvider outputConfigurationProvider) {
		this.outputConfigurationProvider = outputConfigurationProvider;
	}

	public void build(final IBuildContext context, IProgressMonitor monitor) throws CoreException {
		EclipseResourceFileSystemAccess2 access = fileSystemAccessProvider.get();
		// TODO improve progress monitor handling
		// we should use a new child of a submonitor for each invocation on the fileSystmeAccess
		// since we want to report proper progress here
		access.setMonitor(monitor);
		final IProject builtProject = context.getBuiltProject();
		access.setProject(builtProject);
		final Map<String, OutputConfiguration> outputConfigurations = getOutputConfigurations(context);
		access.setOutputConfigurations(outputConfigurations);
		if (context.getBuildType() == BuildType.CLEAN || context.getBuildType() == BuildType.RECOVERY) {
			for (OutputConfiguration config : outputConfigurations.values()) {
				cleanOutput(context, config, monitor);
				// TODO I think we should put a 'context.needRebuild();' here, but 
				// org.eclipse.xtext.builder.impl.BuilderParticipantTest.testClean() fails afterwards
			}
			if (context.getBuildType() == BuildType.CLEAN)
				return;
		}
		for (final IResourceDescription.Delta delta : context.getDeltas()) {
			final String uri = delta.getUri().toString();
			final Set<IFile> derivedResources = newLinkedHashSet();
			for (OutputConfiguration config : outputConfigurations.values()) {
				if (config.isCleanUpDerivedResources()) {
					List<IFile> resources = derivedResourceMarkers.findDerivedResources(builtProject.getFolder(config.getOutputDirectory()), getGeneratorIdentifier(), uri);
					derivedResources.addAll(resources);
				}
			}
			access.setPostProcessor(new EclipseResourceFileSystemAccess2.IFileCallback() {
				public boolean beforeFileDeletion(IFile file) {
					context.needRebuild();
					return false; // TODO this looks like a bug to me.
				}
				
				public void afterFileUpdate(IFile file) {
					derivedResources.remove(file);
					context.needRebuild();
				}
				
				public void afterFileCreation(IFile file) {
					try {
						derivedResources.remove(file);
						derivedResourceMarkers.installMarker(file, getGeneratorIdentifier(), uri);
						context.needRebuild();
					} catch (CoreException e) {
						throw new RuntimeException(e);
					}
				}
			});
			if (delta.getNew() != null) {
				handleChangedContents(delta, context, access);
			}
			for (IFile iFile : derivedResources) {
				iFile.delete(IResource.KEEP_HISTORY, monitor);
				context.needRebuild();
			}
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
				List<IFile> resources = derivedResourceMarkers.findDerivedResources(folder, getGeneratorIdentifier(), null);
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
		Set<OutputConfiguration> configurations = outputConfigurationProvider.getOutputConfigurations();
		//TODO check preferences and update accordingly
		
		return uniqueIndex(configurations, new Function<OutputConfiguration, String>() {
			public String apply(OutputConfiguration from) {
				return from.getName();
			}
		});
	}
	
	protected String getGeneratorIdentifier() {
		return generator.getClass().getCanonicalName();
	}

}
