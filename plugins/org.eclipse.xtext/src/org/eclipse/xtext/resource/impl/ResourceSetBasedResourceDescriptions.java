/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Event.Listener;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ISelectable;

import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 * @author Moritz Eysholdt
 */
public class ResourceSetBasedResourceDescriptions extends AbstractCompoundSelectable implements
		IResourceDescriptions.IContextAware, IResourceDescription.Event.Source {

	protected class DeltaImpl implements IResourceDescription.Delta {

		protected URI uri;
		protected IResourceDescription desc;

		public DeltaImpl(IResourceDescription desc) {
			this(desc.getURI(), desc);
		}

		public DeltaImpl(URI uri, IResourceDescription desc) {
			super();
			this.uri = uri;
			this.desc = desc;
		}

		public URI getUri() {
			return uri;
		}

		public IResourceDescription getOld() {
			return null;
		}

		public IResourceDescription getNew() {
			return desc;
		}

		public boolean haveEObjectDescriptionsChanged() {
			return false;
		}
	}

	protected class ResourceEventBroker extends AdapterImpl {

		public ResourceSetBasedResourceDescriptions getOwner() {
			return ResourceSetBasedResourceDescriptions.this;
		}

		@Override
		public void notifyChanged(Notification msg) {
			int featureID = msg.getFeatureID(Resource.class);
			if (featureID != Resource.RESOURCE__IS_LOADED)
				return;
			switch (msg.getEventType()) {
				case Notification.SET:
					boolean loaded = msg.getNewBooleanValue();
					if (loaded) {
						IResourceDescription desc = getResourceDescription(((Resource) msg.getNotifier()).getURI());
						if (desc != null)
							fire(new DeltaImpl(desc));
					} else
						fire(new DeltaImpl(((Resource) msg.getNotifier()).getURI(), null));
					break;
			}

		}
	}

	protected class ResourceSetEventBroker extends AdapterImpl {

		public ResourceSetBasedResourceDescriptions getOwner() {
			return ResourceSetBasedResourceDescriptions.this;
		}

		@Override
		public void notifyChanged(final Notification msg) {
			int featureID = msg.getFeatureID(ResourceSet.class);
			if (featureID != ResourceSet.RESOURCE_SET__RESOURCES)
				return;
			switch (msg.getEventType()) {
				case Notification.ADD:
					Resource resource = (Resource) msg.getNewValue();
					if (resource.isLoaded()) {
						IResourceDescription desc = getResourceDescription(((Resource) msg.getNewValue()).getURI());
						if (desc != null)
							fire(new DeltaImpl(desc));
					}
					addResourceListener(resource);
					break;
				case Notification.REMOVE:
					Resource resource2 = (Resource) msg.getOldValue();
					fire(new DeltaImpl(resource2.getURI(), null));
					removeResourceListener(resource2);
					break;
			}
			super.notifyChanged(msg);
		}

	}

	private ResourceSet resourceSet;

	@Inject
	private IResourceServiceProvider.Registry registry;

	private Collection<IResourceDescription.Event.Listener> listenerList;

	public ResourceSetBasedResourceDescriptions() {
		this.listenerList = new CopyOnWriteArraySet<IResourceDescription.Event.Listener>();
	}

	protected void fire(final IResourceDescription.Delta delta) {
		fire(new IResourceDescription.Event() {

			public ImmutableList<Delta> getDeltas() {
				return ImmutableList.of(delta);
			}

			public Source getSender() {
				return ResourceSetBasedResourceDescriptions.this;
			}
		});
	}

	protected void fire(IResourceDescription.Event event) {
		for (IResourceDescription.Event.Listener lister : listenerList)
			lister.descriptionsChanged(event);
	}

	public void setRegistry(IResourceServiceProvider.Registry registry) {
		this.registry = registry;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Iterables.filter(new Iterable<IResourceDescription>() {
			public Iterator<IResourceDescription> iterator() {
				return new AbstractIterator<IResourceDescription>() {
					int index = 0;
					List<Resource> resources = resourceSet.getResources();

					@Override
					protected IResourceDescription computeNext() {
						if (resources.size() <= index)
							return endOfData();
						Resource resource = resources.get(index);
						index++;
						return getResourceDescription(resource.getURI());
					}
				};
			}
		}, Predicates.notNull());

	}

	@Override
	protected Iterable<? extends ISelectable> getSelectables() {
		return getAllResourceDescriptions();
	}

	@Override
	public boolean isEmpty() {
		return resourceSet.getResources().isEmpty();
	}

	/**
	 * @since 2.1
	 */
	protected boolean hasDescription(URI uri) {
		Resource resource = resourceSet.getResource(uri, false);
		return resource != null;
	}

	public IResourceDescription getResourceDescription(URI uri) {
		Resource resource = resourceSet.getResource(uri, false);
		if (resource == null)
			return null;
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(uri);
		if (resourceServiceProvider == null)
			return null;
		Manager manager = resourceServiceProvider.getResourceDescriptionManager();
		if (manager == null)
			return null;
		return manager.getResourceDescription(resource);
	}

	protected void addResourceSetListener(ResourceSet rs) {
		rs.eAdapters().add(new ResourceSetEventBroker());
		for (Resource r : rs.getResources())
			addResourceListener(r);
	}

	protected void addResourceListener(Resource res) {
		res.eAdapters().add(new ResourceEventBroker());
	}

	protected void removeResourceSetListener(ResourceSet rs) {
		if (rs != null) {
			Iterator<Adapter> iterator = rs.eAdapters().iterator();
			while (iterator.hasNext()) {
				Adapter next = iterator.next();
				if (next instanceof ResourceSetEventBroker && ((ResourceSetEventBroker) next).getOwner() == this)
					iterator.remove();
			}
			for (Resource r : rs.getResources())
				removeResourceListener(r);
		}
	}

	protected void removeResourceListener(Resource res) {
		if (res != null) {
			Iterator<Adapter> iterator = res.eAdapters().iterator();
			while (iterator.hasNext()) {
				Adapter next = iterator.next();
				if (next instanceof ResourceEventBroker && ((ResourceEventBroker) next).getOwner() == this)
					iterator.remove();
			}
		}
	}

	public void setContext(Notifier ctx) {
		removeResourceSetListener(this.resourceSet);
		this.resourceSet = EcoreUtil2.getResourceSet(ctx);
		addResourceSetListener(this.resourceSet);
	}

	/**
	 * @since 2.3
	 */
	public void addListener(Listener listener) {
		listenerList.add(listener);
	}

	/**
	 * @since 2.3
	 */
	public void removeListener(Listener listener) {
		listenerList.remove(listener);
	}

}
