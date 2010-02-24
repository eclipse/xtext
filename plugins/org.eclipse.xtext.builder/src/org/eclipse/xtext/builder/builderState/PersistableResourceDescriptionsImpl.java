/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.AbstractResourceDescriptionChangeEventSource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PersistableResourceDescriptionsImpl extends AbstractResourceDescriptionChangeEventSource 
	implements IBuilderState {

	@ImplementedBy(EMFBasedPersister.class)
	public interface PersistedStateProvider {
		Iterable<IResourceDescription> load();
	}
	
	private volatile Map<URI, IResourceDescription> resourceDescriptionMap = Collections.emptyMap();

	@Inject
	private ResourceDescriptionsUpdater updater;

	@Inject
	private IMarkerUpdater markerUpdater;

	@Inject
	private PersistedStateProvider persister;
	
	private boolean isLoaded = false;
	
	public synchronized void load() {
		resourceDescriptionMap = Maps.uniqueIndex(persister.load(), new Function<IResourceDescription, URI>() {
			public URI apply(IResourceDescription from) {
				return from.getURI();
			}
		});
		isLoaded = true;
	}

	public synchronized ImmutableList<IResourceDescription.Delta> update(ResourceSet resourceSet, 
			Set<URI> toBeAddedOrUpdated,
			Set<URI> toBeRemoved, 
			IProgressMonitor monitor) {
		if (!isLoaded)
			load();
		toBeAddedOrUpdated = toBeAddedOrUpdated!=null?toBeAddedOrUpdated:Collections.<URI>emptySet();
		toBeRemoved = toBeRemoved!=null?toBeRemoved:Collections.<URI>emptySet();
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Create resource descriptions", 3);
		subMonitor.subTask("Create resource descriptions");
		try {
			if (subMonitor.isCanceled() || (toBeAddedOrUpdated.isEmpty() && toBeRemoved.isEmpty()))
				return ImmutableList.of();
			resourceSet.eAdapters().add(new ShadowingResourceDescriptions.Adapter(this, toBeAddedOrUpdated, toBeRemoved));
			resourceSet.getLoadOptions().put(AbstractGlobalScopeProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);
			Collection<Delta> deltas = updater.transitiveUpdate(
					this, resourceSet, toBeAddedOrUpdated, toBeRemoved, subMonitor.newChild(1));
			
			Set<Delta> copiedDeltas = Sets.newHashSet();
			Map<URI, IResourceDescription> newMap = Maps.newHashMap(resourceDescriptionMap);
			
			SubMonitor deltaMonitor = SubMonitor.convert(subMonitor.newChild(1), "Update resource descriptions", deltas.size());
			int total = deltas.size();
			int current = 1;
			try {
				for (Delta delta : deltas) {
					if (deltaMonitor.isCanceled())
						return ImmutableList.of();
					deltaMonitor.subTask("Update resource description " + current + " of " + total);
					DefaultResourceDescriptionDelta copiedDelta = new DefaultResourceDescriptionDelta(delta.getOld(),
							createNew(delta, toBeAddedOrUpdated));
					copiedDeltas.add(copiedDelta);
					if (delta.getNew() == null) {
						newMap.remove(copiedDelta.getOld().getURI());
					} else {
						newMap.put(copiedDelta.getNew().getURI(), copiedDelta.getNew());
					}
					current++;
					deltaMonitor.worked(1);
				}
			} finally {
				deltaMonitor.done();
			}
			ResourceDescriptionChangeEvent event = new ResourceDescriptionChangeEvent(copiedDeltas, this);
			if (subMonitor.isCanceled())
				return ImmutableList.of();
			doValidate(resourceSet, event.getDeltas(), subMonitor.newChild(1));
			// update the reference
			resourceDescriptionMap = Collections.unmodifiableMap(newMap);
			notifyListeners(event);
			return event.getDeltas();
		} finally {
			subMonitor.done();
		}
	}

	protected void doValidate(ResourceSet rs, ImmutableList<Delta> deltas, IProgressMonitor monitor) {
		markerUpdater.updateMarker(rs, deltas, monitor);
	}

	private IResourceDescription createNew(Delta delta, Set<URI> toBeAddedOrUpdated) {
		if (delta.getNew() == null)
			return null;
		IResourceDescription toCopy = delta.getNew();
		ResourceDescriptionImpl copied = BuilderStateUtil.create(toCopy);
		return copied;
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		if (!isLoaded)
			load();
		return resourceDescriptionMap.values();
	}

	public IResourceDescription getResourceDescription(URI uri) {
		if (!isLoaded)
			load();
		return resourceDescriptionMap.get(uri);
	}

	public void setPersister(PersistedStateProvider persister) {
		this.persister = persister;
	}

}
