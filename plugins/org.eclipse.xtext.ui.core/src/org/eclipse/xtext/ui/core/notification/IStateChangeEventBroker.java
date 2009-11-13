/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.notification;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.core.editor.IDirtyStateManager;

import com.google.common.collect.ImmutableCollection;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IStateChangeEventBroker {

	IStateChangeEventBroker INSTANCE = new StateChangeEventBroker(IDirtyStateManager.INSTANCE);
	
	Provider<IStateChangeEventBroker> PROVIDER = new Provider<IStateChangeEventBroker>() {
		public IStateChangeEventBroker get() {
			return INSTANCE;
		}
	};
	
	interface IStateChangeEventListener {
		void onStateChanged(IStateChangeEventBroker sender, ImmutableCollection<URI> affectedURIs);
	}
	
	void addListener(IStateChangeEventListener listener);
	
	void removeListener(IStateChangeEventListener listener);
	
}
