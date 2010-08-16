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
    public Collection<IResourceDescription.Delta> transitiveUpdate(IResourceDescriptions oldState, final ResourceSet rs,
            Set<URI> toBeUpdated, Set<URI> toBeDeleted, IProgressMonitor monitor) {
        SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.ClusteringUpdater_0, 100);
        subMonitor.subTask(Messages.ClusteringUpdater_0);

        Set<URI> toBeDeletedAsSet = Sets.newHashSet(toBeDeleted);
        if (!toBeDeletedAsSet.isEmpty()) {
	        for(URI updatedURI: toBeUpdated) {
	        	toBeDeletedAsSet.remove(updatedURI);
	        	if (toBeDeletedAsSet.isEmpty())
	        		break;
	        }
        }
        Map<URI, IResourceDescription.Delta> result = Maps.newHashMap();
        // add deleted
        for (final URI toDelete : toBeDeletedAsSet) {
            IResourceDescription resourceDescription = oldState.getResourceDescription(toDelete);
            if (resourceDescription != null) {
                result.put(toDelete, new DefaultResourceDescriptionDelta(resourceDescription, null));
            }
        }

        int startWith = result.size();
        CurrentDescriptions newState = new CurrentDescriptions(rs, oldState, toBeDeletedAsSet);
        IUniqueURIQueue queue = queueFactory.create(toBeUpdated);
        queueAffectedResourceDescriptions(oldState, newState, result.values(), queue);            
        while (!queue.isEmpty()) {
        	subMonitor.setWorkRemaining(100);
            Map<URI, Delta> clusterDeltas = loadResourceCluster(oldState, rs, queue, toBeDeletedAsSet,
            		subMonitor.newChild(30), result.size() - startWith + 1);
            result.putAll(clusterDeltas);
            for (final Delta delta : clusterDeltas.values()) {
                newState.register(delta);
            }
            queueAffectedResourceDescriptions(oldState, newState, clusterDeltas.values(), queue);
            rs.getResources().clear();
        }
        return result.values();
    }

    public Collection<IResourceDescription.Delta> clean(IResourceDescriptions oldState, Set<URI> toBeDeleted,
            IProgressMonitor monitor) {
        SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.ClusteringUpdater_2, toBeDeleted.size());
        subMonitor.subTask(Messages.ClusteringUpdater_2);
        Set<URI> toBeDeletedAsSet = Sets.newHashSet(toBeDeleted);
        Map<URI, IResourceDescription.Delta> result = Maps.newHashMap();
        for (URI toDelete : toBeDeletedAsSet) {
            IResourceDescription resourceDescription = oldState.getResourceDescription(toDelete);
            if (resourceDescription != null) {
                result.put(toDelete, new DefaultResourceDescriptionDelta(resourceDescription, null));
            }
            subMonitor.worked(1);
        }
        return result.values();
    }

    protected Map<URI, IResourceDescription.Delta> loadResourceCluster(
            IResourceDescriptions oldState,
            ResourceSet resourceSet,
            IUniqueURIQueue queue,
            Collection<URI> ignoredURIs,
            IProgressMonitor monitor,
            int baseIndex) {
        SubMonitor subMonitor = SubMonitor.convert(monitor, clusterSize);
        Map<URI, IResourceDescription.Delta> result = Maps.newHashMap();
        for (int i = 0; i < clusterSize && !queue.isEmpty(); i++) {
            if (subMonitor.isCanceled()) {
                return Collections.emptyMap();
            }
            subMonitor.subTask(Messages.ClusteringUpdater_4 + baseIndex + Messages.ClusteringUpdater_5 + queue.totalSize());
            URI nextURI = queue.remove();
            Resource resource = null;
            try {
            	if (!ignoredURIs.contains(nextURI)) {
            		resource = resourceSet.getResource(nextURI, true);

                    IResourceDescription.Manager manager = getResourceDescriptionManager(nextURI);
                    if (manager != null) {
                        IResourceDescription description = manager.getResourceDescription(resource);
                        IResourceDescription copiedDescription = new CopiedResourceDescription(description);
                        result.put(nextURI, new DefaultResourceDescriptionDelta(
                                oldState.getResourceDescription(nextURI), copiedDescription));
                    }
            	}
            } catch (final WrappedException ex) {
                if (resourceSet.getURIConverter().exists(nextURI, Collections.emptyMap())) {
                    log.error("Error loading resource from: " + nextURI.toString(), ex); //$NON-NLS-1$
                }
                if (resource != null) {
                    resourceSet.getResources().remove(resource);
                }
                IResourceDescription oldDescription = oldState.getResourceDescription(nextURI);
                if (oldDescription != null) {
                    result.put(nextURI, new DefaultResourceDescriptionDelta(oldDescription, null));
                }
            }
            baseIndex++;
            subMonitor.worked(1);
        }
        return result;
    }

    protected IResourceDescription.Manager getResourceDescriptionManager(URI uri) {
        IResourceServiceProvider resourceServiceProvider = managerRegistry.getResourceServiceProvider(uri);
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
        Iterable<IResourceDescription> descriptions = oldState.getAllResourceDescriptions();
        for (IResourceDescription desc : descriptions) {
            IResourceDescription.Manager manager = getResourceDescriptionManager(desc.getURI());
            if (manager != null) {
                if (manager.isAffected(deltas, desc, newState)) {
                    queue.add(desc.getURI());
                }
            }
        }
    }

}