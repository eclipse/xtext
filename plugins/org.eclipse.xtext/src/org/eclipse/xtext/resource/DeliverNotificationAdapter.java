/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

/**
 * <p>
 * An adapter that is used to decide whether notifications should be delivered to Notifiers.
 * </p>
 * <p>
 * Usage example:
 * <pre>
 * 
 * DeliverNotificationAdapter.DEFAULT.setDeliver(true);
 * 
 * ...
 * 
 * Notifier notifier = ...;
 * Resource resource = ...;
 * 
 * try {
 *    DeliverNotificationAdapter.get(resource).setDeliver(notifier);
 *    // do something with notifier
 * } finally {
 *    DeliverNotificationAdapter.get(resource).resetDeliver(notifier);
 * }
 * 
 * @author thoms - Initial contribution and API
 * @since 2.10
 */
public class DeliverNotificationAdapter extends EContentAdapter {
	private boolean deliver = false;
	private Pair<Notifier, Boolean> memento;
	
	public static DeliverNotificationAdapter DEFAULT = new DeliverNotificationAdapter();
	
	/**
	 * Gets an instance for a Resource. Searches the Resource's and the ResourceSet's adapters for
	 * an instance in their adapters lists. When not found, the {@link #DEFAULT} singleton is returned.
	 * @return The active instance for the Resource. Will not return <code>null</code>.
	 */
	public static DeliverNotificationAdapter get (Resource resource) {
		if (resource != null) {
			for (Adapter adapter : resource.eAdapters()) {
				if (adapter instanceof DeliverNotificationAdapter) {
					return (DeliverNotificationAdapter) adapter;
				}
			}
			return get(resource.getResourceSet());
		} else {
			return DEFAULT;
		}
	}
	public static DeliverNotificationAdapter get (ResourceSet resourceSet) {
		if (resourceSet != null) {
			for (Adapter adapter : resourceSet.eAdapters()) {
				if (adapter instanceof DeliverNotificationAdapter) {
					return (DeliverNotificationAdapter) adapter;
				}
			}
		}
		return DEFAULT;
	}

	/**
	 * Enable notifications.
	 */
	public void enable() {
		this.deliver = true;
	}

	/**
	 * Disable notifications.
	 */
	public void disable() {
		this.deliver = false;
	}
	
	/**
	 * Notification enablement state.
	 */
	public boolean isDeliver() {
		return deliver;
	}

	/**
	 * Calls {@link Notifier#eSetDeliver(boolean)} on the {@link Notifier} with the
	 * current enablement state value. The current state of {@link Notifier#eDeliver()}
	 * is remembered and can be set to the previous state when {@link #resetDeliver(Notifier)}
	 * is called.
	 */
	public void setDeliver (Notifier notifier) {
		memento = Tuples.pair(notifier, notifier.eDeliver());
		notifier.eSetDeliver(isDeliver());
	}
	
	/**
	 * Resets the {@link Notifier} notification delivery state to the value when {@link #setDeliver(Notifier)}
	 * is called. Usually this method will be called in a finally block after {@link #setDeliver(Notifier)} on 
	 * the same <code>Notifier</code>.
	 */
	public void resetDeliver (Notifier notifier) {
		if (memento != null && memento.getFirst()==notifier) {
			notifier.eSetDeliver(memento.getSecond());
		}
	}
}
