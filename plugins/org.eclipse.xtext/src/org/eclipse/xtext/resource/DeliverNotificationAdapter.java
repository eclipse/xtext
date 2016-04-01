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
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.DeliverNotificationAdapter.Provider.SingletonProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.ImplementedBy;

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
public class DeliverNotificationAdapter extends AdapterImpl {
	private boolean deliver = false;
	private ThreadLocal<Pair<Notifier, Boolean>> memento = new ThreadLocal<Pair<Notifier,Boolean>>();
	
	private static DeliverNotificationAdapter DEFAULT = new DeliverNotificationAdapter();

	@ImplementedBy(SingletonProvider.class)
	public static interface Provider {
		/**
		 * Gets an instance for a Notifier.
		 * @param notifier A Notifier. Might be <code>null</code>.
		 * @return The active instance for the Notifier. Must not return <code>null</code>.
		 */
		public DeliverNotificationAdapter get (Notifier notifier);

		/**
		 * Provides the DEFAULT instance
		 * @author thoms - Initial contribution and API
		 */
		public static class SingletonProvider implements Provider {
			@Override
			public DeliverNotificationAdapter get(Notifier notifier) {
				return DEFAULT;
			}
		}
		
		/**
		 * Searches the Resource's and the ResourceSet's adapters for
		 * an instance in their adapters lists. When not found, the {@link #DEFAULT} singleton is returned.
		 */
		public static class HierarchicalProvider implements Provider {
			@Override
			public DeliverNotificationAdapter get(Notifier notifier) {
				DeliverNotificationAdapter adapter = notifier != null ? get(notifier.eAdapters()) : null;
				if (adapter == null) {
					if (notifier instanceof EObject) {
						adapter = get(((EObject)notifier).eResource());
					} else if (notifier instanceof Resource) {
						adapter = get(((Resource)notifier).getResourceSet());
					} else {
						adapter = DEFAULT;
					}
				}
				return DEFAULT;
			}
			private DeliverNotificationAdapter get(EList<Adapter> eAdapters) {
				for (Adapter adapter : eAdapters) {
					if (adapter instanceof DeliverNotificationAdapter) {
						return (DeliverNotificationAdapter) adapter;
					}
				}
				return null;
			}
		}
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
		memento.set(Tuples.pair(notifier, notifier.eDeliver()));
		notifier.eSetDeliver(isDeliver());
	}
	
	/**
	 * Resets the {@link Notifier} notification delivery state to the value when {@link #setDeliver(Notifier)}
	 * is called. Usually this method will be called in a finally block after {@link #setDeliver(Notifier)} on 
	 * the same <code>Notifier</code>.
	 */
	public void resetDeliver (Notifier notifier) {
		if (memento.get() != null && memento.get().getFirst()==notifier) {
			notifier.eSetDeliver(memento.get().getSecond());
		}
	}
}
