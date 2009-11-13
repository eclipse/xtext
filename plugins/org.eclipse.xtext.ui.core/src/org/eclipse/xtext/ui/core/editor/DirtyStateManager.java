/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.concurrent.ConcurrentMap;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.util.URI;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
// TODO: batch events, fulfill contract as defined in documentation of IDirtyStateManager
public class DirtyStateManager implements IDirtyStateManager {

	private ConcurrentMap<URI, IDirtyResource> managedResources;
	
	private ListenerList listeners;
	
	public DirtyStateManager() {
		managedResources = Maps.newConcurrentHashMap();
		listeners = new ListenerList();
	}
	
	public void announceDirtyStateChanged(IDirtyResource dirtyResource) {
		managedResources.put(dirtyResource.getURI(), dirtyResource);
		notifyListeners(dirtyResource);
	}

	public void discardDirtyState(IDirtyResource dirtyResource) {
		if (managedResources.remove(dirtyResource.getURI(), dirtyResource)) {
			notifyListeners(dirtyResource);
		}
	}

	protected void notifyListeners(IDirtyResource dirtyResource) {
		Object[] notifyUs = listeners.getListeners();
		ImmutableList<IDirtyResource> changedResources = ImmutableList.of(dirtyResource);
		for(Object notifyMe: notifyUs) {
			IDirtyStateListener listener = (IDirtyStateListener) notifyMe;
			listener.dirtyStateChanged(this, changedResources);
		}
	}

	public boolean manageDirtyState(IDirtyResource dirtyResource) {
		return managedResources.putIfAbsent(dirtyResource.getURI(), dirtyResource) == null;
	}
	
	public IDirtyResource getDirtyResource(URI uri) {
		return managedResources.get(uri);
	}

	public void addListener(IDirtyStateListener listener) {
		listeners.add(listener);
	}

	public void removeListener(IDirtyStateListener listener) {
		listeners.remove(listener);
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
