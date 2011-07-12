/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.builderState.AbstractBuilderState;
import org.eclipse.xtext.builder.builderState.BuilderStateUtil;
import org.eclipse.xtext.builder.builderState.ResourceDescriptionsData;
import org.eclipse.xtext.builder.impl.BuildData;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @authot Thomas Wolf <thomas.wolf@paranor.ch> - Refactored the build phases and documentation
 */
public class ClusteringBuilderState extends AbstractBuilderState {

	/** Class-wide logger. */
    private static final Logger LOGGER = Logger.getLogger(ClusteringBuilderState.class);
    
	@Inject
	private IResourceServiceProvider.Registry managerRegistry;

	@Inject(optional = true)
	@Named("org.eclipse.xtext.builder.clustering.ClusteringBuilderState.clusterSize")
	private int clusterSize = 20;

	/**
     * Actually do the build.
     * 
     * @param resourceSet
     *            The resource set
     * @param toBeUpdated
     *            The URIs of all the resources that have physically changed
     * @param toBeRemoved
     *            The URIs of all the resources that have been physically deleted
     * @param newMap
     *            A map collecting the new resource descriptions as they are to be persisted. (The new index after the build.)
     *            Initially contains the old resource descriptions.
     * @param monitor
     *            The progress monitor
     * @return A list of deltas describing all changes made by the build.
     */
    @Override
    protected Collection<Delta> doUpdate(BuildData buildData, ResourceDescriptionsData newData, IProgressMonitor monitor) {
        final SubMonitor progress = SubMonitor.convert(monitor, 100);

        
        // Step 1: Clean the set of deleted URIs. If any of them are also added, they're not deleted.
        final Set<URI> toBeDeleted = buildData.getAndRemoveToBeDeleted();

        // Step 2: Create a new state (old state minus the deleted resources). This, by virtue of the flag 
        // NAMED_BUILDER_SCOPE in the resource set's load options
        // and a Guice binding, is the index that is used during the build; i.e., linking during the build will
        // use this. Once the build is completed, the persistable index is reset to the contents of newState by
        // virtue of the newMap, which is maintained in synch with this.
        ResourceSet resourceSet = buildData.getResourceSet();
        final CurrentDescriptions newState = new CurrentDescriptions(resourceSet, newData);

        // Step 3: Create a queue; write new temporary resource descriptions for the added or updated resources so that we can link
        // subsequently; put all the added or updated resources into the queue.
        writeNewResourceDescriptions(buildData, this, newState, progress.newChild(20));

        if (progress.isCanceled()) {
            throw new OperationCanceledException();
        }

        // Step 4: Create a URI set of resources not yet in the delta. This is used for queuing; whenever a resource is
        // queued for processing, its URI is removed from this set. queueAffectedResources will consider only resources
        // in this set as potential candidates.
        for (final URI uri : toBeDeleted) {
        	newData.removeDescription(uri);
        }
        final Set<URI> allRemainingURIs = Sets.newLinkedHashSet(newData.getAllURIs());
        allRemainingURIs.removeAll(buildData.getToBeUpdated());
        for(URI remainingURI: buildData.getAllRemainingURIs()) {
        	allRemainingURIs.remove(remainingURI);
        }
        // TODO: consider to remove any entry from upstream projects and independent projects
        // from the set of remaining uris (template method or service?)
        // this should reduce the number of to-be-checked descriptions significantly
        // for common setups (large number of reasonable sized projects)

        // Our return value. It contains all the deltas resulting from this build.
        final Set<Delta> allDeltas = Sets.newHashSet();
        
        // Step 5: Put all resources depending on a deleted resource into the queue. Also register the deltas in allDeltas.
        if (!toBeDeleted.isEmpty()) {
            for (final URI uri : toBeDeleted) {
                final IResourceDescription oldDescription = this.getResourceDescription(uri);
                if (oldDescription != null) {
                    allDeltas.add(new DefaultResourceDescriptionDelta(oldDescription, null));
                }
            }
        }
        // Add all pending deltas to all deltas (may be scheduled java deltas)
        Collection<Delta> pendingDeltas = buildData.getAndRemovePendingDeltas();
        allDeltas.addAll(pendingDeltas);
        queueAffectedResources(allRemainingURIs, this, newState, allDeltas, buildData, progress.newChild(1));
        
        // Step 6: Iteratively got through the queue. For each resource, create a new resource description and queue all depending
        // resources that are not yet in the delta. Validate resources. Do this in chunks.
        final SubMonitor subProgress = progress.newChild(80);
        CancelIndicator cancelMonitor = new CancelIndicator() {
            public boolean isCanceled() {
                return progress.isCanceled();
            }
        };

        int index = 1;
        Queue<URI> queue = buildData.getURIQueue();
        while (!queue.isEmpty()) {
            subProgress.setWorkRemaining(queue.size() + 2);
            // TODO: How to properly do progress indication with an unknown amount of work? Somehow, the progress bar doesn't
            // advance anymore after this...
            final List<Delta> newDeltas = new ArrayList<Delta>(clusterSize);
            final List<Delta> changedDeltas = new ArrayList<Delta>(clusterSize);
            while (!queue.isEmpty() && newDeltas.size() < clusterSize) {
                final URI changedURI = queue.poll();
                if (subProgress.isCanceled()) {
                    throw new OperationCanceledException();
                }
                subProgress.subTask("Updating resource description " + index + " of " + (index + queue.size()));
                // Load the resource and create a new resource description
                Resource resource = null;
                Delta newDelta = null;
                try {
                    final IResourceDescription.Manager manager = getResourceDescriptionManager(changedURI);
                    if (manager != null) {
                        resource = resourceSet.getResource(changedURI, true);
                        // Resolve links here!
						EcoreUtil2.resolveLazyCrossReferences(resource, cancelMonitor);
                        final IResourceDescription description = manager.getResourceDescription(resource);
                        final IResourceDescription copiedDescription = BuilderStateUtil.create(description);
                        newDelta = manager.createDelta(
                                    this.getResourceDescription(changedURI), copiedDescription);
                    }
                } catch (final WrappedException ex) {
                    if (resourceSet.getURIConverter().exists(changedURI, Collections.emptyMap())) {
                        LOGGER.error("Error loading resource from: " + changedURI.toString(), ex); //$NON-NLS-1$
                    }
                    if (resource != null) {
                        resourceSet.getResources().remove(resource);
                    }
                    final IResourceDescription oldDescription = this.getResourceDescription(changedURI);
                    if (oldDescription != null) {
                        newDelta = new DefaultResourceDescriptionDelta(oldDescription, null);
                    }
                }
                if (newDelta != null) {
                    newDeltas.add(newDelta);
                    if (newDelta.haveEObjectDescriptionsChanged())
                    	changedDeltas.add(newDelta);
                    // Make the new resource description known and update the map.
                    newState.register(newDelta);
                }
                subProgress.worked(1);
                index++;
            }
            queueAffectedResources(allRemainingURIs, this, newState, changedDeltas, buildData, subProgress.newChild(1));
            // Validate now.
            updateMarkers(resourceSet, ImmutableList.<Delta>copyOf(newDeltas), subProgress.newChild(1));
            allDeltas.addAll(newDeltas);
            // Release memory
            resourceSet.getResources().clear();
        }
        return allDeltas;
    }
    
