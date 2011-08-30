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
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.CheckMode;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public class MarkerUpdaterImpl implements IMarkerUpdater {
	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Inject
	private IStorage2UriMapper mapper;

	public void updateMarker(ResourceSet resourceSet, ImmutableList<Delta> resourceDescriptionDeltas,
			IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.MarkerUpdaterImpl_ValidateResources,
				resourceDescriptionDeltas.size());
		subMonitor.subTask(Messages.MarkerUpdaterImpl_ValidateResources);
		for (Delta delta : resourceDescriptionDeltas) {
			if (subMonitor.isCanceled())
				throw new OperationCanceledException();
			SubMonitor child = subMonitor.newChild(1);
			if (delta.getNew() != null) {
				URI uri = delta.getNew().getURI();
				Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(uri);
				child.setWorkRemaining(3);
				for (Pair<IStorage, IProject> pair : storages) {
					child.setWorkRemaining(3);
					if (pair.getFirst() instanceof IFile) {
						IResourceUIValidatorExtension resourceUIValidatorExtension = getResourceUIValidatorExtension(uri);
						resourceUIValidatorExtension.updateValidationMarkers((IFile) pair.getFirst(),
								resourceSet.getResource(uri, true), CheckMode.NORMAL_AND_FAST, child.newChild(2));
					} else {
						child.worked(1);
					}
				}
			} else {
				Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(delta.getOld().getURI());
				for (Pair<IStorage, IProject> pair : storages) {
					if (pair.getFirst() instanceof IFile) {
						IResourceUIValidatorExtension resourceUIValidatorExtension = getResourceUIValidatorExtension(delta
								.getOld().getURI());
						resourceUIValidatorExtension.deleteValidationMarkers((IFile) pair.getFirst(),
								CheckMode.NORMAL_AND_FAST, child);
					}
				}
				subMonitor.worked(1);
			}
		}
	}

	protected IResourceUIValidatorExtension getResourceUIValidatorExtension(URI uri) {
		IResourceServiceProvider provider = resourceServiceProviderRegistry.getResourceServiceProvider(uri);
		IResourceUIValidatorExtension resourceUIValidatorExtension = provider.get(IResourceUIValidatorExtension.class);
		return resourceUIValidatorExtension;
	}

}
