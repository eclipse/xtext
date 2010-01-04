/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Event.Listener;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ShadowingResourceDescriptions implements IResourceDescriptions.IContextAware {

	public static class Adapter extends AdapterImpl {

		private IResourceDescriptions toBeShadowed;
		private Set<URI> deletedUris;
		private Set<URI> toBeUpdated;
		private Map<URI, IResourceDescription> resourceDescriptions;
		
		public Adapter(IResourceDescriptions toBeShadowed, Set<URI> toBeUpdated, Set<URI> deletedUris) {
			super();
			this.toBeShadowed = toBeShadowed;
			this.deletedUris = deletedUris;
			this.toBeUpdated = toBeUpdated;
		}
		
		public IResourceDescriptions getToBeShadowed() {
			return toBeShadowed;
		}
		
		public Set<URI> getDeletedUris() {
			return deletedUris;
		}
		
		public Set<URI> getToBeUpdated() {
			return toBeUpdated;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return Adapter.class == type;
		}
		
		public Map<URI, IResourceDescription> getResourceDescriptionsMap() {
			return resourceDescriptions;
		}
		
		public void setResourceDescriptionsMap(Map<URI, IResourceDescription> resourceDescriptions) {
			this.resourceDescriptions = resourceDescriptions;
		}
		
	}
	
	@Inject
	private Provider<ResourceSetBasedResourceDescriptions> resourceSetDescriptionsProvider;
	
	private Map<URI, IResourceDescription> resourceDescriptions;
	
	public void setContext(Notifier ctx) {
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
		if (resourceSet == null)
			throw new NullPointerException();
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(resourceSet.eAdapters(), Adapter.class);
		if (adapter == null)
			throw new IllegalArgumentException("No "+ShadowingResourceDescriptions.Adapter.class.getName()+" found");
		if (adapter.getResourceDescriptionsMap() != null) {
			this.resourceDescriptions = adapter.getResourceDescriptionsMap();
		} else {
			ResourceSetBasedResourceDescriptions resourceSetBasedResourceDescriptions = resourceSetDescriptionsProvider.get();
			resourceSetBasedResourceDescriptions.setContext(resourceSet);
			initialize(resourceSetBasedResourceDescriptions, adapter);
			adapter.setResourceDescriptionsMap(resourceDescriptions);
		}
	}


	public void initialize(IResourceDescriptions shadowing, Adapter adapter) {
		this.resourceDescriptions = Maps.newHashMap();
		for (URI uri : adapter.getToBeUpdated()) {
			if (!resourceDescriptions.containsKey(uri)) {
				IResourceDescription description = shadowing.getResourceDescription(uri);
				if (description != null)
					resourceDescriptions.put(uri, description);
			}
		}
		Iterable<? extends IResourceDescription> descriptions = adapter.getToBeShadowed().getAllResourceDescriptions();
		for (IResourceDescription desc : descriptions) {
			URI uri = desc.getURI();
			if (!adapter.getDeletedUris().contains(uri) && !resourceDescriptions.containsKey(uri)) {
				resourceDescriptions.put(uri, desc);
			}
		}
	}

	
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return resourceDescriptions.values();
	}

	public IResourceDescription getResourceDescription(URI uri) {
		return resourceDescriptions.get(uri);
	}

	public void addListener(Listener listener) {
	}

	public void removeListener(Listener listener) {
	}

}
