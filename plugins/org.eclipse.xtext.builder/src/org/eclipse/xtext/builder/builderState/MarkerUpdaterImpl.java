/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.validation.IResourceUIValidatorExtension;
import org.eclipse.xtext.ui.validation.MarkerEraser;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.CheckMode;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * {@link IMarkerUpdater} that handles {@link CheckMode#NORMAL_AND_FAST} marker for all changed resources.<br>
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 * @author Dennis Huebner
 */
public class MarkerUpdaterImpl implements IMarkerUpdater {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Inject
	private IStorage2UriMapper mapper;

	/**
	 * {@inheritDoc}
	 */
	public void updateMarker(ResourceSet resourceSet, ImmutableList<Delta> resourceDescriptionDeltas,
			IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.MarkerUpdaterImpl_ValidateResources,
				resourceDescriptionDeltas.size());
		subMonitor.subTask(Messages.MarkerUpdaterImpl_ValidateResources);

		for (Delta delta : resourceDescriptionDeltas) {
			if (subMonitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			processDelta(delta, resourceSet, subMonitor.newChild(1));

		}
	}

	private void processDelta(Delta delta, ResourceSet resourceSet, SubMonitor childMonitor) {
		URI uri = delta.getUri();
		IResourceUIValidatorExtension validatorExtension = getResourceUIValidatorExtension(uri);

		for (Pair<IStorage, IProject> pair : mapper.getStorages(uri)) {
			if (pair.getFirst() instanceof IFile) {
				IFile iFile = (IFile) pair.getFirst();
				CheckMode normalAndFastMode = CheckMode.NORMAL_AND_FAST;
				if (validatorExtension != null) {
					if (delta.getNew() != null) {
						validatorExtension.updateValidationMarkers(iFile, resourceSet.getResource(uri, true),
								normalAndFastMode, childMonitor);
					} else {
						validatorExtension.deleteValidationMarkers(iFile, normalAndFastMode, childMonitor);
					}
				} else {
					// Clean up orphaned marker (no IResourceUIValidatorExtension registered)
					fallBackDeleteMarker(iFile, normalAndFastMode, childMonitor);
				}
			}
		}
	}

	private void fallBackDeleteMarker(IFile iFile, CheckMode checkMode, IProgressMonitor monitor) {
		MarkerEraser markerEraser = new MarkerEraser();
		markerEraser.deleteValidationMarkers(iFile, checkMode, monitor);
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
		IResourceUIValidatorExtension uiValidatorExtension = null;
		if (provider != null) {
			uiValidatorExtension = provider.get(IResourceUIValidatorExtension.class);
		}
		return uiValidatorExtension;
	}

}
