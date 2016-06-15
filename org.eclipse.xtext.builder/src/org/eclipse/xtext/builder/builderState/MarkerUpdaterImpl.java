/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.markers.IMarkerContributor;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.validation.IResourceUIValidatorExtension;
import org.eclipse.xtext.ui.validation.MarkerEraser;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.CheckMode;

import com.google.inject.Inject;

/**
 * {@link IMarkerUpdater} that handles {@link CheckMode#NORMAL_AND_FAST} marker for all changed resources.
 * 
 * The implementation delegates to the language specific {@link IResourceUIValidatorExtension validator} if available.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 * @author Dennis Huebner
 * @author Christian Schneider
 */
public class MarkerUpdaterImpl implements IMarkerUpdater {
	
	/** Duplicate of ExternalFoldersManager.EXTERNAL_PROJECT_NAME for avoiding any dependency on that (internal) API. */
	private static final String EXTERNAL_PROJECT_NAME = ".org.eclipse.jdt.core.external.folders";

	public static final Logger LOG = Logger.getLogger(MarkerUpdaterImpl.class);

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Inject
	private IStorage2UriMapper mapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateMarkers(Delta delta, /* @Nullable */ ResourceSet resourceSet, IProgressMonitor monitor) throws OperationCanceledException {
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		processDelta(delta, resourceSet, monitor);
	}

	private void processDelta(Delta delta, /* @Nullable */ ResourceSet resourceSet, IProgressMonitor monitor) throws OperationCanceledException {
		URI uri = delta.getUri();
		IResourceUIValidatorExtension validatorExtension = getResourceUIValidatorExtension(uri);
		IMarkerContributor markerContributor = getMarkerContributor(uri);
		CheckMode normalAndFastMode = CheckMode.NORMAL_AND_FAST;

		for (Pair<IStorage, IProject> pair : mapper.getStorages(uri)) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			if (pair.getFirst() instanceof IFile) {
				IFile file = (IFile) pair.getFirst();
				
				if (EXTERNAL_PROJECT_NAME.equals(file.getProject().getName())) {
					// if the file is found via the source attachment of a classpath entry, which happens
					//  in case of running a test IDE with bundles from the workspace of the development IDE
					//  (the workspace bundles' bin folder is linked to the classpath of bundles in the test IDE),
					// skip the marker processing of that file, as the user can't react on any markers anyway.
					continue;
				}
				
				if (delta.getNew() != null) {
					if (resourceSet == null)
						throw new IllegalArgumentException("resourceSet may not be null for changed resources.");
					
					Resource resource = resourceSet.getResource(uri, true);
					if (validatorExtension != null) {
						validatorExtension.updateValidationMarkers(file, resource, normalAndFastMode, monitor);
					}
					if (markerContributor != null) {
						markerContributor.updateMarkers(file, resource, monitor);
					}
				} else {
					if (validatorExtension != null) {
						validatorExtension.deleteValidationMarkers(file, normalAndFastMode, monitor);
					} else {
						deleteAllValidationMarker(file, normalAndFastMode, monitor);
					}	
					if (markerContributor != null) {
						markerContributor.deleteMarkers(file, monitor);
					} else {
						deleteAllContributedMarkers(file, monitor);
					}
				}
			}
		}
	}

	private void deleteAllValidationMarker(IFile file, CheckMode checkMode, IProgressMonitor monitor) {
		MarkerEraser markerEraser = new MarkerEraser();
		markerEraser.deleteValidationMarkers(file, checkMode, monitor);
	}
	
	private void deleteAllContributedMarkers(IFile file, IProgressMonitor monitor) {
		try {
			file.deleteMarkers(IMarkerContributor.MARKER_TYPE, true, IResource.DEPTH_ZERO);
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	 * Searches for a {@link IResourceUIValidatorExtension} implementation in
	 * {@link org.eclipse.xtext.resource.IResourceServiceProvider.Registry}<br>
	 * 
	 * @return {@link IResourceUIValidatorExtension} for the given {@link URI} or <code>null</code> if not found.
	 * @see org.eclipse.xtext.resource.IResourceServiceProvider.Registry#getResourceServiceProvider(URI)
	 * @see IResourceServiceProvider#get(Class)
	 */
	protected IResourceUIValidatorExtension getResourceUIValidatorExtension(URI uri) {
		IResourceServiceProvider provider = resourceServiceProviderRegistry.getResourceServiceProvider(uri);
		if (provider != null) {
			return provider.get(IResourceUIValidatorExtension.class);
		}
		return null;
	}

	protected IMarkerContributor getMarkerContributor(URI uri) {
		IResourceServiceProvider provider = resourceServiceProviderRegistry.getResourceServiceProvider(uri);
		if (provider != null) {
			return provider.get(IMarkerContributor.class);
		}
		return null;
	}

}
