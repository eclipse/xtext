/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.notification;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.core.editor.IDirtyResource;
import org.eclipse.xtext.ui.core.editor.IDirtyStateManager;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StateChangeEventBroker implements IStateChangeEventBroker, IDirtyStateManager.IDirtyStateListener{

	private ListenerList listeners;

	public StateChangeEventBroker(IDirtyStateManager instance) {
		listeners = new ListenerList();
		registerAtDirtyStateManager(instance);
	}

	public void registerAtDirtyStateManager(IDirtyStateManager manager) {
		manager.addListener(this);
	}
	
	public void addListener(IStateChangeEventListener listener) {
		listeners.add(listener);
	}

	public void removeListener(IStateChangeEventListener listener) {
		listeners.remove(listener);
	}
	
	protected void notifyListeners(ImmutableList<URI> uris) {
		Object[] listeners = this.listeners.getListeners();
		for(Object listener: listeners) {
			IStateChangeEventListener stateChangeListener = (IStateChangeEventListener) listener;
			stateChangeListener.onStateChanged(this, uris);
		}
	}

	public void dirtyStateChanged(IDirtyStateManager sender, ImmutableCollection<IDirtyResource> changedResources) {
		Iterable<URI> tranformed = Iterables.transform(changedResources, new Function<IDirtyResource, URI>() {
			public URI apply(IDirtyResource from) {
				return from.getURI();
			}
		});
		ImmutableList<URI> uris = ImmutableList.copyOf(tranformed);
		notifyListeners(uris);
	}

}
