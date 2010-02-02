/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.AbstractResourceDescriptionChangeEventSource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
// TODO: batch events according to the contract of IDirtyStateManager
public class DirtyStateManager extends AbstractResourceDescriptionChangeEventSource implements IDirtyStateManager {

	protected static class Event extends ResourceDescriptionChangeEvent {

		public Event(Collection<Delta> delta, Source sender) {
			super(delta, sender);
		}

		@Override
		public IDirtyStateManager getSender() {
			return (IDirtyStateManager) super.getSender();
		}

	}
	
	private ConcurrentMap<URI, IDirtyResource> managedResources;
	
	public DirtyStateManager() {
		managedResources = Maps.newConcurrentHashMap();
	}
	
	public void announceDirtyStateChanged(IDirtyResource dirtyResource) {
		managedResources.put(dirtyResource.getURI(), dirtyResource);
		notifyListeners(dirtyResource, true);
	}

	public void discardDirtyState(IDirtyResource dirtyResource) {
		if (managedResources.remove(dirtyResource.getURI(), dirtyResource)) {
			notifyListeners(dirtyResource, false);
		}
	}

	protected void notifyListeners(final IDirtyResource dirtyResource, boolean managed) {
		if (managed) {
			IResourceDescription.Delta delta = new IResourceDescription.Delta() {
				public boolean hasChanges() {
					return true;
				}
				
				public IResourceDescription getOld() {
					return null;
				}
				
				public IResourceDescription getNew() {
					return dirtyResource.getDescription();
				}

				public URI getUri() {
					return dirtyResource.getURI();
				}
			};
			notifyListeners(new Event(Collections.singletonList(delta), this));
		} else {
			IResourceDescription.Delta delta = new IResourceDescription.Delta() {
				public boolean hasChanges() {
					return true;
				}
				
				public IResourceDescription getOld() {
					return dirtyResource.getDescription();
				}
				
				public IResourceDescription getNew() {
					return null;
				}
				public URI getUri() {
					return dirtyResource.getURI();
				}
			};
			notifyListeners(new Event(Collections.singletonList(delta), this));
		}
	}

	public boolean manageDirtyState(IDirtyResource dirtyResource) {
		IDirtyResource prevValue = managedResources.putIfAbsent(dirtyResource.getURI(), dirtyResource);
		return prevValue == null || prevValue == dirtyResource;
	}
	
	public IDirtyResource getDirtyResource(URI uri) {
		return managedResources.get(uri);
	}
	
	public IResourceDescription getDirtyResourceDescription(URI uri) {
		IDirtyResource dirtyResource = getDirtyResource(uri);
		if (dirtyResource != null)
			return dirtyResource.getDescription();
		return null;
	}

	public String getContent(URI uri) {
		IDirtyResource dirtyResource = managedResources.get(uri);
		if (dirtyResource != null)
			return dirtyResource.getContents();
		return null;
	}

	public boolean hasContent(URI uri) {
		return managedResources.containsKey(uri);
	}

}
