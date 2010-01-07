/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractResourceDescriptionChangeEventSource implements IResourceDescription.Event.Source {

	private Collection<IResourceDescription.Event.Listener> listenerList;
	
	protected AbstractResourceDescriptionChangeEventSource() {
		listenerList = new CopyOnWriteArraySet<IResourceDescription.Event.Listener>();
	}
	
	public void addListener(IResourceDescription.Event.Listener listener) {
		listenerList.add(listener);
	}
	
	public void addListeners(Collection<IResourceDescription.Event.Listener> listeners) {
		listenerList.addAll(listeners);
	}

	public void removeListener(IResourceDescription.Event.Listener listener) {
		listenerList.remove(listener);
	}
	
	public void removeListeners(Collection<IResourceDescription.Event.Listener> listeners) {
		listenerList.removeAll(listeners);
	}
	
	protected void notifyListeners(IResourceDescription.Event event) {
		if (event == null)
			throw new IllegalArgumentException("event may not be null");
		for(IResourceDescription.Event.Listener listener: listenerList) {
			listener.descriptionsChanged(event);
		}
	}

}
