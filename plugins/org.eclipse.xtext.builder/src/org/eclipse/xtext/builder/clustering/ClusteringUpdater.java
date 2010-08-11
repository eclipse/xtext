/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.builderState.IResourceDescriptionsUpdater;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;

import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClusteringUpdater implements IResourceDescriptionsUpdater {
    private static final Logger log = Logger.getLogger(ClusteringUpdater.class);

    @Inject
    private IResourceServiceProvider.Registry managerRegistry;
    
    @Inject
    private IUniqueURIQueue.Factory queueFactory;
    
    @Inject(optional=true)
    @Named("org.eclipse.xtext.builder.clustering.ClusteringUpdater.clusterSize")
    private int clusterSize = 20;

    public void setResourceServiceRegistry(IResourceServiceProvider.Registry managerRegistry) {
        this.managerRegistry = managerRegistry;
    }

    /**
     * This method computes the {@link IResourceDescription}s for all affected (i.e. added, updated or transitively
     * affected) resources. It does not change any state in the underlying {@link org.eclipse.xtext.resource.IResourceDescriptions}
     * instance.
     * 
     * @param rs
     *            - The ResourceSet to use for reloading the to be updated resources
     * @param toBeUpdated
     *            - the URIs which have to be reloaded
     * @param toBeDeleted
     *            - the URIs which are about to be deleted
     * @return returns an iterable of fresh {@link IResourceDescription} for all resources, which are affected by the
     *         change (i.e. the to BeUpdated and toBeDeleted resources)
     */
    public Collection<IResourceDescription.Delta> transitiveUpdate(final IResourceDescriptions oldState, final ResourceSet rs,
            Set<URI> toBeUpdated, Set<URI> toBeDeleted, IProgressMonitor monitor) {
        final SubMonitor subMonitor = SubMonitor.convert(monitor, "Find affected resources", 2);
        subMonitor.subTask("Find affected resources");
        try {
            final Set<URI> toBeDeletedAsSet = Sets.newHashSet(toBeDeleted);
            toBeDeletedAsSet.removeAll(Collections2.forIterable(toBeUpdated));
            final Map<URI, IResourceDescription.Delta> result = Maps.newHashMap();
            // add deleted
            for (final URI toDelete : toBeDeletedAsSet) {
                final IResourceDescription resourceDescription = oldState.getResourceDescription(toDelete);
                if (resourceDescription != null) {
                    result.put(toDelete, new DefaultResourceDescriptionDelta(resourceDescription, null));
                }
            }

            final CurrentDescriptions newState = new CurrentDescriptions(rs, oldState, toBeDeletedAsSet);
            final IUniqueURIQueue queue = queueFactory.create(toBeUpdated);
            queueAffectedResourceDescriptions(oldState, newState, result.values(), queue);            
            while (!queue.isEmpty()) {
                final Map<URI, Delta> clusterDeltas = loadResourceCluster(oldState, rs, queue, toBeDeletedAsSet,
                		subMonitor.newChild(1), result.size() + 1);
                result.putAll(clusterDeltas);
                for (final Delta delta : clusterDeltas.values()) {
                    newState.register(delta);
                }
                queueAffectedResourceDescriptions(oldState, newState, clusterDeltas.values(), queue);

                rs.getResources().clear();
            }
            return result.values();
        } finally {
            subMonitor.done();
        }
    }

    public Collection<IResourceDescription.Delta> clean(IResourceDescriptions oldState, Set<URI> toBeDeleted,
            IProgressMonitor monitor) {
        final SubMonitor subMonitor = SubMonitor.convert(monitor, "Clean resources", 2);
        subMonitor.subTask("Clean resources");
        try {
            final Set<URI> toBeDeletedAsSet = Sets.newHashSet(toBeDeleted);
            final Map<URI, IResourceDescription.Delta> result = Maps.newHashMap();
            for (final URI toDelete : toBeDeletedAsSet) {
                final IResourceDescription resourceDescription = oldState.getResourceDescription(toDelete);
                if (resourceDescription != null) {
                    result.put(toDelete, new DefaultResourceDescriptionDelta(resourceDescription, null));
                }
            }
            return result.values();
        } finally {
            subMonitor.done();
        }
    }

    protected Map<URI, IResourceDescription.Delta> loadResourceCluster(
            IResourceDescriptions oldState,
            final ResourceSet set,
            IUniqueURIQueue queue,
            Set<URI> ignoredURIs,
            IProgressMonitor monitor,
            int baseIndex) {
        final SubMonitor subMonitor = SubMonitor.convert(monitor, clusterSize);
        try {
            final Map<URI, IResourceDescription.Delta> result = Maps.newHashMap();
            for (int i = 0; i < clusterSize && !queue.isEmpty(); i++) {
                if (subMonitor.isCanceled()) {
                    return Collections.emptyMap();
                }
                subMonitor.subTask("Loading affected resource " + baseIndex);
                final URI uri = queue.get();
                Resource resource = null;
                try {
                	if (!ignoredURIs.contains(uri)) {
                		resource = set.getResource(uri, true);

	                    final IResourceDescription.Manager manager = getResourceDescriptionManager(uri);
	                    if (manager != null) {
	                        final IResourceDescription description = manager.getResourceDescription(resource);
	                        final IResourceDescription copiedDescription = new CopiedResourceDescription(description);
	                        result.put(uri, new DefaultResourceDescriptionDelta(
	                                oldState.getResourceDescription(uri), copiedDescription));
	                    }
                	}
                } catch (final WrappedException ex) {
                    if (set.getURIConverter().exists(uri, Collections.emptyMap())) {
                        log.error("Error loading resource from: " + uri.toString(), ex);
                    }
                    if (resource != null) {
                        set.getResources().remove(resource);
                    }
                    final IResourceDescription oldDescription = oldState.getResourceDescription(uri);
                    if (oldDescription != null) {
                        result.put(uri, new DefaultResourceDescriptionDelta(oldDescription, null));
                    }
                }
                baseIndex++;
                subMonitor.worked(1);
            }
            return result;
        } finally {
            subMonitor.done();
        }

    }

    protected IResourceDescription.Manager getResourceDescriptionManager(URI uri) {
        final IResourceServiceProvider resourceServiceProvider = managerRegistry.getResourceServiceProvider(uri);
        if (resourceServiceProvider == null) {
            return null;
        }
        return resourceServiceProvider.getResourceDescriptionManager();
    }

    protected void queueAffectedResourceDescriptions(
            IResourceDescriptions oldState,
            CurrentDescriptions newState,
            Collection<IResourceDescription.Delta> deltas,
            IUniqueURIQueue queue) throws IllegalArgumentException {
        final Iterable<? extends IResourceDescription> descriptions = oldState.getAllResourceDescriptions();
        for (final IResourceDescription desc : descriptions) {
            final IResourceDescription.Manager manager = getResourceDescriptionManager(desc.getURI());
            if (manager != null) {
                if (manager.isAffected(deltas, desc, newState)) {
                    queue.add(desc.getURI());
                }
            }
        }
    }

}