    /**
     * Create new resource descriptions for a set of resources given by their URIs.
     * 
     * @param resourceSet
     *            The resource set
     * @param oldState
     *            The old index
     * @param newState
     *            The new index
     * @param toBeUpdated
     *            URIs of all resources physically changed (initial delta)
     * @param monitor
     *            The progress monitor used for user feedback
     * @return A list of all the URIs of toBeUpdated that could be indeed loaded and for which new description were written.
     */
    protected void writeNewResourceDescriptions(
            BuildData buildData,
            IResourceDescriptions oldState,
            CurrentDescriptions newState,
            final IProgressMonitor monitor) {
        int index = 1;
        Collection<URI> toBeUpdated = buildData.getToBeUpdated();
        ResourceSet resourceSet = buildData.getResourceSet();
        final int n = toBeUpdated.size();
        final SubMonitor subMonitor = SubMonitor.convert(monitor, "Write new resource descriptions", n); // TODO: NLS
        for (final URI uri : toBeUpdated) {
            if (subMonitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            subMonitor.subTask("Writing new resource description " + index + " of " + n); // TODO: NLS
            Resource resource = null;
            try {
                resource = resourceSet.getResource(uri, true);

                final IResourceDescription.Manager manager = getResourceDescriptionManager(uri);
                if (manager != null) {
                    // We don't care here about links, we really just want the exported objects so that we can link in the
                    // next phase.
                    final IResourceDescription description = manager.getResourceDescription(resource);
                    final IResourceDescription copiedDescription = new CopiedResourceDescription(description);
                    // We also don't care what kind of Delta we get here; it's just a temporary transport vehicle. That interface
                    // could do with some clean-up, too, because all we actually want to do is register the new resource
                    // description, not the delta.
                    newState.register(new DefaultResourceDescriptionDelta(oldState.getResourceDescription(uri), copiedDescription));
                    buildData.queueURI(uri);
                }
            } catch (final WrappedException ex) {
                if (resourceSet.getURIConverter().exists(uri, Collections.emptyMap())) {
                    LOGGER.error("Error loading resource from: " + uri.toString(), ex); //$NON-NLS-1$
                }
                if (resource != null) {
                    resourceSet.getResources().remove(resource);
                }
                final IResourceDescription oldDescription = oldState.getResourceDescription(uri);
                if (oldDescription != null) {
                    newState.register(new DefaultResourceDescriptionDelta(oldDescription, null));
                }
                // If we couldn't load it, there's no use trying again: do not add it to the queue
            }

            subMonitor.worked(1);
            index++;
            if (index % clusterSize == 0) {
                resourceSet.getResources().clear();
            }
        }
        resourceSet.getResources().clear(); // Empty the resource set so that the next phase starts afresh.
    }

    /**
     * Put all resources that depend on some changes onto the queue of resources to be processed. 
     * Updates notInDelta by removing all URIs put into the queue.
     * 
     * @param notInDelta
     *            URIs of unchanged and unaffected resources
     * @param oldState
     *            State before the build
     * @param newState
     *            The current state
     * @param deltas
     *            The changes
     * @param queue
     *            The queue of resources yet to be built
     * @param monitor
     *            The progress monitor used for user feedback
     */
    protected void queueAffectedResources(
    		Set<URI> allRemainingURIs, 
    		IResourceDescriptions oldState, 
    		CurrentDescriptions newState,
            Collection<Delta> deltas, 
            BuildData buildData, 
            final IProgressMonitor monitor) {
    	if (deltas.isEmpty()) {
            return;
        }
        final SubMonitor progress = SubMonitor.convert(monitor, allRemainingURIs.size());
        Iterator<URI> iter = allRemainingURIs.iterator();
        while (iter.hasNext()) {
            if (progress.isCanceled()) {
                throw new OperationCanceledException();
            }
            final URI candidateURI = iter.next();
            final IResourceDescription candidateDescription = oldState.getResourceDescription(candidateURI);
            final IResourceDescription.Manager manager = getResourceDescriptionManager(candidateURI);
            if (candidateDescription == null || manager == null) {
                // If there is no description in the old state, there's no need to re-check this over and over.
                iter.remove();
            } else {
                if (manager.isAffected(deltas, candidateDescription, newState)) {
                    buildData.queueURI(candidateURI);
                    iter.remove();
                }
            }
            progress.worked(1);
        }
    }

	protected IResourceDescription.Manager getResourceDescriptionManager(URI uri) {
		IResourceServiceProvider resourceServiceProvider = managerRegistry.getResourceServiceProvider(uri);
		if (resourceServiceProvider == null) {
			return null;
		}
		return resourceServiceProvider.getResourceDescriptionManager();
	}

}
