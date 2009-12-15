/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.core.MarkerTypes;
import org.eclipse.xtext.ui.core.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.core.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MarkerUpdaterImpl implements IMarkerUpdater {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
	
	@Inject 
	private MarkerCreator markerCreator; 
	
	@Inject
	private IStorage2UriMapper mapper;

	private final static Logger log = Logger.getLogger(MarkerUpdaterImpl.class);

	public void updateMarker(ResourceSet resourceSet, ImmutableList<Delta> resourceDescriptionDeltas,
			IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, resourceDescriptionDeltas.size());
		for (Delta delta : resourceDescriptionDeltas) {
			if (delta.getNew() != null) {
				Iterable<IStorage> storages = mapper.getStorages(delta.getNew().getURI());
				for (IStorage storage : storages) {
					if (storage instanceof IFile) {
						IFile file = (IFile) storage;
						if (!file.isReadOnly()) {
							Resource resource = resourceSet.getResource(delta.getNew().getURI(), true);
							addMarkers(file, resource, subMonitor.newChild(1));
						}
					}
				}
			}
		}
		subMonitor.done();
	}

	protected void addMarkers(IFile file, Resource resource, final IProgressMonitor monitor) {
		try {
			SubMonitor subMonitor = SubMonitor.convert(monitor, 2);
			IResourceServiceProvider provider = resourceServiceProviderRegistry.getResourceServiceProvider(resource
					.getURI(), null);
			
			List<Issue> list = provider.getResourceValidator().validate(resource, CheckMode.FAST_ONLY,
					getCancelIndicator(subMonitor));
			if (monitor.isCanceled())
				return;
			file.deleteMarkers(MarkerTypes.FAST_VALIDATION, true, 1);
			for (Issue issue : list) {
				markerCreator.createMarker(issue, file, MarkerTypes.FAST_VALIDATION);
			}
			subMonitor.worked(1);
			
			list = provider.getResourceValidator().validate(resource, CheckMode.NORMAL_ONLY,
					getCancelIndicator(monitor));
			subMonitor.worked(1);
			file.deleteMarkers(MarkerTypes.NORMAL_VALIDATION, true, 1);
			if (subMonitor.isCanceled())
				return;
			for (Issue issue : list) {
				markerCreator.createMarker(issue, file, MarkerTypes.NORMAL_VALIDATION);
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	private CancelIndicator getCancelIndicator(final IProgressMonitor monitor) {
		return new CancelIndicator() {
			public boolean isCanceled() {
				return monitor.isCanceled();
			}
		};
	}

}
