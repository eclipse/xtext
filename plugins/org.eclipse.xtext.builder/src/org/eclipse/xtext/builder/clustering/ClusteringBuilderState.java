/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.builderState.AbstractBuilderState;
import org.eclipse.xtext.builder.builderState.BuilderStateUtil;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClusteringBuilderState extends AbstractBuilderState {

    @Inject
    private IResourceServiceProvider.Registry managerRegistry;

    @Inject(optional=true)
    @Named("org.eclipse.xtext.builder.clustering.ClusteringBuilderState.clusterSize")
    private int clusterSize = 20;

	@Override
	protected Collection<Delta> doUpdate(ResourceSet resourceSet, Set<URI> toBeAddedOrUpdated,
			Set<URI> toBeRemoved, final Map<URI, IResourceDescription> newMap, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		
		Collection<Delta> deltas = collectResources(resourceSet, toBeAddedOrUpdated, toBeRemoved, progress.newChild(20));
		Set<Delta> allCopiedDeltas = Sets.newHashSet();

		Iterator<Delta> deltaIterator = deltas.iterator();
		int noOfDeltas = deltas.size();
		int currentDeltaIndex = 1;
		while (deltaIterator.hasNext()) {
			progress.setWorkRemaining(2 * (noOfDeltas - currentDeltaIndex));
		    ImmutableList<Delta> copiedDeltas = updateAndCopyDescriptions(resourceSet, deltaIterator, newMap,
		            currentDeltaIndex, noOfDeltas, progress.newChild(clusterSize));
		    if (monitor.isCanceled()) {
		        return ImmutableList.of();
		    }
		    currentDeltaIndex += copiedDeltas.size();
		    updateMarkers(resourceSet, copiedDeltas, progress.newChild(copiedDeltas.size()));
		    resourceSet.getResources().clear();
		    allCopiedDeltas.addAll(copiedDeltas);
		    if (monitor.isCanceled()) {
		        return ImmutableList.of();
		    }
		}
		return allCopiedDeltas;
	}

    protected Collection<Delta> collectResources(ResourceSet resourceSet, Set<URI> toBeAddedOrUpdated, Set<URI> toBeRemoved,
    		IProgressMonitor monitor) {
    	SubMonitor progress = SubMonitor.convert(monitor, 1);
        resourceSet.getLoadOptions().put(AbstractGlobalScopeProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);
        Collection<Delta> result = transitiveUpdate(resourceSet, toBeAddedOrUpdated, toBeRemoved, progress.newChild(1));
        return result;
    }

    protected ImmutableList<Delta> updateAndCopyDescriptions(
            ResourceSet resourceSet, Iterator<Delta> deltaIterator,
            Map<URI, IResourceDescription> newMap,
            int firstIndex,
            int noOfDeltas,
            IProgressMonitor monitor) {
        SubMonitor progress = SubMonitor.convert(monitor, "Update resource descriptions", clusterSize);
        Set<Delta> result = Sets.newHashSet();
        for (int i = 0; i < clusterSize && deltaIterator.hasNext(); i++) {
            Delta delta = deltaIterator.next();
            if (progress.isCanceled()) {
                return ImmutableList.of();
            }
            progress.subTask("Update resource description " + firstIndex + " of " + noOfDeltas);
            IResourceDescription newDescription = null;
            if (delta.getNew() != null) {
                Resource resource = resourceSet.getResource(delta.getUri(), true);
                IResourceDescription.Manager manager = getResourceDescriptionManager(delta.getUri());
                newDescription = manager.getResourceDescription(resource);
            }
            DefaultResourceDescriptionDelta copiedDelta = new DefaultResourceDescriptionDelta(delta.getOld(),
                    copy(newDescription));
            result.add(copiedDelta);
            if (copiedDelta.getNew() == null) {
                newMap.remove(copiedDelta.getUri());
            } else {
                newMap.put(copiedDelta.getUri(), copiedDelta.getNew());
            }
            firstIndex++;
            progress.worked(1);
        }
        return ImmutableList.copyOf(result);
    }

    protected IResourceDescription.Manager getResourceDescriptionManager(URI uri) {
        IResourceServiceProvider resourceServiceProvider = managerRegistry.getResourceServiceProvider(uri);
        if (resourceServiceProvider == null) {
            return null;
        }
        return resourceServiceProvider.getResourceDescriptionManager();
    }

    private IResourceDescription copy(IResourceDescription toCopy) {
        if (toCopy == null) {
            return null;
        }
        ResourceDescriptionImpl result = BuilderStateUtil.create(toCopy);
        return result;
    }

}
