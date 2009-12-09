/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription.Event.Listener;

import com.google.common.collect.Iterables;

/**
 * Represents an observable set of {@link IResourceDescription}
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IResourceDescriptions extends IResourceDescription.Event.Source {

	Iterable<IResourceDescription> getAllResourceDescriptions();

	IResourceDescription getResourceDescription(URI uri);

	/**
	 * A context aware instance {@link IResourceDescriptions}.
	 * Needs to be configured with the current context before used.
	 * 
	 * @author Sven Efftinge - Initial contribution and API
	 */
	interface IContextAware extends IResourceDescriptions {
		
		void setContext(Notifier ctx);
	}
	
	class NullImpl implements IResourceDescriptions {

		public Iterable<IResourceDescription> getAllResourceDescriptions() {
			return Iterables.emptyIterable();
		}

		public IResourceDescription getResourceDescription(URI uri) {
			return null;
		}

		public void addListener(Listener listener) {
			// ignore
		}

		public void removeListener(Listener listener) {
			// ignore
		}
		
	}
}
