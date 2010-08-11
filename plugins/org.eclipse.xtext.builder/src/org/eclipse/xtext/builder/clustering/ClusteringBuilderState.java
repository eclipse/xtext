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
			Set<URI> toBeRemoved, final Map<URI, IResourceDescription> newMap, final SubMonitor subMonitor) {
		final Collection<Delta> deltas = collectResources(resourceSet, toBeAddedOrUpdated, toBeRemoved, subMonitor);
		final Set<Delta> allCopiedDeltas = Sets.newHashSet();

		final Iterator<Delta> deltaIterator = deltas.iterator();
		final int nofDeltas = deltas.size();
		int currentDeltaIndex = 1;
		while (deltaIterator.hasNext()) {
		    final ImmutableList<Delta> copiedDeltas = updateAndCopyDescriptions(resourceSet, subMonitor, deltaIterator,
		            newMap, currentDeltaIndex, nofDeltas);
		    if (subMonitor.isCanceled()) {
		        return ImmutableList.of();
		    }
		    currentDeltaIndex += copiedDeltas.size();
		    updateMarkers(resourceSet, copiedDeltas, subMonitor);
		    resourceSet.getResources().clear();
		    allCopiedDeltas.addAll(copiedDeltas);
		    if (subMonitor.isCanceled()) {
		        return ImmutableList.of();
		    }
		}
		return allCopiedDeltas;
	}

    protected Collection<Delta> collectResources(ResourceSet resourceSet, Set<URI> toBeAddedOrUpdated, Set<URI> toBeRemoved,
            SubMonitor subMonitor) {
        resourceSet.getLoadOptions().put(AbstractGlobalScopeProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);
        final Collection<Delta> deltas = transitiveUpdate(resourceSet, toBeAddedOrUpdated, toBeRemoved, subMonitor);
        return deltas;
    }

    protected ImmutableList<Delta> updateAndCopyDescriptions(
            ResourceSet resourceSet, SubMonitor subMonitor,
            Iterator<Delta> deltaIterator,
            Map<URI, IResourceDescription> newMap,
            int firstIndex,
            final int nofDeltas) {
        final SubMonitor deltaMonitor = SubMonitor.convert(subMonitor.newChild(1), "Update resource descriptions", clusterSize);
        final Set<Delta> result = Sets.newHashSet();
        try {
            for (int i = 0; i < clusterSize && deltaIterator.hasNext(); i++) {
                final Delta delta = deltaIterator.next();
                if (deltaMonitor.isCanceled()) {
                    return ImmutableList.of();
                }
                deltaMonitor.subTask("Update resource description " + firstIndex + " of " + nofDeltas);
                IResourceDescription newDescription = null;
                if (delta.getNew() != null) {
                    final Resource resource = resourceSet.getResource(delta.getUri(), true);
                    final IResourceDescription.Manager manager = getResourceDescriptionManager(delta.getUri());
                    newDescription = manager.getResourceDescription(resource);
                }
                final DefaultResourceDescriptionDelta copiedDelta = new DefaultResourceDescriptionDelta(delta.getOld(),
                        copy(newDescription));
                result.add(copiedDelta);
                if (copiedDelta.getNew() == null) {
                    newMap.remove(copiedDelta.getUri());
                } else {
                    newMap.put(copiedDelta.getUri(), copiedDelta.getNew());
                }
                firstIndex++;
                deltaMonitor.worked(1);
            }
            return ImmutableList.copyOf(result);
        } finally {
            deltaMonitor.done();
        }
    }

    protected IResourceDescription.Manager getResourceDescriptionManager(URI uri) {
        final IResourceServiceProvider resourceServiceProvider = managerRegistry.getResourceServiceProvider(uri);
        if (resourceServiceProvider == null) {
            return null;
        }
        return resourceServiceProvider.getResourceDescriptionManager();
    }

    private IResourceDescription copy(IResourceDescription toCopy) {
        if (toCopy == null) {
            return null;
        }
        final ResourceDescriptionImpl copied = BuilderStateUtil.create(toCopy);
        return copied;
    }

}
