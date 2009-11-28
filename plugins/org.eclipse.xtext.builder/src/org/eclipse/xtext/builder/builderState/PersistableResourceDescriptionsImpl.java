/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import static org.eclipse.xtext.builder.builderState.BuilderStateUtil.*;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.AbstractResourceDescriptionChangeEventSource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;
import org.eclipse.xtext.scoping.namespaces.DefaultGlobalScopeProvider;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PersistableResourceDescriptionsImpl extends AbstractResourceDescriptionChangeEventSource implements IResourceDescriptions {

	private volatile Map<URI, IResourceDescription> resourceDescriptionMap = Collections.emptyMap();
	
	@Inject
	private ResourceDescriptionsUpdater updater;
	
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	
	public void setResourceSetProvider(Provider<ResourceSet> resourceSetProvider) {
		this.resourceSetProvider = resourceSetProvider;
	}
	
	public synchronized ImmutableList<IResourceDescription.Delta> update(Iterable<URI> toBeAddedOrUpdated, Iterable<URI> toBeRemoved) {
		ResourceSet resourceSet = resourceSetProvider.get();
		resourceSet.getLoadOptions().put(DefaultGlobalScopeProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);
		
		Iterable<Delta> deltas = updater.transitiveUpdate(this, resourceSet, toBeAddedOrUpdated, toBeRemoved);
		Map<URI, IResourceDescription> newMap = Maps.newHashMap(resourceDescriptionMap);
		for (Delta delta : deltas) {
			if (delta.getNew()==null) {
				newMap.remove(delta.getOld().getURI());
			} else {
				newMap.put(delta.getNew().getURI(), create(delta.getNew()));
			}
		}
		resourceDescriptionMap = Collections.unmodifiableMap(newMap);
		ResourceDescriptionChangeEvent event = new ResourceDescriptionChangeEvent(deltas, this);
		notifyListeners(event);
		return event.getDeltas();
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return resourceDescriptionMap.values();
	}

	public IResourceDescription getResourceDescription(URI uri) {
		return resourceDescriptionMap.get(uri);
	}
	
}
