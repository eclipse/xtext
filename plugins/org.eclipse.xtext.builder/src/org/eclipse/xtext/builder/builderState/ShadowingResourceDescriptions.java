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

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Event.Listener;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.ui.core.resource.IStorageAwareResourceDescription;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ShadowingResourceDescriptions implements IResourceDescriptions, IResourceDescriptions.IContextAware {

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	protected static class StorageAwareResourceDescription implements IStorageAwareResourceDescription {

		private IResourceDescription delegate;
		private IStorage storage;
		
		public StorageAwareResourceDescription(IStorage storage, IResourceDescription delegate) {
			super();
			this.storage = storage;
			this.delegate = delegate;
		}
		public Iterable<IEObjectDescription> getExportedObjects() {
			return delegate.getExportedObjects();
		}
		public Iterable<IEObjectDescription> getExportedObjects(EClass clazz, String name) {
			return delegate.getExportedObjects(clazz, name);
		}
		public Iterable<IEObjectDescription> getExportedObjects(EClass clazz) {
			return delegate.getExportedObjects(clazz);
		}
		public Iterable<IEObjectDescription> getExportedObjectsForEObject(EObject object) {
			return delegate.getExportedObjectsForEObject(object);
		}
		public Iterable<String> getImportedNames() {
			return delegate.getImportedNames();
		}
		public URI getURI() {
			return delegate.getURI();
		}
		public Iterable<IReferenceDescription> getReferenceDescriptions() {
			return delegate.getReferenceDescriptions();
		}
		public IStorage getStorage() {
			return storage;
		}
	}

	public static class Adapter extends AdapterImpl {

		private IResourceDescriptions toBeShadowed;
		private Set<URI> deletedUris;
		private Map<URI, IStorage> toBeUpdated;

		public Adapter(IResourceDescriptions toBeShadowed, Map<URI,IStorage> toBeUpdated, Set<URI> deletedUris) {
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
		
		public Map<URI, IStorage> getToBeUpdated() {
			return toBeUpdated;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return Adapter.class == type;
		}
	}
	
	@Inject
	private Provider<ResourceSetBasedResourceDescriptions> resourceSetDescriptionsProvider;
	
	private Map<URI, IResourceDescription> resourceDescriptions;

	public void setContext(Notifier ctx) {
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
		ResourceSetBasedResourceDescriptions resourceSetBasedResourceDescriptions = resourceSetDescriptionsProvider.get();
		resourceSetBasedResourceDescriptions.setContext(resourceSet);
		if (resourceSet == null)
			throw new NullPointerException();
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(resourceSet.eAdapters(),
				Adapter.class);
		if (adapter == null)
			throw new IllegalArgumentException("No "+ShadowingResourceDescriptions.Adapter.class.getName()+" found");
		
		initialize(resourceSetBasedResourceDescriptions, adapter);
	}


	public void initialize(IResourceDescriptions shadowing, Adapter adapter) {
		this.resourceDescriptions = Maps.newHashMap();
		for (Map.Entry<URI,IStorage> toBeUpdated : adapter.getToBeUpdated().entrySet()) {
			URI uri = toBeUpdated.getKey();
			if (!adapter.getDeletedUris().contains(uri) && !resourceDescriptions.containsKey(uri)) {
				IResourceDescription description = shadowing.getResourceDescription(uri);
				resourceDescriptions.put(uri, new StorageAwareResourceDescription(toBeUpdated.getValue(),description));
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
